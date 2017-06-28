/**
 * Copyright &copy; 2012-2013 <a href="httparamMap://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.digihealth.anesthesia.basedata.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.druid.util.StringUtils;
import com.digihealth.anesthesia.basedata.formbean.BaseInfoQuery;
import com.digihealth.anesthesia.basedata.formbean.SystemSearchFormBean;
import com.digihealth.anesthesia.basedata.po.BasAnnouncement;
import com.digihealth.anesthesia.basedata.utils.UserUtils;
import com.digihealth.anesthesia.common.config.Global;
import com.digihealth.anesthesia.common.service.BaseService;
import com.digihealth.anesthesia.common.utils.DateUtils;
import com.digihealth.anesthesia.common.utils.GenerateSequenceUtil;
import com.digihealth.anesthesia.evt.formbean.Filter;
import com.digihealth.anesthesia.sysMng.po.BasUser;

/**
 * 
     * Title: AnnouncementService.java    
     * Description: 日志Service
     * @author chengwang       
     * @created 2015-10-7 下午6:00:54
 */
@Service
public class BasAnnouncementService extends BaseService {
	
	public List<BasAnnouncement> searchAllAnnouncement(SystemSearchFormBean systemSearchFormBean){
        if (StringUtils.isEmpty(systemSearchFormBean.getBeid())) {
            systemSearchFormBean.setBeid(getBeid());
        }
		if(StringUtils.isEmpty(systemSearchFormBean.getSort())){
			systemSearchFormBean.setSort("time");
		}
		if(StringUtils.isEmpty(systemSearchFormBean.getOrderBy())){
			systemSearchFormBean.setOrderBy("DESC");
		}
		String filter = "";
		List<Filter> filters = systemSearchFormBean.getFilters();
		if(filters!=null&&filters.size()>0){
			for(int i = 0;i<filters.size();i++){
				if(!StringUtils.isEmpty(filters.get(i).getValue().toString())){
					if (filters.get(i).getField().equals("createUserName")) {
						filter += " AND createUser IN (SELECT userName FROM bas_user WHERE `name` LIKE '%" + filters.get(i).getValue() + "%' AND beid = '" + systemSearchFormBean.getBeid() + "')";
					}else if (filters.get(i).getField().equals("timeStr")) {
						filter += " AND time like '%" + filters.get(i).getValue() + "%'";
					}else {
						filter += filter + " AND "+filters.get(i).getField() +" like '%"+filters.get(i).getValue()+"%' ";
					}
				}
			}
		}
		return basAnnouncementDao.searchAllAnnouncement(filter, systemSearchFormBean);
	}
	
	public int searchAllAnnouncementTotal(){
		return basAnnouncementDao.searchAllAnnouncementTotal(getBeid());
	}
	
	@Transactional
	public int deleteById(String id){
		return basAnnouncementDao.deleteById(id);
	}
	
	@Transactional
	public int saveAnnouncement(BasAnnouncement announcement){
		BasUser user = UserUtils.getUserCache();
	    if (StringUtils.isEmpty(announcement.getBeid())) {
	        announcement.setBeid(getBeid());
	    }
	    if (user != null) {
	    	announcement.setCreateUser(user.getUserName());
	    }
	    announcement.setEnable(1);
		announcement.setTime(DateUtils.getCurrDate());
		announcement.setId(GenerateSequenceUtil.generateSequenceNo());
		return basAnnouncementDao.insert(announcement);
	}
	
	/**
	 * 查询局点的公告信息 
	 */
	public List<BasAnnouncement> searchAnnouncementByBeid()
	{
		 String beid = basBusEntityDao.getBeid();
		 return basAnnouncementDao.searchAnnouncementByBeid(beid);
	}
	
	/**
	 * 修改的公告信息 
	 */
	@Transactional
	public int updateBasAnnouncement(BasAnnouncement basAnnouncement)
	{
		return basAnnouncementDao.updateByPrimaryKeySelective(basAnnouncement);
	}
}
