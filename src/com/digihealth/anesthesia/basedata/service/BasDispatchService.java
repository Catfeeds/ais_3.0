/**
 * Copyright &copy; 2012-2013 <a href="httparamMap://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.digihealth.anesthesia.basedata.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.digihealth.anesthesia.basedata.config.OperationState;
import com.digihealth.anesthesia.basedata.formbean.BaseInfoQuery;
import com.digihealth.anesthesia.basedata.formbean.DispatchFormbean;
import com.digihealth.anesthesia.basedata.formbean.DispatchOperationFormBean;
import com.digihealth.anesthesia.basedata.formbean.DispatchPeopleNameFormBean;
import com.digihealth.anesthesia.basedata.formbean.DispatchTimeFormbean;
import com.digihealth.anesthesia.basedata.formbean.EmgencyOperationFormBean;
import com.digihealth.anesthesia.basedata.formbean.OperRoomFormBean;
import com.digihealth.anesthesia.basedata.formbean.PrintNoticeFormBean;
import com.digihealth.anesthesia.basedata.formbean.SearchDispatchFormBean;
import com.digihealth.anesthesia.basedata.formbean.SearchListScheduleFormBean;
import com.digihealth.anesthesia.basedata.po.BasAnaesMethod;
import com.digihealth.anesthesia.basedata.po.BasDept;
import com.digihealth.anesthesia.basedata.po.BasDiagnosedef;
import com.digihealth.anesthesia.basedata.po.BasDispatch;
import com.digihealth.anesthesia.basedata.po.BasHealthNurse;
import com.digihealth.anesthesia.basedata.po.BasOperationPeople;
import com.digihealth.anesthesia.basedata.po.BasOperdef;
import com.digihealth.anesthesia.basedata.po.BasRegOpt;
import com.digihealth.anesthesia.basedata.po.BasRegion;
import com.digihealth.anesthesia.basedata.po.BasSysCode;
import com.digihealth.anesthesia.basedata.po.Controller;
import com.digihealth.anesthesia.basedata.utils.BasRegOptUtils;
import com.digihealth.anesthesia.basedata.utils.UserUtils;
import com.digihealth.anesthesia.common.entity.ResponseValue;
import com.digihealth.anesthesia.common.service.BaseService;
import com.digihealth.anesthesia.common.utils.BeanHelper;
import com.digihealth.anesthesia.common.utils.DateUtils;
import com.digihealth.anesthesia.common.utils.GenerateSequenceUtil;
import com.digihealth.anesthesia.common.utils.JsonType;
import com.digihealth.anesthesia.doc.po.DocAccede;
import com.digihealth.anesthesia.doc.po.DocAnaesBeforeSafeCheck;
import com.digihealth.anesthesia.doc.po.DocAnaesPlan;
import com.digihealth.anesthesia.doc.po.DocAnaesRecord;
import com.digihealth.anesthesia.doc.po.DocAnaesSummary;
import com.digihealth.anesthesia.doc.po.DocAnaesSummaryAllergicReaction;
import com.digihealth.anesthesia.doc.po.DocAnaesSummaryAppendixCanal;
import com.digihealth.anesthesia.doc.po.DocAnaesSummaryAppendixGen;
import com.digihealth.anesthesia.doc.po.DocAnaesSummaryAppendixVisit;
import com.digihealth.anesthesia.doc.po.DocAnaesSummaryVenipuncture;
import com.digihealth.anesthesia.doc.po.DocExitOperSafeCheck;
import com.digihealth.anesthesia.doc.po.DocInsuredPatAgree;
import com.digihealth.anesthesia.doc.po.DocOperBeforeSafeCheck;
import com.digihealth.anesthesia.doc.po.DocOptCareRecord;
import com.digihealth.anesthesia.doc.po.DocOptNurse;
import com.digihealth.anesthesia.doc.po.DocOptRiskEvaluation;
import com.digihealth.anesthesia.doc.po.DocPatOutRangeAgree;
import com.digihealth.anesthesia.doc.po.DocPatShuttleTransfer;
import com.digihealth.anesthesia.doc.po.DocPlacentaHandleAgree;
import com.digihealth.anesthesia.doc.po.DocPostFollowRecord;
import com.digihealth.anesthesia.doc.po.DocPreOperVisit;
import com.digihealth.anesthesia.doc.po.DocPrePostVisit;
import com.digihealth.anesthesia.doc.po.DocPreVisit;
import com.digihealth.anesthesia.doc.po.DocSafeCheck;
import com.digihealth.anesthesia.doc.po.DocTransferConnectRecord;
import com.digihealth.anesthesia.evt.po.EvtParticipant;
import com.digihealth.anesthesia.evt.service.EvtParticipantService;
import com.digihealth.anesthesia.sysMng.po.BasUser;

/**
 * 
 * Title: DispatchService.java Description: 手术排程Service
 * 
 * @author liukui
 * @created 2015-10-7 下午6:00:54
 */
@Service
public class BasDispatchService extends BaseService {

	private static final Integer DISPATCH_SAVE = 0;// 保存暂存

	/**
	 * 当传入的查询条件为空时，需要构建一个查询对象
	 * 
	 * @param baseQuery
	 * @return
	 */
	public List<SearchDispatchFormBean> findList(BaseInfoQuery baseQuery) {
		if (StringUtils.isBlank(baseQuery.getBeid())) {
			baseQuery.setBeid(getBeid());
		}
		return basDispatchDao.findList(baseQuery);
	}

