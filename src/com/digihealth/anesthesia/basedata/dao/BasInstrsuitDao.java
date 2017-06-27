/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.digihealth.anesthesia.basedata.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.digihealth.anesthesia.basedata.formbean.BaseInfoQuery;
import com.digihealth.anesthesia.basedata.formbean.SystemSearchFormBean;
import com.digihealth.anesthesia.basedata.po.BasInstrsuit;
import com.digihealth.anesthesia.common.persistence.CrudDao;
import com.digihealth.anesthesia.common.persistence.annotation.MyBatisDao;


/**
 * 
     * Title: InstrSuitRelDao.java    
     * Description: 手术包DAO接口
     * @author liukui       
     * @created 2015-10-7 下午5:54:49
 */
@MyBatisDao
public interface BasInstrsuitDao extends CrudDao<BasInstrsuit> {
	
	public List<BasInstrsuit> findList(@Param("baseQuery")BaseInfoQuery baseQuery);
	
	public void updateInstrsuit(BasInstrsuit instrsuit);
	
	public void insertInstrsuit(BasInstrsuit instrsuit);
	
    public List<BasInstrsuit> queryInstrsuitList(@Param("filter")String filter,@Param("systemSearchFormBean")SystemSearchFormBean systemSearchFormBean);

	public int queryInstrsuitListTotal(@Param("filter")String filter,@Param("systemSearchFormBean")SystemSearchFormBean systemSearchFormBean);
	
	public BasInstrsuit searchInstrsuitById(@Param("instrsuitId")String instrsuitId);
	
	public List<BasInstrsuit> searchInstrsuitOrderId();
	
}
