package com.digihealth.anesthesia.basedata.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.digihealth.anesthesia.basedata.po.BasRowStyle;
import com.digihealth.anesthesia.common.entity.ResponseValue;
import com.digihealth.anesthesia.common.web.BaseController;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;


/**
 * 
     * Title: RowStyleController.java    
     * Description: Controller
     * @author liukui       
     * @created 2015-9-15 下午1:56:40
 */
@Controller
@RequestMapping(value = "/basedata")
@Api(value = "BasRowStyleController", description = "大屏行样式处理类")
public class BasRowStyleController extends BaseController{

	
	@RequestMapping(value = "/getRowStyle")
	@ResponseBody
	@ApiOperation(value = "查询大屏行样式", httpMethod = "POST", notes = "查询大屏行样式")
	public String getRowStyle(@ApiParam(name = "map", value = "查询条件") @RequestBody Map map) {
	    logger.info("begin getRowStyle");
		ResponseValue resp = new ResponseValue();
		BasRowStyle rowStyle = basRowStyleService.getRowStyle(map.get("id").toString());
		resp.put("rowStyle", rowStyle);
		logger.info("end getRowStyle");
		return resp.getJsonStr();
	}
	/**
	 * @param BasRowStyle
	 * @return
	 */
	@RequestMapping(value = "/saveRowStyle")
	@ResponseBody
	@ApiOperation(value = "保存大屏行样式", httpMethod = "POST", notes = "保存大屏行样式")
	public String saveRowStyle(@ApiParam(name = "record", value = "大屏行样式对象") @RequestBody BasRowStyle record){
		logger.info("begin saveRowStyle");
		ResponseValue resp = new ResponseValue();
		basRowStyleService.saveRowStyle(record);
		logger.info("end saveRowStyle");
		return resp.getJsonStr();
	}
}
