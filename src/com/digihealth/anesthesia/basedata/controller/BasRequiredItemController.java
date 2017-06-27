package com.digihealth.anesthesia.basedata.controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.digihealth.anesthesia.basedata.po.BasRequiredItem;
import com.digihealth.anesthesia.common.entity.ResponseValue;
import com.digihealth.anesthesia.common.web.BaseController;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

@Controller
@RequestMapping(value = "/basedata")
@Api(value = "BasRequiredItemController", description = "文书必选项处理类")
public class BasRequiredItemController extends BaseController
{
    @RequestMapping(value = "/searchRequiredItem")
    @ResponseBody
    @ApiOperation(value = "查询文书必选项", httpMethod = "POST", notes = "查询文书必选项")
    public String searchRequiredItem(@ApiParam(name = "map", value = "查询条件") @RequestBody Map map)
    {
        logger.info("begin searchRequiredItem");
        ResponseValue resp = new ResponseValue();
        List<BasRequiredItem> requiredItemList = basRequiredItemService.searchRequiredItem(map);
        resp.put("resultList", requiredItemList);
        logger.info("end searchRequiredItem");
        return resp.getJsonStr();
    }
    
    @RequestMapping(value = "/updateRequiredItem")
    @ResponseBody
    @ApiOperation(value = "修改文书必选项", httpMethod = "POST", notes = "修改文书必选项")
    public String updateRequiredItem(@ApiParam(name = "requiredItemList", value = "文书必选项对象集合") @RequestBody List<BasRequiredItem> requiredItemList)
    {
        logger.info("begin updateRequiredItem");
        ResponseValue resp = new ResponseValue();
        basRequiredItemService.updateRequiredItem(requiredItemList);
        logger.info("end updateRequiredItem");
        return resp.getJsonStr();
    }
    
}
