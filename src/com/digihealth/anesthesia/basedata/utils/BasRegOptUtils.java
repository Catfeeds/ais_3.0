package com.digihealth.anesthesia.basedata.utils;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.digihealth.anesthesia.basedata.dao.BasAnaesMethodDao;
import com.digihealth.anesthesia.basedata.dao.BasDiagnosedefDao;
import com.digihealth.anesthesia.basedata.dao.BasOperationPeopleDao;
import com.digihealth.anesthesia.basedata.dao.BasOperdefDao;
import com.digihealth.anesthesia.basedata.formbean.DesignedOptCodes;
import com.digihealth.anesthesia.basedata.formbean.DiagnosisCodes;
import com.digihealth.anesthesia.basedata.po.BasAnaesMethod;
import com.digihealth.anesthesia.basedata.po.BasDiagnosedef;
import com.digihealth.anesthesia.basedata.po.BasOperationPeople;
import com.digihealth.anesthesia.basedata.po.BasOperdef;
import com.digihealth.anesthesia.basedata.po.BasRegOpt;
import com.digihealth.anesthesia.common.service.BaseService;
import com.digihealth.anesthesia.common.utils.GenerateSequenceUtil;
import com.digihealth.anesthesia.common.utils.PingYinUtil;
import com.digihealth.anesthesia.common.utils.SpringContextHolder;

public class BasRegOptUtils extends BaseService {

	private static BasAnaesMethodDao basAnaesMethodDao = SpringContextHolder.getBean(BasAnaesMethodDao.class);
	private static BasOperationPeopleDao basOperationPeopleDao = SpringContextHolder.getBean(BasOperationPeopleDao.class);
	private static BasDiagnosedefDao basDiagnosedefDao = SpringContextHolder.getBean(BasDiagnosedefDao.class);
	private static BasOperdefDao basOperdefDao = SpringContextHolder.getBean(BasOperdefDao.class);

	/**
	 * 根据患者麻醉方法，设置是否局麻字段
	 * 
	 * @param regOpt
	 * @param anaesMethodCode
	 * @param beid
	 */
	public static void IsLocalAnaesSet(BasRegOpt regOpt, List<String> anaesMethodCodes, String beid) {
		int isLocalAnaes = 0;
		
        if (null != anaesMethodCodes && anaesMethodCodes.size() == 1)
        {
            List<BasAnaesMethod> anaesMethods = basAnaesMethodDao.selectByCode(anaesMethodCodes.get(0), beid);
            if (null != anaesMethods && anaesMethods.size() > 0)
            {
                BasAnaesMethod basAnaesMethod = anaesMethods.get(0);
                if (null != basAnaesMethod)
                {
                    isLocalAnaes = basAnaesMethod.getIsLocalAnaes();
                }
            }
        }
        regOpt.setIsLocalAnaes(isLocalAnaes);
	}

	/**
	 * 处理拟施手术、拟施诊断、麻醉方法等字段的值。
	 * 
	 * @param regOpt
	 * @return
	 */
	public static BasRegOpt getOtherInfo(BasRegOpt regOpt) {
		// 助手医生
		String assistantId = "";
		String assistantName = "";
		List<String> assistants = regOpt.getAssistants();
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
		regOpt.setAssistantId(assistantId);
		regOpt.setAssistantName(assistantName);

		// 主治医生
		String operatorId = regOpt.getOperatorId();
		BasOperationPeople basOperationPeople = basOperationPeopleDao.queryOperationPeopleById(operatorId);
		regOpt.setOperatorName(basOperationPeople.getName());

	
		//拟施诊断
		String diagnosisCodes = "";
		String diagnosisNames = "";
		List<DiagnosisCodes> diagnosisCodesList = regOpt.getDiagnosisCodes();
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
					basDiagnosedef.setBeid(regOpt.getBeid());
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
		regOpt.setDiagnosisCode(diagnosisCodes);
		regOpt.setDiagnosisName(diagnosisNames);

		//拟施手术
		String designedOptCodes = "";
		String designedOptNames = "";
		List<DesignedOptCodes> designedOptCodesList = regOpt.getDesignedOptCodes();
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
					basOperdef.setBeid(regOpt.getBeid());
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
		regOpt.setDesignedOptCode(designedOptCodes);
		regOpt.setDesignedOptName(designedOptNames);
		
		String designedAnaesMethodCodes = "";
		String designedAnaesMethodNames = "";
		List<String> designedAnaesMethodCodeIds = regOpt.getDesignedAnaesMethodCodes();
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
		regOpt.setDesignedAnaesMethodCode(designedAnaesMethodCodes);
		regOpt.setDesignedAnaesMethodName(designedAnaesMethodNames);
		return regOpt;
	}
}
