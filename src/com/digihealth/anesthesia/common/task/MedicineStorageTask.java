package com.digihealth.anesthesia.common.task;

import java.util.Date;
import java.util.List;

import com.digihealth.anesthesia.basedata.po.BasAnaesMedicineStorage;
import com.digihealth.anesthesia.basedata.po.BasAnaesMedicineStorageHis;
import com.digihealth.anesthesia.basedata.service.BasAnaesMedicineStorageHisService;
import com.digihealth.anesthesia.basedata.service.BasAnaesMedicineStorageService;
import com.digihealth.anesthesia.common.utils.SpringContextHolder;

public class MedicineStorageTask
{

	private BasAnaesMedicineStorageService basAnaesMedicineStorageService;
	private BasAnaesMedicineStorageHisService basAnaesMedicineStorageHisService;
	
	public void job()
	{
		basAnaesMedicineStorageService = SpringContextHolder.getBean("basAnaesMedicineStorageService");
		basAnaesMedicineStorageHisService = SpringContextHolder.getBean("basAnaesMedicineStorageHisService");
		statisticMedicineStorage();
	}
	
	/**
	 * 月底盘点毒麻药数据
	 */
	public void statisticMedicineStorage()
	{
		Date statisticsTime = new Date();
		List<BasAnaesMedicineStorage> basStorageList = basAnaesMedicineStorageService.queryAnaesMedicineStorageByBeid();
		if(null != basStorageList && basStorageList.size()>0)
		{
			for(BasAnaesMedicineStorage basAnaesMedicineStorage : basStorageList )
			{
				BasAnaesMedicineStorageHis basAnaesMedicineStorageHis = new BasAnaesMedicineStorageHis();
				basAnaesMedicineStorageHis.setStorageId(basAnaesMedicineStorage.getId());
				basAnaesMedicineStorageHis.setBeid(basAnaesMedicineStorage.getBeid());
				basAnaesMedicineStorageHis.setStatisticsNum(basAnaesMedicineStorage.getNumber());
				basAnaesMedicineStorageHis.setStatisticsTime(statisticsTime);
				basAnaesMedicineStorageHisService.saveBasAnaesMedicineStorageHis(basAnaesMedicineStorageHis);
			}
		}
	}
}
