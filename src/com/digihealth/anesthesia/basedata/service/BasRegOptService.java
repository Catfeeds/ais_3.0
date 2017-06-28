package com.digihealth.anesthesia.basedata.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.digihealth.anesthesia.basedata.config.OperationState;
import com.digihealth.anesthesia.basedata.formbean.AnaesMethodFormBean;
import com.digihealth.anesthesia.basedata.formbean.BaseInfoQuery;
import com.digihealth.anesthesia.basedata.formbean.DeptFormBean;
import com.digihealth.anesthesia.basedata.formbean.DesignedOptCodes;
import com.digihealth.anesthesia.basedata.formbean.DiagnosedefFormBean;
import com.digihealth.anesthesia.basedata.formbean.DiagnosisCodes;
import com.digihealth.anesthesia.basedata.formbean.DocStateArrayFormbean;
import com.digihealth.anesthesia.basedata.formbean.DocumentStateFormbean;
import com.digihealth.anesthesia.basedata.formbean.EmgencyOperationFormBean;
import com.digihealth.anesthesia.basedata.formbean.OneRegOptDocumentStateFormbean;
import com.digihealth.anesthesia.basedata.formbean.OperDefFormBean;
import com.digihealth.anesthesia.basedata.formbean.OperPeopleFormBean;
import com.digihealth.anesthesia.basedata.formbean.SysCodeFormbean;
import com.digihealth.anesthesia.basedata.po.BasDept;
import com.digihealth.anesthesia.basedata.po.BasDiagnosedef;
import com.digihealth.anesthesia.basedata.po.BasDispatch;
import com.digihealth.anesthesia.basedata.po.BasDocument;
import com.digihealth.anesthesia.basedata.po.BasOperdef;
import com.digihealth.anesthesia.basedata.po.BasRegOpt;
import com.digihealth.anesthesia.basedata.po.BasRegion;
import com.digihealth.anesthesia.basedata.po.Controller;
import com.digihealth.anesthesia.basedata.utils.BasRegOptUtils;
import com.digihealth.anesthesia.basedata.utils.UserUtils;
import com.digihealth.anesthesia.common.entity.ResponseValue;
import com.digihealth.anesthesia.common.service.BaseService;
import com.digihealth.anesthesia.common.utils.DateUtils;
import com.digihealth.anesthesia.common.utils.GenerateSequenceUtil;
import com.digihealth.anesthesia.common.utils.JsonType;
import com.digihealth.anesthesia.common.utils.SysUtil;
import com.digihealth.anesthesia.doc.formbean.AnaesPacuRecFormBean;
import com.digihealth.anesthesia.doc.po.DocAnaesRecord;
import com.digihealth.anesthesia.evt.formbean.CancleRegOptFormBean;
import com.digihealth.anesthesia.evt.formbean.Filter;
import com.digihealth.anesthesia.evt.formbean.SearchConditionFormBean;
import com.digihealth.anesthesia.evt.formbean.SearchFormBean;
import com.digihealth.anesthesia.evt.formbean.SearchMyOperationFormBean;
import com.digihealth.anesthesia.evt.formbean.SearchOperaPatrolRecordFormBean;
import com.digihealth.anesthesia.evt.formbean.SearchRegOptByIdFormBean;
import com.digihealth.anesthesia.evt.formbean.SearchRegOptByLoginNameAndStateFormBean;
import com.digihealth.anesthesia.evt.formbean.SearchRegOptByRoomIdAndOperDateAndStateFormBean;
import com.digihealth.anesthesia.evt.formbean.SearchSafeCheckRegOptFormBean;
import com.digihealth.anesthesia.evt.po.EvtAnaesEvent;
import com.digihealth.anesthesia.evt.po.EvtParticipant;
import com.digihealth.anesthesia.evt.po.EvtRescueevent;
import com.digihealth.anesthesia.evt.service.EvtAnaesEventService;
import com.digihealth.anesthesia.evt.service.EvtParticipantService;
import com.digihealth.anesthesia.operProceed.core.MyConstants;
import com.digihealth.anesthesia.operProceed.formbean.RegOptFormBean;
import com.digihealth.anesthesia.operProceed.formbean.SuspendFormBean;
import com.digihealth.anesthesia.sysMng.formbean.BasRoleFormBean;
import com.digihealth.anesthesia.sysMng.po.BasRole;
import com.digihealth.anesthesia.sysMng.po.BasUser;
import com.digihealth.anesthesia.websocket.WebSocketHandler;

@Service
public class BasRegOptService extends BaseService {

	// public static final String ANAESMETHODJM = "局麻";

	public static final Integer ISLOCALANAES_Y = 1; // 局麻
	public static final Integer ISLOCALANAES_N = 0; // 全麻

	public List<SearchMyOperationFormBean> searchNoScheduling(SearchConditionFormBean searchConditionFormBean) {
		searchConditionFormBean.setState("02");
		if (StringUtils.isEmpty(searchConditionFormBean.getSort())) {
			searchConditionFormBean.setSort("operaDate");
		}
		if (StringUtils.isEmpty(searchConditionFormBean.getOrderBy())) {
			searchConditionFormBean.setOrderBy("DESC");
		}
		String beid = null;
		if (StringUtils.isBlank(searchConditionFormBean.getBeid())) {
			beid = getBeid();
			searchConditionFormBean.setBeid(beid);
		}else{
			beid = searchConditionFormBean.getBeid();
		}
		// String filter = " AND a.operaDate >='"+DateUtils.getDate()+"'";
		String filter = " ";
		return basRegOptDao.searchMyOperation(filter, "", "", searchConditionFormBean);
	}

	public List<SearchMyOperationFormBean> searchMyOperation(SearchConditionFormBean searchConditionFormBean) {
		searchConditionFormBean.setState("03,04,05,06");
		if (StringUtils.isEmpty(searchConditionFormBean.getSort())) {
			searchConditionFormBean.setSort("operaDate");
		}
		if (StringUtils.isEmpty(searchConditionFormBean.getOrderBy())) {
			searchConditionFormBean.setOrderBy("DESC");
		}
		String beid = null;
		if (StringUtils.isBlank(searchConditionFormBean.getBeid())) {
			beid = getBeid();
			searchConditionFormBean.setBeid(beid);
		}else{
			beid = searchConditionFormBean.getBeid();
		}

		String filter = " AND a.operaDate >='" + DateUtils.getDate() + "'";
		
		BasUser user = basUserDao.getByLoginName(searchConditionFormBean.getLoginName() != null ? searchConditionFormBean.getLoginName() : "", beid);

		return basRegOptDao.searchMyOperation(filter, user == null ? "" : user.getUserName(), user == null ? "" : user.getRoleType(), searchConditionFormBean);
	}

	public List<SearchMyOperationFormBean> searchTodayOperation(SearchConditionFormBean searchConditionFormBean) {
		searchConditionFormBean.setState("03,04,05,06");
		if (StringUtils.isEmpty(searchConditionFormBean.getSort())) {
			searchConditionFormBean.setSort("operaDate");
		}
		if (StringUtils.isEmpty(searchConditionFormBean.getOrderBy())) {
			searchConditionFormBean.setOrderBy("DESC");
		}
		String beid = null;
		if (StringUtils.isBlank(searchConditionFormBean.getBeid())) {
			beid = getBeid();
			searchConditionFormBean.setBeid(beid);
		}else{
			beid = searchConditionFormBean.getBeid();
		}
		String filter = " AND a.operaDate ='" + DateUtils.getDate() + "'";
		
		BasUser user = basUserDao.getByLoginName(searchConditionFormBean.getLoginName() != null ? searchConditionFormBean.getLoginName() : "", beid);

		return basRegOptDao.searchMyOperation(filter, "", user == null ? "" : user.getRoleType(), searchConditionFormBean);
	}

