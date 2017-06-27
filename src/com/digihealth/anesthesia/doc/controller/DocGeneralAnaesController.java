/**     
 * @discription 在此输入一句话描述此文件的作用
 * @author liukui       
 * @created 2015-10-10 下午5:34:19    
 * tags     
 * see_to_target     
 */

package com.digihealth.anesthesia.doc.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.digihealth.anesthesia.common.entity.ResponseValue;
import com.digihealth.anesthesia.common.web.BaseController;
import com.digihealth.anesthesia.doc.po.DocGeneralAnaes;
import com.digihealth.anesthesia.evt.formbean.SearchFormBean;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

/**
 * Title: GeneralAnaesController.java Description: 描述
 * 
 * @author liukui
 * @created 2015-10-10 下午5:34:19
 */
@Controller
@RequestMapping(value = "/document")
@Api(value="DocGeneralAnaesController",description="全身麻醉处理类")
public class DocGeneralAnaesController extends BaseController {

	/**
	 * 查询全身麻醉设置表
	 * @param searchBean
	 * @return
	 */
	@RequestMapping(value = "/searchGeneralAnaesList")
	@ResponseBody
	@ApiOperation(value="查询全身麻醉设置表",httpMethod="POST",notes="查询全身麻醉设置表")
	public String searchGeneralAnaesList(@ApiParam(name="searchBean", value ="查询参数") @RequestBody SearchFormBean searchBean) {
		logger.info("-----------------begin searchGeneralAnaesList-----------------");
		ResponseValue resp = new ResponseValue();
		List<DocGeneralAnaes> generalAnaesList = docGeneralAnaesService.searchGeneralAnaesList(searchBean);
		resp.put("resultList", generalAnaesList);
		logger.info("-----------------end searchGeneralAnaesList-----------------");
		return resp.getJsonStr();
	}
	/**
	 * 新增全身麻醉设置表
	 * @param GeneralAnaes
	 * @return
	 */
	@RequestMapping(value = "/insertGeneralAnaes")
	@ResponseBody
	@ApiOperation(value="新增全身麻醉设置表",httpMethod="POST",notes="新增全身麻醉设置表")
	public String insertGeneralAnaes(@ApiParam(name="generalAnaes", value ="全身麻醉设置表参数") @RequestBody DocGeneralAnaes generalAnaes) {
		logger.info("-----------------begin insertGeneralAnaes-----------------");
		ResponseValue resp = new ResponseValue();
		String result = docGeneralAnaesService.insertGeneralAnaes(generalAnaes);
		resp.put("result", result);
		logger.info("-----------------end insertGeneralAnaes-----------------");
		return resp.getJsonStr();
	}
	/**
	 * 修改全身麻醉设置表
	 * @param GeneralAnaes
	 * @return
	 */
	@RequestMapping(value = "/updateGeneralAnaes")
	@ResponseBody
	@ApiOperation(value="修改全身麻醉设置表",httpMethod="POST",notes="修改全身麻醉设置表")
	public String updateGeneralAnaes(@ApiParam(name="generalAnaes", value ="全身麻醉设置表参数") @RequestBody DocGeneralAnaes generalAnaes) {
		logger.info("-----------------begin updateGeneralAnaes-----------------");
		ResponseValue resp = new ResponseValue();
		String result = docGeneralAnaesService.updateGeneralAnaes(generalAnaes);
		resp.put("result", result);
		logger.info("-----------------end updateGeneralAnaes-----------------");
		return resp.getJsonStr();
	}

}