	public List<PrintNoticeFormBean> printOperNoticeindList(BaseInfoQuery baseQuery) {
		if (StringUtils.isBlank(baseQuery.getBeid())) {
			baseQuery.setBeid(getBeid());
		}
		return basDispatchDao.printOperNotice(baseQuery);
	}

	public List<SearchDispatchFormBean> printDispatchItem(BaseInfoQuery baseQuery) {
		if (StringUtils.isBlank(baseQuery.getBeid())) {
			baseQuery.setBeid(getBeid());
		}
		BaseInfoQuery baseQuery1 = new BaseInfoQuery();
		baseQuery1.setType("01");
		List<SearchDispatchFormBean> bean = basDispatchDao.findList(baseQuery);
		List<BasDispatch> dList = basDispatchDao.selectDispatchGbOproomId(baseQuery.getOperDate(),getBeid());
		List<String> stateItems = new ArrayList<String>();
		int sta = 1;
		if (null != dList && dList.size() > 0) {
			for (int i = 0; i < dList.size(); i++) {
				stateItems.add(dList.get(i).getOperRoomId());
			}
			sta = 2;
		}

		List<OperRoomFormBean> list = basOperroomDao.selectPrint("01", stateItems, sta, baseQuery.getBeid());
		if (list != null) {
			for (int i = 0; i < list.size(); i++) {
				OperRoomFormBean or = list.get(i);
				SearchDispatchFormBean b = new SearchDispatchFormBean();
				b.setOperRoomId(or.getOperRoomId());
				b.setOperRoomName(or.getName());
				BasHealthNurse hn = basHealthNurseDao.selectHealNurse(baseQuery.getOperDate(), or.getOperRoomId(), getBeid());
				if (hn != null) {
					b.setHealthNurse(hn.getHealthnurse());
					b.setHealthNurseName(hn.getHealthnurseName());
					bean.add(b);
				}

			}
		}
		return bean;
	}

	/**
	 * 批量排程信息保存
	 * 
	 * @param dispatchList
	 * @throws Exception
	 */
	@Transactional
	public void saveDispatch(DispatchOperationFormBean dispatchFormBean, ResponseValue result) {

		for (BasDispatch dispatch : dispatchFormBean.getDispatchList()) {
			if (StringUtils.isBlank(dispatch.getBeid())) {
				dispatch.setBeid(getBeid());
			}

			Controller controller = controllerDao.getControllerById(dispatch.getRegOptId());
			// 如果此排班信息已经为术中了，则不允许调整排班信息
			if (controller != null) {
				if (!controller.getState().equals(OperationState.NO_SCHEDULING) && !controller.getState().equals(OperationState.PREOPERATIVE)) {
					result.put("resultCode", "30000003");
					result.put("resultMessage", "手术排班修改出错，该排班信息状态错误！");
					return;
				}
			}

			// 获取手术人员信息
			BasRegOpt regOpt = basRegOptDao.searchRegOptById(dispatch.getRegOptId());
			/**
			 * 根据当前操作排程人员类型判断可修改字段的范围 RoleType = N可以修改除麻醉医生意外的其他字段 RoleType =
			 * A只可以修改麻醉医生字段
			 */
			BasDispatch disObj = basDispatchDao.getDispatchOper(dispatch.getRegOptId());
			if (disObj == null) {
				dispatch.setOperRegDate(regOpt.getOperaDate());
				basDispatchDao.insert(dispatch);
			} else {
				dispatch.setOperRegDate(disObj.getOperRegDate());
				String anesthetistId = disObj.getAnesthetistId();
				String perfusiondoctorId = disObj.getPerfusionDoctorId();
				if ("ANAES_DIRECTOR".equals(dispatchFormBean.getRoleType()) || "ADMIN".equals(dispatchFormBean.getRoleType())) {
					anesthetistId = dispatch.getAnesthetistId();
					perfusiondoctorId = dispatch.getPerfusionDoctorId();
				}
				if ("HEAD_NURSE".equals(dispatchFormBean.getRoleType()) || "ADMIN".equals(dispatchFormBean.getRoleType())) {
					BeanHelper.copyProperties(dispatch, disObj);
				}
				disObj.setAnesthetistId(anesthetistId);
				disObj.setPerfusionDoctorId(perfusiondoctorId);
				disObj.setIsHold(dispatch.getIsHold());
				basDispatchDao.update(disObj);
			}

			// 排程完成后，修改手术信息表手术时间
			if (StringUtils.isNotBlank(dispatch.getOperaDate())) {
				regOpt.setOperaDate(dispatch.getOperaDate());
				saveRegOpt(regOpt);
			}

			// 排程完成
			if (DISPATCH_SAVE.equals(dispatch.getIsHold())) {
				saveDispatchSuccess(dispatch, dispatchFormBean.getRoleType());
				// operListService.tsurgeryhisid(regOpt);

			}
			// operListService.tsssqhz(regOpt);

		}

		// BasUser user = UserUtils.getUserCache();
		// operlogService.saveOperatelog("", operlogService.OPT_TYPE_INFO_SAVE,
		// operlogService.OPT_MODULE_OPER_DOC,"批量手术排程",
		// JsonType.jsonType(dispatchFormBean.getDispatchList())
		// ,user);
	}

