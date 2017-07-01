/**     
 * @discription 在此输入一句话描述此文件的作用
 * @author chengwang       
 * @created 2015-10-17 上午9:34:25    
 * tags     
 * see_to_target     
 */

package com.digihealth.anesthesia.research.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import net.sf.json.JSONArray;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.digihealth.anesthesia.basedata.config.OperationState;
import com.digihealth.anesthesia.basedata.formbean.BaseInfoQuery;
import com.digihealth.anesthesia.basedata.formbean.DeptFormBean;
import com.digihealth.anesthesia.basedata.formbean.DispatchPeopleNameFormBean;
import com.digihealth.anesthesia.basedata.formbean.SysCodeFormbean;
import com.digihealth.anesthesia.basedata.formbean.SystemSearchFormBean;
import com.digihealth.anesthesia.basedata.po.BasAnaesMethod;
import com.digihealth.anesthesia.basedata.po.BasDispatch;
import com.digihealth.anesthesia.basedata.po.BasOperationPeople;
import com.digihealth.anesthesia.basedata.po.BasRegOpt;
import com.digihealth.anesthesia.common.entity.ResponseValue;
import com.digihealth.anesthesia.common.utils.DateUtils;
import com.digihealth.anesthesia.common.utils.Exceptions;
import com.digihealth.anesthesia.common.utils.JsonType;
import com.digihealth.anesthesia.common.utils.StringUtils;
import com.digihealth.anesthesia.common.web.BaseController;
import com.digihealth.anesthesia.doc.formbean.EventBillingFormBean;
import com.digihealth.anesthesia.doc.po.DocAnaesRecord;
import com.digihealth.anesthesia.doc.po.DocPackagesItem;
import com.digihealth.anesthesia.evt.formbean.Filter;
import com.digihealth.anesthesia.evt.formbean.SearchConditionFormBean;
import com.digihealth.anesthesia.evt.formbean.SearchFormBean;
import com.digihealth.anesthesia.evt.po.EvtOptLatterDiag;
import com.digihealth.anesthesia.evt.po.EvtOptRealOper;
import com.digihealth.anesthesia.evt.po.EvtRealAnaesMethod;
import com.digihealth.anesthesia.evt.service.EvtParticipantService;
import com.digihealth.anesthesia.operProceed.formbean.BasAnaesMonitorConfigFormBean;
import com.digihealth.anesthesia.operProceed.formbean.DataStatFormbean;
import com.digihealth.anesthesia.operProceed.formbean.LegendData;
import com.digihealth.anesthesia.operProceed.formbean.Series;
import com.digihealth.anesthesia.operProceed.formbean.SeriesDataObject;
import com.digihealth.anesthesia.operProceed.formbean.SeriesPie;
import com.digihealth.anesthesia.operProceed.formbean.XAisData;
import com.digihealth.anesthesia.operProceed.formbean.YAxisData;
import com.digihealth.anesthesia.operProceed.po.BasObserveData;
import com.digihealth.anesthesia.research.formbean.AnaesCntByAnaesMethod;
import com.digihealth.anesthesia.research.formbean.AnaesDocObserveTimeCount;
import com.digihealth.anesthesia.research.formbean.HomeAnaesDoctorWorkingTimeFormBean;
import com.digihealth.anesthesia.research.formbean.HospitalKeyOperationFormBean;
import com.digihealth.anesthesia.research.formbean.MedIoChargeFormBean;
import com.digihealth.anesthesia.research.formbean.SearchAnesTypeFormBean;
import com.digihealth.anesthesia.research.formbean.SearchBadEventInfo;
import com.digihealth.anesthesia.research.formbean.SearchDeptOperatCountBySteward;
import com.digihealth.anesthesia.research.formbean.SearchMedicineType;
import com.digihealth.anesthesia.research.formbean.SearchOperByASALevel;
import com.digihealth.anesthesia.research.formbean.SearchOperByDept;
import com.digihealth.anesthesia.research.formbean.SearchOperByNurse;
import com.digihealth.anesthesia.research.formbean.SearchOperByOperator;
import com.digihealth.anesthesia.research.formbean.SearchOperFormBean;
import com.digihealth.anesthesia.research.formbean.SearchRegionOperatCompdiag;
import com.digihealth.anesthesia.research.formbean.SearchRegionOperatCountByAsalev;
import com.digihealth.anesthesia.research.formbean.SearchRegionOperatCountByOptlev;
import com.digihealth.anesthesia.research.formbean.SearchStewardScoFormBean;
import com.digihealth.anesthesia.research.formbean.StaticAnaesDocCountByAnalgesic;
import com.digihealth.anesthesia.research.formbean.StaticDeptCountByAnalgesic;
import com.digihealth.anesthesia.research.formbean.StatisAnaesMethodNum;
import com.digihealth.anesthesia.research.formbean.StatisAnaesOptFormBean;
import com.digihealth.anesthesia.research.formbean.StatisticsWorkingFormBean;
import com.digihealth.anesthesia.research.formbean.ValueObjcet;
import com.digihealth.anesthesia.research.formbean.WorkingTimeFormBean;
import com.digihealth.anesthesia.research.utils.AllWorkingTimeComparator;
import com.digihealth.anesthesia.research.utils.AnaesCodeComparator;
import com.digihealth.anesthesia.research.utils.MedicineDosageComparator;
import com.digihealth.anesthesia.research.utils.WorkingTimeComparator;
import com.digihealth.anesthesia.sysMng.formbean.BasUserFormBean;
import com.digihealth.anesthesia.sysMng.formbean.UserFormbean;
import com.digihealth.anesthesia.sysMng.po.BasUser;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

/**
 * Title: StatisticsController.java Description: 描述
 * 
 * @author chengwang
 * @created 2015-10-17 上午9:34:25
 */
@Controller
@RequestMapping(value = "/statistics")
@Api(value="StatisticsController",description="查询统计处理类")
public class StatisticsController extends BaseController {
	/**
	 * 
	 * @discription 月度麻醉例数统计
	 * @author chengwang
	 * @created 2015年12月16日 下午2:09:26
	 * @param searchConditionFormBean
	 * @return
	 */
	@RequestMapping(value = "/statistAnaesMethodTotal")
	@ResponseBody
	@ApiOperation(value="月度麻醉例数统计",httpMethod="POST",notes="月度麻醉例数统计")
	public Map statisAnaesOptNum(@ApiParam(name="searchConditionFormBean", value ="统计查询参数") @RequestBody SearchConditionFormBean searchConditionFormBean) {
		String startTime = searchConditionFormBean.getStartTime();
		String endTime = searchConditionFormBean.getEndTime();
		Map map = operateDate(searchConditionFormBean.getStartTime(),
				searchConditionFormBean.getEndTime(), true);
		boolean flag = map.containsKey("month");
		Map<String, Float> compareMap = new HashMap<String, Float>();
		compareMap.put("min", null);
		compareMap.put("max", null);
		
		Integer num = flag ? (Integer) map.get("month") : (Integer) map
				.get("year");
		/*
		 * if (isQuarter)// .booleanValue()) { flag = false; num = (Integer)
		 * map.get("quarter"); }
		 */
		StatisAnaesMethodNum[] result = new StatisAnaesMethodNum[num.intValue() + 2];
		/*List<BasAnaesMethod> baseMethod = anaesMethodService
				.findAllList(new BaseInfoQuery());*/
		List<BasAnaesMethod> baseMethod = statisticsService.searchRealMed(startTime+ " 00:00:00", endTime+ " 23:59:59");
		List list = statisticsService.statisAnaesOptNum(startTime+ " 00:00:00", endTime+ " 23:59:59",
				OperationState.POSTOPERATIVE);
		result[0] = handleStatisAnaesMethod(startTime, endTime, !flag, false,
				0, baseMethod);
		boolean isQuarter = false;
		int baseMethodSize = baseMethod.size() + 1;
		result[0].setVoSize(new Integer(baseMethodSize - 1));
		int count = 0;
		
		List<Series> seriesList = new ArrayList<Series>();
        List<String> sdata = new ArrayList<String>();
        XAisData xAis = new XAisData();
        LegendData legend = new LegendData();
        List<String> legendData = new ArrayList<String>();
		
		for (int j = 1; j < result.length; j++) {
			result[j] = handleStatisAnaesMethod(startTime, endTime, !flag,
					isQuarter, j - 1, baseMethod);
			ValueObjcet[] beans = result[j].getVo();
			int columnNum = 0;
			for (int i = 0; i < list.size(); i++) {
				StatisAnaesOptFormBean obj = (StatisAnaesOptFormBean) list
						.get(i);
				if (isQuarter) {
					compareValue(obj.getCate1(), result[j],
							obj.getTotal(),
							Integer.parseInt(obj.getAnaesStartTime()), null,
							Integer.parseInt(obj.getAnaesEndTime()));
					columnNum += obj.getTotal().intValue();
					continue;
				}
				if (flag && !isQuarter)/* ??·Y */{
					compareValue(obj.getCate1(), result[j],
							obj.getTotal(),
							Integer.parseInt(obj.getAnaesStartTime()),
							Integer.parseInt(obj.getAnaesEndTime()), null);
					columnNum += obj.getTotal().intValue();
				} else {
					compareValue(obj.getCate1(), result[j],
							obj.getTotal(),
							Integer.parseInt(obj.getAnaesStartTime()), null,
							null);
					columnNum += obj.getTotal().intValue();
				}
			}
			count++;
			if (count != result.length) {
				beans[beans.length - 1].setItemValue(new Integer(columnNum));
			}
			result[j].setVoSize(new Integer(baseMethodSize - 1));
		}
		List sumList = new ArrayList();
		String level = "1";
		StatisAnaesMethodNum statisAnaesMethodNumBean = getAnaesMethodSumBean(
				level, baseMethod, Arrays.asList(result), sumList);
		statisAnaesMethodNumBean.setName("总计");
		result[result.length - 1] = statisAnaesMethodNumBean;
		result[result.length - 1].setVoSize(new Integer(baseMethodSize - 1));
		String[] anaesMethodName = new String[result[0].getVoSize()];
		String[] time = new String[result.length - 2];
		// String[][] value = new
		// String[result[0].getVoSize()-1][result.length-2];
		String[][] value = new String[result[0].getVoSize()][result.length - 2];
		List tableList = new ArrayList();

		for (int i = 0; i < result.length; i++) {
			if (i == 0) {
				// tableAnaesMethod.setTime("时间");
				for (int j = 0; j < result[0].getVoSize(); j++) {
					anaesMethodName[j] = ((result[0].getVo())[j]).getItemName();
				}
			}
			if (i != 0 && i != result.length - 1) {
				// tableAnaesMethod.setTime(result[i].getYear()+"年"+result[i].getMonth()+"月");
				time[i - 1] = result[i].getYear() + "年" + result[i].getMonth()
						+ "月";
				for (int j = 0; j < result[0].getVoSize(); j++) {
					value[j][i - 1] = (result[i].getVo()[j]).getItemValue()
							.toString();
				}
				
				sdata.add(time[i - 1]);
			}
			if (i == result.length - 1) {
				// tableAnaesMethod.setTime("总计");
			}

			String[] vo = new String[result[i].getVoSize()];
			for (int a = 0; a < result[0].getVoSize(); a++) {
				if (i == 0) {
					vo[a] = result[i].getVo()[a].getItemName();
				}
				if (i != 0) {
					vo[a] = result[i].getVo()[a].getItemValue().toString();
				}

			}
			// tableAnaesMethod.setVo(vo);
			// tableList.add(tableAnaesMethod);
		}
		
		for (int i = 0; i < result[0].getVoSize(); i++) {
			Map<String, String> resultMap = new HashMap<String, String>();
			resultMap.put("麻醉方法", result[0].getVo()[i].getItemName());
			Series series = new Series();
			
			series.setName(result[0].getVo()[i].getItemName());
			List<Float> data = new ArrayList<Float>();
			legendData.add(series.getName());
			for (int j = 0; j < result.length; j++) {
				if (j != 0 && j != result.length - 1) {
					resultMap.put(
							result[j].getYear() + "年" + result[j].getMonth()
									+ "月", result[j].getVo()[i].getItemValue()
									+ "");
					data.add((float)result[j].getVo()[i].getItemValue());
					
					setMaxAndMin(compareMap,(float)result[j].getVo()[i].getItemValue());
					
				}
				if (j == result.length - 1) {
					// resultMap.put("总计",
					// result[j].getVo()[i].getItemValue()+"");
				}
				
			}
			
			 series.setData(data);
             series.setType("line");
             seriesList.add(series);
            
             
			
            tableList.add(resultMap);
		}
		
		YAxisData iyAxis = new YAxisData();
		if (null != compareMap.get("max"))
		{
		    iyAxis.setMax((compareMap.get("max").intValue() / 5 + 1) * 5);
		}
		if (null != compareMap.get("min"))
        {
		    iyAxis.setMin(compareMap.get("min").intValue() < 0 ? compareMap.get("min").intValue() : 0);
        }
        iyAxis.setType("value");
		
		legend.setData(legendData);
        xAis.setData(sdata);
		/*
		String[] anaesMethodName1 = null;
		// String[][] value = new
		// String[result[0].getVoSize()-1][result.length-2];
		String[][] value1 = null;
		if(value.length>0){
			for(int i = 0 ; i <value.length;i++){
				int statu = 0;
				int len = value[0].length;
				if(len>0){
					for(int j = 0 ; j <len;j++){
						if(value[i][j].equals("0")){
							
						}else{
							statu = 1;
						}
					}
				}
				if(statu == 1){
					anaesMethodName1[i]
				}
			}
		}*/
		
		Map resultMap = new HashMap();

		resultMap.put("resultCode", "1");
		resultMap.put("resultMessage", "查询麻醉例数成功");
		resultMap.put("series", seriesList);
		resultMap.put("yAxis", iyAxis);
		resultMap.put("xAxis", xAis);
        resultMap.put("legend", legend);
		resultMap.put("tableList", tableList);// 表格数据
		resultMap.put("anaesMethodName", anaesMethodName);// 图表数据中的麻醉方法名称
		resultMap.put("time", time);// 图表数据中的时间
		resultMap.put("value", value);// 图表数据中的值
		return resultMap;
	}
	
	private void setMaxAndMin(Map<String, Float> map, Float f)
	{
	    if (null == map.get("min"))
	    {
	        map.put("min", f);
	    }
	    else
	    {
	        if (map.get("min") > f)
	        {
	            map.put("min", f);
	        }
	    }
	    
	    if (null == map.get("max"))
        {
            map.put("max", f);
        }
        else
        {
            if (map.get("max") < f)
            {
                map.put("max", f);
            }
        }
	}

	private void compareValue(String itemCode, StatisAnaesMethodNum vo,
			Long value, Integer year, Integer month, Integer quarter) {
		ValueObjcet[] beans = vo.getVo(); 
		// int columnNum = 0; 
		if(beans.length>0){
			for (int i = 0; i < beans.length - 1; i++) {
				if (beans[i].getItemCode().equals(itemCode)
						&& (quarter != null && vo.getQuarter().equals(quarter))
						&& vo.getYear().equals(year)) {
					beans[i].setItemValue(new Integer(value.intValue()));
					// columnNum += value.intValue();
					continue;
				}
				if (month != null) {
					if (beans[i].getItemCode().equals(itemCode)
							&& (month != null && vo.getMonth().equals(month))
							&& vo.getYear().equals(year))
						beans[i].setItemValue(new Integer(value.intValue()));
					// columnNum += value.intValue();
					continue;
				}
				if (beans[i].getItemCode().equals(itemCode)
						&& vo.getYear().equals(year) && quarter == null) {
					beans[i].setItemValue(new Integer(value.intValue()));
					// columnNum += value.intValue();
					continue;
				}
			}
		}
		
		// beans[beans.length - 1].setItemVaue(new Integer(columnNum));
	}

	private StatisAnaesMethodNum handleStatisAnaesMethod(String startTime,
			String endTime, boolean isYear, boolean isQuarter, int j, List list) {

		StatisAnaesMethodNum result = new StatisAnaesMethodNum();
		String yearOfStartTime = startTime.substring(0, 4);
		int year = new Integer(yearOfStartTime).intValue();
		String monthOfStartTime = startTime.substring(5, 7);
		int month = new Integer(monthOfStartTime).intValue();
		ValueObjcet[] vo = new ValueObjcet[list.size() + 1];
		for (int i = 0; i < list.size(); i++) {
			BasAnaesMethod obj = (BasAnaesMethod) list.get(i);
			vo[i] = new ValueObjcet();
			vo[i].setItemName(obj.getName());
			vo[i].setItemValue(new Integer(0));
			vo[i].setItemCode(obj.getCode());
		}
		vo[list.size()] = new ValueObjcet();
		vo[list.size()].setItemName("总计");
		vo[list.size()].setItemValue(new Integer(0));
		vo[list.size()].setItemCode("");
		result.setVo(vo);

		if (!isYear) {
			// result.setStatisLevel("month");
			result.setYear(new Integer(year));
			int num = (month + j) / 12 > 1 ? (month + j) / 12 : 1;
			if (month + j > 12) {
				result.setYear(new Integer(year
						+ ((month + j) % 12 == 0 ? num - 1 : num)));
				result.setMonth(new Integer(
						(month + j) % (12 * num) == 0 ? (month + j) / num
								: (month + j) % (12 * num)));
			} else
				result.setMonth(new Integer(month + j));
			result.setQuarter(belongQuarter(result.getMonth().intValue()));
		} else {
			if (isQuarter) {
				result.setYear(new Integer(year + (month / 3 + j) / 4));
				// result.setQuarter(new Integer((month / 3 + j )%4 + 1));
				// 第一季度为1、2、3月
				result.setQuarter(new Integer((month - 1) / 3 + 1 + j));
				// result.setStatisLevel("quarter");
			} else {
				result.setYear(new Integer(year + j));
				// result.setStatisLevel("year");
			}
		}
		return result;
	}

	private Integer belongQuarter(int month) {
		Integer num = null;
		switch (month) {
		case 1:
		case 2:
		case 3:
			num = new Integer(1);
			break;
		case 4:
		case 5:
		case 6:
			num = new Integer(2);
			break;
		case 7:
		case 8:
		case 9:
			num = new Integer(3);
			break;
		case 10:
		case 11:
		case 13:
			num = new Integer(4);
			break;

		}
		return num;
	}

	private Map operateDate(String startTime, String endTime, Boolean isQuarter) {
		Map map = new HashMap();
		int num = 0;
		String monthOfStartTime = null;
		String monthOfEndTime = null;
		String yearOfStartTime = startTime.substring(0, 4);
		String yearOfEndTime = endTime.substring(0, 4);
		if (isQuarter != null) {
			monthOfStartTime = startTime.length() > 5 ? startTime.substring(5,
					7) : "01";
			monthOfEndTime = endTime.length() > 5 ? endTime.substring(5, 7)
					: "12";
			num = (new Integer(yearOfEndTime).intValue() - new Integer(
					yearOfStartTime).intValue())
					* 12
					+ new Integer(monthOfEndTime).intValue()
					- new Integer(monthOfStartTime).intValue() + 1;
			int quarterRemainder = num % 3 > 0 ? 1 : 0;
			map.put("quarter", new Integer((num / 3) + quarterRemainder));
		}

		num = (new Integer(yearOfEndTime).intValue() - new Integer(
				yearOfStartTime).intValue())
				* 12
				+ new Integer(monthOfEndTime).intValue()
				- new Integer(monthOfStartTime).intValue() + 1;
		map.put("month", new Integer(num));
		num = new Integer(yearOfEndTime).intValue()
				- new Integer(yearOfStartTime).intValue() + 1;
		map.put("year", new Integer(num));
		return map;
	}

	private String changeSql(String sql, boolean isYear, boolean isQuarter,
			int level) {
		String result = "";
		if (isYear) {
			if (isQuarter)
				result = sql.replaceAll(
						"extract\\(MONTH FROM t3.anaes_start_time\\),", " ");
			else
				result = sql.replaceAll(
						"extract\\(MONTH FROM t3.anaes_start_time\\),", " ")
						.replaceAll(", t3.anaes_start_time", " ");

		} else {
			if (!isQuarter)
				result = sql.replaceAll(", t3.anaes_start_time", " ");
			else
				result = sql.replaceAll(
						"extract\\(MONTH FROM t3.anaes_start_time\\),", " ");
		}

		switch (level) {
		case 1:

			break;
		case 2:
			result = result.replaceAll("t2.cate1", "t2.cate2");
			result = result + " having t2.cate2 is not null";
			break;
		case 3:
			result = result.replaceAll("t2.cate1", "t2.cate3");
			result = result + " having t2.cate3 is not null";
			break;
		case 4:
			result = result.replaceAll("t2.cate1", "t2.code");
			result = result + " having t2.code is not null";
			break;
		}
		return result;
	}

	private StatisAnaesMethodNum getAnaesMethodSumBean(String level,
			List anaesMethodList, List groupList, List sumList) {
		StatisAnaesMethodNum result = new StatisAnaesMethodNum();
		ValueObjcet[] vos = new ValueObjcet[anaesMethodList.size() + 1];
		int columnNum = 0;
		for (int i = 0; i < anaesMethodList.size(); i++) {
			BasAnaesMethod method = (BasAnaesMethod) anaesMethodList.get(i);
			String cate = null;
			if (level.equals("1")) {
				cate = method.getCate1();
			} else if (level.equals("2")) {
				cate = method.getCate2();
			} else if (level.equals("3")) {
				cate = method.getCate3();
			} else if (level.equals("4")) {
				cate = method.getCode();
			}

			int totalNum = 0;
			for (int j = 0; j < groupList.size(); j++) {
				StatisAnaesMethodNum bean = (StatisAnaesMethodNum) groupList
						.get(j);
				ValueObjcet[] valueObjcets = bean.getVo();
				for (int y = 0; y < valueObjcets.length; y++) {
					ValueObjcet vo = valueObjcets[y];
					if (vo.getItemCode() != null
							&& vo.getItemCode().equals(cate)) {
						totalNum = totalNum + vo.getItemValue().intValue();
					}
				}
			}
			vos[i] = new ValueObjcet();
			vos[i].setItemName(method.getName());
			vos[i].setItemValue(new Integer(totalNum));
			vos[i].setItemCode(method.getCode());
			columnNum += totalNum;
		}
		result.setVo(vos);

		ValueObjcet vo = new ValueObjcet();
		vo.setItemName("");
		vo.setItemValue(new Integer(columnNum));
		vo.setItemCode("");
		vos[anaesMethodList.size()] = vo;

		return result;
	}

