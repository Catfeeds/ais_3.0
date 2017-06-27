package com.digihealth.anesthesia.basedata.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.digihealth.anesthesia.basedata.po.BasAnaesKndgbase;
import com.digihealth.anesthesia.common.entity.ResponseValue;
import com.digihealth.anesthesia.common.web.BaseController;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

@Controller
@RequestMapping(value = "/basedata")
@Api(value = "BasAnaesKndgbaseController", description = "知识库处理类")
public class BasAnaesKndgbaseController extends BaseController
{
    /**
     * 查询知识库
     */
    @RequestMapping(value = "/queryAnaesKndgbaseList")
    @ResponseBody
    @ApiOperation(value = "查询知识库", httpMethod = "POST", notes = "查询知识库")
    public String queryAnaesKndgbaseList(@ApiParam(name = "basAnaesKndgbase", value = "知识库对象") @RequestBody BasAnaesKndgbase basAnaesKndgbase) {
        logger.info("begin queryAnaesKndgbaseList");
        ResponseValue resp = new ResponseValue();
        List<BasAnaesKndgbase> anaesKndgbaseList = basAnaesKndgbaseService.queryAnaesKndgbaseList(basAnaesKndgbase);
        resp.put("anaesKndgbaseList", anaesKndgbaseList);
        logger.info("end queryAnaesKndgbaseList");
        return resp.getJsonStr();
    }
    
    /**
     * 保存和更新知识库
     * @param anaesKndgbase
     * @return
     */
    @RequestMapping(value = "/updateAnaesKndgbase")
    @ResponseBody
    @ApiOperation(value = "保存和更新知识库", httpMethod = "POST", notes = "保存和更新知识库")
    public String updateAnaesKndgbase(@ApiParam(name = "basAnaesKndgbase", value = "知识库对象") @RequestBody BasAnaesKndgbase basAnaesKndgbase){
        logger.info("begin queryAnaesKndgbaseList");
        ResponseValue resp = new ResponseValue();
        int result = basAnaesKndgbaseService.updateAnaesKndgbase(basAnaesKndgbase);
        if(result != 0){
            resp.put("id", result);
        }
        logger.info("end queryAnaesKndgbaseList");
        return resp.getJsonStr();
    }
    
    /**
     * 删除知识库
     * @param anaesKndgbase
     * @return
     */
    @RequestMapping(value = "/deleteAnaesKndgbaseById")
    @ResponseBody
    @ApiOperation(value = "删除知识库", httpMethod = "POST", notes = "删除知识库")
    public String deleteAnaesKndgbaseById(@ApiParam(name = "basAnaesKndgbase", value = "知识库对象") @RequestBody BasAnaesKndgbase basAnaesKndgbase){
        logger.info("begin deleteAnaesKndgbaseById");
        ResponseValue resp = new ResponseValue();
        int result = basAnaesKndgbaseService.deleteAnaesKndgbase(basAnaesKndgbase);
        if(result == 0){
            resp.setResultCode("0");
            resp.setResultMessage("该文件夹下还有词条，请先删除词条");
        }
        logger.info("end deleteAnaesKndgbaseById");
        return resp.getJsonStr();
    }
}
