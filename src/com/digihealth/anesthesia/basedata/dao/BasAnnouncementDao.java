/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.digihealth.anesthesia.basedata.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.digihealth.anesthesia.basedata.formbean.SystemSearchFormBean;
import com.digihealth.anesthesia.basedata.po.BasAnnouncement;
import com.digihealth.anesthesia.common.persistence.CrudDao;
import com.digihealth.anesthesia.common.persistence.annotation.MyBatisDao;


/**
 * 
     * Title: AnnouncementDao.java    
     * Description: 公告DAO接口
     * @author liukui       
     * @created 2015-10-7 下午5:54:49
 */
@MyBatisDao
public interface BasAnnouncementDao extends CrudDao<BasAnnouncement> {
	
	public List<BasAnnouncement> searchAllAnnouncement(@Param("filter")String filter, @Param("systemSearchFormBean")SystemSearchFormBean systemSearchFormBean);
	
	public int searchAllAnnouncementTotal(@Param("beid")String beid);
	
	public int deleteById(@Param("id")String id);
	
	//查询局点下所有的公告信息，状态不管是否有效
	public List<BasAnnouncement> searchAnnouncementByBeid(@Param("beid")String beid);
	
	public int updateByPrimaryKeySelective(BasAnnouncement basAnnouncement);
	
	public int insertSelective(BasAnnouncement basAnnouncement);
	
}
