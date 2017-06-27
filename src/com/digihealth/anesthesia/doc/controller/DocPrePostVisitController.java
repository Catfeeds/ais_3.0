package com.digihealth.anesthesia.doc.controller;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.digihealth.anesthesia.basedata.formbean.SysCodeFormbean;
import com.digihealth.anesthesia.common.entity.ResponseValue;
import com.digihealth.anesthesia.common.web.BaseController;
import com.digihealth.anesthesia.doc.po.DocPrePostVisit;
import com.digihealth.anesthesia.doc.po.DocPrePostVisitItem;
import com.digihealth.anesthesia.evt.formbean.SearchRegOptByIdFormBean;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

@Controller
@RequestMapping(value = "/document")
@Api(value="DocPrePostVisitController",description="术前术后访问记录单处理类")
public class DocPrePostVisitController extends BaseController
{
    /** 
     * 查询术前术后访问单
     * <功能详细描述>
     * @param regOptId
     * @return
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping(value = "/searchPrePostVisit")
    @ResponseBody
	@ApiOperation(value="查询术前术后访问单",httpMethod="POST",notes="查询术前术后访问单")
    public String searchPrePostVisit(@ApiParam(name="map", value ="查询参数") @RequestBody Map<String, Object> map) {
        logger.debug("---------------searchPrePostVisit begin---------------");
        ResponseValue resp = new ResponseValue();
        String regOptId = null != map.get("regOptId") ? map.get("regOptId").toString() : "";
        
        DocPrePostVisit prePostVisit = docPrePostVisitService.searchPrePostVisit(regOptId);
        if (null == prePostVisit) {
            resp.setResultCode("80000001");
            resp.setResultMessage("手术病人术前术后访问记录单不存在!");
            return resp.getJsonStr();
        }
        
        List<SearchRegOptByIdFormBean> searchRegOptByIdFormBeanList = basRegOptService.searchApplicationById(regOptId);
        SearchRegOptByIdFormBean searchRegOptByIdFormBean =  searchRegOptByIdFormBeanList!=null?searchRegOptByIdFormBeanList.get(0):null;
        
        //设置默认术前访视人和术后访视人
        if (null != searchRegOptByIdFormBean && StringUtils.isNotBlank(searchRegOptByIdFormBean.getCircunurseName1()))
        {
            if (null == prePostVisit.getPreVisitorName())
            {
                prePostVisit.setPreVisitorName(searchRegOptByIdFormBean.getCircunurseName1());
            }
            if (null == prePostVisit.getPostVisitorName())
            {
                prePostVisit.setPostVisitorName(searchRegOptByIdFormBean.getCircunurseName1());
            }
        }
        
        logger.debug("prePostid: " + prePostVisit.getId());
        List<DocPrePostVisitItem> prePostVisitItemList = docPrePostVisitService.searchItemsByPrePostId(prePostVisit.getId());
        
        List<SysCodeFormbean> bloodTypeList =  basSysCodeService.searchSysCodeByGroupId("blood_type", getBeid());
        
        resp.put("prePostVisit", prePostVisit);
        resp.put("prePostVisitItemList", prePostVisitItemList);
        resp.put("searchRegOptByIdFormBean", searchRegOptByIdFormBean);
        resp.put("bloodTypeList", bloodTypeList);
        resp.put("resultCode", "1");
        resp.put("resultMessage", "查询术前术后访问记录单成功!");
        
        logger.debug("---------------searchPrePostVisit end---------------");
        return resp.getJsonStr();
    }
    
    /** 
     * 更新术前术后访问单
     * <功能详细描述>
     * @param prePostVisitFormBean
     * @return
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping(value = "/updatePrePostVisit")
    @ResponseBody
	@ApiOperation(value="更新术前术后访问单",httpMethod="POST",notes="更新术前术后访问单")
    public String updatePrePostVisit(@ApiParam(name="prePostVisit", value ="更新参数") @RequestBody DocPrePostVisit prePostVisit)
    {
    	logger.debug("---------------updatePrePostVisit begin---------------");
        
    	ResponseValue resp = new ResponseValue();
        if (null == prePostVisit)
        {
            resp.setResultCode("80000001");
            resp.setResultMessage("手术病人术前术后访问记录单不存在!");
            return resp.getJsonStr();
        }
    	docPrePostVisitService.updatePrePostVisit(prePostVisit);
        resp.setResultCode("1");
        resp.setResultMessage("手术病人术前术后访问记录单更新成功!");
        
        logger.debug("---------------updatePrePostVisit end---------------");
        return resp.getJsonStr();
    }
    
    /** 
     * 保存更新术前术后访问单中术中条目
     * <功能详细描述>
     * @param prePostVisitItem
     * @return
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping(value = "/updatePrePostVisitItem")
    @ResponseBody
	@ApiOperation(value="保存更新术前术后访问单中术中条目",httpMethod="POST",notes="保存更新术前术后访问单中术中条目")
    public String updatePrePostVisitItem(@ApiParam(name="prePostVisitItem", value ="更新参数") @RequestBody DocPrePostVisitItem prePostVisitItem)
    {
        logger.debug("--------------------updatePrePostVisitItem begin--------------------");
        ResponseValue resp = new ResponseValue();
        
        if (null == prePostVisitItem)
        {
            resp.setResultCode("80000001");
            resp.setResultMessage("手术病人术前术后访问记录单条目不存在!");
            return resp.getJsonStr();
        }
    	docPrePostVisitService.updatePrePostVisitItem(prePostVisitItem);
        resp.setResultCode("1");
        resp.setResultMessage("术前术后访问单中术中条目更新成功!");
        logger.debug("--------------------updatePrePostVisitItem end--------------------");
        return resp.getJsonStr();
    }
    
    /** 
     * 删除术前术后访问单中术中条目
     * <功能详细描述>
     * @param id
     * @return
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping(value = "/delPrePostVisitItem")
    @ResponseBody
	@ApiOperation(value="删除术前术后访问单中术中条目",httpMethod="POST",notes="删除术前术后访问单中术中条目")
    public String delPrePostVisitItem(@ApiParam(name="map", value ="删除参数") @RequestBody Map<String, Object> map)
    {
        logger.debug("--------------------delPrePostVisitItem begin--------------------");
        ResponseValue resp = new ResponseValue();
        String id = null != map.get("id") ? map.get("id").toString() : "";
        docPrePostVisitService.delPrePostVisitItem(id);
        resp.setResultCode("1");
        resp.setResultMessage("术前术后访问单中术中条目删除成功!");
        logger.debug("--------------------delPrePostVisitItem end--------------------");
        return resp.getJsonStr();
    }
}
