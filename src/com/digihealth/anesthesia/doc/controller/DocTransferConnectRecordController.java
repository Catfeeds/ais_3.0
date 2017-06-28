package com.digihealth.anesthesia.doc.controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.digihealth.anesthesia.common.entity.ResponseValue;
import com.digihealth.anesthesia.common.web.BaseController;
import com.digihealth.anesthesia.doc.formbean.TransferConnectFormBean;
import com.digihealth.anesthesia.evt.formbean.SearchRegOptByIdFormBean;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

@Controller
@RequestMapping(value = "/document")
@Api(value="DocTransferConnectRecordController",description="手术病人转运交接记录单处理类")
public class DocTransferConnectRecordController extends BaseController
{
    @RequestMapping(value = "/searchTransferConnectRecord")
    @ResponseBody
    @ApiOperation(value="查询手术病人转运交接记录单",httpMethod="POST",notes="查询手术病人转运交接记录单")
    public String searchTransferConnectRecord(@ApiParam(name="map", value ="查询参数") @RequestBody Map map)
    {
        logger.debug("-----------------begin searchTransferConnectRecord--------------------");
        ResponseValue resp = new ResponseValue();
        String regOptId = null != map.get("regOptId") ? map.get("regOptId").toString() : "";
        
        TransferConnectFormBean transferConnectFormBean = docTransferConnectRecordService.searchTransferConnect(regOptId);
        if (null == transferConnectFormBean.getTransferConnectRecord())
        {
            resp.setResultCode("40000002");
            resp.setResultMessage("手术病人转运交接记录单不存在");
            logger.debug("-----------------end searchTransferConnectRecord--------------------");
            return resp.getJsonStr();  
        }
        
        // 根据患者id获取到手术基本信息
        List<SearchRegOptByIdFormBean> searchRegOptByIdFormBeanList = basRegOptService.searchApplicationById(regOptId);
        SearchRegOptByIdFormBean searchRegOptByIdFormBean =
            searchRegOptByIdFormBeanList != null ? searchRegOptByIdFormBeanList.get(0) : null;
        resp.put("searchRegOptByIdFormBean", searchRegOptByIdFormBean);
        resp.put("transferConnectRecord", transferConnectFormBean.getTransferConnectRecord());
        resp.put("transferConnectTypeList", transferConnectFormBean.getTransferConnectTypeList());
        logger.debug("-----------------end searchTransferConnectRecord--------------------");
        return resp.getJsonStr();  
    }
    
    
    @RequestMapping(value = "/updateTransferConnectRecord")
    @ResponseBody
    @ApiOperation(value="修改手术病人转运交接记录单",httpMethod="POST",notes="修改手术病人转运交接记录单")
    public String updateTransferConnectRecord(@ApiParam(name="transferConnectFormBean", value ="修改参数") @RequestBody TransferConnectFormBean transferConnectFormBean)
    {
        logger.debug("-----------------begin updateTransferConnectRecord--------------------");
        ResponseValue resp = new ResponseValue();
        if (null == transferConnectFormBean || null == transferConnectFormBean.getTransferConnectRecord())
        {
            resp.setResultCode("40000002");
            resp.setResultMessage("手术病人转运交接记录单不存在");
            logger.debug("-----------------end updateTransferConnectRecord--------------------");
            return resp.getJsonStr();  
        }
        
        docTransferConnectRecordService.updateTransferConnect(transferConnectFormBean);
        logger.debug("-----------------end updateTransferConnectRecord--------------------");
        return resp.getJsonStr(); 
    }
}
