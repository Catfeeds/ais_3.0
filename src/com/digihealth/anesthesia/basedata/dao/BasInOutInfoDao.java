/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.digihealth.anesthesia.basedata.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.digihealth.anesthesia.basedata.formbean.SystemSearchFormBean;
import com.digihealth.anesthesia.basedata.po.BasInOutInfo;
import com.digihealth.anesthesia.common.persistence.CrudDao;
import com.digihealth.anesthesia.common.persistence.annotation.MyBatisDao;


/**
 * 
     * Title: InOutInfoDao.java    
     * Description: 出入库dao
     * @author chengwang       
     * @created 2015年12月15日 上午10:39:28 
 */
@MyBatisDao
public interface BasInOutInfoDao extends CrudDao<BasInOutInfo> {
	
	public BasInOutInfo searchInOutInfoById(@Param("ioId")String ioId);
	
	public List<BasInOutInfo> queryInOutInfoList(@Param("filter")String filter,@Param("groupId")String groupId,@Param("systemSearchFormBean")SystemSearchFormBean systemSearchFormBean);

	public int queryInOutInfoListTotal(@Param("filter")String filter,@Param("systemSearchFormBean")SystemSearchFormBean systemSearchFormBean);
	
	public int deleteInOutInfoById(@Param("ioId")String ioId);
}
