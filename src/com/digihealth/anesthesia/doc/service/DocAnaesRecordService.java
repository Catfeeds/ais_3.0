/**     
 * @discription 在此输入一句话描述此文件的作用
 * @author liukui       
 * @created 2015-10-10 下午5:32:33    
 * tags     
 * see_to_target     
 */

package com.digihealth.anesthesia.doc.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.digihealth.anesthesia.basedata.po.BasRegOpt;
import com.digihealth.anesthesia.basedata.utils.LogUtils;
import com.digihealth.anesthesia.basedata.utils.UserUtils;
import com.digihealth.anesthesia.common.service.BaseService;
import com.digihealth.anesthesia.common.utils.BeanHelper;
import com.digihealth.anesthesia.common.utils.GenerateSequenceUtil;
import com.digihealth.anesthesia.common.utils.JsonType;
import com.digihealth.anesthesia.common.utils.StringUtils;
import com.digihealth.anesthesia.doc.po.DocAnaesRecord;
import com.digihealth.anesthesia.evt.po.EvtOperBodyEvent;
import com.digihealth.anesthesia.sysMng.po.BasUser;

/**
 * Title: OptNurseService.java Description: 描述
 * 
 * @author liukui
 * @created 2015-10-10 下午5:32:33
 */
@Service
public class DocAnaesRecordService extends BaseService {

	/**
	 * 
	 * @discription 根据手术ID获取麻醉记录
	 * @author liukui
	 * @created 2015-10-10 下午5:13:48
	 * @param regOptId
	 * @return
	 */
	public DocAnaesRecord searchAnaesRecordByRegOptId(String regOptId) {
		logger.info("searchAnaesRecordByRegOptId---- "+regOptId);
		return docAnaesRecordDao.searchAnaesRecordByRegOptId(regOptId);
	}

	/**
	 * 
	 * @discription 通过ID查询麻醉同意书
	 * @author liukui
	 * @created 2015-10-20 下午1:44:32
	 * @param id
	 * @return
	 */
	public DocAnaesRecord searchAnaesRecordById(String id) {
		return docAnaesRecordDao.searchAnaesRecordById(id);
	}

