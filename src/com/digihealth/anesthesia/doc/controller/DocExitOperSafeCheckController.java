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
import com.digihealth.anesthesia.doc.po.DocExitOperSafeCheck;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

/**
 * Title: ExitOperSafeCheckController.java Description: 描述
 * 
 * @author chengwang
 * @created 2015-10-10 下午5:34:19
 */
@Controller
@RequestMapping(value = "/document")
@Api(value="DocExitOperSafeCheckController",description="安全核查处理类")
public class DocExitOperSafeCheckController extends BaseController {
	
	@RequestMapping(value = "/updateExitOperSafeCheck")
	@ResponseBody
	@ApiOperation(value="修改安全核查信息",httpMethod="POST",notes="修改安全核查信息")
	public String updateExitOperSafeCheck(@ApiParam(name="exitOperSafeCheck", value ="修改参数") @RequestBody DocExitOperSafeCheck exitOperSafeCheck){
		logger.info("-------------------begin updateExitOperSafeCheck-------------------");
		ResponseValue resp = new ResponseValue();
		ValidatorBean validatorBean = beanValidator(exitOperSafeCheck);
		if(!(validatorBean.isValidator())){
			resp.setResultCode("10000001");
			resp.setResultMessage(validatorBean.getMessage());
			return resp.getJsonStr();
		}
		resp = docExitOperSafeCheckService.updateExitOperSafeCheck(exitOperSafeCheck, "");
		logger.info("-------------------end updateExitOperSafeCheck-------------------");
		return resp.getJsonStr();
	}

}
