package com.digihealth.anesthesia.basedata.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.digihealth.anesthesia.basedata.formbean.BaseInfoQuery;
import com.digihealth.anesthesia.basedata.formbean.SystemSearchFormBean;
import com.digihealth.anesthesia.basedata.po.BasPrice;
import com.digihealth.anesthesia.common.entity.ResponseValue;
import com.digihealth.anesthesia.common.web.BaseController;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;


/**
 * 
     * Title: PriceController.java    
     * Description: 药品表MedicineController
     * @author liukui       
     * @created 2015-9-15 下午1:56:40
 */
@Controller
@RequestMapping(value = "/basedata")
@Api(value="BasPriceController",description="药品价格处理类")
public class BasPriceController extends BaseController{

	@RequestMapping(value = "/searchPriceList")
	@ResponseBody
	@ApiOperation(value="查询药品价格信息列表",httpMethod="POST",notes="查询药品价格信息列表")
	public String searchPriceList(@ApiParam(name="baseQuery", value ="系统查询参数") @RequestBody BaseInfoQuery baseQuery){
		logger.info("begin searchPriceList");
		ResponseValue resp = new ResponseValue();
		List<BasPrice> resultList = basPriceService.searchPriceList(baseQuery);
		resp.put("resultList", resultList);
		logger.info("end searchPriceList");
		return resp.getJsonStr();
	}
	
	
	/**
	 * 
	     * @discription 根据条件查询药品价格信息
	     * @author liukui       
	     * @created 2015年12月3日 下午3:01:40     
	     * @param systemSearchFormBean
	     * @return
	 */
	@RequestMapping(value = "/queryPriceList")
	@ResponseBody
	@ApiOperation(value="查询药品价格信息列表",httpMethod="POST",notes="查询药品价格信息列表")
	public String queryPriceList(@ApiParam(name="systemSearchFormBean", value ="系统查询对象") @RequestBody SystemSearchFormBean systemSearchFormBean) {
		logger.info("begin queryPriceList");
		ResponseValue resp = new ResponseValue();
		List<BasPrice> resultList = basPriceService.queryPriceList(systemSearchFormBean);
		int total = basPriceService.queryPriceListTotal(systemSearchFormBean);
		resp.put("resultList", resultList);
		resp.put("total", total);
		logger.info("end queryPriceList");
		return resp.getJsonStr();
	}
	
	/**
	 * 
	     * @discription 查询单个药品信息
	     * @author liukui       
	     * @created 2015年12月3日 下午3:01:54     
	     * @param dept
	     * @return
	 */
	@RequestMapping(value = "/queryPriceByPriceId")
	@ResponseBody
	@ApiOperation(value="查询单个药品信息",httpMethod="POST",notes="查询单个药品信息")
	public String queryPriceByPriceId(@ApiParam(name="price", value ="药品价格对象") @RequestBody BasPrice price){
		logger.info("begin queryPriceById");
		ResponseValue resp = new ResponseValue();
		BasPrice resultPo = basPriceService.queryPriceByPriceId(price.getPriceId());
		resp.put("BasPrice", resultPo);
		logger.info("end queryPriceByPriceId");
		return resp.getJsonStr();
	}
	
	
	/**
	 * 
	     * @discription 修改或者添加药品价格信息
	     * @author liukui      
	     * @created 2015年12月3日 下午3:02:15     
	     * @param Operdef
	     * @return
	 */
	@RequestMapping(value = "/savePrice")
	@ResponseBody
	@ApiOperation(value="保存药品信息",httpMethod="POST",notes="保存药品信息")
	public String savePrice(@ApiParam(name="price", value ="药品价格对象") @RequestBody BasPrice price){
		logger.info("begin savePrice");
		ResponseValue resp = new ResponseValue();
        basPriceService.savePrice(price);
		logger.info("end savePrice");
		return resp.getJsonStr();
	}
}
