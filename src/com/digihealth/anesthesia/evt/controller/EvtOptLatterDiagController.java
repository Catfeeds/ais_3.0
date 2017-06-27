package com.digihealth.anesthesia.evt.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.digihealth.anesthesia.common.entity.ResponseValue;
import com.digihealth.anesthesia.common.web.BaseController;
import com.digihealth.anesthesia.evt.formbean.SearchFormBean;
import com.digihealth.anesthesia.evt.po.EvtOptLatterDiag;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

@Controller
@RequestMapping(value = "/operation")
public class EvtOptLatterDiagController extends BaseController {
	
	@RequestMapping(value = "/searchOptLatterDiagList")
	@ResponseBody
	@ApiOperation(value = "查询诊断名称列表", httpMethod = "POST", notes = "查询诊断名称列表")
	public String searchOptLatterDiagList(@ApiParam(name = "searchBean", value = "参数")@RequestBody SearchFormBean searchBean) {
		logger.info("begin searchOptLatterDiagList");
		ResponseValue resp = new ResponseValue();
		List<EvtOptLatterDiag> resultList = evtOptLatterDiagService.searchOptLatterDiagList(searchBean);
		resp.put("resultList", resultList);
		logger.info("end searchOptLatterDiagList");
		return resp.getJsonStr();
	}

	/**
	 * 批量保存事件数据
	 * 
	 * @param optLatterDiagList
	 * @return
	 */
	@RequestMapping(value = "/saveOptLatterDiag")
	@ResponseBody
	@ApiOperation(value = "批量保存诊断名称事件", httpMethod = "POST", notes = "批量保存诊断名称事件")
	public String saveOptLatterDiag(@ApiParam(name = "optLatterDiagList", value = "参数")@RequestBody List<EvtOptLatterDiag> optLatterDiagList) {
		logger.info("begin saveOptLatterDiag");
		ResponseValue resp = new ResponseValue();
		evtOptLatterDiagService.saveOptLatterDiag(optLatterDiagList);
		logger.info("end saveOptLatterDiag");
		return resp.getJsonStr();
	}
	
	
	/**
	@RequestMapping(value = "/insertOptLatterDiag")
	@ResponseBody
	public Map insertOptLatterDiag(@RequestBody OptLatterDiag optLatterDiag) {
		Map map = new HashMap();
		try {
			optLatterDiagService.insertOptLatterDiag(optLatterDiag);
			map.put("result", true);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("result",false);
		}
		return map;
	}
	
	@RequestMapping(value = "/updateOptLatterDiag")
	@ResponseBody
	public Map updateOptLatterDiag(@RequestBody OptLatterDiag optLatterDiag) {
		Map map = new HashMap();
		try {
			optLatterDiagService.updateOptLatterDiag(optLatterDiag);
			map.put("result", true);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("result",false);
		}
		return map;
	}
	
	@RequestMapping(value = "/deleteOptLatterDiag")
	@ResponseBody
	public Map deleteOptLatterDiag(@RequestBody OptLatterDiag optLatterDiag) {
		Map map = new HashMap();
		try {
			optLatterDiagService.deleteOptLatterDiag(optLatterDiag);
			map.put("result", true);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("result",false);
		}
		return map;
	}
	
	**/
}
