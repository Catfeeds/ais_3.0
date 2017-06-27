package com.digihealth.anesthesia.basedata.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.digihealth.anesthesia.basedata.formbean.BaseInfoQuery;
import com.digihealth.anesthesia.basedata.formbean.OperPeopleFormBean;
import com.digihealth.anesthesia.basedata.formbean.SystemSearchFormBean;
import com.digihealth.anesthesia.basedata.po.BasOperationPeople;
import com.digihealth.anesthesia.common.entity.ResponseValue;
import com.digihealth.anesthesia.common.web.BaseController;
import com.digihealth.anesthesia.sysMng.formbean.UserInfoFormBean;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

/**
 * 
 * Title: OperationPeopleController.java Description: 手术人员Controller
 * 
 * @author liukui
 * @created 2015-9-15 下午1:56:40
 */
@Controller
@RequestMapping(value = "/basedata")
@Api(value = "BasOperationPeopleController", description = "手术医生信息处理类")
public class BasOperationPeopleController extends BaseController
{
    
    @RequestMapping(value = "/getSelectOperPeopleList")
    @ResponseBody
    @ApiOperation(value = "查询手术医生信息列表", httpMethod = "POST", notes = "查询手术医生信息列表")
    public String getSelectOperPeopleList(@ApiParam(name="baseQuery", value ="系统查询参数") @RequestBody BaseInfoQuery baseQuery)
    {
        logger.info("begin getSelectOperPeopleList");
        ResponseValue resp = new ResponseValue();
        List<UserInfoFormBean> resultList = basOperationPeopleService.getSelectOperPeopleList(baseQuery);
        resp.put("resultList", resultList);
        logger.info("end getSelectOperPeopleList");
        return resp.getJsonStr();
    }
    
    @RequestMapping(value = "/getOperationPeopleList")
    @ResponseBody
    @ApiOperation(value = "查询手术医生信息列表", httpMethod = "POST", notes = "查询手术医生信息列表")
    public String getOperationPeopleList(@ApiParam(name="baseQuery", value ="系统查询参数") @RequestBody BaseInfoQuery baseQuery)
    {
        logger.info("begin getOperationPeopleList");
        ResponseValue resp = new ResponseValue();
        if(null == baseQuery)
        {
        	baseQuery = new BaseInfoQuery();
        }
        List<OperPeopleFormBean> resultList = basOperationPeopleService.findList(baseQuery);
        resp.put("resultList", resultList);
        logger.info("end getOperationPeopleList");
        return resp.getJsonStr();
    }
    
    /**
     * 
     * @discription 根据条件查询手术人员
     * @author liukui
     * @created 2015年12月3日 下午3:01:40
     * @param systemSearchFormBean
     * @return
     */
    @RequestMapping(value = "/queryOperationPeopleList")
    @ResponseBody
    @ApiOperation(value = "根据条件查询手术人员", httpMethod = "POST", notes = "根据条件查询手术人员")
    public String queryOperationPeopleList(@ApiParam(name="systemSearchFormBean", value ="系统查询参数") @RequestBody SystemSearchFormBean systemSearchFormBean)
    {
        logger.info("begin queryOperationPeopleList");
        ResponseValue resp = new ResponseValue();
        List<BasOperationPeople> resultList = basOperationPeopleService.queryOperationPeopleList(systemSearchFormBean);
        int total = basOperationPeopleService.queryOperationPeopleListTotal(systemSearchFormBean);
        resp.put("resultList", resultList);
        resp.put("total", total);
        logger.info("end queryOperationPeopleList");
        return resp.getJsonStr();
    }
    
    /**
     * 
     * @discription 查询单个手术人员
     * @author liukui
     * @created 2015年12月3日 下午3:01:54
     * @param dept
     * @return
     */
    @RequestMapping(value = "/queryOperationPeopleById")
    @ResponseBody
    @ApiOperation(value = "查询单个手术人员", httpMethod = "POST", notes = "查询单个手术人员")
    public String queryOperationPeopleById(@ApiParam(name="operationPeople", value ="手术人员对象") @RequestBody BasOperationPeople operationPeople)
    {
        logger.info("begin queryOperdefById");
        ResponseValue resp = new ResponseValue();
        BasOperationPeople resultDept =
            basOperationPeopleService.queryOperationPeopleById(operationPeople.getOperatorId());
        resp.put("operationPeople", resultDept);
        logger.info("end queryOperationPeopleById");
        return resp.getJsonStr();
    }
    
    /**
     * 
     * @discription 修改或者添加手术人员
     * @author liukui
     * @created 2015年12月3日 下午3:02:15
     * @param Operdef
     * @return
     */
    @RequestMapping(value = "/saveOperationPeople")
    @ResponseBody
    @ApiOperation(value = "修改或者添加手术人员", httpMethod = "POST", notes = "修改或者添加手术人员")
    public String saveOperationPeople(@ApiParam(name="operationPeople", value ="手术人员对象") @RequestBody BasOperationPeople operationPeople)
    {
        logger.info("begin saveOperationPeople");
        ResponseValue resp = new ResponseValue();
        basOperationPeopleService.saveOperationPeople(operationPeople);
        logger.info("end saveOperationPeople");
        return resp.getJsonStr();
    }
    
    /**
     * 
     * @discription 删除手术人员
     * @author liukui
     * @created 2015年12月3日 下午3:02:15
     * @param Operdef
     * @return
     */
    @RequestMapping(value = "/deleteOperationPeople")
    @ResponseBody
    @ApiOperation(value = "删除手术人员", httpMethod = "POST", notes = "删除手术人员")
    public String deleteOperationPeople(@ApiParam(name="operationPeopleIdList", value ="手术人员ID集合") @RequestBody List<String> operationPeopleIdList)
    {
        logger.info("begin deleteOperationPeople");
        ResponseValue resp = new ResponseValue();
        basOperationPeopleService.deleteOperationPeople(operationPeopleIdList);
        logger.info("end deleteOperationPeople");
        return resp.getJsonStr();
    }
    
}
