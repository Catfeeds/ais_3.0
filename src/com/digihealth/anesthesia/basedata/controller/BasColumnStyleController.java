package com.digihealth.anesthesia.basedata.controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.digihealth.anesthesia.basedata.po.BasColumnStyle;
import com.digihealth.anesthesia.common.entity.ResponseValue;
import com.digihealth.anesthesia.common.web.BaseController;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;


/**
 * 
     * Title: ColumnStyleController.java    
     * Description: Controller
     * @author liukui       
     * @created 2015-9-15 下午1:56:40
 */
@Controller
@RequestMapping(value = "/basedata")
@Api(value = "BasColumnStyleController", description = "大屏列样式处理类")
public class BasColumnStyleController extends BaseController{

	
	@RequestMapping(value = "/getColumnStyle")
	@ResponseBody
	@ApiOperation(value = "查询大屏列样式", httpMethod = "POST", notes = "查询大屏列样式")
	public String getColumnStyle(@ApiParam(name = "map", value = "查询条件") @RequestBody Map map) {
	    logger.info("begin getColumnStyle");
		ResponseValue resp = new ResponseValue();
		BasColumnStyle columnStyle = basColumnStyleService.getColumnStyle(map.get("id").toString());
		resp.put("columnStyle", columnStyle);
		logger.info("end getColumnStyle");
		return resp.getJsonStr();
	}
	/**
	 * @param BasColumnStyle
	 * @return
	 */
	@RequestMapping(value = "/saveColumnStyle")
	@ResponseBody
	@ApiOperation(value = "保存大屏列样式", httpMethod = "POST", notes = "保存大屏列样式")
	public String saveColumnStyle(@ApiParam(name = "basColumnStyle", value = "大屏列样式对象") @RequestBody BasColumnStyle basColumnStyle){
		logger.info("begin saveColumnStyle");
		ResponseValue resp = new ResponseValue();
		basColumnStyleService.saveColumnStyle(basColumnStyle);
		logger.info("end saveColumnStyle");
		return resp.getJsonStr();
	}
	/**
	 * @param List<BasColumnStyle>
	 * @return
	 */
	@RequestMapping(value = "/changeColumnSort")
	@ResponseBody
	@ApiOperation(value = "批量修改大屏列样式", httpMethod = "POST", notes = "批量修改大屏列样式")
	public String changeColumnSort(@ApiParam(name = "columnStyleList", value = "大屏列样式对象集合") @RequestBody List<BasColumnStyle> columnStyleList){
		logger.info("begin changeColumnSort");
		ResponseValue resp = new ResponseValue();
		basColumnStyleService.changeColumnSort(columnStyleList);
		logger.info("end changeColumnSort");
		return resp.getJsonStr();
	}
	
}
