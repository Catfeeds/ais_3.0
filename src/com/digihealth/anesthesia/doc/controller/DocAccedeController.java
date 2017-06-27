package com.digihealth.anesthesia.doc.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.digihealth.anesthesia.basedata.formbean.DispatchPeopleNameFormBean;
import com.digihealth.anesthesia.basedata.formbean.SysCodeFormbean;
import com.digihealth.anesthesia.common.beanvalidator.ValidatorBean;
import com.digihealth.anesthesia.common.entity.ResponseValue;
import com.digihealth.anesthesia.common.utils.Exceptions;
import com.digihealth.anesthesia.common.utils.JsonType;
import com.digihealth.anesthesia.common.utils.StringUtils;
import com.digihealth.anesthesia.common.web.BaseController;
import com.digihealth.anesthesia.doc.formbean.AccedeFormBean;
import com.digihealth.anesthesia.doc.po.DocAccede;
import com.digihealth.anesthesia.doc.po.DocPreVisit;
import com.digihealth.anesthesia.evt.formbean.SearchRegOptByIdFormBean;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

@Controller
@RequestMapping(value = "/document")
@Api(value = "DocAccedeController", description = "麻醉同意书处理类")
public class DocAccedeController extends BaseController {

	/**
	 * 
	 * @discription 根据手术ID获取麻醉同意书
	 * @author chengwang
	 * @created 2015-10-10 下午5:13:48
	 * @param regOptId
	 * @return
	 */
	@RequestMapping(value = "/searchAccedeByRegOptId")
	@ResponseBody
	@ApiOperation(value = "根据手术ID获取麻醉同意书", httpMethod = "POST", notes = "根据手术ID获取麻醉同意书")
	public String searchAccedeByRegOptId(
			@ApiParam(name = "map", value = "统计查询参数") @RequestBody Map map) {
		logger.info("-----------------start searchAccedeByRegOptId-----------------");
		ResponseValue resp = new ResponseValue();
		String regOptId = map.get("regOptId") != null ? map.get("regOptId")
				.toString() : "";
		DocAccede accede = docAccedeService.searchAccedeByRegOptId(regOptId);
		if (accede == null) {
			resp.setResultCode("30000002");
			resp.setResultMessage("麻醉同意书不存在");
			return resp.getJsonStr();
		}

		List<Map> anaseMethodList = new ArrayList<Map>();
		String[] code = null;
		String[] name = null;
		// if (null == accede.getAnaseMethod() ||
		// "".equals(accede.getAnaseMethod()))
		// {
		// 麻醉方法从术前访视单中获取
		DocPreVisit preVisit = docPreVisitService
				.searchPreVisitByRegOptId(regOptId);
		if (null != preVisit && null != preVisit.getDesignedAnaesCode()
				&& null != preVisit.getDesignedAnaes()) {

			code = preVisit.getDesignedAnaesCode().split(",");
			name = preVisit.getDesignedAnaes().split(",");
		}
		// }
		// else
		// {
		// code = accede.getAnaseMethodCode().split(",");
		// name = accede.getAnaseMethod().split(",");
		//
		// }
		if (null != code && null != name && code.length == name.length) {
			for (int i = 0; i < code.length; i++) {
				Map anaesMethodmap = new HashMap();
				anaesMethodmap.put("anaMedId", code[i]);
				anaesMethodmap.put("name", name[i]);
				anaseMethodList.add(anaesMethodmap);
				accede.setAnaseMethodList(anaseMethodList);
			}
		}

		DispatchPeopleNameFormBean dispatchPeople = basDispatchService
				.searchPeopleNameByRegOptId(map.get("regOptId") != null ? map
						.get("regOptId").toString() : "");
		if (dispatchPeople != null) {
			accede.setAnaestheitistName(dispatchPeople.getAnesthetistName() != null ? dispatchPeople
					.getAnesthetistName() : "");
		}

		List<SearchRegOptByIdFormBean> searchRegOptByIdFormBean = basRegOptService
				.searchApplicationById(map.get("regOptId").toString());
		resp.put("result", "true");
		resp.put("accedeItem", accede);
		resp.put(
				"regOptItem",
				searchRegOptByIdFormBean != null ? searchRegOptByIdFormBean
						.get(0) : null);
		resp.put("accedeInformedList", docAccedeService.searchAccedeInformedListById(accede.getAccedeId()));

		logger.info("-----------------end searchAccedeByRegOptId-----------------");
		return resp.getJsonStr();
	}

