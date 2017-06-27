/**     
 * @discription 在此输入一句话描述此文件的作用
 * @author liukui       
 * @created 2015-10-10 下午5:34:19    
 * tags     
 * see_to_target     
 */

package com.digihealth.anesthesia.doc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.digihealth.anesthesia.common.entity.ResponseValue;
import com.digihealth.anesthesia.common.web.BaseController;
import com.digihealth.anesthesia.doc.formbean.OptRiskFormBean;
import com.digihealth.anesthesia.doc.po.DocAnaesRecord;
import com.digihealth.anesthesia.doc.po.DocOptRiskEvaluation;
import com.digihealth.anesthesia.evt.formbean.SearchFormBean;
import com.digihealth.anesthesia.evt.formbean.SearchSafeCheckRegOptFormBean;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

/**
 * Title: OptRiskEvaluationController.java Description: 描述
 * 
 * @author liukui
 * @created 2015-10-10 下午5:34:19
 */
@Controller
@RequestMapping(value = "/document")
@Api(value="DocOptRiskEvaluationController",description="风险评估单处理类")
public class DocOptRiskEvaluationController extends BaseController {

	/**
	 * 
	 * @discription 根据手术ID获取手术风险评估信息
	 * @author liukui
	 * @created 2015-10-10 下午5:13:48
	 * @param regOptId
	 * @return
	 */
	@RequestMapping(value = "/searchOptRiskEvaluationByRegOptId")
	@ResponseBody
	@ApiOperation(value="根据手术ID获取手术风险评估信息",httpMethod="POST",notes="根据手术ID获取手术风险评估信息")
	public String searchOptRiskEvaluationByRegOptId(@ApiParam(name="optRiskEvaluation", value ="手术风险评估信息参数") @RequestBody DocOptRiskEvaluation optRiskEvaluation) {
		ResponseValue resp = new ResponseValue();
		logger.info("-------------------begin searchOptRiskEvaluationByRegOptId-------------------");
		DocOptRiskEvaluation optRisk = docOptRiskEvaluationService.searchOptRiskEvaluationByRegOptId(optRiskEvaluation);
		SearchSafeCheckRegOptFormBean searchRegOptByIdFormBean = basRegOptService.searchSafeCheckRegOptById(optRiskEvaluation.getRegOptId());
		DocAnaesRecord anaesRecord = docAnaesRecordService.searchAnaesRecordByRegOptId(optRiskEvaluation.getRegOptId());
		
		SearchFormBean searchBean = new SearchFormBean();
		if (anaesRecord != null) {
			searchBean.setDocId(anaesRecord.getAnaRecordId());
		}
		
		resp.put("optRiskEvaluation", optRisk);
		resp.put("regOpt", searchRegOptByIdFormBean);
		logger.info("-------------------end searchOptRiskEvaluationByRegOptId-------------------");
		return resp.getJsonStr();
	}
	
	/**
	 * 
	 * @discription 修改手术风险评估信息
	 * @author liukui
	 * @created 2015-10-20 上午9:33:40
	 * @param docId
	 * @return
	 */
	@RequestMapping(value = "/saveOptRiskEvaluation")
	@ResponseBody
	@ApiOperation(value="修改手术风险评估信息",httpMethod="POST",notes="修改手术风险评估信息")
	public String saveOptRiskEvaluation(@ApiParam(name="optRiskEvaluation", value ="手术风险评估信息参数") @RequestBody DocOptRiskEvaluation optRiskEvaluation) {
		logger.info("-------------------begin saveOptRiskEvaluation-------------------");
		ResponseValue resp = new ResponseValue();
		docOptRiskEvaluationService.saveOptRiskEvaluation(optRiskEvaluation);
		logger.info("-------------------end saveOptRiskEvaluation-------------------");
		return resp.getJsonStr();
	}

}
