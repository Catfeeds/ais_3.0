/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.digihealth.anesthesia.basedata.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.digihealth.anesthesia.basedata.formbean.BaseInfoQuery;
import com.digihealth.anesthesia.basedata.formbean.DeptFormBean;
import com.digihealth.anesthesia.basedata.formbean.SystemSearchFormBean;
import com.digihealth.anesthesia.basedata.po.BasDept;
import com.digihealth.anesthesia.common.persistence.CrudDao;
import com.digihealth.anesthesia.common.persistence.annotation.MyBatisDao;


/**
 * 
     * Title: DeptDao.java    
     * Description: 科室
     * @author liukui       
     * @created 2015-10-7 下午5:54:49
 */
@MyBatisDao
public interface BasDeptDao extends CrudDao<BasDept> {
	
	public List<DeptFormBean> findList(@Param("baseQuery") BaseInfoQuery baseQuery);
	
	public BasDept searchDeptById(@Param("deptId")String deptId);
	
	public List<BasDept> queryDeptList(@Param("filter")String filter,@Param("systemSearchFormBean")SystemSearchFormBean systemSearchFormBean,@Param("beid")String beid);

	public int queryDeptListTotal(@Param("filter")String filter,@Param("systemSearchFormBean")SystemSearchFormBean systemSearchFormBean,@Param("beid")String beid);
	
	public List<BasDept> selectByCode(@Param("code")String code);

    int updateByPrimaryKey(BasDept basDept);
    
	public int updateEnable(@Param("beid")String beid);
}
