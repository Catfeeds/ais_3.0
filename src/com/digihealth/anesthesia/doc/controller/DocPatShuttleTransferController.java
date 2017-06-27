package com.digihealth.anesthesia.doc.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.digihealth.anesthesia.common.entity.ResponseValue;
import com.digihealth.anesthesia.common.web.BaseController;
import com.digihealth.anesthesia.doc.formbean.PatShuttleTransferFormbean;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

/**
 * Title: PatShuttleTransferController.java Description: 描述
 * 
 * @author liukui
 * 手术患者接送交接单
 */
@Controller
@RequestMapping(value = "/document")
@Api(value="DocPatShuttleTransferController",description="手术患者接送交接单处理类")
public class DocPatShuttleTransferController extends BaseController {

	/**
	 * 
	 * @discription 手术患者接送交接单查询
	 * @author liukui
	 * @created 2015-10-10 下午5:13:48
	 * @param regOptId
	 * @return
	 */
	@RequestMapping(value = "/searchPatShuttleTransfer")
	@ResponseBody
	@ApiOperation(value="手术患者接送交接单查询",httpMethod="POST",notes="手术患者接送交接单查询")
	public String searchPatShuttleTransfer(@ApiParam(name="map", value ="查询参数") @RequestBody Map<String, Object> map) {
		logger.info("--------------------begin searchPatShuttleTransfer--------------------");
		ResponseValue resp = new ResponseValue();
		docPatShuttleTransferService.searchPatShuttleTransfer(map.get("regOptId").toString(),resp);
		resp.put("regOptItem", basRegOptService.searchRegOptById(map.get("regOptId").toString()));
		logger.info("--------------------end searchPatShuttleTransfer--------------------");
		return resp.getJsonStr();
	}

	/**
	 * 
	 * @discription 手术患者接送交接单修改
	 * @author liukui
	 * @created 2015-10-20 上午9:33:40
	 * @param docId
	 * @return
	 */
	@RequestMapping(value = "/savePatShuttleTransfer")
	@ResponseBody
	@ApiOperation(value="手术患者接送交接单修改",httpMethod="POST",notes="手术患者接送交接单修改")
	public String savePatShuttleTransfer(@ApiParam(name="record", value ="修改参数") @RequestBody PatShuttleTransferFormbean record) {
		logger.info("--------------------begin savePatShuttleTransfer--------------------");
		ResponseValue resp = new ResponseValue();
		resp = docPatShuttleTransferService.savePatShuttleTransfer(record, resp);
		logger.info("--------------------end savePatShuttleTransfer--------------------");
		return resp.getJsonStr();
	}
}
