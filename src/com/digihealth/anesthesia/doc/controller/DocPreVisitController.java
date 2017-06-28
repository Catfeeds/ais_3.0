package com.digihealth.anesthesia.doc.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.digihealth.anesthesia.basedata.formbean.DispatchFormbean;
import com.digihealth.anesthesia.common.beanvalidator.ValidatorBean;
import com.digihealth.anesthesia.common.entity.ResponseValue;
import com.digihealth.anesthesia.common.utils.StringUtils;
import com.digihealth.anesthesia.common.web.BaseController;
import com.digihealth.anesthesia.doc.po.DocPreVisit;
import com.digihealth.anesthesia.evt.formbean.SearchRegOptByIdFormBean;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

/**
 * 术前访视单 <功能详细描述>
 * 
 * @author zhouyi
 */
@Controller
@RequestMapping(value = "/document")
@Api(value="DocPreVisitController",description="术前访视单处理类")
public class DocPreVisitController extends BaseController {
    
    /**
     * @discription 根据手术ID获取术前访视单信息
     * @author zhouyi
     * @created 2016-9-7
     * @param regOptId
     * @return
     */
    @RequestMapping(value = "/searchPreVisitByRegOptId")
    @ResponseBody
	@ApiOperation(value="根据手术ID获取术前访视单信息",httpMethod="POST",notes="根据手术ID获取术前访视单信息")
    public String searchPreVisitByRegOptId(@ApiParam(name="map", value ="查询参数") @RequestBody Map<String, Object> map) {
        logger.info("------------------begin searchPreVisitByRegOptId------------------");
        ResponseValue resp = new ResponseValue();
        String regOptId = map.get("regOptId") != null ? map.get("regOptId").toString() : "";
        DocPreVisit preVisit = docPreVisitService.searchPreVisitByRegOptId(regOptId);
        if (preVisit == null) {
            resp.setResultCode("30000001");
            resp.setResultMessage("术前访视单不存在!");
            return resp.getJsonStr();
        }
        
        //获取到麻醉医生名字
        if (null == preVisit.getAnaestheitistId())
        {
            DispatchFormbean dispatchPeople =
                basDispatchService.getDispatchOperByRegOptId(map.get("regOptId").toString());
            if (dispatchPeople != null)
            {
                preVisit.setAnaestheitistId(dispatchPeople.getAnesthetistId() != null ? dispatchPeople.getAnesthetistId() : "");
                preVisit.setAnaestheitistName(dispatchPeople.getAnesthetistName() != null ? dispatchPeople.getAnesthetistName() : "");
            }
        }
        
        //获取手术基本信息
        List<SearchRegOptByIdFormBean> searchRegOptByIdFormBeanList =
            basRegOptService.searchApplicationById(map.get("regOptId").toString());
        SearchRegOptByIdFormBean searchRegOptByIdFormBean =  searchRegOptByIdFormBeanList!=null?searchRegOptByIdFormBeanList.get(0):null;
        if (searchRegOptByIdFormBean == null) {
            resp.setResultCode("30000001");
            resp.setResultMessage("手术基本信息不存在!");
            return resp.getJsonStr();
        }
        
        List<String> anaseMethodList = new ArrayList<String>();
        String[] code = null;
        if (null == preVisit.getDesignedAnaesCode())
        {
            if (StringUtils.isNotBlank(searchRegOptByIdFormBean.getDesignedAnaesMethodCode()))
            {
                code = searchRegOptByIdFormBean.getDesignedAnaesMethodCode().split(",");
            }
            preVisit.setDesignedAnaesCode(searchRegOptByIdFormBean.getDesignedAnaesMethodCode());
            preVisit.setDesignedAnaes(searchRegOptByIdFormBean.getDesignedAnaesMethodName());
        }
        else
        {
            code = preVisit.getDesignedAnaesCode().split(",");
        }
        if (null != code && code.length > 0)
        {
            for (int i = 0; i < code.length; i++)
            {
                anaseMethodList.add(code[i]);
            }
        }
        preVisit.setDesignedAnaesList(anaseMethodList);
            
        //设置页面选择框的值
        setMapValue(preVisit);
		resp.put("result", "true");
		resp.put("preVisitItem", preVisit);
		resp.put("regOptItem", searchRegOptByIdFormBean);
        logger.info("-------------------end searchPreVisitByRegOptId-------------------");
        return resp.getJsonStr();
    }
    
