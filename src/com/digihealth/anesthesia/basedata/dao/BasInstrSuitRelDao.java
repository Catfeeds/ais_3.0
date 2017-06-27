/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.digihealth.anesthesia.basedata.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.digihealth.anesthesia.basedata.po.BasInstrSuitRel;
import com.digihealth.anesthesia.common.persistence.CrudDao;
import com.digihealth.anesthesia.common.persistence.annotation.MyBatisDao;


/**
 * 
     * Title: InstrSuitRelDao.java    
     * Description: 手术包器械耗材关联表DAO接口
     * @author chengwang       
     * @created 2015-10-7 下午5:54:49
 */
@MyBatisDao
public interface BasInstrSuitRelDao extends CrudDao<BasInstrSuitRel> {
	
	public List<BasInstrSuitRel> findList(@Param("instrsuitId")String instrsuitId);
	
	public void updateInstrSuitRel(BasInstrSuitRel instrSuitRel);
	
	public void insertInstrSuitRel(BasInstrSuitRel instrSuitRel);
	
	/**
	 * 
	     * @discription 通过手术包CODE获取器械CODE
	     * @author chengwang       
	     * @created 2015-10-22 下午5:25:38     
	     * @param instrsuitCode
	     * @return
	 */
	public List<BasInstrSuitRel> searchInstrumentCodeByInstrsuitCode(@Param("instrsuitId")String instrsuitId);
	
	public int deleteById(@Param("instrSuitRelId")String instrSuitRelId);
	
	public int deleteByInstrsuitId(@Param("instrsuitId")String instrsuitId);
}
