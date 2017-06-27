/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.digihealth.anesthesia.operProceed.dao;

import org.apache.ibatis.annotations.Param;

import com.digihealth.anesthesia.common.persistence.CrudDao;
import com.digihealth.anesthesia.common.persistence.annotation.MyBatisDao;
import com.digihealth.anesthesia.operProceed.po.ObserveDataChangeHis;


/**
 * 
 * @author huchao
 *
 */
@MyBatisDao
public interface ObserveDataChangeHisDao extends CrudDao<ObserveDataChangeHis> {
	
	public void updateObserveUserByRegOptId(@Param("userId") String userId,@Param("time") String time,@Param("regOptId") String regOptId);

}
