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

import com.digihealth.anesthesia.basedata.po.BasRegOpt;
import com.digihealth.anesthesia.common.beanvalidator.ValidatorBean;
import com.digihealth.anesthesia.common.entity.ResponseValue;
import com.digihealth.anesthesia.common.web.BaseController;
import com.digihealth.anesthesia.doc.po.DocSelfPayAccede;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

/**
 * Title: PreVisitController.java Description: 描述
 * 
 * @author chengwang
 * @created 2015-10-10 下午5:34:19
 */
@Controller
@RequestMapping(value = "/document")
@Api(value="DocSafeCheckController",description="医保病人麻醉科自费项目同意书处理类")
public class DocSelfPayAccedeController extends BaseController {

	/**
	 * 
	 * @discription 根据手术ID获取医保病人麻醉科自费项目同意书
	 * @author chengwang
	 * @created 2015-10-10 下午5:13:48
	 * @param selfPayAccede
	 * @return
	 */
	@RequestMapping(value = "/searchSelfPayAccedeByRegOptId")
	@ResponseBody
	@ApiOperation(value="根据手术ID获取医保病人麻醉科自费项目同意书",httpMethod="POST",notes="根据手术ID获取医保病人麻醉科自费项目同意书")
	public String searchSelfPayAccedeByRegOptId(@ApiParam(name="selfPayAccede", value ="查询参数") @RequestBody DocSelfPayAccede selfPayAccede) {
		logger.info("begin searchSelfPayAccedeByRegOptId");
		ResponseValue req = new ResponseValue();
		BasRegOpt regOpt = basRegOptService.searchRegOptById(selfPayAccede.getRegOptId());
		//type =1 查药品 type=2查其他
		List<DocSelfPayAccede> selfMedPayList = docSelfPayAccedeService.searchSelfPayAccedeByRegOptId(selfPayAccede.getRegOptId(), "1");
		List<DocSelfPayAccede> selfOtherPayList = docSelfPayAccedeService.searchSelfPayAccedeByRegOptId(selfPayAccede.getRegOptId(), "2");
		
		req.put("regOpt", regOpt);
		req.put("selfMedPayList", selfMedPayList);
		req.put("selfOtherPayList", selfOtherPayList);
		logger.info("end searchSelfPayAccedeByRegOptId");
		return req.getJsonStr();
	}

	
	@RequestMapping(value = "/updateSelfPayAccede")
	@ResponseBody
	@ApiOperation(value="修改医保病人麻醉科自费项目同意书",httpMethod="POST",notes="修改医保病人麻醉科自费项目同意书")
	public String updateSelfPayAccede(@ApiParam(name="selfPayAccede", value ="修改参数") @RequestBody DocSelfPayAccede selfPayAccede) {
		logger.info("begin updateSelfPayAccede");
		ResponseValue req = new ResponseValue();
		ValidatorBean validatorBean = beanValidator(selfPayAccede);
		if(!(validatorBean.isValidator())){
			req.setResultCode("10000001");
			req.setResultMessage(validatorBean.getMessage());
			return req.getJsonStr();
		}
		req = docSelfPayAccedeService.updateSelfPayAccede(selfPayAccede);
		logger.info("end updateSelfPayAccede");
		return req.getJsonStr();
	}
	
	@RequestMapping(value = "/deleteSelfPayAccedeById")
	@ResponseBody
	@ApiOperation(value="删除医保病人麻醉科自费项目同意书",httpMethod="POST",notes="删除医保病人麻醉科自费项目同意书")
	public String deleteSelfPayAccedeById(@ApiParam(name="selfPayAccede", value ="删除参数") @RequestBody DocSelfPayAccede selfPayAccede){
		ResponseValue req = new ResponseValue();
		int result = docSelfPayAccedeService.deleteByPrimaryKey(selfPayAccede.getId());
		if(result!=1){
			req.setResultCode("10000000");
			req.setResultMessage("删除医保病人麻醉科自费项目同意书成功！");
		}
		return req.getJsonStr();
	}

}
