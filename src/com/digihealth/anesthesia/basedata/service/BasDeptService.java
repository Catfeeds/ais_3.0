/**
 * Copyright &copy; 2012-2013 <a href="httparamMap://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.digihealth.anesthesia.basedata.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.digihealth.anesthesia.basedata.formbean.BaseInfoQuery;
import com.digihealth.anesthesia.basedata.formbean.DeptFormBean;
import com.digihealth.anesthesia.basedata.formbean.SystemSearchFormBean;
import com.digihealth.anesthesia.basedata.po.BasDept;
import com.digihealth.anesthesia.common.service.BaseService;
import com.digihealth.anesthesia.common.utils.GenerateSequenceUtil;
import com.digihealth.anesthesia.common.utils.PingYinUtil;
import com.digihealth.anesthesia.evt.formbean.Filter;
/**
 * 
     * Title: DeptService.java    
     * Description: 科室Service
     * @author liukui       
     * @created 2015-10-7 下午6:00:54
 */
@Service
public class BasDeptService extends BaseService {
	
	/**
	 * 当传入的查询条件为空时，需要构建一个查询对象
	 * @param baseQuery
	 * @return
	 */
	public List<DeptFormBean> findList(BaseInfoQuery baseQuery) {
	    String beid = baseQuery.getBeid();
        if (StringUtils.isEmpty(beid)) {
            beid = getBeid();
        }
        baseQuery.setBeid(beid);
		return basDeptDao.findList(baseQuery);
	}
	
	public BasDept searchDeptById(String deptId){
		return basDeptDao.searchDeptById(deptId);
	}
	
	public List<BasDept> queryDeptList(SystemSearchFormBean systemSearchFormBean){
	    if (StringUtils.isBlank(systemSearchFormBean.getBeid()))
	    {
	        systemSearchFormBean.setBeid(getBeid());
	    }
		if(StringUtils.isEmpty(systemSearchFormBean.getSort())){ 
			systemSearchFormBean.setSort("deptId");
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
		return basDeptDao.queryDeptList(filter, systemSearchFormBean, getBeid());
	}
	
	public int queryDeptListTotal(SystemSearchFormBean systemSearchFormBean){
	    
	    if (StringUtils.isBlank(systemSearchFormBean.getBeid()))
        {
            systemSearchFormBean.setBeid(getBeid());
        }
		if(StringUtils.isEmpty(systemSearchFormBean.getSort())){
			systemSearchFormBean.setSort("deptId");
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
		return basDeptDao.queryDeptListTotal(filter, systemSearchFormBean, getBeid());
	}
	
	
	@Transactional
	public String updateDept(BasDept dept){
	    if (StringUtils.isBlank(dept.getBeid()))
	    {
	        dept.setBeid(getBeid());
	    }
		if (StringUtils.isNotBlank(dept.getDeptId())) {
			dept.setPinYin(PingYinUtil.getFirstSpell(dept.getName()));
			basDeptDao.updateByPrimaryKey(dept);
			return "修改科室成功";
		} else {
		    dept.setDeptId(GenerateSequenceUtil.generateSequenceNo());
		    dept.setPinYin(PingYinUtil.getFirstSpell(dept.getName()));
			basDeptDao.insert(dept);
			return "创建科室成功";
		}
	}
	
}