	/**
	 * 更改手术室
	 * 
	 * @param dispatchList
	 * @throws Exception
	 */
	@Transactional
	public void changeOperRoom(DispatchOperationFormBean dispatchFormBean, ResponseValue result) {

		for (BasDispatch dispatch : dispatchFormBean.getDispatchList()) {
			if (StringUtils.isBlank(dispatch.getBeid())) {
				dispatch.setBeid(getBeid());
			}

			Controller controller = controllerDao.getControllerById(dispatch.getRegOptId());
			// 如果此排班信息已经为术中了，则不允许调整排班信息
			if (controller != null) {
				if (!controller.getState().equals(OperationState.NO_SCHEDULING) && !controller.getState().equals(OperationState.PREOPERATIVE)) {
					result.put("resultCode", "30000003");
					result.put("resultMessage", "手术排班修改出错，该排班信息状态错误！");
					return;
				}
			}

			// 获取手术人员信息
			BasRegOpt regOpt = basRegOptDao.searchRegOptById(dispatch.getRegOptId());
			/**
			 * 根据当前操作排程人员类型判断可修改字段的范围 RoleType = N可以修改除麻醉医生意外的其他字段 RoleType =
			 * A只可以修改麻醉医生字段
			 */
			BasDispatch disObj = basDispatchDao.getDispatchOper(dispatch.getRegOptId());
			if (disObj == null) {
				dispatch.setOperRegDate(regOpt.getOperaDate());
				basDispatchDao.insert(dispatch);
			} else {
				dispatch.setOperRegDate(disObj.getOperRegDate());
				String anesthetistId = disObj.getAnesthetistId();
				String perfusiondoctorId = disObj.getPerfusionDoctorId();
				if ("ANAES_DIRECTOR".equals(dispatchFormBean.getRoleType())  || "ADMIN".equals(dispatchFormBean.getRoleType())) {
					anesthetistId = dispatch.getAnesthetistId();
					perfusiondoctorId = dispatch.getPerfusionDoctorId();
				}
				if ("HEAD_NURSE".equals(dispatchFormBean.getRoleType())  || "ADMIN".equals(dispatchFormBean.getRoleType())) {
					BeanHelper.copyProperties(dispatch, disObj);
				}
				disObj.setAnesthetistId(anesthetistId);
				disObj.setPerfusionDoctorId(perfusiondoctorId); 
				disObj.setIsHold(dispatch.getIsHold());
				int resultPc = basDispatchDao.selectByOprroomOperDateStartTime(dispatch.getOperaDate(), dispatch.getOperRoomId(), dispatch.getStartTime());
				if (resultPc >= 1) {
					result.put("resultCode", "0");
					result.put("resultMessage", "切换的手术间此时间点已有手术，请重新更换！");
				}
			}

			// 排程完成后，修改手术信息表手术时间
			if (StringUtils.isNotBlank(dispatch.getOperaDate())) {
				regOpt.setOperaDate(dispatch.getOperaDate());
				saveRegOpt(regOpt);
			}

			// 排程完成
			if (DISPATCH_SAVE.equals(dispatch.getIsHold())) {
				saveDispatchSuccess(dispatch, dispatchFormBean.getRoleType());
				// operListService.tsurgeryhisid(regOpt);

			}
			// operListService.tsssqhz(regOpt);

		}

		// BasUser user = UserUtils.getUserCache();
		// operlogService.saveOperatelog("", operlogService.OPT_TYPE_INFO_SAVE,
		// operlogService.OPT_MODULE_OPER_DOC,"批量手术排程",
		// JsonType.jsonType(dispatchFormBean.getDispatchList())
		// ,user);
	}

