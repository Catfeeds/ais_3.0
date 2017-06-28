package com.digihealth.anesthesia.doc.controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.digihealth.anesthesia.basedata.formbean.SystemSearchFormBean;
import com.digihealth.anesthesia.common.entity.ResponseValue;
import com.digihealth.anesthesia.common.web.BaseController;
import com.digihealth.anesthesia.doc.formbean.InsuredPatAgreeFormBean;
import com.digihealth.anesthesia.doc.formbean.SearchMedAndInstruFormBean;
import com.digihealth.anesthesia.doc.po.DocInsuredItem;
import com.digihealth.anesthesia.doc.po.DocInsuredPatAgree;
import com.digihealth.anesthesia.evt.formbean.SearchRegOptByIdFormBean;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

@Controller
@RequestMapping(value = "/document")
@Api(value="DocInsuredPatAgreeController",description="参保患者特殊用药、卫材知情单处理类")
public class DocInsuredPatAgreeController extends BaseController
{
    @RequestMapping(value = "/searchInsuredPatAgreeByRegOptId")
    @ResponseBody
    @ApiOperation(value="查询参保患者特殊用药、卫材知情单",httpMethod="POST",notes="查询参保患者特殊用药、卫材知情单")
    public String searchInsuredPatAgreeByRegOptId(@ApiParam(name="map", value ="查询参数") @RequestBody Map map)
    {
        logger.debug("-----------------begin searchInsuredPatAgreeByRegOptId--------------------");
        ResponseValue resp = new ResponseValue();
        String regOptId = null != map.get("regOptId") ? map.get("regOptId").toString() : "";
        InsuredPatAgreeFormBean insuredPatAgreeFormBean = docInsuredPatAgreeService.searchInsuredPatAgreeByRegOptId(regOptId);
        if (null == insuredPatAgreeFormBean.getDocInsuredPatAgree())
        {
            resp.setResultCode("40000002");
            resp.setResultMessage("参保患者特殊用药、卫材知情单不存在");
            logger.debug("-----------------end searchInsuredPatAgreeByRegOptId--------------------");
            return resp.getJsonStr();
        }
        
        // 根据患者id获取到手术基本信息
        List<SearchRegOptByIdFormBean> searchRegOptByIdFormBeanList = basRegOptService.searchApplicationById(regOptId);
        SearchRegOptByIdFormBean searchRegOptByIdFormBean =
            searchRegOptByIdFormBeanList != null ? searchRegOptByIdFormBeanList.get(0) : null;
        if (null == searchRegOptByIdFormBean)
        {
            resp.setResultCode("40000002");
            resp.setResultMessage("手术基本信息不存在");
            logger.debug("-----------------end searchInsuredPatAgreeByRegOptId--------------------");
            return resp.getJsonStr();
        }
        
        List<DocInsuredItem> insuredItemList = insuredPatAgreeFormBean.getDocInsuredItemList();
        resp.put("insuredPatAgree",insuredPatAgreeFormBean.getDocInsuredPatAgree());
        resp.put("insuredItemList",insuredItemList);
        resp.put("searchRegOptByIdFormBean", searchRegOptByIdFormBean);
        logger.debug("-----------------end searchInsuredPatAgreeByRegOptId--------------------");
        return resp.getJsonStr(); 
    }
    
    @RequestMapping(value = "/updateInsuredPatAgree")
    @ResponseBody
    @ApiOperation(value="修改参保患者特殊用药、卫材知情单",httpMethod="POST",notes="修改参保患者特殊用药、卫材知情单")
    public String updateInsuredPatAgree(@ApiParam(name="insuredPatAgree", value ="修改参数") @RequestBody DocInsuredPatAgree insuredPatAgree)
    {
        logger.debug("-----------------begin updateInsuredPatAgree--------------------");
        ResponseValue resp = new ResponseValue();
        if (null == insuredPatAgree)
        {
            resp.setResultCode("40000002");
            resp.setResultMessage("参保患者特殊用药、卫材知情单不存在");
            logger.debug("-----------------end updateInsuredPatAgree--------------------");
            return resp.getJsonStr(); 
        }
        docInsuredPatAgreeService.updateInsuredPatAgree(insuredPatAgree);
        logger.debug("-----------------end updateInsuredPatAgree--------------------");
        return resp.getJsonStr(); 
    }
    
    @RequestMapping(value = "/updateInsuredItem")
    @ResponseBody
    @ApiOperation(value="修改参保患者特殊用药、卫材知情单条目",httpMethod="POST",notes="修改参保患者特殊用药、卫材知情单条目")
    public String updateInsuredItem(@ApiParam(name="insuredItem", value ="修改参数") @RequestBody DocInsuredItem insuredItem)
    {
        logger.debug("-----------------begin updateInsuredItem--------------------");
        ResponseValue resp = new ResponseValue();
        if (null == insuredItem)
        {
            resp.setResultCode("40000002");
            resp.setResultMessage("药品或者耗材条目不存在");
            logger.debug("-----------------end updateInsuredItem--------------------");
            return resp.getJsonStr();
        }
        resp = docInsuredPatAgreeService.updateInsuredItem(insuredItem);
        logger.debug("-----------------end updateInsuredItem--------------------");
        return resp.getJsonStr(); 
    }
    
    @RequestMapping(value = "/searchMedAndInstru")
    @ResponseBody
    @ApiOperation(value="查询参保患者特殊用药和卫材",httpMethod="POST",notes="查询参保患者特殊用药和卫材")
    public String searchMedAndInstru(@ApiParam(name="systemSearchFormBean", value ="查询参数") @RequestBody SystemSearchFormBean systemSearchFormBean)
    {
        logger.debug("-----------------begin searchMedAndInstru--------------------");
        ResponseValue resp = new ResponseValue();
        List<SearchMedAndInstruFormBean> resultList = docInsuredPatAgreeService.searchMedAndInstru(systemSearchFormBean);
        resp.put("medAndInstruList", resultList);
        logger.debug("-----------------end searchMedAndInstru--------------------");
        return resp.getJsonStr(); 
    }
    
    @RequestMapping(value = "/deleteInsuredItem")
    @ResponseBody
    @ApiOperation(value="删除参保患者特殊用药、卫材知情单条目",httpMethod="POST",notes="删除参保患者特殊用药、卫材知情单条目")
    public String deleteInsuredItem(@ApiParam(name="insuredItem", value ="删除参数") @RequestBody DocInsuredItem insuredItem)
    {
        logger.debug("-----------------begin deleteInsuredItem--------------------");
        ResponseValue resp = new ResponseValue();
        if (null == insuredItem)
        {
            resp.setResultCode("40000002");
            resp.setResultMessage("药品或者耗材条目不存在");
            logger.debug("-----------------end deleteInsuredItem--------------------");
            return resp.getJsonStr();
        }
        docInsuredPatAgreeService.deleteInsuredItem(insuredItem);
        logger.debug("-----------------end deleteInsuredItem--------------------");
        return resp.getJsonStr(); 
    }
}
