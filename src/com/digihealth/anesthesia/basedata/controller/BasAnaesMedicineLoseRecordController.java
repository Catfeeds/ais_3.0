package com.digihealth.anesthesia.basedata.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.digihealth.anesthesia.basedata.formbean.BasAnaesMedicineLoseRecordFormBean;
import com.digihealth.anesthesia.basedata.formbean.StatisticsFormbean;
import com.digihealth.anesthesia.basedata.formbean.SystemSearchFormBean;
import com.digihealth.anesthesia.common.entity.ResponseValue;
import com.digihealth.anesthesia.common.utils.DateUtils;
import com.digihealth.anesthesia.common.web.BaseController;
import com.digihealth.anesthesia.operProceed.formbean.DataStatFormbean;
import com.digihealth.anesthesia.operProceed.formbean.Series;
import com.digihealth.anesthesia.operProceed.formbean.SeriesDataObject;
import com.digihealth.anesthesia.operProceed.formbean.SeriesPie;
import com.digihealth.anesthesia.operProceed.formbean.XAisData;
import com.digihealth.anesthesia.operProceed.formbean.YAxisData;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

@Controller
@RequestMapping(value = "/basedata")
@Api(value = "BasAnaesMedicineLoseRecordController", description = "毒麻药报损处理类")
public class BasAnaesMedicineLoseRecordController extends BaseController
{
	/**
     * 
     * @discription 根据条件查询毒麻药报损记录
     * @author pengqing
     * @created 2017年6月13日 下午3:01:40
     * @param systemSearchFormBean
     * @return
     */
    @RequestMapping(value = "/queryMedicineLoseRecordList")
    @ResponseBody
    @ApiOperation(value = "根据条件查询毒麻药取药记录", httpMethod = "POST", notes = "根据条件查询毒麻药取药记录")
    public String queryMedicineLoseRecordList(
        @ApiParam(name = "systemSearchFormBean", value = "系统查询参数") @RequestBody SystemSearchFormBean systemSearchFormBean)
    {
        logger.info("begin queryMedicineLoseRecordList");
        ResponseValue resp = new ResponseValue();
        List<BasAnaesMedicineLoseRecordFormBean> resultList = basAnaesMedicineLoseRecordService.queryMedicineLoseRecordList(systemSearchFormBean);
        int total = basAnaesMedicineLoseRecordService.queryMedicineLoseRecordListTotal(systemSearchFormBean);
        resp.put("resultList", resultList);
        resp.put("total", total);
        logger.info("end queryMedicineLoseRecordList");
        return resp.getJsonStr();
    }
    
	/**
	 * 报损记录,通过折线图展示
	 */
	@RequestMapping("/queryMedicineLoseRecordForLine")
	@ResponseBody
	@ApiOperation(value="报损记录,通过折线图展示",httpMethod="POST",notes="报损记录,通过折线图展示")
    public String queryMedicineLoseRecordForLine(@ApiParam(name="map", value ="系统查询参数对象") @RequestBody Map<String,Object> map) 
	{
		ResponseValue resp = new ResponseValue();

		String queryType = map.get("queryType").toString();
		String stTime = map.get("startTime").toString();
		String edTime = map.get("startTime").toString();
		if (queryType.equals("2"))
		{
			edTime = map.get("endTime").toString();
		}

		List<StatisticsFormbean> list = basAnaesMedicineLoseRecordService
				.queryMedicineLoseRecordForLine(stTime, edTime, queryType);

		List<Float> fdata = new ArrayList<Float>();
		List<String> sdata = new ArrayList<String>();
		if (list != null && list.size() > 0)
		{
			for (int i = 0; i < list.size(); i++)
			{
				fdata.add(Float.parseFloat(list.get(i).getDay()));
				sdata.add(list.get(i).getName());
			}
		}
		DataStatFormbean bean = new DataStatFormbean();
		List<Series> seriesList = new ArrayList<Series>();
		Series series = new Series();
		series.setData(fdata);
		series.setName("药品报损情况");
		series.setType("line");
		seriesList.add(series);
		bean.setSeries(seriesList);

		List<YAxisData> yAxisList = new ArrayList<YAxisData>();
		YAxisData yAxis = new YAxisData();
		yAxis.setMax(null);
		yAxis.setName("药品报损数量");
		yAxis.setType("value");
		yAxisList.add(yAxis);
		bean.setyAxis(yAxisList);

		List<XAisData> xAxisList = new ArrayList<XAisData>();
		XAisData xAis = new XAisData();
		xAis.setData(sdata);
		xAxisList.add(xAis);
		bean.setxAxis(xAxisList);

		resp.put("dataStat", bean);
		return resp.getJsonStr();
	}
	
