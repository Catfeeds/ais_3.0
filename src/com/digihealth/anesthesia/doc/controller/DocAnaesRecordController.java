/**     
 * @discription 在此输入一句话描述此文件的作用
 * @author liukui       
 * @created 2015-10-10 下午5:34:19    
 * tags     
 * see_to_target     
 */

package com.digihealth.anesthesia.doc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.digihealth.anesthesia.basedata.formbean.BaseInfoQuery;
import com.digihealth.anesthesia.basedata.formbean.DiagnosedefFormBean;
import com.digihealth.anesthesia.basedata.formbean.DispatchPeopleNameFormBean;
import com.digihealth.anesthesia.basedata.formbean.OperDefFormBean;
import com.digihealth.anesthesia.basedata.formbean.SysCodeFormbean;
import com.digihealth.anesthesia.basedata.po.BasOperationPeople;
import com.digihealth.anesthesia.basedata.po.BasRegOpt;
import com.digihealth.anesthesia.common.beanvalidator.ValidatorBean;
import com.digihealth.anesthesia.common.entity.ResponseValue;
import com.digihealth.anesthesia.common.utils.Exceptions;
import com.digihealth.anesthesia.common.utils.JsonType;
import com.digihealth.anesthesia.common.utils.StringUtils;
import com.digihealth.anesthesia.common.web.BaseController;
import com.digihealth.anesthesia.doc.formbean.SafeCheckFormBean;
import com.digihealth.anesthesia.doc.po.DocAccede;
import com.digihealth.anesthesia.doc.po.DocAnaesBeforeSafeCheck;
import com.digihealth.anesthesia.doc.po.DocAnaesRecord;
import com.digihealth.anesthesia.doc.po.DocExitOperSafeCheck;
import com.digihealth.anesthesia.doc.po.DocOperBeforeSafeCheck;
import com.digihealth.anesthesia.doc.po.DocPreVisit;
import com.digihealth.anesthesia.doc.po.DocSafeCheck;
import com.digihealth.anesthesia.evt.formbean.EvtAnaesMethodFormBean;
import com.digihealth.anesthesia.evt.formbean.OperBodyFormBean;
import com.digihealth.anesthesia.evt.formbean.RegOptOperEgressFormBean;
import com.digihealth.anesthesia.evt.formbean.RegOptOperIoeventFormBean;
import com.digihealth.anesthesia.evt.formbean.RegOptOperMedicaleventFormBean;
import com.digihealth.anesthesia.evt.formbean.SearchFormBean;
import com.digihealth.anesthesia.evt.formbean.SearchRegOptByIdFormBean;
import com.digihealth.anesthesia.evt.formbean.SearchSafeCheckRegOptFormBean;
import com.digihealth.anesthesia.evt.po.EvtAnaesEvent;
import com.digihealth.anesthesia.evt.po.EvtCtlBreath;
import com.digihealth.anesthesia.evt.po.EvtOptLatterDiag;
import com.digihealth.anesthesia.evt.po.EvtOptRealOper;
import com.digihealth.anesthesia.evt.po.EvtOtherEvent;
import com.digihealth.anesthesia.evt.po.EvtParticipant;
import com.digihealth.anesthesia.evt.po.EvtRealAnaesMethod;
import com.digihealth.anesthesia.evt.po.EvtRescueevent;
import com.digihealth.anesthesia.evt.po.EvtShiftChange;
import com.digihealth.anesthesia.evt.service.EvtParticipantService;
import com.digihealth.anesthesia.operProceed.formbean.BasAnaesMonitorConfigFormBean;
import com.digihealth.anesthesia.operProceed.formbean.MonitorDataFormBean;
import com.digihealth.anesthesia.operProceed.po.BasMonitorConfig;
import com.digihealth.anesthesia.sysMng.formbean.UserInfoFormBean;
import com.digihealth.anesthesia.sysMng.po.BasUser;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

/**
 * Title: AnaesRecordController.java Description: 描述
 * 
 * @author liukui
 * @created 2015-10-10 下午5:34:19
 */
@Controller
@RequestMapping(value = "/document")
@Api(value = "DocAnaesRecordController", description = "麻醉记录单处理类")
public class DocAnaesRecordController extends BaseController {

