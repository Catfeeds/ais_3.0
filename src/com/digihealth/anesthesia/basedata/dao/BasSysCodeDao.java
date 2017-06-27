/*
 * BasSysCodeDao.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-03-31 Created
 */
package com.digihealth.anesthesia.basedata.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.digihealth.anesthesia.basedata.formbean.AnaesEventFormBean;
import com.digihealth.anesthesia.basedata.formbean.SysCodeFormbean;
import com.digihealth.anesthesia.basedata.formbean.SystemSearchFormBean;
import com.digihealth.anesthesia.basedata.po.BasSysCode;
import com.digihealth.anesthesia.common.persistence.CrudDao;
import com.digihealth.anesthesia.common.persistence.annotation.MyBatisDao;

@MyBatisDao
public interface BasSysCodeDao extends CrudDao<BasSysCode>{
    int insertSelective(BasSysCode record);

    int insert(BasSysCode record);
    
    int updateByPrimaryKeySelective(BasSysCode record);
    
    public List<SysCodeFormbean> searchSysCodeByGroupId(@Param("groupId")String groupId,@Param("beid")String beid);
    
    public List<SysCodeFormbean> searchSysCodeByGroupIdAndCodeValue(@Param("groupId")String groupId,@Param("codeValue")String codeValue,@Param("beid")String beid);
    
    public void deleteByGroupId(@Param("groupId")String groupId,@Param("beid")String beid);
    
    public List<SysCodeFormbean> searchSysCodeByGroupIdAndCodeName(@Param("groupId")String groupId,@Param("codeName")String codeName,@Param("beid")String beid);

	public List<AnaesEventFormBean> searchAnaesEvent(@Param("filter")String filter,@Param("systemSearchFormBean")SystemSearchFormBean systemSearchFormBean);
	
	public Integer searchAnaesEventTotal(@Param("filter")String filter,@Param("systemSearchFormBean")SystemSearchFormBean systemSearchFormBean);

	public void insertAnaesEvent(AnaesEventFormBean anaesEventFormBean);

	public void updateAnaesEvent(AnaesEventFormBean anaesEventFormBean);
	
	public void deleteAnaesEvent(@Param("sysCodeId")String sysCodeId);

	public Integer getMaxCodeValue(@Param("beid")String beid);
	
	public Integer getMaxOrder(@Param("beid")String beid);
}