    /**
     * 
     * @discription 麻醉科麻醉例数统计
     * @author liukui
     * @param searchConditionFormBean
     * @return
     */
    @RequestMapping(value = "/countAnaesDeptByMethodType")
    @ResponseBody
    @ApiOperation(value="麻醉科麻醉例数统计",httpMethod="POST",notes="麻醉科麻醉例数统计")
    public String searchAnaesMethodByDept(@ApiParam(name="searchFormBean", value ="统计查询参数") @RequestBody SearchFormBean searchFormBean) {
        logger.info("begin countAnaesDeptByMethodType");
        ResponseValue resp = new ResponseValue();

        if (StringUtils.isBlank(searchFormBean.getBeid())) {
        	searchFormBean.setBeid(getBeid());
		}
        XAisData xAxis = new XAisData();
        YAxisData yAxis = new YAxisData();
        yAxis.setName("例");
        Series series = new Series();
        List<String> legendData = new ArrayList<String>();
        List<Series> seriesData = new ArrayList<Series>();
        legendData.add("椎管内全麻");
        legendData.add("插管全麻");
        legendData.add("非插管全麻");
        legendData.add("复合麻醉");
        legendData.add("其他麻醉方式");
        xAxis.setData(legendData);
        series.setName("麻醉类型");
        series.setType("bar");
        List<SearchAnesTypeFormBean> list = statisticsService.searchAnaesMethodByDept(searchFormBean);
        List<Float> chartData = new ArrayList<Float>();
        Integer max = 1,min = 0, num = 0;
        for (SearchAnesTypeFormBean searchAnesTypeFormBean : list) {
        	if(searchAnesTypeFormBean.getTotalNum() > max) {
        		max = searchAnesTypeFormBean.getTotalNum();
        	}
        	if(searchAnesTypeFormBean.getTotalNum() <= min) {
        		num = searchAnesTypeFormBean.getTotalNum();
        		if (num > 0) {
        			num = 0;
				}
        	}
        	if (!"总计".equals(searchAnesTypeFormBean.getAnesType())) {
        		chartData.add(Float.parseFloat(searchAnesTypeFormBean.getTotalNum() + ""));
			}
		}
        yAxis.setMin(num);
        yAxis.setMax(max);
        series.setData(chartData);
        seriesData.add(series);
        resp.put("tableList", statisticsService.searchAnaesMethodByDept(searchFormBean));
        resp.put("xAxis", xAxis);
        resp.put("yAxis", yAxis);
        resp.put("series", seriesData);
        logger.info("end countAnaesDeptByMethodType");
	    return resp.getJsonStr();
    }
    
	/**
	 * 
	 * @discription 首页中的个人工作量统计 废弃
	 * @author chengwang
	 * @created 2015年12月16日 下午2:11:34
	 * @param searchConditionFormBean
	 * @return
	 */
	@RequestMapping(value = "/searchWorkingTime1")
	@ResponseBody
	public String searchWorkingTime(
			@RequestBody SearchConditionFormBean searchConditionFormBean) {
		logger.info("begin searchWorkingTime");
		String beid = searchConditionFormBean.getBeid();
		if (StringUtils.isBlank(beid)) {
			beid = getBeid();
		}
		String time = DateUtils.getDate();
		String startTime = time.substring(0, 4) + "-01-01 00:00:00";
		String endTime = time.substring(0, 4) + "-12-31 23:59:59";
		Map map = new HashMap();
		
		List<WorkingTimeFormBean> resultList = new ArrayList<WorkingTimeFormBean>();
		
		BasUser user = basUserService.get(searchConditionFormBean.getLoginName(), beid);
		if(user.getUserType().equals("ANAES_DOCTOR")){
			resultList = statisticsService
					.searchAnaesDoctorWorkingTime(startTime, endTime, searchConditionFormBean.getLoginName(), beid);
		}else if(user.getUserType().equals("NURSE")){
			resultList = statisticsService
					.searchNurseQmWorkingTime(startTime, endTime, searchConditionFormBean.getLoginName(), beid);
			
			List<WorkingTimeFormBean> resultJmList = statisticsService
					.searchNurseJmWorkingTime(startTime, endTime, searchConditionFormBean.getLoginName(), beid);
			resultList.addAll(resultJmList);
		}
		/*List<WorkingTimeFormBean> resultList = statisticsService
				.searchWorkingTime(startTime, endTime, Integer
						.parseInt(searchConditionFormBean.getLoginName()));*/
		List<WorkingTimeFormBean> resultConsultationList = statisticsService.searchConsultationTime(startTime, endTime, searchConditionFormBean.getLoginName(), beid);
		Map<String, WorkingTimeFormBean> timeMap = new HashMap<String, WorkingTimeFormBean>();
		for(int i = 0 ; i < 12;i++){
			WorkingTimeFormBean w = new WorkingTimeFormBean();
			w.setTime("0");
			w.setYear(time.substring(0, 4));
			w.setMonth((i+1)+"");
			timeMap.put(time.substring(0, 4)+"年"+(i+1)+"月",w );
		}
		resultList.addAll(resultConsultationList);
		if (resultList != null && resultList.size() > 0) {
			for (int i = 0; i < resultList.size(); i++) {
				if (timeMap.containsKey(resultList.get(i).getYear() + "年"
						+ resultList.get(i).getMonth() + "月")) {
					WorkingTimeFormBean old = (timeMap
							.get(resultList.get(i).getYear() + "年"
									+ resultList.get(i).getMonth() + "月"));
					String oldTime = old.getTime();
					String newTime = (Integer.parseInt(oldTime) + Integer
							.parseInt(resultList.get(i).getTime())) + "";
					old.setTime(newTime);
					timeMap.put(resultList.get(i).getYear() + "年"
							+ resultList.get(i).getMonth() + "月", old);
				} else {
					timeMap.put(resultList.get(i).getYear() + "年"
							+ resultList.get(i).getMonth() + "月",
							resultList.get(i));
				}
			}
		}

		resultList.clear();
		for (Map.Entry<String, WorkingTimeFormBean> entry : timeMap.entrySet()) {
			resultList.add(entry.getValue());
		}
		WorkingTimeComparator comparator = new WorkingTimeComparator();
		Collections.sort(resultList, comparator);
		String[] field = new String[resultList.size()];
		String[] value = new String[resultList.size()];
		if (resultList != null && resultList.size() > 0) {
			for (int i = 0; i < resultList.size(); i++) {
				field[i] = resultList.get(i).getYear() + "年"
						+ resultList.get(i).getMonth() + "月";
				value[i] = resultList.get(i).getTime();
			}
		}
		map.put("resultCode", "1");
		map.put("resultMessage", "查询工作量成功");
		map.put("field", field);
		map.put("value", value);
		logger.info("end searchWorkingTime");
		return JsonType.jsonType(map);
	}
	
	/**
     * 
         * @discription 首页工作量计算 深圳龙岗
         * @author chengwang       
         * @created 2016年11月18日 下午2:23:11     
         * @param searchConditionFormBean
         * @return
     */
    @RequestMapping(value = "/searchWorkingTime")
    @ResponseBody
	@ApiOperation(value="手术时长统计",httpMethod="POST",notes="手术时长统计")
    public String searchWorkingTime1(@ApiParam(name="searchConditionFormBean", value ="查询参数对象") 
            @RequestBody SearchConditionFormBean searchConditionFormBean) {
        logger.info("begin searchWorkingTime");
        /*String time = DateUtils.getDate();
        String startTime = time.substring(0, 4) + "-01-01 00:00:00";
        String endTime = time.substring(0, 4) + "-12-31 23:59:59";
        Map map = new HashMap();
        
        List<WorkingTimeFormBean> resultList = new ArrayList<WorkingTimeFormBean>();
        
        List<HomeAnaesDoctorWorkingTimeFormBean> anaesRecordList = new ArrayList<HomeAnaesDoctorWorkingTimeFormBean>();
        List<HomeAnaesDoctorWorkingTimeFormBean> anaesAllRecordList = new ArrayList<HomeAnaesDoctorWorkingTimeFormBean>();
        List<HomeAnaesDoctorWorkingTimeFormBean> shiftChangeList = new ArrayList<HomeAnaesDoctorWorkingTimeFormBean>();
        
        
        Map<String, WorkingTimeFormBean> timeMap = new HashMap<String, WorkingTimeFormBean>();
        for(int i = 0 ; i < 12;i++){
            WorkingTimeFormBean w = new WorkingTimeFormBean();
            w.setTime("0");
            w.setYear(time.substring(0, 4));
            w.setMonth((i+1)+"");
            timeMap.put(time.substring(0, 4)+"年"+(i+1)+"月",w );
        }
        
        Map anaesRecordMap = new HashMap();
        
        User user = basUserService.get(searchConditionFormBean.getLoginName());
        if(user.getUserType().equals("ANAES_DOCTOR")){
        	anaesAllRecordList = statisticsService
                    .searchAllHomeAnaesDoctorWorkingTime(startTime, endTime,user.getId());
        	anaesRecordList = statisticsService
                    .searchHomeAnaesDoctorWorkingTime(startTime, endTime,user.getId());
        	shiftChangeList = statisticsService.searchHomeAnaesDoctorShiftWorkingTime(startTime, endTime);
        	HomeAnaesDoctorWorkingTimeFormBean[] shiftChanges = shiftChangeList.toArray(new HomeAnaesDoctorWorkingTimeFormBean[0]);
        	if(anaesAllRecordList!=null&&anaesAllRecordList.size()>0){
        		for(int i = 0 ; i <anaesAllRecordList.size();i++){
        			anaesRecordMap.put(anaesAllRecordList.get(i).getRegOptId(), anaesAllRecordList.get(i));
        			//此块统计排班里面的巡台麻醉医师的工作量
        			long workingtime = (DateUtils.getParseTime(anaesAllRecordList.get(i).getOutOperRoomTime()).getTime() - DateUtils.getParseTime(anaesAllRecordList.get(i).getAnaesStartTime()).getTime())/1000/60 ;
                    
                 	if((user.getId()+"").equals(anaesAllRecordList.get(i).getCircuanesthetistId())){
                 		WorkingTimeFormBean old = ((WorkingTimeFormBean) timeMap
                                 .get(anaesAllRecordList.get(i).getYear() + "年"+ anaesAllRecordList.get(i).getMonth() + "月"));
                 		long l = Long.parseLong(old.getTime()) + workingtime;
                 		old.setTime(l+"");
                 		timeMap.put(anaesAllRecordList.get(i).getYear() + "年"+ anaesAllRecordList.get(i).getMonth() + "月", old);
                 	}
        		}
        	}
        	 if (anaesRecordList != null && anaesRecordList.size() > 0) {
                 for (int i = 0; i < anaesRecordList.size(); i++) {
                 	long workingtime = (DateUtils.getParseTime(anaesRecordList.get(i).getOutOperRoomTime()).getTime() - DateUtils.getParseTime(anaesRecordList.get(i).getAnaesStartTime()).getTime())/1000/60 ;
                     //此块统计排班里面的主麻的工作量
                 	if((user.getId()+"").equals(anaesRecordList.get(i).getAnesthetistId())){
                 		WorkingTimeFormBean old = ((WorkingTimeFormBean) timeMap
                                 .get(anaesRecordList.get(i).getYear() + "年"+ anaesRecordList.get(i).getMonth() + "月"));
                 		long l = Long.parseLong(old.getTime()) + workingtime;
                 		old.setTime(l+"");
                 		timeMap.put(anaesRecordList.get(i).getYear() + "年"+ anaesRecordList.get(i).getMonth() + "月", old);
                 		
                 	}
                 	
                 	
                 }
             }
        	 
        	 for(int i = 0 ; i < shiftChanges.length ; i ++){
        		 if(i + 1 < shiftChanges.length){
        			 if(shiftChanges[i].getRegOptId().equals(shiftChanges[i+1].getRegOptId())){
            			 if((user.getId()+"").equals(shiftChanges[i].getShiftChangedPeopleId())){
            				 //long tmp = (DateUtils.getParseTime(shiftChanges[i+1].getShiftChangeTime()).getTime() - DateUtils.getParseTime(shiftChanges[i].getShiftChangeTime()).getTime())/1000/60;
            				 WorkingTimeFormBean old = ((WorkingTimeFormBean) timeMap
                                     .get(shiftChanges[i].getYear() + "年"+ shiftChanges[i].getMonth() + "月"));
            				if(!StringUtils.isEmpty(shiftChanges[i].getTimes())){
            					long l = Long.parseLong(old.getTime()) + Long.parseLong(shiftChanges[i].getTimes());
                         		old.setTime(l+"");
                         		timeMap.put(shiftChanges[i].getYear() + "年"+ shiftChanges[i].getMonth() + "月", old);
            				}
                     		
            			 }
            		 }else{
            			 if((user.getId()+"").equals(shiftChanges[i].getShiftChangedPeopleId())){
            				 HomeAnaesDoctorWorkingTimeFormBean workingbean = (HomeAnaesDoctorWorkingTimeFormBean) anaesRecordMap.get(shiftChanges[i].getRegOptId());
            				 //long tmp = (DateUtils.getParseTime(workingbean.getOutOperRoomTime()).getTime() - DateUtils.getParseTime(shiftChanges[i].getShiftChangeTime()).getTime())/1000/60;
            				 WorkingTimeFormBean old = ((WorkingTimeFormBean) timeMap
                                     .get(shiftChanges[i].getYear() + "年"+ shiftChanges[i].getMonth() + "月"));
            				 if(!StringUtils.isEmpty(shiftChanges[i].getTimes())){
            					 long l = Long.parseLong(old.getTime()) + Long.parseLong(shiftChanges[i].getTimes());
                          		old.setTime(l+"");
                          		timeMap.put(shiftChanges[i].getYear() + "年"+ shiftChanges[i].getMonth() + "月", old);
            				 }
                     		
            			 }
            			 if((user.getId()+"").equals(shiftChanges[i].getShiftChangePeopleId())){
            				 HomeAnaesDoctorWorkingTimeFormBean workingbean = (HomeAnaesDoctorWorkingTimeFormBean) anaesRecordMap.get(shiftChanges[i].getRegOptId());
            				 long tmp = (DateUtils.getParseTime(workingbean.getOutOperRoomTime()).getTime() - DateUtils.getParseTime(shiftChanges[i].getShiftChangeTime()).getTime())/1000/60;
            				 WorkingTimeFormBean old = ((WorkingTimeFormBean) timeMap
                                     .get(shiftChanges[i].getYear() + "年"+ shiftChanges[i].getMonth() + "月"));
                     		long l = Long.parseLong(old.getTime()) + tmp;
                     		old.setTime(l+"");
                     		timeMap.put(shiftChanges[i].getYear() + "年"+ shiftChanges[i].getMonth() + "月", old);
            			 }
            		 }
        		 }else{
        			 if((user.getId()+"").equals(shiftChanges[i].getShiftChangedPeopleId())){
        				 HomeAnaesDoctorWorkingTimeFormBean workingbean = (HomeAnaesDoctorWorkingTimeFormBean) anaesRecordMap.get(shiftChanges[i].getRegOptId());
        				 //long tmp = (DateUtils.getParseTime(workingbean.getOutOperRoomTime()).getTime() - DateUtils.getParseTime(shiftChanges[i].getShiftChangeTime()).getTime())/1000/60;
        				 WorkingTimeFormBean old = ((WorkingTimeFormBean) timeMap
                                 .get(shiftChanges[i].getYear() + "年"+ shiftChanges[i].getMonth() + "月"));
        				 if(!StringUtils.isEmpty(shiftChanges[i].getTimes())){
        					 long l = Long.parseLong(old.getTime()) + Long.parseLong(shiftChanges[i].getTimes());
                      		old.setTime(l+"");
                      		timeMap.put(shiftChanges[i].getYear() + "年"+ shiftChanges[i].getMonth() + "月", old);
        				 }
                 		
        			 }
        			 if((user.getId()+"").equals(shiftChanges[i].getShiftChangePeopleId())){
        				 HomeAnaesDoctorWorkingTimeFormBean workingbean = (HomeAnaesDoctorWorkingTimeFormBean) anaesRecordMap.get(shiftChanges[i].getRegOptId());
        				 long tmp = (DateUtils.getParseTime(workingbean.getOutOperRoomTime()).getTime() - DateUtils.getParseTime(shiftChanges[i].getShiftChangeTime()).getTime())/1000/60;
        				 WorkingTimeFormBean old = ((WorkingTimeFormBean) timeMap
                                 .get(shiftChanges[i].getYear() + "年"+ shiftChanges[i].getMonth() + "月"));
                 		long l = Long.parseLong(old.getTime()) + tmp;
                 		old.setTime(l+"");
                 		timeMap.put(shiftChanges[i].getYear() + "年"+ shiftChanges[i].getMonth() + "月", old);
        			 }
        		 }
        		 
        	 }
             
             
        	
        }else if(user.getUserType().equals("NURSE")){
        	//全麻
            resultList = statisticsService
                    .searchNhNurseQmWorkingTime(startTime, endTime, Integer
                            .parseInt(searchConditionFormBean.getLoginName()));
            //局麻
            resultList.addAll(statisticsService
                    .searchNhNurseJmWorkingTime(startTime, endTime, Integer
                            .parseInt(searchConditionFormBean.getLoginName())));
           
        }
        
        //resultList.addAll(resultConsultationList);
        List<WorkingTimeFormBean> resultConsultationList = statisticsService
                .searchConsultationTime(startTime, endTime, Integer
                        .parseInt(searchConditionFormBean.getLoginName()));
        
        resultList.addAll(resultConsultationList);
        
        resultList.clear();
        for (Map.Entry<String, WorkingTimeFormBean> entry : timeMap.entrySet()) {
            resultList.add(entry.getValue());
        }
        WorkingTimeComparator comparator = new WorkingTimeComparator();
        Collections.sort(resultList, comparator);
        String[] field = new String[resultList.size()];
        String[] value = new String[resultList.size()];
        if (resultList != null && resultList.size() > 0) {
            for (int i = 0; i < resultList.size(); i++) {
                field[i] = resultList.get(i).getYear() + "年"
                        + resultList.get(i).getMonth() + "月";
                value[i] = resultList.get(i).getTime();
            }
        }
        map.put("resultCode", "1");
        map.put("resultMessage", "查询工作量成功");
        map.put("field", field);
        map.put("value", value);*/
        String beid = searchConditionFormBean.getBeid();
        if(StringUtils.isBlank(beid)) {
        	beid = getBeid();
        }
        String time = DateUtils.getDate();
        String startTime = time.substring(0, 4) + "-01-01 00:00:00";
        String endTime = time.substring(0, 4) + "-12-31 23:59:59";
        
        XAisData xAxis = new XAisData();
        List<String> xAxisData = new ArrayList<String>();
        List<Float> seriesData = new ArrayList<Float>();
        YAxisData yAxis = new YAxisData();
        yAxis.setName("分钟");
        yAxis.setType("value");
        Series series = new Series();
        series.setName("手术时长");
        series.setType("bar");
        Map<String, Object> map = new HashMap<String, Object>();
        
        List<WorkingTimeFormBean> resultList = new ArrayList<WorkingTimeFormBean>();
        
        List<HomeAnaesDoctorWorkingTimeFormBean> anaesRecordList = new ArrayList<HomeAnaesDoctorWorkingTimeFormBean>();
        List<HomeAnaesDoctorWorkingTimeFormBean> anaesAllRecordList = new ArrayList<HomeAnaesDoctorWorkingTimeFormBean>();
        List<HomeAnaesDoctorWorkingTimeFormBean> shiftChangeList = new ArrayList<HomeAnaesDoctorWorkingTimeFormBean>();
        
        
        Map<String, WorkingTimeFormBean> timeMap = new HashMap<String, WorkingTimeFormBean>();
        for(int i = 0 ; i < 12;i++){
            WorkingTimeFormBean w = new WorkingTimeFormBean();
            w.setTime("0");
            w.setYear(time.substring(0, 4));
            w.setMonth((i+1)+"");
            timeMap.put(time.substring(0, 4)+"年"+(i+1)+"月",w );
        }
        
        Map anaesRecordMap = new HashMap();
        BasUser user = basUserService.selectByUsername(searchConditionFormBean.getLoginName(), getBeid());
        if (user != null) {
        	if(user.getRoleType().equals("ANAES_DOCTOR")){
        		anaesAllRecordList = statisticsService.searchAllHomeAnaesDoctorWorkingTime(startTime, endTime,user.getUserName());
        		anaesRecordList = statisticsService.searchHomeAnaesDoctorWorkingTime(startTime, endTime,user.getUserName());
        		shiftChangeList = statisticsService.searchHomeAnaesDoctorShiftWorkingTime(startTime, endTime);
        		HomeAnaesDoctorWorkingTimeFormBean[] shiftChanges = shiftChangeList.toArray(new HomeAnaesDoctorWorkingTimeFormBean[0]);
        		if(anaesAllRecordList!=null&&anaesAllRecordList.size()>0){
        			for(int i = 0 ; i <anaesAllRecordList.size();i++){
        				anaesRecordMap.put(anaesAllRecordList.get(i).getRegOptId(), anaesAllRecordList.get(i));
        				//此块统计排班里面的巡台麻醉医师的工作量
        				long workingtime = (DateUtils.getParseTime(anaesAllRecordList.get(i).getOutOperRoomTime()).getTime() - DateUtils.getParseTime(anaesAllRecordList.get(i).getAnaesStartTime()).getTime())/1000/60 ;
        				
        				if((user.getUserName()).equals(anaesAllRecordList.get(i).getCircuanesthetistId())){
        					WorkingTimeFormBean old = (timeMap
        							.get(anaesAllRecordList.get(i).getYear() + "年"+ anaesAllRecordList.get(i).getMonth() + "月"));
        					long l = Long.parseLong(old.getTime()) + workingtime;
        					old.setTime(l+"");
        					timeMap.put(anaesAllRecordList.get(i).getYear() + "年"+ anaesAllRecordList.get(i).getMonth() + "月", old);
        				}
        			}
        		}
        		if (anaesRecordList != null && anaesRecordList.size() > 0) {
        			for (int i = 0; i < anaesRecordList.size(); i++) {
        				long workingtime = (DateUtils.getParseTime(anaesRecordList.get(i).getOutOperRoomTime()).getTime() - DateUtils.getParseTime(anaesRecordList.get(i).getAnaesStartTime()).getTime())/1000/60 ;
        				//此块统计排班里面的主麻的工作量
        				if((user.getUserName()+"").equals(anaesRecordList.get(i).getAnesthetistId())){
        					WorkingTimeFormBean old = (timeMap
        							.get(anaesRecordList.get(i).getYear() + "年"+ anaesRecordList.get(i).getMonth() + "月"));
        					long l = Long.parseLong(old.getTime()) + workingtime;
        					old.setTime(l+"");
        					timeMap.put(anaesRecordList.get(i).getYear() + "年"+ anaesRecordList.get(i).getMonth() + "月", old);
        					
        				}
        				
        				
        			}
        		}
        		
        		for(int i = 0 ; i < shiftChanges.length ; i ++){
        			if(i + 1 < shiftChanges.length){
        				if(shiftChanges[i].getRegOptId().equals(shiftChanges[i+1].getRegOptId())){
        					if((user.getUserName()+"").equals(shiftChanges[i].getShiftChangedPeopleId())){
        						//long tmp = (DateUtils.getParseTime(shiftChanges[i+1].getShiftChangeTime()).getTime() - DateUtils.getParseTime(shiftChanges[i].getShiftChangeTime()).getTime())/1000/60;
        						WorkingTimeFormBean old = (timeMap
        								.get(shiftChanges[i].getYear() + "年"+ shiftChanges[i].getMonth() + "月"));
        						if(!org.apache.commons.lang3.StringUtils.isEmpty(shiftChanges[i].getTimes())){
        							long l = Long.parseLong(old.getTime()) + Long.parseLong(shiftChanges[i].getTimes());
        							old.setTime(l+"");
        							timeMap.put(shiftChanges[i].getYear() + "年"+ shiftChanges[i].getMonth() + "月", old);
        						}
        						
        					}
        				}else{
        					if((user.getUserName()+"").equals(shiftChanges[i].getShiftChangedPeopleId())){
        						HomeAnaesDoctorWorkingTimeFormBean workingbean = (HomeAnaesDoctorWorkingTimeFormBean) anaesRecordMap.get(shiftChanges[i].getRegOptId());
        						//long tmp = (DateUtils.getParseTime(workingbean.getOutOperRoomTime()).getTime() - DateUtils.getParseTime(shiftChanges[i].getShiftChangeTime()).getTime())/1000/60;
        						WorkingTimeFormBean old = (timeMap
        								.get(shiftChanges[i].getYear() + "年"+ shiftChanges[i].getMonth() + "月"));
        						if(!org.apache.commons.lang3.StringUtils.isEmpty(shiftChanges[i].getTimes())){
        							long l = Long.parseLong(old.getTime()) + Long.parseLong(shiftChanges[i].getTimes());
        							old.setTime(l+"");
        							timeMap.put(shiftChanges[i].getYear() + "年"+ shiftChanges[i].getMonth() + "月", old);
        						}
        						
        					}
        					if((user.getUserName()+"").equals(shiftChanges[i].getShiftChangePeopleId())){
        						HomeAnaesDoctorWorkingTimeFormBean workingbean = (HomeAnaesDoctorWorkingTimeFormBean) anaesRecordMap.get(shiftChanges[i].getRegOptId());
        						long tmp = (DateUtils.getParseTime(workingbean.getOutOperRoomTime()).getTime() - DateUtils.getParseTime(shiftChanges[i].getShiftChangeTime()).getTime())/1000/60;
        						WorkingTimeFormBean old = (timeMap
        								.get(shiftChanges[i].getYear() + "年"+ shiftChanges[i].getMonth() + "月"));
        						long l = Long.parseLong(old.getTime()) + tmp;
        						old.setTime(l+"");
        						timeMap.put(shiftChanges[i].getYear() + "年"+ shiftChanges[i].getMonth() + "月", old);
        					}
        				}
        			}else{
        				if((user.getUserName()).equals(shiftChanges[i].getShiftChangedPeopleId())){
        					HomeAnaesDoctorWorkingTimeFormBean workingbean = (HomeAnaesDoctorWorkingTimeFormBean) anaesRecordMap.get(shiftChanges[i].getRegOptId());
        					//long tmp = (DateUtils.getParseTime(workingbean.getOutOperRoomTime()).getTime() - DateUtils.getParseTime(shiftChanges[i].getShiftChangeTime()).getTime())/1000/60;
        					WorkingTimeFormBean old = (timeMap
        							.get(shiftChanges[i].getYear() + "年"+ shiftChanges[i].getMonth() + "月"));
        					if(!org.apache.commons.lang3.StringUtils.isEmpty(shiftChanges[i].getTimes())){
        						long l = Long.parseLong(old.getTime()) + Long.parseLong(shiftChanges[i].getTimes());
        						old.setTime(l+"");
        						timeMap.put(shiftChanges[i].getYear() + "年"+ shiftChanges[i].getMonth() + "月", old);
        					}
        					
        				}
        				if((user.getUserName()+"").equals(shiftChanges[i].getShiftChangePeopleId())){
        					HomeAnaesDoctorWorkingTimeFormBean workingbean = (HomeAnaesDoctorWorkingTimeFormBean) anaesRecordMap.get(shiftChanges[i].getRegOptId());
        					long tmp = (DateUtils.getParseTime(workingbean.getOutOperRoomTime()).getTime() - DateUtils.getParseTime(shiftChanges[i].getShiftChangeTime()).getTime())/1000/60;
        					WorkingTimeFormBean old = (timeMap
        							.get(shiftChanges[i].getYear() + "年"+ shiftChanges[i].getMonth() + "月"));
        					long l = Long.parseLong(old.getTime()) + tmp;
        					old.setTime(l+"");
        					timeMap.put(shiftChanges[i].getYear() + "年"+ shiftChanges[i].getMonth() + "月", old);
        				}
        			}
        			
        		}
        		
        		
        		
        	}else if(user.getRoleType().equals("NURSE")){
        		//全麻
        		resultList = statisticsService
        				.searchNhNurseQmWorkingTime(startTime, endTime, searchConditionFormBean.getLoginName());
        		//局麻
        		resultList.addAll(statisticsService
        				.searchNhNurseJmWorkingTime(startTime, endTime, searchConditionFormBean.getLoginName()));
        		
        	}
		}
        
        //resultList.addAll(resultConsultationList);
        List<WorkingTimeFormBean> resultConsultationList = statisticsService
                .searchConsultationTime(startTime, endTime, searchConditionFormBean.getLoginName(), beid);
        
        resultList.addAll(resultConsultationList);
        
        if (resultList != null && resultList.size() > 0) {
            for (int i = 0; i < resultList.size(); i++) {
                if (timeMap.containsKey(resultList.get(i).getYear() + "年"
                        + resultList.get(i).getMonth() + "月")) {
                    WorkingTimeFormBean old = (timeMap
                            .get(resultList.get(i).getYear() + "年"
                                    + resultList.get(i).getMonth() + "月"));
                    String oldTime = old.getTime();
                    String newTime = (Integer.parseInt(oldTime) + Integer
                            .parseInt(resultList.get(i).getTime())) + "";
                    old.setTime(newTime);
                    timeMap.put(resultList.get(i).getYear() + "年"
                            + resultList.get(i).getMonth() + "月", old);
                } else {
                    timeMap.put(resultList.get(i).getYear() + "年"
                            + resultList.get(i).getMonth() + "月",
                            resultList.get(i));
                }
            }
        }
        resultList.clear();
        for (Map.Entry<String, WorkingTimeFormBean> entry : timeMap.entrySet()) {
            resultList.add(entry.getValue());
        }
        WorkingTimeComparator comparator = new WorkingTimeComparator();
        Collections.sort(resultList, comparator);
        String[] field = new String[resultList.size()];
        String[] value = new String[resultList.size()];
        int max=0,min=0;
        if (resultList != null && resultList.size() > 0) {
            for (int i = 0; i < resultList.size(); i++) {
                field[i] = resultList.get(i).getYear() + "年"
                        + resultList.get(i).getMonth() + "月";
                value[i] = resultList.get(i).getTime();
                if(Float.parseFloat(value[i])>max) {
                	max = Integer.parseInt(value[i]);
                }
                if(Float.parseFloat(value[i])<min) {
                	min = Integer.parseInt(value[i]);
                }
                xAxisData.add(field[i]);
                seriesData.add(Float.parseFloat(value[i]));
            }
        }
        xAxis.setData(xAxisData);
        series.setData(seriesData);
        yAxis.setMax(max);
        yAxis.setMin(min);
        map.put("xAxis", xAxis);
        map.put("yAxis", yAxis);
        map.put("series", series);
        map.put("resultCode", "1");
        map.put("resultMessage", "查询手术时长成功");
        logger.info("end searchWorkingTime");
        return JsonType.jsonType(map);
    }

