/**     
 * @discription 在此输入一句话描述此文件的作用
 * @author chengwang       
 * @created 2015-10-10 下午5:34:19    
 * tags     
 * see_to_target     
 */

package com.digihealth.anesthesia.doc.controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.digihealth.anesthesia.basedata.formbean.DispatchPeopleNameFormBean;
import com.digihealth.anesthesia.common.beanvalidator.ValidatorBean;
import com.digihealth.anesthesia.common.entity.ResponseValue;
import com.digihealth.anesthesia.common.web.BaseController;
import com.digihealth.anesthesia.doc.po.DocAnaesPostop;
import com.digihealth.anesthesia.doc.po.DocAnaesRecord;
import com.digihealth.anesthesia.evt.formbean.SearchConditionFormBean;
import com.digihealth.anesthesia.evt.formbean.SearchFormBean;
import com.digihealth.anesthesia.evt.formbean.SearchMyOperationFormBean;
import com.digihealth.anesthesia.evt.formbean.SearchRegOptByIdFormBean;
import com.digihealth.anesthesia.evt.po.EvtOptLatterDiag;
import com.digihealth.anesthesia.evt.po.EvtOptRealOper;
import com.digihealth.anesthesia.evt.po.EvtRealAnaesMethod;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

/**
 * Title: AnaesPostopController.java Description: 描述
 * 
 * @author chengwang
 * @created 2015-10-10 下午5:34:19
 */
@Controller
@RequestMapping(value = "/document")
@Api(value="DocAnaesPostopController",description="术后随访处理类")
public class DocAnaesPostopController extends BaseController {

	/**
	 * 
	 * @discription 根据手术ID获取术后随访
	 * @author chengwang
	 * @created 2015-10-10 下午5:13:48
	 * @param regOptId
	 * @return
	 */
	@RequestMapping(value = "/searchAnaesPostopByRegOptId")
	@ResponseBody
	@ApiOperation(value="根据手术ID获取术后随访",httpMethod="POST",notes="根据手术ID获取术后随访")
	public String searchAnaesPostopByRegOptId(@ApiParam(name="map", value ="查询参数") @RequestBody Map map) {
		logger.info("---------------------start searchAnaesPostopByRegOptId--------------------");
		ResponseValue resp = new ResponseValue();
		String regOptId = map.get("regOptId")!=null?map.get("regOptId").toString():"";
		DocAnaesPostop anaesPostop = docAnaesPostopService.searchAnaesPostopByRegOptId(regOptId);
		if(anaesPostop == null){
			resp.setResultCode("80000001");
			resp.setResultMessage("术后访视单不存在!");
			return resp.getJsonStr();
		}
		DispatchPeopleNameFormBean dispatchPeople = basDispatchService.searchPeopleNameByRegOptId(regOptId);
		if(dispatchPeople!=null){
			anaesPostop.setAnaestheitistName(dispatchPeople.getAnesthetistName()!=null?dispatchPeople.getAnesthetistName():"");
		}
		List<SearchRegOptByIdFormBean> searchRegOptByIdFormBean = basRegOptService
				.searchApplicationById(map.get("regOptId").toString());
		
		SearchRegOptByIdFormBean bean = searchRegOptByIdFormBean!=null?searchRegOptByIdFormBean.get(0):null;
		DocAnaesRecord anaesRecord = docAnaesRecordService
				.searchAnaesRecordByRegOptId(regOptId);
		SearchFormBean searchBean = new SearchFormBean();
		searchBean.setDocId(anaesRecord.getAnaRecordId());
		List<EvtRealAnaesMethod> realAnaMdList = evtRealAnaesMethodService
				.searchRealAnaesMethodList(searchBean);
		bean.setDesignedAnaesMethodName("");
		bean.setDesignedOptName("");
		bean.setDiagnosisName("");
		if (realAnaMdList.size() > 0 && realAnaMdList != null) {
			for (int i = 0; i < realAnaMdList.size(); i++) {
				bean.setDesignedAnaesMethodName(bean
						.getDesignedAnaesMethodName()==null?realAnaMdList.get(i).getName() + ",":bean
						.getDesignedAnaesMethodName()
						+ realAnaMdList.get(i).getName() + ",");
			}
		}
		
		if(!org.apache.commons.lang3.StringUtils.isEmpty(bean.getDesignedAnaesMethodName())){
			bean.setDesignedAnaesMethodName(bean.getDesignedAnaesMethodName().substring(0,bean.getDesignedAnaesMethodName().length()-1));
		}

		List<EvtOptLatterDiag> optLDList = evtOptLatterDiagService
				.searchOptLatterDiagList(searchBean);
		if (optLDList.size() > 0 && optLDList != null) {
			for (int i = 0; i < optLDList.size(); i++) {
				bean.setDiagnosisName(bean.getDiagnosisName()==null?optLDList.get(i).getName() + ",":bean.getDiagnosisName()
						+ optLDList.get(i).getName() + ",");
			}
		}
		
		if(!org.apache.commons.lang3.StringUtils.isEmpty(bean.getDiagnosisName())){
			bean.setDiagnosisName(bean.getDiagnosisName().substring(0,bean.getDiagnosisName().length()-1));
		}

		List<EvtOptRealOper> optROList = evtOptRealOperService
				.searchOptRealOperList(searchBean);
		if (optROList.size() > 0 && optROList != null) {
			for (int i = 0; i < optROList.size(); i++) {
				bean.setDesignedOptName(bean.getDesignedOptName()==null?optROList.get(i).getName() + ",":bean.getDesignedOptName()
						+ optROList.get(i).getName() + ",");
			}
		}
		
		if(!org.apache.commons.lang3.StringUtils.isEmpty(bean.getDesignedOptName())){
			bean.setDesignedOptName(bean.getDesignedOptName().substring(0,bean.getDesignedOptName().length()-1));
		}
		
		resp.put("result", "true");
		resp.put("anaesPostopItem", anaesPostop);
		resp.put("searchRegOptByIdFormBean", bean);
		resp.setResultCode("1");
		resp.setResultMessage("查询术后随访成功！");

		logger.info("---------------------end searchAnaesPostopByRegOptId--------------------");
		return resp.getJsonStr();
	}

