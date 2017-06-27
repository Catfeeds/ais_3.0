package com.digihealth.anesthesia.evt.service;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.digihealth.anesthesia.basedata.config.OperationState;
import com.digihealth.anesthesia.basedata.formbean.SysCodeFormbean;
import com.digihealth.anesthesia.basedata.po.BasRegOpt;
import com.digihealth.anesthesia.basedata.po.BasRegionBed;
import com.digihealth.anesthesia.basedata.po.Controller;
import com.digihealth.anesthesia.basedata.utils.LogUtils;
import com.digihealth.anesthesia.basedata.utils.UserUtils;
import com.digihealth.anesthesia.common.entity.ResponseValue;
import com.digihealth.anesthesia.common.service.BaseService;
import com.digihealth.anesthesia.common.utils.DateUtils;
import com.digihealth.anesthesia.common.utils.GenerateSequenceUtil;
import com.digihealth.anesthesia.common.utils.JsonType;
import com.digihealth.anesthesia.doc.po.DocAnaesPacuRec;
import com.digihealth.anesthesia.doc.po.DocAnaesRecord;
import com.digihealth.anesthesia.evt.formbean.SearchFormBean;
import com.digihealth.anesthesia.evt.po.EvtAnaesEvent;
import com.digihealth.anesthesia.evt.po.EvtOperBodyEvent;
import com.digihealth.anesthesia.websocket.WebSocketHandler;

@Service
public class EvtAnaesEventService extends BaseService {
	public static final Integer IN_ROOM = 1; // 入室
	public static final Integer ANAES_START = 2;// 麻醉开始
	public static final Integer OPER_START = 4;// 手术开始
	public static final Integer OPER_END = 5;// 手术结束
	public static final Integer ANAES_END = 8;// 麻醉结束
	public static final Integer OUT_ROOM = 9;// 出室
	public static final Integer SUSPEND_OPER = 10; // 中止手术
	public static final Integer CANCEL_OPER = 7; //麻醉开始，手术未开始 

	public static final Integer DOC_ANAES_RECORD = 1;
	public static final Integer DOC_PACU_RECORD = 2;

	public List<EvtAnaesEvent> searchAnaeseventList(SearchFormBean searchBean) {
		if (StringUtils.isBlank(searchBean.getBeid())) {
			searchBean.setBeid(getBeid());
		}
		return evtAnaesEventDao.searchAnaeseventList(searchBean);
	}

	public List<EvtAnaesEvent> searchAnaesEventPacuList(SearchFormBean searchBean) {
		if (StringUtils.isBlank(searchBean.getBeid())) {
			searchBean.setBeid(getBeid());
		}
		List<EvtAnaesEvent> anaesEventPacuList = evtAnaesEventDao.searchAnaeseventList(searchBean);
		return anaesEventPacuList;
	}

    /**
     * 保存麻醉事件
     * @param anaesevent
     */
    @Transactional
	public void saveAnaeseventPacu(EvtAnaesEvent anaesEventPacu, ResponseValue resp) {
//		DocAnaesPacuRec anaesPacuRec = docAnaesPacuRecDao.selectByPrimaryKey(anaesEventPacu.getDocId());

//		BasRegOpt regOpt = basRegOptDao.searchRegOptById(anaesPacuRec.getRegOptId());
//		anaesEventPacu.setState(regOpt.getState());
		if ((!IN_ROOM.equals(anaesEventPacu.getCode()))
				&& (!ANAES_START.equals(anaesEventPacu.getCode()))
				&& (!OPER_START.equals(anaesEventPacu.getCode()))
				&& (!OPER_END.equals(anaesEventPacu.getCode()))
				&& (!ANAES_END.equals(anaesEventPacu.getCode()))
				&& (!OUT_ROOM.equals(anaesEventPacu.getCode()))) {
			if (StringUtils.isEmpty(anaesEventPacu.getAnaEventId())) {
				anaesEventPacu.setAnaEventId(GenerateSequenceUtil.generateSequenceNo());
				anaesEventPacu.setDocType(DOC_PACU_RECORD);
				evtAnaesEventDao.insertSelective(anaesEventPacu);
			} else {
				evtAnaesEventDao.updateByPrimaryKeySelective(anaesEventPacu);
			}
		} else {
			anaesEventPacu.setDocType(DOC_PACU_RECORD);
			saveAnaes(anaesEventPacu, resp);
		}
	}

    @Transactional
	public void deleteAnaeseventPacu(EvtAnaesEvent anaesEventPacu) {
    	evtAnaesEventDao.deleteByPrimaryKey(anaesEventPacu.getAnaEventId());
	}
    
