package com.digihealth.anesthesia.common.utils;

import java.util.HashMap;
import java.util.Map;

import com.digihealth.anesthesia.common.entity.ResponseValue;

public class StatDateUtils
{

	//检查统计时间
	public static ResponseValue checkStatTime(String startDt,String endDt,String queryType,ResponseValue resp)
	{
	    int month = 12;
        int season = 4;
        String subStartDt = startDt.substring(0, 4);
        String subEndDt = endDt.substring(0, 4);
        int subendDtMonth = 12;
        if(!StringUtils.isEmpty(endDt.substring(5,7)))
        {
        	subendDtMonth = Integer.parseInt(endDt.substring(5,7));
        }
        
        int startYear = Integer.parseInt(subStartDt);
        int endYear = Integer.parseInt(subEndDt);
        if(startDt.substring(0, 4).equals(DateUtils.getYear())){
            month = Integer.parseInt(DateUtils.getMonth());
        }
        season = getSeasonTime();
        int endTimeSeason = getSeasonEndTime(subendDtMonth);
        
        //如果查询年份大于当前年份直接返回
        if(startYear>Integer.parseInt(DateUtils.getYear()))
        {
        	resp.setResultCode("30000001");
        	resp.setResultMessage("查询开始年份不能大于当前年份！");
            return resp;
        }
        //如果查询的结束年份大于当前年份则需要将结束年份改成当前年
        if(endYear>Integer.parseInt(DateUtils.getYear()))
        {
        	resp.setResultCode("30000001");
        	resp.setResultMessage("查询结束年份不能大于当前年份！");
            return resp;
        }
        
		
    	startDt = startDt.substring(0, 4);
    	if(queryType.equals("1"))
    	{
            
            if(endYear==Integer.parseInt(DateUtils.getYear()) && subendDtMonth >= month)
            {
            	resp.setResultCode("30000001");
            	resp.setResultMessage("查询月份没有过完，统计数据还有变动，不能进行统计！");
                return resp;
            }
        }

        if(queryType.equals("2"))
        {
            if(endYear==Integer.parseInt(DateUtils.getYear()) && endTimeSeason >= season)
            {
            	resp.setResultCode("30000001");
            	resp.setResultMessage("查询季度没有过完，统计数据还有变动，不能进行统计！");
                return resp;
            }
        }
    
		return resp;
	}
	
	//获得修正后的统计时间
	public static Map<String,String> getStatTime(String startDt,String endDt,String queryType)
	{
		
		Map<String,String> resultMap = new HashMap<String,String>();
		String resultStartTime = "2017-01";
		String resultEndTime = "2017-03";
		
	    int month = 12;
        int season = 4;
        String subStartDt = startDt.substring(0, 4);
        String subEndDt = endDt.substring(0, 4);
        String subStartMonth = startDt.substring(5,7);
        String subEndMonth = endDt.substring(5,7);
        int substartDtMonth = 1;
        int subendDtMonth = 12;
        if(!StringUtils.isEmpty(subEndMonth))
        {
        	subendDtMonth = Integer.parseInt(subEndMonth);
        }
        if(!StringUtils.isEmpty(subStartMonth))
        {
        	substartDtMonth = Integer.parseInt(subStartMonth);
        }
        
        int startYear = Integer.parseInt(subStartDt);
        int endYear = Integer.parseInt(subEndDt);
        if(startDt.substring(0, 4).equals(DateUtils.getYear())){
            month = Integer.parseInt(DateUtils.getMonth());
        }
        season = getSeasonTime();
        int endTimeSeason = getSeasonEndTime(subendDtMonth);
        
        //如果查询年份大于当前年份直接返回
        if(startYear>Integer.parseInt(DateUtils.getYear()))
        {
        	subStartDt = DateUtils.getYear();
        	
        }
        //如果查询的结束年份大于当前年份则需要将结束年份改成当前年
        if(endYear>Integer.parseInt(DateUtils.getYear()))
        {
        	subEndDt = DateUtils.getYear();
        }
        
		
    	startDt = startDt.substring(0, 4);
    	if(queryType.equals("1"))
    	{
    		
    		if(substartDtMonth >= month)
            {
    			substartDtMonth = month -1;
            }
            if(subendDtMonth >= month)
            {
            	subendDtMonth =month -1;
            }
        }

        if(queryType.equals("2"))
        {
            if(endTimeSeason >= season)
            {
            	if(season -1>0)
            	{
            		substartDtMonth = (season -1)*3-2;
            		subendDtMonth =  (season -1)*3;
            	}else
            	{
            		subStartDt=subEndDt = String.valueOf(endYear-1);
            		substartDtMonth = subendDtMonth = 12;
            	}
            	
            }
        }
    
        resultStartTime = subStartDt + "-" + (substartDtMonth<10?"0"+substartDtMonth:substartDtMonth);
        resultEndTime = subEndDt + "-" + (subendDtMonth<10?"0"+subendDtMonth:subendDtMonth);
        resultMap.put("startTime",resultStartTime);
        resultMap.put("endTime",resultEndTime);
		return resultMap;
	}
	
	private static int getSeasonEndTime(int endmonth){
		int season = 0;
		if(endmonth>=1 && endmonth<=3){
			season = 1; 
		}
		if(endmonth>=4 && endmonth<=6){
			season = 2; 
		}
		if(endmonth>=7 && endmonth<=9){
			season = 3; 
		}
		if(endmonth>=10 && endmonth<=12){
			season = 4; 
		}
		return season;
	}
	
	private static int getSeasonTime(){
		int month = Integer.parseInt(DateUtils.getMonth());
		int season = 0;
		if(month>=1 && month<=3){
			season = 1; 
		}
		if(month>=4 && month<=6){
			season = 2; 
		}
		if(month>=7 && month<=9){
			season = 3; 
		}
		if(month>=10 && month<=12){
			season = 4; 
		}
		return season;
	}
}