	/**
	 * 
	 * @discription 修改术后随访
	 * @author chengwang
	 * @created 2015-10-20 上午9:33:40
	 * @param docId
	 * @return
	 */
	@RequestMapping(value = "/updateAnaesPostop")
	@ResponseBody
	@ApiOperation(value="修改术后随访",httpMethod="POST",notes="修改术后随访")
	public String updateAnaesPostopByDocId(@ApiParam(name="anaesPostop", value ="统计查询参数") @RequestBody DocAnaesPostop anaesPostop) {
		logger.info("----------------begin updateAnaesPostop----------------");
		ResponseValue resp = new ResponseValue();
		ValidatorBean validatorBean = beanValidator(anaesPostop);
		if(!(validatorBean.isValidator())){
			resp.setResultCode("10000001");
			resp.setResultMessage(validatorBean.getMessage());
			return resp.getJsonStr();
		}
		resp = docAnaesPostopService.updateAnaesPostop(anaesPostop);
		logger.info("----------------end updateAnaesPostop----------------");
		return resp.getJsonStr();
	}

	
	@RequestMapping(value = "/searchNoEndAnaesPostop")
	@ResponseBody
	@ApiOperation(value="查询未结束的术后随访",httpMethod="POST",notes="查询未结束的术后随访")
	public String searchNoEndAnaesPostop(@ApiParam(name="searchConditionFormBean", value ="统计查询参数") @RequestBody SearchConditionFormBean searchConditionFormBean){
		logger.info("---------------------begin searchNoEndAnaesPostop---------------------");
		ResponseValue resp = new ResponseValue();
		List<SearchMyOperationFormBean> resultList = docAnaesPostopService.searchNoEndAnaesPostop(searchConditionFormBean);
		resp.setResultCode("1");
		resp.setResultMessage("未术后访视病人查询成功");
		resp.put("resultList", resultList);
		resp.put("total", resultList.size());
		logger.info("---------------------end searchNoEndAnaesPostop---------------------");
		return resp.getJsonStr();
	}
	
}
