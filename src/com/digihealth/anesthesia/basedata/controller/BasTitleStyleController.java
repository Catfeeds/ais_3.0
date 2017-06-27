package com.digihealth.anesthesia.basedata.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.digihealth.anesthesia.basedata.po.BasTitleStyle;
import com.digihealth.anesthesia.common.entity.ResponseValue;
import com.digihealth.anesthesia.common.web.BaseController;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;


/**
 * 
     * Title: TitleStyleController.java    
     * Description: Controller
     * @author liukui       
     * @created 2015-9-15 下午1:56:40
 */
@Controller
@RequestMapping(value = "/basedata")
@Api(value = "BasTitleStyleController", description = "样式表处理类")
public class BasTitleStyleController extends BaseController{
	@RequestMapping(value = "/getTitleStyle")
	@ResponseBody
	@ApiOperation(value = "查询标题样式", httpMethod = "POST", notes = "查询标题样式")
	public String getTitleStyle(@ApiParam(name = "map", value = "查询对象") @RequestBody Map map) {
		ResponseValue resp = new ResponseValue();
		logger.info("begin getTitleStyle");
		BasTitleStyle titleStyle = basTitleStyleService.getTitleStyle(map.get("id").toString());
		resp.put("titleStyle", titleStyle);
		logger.info("end getTitleStyle");
		return resp.getJsonStr();
	}
	/**
	 * @param BasTitleStyle
	 * @return
	 */
	@RequestMapping(value = "/saveTitleStyle")
	@ResponseBody
	@ApiOperation(value = "保存标题样式", httpMethod = "POST", notes = "保存标题样式")
	public String saveTitleStyle(@ApiParam(name = "record", value = "标题样式对象") @RequestBody BasTitleStyle record){
		logger.info("begin saveTitleStyle");
		ResponseValue resp = new ResponseValue();
		basTitleStyleService.saveTitleStyle(record);
		logger.info("end saveTitleStyle");
		return resp.getJsonStr();
	}
}