	/**
	 * 
	 * @discription 修改麻醉同意书
	 * @author chengwang
	 * @created 2015-10-20 上午9:33:40
	 * @param docId
	 * @return
	 */
	@RequestMapping(value = "/updateAccede")
	@ResponseBody
	@ApiOperation(value = "修改麻醉同意书", httpMethod = "POST", notes = "修改麻醉同意书")
	public String updateAccedeByDocId(
			@ApiParam(name = "accedeFormBean", value = "修改参数") @RequestBody AccedeFormBean accedeFormBean) {
		logger.info("-----------------start updateAccede-----------------");
		ResponseValue resp = new ResponseValue();
		ValidatorBean validatorBean = beanValidator(accedeFormBean);
		if (!(validatorBean.isValidator())) {
			resp.setResultCode("10000001");
			resp.setResultMessage(validatorBean.getMessage());
			return resp.getJsonStr();
		}
		getAnaesMethod(accedeFormBean);
		resp = docAccedeService.updateAccede(accedeFormBean);
		logger.info("-----------------end updateAccede-----------------");
		return resp.getJsonStr();
	}

	/**
	 * 
	 * 
	 * @discription 提交麻醉同意书
	 * @author chengwang
	 * @created 2015-10-20 上午9:33:40
	 * @param docId
	 * @return
	 */
	@RequestMapping(value = "/submitAccede")
	@ResponseBody
	@ApiOperation(value = "提交麻醉同意书", httpMethod = "POST", notes = "提交麻醉同意书")
	public String submitAccedeByDocId(
			@ApiParam(name = "accede", value = "保存参数") @RequestBody AccedeFormBean accede) {
		logger.info("-----------------start submitAccede-----------------");
		ResponseValue resp = new ResponseValue();
		ValidatorBean validatorBean = beanValidator(accede);
		if (!(validatorBean.isValidator())) {
			resp.setResultCode("10000001");
			resp.setResultMessage(validatorBean.getMessage());
			return resp.getJsonStr();
		}
		getAnaesMethod(accede);
		accede.getAccede().setProcessState("END");
		resp = docAccedeService.updateAccede(accede);
		logger.info("-----------------end submitAccede-----------------");
		return resp.getJsonStr();
	}

	private void getAnaesMethod(AccedeFormBean accede) {
		if (null != accede.getAccede().getAnaseMethodList()
				&& accede.getAccede().getAnaseMethodList().size() > 0) {
			accede.getAccede().setAnaseMethodCode("");
			accede.getAccede().setAnaseMethod("");
			for (Map anaesMethodMap : accede.getAccede().getAnaseMethodList()) {

				accede.getAccede().setAnaseMethodCode(accede.getAccede().getAnaseMethodCode()
						+ anaesMethodMap.get("anaMedId") + ",");
				accede.getAccede().setAnaseMethod(accede.getAccede().getAnaseMethod()
						+ anaesMethodMap.get("name") + ",");
			}

			if (!StringUtils.isEmpty(accede.getAccede().getAnaseMethodCode())
					&& !StringUtils.isEmpty(accede.getAccede().getAnaseMethod())) {
				accede.getAccede().setAnaseMethodCode(accede.getAccede().getAnaseMethodCode()
						.substring(0, accede.getAccede().getAnaseMethodCode().length() - 1));

				accede.getAccede().setAnaseMethod(accede.getAccede().getAnaseMethod().substring(0,
						accede.getAccede().getAnaseMethod().length() - 1));
			}
		}
	}

	private void getAnaesMethod(DocAccede accede) {
		if (null != accede.getAnaseMethodList()
				&& accede.getAnaseMethodList().size() > 0) {
			accede.setAnaseMethodCode("");
			accede.setAnaseMethod("");
			for (Map anaesMethodMap : accede.getAnaseMethodList()) {

				accede.setAnaseMethodCode(accede.getAnaseMethodCode()
						+ anaesMethodMap.get("anaMedId") + ",");
				accede.setAnaseMethod(accede.getAnaseMethod()
						+ anaesMethodMap.get("name") + ",");
			}

			if (!StringUtils.isEmpty(accede.getAnaseMethodCode())
					&& !StringUtils.isEmpty(accede.getAnaseMethod())) {
				accede.setAnaseMethodCode(accede.getAnaseMethodCode()
						.substring(0, accede.getAnaseMethodCode().length() - 1));

				accede.setAnaseMethod(accede.getAnaseMethod().substring(0,
						accede.getAnaseMethod().length() - 1));
			}
		}
	}
}