	/**
	 * 新增麻醉事件
	 * 
	 * @param Anaesevent
	 */
	@Transactional
	public void insertAnaesevent(EvtAnaesEvent anaesevent) {
		anaesevent.setAnaEventId(GenerateSequenceUtil.generateSequenceNo());
		anaesevent.setDocType(DOC_ANAES_RECORD);
		evtAnaesEventDao.insertSelective(anaesevent);
	}

	/**
	 * 修改麻醉事件
	 * 
	 * @param Anaesevent
	 */
	@Transactional
	public void updateAnaesevent(EvtAnaesEvent anaesevent) {
		evtAnaesEventDao.updateByPrimaryKeySelective(anaesevent);
	}

	@Transactional
	public void deleteByCodeAndDocId(EvtAnaesEvent anaesevent, ResponseValue resp) {
		Integer code = anaesevent.getCode();
		if ((!IN_ROOM.equals(code)) && (!ANAES_START.equals(code)) && (!OPER_START.equals(code))
				&& (!OPER_END.equals(code)) && (!ANAES_END.equals(code)) && (!OUT_ROOM.equals(code))) {

			evtAnaesEventDao.deleteByCodeAndDocId(anaesevent.getDocId(), code, anaesevent.getAnaEventId());
		} else {
			resp.setResultCode("200000000");
			resp.setResultMessage("该事件不能删除！");
		}
	}

	public void saveAnaes(EvtAnaesEvent anaesevent,ResponseValue resp) {
		Integer code = anaesevent.getCode();
		List<EvtAnaesEvent> anaeseventList = evtAnaesEventDao.selectByCodeAndDocId(anaesevent.getDocId(), code);
		String beid =null;
		if(StringUtils.isBlank(beid)){
			beid = getBeid();
		}
		if (StringUtils.isEmpty(anaesevent.getAnaEventId())) {
			if (anaeseventList != null && anaeseventList.size() > 0) {
				resp.setResultCode("-1");
				resp.setResultMessage("该事件已存在，不能重复添加！");
				return ;
			} else {
				List<EvtAnaesEvent> sAnaesEventList = evtAnaesEventDao.selectCodeByDESC(anaesevent.getDocId(), code);
				if (sAnaesEventList != null && sAnaesEventList.size() > 0) {
					// Date d =
					// DateUtils.getParseTime(sAnaesEventList.get(0).getOccurtime());
					if ((sAnaesEventList.get(0).getOccurTime().getTime()) > (anaesevent.getOccurTime().getTime())) {
						List<SysCodeFormbean> s1 = basSysCodeDao.searchSysCodeByGroupIdAndCodeValue("anaes_event_type", code + "", beid);
						List<SysCodeFormbean> s2 = basSysCodeDao.searchSysCodeByGroupIdAndCodeValue("anaes_event_type", sAnaesEventList.get(0).getCode() + "", beid);
						resp.setResultCode("-1");
						resp.setResultMessage(s1.get(0).getCodeName() + "时间不能小于" + s2.get(0).getCodeName() + "时间");
						return ;
					}
				}
				List<EvtAnaesEvent> sAnaesEventList1 = evtAnaesEventDao.selectCodeByASC(anaesevent.getDocId(), code);
				if (sAnaesEventList1 != null && sAnaesEventList1.size() > 0) {

					if ((sAnaesEventList1.get(0).getOccurTime().getTime()) < (anaesevent.getOccurTime()).getTime()) {
						List<SysCodeFormbean> s1 = basSysCodeDao.searchSysCodeByGroupIdAndCodeValue("anaes_event_type", code + "", beid);
						List<SysCodeFormbean> s2 = basSysCodeDao.searchSysCodeByGroupIdAndCodeValue("anaes_event_type", sAnaesEventList1.get(0).getCode() + "", beid);
						resp.setResultCode("-1");
						resp.setResultMessage(s1.get(0).getCodeName() + "时间不能大于" + s2.get(0).getCodeName() + "时间");
						return ;
					}
				}
				anaesevent.setAnaEventId(GenerateSequenceUtil.generateSequenceNo());
				if (anaesevent.getDocType() == null) {
					anaesevent.setDocType(DOC_ANAES_RECORD);
				}
				evtAnaesEventDao.insertSelective(anaesevent);
			}
		} else {
			List<EvtAnaesEvent> sAnaesEventList = evtAnaesEventDao.selectCodeByDESC(anaesevent.getDocId(), code);
			if (sAnaesEventList != null && sAnaesEventList.size() > 0) {

				if ((sAnaesEventList.get(0).getOccurTime().getTime()) > (anaesevent.getOccurTime()).getTime()) {
					List<SysCodeFormbean> s1 = basSysCodeDao.searchSysCodeByGroupIdAndCodeValue("anaes_event_type", code + "", beid);
					List<SysCodeFormbean> s2 = basSysCodeDao.searchSysCodeByGroupIdAndCodeValue("anaes_event_type", sAnaesEventList.get(0).getCode() + "", beid);
					resp.setResultCode("-1");
					resp.setResultMessage(s1.get(0).getCodeName() + "时间不能小于" + s2.get(0).getCodeName() + "时间");
					return ;
				}
			}
			List<EvtAnaesEvent> sAnaesEventList1 = evtAnaesEventDao.selectCodeByASC(anaesevent.getDocId(), code);
			if (sAnaesEventList1 != null && sAnaesEventList1.size() > 0) {

				if ((sAnaesEventList1.get(0).getOccurTime().getTime()) < (anaesevent.getOccurTime()).getTime()) {
					List<SysCodeFormbean> s1 = basSysCodeDao.searchSysCodeByGroupIdAndCodeValue("anaes_event_type", code + "", beid);
					List<SysCodeFormbean> s2 = basSysCodeDao.searchSysCodeByGroupIdAndCodeValue("anaes_event_type", sAnaesEventList1.get(0).getCode() + "", beid);
					resp.setResultCode("-1");
					resp.setResultMessage(s1.get(0).getCodeName() + "时间不能大于" + s2.get(0).getCodeName() + "时间");
					return ;
				}
			}
			evtAnaesEventDao.updateByPrimaryKeySelective(anaesevent);
		}
		
		resp.setResultCode("1");
		resp.setResultMessage("操作成功！");
	}

