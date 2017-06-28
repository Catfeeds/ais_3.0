package com.digihealth.anesthesia.basedata.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.druid.util.StringUtils;
import com.digihealth.anesthesia.basedata.formbean.BasChargePackagesFromBean;
import com.digihealth.anesthesia.basedata.formbean.SystemSearchFormBean;
import com.digihealth.anesthesia.basedata.po.BasChargeItem;
import com.digihealth.anesthesia.basedata.po.BasChargePackages;
import com.digihealth.anesthesia.common.entity.ResponseValue;
import com.digihealth.anesthesia.common.web.BaseController;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;


/**
 * 
     * Title: ChargePackagesController.java    
     * Description: 收费项目套餐包
     * @author chengwang       
     * @created 2015年12月16日 上午10:25:10
 */
@Controller
@RequestMapping(value = "/basedata")
@Api(value = "BasChargePackagesController", description = "收费项目套餐包处理类")
public class BasChargePackagesController extends BaseController{

	/**
	 * 
	     * @discription 根据条件查询收费项目套餐
	     * @author chengwang       
	     * @created 2015年12月3日 下午3:01:40     
	     * @param systemSearchFormBean
	     * @return
	 */
	@RequestMapping(value = "/queryChargePackagesList")
	@ResponseBody
	@ApiOperation(value = "根据条件查询收费项目套餐", httpMethod = "POST", notes = "根据条件查询收费项目套餐")
	public String queryChargePackagesList(@ApiParam(name = "systemSearchFormBean", value = "系统查询对象") @RequestBody SystemSearchFormBean systemSearchFormBean) {
		logger.info("begin queryChargePackagesList");
		ResponseValue resp = new ResponseValue();
		List<BasChargePackages> resultList = basChargePackagesService.queryChargePackagesList(systemSearchFormBean);
		int total = basChargePackagesService.queryChargePackagesTotal(systemSearchFormBean);
		resp.put("resultList", resultList);
		resp.put("total", total);
		logger.info("end queryChargePackagesList");
		return resp.getJsonStr();
	}
	
	/**
	 * 
	     * @discription 查询单个收费项目包信息
	     * @author chengwang       
	     * @created 2015年12月3日 下午3:01:54     
	     * @param dept
	     * @return
	 */
	@RequestMapping(value = "/queryChargePackagesById")
	@ResponseBody
	@ApiOperation(value = "查询单个收费项目包信息", httpMethod = "POST", notes = "查询单个收费项目包信息")
	public String queryChargePackagesById(@ApiParam(name = "chargePackages", value = "收费项目包对象") @RequestBody SystemSearchFormBean systemSearchFormBean){
		logger.info("begin queryChargePackagesById");
		ResponseValue resp = new ResponseValue();
		String chargePkgId = "";
		if(!systemSearchFormBean.getFilters().isEmpty() && systemSearchFormBean.getFilters().size()>0) {
			for (int i = 0; i < systemSearchFormBean.getFilters().size(); i++) {
				if ("chargePkgId".equals(systemSearchFormBean.getFilters().get(i).getField().toString())) {
					chargePkgId = systemSearchFormBean.getFilters().get(i).getValue();
				}
			}
		}
		BasChargePackages resultChargePackages = basChargePackagesService.searchChargePackagesById(chargePkgId);
		List<BasChargeItem> chargeItemList = new ArrayList<BasChargeItem>();
		if(resultChargePackages!=null){
			chargeItemList = basChargeItemService.queryChargeItemByChargePackagesId(systemSearchFormBean, chargePkgId, systemSearchFormBean.getBeid());
		}
		resp.put("chargePackages", resultChargePackages);
		resp.put("resultList", chargeItemList);
		logger.info("end queryChargePackagesById");
		return resp.getJsonStr();
	}
	
	
	/**
	 * 
	     * @discription 保存单个收费项目套餐包
	     * @author chengwang       
	     * @created 2015年12月16日 上午10:39:35     
	     * @param chargePackagesFromBean
	     * @return
	 */
	@RequestMapping(value = "/updateChargePackages")
	@ResponseBody
	@ApiOperation(value = "保存单个收费项目套餐包", httpMethod = "POST", notes = "保存单个收费项目套餐包")
	public String updateChargePackages(@ApiParam(name = "chargePackagesFromBean", value = "收费项目包查询对象") @RequestBody BasChargePackagesFromBean chargePackagesFromBean){
		logger.info("begin updateChargePackages");
		ResponseValue resp = new ResponseValue();
		basChargePackagesService.updateChargePackages(chargePackagesFromBean);
		logger.info("end updateChargePackages");
		return resp.getJsonStr();
	}
	
}
