package com.digihealth.anesthesia.research.controller;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.digihealth.anesthesia.common.entity.ResponseValue;
import com.digihealth.anesthesia.common.utils.DateUtils;
import com.digihealth.anesthesia.common.utils.Exceptions;
import com.digihealth.anesthesia.common.web.BaseController;
import com.digihealth.anesthesia.doc.po.DocPostFollowGeneral;
import com.digihealth.anesthesia.doc.po.DocPostFollowSpinal;
import com.digihealth.anesthesia.evt.formbean.SearchConditionFormBean;
import com.digihealth.anesthesia.evt.formbean.SearchFormBean;
import com.digihealth.anesthesia.evt.po.EvtAnaesEvent;
import com.digihealth.anesthesia.research.formbean.SearchOperFormBean;
import com.digihealth.anesthesia.research.service.QCManagerService;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

@Controller
@RequestMapping("/qcMng")
public class QCManagerController extends BaseController{
	
    private static final String[] COLUMN = new String[]{"患者姓名","性别","年龄","住院号","手术日期","手术医生","手术名称","麻醉医生"};

    private static final String[] PACUCOLUMN = new String[]{"患者姓名","性别","年龄","住院号","手术日期","手术医生","手术名称","麻醉方法","麻醉医生","巡回护士","入PACU时间","出PACU时间"};

    private static final String[] LTCOLUMN = new String[]{"患者姓名","性别","年龄","住院号","手术日期","手术医生","手术名称","麻醉方法","麻醉医生","巡回护士","入PACU时间","入室体温","出PACU时间"};

    private static final String[] CACOLUMN = new String[]{"患者姓名","性别","年龄","住院号","手术日期","手术医生","手术名称","麻醉方法","麻醉医生","巡回护士","麻醉开始时间","是否心跳骤停","心跳骤停时间"};

    private static final String[] DHCOLUMN = new String[]{"患者姓名","性别","年龄","住院号","手术日期","手术医生","手术名称","麻醉方法","麻醉医生","巡回护士","麻醉开始时间","是否死亡","死亡时间"};

    private static final String[] NPCOLUMN = new String[]{"患者姓名","性别","年龄","住院号","手术日期","手术医生","手术名称","麻醉方法","麻醉医生","巡回护士","计划转入","实际转入"};

