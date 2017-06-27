/**
 * Copyright &copy; 2012-2013 <a href="httparamMap://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.digihealth.anesthesia.basedata.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.digihealth.anesthesia.basedata.formbean.DesignedOptCodes;
import com.digihealth.anesthesia.basedata.formbean.DiagnosisCodes;
import com.digihealth.anesthesia.basedata.po.BasAnaesMethod;
import com.digihealth.anesthesia.basedata.po.BasConsultation;
import com.digihealth.anesthesia.basedata.po.BasDept;
import com.digihealth.anesthesia.basedata.po.BasDiagnosedef;
import com.digihealth.anesthesia.basedata.po.BasOperationPeople;
import com.digihealth.anesthesia.basedata.po.BasOperdef;
import com.digihealth.anesthesia.basedata.po.BasRegion;
import com.digihealth.anesthesia.basedata.utils.UserUtils;
import com.digihealth.anesthesia.common.service.BaseService;
import com.digihealth.anesthesia.common.utils.DateUtils;
import com.digihealth.anesthesia.common.utils.GenerateSequenceUtil;
import com.digihealth.anesthesia.common.utils.PingYinUtil;
import com.digihealth.anesthesia.common.utils.StringUtils;
import com.digihealth.anesthesia.evt.formbean.Filter;
import com.digihealth.anesthesia.evt.formbean.SearchConditionFormBean;
import com.digihealth.anesthesia.sysMng.po.BasUser;

/**
 * 
     * Title: ConsultationService.java    
     * Description: 麻醉事件Service
     * @author liukui       
     * @created 2015-10-7 下午6:00:54
 */
@Service
public class BasConsultationService extends BaseService {

	@Transactional
	public String updateConsultation(BasConsultation consultation){
		if (StringUtils.isEmpty(consultation.getBeid())) {
			consultation.setBeid(getBeid());
		}
		
		//处理一些特殊数据
		getOtherInfo(consultation);
		
		if(!StringUtils.isEmpty(consultation.getConttId())){
			
			basConsultationDao.update(consultation);
			return "修改外部会诊成功!";
		}else{
			
			consultation.setCreateTime(DateUtils.getDateTime());
			consultation.setCreateUser(UserUtils.getUserCache().getUserName());
			consultation.setConttId(GenerateSequenceUtil.generateSequenceNo());
			basConsultationDao.insert(consultation);
			return "创建外部会诊成功!";
		}
	}
	
	public List<BasConsultation> searchConsultation(SearchConditionFormBean searchConditionFormBean){
		if(StringUtils.isEmpty(searchConditionFormBean.getBeid())){
			searchConditionFormBean.setBeid(getBeid());
		}
		if(StringUtils.isEmpty(searchConditionFormBean.getSort())){
			searchConditionFormBean.setSort("createTime");
		}
		if(StringUtils.isEmpty(searchConditionFormBean.getOrderBy())){
			searchConditionFormBean.setOrderBy("DESC");
		}
		String filter = "";
		List<Filter> filters = searchConditionFormBean.getFilters();
		if(filters!=null&&filters.size()>0){
			for(int i = 0;i<filters.size();i++){
				if(!StringUtils.isEmpty(filters.get(i).getValue())){
					filter = filter + " AND "+filters.get(i).getField()+" like '%"+filters.get(i).getValue()+"%' ";
				}
			}
		}
		BasUser user = basUserDao.get(searchConditionFormBean.getLoginName()!=null?searchConditionFormBean.getLoginName():"");
		return basConsultationDao.searchConsultation(filter, user == null?"":user.getUserName(), user == null?"": user.getExecutiveLevel(),searchConditionFormBean);
	}
	
	
	public BasConsultation searchConsultationById(String conttId){
		BasConsultation basConsultation = basConsultationDao.searchConsultationById(conttId);
		// 助手医生
		String assistantId = basConsultation.getAssistantId();
		if (StringUtils.isNoneBlank(assistantId)) {
			List<String> codes = new ArrayList<String>();
			String[] assistantIds = assistantId.split(",");
			for (String code : assistantIds) {
				codes.add(code);
			}
			basConsultation.setAssistants(codes);
		} else {
			basConsultation.setAssistants(new ArrayList<String>());
		}
		// 麻醉方法
		String anaesMethodCode = basConsultation.getDesignedAnaesMethodCode();
		if (StringUtils.isNoneBlank(anaesMethodCode)) {
			List<String> codes = new ArrayList<String>();
			String[] anaesMethodCodes = anaesMethodCode.split(",");
			for (String code : anaesMethodCodes) {
				codes.add(code);
			}
			basConsultation.setDesignedAnaesMethodCodes(codes);
		} else {
			basConsultation.setDesignedAnaesMethodCodes(new ArrayList<String>());
		}
		
		// 拟施手术
		List<DesignedOptCodes> designedOptCodeList = new ArrayList<DesignedOptCodes>();
		String designedOptCode = basConsultation.getDesignedOptCode();
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
		basConsultation.setDesignedOptCodes(designedOptCodeList);
		
		
		// 拟施诊断
		List<DiagnosisCodes> diagnosisCodesList = new ArrayList<DiagnosisCodes>();
		String diagnosisCode = basConsultation.getDiagnosisCode();
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
		basConsultation.setDiagnosisCodes(diagnosisCodesList);
		
		return basConsultationDao.searchConsultationById(conttId);
	}
	

	@Transactional
	public int deleteConsultationById(String conttId){
		return basConsultationDao.deleteConsultationById(conttId);
	}