	public void saveAnaesPacuRec(DocAnaesPacuRec record) {
		if (StringUtils.isBlank(record.getId())) {
			String bedId = record.getBedId();
			String regOptId = record.getRegOptId();
			if (bedId != null) {
				BasRegionBed regionBed = basRegionBedDao.selectByPrimaryKey(bedId);
				if (regionBed.getStatus() == 1) {
					logger.error("saveAnaesPacuRec---该床位已被占用请选择其他床位!");
					return;
				}
				regionBed.setRegOptId(regOptId);
				regionBed.setStatus(1);
				basRegionBedDao.updateByPatId(regionBed);
			}
			DocAnaesPacuRec p = docAnaesPacuRecDao.selectPacuByRegOptId(regOptId);
			if (p == null) {
				record.setId(GenerateSequenceUtil.generateSequenceNo());
				record.setProcessState("0");
				docAnaesPacuRecDao.insertSelective(record);
			}

		} else {
			// 当leaveTo不为空则代表患者出复苏室，则需要将床位状态改成有效
			if (StringUtils.isNotBlank(record.getLeaveTo() + "")) {
				BasRegionBed regionBed = basRegionBedDao.selectByPrimaryKey(record.getBedId());
				regionBed.setStatus(0);
				regionBed.setRegOptId("");
				basRegionBedDao.updateByPrimaryKey(regionBed);
				record.setProcessState("2");
				basRegOptDao.updateState(record.getRegOptId(), "06");
			} else {
				// regOptDao.updateState(record.getRegOptId(), "05");
				record.setProcessState("1");
			}
			docAnaesPacuRecDao.updateByPrimaryKeySelective(record);
		}

	}

