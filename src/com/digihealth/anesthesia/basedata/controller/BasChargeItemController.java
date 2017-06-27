package com.digihealth.anesthesia.basedata.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.digihealth.anesthesia.basedata.formbean.BasChargeItemFormBean;
import com.digihealth.anesthesia.basedata.formbean.BaseInfoQuery;
import com.digihealth.anesthesia.basedata.formbean.SystemSearchFormBean;
import com.digihealth.anesthesia.basedata.po.BasChargeItem;
import com.digihealth.anesthesia.common.entity.ResponseValue;
import com.digihealth.anesthesia.common.web.BaseController;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;


/**
 * 
 * Title: ChargeItemController.java    
 * Description: 收费项目Controller
 * @author chengwang       
 * @created 2015年12月15日 上午10:19:57
 */
@Controller
@RequestMapping(value = "/basedata")
@Api(value = "BasChargeItemController", description = "收费项目处理类")
public class BasChargeItemController extends BaseController{

	
	@RequestMapping(value = "/searchChargeItem")
	@ResponseBody
	@ApiOperation(value = "查询收费项目列表", httpMethod = "POST", notes = "查询收费项目列表")
	public String findList(@ApiParam(name = "baseQuery", value = "系统查询对象") @RequestBody BaseInfoQuery baseQuery){
	    logger.info("begin searchChargeItem");
	    ResponseValue resp = new ResponseValue();
		String pinyin = baseQuery.getPinyin();
		String beid = baseQuery.getBeid();
		List<BasChargeItemFormBean>  chargeItemList = basChargeItemService.findList(pinyin, beid);
		resp.put("resultList", chargeItemList);
		logger.info("end searchChargeItem");
		return resp.getJsonStr();
	}
	
	@RequestMapping(value = "/queryChargeItem")
	@ResponseBody
	@ApiOperation(value = "查询收费项目", httpMethod = "POST", notes = "查询收费项目")
	public String queryChargeItem(@ApiParam(name = "systemSearchFormBean", value = "系统查询对象") @RequestBody SystemSearchFormBean systemSearchFormBean){
		logger.info("begin queryChargeItem");
		ResponseValue resp = new ResponseValue();
		List<BasChargeItem>  chargeItemList = basChargeItemService.queryChargeItemList(systemSearchFormBean);
		int total = basChargeItemService.findListTotal(systemSearchFormBean);
		resp.put("resultList", chargeItemList);
		resp.put("total", total);
		logger.info("end queryChargeItem");
		return resp.getJsonStr();
	}
	
	/**
	 * 
     * @discription 查询单个收费项目
     * @author chengwang       
     * @created 2015年12月16日 上午9:26:12     
     * @param chargeItem
     * @return
	 */
	@RequestMapping(value = "/queryChargeItemById")
	@ResponseBody
	@ApiOperation(value = "查询单个收费项目", httpMethod = "POST", notes = "查询单个收费项目")
	public String queryChargeItemById(@ApiParam(name = "chargeItem", value = "收费项目对象") @RequestBody BasChargeItem chargeItem){
		logger.info("begin queryChargeItemById");
		ResponseValue resp = new ResponseValue();
        BasChargeItem resultChargeItem = basChargeItemService.searchChargeItemById(chargeItem.getChargeItemId(), chargeItem.getBeid());
		resp.put("chargeItem", resultChargeItem);
		logger.info("end queryChargeItemById");
		return resp.getJsonStr();
	}
	
	/**
	 * 
     * @discription 修改或者添加收费项目
     * @author chengwang       
     * @created 2015年12月3日 下午3:02:15     
     * @param chargeItem
     * @return
	 */
	@RequestMapping(value = "/updateChargeItem")
	@ResponseBody
	@ApiOperation(value = "修改或者添加收费项目", httpMethod = "POST", notes = "修改或者添加收费项目")
	public String updateInstrument(@ApiParam(name = "chargeItem", value = "收费项目对象") @RequestBody BasChargeItem chargeItem){
		logger.info("begin updateChargeItem");
		ResponseValue resp = new ResponseValue();
		basChargeItemService.updateChargeItem(chargeItem);
		logger.info("end updateChargeItem");
		return resp.getJsonStr();
	}
}
