package com.digihealth.anesthesia.basedata.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.digihealth.anesthesia.basedata.formbean.SearchInventoryAndInOutFormbean;
import com.digihealth.anesthesia.basedata.formbean.SystemSearchFormBean;
import com.digihealth.anesthesia.basedata.po.BasInventory;
import com.digihealth.anesthesia.basedata.po.BasInOutInfo;
import com.digihealth.anesthesia.common.entity.ResponseValue;
import com.digihealth.anesthesia.common.web.BaseController;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

/**
 * 
 * Title: InventoryController.java Description: 库存
 * 
 * @author chengwang
 * @created 2015年12月15日 下午6:14:49
 */
@Controller
@RequestMapping(value = "/basedata")
@Api(value = "BasInventoryController", description = "库存处理类")
public class BasInventoryController extends BaseController
{
    
    @RequestMapping(value = "/searchInventory")
    @ResponseBody
    @ApiOperation(value = "根据条件查询库存信息", httpMethod = "POST", notes = "根据条件查询库存信息")
    public String searchInventory(@ApiParam(name = "systemSearchFormBean", value = "系统查询对象") @RequestBody SystemSearchFormBean systemSearchFormBean)
    {
        logger.info("begin searchInventory");
        ResponseValue resp = new ResponseValue();
        List<BasInventory> inventoryList = basInventoryService.searchInventory(systemSearchFormBean);
        int total = basInventoryService.searchInventoryTotal(systemSearchFormBean);
        resp.put("resultList", inventoryList);
        resp.put("total", total);
        
        logger.info("end searchInventory");
        return resp.getJsonStr();
    }
    
    /**
     * 
     * @param searchInventoryAndInOutFormbean
     * @return
     */
    @RequestMapping(value = "/searchOutAndInventory")
    @ResponseBody
    @ApiOperation(value = "查询出入量信息", httpMethod = "POST", notes = "查询出入量信息")
    public String searchOutAndInventory(@ApiParam(name = "searchInventoryAndInOutFormbean", value = "入量信息查询对象") @RequestBody SearchInventoryAndInOutFormbean searchInventoryAndInOutFormbean)
    {
        logger.info("begin searchOutAndInventory");
        ResponseValue resp = new ResponseValue();
        if ("S".equals(searchInventoryAndInOutFormbean.getType()))
        {
            BasInventory inventory =
                basInventoryService.searchInventoryById(searchInventoryAndInOutFormbean.getId() + "");
            resp.put("resultData", inventory);
            return resp.getJsonStr();
        }
        if ("O".equals(searchInventoryAndInOutFormbean.getType()))
        {
            BasInOutInfo inOutInfoResult = basInOutInfoService.searchInOutInfoById(searchInventoryAndInOutFormbean.getId());
            resp.put("resultData", inOutInfoResult);
            return resp.getJsonStr();
        }
        
        logger.info("end searchOutAndInventory");
        return resp.getJsonStr();
    }
    
}
