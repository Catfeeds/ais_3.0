package com.digihealth.anesthesia.basedata.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.digihealth.anesthesia.basedata.formbean.BasAnaesMedicineLoseRecordFormBean;
import com.digihealth.anesthesia.basedata.formbean.StatisticsFormbean;
import com.digihealth.anesthesia.basedata.formbean.SystemSearchFormBean;
import com.digihealth.anesthesia.common.service.BaseService;
import com.digihealth.anesthesia.common.utils.DateUtils;
import com.digihealth.anesthesia.common.utils.StringUtils;
import com.digihealth.anesthesia.evt.formbean.Filter;

@Service
public class BasAnaesMedicineLoseRecordService extends BaseService
{
	//查询毒麻药取药记录列表
	public List<BasAnaesMedicineLoseRecordFormBean>  queryMedicineLoseRecordList(SystemSearchFormBean systemSearchFormBean)
	{
		if (StringUtils.isEmpty(systemSearchFormBean.getSort()))
		{
			systemSearchFormBean.setSort("id");
		}
		if (StringUtils.isEmpty(systemSearchFormBean.getOrderBy()))
		{
			systemSearchFormBean.setOrderBy("ASC");
		}
		
		String startTime = "";
		String endTime = "";
		String queryType = "";
		List<Filter> filters = systemSearchFormBean.getFilters();
		// 防止页面未传递filters
		if (null == filters)
		{
			filters = new ArrayList<Filter>();
		}
		for (Filter filter : filters)
		{
			if (filter.getField().equals("startTime"))
			{
				startTime = filter.getValue();
			}
			if (filter.getField().equals("endTime"))
			{
				endTime = filter.getValue();
			}
			if (filter.getField().equals("queryType"))
			{
				queryType = filter.getValue();
			}
		}
		if ("1".equals(queryType))
		{
			int year = Integer.parseInt(startTime);
			int month = 12;
			if (startTime.equals(DateUtils.getYear()))
			{
				month = Integer.parseInt(DateUtils.getMonth()) - 1;
			}
			if (month >= 1)
			{
				for (int i = 1; i <= month; i++)
				{
					if (i == 1)
					{
						startTime = DateUtils.formatDate(DateUtils
								.getFirstDayOfMonth(year, i - 1));
					}
					if (month == i)
					{
						endTime = DateUtils.formatDate(DateUtils
								.getLastDayOfMonth(year, i - 1));
					}
				}
			}
			Filter ft = new Filter();
			ft.setField("endTime");
			ft.setValue(endTime);
			filters.add(ft);
			for (Filter f : filters)
			{
				if (f.getField().equals("startTime"))
				{
					f.setValue(startTime);
				}
				if (f.getField().equals("endTime"))
				{
					f.setValue(endTime);
				}
			}
		}
		Filter filter = new Filter();
		filter.setField("beid");
		filter.setValue(getBeid());
		filters.add(filter);
		
		return basAnaesMedicineLoseRecordDao.queryMedicineLoseRecordList(
				filters, systemSearchFormBean);
	}
	
	//查询毒麻药入库信息数量
	public int queryMedicineLoseRecordListTotal(SystemSearchFormBean systemSearchFormBean)
	{
		List<Filter> filters = systemSearchFormBean.getFilters();
		return basAnaesMedicineLoseRecordDao.queryMedicineLoseRecordListTotal(filters);
	}
	
    /**
     * 查询报损数量
     * @param startDt
     * @param endDt
     * @param queryType 1按月查询，2按时间区间
     * @return
     */
    public List<StatisticsFormbean> queryMedicineLoseRecordForLine(String startDt,String endDt,String queryType){
        
        String startTime = "";
        String endTime = "";
        
        List<StatisticsFormbean> resultList = new ArrayList<StatisticsFormbean>();
        
        if(queryType.equals("1")){
            int year = Integer.parseInt(startDt);
            int month = 12;
            if(startDt.equals(DateUtils.getYear())){
                month = Integer.parseInt(DateUtils.getMonth())-1;
            }
            //如果查询年份大于当前年份直接返回
            if(Integer.parseInt(startDt)>Integer.parseInt(DateUtils.getYear())){
                return resultList;
            }
            
            if(month>=1){
                for (int i = 1; i <= month; i++) {
                    startTime = DateUtils.formatDate(DateUtils.getFirstDayOfMonth(year, i - 1));
                    endTime = DateUtils.formatDate(DateUtils.getLastDayOfMonth(year, i - 1));
                    StatisticsFormbean record = new StatisticsFormbean();
                    record.setName(i+"月");
                    Integer loseNum = basAnaesMedicineLoseRecordDao.queryMedicineLoseRecordForLine(startTime, endTime, getBeid());
                    record.setDay(loseNum + "");
                    resultList.add(record);
                }
            }
        }

        if(queryType.equals("2")){
        	StatisticsFormbean record = new StatisticsFormbean();
            startTime = startDt;
            endTime = endDt;
            record.setName(startTime.substring(0, 4) + "年" + startTime.substring(5, 7) + "月"
                + startTime.substring(8, 10) + "日" + "-" + endTime.substring(0, 4) + "年" + endTime.substring(5, 7)
                + "月" + endTime.substring(8, 10) + "日");
            Integer loseNum = basAnaesMedicineLoseRecordDao.queryMedicineLoseRecordForLine(startTime, endTime, getBeid());
            record.setDay(loseNum + "");
            resultList.add(record);
        }
        
        return resultList;
    }
    
    //根据原因查询报损数量
    public Integer queryMedicineLoseRecordByReason(String startTime,String endTime,String reason)
    {
    	return basAnaesMedicineLoseRecordDao.queryMedicineLoseRecordByReason(startTime, endTime, reason, getBeid());
    }
}