    private static final String[] AMCOLUMN = new String[]{"患者姓名","性别","年龄","住院号","手术日期","手术医生","手术名称","麻醉方法","麻醉医生","巡回护士"};
	/**
	 * 同期麻醉患者的总数
	 */
	public String getAllRegOptByTime(@RequestBody String time){
		return null;
	}
	
	
	/** 
     * 查询急诊非择期麻醉比例
     * <功能详细描述>
     * @param searchConditionFormBean
     * @return
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping(value = "/searchEmergencyOper")
    @ResponseBody
    @ApiOperation(value="急诊非择期麻醉比例",httpMethod="POST",notes="急诊非择期麻醉比例")
    public String searchEmergencyOper(@ApiParam(name="searchConditionFormBean", value ="统计查询参数") @RequestBody SearchConditionFormBean searchConditionFormBean)
    {
        logger.info("begin searchEmergencyOper");
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
        if (StringUtils.isBlank(searchConditionFormBean.getBeid())) {
        	searchFormBean.setBeid(getBeid());
		}else {
			searchFormBean.setBeid(searchConditionFormBean.getBeid());
		}
        
        int operTotal = 0;
        List<SearchOperFormBean> operList = qcManagerService.searchOperByCondition(searchFormBean);
        
        searchFormBean.setEmergency(1);
        int emergencyTotal = 0;
        List<SearchOperFormBean> emergencyList = qcManagerService.searchOperByCondition(searchFormBean);
        
        Map<String, String> vo = null;
        //表格统计数据的list
        List operTableList = new ArrayList();
        if (operList != null && operList.size() > 0)
        {
            operTotal = operList.size();
            for (int i = 0; i < operList.size(); i++)
            {
                vo = new HashMap<String, String>();
                vo.put("行名", (i+1) + "");
                vo.put(COLUMN[0], operList.get(i).getName());
                vo.put(COLUMN[1], operList.get(i).getSex());
                vo.put(COLUMN[2], operList.get(i).getAge());
                vo.put(COLUMN[3], operList.get(i).getHid());
                vo.put(COLUMN[4], operList.get(i).getOperaDate());
                vo.put(COLUMN[5], operList.get(i).getOperatorName());
                vo.put(COLUMN[6], operList.get(i).getDesignedOptName());
                vo.put(COLUMN[7], operList.get(i).getAnesthetistName());
                operTableList.add(vo);
            }
        }
        
        List emergencyTableList = new ArrayList();
        if (emergencyList != null && emergencyList.size() > 0)
        {
            emergencyTotal = emergencyList.size();
            for (int i = 0; i < emergencyList.size(); i++)
            {
                vo = new HashMap<String, String>();
                vo.put("行名", (i+1) + "");
                vo.put(COLUMN[0], emergencyList.get(i).getName());
                vo.put(COLUMN[1], emergencyList.get(i).getSex());
                vo.put(COLUMN[2], emergencyList.get(i).getAge());
                vo.put(COLUMN[3], emergencyList.get(i).getHid());
                vo.put(COLUMN[4], emergencyList.get(i).getOperaDate());
                vo.put(COLUMN[5], emergencyList.get(i).getOperatorName());
                vo.put(COLUMN[6], emergencyList.get(i).getDesignedOptName());
                vo.put(COLUMN[7], emergencyList.get(i).getAnesthetistName());
                emergencyTableList.add(vo);
            }
        }
        
        float rate = 0.00f;
        if (operTotal != 0)
        {
            rate = (float)emergencyTotal / operTotal;
        }
        DecimalFormat df = new DecimalFormat("0.000");
        BigDecimal b = new BigDecimal(df.format(rate));
        BigDecimal c = new BigDecimal(Double.valueOf(100));
        rate = b.multiply(c).setScale(1, BigDecimal.ROUND_HALF_UP).floatValue();
        
        resp.put("operTotal", operTotal);
        resp.put("emergencyTotal", emergencyTotal);
        resp.put("operTableList", operTableList);
        resp.put("emergencyTableList", emergencyTableList);
        resp.put("columnAry", COLUMN);
        resp.put("rate", rate);
        logger.info("end searchEmergencyOper");
        return resp.getJsonStr();
    }
    
   
    /**
     * 查询麻醉科医患比 <功能详细描述>
     * 
     * @param searchConditionFormBean
     * @return
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping(value = "/searchDoctorPatientRate")
    @ResponseBody
    @ApiOperation(value="麻醉科医患比",httpMethod="POST",notes="麻醉科医患比")
    public String searchDoctorPatientRate(@ApiParam(name="searchConditionFormBean", value ="统计查询参数") @RequestBody SearchConditionFormBean searchConditionFormBean)
    {
        logger.info("begin searchDoctorPatientRatio");
        ResponseValue resp = new ResponseValue();
        Map<String, String> timeMap = new HashMap<String, String>();
        setTimeMap(searchConditionFormBean, resp, timeMap);
        if (!"1".equals(resp.getResultCode())) {
            resp.setResultCode("10000000");
            resp.setResultMessage("系统错误，请与系统管理员联系!");
            return resp.getJsonStr();
        }
        
        SearchFormBean searchFormBean = new SearchFormBean();
        searchFormBean.setStartTime(timeMap.get("startTime"));
        searchFormBean.setEndTime(timeMap.get("endTime"));
        if (StringUtils.isBlank(searchConditionFormBean.getBeid())) {
        	searchFormBean.setBeid(getBeid());
		}else {
			searchFormBean.setBeid(searchConditionFormBean.getBeid());
		}
        List<SearchOperFormBean> operList = qcManagerService.searchOperByCondition(searchFormBean);
        
        // 暂时做不了
        int anestheDocNum = 0;
        int operTotal = 0;
        
        Map<String, String> vo = null;
        // 表格统计数据的list
        List operTableList = new ArrayList();
        if (operList != null && operList.size() > 0)
        {
            operTotal = operList.size();
            for (int i = 0; i < operList.size(); i++)
            {
                vo = new HashMap<String, String>();
                vo.put("行名", (i + 1) + "");
                vo.put(COLUMN[0], operList.get(i).getName());
                vo.put(COLUMN[1], operList.get(i).getSex());
                vo.put(COLUMN[2], operList.get(i).getAge());
                vo.put(COLUMN[3], operList.get(i).getHid());
                vo.put(COLUMN[4], operList.get(i).getOperaDate());
                vo.put(COLUMN[5], operList.get(i).getOperatorName());
                vo.put(COLUMN[6], operList.get(i).getDesignedOptName());
                vo.put(COLUMN[7], operList.get(i).getAnesthetistName());
                operTableList.add(vo);
            }
        }
        
        float rate = 0.00f;
        if (operTotal != 0)
        {
            rate = (float)anestheDocNum / operTotal;
        }
        DecimalFormat df = new DecimalFormat("0.000");
        BigDecimal b = new BigDecimal(df.format(rate));
        BigDecimal c = new BigDecimal(Double.valueOf(100));
        rate = b.multiply(c).setScale(1, BigDecimal.ROUND_HALF_UP).floatValue();
        
        resp.put("operTotal", operTotal);
        resp.put("anestheDocNum", anestheDocNum);
        resp.put("operTableList", operTableList);
        resp.put("columnAry", COLUMN);
        resp.put("rate", rate);
        logger.info("end searchDoctorPatientRatio");
        return resp.getJsonStr();
    }
    
    /**
     * 查询各类麻醉方式比例
     * 
     * @param searchConditionFormBean
     * @return
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping(value = "/searchAnesthMethodRate")
    @ResponseBody
    @ApiOperation(value="各类麻醉方式比例",httpMethod="POST",notes="各类麻醉方式比例")
    public String searchAnesthMethodRate(@ApiParam(name="searchConditionFormBean", value ="统计查询参数") @RequestBody SearchConditionFormBean searchConditionFormBean) {
    	logger.info("begin searchAnesthMethodRate");
        ResponseValue resp = new ResponseValue();
        Map<String, String> timeMap = new HashMap<String, String>();
        setTimeMap(searchConditionFormBean, resp, timeMap);
        if (!"1".equals(resp.getResultCode())) {
            resp.setResultCode("10000000");
            resp.setResultMessage("系统错误，请与系统管理员联系!");
            return resp.getJsonStr();
        }
        
        SearchFormBean searchFormBean = new SearchFormBean();
        searchFormBean.setStartTime(timeMap.get("startTime"));
        searchFormBean.setEndTime(timeMap.get("endTime"));
        if (StringUtils.isBlank(searchConditionFormBean.getBeid())) {
        	searchFormBean.setBeid(getBeid());
		}else {
			searchFormBean.setBeid(searchConditionFormBean.getBeid());
		}
        List<SearchOperFormBean> operList = qcManagerService.searchOperByCondition(searchFormBean);
        
        searchFormBean.setType("0");
        List<SearchOperFormBean> spinalList = qcManagerService.searchOtherAnesList(searchFormBean); //椎管内全麻
        
        searchFormBean.setType("1");
        List<SearchOperFormBean> intubatList = qcManagerService.searchOtherAnesList(searchFormBean); //插管全麻
        
        searchFormBean.setType("2");
        List<SearchOperFormBean> nonIntubatList = qcManagerService.searchOtherAnesList(searchFormBean); //非插管全麻
        
        List<SearchOperFormBean> compositeList = qcManagerService.searchReunitWihtAnesList(searchFormBean); //复合全麻
        
        searchFormBean.setType("3");
        List<SearchOperFormBean> otherList = qcManagerService.searchOtherAnesList(searchFormBean); //其他麻醉方式
        for (SearchOperFormBean searchOperFormBean : operList) {
			if(searchOperFormBean.getIsLocalAnaes().equals("1")){//局部麻醉 归类到其他麻醉方式里
				otherList.add(searchOperFormBean);
			}
		}
        
        Map<String,Integer> map = new HashMap<String,Integer>();
        Map<String,Float> rateMap = new HashMap<String,Float>();
        Map<String, String> vo = null;
        // 表格统计数据的list
        List anesTableList = new ArrayList();
        
        map.put("椎管内麻醉", spinalList.size());
        for (int j = 0; j < spinalList.size(); j++) {
            vo = new HashMap<String, String>();
            vo.put("麻醉方法", "椎管内麻醉");
            vo.put(AMCOLUMN[0], spinalList.get(j).getName());
            vo.put(AMCOLUMN[1], spinalList.get(j).getSex());
            vo.put(AMCOLUMN[2], spinalList.get(j).getAge());
            vo.put(AMCOLUMN[3], spinalList.get(j).getHid());
            vo.put(AMCOLUMN[4], spinalList.get(j).getOperaDate());
            vo.put(AMCOLUMN[5], spinalList.get(j).getOperatorName());
            vo.put(AMCOLUMN[6], spinalList.get(j).getDesignedOptName());
            vo.put(AMCOLUMN[7], "椎管内麻醉");
            vo.put(AMCOLUMN[8], spinalList.get(j).getAnesthetistName());
            vo.put(AMCOLUMN[9], spinalList.get(j).getCircunurseName());
            
            anesTableList.add(vo);
        }
        
        map.put("插管全麻", intubatList.size());
        for (int j = 0; j < intubatList.size(); j++) {
            vo = new HashMap<String, String>();
            vo.put("麻醉方法", "插管全麻");
            vo.put(AMCOLUMN[0], intubatList.get(j).getName());
            vo.put(AMCOLUMN[1], intubatList.get(j).getSex());
            vo.put(AMCOLUMN[2], intubatList.get(j).getAge());
            vo.put(AMCOLUMN[3], intubatList.get(j).getHid());
            vo.put(AMCOLUMN[4], intubatList.get(j).getOperaDate());
            vo.put(AMCOLUMN[5], intubatList.get(j).getOperatorName());
            vo.put(AMCOLUMN[6], intubatList.get(j).getDesignedOptName());
            vo.put(AMCOLUMN[7], "插管全麻");
            vo.put(AMCOLUMN[8], intubatList.get(j).getAnesthetistName());
            vo.put(AMCOLUMN[9], intubatList.get(j).getCircunurseName());
            anesTableList.add(vo);
        }
        
        map.put("非插管全麻", nonIntubatList.size());
        for (int j = 0; j < nonIntubatList.size(); j++) {
            vo = new HashMap<String, String>();
            vo.put("麻醉方法", "非插管全麻");
            vo.put(AMCOLUMN[0], nonIntubatList.get(j).getName());
            vo.put(AMCOLUMN[1], nonIntubatList.get(j).getSex());
            vo.put(AMCOLUMN[2], nonIntubatList.get(j).getAge());
            vo.put(AMCOLUMN[3], nonIntubatList.get(j).getHid());
            vo.put(AMCOLUMN[4], nonIntubatList.get(j).getOperaDate());
            vo.put(AMCOLUMN[5], nonIntubatList.get(j).getOperatorName());
            vo.put(AMCOLUMN[6], nonIntubatList.get(j).getDesignedOptName());
            vo.put(AMCOLUMN[7], "非插管全麻");
            vo.put(AMCOLUMN[8], nonIntubatList.get(j).getAnesthetistName());
            vo.put(AMCOLUMN[9], nonIntubatList.get(j).getCircunurseName());
            anesTableList.add(vo);
        }
        
        map.put("复合麻醉", compositeList.size());
        for (int j = 0; j < compositeList.size(); j++) {
            vo = new HashMap<String, String>();
            vo.put("麻醉方法", "复合麻醉");
            vo.put(AMCOLUMN[0], compositeList.get(j).getName());
            vo.put(AMCOLUMN[1], compositeList.get(j).getSex());
            vo.put(AMCOLUMN[2], compositeList.get(j).getAge());
            vo.put(AMCOLUMN[3], compositeList.get(j).getHid());
            vo.put(AMCOLUMN[4], compositeList.get(j).getOperaDate());
            vo.put(AMCOLUMN[5], compositeList.get(j).getOperatorName());
            vo.put(AMCOLUMN[6], compositeList.get(j).getDesignedOptName());
            vo.put(AMCOLUMN[7], "复合麻醉");
            vo.put(AMCOLUMN[8], compositeList.get(j).getAnesthetistName());
            vo.put(AMCOLUMN[9], compositeList.get(j).getCircunurseName());
            anesTableList.add(vo);
        }
        map.put("其他麻醉方式", otherList.size());
        for (int j = 0; j < otherList.size(); j++) {
            vo = new HashMap<String, String>();
            vo.put("麻醉方法", "其他麻醉方式");
            vo.put(AMCOLUMN[0], otherList.get(j).getName());
            vo.put(AMCOLUMN[1], otherList.get(j).getSex());
            vo.put(AMCOLUMN[2], otherList.get(j).getAge());
            vo.put(AMCOLUMN[3], otherList.get(j).getHid());
            vo.put(AMCOLUMN[4], otherList.get(j).getOperaDate());
            vo.put(AMCOLUMN[5], otherList.get(j).getOperatorName());
            vo.put(AMCOLUMN[6], otherList.get(j).getDesignedOptName());
            vo.put(AMCOLUMN[7], "其他麻醉方式");
            vo.put(AMCOLUMN[8], otherList.get(j).getAnesthetistName());
            vo.put(AMCOLUMN[9], otherList.get(j).getCircunurseName());
            anesTableList.add(vo);
        }
        
        // 暂时做不了
        int anesthMethodNum = 0;
        int operTotal = 0;
        
        // 表格统计数据的list
        List operTableList = new ArrayList();
        if (operList != null && operList.size() > 0) {
            operTotal = operList.size();
            for (int i = 0; i < operList.size(); i++) {
                vo = new HashMap<String, String>();
                vo.put("行名", (i + 1) + "");
                vo.put(AMCOLUMN[0], operList.get(i).getName());
                vo.put(AMCOLUMN[1], operList.get(i).getSex());
                vo.put(AMCOLUMN[2], operList.get(i).getAge());
                vo.put(AMCOLUMN[3], operList.get(i).getHid());
                vo.put(AMCOLUMN[4], operList.get(i).getOperaDate());
                vo.put(AMCOLUMN[5], operList.get(i).getOperatorName());
                vo.put(AMCOLUMN[6], operList.get(i).getDesignedOptName());
                vo.put(AMCOLUMN[7], operList.get(i).getAnaesMethodName());
                vo.put(AMCOLUMN[8], operList.get(i).getAnesthetistName());
                vo.put(AMCOLUMN[9], operList.get(i).getCircunurseName());
                operTableList.add(vo);
            }
        }
        
        for (String key : map.keySet()) {
            int total = map.get(key);
            float rate = 0.00f;
            if (operTotal != 0) {
                rate = (float)total / operTotal;
            }
            DecimalFormat df = new DecimalFormat("0.000");
            BigDecimal b = new BigDecimal(df.format(rate));
            BigDecimal c = new BigDecimal(Double.valueOf(100));
            rate = b.multiply(c).setScale(1, BigDecimal.ROUND_HALF_UP).floatValue();
            rateMap.put(key, rate);
        }
        resp.put("operTotal", operTotal);
        resp.put("operTableList", operTableList);
        resp.put("anesTypeTotal", map);
        resp.put("anesTableList", anesTableList);
        resp.put("columnAry", AMCOLUMN);
        resp.put("rate", rateMap);
        logger.info("end searchAnesthMethodRate");
        return resp.getJsonStr();
    }
   
    /**
     * 查询麻醉开始后手术取消率
     * 
     * @param searchConditionFormBean
     * @return
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping(value = "/searchOperCancleRate")
    @ResponseBody
    @ApiOperation(value="麻醉开始后手术取消率",httpMethod="POST",notes="麻醉开始后手术取消率")
    public String searchOperCancleRate(@ApiParam(name="searchConditionFormBean", value ="统计查询参数") @RequestBody SearchConditionFormBean searchConditionFormBean)
    {
        logger.info("begin searchOperCancleRate");
        ResponseValue resp = new ResponseValue();
        Map<String, String> timeMap = new HashMap<String, String>();
        setTimeMap(searchConditionFormBean, resp, timeMap);
        if (!"1".equals(resp.getResultCode())) {
            resp.setResultCode("10000000");
            resp.setResultMessage("系统错误，请与系统管理员联系!");
            return resp.getJsonStr();
        }
        
        SearchFormBean searchFormBean = new SearchFormBean();
        searchFormBean.setStartTime(timeMap.get("startTime"));
        searchFormBean.setEndTime(timeMap.get("endTime"));
        if (StringUtils.isBlank(searchConditionFormBean.getBeid())) {
        	searchFormBean.setBeid(getBeid());
		}else {
			searchFormBean.setBeid(searchConditionFormBean.getBeid());
		}

        List<SearchOperFormBean> operList = qcManagerService.searchOperByCondition(searchFormBean);
        List<SearchOperFormBean> operCancleList = qcManagerService.searchCancleOperAfterAnaes(searchFormBean);
        
        // 暂时做不了
        int operCancleNum = 0;
        int operTotal = 0;
        
        Map<String, String> vo = null;
        // 表格统计数据的list
        List operTableList = new ArrayList();
        if (operList != null && operList.size() > 0)
        {
            operTotal = operList.size();
            for (int i = 0; i < operList.size(); i++)
            {
                vo = new HashMap<String, String>();
                vo.put("行名", (i + 1) + "");
                vo.put(COLUMN[0], operList.get(i).getName());
                vo.put(COLUMN[1], operList.get(i).getSex());
                vo.put(COLUMN[2], operList.get(i).getAge());
                vo.put(COLUMN[3], operList.get(i).getHid());
                vo.put(COLUMN[4], operList.get(i).getOperaDate());
                vo.put(COLUMN[5], operList.get(i).getOperatorName());
                vo.put(COLUMN[6], operList.get(i).getDesignedOptName());
                vo.put(COLUMN[7], operList.get(i).getAnesthetistName());
                operTableList.add(vo);
            }
        }
        
        // 表格统计数据的list
        List operCancleTableList = new ArrayList();
        if (operCancleList != null && operCancleList.size() > 0)
        {
            operCancleNum = operCancleList.size();
            for (int i = 0; i < operCancleList.size(); i++)
            {
                vo = new HashMap<String, String>();
                vo.put("行名", (i + 1) + "");
                vo.put(COLUMN[0], operCancleList.get(i).getName());
                vo.put(COLUMN[1], operCancleList.get(i).getSex());
                vo.put(COLUMN[2], operCancleList.get(i).getAge());
                vo.put(COLUMN[3], operCancleList.get(i).getHid());
                vo.put(COLUMN[4], operCancleList.get(i).getOperaDate());
                vo.put(COLUMN[5], operCancleList.get(i).getOperatorName());
                vo.put(COLUMN[6], operCancleList.get(i).getDesignedOptName());
                vo.put(COLUMN[7], operCancleList.get(i).getAnesthetistName());
                operCancleTableList.add(vo);
            }
        }
        
        float rate = 0.00f;
        if (operTotal != 0)
        {
            rate = (float)operCancleNum / operTotal;
        }
        DecimalFormat df = new DecimalFormat("0.0000");
        BigDecimal b = new BigDecimal(df.format(rate));
        BigDecimal c = new BigDecimal(Double.valueOf(1000));
        rate = b.multiply(c).setScale(1, BigDecimal.ROUND_HALF_UP).floatValue();
        
        resp.put("operTotal", operTotal);
        resp.put("operCancleNum", operCancleNum);
        resp.put("operTableList", operTableList);
        resp.put("operCancleTableList", operCancleTableList);
        resp.put("columnAry", COLUMN);
        resp.put("rate", rate);
        logger.info("end searchOperCancleRate");
        return resp.getJsonStr();
    }
    
    /**
     * 查询非计划转入ICU率
     * 
     * @param searchConditionFormBean
     * @return
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping(value = "/searchNonPlanToICURate")
    @ResponseBody
    @ApiOperation(value="非计划转入ICU率",httpMethod="POST",notes="非计划转入ICU率")
    public String searchNonPlanToICURate(@ApiParam(name="searchConditionFormBean", value ="统计查询参数") @RequestBody SearchConditionFormBean searchConditionFormBean) {
    	logger.info("begin searchNonPlanToICURate");
        ResponseValue resp = new ResponseValue();
        Map<String, String> timeMap = new HashMap<String, String>();
        setTimeMap(searchConditionFormBean, resp, timeMap);
        if (!"1".equals(resp.getResultCode())) {
            resp.setResultCode("10000000");
            resp.setResultMessage("系统错误，请与系统管理员联系!");
            return resp.getJsonStr();
        }
        
        SearchFormBean searchFormBean = new SearchFormBean();
        searchFormBean.setStartTime(timeMap.get("startTime"));
        searchFormBean.setEndTime(timeMap.get("endTime"));
        if (StringUtils.isBlank(searchConditionFormBean.getBeid())) {
        	searchFormBean.setBeid(getBeid());
		}else {
			searchFormBean.setBeid(searchConditionFormBean.getBeid());
		}
        
        //同期转入ICU患者
        List<SearchOperFormBean> toICUQmOperList = qcManagerService.searchQmIcuNum(searchFormBean);
        List<SearchOperFormBean> toICUJmOperList = qcManagerService.searchJmIcuNum(searchFormBean);
        
        //非计划转入ICU
        List<SearchOperFormBean> toICUQmFjhOperList = qcManagerService.searchQmFjgIcuNum(searchFormBean);
        toICUQmOperList.addAll(toICUJmOperList);
        int toICUOperTotal = 0;
        
        // 暂时做不了
        int nonPlanICUNum = 0;
        
        Map<String, String> vo = null;
        // 表格统计数据的list
        List operTableList = new ArrayList();
        if (toICUQmOperList != null && toICUQmOperList.size() > 0)
        {
            toICUOperTotal = toICUQmOperList.size();
            for (int i = 0; i < toICUQmOperList.size(); i++)
            {
                vo = new HashMap<String, String>();
                vo.put("行名", (i + 1) + "");
                vo.put(NPCOLUMN[0], toICUQmOperList.get(i).getName());
                vo.put(NPCOLUMN[1], toICUQmOperList.get(i).getSex());
                vo.put(NPCOLUMN[2], toICUQmOperList.get(i).getAge());
                vo.put(NPCOLUMN[3], toICUQmOperList.get(i).getHid());
                vo.put(NPCOLUMN[4], toICUQmOperList.get(i).getOperaDate());
                vo.put(NPCOLUMN[5], toICUQmOperList.get(i).getOperatorName());
                vo.put(NPCOLUMN[6], toICUQmOperList.get(i).getDesignedOptName());
                vo.put(NPCOLUMN[7], toICUQmOperList.get(i).getAnaesMethodName());
                vo.put(NPCOLUMN[8], toICUQmOperList.get(i).getAnesthetistName());
                vo.put(NPCOLUMN[9], toICUQmOperList.get(i).getCircunurseName());
                vo.put(NPCOLUMN[10], toICUQmOperList.get(i).getPlanTo());
                vo.put(NPCOLUMN[11], toICUQmOperList.get(i).getActualTo());
                operTableList.add(vo);
            }
        }
        
     // 表格统计数据的list
        List toICUQmFjhTableList = new ArrayList();
        if (toICUQmFjhOperList != null && toICUQmFjhOperList.size() > 0)
        {
        	nonPlanICUNum = toICUQmFjhOperList.size();
            for (int i = 0; i < toICUQmFjhOperList.size(); i++)
            {
                vo = new HashMap<String, String>();
                vo.put("行名", (i + 1) + "");
                vo.put(NPCOLUMN[0], toICUQmFjhOperList.get(i).getName());
                vo.put(NPCOLUMN[1], toICUQmFjhOperList.get(i).getSex());
                vo.put(NPCOLUMN[2], toICUQmFjhOperList.get(i).getAge());
                vo.put(NPCOLUMN[3], toICUQmFjhOperList.get(i).getHid());
                vo.put(NPCOLUMN[4], toICUQmFjhOperList.get(i).getOperaDate());
                vo.put(NPCOLUMN[5], toICUQmFjhOperList.get(i).getOperatorName());
                vo.put(NPCOLUMN[6], toICUQmFjhOperList.get(i).getDesignedOptName());
                vo.put(NPCOLUMN[7], toICUQmFjhOperList.get(i).getAnaesMethodName());
                vo.put(NPCOLUMN[8], toICUQmFjhOperList.get(i).getAnesthetistName());
                vo.put(NPCOLUMN[9], toICUQmFjhOperList.get(i).getCircunurseName());
                vo.put(NPCOLUMN[10], toICUQmFjhOperList.get(i).getPlanTo());
                vo.put(NPCOLUMN[11], toICUQmFjhOperList.get(i).getActualTo());
                toICUQmFjhTableList.add(vo);
            }
        }
        
        float rate = 0.00f;
        if (toICUOperTotal != 0)
        {
            rate = (float)nonPlanICUNum / toICUOperTotal;
        }
        DecimalFormat df = new DecimalFormat("0.000");
        BigDecimal b = new BigDecimal(df.format(rate));
        BigDecimal c = new BigDecimal(Double.valueOf(100));
        rate = b.multiply(c).setScale(1, BigDecimal.ROUND_HALF_UP).floatValue();
        
        resp.put("toICUOperTotal", toICUOperTotal);
        resp.put("nonPlanICUNum", nonPlanICUNum);
        resp.put("operTableList", operTableList);
        resp.put("toICUQmFjhTableList", toICUQmFjhTableList);
        resp.put("columnAry", NPCOLUMN);
        resp.put("rate", rate);
        logger.info("end searchNonPlanToICURate");
        return resp.getJsonStr();
    }
    
    /**
     * 查询麻醉开始后24小时内死亡率
     * 
     * @param searchConditionFormBean
     * @return
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping(value = "/search24HourDealthRate")
    @ResponseBody
    @ApiOperation(value="查询麻醉开始后24小时内死亡率",httpMethod="POST",notes="查询麻醉开始后24小时内死亡率")
    public String search24HourDealthRate(@ApiParam(name="searchConditionFormBean", value ="查询参数") @RequestBody SearchConditionFormBean searchConditionFormBean) {
    	logger.info("begin search24HourDealthRate");
        ResponseValue resp = new ResponseValue();
        Map<String, String> timeMap = new HashMap<String, String>();
        setTimeMap(searchConditionFormBean, resp, timeMap);
        if (!"1".equals(resp.getResultCode())) {
            resp.setResultCode("10000000");
            resp.setResultMessage("系统错误，请与系统管理员联系!");
            return resp.getJsonStr();
        }
        
        SearchFormBean searchFormBean = new SearchFormBean();
        searchFormBean.setStartTime(timeMap.get("startTime"));
        searchFormBean.setEndTime(timeMap.get("endTime"));
        if (StringUtils.isBlank(searchConditionFormBean.getBeid())) {
        	searchFormBean.setBeid(getBeid());
		}else {
			searchFormBean.setBeid(searchConditionFormBean.getBeid());
		}
        
        int operTotal = 0;
        List<SearchOperFormBean> operList = qcManagerService.searchOperByCondition(searchFormBean);
        List<SearchOperFormBean> hourDeathList = qcManagerService.search24HourDeathRate(searchFormBean);
        
        //将死亡时间赋值给operList
        for (SearchOperFormBean searchOperFormBean : hourDeathList) {
			for (SearchOperFormBean operObj : operList) {
				if(searchOperFormBean.getRegOptId().equals(operObj.getRegOptId())){
					operObj.setDeathTime(searchOperFormBean.getDeathTime());
					operObj.setIsDeath(searchOperFormBean.getIsDeath());
				}
			}
		}
        
        // 暂时做不了
        int dealthNum = 0;
        
        Map<String, String> vo = null;
        // 表格统计数据的list
        List operTableList = new ArrayList();
        if (operList != null && operList.size() > 0)
        {
            operTotal = operList.size();
            for (int i = 0; i < operList.size(); i++)
            {
                vo = new HashMap<String, String>();
                vo.put("行名", (i + 1) + "");
                vo.put(DHCOLUMN[0], operList.get(i).getName());
                vo.put(DHCOLUMN[1], operList.get(i).getSex());
                vo.put(DHCOLUMN[2], operList.get(i).getAge());
                vo.put(DHCOLUMN[3], operList.get(i).getHid());
                vo.put(DHCOLUMN[4], operList.get(i).getOperaDate());
                vo.put(DHCOLUMN[5], operList.get(i).getOperatorName());
                vo.put(DHCOLUMN[6], operList.get(i).getDesignedOptName());
                vo.put(DHCOLUMN[7], operList.get(i).getAnaesMethodName());
                vo.put(DHCOLUMN[8], operList.get(i).getAnesthetistName());
                vo.put(DHCOLUMN[9], operList.get(i).getCircunurseName());
                vo.put(DHCOLUMN[10], operList.get(i).getAnaesStartTime());
                vo.put(DHCOLUMN[11], operList.get(i).getIsDeath());
                vo.put(DHCOLUMN[12], operList.get(i).getDeathTime());
                operTableList.add(vo);
            }
        }
        
     // 表格统计数据的list
        List toHourDeathTableList = new ArrayList();
        if (hourDeathList != null && hourDeathList.size() > 0)
        {
        	dealthNum = hourDeathList.size();
            for (int i = 0; i < hourDeathList.size(); i++)
            {
                vo = new HashMap<String, String>();
                vo.put("行名", (i + 1) + "");
                vo.put(DHCOLUMN[0], hourDeathList.get(i).getName());
                vo.put(DHCOLUMN[1], hourDeathList.get(i).getSex());
                vo.put(DHCOLUMN[2], hourDeathList.get(i).getAge());
                vo.put(DHCOLUMN[3], hourDeathList.get(i).getHid());
                vo.put(DHCOLUMN[4], hourDeathList.get(i).getOperaDate());
                vo.put(DHCOLUMN[5], hourDeathList.get(i).getOperatorName());
                vo.put(DHCOLUMN[6], hourDeathList.get(i).getDesignedOptName());
                vo.put(DHCOLUMN[7], hourDeathList.get(i).getAnaesMethodName());
                vo.put(DHCOLUMN[8], hourDeathList.get(i).getAnesthetistName());
                vo.put(DHCOLUMN[9], hourDeathList.get(i).getCircunurseName());
                vo.put(DHCOLUMN[10], hourDeathList.get(i).getAnaesStartTime());
                vo.put(DHCOLUMN[11], hourDeathList.get(i).getIsDeath());
                vo.put(DHCOLUMN[12], hourDeathList.get(i).getDeathTime());
                toHourDeathTableList.add(vo);
            }
        }
        
        float rate = 0.00f;
        if (operTotal != 0)
        {
            rate = (float)dealthNum / operTotal;
        }
        DecimalFormat df = new DecimalFormat("0.000");
        BigDecimal b = new BigDecimal(df.format(rate));
        BigDecimal c = new BigDecimal(Double.valueOf(100));
        rate = b.multiply(c).setScale(1, BigDecimal.ROUND_HALF_UP).floatValue();
        
        resp.put("operTotal", operTotal);
        resp.put("dealthNum", dealthNum);
        resp.put("operTableList", operTableList);
        resp.put("toHourDeathTableList", toHourDeathTableList);
        resp.put("columnAry", DHCOLUMN);
        resp.put("rate", rate);
        logger.info("end search24HourDealthRate");
        return resp.getJsonStr();
    }
    
    /**
     * 查询各ASA分级麻醉患者比例
     * 
     * @param searchConditionFormBean
     * @return
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping(value = "/searchASALevelRate")
    @ResponseBody
    @ApiOperation(value="各ASA分级麻醉患者比例",httpMethod="POST",notes="各ASA分级麻醉患者比例")
    public String searchASALevelRate(@ApiParam(name="searchConditionFormBean", value ="统计查询参数") @RequestBody SearchConditionFormBean searchConditionFormBean)
    {
        logger.info("begin searchASALevelRate");
        ResponseValue resp = new ResponseValue();
        Map<String, String> timeMap = new HashMap<String, String>();
        setTimeMap(searchConditionFormBean, resp, timeMap);
        if (!"1".equals(resp.getResultCode())) {
            resp.setResultCode("10000000");
            resp.setResultMessage("系统错误，请与系统管理员联系!");
            return resp.getJsonStr();
        }
        
        SearchFormBean searchFormBean = new SearchFormBean();
        searchFormBean.setStartTime(timeMap.get("startTime"));
        searchFormBean.setEndTime(timeMap.get("endTime"));
        if (StringUtils.isBlank(searchConditionFormBean.getBeid())) {
        	searchFormBean.setBeid(getBeid());
		}else {
			searchFormBean.setBeid(searchConditionFormBean.getBeid());
		}
        
        int operTotal = 0;
        List<SearchOperFormBean> operList = qcManagerService.searchOperByCondition(searchFormBean);
        
        Map<String,Integer> map = new HashMap<String,Integer>();
        Map<String,Float> rateMap = new HashMap<String,Float>();
        Map<String, String> vo = null;
        // 表格统计数据的list
        List asaTableList = new ArrayList();
        
        for (int i = 1; i<=5; i++)
        {
            searchFormBean.setAsaLevel(i + "");
            List<SearchOperFormBean> asaLevelList = qcManagerService.searchASALevelOper(searchFormBean);
            map.put(i + "级", 0);
            if (asaLevelList != null && asaLevelList.size() > 0)
            {
                map.put(i + "级", asaLevelList.size());
                for (int j = 0; j < asaLevelList.size(); j++)
                {
                    vo = new HashMap<String, String>();
                    vo.put("级别", i  + "级");
                    vo.put(COLUMN[0], asaLevelList.get(j).getName());
                    vo.put(COLUMN[1], asaLevelList.get(j).getSex());
                    vo.put(COLUMN[2], asaLevelList.get(j).getAge());
                    vo.put(COLUMN[3], asaLevelList.get(j).getHid());
                    vo.put(COLUMN[4], asaLevelList.get(j).getOperaDate());
                    vo.put(COLUMN[5], asaLevelList.get(j).getOperatorName());
                    vo.put(COLUMN[6], asaLevelList.get(j).getDesignedOptName());
                    vo.put(COLUMN[7], asaLevelList.get(j).getAnesthetistName());
                    asaTableList.add(vo);
                }
            }
        }
        
        searchFormBean.setIsLocalAnaes("1");
        List<SearchOperFormBean> localOperList = qcManagerService.searchOperByCondition(searchFormBean);
        if (localOperList != null && localOperList.size() > 0)
        {
            map.put("其他", localOperList.size());
            for (int j = 0; j < localOperList.size(); j++)
            {
                vo = new HashMap<String, String>();
                vo.put("级别", "其他");
                vo.put(COLUMN[0], localOperList.get(j).getName());
                vo.put(COLUMN[1], localOperList.get(j).getSex());
                vo.put(COLUMN[2], localOperList.get(j).getAge());
                vo.put(COLUMN[3], localOperList.get(j).getHid());
                vo.put(COLUMN[4], localOperList.get(j).getOperaDate());
                vo.put(COLUMN[5], localOperList.get(j).getOperatorName());
                vo.put(COLUMN[6], localOperList.get(j).getDesignedOptName());
                vo.put(COLUMN[7], localOperList.get(j).getAnesthetistName());
                asaTableList.add(vo);
            }
        }
        
        // 表格统计数据的list
        List operTableList = new ArrayList();
        if (operList != null && operList.size() > 0)
        {
            operTotal = operList.size();
            for (int i = 0; i < operList.size(); i++)
            {
                vo = new HashMap<String, String>();
                vo.put("行名", (i + 1) + "");
                vo.put(COLUMN[0], operList.get(i).getName());
                vo.put(COLUMN[1], operList.get(i).getSex());
                vo.put(COLUMN[2], operList.get(i).getAge());
                vo.put(COLUMN[3], operList.get(i).getHid());
                vo.put(COLUMN[4], operList.get(i).getOperaDate());
                vo.put(COLUMN[5], operList.get(i).getOperatorName());
                vo.put(COLUMN[6], operList.get(i).getDesignedOptName());
                vo.put(COLUMN[7], operList.get(i).getAnesthetistName());
                operTableList.add(vo);
            }
        }
        
        
        for (String key : map.keySet())
        {
            int total = map.get(key);
            float rate = 0.00f;
            if (operTotal != 0)
            {
                rate = (float)total / operTotal;
            }
            DecimalFormat df = new DecimalFormat("0.000");
            BigDecimal b = new BigDecimal(df.format(rate));
            BigDecimal c = new BigDecimal(Double.valueOf(100));
            rate = b.multiply(c).setScale(1, BigDecimal.ROUND_HALF_UP).floatValue();
            rateMap.put(key, rate);
        }
        
        resp.put("operTotal", operTotal);
        resp.put("operTableList", operTableList);
        resp.put("asaLevelTotal", map);
        resp.put("asaTableList", asaTableList);
        resp.put("columnAry", COLUMN);
        resp.put("rate", rateMap);
        logger.info("end searchASALevelRate");
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
     * 麻醉期间严重过敏反应发生率
     * <功能详细描述>
     * @param searchConditionFormBean
     * @return
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping(value = "/searchAnesAllergicRecatRate")
    @ResponseBody
    @ApiOperation(value="麻醉期间严重过敏反应发生率",httpMethod="POST",notes="麻醉期间严重过敏反应发生率")
    public String searchAnesAllergicRecatRate(@ApiParam(name="searchConditionFormBean", value ="查询参数") @RequestBody SearchConditionFormBean searchConditionFormBean) {
        logger.info("begin searchAnesAllergicRecatRate");
        ResponseValue resp = new ResponseValue();
        Map<String,String> timeMap = new HashMap<String,String>();
        setTimeMap(searchConditionFormBean, resp, timeMap);
        if (!"1".equals(resp.getResultCode())) {
            resp.setResultCode("10000000");
            resp.setResultMessage("系统错误，请与系统管理员联系!");
            return resp.getJsonStr();
        }
        /**
         * 全麻气管插管拔管后声音嘶哑发生例数
         */
        SearchFormBean searchFormBean = new SearchFormBean();
        searchFormBean.setStartTime(timeMap.get("startTime"));
        searchFormBean.setEndTime(timeMap.get("endTime"));
        if (StringUtils.isBlank(searchConditionFormBean.getBeid())) {
        	searchFormBean.setBeid(getBeid());
		}else {
			searchFormBean.setBeid(searchConditionFormBean.getBeid());
		}
        //在麻醉记录单二中有循环衰竭 circulatFailure 、严重气道反应 airwayResp、明显皮疹 obviousRash、肾上腺素 adrenaline
        List<SearchOperFormBean> allergicReactionList = qcManagerService.searchOptAllergicReactionList(searchFormBean);
        /**
         * 同期麻醉总例数
         */
        List<SearchOperFormBean> anaesList = qcManagerService.searchOperByCondition(searchFormBean);
        
