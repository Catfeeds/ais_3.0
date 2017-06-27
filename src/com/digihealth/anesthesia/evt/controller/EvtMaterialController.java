package com.digihealth.anesthesia.evt.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.digihealth.anesthesia.basedata.po.BasRegOpt;
import com.digihealth.anesthesia.basedata.utils.UserUtils;
import com.digihealth.anesthesia.common.beanvalidator.ValidatorBean;
import com.digihealth.anesthesia.common.entity.ResponseValue;
import com.digihealth.anesthesia.common.web.BaseController;
import com.digihealth.anesthesia.doc.po.DocAnaesRecord;
import com.digihealth.anesthesia.evt.formbean.MaterialFormBean;
import com.digihealth.anesthesia.evt.formbean.SearchFormBean;
import com.digihealth.anesthesia.evt.po.EvtMaterial;
import com.digihealth.anesthesia.evt.po.EvtOptRealOper;
import com.digihealth.anesthesia.evt.service.EvtParticipantService;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

@Controller
@RequestMapping(value = "/operation")
public class EvtMaterialController extends BaseController {

	@RequestMapping(value = "/selectMaterial")
	@ResponseBody
	@ApiOperation(value = "查询安装体内置入材料情况", httpMethod = "POST", notes = "查询安装体内置入材料情况")
	public String selectMaterial(@ApiParam(name = "formbean", value = "参数") @RequestBody SearchFormBean searchBean) {
		logger.info("--------- begin selectMaterial ------------");
		ResponseValue req = new ResponseValue();

		MaterialFormBean bean = new MaterialFormBean();

		// 获取手术人员信息
		BasRegOpt regOpt = basRegOptService.searchRegOptById(searchBean.getRegOptId());
		// 麻醉记录单
		DocAnaesRecord anaesRecord = docAnaesRecordService.searchAnaesRecordByRegOptId(searchBean.getRegOptId());
		// 实施手术
		searchBean.setDocId(anaesRecord.getAnaRecordId());
		List<EvtOptRealOper> optRealOperList = evtOptRealOperService.searchOptRealOperList(searchBean);
		// 手术名称
		String realOper = "";
		for (EvtOptRealOper optRealOper : optRealOperList) {
			realOper += optRealOper.getName() + ",";
		}
		if (realOper.length() > 0)
			realOper = realOper.substring(0, realOper.length() - 1);

		// 手术医生列表
		searchBean.setRole(EvtParticipantService.ROLE_OPERAT);
		searchBean.setType("06");
		String operatDoc = statisticsService.getNameStrByDocId(searchBean);
		// 巡回护士列表
		searchBean.setRole(EvtParticipantService.ROLE_NURSE);
		searchBean.setType("05");
		String circunurse = statisticsService.getNameStrByDocId(searchBean);

		bean.setName(regOpt.getName());
		bean.setSex(regOpt.getSex());
		bean.setAge(UserUtils.getAge(regOpt.getAge() == null ? "" : regOpt.getAge() + "", regOpt.getAgeMon() == null ? "" : regOpt.getAgeMon() + "", regOpt.getAgeDay()));
		bean.setDeptName(regOpt.getDeptName());
		bean.setBed(regOpt.getBed());
		bean.setRealoperationName(realOper);
		bean.setDocId(anaesRecord.getAnaRecordId());
		bean.setOperaDate(regOpt.getOperaDate());
		bean.setOperatorName(operatDoc);
		bean.setCircunurseName(circunurse);

		List<EvtMaterial> materialList = evtMaterialService.selectMaterialByDocId(anaesRecord.getAnaRecordId());

		req.put("materialFormBean", bean);
		req.put("anaesRecord", anaesRecord);
		req.put("materialList", materialList);
		logger.info("--------- end selectMaterial ------------");
		return req.getJsonStr();
	}

	@RequestMapping(value = "/updateMaterial")
	@ResponseBody
	@ApiOperation(value = "修改安装体内置入材料情况", httpMethod = "POST", notes = "修改安装体内置入材料情况")
	public String updateMaterial(@ApiParam(name = "material", value = "参数") @RequestBody EvtMaterial material) {
		logger.info("--------- begin updateMaterial ------------");
		ResponseValue req = new ResponseValue();
		ValidatorBean validatorBean = beanValidator(material);
		if (!(validatorBean.isValidator())) {
			req.setResultCode("10000001");
			req.setResultMessage(validatorBean.getMessage());
			return req.getJsonStr();
		}
		evtMaterialService.updateMaterial(material);
		logger.info("--------- end updateMaterial ------------");
		return req.getJsonStr();
	}

	@RequestMapping(value = "/deleteMaterialById")
	@ResponseBody
	@ApiOperation(value = "删除安装体内置入材料情况", httpMethod = "POST", notes = "删除安装体内置入材料情况")
	public String deleteMaterialById(@ApiParam(name = "material", value = "参数") @RequestBody EvtMaterial material) {
		logger.info("--------- begin deleteMaterialById ------------");
		ResponseValue req = new ResponseValue();
		evtMaterialService.deleteMaterialById(material.getId());
		logger.info("--------- end deleteMaterialById ------------");
		return req.getJsonStr();
	}
}
