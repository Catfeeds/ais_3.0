package com.digihealth.anesthesia.doc.controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.digihealth.anesthesia.common.entity.ResponseValue;
import com.digihealth.anesthesia.common.web.BaseController;
import com.digihealth.anesthesia.doc.po.DocPatOutRangeAgree;
import com.digihealth.anesthesia.doc.po.DocPatOutRangeItem;
import com.digihealth.anesthesia.evt.formbean.SearchRegOptByIdFormBean;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

@Controller
@RequestMapping(value = "/document")
@Api(value="DocPatOutRangeAgreeController",description="医疗保险病人超范围用药处理类")
public class DocPatOutRangeAgreeController extends BaseController {
    /** 
     * 查询医疗保险病人超范围用药同意书
     * <功能详细描述>
     * @param regOptId
     * @return
     * @see [类、类#方法、类#成员]
     */
	@RequestMapping(value = "/searchPatOutRangeAgree")
	@ResponseBody
	@ApiOperation(value = "查询医疗保险病人超范围用药同意书", httpMethod = "POST", notes = "查询医疗保险病人超范围用药同意书")
	public String searchPatOutRangeAgree(@ApiParam(name = "map", value = "查询参数") @RequestBody Map<String, Object> map) {
		logger.debug("-----------------searchPatOutRangeAgree begin-----------------");
		ResponseValue resp = new ResponseValue();
		String regOptId = null != map.get("regOptId") ? map.get("regOptId").toString() : "";

		DocPatOutRangeAgree pora = docPatOutRangeAgreeService.searchPatOutRangeAgree(regOptId);
		if (null == pora) {
			resp.setResultCode("80000001");
			resp.setResultMessage("医疗保险病人超范围用药记录单不存在!");
			return resp.getJsonStr();
		}

		List<SearchRegOptByIdFormBean> searchRegOptByIdFormBeanList = basRegOptService.searchApplicationById(regOptId);
		SearchRegOptByIdFormBean searchRegOptByIdFormBean = searchRegOptByIdFormBeanList != null ? searchRegOptByIdFormBeanList
				.get(0) : null;
		List<DocPatOutRangeItem> patOutRangeItemList = docPatOutRangeAgreeService.searchByPatOutRangeId(pora.getId());

		resp.put("patOutRangeAgree", pora);
		resp.put("patOutRangeItemList", patOutRangeItemList);
		resp.put("searchRegOptByIdFormBean", searchRegOptByIdFormBean);
		resp.setResultCode("1");
		resp.setResultMessage("查询医疗保险病人超范围用药同意书成功!");

		logger.debug("-----------------searchPatOutRangeAgree end-----------------");
		return resp.getJsonStr();
	}
    
    /** 
     * 更新医疗保险病人超范围用药同意书
     * <功能详细描述>
     * @param pora
     * @return
     * @see [类、类#方法、类#成员]
     */
	@RequestMapping(value = "/updatePatOutRangeAgree")
	@ResponseBody
	@ApiOperation(value = "更新医疗保险病人超范围用药同意书", httpMethod = "POST", notes = "更新医疗保险病人超范围用药同意书")
	public String updatePatOutRangeAgree(@ApiParam(name = "pora", value = "更新参数") @RequestBody DocPatOutRangeAgree pora) {
		logger.debug("-----------------updatePatOutRangeAgree begin-----------------");
		ResponseValue resp = new ResponseValue();

		if (null == pora) {
			resp.setResultCode("80000001");
			resp.setResultMessage("医疗保险病人超范围用药记录单不存在!");
			return resp.getJsonStr();
		}
		docPatOutRangeAgreeService.updatePatOutRangeAgree(pora);
		resp.setResultCode("1");
		resp.setResultMessage("医疗保险病人超范围用药记录单更新成功!");
		logger.debug("-----------------updatePatOutRangeAgree end-----------------");
		return resp.getJsonStr();
	}
    
    /** 
     * 更新保存医疗保险病人超范围用药同意书条目
     * <功能详细描述>
     * @param pori
     * @return
     * @see [类、类#方法、类#成员]
     */
	@RequestMapping(value = "/updatePatOutRangeItem")
	@ResponseBody
	@ApiOperation(value = "更新保存医疗保险病人超范围用药同意书条目", httpMethod = "POST", notes = "更新保存医疗保险病人超范围用药同意书条目")
	public String updatePatOutRangeItem(@ApiParam(name = "pori", value = "更新参数") @RequestBody DocPatOutRangeItem pori) {
		logger.debug("-----------------updatePatOutRangeItem begin-----------------");
		ResponseValue resp = new ResponseValue();

		if (null == pori) {
			resp.setResultCode("80000001");
			resp.setResultMessage("医疗保险病人超范围用药记录单不存在!");
			return resp.getJsonStr();
		}
		docPatOutRangeAgreeService.updatePatOutRangeItem(pori);
		resp.setResultCode("1");
		resp.setResultMessage("医疗保险病人超范围用药记录单条目添加成功!");
		logger.debug("-----------------updatePatOutRangeItem end-----------------");
		return resp.getJsonStr();
	}
    
    /** 
     * 删除医疗保险病人超范围用药同意书条目
     * <功能详细描述>
     * @param id
     * @return
     * @see [类、类#方法、类#成员]
     */
	@RequestMapping(value = "/delPatOutRangeItem")
	@ResponseBody
	@ApiOperation(value = "更新保存医疗保险病人超范围用药同意书条目", httpMethod = "POST", notes = "更新保存医疗保险病人超范围用药同意书条目")
	public String delPatOutRangeItem(@ApiParam(name = "map", value = "删除参数") @RequestBody Map<String, Object> map) {
		logger.debug("-----------------delPatOutRangeItem begin-----------------");
		ResponseValue resp = new ResponseValue();

		String id = null != map.get("id") ? map.get("id").toString() : "";
		docPatOutRangeAgreeService.delPatOutRangeItem(id);
		resp.setResultCode("1");
		resp.setResultMessage("医疗保险病人超范围用药记录单条目删除成功!");
		logger.debug("-----------------delPatOutRangeItem end-----------------");
		return resp.getJsonStr();
	}
}
