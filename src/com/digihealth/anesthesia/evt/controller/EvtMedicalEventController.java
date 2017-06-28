package com.digihealth.anesthesia.evt.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.digihealth.anesthesia.common.beanvalidator.ValidatorBean;
import com.digihealth.anesthesia.common.entity.ResponseValue;
import com.digihealth.anesthesia.common.web.BaseController;
import com.digihealth.anesthesia.doc.po.DocAnaesRecord;
import com.digihealth.anesthesia.evt.formbean.MedicalDetailFormbean;
import com.digihealth.anesthesia.evt.formbean.RegOptOperMedicaleventFormBean;
import com.digihealth.anesthesia.evt.formbean.SearchFormBean;
import com.digihealth.anesthesia.evt.formbean.SearchOptOperMedicalevent;
import com.digihealth.anesthesia.evt.po.EvtMedicalEvent;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

@Controller
@RequestMapping(value = "/operation")
public class EvtMedicalEventController extends BaseController {

	@RequestMapping(value = "/serarchMedicaleventList")
	@ResponseBody
	@ApiOperation(value = "查询用药事件", httpMethod = "POST", notes = "查询用药事件")
	public String searchMedicaleventList(@ApiParam(name = "searchBean", value = "参数")@RequestBody SearchFormBean searchBean) {
		logger.info("begin serarchMedicaleventList");
		ResponseValue resp = new ResponseValue();
		if(null == searchBean)
		{
			resp.setResultCode("10000001");
            resp.setResultMessage("查询对象不能为空");
		}else
		{
			List<SearchOptOperMedicalevent> resultList = new ArrayList<SearchOptOperMedicalevent>();
			
			//如果没有传文书ID，传了regOptId,通过regOptId得到文书ID
			if(StringUtils.isBlank(searchBean.getDocId()))
			{
				String regOptid = searchBean.getRegOptId();
				if(StringUtils.isNotBlank(regOptid))
				{
					DocAnaesRecord docAnaesRecord = docAnaesRecordService.searchAnaesRecordByRegOptId(regOptid);
					if(null != docAnaesRecord)
					{
						searchBean.setDocId(docAnaesRecord.getAnaRecordId());
						resultList = evtMedicaleventService.searchMedicaleventList(searchBean);
					}
				}
			}else{
				resultList = evtMedicaleventService.searchMedicaleventList(searchBean);
			}
			resp.put("resultList", resultList);
		}
		
		logger.info("end serarchMedicaleventList");
		return resp.getJsonStr();
	}

	@RequestMapping(value = "/searchMedicaleventGroupByCodeList")
	@ResponseBody
	@ApiOperation(value = "分组获取相同用药list", httpMethod = "POST", notes = "分组获取相同用药list")
	public String searchMedicaleventGroupByCodeList(@ApiParam(name = "searchBean", value = "参数")@RequestBody SearchFormBean searchBean) {
		logger.info("begin searchMedicaleventGroupByCodeList");
		ResponseValue resp = new ResponseValue();
		List<RegOptOperMedicaleventFormBean> resultList = evtMedicaleventService.searchMedicaleventGroupByCodeList(searchBean);
		resp.put("resultList", resultList);
		logger.info("end searchMedicaleventGroupByCodeList");
		return resp.getJsonStr();

	}

	@RequestMapping(value = "/saveMedicalevent")
	@ResponseBody
	@ApiOperation(value = "保存用药事件", httpMethod = "POST", notes = "保存用药事件")
	public String saveMedicalevent(@ApiParam(name = "medicalevent", value = "参数")@RequestBody EvtMedicalEvent medicalevent) {
		logger.info("begin saveMedicalevent");
		ResponseValue value = new ResponseValue();
		ValidatorBean validatorBean = beanValidator(medicalevent);
		if (!(validatorBean.isValidator())) {
			value.setResultCode("10000001");
			value.setResultMessage(validatorBean.getMessage());
			return value.getJsonStr();
		}
		evtMedicaleventService.saveMedicalevent(medicalevent, value);
		logger.info("end saveMedicalevent");
		return value.getJsonStr();
	}

	@RequestMapping("/saveMedicalEventDetail")
	@ResponseBody
	@ApiOperation(value = "保存用药事件详情", httpMethod = "POST", notes = "保存用药事件详情")
	public String saveMedicalEventDetail(@ApiParam(name = "medicalevent", value = "参数")@RequestBody MedicalDetailFormbean bean) {
		logger.info("begin saveMedicalEventDetail");
		ResponseValue value = new ResponseValue();
		ValidatorBean validatorBean = beanValidator(bean);
		if (!(validatorBean.isValidator())) {
			value.setResultCode("10000001");
			value.setResultMessage(validatorBean.getMessage());
			return value.getJsonStr();
		}
		evtMedicaleventService.saveMedicalEventDetail(bean, value);
		logger.info("end saveMedicalEventDetail");
		return value.getJsonStr();
	}

	@RequestMapping("/deleteMedicalEventDetail")
	@ResponseBody
	@ApiOperation(value = "删除用药事件详情", httpMethod = "POST", notes = "删除用药事件详情")
	public String deleteMedicalEventDetail(@ApiParam(name = "medicalevent", value = "参数")@RequestBody MedicalDetailFormbean bean) {
		logger.info("begin deleteMedicalEventDetail");
		ResponseValue value = new ResponseValue();
		evtMedicaleventService.deleteMedicalEventDetail(bean, value);
		logger.info("end deleteMedicalEventDetail");
		return value.getJsonStr();
	}

	@RequestMapping(value = "/batchSaveMedicalevent")
	@ResponseBody
	@ApiOperation(value = "批量保存用药事件", httpMethod = "POST", notes = "批量保存用药事件")
	public String batchSaveMedicalevent(@ApiParam(name = "medicalevent", value = "参数")@RequestBody List<EvtMedicalEvent> medicalevents) {
		logger.info("begin saveMedicalevent");
		ResponseValue value = new ResponseValue();
		evtMedicaleventService.batchSaveMedicalevent(medicalevents, value);
		logger.info("end saveMedicalevent");
		return value.getJsonStr();
	}

	@RequestMapping(value = "/deleteMedicalevent")
	@ResponseBody
	@ApiOperation(value = "删除用药事件", httpMethod = "POST", notes = "删除用药事件")
	public String deleteMedicalevent(@ApiParam(name = "medicalevent", value = "参数")@RequestBody EvtMedicalEvent medicalevent) {
		logger.info("begin deleteMedicalevent");
		ResponseValue value = new ResponseValue();
		evtMedicaleventService.deleteMedicalevent(medicalevent);
		logger.info("end deleteMedicalevent");
		return value.getJsonStr();
	}
}
