/**     
 * @discription 在此输入一句话描述此文件的作用
 * @author chengwang       
 * @created 2015-10-10 下午5:34:19    
 * tags     
 * see_to_target     
 */

package com.digihealth.anesthesia.doc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.digihealth.anesthesia.common.beanvalidator.ValidatorBean;
import com.digihealth.anesthesia.common.entity.ResponseValue;
import com.digihealth.anesthesia.common.web.BaseController;
import com.digihealth.anesthesia.doc.po.DocOperBeforeSafeCheck;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

/**
 * Title: OperBeforeSafeCheckController.java Description: 描述
 * 
 * @author chengwang
 * @created 2015-10-10 下午5:34:19
 */
@Controller
@RequestMapping(value = "/document")
@Api(value="DocOperBeforeSafeCheckController",description="手术前安全核查处理类")
public class DocOperBeforeSafeCheckController extends BaseController {
	
	@RequestMapping(value = "/updateOperBeforeSafeCheck")
	@ResponseBody
	@ApiOperation(value="更新手术前安全核查信息",httpMethod="POST",notes="更新手术前安全核查信息")
	public String updateOperBeforeSafeCheck(@ApiParam(name="operBeforeSafeCheck", value ="查询参数") @RequestBody DocOperBeforeSafeCheck operBeforeSafeCheck){
		logger.info("-------------------begin updateOperBeforeSafeCheck-------------------");
		ResponseValue resp = new ResponseValue();
		ValidatorBean validatorBean = beanValidator(operBeforeSafeCheck);
		if(!(validatorBean.isValidator())){
			resp.setResultCode("10000001");
			resp.setResultMessage(validatorBean.getMessage());
			return resp.getJsonStr();
		}
		resp = docOperBeforeSafeCheckService.updateOperBeforeSafeCheck(operBeforeSafeCheck);
		logger.info("-------------------end updateOperBeforeSafeCheck-------------------");
		return resp.getJsonStr();
	}

}