	/**
	 * 
	 * @discription 根据术中人员状态值得变化对相应的事件表进行备份并将麻醉记录单重新保存一条有效记录
	 * @author liukui
	 * @created 2015-10-20 下午1:44:18
	 * @param preVisit
	 * @return
	 */
	@Transactional
	public void changeAnaesRecordState(DocAnaesRecord anaesRecord) {
		logger.info("begin changeAnaesRecordState");
		
		BasRegOpt regOpt = basRegOptDao.searchRegOptById(anaesRecord.getRegOptId());
		if(null != anaesRecord.getFrontOperForbidTake()){
			regOpt.setFrontOperForbidTake(anaesRecord.getFrontOperForbidTake());
			basRegOptDao.updateFrontOperForbidTake(regOpt);
		}
		if(StringUtils.isNotBlank(anaesRecord.getFrontOperSpecialCase())){
			regOpt.setFrontOperSpecialCase(anaesRecord.getFrontOperSpecialCase());
			basRegOptDao.updateFrontOperSpecialCase(regOpt);
		}
		
		DocAnaesRecord oldAnaesRecord = docAnaesRecordDao.searchAnaesRecordById(anaesRecord.getAnaRecordId());
		// 如果状态没发生改变，直接修改数据
		//if (controller.getState().equals(oldAnaesRecord.getState())) {
		anaesRecord.setOptBody(getOptBody(anaesRecord.getOptBodys()));
			//如果手术体位发生改变，则需要记录到变更表中
			if(StringUtils.isNotBlank(anaesRecord.getOptBody()) && StringUtils.isNotBlank(oldAnaesRecord.getOptBody())){
				if(!anaesRecord.getOptBody().equals(oldAnaesRecord.getOptBody())){
					EvtOperBodyEvent operBodyEvent = new EvtOperBodyEvent();
					operBodyEvent.setDocId(anaesRecord.getAnaRecordId());
					operBodyEvent.setOptBody(anaesRecord.getOptBody());
					//operBodyEvent.setState(regOpt.getState());
					operBodyEvent.setStartTime(new Date());
					operBodyEvent.setOptBodyEventId(GenerateSequenceUtil.generateSequenceNo());
					operBodyEvent.setOptBodyOld(oldAnaesRecord.getOptBody());
					evtOperBodyEventDao.insert(operBodyEvent);
				}
			}
			
			BeanHelper.copyProperties(anaesRecord, oldAnaesRecord,true);
			docAnaesRecordDao.updateByPrimaryKey(oldAnaesRecord);
			
		/*} else {
			// 如果状态发生改变，麻醉记录表新增一条数据为新的有用的数据，上个数据flag=0作为历史数据
			oldAnaesRecord.setFlag("0");
			docAnaesRecordDao.updateByPrimaryKey(oldAnaesRecord);
			//将当前传入的数据保存
			anaesRecord.setState(controller.getState());
			anaesRecord.setFlag("1");
			docAnaesRecordDao.insert(anaesRecord);
			
			SearchFormBean searchBean =  new SearchFormBean();
			searchBean.setDocId(anaesRecord.getAnaRecordId());
			//获取当前麻醉记录单对应的麻醉事件记录
			List<Anaesevent> anaeseventList = anaeseventDao.searchAnaeseventList(searchBean);
			for (Anaesevent anaesevent : anaeseventList) {
				//将当前记录保存至事件历史表
				anaeseventDao.insertAnaeseventHis(anaesevent);
				//更改事件主表的状态
				anaesevent.setState(anaesRecord.getState());
				anaeseventDao.update(anaesevent);
			}
			// 用药事件明细
			List<Medicalevent> medEvtList = medicaleventDao.queryMedicaleventListById(searchBean);
			for (Medicalevent medicalevent : medEvtList) {
				//将当前记录保存至事件历史表
				medicaleventDao.insertMedicaleventHis(medicalevent);
				//更改事件主表的状态
				medicalevent.setState(anaesRecord.getState());
				medicaleventDao.update(medicalevent);
			}
			//入药量事件
			List<Ioevent> ioeventList = ioeventDao.queryIoeventById(searchBean);
			for (Ioevent ioevent : ioeventList) {
				//将当前记录保存至事件历史表
				ioeventDao.insertIoeventHis(ioevent);
				//更改事件主表的状态
				ioevent.setState(anaesRecord.getState());
				ioeventDao.update(ioevent);
			}
			
			//出药量事件
			List<Egress> egressList = egressDao.queryEgressListById(searchBean);
			for (Egress egress : egressList) {
				//将当前记录保存至事件历史表
				egressDao.insertEgressHis(egress);
				//更改事件主表的状态
				egress.setState(anaesRecord.getState());
				egressDao.update(egress);
			}
			
			// 实际麻醉方法
			List<RealAnaesMethod> realAnaesList = realAnaesMethodDao.searchRealAnaesMethodList(searchBean);
			for (RealAnaesMethod realAnaesMethod : realAnaesList) {
				//将当前记录保存至事件历史表
				realAnaesMethodDao.insertRealAnaesMethodHis(realAnaesMethod);
				//realAnaesMethodDao.update(realAnaesMethod);
			}
			//术中诊断
			List<OptLatterDiag> optLatterDiagList = OptLatterDiagDao.searchOptLatterDiagList(searchBean);
			for (OptLatterDiag optLatterDiag : optLatterDiagList) {
				//将当前记录保存至事件历史表
				OptLatterDiagDao.insertOptLatterDiagHis(optLatterDiag);
				//OptLatterDiagDao.update(optLatterDiag);
			}
			//已施手术
			List<OptRealOper> optRealOperList = optRealOperDao.searchOptRealOperList(searchBean);
			for (OptRealOper optRealOper : optRealOperList) {
				//将当前记录保存至事件历史表
				optRealOperDao.insertOptRealOperHis(optRealOper);
				//optRealOperDao.update(optRealOper);
			}
			//手术人员
			List<Participant> participantList = participantDao.searchParticipantList(searchBean);
			for (Participant participant : participantList) {
				//将当前记录保存至事件历史表
				participantDao.insertParticipantHis(participant);
				//participantDao.update(participant);
			}
			//呼吸事件
			List<CtlBreath> ctlBreathList = ctlBreathDao.searchCtlBreathList(searchBean);
			for (CtlBreath ctlBreath : ctlBreathList) {
				//将当前记录保存至事件历史表
				ctlBreathDao.insertCtlBreathHis(ctlBreath);
				//更改事件主表的状态
				ctlBreath.setState(anaesRecord.getState());
				ctlBreathDao.update(ctlBreath);
			}
			//心电图数据
			List<ElectDiogData> electDiogDataList = electDiogDataDao.searchElectDiogDataList(searchBean);
			for (ElectDiogData electDiogData : electDiogDataList) {
				//将当前记录保存至事件历史表
				electDiogDataDao.insertElectDiogDataHis(electDiogData);
			}
		}*/
		BasUser user = UserUtils.getUserCache();
		LogUtils.saveOperateLog(anaesRecord.getRegOptId(), "4",
            "2", "麻醉记录单修改", JsonType.jsonType(anaesRecord),user, getBeid());
		logger.info("end changeAnaesRecordState");
	}
	
	/**
	 * 保存提交的麻醉记录单修改信息
	 * @param anaesRecord
	 */
	@Transactional
	public void saveAnaesRecord(DocAnaesRecord anaesRecord){
		logger.info("begin saveAnaesRecord");
		logger.info("recordSave "+anaesRecord.toString());
		docAnaesRecordDao.updateByPrimaryKey(anaesRecord);
		logger.info("end saveAnaesRecord");
	}
	
	@Transactional
	public void updateAnaesInRoomTime(String inTime, String regOptId) {
		 docAnaesRecordDao.updateAnaesInRoomTime(inTime, regOptId);
	}
	
	@Transactional
	public void updatefievt(DocAnaesRecord anaesRecord){
		docAnaesRecordDao.updatefievt(anaesRecord.getF(), anaesRecord.getIe(), anaesRecord.getVt(), anaesRecord.getRegOptId());
	}

	public DocAnaesRecord getAnaesRecord(String regOptId) {
		return docAnaesRecordDao.searchAnaesRecordByRegOptId(regOptId);
	}

	public String getOptBody(List<String> optBodys) {
		String optBody = "";
		if(!optBodys.isEmpty() && optBodys.size() > 0) {
			for(int i=0; i<optBodys.size(); i++) {
				if(StringUtils.isBlank(optBody)) {
					optBody = optBodys.get(i);
				}else {
					optBody += "," + optBodys.get(i);
				}
			}
		}
		return optBody;
	}
	
	public List<String> getOptBodys(String optBodys) {
		List<String> optBodys_ = new ArrayList<String>();
		if (StringUtils.isNotBlank(optBodys)) {
			String[] optBody = optBodys.split(",");
			for (int i = 0; i < optBody.length; i++) {
				optBodys_.add(optBody[i]);
			}
		}
		return optBodys_;
	}
}
