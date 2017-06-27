/**
 * Copyright &copy; 2012-2013 <a href="httparamMap://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.digihealth.anesthesia.basedata.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.digihealth.anesthesia.basedata.formbean.BaseInfoQuery;
import com.digihealth.anesthesia.basedata.formbean.OperDefFormBean;
import com.digihealth.anesthesia.basedata.formbean.SystemSearchFormBean;
import com.digihealth.anesthesia.basedata.po.BasOperdef;
import com.digihealth.anesthesia.common.service.BaseService;
import com.digihealth.anesthesia.common.utils.GenerateSequenceUtil;
import com.digihealth.anesthesia.common.utils.PingYinUtil;
import com.digihealth.anesthesia.evt.formbean.Filter;

/**
 * 
     * Title: OperdefService.java    
     * Description: 手术名称Service
     * @author liukui       
     * @created 2015-10-7 下午6:00:54
 */
@Service
public class BasOperdefService extends BaseService {
	
	
	public List<OperDefFormBean> findList(BaseInfoQuery baseQuery) {
	    if (StringUtils.isEmpty(baseQuery.getBeid()))
        {
	        baseQuery.setBeid(getBeid());
        }
		return basOperdefDao.findList(baseQuery == null?new BaseInfoQuery():baseQuery);
	}
	
	
	
	public BasOperdef queryOperdefById(String operdefId) {
		return basOperdefDao.queryOperdefById(operdefId);
	}
	
	
	public List<BasOperdef> queryOperdefList(SystemSearchFormBean systemSearchFormBean){
	    if (StringUtils.isEmpty(systemSearchFormBean.getBeid()))
        {
	        systemSearchFormBean.setBeid(getBeid());
        }
		if(StringUtils.isEmpty(systemSearchFormBean.getSort())){
			systemSearchFormBean.setSort("operdefId");
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
		return basOperdefDao.queryOperdefList(filter, systemSearchFormBean);
	}
	
	public int queryOperdefListTotal(SystemSearchFormBean systemSearchFormBean){
	    if (StringUtils.isEmpty(systemSearchFormBean.getBeid()))
        {
            systemSearchFormBean.setBeid(getBeid());
        }
		if(StringUtils.isEmpty(systemSearchFormBean.getSort())){
			systemSearchFormBean.setSort("operdefId");
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
		return basOperdefDao.queryOperdefListTotal(filter, systemSearchFormBean);
	}
	
	/**
	 * 保存手术名称
	 * @param operdef
	 */
	@Transactional
	public String saveOperdef(BasOperdef operdef){
	    if (StringUtils.isEmpty(operdef.getBeid()))
        {
	        operdef.setBeid(getBeid());
        }
		if(StringUtils.isNotBlank(operdef.getOperdefId())){
			basOperdefDao.update(operdef);
		}else{
			if(StringUtils.isNotBlank(operdef.getName())){
				operdef.setPinYin(PingYinUtil.getFirstSpell(operdef.getName()));
			}
			operdef.setOperdefId(GenerateSequenceUtil.generateSequenceNo()); 
			basOperdefDao.insert(operdef);
		}
		return "保存成功";
	}
	/**
	 * 删除手术名称
	 * @param operdef
	 */
	@Transactional
	public String deleteOperdef(List<String> operdefIdList){
		for (String operdefId : operdefIdList) {
			basOperdefDao.deleteOperdef(operdefId);
		}
		return "删除成功";
	}
	
	public List<BasOperdef> selectByCode(String code){
		return basOperdefDao.selectByCode(code, getBeid());
	}
	@Transactional
	public int updateEnable(){
		return basOperdefDao.updateEnable(getBeid());
	}
	
	
}