	/**
	 * 保存麻醉事件
	 * 
	 * @param anaesevent
	 */
	@Transactional
	public void saveAnaesevent(EvtAnaesEvent anaesevent,ResponseValue resp) {

		// 获取麻醉记录单
		DocAnaesRecord anaesRecord = docAnaesRecordDao.searchAnaesRecordById(anaesevent.getDocId());

		BasRegOpt regOpt = basRegOptDao.searchRegOptById(anaesRecord.getRegOptId());

		// 判断是否更新
		Boolean isUpdate = false;
		
		String beid = null;
		if(StringUtils.isBlank(beid)){
			beid = getBeid();
		}

		String bedStr = "";
		if (StringUtils.isNotBlank(regOpt.getBed())) {
			bedStr = regOpt.getBed() + "床的";
		}
		Integer code = anaesevent.getCode();
		String time = DateUtils.formatLongTime(anaesevent.getOccurTime().getTime());
		if (IN_ROOM.equals(code)) {
			anaesRecord.setInOperRoomTime(time);
		}
		if (ANAES_START.equals(code)) {
			anaesRecord.setAnaesStartTime(time);
		}
		if (OPER_START.equals(code)) {
			// 将消息推送到手术室大屏
			// WebSocketHandler.sentMessageToAllUser(regOpt.getDeptName()+regOpt.getRegionName()+bedStr+regOpt.getName()+"开始手术");
			anaesRecord.setOperStartTime(time);
		}
		if (OPER_END.equals(code)) {
			anaesRecord.setOperEndTime(time);

		}
		if (ANAES_END.equals(code)) {
			anaesRecord.setAnaesEndTime(time);

		}
		
		/**
		 * 不是特殊事件，直接新增or修改
		 */
		if ((!IN_ROOM.equals(code)) && (!ANAES_START.equals(code)) && (!OPER_START.equals(code)) 
				&& (!OPER_END.equals(code)) && (!ANAES_END.equals(code)) && (!OUT_ROOM.equals(code))) {
			if (StringUtils.isBlank(anaesevent.getAnaEventId())) {
				anaesevent.setAnaEventId(GenerateSequenceUtil.generateSequenceNo());
				anaesevent.setDocType(DOC_ANAES_RECORD); //从麻醉记录单过来
				evtAnaesEventDao.insertSelective(anaesevent);
			} else {
				evtAnaesEventDao.updateByPrimaryKeySelective(anaesevent);
			}

		} else { //是特殊事件，则特殊处理
			saveAnaes(anaesevent,resp);
			// 如果result 为 0 那么证明保存成功
//			if (!resp.getResultCode().equals("0")) {
//				return resp;
//			}
		}
		// 将麻醉记录单表中的去向、出室时间进行修改，并将状态修改成为术后状态
		if (OUT_ROOM.equals(code)) {
			anaesRecord.setLeaveTo(anaesevent.getLeaveTo());
			anaesRecord.setOutOperRoomTime(time);

			// 这里页面要求将麻醉结束时间设置成出室时间，麻醉结束时间不单独设置
			// anaesRecord.setAnaesEndTime(event.getOccurtime());
			String regOptId = anaesRecord.getRegOptId();
			Controller controller = controllerDao.getControllerById(regOptId);
			// 当麻醉事件提交数据为出室时，需要将控制表的状态改成POSTOPERATIVE 术后
			if (null != controller) {
				String state = controller.getState();
				logger.info("state---------" + state + ",anaesRecord----" + regOptId);
				logger.info("anaesevent-----" + anaesevent.toString());
				
				// 去pacu的处理
				if ("2".equals(anaesevent.getLeaveTo()) && (!state.equals(OperationState.POSTOPERATIVE))) {
					controller.setState(OperationState.RESUSCITATION); // 存入pacu
					DocAnaesPacuRec p = docAnaesPacuRecDao.selectPacuByRegOptId(regOptId);
					if (p == null) {
						p = new DocAnaesPacuRec();
						p.setRegOptId(regOptId);
					}
					saveAnaesPacuRec(p);
				} else {
					controller.setState(OperationState.POSTOPERATIVE);
				}

				controllerDao.update(controller);

				// 当状态从术中转术后时，将事件表的数据备份
				this.changeAnaesRecordState(anaesRecord);
				isUpdate = true;
			}

			// 将消息推送到手术室大屏
			List<SysCodeFormbean> ls = basSysCodeDao.searchSysCodeByGroupIdAndCodeValue("leave_to", anaesevent.getLeaveTo(), beid);
			String leaveTo = ls.size() > 0 ? ls.get(0).getCodeName() : "";
			WebSocketHandler.sentMessageToAllUser(regOpt.getDeptName() + regOpt.getRegionName() + bedStr + regOpt.getName() + "手术已结束,去往" + leaveTo);
		}else if(CANCEL_OPER.equals(code)){
			logger.info("---进入---手术取消------CANCEL_OPER----");
			if(StringUtils.isNotEmpty(anaesevent.getLeaveTo())){
				anaesRecord.setLeaveTo(anaesevent.getLeaveTo());
			}else{
				anaesRecord.setLeaveTo("1");//如果前端传递为空，则默认回病房
			}
			anaesRecord.setOutOperRoomTime(time);
			
			Controller controller = controllerDao.getControllerById(anaesRecord.getRegOptId());
			if(null != controller){
				if(controller.getState().equals(OperationState.SURGERY)){
					controller.setState(OperationState.CANCEL);
					controller.setPreviousState(OperationState.SURGERY);
					controllerDao.update(controller);
				}
			}	
			anaesRecord.setProcessState("END");
			//anaesRecord.setState(OperationState.CANCEL);//置为取消状态
			
			//将消息推送到手术室大屏
			List<SysCodeFormbean> ls = basSysCodeDao.searchSysCodeByGroupIdAndCodeValue("leave_to", anaesRecord.getLeaveTo(),beid);
			String leaveTo = ls.size()>0?ls.get(0).getCodeName():"";
			WebSocketHandler.sentMessageToAllUser(regOpt.getDeptName()+regOpt.getRegionName()+bedStr+regOpt.getName()+"手术已取消,去往"+leaveTo);
		}

		// 将麻醉事件的数据保存至麻醉记录单中
		if (!isUpdate) {
			docAnaesRecordDao.updateByPrimaryKeySelective(anaesRecord);
		}
		LogUtils.saveOperateLog(anaesRecord.getRegOptId(), LogUtils.OPT_TYPE_INFO_SAVE, LogUtils.OPT_MODULE_INTERFACE, "术中人员麻醉事件保存", JsonType.jsonType(anaesevent), UserUtils.getUserCache(), beid);
		//return "操作成功";
	}

