package com.digihealth.anesthesia.doc.controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.digihealth.anesthesia.common.entity.ResponseValue;
import com.digihealth.anesthesia.common.web.BaseController;
import com.digihealth.anesthesia.doc.po.DocPlacentaHandleAgree;
import com.digihealth.anesthesia.evt.formbean.SearchRegOptByIdFormBean;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

@Controller
@RequestMapping(value = "/document")
@Api(value="DocPlacentaHandleAgreeController",description="胎盘处置知情同意书处理类")
public class DocPlacentaHandleAgreeController extends BaseController
{
    @RequestMapping(value = "/searchPlacentaHandleAgreeByRegOptId")
    @ResponseBody
    @ApiOperation(value="查询胎盘处置知情同意书",httpMethod="POST",notes="查询胎盘处置知情同意书")
    public String searchPlacentaHandleAgreeByRegOptId(@ApiParam(name="map", value ="查询参数") @RequestBody Map map)
    {
        logger.debug("--------------begin searchPlacentaHandleAgreeByRegOptId----------------------------");
        String regOptId = null != map.get("regOptId") ? map.get("regOptId").toString() : "";
        DocPlacentaHandleAgree placentaHandleAgree = docPlacentaHandleAgreeService.searchPlacentaHandleAgreeByRegOptId(regOptId);
        ResponseValue resp = new ResponseValue();
        if(placentaHandleAgree == null){
            resp.setResultCode("30000001");
            resp.setResultMessage("胎盘处置知情同意书不存在!");
            logger.debug("--------------end searchPlacentaHandleAgreeByRegOptId----------------------------");
            return resp.getJsonStr();
        }
        
        // 根据患者id获取到手术基本信息
        List<SearchRegOptByIdFormBean> searchRegOptByIdFormBeanList = basRegOptService.searchApplicationById(regOptId);
        SearchRegOptByIdFormBean searchRegOptByIdFormBean =
            searchRegOptByIdFormBeanList != null ? searchRegOptByIdFormBeanList.get(0) : null;
        resp.put("searchRegOptByIdFormBean", searchRegOptByIdFormBean);
        resp.put("placentaHandleAgree", placentaHandleAgree);
        logger.debug("--------------end searchPlacentaHandleAgreeByRegOptId----------------------------");
        return resp.getJsonStr();
    }
    
    @RequestMapping(value = "/updatePlacentaHandleAgree")
    @ResponseBody
    @ApiOperation(value="修改胎盘处置知情同意书",httpMethod="POST",notes="修改胎盘处置知情同意书")
    public String updatePlacentaHandleAgree(@ApiParam(name="placentaHandleAgree", value ="修改参数") @RequestBody DocPlacentaHandleAgree placentaHandleAgree)
    {
        logger.debug("--------------begin updatePlacentaHandleAgree----------------------------");
        ResponseValue resp = new ResponseValue();
        if(placentaHandleAgree == null){
            resp.setResultCode("30000001");
            resp.setResultMessage("胎盘处置知情同意书不存在!");
            logger.debug("--------------end updatePlacentaHandleAgree----------------------------");
            return resp.getJsonStr();
        }
        
        docPlacentaHandleAgreeService.updatePlacentaHandleAgree(placentaHandleAgree);
        logger.debug("--------------end updatePlacentaHandleAgree----------------------------");
        return resp.getJsonStr();
    }
}