	/**
	 * 
	 * @discription 根据手术ID获取麻醉记录单
	 * @author liukui
	 * @created 2015-10-10 下午5:13:48
	 * @param regOptId
	 * @return
	 */
	@RequestMapping(value = "/searchAnaesRecordByRegOptId")
	@ResponseBody
	@ApiOperation(value = "根据手术ID获取麻醉记录单", httpMethod = "POST", notes = "根据手术ID获取麻醉记录单")
	public String searchAnaesRecordByRegOptId(@ApiParam(name = "record", value = "查询参数") @RequestBody DocAnaesRecord record) {
		logger.info("-------------------begin searchAnaesRecordByRegOptId-------------------");
		ResponseValue resp = new ResponseValue();
		DocAnaesRecord anaesRecord = docAnaesRecordService.searchAnaesRecordByRegOptId(record.getRegOptId());
		resp.put("anaesRecord", anaesRecord);
		resp.setResultCode("1");
		resp.setResultMessage("获取麻醉记录单信息成功!");
		logger.info("-------------------end searchAnaesRecordByRegOptId-------------------");
		return resp.getJsonStr();
	}

	/**
	 * 
	 * @discription 根据手术ID获取麻醉记录单
	 * @author liukui
	 * @created 2015-10-10 下午5:13:48
	 * @param regOptId
	 * @return
	 */
	@RequestMapping(value = "/searchAnaesRecordById")
	@ResponseBody
	@ApiOperation(value = "根据手术ID获取麻醉记录单", httpMethod = "POST", notes = "根据手术ID获取麻醉记录单")
	public String searchAnaesRecordById(@ApiParam(name = "record", value = "查询参数") @RequestBody DocAnaesRecord record) {
		logger.info("------------------------begin searchAnaesRecordById------------------------");
		ResponseValue resp = new ResponseValue();
		DocAnaesRecord anaesRecord = docAnaesRecordService.searchAnaesRecordById(record.getAnaRecordId());
		resp.put("anaesRecord", anaesRecord);
		resp.setResultCode("1");
		resp.setResultMessage("获取麻醉记录单信息成功!");
		logger.info("------------------------end searchAnaesRecordById------------------------");
		return resp.getJsonStr();
	}

	@RequestMapping("/updatefievt")
	@ResponseBody
	@ApiOperation(value = "修改麻醉记录单信息", httpMethod = "POST", notes = "修改麻醉记录单信息")
	public String updatefievt(@ApiParam(name = "record", value = "修改参数") @RequestBody DocAnaesRecord record) {
		logger.info("----------------start updatefievt------------------------");
		ResponseValue resp = new ResponseValue();
		docAnaesRecordService.updatefievt(record);
		resp.setResultCode("1");
		resp.setResultMessage("操作成功");
		logger.info("------------------end updatefievt------------------------");
		return resp.getJsonStr();
	}

	/**
	 * 
	 * @discription 修改手术护理
	 * @author liukui
	 * @created 2015-10-20 上午9:33:40
	 * @param docId
	 * @return
	 */
	@RequestMapping(value = "/updateAnaesRecord")
	@ResponseBody
	@ApiOperation(value = "修改手术护理", httpMethod = "POST", notes = "修改手术护理")
	public String updateAnaesRecord(@ApiParam(name = "anaesRecord", value = "修改参数") @RequestBody DocAnaesRecord anaesRecord) {
		logger.info("----------------------begin updateAnaesRecord----------------------");
		ResponseValue resp = new ResponseValue();
		ValidatorBean validatorBean = beanValidator(anaesRecord);
		if (!(validatorBean.isValidator())) {
			resp.setResultCode("10000001");
			resp.setResultMessage(validatorBean.getMessage());
			return resp.getJsonStr();
		}
		docAnaesRecordService.changeAnaesRecordState(anaesRecord);
		resp.setResultCode("1");
		resp.setResultMessage("麻醉记录单修改成功!");
		logger.info("----------------------end updateAnaesRecord----------------------");
		return resp.getJsonStr();
	}

