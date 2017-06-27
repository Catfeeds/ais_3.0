/**     
 * @discription 在此输入一句话描述此文件的作用
 * @author chengwang       
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

import com.digihealth.anesthesia.basedata.formbean.BaseInfoQuery;
import com.digihealth.anesthesia.basedata.formbean.SystemSearchFormBean;
import com.digihealth.anesthesia.common.entity.ResponseValue;
import com.digihealth.anesthesia.common.web.BaseController;
import com.digihealth.anesthesia.doc.formbean.EventBillingFormBean;
import com.digihealth.anesthesia.doc.po.DocEventBilling;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

/**
 * Title: EventBillingController.java Description: 描述
 * 
 * @author liukui
 * @created 2015-10-10 下午5:34:19
 */
@Controller
@RequestMapping(value = "/document")
@Api(value="DocEventBillingController",description="费用统计单处理类")
public class DocEventBillingController extends BaseController {
	
	/**
	 * 根据手术id查询账单明细信息
	 * @param baseInfo
	 * @return
	 */
	@RequestMapping(value = "/searchBillGroupByMedicode")
	@ResponseBody
	@ApiOperation(value="根据手术id查询账单明细信息",httpMethod="POST",notes="根据手术id查询账单明细信息")
	public String searchBillGroupByMedicode(@ApiParam(name="systemSearchFormBean", value ="查询参数") @RequestBody SystemSearchFormBean systemSearchFormBean) {
		logger.info("-----------------begin searchEventBillingList-----------------");
		ResponseValue resp = new ResponseValue();
		List<EventBillingFormBean> rsList= docEventBillingService.searchBillGroupByMedicode(systemSearchFormBean);
		resp.put("rsList", rsList);
		resp.setResultCode("1");
		resp.setResultMessage("查询病人账单信息成功!");
		logger.info("-----------------end searchEventBillingList-----------------");
		return resp.getJsonStr();
	}
	

	/**
	 * 根据手术id查询账单明细信息
	 * @param baseInfo
	 * @return
	 */
	@RequestMapping(value = "/searchEventBillingList")
	@ResponseBody
	@ApiOperation(value="根据手术id查询账单明细信息",httpMethod="POST",notes="根据手术id查询账单明细信息")
	public String searchEventBillingList(@ApiParam(name="systemSearchFormBean", value ="查询参数") @RequestBody SystemSearchFormBean systemSearchFormBean) {
		logger.info("-----------------begin searchEventBillingList-----------------");
		ResponseValue resp = new ResponseValue();
		List<DocEventBilling> rsList= docEventBillingService.searchEventBillingList(systemSearchFormBean);
		Integer total = docEventBillingService.searchEventBillingListTotal(systemSearchFormBean);
		resp.put("rsList", rsList);
		resp.put("total", total);
		resp.setResultCode("1");
		resp.setResultMessage("查询病人账单信息成功!");
		logger.info("-----------------end searchEventBillingList-----------------");
		return resp.getJsonStr();
	}
	
	/**
	 * 同步术中药品及入量信息至账单表
	 * @param baseInfo
	 * @return
	 */
	@RequestMapping(value = "/synMedicTakeInfoList")
	@ResponseBody
	@ApiOperation(value="同步术中药品及入量信息至账单表",httpMethod="POST",notes="同步术中药品及入量信息至账单表")
	public String synMedicTakeInfoList(@ApiParam(name="baseInfo", value ="同步参数") @RequestBody BaseInfoQuery baseInfo) {
		logger.info("-----------------begin synMedicTakeInfoList-----------------");
		ResponseValue resp = new ResponseValue();
		docEventBillingService.synMedicTakeInfoList(baseInfo.getRegOptId(),baseInfo.getUserType(),resp);
		logger.info("-----------------end synMedicTakeInfoList-----------------");
		return resp.getJsonStr();
	}
	/**
	 * 保存入账信息
	 * @param eventBilling
	 * @return
	 */
	@RequestMapping(value = "/saveEventBilling")
	@ResponseBody
	@ApiOperation(value="保存入账信息",httpMethod="POST",notes="保存入账信息")
	public String saveEventBilling(@ApiParam(name="eventBillingList", value ="入账信息参数") @RequestBody List<DocEventBilling> eventBillingList){
		logger.info("-----------------begin saveEventBilling-----------------");
		ResponseValue resp = new ResponseValue();
		docEventBillingService.saveEventBilling(eventBillingList);
		
		resp.setResultCode("1");
		resp.setResultMessage("保存入账信息成功!");
		logger.info("-----------------end saveEventBilling-----------------");
		return resp.getJsonStr();
	}
	/**
	 * 保存入账信息
	 * @param eventBilling
	 * @return
	 */
	@RequestMapping(value = "/deleteBilling")
	@ResponseBody
	@ApiOperation(value="删除入账信息",httpMethod="POST",notes="删除入账信息")
	public String deleteBilling(@ApiParam(name="eventBillingList", value ="入账信息参数") @RequestBody DocEventBilling eventBilling){
		logger.info("-----------------begin deleteBilling-----------------");
		ResponseValue resp = new ResponseValue();
		docEventBillingService.deleteBilling(eventBilling.getEbId());
		resp.setResultCode("1");
		resp.setResultMessage("删除入账信息成功!");
		logger.info("-----------------end deleteBilling-----------------");
		return resp.getJsonStr();
	}
}