	/**
	 * 将页面传入的排程完成信息进行保存
	 * 
	 * @param dispatch
	 */
	//@Transactional
	public void saveDispatchSuccess(BasDispatch dispatch, String RoleType) {

		Controller controller = controllerDao.getControllerById(dispatch.getRegOptId());
		// 只有当controller表中的状态等于02时才允许保存排程信息
		if (null != controller && (controller.getState().equals(OperationState.NO_SCHEDULING) || controller.getState().equals(OperationState.PREOPERATIVE))) {
			controller.setState(OperationState.PREOPERATIVE);
			if (logger.isDebugEnabled()) {
				logger.debug("DispatchService insertDispatch data:controller" + controller.toString());
			}
			controllerDao.update(controller);

			// 获取麻醉记录单数据
			DocAnaesRecord anaesRecord = docAnaesRecordDao.searchAnaesRecordByRegOptId(dispatch.getRegOptId());

			// 避免重复保存时出现数据错误，先删除原来数据再做保存
			EvtParticipant delPant = new EvtParticipant();
			delPant.setDocId(dispatch.getRegOptId());
			delPant.setRole(RoleType);
			evtParticipantDao.delete(delPant);
			// 排程完成后将麻醉医生字段的值写入术中人员表中
			if (StringUtils.isNotBlank(dispatch.getAnesthetistId())) {
				List<EvtParticipant> participantList = new ArrayList<EvtParticipant>();
				EvtParticipant participant = new EvtParticipant();
				participant.setDocId(anaesRecord.getAnaRecordId());
				participant.setRole(EvtParticipantService.ROLE_ANESTH);
				participant.setUserLoginName(dispatch.getAnesthetistId());
				participant.setOperatorType("01"); // 将排程中的麻醉医生设置为主麻醉医生
				participant.setIsShiftChange(1); // 设为交班人员
				participantList.add(participant);
				saveParticipant(participantList);
			}

			List<EvtParticipant> nurseList = new ArrayList<EvtParticipant>();
			// 第一巡回护士
			if (StringUtils.isNotBlank(dispatch.getCircunurseId1())) {
				EvtParticipant participant = new EvtParticipant();
				participant.setDocId(anaesRecord.getAnaRecordId());
				participant.setRole(EvtParticipantService.ROLE_NURSE);
				participant.setUserLoginName(dispatch.getCircunurseId1());
				participant.setOperatorType("05"); // 巡回护士
				nurseList.add(participant);
			}
			// 第二巡回护士
			if (StringUtils.isNotBlank(dispatch.getCircunurseId2())) {
				EvtParticipant participant = new EvtParticipant();
				participant.setDocId(anaesRecord.getAnaRecordId());
				participant.setRole(EvtParticipantService.ROLE_NURSE);
				participant.setUserLoginName(dispatch.getCircunurseId2());
				participant.setOperatorType("05"); // 巡回护士
				nurseList.add(participant);
			}

			// 第一洗手护士
			if (StringUtils.isNotBlank(dispatch.getInstrnurseId1())) {
				EvtParticipant participant = new EvtParticipant();
				participant.setDocId(anaesRecord.getAnaRecordId());
				participant.setRole(EvtParticipantService.ROLE_NURSE);
				participant.setUserLoginName(dispatch.getInstrnurseId1());
				participant.setOperatorType("04"); // 洗手护士
				nurseList.add(participant);
			}
			// 第二洗手护士
			if (StringUtils.isNotBlank(dispatch.getInstrnurseId2())) {
				EvtParticipant participant = new EvtParticipant();
				participant.setDocId(anaesRecord.getAnaRecordId());
				participant.setRole(EvtParticipantService.ROLE_NURSE);
				participant.setUserLoginName(dispatch.getInstrnurseId2());
				participant.setOperatorType("04"); // 洗手护士
				nurseList.add(participant);
			}
			if (nurseList.size() > 0) {
				saveParticipant(nurseList);
			}
		}
	}

	/**
	 * 紧急手术创建
	 * 
	 * @param EmgencyOperationFormBean
	 * @throws Exception
	 */
	@Transactional
	public void createEmergencyOperation(EmgencyOperationFormBean emgencyOperationFormBean, ResponseValue respValue) {
		BasRegOpt regOpt = emgencyOperationFormBean.getRegOpt();
		if (logger.isDebugEnabled()) {
			logger.debug("DispatchService createEmergencyOperation data:dispatch" + emgencyOperationFormBean.getDispatch().toString());
		}
		// regOpt.setRegOptId(GenerateSequenceUtil.generateSequenceNo());
		BasRegOptUtils.getOtherInfo(regOpt);
		String result = saveRegOpt(regOpt);
		if (result.equals("true")) {
			// 创建排程信息
			BasDispatch dispatch = emgencyOperationFormBean.getDispatch();
			dispatch.setRegOptId(regOpt.getRegOptId());
			dispatch.setOperRegDate(regOpt.getOperaDate());
			dispatch.setIsHold(DISPATCH_SAVE);
			if (StringUtils.isBlank(dispatch.getBeid())) {
				dispatch.setBeid(getBeid());
			}
			if (logger.isDebugEnabled()) {
				logger.debug("DispatchService createEmergencyOperation data:dispatch" + dispatch.toString());
			}
			basDispatchDao.insert(dispatch);

			// 手术审核
			checkOperation(regOpt.getRegOptId(), OperationState.PREOPERATIVE, "", respValue);

			// 紧急排程时roleType为护士长
			saveDispatchSuccess(dispatch, "N");
			// operListService.tsurgeryhisid(regOpt);
			// operListService.tsssqhz(regOpt);
		}
		// operlogService.saveOperatelog(emgencyOperationFormBean.getRegOpt().getRegOptId(),
		// operlogService.OPT_TYPE_INFO_SAVE,
		// operlogService.OPT_MODULE_OPER_DOC,"病人急诊信息登记",
		// JsonType.jsonType(emgencyOperationFormBean)
		// ,UserUtils.getUserCache());

	}

	public BasDispatch getDispatchOper(String regOptId) {
		return basDispatchDao.getDispatchOper(regOptId);
	}

	/**
	 * 批量修改排程信息
	 * 
	 * @param dispatchList
	 */

	@Transactional
	public void updateDispatch(List<BasDispatch> dispatchList) {
		for (BasDispatch dispatch : dispatchList) {
			if (StringUtils.isBlank(dispatch.getBeid())) {
				dispatch.setBeid(getBeid());
			}
			if (logger.isDebugEnabled()) {
				logger.debug("DispatchService updateDispatch data:" + dispatch.toString());
			}
			basDispatchDao.update(dispatch);
		}
	}