	/**
	 * 
	 * @discription 根据病人id获取麻醉记录单上相关信息
	 * @author liukui
	 * @created 2015-10-14 下午4:23:28
	 * @param id
	 * @return Map
	 */
	@RequestMapping(value = "/printDocumentByRegOptId")
	@ResponseBody
	@ApiOperation(value = "根据病人id获取麻醉记录单上相关信息", httpMethod = "POST", notes = "根据病人id获取麻醉记录单上相关信息")
	public String printDocumentByRegOptId(@ApiParam(name = "map", value = "查询参数") @RequestBody Map map) {
		logger.info("----------------------begin printDocumentByRegOptId----------------------");
		ResponseValue resp = new ResponseValue();
		Map result = new HashMap();

		String regOptId = map.get("regOptId").toString();
		String docLs = map.get("docStr").toString();

		Map<String, Map> rec = new HashMap<String, Map>();

		try {

			DocAnaesRecord anaesRecord = docAnaesRecordService.searchAnaesRecordByRegOptId(regOptId);

			SearchFormBean searchBean = new SearchFormBean();
			// 设置文书ID
			searchBean.setDocId(anaesRecord.getAnaRecordId());
			// 手术信息表
			BasRegOpt opt = basRegOptService.searchRegOptById(anaesRecord.getRegOptId());

			/**
			 * 麻醉记录单
			 */
			if (docLs.contains("doc_anaes_record")) {

				// 麻醉事件
				List<EvtAnaesEvent> anaeseventList = evtAnaesEventService.searchAnaeseventList(searchBean);
				// 实际麻醉方法
				List<EvtAnaesMethodFormBean> realAnaesList = evtRealAnaesMethodService.getSelectRealAnaesMethodList(searchBean);
				// 术后诊断
				List<DiagnosedefFormBean> optLatterDiagList = evtOptLatterDiagService.getSelectOptLatterDiagList(searchBean);
				// 实施手术
				List<OperDefFormBean> optRealOperList = evtOptRealOperService.getSelectOptRealOperList(searchBean);
				// 麻醉医生列表
				searchBean.setRole(EvtParticipantService.ROLE_ANESTH);
				List<UserInfoFormBean> anesDocList = evtParticipantService.getSelectParticipantList(searchBean);

				// 手术医生列表
				searchBean.setRole(EvtParticipantService.ROLE_OPERAT);
				List<UserInfoFormBean> operatDocList = evtParticipantService.getSelectParticipantList(searchBean);

				// 巡回护士列表
				searchBean.setRole(EvtParticipantService.ROLE_NURSE);
				searchBean.setType(EvtParticipantService.OPER_TYPE_TOUR);// 05
				List<UserInfoFormBean> nurseList = evtParticipantService.getSelectParticipantList(searchBean);

				// 器械护士列表
				searchBean.setRole(EvtParticipantService.ROLE_NURSE);
				searchBean.setType(EvtParticipantService.OPER_TYPE_INSTRUMENT);// 04
				List<UserInfoFormBean> instruNurseList = evtParticipantService.getSelectParticipantList(searchBean);

				// 麻醉药事件明细 麻醉前用药
				searchBean.setType("02");
				List<RegOptOperMedicaleventFormBean> anaesMedEvtList = evtMedicaleventService.searchMedicaleventGroupByCodeList(searchBean);

				// 治疗药事件明细 用药
				searchBean.setType("01");
				List<RegOptOperMedicaleventFormBean> treatMedEvtList = evtMedicaleventService.searchMedicaleventGroupByCodeList(searchBean);

				// 入药量事件
				List<RegOptOperIoeventFormBean> inIoeventList = evtInEventService.searchIoeventGroupByDefIdList(searchBean);

				// 出药量事件
				List<RegOptOperEgressFormBean> egressList = evtEgressService.searchEgressGroupByDefIdList(searchBean);

				// 手术体位变更
				List<OperBodyFormBean> operBodyList = evtOperBodyEventService.queryOperBodyEventList(searchBean);

				// 术中监测显示项
				BaseInfoQuery baseQuery = new BaseInfoQuery();
				baseQuery.setRegOptId(searchBean.getRegOptId());
				baseQuery.setEnable("1");
				baseQuery.setPosition("0");
				List<BasAnaesMonitorConfigFormBean> showList = basAnaesMonitorConfigService.finaAnaesList(baseQuery);

				// 左侧采集项显示
				baseQuery.setPosition("1");
				List<BasAnaesMonitorConfigFormBean> leftShowList = basAnaesMonitorConfigService.finaAnaesList(baseQuery);

				// 安全核查单
				DocAnaesBeforeSafeCheck anaesBeforeSafeCheck = docAnaesBeforeSafeCheckService.searchAnaBeCheckByRegOptId(opt.getRegOptId());
				DocExitOperSafeCheck exitOperSafeCheck = docExitOperSafeCheckService.searchExitOperCheckByRegOptId(opt.getRegOptId());
				DocOperBeforeSafeCheck operBeforeSafeCheck = docOperBeforeSafeCheckService.searchOperBeCheckByRegOptId(opt.getRegOptId());

				// 去除O2
				List<BasMonitorConfig> monitorConfigList = basMonitorConfigService.selectMustShowListWithoutO2();
				// 其他事件
				List<EvtOtherEvent> othereventList = evtOtherEventService.searchOthereventList(searchBean);
				// 呼吸事件
				List<EvtCtlBreath> ctlBreathList = evtCtlBreathService.searchCtlBreathList(searchBean);
				// 抢救事件
				List<EvtRescueevent> rescueeventList = evtRescueeventService.searchRescueeventList(searchBean);
				// 交接班
				List<EvtShiftChange> shiftChangeList = evtShiftChangeService.searchShiftChangeList(searchBean);
				// 检查事件
				// List<CheckeventItemRelation> checkeventList =
				// checkeventItemRelationService.serarchCheckevent(searchBean);
				// asa分级
				List<SysCodeFormbean> asaList = basSysCodeService.searchSysCodeByGroupId("asa_level", (String) map.get("beid"));
				// 麻醉分级
				List<SysCodeFormbean> anesLevelList = basSysCodeService.searchSysCodeByGroupId("anaes_level", (String) map.get("beid"));
				// 手术体位
				List<SysCodeFormbean> optBodyList = basSysCodeService.searchSysCodeByGroupId("opt_body", (String) map.get("beid"));
				// 出室去向
				List<SysCodeFormbean> leaveToList = basSysCodeService.searchSysCodeByGroupId("leave_to", (String) map.get("beid"));

				// 生命体征数据查询
				MonitorDataFormBean formBean = new MonitorDataFormBean();
				formBean.setRegOptId(regOptId);
				formBean.setSize(Integer.parseInt(map.get("size").toString()));
				basMonitorDisplayService.printObserveData(formBean, result);

				resp.put("resultCode", "1");
				resp.put("resultMessage", "查询麻醉记录单成功!!!");
				resp.put("regOpt", opt);
				resp.put("anaesBeforeSafeCheck", anaesBeforeSafeCheck.getProcessState());
				resp.put("exitOperSafeCheck", exitOperSafeCheck.getProcessState());
				resp.put("operBeforeSafeCheck", operBeforeSafeCheck.getProcessState());
				resp.put("anaesRecord", anaesRecord);
				resp.put("anaesMedEvtList", anaesMedEvtList);
				resp.put("treatMedEvtList", treatMedEvtList);
				resp.put("realAnaesList", realAnaesList);
				resp.put("optLatterDiagList", optLatterDiagList);
				resp.put("optRealOperList", optRealOperList);
				resp.put("anaeseventList", anaeseventList);
				resp.put("inIoeventList", inIoeventList);
				resp.put("outIoeventList", egressList);
				resp.put("anesDocList", anesDocList);
				resp.put("operatDocList", operatDocList);
				resp.put("nurseList", nurseList);
				resp.put("instruNurseList", instruNurseList);
				resp.put("operBodyList", operBodyList);
				resp.put("showList", showList);
				resp.put("leftShowList", leftShowList);
				resp.put("monitorConfigList", monitorConfigList);
				resp.put("othereventList", othereventList);
				resp.put("ctlBreathList", ctlBreathList);
				resp.put("rescueeventList", rescueeventList);
				resp.put("shiftChangeList", shiftChangeList);
				// resp.put("checkeventList", checkeventList);
				resp.put("asaList", asaList);
				resp.put("anesLevelList", anesLevelList);
				resp.put("optBodyList", optBodyList);
				resp.put("leaveToList", leaveToList);

				rec.put("anesDoc", result);
			}

			/**
			 * 自控记录单
			 */
			if (docLs.contains("doc_analgesic_record")) {
				Map resp1 = new HashMap();

				// 实施手术
				List<EvtOptRealOper> optRealOperList = evtOptRealOperService.searchOptRealOperList(searchBean);
				String optRealOperStr = "";
				for (EvtOptRealOper optRealOper : optRealOperList) {
					optRealOperStr += optRealOper.getName() + ",";
				}
				if (StringUtils.isNotBlank(optRealOperStr)) {
					optRealOperStr = optRealOperStr.substring(0, optRealOperStr.length() - 1);
				}

				// 实际麻醉方法
				List<EvtRealAnaesMethod> realAnaesList = evtRealAnaesMethodService.searchRealAnaesMethodList(searchBean);
				String realAnaesStr = "";
				for (EvtRealAnaesMethod realAnaesMethod : realAnaesList) {
					realAnaesStr += realAnaesMethod.getName() + ",";
				}
				if (StringUtils.isNotBlank(realAnaesStr)) {
					realAnaesStr = realAnaesStr.substring(0, realAnaesStr.length() - 1);
				}

				// 获取病人基本信息
				resp1.put("regOpt", basRegOptService.getPostopOptInfo(regOptId));
				resp1.put("analgesicRecord", docAnalgesicRecordService.getAnalgesicRecord(regOptId));
				resp1.put("optRealOperStr", optRealOperStr);
				resp1.put("realAnaesStr", realAnaesStr);

				rec.put("anesAnalgesDoc", resp1);
			}

			/**
			 * 安全核查单
			 */
			if (docLs.contains("doc_safe_check")) {
				Map safe = new HashMap();

				DocSafeCheck safeCheck = docSafeCheckService.searchSafeCheckByRegOptId(regOptId);
				BasUser safeCheckUser = basUserService.get(safeCheck.getCircunurseId() != null ? safeCheck.getCircunurseId() : "", getBeid());
				if (safeCheckUser != null) {
					safeCheck.setCircunurseName(safeCheckUser.getName());
				}

				SearchSafeCheckRegOptFormBean searchRegOptByIdFormBean = basRegOptService.searchSafeCheckRegOptById(regOptId);
				SafeCheckFormBean bean = new SafeCheckFormBean();
				bean.setAge(searchRegOptByIdFormBean.getAge());
				bean.setBed(searchRegOptByIdFormBean.getBed());
				bean.setDeptName(searchRegOptByIdFormBean.getDeptName());
				bean.setDesignedAnaesMethodName(searchRegOptByIdFormBean.getDesignedAnaesMethodName());
				bean.setDesignedOptName(searchRegOptByIdFormBean.getDesignedOptName());
				bean.setDiagnosisName(searchRegOptByIdFormBean.getDiagnosisName());
				bean.setHid(searchRegOptByIdFormBean.getHid());
				bean.setName(searchRegOptByIdFormBean.getName());
				bean.setOperaDate(searchRegOptByIdFormBean.getOperaDate());
				bean.setRegionName(searchRegOptByIdFormBean.getRegionName());
				bean.setRegOptId(searchRegOptByIdFormBean.getRegOptId());
				bean.setSex(searchRegOptByIdFormBean.getSex());

				List<EvtRealAnaesMethod> realAnaMdList = evtRealAnaesMethodService.searchRealAnaesMethodList(searchBean);
				searchBean.setRole("A");
				List<EvtParticipant> anaesDocList = evtParticipantService.searchParticipantList(searchBean);
				bean.setAnesthetistName("");
				if (anaesDocList != null && anaesDocList.size() > 0) {
					for (int i = 0; i < anaesDocList.size(); i++) {
						BasUser user = basUserService.searchUserById(anaesDocList.get(i).getUserLoginName(), getBeid());
						bean.setAnesthetistName(bean.getAnesthetistName() + user.getName() + ",");
					}
				}

				if (!StringUtils.isEmpty(bean.getAnesthetistName())) {
					bean.setAnesthetistName(bean.getAnesthetistName().substring(0, bean.getAnesthetistName().length() - 1));
				}

				searchBean.setRole("N");
				List<EvtParticipant> nurseDocList = evtParticipantService.searchParticipantList(searchBean);
				bean.setNurseName("");
				if (nurseDocList != null && nurseDocList.size() > 0) {
					for (int i = 0; i < nurseDocList.size(); i++) {
						BasUser user = basUserService.searchUserById(nurseDocList.get(i).getUserLoginName(), getBeid());
						bean.setNurseName(bean.getNurseName() + user.getName() + ",");
					}
				}

				if (!StringUtils.isEmpty(bean.getNurseName())) {
					bean.setNurseName(bean.getNurseName().substring(0, bean.getNurseName().length() - 1));
				}

				searchBean.setRole("O");
				List<EvtParticipant> operList = evtParticipantService.searchParticipantList(searchBean);
				bean.setOperatorName("");
				if (operList != null && operList.size() > 0) {
					for (int i = 0; i < operList.size(); i++) {
						BasOperationPeople resultDept = basOperationPeopleService.queryOperationPeopleById(operList.get(i).getUserLoginName());
						bean.setOperatorName(bean.getOperatorName() + resultDept.getName() + ",");
					}
				}

				if (!StringUtils.isEmpty(bean.getOperatorName())) {
					bean.setOperatorName(bean.getOperatorName().substring(0, bean.getOperatorName().length() - 1));
				}
				bean.setRealDesignedAnaesMethodName("");
				if (realAnaMdList.size() > 0 && realAnaMdList != null) {
					for (int i = 0; i < realAnaMdList.size(); i++) {
						bean.setRealDesignedAnaesMethodName(bean.getRealDesignedAnaesMethodName() == null ? realAnaMdList.get(i).getName() + "," : bean.getRealDesignedAnaesMethodName() + realAnaMdList.get(i).getName() + ",");
					}
				}

				if (!StringUtils.isEmpty(bean.getRealDesignedAnaesMethodName())) {
					bean.setRealDesignedAnaesMethodName(bean.getRealDesignedAnaesMethodName().substring(0, bean.getRealDesignedAnaesMethodName().length() - 1));
				}

				List<EvtOptLatterDiag> optLDList = evtOptLatterDiagService.searchOptLatterDiagList(searchBean);
				bean.setRealDiagnosisName("");
				if (optLDList.size() > 0 && optLDList != null) {
					for (int i = 0; i < optLDList.size(); i++) {
						bean.setRealDiagnosisName(bean.getRealDiagnosisName() == null ? optLDList.get(i).getName() + "," : bean.getRealDiagnosisName() + optLDList.get(i).getName() + ",");
					}
				}

				if (!StringUtils.isEmpty(bean.getRealDiagnosisName())) {
					bean.setRealDiagnosisName(bean.getRealDiagnosisName().substring(0, bean.getRealDiagnosisName().length() - 1));
				}

				List<EvtOptRealOper> optROList = evtOptRealOperService.searchOptRealOperList(searchBean);
				bean.setRealDesignedOptName("");
				if (optROList.size() > 0 && optROList != null) {
					for (int i = 0; i < optROList.size(); i++) {
						bean.setRealDesignedOptName(bean.getRealDesignedOptName() == null ? optROList.get(i).getName() + "," : bean.getRealDesignedOptName() + optROList.get(i).getName() + ",");
					}
				}
				if (!StringUtils.isEmpty(bean.getRealDesignedOptName())) {
					bean.setRealDesignedOptName(bean.getRealDesignedOptName().substring(0, bean.getRealDesignedOptName().length() - 1));
				}

				DocAnaesBeforeSafeCheck anaesBeforeSafeCheck = docAnaesBeforeSafeCheckService.searchAnaBeCheckByRegOptId(regOptId);
				BasUser anaesBeforeSafeCheckA = basUserService.get(anaesBeforeSafeCheck.getAnesthetistId() != null ? anaesBeforeSafeCheck.getAnesthetistId() : "", getBeid());
				if (anaesBeforeSafeCheckA != null) {
					anaesBeforeSafeCheck.setAnesthetistName(anaesBeforeSafeCheckA.getName());
				}
				BasUser anaesBeforeSafeCheckO = basUserService.get(anaesBeforeSafeCheck.getOperatorId() != null ? anaesBeforeSafeCheck.getOperatorId() : "", getBeid());
				if (anaesBeforeSafeCheckO != null) {
					anaesBeforeSafeCheck.setOperatorName(anaesBeforeSafeCheckO.getName());
				}
				BasUser anaesBeforeSafeCheckC = basUserService.get(anaesBeforeSafeCheck.getCircuNurseId() != null ? anaesBeforeSafeCheck.getOperatorId() : "", getBeid());
				if (anaesBeforeSafeCheckC != null) {
					anaesBeforeSafeCheck.setCircunurseName(anaesBeforeSafeCheckC.getName());
				}
				DocOperBeforeSafeCheck operBeforeSafeCheck = docOperBeforeSafeCheckService.searchOperBeCheckByRegOptId(regOptId);
				BasUser operBeforeSafeCheckA = basUserService.get(operBeforeSafeCheck.getAnesthetistId() != null ? operBeforeSafeCheck.getAnesthetistId() : "", getBeid());
				if (operBeforeSafeCheckA != null) {
					operBeforeSafeCheck.setAnesthetistName(operBeforeSafeCheckA.getName());
				}
				BasUser operBeforeSafeCheckO = basUserService.get(operBeforeSafeCheck.getOperatorId() != null ? operBeforeSafeCheck.getOperatorId() : "", getBeid());
				if (operBeforeSafeCheckO != null) {
					operBeforeSafeCheck.setOperatorName(operBeforeSafeCheckO.getName());
				}
				BasUser operBeforeSafeCheckC = basUserService.get(operBeforeSafeCheck.getCircuNurseId() != null ? operBeforeSafeCheck.getCircuNurseId() : "", getBeid());
				if (operBeforeSafeCheckC != null) {
					operBeforeSafeCheck.setCircunurseName(operBeforeSafeCheckC.getName());
				}
				DocExitOperSafeCheck exitOperSafeCheck = docExitOperSafeCheckService.searchExitOperCheckByRegOptId(regOptId);
				BasUser exitOperSafeCheckA = basUserService.get(exitOperSafeCheck.getAnesthetistId() != null ? exitOperSafeCheck.getAnesthetistId() : "", getBeid());
				if (exitOperSafeCheckA != null) {
					exitOperSafeCheck.setAnesthetistName(exitOperSafeCheckA.getName());
				}
				BasUser exitOperSafeCheckO = basUserService.get(exitOperSafeCheck.getOperatorId() != null ? exitOperSafeCheck.getOperatorId() : "", getBeid());
				if (exitOperSafeCheckO != null) {
					exitOperSafeCheck.setOperatorName(exitOperSafeCheckO.getName());
				}
				BasUser exitOperSafeCheckC = basUserService.get(exitOperSafeCheck.getCircuNurseId() != null ? exitOperSafeCheck.getCircuNurseId() : "", getBeid());
				if (exitOperSafeCheckC != null) {
					exitOperSafeCheck.setCircunurseName(exitOperSafeCheckC.getName());
				}
				safe.put("safeCheck", safeCheck);
				safe.put("safeCheckFormBean", bean);
				safe.put("anaesBeforeSafeCheck", anaesBeforeSafeCheck);
				safe.put("operBeforeSafeCheck", operBeforeSafeCheck);
				safe.put("exitOperSafeCheck", exitOperSafeCheck);

				rec.put("safeDoc", safe);
			}

			/**
			 * 麻醉总结单
			 */
			if (docLs.contains("doc_anaes_summary")) {
				Map summary = new HashMap();
				// 麻醉总结数据
				summary.put("anaesSummaryFormbean", docAnaesSummaryService.getAnaesSummaryDetail(regOptId));
				summary.put("regOpt", opt);

				// 出入量数据
				docAnaesSummaryService.getAmountDetail(summary, anaesRecord.getAnaRecordId());
				// 血型
				String blood = evtInEventService.getBloodByDocId(anaesRecord.getAnaRecordId());
				summary.put("blood", blood);

				rec.put("summaryDoc", summary);
			}

			/**
			 * 术前访视单
			 */
			if (docLs.contains("doc_pre_visit")) {
				Map preVisitMap = new HashMap();

				DocPreVisit preVisit = docPreVisitService.searchPreVisitByRegOptId(regOptId);

				// 获取到麻醉医生名字
				DispatchPeopleNameFormBean dispatchPeople = basDispatchService.searchPeopleNameByRegOptId(map.get("regOptId").toString());
				if (dispatchPeople != null) {
					preVisit.setAnaestheitistName(dispatchPeople.getAnesthetistName() != null ? dispatchPeople.getAnesthetistName() : "");
				}

				// 获取手术基本信息
				List<SearchRegOptByIdFormBean> searchRegOptById = basRegOptService.searchApplicationById(map.get("regOptId").toString());

				if (null == preVisit.getDesignedAnaes() || "".equals(preVisit.getDesignedAnaes())) {
					if (null != searchRegOptById && searchRegOptById.size() > 0 && null != searchRegOptById.get(0)) {
						preVisit.setDesignedAnaes(searchRegOptById.get(0).getDesignedAnaesMethodName());
					}
				}

				// 设置页面选择框的值
				setMapValue(preVisit);
				preVisitMap.put("preVisitItem", preVisit);
				preVisitMap.put("regOptItem", searchRegOptById != null ? searchRegOptById.get(0) : null);

				rec.put("preVisitDoc", preVisitMap);
			}

			/**
			 * 麻醉同意书
			 */
			if (docLs.contains("doc_accede")) {
				Map accedeMap = new HashMap();

				DocAccede accede = docAccedeService.searchAccedeByRegOptId(regOptId);

				if (null == accede.getAnaseMethod() || "".equals(accede.getAnaseMethod())) {
					// 麻醉方法从术前访视单中获取
					DocPreVisit preVisit = docPreVisitService.searchPreVisitByRegOptId(regOptId);
					if (null != preVisit) {
						accede.setAnaseMethod(preVisit.getDesignedAnaes());
					}
				}

				DispatchPeopleNameFormBean dispatchPeople = basDispatchService.searchPeopleNameByRegOptId(map.get("regOptId") != null ? map.get("regOptId").toString() : "");
				if (dispatchPeople != null) {
					accede.setAnaestheitistName(dispatchPeople.getAnesthetistName() != null ? dispatchPeople.getAnesthetistName() : "");
				}

				List<SearchRegOptByIdFormBean> searchRegOptByIdFormBean = basRegOptService.searchApplicationById(map.get("regOptId").toString());

				accedeMap.put("accedeItem", accede);
				accedeMap.put("regOptItem", searchRegOptByIdFormBean != null ? searchRegOptByIdFormBean.get(0) : null);

				rec.put("accedeDoc", accedeMap);
			}

			return JsonType.jsonType(rec);
		} catch (Exception e) {
			if (logger.isErrorEnabled()) {
				logger.error(Exceptions.getStackTraceAsString(e));
			}
			result.put("resultCode", "10000000");
			result.put("resultMessage", "系统错误，请与系统管理员联系!");
		}
		logger.info("----------------------end printDocumentByRegOptId----------------------");
		return JsonType.jsonType(result);
	}