        for (SearchOperFormBean searchOperFormBean : allergicReactionList) {
        	for (SearchOperFormBean anaObj : anaesList) {
    			if(searchOperFormBean.getRegOptId().equals(anaObj.getRegOptId())){
    				anaObj.setAllergicReactionTime(anaObj.getAllergicReactionTime());
    				anaObj.setContents(anaObj.getContents());
    			}
    		}
		}
        
        
        int allergicReactionTotal = allergicReactionList.size();
        resp.put("allergicReactionList", allergicReactionList);
        resp.put("allergicReactionTotal", allergicReactionTotal);
        
        int anaesTotal = anaesList.size();
        resp.put("anaesList", anaesList);
        resp.put("anaesTotal", anaesTotal);
        
        float rate = 0.000f;
        if (allergicReactionTotal != 0 && anaesTotal != 0)
        {
            rate = (float)allergicReactionTotal / anaesTotal;
        }
        DecimalFormat df = new DecimalFormat("0.0000");
        BigDecimal b = new BigDecimal(df.format(rate));
        BigDecimal c = new BigDecimal(Double.valueOf(1000));
        
        resp.put("rate", b.multiply(c).setScale(1, BigDecimal.ROUND_HALF_UP).floatValue());
        
        logger.info("end searchAnesAllergicRecatRate");
        return resp.getJsonStr();
    }
    
    
    /** 
     * 麻醉开始后24小时内心跳骤停率
     * <功能详细描述>
     * @param searchConditionFormBean
     * @return
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping(value = "/searchAnes24hrCardiacArrestRate")
    @ResponseBody
    @ApiOperation(value="麻醉开始后24小时内心跳骤停率",httpMethod="POST",notes="麻醉开始后24小时内心跳骤停率")
    public String searchAnes24hrCardiacArrestRate(@ApiParam(name="searchConditionFormBean", value ="查询参数") @RequestBody SearchConditionFormBean searchConditionFormBean) {
		logger.info("begin searchAnes24hrCardiacArrestRate");
		ResponseValue resp = new ResponseValue();
		Map<String, String> timeMap = new HashMap<String, String>();
		setTimeMap(searchConditionFormBean, resp, timeMap);
		if (!"1".equals(resp.getResultCode())) {
			resp.setResultCode("10000000");
			resp.setResultMessage("系统错误，请与系统管理员联系!");
			return resp.getJsonStr();
		}

		SearchFormBean searchFormBean = new SearchFormBean();
		searchFormBean.setStartTime(timeMap.get("startTime"));
		searchFormBean.setEndTime(timeMap.get("endTime"));
        if (StringUtils.isBlank(searchConditionFormBean.getBeid())) {
        	searchFormBean.setBeid(getBeid());
		}else {
			searchFormBean.setBeid(searchConditionFormBean.getBeid());
		}

		int operTotal = 0;
		List<SearchOperFormBean> operList = qcManagerService.searchOperByCondition(searchFormBean);
		List<SearchOperFormBean> hrCardiacArrestList = qcManagerService.searchAnes24hrCardiacArrest(searchFormBean);

		// 将心跳骤停时间赋值给operList
		for (SearchOperFormBean searchOperFormBean : hrCardiacArrestList) {
			for (SearchOperFormBean operObj : operList) {
				if (searchOperFormBean.getRegOptId().equals(
						operObj.getRegOptId())) {
					operObj.setCardiacArrestTime(searchOperFormBean.getCardiacArrestTime());
					operObj.setCardiacArrest(searchOperFormBean.getCardiacArrest());
				}
			}
		}

		// 暂时做不了
		int hrCardiacArrestNum = 0;

		Map<String, String> vo = null;
		// 表格统计数据的list
		List operTableList = new ArrayList();
		if (operList != null && operList.size() > 0) {
			operTotal = operList.size();
			for (int i = 0; i < operList.size(); i++) {
				vo = new HashMap<String, String>();
				vo.put("行名", (i + 1) + "");

				vo.put(CACOLUMN[0], operList.get(i).getName());
				vo.put(CACOLUMN[1], operList.get(i).getSex());
				vo.put(CACOLUMN[2], operList.get(i).getAge());
				vo.put(CACOLUMN[3], operList.get(i).getHid());
				vo.put(CACOLUMN[4], operList.get(i).getOperaDate());
				vo.put(CACOLUMN[5], operList.get(i).getOperatorName());
				vo.put(CACOLUMN[6], operList.get(i).getDesignedOptName());
				vo.put(CACOLUMN[7], operList.get(i).getAnaesMethodName());
				vo.put(CACOLUMN[8], operList.get(i).getAnesthetistName());
				vo.put(CACOLUMN[9], operList.get(i).getCircunurseName());
				vo.put(CACOLUMN[10], operList.get(i).getAnaesStartTime());
				vo.put(CACOLUMN[11], operList.get(i).getCardiacArrest());
				vo.put(CACOLUMN[12], operList.get(i).getCardiacArrestTime());
				operTableList.add(vo);
			}
		}

		// 表格统计数据的list
		List toCardiacArrestTableList = new ArrayList();
		if (hrCardiacArrestList != null && hrCardiacArrestList.size() > 0) {
			hrCardiacArrestNum = hrCardiacArrestList.size();
			for (int i = 0; i < hrCardiacArrestList.size(); i++) {
				vo = new HashMap<String, String>();
				vo.put("行名", (i + 1) + "");
				vo.put(CACOLUMN[0], hrCardiacArrestList.get(i).getName());
				vo.put(CACOLUMN[1], hrCardiacArrestList.get(i).getSex());
				vo.put(CACOLUMN[2], hrCardiacArrestList.get(i).getAge());
				vo.put(CACOLUMN[3], hrCardiacArrestList.get(i).getHid());
				vo.put(CACOLUMN[4], hrCardiacArrestList.get(i).getOperaDate());
				vo.put(CACOLUMN[5], hrCardiacArrestList.get(i).getOperatorName());
				vo.put(CACOLUMN[6], hrCardiacArrestList.get(i).getDesignedOptName());
				vo.put(CACOLUMN[7], hrCardiacArrestList.get(i).getAnaesMethodName());
				vo.put(CACOLUMN[8], hrCardiacArrestList.get(i).getAnesthetistName());
				vo.put(CACOLUMN[9], hrCardiacArrestList.get(i).getCircunurseName());
				vo.put(CACOLUMN[10], hrCardiacArrestList.get(i).getAnaesStartTime());
				vo.put(CACOLUMN[11], hrCardiacArrestList.get(i).getCardiacArrest());
				vo.put(CACOLUMN[12], hrCardiacArrestList.get(i).getCardiacArrestTime());
				toCardiacArrestTableList.add(vo);
			}
		}

		float rate = 0.00f;
		if (operTotal != 0) {
			rate = (float) hrCardiacArrestNum / operTotal;
		}
		DecimalFormat df = new DecimalFormat("0.000");
		BigDecimal b = new BigDecimal(df.format(rate));
		BigDecimal c = new BigDecimal(Double.valueOf(100));
		rate = b.multiply(c).setScale(1, BigDecimal.ROUND_HALF_UP).floatValue();

		resp.put("operTotal", operTotal);
		resp.put("hrCardiacArrestNum", hrCardiacArrestNum);
		resp.put("operTableList", operTableList);
		resp.put("toCardiacArrestTableList", toCardiacArrestTableList);
		resp.put("columnAry", CACOLUMN);
		resp.put("rate", rate);
		logger.info("end searchAnes24hrCardiacArrestRate");
		return resp.getJsonStr();
	}

    /**
     * 查询麻醉后监测PACU转出延迟率
     * 
     * @param searchConditionFormBean
     * @return
     * @see [类、类#方法、类#成员]
     */
    
    @RequestMapping(value = "/searchAnaesPacuDelayRate")
    @ResponseBody
    @ApiOperation(value="查询麻醉后监测PACU转出延迟率",httpMethod="POST",notes="查询麻醉后监测PACU转出延迟率")
    public String searchAnaesPacuDelayRate(@ApiParam(name="searchConditionFormBean", value ="查询参数") @RequestBody SearchConditionFormBean searchConditionFormBean) {
        logger.info("begin searchAnaesPacuDelayRate");
        ResponseValue resp = new ResponseValue();
        Map<String, String> timeMap = new HashMap<String, String>();
        setTimeMap(searchConditionFormBean, resp, timeMap);
        if (!"1".equals(resp.getResultCode())) {
            resp.setResultCode("10000000");
            resp.setResultMessage("系统错误，请与系统管理员联系!");
            return resp.getJsonStr();
        }
        
        SearchFormBean searchFormBean = new SearchFormBean();
        searchFormBean.setStartTime(timeMap.get("startTime"));
        searchFormBean.setEndTime(timeMap.get("endTime"));
        if (StringUtils.isBlank(searchConditionFormBean.getBeid())) {
        	searchFormBean.setBeid(getBeid());
		}else {
			searchFormBean.setBeid(searchConditionFormBean.getBeid());
		}

        List<SearchOperFormBean> operList = qcManagerService.searchEnterPacuNum(searchFormBean);
        List<SearchOperFormBean> pacuDelayList = qcManagerService.searchAnaesPacuDelayRate(searchFormBean);
        
        // 
        int pacuDelayNum = 0;
        int operTotal = 0;
        
        Map<String, String> vo = null;
        // 表格统计数据的list
        List operTableList = new ArrayList();
        if (operList != null && operList.size() > 0)
        {
            operTotal = operList.size();
            for (int i = 0; i < operList.size(); i++)
            {
                vo = new HashMap<String, String>();
                vo.put("行名", (i + 1) + "");
                vo.put(PACUCOLUMN[0], operList.get(i).getName());
                vo.put(PACUCOLUMN[1], operList.get(i).getSex());
                vo.put(PACUCOLUMN[2], operList.get(i).getAge());
                vo.put(PACUCOLUMN[3], operList.get(i).getHid());
                vo.put(PACUCOLUMN[4], operList.get(i).getOperaDate());
                vo.put(PACUCOLUMN[5], operList.get(i).getOperatorName());
                vo.put(PACUCOLUMN[6], operList.get(i).getDesignedOptName());
                vo.put(PACUCOLUMN[7], operList.get(i).getAnaesMethodName());
                vo.put(PACUCOLUMN[8], operList.get(i).getAnesthetistName());
                vo.put(PACUCOLUMN[9], operList.get(i).getCircunurseName());
                vo.put(PACUCOLUMN[10], operList.get(i).getEnterTime());
                vo.put(PACUCOLUMN[11], operList.get(i).getExitTime());
                operTableList.add(vo);
            }
        }
        
        // 表格统计数据的list
        List pacuDelayTableList = new ArrayList();
        if (pacuDelayList != null && pacuDelayList.size() > 0)
        {
        	pacuDelayNum = pacuDelayList.size();
            for (int i = 0; i < pacuDelayList.size(); i++)
            {
                vo = new HashMap<String, String>();
                vo.put("行名", (i + 1) + "");
                vo.put(PACUCOLUMN[0], pacuDelayList.get(i).getName());
                vo.put(PACUCOLUMN[1], pacuDelayList.get(i).getSex());
                vo.put(PACUCOLUMN[2], pacuDelayList.get(i).getAge());
                vo.put(PACUCOLUMN[3], pacuDelayList.get(i).getHid());
                vo.put(PACUCOLUMN[4], pacuDelayList.get(i).getOperaDate());
                vo.put(PACUCOLUMN[5], pacuDelayList.get(i).getOperatorName());
                vo.put(PACUCOLUMN[6], pacuDelayList.get(i).getDesignedOptName());
                vo.put(PACUCOLUMN[7], pacuDelayList.get(i).getAnaesMethodName());
                vo.put(PACUCOLUMN[8], pacuDelayList.get(i).getAnesthetistName());
                vo.put(PACUCOLUMN[9], pacuDelayList.get(i).getCircunurseName());
                vo.put(PACUCOLUMN[10], pacuDelayList.get(i).getEnterTime());
                vo.put(PACUCOLUMN[11], pacuDelayList.get(i).getExitTime());
                pacuDelayTableList.add(vo);
            }
        }
        
        float rate = 0.00f;
        if (operTotal != 0)
        {
            rate = (float)pacuDelayNum / operTotal;
        }
        DecimalFormat df = new DecimalFormat("0.0000");
        BigDecimal b = new BigDecimal(df.format(rate));
        BigDecimal c = new BigDecimal(Double.valueOf(1000));
        rate = b.multiply(c).setScale(1, BigDecimal.ROUND_HALF_UP).floatValue();
        
        resp.put("operTotal", operTotal);
        resp.put("pacuDelayNum", pacuDelayNum);
        resp.put("operTableList", operTableList);
        resp.put("operCancleTableList", pacuDelayTableList);
        resp.put("columnAry", PACUCOLUMN);
        resp.put("rate", rate);
        logger.info("end searchAnaesPacuDelayRate");
        return resp.getJsonStr();
    }

    /**
     * 查询入室低温率
     * 
     * @param searchConditionFormBean
     * @return
     * @see [类、类#方法、类#成员]
     */
    
    @RequestMapping(value = "/searchAnaesPacuLowTempRate")
    @ResponseBody
    @ApiOperation(value="查询PACU入室低温率",httpMethod="POST",notes="查询PACU入室低温率")
    public String searchAnaesPacuLowTempRate(@ApiParam(name="searchConditionFormBean", value ="查询参数") @RequestBody SearchConditionFormBean searchConditionFormBean)
    {
        logger.info("begin searchAnaesPacuLowTempRate");
        ResponseValue resp = new ResponseValue();
        Map<String, String> timeMap = new HashMap<String, String>();
        setTimeMap(searchConditionFormBean, resp, timeMap);
        if (!"1".equals(resp.getResultCode()))
        {
            resp.setResultCode("10000000");
            resp.setResultMessage("系统错误，请与系统管理员联系!");
            return resp.getJsonStr();
        }
        
        SearchFormBean searchFormBean = new SearchFormBean();
        searchFormBean.setStartTime(timeMap.get("startTime"));
        searchFormBean.setEndTime(timeMap.get("endTime"));

        List<SearchOperFormBean> operList = qcManagerService.searchEnterPacuNum(searchFormBean);
        List<SearchOperFormBean> pacuLowTmepList = qcManagerService.searchAnaesPacuLowTemp(searchFormBean);
        
        
        // 
        int pacuLowTempNum = 0;
        int operTotal = 0;
        
        Map<String, String> vo = null;
        // 表格统计数据的list
        List operTableList = new ArrayList();
        if (operList != null && operList.size() > 0)
        {
            operTotal = operList.size();
            for (int i = 0; i < operList.size(); i++)
            {
                vo = new HashMap<String, String>();
                vo.put("行名", (i + 1) + "");
                
                vo.put(LTCOLUMN[0], operList.get(i).getName());
                vo.put(LTCOLUMN[1], operList.get(i).getSex());
                vo.put(LTCOLUMN[2], operList.get(i).getAge());
                vo.put(LTCOLUMN[3], operList.get(i).getHid());
                vo.put(LTCOLUMN[4], operList.get(i).getOperaDate());
                vo.put(LTCOLUMN[5], operList.get(i).getOperatorName());
                vo.put(LTCOLUMN[6], operList.get(i).getDesignedOptName());
                vo.put(LTCOLUMN[7], operList.get(i).getAnaesMethodName());
                vo.put(LTCOLUMN[8], operList.get(i).getAnesthetistName());
                vo.put(LTCOLUMN[9], operList.get(i).getCircunurseName());
                vo.put(LTCOLUMN[10], operList.get(i).getEnterTime());
                vo.put(LTCOLUMN[11], operList.get(i).getEnterTemp());
                vo.put(LTCOLUMN[12], operList.get(i).getExitTime());
                operTableList.add(vo);
            }
        }
        
        // 表格统计数据的list
        List pacuLowTempTableList = new ArrayList();
        if (pacuLowTmepList != null && pacuLowTmepList.size() > 0)
        {
        	pacuLowTempNum = pacuLowTmepList.size();
            for (int i = 0; i < pacuLowTmepList.size(); i++)
            {
                vo = new HashMap<String, String>();
                vo.put("行名", (i + 1) + "");
                vo.put(LTCOLUMN[0], pacuLowTmepList.get(i).getName());
                vo.put(LTCOLUMN[1], pacuLowTmepList.get(i).getSex());
                vo.put(LTCOLUMN[2], pacuLowTmepList.get(i).getAge());
                vo.put(LTCOLUMN[3], pacuLowTmepList.get(i).getHid());
                vo.put(LTCOLUMN[4], pacuLowTmepList.get(i).getOperaDate());
                vo.put(LTCOLUMN[5], pacuLowTmepList.get(i).getOperatorName());
                vo.put(LTCOLUMN[6], pacuLowTmepList.get(i).getDesignedOptName());
                vo.put(LTCOLUMN[7], pacuLowTmepList.get(i).getAnaesMethodName());
                vo.put(LTCOLUMN[8], pacuLowTmepList.get(i).getAnesthetistName());
                vo.put(LTCOLUMN[9], pacuLowTmepList.get(i).getCircunurseName());
                vo.put(LTCOLUMN[10], pacuLowTmepList.get(i).getEnterTime());
                vo.put(LTCOLUMN[11], pacuLowTmepList.get(i).getEnterTemp());
                vo.put(LTCOLUMN[12], pacuLowTmepList.get(i).getExitTime());
                pacuLowTempTableList.add(vo);
            }
        }
        
        float rate = 0.00f;
        if (operTotal != 0)
        {
            rate = (float)pacuLowTempNum / operTotal;
        }
        DecimalFormat df = new DecimalFormat("0.000");
        BigDecimal b = new BigDecimal(df.format(rate));
        BigDecimal c = new BigDecimal(Double.valueOf(100));
        rate = b.multiply(c).setScale(1, BigDecimal.ROUND_HALF_UP).floatValue();
        
        
        resp.put("operTotal", operTotal);
        resp.put("pacuLowTempNum", pacuLowTempNum);
        resp.put("operTableList", operTableList);
        resp.put("pacuLowTempTableList", pacuLowTempTableList);
        resp.put("columnAry", LTCOLUMN);
        resp.put("rate", rate);
        logger.info("end searchAnaesPacuLowTempRate");
        return resp.getJsonStr();
    }

    /** 
     * 非计划二次气管插管率
     * <功能详细描述>
     * @param searchConditionFormBean
     * @return
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping(value = "/searchAnesSecondIntubatRate")
    @ResponseBody
    @ApiOperation(value="非计划二次气管插管率",httpMethod="POST",notes="非计划二次气管插管率")
    public String searchAnesSecondIntubatRate(@ApiParam(name="searchConditionFormBean", value ="查询参数") @RequestBody SearchConditionFormBean searchConditionFormBean) {
        logger.info("begin searchAnesSecondIntubatRate");
        ResponseValue resp = new ResponseValue();
        Map<String,String> timeMap = new HashMap<String,String>();
        setTimeMap(searchConditionFormBean, resp, timeMap);
        if (!"1".equals(resp.getResultCode())) {
            resp.setResultCode("10000000");
            resp.setResultMessage("系统错误，请与系统管理员联系!");
            return resp.getJsonStr();
        }
        /**
         * 非计划二次气管插管患者数
         */
        SearchFormBean searchFormBean = new SearchFormBean();
        searchFormBean.setStartTime(timeMap.get("startTime"));
        searchFormBean.setEndTime(timeMap.get("endTime"));
        if (StringUtils.isBlank(searchConditionFormBean.getBeid())) {
        	searchFormBean.setBeid(getBeid());
		}else {
			searchFormBean.setBeid(searchConditionFormBean.getBeid());
		}
        List<SearchOperFormBean> secondIntubatList = qcManagerService.searchAnesSecondIntubatList(searchFormBean);
        /**
         *同期术后气管插管拔除患者总数
         */
        List<SearchOperFormBean> extubatList = qcManagerService.searchAnesExtubatList(searchFormBean);
        
        int secondIntubatTotal = secondIntubatList.size();
        resp.put("secondIntubatList", secondIntubatList);
        resp.put("secondIntubatTotal", secondIntubatTotal);
        
        int extubatTotal = extubatList.size();
        resp.put("extubatList", extubatList);
        resp.put("extubatTotal", extubatTotal);
        
        float rate = 0.00f;
        if (secondIntubatTotal != 0 && extubatTotal != 0)
        {
            rate = (float)secondIntubatTotal / extubatTotal;
        }
        DecimalFormat df = new DecimalFormat("0.000");
        BigDecimal b = new BigDecimal(df.format(rate));
        BigDecimal c = new BigDecimal(Double.valueOf(100));
        
        resp.put("rate", b.multiply(c).setScale(1, BigDecimal.ROUND_HALF_UP).floatValue());
        
        logger.info("end searchAnesSecondIntubatRate");
        return resp.getJsonStr();
    }
    
    /** 
     * 麻醉期间严重过敏反应发生率
     * <功能详细描述>
     * @param searchConditionFormBean
     * @return
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping(value = "/searchAnesAllergicRate")
    @ResponseBody
    public String searchAnesAllergicRate(@RequestBody SearchConditionFormBean searchConditionFormBean)
    {
        logger.info("begin searchAnesAllergicRate");
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
        
        List<SearchOperFormBean> operList = qcManagerService.searchOperByCondition(searchFormBean);
        
        resp.put("operList", operList);
        resp.put("operTotal", operList.size());
        logger.info("end searchAnesAllergicRate");
        return resp.getJsonStr();
    }
    
    
    /** 
     * 中心静脉穿刺严重并发症发生率
     * <功能详细描述>
     * @param searchConditionFormBean
     * @return
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping(value = "/searchVenipunctyreRate")
    @ResponseBody
    @ApiOperation(value="中心静脉穿刺严重并发症发生率",httpMethod="POST",notes="中心静脉穿刺严重并发症发生率")
    public String searchVenipunctyreRate(@ApiParam(name="searchConditionFormBean", value ="查询参数") @RequestBody SearchConditionFormBean searchConditionFormBean) {
        logger.info("begin searchVenipunctyreRate");
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
        if (StringUtils.isBlank(searchConditionFormBean.getBeid())) {
        	searchFormBean.setBeid(getBeid());
		}else {
			searchFormBean.setBeid(searchConditionFormBean.getBeid());
		}
        
        List<SearchOperFormBean> operList = qcManagerService.searchVenipunctyreList(searchFormBean);
        
        resp.put("operList", operList);
        resp.put("operTotal", operList.size());
        logger.info("end searchVenipunctyreRate");
        return resp.getJsonStr();
    }
    
    
    /** 
     * 麻醉后新发昏迷发生率
     * <功能详细描述>
     * @param searchConditionFormBean
     * @return
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping(value = "/searchAnesComaRate")
    @ResponseBody
    @ApiOperation(value="麻醉后新发昏迷发生率",httpMethod="POST",notes="麻醉后新发昏迷发生率")
    public String searchAnesComaRate(@ApiParam(name="searchConditionFormBean", value ="查询参数") @RequestBody SearchConditionFormBean searchConditionFormBean) {
    	logger.info("begin searchAnesComaRate");
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
        if (StringUtils.isBlank(searchConditionFormBean.getBeid())) {
        	searchFormBean.setBeid(getBeid());
		}else {
			searchFormBean.setBeid(searchConditionFormBean.getBeid());
		}
        
        List<SearchOperFormBean> regOptList = qcManagerService.searchOperByCondition(searchFormBean);
        
        //持续昏迷超过24小时
        List<SearchOperFormBean> comaList = new ArrayList<SearchOperFormBean>();
        
        for (SearchOperFormBean searchOperFormBean : regOptList) {
        	//只有全麻患者才需要判断是否持续昏迷
        	if("0".equals(searchOperFormBean.getIsLocalAnaes())){
	        	//获取当前患者最后一条拔管记录
	        	searchFormBean = new SearchFormBean();
	        	searchFormBean.setDocId(searchOperFormBean.getDocId());
	        	searchFormBean.setCode("2"); //麻醉开始
	        	List<EvtAnaesEvent> anaesList = evtAnaesEventService.searchAnaeseventList(searchFormBean);
	        	EvtAnaesEvent anaesevent = null;
	        	if(anaesList.size()>0){
	        		anaesevent = anaesList.get(anaesList.size()-1);
	        	}
	        	if(anaesevent!=null){
	        		searchFormBean = new SearchFormBean();
	        		searchFormBean.setRegOptId(searchOperFormBean.getRegOptId());
	        		searchFormBean.setStartTime(DateUtils.formatDateTime(anaesevent.getOccurTime()));
	        		List<DocPostFollowSpinal> extList = qcManagerService.searchSpinalAneshrListInHours(searchFormBean,24);
	        		if(extList.size()>0){
	        			//术后访视单读取，当意识选项为昏迷时
	        			boolean flag = true;
	        			for (DocPostFollowSpinal postFollowSpinal : extList) {
	        				if((null == postFollowSpinal.getConsciousness()) || (null != postFollowSpinal.getConsciousness() && postFollowSpinal.getConsciousness().intValue()!=4)){
	        					flag = false;
	        					break;
	        				}
						}
	        			if(flag){
	        				searchOperFormBean.setComa("是");
	        				comaList.add(searchOperFormBean);
	        			}
	        		}
	        	}
        	}
		}
        Integer comaListTotal = comaList.size();
        resp.put("comaList", comaList);
        resp.put("comaListTotal", comaListTotal);
        
        Integer operTotal = regOptList.size();
        resp.put("operList", regOptList);
        resp.put("operTotal", operTotal);
        
        float rate = 0.000f;
        if (comaListTotal != 0 && operTotal != 0)
        {
            rate = (float)comaListTotal / operTotal;
        }
        DecimalFormat df = new DecimalFormat("0.0000");
        BigDecimal b = new BigDecimal(df.format(rate));
        BigDecimal c = new BigDecimal(Double.valueOf(1000));
        
        resp.put("rate", b.multiply(c).setScale(1, BigDecimal.ROUND_HALF_UP).floatValue());
        
        logger.info("end searchAnesComaRate");
        return resp.getJsonStr();
    }

    /** 
     * 椎管内麻醉后严重神经并发症发生率
     * <功能详细描述>
     * @param searchConditionFormBean
     * @return
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping(value = "/searchSpinalAnaesNeuralComplicatRate")
    @ResponseBody
    @ApiOperation(value="椎管内麻醉后严重神经并发症发生率",httpMethod="POST",notes="椎管内麻醉后严重神经并发症发生率")
    public String searchSpinalAnaesNeuralComplicatRate(@ApiParam(name="searchConditionFormBean", value ="查询参数") @RequestBody SearchConditionFormBean searchConditionFormBean) {
        logger.info("begin searchSpinalAnaesNeuralComplicatRate");
        ResponseValue resp = new ResponseValue();
        Map<String,String> timeMap = new HashMap<String,String>();
        setTimeMap(searchConditionFormBean, resp, timeMap);
        if (!"1".equals(resp.getResultCode())) {
            resp.setResultCode("10000000");
            resp.setResultMessage("系统错误，请与系统管理员联系!");
            return resp.getJsonStr();
        }
        
        /**
         * 同期椎管内麻醉总例数
         */
        SearchFormBean searchFormBean = new SearchFormBean();
        searchFormBean.setStartTime(timeMap.get("startTime"));
        searchFormBean.setEndTime(timeMap.get("endTime"));
        searchFormBean.setType("0");
        if (StringUtils.isBlank(searchConditionFormBean.getBeid())) {
        	searchFormBean.setBeid(getBeid());
		}else {
			searchFormBean.setBeid(searchConditionFormBean.getBeid());
		}
        List<SearchOperFormBean> spinalList = qcManagerService.searchOtherAnesList(searchFormBean); //椎管内全麻
        
        
        /**
         * 椎管内麻醉后严重神经并发症发生例数
         * 椎管内麻醉后严重神经并发症，是指在椎管内麻醉后新发的重度头痛、局部感觉异常（麻木或异感）、运动异常（肌无力甚至瘫痪）等，持续超过72小时
         */
        List<SearchOperFormBean> spinalComplicatList = new ArrayList<SearchOperFormBean>();
        for (SearchOperFormBean searchOperFormBean : spinalList) {
        	//获取当前患者最后一条拔管记录
        	searchFormBean = new SearchFormBean();
        	searchFormBean.setDocId(searchOperFormBean.getDocId());
        	searchFormBean.setCode("2"); //麻醉开始
        	List<EvtAnaesEvent> anaesList = evtAnaesEventService.searchAnaeseventList(searchFormBean);
        	EvtAnaesEvent anaesevent = null;
        	if(anaesList.size()>0){
        		anaesevent = anaesList.get(anaesList.size()-1);
        	}
        	if(anaesevent!=null){
        		searchFormBean = new SearchFormBean();
        		searchFormBean.setRegOptId(searchOperFormBean.getRegOptId());
        		searchFormBean.setStartTime(DateUtils.formatDateTime(anaesevent.getOccurTime()));
        		List<DocPostFollowSpinal> extList = qcManagerService.searchSpinalAneshrListInHours(searchFormBean,72);
        		if(extList.size()>0){
        			//重度头痛或 cognitObstacle 局部感觉异常或 limbsFeelImp 运动异常 limbsMoveImp  severeheadache
        			boolean flag = true;
        			String contents = "";
        			for (DocPostFollowSpinal postFollowSpinal : extList) {
        				if((null == postFollowSpinal.getCognitObstacle() || postFollowSpinal.getCognitObstacle()==0) 
        						&& (null == postFollowSpinal.getLeftLimbsFeelImp()|| postFollowSpinal.getLeftLimbsFeelImp()==0) 
        						&& (null == postFollowSpinal.getRightLimbsFeelImp() || postFollowSpinal.getRightLimbsFeelImp()==0)
        						&& (null == postFollowSpinal.getLeftMoveFeelImp()|| postFollowSpinal.getLeftMoveFeelImp()==0)
        						&& (null == postFollowSpinal.getRightMoveFeelImp() || postFollowSpinal.getRightMoveFeelImp()==0)){
        					flag = false;
        				}else{
        					if(postFollowSpinal.getSevereHeadache()==1){
        						contents+="重度头痛,";
        					}
        					if(postFollowSpinal.getLeftLimbsFeelImp()==1){
        						contents+="麻木,";
        					}
        					if(postFollowSpinal.getRightLimbsFeelImp()==1){
        						contents+="异感,";
        					}
        					if(postFollowSpinal.getLeftMoveFeelImp()==1){
        						contents+="肌无力,";
        					}
        					if(postFollowSpinal.getRightMoveFeelImp()==1){
        						contents+="瘫痪,";
        					}
        					contents = contents.substring(0, contents.length()-1);
        					searchOperFormBean.setContents(contents);
        					
        				}
					}
        			if(flag){
        				spinalComplicatList.add(searchOperFormBean);
        			}
        		}
        	}
		}
        
        
        int spinalComplicatTotal = spinalComplicatList.size();
        resp.put("spinalComplicatList", spinalComplicatList);
        resp.put("spinalComplicatTotal", spinalComplicatTotal);
        
        int spinalTotal = spinalList.size();
        resp.put("spinalList", spinalList);
        resp.put("spinalTotal", spinalTotal);
        
        float rate = 0.000f;
        if (spinalComplicatTotal != 0 && spinalTotal != 0)
        {
            rate = (float)spinalComplicatTotal / spinalTotal;
        }
        DecimalFormat df = new DecimalFormat("0.0000");
        BigDecimal b = new BigDecimal(df.format(rate));
        BigDecimal c = new BigDecimal(Double.valueOf(1000));
        
        resp.put("rate", b.multiply(c).setScale(1, BigDecimal.ROUND_HALF_UP).floatValue());
        
        logger.info("end searchSpinalAnaesNeuralComplicatRate");
        return resp.getJsonStr();
    }

    /** 
     * 全麻气管插管拔管后声音嘶哑发生率
     * <功能详细描述>
     * @param searchConditionFormBean
     * @return
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping(value = "/searchGenAnesHoarseRate")
    @ResponseBody
    @ApiOperation(value="全麻气管插管拔管后声音嘶哑发生率",httpMethod="POST",notes="全麻气管插管拔管后声音嘶哑发生率")
    public String searchGenAnesHoarseRate(@ApiParam(name="searchConditionFormBean", value ="查询参数") @RequestBody SearchConditionFormBean searchConditionFormBean) {
        logger.info("begin searchGenAnesHoarseRate");
        ResponseValue resp = new ResponseValue();
        Map<String,String> timeMap = new HashMap<String,String>();
        setTimeMap(searchConditionFormBean, resp, timeMap);
        if (!"1".equals(resp.getResultCode())) {
            resp.setResultCode("10000000");
            resp.setResultMessage("系统错误，请与系统管理员联系!");
            return resp.getJsonStr();
        }
        
        /**
         * 全麻气管插管拔管后声音嘶哑发生例数
         */
        SearchFormBean searchFormBean = new SearchFormBean();
        searchFormBean.setStartTime(timeMap.get("startTime"));
        searchFormBean.setEndTime(timeMap.get("endTime"));
        searchFormBean.setIsLocalAnaes("0"); //获取全麻数据
        if (StringUtils.isBlank(searchConditionFormBean.getBeid())) {
        	searchFormBean.setBeid(getBeid());
		}else {
			searchFormBean.setBeid(searchConditionFormBean.getBeid());
		}
        
        List<SearchOperFormBean> regOptList = qcManagerService.searchOperByCondition(searchFormBean);
        List<SearchOperFormBean> extubatList = new ArrayList<SearchOperFormBean>();
        for (SearchOperFormBean searchOperFormBean : regOptList) {
        	
        	//获取当前患者最后一条拔管记录
        	searchFormBean = new SearchFormBean();
        	searchFormBean.setDocId(searchOperFormBean.getDocId());
        	searchFormBean.setCode("6"); //气管拔管率
        	List<EvtAnaesEvent> anaesList = evtAnaesEventService.searchAnaeseventList(searchFormBean);
        	EvtAnaesEvent anaesevent = null;
        	if(anaesList.size()>0){
        		anaesevent = anaesList.get(anaesList.size()-1);
        	}
        	if(anaesevent!=null){
        		searchFormBean = new SearchFormBean();
        		searchFormBean.setRegOptId(searchOperFormBean.getRegOptId());
        		searchFormBean.setStartTime(DateUtils.formatDateTime(anaesevent.getOccurTime()));
        		List<DocPostFollowGeneral> extList = qcManagerService.searchExtubat72hrHoarseList(searchFormBean);
        		if(extList.size()>0){
        			Integer hoarse = extList.get(0).getHoarse();
        			if(null !=hoarse && hoarse.intValue()==1){
        				searchOperFormBean.setHoarse("是");
        				extubatList.add(searchOperFormBean);
        			}
        		}
        	}
		}
        /**
         * 同期全麻气管插管总例数
         */
        List<SearchOperFormBean> tubesList = new ArrayList<SearchOperFormBean>();
        
        for (SearchOperFormBean searchOperFormBean : regOptList) {
        	//获取当前患者最后一条拔管记录
        	searchFormBean = new SearchFormBean();
        	searchFormBean.setDocId(searchOperFormBean.getDocId());
        	searchFormBean.setCode("3"); //气管插管
        	List<EvtAnaesEvent> anaesList = evtAnaesEventService.searchAnaeseventList(searchFormBean);
        	if(anaesList.size()>0){
        		tubesList.add(searchOperFormBean);
        	}
		}
        
        int extubatTotal = extubatList.size();
        resp.put("extubatList", extubatList);
        resp.put("extubatTotal", extubatTotal);
        
        int tubesTotal = tubesList.size();
        resp.put("tubesList", tubesList);
        resp.put("tubesTotal", tubesTotal);
        
        float rate = 0.000f;
        if (extubatTotal != 0 && tubesTotal != 0) {
            rate = (float)extubatTotal / tubesTotal;
        }
        DecimalFormat df = new DecimalFormat("0.0000");
        BigDecimal b = new BigDecimal(df.format(rate));
        BigDecimal c = new BigDecimal(Double.valueOf(1000));
        
        resp.put("rate", b.multiply(c).setScale(1, BigDecimal.ROUND_HALF_UP).floatValue());
        
        logger.info("end searchGenAnesHoarseRate");
        return resp.getJsonStr();
    }
    
    /** 
     * 术中自体血输注率
     * <功能详细描述>
     * @param searchConditionFormBean
     * @return
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping(value = "/searchAutograftBloodTrans400mlInfo")
    @ResponseBody
    @ApiOperation(value="术中自体血输注率",httpMethod="POST",notes="术中自体血输注率")
    public String searchAutograftBloodTrans400mlInfo(@ApiParam(name="searchConditionFormBean", value ="统计查询参数") @RequestBody SearchConditionFormBean searchConditionFormBean)
    {
        logger.info("begin searchAutograftBloodTrans400mlInfo");
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
        if (StringUtils.isBlank(searchConditionFormBean.getBeid())) {
        	searchFormBean.setBeid(getBeid());
		}else {
			searchFormBean.setBeid(searchConditionFormBean.getBeid());
		}
        
        //自体血
        List<SearchOperFormBean> autograftList = qcManagerService.searchAutograftBloodTrans400mlInfo(searchFormBean);
        //输血
        List<SearchOperFormBean> operList = qcManagerService.searchBloodTrans400mlInfo(searchFormBean);
        
        
        int autograftTotal = autograftList.size();
        resp.put("autograftList", autograftList);
        resp.put("autograftTotal", autograftTotal);
        
        int operTotal = operList.size();
        resp.put("operList", operList);
        resp.put("operTotal", operTotal);
        
        float rate = 0.00f;
        if (autograftTotal != 0 && operTotal != 0)
        {
            rate = (float)autograftTotal / operTotal;
        }
        DecimalFormat df = new DecimalFormat("0.000");
        BigDecimal b = new BigDecimal(df.format(rate));
        BigDecimal c = new BigDecimal(Double.valueOf(100));
        
        resp.put("rate", b.multiply(c).setScale(1, BigDecimal.ROUND_HALF_UP).floatValue());
        
        logger.info("end searchAutograftBloodTrans400mlInfo");
        return resp.getJsonStr();
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
                startTimeList.add(DateUtils.DateToString(DateUtils.addMonths(DateUtils.getFirstDayOfMonth(new Date()), -1)));
                endTimeList.add(DateUtils.DateToString(DateUtils.addMonths(DateUtils.getLastDayOfMonth(new Date()), -1)));
            }
            //最近两个月
            else if ("2".equals(searchConditionFormBean.getTimeRang()))
            {
                startTimeList.add(DateUtils.DateToString(DateUtils.addMonths(DateUtils.getFirstDayOfMonth(new Date()), -2)));
                endTimeList.add(DateUtils.DateToString(DateUtils.addMonths(DateUtils.getLastDayOfMonth(new Date()), -2)));
                startTimeList.add(DateUtils.DateToString(DateUtils.addMonths(DateUtils.getFirstDayOfMonth(new Date()), -1)));
                endTimeList.add(DateUtils.DateToString(DateUtils.addMonths(DateUtils.getLastDayOfMonth(new Date()), -1)));
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
                startTimeList.add(DateUtils.DateToString(DateUtils.addMonths(DateUtils.getFirstDayOfQuarter(new Date()), -3)));
                endTimeList.add(DateUtils.DateToString(DateUtils.addMonths(DateUtils.getLastDayOfQuarter(new Date()), -3)));
            }
            //最近两个季度
            else if ("2".equals(searchConditionFormBean.getTimeRang()))
            {
                startTimeList.add(DateUtils.DateToString(DateUtils.addMonths(DateUtils.getFirstDayOfQuarter(new Date()), -6)));
                endTimeList.add(DateUtils.DateToString(DateUtils.addMonths(DateUtils.getLastDayOfQuarter(new Date()), -6)));
                startTimeList.add(DateUtils.DateToString(DateUtils.addMonths(DateUtils.getFirstDayOfQuarter(new Date()), -3)));
                endTimeList.add(DateUtils.DateToString(DateUtils.addMonths(DateUtils.getLastDayOfQuarter(new Date()), -3)));
            }
            //最近三个季度
            else if ("3".equals(searchConditionFormBean.getTimeRang()))
            {
                startTimeList.add(DateUtils.DateToString(DateUtils.addMonths(DateUtils.getFirstDayOfQuarter(new Date()), -9)));
                endTimeList.add(DateUtils.DateToString(DateUtils.addMonths(DateUtils.getLastDayOfQuarter(new Date()), -9)));
                startTimeList.add(DateUtils.DateToString(DateUtils.addMonths(DateUtils.getFirstDayOfQuarter(new Date()), -6)));
                endTimeList.add(DateUtils.DateToString(DateUtils.addMonths(DateUtils.getLastDayOfQuarter(new Date()), -6)));
                startTimeList.add(DateUtils.DateToString(DateUtils.addMonths(DateUtils.getFirstDayOfQuarter(new Date()), -3)));
                endTimeList.add(DateUtils.DateToString(DateUtils.addMonths(DateUtils.getLastDayOfQuarter(new Date()), -3)));
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
}
