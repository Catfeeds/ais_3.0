package com.digihealth.anesthesia.sysMng.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.digihealth.anesthesia.basedata.formbean.SystemSearchFormBean;
import com.digihealth.anesthesia.basedata.po.BasBusEntity;
import com.digihealth.anesthesia.common.entity.ResponseValue;
import com.digihealth.anesthesia.common.web.BaseController;
import com.digihealth.anesthesia.sysMng.formbean.BasBusDropDownFormBean;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

@Controller
@RequestMapping(value = "/sys")
@Api(value = "SysBusEntityController", description = "局点处理类")
public class BasBusEntityController extends BaseController {

	@RequestMapping("/selectBusEntityList")
	@ResponseBody
	@ApiOperation(value = "查询局点列表", httpMethod = "POST", notes = "查询局点编号，名称，是否为当前局点等信息列表")
	public String selectBusEntityList(@ApiParam(name = "systemSearchFormBean", value = "系统查询对象") @RequestBody SystemSearchFormBean systemSearchFormBean) {
		logger.info("--------------start selectBusEntityList---------------------------");
		ResponseValue resp = new ResponseValue();
		List<BasBusEntity> sysBusEntityList = basBusEntityService.selectBusEntityList(systemSearchFormBean);
		Integer sysBusEntityTotal = basBusEntityService.selectBusEntityTotal(systemSearchFormBean);
		resp.put("sysBusEntityList", sysBusEntityList);
		resp.put("sysBusEntityTotal", sysBusEntityTotal);
		logger.info("--------------end selectBusEntityList---------------------------");
		return resp.getJsonStr();
	}

	@RequestMapping("/saveBusEntity")
	@ResponseBody
	@ApiOperation(value = "新增局点信息", httpMethod = "POST", notes = "新增局点信息。")
	public String saveBusEntity(@ApiParam(name = "basBusEntity", value = "局点对象") @RequestBody BasBusEntity sysBusEntity) {
		logger.info("--------------start saveBusEntity---------------------------");
		ResponseValue resp = new ResponseValue();
		if (null == sysBusEntity || null == sysBusEntity.getBeid()) {
			resp.setResultCode("200001");
			resp.setResultMessage("存储的对象不能为空。");
		} else {
			String beid = sysBusEntity.getBeid();
			BasBusEntity busEntity = basBusEntityService.selectBusEntityById(beid);
			if (null != busEntity) {
				resp.setResultCode("200002");
				resp.setResultMessage("此编号已经使用过了，请采用其他编号。");
			} else {
				basBusEntityService.saveBusEntity(sysBusEntity);
			}
		}
		logger.info("--------------end saveBusEntity---------------------------");
		return resp.getJsonStr();
	}

	@RequestMapping("/updateBusEntity")
	@ResponseBody
	@ApiOperation(value = "修改局点信息", httpMethod = "POST", notes = "修改局点信息。")
	public String updateBusEntity(@ApiParam(name = "sysBusEntity", value = "局点对象") @RequestBody BasBusEntity sysBusEntity) {
		logger.info("--------------start updateBusEntity---------------------------");
		ResponseValue resp = new ResponseValue();
		if (null == sysBusEntity || null == sysBusEntity.getBeid()) {
			resp.setResultCode("200001");
			resp.setResultMessage("存储的对象不能为空。");
		} else {
			String beid = sysBusEntity.getBeid();
			BasBusEntity busEntity = basBusEntityService.selectBusEntityById(beid);
			if (null == busEntity) {
				resp.setResultCode("200002");
				resp.setResultMessage("不存在这个对象，无法修改!");
			} else {
				basBusEntityService.updateBusEntity(sysBusEntity);
			}
		}
		logger.info("--------------start updateBusEntity---------------------------");
		return resp.getJsonStr();
	}

	@RequestMapping("/delBusEntity")
	@ResponseBody
	@ApiOperation(value = "删除局点信息", httpMethod = "POST", notes = "通过beid删除局点信息")
	public String delBusEntity(@ApiParam(name = "delMap", value = "删除对象") @RequestBody Map<String, Object> delMap) {
		logger.info("--------------start delBusEntity---------------------------");
		ResponseValue resp = new ResponseValue();
		if (null == delMap || null == delMap.get("beid")) {
			resp.setResultCode("200001");
			resp.setResultMessage("要删除的对象不能为空。");
		}
		String beid = delMap.get("beid").toString();
		BasBusEntity sysBusEntity = basBusEntityService.selectBusEntityById(beid);
		if (null == sysBusEntity) {
			resp.setResultCode("200001");
			resp.setResultMessage("要删除的对象不存在。");
		} else {
			basBusEntityService.delBusEntity(beid);
		}
		logger.info("--------------end delBusEntity---------------------------");
		return resp.getJsonStr();
	}

	@RequestMapping("/setCurBe")
	@ResponseBody
	@ApiOperation(value = "设置局点为当前局点", httpMethod = "POST", notes = "通过beid将局点设置为当前局点，其他局点改为非当前局点")
	public String setCurBe(@ApiParam(name = "setMap", value = "删除对象") @RequestBody Map<String, Object> setMap) {
		logger.info("--------------start setCurBe---------------------------");
		ResponseValue resp = new ResponseValue();
		if (null == setMap || null == setMap.get("beid")) {
			resp.setResultCode("200001");
			resp.setResultMessage("要设置的对象不能为空。");
		}
		String beid = setMap.get("beid").toString();
		BasBusEntity basBusEntity = basBusEntityService.selectBusEntityById(beid);
		if (null == basBusEntity) {
			resp.setResultCode("200001");
			resp.setResultMessage("要设置的对象不存在。");
		} else {
			// 判断这个局点不是当前，就去设置一下
			if (null == basBusEntity.getIsCurBe() || basBusEntity.getIsCurBe().intValue() == 0) {
				basBusEntityService.setCurBe(beid);
			}
		}
		logger.info("--------------end setCurBe---------------------------");
		return resp.getJsonStr();
	}

	@RequestMapping("/selectBusForDropDown")
	@ResponseBody
	@ApiOperation(value = "查询局点下拉列表", httpMethod = "POST", notes = "查询局点下拉列表")
	public String selectBusForDropDown() {
		logger.info("--------------start selectBusForDropDown---------------------------");
		ResponseValue resp = new ResponseValue();
		SystemSearchFormBean systemSearchFormBean = new SystemSearchFormBean();
		List<BasBusEntity> basBusEntityList = basBusEntityService.selectBusEntityList(systemSearchFormBean);
		List<BasBusDropDownFormBean> dorpdownList = new ArrayList<BasBusDropDownFormBean>();
		if (null != basBusEntityList && basBusEntityList.size() > 0) {
			for (BasBusEntity sysBusEntity : basBusEntityList) {
				BasBusDropDownFormBean bean = new BasBusDropDownFormBean();
				bean.setBeid(sysBusEntity.getBeid());
				bean.setName(sysBusEntity.getName());
				dorpdownList.add(bean);
			}
		}
		resp.put("sysBusDropDown", dorpdownList);
		logger.info("--------------end selectBusForDropDown---------------------------");
		return resp.getJsonStr();
	}
}