    private void setMapValue(DocPreVisit preVisit)
    {
        JSONObject jasonObject1 = JSONObject.fromObject(preVisit.getBriefHis());
        preVisit.setBriefHisMap(jasonObject1);
        
        JSONObject jasonObject2 = JSONObject.fromObject(preVisit.getLungbreathCond());
        preVisit.setLungbreathCondMap(jasonObject2);
        
        JSONObject jasonObject3 = JSONObject.fromObject(preVisit.getBrainNerve());
        preVisit.setBrainNerveMap(jasonObject3);
        
        JSONObject jasonObject4 = JSONObject.fromObject(preVisit.getSpineLimb());
        preVisit.setSpineLimbMap(jasonObject4);
        
        JSONObject jasonObject5 = JSONObject.fromObject(preVisit.getBlood());
        preVisit.setBloodMap(jasonObject5);
        
        JSONObject jasonObject7 = JSONObject.fromObject(preVisit.getDigestion());
        preVisit.setDigestionMap(jasonObject7);
        
        JSONObject jasonObject8 = JSONObject.fromObject(preVisit.getEndocrine());
        preVisit.setEndocrineMap(jasonObject8);
        
        JSONObject jasonObject9 = JSONObject.fromObject(preVisit.getInfectious());
        preVisit.setInfectiousMap(jasonObject9);
        
        JSONObject jasonObject10 = JSONObject.fromObject(preVisit.getAirwayManage());
        preVisit.setAirwayManageMap(jasonObject10);
        
        JSONObject jasonObject11 = JSONObject.fromObject(preVisit.getSpecialHandle());
        preVisit.setSpecialHandleMap(jasonObject11);
        
        JSONObject jasonObject12 = JSONObject.fromObject(preVisit.getAnalgesicCond());
        preVisit.setAnalgesicMap(jasonObject12);
        
        JSONObject jasonObject13 = JSONObject.fromObject(preVisit.getMonitor());
        preVisit.setMonitorMap(jasonObject13);
        
        JSONObject jasonObject14 = JSONObject.fromObject(preVisit.getHeartBoolCond());
        preVisit.setHeartBoolCondMap(jasonObject14);
        
        JSONObject jasonObject15 = JSONObject.fromObject(preVisit.getToothAbnormalCond());
        preVisit.setToothAbnormalMap(jasonObject15);
        
        JSONObject jasonObject16 = JSONObject.fromObject(preVisit.getAssayAbnormalCond());
        preVisit.setAssayAbnormalMap(jasonObject16);
        
        JSONObject jasonObject17 = JSONObject.fromObject(preVisit.getSpecialTreatmentCond());
        preVisit.setSpecialTreatmentCondMap(jasonObject17);
    }
    
    /**
     * 
     * @discription 修改术前访视单
     * @author zhouyi
     * @created 2016-9-7
     * @param docId
     * @return
     */
    @RequestMapping(value = "/updatePreVisit")
    @ResponseBody
	@ApiOperation(value="修改术前访视单",httpMethod="POST",notes="修改术前访视单")
    public String updatePreVisitByDocId(@ApiParam(name="preVisit", value ="修改参数") @RequestBody DocPreVisit preVisit) {
        logger.info("--------------------begin updatePreVisit--------------------");
        ResponseValue resp = new ResponseValue();
        ValidatorBean validatorBean = beanValidator(preVisit);
        if (!(validatorBean.isValidator())) {
            resp.setResultCode("10000001");
            resp.setResultMessage(validatorBean.getMessage());
            return resp.getJsonStr();
        }
        preVisit.setDesignedAnaesCode(StringUtils.getStringByList(preVisit.getDesignedAnaesList()));
        resp = docPreVisitService.updatePreVisitByDocId(preVisit);
        logger.info("--------------------end updatePreVisit--------------------");
        return resp.getJsonStr();
    }
    
//    /**
//     * 
//     * @discription 提交术前访视单
//     * @author zhouyi
//     * @created 2016-9-7
//     * @param docId
//     * @return
//     */
//    @RequestMapping(value = "/submitPreVisit")
//    @ResponseBody
//	@ApiOperation(value="提交术前访视单",httpMethod="POST",notes="提交术前访视单")
//    public String submitPreVisitByDocId(@ApiParam(name="preVisit", value ="修改参数") @RequestBody DocPreVisit preVisit)
//    {
//        logger.info("--------------------begin updatePreVisit--------------------");
//        ResponseValue resp = new ResponseValue();
//        ValidatorBean validatorBean = beanValidator(preVisit);
//        if (!(validatorBean.isValidator())) {
//            resp.setResultCode("10000001");
//            resp.setResultMessage(validatorBean.getMessage());
//            return resp.getJsonStr();
//        }
//        preVisit.setDesignedAnaesCode(StringUtils.getStringByList(preVisit.getDesignedAnaesList()));
//        preVisit.setProcessState("END");
//        resp = docPreVisitService.updatePreVisitByDocId(preVisit);
//        logger.info("--------------------end updatePreVisit--------------------");
//        return resp.getJsonStr();
//    }
}
