/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.digihealth.anesthesia.basedata.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.digihealth.anesthesia.basedata.formbean.BaseInfoQuery;
import com.digihealth.anesthesia.basedata.formbean.SystemSearchFormBean;
import com.digihealth.anesthesia.basedata.po.BasInstrument;
import com.digihealth.anesthesia.common.persistence.CrudDao;
import com.digihealth.anesthesia.common.persistence.annotation.MyBatisDao;


/**
 * 
     * Title: InstrumentDao.java    
     * Description: 基本器械DAO
     * @author chengwang       
     * @created 2015-10-22 下午5:17:53
 */
@MyBatisDao
public interface BasInstrumentDao extends CrudDao<BasInstrument> {
	
	/**
	 * 
	     * @discription 在此输入一句话描述作用
	     * @author chengwang       
	     * @created 2015-10-22 下午5:17:46     
	     * @param code
	     * @return
	 */
	public BasInstrument searchInstrumentByInstrumentId(@Param("instrumentId")String instrumentId);
	
	public List<BasInstrument> searchInstrument(@Param("baseQuery")BaseInfoQuery baseQuery);
	
	
	public List<BasInstrument> queryInstrumentList(@Param("filter")String filter,@Param("systemSearchFormBean")SystemSearchFormBean systemSearchFormBean);

	public int queryInstrumentListTotal(@Param("filter")String filter,@Param("systemSearchFormBean")SystemSearchFormBean systemSearchFormBean);
	
	public BasInstrument searchInstrumentById(@Param("instrumentId")String instrumentId);
	
	public List<BasInstrument> queryInstrumentByInstrsuitId(@Param("instrsuitId")String instrsuitId);
	
	public List<BasInstrument> selectByCode(@Param("code")String code, @Param("beid")String beid);
	
	public int updateEnable(@Param("beid")String beid);
}
