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
import com.digihealth.anesthesia.doc.po.DocAnaesBeforeSafeCheck;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

/**
 * Title: AnaesBeforeSafeCheckController.java Description: 描述
 * 
 * @author chengwang
 * @created 2015-10-10 下午5:34:19
 */
@Controller
@RequestMapping(value = "/document")
@Api(value="DocAnaesBeforeSafeCheckController",description="麻醉前核查处理类")
public class DocAnaesBeforeSafeCheckController extends BaseController {

	/**
	 * 
	     * @discription 保存麻醉前核查
	     * @author chengwang       
	     * @created 2015年10月30日 下午5:12:39     
	     * @param anaesBeforeSafeCheck
	     * @return
	 */
	@RequestMapping(value = "/updateAnaesBeforeSafeCheck")
	@ResponseBody
	@ApiOperation(value="保存麻醉前核查",httpMethod="POST",notes="保存麻醉前核查")
	public String updateAnaesBeforeSafeCheck(@ApiParam(name="anaesBeforeSafeCheck", value ="统计查询参数") @RequestBody DocAnaesBeforeSafeCheck anaesBeforeSafeCheck){
		logger.info("--------------------start updateAnaesBeforeSafeCheck--------------------");
		ResponseValue resp = new ResponseValue();
		ValidatorBean validatorBean = beanValidator(anaesBeforeSafeCheck);
		if(!(validatorBean.isValidator())){
			resp.setResultCode("10000001");
			resp.setResultMessage(validatorBean.getMessage());
			return resp.getJsonStr();
		}
		resp = docAnaesBeforeSafeCheckService.updateAnaesBeforeSafeCheck(anaesBeforeSafeCheck);
		
		logger.info("--------------------end updateAnaesBeforeSafeCheck--------------------");
		return resp.getJsonStr();
	}

}