	/**
	 * 处理拟施手术、拟施诊断、麻醉方法等字段的值。
	 * 
	 * @param regOpt
	 * @return
	 */
	public BasConsultation getOtherInfo(BasConsultation basConsultation) {
		String deptId = basConsultation.getDeptId();
		if (StringUtils.isNotBlank(deptId)) {
			BasDept basDept = basDeptDao.searchDeptById(deptId);
			if (basDept != null) {
				basConsultation.setDeptName(basDept.getName());
			}
		}
		String regionId = basConsultation.getRegionId();
		if (StringUtils.isNotBlank(regionId)) {
			BasRegion basRegion = basRegionDao.searchRegionById(regionId);
			if (basRegion != null) {
				basConsultation.setRegionName(basRegion.getName());
			}
		}
		// 助手医生
		String assistantId = "";
		String assistantName = "";
		List<String> assistants = basConsultation.getAssistants();
		if (assistants != null) {
			for (String id : assistants) {
				BasOperationPeople basOperationPeople = basOperationPeopleDao.queryOperationPeopleById(id);
				if (StringUtils.isBlank(assistantId)) {
					assistantId = id;
					assistantName = basOperationPeople.getName();
				} else {
					assistantId += "," + id;
					assistantName += "," + basOperationPeople.getName();
				}
			}
		}
		basConsultation.setAssistantId(assistantId);
		basConsultation.setAssistantName(assistantName);

		// 主治医生
		String operatorId = basConsultation.getOperatorId();
		// String operatorName = "";
		BasOperationPeople basOperationPeople = basOperationPeopleDao.queryOperationPeopleById(operatorId);
		basConsultation.setOperatorName(basOperationPeople.getName());

		String diagnosisCodes = "";
		String diagnosisNames = "";
		
		List<DiagnosisCodes> diagnosisCodesList = basConsultation.getDiagnosisCodes();
		if (diagnosisCodesList != null && diagnosisCodesList.size()>0) 
		{
			for (int i =0; i<diagnosisCodesList.size();i++ ) 
			{
				DiagnosisCodes dCodes = diagnosisCodesList.get(i);
				String id = "";
				String name = "";
				//为空表示自定义了一个诊断名称
				if(StringUtils.isBlank(dCodes.getDiagDefId()))
				{
					id = GenerateSequenceUtil.generateSequenceNo();
					BasDiagnosedef basDiagnosedef = new BasDiagnosedef();
					basDiagnosedef.setDiagDefId(id);
					basDiagnosedef.setBeid(getBeid());
					basDiagnosedef.setName(dCodes.getName());
					basDiagnosedef.setEnable(1);
					basDiagnosedef.setPinYin(PingYinUtil.getFirstSpell(dCodes.getName()));
					basDiagnosedefDao.insertSelective(basDiagnosedef);	
					
				}else
				{
					id = dCodes.getDiagDefId();
				}
				name = dCodes.getName();
				
				if(i == 0)
				{
					diagnosisCodes = id;
					diagnosisNames = name;
				}else if(i>0)
				{
					diagnosisCodes += "," + id;
					diagnosisNames += "," + name;
				}
				
			}
		}
		basConsultation.setDiagnosisCode(diagnosisCodes);
		basConsultation.setDiagnosisName(diagnosisNames);
		
		String designedOptCodes = "";
		String designedOptNames = "";
		List<DesignedOptCodes> designedOptCodesList = basConsultation.getDesignedOptCodes();
		if (designedOptCodesList != null && designedOptCodesList.size()>0) 
		{
			for (int i =0; i<designedOptCodesList.size();i++ ) 
			{
				DesignedOptCodes optCodes = designedOptCodesList.get(i);
				String id = "";
				String name = "";
				//为空表示自定义了一个手术名称
				if(StringUtils.isBlank(optCodes.getOperDefId()))
				{
					id = GenerateSequenceUtil.generateSequenceNo();
					BasOperdef basOperdef = new BasOperdef();
					basOperdef.setOperdefId(id);
					basOperdef.setBeid(getBeid());
					basOperdef.setEnable(1);
					basOperdef.setName(optCodes.getName());
					basOperdef.setPinYin(PingYinUtil.getFirstSpell(optCodes.getName()));
					basOperdefDao.insertSelective(basOperdef);
				}else
				{
					id = optCodes.getOperDefId();
				}
				name = optCodes.getName();
				
				if(i == 0)
				{
					designedOptCodes = id;
					designedOptNames = name;
				}else if(i>0)
				{
					designedOptCodes += "," + id;
					designedOptNames += "," + name;
				}
				
			}
		}
		basConsultation.setDesignedOptCode(designedOptCodes);
		basConsultation.setDesignedOptName(designedOptNames);
		
		String designedAnaesMethodCodes = "";
		String designedAnaesMethodNames = "";
		List<String> designedAnaesMethodCodeIds = basConsultation.getDesignedAnaesMethodCodes();
		if (designedAnaesMethodCodeIds != null) {
			for (String id : designedAnaesMethodCodeIds) {
				BasAnaesMethod basAnaesMethod = basAnaesMethodDao.searchAnaesMethodById(id);
				if (StringUtils.isBlank(designedAnaesMethodCodes)) {
					designedAnaesMethodCodes = id;
					designedAnaesMethodNames = basAnaesMethod.getName();
				} else {
					designedAnaesMethodCodes += "," + id;
					designedAnaesMethodNames += "," + basAnaesMethod.getName();
				}
			}
		}
		basConsultation.setDesignedAnaesMethodCode(designedAnaesMethodCodes);
		basConsultation.setDesignedAnaesMethodName(designedAnaesMethodNames);
		
		return basConsultation;
	}
	
}
