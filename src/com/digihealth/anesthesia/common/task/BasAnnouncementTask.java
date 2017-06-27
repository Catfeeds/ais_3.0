package com.digihealth.anesthesia.common.task;

import java.util.Date;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.digihealth.anesthesia.basedata.po.BasAnnouncement;
import com.digihealth.anesthesia.basedata.service.BasAnnouncementService;
import com.digihealth.anesthesia.common.config.Global;
import com.digihealth.anesthesia.common.utils.SpringContextHolder;

public class BasAnnouncementTask
{
	private BasAnnouncementService basAnnouncementService;
	public void job()
	{
		basAnnouncementService = SpringContextHolder.getBean("basAnnouncementService");
		updateAnnouncementEnable();
	}
	
	/**
	 * 定时任务处理方法，将超过指定日期的公告设置为无效的。 
	 */
	@Transactional
	public void updateAnnouncementEnable()
	{
		List<BasAnnouncement> basAnnouncementList = basAnnouncementService.searchAnnouncementByBeid();
		if(null != basAnnouncementList && basAnnouncementList.size()>0)
		{
			for(BasAnnouncement basAnnouncement : basAnnouncementList)
			{
				Date time = basAnnouncement.getTime();
				Date nowTime = new Date();
				//获取系统参数
				String days = Global.getConfig("announcementEnableDays").toString();
				int enableDays = Integer.parseInt(days);
				if(nowTime.getTime() - time.getTime() > enableDays*24*60*60*1000)
				{
					basAnnouncement.setEnable(0);
				}else
				{
					basAnnouncement.setEnable(1);
				}
				
				basAnnouncementService.updateBasAnnouncement(basAnnouncement);
			}
		}
	}
}
