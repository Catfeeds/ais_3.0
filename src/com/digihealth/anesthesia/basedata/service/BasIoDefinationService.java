/**
 * Copyright &copy; 2012-2013 <a href="httparamMap://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.digihealth.anesthesia.basedata.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.druid.util.StringUtils;
import com.digihealth.anesthesia.basedata.formbean.BaseInfoQuery;
import com.digihealth.anesthesia.basedata.formbean.IoDefinationFormBean;
import com.digihealth.anesthesia.basedata.formbean.SystemSearchFormBean;
import com.digihealth.anesthesia.basedata.po.BasIoDefination;
import com.digihealth.anesthesia.common.service.BaseService;
import com.digihealth.anesthesia.common.utils.GenerateSequenceUtil;
import com.digihealth.anesthesia.common.utils.PingYinUtil;
import com.digihealth.anesthesia.evt.formbean.Filter;

/**
 * 
     * Title: IoDefinationService.java    
     * Description: 出入量查询接口BaseService
     * @author chengwang       
     * @created 2015-10-7 下午6:00:54
 */
@Service
public class BasIoDefinationService extends BaseService {
	
	public List<IoDefinationFormBean> findList( BaseInfoQuery baseQuery) {
	    if (StringUtils.isEmpty(baseQuery.getBeid()))
        {
	        baseQuery.setBeid(getBeid());
        }
		return basIoDefinationDao.findList(baseQuery);
	}
	
	public List<IoDefinationFormBean> findOutList(){
		return basIoDefinationDao.findOutList(getBeid());
	}
	
	@Transactional
	public int updateIoDefination(BasIoDefination ioDefination) {
		if (null != ioDefination.getName() && !"".equals(ioDefination.getName())) {
			ioDefination.setPinYin(PingYinUtil.getFirstSpell(ioDefination.getName()));
		}
		if (StringUtils.isEmpty(ioDefination.getBeid())) {
			ioDefination.setBeid(getBeid());
		}
		if (StringUtils.isEmpty(ioDefination.getIoDefId())) {
			ioDefination.setIoDefId(GenerateSequenceUtil.generateSequenceNo());
			return basIoDefinationDao.insert(ioDefination);
		} else {
			return basIoDefinationDao.updateByPrimaryKeySelective(ioDefination);
		}
	}
	
	public int deleteByPrimarykey(String id){
		return basIoDefinationDao.deleteByPrimaryKey(id);
	}
	
	public List<BasIoDefination> queryIoDefinationList(SystemSearchFormBean systemSearchFormBean){
	    if (StringUtils.isEmpty(systemSearchFormBean.getBeid()))
        {
	        systemSearchFormBean.setBeid(getBeid());
        }
		if(StringUtils.isEmpty(systemSearchFormBean.getSort())){
			systemSearchFormBean.setSort("ioDefId");
		}
		if(StringUtils.isEmpty(systemSearchFormBean.getOrderBy())){
			systemSearchFormBean.setOrderBy("ASC");
		}
		String filter = "";
		List<Filter> filters = systemSearchFormBean.getFilters();
		if(filters!=null&&filters.size()>0){
			for(int i = 0;i<filters.size();i++){
				if(!StringUtils.isEmpty(filters.get(i).getValue().toString())){
					if (filters.get(i).getField().equals("typeStr")) {
						if ("入量".contains(filters.get(i).getValue())) {
							filters.get(i).setValue("I");
						}else if ("出量".contains(filters.get(i).getValue())) {
							filters.get(i).setValue("O");
						}
						filter += " AND type = '" + filters.get(i).getValue() + "'";
					}else if (filters.get(i).getField().equals("subType")) {
						if ("输液".contains(filters.get(i).getValue())) {
							filters.get(i).setValue("1");
						}else if ("输血".contains(filters.get(i).getValue())) {
							filters.get(i).setValue("2");
						}
						filter += " AND subType = '" + filters.get(i).getValue() + "'";
					}else {
						filter += " AND "+filters.get(i).getField() +" like '%"+filters.get(i).getValue()+"%' ";
					}
				}
			}
		}
		return basIoDefinationDao.queryIoDefinationList(filter, systemSearchFormBean);
	}
	
	public int queryIoDefinationListTotal(SystemSearchFormBean systemSearchFormBean){
	    if (StringUtils.isEmpty(systemSearchFormBean.getBeid()))
        {
            systemSearchFormBean.setBeid(getBeid());
        }
		if(StringUtils.isEmpty(systemSearchFormBean.getSort())){
			systemSearchFormBean.setSort("ioDefId");
		}
		if(StringUtils.isEmpty(systemSearchFormBean.getOrderBy())){
			systemSearchFormBean.setOrderBy("ASC");
		}
		String filter = "";
		List<Filter> filters = systemSearchFormBean.getFilters();
		if(filters!=null&&filters.size()>0){
			for(int i = 0;i<filters.size();i++){
				if(!StringUtils.isEmpty(filters.get(i).getValue().toString())){
					if (filters.get(i).getField().equals("typeStr")) {
						if ("入量".contains(filters.get(i).getValue())) {
							filters.get(i).setValue("I");
						}else if ("出量".contains(filters.get(i).getValue())) {
							filters.get(i).setValue("O");
						}
						filter += " AND type = '" + filters.get(i).getValue() + "'";
					}else if (filters.get(i).getField().equals("subType")) {
						if ("输液".contains(filters.get(i).getValue())) {
							filters.get(i).setValue("1");
						}else if ("输血".contains(filters.get(i).getValue())) {
							filters.get(i).setValue("2");
						}
						filter += " AND subType = '" + filters.get(i).getValue() + "'";
					}else {
						filter += " AND "+filters.get(i).getField() +" like '%"+filters.get(i).getValue()+"%' ";
					}
				}
			}
		}
		return basIoDefinationDao.queryIoDefinationListTotal(filter, systemSearchFormBean);
	}
	
	public BasIoDefination selectByPrimarykey(String ioDefId){
		return basIoDefinationDao.selectByPrimaryKey(ioDefId);
	}
}
