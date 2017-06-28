/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.digihealth.anesthesia.basedata.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.digihealth.anesthesia.basedata.formbean.AnaesMethodFormBean;
import com.digihealth.anesthesia.basedata.formbean.BaseInfoQuery;
import com.digihealth.anesthesia.basedata.formbean.SystemSearchFormBean;
import com.digihealth.anesthesia.basedata.po.BasAnaesMethod;
import com.digihealth.anesthesia.common.persistence.CrudDao;
import com.digihealth.anesthesia.common.persistence.annotation.MyBatisDao;


/**
 * 
     * Title: AnaesMethodDao.java    
     * Description: 角色DAO接口
     * @author liukui       
     * @created 2015-10-7 下午5:54:49
 */
@MyBatisDao
public interface BasAnaesMethodDao extends CrudDao<BasAnaesMethod> {

	List<BasAnaesMethod> selectEntityList(BasAnaesMethod params);
	
	public List<AnaesMethodFormBean> findList(@Param("baseQuery") BaseInfoQuery baseQuery);
	
	public List<BasAnaesMethod> findAllList(@Param("baseQuery") BaseInfoQuery baseQuery);
	
	public int updateSql(@Param("sql")String sql);
	
	public List<BasAnaesMethod> queryAnaesMethodList(@Param("filter")String filter,@Param("systemSearchFormBean")SystemSearchFormBean systemSearchFormBean);

	public int queryAnaesMethodListTotal(@Param("filter")String filter,@Param("systemSearchFormBean")SystemSearchFormBean systemSearchFormBean);
	
	public BasAnaesMethod searchAnaesMethodById(@Param("anaMedId")String anaMedId);
	
	public List<BasAnaesMethod> searchAnaesMethodOrberById(@Param("beid")String beid);
	
	public List<BasAnaesMethod> selectByCode(@Param("code")String code, @Param("beid")String beid);
	
	public List<BasAnaesMethod> selectByName(@Param("name")String name, @Param("beid")String beid);
	
	public int updateEnable(@Param("beid")String beid);
	
	public List<BasAnaesMethod> selectAnaesMethodByBeid(@Param("beid")String beid);
	
	public int deleteAnaesMethodByBeid(@Param("beid")String beid);
	
	public int insertSelective(BasAnaesMethod params);
}