	/**
	 * 
	 * @discription 根据登录账号和手术状态获取人员列表信息
	 * @author chengwang
	 * @created 2015-10-9 上午10:29:34
	 * @param loginName
	 * @param statu
	 * @return
	 */
	public List<SearchRegOptByLoginNameAndStateFormBean> searchRegOptByAnaesDoctorAndState(SearchConditionFormBean searchConditionFormBean) {
		String state = searchConditionFormBean.getState();
		if (state != null) {
			searchConditionFormBean.setState(searchConditionFormBean.getState().replace(" ", ""));
		}
		if (StringUtils.isBlank(searchConditionFormBean.getSort())) {
			searchConditionFormBean.setSort("operaDate");
		}
		if (StringUtils.isBlank(searchConditionFormBean.getOrderBy())) {
			searchConditionFormBean.setOrderBy("DESC");
		}
		String beid = null;
		if (StringUtils.isBlank(searchConditionFormBean.getBeid())) {
			beid = getBeid();
			searchConditionFormBean.setBeid(beid);
		}else{
			beid = searchConditionFormBean.getBeid();
		}
		String filter = getFilterStr(searchConditionFormBean);
		BasUser user = basUserDao.getByLoginName(searchConditionFormBean.getLoginName() != null ? searchConditionFormBean.getLoginName() : "", beid);
		List<SearchRegOptByLoginNameAndStateFormBean> resultList = new ArrayList<SearchRegOptByLoginNameAndStateFormBean>();
		List<SearchRegOptByLoginNameAndStateFormBean> result = basRegOptDao.searchRegOptByAnaesDoctorAndState(filter, user == null ? "" : user.getUserName(), user == null ? "" : user.getRoleType(), searchConditionFormBean, beid);

		if (result != null && result.size() > 0) {

			String regOptStr = "";
			for (int i = 0; i < result.size(); i++) {
				regOptStr += "'" + result.get(i).getRegOptId() + "',";
			}
			regOptStr = regOptStr.substring(0, regOptStr.length() - 1);
			List<DocStateArrayFormbean> arrList = getDocumentState(user, searchConditionFormBean.getState(), regOptStr,beid);
			for (int i = 0; i < result.size(); i++) {
				SearchRegOptByLoginNameAndStateFormBean bean = result.get(i);
				String documentState = "完成";

				List<DocumentStateFormbean> stateFormbeanList = new ArrayList<DocumentStateFormbean>();
				for (DocStateArrayFormbean docStateArrayFormbean : arrList) {
					DocumentStateFormbean stateFormbean = new DocumentStateFormbean();
					List<DocumentStateFormbean> statList = docStateArrayFormbean.getDocStateList();
					for (DocumentStateFormbean documentStateFormbean : statList) {
						if (bean.getRegOptId().equals(documentStateFormbean.getRegOptId())) { //只把未完成的存入的stateFormbean中
							if (!"END".equals(documentStateFormbean.getState())) {
								if (1 == docStateArrayFormbean.getIsNeed()) { //1 必须完成  
									documentState = "未完成";
									stateFormbean.setState("未完成");
									stateFormbean.setName(docStateArrayFormbean.getDocName());
									stateFormbeanList.add(stateFormbean);
									break;
								}
							} /*else {
								stateFormbean.setState("完成");
							}*/
							
						}
					}
				}
				bean.setDocumentState(documentState);
				bean.setDocumentStateList(stateFormbeanList);
				resultList.add(bean);
			}

		}

		return resultList;
	}

	public int searchRegOptTotalByAnaesDoctorAndState(SearchConditionFormBean searchConditionFormBean) {
		if (StringUtils.isEmpty(searchConditionFormBean.getSort())) {
			searchConditionFormBean.setSort("operaDate");
		}
		if (StringUtils.isEmpty(searchConditionFormBean.getOrderBy())) {
			searchConditionFormBean.setOrderBy("DESC");
		}
		String beid = null;
		if (StringUtils.isBlank(searchConditionFormBean.getBeid())) {
			beid = getBeid();
			searchConditionFormBean.setBeid(beid);
		}else{
			beid = searchConditionFormBean.getBeid();
		}
		String filter = getFilterStr(searchConditionFormBean);
		BasUser user = basUserDao.getByLoginName(searchConditionFormBean.getLoginName() != null ? searchConditionFormBean.getLoginName() : "", beid);
		return basRegOptDao.searchRegoptTotalByAnaesDoctorAndState(filter, user == null ? "" : user.getUserName(), user == null ? "" : user.getRoleType(), searchConditionFormBean, beid);
	}

	/**
	 * 
	 * @discription 获取单个手术室即将进行手术的病人列表
	 * @author chengwang
	 * @created 2015-10-10 上午9:43:03
	 * @param roomId
	 * @param operDate
	 * @param state
	 * @return
	 */
	public List<SearchRegOptByRoomIdAndOperDateAndStateFormBean> searchRegOptByRoomIdAndOperDateAndState(String roomId, String operDate, List<String> state) {
		return basRegOptDao.searchRegOptByRoomIdAndOperDateAndState(roomId, operDate, state, getBeid());
	}

	/**
	 * 获取当前手术下当日的手术
	 * 
	 * @param roomId
	 * @param operDate
	 * @return
	 */
	public List<SearchRegOptByRoomIdAndOperDateAndStateFormBean> searchDayRegOpt(String roomId, String operDate) {
		return basRegOptDao.searchDayRegOpt(roomId, operDate, getBeid());
	}

	/**
	 * 获取当前麻醉医生或巡回护士1的下面的手术
	 * 
	 * @param roomId
	 * @param operDate
	 * @param loginName
	 * @return
	 */
	public List<SearchRegOptByRoomIdAndOperDateAndStateFormBean> searchCurUserRegOpt(String roomId, String operDate, String userId) {
		return basRegOptDao.searchCurUserRegOpt(roomId, operDate, userId, getBeid());
	}

	public AnaesPacuRecFormBean getPostopOptInfo(String regOptId) {
		return basRegOptDao.getPostopOptInfo(regOptId, getBeid());
	}

	public List<SearchRegOptByRoomIdAndOperDateAndStateFormBean> queryAllRegOpt(RegOptFormBean entity) {
		return basRegOptDao.queryAllRegOpt(entity, getBeid());
	}

	/**
	 * 
	 * @discription 根据ID获取regOpt
	 * @author chengwang
	 * @created 2015-10-10 下午5:47:31
	 * @param id
	 * @return
	 */
	public BasRegOpt searchRegOptById(String id) {
		BasRegOpt basRegOpt = basRegOptDao.searchRegOptById(id);
		if (basRegOpt != null) {
			BasDept basDept = new BasDept();
			basDept.setDeptId(String.valueOf(basRegOpt.getDeptId()));
			basDept.setName(basRegOpt.getDeptName());
			basRegOpt.setBasDept(basDept);

			BasRegion basRegion = new BasRegion();
			basRegion.setRegionId(String.valueOf(basRegOpt.getRegionId()));
			basRegion.setName(basRegOpt.getRegionName());
			basRegOpt.setBasRegion(basRegion);
			// 助手医生
			String assistantId = basRegOpt.getAssistantId();
			if (StringUtils.isNoneBlank(assistantId)) {
				List<String> codes = new ArrayList<String>();
				String[] assistantIds = assistantId.split(",");
				for (String code : assistantIds) {
					codes.add(code);
				}
				basRegOpt.setAssistants(codes);
			} else {
				basRegOpt.setAssistants(new ArrayList<String>());
			}
			// 麻醉方法
			String anaesMethodCode = basRegOpt.getDesignedAnaesMethodCode();
			if (StringUtils.isNoneBlank(anaesMethodCode)) {
				List<String> codes = new ArrayList<String>();
				String[] anaesMethodCodes = anaesMethodCode.split(",");
				for (String code : anaesMethodCodes) {
					codes.add(code);
				}
				basRegOpt.setDesignedAnaesMethodCodes(codes);
			} else {
				basRegOpt.setDesignedAnaesMethodCodes(new ArrayList<String>());
			}
			// 拟施手术
			List<DesignedOptCodes> designedOptCodeList = new ArrayList<DesignedOptCodes>();
			String designedOptCode = basRegOpt.getDesignedOptCode();
			if (StringUtils.isNoneBlank(designedOptCode)) 
			{
				String[] designedOptCodes = designedOptCode.split(",");
				for (String code : designedOptCodes)
				{
					DesignedOptCodes optCode = new DesignedOptCodes();
					optCode.setOperDefId(code);
					BasOperdef basOperdef = basOperdefDao.queryOperdefById(code);
					if(null != basOperdef)
					{
						optCode.setName(basOperdef.getName());
						optCode.setPinYin(basOperdef.getPinYin());
					}
					designedOptCodeList.add(optCode);
				}
				
			} 
			basRegOpt.setDesignedOptCodes(designedOptCodeList);
			
			
			// 拟施诊断
			List<DiagnosisCodes> diagnosisCodesList = new ArrayList<DiagnosisCodes>();
			String diagnosisCode = basRegOpt.getDiagnosisCode();
			if (StringUtils.isNoneBlank(diagnosisCode)) {
				String[] diagnosisCodes = diagnosisCode.split(",");
				for (String code : diagnosisCodes) {
					DiagnosisCodes dCode = new DiagnosisCodes();
					dCode.setDiagDefId(code);
					BasDiagnosedef basDiagnosedef = basDiagnosedefDao.searchDiagnosedefById(code);
					if (null != basDiagnosedef)
					{
						dCode.setName(basDiagnosedef.getName());
						dCode.setPinYin(basDiagnosedef.getPinYin());
					}
					diagnosisCodesList.add(dCode);
				}
				
			}
			basRegOpt.setDiagnosisCodes(diagnosisCodesList);

		}
		return basRegOpt;
	}

	/**
	 * 
	 * @discription 根据ID获取手术申请列表病人详细信息
	 * @author chengwang
	 * @created 2015-10-19 下午3:42:41
	 * @param id
	 * @return
	 */
	public List<SearchRegOptByIdFormBean> searchApplicationById(String id) {
		return basRegOptDao.searchApplicationById(id, getBeid());
	}

	/**
	 * 
	 * @discription 手术核查需要的基本信息
	 * @author chengwang
	 * @created 2015年10月28日 上午11:00:19
	 * @param id
	 * @return
	 */
	public SearchSafeCheckRegOptFormBean searchSafeCheckRegOptById(String id) {
		return basRegOptDao.searchSafeCheckRegOptById(id, getBeid());
	}