	/**
	 * 报损记录 按照报损原因（霉变、破损、失效、其他）进行平图分层 
	 */
	@RequestMapping("/queryMedicineLoseRecordForPie")
	@ResponseBody
	@ApiOperation(value="报损记录 按照报损原因（霉变、破损、失效、其他）进行平图分层",httpMethod="POST",notes="报损记录 按照报损原因（霉变、破损、失效、其他）进行平图分层")
    public String queryMedicineLoseRecordForPie(@ApiParam(name="map", value ="系统查询参数对象") @RequestBody Map<String,Object> map) 
	{
    	ResponseValue resp = new ResponseValue();
    	String queryType = map.get("queryType").toString();
		String stTime = map.get("startTime").toString();
		String edTime = map.get("startTime").toString();
		if (queryType.equals("2"))
		{
			edTime = map.get("endTime").toString();
		}
		
		//最后得到的开始时间和结束时间
		String startTime = "";
		String endTime = "";
		if ("1".equals(queryType))
		{
			int year = Integer.parseInt(stTime);
			int month = 12;
			if (stTime.equals(DateUtils.getYear()))
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
		}else
		{
			startTime = stTime;
			endTime = edTime;
		}
		
		Integer mbNum = basAnaesMedicineLoseRecordService.queryMedicineLoseRecordByReason(startTime,endTime,"霉变");
		Integer psNum = basAnaesMedicineLoseRecordService.queryMedicineLoseRecordByReason(startTime,endTime,"破损");
		Integer sxNum = basAnaesMedicineLoseRecordService.queryMedicineLoseRecordByReason(startTime,endTime,"失效");
		Integer qtNum = basAnaesMedicineLoseRecordService.queryMedicineLoseRecordByReason(startTime,endTime,"其他");
		
		
		//原因分类
		List<SeriesDataObject> pieDatas = new ArrayList<SeriesDataObject>();
		SeriesDataObject pieData1 =new SeriesDataObject();
		SeriesDataObject pieData2 =new SeriesDataObject();
		SeriesDataObject pieData3 =new SeriesDataObject();
		SeriesDataObject pieData4 =new SeriesDataObject();
		pieData1.setName("霉变");
		pieData1.setValue(mbNum+"");
		pieDatas.add(pieData1);
		pieData2.setName("破损");
		pieData2.setValue(psNum+"");
		pieDatas.add(pieData2);
		pieData3.setName("失效");
		pieData3.setValue(sxNum+"");
		pieDatas.add(pieData3);
		pieData4.setName("其他");
		pieData4.setValue(qtNum+"");
		pieDatas.add(pieData4);
		
		List<SeriesPie> seriesPies = new ArrayList<SeriesPie>();
		SeriesPie seriesPie = new SeriesPie();
		seriesPie.setData(pieDatas);
		seriesPie.setName("报损原因饼图数据");
		seriesPie.setStack("报损原因饼图数据");
		seriesPie.setType("pie");
		seriesPies.add(seriesPie);
		
		DataStatFormbean bean = new DataStatFormbean();
		bean.setSeriesPies(seriesPies);
		resp.put("dataStat", bean);
    	return resp.getJsonStr();
	}
}