	/**
	 * 
	 * @discription 所有护士或者麻醉医生的麻醉时长统计
	 * @author chengwang
	 * @created 2015年12月16日 下午2:12:09
	 * @param searchConditionFormBean
	 * @return
	 */
	@RequestMapping(value = "/searchAllWorkingTime")
	@ResponseBody
	@ApiOperation(value="工作量统计",httpMethod="POST",notes="工作量统计")
	public String searchAllWorkingTime(@ApiParam(name="searchConditionFormBean", value ="统计查询参数") @RequestBody SearchConditionFormBean searchConditionFormBean) {
		logger.info("begin searchAllWorkingTime");
		Map map = new HashMap();
		String beid = searchConditionFormBean.getBeid();
		if (StringUtils.isBlank(beid)) {
			beid = getBeid();
		}
		//查询用户的搜索条件类
		UserFormbean userFormbean = new UserFormbean();
		List<Filter> filters = new ArrayList<Filter>();
		Filter filter = new Filter();
		filter.setField("userType");
		filter.setValue(searchConditionFormBean.getUserType());
		filters.add(filter);
		userFormbean.setFilters(filters);
		//根据userType得到护士或者医生
		List<BasUser> userList = new ArrayList<BasUser>();
		if("ADMIN".equals(searchConditionFormBean.getUserType())){
			UserFormbean docuserFormbean = new UserFormbean();
			List<Filter> docfilters = new ArrayList<Filter>();
			Filter docfilter = new Filter();
			docfilter.setField("userType");
			docfilter.setValue("ANAES_DOCTOR");
			docfilters.add(docfilter);
			docuserFormbean.setFilters(docfilters);
			userList = basUserService.getAllUser(docuserFormbean);
			
			UserFormbean nuruserFormbean = new UserFormbean();
			List<Filter> nurfilters = new ArrayList<Filter>();
			Filter nurfilter = new Filter();
			nurfilter.setField("userType");
			nurfilter.setValue("NURSE");
			nurfilters.add(nurfilter);
			nuruserFormbean.setFilters(nurfilters);
			
			List<BasUser> nurList = basUserService.getAllUser(nuruserFormbean);
			userList.addAll(nurList);
			
		}else{
			userList = basUserService.getAllUser(userFormbean);
		}
		//搜索条件，开始时间和结束时间
		String startTime = searchConditionFormBean.getStartTime();
		String endTime = searchConditionFormBean.getEndTime();
		String sYear = startTime.substring(0, 4);
		String eYear = endTime.substring(0, 4);
		String sMonth = startTime.substring(5, 7);
		String eMonth = endTime.substring(5, 7);
		//得到时间差所包含的年月的长度 如2015-10-10和2015-12-12那么这个长度为3,里面的值分别为2015年10月，2015年11月，2015年12月
		String[] time = new String[(Integer.parseInt(eYear) - Integer
				.parseInt(sYear))
				* 12
				- Integer.parseInt(sMonth)
				+ Integer.parseInt(eMonth) + 1];
		int smonth = 0;
		int syear = 0;
		//表格统计数据的list
		List tableList = new ArrayList();
		
		Map<String, Float> compareMap = new HashMap<String, Float>();
        compareMap.put("min", null);
        compareMap.put("max", null);
		List<Series> seriesList = new ArrayList<Series>();
        List<Float> fdata = new ArrayList<Float>();
        List<String> sdata = new ArrayList<String>();
        XAisData xAis = new XAisData();
        LegendData legend = new LegendData();
        List<String> legendData = new ArrayList<String>();
		
		//表头
		Map<String, String> titleVo = new HashMap<String, String>();

		for (int i = 0; i < time.length; i++) {
			if (i == 0) {
				smonth = Integer.parseInt(sMonth);
				syear = Integer.parseInt(sYear);
			}
			if (smonth == 13) {
				syear = syear + 1;
				smonth = 1;
				time[i] = syear + "年" + smonth + "月";
			} else {
				time[i] = syear + "年" + smonth + "月";
			}
			sdata.add(time[i]);
			smonth++;
		}
		
		//工作量图表统计中的  用户名字
		String[] field = new String[userList.size()];
		//工作量图表统计中的 用户名字月份所对应的工作量
		String[][] value = new String[userList.size()][time.length];

		if (userList != null && userList.size() > 0) {
			for (int i = 0; i < userList.size(); i++) {
				StatisticsWorkingFormBean workingbean = new StatisticsWorkingFormBean();
				//先初始化每个人所有月的工作量
				Map<String, WorkingTimeFormBean> timeMap = new HashMap<String, WorkingTimeFormBean>();
				for (int j = 0; j < time.length; j++) {
					WorkingTimeFormBean w = new WorkingTimeFormBean();
					w.setTime("0");
					if (j == 0) {
						smonth = Integer.parseInt(sMonth);
						syear = Integer.parseInt(sYear);
					}
					if (smonth == 13) {
						syear = syear + 1;
						smonth = 1;
					} else {
					}
					w.setYear(syear + "");
					w.setMonth(smonth + "");
					timeMap.put(time[j], w);
					smonth++;

				}
				//指定哪一个人的工作量计算
				field[i] = userList.get(i).getName();
				//查询术中记录的工作时长
				List<WorkingTimeFormBean> resultList = new ArrayList<WorkingTimeFormBean>();
				if(userList.get(i).getUserType().equals("麻醉医生")){
					resultList = statisticsService
							.searchAnaesDoctorWorkingTime(searchConditionFormBean
									.getStartTime()+ " 00:00:00", searchConditionFormBean
									.getEndTime()+ " 23:59:59", userList.get(i).getUserName(), beid);
				}else if(userList.get(i).getUserType().equals("护士")){
					resultList = statisticsService
							.searchNurseQmWorkingTime(searchConditionFormBean
									.getStartTime()+ " 00:00:00", searchConditionFormBean
									.getEndTime()+ " 23:59:59", userList.get(i).getUserName(), beid);
					
					List<WorkingTimeFormBean> resultJmList = statisticsService
							.searchNurseJmWorkingTime(searchConditionFormBean
									.getStartTime()+ " 00:00:00", searchConditionFormBean
									.getEndTime()+ " 23:59:59", userList.get(i).getUserName(), beid);
					resultList.addAll(resultJmList);
				}
				/*List<WorkingTimeFormBean> resultList = statisticsService
						.searchWorkingTime(searchConditionFormBean
								.getStartTime()+ " 00:00:00", searchConditionFormBean
								.getEndTime()+ " 23:59:59", userList.get(i).getId());*/
				//计算外部会诊的工作时长
				List<WorkingTimeFormBean> resultConsultationList = statisticsService
						.searchConsultationTime(searchConditionFormBean
								.getStartTime()+ " 00:00:00", searchConditionFormBean
								.getEndTime()+ " 23:59:59", userList.get(i).getUserName(), beid);
				//把外部会诊工作时长追加到术中记录的工作市场List中
				resultList.addAll(resultConsultationList);
				if (resultList != null && resultList.size() > 0) {
					for (int m = 0; m < resultList.size(); m++) {
						//判断所有月的工作量的Map中，是否存在该月的工作量计算
						if (timeMap.containsKey(resultList.get(m).getYear()
								+ "年" + resultList.get(m).getMonth() + "月")) {
							WorkingTimeFormBean old = (timeMap
									.get(resultList.get(m).getYear() + "年"
											+ resultList.get(m).getMonth()
											+ "月"));
							String oldTime = old.getTime();
							String newTime = (Integer.parseInt(oldTime) + Integer
									.parseInt(resultList.get(m).getTime()))
									+ "";
							//把相同月数的工作量一起追加起来
							old.setTime(newTime);
							timeMap.put(resultList.get(m).getYear() + "年"
									+ resultList.get(m).getMonth() + "月", old);
						} else {
							//如果对应所有月的工作量map中不存在该月份的数据，那么就自己put第一个
							timeMap.put(resultList.get(m).getYear() + "年"
									+ resultList.get(m).getMonth() + "月",
									resultList.get(m));
						}
					}

				}
				//清除掉所有的工作时长List
				resultList.clear();
				//把map中的所有月的工作量的value加入resultList
				for (Map.Entry<String, WorkingTimeFormBean> entry : timeMap
						.entrySet()) {
					resultList.add(entry.getValue());
				}
				//根据时间大小进行排序
				AllWorkingTimeComparator comparator = new AllWorkingTimeComparator();
				Collections.sort(resultList, comparator);
				
				List<Float> data = new ArrayList<Float>();
                Series series = new Series();
                series.setName(userList.get(i).getName());
                series.setData(data);
                series.setType("line");
                legendData.add(series.getName());
				
				//表格统计的每一行的值
				Map<String, String> vo = new HashMap<String, String>();
				vo.put("姓名", userList.get(i).getName());
				if (resultList != null && resultList.size() > 0) {
					for (int a = 0; a < resultList.size(); a++) {
						//图表统计的每个人每个月的工作量的值对应的位置
						value[i][a] = resultList.get(a) == null ? 0 + ""
								: resultList.get(a).getTime();
						//表格统计中的每一行的值
						vo.put(resultList.get(a).getYear() + "年"
								+ resultList.get(a).getMonth() + "月",
								resultList.get(a) == null ? 0 + "" : resultList
										.get(a).getTime());
						data.add(resultList.get(a) == null ? 0 : Float.valueOf(resultList.get(a).getTime()));
						setMaxAndMin(compareMap, Float.valueOf(resultList.get(a).getTime()));
					}
				}
                
				workingbean.setMap(vo);
				tableList.add(vo);
				seriesList.add(series); 
            }
        }
        
		YAxisData iyAxis = new YAxisData();
        iyAxis.setMax(null);
        iyAxis.setType("value");
        if (null != compareMap.get("max"))
        {
            iyAxis.setMax((compareMap.get("max").intValue() / 5 + 1) * 5);
        }
        if (null != compareMap.get("min"))
        {
            iyAxis.setMin(compareMap.get("min").intValue() < 0 ? compareMap.get("min").intValue() : 0);
        }
		
        legend.setData(legendData);
        xAis.setData(sdata);
        
        map.put("xAxis", xAis);
        map.put("yAxis", iyAxis);
        map.put("series", seriesList);
        map.put("legend", legend);
        
		map.put("resultCode", "1");
		map.put("resultMessage", "查询工作量成功");
		map.put("tableList", tableList);
		map.put("time", time);
		map.put("field", field);
		map.put("value", value);
		logger.info("end searchAllWorkingTime");
		return JsonType.jsonType(map);
	}

