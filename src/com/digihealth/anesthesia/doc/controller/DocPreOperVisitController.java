package com.digihealth.anesthesia.doc.controller;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.digihealth.anesthesia.common.entity.ResponseValue;
import com.digihealth.anesthesia.common.web.BaseController;
import com.digihealth.anesthesia.doc.po.DocPreOperVisit;
import com.digihealth.anesthesia.evt.formbean.SearchRegOptByIdFormBean;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

@Controller
@RequestMapping(value = "/document")
@Api(value = "DocPreOperVisitController", description = "麻醉术前访视单处理类")
public class DocPreOperVisitController extends BaseController {
	/**
	 * 查询麻醉术前访视单 <功能详细描述>
	 * 
	 * @param regOptId
	 * @return
	 * @see [类、类#方法、类#成员]
	 */
	@RequestMapping(value = "/searchPreOperVisit")
	@ResponseBody
	@ApiOperation(value="查询麻醉术前访视单",httpMethod="POST",notes="查询麻醉术前访视单")
	public String searchPreOperVisit(@ApiParam(name="map", value ="查询参数") @RequestBody Map<String, Object> map) {
		logger.debug("-------------------searchPreOperVisit begin-------------------");
		String regOptId = null != map.get("regOptId") ? map.get("regOptId").toString() : "";
		ResponseValue resp = new ResponseValue();
		DocPreOperVisit preOperVisit = docPreOperVisitService.searchPreOperVisit(regOptId);

		if (null == preOperVisit) {
			resp.setResultCode("80000001");
			resp.setResultMessage("麻醉术前访视单不存在!");
			return resp.getJsonStr();
		}
		List<SearchRegOptByIdFormBean> searchRegOptByIdFormBeanList = basRegOptService.searchApplicationById(regOptId);
		SearchRegOptByIdFormBean searchRegOptByIdFormBean = searchRegOptByIdFormBeanList != null ? searchRegOptByIdFormBeanList
				.get(0) : null;

		if (null == preOperVisit.getAnesthetistSign()
				&& null != searchRegOptByIdFormBean
				&& StringUtils.isNotBlank(searchRegOptByIdFormBean
						.getAnesthetistName())) {
			preOperVisit.setAnesthetistSign(searchRegOptByIdFormBean
					.getAnesthetistName());
		}
		resp.put("searchRegOptByIdFormBean", searchRegOptByIdFormBean);
		resp.put("preOperVisit", preOperVisit);
		resp.setResultCode("1");
		resp.setResultMessage("查询麻醉术前访视单成功!");
		logger.debug("-------------------searchPreOperVisit end-------------------");

		return resp.getJsonStr();
	}

	/**
	 * 更新麻醉术前访视单 <功能详细描述>
	 * 
	 * @param preOperVisit
	 * @return
	 * @see [类、类#方法、类#成员]
	 */
	@RequestMapping(value = "/updatePreOperVisit")
	@ResponseBody
	@ApiOperation(value="更新麻醉术前访视单",httpMethod="POST",notes="更新麻醉术前访视单")
	public String updatePreOperVisit(@ApiParam(name="preOperVisit", value ="查询参数") @RequestBody DocPreOperVisit preOperVisit) {
		logger.debug("-------------------updatePreOperVisit begin-------------------");
		ResponseValue resp = new ResponseValue();
		if (null == preOperVisit) {
			resp.setResultCode("80000001");
			resp.setResultMessage("麻醉术前访视单不存在!");
			return resp.getJsonStr();
		}
		docPreOperVisitService.updatePreOperVisit(preOperVisit);
		resp.setResultCode("1");
		resp.setResultMessage("麻醉术前访视单更新成功!");
		logger.debug("-------------------updatePreOperVisit end-------------------");
		return resp.getJsonStr();
	}
}