	/**
	 * 排班取消 这里只允许对暂存数据做重排操作
	 */
	@Transactional
	public Map cancelDispatchItem(List<String> regOptIdList) {
		if (logger.isDebugEnabled()) {
			logger.debug("DispatchService cancelDispatchItem data:" + regOptIdList.toString());
		}
		Map result = new HashMap();
		for (String regOptId : regOptIdList) {
			// 获取当前手术人员的状态
			Controller controller = controllerDao.getControllerById(regOptId);
			BasDispatch dispatch = basDispatchDao.getDispatchOper(regOptId);

			if (!OperationState.NO_SCHEDULING.equals(controller.getState()) && !OperationState.PREOPERATIVE.equals(controller.getState())) {
				result.put("resultCode", "30000003");
				result.put("resultMessage", "手术排班取消错误，当前状态不允许取消排班");
				return result;
			}
			/**
			 * 如果当前状态为未排班则直接取消排班信息 当已经排班未进入术中时，允许取消排班，并将手术人员状态回退到未排班状态
			 */
			if (null != controller && controller.getState().equals(OperationState.PREOPERATIVE)) {
				controller.setState(OperationState.NO_SCHEDULING);
				controllerDao.update(controller);
			}

			// 获取手术人员信息将手术日期改成手术申请日期
			BasRegOpt regOpt = basRegOptDao.searchRegOptById(dispatch.getRegOptId());
			regOpt.setOperaDate(dispatch.getOperRegDate());
			basRegOptDao.update(regOpt);

			basDispatchDao.deleteDispatchHold(regOptId);
		}
		result.put("resultCode", "1");
		result.put("resultMessage", "手术排程取消成功！");
		return result;
	}

	/**
	 * 批量排班重排
	 */
	@Transactional
	public void redispatchItem(Map map) {
		if (logger.isDebugEnabled()) {
			logger.debug("DispatchService redispatchItem data:" + map.get("operatDate"));
		}

		List<BasDispatch> dispatchList = basDispatchDao.getDispatchListByOperateDate(map.get("operatDate").toString());

		for (BasDispatch dispatch : dispatchList) {
			if (StringUtils.isBlank(dispatch.getBeid())) {
				dispatch.setBeid(getBeid());
			}
			// 获取当前手术人员的状态
			Controller controller = controllerDao.getControllerById(dispatch.getRegOptId());
			/**
			 * 如果当前状态为排班则直接取消排班信息 当已经排班未进入术中时，允许取消排班，并将手术人员状态回退到未排班状态
			 */
			if (OperationState.NO_SCHEDULING.equals(controller.getState()) || OperationState.PREOPERATIVE.equals(controller.getState())) {
				controller.setState(OperationState.NO_SCHEDULING);
				controllerDao.update(controller);

				// 获取手术人员信息将手术日期改成手术申请日期
				BasRegOpt regOpt = basRegOptDao.searchRegOptById(dispatch.getRegOptId());
				regOpt.setOperaDate(dispatch.getOperRegDate());
				basRegOptDao.update(regOpt);
				basDispatchDao.deleteDispatchHold(dispatch.getRegOptId());
			}
		}

	}

	/**
	 * 
	 * @discription 根据regOptId获取排班人员的名字
	 * @author chengwang
	 * @created 2015年10月30日 下午2:08:37
	 * @param regOptId
	 * @return
	 */
	public DispatchPeopleNameFormBean searchPeopleNameByRegOptId(String regOptId) {
		return basDispatchDao.searchPeopleNameByRegOptId(regOptId, getBeid());
	}

	public DispatchFormbean getDispatchOperByRegOptId(String regOptId) {
		return basDispatchDao.getDispatchOperByRegOptId(regOptId, getBeid());
	}

	public Integer searchPersonTotalInOperRoomByStartTime(BasDispatch dis) {
		return basDispatchDao.searchPersonTotalInOperRoomByStartTime(dis.getOperaDate(), dis.getStartTime(), dis.getOperRoomId(), getBeid());
	}

	public Integer checkOperateTimeBeUse(BasDispatch dis) {
		return basDispatchDao.checkOperateTimeBeUse(dis.getOperaDate(), dis.getStartTime(), dis.getOperRoomId(), getBeid());
	}

	public List<DispatchTimeFormbean> getNotUseTimeList(BasDispatch dispatch) {
		if (StringUtils.isBlank(dispatch.getBeid())) {
			dispatch.setBeid(getBeid());
		}
		return basDispatchDao.getNotUseTimeList(dispatch);
	}

	public List<BasSysCode> getNoUsePcsList(BasDispatch dispatch) {
		if (StringUtils.isBlank(dispatch.getBeid())) {
			dispatch.setBeid(getBeid());
		}
		return basDispatchDao.getNoUsePcsList(dispatch);
	}

	public List<PrintNoticeFormBean> getOperateInfoByInsideScreen() {

		return basDispatchDao.getOperateInfoByInsideScreen(getBeid());
	}

	public List<PrintNoticeFormBean> getOperateInfoByOutsideScreen() {
		return basDispatchDao.getOperateInfoByOutsideScreen();
	}

	private String saveRegOpt(BasRegOpt regOpt) {
		BasDept basDept = basDeptDao.searchDeptById(regOpt.getDeptId());
		if (basDept != null) {
			regOpt.setDeptName(basDept.getName());
		}
		BasRegion basRegion = basRegionDao.searchRegionById(regOpt.getRegionId());
		if (basRegion != null) {
			regOpt.setRegionName(basRegion.getName());
		}
		BasRegOptUtils.IsLocalAnaesSet(regOpt, regOpt.getDesignedAnaesMethodCodes(), regOpt.getBeid());
		if (StringUtils.isNotBlank(regOpt.getRegOptId())) {
			basRegOptDao.updateByPrimaryKey(regOpt);
			return "true";
		} else {
			BasUser user = UserUtils.getUserCache();
			String regOptId = GenerateSequenceUtil.generateSequenceNo();
			regOpt.setRegOptId(regOptId);
			regOpt.setCostsettlementState("0");
			regOpt.setState(OperationState.NOT_REVIEWED);
			if (user != null) {
				regOpt.setCreateUser(user.getUserName());
			}
			regOpt.setCreateTime(DateUtils.formatDateTime(new Date()));
			regOpt.setBeid(getBeid());
			basRegOptDao.insert(regOpt);
			if ("1".equals(regOpt.getGetData())) {
				return JsonType.jsonType(basRegOptDao.searchRegOptById(regOpt.getRegOptId()));
			}
			return "true";
		}
	}

