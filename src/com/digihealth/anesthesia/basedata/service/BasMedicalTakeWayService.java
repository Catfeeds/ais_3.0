/**
 * Copyright &copy; 2012-2013 <a href="httparamMap://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.digihealth.anesthesia.basedata.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.digihealth.anesthesia.basedata.formbean.BaseInfoQuery;
import com.digihealth.anesthesia.basedata.formbean.SystemSearchFormBean;
import com.digihealth.anesthesia.basedata.po.BasMedicalTakeWay;
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
public class BasMedicalTakeWayService extends BaseService {
	
	
	public List<BasMedicalTakeWay> findList(BaseInfoQuery baseQuery) {
	    if (StringUtils.isEmpty(baseQuery.getBeid()))
        {
	        baseQuery.setBeid(getBeid());
        }
		return basMedicalTakeWayDao.findList(baseQuery);
	}
	
	
	/**
	 * 根据id查询用药途径信息
	 * @param defId
	 * @return
	 */
	public BasMedicalTakeWay queryMedicalTakeWayById(String medTakeWayId) {
		return basMedicalTakeWayDao.queryMedicalTakeWayById(medTakeWayId);
	}
	
	/**
	 * 根据页面条件筛选用药途径并排序
	 * @param systemSearchFormBean
	 * @return
	 */
	public List<BasMedicalTakeWay> queryMedicalTakeWayList(SystemSearchFormBean systemSearchFormBean){
	    if (StringUtils.isEmpty(systemSearchFormBean.getBeid()))
        {
	        systemSearchFormBean.setBeid(getBeid());
        }
		if(StringUtils.isEmpty(systemSearchFormBean.getSort())){
			systemSearchFormBean.setSort("medTakeWayId");
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
		return basMedicalTakeWayDao.queryMedicalTakeWayList(filter, systemSearchFormBean);
	}
	/**
	 * 获取查询用药途径条数
	 * @param systemSearchFormBean
	 * @return
	 */
	public int queryMedicalTakeWayListTotal(SystemSearchFormBean systemSearchFormBean){
	    if (StringUtils.isEmpty(systemSearchFormBean.getBeid()))
        {
            systemSearchFormBean.setBeid(getBeid());
        }
		if(StringUtils.isEmpty(systemSearchFormBean.getSort())){
			systemSearchFormBean.setSort("medTakeWayId");
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
		return basMedicalTakeWayDao.queryMedicalTakeWayListTotal(filter, systemSearchFormBean);
	}
	
	/**
	 * 保存用药途径
	 * @param Medicine
	 */
	@Transactional
	public String saveMedicalTakeWay(BasMedicalTakeWay medicalTakeWay){
	    if (StringUtils.isEmpty(medicalTakeWay.getBeid()))
        {
	        medicalTakeWay.setBeid(getBeid());
        }
		if(null != medicalTakeWay.getMedTakeWayId()){
			basMedicalTakeWayDao.update(medicalTakeWay);
		}else{
		    medicalTakeWay.setMedTakeWayId(GenerateSequenceUtil.generateSequenceNo());
			basMedicalTakeWayDao.insert(medicalTakeWay);
		}
		return "保存成功";
	}
	/**
	 * 删除用药途径信息
	 * @param Medicine
	 */
	@Transactional
	public String deleteMedicalTakeWay(List<String> medTakeWayIdList){
		for (String medTakeWayId : medTakeWayIdList) {
			basMedicalTakeWayDao.deleteMedicalTakeWay(medTakeWayId);
		}
		return "删除成功";
	}
}