	/**
	 * 
	 * @discription 创建一条新手术信息
	 * @author chengwang
	 * @created 2015年10月30日 上午9:18:17
	 * @param regOpt
	 * @return
	 */
	@Transactional
	public String insertRegOpt(BasRegOpt regOpt) {
	    List<String> anaesMethodCodes = regOpt.getDesignedAnaesMethodCodes();
		String beid = regOpt.getBeid();
		if (StringUtils.isBlank(beid)) {
			beid = getBeid();
		}
		
		// 处理拟施手术、拟施诊断、麻醉方法等字段的值。
		BasRegOptUtils.getOtherInfo(regOpt);

		BasRegOptUtils.IsLocalAnaesSet(regOpt, anaesMethodCodes, beid);

		BasDept basDept = basDeptDao.searchDeptById(regOpt.getDeptId());
		if (basDept != null) {
			regOpt.setDeptName(basDept.getName());
		}
		BasRegion basRegion = basRegionDao.searchRegionById(regOpt.getRegionId());
		if (basRegion != null) {
			regOpt.setRegionName(basRegion.getName());
		}
		BasUser user = UserUtils.getUserCache();
		String regOptId = GenerateSequenceUtil.generateSequenceNo();
		regOpt.setRegOptId(regOptId);
		regOpt.setCostsettlementState("0");
		regOpt.setState(OperationState.NOT_REVIEWED);
		if (user != null) {
			regOpt.setCreateUser(user.getUserName());
		}
		regOpt.setCreateTime(DateUtils.formatDateTime(new Date()));
		regOpt.setBeid(beid);
		
		basRegOptDao.insertSelective(regOpt);
		if ("1".equals(regOpt.getGetData())) {
			return JsonType.jsonType(searchRegOptById(regOptId));
		}
		return "true";
	}

	@Transactional
	public void batchCreateRegOpt(int count) {
		BaseInfoQuery query = new BaseInfoQuery();
		List<DiagnosedefFormBean> diagList = basDiagnosedefDao.findList(query);
		List<BasRegion> regList = basRegionDao.findList(query);
		List<DeptFormBean> deptList = basDeptDao.findList(query);
		List<OperDefFormBean> operdefList = basOperdefDao.findList(query);
		List<AnaesMethodFormBean> anaesMethodList = basAnaesMethodDao.findList(query);
		List<OperPeopleFormBean> operList = basOperationPeopleDao.findList(query);
		for (int i = 1; i <= count; i++) {
			String regOptId = GenerateSequenceUtil.generateSequenceNo();
			BasRegOpt regOpt = new BasRegOpt();
			regOpt.setIsLocalAnaes(0); // 默认全麻
			regOpt.setRegOptId(regOptId);
			regOpt.setCreateTime(DateUtils.formatDateTime(new Date()));
			Random r = new Random();
			String[] firstName = { "张", "李", "刘", "曹", "王", "陈", "邹", "许" };
			String[] secedName = { "杨", "志", "宇", "勇", "鑫", "泽", "翔", "茹", "诚" };
			regOpt.setName(firstName[r.nextInt(firstName.length)] + secedName[r.nextInt(secedName.length)]);
			regOpt.setAge(r.nextInt(100) == 0 ? 1 : r.nextInt(100));
			String sex = "男";
			String medicalType = "自费";
			if (i % 2 == 0) {
				sex = "女";
				medicalType = "医保";
			}
			regOpt.setSex(sex);
			regOpt.setHid("100010" + i + "" + r.nextInt(10));
			BasRegion region = regList.get(r.nextInt(regList.size() - 1));
			regOpt.setRegionId(region.getRegionId());
			regOpt.setRegionName(region.getName());
			DeptFormBean dept = deptList.get(r.nextInt(deptList.size() - 1));
			regOpt.setDeptId(dept.getDeptId());
			regOpt.setDeptName(dept.getName());
			regOpt.setBed(i + "" + r.nextInt(9));
			regOpt.setMedicalType(medicalType);
			OperDefFormBean operdef = operdefList.get(r.nextInt(operdefList.size() - 1));
			regOpt.setDesignedOptCode(operdef.getOperDefId() + "");
			regOpt.setDesignedOptName(operdef.getName());

			DiagnosedefFormBean diagnosedef = diagList.get(r.nextInt(diagList.size() - 1));
			regOpt.setDiagnosisCode(diagnosedef.getDiagDefId() + "");
			regOpt.setDiagnosisName(diagnosedef.getName());
			Date date = new Date();
			regOpt.setOperaDate(DateUtils.formatDate(date, "yyyy-MM-dd"));
			regOpt.setCreateUser("11");
			regOpt.setCreateTime(DateUtils.formatDateTime(date));
			regOpt.setEmergency(0);
			AnaesMethodFormBean anaesMethod = anaesMethodList.get(r.nextInt(anaesMethodList.size() - 1));
			regOpt.setDesignedAnaesMethodCode(anaesMethod.getAnaMedId() + "");
			regOpt.setDesignedAnaesMethodName(anaesMethod.getName());
			OperPeopleFormBean operationPeople = operList.get(r.nextInt(operList.size() - 1));
			regOpt.setOperatorId(operationPeople.getOperatorId() + "");
			regOpt.setOperatorName(operationPeople.getName() + "");
			basRegOptDao.insert(regOpt);
			Controller controller = new Controller();
			controller.setRegOptId(regOptId);
			controller.setCostsettlementState("0");
			controller.setState(OperationState.NOT_REVIEWED);
			controllerDao.update(controller);
		}
	}

	@Transactional
	public void updateRegOptByHis(BasRegOpt regOpt) {
		List<String> anaesMethodCodes = regOpt.getDesignedAnaesMethodCodes();
		String beid = regOpt.getBeid();
		if (StringUtils.isBlank("beid")) {
			beid = getBeid();
		}
		BasRegOptUtils.IsLocalAnaesSet(regOpt, anaesMethodCodes, beid);
		basRegOptDao.updateByPrimaryKeySelective(regOpt);
	}

