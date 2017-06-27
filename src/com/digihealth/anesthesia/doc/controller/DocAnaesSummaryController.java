/**     
 * @discription 在此输入一句话描述此文件的作用
 * @author liukui       
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
import com.digihealth.anesthesia.doc.formbean.AnaesSummaryItemFormbean;
import com.digihealth.anesthesia.doc.po.DocAnaesRecord;
import com.digihealth.anesthesia.doc.po.DocAnaesSummary;
import com.digihealth.anesthesia.evt.formbean.SearchFormBean;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

/**
 * Title: AnaesSummaryController.java Description: 描述
 * 
 * @author liukui
 * @created 2015-10-10 下午5:34:19
 */
@Controller
@RequestMapping(value = "/document")
@Api(value="DocAnaesSummaryController",description="麻醉总结处理类")
public class DocAnaesSummaryController extends BaseController {
	
	/**
	 * 查询麻醉总结单
	 * @param searchBean
	 * @return
	 */
	@RequestMapping(value = "/searchAnaesSummaryList")
	@ResponseBody
	@ApiOperation(value="查询麻醉总结单",httpMethod="POST",notes="查询麻醉总结单")
	public String searchAnaesSummaryList(@ApiParam(name="searchBean", value ="查询参数") @RequestBody SearchFormBean searchBean) {
		logger.info("-------------begin searchAnaesSummaryList-------------");
		ResponseValue resp = new ResponseValue();
		List<DocAnaesSummary> anaesSummaryList = docAnaesSummaryService.searchAnaesSummaryList(searchBean);
		resp.put("resultList", anaesSummaryList);
		logger.info("-------------end searchAnaesSummaryList-------------");
		return resp.getJsonStr();
	}
	/**
	 * 获取麻醉总结明细信息
	 * @param searchBean
	 * @return
	 */
	@RequestMapping(value = "/searchAnaesSummaryDetail")
	@ResponseBody
	@ApiOperation(value="获取麻醉总结明细信息",httpMethod="POST",notes="获取麻醉总结明细信息")
	public String searchAnaesSummaryDetail(@ApiParam(name="searchBean", value ="查询参数") @RequestBody SearchFormBean searchBean){
		logger.info("-------------begin searchAnaesSummaryDetail-------------");
		ResponseValue result = new ResponseValue();

		//手术信息表
		BasRegOpt opt = basRegOptService.searchRegOptById(searchBean.getRegOptId());
	
		//麻醉总结数据
		result.put("anaesSummaryFormbean", docAnaesSummaryService.getAnaesSummaryDetail(searchBean.getRegOptId()));
		result.put("regOpt", opt);	
		//血型
		String blood = "";
		//出入量数据
		DocAnaesRecord anaesRecord = docAnaesRecordService.getAnaesRecord(searchBean.getRegOptId());
		if(null != anaesRecord)
		{
			docAnaesSummaryService.getAmountDetail(result, anaesRecord.getAnaRecordId());
			blood = evtInEventService.getBloodByDocId(anaesRecord.getAnaRecordId());
		}
		result.put("blood", blood);	
		
		logger.info("-------------end searchAnaesSummaryDetail-------------");
		return result.getJsonStr();
	}
	
	/**
	 * 修改麻醉总结单
	 * @param anaesSummary
	 * @return
	 */
	@RequestMapping(value = "/saveAnaesSummaryDetail")
	@ResponseBody
	@ApiOperation(value="修改麻醉总结单",httpMethod="POST",notes="修改麻醉总结单")
	public String saveAnaesSummaryDetail(@ApiParam(name="anaesSummaryItemFormbean", value ="修改参数") @RequestBody AnaesSummaryItemFormbean anaesSummaryItemFormbean) {
		logger.info("-------------begin saveAnaesSummaryDetail-------------");
		ResponseValue resp = new ResponseValue();
		ValidatorBean validatorBean = beanValidator(anaesSummaryItemFormbean.getAnaesSummary());
		if(!(validatorBean.isValidator())){
			resp.setResultCode("10000001");
			resp.setResultMessage(validatorBean.getMessage());
			return resp.getJsonStr();
		}
		docAnaesSummaryService.saveAnaesSummaryDetail(anaesSummaryItemFormbean);
		logger.info("-------------end saveAnaesSummaryDetail-------------");
		return resp.getJsonStr();
	}

}
