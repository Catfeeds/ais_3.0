package com.digihealth.anesthesia.evt.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.digihealth.anesthesia.common.entity.ResponseValue;
import com.digihealth.anesthesia.common.web.BaseController;
import com.digihealth.anesthesia.evt.formbean.SearchFormBean;
import com.digihealth.anesthesia.evt.po.EvtOptRealOper;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

@Controller
@RequestMapping(value = "/operation")
public class EvtOptRealOperController extends BaseController {
	
	@RequestMapping(value = "/searchOptRealOperList")
	@ResponseBody
	@ApiOperation(value = "批量查询手术名称事件", httpMethod = "POST", notes = "批量查询手术名称事件")
	public String searchOptRealOperList(@ApiParam(name = "searchBean", value = "参数")@RequestBody SearchFormBean searchBean) {
		logger.info("begin searchOptRealOperList");
		ResponseValue resp = new ResponseValue();
		List<EvtOptRealOper> resultList = evtOptRealOperService.searchOptRealOperList(searchBean);
		resp.put("resultList", resultList);
		logger.info("end searchOptRealOperList");
		return resp.getJsonStr();
	}

	/**
	 * 批量保存事件数据
	 * 
	 * @param optRealOperList
	 * @return
	 */
	@RequestMapping(value = "/saveOptRealOper")
	@ResponseBody
	@ApiOperation(value = "批量保存手术名称事件", httpMethod = "POST", notes = "批量保存手术名称事件")
	public String saveOptRealOper(@ApiParam(name = "optRealOperList", value = "参数")@RequestBody List<EvtOptRealOper> optRealOperList) {
		logger.info("begin saveOptRealOper");
		ResponseValue resp = new ResponseValue();
		evtOptRealOperService.saveOptRealOper(optRealOperList);
		logger.info("end saveOptRealOper");
		return resp.getJsonStr();
	}
	
	/**
	
	@RequestMapping(value = "/insertOptRealOper")
	@ResponseBody
	public Map insertOptRealOper(@RequestBody OptRealOper optRealOper) {
		Map map = new HashMap();
		try {
			optRealOperService.insertOptRealOper(optRealOper);
			map.put("result", true);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("result",false);
		}
		return map;
	}
	
	@RequestMapping(value = "/updateOptRealOper")
	@ResponseBody
	public Map updateOptRealOper(@RequestBody OptRealOper optRealOper) {
		Map map = new HashMap();
		try {
			optRealOperService.updateOptRealOper(optRealOper);
			map.put("result", true);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("result",false);
		}
		return map;
	}
	
	@RequestMapping(value = "/deleteOptRealOper")
	@ResponseBody
	public Map deleteOptRealOper(@RequestBody OptRealOper optRealOper) {
		Map map = new HashMap();
		try {
			optRealOperService.deleteOptRealOper(optRealOper);
			map.put("result", true);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("result",false);
		}
		return map;
	}
	**/
}
