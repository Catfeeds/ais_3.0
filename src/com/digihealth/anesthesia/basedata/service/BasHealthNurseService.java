package com.digihealth.anesthesia.basedata.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.digihealth.anesthesia.basedata.po.BasHealthNurse;
import com.digihealth.anesthesia.common.service.BaseService;
import com.digihealth.anesthesia.common.utils.GenerateSequenceUtil;
@Service
public class BasHealthNurseService extends BaseService{

	public BasHealthNurse selectHealNurse(String operaDate,String operRoomId){
		return basHealthNurseDao.selectHealNurse(operaDate, operRoomId, getBeid());
	}
	
	
	@Transactional
	public int updateHealthNurse(BasHealthNurse healthNurse){
	    if (StringUtils.isBlank(healthNurse.getBeid()))
        {
	        healthNurse.setBeid(getBeid());
        }
		if(healthNurse.getId()!=null){
			return basHealthNurseDao.updateByPrimaryKeySelective(healthNurse);
		}else{
		    healthNurse.setId(GenerateSequenceUtil.generateSequenceNo());
			return basHealthNurseDao.insert(healthNurse);
		}
	}
	
}
