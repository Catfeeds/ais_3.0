package com.digihealth.anesthesia.evt.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.digihealth.anesthesia.common.beanvalidator.ValidatorBean;
import com.digihealth.anesthesia.common.entity.ResponseValue;
import com.digihealth.anesthesia.common.web.BaseController;
import com.digihealth.anesthesia.evt.formbean.SearchFormBean;
import com.digihealth.anesthesia.evt.po.EvtShiftChange;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;


/**
 * 
 * Title: ShiftChangeController.java    
 * Description: 人员交接班事件
 * @author liukui       
 * @created 2015-12-15 下午1:56:40
 */
@Controller
@RequestMapping(value = "/operation")
@Api(value = "EvtShiftChangeController", description = "交接班事件处理类")
public class EvtShiftChangeController extends BaseController{

	/**
	 * 交接班事件
	 * @param searchBean
	 * @return
	 */
	@RequestMapping(value = "/searchShiftChangeList")
	@ResponseBody
	@ApiOperation(value = "查询交接班事件", httpMethod = "POST", notes = "查询抢救事件")
	public String searchShiftChangeList(@ApiParam(name = "searchBean", value = "系统查询参数") @RequestBody SearchFormBean searchBean) {
		// 交接班			
		logger.info("begin searchShiftChangeList");
		ResponseValue respValue = new ResponseValue();
		List<EvtShiftChange> shiftChangeList = evtShiftChangeService.searchShiftChangeList(searchBean);
		respValue.put("resultList", shiftChangeList);
		logger.info("end searchShiftChangeList");
		return respValue.getJsonStr();
	}
	
	/**
	 * 保存交接班信息
	 * @param shiftChange
	 * @return
	 */
	@RequestMapping(value = "/saveShiftChange")
	@ResponseBody
	@ApiOperation(value = "保存交接班事件", httpMethod = "POST", notes = "保存交接班事件")
	public String saveShiftChange(@ApiParam(name = "shiftChange", value = "交接班事件对象") @RequestBody EvtShiftChange shiftChange) {
		logger.info("begin saveShiftChange");
		ResponseValue respValue = new ResponseValue();
		
		//先校验接班人密码信息是否正确，如果校验不通过，则不保存交班信息
        basUserService.checkUserById(respValue, shiftChange.getShiftChangePeopleId(), shiftChange.getShiftChangePeoplePwd());
        if (!"1".equals(respValue.getResultCode()))
        {
            return respValue.getJsonStr();
        }
		
		ValidatorBean validatorBean = beanValidator(shiftChange);
		if(!(validatorBean.isValidator())){
				respValue.setResultCode("10000001");
				respValue.setResultMessage(validatorBean.getMessage());
				return respValue.getJsonStr();
		}
		evtShiftChangeService.saveShiftChange(shiftChange,respValue);
		
		logger.info("end saveShiftChange");
		return respValue.getJsonStr();
	}
	
	
	@RequestMapping(value = "/deleteShiftChange")
	@ResponseBody
	@ApiOperation(value = "删除交接班事件", httpMethod = "POST", notes = "删除交接班事件")
	public String deleteShiftChange(@ApiParam(name = "id", value = "主键") @RequestBody Integer id) {
		logger.info("begin deleteShiftChange");
		ResponseValue respValue = new ResponseValue();
		evtShiftChangeService.deleteShiftChange(id);
		logger.info("end deleteShiftChange");
		return respValue.getJsonStr();
	}
	
}