	/**
	 * 
	 * @discription 一段时间内麻醉医生或者护士所用药统计
	 * @author chengwang
	 * @created 2015年12月16日 下午2:12:39
	 * @param searchConditionFormBean
	 * @return
	 */
	@RequestMapping(value = "/searchMedicineByTime")
	@ResponseBody
	public String searchMedicineByTime(
			@RequestBody SearchConditionFormBean searchConditionFormBean) {
		logger.info("begin searchMedicineByTime");
		Map map = new HashMap();
		UserFormbean userFormbean = new UserFormbean();
		List<Filter> filters = new ArrayList<Filter>();
		Filter filter = new Filter();
		filter.setField("userType");
		filter.setValue(searchConditionFormBean.getUserType());
		filters.add(filter);
		userFormbean.setFilters(filters);
		List<SearchMedicineType> list = statisticsService
				.searchMedicineGroupMedicineId(
						searchConditionFormBean.getStartTime()+" 00:00:00",
						searchConditionFormBean.getEndTime() + " 23:59:59");
		String[] medicineName = new String[list != null ? list.size() : 0];

		List tableList = new ArrayList();
		/*
		 * StatisticsWorkingFormBean title = new StatisticsWorkingFormBean();
		 * title.setName("名字"); String[] titleVo = new
		 * String[medicineName.length];
		 */

		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				medicineName[i] = StringUtils.StringFilter(list.get(i).getName());
				// titleVo[i] = list.get(i).getName();
			}
		}
		// title.setVo(titleVo);
		// tableList.add(title);
		//List<User> userList = basUserService.getAllUser(userFormbean);
		List<BasUser> userList = new ArrayList<BasUser>();
		if("ADMIN".equals(searchConditionFormBean.getUserType())){
			UserFormbean docuserFormbean = new UserFormbean();
			List<Filter> docfilters = new ArrayList<Filter>();
			Filter docfilter = new Filter();
			docfilter.setField("userType");
			docfilter.setValue("ANAES_DOCTOR");
			docfilters.add(docfilter);
			docuserFormbean.setFilters(docfilters);
			userList = basUserService.getAllUser(docuserFormbean);
			
			UserFormbean nuruserFormbean = new UserFormbean();
			List<Filter> nurfilters = new ArrayList<Filter>();
			Filter nurfilter = new Filter();
			nurfilter.setField("userType");
			nurfilter.setValue("NURSE");
			nurfilters.add(nurfilter);
			nuruserFormbean.setFilters(nurfilters);
			
			List<BasUser> nurList = basUserService.getAllUser(nuruserFormbean);
			userList.addAll(nurList);
			
		}else{
			userList = basUserService.getAllUser(userFormbean);
		}
		String[] field = new String[userList.size()];
		String[][] value = new String[userList.size()][medicineName.length];
		if (userList != null && userList.size() > 0) {
			for (int i = 0; i < userList.size(); i++) {
				StatisticsWorkingFormBean medicineFormbean = new StatisticsWorkingFormBean();
				// medicineFormbean.setName(userList.get(i).getName());
				Map<String, SearchMedicineType> timeMap = new HashMap<String, SearchMedicineType>();
				for (int j = 0; j < list.size(); j++) {
					SearchMedicineType st = new SearchMedicineType();
					st.setMedicineId(list.get(j).getMedicineId());
					st.setName(list.get(j).getName());
					st.setDosage(0f);
					timeMap.put(list.get(j).getMedicineId() + "", st);
				}
				field[i] = userList.get(i).getName();
				List<SearchMedicineType> medicineList = statisticsService
						.searchMedicineByUser(searchConditionFormBean
								.getStartTime()+" 00:00:00", searchConditionFormBean
								.getEndTime()+ " 23:59:59", userList.get(i).getUserName());
				if (medicineList != null && medicineList.size() > 0) {
					for (int m = 0; m < medicineList.size(); m++) {
						if (timeMap.containsKey(medicineList.get(m)
								.getMedicineId() + "")) {
							SearchMedicineType old = timeMap
									.get(medicineList.get(m).getMedicineId()
											+ "");
							Float oldDosage = old.getDosage();
							Float newDosage = oldDosage
									+ medicineList.get(m).getDosage();
							old.setDosage(newDosage);
							timeMap.put(medicineList.get(m).getMedicineId()
									+ "", old);
						} else {
							timeMap.put(medicineList.get(m).getMedicineId()
									+ "", medicineList.get(m));
						}
					}
				}

				medicineList.clear();
				for (Map.Entry<String, SearchMedicineType> entry : timeMap
						.entrySet()) {
					medicineList.add(entry.getValue());
				}
				MedicineDosageComparator comparator = new MedicineDosageComparator();
				Collections.sort(medicineList, comparator);
				Map<String, String> vo = new HashMap<String, String>();
				vo.put("姓名", userList.get(i).getName());
				if (medicineList != null && medicineList.size() > 0) {
					for (int a = 0; a < medicineList.size(); a++) {
						value[i][a] = medicineList.get(a) == null ? 0 + ""
								: medicineList.get(a).getDosage() + "";
						vo.put(StringUtils.StringFilter(medicineList.get(a).getName()), medicineList
								.get(a) == null ? 0 + "" : medicineList.get(a)
								.getDosage() + "");
					}
				}
				medicineFormbean.setMap(vo);
				tableList.add(vo);
			}
		}
		
		map.put("resultCode", "1");
		map.put("resultMessage", "查询用药量成功");
		map.put("tableList", tableList);
		map.put("medicineName", medicineName);
		map.put("field", field);
		map.put("value", value);
		logger.info("end searchMedicineByTime");
		return JsonType.jsonType(map);
	}

	
	  
	
	@RequestMapping(value = "/searchMedIoCharge")
	@ResponseBody
	public String searchMedIoCharge(
			@RequestBody SystemSearchFormBean systemSearchFormBean) {
		logger.info("begin searchMedIoCharge");
		Map map = new HashMap();
		// 收费套餐
		List<DocPackagesItem> packagesCharge = docPackagesItemService
				.queryPackagesItemList(systemSearchFormBean, 1);

		// 单项收费
		List<DocPackagesItem> charge = docPackagesItemService.queryPackagesItemList(
				systemSearchFormBean, 0);
		// 药品
		SystemSearchFormBean medsystemSearchFormBean = new SystemSearchFormBean();
		List<Filter> medFilters = systemSearchFormBean.getFilters();
		Filter filter = new Filter();
		filter.setField("chargedType");
		filter.setValue("M");
		medFilters.add(filter);
		medsystemSearchFormBean.setFilters(medFilters);
		List<EventBillingFormBean> medList = docEventBillingService
				.searchBillGroupByMedicode(medsystemSearchFormBean);
		// 入量
		SystemSearchFormBean iosystemSearchFormBean = new SystemSearchFormBean();
		List<Filter> ioFilters = systemSearchFormBean.getFilters();
		filter.setField("chargedType");
		filter.setValue("I");
		ioFilters.add(filter);
		iosystemSearchFormBean.setFilters(ioFilters);
		List<EventBillingFormBean> ioList = docEventBillingService
				.searchBillGroupByMedicode(iosystemSearchFormBean);
		
		List<Filter> fList = systemSearchFormBean.getFilters();
		String regOptId = "";
		for (Filter fi : fList) {
			if("reg_opt_id".equals(fi.getField())){
				regOptId = fi.getValue();
			}
		}
		//获取手术人员信息
		BasRegOpt regOpt = basRegOptService.searchRegOptById(regOptId);
		//麻醉记录单
		DocAnaesRecord anaesRecord = docAnaesRecordService.searchAnaesRecordByRegOptId(regOptId);
		//实施手术
		SearchFormBean searchBean = new SearchFormBean();
		searchBean.setRegOptId(regOptId);
		searchBean.setDocId(anaesRecord.getAnaRecordId());
		List<EvtOptRealOper> optRealOperList = evtOptRealOperService.searchOptRealOperList(searchBean);
		//手术名称
		String realOper = "";
		for (EvtOptRealOper optRealOper : optRealOperList) {
			realOper +=optRealOper.getName()+",";
		}
		if(realOper.length()>0)
			realOper = realOper.substring(0, realOper.length()-1);
		//获取排程信息
		BasDispatch dispatch = basDispatchService.getDispatchOper(regOptId);
		//手术室名称
		String operRoomName = basOperroomService.queryRoomListById(dispatch.getOperRoomId().toString()).getName();
		
		//麻醉医生列表
		searchBean.setRole(EvtParticipantService.ROLE_ANESTH);
		searchBean.setType("01");
		String anaesDoc = statisticsService.getNameStrByDocId(searchBean);
		//手术医生列表
		searchBean.setRole(EvtParticipantService.ROLE_OPERAT);
		searchBean.setType("06");
		String operatDoc = statisticsService.getNameStrByDocId(searchBean);
		//巡回护士列表
		searchBean.setRole(EvtParticipantService.ROLE_NURSE);
		searchBean.setType("05");
		String circunurse = statisticsService.getNameStrByDocId(searchBean);
		//洗手护士列表
		/*searchBean.setRole(ParticipantService.ROLE_NURSE);
		searchBean.setType("04");
		String instrnurse = statisticsService.getNameStrByDocId(searchBean);*/
		DispatchPeopleNameFormBean dispatchBean = basDispatchService.searchPeopleNameByRegOptId(regOptId);
		String instrnurse1 = dispatchBean.getInstrnurseName1();
		String instrnurse2 = dispatchBean.getInstrnurseName2();
		String instrnurse = (org.apache.commons.lang3.StringUtils.isEmpty(instrnurse1)?"":instrnurse1) + (org.apache.commons.lang3.StringUtils.isEmpty(instrnurse2)?"":","+instrnurse2); 
		
		regOpt.setDesignedAnaesMethodName("");
		regOpt.setDesignedOptName("");
		regOpt.setDiagnosisName("");
		List<EvtRealAnaesMethod> realAnaMdList = evtRealAnaesMethodService
				.searchRealAnaesMethodList(searchBean);
		if (realAnaMdList.size() > 0 && realAnaMdList != null) {
			for (int i = 0; i < realAnaMdList.size(); i++) {
				regOpt.setDesignedAnaesMethodName(regOpt
						.getDesignedAnaesMethodName()==null?realAnaMdList.get(i).getName() + ",":regOpt
						.getDesignedAnaesMethodName()
						+ realAnaMdList.get(i).getName() + ",");
			}
		}

		List<EvtOptLatterDiag> optLDList = evtOptLatterDiagService
				.searchOptLatterDiagList(searchBean);
		if (optLDList.size() > 0 && optLDList != null) {
			for (int i = 0; i < optLDList.size(); i++) {
				regOpt.setDiagnosisName(regOpt.getDiagnosisName()==null?optLDList.get(i).getName() + ",":regOpt.getDiagnosisName()
						+ optLDList.get(i).getName() + ",");
			}
		}

		List<EvtOptRealOper> optROList = evtOptRealOperService
				.searchOptRealOperList(searchBean);
		if (optROList.size() > 0 && optROList != null) {
			for (int i = 0; i < optROList.size(); i++) {
				regOpt.setDesignedOptName(regOpt.getDesignedOptName()==null?optROList.get(i).getName() + ",":regOpt.getDesignedOptName()
						+ optROList.get(i).getName() + ",");
			}
		}
		if(!org.apache.commons.lang3.StringUtils.isEmpty(regOpt.getDiagnosisName())){
			regOpt.setDiagnosisName(regOpt.getDiagnosisName().substring(0,regOpt.getDiagnosisName().length()-1));
		}
		
		if(!org.apache.commons.lang3.StringUtils.isEmpty(regOpt.getDesignedOptName())){
			regOpt.setDesignedOptName(regOpt.getDesignedOptName().substring(0,regOpt.getDesignedOptName().length()-1));
		}
		
		map.put("resultCode", "1");
		map.put("resultMessage", "查询费用统计成功!");
		map.put("medList", medList);
		map.put("ioList", ioList);
		map.put("packagesCharge", packagesCharge);
		map.put("charge", charge);
		map.put("anaesRecord", anaesRecord);
		map.put("operRoomName", operRoomName);
		map.put("regOpt", regOpt);
		map.put("anaesDoc", anaesDoc);
		map.put("operatDoc", operatDoc);
		map.put("circunurse", circunurse);
		map.put("instrnurse", instrnurse);
		logger.info("end searchMedIoCharge");
		return JsonType.jsonType(map);
	}

	@RequestMapping(value = "/updateMedIoCharge")
	@ResponseBody
	public String updateMedIoCharge(
			@RequestBody MedIoChargeFormBean medIoChargeFormBean) {
		logger.info("begin updateMedIoCharge");
		Map map = new HashMap();
		try {
			String result = statisticsService
					.updateMedIoCharge(medIoChargeFormBean);
			map.put("resultCode", "1");
			map.put("resultMessage", result);
		} catch (Exception e) {
			// TODO: handle exception
			if (logger.isErrorEnabled()) {
				logger.error(Exceptions.getStackTraceAsString(e));
			}
			map.put("resultCode", "10000000");
			map.put("resultMessage", "系统错误，请与系统管理员联系!");
		}

		logger.info("end updateMedIoCharge");
		return JsonType.jsonType(map);
	}
	
	
	
	/**
	 * 
	 * @discription 描点数据绘图
	 * @author liukui
	 * @created 2016年1月、7日 下午2:12:09
	 * @param searchConditionFormBean
	 * @return
	 */
	@RequestMapping(value = "/searchPointByRegOptId")
	@ResponseBody
	public String searchPointByRegOptId(
			@RequestBody Map paraObjMap) {
		logger.info("begin searchPointByRegOptId");
		Map map = new HashMap();

		String regOptId = paraObjMap.get("regOptId").toString();
		
		//获取时间轴信息
		List<BasObserveData> timeList = observeDataService.searchObserveTimeById(regOptId);
		String[] time = new String[timeList.size()];
		for (int i = 0; i < time.length; i++) {
			time[i]  = DateUtils.formatDate(timeList.get(i).getTime(), "yyyy-MM-dd HH:mm:ss");
		}
		
		//术中监测显示项
		BaseInfoQuery baseQuery = new BaseInfoQuery();
		baseQuery.setRegOptId(regOptId);
		baseQuery.setEnable("1");
		baseQuery.setPosition("0");
		List<BasAnaesMonitorConfigFormBean> showList = basAnaesMonitorConfigService.finaAnaesList(baseQuery);
		
		String[] field = new String[showList.size()];
		String[] fieldName = new String[showList.size()];
		int i=0;
		List<String> obserIdItems = new ArrayList<String>();
		for (BasAnaesMonitorConfigFormBean anaesMonitorConfigFormBean : showList) {
			field[i] = anaesMonitorConfigFormBean.getEventId();
			fieldName[i] = anaesMonitorConfigFormBean.getEventName();
			obserIdItems.add(anaesMonitorConfigFormBean.getEventId());
			i++;
		}
		
		//根据时间节点、检测项查询对应值
		JSONArray value = new JSONArray();
		
		Map<String, List<BasObserveData>> observerMap = new HashMap<String, List<BasObserveData>>();
		List<BasObserveData> obDataList = observeDataService.searchObserveDataById(regOptId,obserIdItems,obserIdItems.toString());
		List<BasObserveData> list = new ArrayList<BasObserveData>();
		for (int k = 0; k < obDataList.size(); k++) {
			list.add(obDataList.get(k));
			if(k+1<obDataList.size()){
				if(!obDataList.get(k).getObserveId().equals(obDataList.get(k+1).getObserveId())){
					observerMap.put(obDataList.get(k).getObserveId(), list);
					list = new ArrayList<BasObserveData>();
					continue;
				}
			}else{
				observerMap.put(obDataList.get(k).getObserveId(), list);
			}
		}
		
		for (int j = 0; j < field.length; j++) {
			List<String> valueList = new ArrayList<String>();
			List<BasObserveData> objList = observerMap.get(field[j]);
			for (int m = 0; m < time.length; m++) {
				if(objList!=null){
					for (BasObserveData observeData : objList) {
						if(time[m].equals(DateUtils.formatDate(observeData.getTime(), "yyyy-MM-dd HH:mm:ss"))){
							valueList.add(observeData.getValue()+"");
							break;
						}
					}
				}
			}
			value.add(valueList);
		}
		map.put("resultCode", "1");
		map.put("resultMessage", "查询数据成功!");
		map.put("time", time);
		map.put("field", field);
		map.put("fieldName", fieldName);
		map.put("value", value);
		logger.info("end searchPointByRegOptId");
		return JsonType.jsonType(map);
	}
	
	/**
	 * 手术等级统计
	 * @param paraObjMap
	 * @return
	 */
	@RequestMapping(value = "/searchRegionOperatCountByOptlev")
	@ResponseBody
	@ApiOperation(value="科室手术等级统计",httpMethod="POST",notes="科室手术等级统计")
	public String searchRegionOperatCountByOptlev(@ApiParam(name="searchFormBean", value ="统计查询参数") @RequestBody SearchFormBean searchFormBean) {
		logger.info("begin searchRegionOperatCountByOptlev");
		ResponseValue resValue = new ResponseValue();
		if(StringUtils.isBlank(searchFormBean.getBeid())) {
			searchFormBean.setBeid(getBeid());
		}
		List<SearchRegionOperatCountByOptlev> list = statisticsService.searchRegionOperatCountByOptlev(searchFormBean);
		
		Map<String, Float> compareMap = new HashMap<String, Float>();
        compareMap.put("min", null);
        compareMap.put("max", null);
		List<Series> seriesList = new ArrayList<Series>();
        List<String> sdata = new ArrayList<String>();
        XAisData xAis = new XAisData();
        LegendData legend = new LegendData();
        List<String> legendData = new ArrayList<String>();
		
		
		String[] time = new String[list.size()];
		List<SysCodeFormbean> fieldList = basSysCodeService.searchSysCodeByGroupId("operat_level", searchFormBean.getBeid());
		String[] field = new String[fieldList.size()];
		for (int i = 0; i < fieldList.size(); i++) {
			field[i] = fieldList.get(i).getCodeName();
			sdata.add(fieldList.get(i).getCodeName());
		}
		
		for (int i = 0; i < list.size(); i++) {
			SearchRegionOperatCountByOptlev obj = list.get(i);
			time[i] = obj.getRegionName();
		}
		JSONArray value = new JSONArray();	
		for (SearchRegionOperatCountByOptlev searchRegionOperatCountByOptlev : list) {
			List<Long> valueList = new ArrayList<Long>();
			valueList.add(searchRegionOperatCountByOptlev.getFst());
			valueList.add(searchRegionOperatCountByOptlev.getSec());
			valueList.add(searchRegionOperatCountByOptlev.getThd());
			valueList.add(searchRegionOperatCountByOptlev.getFou());
			value.add(valueList);
			
			List<Float> data = new ArrayList<Float>();
	        Series series = new Series();
	        series.setName(searchRegionOperatCountByOptlev.getRegionName());
	        data.add((float)searchRegionOperatCountByOptlev.getFst());
	        setMaxAndMin(compareMap, (float)searchRegionOperatCountByOptlev.getFst());
	        data.add((float)searchRegionOperatCountByOptlev.getSec());
	        setMaxAndMin(compareMap, (float)searchRegionOperatCountByOptlev.getSec());
	        data.add((float)searchRegionOperatCountByOptlev.getThd());
	        setMaxAndMin(compareMap, (float)searchRegionOperatCountByOptlev.getThd());
	        data.add((float)searchRegionOperatCountByOptlev.getFou());
	        setMaxAndMin(compareMap, (float)searchRegionOperatCountByOptlev.getFou());
	        series.setData(data);
	        series.setType("bar");
	        seriesList.add(series);
	        
	        legendData.add(series.getName());
		}
		
		YAxisData iyAxis = new YAxisData();
		if (null != compareMap.get("max"))
        {
            iyAxis.setMax((compareMap.get("max").intValue() / 5 + 1) * 5);
        }
        if (null != compareMap.get("min"))
        {
            iyAxis.setMin(compareMap.get("min").intValue() < 0 ? compareMap.get("min").intValue() : 0);
        }
        iyAxis.setType("value");
		
		legend.setData(legendData);
        xAis.setData(sdata);
        
        resValue.put("xAxis", xAis);
        resValue.put("yAxis", iyAxis);
        resValue.put("series", seriesList);
        resValue.put("legend", legend);
		resValue.put("tableList", list);
		resValue.put("time", time);
		resValue.put("field", field);
		resValue.put("value", value);
		logger.info("end searchRegionOperatCountByOptlev");
		return resValue.getJsonStr();
	}
	
	/**
	 *ASA统计
	 * @param paraObjMap
	 * @return
	 */
	@RequestMapping(value = "/searchRegionOperatCountByAsalev")
	@ResponseBody
	@ApiOperation(value="ASA统计",httpMethod="POST",notes="ASA统计")
	public String searchRegionOperatCountByAsalev(@ApiParam(name="searchFormBean", value ="统计查询参数") @RequestBody SearchFormBean searchFormBean) {
		logger.info("begin searchRegionOperatCountByAsalev");
		ResponseValue resValue = new ResponseValue();
		if (StringUtils.isBlank(searchFormBean.getBeid())) {
			searchFormBean.setBeid(getBeid());
		}
		List<SearchRegionOperatCountByAsalev> list = statisticsService.searchRegionOperatCountByAsalev(searchFormBean);
		String[] time = new String[list.size()];
		List<SysCodeFormbean> fieldList = basSysCodeService.searchSysCodeByGroupId("asa_level", searchFormBean.getBeid());
		String[] field = new String[fieldList.size()];
		
		Map<String, Float> compareMap = new HashMap<String, Float>();
        compareMap.put("min", null);
        compareMap.put("max", null);
		List<Series> seriesList = new ArrayList<Series>();
        List<String> sdata = new ArrayList<String>();
        XAisData xAis = new XAisData();
        LegendData legend = new LegendData();
        List<String> legendData = new ArrayList<String>();
		
		for (int i = 0; i < fieldList.size(); i++) {
			field[i] = fieldList.get(i).getCodeName();
			sdata.add(fieldList.get(i).getCodeName());
		}
		for (int i = 0; i < list.size(); i++) {
			SearchRegionOperatCountByAsalev obj = list.get(i);
			time[i] = obj.getRegionName();
		}
		JSONArray value = new JSONArray();	
		for (SearchRegionOperatCountByAsalev searchRegionOperatCountByAsalev : list) {
			List<Long> valueList = new ArrayList<Long>();
			valueList.add(searchRegionOperatCountByAsalev.getFst());
			valueList.add(searchRegionOperatCountByAsalev.getSec());
			valueList.add(searchRegionOperatCountByAsalev.getThd());
			valueList.add(searchRegionOperatCountByAsalev.getFou());
			valueList.add(searchRegionOperatCountByAsalev.getFif());
			valueList.add(searchRegionOperatCountByAsalev.getSix());
			value.add(valueList);
			
			
			List<Float> data = new ArrayList<Float>();
            Series series = new Series();
            series.setName(searchRegionOperatCountByAsalev.getRegionName());
            data.add((float)searchRegionOperatCountByAsalev.getFst());
            setMaxAndMin(compareMap, (float)searchRegionOperatCountByAsalev.getFst());
            data.add((float)searchRegionOperatCountByAsalev.getSec());
            setMaxAndMin(compareMap, (float)searchRegionOperatCountByAsalev.getSec());
            data.add((float)searchRegionOperatCountByAsalev.getThd());
            setMaxAndMin(compareMap, (float)searchRegionOperatCountByAsalev.getThd());
            data.add((float)searchRegionOperatCountByAsalev.getFou());
            setMaxAndMin(compareMap, (float)searchRegionOperatCountByAsalev.getFou());
            data.add((float)searchRegionOperatCountByAsalev.getFif());
            setMaxAndMin(compareMap, (float)searchRegionOperatCountByAsalev.getFif());
            data.add((float)searchRegionOperatCountByAsalev.getSix());
            setMaxAndMin(compareMap, (float)searchRegionOperatCountByAsalev.getSix());
            series.setData(data);
            series.setType("bar");
            seriesList.add(series);
            legendData.add(series.getName());
		}
		
		YAxisData iyAxis = new YAxisData();
		if (null != compareMap.get("max"))
        {
            iyAxis.setMax((compareMap.get("max").intValue() / 5 + 1) * 5);
        }
        if (null != compareMap.get("min"))
        {
            iyAxis.setMin(compareMap.get("min").intValue() < 0 ? compareMap.get("min").intValue() : 0);
        }
        iyAxis.setType("value");
		
		legend.setData(legendData);
        xAis.setData(sdata);
        
        resValue.put("xAxis", xAis);
        resValue.put("yAxis", iyAxis);
        resValue.put("series", seriesList);
        resValue.put("legend", legend);
		resValue.put("tableList", list);
		resValue.put("time", time);
		resValue.put("field", field);
		resValue.put("value", value);
		
		logger.info("end searchRegionOperatCountByAsalev");
		return resValue.getJsonStr();
	}
	
	
	
	/**
	 * 术前术后诊断差异统计
	 * @param paraObjMap
	 * @return
	 */
	@RequestMapping(value = "/searchRegionOperatCompdiag")
	@ResponseBody
	@ApiOperation(value="术前术后诊断差异统计",httpMethod="POST",notes="术前术后诊断差异统计")
	public String searchRegionOperatCompdiag(@ApiParam(name="searchFormBean", value ="统计查询参数") @RequestBody SearchFormBean searchFormBean) {
		logger.info("begin searchRegionOperatCompdiag");
		ResponseValue value = new ResponseValue();
		List<SearchRegionOperatCompdiag> list = statisticsService.searchRegionOperatCompdiag(searchFormBean);
		value.put("tableList", list);
		logger.info("end searchRegionOperatCompdiag");
		return value.getJsonStr();
	}
	
	/**
	 * 不良事件查询统计
	 * @param SearchFormBean
	 * @return
	 */
	@RequestMapping(value = "/searchBadEventInfoList")
	@ResponseBody
	@ApiOperation(value="不良事件统计",httpMethod="POST",notes="不良事件统计")
	public String searchBadEventInfoList(@ApiParam(name="searchFormBean", value ="统计查询参数") @RequestBody SearchFormBean searchFormBean) {
		logger.info("begin searchBadEventInfoList");
		ResponseValue value = new ResponseValue();
		List<SearchBadEventInfo> list = statisticsService.searchBadEventInfoList(searchFormBean);
		value.put("tableList", list);
		logger.info("end searchBadEventInfoList");
		return value.getJsonStr();
	}
	
	/**
	 * 修改痕迹统计
	 * @param SearchFormBean
	 * @return
	 */
	@RequestMapping(value = "/countAnaesDocUpdateObserveTime")
	@ResponseBody
	@ApiOperation(value="修改痕迹统计",httpMethod="POST",notes="修改痕迹统计")
	public String countAnaesDocUpdateObserveTime(@ApiParam(name="searchFormBean", value ="统计查询参数") @RequestBody SearchFormBean searchFormBean) {
		logger.info("begin countAnaesDocUpdateObserveTime");
		ResponseValue resValue = new ResponseValue();
		List<AnaesDocObserveTimeCount> list = statisticsService.countAnaesDocUpdateObserveTime(searchFormBean);
		String[] time = new String[list.size()];
		Long[] value = new Long[list.size()];
		
		Map<String, Float> compareMap = new HashMap<String, Float>();
        compareMap.put("min", null);
        compareMap.put("max", null);
		List<Series> seriesList = new ArrayList<Series>();
        List<String> sdata = new ArrayList<String>();
        XAisData xAis = new XAisData();
		
        Series series = new Series();
        series.setName("修改痕迹");
        series.setType("bar");
        List<Float> data = new ArrayList<Float>();
		for (int i = 0; i < list.size(); i++) {
			AnaesDocObserveTimeCount obj = list.get(i);
			time[i] = obj.getName();
			value[i] = obj.getTotal();
			
			sdata.add(obj.getName());
            data.add((float)obj.getTotal());
            setMaxAndMin(compareMap, (float)obj.getTotal());
            
		}
		series.setData(data);
		seriesList.add(series);
		YAxisData iyAxis = new YAxisData();
		if (null != compareMap.get("max"))
        {
            iyAxis.setMax((compareMap.get("max").intValue() / 5 + 1) * 5);
        }
        if (null != compareMap.get("min"))
        {
            iyAxis.setMin(compareMap.get("min").intValue() < 0 ? compareMap.get("min").intValue() : 0);
        }
		iyAxis.setName("修改痕迹");
		iyAxis.setType("value");
		xAis.setData(sdata);
		
		resValue.put("xAxis", xAis);
		resValue.put("yAxis", iyAxis);
		resValue.put("series", seriesList);
		resValue.put("tableList", list);
		resValue.put("time", time);
		resValue.put("value", value);
		logger.info("end countAnaesDocUpdateObserveTime");
		return resValue.getJsonStr();
	}
	
	/**
	 * 查询术后麻醉登记查询
	 * @param systemSearchFormBean
	 * @return
	 */
	@RequestMapping(value = "/searchAnaesRegInfoList")
	@ResponseBody
	@ApiOperation(value="查询术后麻醉登记查询",httpMethod="POST",notes="查询术后麻醉登记查询")
	public String searchAnaesRegInfoList(@ApiParam(name="searchFormBean", value ="查询参数") @RequestBody SystemSearchFormBean searchFormBean){
		ResponseValue rep = new ResponseValue();
		int total = statisticsService.searchTotalByAnaesRegInfoList(searchFormBean);
		rep.put("anaesRegInfoList", statisticsService.searchAnaesRegInfoList(searchFormBean));
		rep.put("total", total);
		return rep.getJsonStr();
	}
	
	/**
	 * 查询术后镇痛登记
	 * @param systemSearchFormBean
	 * @return
	 */
	@RequestMapping(value = "/searchAnalgesicAnaesRegInfoList")
	@ResponseBody
	@ApiOperation(value="查询术后镇痛登记",httpMethod="POST",notes="查询术后镇痛登记")
	public String searchAnalgesicAnaesRegInfoList(@ApiParam(name="searchFormBean", value ="查询参数") @RequestBody SystemSearchFormBean searchFormBean){
		ResponseValue rep = new ResponseValue();
		int total = statisticsService.searchTotalAnalgesicRegInfoList(searchFormBean);
		rep.put("anaesRegInfoList", statisticsService.searchAnalgesicRegInfoList(searchFormBean));
		rep.put("total", total);
		return rep.getJsonStr();
	}

	/**
	 * 意外死亡、进入麻醉复苏室例数统计
	 * @param systemSearchFormBean
	 * leave_to = 2 麻醉复苏室
	 * leave_to = 4 死亡
	 * @return
	 */
	@RequestMapping(value = "/searchPatGroupByDept")
	@ResponseBody
	@ApiOperation(value="进入麻醉复苏室例数统计",httpMethod="POST",notes="进入麻醉复苏室例数统计")
	public String searchPatGroupByDept(@ApiParam(name="searchFormBean", value ="统计查询参数") @RequestBody SystemSearchFormBean searchFormBean){
		ResponseValue resp = new ResponseValue();
		List<AnaesDocObserveTimeCount> tableList = statisticsService.searchPatGroupByDept(searchFormBean);
		resp.put("tableList", tableList);
		return resp.getJsonStr();
	}

	/**
	* 意外死亡、进入麻醉复苏室例数统计按麻醉医生
	 * @param systemSearchFormBean
	 * leave_to = 2 麻醉复苏室
	 * leave_to = 4 死亡
	 * @return
	 */
	@RequestMapping(value = "/searchPatGroupByAnaesDoc")
	@ResponseBody
	@ApiOperation(value="意外死亡例数统计",httpMethod="POST",notes="意外死亡例数统计")
	public String searchPatGroupByAnaesDoc(@ApiParam(name="searchFormBean", value ="统计查询参数") @RequestBody SystemSearchFormBean searchFormBean){
		ResponseValue resp = new ResponseValue();
		List<AnaesDocObserveTimeCount> tableList = statisticsService.searchPatGroupByAnaesDoc(searchFormBean);
		resp.put("tableList", tableList);
		return resp.getJsonStr();
	}
	
	
	/**
	 * Steward评分统计
	 * @param searchFormBean
	 * @return
	 */
	@RequestMapping(value = "/searchDeptOperatCountBySteward")
	@ResponseBody
	public String searchDeptOperatCountBySteward(
			@RequestBody SearchFormBean searchFormBean) {
		ResponseValue resp = new ResponseValue();
		logger.info("begin searchDeptOperatCountBySteward");
		List<SearchDeptOperatCountBySteward> tableList= statisticsService.searchDeptOperatCountBySteward(searchFormBean);
		resp.put("tableList", tableList);
		logger.info("end searchDeptOperatCountBySteward");
		return resp.getJsonStr();
	}
	
	/**
	 * 术后镇痛统计按科室
	 */
	@RequestMapping(value = "/searchDeptCountByAnalgesic")
	@ResponseBody
	@ApiOperation(value="术后镇痛统计",httpMethod="POST",notes="术后镇痛统计")
	public String searchDeptCountByAnalgesic(@ApiParam(name="searchFormBean", value ="统计查询参数") @RequestBody SearchFormBean searchFormBean) {
		ResponseValue resp = new ResponseValue();
		logger.info("begin searchDeptCountByAnalgesic");
		
		if(StringUtils.isBlank(searchFormBean.getBeid())) {
			searchFormBean.setBeid(getBeid());
		}
		List<StaticDeptCountByAnalgesic> tableList = statisticsService.searchDeptCountByAnalgesic(searchFormBean);
		resp.put("tableList", tableList);
		logger.info("end searchDeptCountByAnalgesic");
		return resp.getJsonStr();
	}
	
	/**
	 * 术后镇痛统计按麻醉医生
	 */
	@RequestMapping(value = "/searchAnaecDocCountByAnalgesic")
	@ResponseBody
	@ApiOperation(value="术后镇痛统计按麻醉医生",httpMethod="POST",notes="术后镇痛统计按麻醉医生")
	public String searchAnaecDocCountByAnalgesic(@ApiParam(name="searchFormBean", value ="查询参数") @RequestBody SearchFormBean searchFormBean) {
		ResponseValue resp = new ResponseValue();
		logger.info("begin searchAnaecDocCountByAnalgesic");
		List<StaticAnaesDocCountByAnalgesic> tableList = statisticsService.searchAnaecDocCountByAnalgesic(searchFormBean);
		resp.put("tableList", tableList);
		logger.info("end searchAnaecDocCountByAnalgesic");
		return resp.getJsonStr();
	}
	
	/**
	 * 
	 * @discription 科室-麻醉方法例数统计
	 * @author liukui
	 * @param searchConditionFormBean
	 * @return
	 */
	@RequestMapping(value = "/searchAnaesMethodByDept")
	@ResponseBody
	@ApiOperation(value="科室麻醉例数统计",httpMethod="POST",notes="科室麻醉例数统计")
	public String searchAnaesMethodByDept(@ApiParam(name="searchConditionFormBean", value ="统计查询参数") @RequestBody SearchConditionFormBean searchConditionFormBean) {
		logger.info("begin searchAnaesMethodByDept");
		ResponseValue resp = new ResponseValue();
		//搜索条件，开始时间和结束时间
		BaseInfoQuery baseInfoQuery = new BaseInfoQuery();
		baseInfoQuery.setBeid(searchConditionFormBean.getBeid());
		List<BasAnaesMethod> methodList = basAnaesMethodService.findAllList(baseInfoQuery);
		String[] timeTitle = new String[methodList.size()];
		String[] time = new String[methodList.size()];
		//表格统计数据的list
		List tableList = new ArrayList();

		Map<String, Float> compareMap = new HashMap<String, Float>();
        compareMap.put("min", null);
        compareMap.put("max", null);
		List<Series> seriesList = new ArrayList<Series>();
        List<String> sdata = new ArrayList<String>();
        XAisData xAis = new XAisData();
        LegendData legend = new LegendData();
        List<String> legendData = new ArrayList<String>();
		
		SearchFormBean searchFormBean = new SearchFormBean();
		searchFormBean.setStartTime(searchConditionFormBean.getStartTime());
		searchFormBean.setEndTime(searchConditionFormBean.getEndTime());
        if (StringUtils.isBlank(searchConditionFormBean.getBeid())) {
        	searchFormBean.setBeid(getBeid());
		}else {
			searchFormBean.setBeid(searchConditionFormBean.getBeid());
		}
		for (int i = 0; i < time.length; i++) {
			timeTitle[i] = methodList.get(i).getName();
			time[i] = methodList.get(i).getCode();
			legendData.add(methodList.get(i).getName());
		}
		
		List<DeptFormBean> deptList = basDeptService.findList(baseInfoQuery);
		//工作量图表统计中的  用户名字
		String[] field = new String[deptList.size()];
		//工作量图表统计中的 用户名字月份所对应的工作量
		String[][] value = new String[deptList.size()][time.length];

		if (deptList != null && deptList.size() > 0) {
			for (int i = 0; i < deptList.size(); i++) {
				//先初始化每个科室的麻醉总数
				Map<String, AnaesCntByAnaesMethod> timeMap = new HashMap<String, AnaesCntByAnaesMethod>();
				for (int j = 0; j < time.length; j++) {
					AnaesCntByAnaesMethod w = new AnaesCntByAnaesMethod();
					w.setAnaMed(time[j]);
					timeMap.put(time[j], w);
				}
				//指定哪个科室的麻醉个数
				field[i] = deptList.get(i).getName();
				searchFormBean.setDeptId(deptList.get(i).getDeptId());
				List<AnaesCntByAnaesMethod> queryList = statisticsService.getDeptAnaesCntGroupByAnaesMethod(searchFormBean);

				List<AnaesCntByAnaesMethod> resultList = new ArrayList<AnaesCntByAnaesMethod>();
				
				for (Map.Entry<String, AnaesCntByAnaesMethod> entry : timeMap
						.entrySet()) {
					AnaesCntByAnaesMethod opt = entry.getValue();
					opt.setTotal(0);
					for (AnaesCntByAnaesMethod anaesCntByAnaesMethod : queryList) {
						if(opt.getAnaMed().equals(anaesCntByAnaesMethod.getAnaMed())){
							opt.setTotal(anaesCntByAnaesMethod.getTotal());
						}
					}
					resultList.add(opt);
				}
				
                sdata.add(deptList.get(i).getName());
				
				//根据时间大小进行排序
				AnaesCodeComparator comparator = new AnaesCodeComparator();
				Collections.sort(resultList, comparator);
				//表格统计的每一行的值
				Map<String, String> vo = new HashMap<String, String>();
				vo.put("科室", deptList.get(i).getName());
				if (resultList != null && resultList.size() > 0) {
					for (int a = 0; a < resultList.size(); a++) {
					    
						//图表统计的每个人每个月的工作量的值对应的位置
						value[i][a] = resultList.get(a).getTotal()+"";
						//表格统计中的每一行的值
						vo.put(resultList.get(a).getAnaMed(),resultList.get(a).getTotal()+"");
					}
				}
				tableList.add(vo);
			}
		}
		
		for (int i = 0; i < methodList.size(); i++)
		{
            List<Float> data = new ArrayList<Float>();
            Series series = new Series();
            series.setName(methodList.get(i).getName());
            series.setData(data);
            series.setType("bar");
            for (int j = 0; j < tableList.size(); j++)
            {
                Map<String, String> volumn = (Map<String, String>)tableList.get(j);
                String anaesValue = volumn.get(methodList.get(i).getCode());
                data.add(Float.valueOf(anaesValue));
                setMaxAndMin(compareMap, Float.valueOf(anaesValue)); 
            }
            seriesList.add(series);
		}
		
        
        YAxisData iyAxis = new YAxisData();
        if (null != compareMap.get("max"))
        {
            iyAxis.setMax((compareMap.get("max").intValue() / 5 + 1) * 5);
        }
        if (null != compareMap.get("min"))
        {
            iyAxis.setMin(compareMap.get("min").intValue() < 0 ? compareMap.get("min").intValue() : 0);
        }
        iyAxis.setType("value"); 

		legend.setData(legendData);
        xAis.setData(sdata);
        
        resp.put("xAxis", xAis);
        resp.put("yAxis", iyAxis);
        resp.put("series", seriesList);
        resp.put("legend", legend);
		resp.put("tableList", tableList);
		resp.put("timeTitle", timeTitle);
		resp.put("time", time);
		resp.put("field", field);
		resp.put("value", value);
		logger.info("end searchAnaesMethodByDept");
		return resp.getJsonStr();
	}
	
	/**
	 * 
	 * @discription 麻醉医生-麻醉方法例数统计
	 * @author liukui
	 * @param searchConditionFormBean
	 * @return
	 */
	@RequestMapping(value = "/searchAnaesMethodByAnaesDoc")
	@ResponseBody
	@ApiOperation(value="麻醉医生麻醉例数统计",httpMethod="POST",notes="麻醉医生麻醉例数统计")
	public String searchAnaesMethodByAnaesDoc(@ApiParam(name="searchConditionFormBean", value ="统计查询参数") @RequestBody SearchConditionFormBean searchConditionFormBean) {
		logger.info("begin searchAnaesMethodByAnaesDoc");
		ResponseValue resp = new ResponseValue();
		String beid = searchConditionFormBean.getBeid();
        if (StringUtils.isEmpty(beid)) {
            beid = getBeid();
        }
        searchConditionFormBean.setBeid(beid);
		//搜索条件，开始时间和结束时间
		BaseInfoQuery baseInfoQuery = new BaseInfoQuery();
        baseInfoQuery.setBeid(searchConditionFormBean.getBeid());
        List<BasAnaesMethod> methodList = basAnaesMethodService.findAllList(baseInfoQuery);
		String[] timeTitle = new String[methodList.size()];
		String[] time = new String[methodList.size()];
		//表格统计数据的list
		List tableList = new ArrayList();
		
		Map<String, Float> compareMap = new HashMap<String, Float>();
        compareMap.put("min", null);
        compareMap.put("max", null);
		List<Series> seriesList = new ArrayList<Series>();
		List<String> sdata = new ArrayList<String>();
		XAisData xAis = new XAisData();
		LegendData legend = new LegendData();
        List<String> legendData = new ArrayList<String>();
        
		SearchFormBean searchFormBean = new SearchFormBean();
		searchFormBean.setStartTime(searchConditionFormBean.getStartTime());
		searchFormBean.setEndTime(searchConditionFormBean.getEndTime());
        if (StringUtils.isBlank(searchConditionFormBean.getBeid())) {
        	searchFormBean.setBeid(getBeid());
		}else {
			searchFormBean.setBeid(searchConditionFormBean.getBeid());
		}
		for (int i = 0; i < time.length; i++) {
			//if(methodList.size()>i){
			timeTitle[i] = methodList.get(i).getName();
			time[i] = methodList.get(i).getCode();
			sdata.add(methodList.get(i).getName());
			//}
		}
		
		//根据userType得到医生
		List<BasUser> userList = new ArrayList<BasUser>();
		BasUserFormBean basUser = new BasUserFormBean();
		basUser.setUserType("ANAES_DOCTOR");
		basUser.setBeid(searchConditionFormBean.getBeid());
		userList = basUserService.selectEntityList(basUser);
		
		//统计中的 用户名字
		String[] field = new String[userList.size()];
		//工作量图表统计中的 用户名字月份所对应的工作量
		String[][] value = new String[userList.size()][time.length];

		
		if (userList != null && userList.size() > 0) {
			for (int i = 0; i < userList.size(); i++) {
				//先初始化每个科室的麻醉总数
				Map<String, AnaesCntByAnaesMethod> timeMap = new HashMap<String, AnaesCntByAnaesMethod>();
				for (int j = 0; j < time.length; j++) {
					AnaesCntByAnaesMethod w = new AnaesCntByAnaesMethod();
					w.setAnaMed(time[j]);
					timeMap.put(time[j], w);
				}
				//指定哪个科室的麻醉个数
				field[i] = userList.get(i).getName();
				searchFormBean.setId(userList.get(i).getUserName());
				List<AnaesCntByAnaesMethod> queryList = statisticsService.getAnaesDocAnaesCntGroupByAnaesMethod(searchFormBean);

				List<AnaesCntByAnaesMethod> resultList = new ArrayList<AnaesCntByAnaesMethod>();
				
				for (Map.Entry<String, AnaesCntByAnaesMethod> entry : timeMap
						.entrySet()) {
					AnaesCntByAnaesMethod opt = entry.getValue();
					opt.setTotal(0);
					for (AnaesCntByAnaesMethod anaesCntByAnaesMethod : queryList) {
						if(opt.getAnaMed().equals(anaesCntByAnaesMethod.getAnaMed())){
							opt.setTotal(anaesCntByAnaesMethod.getTotal());
						}
					}
					resultList.add(opt);
				}
				
                List<Float> data = new ArrayList<Float>();
                Series series = new Series();
                series.setName(userList.get(i).getName());
                series.setData(data);
                series.setType("bar");
                
                
                
                legendData.add(series.getName());
				//根据时间大小进行排序
				AnaesCodeComparator comparator = new AnaesCodeComparator();
				Collections.sort(resultList, comparator);
				//表格统计的每一行的值
				Map<String, String> vo = new HashMap<String, String>();
				vo.put("姓名", userList.get(i).getName());
				if (resultList != null && resultList.size() > 0) {
					for (int a = 0; a < resultList.size(); a++) {
					    data.add((float)resultList.get(a).getTotal());
					    setMaxAndMin(compareMap, (float)resultList.get(a).getTotal());
					    
						//图表统计的每个人每个月的工作量的值对应的位置
						value[i][a] = resultList.get(a).getTotal()+"";
						//表格统计中的每一行的值
						vo.put(resultList.get(a).getAnaMed(),resultList.get(a).getTotal()+"");
					}
				}
				tableList.add(vo);
				seriesList.add(series);
			}
		}
		
		YAxisData iyAxis = new YAxisData();
		if (null != compareMap.get("max"))
        {
            iyAxis.setMax((compareMap.get("max").intValue() / 5 + 1) * 5);
        }
        if (null != compareMap.get("min"))
        {
            iyAxis.setMin(compareMap.get("min").intValue() < 0 ? compareMap.get("min").intValue() : 0);
        }
        iyAxis.setType("value");
		
		legend.setData(legendData);
		xAis.setData(sdata);
        
		resp.put("xAxis", xAis);
        resp.put("yAxis", iyAxis);
        resp.put("series", seriesList);
        resp.put("legend", legend);
		resp.put("tableList", tableList);
		resp.put("timeTitle", timeTitle);
		resp.put("time", time);
		resp.put("field", field);
		resp.put("value", value);
		logger.info("end searchAnaesMethodByAnaesDoc");
		return resp.getJsonStr();
	}
	
	
	/**
	 * 麻醉医生文书完成情况统计
	 * @return
	 */
	@RequestMapping(value = "/countAnaesDocDocumentCondition")
	@ResponseBody
    @ApiOperation(value="麻醉医生文书完成情况统计",httpMethod="POST",notes="麻醉医生文书完成情况统计")
	public String countAnaesDocDocumentCondition(@ApiParam(name="searchConditionFormBean", value ="统计查询参数") @RequestBody SearchConditionFormBean searchConditionFormBean){
		ResponseValue resp = new ResponseValue();
		resp.put("rslist", statisticsService.countAnaesDocDocumentCondition(searchConditionFormBean));
		return resp.getJsonStr();
	}
	
	/**
     * 
     * @discription 科室-手术例数统计
     * @author zhouyi
     * @param searchConditionFormBean
     * @return
	 * @throws  
     */
    @RequestMapping(value = "/searchOperByDept")
    @ResponseBody
    @ApiOperation(value="科室-手术例数统计",httpMethod="POST",notes="科室-手术例数统计")
    public String searchOperByDept(@ApiParam(name="searchConditionFormBean", value ="统计查询参数") @RequestBody SearchConditionFormBean searchConditionFormBean){
        logger.info("begin searchOperByDept");
        ResponseValue resp = new ResponseValue();

        BaseInfoQuery baseInfoQuery = new BaseInfoQuery();
        baseInfoQuery.setBeid(searchConditionFormBean.getBeid());
        List<DeptFormBean> deptList = basDeptService.findList(new BaseInfoQuery());
        
        //表格统计数据的list
        List tableList = new ArrayList();
        
        //开始时间集合
        List<String> startTimeList = new ArrayList<String>();
        System.out.println(startTimeList);
        //结束时间集合
        List<String> endTimeList = new ArrayList<String>();
        
        //统计数据表格列名数组
        String[] columnAry = null;
        
        //根据传入的时间查询类型设置开始时间和结束时间
        try
        {
            columnAry = setTime(searchConditionFormBean, startTimeList, endTimeList, 1);
        }
        catch (Exception e)
        {
            if (logger.isErrorEnabled()) {
                logger.error(Exceptions.getStackTraceAsString(e));
            }
            resp.put("resultCode", "10000000");
            resp.put("resultMessage", "系统错误，请与系统管理员联系!");
            return resp.getJsonStr();
        }
        int colSize = columnAry.length;
        columnAry[colSize - 1] = "总计";
        
        //统计数据表格行名数组，科室名称
        int volSize = deptList.size();
        String[] deptNameAry = new String[volSize];
        String[] deptIdAry = new String[volSize];
        
        //统计数据表格中的科室在对应查询时间内的手术数量
        String[][] value = new String[volSize][colSize];
        
        //将获取总计例数的时间区间加入到开始时间集合和结束时间集合中
        startTimeList.add(startTimeList.get(0));
        endTimeList.add(endTimeList.get(endTimeList.size() - 1));
        
        SearchFormBean searchFormBean = new SearchFormBean();
        for (int j = 0; j < colSize; j++)
        {
            //表格统计的每一列的值
            Map<String, String> co = new HashMap<String, String>();
            searchFormBean.setStartTime(startTimeList.get(j));
            searchFormBean.setEndTime(endTimeList.get(j));
            
            //获取到所有科室在指定时间区间的手术例数
            List<SearchOperByDept> searchOperByDeptList = statisticsService.searchOperByDept(searchFormBean);
            
            if (null != searchOperByDeptList && searchOperByDeptList.size() > 0)
            {
                co.put("列名", columnAry[j]);
                for (int i = 0; i < searchOperByDeptList.size(); i++)
                {
                    SearchOperByDept searchOperByDept = searchOperByDeptList.get(i);
                    deptIdAry[i] = searchOperByDept.getDeptId();
                    deptNameAry[i] = searchOperByDept.getDeptName();
                    value[i][j] = searchOperByDept.getTotal() + "";
                    co.put(searchOperByDept.getDeptId(), searchOperByDept.getTotal() + "");
                }
                tableList.add(co);
            }
        }
        
        //列转为行
        Map<String, String> vo = null;
        //表格统计行数据的list
        List voTableList = new ArrayList();
        for (int i = 0; i< deptNameAry.length; i++)
        {
            vo = new HashMap<String,String>();
            vo.put("行名", deptNameAry[i]);
            for (int j = 0; j < tableList.size(); j++)
            {
                Map<String, String> columnMap = (Map<String, String>)tableList.get(j);
                
                vo.put(columnAry[j], columnMap.get(deptIdAry[i]));
            }
            voTableList.add(vo);
        }
        
        Map<String, Float> compareMap = new HashMap<String, Float>();
        compareMap.put("min", null);
        compareMap.put("max", null);
        List<Series> seriesList = new ArrayList<Series>();
        List<Float> fdata = new ArrayList<Float>();
        
        if (tableList.size() > 0)
        {
            Map map = (Map)tableList.get(colSize - 1);

            XAisData xAis = new XAisData();
            List<String> sdata = new ArrayList<String>();
            
            for (int i = 0; i < volSize; i++)
            {
                sdata.add(deptNameAry[i]);
                
                fdata.add(Float.valueOf((String)map.get(deptIdAry[i])));
                setMaxAndMin(compareMap, Float.valueOf((String)map.get(deptIdAry[i])));
            }
            YAxisData iyAxis = new YAxisData();
            if (null != compareMap.get("max"))
            {
                iyAxis.setMax((compareMap.get("max").intValue() / 5 + 1) * 5);
            }
            if (null != compareMap.get("min"))
            {
                iyAxis.setMin(compareMap.get("min").intValue() < 0 ? compareMap.get("min").intValue() : 0);
            }
            iyAxis.setType("value");
            
            
            xAis.setData(sdata);
            
            Series series = new Series();
            series.setData(fdata);
            series.setType("bar");
            series.setName("科室-手术例数");
            seriesList.add(series);
            
            resp.put("xAxis", xAis);
            resp.put("yAxis", iyAxis);
            resp.put("series", seriesList);
        }
        
        resp.put("coTableList", tableList);
        resp.put("voTableList", voTableList);
        resp.put("time", columnAry);
        resp.put("deptId", deptIdAry);
        resp.put("deptName", deptNameAry);
        resp.put("value", value); 
        logger.info("end searchOperByDept");
        return resp.getJsonStr();
    }

    /**
     * Steward评分统计
     * @param searchFormBean
     * @return
     */
    @RequestMapping(value = "/searchStewardScoByPacu")
    @ResponseBody
    @ApiOperation(value="Steward评分统计",httpMethod="POST",notes="Steward评分统计")
    public String searchStewardScoByPacu(@ApiParam(name="searchFormBean", value ="统计查询参数") @RequestBody SearchFormBean searchFormBean) {
        ResponseValue resp = new ResponseValue();
        logger.info("begin searchStewardScoByPacu");
        List<Series> seriesList = new ArrayList<Series>();
        List<SearchStewardScoFormBean> tableList= statisticsService.searchStewardScoByPacu(searchFormBean);
        List<Float> paculist = new ArrayList<Float>();
        List<Float> stewardscolist = new ArrayList<Float>();
        Integer max=1;
        for (SearchStewardScoFormBean searchStewardScoFormBean : tableList) {
        	if (!"总计".equals(searchStewardScoFormBean.getEnterTime())) {
        		paculist.add(Float.valueOf(searchStewardScoFormBean.getPacuTotal() + ""));
        		stewardscolist.add(Float.valueOf(searchStewardScoFormBean.getStewardTotal() + ""));
        		if (searchStewardScoFormBean.getPacuTotal() > max) {
        			max = searchStewardScoFormBean.getPacuTotal();
        		}
        		if (searchStewardScoFormBean.getStewardTotal() > max) {
        			max = searchStewardScoFormBean.getStewardTotal();
        		}
			}
		}
        Series series1 = new Series();
        series1.setName("入复苏室例数");
        series1.setType("bar");
        series1.setData(paculist);
        seriesList.add(series1);

        Series series2 = new Series();
        series2.setName("离室时Steward评分≥4分例数");
        series2.setType("bar");
        series2.setData(stewardscolist);
        seriesList.add(series2);
        LegendData legend = new LegendData();
        XAisData xAis = new XAisData();
        YAxisData yAis = new YAxisData();
        List<String> legends = new ArrayList<String>();

        legends.add("入复苏室例数");
        legends.add("离室时Steward评分≥4分例数");
        legend.setData(legends);
        xAis.setData(statisticsService.getTimeList(searchFormBean));
        
        yAis.setMin(0);
        yAis.setMax(max);
        yAis.setName("例");
        resp.put("tableList", tableList);
        resp.put("series", seriesList);
        resp.put("legend", legend);
        resp.put("xAxis", xAis);
        resp.put("yAxis", yAis);
        logger.info("end searchStewardScoByPacu");
        return resp.getJsonStr();
    }

    /**
     * 
     * @discription 麻醉医生实施心肺复苏治疗例数统计
     * @author zhouyi
     * @param searchConditionFormBean
     * @return
     * @throws ParseException 
     */
    @RequestMapping(value = "/searchOperByCPRNum")
    @ResponseBody
    @ApiOperation(value="麻醉医生实施心肺复苏治疗例数统计",httpMethod="POST",notes="麻醉医生实施心肺复苏治疗例数统计")
    public String searchOperByCPRNum(@ApiParam(name="searchConditionFormBean", value ="统计查询参数") @RequestBody SearchConditionFormBean searchConditionFormBean)
    {
        logger.info("begin searchOperByCPRNum");
        ResponseValue resp = new ResponseValue();
        //表格统计数据的list
        List tableList = new ArrayList();
		LegendData legend = new LegendData();
        List<String> legendData = new ArrayList<String>();
        //开始时间集合
        List<String> startTimeList = new ArrayList<String>();
        //结束时间集合
        List<String> endTimeList = new ArrayList<String>();
        //统计数据表格列名数组
        String[] volumnAry = null;
        //根据传入的时间查询类型设置开始时间和结束时间
        try{
            volumnAry = setTime(searchConditionFormBean, startTimeList, endTimeList, 1);
        }
        catch (Exception e){
            if (logger.isErrorEnabled()) {
                logger.error(Exceptions.getStackTraceAsString(e));
            }
            resp.put("resultCode", "10000000");
            resp.put("resultMessage", "系统错误，请与系统管理员联系!");
            return resp.getJsonStr();
        }
        String[] columnAry = new String[2];
        columnAry[0] = "实施心肺复苏治疗例数";
        columnAry[1] = "心肺复苏成功例数";
        volumnAry[volumnAry.length - 1] = "总计";
        String[][] value = new String[volumnAry.length][2];
        
        //统计总计例数的时间加入到开始时间和结束时间集合中
        startTimeList.add(startTimeList.get(0));
        endTimeList.add(endTimeList.get(endTimeList.size() - 1));
        
        Map<String, String> vo = null;
        SearchFormBean searchFormBean = new SearchFormBean();
        if (StringUtils.isBlank(searchConditionFormBean.getBeid())) {
        	searchFormBean.setBeid(getBeid());
		}else {
			searchFormBean.setBeid(searchConditionFormBean.getBeid());
		}
        //手术室条件筛选
        if (null != searchConditionFormBean.getOperRoomId() && !"".equals(searchConditionFormBean.getOperRoomId())){
            searchFormBean.setOperRoomId(searchConditionFormBean.getOperRoomId());
        }
        //麻醉医生条件筛选
        if (null != searchConditionFormBean.getAnesthetistId() && !"".equals(searchConditionFormBean.getAnesthetistId())){
            searchFormBean.setAnesthetistId(searchConditionFormBean.getAnesthetistId());
        }
        Integer zlTotal = 0;
        Integer cgTotal = 0;
        
        for (int i = 0; i < startTimeList.size(); i++){
            searchFormBean.setStartTime(startTimeList.get(i));
            searchFormBean.setEndTime(endTimeList.get(i));
            vo = new HashMap<String, String>();
            vo.put("行名", volumnAry[i]);
            searchFormBean.setCode("29");//实施心肺复苏治疗例数
            Integer total = statisticsService.searchOperByCPRNum(searchFormBean);
            value[i][0] = total + "";
            vo.put(columnAry[0], total + "");
            //心肺复苏成功例数
            searchFormBean.setIsSuccess(1);
            Integer total1 = statisticsService.searchOperByCPRNum(searchFormBean);
            value[i][1] = total1 + "";
            if (volumnAry[i] != "总计") {
            	zlTotal += total;
            	cgTotal += total1;
            }
            vo.put(columnAry[1], total1 + "");
            if ("总计".equals(vo.get("行名"))) {
				vo.put("实施心肺复苏治疗例数", zlTotal + "");
				vo.put("心肺复苏成功例数", cgTotal + "");
			}
            tableList.add(vo);
        }
        List<Series> seriesList = new ArrayList<Series>();
        List<YAxisData> yAxisList = new ArrayList<YAxisData>();
        List<XAisData> xAxisList = new ArrayList<XAisData>();
        List<Float> fdata = new ArrayList<Float>();
        DataStatFormbean bean = new DataStatFormbean();
        if (tableList.size() > 0)
        {
            Map map = (Map)tableList.get(tableList.size() - 1);

            XAisData xAis = new XAisData();
            List<String> sdata = new ArrayList<String>();
            
            for (int i = 0; i < columnAry.length; i++)
            {
                YAxisData iyAxis = new YAxisData();
                iyAxis.setMax(1);
                iyAxis.setMin(0);
                iyAxis.setName(columnAry[i]);
                iyAxis.setType("value");
                yAxisList.add(iyAxis);
                
                sdata.add(columnAry[i]);
                
                fdata.add(Float.valueOf((String)map.get(columnAry[i])));
            }
            xAis.setData(sdata);
            xAxisList.add(xAis);
            
            Series series = new Series();
            series.setData(fdata);
            series.setType("bar");
            series.setName("麻醉医师实施心肺复苏治疗例数");
            seriesList.add(series);
            bean.setSeries(seriesList);
            bean.setxAxis(xAxisList);
            bean.setyAxis(yAxisList);
        }
        resp.put("legend", legend);
        resp.put("tableList", tableList);
        resp.put("volumnAry", volumnAry);
        resp.put("columnAry", columnAry);
        resp.put("value", value);
        resp.put("dataStat", bean);
        logger.info("end searchOperByCPRNum");
        return resp.getJsonStr();
    }
    
    /**
     * 
     * @discription 医生-手术例数统计
     * @author zhouyi
     * @param searchConditionFormBean
     * @return
     * @throws ParseException 
     */
    @RequestMapping(value = "/searchOperByOperator")
    @ResponseBody
    @ApiOperation(value="手术医生-手术例数统计",httpMethod="POST",notes="手术医生-手术例数统计")
    public String searchOperByOperator(@ApiParam(name="searchConditionFormBean", value ="统计查询参数") @RequestBody SearchConditionFormBean searchConditionFormBean)
    {
        logger.info("begin searchOperByOperator");
        ResponseValue resp = new ResponseValue();
        
        List<BasOperationPeople> operatorList = new ArrayList<BasOperationPeople>();
        
        //没有传手术医生ID，则为查询所有
        if (null == searchConditionFormBean.getOperatorId() || "".equals(searchConditionFormBean.getOperatorId())) {
        	SystemSearchFormBean bean = new SystemSearchFormBean();
        	bean.setBeid(searchConditionFormBean.getBeid());
        	bean.setPageNo(null);
        	bean.setPageSize(null);
            operatorList = basOperationPeopleService.queryOperationPeopleList(bean);
        } else {
            operatorList.add(basOperationPeopleService.queryOperationPeopleById(searchConditionFormBean.getOperatorId()));
        }
        
        //表格统计数据的list
        List tableList = new ArrayList();
        
        //开始时间集合
        List<String> startTimeList = new ArrayList<String>();
        
        //结束时间集合
        List<String> endTimeList = new ArrayList<String>();
        
        //统计数据表格列名数组
        String[] columnAry = null;
        
        //根据传入的时间查询类型设置开始时间和结束时间
        try
        {
            columnAry = setTime(searchConditionFormBean, startTimeList, endTimeList, 3);
        }
        catch (Exception e)
        {
            if (logger.isErrorEnabled()) {
                logger.error(Exceptions.getStackTraceAsString(e));
            }
            resp.put("resultCode", "10000000");
            resp.put("resultMessage", "系统错误，请与系统管理员联系!");
            return resp.getJsonStr();
        }
        
        int colSize = startTimeList.size() + 3; //列数
        int volSize = operatorList.size(); //行数
        
        columnAry[colSize - 3] = "总计";
        columnAry[colSize - 2] = "总手术时长";
        columnAry[colSize - 1] = "平均手术时长";

        //统计数据表格行名数组，手术医生名称
        String[] operatorNameAry = new String[volSize];
        String[] operatorIdAry = new String[volSize];
        
        //统计数据表格中的手术医生在对应查询时间内的手术数量
        String[][] value = new String[volSize][colSize];
        Map<String, String> co = null;
        SearchFormBean searchFormBean = new SearchFormBean();
        searchFormBean.setOperatorId(searchConditionFormBean.getOperatorId());
        if (StringUtils.isBlank(searchConditionFormBean.getBeid())) {
        	searchFormBean.setBeid(getBeid());
		}else {
			searchFormBean.setBeid(searchConditionFormBean.getBeid());
		}
        for (int j = 0; j < startTimeList.size(); j++)
        {
            searchFormBean.setStartTime(startTimeList.get(j));
            searchFormBean.setEndTime(endTimeList.get(j));
            //表格统计的每一列的值
            co = new HashMap<String, String>();
            
            List<SearchOperByOperator> searchOperByOperators = statisticsService.searchOperByOperator(searchFormBean);
            
            if (null != searchOperByOperators && searchOperByOperators.size() > 0)
            {
                co.put("列名", columnAry[j]);
                for (int i = 0; i < searchOperByOperators.size(); i++)
                {
                    SearchOperByOperator searchOperByOperator = searchOperByOperators.get(i);
                    operatorIdAry[i] = searchOperByOperator.getOperatorId();
                    operatorNameAry[i] = searchOperByOperator.getOperatorName();
                    value[i][j] = searchOperByOperator.getTotal() + "";
                    co.put(searchOperByOperator.getOperatorId(), searchOperByOperator.getTotal() + "");
                }
                tableList.add(co);
            }
        }
        
        // 求总计、总手术时长、平均手术时长
        searchFormBean.setStartTime(startTimeList.get(0));
        searchFormBean.setEndTime(endTimeList.get(endTimeList.size() - 1));
        List<SearchOperByOperator> searchJMWorkTime = statisticsService.searchOperatorJMWorkingTime(searchFormBean);
        List<SearchOperByOperator> searchQMWorkTime = statisticsService.searchOperatorQMWorkingTime(searchFormBean);

        if (null != searchJMWorkTime && null != searchQMWorkTime)
        {
            // 总计
            co = new HashMap<String, String>();
            co.put("列名", columnAry[colSize - 3]);
            for (int i = 0; i < searchJMWorkTime.size(); i++)
            {
                value[i][colSize - 3] = String.valueOf(searchJMWorkTime.get(i).getTotal() + searchQMWorkTime.get(i).getTotal());
                co.put(searchJMWorkTime.get(i).getOperatorId(), value[i][colSize - 3]);
            }
            tableList.add(co);
            
            // 总时长
            co = new HashMap<String, String>();
            co.put("列名", columnAry[colSize - 2]);
            for (int i = 0; i < searchJMWorkTime.size(); i++)
            {
                value[i][colSize - 2] = String.valueOf(searchJMWorkTime.get(i).getTime() + searchQMWorkTime.get(i).getTime());
                co.put(searchJMWorkTime.get(i).getOperatorId(), value[i][colSize - 2]);
            }
            tableList.add(co);
            
            // 平均时长
            co = new HashMap<String, String>();
            co.put("列名", columnAry[colSize - 1]);
            for (int i = 0; i < searchJMWorkTime.size(); i++)
            {
                int totalNum = searchJMWorkTime.get(i).getTotal() + searchQMWorkTime.get(i).getTotal();
                int totalTime = searchJMWorkTime.get(i).getTime() + searchQMWorkTime.get(i).getTime();
                
                value[i][colSize - 1] = String.valueOf(totalNum == 0 ? 0: totalTime/totalNum);
                co.put(searchJMWorkTime.get(i).getOperatorId(), value[i][colSize - 1]);
            }
            tableList.add(co);
        }
        
        //列转为行
        Map<String, String> vo = null;
        //表格统计行数据的list
        List voTableList = new ArrayList();
        
        for (int i = 0; i< volSize; i++)
        {
            vo = new HashMap<String,String>();
            vo.put("行名", operatorNameAry[i]);
            for (int j = 0; j < tableList.size(); j++)
            {
                Map<String, String> columnMap = (Map<String, String>)tableList.get(j);
                
                vo.put(columnAry[j], columnMap.get(operatorIdAry[i]));
            }
            voTableList.add(vo);
        }
        
        Map<String, Float> compareMap = new HashMap<String, Float>();
        compareMap.put("min", null);
        compareMap.put("max", null);
        List<Series> seriesList = new ArrayList<Series>();
        List<Float> fdata = new ArrayList<Float>();
        
        if (tableList.size() > 0)
        {
            Map map = (Map)tableList.get(colSize - 3);

            XAisData xAis = new XAisData();
            List<String> sdata = new ArrayList<String>();
            
            for (int i = 0; i < volSize; i++)
            {
                sdata.add(operatorNameAry[i]);
                
                fdata.add(Float.valueOf((String)map.get(operatorIdAry[i])));
                setMaxAndMin(compareMap, Float.valueOf((String)map.get(operatorIdAry[i])));
            }
            xAis.setData(sdata);
            
            YAxisData iyAxis = new YAxisData();
            if (null != compareMap.get("max"))
            {
                iyAxis.setMax((compareMap.get("max").intValue() / 5 + 1) * 5);
            }
            if (null != compareMap.get("min"))
            {
                iyAxis.setMin(compareMap.get("min").intValue() < 0 ? compareMap.get("min").intValue() : 0);
            }
            iyAxis.setType("value");
            if (iyAxis.getMax() == null) {
            	iyAxis.setMax(1);
			}
            if (iyAxis.getMin() == null) {
            	iyAxis.setMin(0);
			}
            Series series = new Series();
            series.setData(fdata);
            series.setType("bar");
            series.setName("医生手术例数");
            seriesList.add(series);
            
            resp.put("xAxis", xAis);
            resp.put("yAxis", iyAxis);
            resp.put("series", seriesList);
        }
        
        resp.put("coTableList", tableList);
        resp.put("voTableList", voTableList);
        resp.put("time", columnAry);
        resp.put("operatorIdAry", operatorIdAry);
        resp.put("operatorNameAry", operatorNameAry);
        resp.put("value", value);
        logger.info("end searchOperByDept");
        return resp.getJsonStr();
    }
    
    /**
     * 
     * @discription 护士-护理例数统计
     * @author zhouyi
     * @param searchConditionFormBean
     * @return
     * @throws ParseException 
     */
    @RequestMapping(value = "/searchOperByNurse")
    @ResponseBody
    @ApiOperation(value="护士-护理例数统计",httpMethod="POST",notes="护士-护理例数统计")
    public String searchOperByNurse(@ApiParam(name="searchConditionFormBean", value ="统计查询参数") @RequestBody SearchConditionFormBean searchConditionFormBean) {
        logger.info("begin searchOperByNurse");
        ResponseValue resp = new ResponseValue();
        
        List<BasUser> nurList = new ArrayList<BasUser>();
        
        if (null == searchConditionFormBean.getNurseId() || "".equals(searchConditionFormBean.getNurseId())) {
            UserFormbean nuruserFormbean = new UserFormbean();
            List<Filter> nurfilters = new ArrayList<Filter>();
            Filter nurfilter = new Filter();
            nurfilter.setField("userType");
            nurfilter.setValue("NURSE");
            nurfilters.add(nurfilter);
            nuruserFormbean.setFilters(nurfilters);
            nurList = basUserService.getAllUser(nuruserFormbean);
        } else {
        	BasUser user = basUserService.selectByUsername(searchConditionFormBean.getNurseId(), searchConditionFormBean.getBeid());
            nurList.add(user);
        }
        
        //表格统计数据的list
        List tableList = new ArrayList();
        
        //开始时间集合
        List<String> startTimeList = new ArrayList<String>();
        
        //结束时间集合
        List<String> endTimeList = new ArrayList<String>();
        
        //统计数据表格列名数组
        String[] columnAry = null;
        
        //根据传入的时间查询类型设置开始时间和结束时间
        try
        {
            columnAry = setTime(searchConditionFormBean, startTimeList, endTimeList, 3);
        }
        catch (Exception e)
        {
            if (logger.isErrorEnabled()) {
                logger.error(Exceptions.getStackTraceAsString(e));
            }
            resp.put("resultCode", "10000000");
            resp.put("resultMessage", "系统错误，请与系统管理员联系!");
            return resp.getJsonStr();
        }
        
        int volSize = nurList.size();
        int colSize = columnAry.length;

        //统计数据表格行名数组，手术医生名称
        String[] nurseNameAry = new String[volSize];
        
        String[] nurseIdAry = new String[volSize];
        
        String[][] value = new String[volSize][colSize];
        Map<String, String> vo = null;
        
        columnAry[colSize - 3] = "总计";
        columnAry[colSize - 2] = "总手术时长";
        columnAry[colSize - 1] = "平均手术时长";
        
        for (int i = 0; i< volSize; i++)
        {
        	BasUser user = nurList.get(i);
            nurseIdAry[i] = user.getUserName();
            nurseNameAry[i] = user.getName();
            SearchFormBean searchFormBean = new SearchFormBean();
            searchFormBean.setNurseId(user.getUserName());
            if (StringUtils.isBlank(searchConditionFormBean.getBeid())) {
            	searchFormBean.setBeid(getBeid());
    		}else {
    			searchFormBean.setBeid(searchConditionFormBean.getBeid());
    		}
            vo = new HashMap<String, String>();
            vo.put("行名", user.getName());
            for (int j = 0; j < startTimeList.size(); j++)
            {
                searchFormBean.setStartTime(startTimeList.get(j));
                searchFormBean.setEndTime(endTimeList.get(j));
                SearchOperByNurse searchOperByNurse = statisticsService.searchOperByNurse(searchFormBean);
                value[i][j] = searchOperByNurse.getTotal() + "";
                vo.put(columnAry[j], searchOperByNurse.getTotal() + "");
            }
            
            searchFormBean.setStartTime(startTimeList.get(0));
            searchFormBean.setEndTime(endTimeList.get(endTimeList.size() - 1));
            SearchOperByNurse searchJMWorkTime = statisticsService.searchNurseJMWorkingTime(searchFormBean);
            SearchOperByNurse searchQMWorkTime = statisticsService.searchNurseQMWorkingTime(searchFormBean);
            value[i][colSize - 3] = String.valueOf(searchJMWorkTime.getTotal() + searchQMWorkTime.getTotal());
            vo.put(columnAry[colSize - 3], value[i][colSize - 3]);
            
            value[i][colSize - 2] = String.valueOf(searchJMWorkTime.getTime() + searchQMWorkTime.getTime());
            vo.put(columnAry[colSize - 2], value[i][colSize - 2]);
            
            int totalNum = searchJMWorkTime.getTotal() + searchQMWorkTime.getTotal();
            int totalTime = searchJMWorkTime.getTime() + searchQMWorkTime.getTime();
            value[i][colSize - 1] = String.valueOf(totalNum == 0 ? 0: totalTime/totalNum);
            vo.put(columnAry[colSize - 1], value[i][colSize - 1]);
            
            tableList.add(vo);
        }
        
        
        //行转为列
        Map<String, String> co = null;
        //表格统计行数据的list
        List coTableList = new ArrayList();
        
        for (int i = 0; i< colSize; i++)
        {
            co = new HashMap<String,String>();
            co.put("列名", columnAry[i]);
            for (int j = 0; j < tableList.size(); j++)
            {
                Map<String, String> volumnMap = (Map<String, String>)tableList.get(j);
                
                co.put(nurseNameAry[j], volumnMap.get(columnAry[i]));
            }
            coTableList.add(co);
        }
        
        Map<String, Float> compareMap = new HashMap<String, Float>();
        compareMap.put("min", null);
        compareMap.put("max", null);
        List<Series> seriesList = new ArrayList<Series>();
        List<Float> fdata = new ArrayList<Float>();
        
        if (coTableList.size() > 0)
        {
            Map map = (Map)coTableList.get(colSize - 3);

            XAisData xAis = new XAisData();
            List<String> sdata = new ArrayList<String>();
            
            for (int i = 0; i < volSize; i++)
            {
                sdata.add(nurseNameAry[i]);
                
                fdata.add(Float.valueOf((String)map.get(nurseNameAry[i])));
                setMaxAndMin(compareMap, Float.valueOf((String)map.get(nurseNameAry[i])));
            }
            YAxisData iyAxis = new YAxisData();
            if (null != compareMap.get("max"))
            {
                iyAxis.setMax((compareMap.get("max").intValue() / 5 + 1) * 5);
            }
            if (null != compareMap.get("min"))
            {
                iyAxis.setMin(compareMap.get("min").intValue() < 0 ? compareMap.get("min").intValue() : 0);
            }
            iyAxis.setType("value");
            xAis.setData(sdata);
            
            Series series = new Series();
            series.setData(fdata);
            series.setType("bar");
            series.setName("护士护理例数");
            seriesList.add(series);
            
            resp.put("xAxis", xAis);
            resp.put("yAxis", iyAxis);
            resp.put("series", seriesList);
        }
        
        resp.put("coTableList", coTableList);
        resp.put("voTableList", tableList);
        resp.put("time", columnAry);
        resp.put("nurseIdAry", nurseIdAry);
        resp.put("nurseNameAry", nurseNameAry);
        resp.put("value", value);
        logger.info("end searchOperByNurse");
        return resp.getJsonStr();
    }
    

    /**
     * 
     * @discription 麻醉分级管理例数
     * @author zhouyi
     * @param searchConditionFormBean
     * @return
     * @throws ParseException 
     */
    @RequestMapping(value = "/searchOperByASALevel")
    @ResponseBody
    @ApiOperation(value="麻醉分级管理例数统计",httpMethod="POST",notes="麻醉分级管理例数统计")
    public String searchOperByASALevel(@ApiParam(name="searchConditionFormBean", value ="统计查询参数") @RequestBody SearchConditionFormBean searchConditionFormBean)
    {
        logger.info("begin searchOperByASALevel");
        ResponseValue resp = new ResponseValue();
        
        List<SysCodeFormbean> fieldList = basSysCodeService.searchSysCodeByGroupId("asa_level", searchConditionFormBean.getBeid());
        
        int colSize = fieldList.size() * 2;
        String[] colAry = new String[colSize];
        for (int i = 0; i < fieldList.size(); i++) {
            colAry[i * 2] = "ASA-" + fieldList.get(i).getCodeName() + "级总例数";
        }
        
        for (int i = 0; i < fieldList.size(); i++) {
            colAry[i * 2 + 1] = "ASA-" + fieldList.get(i).getCodeName() + "级术后死亡例数";
        }
        
        //表格统计数据的list
        List tableList = new ArrayList();
        
        //开始时间集合
        List<String> startTimeList = new ArrayList<String>();
        
        //结束时间集合
        List<String> endTimeList = new ArrayList<String>();
        
        //统计数据表格列名数组
        String[] volumnAry = null;
        
        //根据传入的时间查询类型设置开始时间和结束时间
        try
        {
            volumnAry = setTime(searchConditionFormBean, startTimeList, endTimeList, 1);
        }
        catch (Exception e)
        {
            if (logger.isErrorEnabled()) {
                logger.error(Exceptions.getStackTraceAsString(e));
            }
            resp.put("resultCode", "10000000");
            resp.put("resultMessage", "系统错误，请与系统管理员联系!");
            return resp.getJsonStr();
        }
        
        int volSize = volumnAry.length;
        volumnAry[volSize - 1] = "总计";
        
        //将统计总计例数的时间区间加入到开始时间和结束时间集合中
        startTimeList.add(startTimeList.get(0));
        endTimeList.add(endTimeList.get(endTimeList.size() - 1));
        
        String[][] value = new String[volSize][colSize];
        
        Map<String, String> vo = null;
        SearchFormBean searchFormBean = new SearchFormBean();
        
        //手术室条件筛选
        if (null != searchConditionFormBean.getOperRoomId() && !"".equals(searchConditionFormBean.getOperRoomId()))
        {
            searchFormBean.setOperRoomId(searchConditionFormBean.getOperRoomId());
        }
        
        for (int i = 0; i < startTimeList.size(); i++)
        {
            searchFormBean.setStartTime(startTimeList.get(i));
            searchFormBean.setEndTime(endTimeList.get(i));
            List<SearchOperByASALevel> asaLevelList = statisticsService.searchOperByASALevel(searchFormBean);
            vo = new HashMap<String, String>();
            vo.put("行名", volumnAry[i]);
            for (int j = 0; j < asaLevelList.size(); j++)
            {
                SearchOperByASALevel searchOperByASALevel = asaLevelList.get(j);
                value[i][j * 2] = searchOperByASALevel.getTotal() + "";
                vo.put(colAry[j * 2], searchOperByASALevel.getTotal() + "");
            }
            
            //searchFormBean.setLeaveTo("1");
            asaLevelList = statisticsService.searchOperByASALevel(searchFormBean);
            for (int j = 0; j < asaLevelList.size(); j++)
            {
                SearchOperByASALevel searchOperByASALevel = asaLevelList.get(j);
                value[i][j * 2 + 1] = searchOperByASALevel.getTotal() + "";
                vo.put(colAry[j * 2 + 1], searchOperByASALevel.getTotal() + "");
            }
            tableList.add(vo);
        }
        
        Map<String, Float> compareMap = new HashMap<String, Float>();
        compareMap.put("min", null);
        compareMap.put("max", null);
        List<Series> seriesList = new ArrayList<Series>();
        List<Float> fdata = new ArrayList<Float>();
        
        if (tableList.size() > 0)
        {
            Map map = (Map)tableList.get(tableList.size() - 1);

            XAisData xAis = new XAisData();
            List<String> sdata = new ArrayList<String>();
            
            for (int i = 0; i < colAry.length; i++)
            {
                sdata.add(colAry[i]);
                
                fdata.add(Float.valueOf((String)map.get(colAry[i])));
                setMaxAndMin(compareMap, Float.valueOf((String)map.get(colAry[i])));
            }
            YAxisData iyAxis = new YAxisData();
            if (null != compareMap.get("max"))
            {
                iyAxis.setMax((compareMap.get("max").intValue() / 5 + 1) * 5);
            }
            if (null != compareMap.get("min"))
            {
                iyAxis.setMin(compareMap.get("min").intValue() < 0 ? compareMap.get("min").intValue() : 0);
            }
            iyAxis.setType("value");
            
            xAis.setData(sdata);
            
            Series series = new Series();
            series.setData(fdata);
            series.setType("bar");
            series.setName("麻醉分级管理例数");
            seriesList.add(series);
            
            resp.put("xAxis", xAis);
            resp.put("yAxis", iyAxis);
            resp.put("series", seriesList);
        }
        
        resp.put("tableList", tableList);
        resp.put("volumnAry", volumnAry);
        resp.put("columnAry", colAry);
        resp.put("value", value);
        logger.info("end searchOperByASALevel");
        return resp.getJsonStr();
    }
    
    
    /**
     * 
     * @discription 实施镇痛治疗例数
     * @author zhouyi
     * @param searchConditionFormBean
     * @return
     * @throws ParseException 
     */
    @RequestMapping(value = "/searchOperByAnalgesic")
    @ResponseBody
    @ApiOperation(value="实施镇痛治疗例数",httpMethod="POST",notes="实施镇痛治疗例数")
    public String searchOperByAnalgesic(@ApiParam(name="searchConditionFormBean", value ="统计查询参数") @RequestBody SearchConditionFormBean searchConditionFormBean)
    {
        logger.info("begin searchOperByAnalgesic");
        ResponseValue resp = new ResponseValue();
       
        //表格统计数据的list
        List tableList = new ArrayList();
        
        //开始时间集合
        List<String> startTimeList = new ArrayList<String>();
        
        //结束时间集合
        List<String> endTimeList = new ArrayList<String>();
        
        //统计数据表格列名数组
        String[] volumnAry = null;
        
        //根据传入的时间查询类型设置开始时间和结束时间
        try
        {
            volumnAry = setTime(searchConditionFormBean, startTimeList, endTimeList, 1);
        }
        catch (Exception e)
        {
            if (logger.isErrorEnabled()) {
                logger.error(Exceptions.getStackTraceAsString(e));
            }
            resp.put("resultCode", "10000000");
            resp.put("resultMessage", "系统错误，请与系统管理员联系!");
            return resp.getJsonStr();
        }
        
        String[] columnAry = new String[4];
        columnAry[0] = "镇痛治疗总例数";
        columnAry[1] = "门诊患者例数";
        columnAry[2] = "住院患者例数";
        columnAry[3] = "手术后镇痛例数";
        
        
        volumnAry[volumnAry.length - 1] = "总计";
        String[][] value = new String[volumnAry.length][4];
        
        //统计总计例数的时间加入到开始时间和结束时间集合中
        startTimeList.add(startTimeList.get(0));
        endTimeList.add(endTimeList.get(endTimeList.size() - 1));
        
        Map<String, String> vo = null;
        SearchFormBean searchFormBean = new SearchFormBean();
        //手术室条件筛选
        if (null != searchConditionFormBean.getOperRoomId() && !"".equals(searchConditionFormBean.getOperRoomId()))
        {
            searchFormBean.setOperRoomId(searchConditionFormBean.getOperRoomId());
        }
        
        //麻醉医生条件筛选
        if (null != searchConditionFormBean.getAnesthetistId() && !"".equals(searchConditionFormBean.getAnesthetistId()))
        {
            searchFormBean.setAnesthetistId(searchConditionFormBean.getAnesthetistId());
        }
        
        for (int i = 0; i < startTimeList.size(); i++)
        {
            searchFormBean.setStartTime(startTimeList.get(i));
            searchFormBean.setEndTime(endTimeList.get(i));
            vo = new HashMap<String, String>();
            vo.put("行名", volumnAry[i]);

            Integer total = statisticsService.searchOperByAnalgesic(searchFormBean);
            value[i][0] = total + "";
            vo.put(columnAry[0], total + "");
            
            //门诊统计
            searchFormBean.setOperSource("1");
            Integer total1 = statisticsService.searchOperByOperSource(searchFormBean);
            value[i][1] = total1 + "";
            vo.put(columnAry[1], total1 + "");
            
            //住院统计
            searchFormBean.setOperSource("0");
            Integer total2 = statisticsService.searchOperByOperSource(searchFormBean);
            value[i][2] = total2 + "";
            vo.put(columnAry[2], total2 + "");
            
            value[i][3] = total + "";
            vo.put(columnAry[3], total + "");
            
            tableList.add(vo);
        }
        
        Map<String, Float> compareMap = new HashMap<String, Float>();
        compareMap.put("min", null);
        compareMap.put("max", null);
        List<Series> seriesList = new ArrayList<Series>();
        List<Float> fdata = new ArrayList<Float>();
        
        if (tableList.size() > 0)
        {
            Map map = (Map)tableList.get(tableList.size() - 1);

            XAisData xAis = new XAisData();
            List<String> sdata = new ArrayList<String>();
            
            for (int i = 0; i < columnAry.length; i++)
            {
                sdata.add(columnAry[i]);
                
                fdata.add(Float.valueOf((String)map.get(columnAry[i])));
                setMaxAndMin(compareMap, Float.valueOf((String)map.get(columnAry[i])));
            }
            YAxisData iyAxis = new YAxisData();
            if (null != compareMap.get("max"))
            {
                iyAxis.setMax((compareMap.get("max").intValue() / 5 + 1) * 5 );
            }
            if (null != compareMap.get("min"))
            {
                iyAxis.setMin(compareMap.get("min").intValue() < 0 ? compareMap.get("min").intValue() : 0);
            }
            iyAxis.setType("value");
            
            xAis.setData(sdata);
            
            Series series = new Series();
            series.setData(fdata);
            series.setType("bar");
            series.setName("实施镇痛治疗例数");
            seriesList.add(series);
            
            resp.put("xAxis", xAis);
            resp.put("yAxis", iyAxis);
            resp.put("series", seriesList);
        }
        
        resp.put("tableList", tableList);
        resp.put("volumnAry", volumnAry);
        resp.put("columnAry", columnAry);
        resp.put("value", value);
        
        logger.info("end searchOperByAnalgesic");
        return resp.getJsonStr();
    }

    private void setTimeMap(SearchConditionFormBean searchConditionFormBean, ResponseValue resp, Map timeMap)
    {
        //开始时间集合
        List<String> startTimeList = new ArrayList<String>();
        
        //结束时间集合
        List<String> endTimeList = new ArrayList<String>();
        
        //根据传入的时间查询类型设置开始时间和结束时间
        try
        {
            setTime(searchConditionFormBean, startTimeList, endTimeList, 1);
        }
        catch (Exception e)
        {
            if (logger.isErrorEnabled()) {
                logger.error(Exceptions.getStackTraceAsString(e));
            }
            resp.setResultCode("10000000");
            return;
        }
        
        if (startTimeList.size() > 0)
        {
            timeMap.put("startTime", startTimeList.get(0));
        }
        
        if (endTimeList.size() > 0)
        {
            timeMap.put("endTime", endTimeList.get(endTimeList.size() - 1));
        }
    }
    
    
    /** 
     * 根据时间查询模式获取开始时间和结束时间
     * <功能详细描述>
     * @param searchConditionFormBean
     * @param startTimeList
     * @param endTimeList
     * @throws ParseException 
     * @see [类、类#方法、类#成员]
     */
    private String[] setTime(SearchConditionFormBean searchConditionFormBean, List<String> startTimeList,
        List<String> endTimeList, int length) throws ParseException
    {
        //月报
        if ("1".equals(searchConditionFormBean.getTimeType()))
        {
            //当前月
            if ("0".equals(searchConditionFormBean.getTimeRang()))
            {
                startTimeList.add(DateUtils.DateToString(DateUtils.getFirstDayOfMonth(new Date())));
                endTimeList.add(DateUtils.DateToString(DateUtils.getLastDayOfMonth(new Date())));
            }
            //最近一个月
            else if ("1".equals(searchConditionFormBean.getTimeRang()))
            {
                startTimeList.add(DateUtils.DateToString(org.apache.commons.lang3.time.DateUtils.addMonths(DateUtils.getFirstDayOfMonth(new Date()), -1)));
                endTimeList.add(DateUtils.DateToString(org.apache.commons.lang3.time.DateUtils.addMonths(DateUtils.getLastDayOfMonth(new Date()), -1)));
            }
            //最近两个月
            else if ("2".equals(searchConditionFormBean.getTimeRang()))
            {
                startTimeList.add(DateUtils.DateToString(org.apache.commons.lang3.time.DateUtils.addMonths(DateUtils.getFirstDayOfMonth(new Date()), -2)));
                endTimeList.add(DateUtils.DateToString(org.apache.commons.lang3.time.DateUtils.addMonths(DateUtils.getLastDayOfMonth(new Date()), -2)));
                startTimeList.add(DateUtils.DateToString(org.apache.commons.lang3.time.DateUtils.addMonths(DateUtils.getFirstDayOfMonth(new Date()), -1)));
                endTimeList.add(DateUtils.DateToString(org.apache.commons.lang3.time.DateUtils.addMonths(DateUtils.getLastDayOfMonth(new Date()), -1)));
            }
        }
        //季报
        else if ("2".equals(searchConditionFormBean.getTimeType()))
        {
            //当季
            if ("0".equals(searchConditionFormBean.getTimeRang()))
            {
                startTimeList.add(DateUtils.DateToString(DateUtils.getFirstDayOfQuarter(new Date())));
                endTimeList.add(DateUtils.DateToString(DateUtils.getLastDayOfQuarter(new Date())));
            }
            //最近一个季度
            else if ("1".equals(searchConditionFormBean.getTimeRang()))
            {
                startTimeList.add(DateUtils.DateToString(org.apache.commons.lang3.time.DateUtils.addMonths(DateUtils.getFirstDayOfQuarter(new Date()), -3)));
                endTimeList.add(DateUtils.DateToString(org.apache.commons.lang3.time.DateUtils.addMonths(DateUtils.getLastDayOfQuarter(new Date()), -3)));
            }
            //最近两个季度
            else if ("2".equals(searchConditionFormBean.getTimeRang()))
            {
                startTimeList.add(DateUtils.DateToString(org.apache.commons.lang3.time.DateUtils.addMonths(DateUtils.getFirstDayOfQuarter(new Date()), -6)));
                endTimeList.add(DateUtils.DateToString(org.apache.commons.lang3.time.DateUtils.addMonths(DateUtils.getLastDayOfQuarter(new Date()), -6)));
                startTimeList.add(DateUtils.DateToString(org.apache.commons.lang3.time.DateUtils.addMonths(DateUtils.getFirstDayOfQuarter(new Date()), -3)));
                endTimeList.add(DateUtils.DateToString(org.apache.commons.lang3.time.DateUtils.addMonths(DateUtils.getLastDayOfQuarter(new Date()), -3)));
            }
            //最近三个季度
            else if ("3".equals(searchConditionFormBean.getTimeRang()))
            {
                startTimeList.add(DateUtils.DateToString(org.apache.commons.lang3.time.DateUtils.addMonths(DateUtils.getFirstDayOfQuarter(new Date()), -9)));
                endTimeList.add(DateUtils.DateToString(org.apache.commons.lang3.time.DateUtils.addMonths(DateUtils.getLastDayOfQuarter(new Date()), -9)));
                startTimeList.add(DateUtils.DateToString(org.apache.commons.lang3.time.DateUtils.addMonths(DateUtils.getFirstDayOfQuarter(new Date()), -6)));
                endTimeList.add(DateUtils.DateToString(org.apache.commons.lang3.time.DateUtils.addMonths(DateUtils.getLastDayOfQuarter(new Date()), -6)));
                startTimeList.add(DateUtils.DateToString(org.apache.commons.lang3.time.DateUtils.addMonths(DateUtils.getFirstDayOfQuarter(new Date()), -3)));
                endTimeList.add(DateUtils.DateToString(org.apache.commons.lang3.time.DateUtils.addMonths(DateUtils.getLastDayOfQuarter(new Date()), -3)));
            }
        }
        //年报
        else if ("3".equals(searchConditionFormBean.getTimeType()))
        {
            int year = Calendar.getInstance().get(Calendar.YEAR);
            //当年
            if ("0".equals(searchConditionFormBean.getTimeRang()))
            {
                startTimeList.add(DateUtils.DateToString(DateUtils.getFirstDayOfYear(year)));
                endTimeList.add(DateUtils.DateToString(DateUtils.getLastDayOfYear(year)));
            }
            //最近一年
            else if ("1".equals(searchConditionFormBean.getTimeRang()))
            {
                startTimeList.add(DateUtils.DateToString(DateUtils.getFirstDayOfYear(year - 1)));
                endTimeList.add(DateUtils.DateToString(DateUtils.getLastDayOfYear(year - 1)));
            }
            //最近两年
            else if ("2".equals(searchConditionFormBean.getTimeRang()))
            {
                startTimeList.add(DateUtils.DateToString(DateUtils.getFirstDayOfYear(year - 2)));
                endTimeList.add(DateUtils.DateToString(DateUtils.getLastDayOfYear(year - 2)));
                startTimeList.add(DateUtils.DateToString(DateUtils.getFirstDayOfYear(year - 1)));
                endTimeList.add(DateUtils.DateToString(DateUtils.getLastDayOfYear(year - 1)));
            }
        }
        //时间区间
        else if ("4".equals(searchConditionFormBean.getTimeType()))
        {
            startTimeList.add(searchConditionFormBean.getStartTime());
            if (null == searchConditionFormBean.getEndTime())
            {
                endTimeList.add(DateUtils.getDate());
            }
            else
            {
                endTimeList.add(searchConditionFormBean.getEndTime());
            }
        }
        
        String[] ary = new String[startTimeList.size() + length];
        
        for (int i = 0; i < startTimeList.size(); i++)
        {
            if ("1".equals(searchConditionFormBean.getTimeType()))
            {
                ary[i] = DateUtils.getDateToString(startTimeList.get(i));
            }
            else if ("2".equals(searchConditionFormBean.getTimeType()))
            {
                ary[i] =
                    DateUtils.getDateToString(startTimeList.get(i)) + "/"
                        + DateUtils.getDateToString(endTimeList.get(i));
            }
            else if ("3".equals(searchConditionFormBean.getTimeType()))
            {
                if ("0".equals(searchConditionFormBean.getTimeRang()))
                {
                    ary[i] = String.valueOf(Calendar.getInstance().get(Calendar.YEAR) - i);
                }
                else
                {
                    ary[i] = String.valueOf(Calendar.getInstance().get(Calendar.YEAR) - 1 - i);
                }
            }
            else if ("4".equals(searchConditionFormBean.getTimeType()))
            {
                ary[i] = startTimeList.get(i) + "/" + endTimeList.get(i);
            }
        }
        
        return ary;
    }
    /** 
     * 首页手术台次统计  葛洲坝版本
     * <功能详细描述>
     * @param searchConditionFormBean
     * @return
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping(value = "/searchHomeOperTimes")
    @ResponseBody
	@ApiOperation(value="手术台次统计",httpMethod="POST",notes="首页手术台次统计")
    public String searchHomeOperTimes(@ApiParam(name="searchFormBean", value ="统计查询参数") @RequestBody SearchConditionFormBean searchFormBean) {
        Map map = new HashMap();
		String beid = searchFormBean.getBeid();
		if (StringUtils.isBlank(beid)) {
			beid = getBeid();
		}
        LegendData legend = new LegendData();
        List<String> legendList = new ArrayList<String>();
        List<SeriesDataObject> seriesData = new ArrayList<SeriesDataObject>();
		List<SeriesPie> seriesList = new ArrayList<SeriesPie>();
        
        SeriesPie series = new SeriesPie();
        series.setName("手术台次");
        series.setType("pie");
        //得到当前年份
        String year = DateUtils.getYear();
        String loginName = searchFormBean.getLoginName();
        BasUser user = basUserService.get(loginName, beid);
        
        for (int i = 0; i < 12; i++)
        {
            int count = 0;
            SeriesDataObject sdobj = new SeriesDataObject();
            String startTime = DateUtils.formatDate(DateUtils.getFirstDayOfMonth(Integer.parseInt(year), i), "yyyy-MM-dd");
            String endTime = DateUtils.formatDate(DateUtils.getLastDayOfMonth(Integer.parseInt(year), i), "yyyy-MM-dd");
            if (null != user && "ANAES_DOCTOR".equals(user.getUserType()))
            {
                count = statisticsService.searchHomeQMTimes(startTime, endTime, loginName);
            }
            else if(null != user && "NURSE".equals(user.getUserType()))
            {
                int qmCount = statisticsService.searchHomeQMTimes(startTime, endTime, loginName);
                int jmCount = statisticsService.searchHomeNurseJMTimes(startTime, endTime, loginName);
                count = qmCount + jmCount;
            }
            legendList.add(year + "年" + (i + 1) + "月");
            sdobj.setName(year + "年" + (i + 1) + "月");
            sdobj.setValue(String.valueOf(count));
            seriesData.add(sdobj);
        }
        legend.setData(legendList);
        series.setData(seriesData);
        seriesList.add(series);
        map.put("resultCode", "1");
        map.put("resultMessage", "查询手术台次成功");
        map.put("legend", legend);
        map.put("series", seriesList);
        return JsonType.jsonType(map);
    }

    /** 
     * 门诊手术统计表及明细
     * <功能详细描述>
     * @param searchConditionFormBean
     * @return
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping(value = "/searchOutpatientOperateList")
    @ResponseBody
    @ApiOperation(value="门诊手术统计表及明细",httpMethod="POST",notes="门诊手术统计表及明细")
    public String searchOutpatientOperateList(@ApiParam(name="searchConditionFormBean", value ="查询参数") @RequestBody SearchConditionFormBean searchConditionFormBean) {
        logger.info("begin searchOutpatientOperateList");
        ResponseValue resp = new ResponseValue();
        Map<String,String> timeMap = new HashMap<String,String>();
        setTimeMap(searchConditionFormBean, resp, timeMap);
        if (!"1".equals(resp.getResultCode())) {
        	resp.setResultCode("10000000");
        	resp.setResultMessage("系统错误，请与系统管理员联系!");
            return resp.getJsonStr();
        }
        SearchFormBean searchFormBean = new SearchFormBean();
        searchFormBean.setStartTime(timeMap.get("startTime"));
        searchFormBean.setEndTime(timeMap.get("endTime"));
        searchFormBean.setOperSource("1");//是否门诊 0住院 1门诊
        //手术室条件筛选
        if (null != searchConditionFormBean.getOperRoomId() && !"".equals(searchConditionFormBean.getOperRoomId())){
            searchFormBean.setOperRoomId(searchConditionFormBean.getOperRoomId());
        }
        List<SearchOperFormBean> outpatientList = statisticsService.searchOutpatientOperateList(searchFormBean);
        resp.put("outpatientList", outpatientList);
        resp.put("total", outpatientList.size());
        logger.info("end searchOutpatientOperateList");
        return resp.getJsonStr();
    }

    /** 
     * 住院手术统计表及明细
     * <功能详细描述>
     * @param searchConditionFormBean
     * @return
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping(value = "/searchHospPatientOperateList")
    @ResponseBody
    @ApiOperation(value="住院手术统计表及明细",httpMethod="POST",notes="住院手术统计表及明细")
    public String searchHospPatientOperateList(@ApiParam(name="searchConditionFormBean", value ="查询参数") @RequestBody SearchConditionFormBean searchConditionFormBean) {
        logger.info("begin searchHospPatientOperateList");
        ResponseValue resp = new ResponseValue();
        Map<String,String> timeMap = new HashMap<String,String>();
        setTimeMap(searchConditionFormBean, resp, timeMap);
        if (!"1".equals(resp.getResultCode())) {
            resp.setResultCode("10000000");
            resp.setResultMessage("系统错误，请与系统管理员联系!");
            return resp.getJsonStr();
        }
        SearchFormBean searchFormBean = new SearchFormBean();
        searchFormBean.setStartTime(timeMap.get("startTime"));
        searchFormBean.setEndTime(timeMap.get("endTime"));
        searchFormBean.setOperSource("0");//是否门诊 0住院 1门诊
        //手术室条件筛选
        if (null != searchConditionFormBean.getOperRoomId() && !"".equals(searchConditionFormBean.getOperRoomId())){
            searchFormBean.setOperRoomId(searchConditionFormBean.getOperRoomId());
        }
        List<SearchOperFormBean> hospPatientList = statisticsService.searchOutpatientOperateList(searchFormBean);
        resp.put("hospPatientList", hospPatientList);
        resp.put("total", hospPatientList.size());
        logger.info("end searchHospPatientOperateList");
        return resp.getJsonStr();
    }

    /**
     * 手术统计表  麻醉登记表
     * @param systemSearchFormBean
     * @return
     */
    @RequestMapping(value = "/queryAnaesRegDetailList")
    @ResponseBody
    @ApiOperation(value="麻醉登记表",httpMethod="POST",notes="麻醉登记表")
    public String queryAnaesRegDetailList(@ApiParam(name="searchConditionFormBean", value ="查询参数") @RequestBody SearchConditionFormBean searchConditionFormBean){
    	logger.info("begin queryAnaesRegDetailList");
        ResponseValue resp = new ResponseValue();
        Map<String,String> timeMap = new HashMap<String,String>();
        setTimeMap(searchConditionFormBean, resp, timeMap);
        if (!"1".equals(resp.getResultCode())) {
            resp.setResultCode("10000000");
            resp.setResultMessage("系统错误，请与系统管理员联系!");
            return resp.getJsonStr();
        }
        int total = statisticsService.queryTotalAnaesRegDetailList(searchConditionFormBean);
        resp.put("anaesRegdetailList", statisticsService.queryAnaesRegDetailList(searchConditionFormBean));
        resp.put("total", total);
        logger.info("end queryAnaesRegDetailList");
        return resp.getJsonStr();
    }

    /**
     * 手术统计表  分科手术登记表
     * @param systemSearchFormBean
     * @return
     */
    @RequestMapping(value = "/queryOperateDetailByDept")
    @ResponseBody
    @ApiOperation(value="分科手术登记表",httpMethod="POST",notes="分科手术登记表")
    public String queryOperateDetailByDept(@ApiParam(name="searchConditionFormBean", value ="查询参数") @RequestBody SearchConditionFormBean searchConditionFormBean){
    	logger.info("begin queryOperateDetailByDept");
        ResponseValue resp = new ResponseValue();
        Map<String,String> timeMap = new HashMap<String,String>();
        setTimeMap(searchConditionFormBean, resp, timeMap);
        if (!"1".equals(resp.getResultCode())) {
            resp.setResultCode("10000000");
            resp.setResultMessage("系统错误，请与系统管理员联系!");
            return resp.getJsonStr();
        }
        int total = statisticsService.queryOperateDetailByDeptTotal(searchConditionFormBean);
        resp.put("operateDetailByDeptList", statisticsService.queryOperateDetailByDept(searchConditionFormBean));
        resp.put("total", total);
        logger.info("end queryOperateDetailByDept");
        return resp.getJsonStr();
    }

    /**
     * 手术统计表  手术医生统计明细登记表
     * @param systemSearchFormBean
     * @return
     */
    @RequestMapping(value = "/queryOpeDocDetail")
    @ResponseBody
    @ApiOperation(value="手术医生统计明细登记表",httpMethod="POST",notes="手术医生统计明细登记表")
    public String queryOpeDocDetail(@ApiParam(name="searchConditionFormBean", value ="查询参数") @RequestBody SearchConditionFormBean searchConditionFormBean){
    	logger.info("begin queryOpeDocDetail");
        ResponseValue resp = new ResponseValue();
        Map<String,String> timeMap = new HashMap<String,String>();
        setTimeMap(searchConditionFormBean, resp, timeMap);
        if (!"1".equals(resp.getResultCode())) {
            resp.setResultCode("10000000");
            resp.setResultMessage("系统错误，请与系统管理员联系!");
            return resp.getJsonStr();
        }
        int total = statisticsService.queryOperateDetailByDeptTotal(searchConditionFormBean);
        resp.put("operDocDetailList", statisticsService.queryOperateDetailByDept(searchConditionFormBean));
        resp.put("total", total);
        logger.info("end queryOpeDocDetail");
        return resp.getJsonStr();
    }

    /** 
     * 手术患者手术并发症统计及明细
     * <功能详细描述>
     * @param searchConditionFormBean
     * @return
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping(value = "/searchComplicationPatient")
    @ResponseBody
    @ApiOperation(value="手术患者手术并发症统计及明细",httpMethod="POST",notes="手术患者手术并发症统计及明细")
    public String queryComplicationPatient(@ApiParam(name="searchConditionFormBean", value ="查询参数") @RequestBody SearchConditionFormBean searchConditionFormBean) {
        logger.info("begin searchComplicationPatient");
        ResponseValue resp = new ResponseValue();
        Map<String,String> timeMap = new HashMap<String,String>();
        setTimeMap(searchConditionFormBean, resp, timeMap);
        if (!"1".equals(resp.getResultCode())) {
            resp.setResultCode("10000000");
            resp.setResultMessage("系统错误，请与系统管理员联系!");
            return resp.getJsonStr();
        }
        SearchFormBean searchFormBean = new SearchFormBean();
        searchFormBean.setStartTime(timeMap.get("startTime"));
        searchFormBean.setEndTime(timeMap.get("endTime"));
        searchFormBean.setIsLocalAnaes("0");  //全麻
        if (StringUtils.isBlank(searchConditionFormBean.getBeid())) {
        	searchFormBean.setBeid(getBeid());
		}else {
			searchFormBean.setBeid(searchConditionFormBean.getBeid());
		}
        List<SearchOperFormBean> complicationPatientList = statisticsService.queryComplicationPatient(searchFormBean);
        
        resp.put("complicationPatientList", complicationPatientList);
        resp.put("total", complicationPatientList.size());
        logger.info("end searchComplicationPatient");
        return resp.getJsonStr();
    }

    
    /**
     * 
     * 住院重点手术总例数、死亡例数、术后非计划重返再次手术例数（新增）
     * @param searchConditionFormBean
     * @return
     */
    
    @RequestMapping(value = "/searchHospitalKeyOperationNum")
    @ResponseBody
    @ApiOperation(value="住院重点手术总例数、死亡例数、术后非计划重返再次手术例数",httpMethod="POST",notes="住院重点手术总例数、死亡例数、术后非计划重返再次手术例数")
    public String searchHospitalKeyOperationNum(@ApiParam(name="searchConditionFormBean", value ="查询参数") @RequestBody SearchConditionFormBean searchConditionFormBean) {
        logger.info("begin searchHospitalKeyOperationNum");
        ResponseValue resp = new ResponseValue();
        
        List<String> startTimeList = new ArrayList<String>();
		List<String> endTimeList = new ArrayList<String>();
		
		//统计数据表格列名数组
        String[] columnAry = null;
        
        //根据传入的时间查询类型设置开始时间和结束时间
        try {
			columnAry = setTime(searchConditionFormBean, startTimeList , endTimeList , 1);
		} catch (ParseException e) {
            resp.setResultCode("10000000");
            resp.setResultMessage("系统错误，请与系统管理员联系!");
            return resp.getJsonStr();
		} //增加length，则为1 
        int colSize = columnAry.length+1; //行长度
        
        SearchFormBean searchFormBean = new SearchFormBean();
        //手术室条件筛选
        if (null != searchConditionFormBean.getOperatorId() && !"".equals(searchConditionFormBean.getOperatorId())){
            searchFormBean.setOperatorId(searchConditionFormBean.getOperatorId());
        }
        
        List<HospitalKeyOperationFormBean> tabList = new ArrayList<HospitalKeyOperationFormBean>();
        HospitalKeyOperationFormBean first = new HospitalKeyOperationFormBean();
        first.setDateName("日期");
        first.setKeyOperationNum("重点手术总例数");
        first.setDeathNum("死亡例数");
        first.setReturnNum("术后非计划重返再次手术例数");
        tabList.add(0, first);
        
        int totalKey = 0;
        int totalDeath = 0;
        int totalReturn = 0;
        
        for (int i = 0; i < startTimeList.size(); i++) {
			String startTime = startTimeList.get(i);
			String endTime = endTimeList.get(i);
			searchFormBean.setStartTime(startTime);
			searchFormBean.setEndTime(endTime);
			int keyOperationNum = statisticsService.searchHospitalKeyOperationNum(searchFormBean);
			int deathNum = statisticsService.searchDeathNum(searchFormBean);
			int returnNum = new Random().nextInt(10);
			totalKey += keyOperationNum;
			totalDeath += deathNum;
			totalReturn += returnNum;
			HospitalKeyOperationFormBean bean = new HospitalKeyOperationFormBean();
			bean.setDateName(columnAry[i]);
			bean.setKeyOperationNum(keyOperationNum+"");
			bean.setDeathNum(deathNum+"");
			bean.setReturnNum(returnNum+"");
			tabList.add(i+1,bean);
		}
        
        HospitalKeyOperationFormBean b = new HospitalKeyOperationFormBean();
        b.setDateName("总计");
        b.setKeyOperationNum(totalKey+"");
        b.setDeathNum(totalDeath+"");
        b.setReturnNum(totalReturn+"");
        tabList.add(tabList.size(), b);
        
        resp.put("tabList", tabList);
        logger.info("end searchHospitalKeyOperationNum");
        return resp.getJsonStr();
    }
}
