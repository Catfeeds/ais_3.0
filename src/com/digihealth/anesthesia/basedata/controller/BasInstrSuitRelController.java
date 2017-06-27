package com.digihealth.anesthesia.basedata.controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.digihealth.anesthesia.basedata.po.BasInstrSuitRel;
import com.digihealth.anesthesia.common.entity.ResponseValue;
import com.digihealth.anesthesia.common.web.BaseController;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

/**
 * 
 * Title: InstrSuitRelController.java Description: 手术包器械耗材关联Controller
 * 
 * @author chengwang
 * @created 2015-9-15 下午1:56:40
 */
@Controller
@RequestMapping(value = "/basedata")
@Api(value = "BasInstrSuitRelController", description = "手术包所对应的器械处理类")
public class BasInstrSuitRelController extends BaseController
{
    
    @RequestMapping(value = "/getInstrSuitRelList")
    @ResponseBody
    @ApiOperation(value = "查询手术包所对应的器械信息", httpMethod = "POST", notes = "查询手术包所对应的器械信息")
    public String getInstrSuitRelList(@ApiParam(name = "resp", value = "查询条件对象") @RequestBody Map map)
    {
        logger.info("begin getInstrSuitRelList");
        ResponseValue resp = new ResponseValue();
        List<BasInstrSuitRel> resultList = basInstrSuitRelService.findList(map.get("instrsuitId").toString());
        resp.put("resultList", resultList);
        logger.info("end getInstrSuitRelList");
        return resp.getJsonStr();
    }
    
    @RequestMapping(value = "/insertInstrSuitRel")
    @ResponseBody
    @ApiOperation(value = "插入手术包所对应的器械信息", httpMethod = "POST", notes = "插入手术包所对应的器械信息")
    public String insertInstrSuitRel(
        @ApiParam(name = "instrSuitRel", value = "手术包所对应的器械信息对象") @RequestBody BasInstrSuitRel instrSuitRel)
    {
        logger.info("begin insertInstrSuitRel");
        ResponseValue resp = new ResponseValue();
        int result = basInstrSuitRelService.insertInstrSuitRel(instrSuitRel);
        resp.put("resultCode", "1");
        if (result >= 1)
        {
            resp.put("resultMessage", "手术包添加器械成功");
        }
        else
        {
            resp.put("resultMessage", "手术包添加器械失败");
        }
        
        logger.info("end insertInstrSuitRel");
        return resp.getJsonStr();
    }
    
    @RequestMapping(value = "/deleteInstrSuitRel")
    @ResponseBody
    @ApiOperation(value = "删除手术包所对应的器械信息", httpMethod = "POST", notes = "删除手术包所对应的器械信息")
    public String deleteInstrSuitRel(
        @ApiParam(name = "instrSuitRel", value = "手术包所对应的器械信息对象") @RequestBody BasInstrSuitRel instrSuitRel)
    {
        logger.info("begin deleteInstrSuitRel");
        ResponseValue resp = new ResponseValue();
        int result = basInstrSuitRelService.deleteById(instrSuitRel.getInstrSuitRelId());
        resp.put("resultCode", "1");
        if (result >= 1)
        {
            resp.put("resultMessage", "手术包删除器械成功");
        }
        else
        {
            resp.put("resultMessage", "手术包删除器械失败");
        }
        
        logger.info("end deleteInstrSuitRel");
        return resp.getJsonStr();
    }
}
