/**
 * Copyright &copy; 2012-2013 <a href="httparamMap://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.digihealth.anesthesia.basedata.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.digihealth.anesthesia.basedata.formbean.SystemSearchFormBean;
import com.digihealth.anesthesia.basedata.po.BasMedicalTakeReason;
import com.digihealth.anesthesia.common.service.BaseService;
import com.digihealth.anesthesia.common.utils.GenerateSequenceUtil;
import com.digihealth.anesthesia.evt.formbean.Filter;

/**
 * 
     * Title: OperdefService.java    
     * Description: 用药途径Service
     * @author liukui       
     * @created 2015-10-7 下午6:00:54
 */
@Service
public class BasMedicalTakeReasonService extends BaseService {
	
	
	/**
	 * 根据id查询用药理由信息
	 * @param defId
	 * @return
	 */
	public BasMedicalTakeReason queryMedicalTakeReasonById(String medTakeReasonId) {
		return basMedicalTakeReasonDao.queryMedicalTakeReasonById(medTakeReasonId);
	}
	
	/**
	 * 根据页面条件筛选用药理由并排序
	 * @param systemSearchFormBean
	 * @return
	 */
	public List<BasMedicalTakeReason> queryMedicalTakeReasonList(SystemSearchFormBean systemSearchFormBean){
	    if (StringUtils.isEmpty(systemSearchFormBean.getBeid()))
        {
            systemSearchFormBean.setBeid(getBeid());
        }
		if(StringUtils.isEmpty(systemSearchFormBean.getSort())){
			systemSearchFormBean.setSort("medTakeReasonId");
		}
		if(StringUtils.isEmpty(systemSearchFormBean.getOrderBy())){
			systemSearchFormBean.setOrderBy("ASC");
		}
		String filter = "";
		List<Filter> filters = systemSearchFormBean.getFilters();
		if(filters!=null&&filters.size()>0){
			for(int i = 0;i<filters.size();i++){
				if(!StringUtils.isEmpty(filters.get(i).getValue().toString())){
					filter = filter + " AND "+filters.get(i).getField() +" like '%"+filters.get(i).getValue()+"%' ";
				}
			}
		}
		return basMedicalTakeReasonDao.queryMedicalTakeReasonList(filter, systemSearchFormBean);
	}
	/**
	 * 获取查询用药理由条数
	 * @param systemSearchFormBean
	 * @return
	 */
	public int queryMedicalTakeReasonListTotal(SystemSearchFormBean systemSearchFormBean){
	    
	    if (StringUtils.isEmpty(systemSearchFormBean.getBeid()))
        {
            systemSearchFormBean.setBeid(getBeid());
        }
		if(StringUtils.isEmpty(systemSearchFormBean.getSort())){
			systemSearchFormBean.setSort("medTakeReasonId");
		}
		if(StringUtils.isEmpty(systemSearchFormBean.getOrderBy())){
			systemSearchFormBean.setOrderBy("ASC");
		}
		String filter = "";
		List<Filter> filters = systemSearchFormBean.getFilters();
		if(filters!=null&&filters.size()>0){
			for(int i = 0;i<filters.size();i++){
				if(!StringUtils.isEmpty(filters.get(i).getValue().toString())){
					filter = filter + " AND "+filters.get(i).getField() +" like '%"+filters.get(i).getValue()+"%' ";
				}
			}
		}
		return basMedicalTakeReasonDao.queryMedicalTakeReasonListTotal(filter, systemSearchFormBean);
	}
	
	/**
	 * 保存用药理由
	 * @param Medicine
	 */
	@Transactional
	public String saveMedicalTakeReason(BasMedicalTakeReason medicalTakeReason){
	    if (StringUtils.isEmpty(medicalTakeReason.getBeid()))
        {
	        medicalTakeReason.setBeid(getBeid());
        }
		if(StringUtils.isNotBlank(medicalTakeReason.getMedTakeReasonId())){
			basMedicalTakeReasonDao.update(medicalTakeReason);
		}else{
		    medicalTakeReason.setMedTakeReasonId(GenerateSequenceUtil.generateSequenceNo());
			basMedicalTakeReasonDao.insert(medicalTakeReason);
		}
		return "保存成功";
	}
	/**
	 * 删除用药途径信息
	 * @param Medicine
	 */
	@Transactional
	public String deleteMedicalTakeReason(List<String> medTakeReasonIdList){
		for (String medTakeReasonId : medTakeReasonIdList) {
			basMedicalTakeReasonDao.deleteMedicalTakeReason(medTakeReasonId);;
		}
		return "删除成功";
	}
}
