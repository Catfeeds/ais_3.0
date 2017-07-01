/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.digihealth.anesthesia.basedata.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.digihealth.anesthesia.basedata.formbean.BaseInfoQuery;
import com.digihealth.anesthesia.basedata.formbean.DiagnosedefFormBean;
import com.digihealth.anesthesia.basedata.formbean.SystemSearchFormBean;
import com.digihealth.anesthesia.basedata.po.BasDiagnosedef;
import com.digihealth.anesthesia.common.persistence.CrudDao;
import com.digihealth.anesthesia.common.persistence.annotation.MyBatisDao;


/**
 * 
     * Title: DiagnosedefDao.java    
     * Description: 角色DAO接口
     * @author liukui       
     * @created 2015-10-7 下午5:54:49
 */
@MyBatisDao
public interface BasDiagnosedefDao extends CrudDao<BasDiagnosedef> {
	
	public List<DiagnosedefFormBean> findList(@Param("baseQuery")BaseInfoQuery baseQuery);
	
	public BasDiagnosedef searchDiagnosedefById(@Param("diagDefId")String diagDefId);
	
	public List<BasDiagnosedef> queryDiagnosedefList(@Param("filter")String filter,@Param("systemSearchFormBean")SystemSearchFormBean systemSearchFormBean);

	public int queryDiagnosedefListTotal(@Param("filter")String filter,@Param("systemSearchFormBean")SystemSearchFormBean systemSearchFormBean);
	
	public List<BasDiagnosedef> selectByCode(@Param("code")String code, @Param("beid")String beid);
	
	public int updateEnable(@Param("beid")String beid);
	
	public List<BasDiagnosedef> selectByName(@Param("name")String name, @Param("beid")String beid);
	
	public List<BasDiagnosedef> selectOrderByIdDesc();
	
	public int insertSelective(BasDiagnosedef basDiagnosedef);
	
	public int initData(@Param("basDiagnosedef")BasDiagnosedef basDiagnosedef, @Param("random")String random);
}