	public void checkOperation(String ids, String state, String previousState, ResponseValue respValue) {
		List<String> idsList = new ArrayList<String>();
		String[] idsString = ids.split(",");
		for (int i = 0; i < idsString.length; i++) {
			idsList.add(idsString[i]);
		}
		int succCnt = 0;
		// List<DocumentType> documentType =
		// documentTypeDao.searchDocumentTypeByEnable("");
		if (idsList.size() > 0 && idsList != null) {
			for (int i = 0; i < idsList.size(); i++) {
				BasRegOpt regOpt = basRegOptDao.searchRegOptById(idsList.get(i));
				if (regOpt != null) {
					if (StringUtils.isEmpty(regOpt.getDesignedAnaesMethodName()) || StringUtils.isEmpty(regOpt.getDesignedAnaesMethodCode())) {
						continue;
					}
				}
				Controller c = controllerDao.getControllerById(idsList.get(i));
				if (c != null) {
					if (c.getState().equals(OperationState.NOT_REVIEWED)) {
						controllerDao.checkOperation(idsList.get(i), state, previousState);

						// 创建术前访视单
						DocPreVisit preVisit = new DocPreVisit();
						preVisit.setPreVisitId(GenerateSequenceUtil.generateSequenceNo());
						preVisit.setRegOptId(idsList.get(i));
						preVisit.setProcessState("NO_END");
						docPreVisitDao.insert(preVisit);

                        // 创建术前访视单
                        DocPreOperVisit docPreOperVisit = new DocPreOperVisit();
                        docPreOperVisit.setId(GenerateSequenceUtil.generateSequenceNo());
                        docPreOperVisit.setRegOptId(idsList.get(i));
                        docPreOperVisit.setProcessState("NO_END");
                        docPreOperVisitDao.insert(docPreOperVisit);
						// 创建麻醉同意书
						DocAccede accede = new DocAccede();
						accede.setAccedeId(GenerateSequenceUtil.generateSequenceNo());
						accede.setRegOptId(idsList.get(i));
						accede.setFlag("1");
						accede.setProcessState("NO_END");
						docAccedeDao.insert(accede);

						// 麻醉计划单
						DocAnaesPlan anaesPlan = new DocAnaesPlan();
						anaesPlan.setRegOptId(idsList.get(i));
						anaesPlan.setProcessState("NO_END");
						anaesPlan.setId(GenerateSequenceUtil.generateSequenceNo());
						docAnaesPlanDao.insert(anaesPlan);

						// 医疗保险病人超范围用药同意书
						DocPatOutRangeAgree patOutRangeAgree = new DocPatOutRangeAgree();
						patOutRangeAgree.setRegOptId(idsList.get(i));
						patOutRangeAgree.setProcessState("NO_END");
						patOutRangeAgree.setId(GenerateSequenceUtil.generateSequenceNo());
						docPatOutRangeAgreeDao.insert(patOutRangeAgree);

						// 手术病人术前术后访问记录单
						DocPrePostVisit prePostVisit = new DocPrePostVisit();
						prePostVisit.setRegOptId(idsList.get(i));
						prePostVisit.setProcessState("NO_END");
						// 急诊时不需要此单子，直接设置状态为完成
						if ("1".equals(regOpt.getEmergency())) {
							prePostVisit.setProcessState("END");
						}
						prePostVisit.setId(GenerateSequenceUtil.generateSequenceNo());
						docPrePostVisitDao.insert(prePostVisit);

						// 手术患者接送交接单
						DocPatShuttleTransfer patShuttleTransfer = new DocPatShuttleTransfer();
						patShuttleTransfer.setRegOptId(idsList.get(i));
						patShuttleTransfer.setProcessState("NO_END");
						patShuttleTransfer.setId(GenerateSequenceUtil.generateSequenceNo());
						docPatShuttleTransferDao.insert(patShuttleTransfer);

						// 创建手术风险评估单
						DocOptRiskEvaluation optRiskEvaluatio = new DocOptRiskEvaluation();
						optRiskEvaluatio.setRegOptId(idsList.get(i));
						optRiskEvaluatio.setOptRiskEvaluationId(GenerateSequenceUtil.generateSequenceNo());
						optRiskEvaluatio.setProcessState("NO_END");
						// 局麻时直接设置状态为完成
						if ("1".equals(regOpt.getIsLocalAnaes())) {
							optRiskEvaluatio.setProcessState("END");
						}
						optRiskEvaluatio.setFlag("1");
						docOptRiskEvaluationDao.insert(optRiskEvaluatio);

						// 创建麻醉记录单
						DocAnaesRecord anaesRecord = new DocAnaesRecord();
						anaesRecord.setAnaRecordId(GenerateSequenceUtil.generateSequenceNo());
						anaesRecord.setOther("O2L/min");
						anaesRecord.setProcessState("NO_END");
						anaesRecord.setRegOptId(idsList.get(i));
						docAnaesRecordDao.insert(anaesRecord);

						// 麻醉总结单
						DocAnaesSummary anaesSummary = new DocAnaesSummary();
						anaesSummary.setRegOptId(idsList.get(i));
						anaesSummary.setProcessState("NO_END");
						anaesSummary.setAnaSumId(GenerateSequenceUtil.generateSequenceNo());
						docAnaesSummaryDao.insert(anaesSummary);
						// 椎管内麻醉
						DocAnaesSummaryAppendixCanal anaesSummaryAppendixCanal = new DocAnaesSummaryAppendixCanal();
						anaesSummaryAppendixCanal.setAnaSumId(anaesSummary.getAnaSumId());
						anaesSummaryAppendixCanal.setAnaSumAppCanId(GenerateSequenceUtil.generateSequenceNo());
						docAnaesSummaryAppendixCanalDao.insert(anaesSummaryAppendixCanal);
						// 全麻
						DocAnaesSummaryAppendixGen anaesSummaryAppendixGen = new DocAnaesSummaryAppendixGen();
						anaesSummaryAppendixGen.setAnaSumId(anaesSummary.getAnaSumId());
						anaesSummaryAppendixGen.setAnaSumAppGenId(GenerateSequenceUtil.generateSequenceNo());
						docAnaesSummaryAppendixGenDao.insert(anaesSummaryAppendixGen);
						// 术后访视
						DocAnaesSummaryAppendixVisit anaesSummaryAppendixVisit = new DocAnaesSummaryAppendixVisit();
						anaesSummaryAppendixVisit.setAnaSumId(anaesSummary.getAnaSumId());
						anaesSummaryAppendixVisit.setAnesSumVisId(GenerateSequenceUtil.generateSequenceNo());
						docAnaesSummaryAppendixVisitDao.insert(anaesSummaryAppendixVisit);
						// 并发症
						DocAnaesSummaryAllergicReaction anaesSummaryAllergicReaction = new DocAnaesSummaryAllergicReaction();
						anaesSummaryAllergicReaction.setAnaSumId(anaesSummary.getAnaSumId());
						anaesSummaryAllergicReaction.setAnaSumAllReaId(GenerateSequenceUtil.generateSequenceNo());
						docAnaesSummaryAllergicReactionDao.insert(anaesSummaryAllergicReaction);
						// 中心静脉穿刺
						DocAnaesSummaryVenipuncture anaesSummaryVenipuncture = new DocAnaesSummaryVenipuncture();
						anaesSummaryVenipuncture.setAnaSumId(anaesSummary.getAnaSumId());
						anaesSummaryVenipuncture.setAnesSumVenId(GenerateSequenceUtil.generateSequenceNo());
						docAnaesSummaryVenipunctureDao.insert(anaesSummaryVenipuncture);

						// 创建手术护理记录文书
						DocOptCareRecord optCareRecord = new DocOptCareRecord();
						optCareRecord.setRegOptId(idsList.get(i));
						optCareRecord.setId(GenerateSequenceUtil.generateSequenceNo());
						optCareRecord.setProcessState("NO_END");
						docOptCareRecordDao.insert(optCareRecord);

						// 创建手术清点记录
						DocOptNurse optNurse = new DocOptNurse();
						optNurse.setRegOptId(idsList.get(i));
						optNurse.setOptNurseId(GenerateSequenceUtil.generateSequenceNo());
						optNurse.setProcessState("NO_END");
						docOptNurseDao.insert(optNurse);

						// 创建手术核查单
						DocSafeCheck safeCheck = new DocSafeCheck();
						safeCheck.setRegOptId(idsList.get(i));
						safeCheck.setProcessState("NO_END");
						safeCheck.setSafCheckId(GenerateSequenceUtil.generateSequenceNo());
						docSafeCheckDao.insert(safeCheck);
						DocAnaesBeforeSafeCheck anaesBeforeSafeCheck = new DocAnaesBeforeSafeCheck();
						anaesBeforeSafeCheck.setRegOptId(idsList.get(i));
						anaesBeforeSafeCheck.setAnesBeforeId(GenerateSequenceUtil.generateSequenceNo());
						anaesBeforeSafeCheck.setProcessState("NO_END");
						docAnaesBeforeSafeCheckDao.insert(anaesBeforeSafeCheck);
						DocOperBeforeSafeCheck operBeforeSafeCheck = new DocOperBeforeSafeCheck();
						operBeforeSafeCheck.setRegOptId(idsList.get(i));
						operBeforeSafeCheck.setOperBeforeId(GenerateSequenceUtil.generateSequenceNo());
						operBeforeSafeCheck.setProcessState("NO_END");
						docOperBeforeSafeCheckDao.insert(operBeforeSafeCheck);
						DocExitOperSafeCheck exitOperSafeCheck = new DocExitOperSafeCheck();
						exitOperSafeCheck.setRegOptId(idsList.get(i));
						exitOperSafeCheck.setProcessState("NO_END");
						exitOperSafeCheck.setExitOperId(GenerateSequenceUtil.generateSequenceNo());
						docExitOperSafeCheckDao.insert(exitOperSafeCheck);

						// 术后随访记录单
						DocPostFollowRecord postFollowRecord = new DocPostFollowRecord();
						postFollowRecord.setRegOptId(idsList.get(i));
						postFollowRecord.setProcessState("NO_END");
						postFollowRecord.setPostFollowId(GenerateSequenceUtil.generateSequenceNo());
						docPostFollowRecordDao.insert(postFollowRecord);
						
						//参保患者特殊用药、卫材知情单
                        DocInsuredPatAgree insuredPatAgree = new DocInsuredPatAgree();
                        insuredPatAgree.setRegOptId(idsList.get(i));
                        insuredPatAgree.setProcessState("NO_END");
                        insuredPatAgree.setId(GenerateSequenceUtil.generateSequenceNo());
                        docInsuredPatAgreeDao.insert(insuredPatAgree);
                        
                        //手术病人转运交接记录单
                        DocTransferConnectRecord transferConnectRecord = new DocTransferConnectRecord();
                        transferConnectRecord.setRegOptId(idsList.get(i));
                        transferConnectRecord.setProcessState("NO_END");
                        transferConnectRecord.setId(GenerateSequenceUtil.generateSequenceNo());
                        docTransferConnectRecordDao.insert(transferConnectRecord);
                        
                        //胎盘处置知情同意书
                        DocPlacentaHandleAgree placentaHandleAgree = new DocPlacentaHandleAgree();
                        placentaHandleAgree.setRegOptId(idsList.get(i));
                        placentaHandleAgree.setProcessState("NO_END");
                        placentaHandleAgree.setId(GenerateSequenceUtil.generateSequenceNo());
                        docPlacentaHandleAgreeDao.insert(placentaHandleAgree);
                        
                        
                        

						// 在审核的时候 生成排程信息记录
						int dispatchCount = basDispatchDao.searchDistchByRegOptId(idsList.get(i));
						if (dispatchCount < 1) {
							BasDispatch dispatch = new BasDispatch();
							dispatch.setRegOptId(idsList.get(i));
							basDispatchDao.insert(dispatch);
						}

						succCnt++;
					}
				}
			}
		}

		if (idsList.size() - succCnt > 0) {
			int failCnt = idsList.size() - succCnt;
			respValue.setResultMessage("批量审核完成!其中成功" + succCnt + "条数据," + "失败" + failCnt + "条数据");
		}
	}

