package com.digihealth.anesthesia.doc.controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.digihealth.anesthesia.basedata.formbean.SysCodeFormbean;
import com.digihealth.anesthesia.common.entity.ResponseValue;
import com.digihealth.anesthesia.common.web.BaseController;
import com.digihealth.anesthesia.doc.po.DocAnaesPlan;
import com.digihealth.anesthesia.evt.formbean.SearchRegOptByIdFormBean;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

@Controller
@RequestMapping(value = "/document")
@Api(value="DocAnaesPlanController",description="麻醉计划处理类")
public class DocAnaesPlanController extends BaseController
{
    /** 
     * 查询麻醉计划
     * <功能详细描述>
     * @param map
     * @return
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping(value = "/searchAnaesPlan")
    @ResponseBody
	@ApiOperation(value="查询麻醉计划",httpMethod="POST",notes="查询麻醉计划")
    public String searchAnaesPlan(@ApiParam(name="map", value ="查询参数") @RequestBody Map<String, Object> map) {
        String regOptId = null != map.get("regOptId") ? map.get("regOptId").toString() : "";
        logger.debug("------------------searchAnaesPlan begin------------------");
        ResponseValue resp = new ResponseValue();
        DocAnaesPlan anaesPlan = docAnaesPlanService.searchAnaesPlan(regOptId);
        if (null == anaesPlan) {
            resp.setResultCode("80000001");
            resp.setResultMessage("麻醉计划单不存在!");
            return resp.getJsonStr();
        }
        List<SearchRegOptByIdFormBean> searchRegOptByIdFormBeanList = basRegOptService.searchApplicationById(regOptId);
        SearchRegOptByIdFormBean searchRegOptByIdFormBean = searchRegOptByIdFormBeanList!=null?searchRegOptByIdFormBeanList.get(0):null;
        
        if (null == anaesPlan.getAnaesDoctorName()) {
            anaesPlan.setAnaesDoctorName(searchRegOptByIdFormBean.getAnesthetistName());
        }
        
        List<SysCodeFormbean> puncturePointList =  basSysCodeService.searchSysCodeByGroupId("puncture_point", null);
        List<SysCodeFormbean> laryngealMaskList =  basSysCodeService.searchSysCodeByGroupId("laryngeal_mask_model", null);
        List<SysCodeFormbean> microPumpList = basSysCodeService.searchSysCodeByGroupId("micro_pump", null);
        List<SysCodeFormbean> catherIdList = basSysCodeService.searchSysCodeByGroupId("trachea_cather_id", null);

        resp.put("anaesPlan", anaesPlan);
        resp.put("searchRegOptByIdFormBean", searchRegOptByIdFormBean);
        resp.put("puncturePointList", puncturePointList);//穿刺点
        resp.put("laryngealMaskList", laryngealMaskList);//喉罩型号
        resp.put("microPumpList", microPumpList);//微量泵
        resp.put("catherIdList", catherIdList);//气管导管ID
        resp.setResultCode("1");
        resp.setResultMessage("麻醉计划单查询成功!");
        logger.debug("------------------searchAnaesPlan end------------------");
        return resp.getJsonStr();
    }
    
    /** 
     * 更新保存麻醉计划
     * <功能详细描述>
     * @param anaesPlan
     * @return
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping(value = "/updateAnaesPlan")
    @ResponseBody
	@ApiOperation(value="更新保存麻醉计划",httpMethod="POST",notes="更新保存麻醉计划")
    public String updateAnaesPlan(@ApiParam(name="anaesPlan", value ="麻醉计划参数") @RequestBody DocAnaesPlan anaesPlan) {
        logger.debug("------------------updateAnaesPlan begin------------------");
        ResponseValue resp = new ResponseValue();
        if (null == anaesPlan) {
            resp.setResultCode("80000001");
            resp.setResultMessage("麻醉计划单不存在!");
            return resp.getJsonStr();
        }
        docAnaesPlanService.updateAnaesPlan(anaesPlan);
        resp.setResultCode("1");
        resp.setResultMessage("麻醉计划单更新成功!");
        logger.debug("------------------updateAnaesPlan end------------------");
        return resp.getJsonStr();
    }
}