	@Transactional
	public String updateRegOptInfo(EmgencyOperationFormBean emgencyOperationFormBean) {
		BasRegOpt regOpt = emgencyOperationFormBean.getRegOpt();
		String beid = regOpt.getBeid();
		if (StringUtils.isBlank("beid")) {
			beid = getBeid();
		}
		if (regOpt != null && (!StringUtils.isEmpty(regOpt.getRegOptId()))) {
			List<String> anaesMethodCodes = regOpt.getDesignedAnaesMethodCodes();
			BasRegOptUtils.IsLocalAnaesSet(regOpt, anaesMethodCodes, beid);
			
			// 处理拟施手术、拟施诊断、麻醉方法等字段的值。
			BasRegOptUtils.getOtherInfo(regOpt);
			
			BasDept basDept = basDeptDao.searchDeptById(regOpt.getDeptId());
			if (basDept != null) {
				regOpt.setDeptName(basDept.getName());
			}
			BasRegion basRegion = basRegionDao.searchRegionById(regOpt.getRegionId());
			if (basRegion != null) {
				regOpt.setRegionName(basRegion.getName());
			}
			
			basRegOptDao.updateByPrimaryKeySelective(regOpt);
		}

		BasDispatch dispatch = emgencyOperationFormBean.getDispatch();
		if (dispatch != null && (!StringUtils.isEmpty(dispatch.getRegOptId()))) {
			if(StringUtils.isNotEmpty(dispatch.getOperRoomId()) && StringUtils.isNotEmpty(dispatch.getStartTime())) {
				dispatch.setBeid(beid);
				basDispatchDao.update(dispatch);
			}
		}
		
		// 如果在术前修改了手术的人员信息，需要同步将s_participant表中的人员信息同步修改
		if (null != regOpt && "03".equals(regOpt.getState()) && "0".equals(regOpt.getIsLocalAnaes())) {
			SearchFormBean searchBean = new SearchFormBean();
			DocAnaesRecord anaesRecord = docAnaesRecordDao.searchAnaesRecordByRegOptId(regOpt.getRegOptId());
			String docId = anaesRecord.getAnaRecordId();
			searchBean.setDocId(docId);

			// 麻醉医生列表
			searchBean.setRole(EvtParticipantService.ROLE_ANESTH);
			List<EvtParticipant> anesDocList = evtParticipantDao.searchParticipantList(searchBean, getBeid());
			EvtParticipant participant = new EvtParticipant();
			participant = anesDocList.get(0);
			if (!dispatch.getAnesthetistId().equals(participant.getUserLoginName())) {
				participant.setUserLoginName(dispatch.getAnesthetistId());
				BasUser user = basUserDao.searchUserById(dispatch.getAnesthetistId(), getBeid());
				participant.setName(user == null ? "" : user.getName());
				evtParticipantDao.update(participant);
			}
			// 巡回护士列表
			searchBean.setRole(EvtParticipantService.ROLE_NURSE);
			searchBean.setType(EvtParticipantService.OPER_TYPE_TOUR);// 05
			List<EvtParticipant> nurseList = evtParticipantDao.searchParticipantList(searchBean, getBeid());
			// 第一巡回护士
			participant = nurseList.get(0);
			if (!dispatch.getCircunurseId1().equals(participant.getUserLoginName())) {
				participant.setUserLoginName(dispatch.getCircunurseId1());
				BasUser user = basUserDao.searchUserById(dispatch.getCircunurseId1(), getBeid());
				participant.setName(user == null ? "" : user.getName());
				evtParticipantDao.update(participant);
			}
			// 第二巡回护士
			if (nurseList.size() > 1) {
				participant = nurseList.get(1);
				if (StringUtils.isBlank(dispatch.getCircunurseId2())) {
					evtParticipantDao.deleteById(participant);
				} else if (!dispatch.getCircunurseId2().equals(participant.getUserLoginName())) {
					participant.setUserLoginName(dispatch.getCircunurseId2());
					BasUser user = basUserDao.searchUserById(dispatch.getCircunurseId2(), getBeid());
					participant.setName(user == null ? "" : user.getName());
					evtParticipantDao.update(participant);
				}
			} else if (StringUtils.isNotBlank(dispatch.getCircunurseId2())) {
				participant = new EvtParticipant();
				participant.setDocId(docId);
				participant.setRole(EvtParticipantService.ROLE_NURSE);
				participant.setUserLoginName(dispatch.getCircunurseId2());
				participant.setOperatorType(EvtParticipantService.OPER_TYPE_TOUR); // 巡回护士
				participant.setPartpId(GenerateSequenceUtil.generateSequenceNo());
				evtParticipantDao.insert(participant);
			}
			// 器械护士列表
			searchBean.setRole(EvtParticipantService.ROLE_NURSE);
			searchBean.setType(EvtParticipantService.OPER_TYPE_INSTRUMENT);// 04
			List<EvtParticipant> instruNurseList = evtParticipantDao.searchParticipantList(searchBean, getBeid());

			// 第一洗手护士
			if (null != instruNurseList && instruNurseList.size() > 0) {
				participant = instruNurseList.get(0);
				if (StringUtils.isBlank(dispatch.getInstrnurseId1())) {
					evtParticipantDao.deleteById(participant);
				} else if (!dispatch.getInstrnurseId1().equals(participant.getUserLoginName())) {
					participant.setUserLoginName(dispatch.getInstrnurseId1());
					BasUser user = basUserDao.searchUserById(dispatch.getInstrnurseId1(), getBeid());
					participant.setName(user == null ? "" : user.getName());
					evtParticipantDao.update(participant);
				}
			} else if (StringUtils.isNotBlank(dispatch.getInstrnurseId1())) {
				participant = new EvtParticipant();
				participant.setDocId(docId);
				participant.setRole(EvtParticipantService.ROLE_NURSE);
				participant.setUserLoginName(dispatch.getInstrnurseId1());
				participant.setOperatorType(EvtParticipantService.OPER_TYPE_INSTRUMENT); // 洗手护士
				participant.setPartpId(GenerateSequenceUtil.generateSequenceNo());
				evtParticipantDao.insert(participant);
			}

			// 第二洗手护士
			if (null != instruNurseList && instruNurseList.size() > 1) {
				participant = instruNurseList.get(1);
				if (StringUtils.isBlank(dispatch.getInstrnurseId2())) {
					evtParticipantDao.deleteById(participant);
				} else if (!dispatch.getInstrnurseId2().equals(participant.getUserLoginName())) {
					participant.setUserLoginName(dispatch.getInstrnurseId2());
					BasUser user = basUserDao.searchUserById(dispatch.getInstrnurseId2(), getBeid());
					participant.setName(user == null ? "" : user.getName());
					evtParticipantDao.update(participant);
				}
			} else if (StringUtils.isNotBlank(dispatch.getInstrnurseId2())) {
				participant = new EvtParticipant();
				participant.setDocId(docId);
				participant.setRole(EvtParticipantService.ROLE_NURSE);
				participant.setUserLoginName(dispatch.getInstrnurseId2());
				participant.setOperatorType(EvtParticipantService.OPER_TYPE_INSTRUMENT); // 洗手护士
				participant.setPartpId(GenerateSequenceUtil.generateSequenceNo());
				evtParticipantDao.insert(participant);
			}
		}

		return "保存基本信息成功!";
	}

	/**
	 * 
	 * @discription 修改regOpt
	 * @author chengwang
	 * @created 2015年10月30日 上午9:32:33
	 * @param regOpt
	 * @return
	 */
	@Transactional
	public void updateRegOpt(BasRegOpt regOpt) {
		List<String> anaesMethodCodes = regOpt.getDesignedAnaesMethodCodes();
		if (null != anaesMethodCodes && anaesMethodCodes.size() > 0) {
			String beid = regOpt.getBeid();
			if (StringUtils.isBlank("beid")) {
				beid = getBeid();
			}
			BasRegOptUtils.IsLocalAnaesSet(regOpt, anaesMethodCodes, beid);
		}
		basRegOptDao.updateByPrimaryKeySelective(regOpt);
	}

	/**
	 * 
	 * @discription
	 * @author chengwang
	 * @created 2015年10月30日 上午10:03:08
	 * @param cancleRegOptFormBean
	 * @return
	 */
	@Transactional
	public void cancleRegOpt(CancleRegOptFormBean cancleRegOptFormBean, ResponseValue resp) {
		BasRegOpt regOpt = basRegOptDao.searchRegOptById(cancleRegOptFormBean.getRegOptId());
		regOpt.setReasons(cancleRegOptFormBean.getReasons());
		basRegOptDao.updateByPrimaryKeySelective(regOpt);
		Controller controller = controllerDao.getControllerById(cancleRegOptFormBean.getRegOptId());
		/**
		 * 未审核、未排班、术前 NOT_REVIEWED、NO_SCHEDULING、PREOPERATIVE允许取消手术
		 */
		if (OperationState.NOT_REVIEWED.equals(controller.getState()) || OperationState.NO_SCHEDULING.equals(controller.getState()) || OperationState.PREOPERATIVE.equals(controller.getState())) {
			controllerDao.checkOperation(cancleRegOptFormBean.getRegOptId(), OperationState.CANCEL, controller.getState());
			resp.setResultCode("1");
			resp.setResultMessage("取消手术成功!");
		} else {
			resp.setResultCode("30000001");
			resp.setResultMessage("当前手术状态已不允许取消手术，请核实当前病人信息!");
		}
	}

	@Transactional
	public void activeRegOpt(CancleRegOptFormBean acticRegOptFormBean, ResponseValue resp) {
		BasRegOpt regOpt = basRegOptDao.searchRegOptById(acticRegOptFormBean.getRegOptId());
		if (!OperationState.CANCEL.equals(regOpt.getState())) {
			resp.setResultCode("30000001");
			resp.setResultMessage("当前手术状态已不允许激活手术!");
		} else {
			regOpt.setReasons(acticRegOptFormBean.getReasons());
			basRegOptDao.updateByPrimaryKeySelective(regOpt);
			Controller controller = controllerDao.getControllerById(acticRegOptFormBean.getRegOptId());
			controllerDao.checkOperation(acticRegOptFormBean.getRegOptId(), controller.getPreviousState(), OperationState.CANCEL);
		}
	}

	/**
	 * 查询术中巡视记录
	 * 
	 * @param baseQuery
	 * @return
	 */
	public List<SearchOperaPatrolRecordFormBean> getOperaPatrolRecordList(BaseInfoQuery baseQuery) {
		if (StringUtils.isEmpty(baseQuery.getBeid())) {
			baseQuery.setBeid(getBeid());
		}
		return basRegOptDao.getOperaPatrolRecordList(baseQuery);
	}

	public List<SearchOperaPatrolRecordFormBean> getOperaPatrolRecordListByRoomId(BaseInfoQuery baseQuery) {
		if (StringUtils.isEmpty(baseQuery.getBeid())) {
			baseQuery.setBeid(getBeid());
		}
		return basRegOptDao.getOperaPatrolRecordListByRoomId(baseQuery);
	}