	public void saveParticipant(List<EvtParticipant> participantList) {
		String regOptId = "";
		if (participantList.size() > 0) {
			DocAnaesRecord anaesRecord = docAnaesRecordDao.searchAnaesRecordById(participantList.get(0).getDocId());
			regOptId = anaesRecord.getRegOptId();
		}

		// operlogService.saveOperatelog(regOptId,
		// operlogService.OPT_TYPE_INFO_SAVE,
		// operlogService.OPT_MODULE_OPER_RECORD,"手术人员保存",
		// JsonType.jsonType(participantList));

		if (participantList.size() > 0) {
			EvtParticipant part = participantList.get(0);

			evtParticipantDao.deleteByOperatorType(part);
			// 如果保存为麻醉医生这里需要特殊处理下
			if (part.getRole().equals("A")) {
				List<EvtParticipant> mainAnesDocList = evtParticipantDao.getMainDocList(part.getDocId(), part.getRole(), "01");
				for (EvtParticipant participant1 : participantList) {
					boolean flag = true;
					for (EvtParticipant participant : mainAnesDocList) {
						// 如果界面传入过来的麻醉医生列表的数据已经存在则不新增
						if (participant1.getUserLoginName().equals(participant.getUserLoginName())) {
							flag = false;
							break;
						}
					}
					if (flag) {
						if (StringUtils.isNotBlank(participant1.getUserLoginName())) {
							participant1.setPartpId(GenerateSequenceUtil.generateSequenceNo());
							evtParticipantDao.insert(participant1);
						}
					}
				}
			} else if (part.getRole().equals("O")) {
				List<EvtParticipant> mainOperateDocList = evtParticipantDao.getMainDocList(part.getDocId(), part.getRole(), "06");
				for (EvtParticipant participant1 : participantList) {
					boolean flag = true;
					for (EvtParticipant participant : mainOperateDocList) {
						// 如果界面传入过来的手术医生列表的数据已经存在则不新增
						if (participant1.getUserLoginName().equals(participant.getUserLoginName())) {
							flag = false;
							break;
						}
					}
					if (flag) {
						if (StringUtils.isNotBlank(participant1.getUserLoginName())) {
							participant1.setPartpId(GenerateSequenceUtil.generateSequenceNo());
							evtParticipantDao.insert(participant1);
						}
					}
				}
			} else {
				for (EvtParticipant participant : participantList) {
					if (StringUtils.isNotBlank(participant.getUserLoginName())) {
						participant.setPartpId(GenerateSequenceUtil.generateSequenceNo());
						evtParticipantDao.insert(participant);
					}
				}
			}
		}
	}
	
	/**
     * 根据条件查询未排班的的列表
     * @param baseQuery
     * @return
     */
    public List<SearchListScheduleFormBean> searchAllDispatchList(BaseInfoQuery baseQuery){
        if (StringUtils.isBlank(baseQuery.getBeid()))
        {
            baseQuery.setBeid(getBeid());
        }
        return basDispatchDao.searchAllDispatchList(baseQuery);
    }
}