	private void setMapValue(DocPreVisit preVisit) {
		JSONObject jasonObject1 = JSONObject.fromObject(preVisit.getBriefHis());
		preVisit.setBriefHisMap((Map) jasonObject1);

		JSONObject jasonObject2 = JSONObject.fromObject(preVisit.getLungbreathCond());
		preVisit.setLungbreathCondMap((Map) jasonObject2);

		JSONObject jasonObject3 = JSONObject.fromObject(preVisit.getBrainNerve());
		preVisit.setBrainNerveMap((Map) jasonObject3);

		JSONObject jasonObject4 = JSONObject.fromObject(preVisit.getSpineLimb());
		preVisit.setSpineLimbMap((Map) jasonObject4);

		JSONObject jasonObject5 = JSONObject.fromObject(preVisit.getBlood());
		preVisit.setBloodMap((Map) jasonObject5);

		JSONObject jasonObject7 = JSONObject.fromObject(preVisit.getDigestion());
		preVisit.setDigestionMap((Map) jasonObject7);

		JSONObject jasonObject8 = JSONObject.fromObject(preVisit.getEndocrine());
		preVisit.setEndocrineMap((Map) jasonObject8);

		JSONObject jasonObject9 = JSONObject.fromObject(preVisit.getInfectious());
		preVisit.setInfectiousMap((Map) jasonObject9);

		JSONObject jasonObject10 = JSONObject.fromObject(preVisit.getAirwayManage());
		preVisit.setAirwayManageMap((Map) jasonObject10);

		JSONObject jasonObject11 = JSONObject.fromObject(preVisit.getSpecialHandle());
		preVisit.setSpecialHandleMap((Map) jasonObject11);

		JSONObject jasonObject12 = JSONObject.fromObject(preVisit.getAnalgesicCond());
		preVisit.setAnalgesicMap((Map) jasonObject12);

		JSONObject jasonObject13 = JSONObject.fromObject(preVisit.getMonitor());
		preVisit.setMonitorMap((Map) jasonObject13);

		JSONObject jasonObject14 = JSONObject.fromObject(preVisit.getHeartBoolCond());
		preVisit.setHeartBoolCondMap((Map) jasonObject14);

		JSONObject jasonObject15 = JSONObject.fromObject(preVisit.getToothAbnormalCond());
		preVisit.setToothAbnormalMap((Map) jasonObject15);

		JSONObject jasonObject16 = JSONObject.fromObject(preVisit.getAssayAbnormalCond());
		preVisit.setAssayAbnormalMap((Map) jasonObject16);
	}
}