	@Transactional
	public int autoArchiveDocuments() {
		int result = 0;
		List<SysCodeFormbean> dayList = basSysCodeDao.searchSysCodeByGroupId("archive_day", getBeid());
		int days = Integer.parseInt(dayList.get(0).getCodeValue());
		long currentTime = System.currentTimeMillis();
		Date finishTime = new Date(currentTime - days * 24 * 60 * 60 * 1000);
		String time = DateUtils.DateToString(finishTime);
		List<SearchMyOperationFormBean> list = basRegOptDao.searchNoArchiveRegOpt(time);
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				String regOptId = list.get(i).getRegOptId();
				BasRegOpt regOpt = basRegOptDao.searchRegOptById(regOptId);
				regOpt.setArchState("AR");
				regOpt.setNurseArchState("AR");
				basRegOptDao.update(regOpt);
				result++;
			}
		}
		return result;
	}

	/**
	 * 查询文书的状态
	 * 
	 * @param sql
	 * @return
	 */
	public String searchDocumentState(String sql) {
		return basRegOptDao.searchDocumentState(sql);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Map searchDocumentUnFinish(SearchConditionFormBean searchConditionFormBean) {
		Map map = new HashMap();
		String beid = null;
		if (StringUtils.isBlank(searchConditionFormBean.getBeid())) {
			beid = getBeid();
			searchConditionFormBean.setBeid(beid);
		}else{
			beid = searchConditionFormBean.getBeid();
		}
		searchConditionFormBean.setState("03");
		BasUser user = basUserDao.getByLoginName(searchConditionFormBean.getLoginName() != null ? searchConditionFormBean.getLoginName() : "", beid);
		List<SearchMyOperationFormBean> resultList = new ArrayList<SearchMyOperationFormBean>();
		List<SearchMyOperationFormBean> result = basRegOptDao.searchRegOpt(user == null ? "" : user.getUserName(), user == null ? "" : user.getRoleType(), searchConditionFormBean);
		int total = 0;
		if (result != null && result.size() > 0) {
			String regOptStr = "";
			for (int i = 0; i < result.size(); i++) {
				regOptStr += "'" + result.get(i).getRegOptId() + "',";
			}
			regOptStr = regOptStr.substring(0, regOptStr.length() - 1);
			List<DocStateArrayFormbean> arrList = getDocumentState(user, searchConditionFormBean.getState(), regOptStr,beid);

			for (int i = 0; i < result.size(); i++) {
				SearchMyOperationFormBean bean = result.get(i);
				String documentState = "完成";

				List<DocumentStateFormbean> stateFormbeanList = new ArrayList<DocumentStateFormbean>();
				for (DocStateArrayFormbean docStateArrayFormbean : arrList) {
					DocumentStateFormbean stateFormbean = new DocumentStateFormbean();
					List<DocumentStateFormbean> statList = docStateArrayFormbean.getDocStateList();
					for (DocumentStateFormbean documentStateFormbean : statList) {
						if (bean.getRegOptId().equals(documentStateFormbean.getRegOptId())) {
							if (!"END".equals(documentStateFormbean.getState()) && docStateArrayFormbean.getIsNeed() == 1) {
								if (1 == docStateArrayFormbean.getIsNeed()) { //1 必须完成  
									documentState = "未完成";
								}
								//documentState = "未完成";
								stateFormbean.setState("未完成");
								stateFormbeanList.add(stateFormbean);
							} else {
								stateFormbean.setState("完成");

							}
							stateFormbean.setName(docStateArrayFormbean.getDocName());
						}
					}
				}
				
				//已完成所有文书的手术不需要再加入到首页待补文书手术列表中
                if (documentState.equals("未完成"))
                {
                    bean.setDocumentState(documentState);
                    total = total + 1;
                    bean.setDocumentStateList(stateFormbeanList);
                    resultList.add(bean);
                }
                else
                {
                    bean.setDocumentState("完成");
                }
			}
		}

		searchConditionFormBean.setState("06");
		List<SearchMyOperationFormBean> resultSH = basRegOptDao.searchRegOpt(user == null ? "" : user.getUserName(), user == null ? "" : user.getRoleType(), searchConditionFormBean);

		if (resultSH != null && resultSH.size() > 0) {

			String regOptStr = "";
			for (int i = 0; i < resultSH.size(); i++) {
				regOptStr += "'" + resultSH.get(i).getRegOptId() + "',";
			}
			regOptStr = regOptStr.substring(0, regOptStr.length() - 1);
			List<DocStateArrayFormbean> arrList = getDocumentState(user, searchConditionFormBean.getState(), regOptStr,searchConditionFormBean.getBeid());

			for (int i = 0; i < resultSH.size(); i++) {
				SearchMyOperationFormBean bean = resultSH.get(i);
				String documentState = "完成";

				List<DocumentStateFormbean> stateFormbeanList = new ArrayList<DocumentStateFormbean>();
				for (DocStateArrayFormbean docStateArrayFormbean : arrList) {
					DocumentStateFormbean stateFormbean = new DocumentStateFormbean();
					List<DocumentStateFormbean> statList = docStateArrayFormbean.getDocStateList();
					for (DocumentStateFormbean documentStateFormbean : statList) {
						if (bean.getRegOptId().equals(documentStateFormbean.getRegOptId())) {
							if (!"END".equals(documentStateFormbean.getState()) && docStateArrayFormbean.getIsNeed() == 1) {
								if (1 == docStateArrayFormbean.getIsNeed()) { //1 必须完成  
									documentState = "未完成";
								}
								//documentState = "未完成";
								stateFormbean.setState("未完成");
								stateFormbeanList.add(stateFormbean);
							} else {
								stateFormbean.setState("完成");

							}
							stateFormbean.setName(docStateArrayFormbean.getDocName());
						}
					}
				}
				//已完成所有文书的手术不需要再加入到首页待补文书手术列表中
                if (documentState.equals("未完成"))
                {
                    bean.setDocumentState(documentState);
                    total = total + 1;
                    bean.setDocumentStateList(stateFormbeanList);
                    resultList.add(bean);
                }
                else
                {
                    bean.setDocumentState("完成");
                }
			}
		}
		map.put("documentNoFinishRegOpt", resultList);
		map.put("total", total);
		return map;
	}

	public List<DocStateArrayFormbean> getDocumentState(BasUser user, String state, String regOptStr,String beid) {
		List<BasDocument> documentList = basDocumentDao.searchDocument(user != null ? user.getRoleId() : "0", state, beid);
		//logger.info("regOptStr===="+regOptStr);
		//regOptStr = regOptStr.substring(0, regOptStr.length() - 1);
		List<DocStateArrayFormbean> arrList = new ArrayList<DocStateArrayFormbean>();
		for (int j = 0; j < documentList.size(); j++) {
			String sql = "select regOptId,processState as state from " + documentList.get(j).getTable() + " where regOptId in (" + regOptStr + ") ";
			List<DocumentStateFormbean> stateList = basRegOptDao.queryDocState(sql);
			DocStateArrayFormbean doc = new DocStateArrayFormbean();
			doc.setIsNeed(documentList.get(j).getIsNeed());
			doc.setDocName(documentList.get(j).getName());
			doc.setDocStateList(stateList);
			arrList.add(doc);
		}
		return arrList;
	}

	public List<OneRegOptDocumentStateFormbean> getDocumentStatuByRegOptId(String regOptId) {
		String beid = getBeid();
		List<BasDocument> documents = basDocumentDao.searchAllDocumentMenu(beid);
		List<OneRegOptDocumentStateFormbean> stateFormbeanList = new ArrayList<OneRegOptDocumentStateFormbean>();
		if (documents != null && documents.size() > 0) {
			for (int j = 0; j < documents.size(); j++) {
				String table = documents.get(j).getTable() ;
				String name = documents.get(j).getName();
				OneRegOptDocumentStateFormbean stateFormbean = new OneRegOptDocumentStateFormbean();
				String sql = "select processState from " + table + " where regOptId ='" + regOptId + "'";
				String state = basRegOptDao.searchDocumentState(sql);
				if (!"END".equals(state)) {
					stateFormbean.setName(name);
					stateFormbean.setState(false);
				} else {
					stateFormbean.setName(name);
					stateFormbean.setState(true);
				}
				stateFormbeanList.add(stateFormbean);

			}
		}

		return stateFormbeanList;
	}

	@Transactional
	public int updateMsid(String regOptId, String msid) {
		return basRegOptDao.updateMsid(regOptId, msid);
	}

	@Transactional
	public int updateOperTime(String operTime, String regOptId) {
		return basRegOptDao.updateOperTime(operTime, regOptId);
	}

	@Transactional
	public void suspendOperation(SuspendFormBean bean) {
		String regOptId = bean.getRegOptId();
		DocAnaesRecord anaesRecord = docAnaesRecordDao.searchAnaesRecordByRegOptId(regOptId);
		if (anaesRecord != null) {
			String docId = anaesRecord.getAnaRecordId();
			EvtAnaesEvent anaesevent = new EvtAnaesEvent();
			anaesevent.setAnaEventId(GenerateSequenceUtil.generateSequenceNo());// 中止手术时，ana_event_id
																				// 为null，插入会不成功
			String curTime = SysUtil.getTimeFormat(bean.getSuspendTime()); // 取前端传递的时间
			anaesevent.setDocId(docId);
			anaesevent.setOccurTime(bean.getSuspendTime()); // 取前端传递的时间
			anaesevent.setCode(EvtAnaesEventService.OUT_ROOM);
			// anaesevent.setState(OperationState.STOP); //state不能为空
			evtAnaesEventDao.insert(anaesevent);

			// 中止手术 入室事件、麻醉开始时间、手术开始时间、手术结束时间、麻醉结束时间、出室时间都不能为空
			EvtAnaesEvent rsEvent = evtAnaesEventDao.selectAnaesEventByCodeAndDocId(docId, 1); // 入室
			EvtAnaesEvent mzksEvent = evtAnaesEventDao.selectAnaesEventByCodeAndDocId(docId, 2);// 麻醉开始
			EvtAnaesEvent ssksEvent = evtAnaesEventDao.selectAnaesEventByCodeAndDocId(docId, 4);// 手术开始
			EvtAnaesEvent ssjsEvent = evtAnaesEventDao.selectAnaesEventByCodeAndDocId(docId, 5);// 手术结束
			EvtAnaesEvent mzjsEvent = evtAnaesEventDao.selectAnaesEventByCodeAndDocId(docId, 8);// 麻醉开始
			if (null == rsEvent) { // 入室
				rsEvent = new EvtAnaesEvent();
				rsEvent.setAnaEventId(GenerateSequenceUtil.generateSequenceNo());
				rsEvent.setDocId(docId);
				rsEvent.setCode(1);
				rsEvent.setOccurTime(bean.getSuspendTime());
				// rsEvent.setState(OperationState.STOP);
				evtAnaesEventDao.insertSelective(rsEvent);
				anaesRecord.setInOperRoomTime(curTime); // 修改入室时间为 中止时间
			}

			if (null == mzksEvent) {// 麻醉开始
				mzksEvent = new EvtAnaesEvent();
				mzksEvent.setAnaEventId(GenerateSequenceUtil.generateSequenceNo());
				mzksEvent.setDocId(docId);
				mzksEvent.setCode(2);
				mzksEvent.setOccurTime(bean.getSuspendTime());
				// mzksEvent.setState(OperationState.STOP);
				evtAnaesEventDao.insertSelective(mzksEvent);

				anaesRecord.setAnaesStartTime(curTime); // 修改麻醉开始时间为 中止时间
			}

			if (null == ssksEvent) {// 手术开始
				ssksEvent = new EvtAnaesEvent();
				ssksEvent.setAnaEventId(GenerateSequenceUtil.generateSequenceNo());
				ssksEvent.setDocId(docId);
				ssksEvent.setCode(4);
				ssksEvent.setOccurTime(bean.getSuspendTime());
				// ssksEvent.setState(OperationState.STOP);
				evtAnaesEventDao.insertSelective(ssksEvent);

				anaesRecord.setOperStartTime(curTime); // 修改手术开始时间为 中止时间
			}

			if (null == ssjsEvent) {// 手术结束
				ssjsEvent = new EvtAnaesEvent();
				ssjsEvent.setAnaEventId(GenerateSequenceUtil.generateSequenceNo());
				ssjsEvent.setDocId(docId);
				ssjsEvent.setCode(5);
				ssjsEvent.setOccurTime(bean.getSuspendTime());
				// ssjsEvent.setState(OperationState.STOP);
				evtAnaesEventDao.insertSelective(ssjsEvent);
				anaesRecord.setOperEndTime(curTime); // 修改手术结束时间为 中止时间
			}

			if (null == mzjsEvent) {// 麻醉结束
				mzjsEvent = new EvtAnaesEvent();
				mzjsEvent.setAnaEventId(GenerateSequenceUtil.generateSequenceNo());
				mzjsEvent.setDocId(docId);
				mzjsEvent.setCode(8);
				mzjsEvent.setOccurTime(bean.getSuspendTime());
				// mzjsEvent.setState(OperationState.STOP);
				evtAnaesEventDao.insertSelective(mzjsEvent);

				anaesRecord.setAnaesEndTime(curTime); // 修改麻醉结束时间为 中止时间
			}

			// 将消息推送到手术室大屏
			BasRegOpt regOpt = basRegOptDao.searchRegOptById(regOptId);
			WebSocketHandler.sentMessageToAllUser(regOpt.getDeptName() + regOpt.getRegionName() + regOpt.getBed() + "床的" + regOpt.getName() + "手术已中止");

			Controller controller = controllerDao.getControllerById(bean.getRegOptId());
			// 当麻醉事件提交数据为出室时，需要将控制表的状态改成POSTOPERATIVE 术后
			if (null != controller && controller.getState().equals(OperationState.SURGERY)) {
				controller.setState(OperationState.STOP);
				controller.setPreviousState(OperationState.SURGERY);
				controllerDao.update(controller);

				// 不生成多个d_anaes_record
				anaesRecord.setOutOperRoomTime(curTime);
				anaesRecord.setProcessState(OperationState.SURGERY);
				// anaesRecord.setState(controller.getState());
				anaesRecord.setLeaveTo("1"); // 默认回病房
				anaesRecord.setProcessState("END"); // 文书结束标志
				docAnaesRecordDao.updateByPrimaryKey(anaesRecord);

				/*
				 * AnaesRecord oldAnaesRecord = anaesRecord; //
				 * 如果状态发生改变，麻醉记录表新增一条数据为新的有用的数据，上个数据flag=0作为历史数据
				 * oldAnaesRecord.setFlag("0");
				 * anaesRecordDao.update(oldAnaesRecord);
				 * 
				 * //将当前传入的数据保存 anaesRecord.setState(controller.getState());
				 * anaesRecord.setOutOperRoomTime(curTime);
				 * anaesRecord.setProcessState("END"); anaesRecord.setFlag("1");
				 * anaesRecordDao.insert(anaesRecord);
				 */
			}
		}

		// 修改b_reg_opt的中止原因
		basRegOptDao.updateIntermitcause(bean.getCause(), regOptId);
	}

	/**
	 * 强制结束手术 如果有多个regOptIds
	 * 
	 * @param regOptIds
	 */
	@Transactional
	public void forceEndOperation(List<String> regOptIds) {
		if (null != regOptIds && regOptIds.size() > 0) {
			for (int i = 0; i < regOptIds.size(); i++) {
				String regOptId = regOptIds.get(i);
				DocAnaesRecord anaesRecord = docAnaesRecordDao.searchAnaesRecordByRegOptId(regOptId);
				if (anaesRecord != null) {
					Date curDate = new Date();
					String curTime = SysUtil.getTimeFormat(curDate); // 取前端传递的时间
					String docId = anaesRecord.getAnaRecordId();

					// 强制结束手术 入室事件、麻醉开始时间、手术开始时间、手术结束时间、麻醉结束时间、出室时间都不能为空
					EvtAnaesEvent rsEvent = evtAnaesEventDao.selectAnaesEventByCodeAndDocId(docId, 1); // 入室
					EvtAnaesEvent mzksEvent = evtAnaesEventDao.selectAnaesEventByCodeAndDocId(docId, 2);// 麻醉开始
					EvtAnaesEvent ssksEvent = evtAnaesEventDao.selectAnaesEventByCodeAndDocId(docId, 4);// 手术开始
					EvtAnaesEvent ssjsEvent = evtAnaesEventDao.selectAnaesEventByCodeAndDocId(docId, 5);// 手术结束
					EvtAnaesEvent mzjsEvent = evtAnaesEventDao.selectAnaesEventByCodeAndDocId(docId, 8);// 麻醉开始
					if (null == rsEvent) { // 入室
						rsEvent = new EvtAnaesEvent();
						rsEvent.setAnaEventId(GenerateSequenceUtil.generateSequenceNo());
						rsEvent.setDocId(docId);
						rsEvent.setCode(1);
						rsEvent.setOccurTime(curDate);
						// rsEvent.setState(OperationState.POSTOPERATIVE);
						evtAnaesEventDao.insertSelective(rsEvent);
						anaesRecord.setInOperRoomTime(curTime); // 修改入室时间为 中止时间
					}

					if (null == mzksEvent) {// 麻醉开始
						mzksEvent = new EvtAnaesEvent();
						mzksEvent.setAnaEventId(GenerateSequenceUtil.generateSequenceNo());
						mzksEvent.setDocId(docId);
						mzksEvent.setCode(2);
						mzksEvent.setOccurTime(curDate);
						// mzksEvent.setState(OperationState.POSTOPERATIVE);
						evtAnaesEventDao.insert(mzksEvent);

						anaesRecord.setAnaesStartTime(curTime); // 修改麻醉开始时间为
																// 中止时间
					}

					if (null == ssksEvent) {// 手术开始
						ssksEvent = new EvtAnaesEvent();
						ssksEvent.setAnaEventId(GenerateSequenceUtil.generateSequenceNo());
						ssksEvent.setDocId(docId);
						ssksEvent.setCode(4);
						ssksEvent.setOccurTime(curDate);
						// ssksEvent.setState(OperationState.POSTOPERATIVE);
						evtAnaesEventDao.insertSelective(ssksEvent);

						anaesRecord.setOperStartTime(curTime); // 修改手术开始时间为 中止时间
					}

					if (null == ssjsEvent) {// 手术结束
						ssjsEvent = new EvtAnaesEvent();
						ssjsEvent.setAnaEventId(GenerateSequenceUtil.generateSequenceNo());
						ssjsEvent.setDocId(docId);
						ssjsEvent.setCode(5);
						ssjsEvent.setOccurTime(curDate);
						// ssjsEvent.setState(OperationState.POSTOPERATIVE);
						evtAnaesEventDao.insertSelective(ssjsEvent);
						anaesRecord.setOperEndTime(curTime); // 修改手术结束时间为 中止时间
					}

					if (null == mzjsEvent) {// 麻醉结束
						mzjsEvent = new EvtAnaesEvent();
						mzjsEvent.setAnaEventId(GenerateSequenceUtil.generateSequenceNo());
						mzjsEvent.setDocId(docId);
						mzjsEvent.setCode(8);
						mzjsEvent.setOccurTime(curDate);
						// mzjsEvent.setState(OperationState.POSTOPERATIVE);
						evtAnaesEventDao.insertSelective(mzjsEvent);

						anaesRecord.setAnaesEndTime(curTime); // 修改麻醉结束时间为 中止时间
					}

					EvtAnaesEvent anaesevent = new EvtAnaesEvent();
					anaesevent.setAnaEventId(GenerateSequenceUtil.generateSequenceNo());
					anaesevent.setDocId(docId);
					anaesevent.setOccurTime(curDate);
					anaesevent.setLeaveTo("1"); // 默认回病房
					anaesevent.setCode(EvtAnaesEventService.OUT_ROOM);
					// anaesevent.setState(OperationState.POSTOPERATIVE);
					// //变成术后状态
					evtAnaesEventDao.insertSelective(anaesevent);

					// 将消息推送到手术室大屏
					BasRegOpt regOpt = basRegOptDao.searchRegOptById(regOptId);
					WebSocketHandler.sentMessageToAllUser(regOpt.getDeptName() + regOpt.getRegionName() + regOpt.getBed() + "床的" + regOpt.getName() + "手术已结束");

					Controller controller = controllerDao.getControllerById(regOptId);
					// 当麻醉事件提交数据为出室时，需要将控制表的状态改成POSTOPERATIVE 术后
					if (null != controller && controller.getState().equals(OperationState.SURGERY)) {
						controller.setState(OperationState.POSTOPERATIVE);
						controller.setPreviousState(OperationState.SURGERY);
						controllerDao.update(controller);

						// 不生成多个d_anaes_record
						anaesRecord.setOutOperRoomTime(curTime);
						anaesRecord.setProcessState(OperationState.SURGERY);
						// anaesRecord.setState(controller.getState());
						anaesRecord.setLeaveTo("1"); // 默认回病房
						anaesRecord.setProcessState("END"); // 文书结束标志
						docAnaesRecordDao.updateByPrimaryKey(anaesRecord);
					}
				}

			}

		}
	}

	public String getCurrentModel(String regOptId) {
		String operModel = MyConstants.OPERATION_MODEL_NORMAL;
		DocAnaesRecord anaesRecord = docAnaesRecordDao.searchAnaesRecordByRegOptId(regOptId);
		String anaRecordId = "";
		if (null != anaesRecord) {
			anaRecordId = anaesRecord.getAnaRecordId();
			SearchFormBean searchBean = new SearchFormBean();
			searchBean.setDocId(anaRecordId);
			searchBean.setCurrentState("1");
			List<EvtRescueevent> list = evtRescueeventDao.searchRescueeventList(searchBean);
			if (list.size() > 0) {
				operModel = list.get(0).getModel();
				logger.info("getCurrentModel---当前的手术模式===" + operModel);
			}
			logger.info("getCurrentModel--- 返回当前的手术模式operModel===" + operModel + ",list的size===" + list.size());
		} else {
			logger.error("getCurrentModel-------根据regOptId返回的doc_id为空，请检查！");
		}

		return operModel;
	}

	/**
	 * 
	 * @discription 根据登录账号和手术状态获取归档的手术列表信息
	 * @author chengwang
	 * @created 2015-10-9 上午10:29:34
	 * @param loginName
	 * @param statu
	 * @return
	 */
	public List<SearchRegOptByLoginNameAndStateFormBean> searchRegOptByArchstate(SearchConditionFormBean searchConditionFormBean) {
		if (StringUtils.isBlank(searchConditionFormBean.getSort())) {
			searchConditionFormBean.setSort("operaDate");
		}
		if (StringUtils.isBlank(searchConditionFormBean.getOrderBy())) {
			searchConditionFormBean.setOrderBy("DESC");
		}
		
		String beid = null;
		if (StringUtils.isBlank(searchConditionFormBean.getBeid())) {
			beid = getBeid();
			searchConditionFormBean.setBeid(beid);
		}else{
			beid = searchConditionFormBean.getBeid();
		}
		
		String filter = "";
		List<Filter> filters = searchConditionFormBean.getFilters();
		if (filters != null && filters.size() > 0) {
			for (int i = 0; i < filters.size(); i++) {
				if (StringUtils.isNotBlank(filters.get(i).getValue())) {
					if (filters.get(i).getField().equals("stateName")) {
						filter = filter + " AND a.state= '" + filters.get(i).getValue() + "' ";
					} else {
						filter = filter + " AND a." + filters.get(i).getField() + " like '%" + filters.get(i).getValue() + "%' ";
					}

				}

			}
		}
		BasUser user = basUserDao.getByLoginName(searchConditionFormBean.getLoginName() != null ? searchConditionFormBean.getLoginName() : "", beid);
		List<SearchRegOptByLoginNameAndStateFormBean> resultList = new ArrayList<SearchRegOptByLoginNameAndStateFormBean>();
		List<SearchRegOptByLoginNameAndStateFormBean> result = basRegOptDao.searchRegOptByArchstate(filter, user == null ? "" : user.getUserName(), user == null ? "" : user.getRoleType(), searchConditionFormBean, getBeid());
		if (searchConditionFormBean.getOptType() == null || searchConditionFormBean.getOptType().size() == 0) {
			return result;
		}
		if (result != null && result.size() > 0) {

			String regOptStr = "";
			for (int i = 0; i < result.size(); i++) {
				regOptStr += "'" + result.get(i).getRegOptId() + "',";
			}
			regOptStr = regOptStr.substring(0, regOptStr.length() - 1);
			List<DocStateArrayFormbean> arrList = getDocumentState(user, searchConditionFormBean.getState(), regOptStr,beid);
			for (int i = 0; i < result.size(); i++) {
				SearchRegOptByLoginNameAndStateFormBean bean = result.get(i);
				String documentState = "完成";

				List<DocumentStateFormbean> stateFormbeanList = new ArrayList<DocumentStateFormbean>();
				for (DocStateArrayFormbean docStateArrayFormbean : arrList) {
					DocumentStateFormbean stateFormbean = new DocumentStateFormbean();
					List<DocumentStateFormbean> statList = docStateArrayFormbean.getDocStateList();
					for (DocumentStateFormbean documentStateFormbean : statList) {
						if (bean.getRegOptId().equals(documentStateFormbean.getRegOptId())) {
							if (!"END".equals(documentStateFormbean.getState())) {
								if (1 == docStateArrayFormbean.getIsNeed()) { //1 必须完成  
									documentState = "未完成";
								}
								stateFormbean.setState("未完成");
								//documentState = "未完成";
							} else {
								stateFormbean.setState("完成");
							}
							stateFormbean.setName(docStateArrayFormbean.getDocName());
							stateFormbeanList.add(stateFormbean);
							break;
						}
					}
				}
				bean.setDocumentState(documentState);
				bean.setDocumentStateList(stateFormbeanList);
				resultList.add(bean);
			}

		}

		return resultList;
	}

	public int searchRegOptTotalByArchstate(SearchConditionFormBean searchConditionFormBean) {

		if (StringUtils.isEmpty(searchConditionFormBean.getSort())) {
			searchConditionFormBean.setSort("operaDate");
		}
		if (StringUtils.isEmpty(searchConditionFormBean.getOrderBy())) {
			searchConditionFormBean.setOrderBy("DESC");
		}
		String beid = null;
		if (StringUtils.isBlank(searchConditionFormBean.getBeid())) {
			beid = getBeid();
			searchConditionFormBean.setBeid(beid);
		}else{
			beid = searchConditionFormBean.getBeid();
		}

		String filter = "";
		List<Filter> filters = searchConditionFormBean.getFilters();
		if (filters != null && filters.size() > 0) {
			for (int i = 0; i < filters.size(); i++) {
				if (StringUtils.isNotBlank(filters.get(i).getValue())) {
					if (filters.get(i).getField().equals("stateName")) {
						filter = filter + " AND a.state= '" + filters.get(i).getValue() + "' ";
					} else {
						filter = filter + " AND a." + filters.get(i).getField() + " like '%" + filters.get(i).getValue() + "%' ";
					}

				}

			}
		}
		BasUser user = basUserDao.getByLoginName(searchConditionFormBean.getLoginName() != null ? searchConditionFormBean.getLoginName() : "", beid);

		return basRegOptDao.searchRegoptTotalByArchstate(filter, user == null ? "" : user.getUserName(), user == null ? "" : user.getRoleType(), searchConditionFormBean, beid);
	}

	@Transactional
	public ResponseValue updateArchstate(String regOptIds, String archstate) {
		ResponseValue resp = new ResponseValue();
		//		List<String> optList = new ArrayList<String>();
		//		optList.add("1");
		//		optList.add("2");

		String[] regOptId = null;
		if (null != regOptIds && "" != regOptIds) {
			regOptId = regOptIds.split(",");
		}
		String beid = null;
		if(StringUtils.isBlank(beid)){
			beid = getBeid();
		}

		List<String> regOptIdList = new ArrayList<String>();

		if (null != regOptId && regOptId.length > 0) {
			for (int i = 0; i < regOptId.length; i++) {
				if ("AR".equals(archstate)) {
					// 查询出麻醉医生所有文书列表
					// List<Menu> menuList = menuDao.searchDocumentMenu("4",
					// optList);
					String roleId = "";
					BasRoleFormBean basRole = new BasRoleFormBean();
					basRole.setBeid(beid);
					basRole.setRoleType("ANAES_DOCTOR");
					List<BasRole> list = basRoleDao.selectEntityList(basRole);
					if (!list.isEmpty() && list.size() > 0) {
						roleId = list.get(0).getId();
					}
					List<BasDocument> documentList = basDocumentDao.searchDocument(roleId, "06", beid); //查询麻醉医生所有文书
					for (int j = 0; j < documentList.size(); j++) {
						BasDocument basDocument = documentList.get(j);
						
						//如果文书为非必填文书，则不需要去查询状态
						if (0 == basDocument.getIsNeed()) { //是否为必须完成的文书，才能归档。0:否,1:是
							continue;
						}

						String sql = "select processState as state from " + basDocument.getTable() + " where regOptId = " + regOptId[i];
						String state = basRegOptDao.searchDocumentState(sql);

						if (!"END".equals(state)) {
							resp.setResultCode("10000000");
							resp.setResultMessage("当前选择的病案有必须完成的文书未完成，不能进行归档");
							return resp;
						}
					}
				}

				regOptIdList.add(regOptId[i]);

			}
		}

		if (null != regOptIdList && regOptIdList.size() > 0) {
			basRegOptDao.updateArchstate(regOptIdList, archstate);
		}

		resp.setResultCode("1");
		resp.setResultMessage("操作成功!");
		return resp;
	}

	@Transactional
	public ResponseValue updateNurseArchstate(String regOptIds, String nurseArchstate) {
		ResponseValue resp = new ResponseValue();
		List<String> optList = new ArrayList<String>();
		optList.add("1");
		optList.add("2");

		String[] regOptId = null;
		if (null != regOptIds && "" != regOptIds) {
			regOptId = regOptIds.split(",");
		}
		String beid = null;
		if(StringUtils.isBlank(beid)){
			beid = getBeid();
		}
		String roleId = "";
		BasRoleFormBean basRole = new BasRoleFormBean();
		basRole.setBeid(beid);
		basRole.setRoleType("NURSE");
		List<BasRole> list = basRoleDao.selectEntityList(basRole);
		if (!list.isEmpty() && list.size() > 0) {
			roleId = list.get(0).getId();
		}
		List<String> regOptIdList = new ArrayList<String>();
		
		if (null != regOptId && regOptId.length > 0) {
			for (int i = 0; i < regOptId.length; i++) {
				if ("AR".equals(nurseArchstate)) {
					List<BasDocument> documentList = basDocumentDao.searchDocument(roleId, "06", beid); // 查询出护士所有文书列表
					for (int j = 0; j < documentList.size(); j++) {
						BasDocument basDocument = documentList.get(j);
						//如果文书为非必填文书，则不需要去查询状态
						if (0 == basDocument.getIsNeed()) { //是否为必须完成的文书，才能归档。0:否,1:是
							continue;
						}
						String sql = "select processState as state from " + basDocument.getTable() + " where regOptId = " + regOptId[i];
						String state = basRegOptDao.searchDocumentState(sql);

						if (!"END".equals(state)) {
							resp.setResultCode("10000000");
							resp.setResultMessage("当前选择的病案有文书未完成，不能进行归档");
							return resp;
						}
					}
				}

				regOptIdList.add(regOptId[i]);

			}
		}
		basRegOptDao.updateNurseArchstate(regOptIdList, nurseArchstate);
		resp.setResultCode("1");
		resp.setResultMessage("操作成功!");
		return resp;
	}

	public BasRegOpt queryRegOptByState(String roomId, String state) {
		return basRegOptDao.selectByState(roomId, state, getBeid());
	}

	/**
	 * 获取患者的文书完成情况
	 * 
	 * @param regOptId
	 * @param loginName
	 * @return
	 */
	public List<DocumentStateFormbean> getAnesDucumentStateByRegOptId(SearchConditionFormBean searchConditionFormBean) {
		String beid = null;
		if (StringUtils.isBlank(searchConditionFormBean.getBeid())) {
			beid = getBeid();
			searchConditionFormBean.setBeid(beid);
		}else{
			beid = searchConditionFormBean.getBeid();
		}

		String stateStr = "05,06,07";
		BasRegOpt basRegOpt = basRegOptDao.searchRegOptById(searchConditionFormBean.getRegOptId());
		if(stateStr.contains(basRegOpt.getState())){
			stateStr = "06";
		}else{
			stateStr = "03";
		}
		BasUser user = basUserDao.getByLoginName(searchConditionFormBean.getLoginName(), searchConditionFormBean.getBeid());
		List<BasDocument> documentList = basDocumentDao.searchDocument(user != null ? user.getRoleId() : "0", stateStr, beid);
		String sql = "";
		for (int j = 0; j < documentList.size(); j++) {
			BasDocument basDocument = documentList.get(j);
			// 当前sql获取state状态，文书名称，文书英文名（用于一键打印），表名
			sql += "select regOptId,processState as state,'" + basDocument.getName() + "' name,'" + basDocument.getAliasName()+"' as impName ,'" + basDocument.getTable() + "' tabName from " + basDocument.getTable() + " where regOptId = " + searchConditionFormBean.getRegOptId() + " ";
			if (j + 1 < documentList.size()) {
				sql += " union all ";
			}
		}
		List<DocumentStateFormbean> stateList = basRegOptDao.queryDocState(sql);
		for (DocumentStateFormbean documentStateFormbean : stateList) {
			if (!"END".equals(documentStateFormbean.getState())) {
				documentStateFormbean.setState("未完成");
			} else {
				documentStateFormbean.setState("完成");
			}
		}
		return stateList;
	}

	public static List<DocumentStateFormbean> setDocumentList() {
		List<DocumentStateFormbean> ls = new ArrayList<DocumentStateFormbean>();

		DocumentStateFormbean map = new DocumentStateFormbean();
		map.setTabName("doc_accede");
		map.setImpName("accedeDoc");// 麻醉同意书
		ls.add(map);

		map = new DocumentStateFormbean();
		map.setTabName("doc_pre_visit");
		map.setImpName("preVisitDoc");// 术前访视单
		ls.add(map);

		map = new DocumentStateFormbean();
		map.setTabName("doc_anaes_record");
		map.setImpName("anesDoc");// 麻醉记录单
		ls.add(map);

		map = new DocumentStateFormbean();
		map.setTabName("doc_anaes_summary");
		map.setImpName("summaryDoc");// 麻醉记录单附页
		ls.add(map);

		map = new DocumentStateFormbean();
		map.setTabName("doc_analgesic_record");
		map.setImpName("anesAnalgesDoc");// 自控记录单
		ls.add(map);

		map = new DocumentStateFormbean();
		map.setTabName("doc_safe_check");
		map.setImpName("safeDoc");// 安全核查单
		ls.add(map);

		return ls;
	}
	
	public String getFilterStr(SearchConditionFormBean searchConditionFormBean) {
		String filter = "";
		List<Filter> filters = searchConditionFormBean.getFilters();
		if (filters != null && filters.size() > 0) {
			for (int i = 0; i < filters.size(); i++) {
				if (StringUtils.isNotBlank(filters.get(i).getValue())) {
					if (filters.get(i).getField().equals("stateName")) {
						filter += " AND a.state= '" + filters.get(i).getValue() + "' ";
					} else if (filters.get(i).getField().equals("operaDate")) {
						if (filters.get(i).getValue().length() == 2) {
							filter += " AND a." + filters.get(i).getField() + " like '%-" + filters.get(i).getValue() + "'";
						} else {
							filter += " AND a." + filters.get(i).getField() + " like '%" + filters.get(i).getValue() + "%' ";
						}
					} else if (filters.get(i).getField().equals("age")) {
						if (filters.get(i).getValue().contains("岁")) {
							filter += " AND a.age like '%" + filters.get(i).getValue().replaceAll("岁", "") + "%' ";
						} else if (filters.get(i).getValue().contains("月")) {
							filter += " AND a.ageMon like '%" + filters.get(i).getValue().replaceAll("月", "") + "%' ";
						} else if (filters.get(i).getValue().contains("天")) {
							filter += " AND a.ageDay like '%" + filters.get(i).getValue().replaceAll("天", "") + "%' ";
						} else {
							filter += " AND a." + filters.get(i).getField() + " like '%" + filters.get(i).getValue() + "%' ";
						}
					} else if (filters.get(i).getField().equals("operRoomName")) {
						filter += " AND c.operRoomId IN(select operRoomId from bas_operroom where `name` like '%"+ filters.get(i).getValue() +"%' and beid = '" + searchConditionFormBean.getBeid() + "')";
					} else if (filters.get(i).getField().equals("anesthetistName")) {
						filter += " AND c.anesthetistId IN(select userName from bas_user where `name` like '%"+ filters.get(i).getValue() +"%' and beid = '" + searchConditionFormBean.getBeid() + "')";
					} else if (filters.get(i).getField().equals("circunurseName1")) {
						filter += " AND c.circunurseId1 IN(select userName from bas_user where `name` like '%"+ filters.get(i).getValue() +"%' and beid = '" + searchConditionFormBean.getBeid() + "')";
					} else if (filters.get(i).getField().equals("instrnurseName1")) {
						filter += " AND c.instrnurseId1 IN(select userName from bas_user where `name` like '%"+ filters.get(i).getValue() +"%' and beid = '" + searchConditionFormBean.getBeid() + "')";
					} else {
						filter += " AND a." + filters.get(i).getField() + " like '%" + filters.get(i).getValue() + "%' ";
					}
				}

			}
		}
		return filter;
	}
	
	public static void main(String[] args) {
		String regOptStr = "'201704261352520015','201704261354540045','201704260955480003','201704201021180003','201704201159110024','201704201402400014','201704201148310000',";
		regOptStr = regOptStr.substring(0, regOptStr.length()-1);
		System.out.println(regOptStr);
	}
}