	public void changeAnaesRecordState(DocAnaesRecord anaesRecord) {

		logger.info("anaesEventService-----begin changeAnaesRecordState");

		anaesRecord.setProcessState("END");
		//Controller controller = controllerDao.getControllerById(anaesRecord.getRegOptId());
		// 如果状态没发生改变，直接修改数据

		// 如果手术体位发生改变，则需要记录到变更表中
		if (StringUtils.isNotBlank(anaesRecord.getOptBody()) && StringUtils.isNotBlank(anaesRecord.getOptBody())) {
			if (!anaesRecord.getOptBody().equals(anaesRecord.getOptBody())) {
				EvtOperBodyEvent operBodyEvent = new EvtOperBodyEvent();
				operBodyEvent.setDocId(anaesRecord.getAnaRecordId());
				operBodyEvent.setOptBody(anaesRecord.getOptBody());
				//operBodyEvent.setState(controller.getState());
				operBodyEvent.setStartTime(new Date());
				operBodyEvent.setOptBodyEventId(GenerateSequenceUtil.generateSequenceNo());
				operBodyEvent.setOptBodyOld(anaesRecord.getOptBody());
				evtOperBodyEventDao.insert(operBodyEvent);
			}
		}
		docAnaesRecordDao.updateByPrimaryKeySelective(anaesRecord);

		logger.info("anaesEventService-----end changeAnaesRecordState");
	}

	/** 
	 * 查询麻醉时长和手术时长
	 * <功能详细描述>
	 * @param searchBean
	 * @return
	 * @see [类、类#方法、类#成员]
	 */
	public ResponseValue searchTimesByCode(SearchFormBean searchBean) {
		ResponseValue resp = new ResponseValue();
		String docId = null != searchBean ? searchBean.getDocId() : "";
		double anaesTime = 0;
		double operTime = 0;

		EvtAnaesEvent mzksEvent = evtAnaesEventDao.selectAnaesEventByCodeAndDocId(docId, 2);// 麻醉开始
		EvtAnaesEvent mzjsEvent = evtAnaesEventDao.selectAnaesEventByCodeAndDocId(docId, 8);// 麻醉结束
		EvtAnaesEvent csEvent = evtAnaesEventDao.selectAnaesEventByCodeAndDocId(docId, 9);// 出室
		if (null != mzksEvent && null != mzksEvent.getOccurTime()) {
			if (null != mzjsEvent && null != mzjsEvent.getOccurTime()) {
				anaesTime = (mzjsEvent.getOccurTime().getTime() - mzksEvent.getOccurTime().getTime()) / (1000 * 60);
			} else if (null != csEvent && null != csEvent.getOccurTime()) {
				anaesTime = (csEvent.getOccurTime().getTime() - mzksEvent.getOccurTime().getTime()) / (1000 * 60);
			}
		}
		EvtAnaesEvent ssksEvent = evtAnaesEventDao.selectAnaesEventByCodeAndDocId(docId, 4);// 手术开始
		EvtAnaesEvent ssjsEvent = evtAnaesEventDao.selectAnaesEventByCodeAndDocId(docId, 5);// 手术结束
		if (null != ssksEvent && null != ssjsEvent && null != ssksEvent.getOccurTime() && null != ssjsEvent.getOccurTime()) {
			operTime = (ssjsEvent.getOccurTime().getTime() - ssksEvent.getOccurTime().getTime()) / (1000 * 60);
		}
		resp.put("anaesTime", anaesTime);
		resp.put("operTime", operTime);
		return resp;
	}
}
