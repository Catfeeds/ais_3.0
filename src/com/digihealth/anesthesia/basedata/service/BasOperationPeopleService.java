/**
 * Copyright &copy; 2012-2013 <a href="httparamMap://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.digihealth.anesthesia.basedata.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.digihealth.anesthesia.basedata.formbean.BaseInfoQuery;
import com.digihealth.anesthesia.basedata.formbean.OperPeopleFormBean;
import com.digihealth.anesthesia.basedata.formbean.SystemSearchFormBean;
import com.digihealth.anesthesia.sysMng.formbean.UserInfoFormBean;
import com.digihealth.anesthesia.basedata.po.BasOperationPeople;
import com.digihealth.anesthesia.common.service.BaseService;
import com.digihealth.anesthesia.common.utils.GenerateSequenceUtil;
import com.digihealth.anesthesia.common.utils.PingYinUtil;
import com.digihealth.anesthesia.evt.formbean.Filter;

/**
 * 
     * Title: OperationPeopleService.java    
     * Description: 手术人员Service
     * @author liukui       
     * @created 2015-10-7 下午6:00:54
 */
@Service
public class BasOperationPeopleService extends BaseService {
	
	
	public List<OperPeopleFormBean> findList(BaseInfoQuery baseQuery) {
	    if (StringUtils.isBlank(baseQuery.getBeid()))
        {
	        baseQuery.setBeid(getBeid());
        }
		return basOperationPeopleDao.findList(baseQuery);
	}
	
	public List<UserInfoFormBean> getSelectOperPeopleList(BaseInfoQuery baseQuery) {
	    if (StringUtils.isBlank(baseQuery.getBeid()))
        {
            baseQuery.setBeid(getBeid());
        }
		return basOperationPeopleDao.getSelectOperPeopleList(baseQuery == null?new BaseInfoQuery():baseQuery);
	}
	
	/**
	 * 根据id查询手术人员信息
	 * @param defId
	 * @return
	 */
	public BasOperationPeople queryOperationPeopleById(String operatorId) {
		return basOperationPeopleDao.queryOperationPeopleById(operatorId);
	}
	
	/**
	 * 根据页面条件筛选手术人员并排序
	 * @param systemSearchFormBean
	 * @return
	 */
	public List<BasOperationPeople> queryOperationPeopleList(SystemSearchFormBean systemSearchFormBean){
	    if (StringUtils.isBlank(systemSearchFormBean.getBeid()))
        {
	        systemSearchFormBean.setBeid(getBeid());
        }
		if(StringUtils.isEmpty(systemSearchFormBean.getSort())){
			systemSearchFormBean.setSort("operatorId");
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
//		filter += " AND beid = '" + getBeid() + "'";
		return basOperationPeopleDao.queryOperationPeopleList(filter, systemSearchFormBean);
	}
	/**
	 * 获取查询手术人员条数
	 * @param systemSearchFormBean
	 * @return
	 */
	public int queryOperationPeopleListTotal(SystemSearchFormBean systemSearchFormBean){
	    if (StringUtils.isBlank(systemSearchFormBean.getBeid()))
        {
            systemSearchFormBean.setBeid(getBeid());
        }
		if(StringUtils.isEmpty(systemSearchFormBean.getSort())){
			systemSearchFormBean.setSort("operatorId");
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
		return basOperationPeopleDao.queryOperationPeopleListTotal(filter, systemSearchFormBean);
	}
	
	/**
	 * 保存手术人员
	 * @param Medicine
	 */
	@Transactional
	public String saveOperationPeople(BasOperationPeople operationPeople){
	    if (StringUtils.isBlank(operationPeople.getBeid()))
        {
	        operationPeople.setBeid(getBeid());
        }
		
		if(null != operationPeople.getOperatorId()){
			basOperationPeopleDao.update(operationPeople);
		}else{
			SystemSearchFormBean params = new SystemSearchFormBean();
			params.setBeid(operationPeople.getBeid());
			int total = basOperationPeopleDao.queryOperationPeopleListTotal("", params);
		    operationPeople.setOperatorId(GenerateSequenceUtil.generateSequenceNo());
		    operationPeople.setCode(total + 1 + "");
			if(StringUtils.isNotBlank(operationPeople.getName())){
				operationPeople.setPinYin(PingYinUtil.getFirstSpell(operationPeople.getName()));
			}
			basOperationPeopleDao.insert(operationPeople);
		}
		return "保存成功";
	}
	/**
	 * 删除手术人员信息
	 * @param Medicine
	 */
	@Transactional
	public String deleteOperationPeople(List<String> operationPeopleIdList){
		for (String operationPeopleId : operationPeopleIdList) {
			basOperationPeopleDao.deleteOperationPeople(operationPeopleId);
		}
		return "删除成功";
	}
	
	
}
