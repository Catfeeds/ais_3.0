/**     
 * @discription 在此输入一句话描述此文件的作用
 * @author liukui       
 * @created 2015-10-10 下午5:34:19    
 * tags     
 * see_to_target     
 */

package com.digihealth.anesthesia.doc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.digihealth.anesthesia.common.entity.ResponseValue;
import com.digihealth.anesthesia.common.utils.GenerateSequenceUtil;
import com.digihealth.anesthesia.common.utils.JsonType;
import com.digihealth.anesthesia.common.web.BaseController;
import com.digihealth.anesthesia.doc.po.DocNerveBlock;
import com.digihealth.anesthesia.evt.formbean.SearchFormBean;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

/**
 * Title: NerveBlockController.java Description: 描述
 * 
 * @author liukui
 * @created 2015-10-10 下午5:34:19
 */
@Controller
@RequestMapping(value = "/document")
@Api(value="DocNerveBlockController",description="神经阻滞处理类")
public class DocNerveBlockController extends BaseController {

	/**
	 * 查询神经阻滞表
	 * @param searchBean
	 * @return
	 */
	@RequestMapping(value = "/searchNerveBlockList")
	@ResponseBody
	@ApiOperation(value="查询神经阻滞表",httpMethod="POST",notes="查询神经阻滞表")
	public String searchNerveBlockList(@ApiParam(name="searchBean", value ="查询参数") @RequestBody SearchFormBean searchBean) {
		logger.info("--------------------begin searchNerveBlockList--------------------");
        ResponseValue resp = new ResponseValue();
		List<DocNerveBlock> nerveBlockList = docNerveBlockService.searchNerveBlockList(searchBean);
		resp.put("resultList", nerveBlockList);
		logger.info("--------------------end searchNerveBlockList--------------------");
		return resp.getJsonStr();
	}
	/**
	 * 新增神经阻滞表
	 * @param NerveBlock
	 * @return
	 */
	@RequestMapping(value = "/insertNerveBlock")
	@ResponseBody
	@ApiOperation(value="新增神经阻滞表",httpMethod="POST",notes="新增神经阻滞表")
	public String insertNerveBlock(@ApiParam(name="nerveBlock", value ="神经阻滞参数") @RequestBody DocNerveBlock nerveBlock) {
		logger.info("--------------------begin insertNerveBlock--------------------");
        ResponseValue resp = new ResponseValue();
		String result = docNerveBlockService.insertNerveBlock(nerveBlock);
		resp.put("result", result);
		logger.info("--------------------end insertNerveBlock--------------------");
		return resp.getJsonStr();
	}
	/**
	 * 修改神经阻滞表
	 * @param NerveBlock
	 * @return
	 */
	@RequestMapping(value = "/updateNerveBlock")
	@ResponseBody
	@ApiOperation(value="修改神经阻滞表",httpMethod="POST",notes="修改神经阻滞表")
	public String updateNerveBlock(@ApiParam(name="nerveBlock", value ="神经阻滞参数") @RequestBody DocNerveBlock nerveBlock) {
		logger.info("--------------------begin updateNerveBlock--------------------");
        ResponseValue resp = new ResponseValue();
		String result = docNerveBlockService.updateNerveBlock(nerveBlock);
		resp.put("result", result);
		logger.info("--------------------end updateNerveBlock--------------------");
		return resp.getJsonStr();
	}

}
