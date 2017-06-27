package com.digihealth.anesthesia.doc.controller;

import java.util.List;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.digihealth.anesthesia.basedata.formbean.PacuDeviceConfigFormBean;
import com.digihealth.anesthesia.basedata.formbean.PacuDeviceEventFormBean;
import com.digihealth.anesthesia.basedata.formbean.PacuDeviceSpecFormBean;
import com.digihealth.anesthesia.basedata.formbean.SystemSearchFormBean;
import com.digihealth.anesthesia.basedata.po.BasPacuMonitorConfig;
import com.digihealth.anesthesia.common.entity.ResponseValue;
import com.digihealth.anesthesia.common.utils.StringUtils;
import com.digihealth.anesthesia.common.web.BaseController;
import com.digihealth.anesthesia.doc.po.DocAnaesPacuRec;
import com.digihealth.anesthesia.operProceed.formbean.CmdMsg;
import com.digihealth.anesthesia.pacu.core.MyConstants;
import com.digihealth.anesthesia.pacu.datasync.MsgProcess;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

@Controller
@RequestMapping(value = "/document")
@Api(value="DocAnaesPacuRecController",description="复苏室记录单处理类")
/**
 * 复苏室记录单
 * @author dell
 *
 */
public class DocAnaesPacuRecController extends BaseController {
	
	@RequestMapping(value = "/getAnaesPacuRecCard")
	@ResponseBody
	@ApiOperation(value="查询复苏室记录单列表",httpMethod="POST",notes="查询复苏室记录单列表")
	public String getAnaesPacuRecCard(){
		logger.info("-------------------start getAnaesPacuRecCard---------------------");
		ResponseValue resp = new ResponseValue();
		resp.put("anaesPacuRecCard", docAnaesPacuRecService.getAnaesPacuRecCard());
		resp.setResultCode("1");
		resp.setResultMessage("查询复苏室记录单成功");
		logger.info("-------------------end getAnaesPacuRecCard---------------------");
		return resp.getJsonStr();
	}
	
	@RequestMapping(value = "/searchAnaesPacuRecList")
	@ResponseBody
	@ApiOperation(value="查询复苏室记录单列表",httpMethod="POST",notes="查询复苏室记录单列表")
	public String searchAnaesPacuRecList(@ApiParam(name="searchFormBean", value ="查询参数") @RequestBody SystemSearchFormBean searchFormBean){
		logger.info("-------------------start searchAnaesPacuRecList---------------------");
		ResponseValue resp = new ResponseValue();
		resp.put("anaesPacuRecList", docAnaesPacuRecService.searchAnaesPacuRecList(searchFormBean));
		resp.put("total", docAnaesPacuRecService.searchTotalAnaesPacuRecList(searchFormBean));
		resp.setResultCode("1");
		resp.setResultMessage("查询复苏室记录单列表成功");
		logger.info("-------------------end searchAnaesPacuRecList---------------------");
		return resp.getJsonStr();
	}

	/**
	 * 获取设备列表
	 * @return
	 */
	@RequestMapping("/getPacuDeviceByType")
	@ResponseBody
	@ApiOperation(value="获取设备列表",httpMethod="POST",notes="获取设备列表")
	public String getPacuDeviceByType() {
		logger.info("----------------start getPacuDeviceByType------------------------");
		ResponseValue resp = new ResponseValue();
		List<PacuDeviceSpecFormBean> devicesList = docAnaesPacuRecService.getPacuDeviceByType();
		resp.put("resultList", devicesList);
		resp.setResultCode("1");
		resp.setResultMessage("操作成功");
		logger.info("------------------end getPacuDeviceByType------------------------");
		return resp.getJsonStr();
	}
	
	/**
	 * 获取床位上的已选择的设备列表
	 * @param bedId
	 * @return
	 */
	@RequestMapping("/getPacuDeviceConfigList")
	@ResponseBody
	@ApiOperation(value="获取床位上的已选择的设备列表",httpMethod="POST",notes="获取床位上的已选择的设备列表")
	public String getPacuDeviceConfigList(@ApiParam(name="json", value ="查询参数") @RequestBody JSONObject json) {
		logger.info("----------------start getPacuDeviceConfigList------------------------");
		ResponseValue resp = new ResponseValue();
		String bedId = json.getString("bedId");
		String beid = (String) json.get("beid");
		if (StringUtils.isBlank(beid)) {
			beid = getBeid();
		}
		List<PacuDeviceConfigFormBean> pacuDeviceList = docAnaesPacuRecService.getPacuDeviceConfigList(bedId, beid);
		resp.put("resultList", pacuDeviceList);
		resp.setResultCode("1");
		resp.setResultMessage("操作成功");
		logger.info("------------------end getPacuDeviceConfigList------------------------");
		return resp.getJsonStr();
	}
	
	@RequestMapping("/initAnaesPacu")
	@ResponseBody
	@ApiOperation(value="initAnaesPacu",httpMethod="POST",notes="initAnaesPacu")
	public String initAnaesPacu(@ApiParam(name="msg", value ="查询参数") @RequestBody CmdMsg msg){
		ResponseValue resp = new ResponseValue();
		
		return resp.getJsonStr();
	}
	
	@RequestMapping(value = "/saveAnaesPacuRec")
	@ResponseBody
	@ApiOperation(value="保存复苏室记录单",httpMethod="POST",notes="保存复苏室记录单")
	public String saveAnaesPacuRec(@ApiParam(name="record", value ="查询参数") @RequestBody DocAnaesPacuRec record){
		logger.info("-------------------start saveAnaesPacuRec---------------------");
		ResponseValue resp = new ResponseValue();
		docAnaesPacuRecService.saveAnaesPacuRec(record,resp);
		resp.setResultCode("1");
		resp.setResultMessage("保存复苏室记录单成功");
		logger.info("-------------------end saveAnaesPacuRec---------------------");
		return resp.getJsonStr();
	}

	/**
	 * 根据设备类型和设备id，获取对应的监测项数据列表
	 * @param json
	 * @return
	 */
	@RequestMapping("/getPacuMonitorConfigCheck")
	@ResponseBody
	@ApiOperation(value="根据设备类型和设备id，获取对应的监测项数据列表",httpMethod="POST",notes="根据设备类型和设备id，获取对应的监测项数据列表")
	public String getPacuMonitorConfigCheck(@ApiParam(name="json", value ="查询参数") @RequestBody JSONObject json) {
		logger.info("----------------start getPacuMonitorConfigCheck------------------------");
		ResponseValue resp = new ResponseValue();
		Integer deviceType = json.getInt("deviceType");
		String deviceId = json.getString("deviceId");
		List<BasPacuMonitorConfig> monitorConfigList = docAnaesPacuRecService.getPacuMonitorConfigCheck(deviceType, deviceId);
		resp.put("resultList", monitorConfigList);
		logger.info("------------------end getPacuMonitorConfigCheck------------------------");
		return resp.getJsonStr();
	}

	/**
	 * 保存页面选择的设备以及采集参数，对b_pacu_device_config增加or修改记录
	 * 对b_pacu_bed_event_config记录，先清空，再存入
	 * @param bean
	 * @return
	 */
	@RequestMapping("/savePacuDeviceConfig")
	@ResponseBody
	@ApiOperation(value="保存页面选择的设备以及采集参数，对b_pacu_device_config增加or修改记录",httpMethod="POST",notes="保存页面选择的设备以及采集参数，对b_pacu_device_config增加or修改记录")
	public String savePacuDeviceConfig(@ApiParam(name="bean", value ="保存参数") @RequestBody PacuDeviceEventFormBean bean) {
		logger.info("----------------start savePacuDeviceConfig------------------------");
		ResponseValue resp = new ResponseValue();
		docAnaesPacuRecService.savePacuDeviceConfig(bean);
		String bedId = bean.getPacuDeviceConfig().getBedId();
		String beid = bean.getPacuDeviceConfig().getBeid();
		if (StringUtils.isBlank(beid)) {
			beid = getBeid();
		}
		
		CmdMsg msg = new CmdMsg();
		msg.setMsgType(MyConstants.UPDATE_PACU_CONFIG);
		msg.setBedId(bedId);
		//msg.setRegOptId(regOptId);
		resp = MsgProcess.process(msg);
		
		List<PacuDeviceConfigFormBean> pacuDeviceConfigList = docAnaesPacuRecService.getPacuDeviceConfigList(bedId, beid);
		resp.put("resultList", pacuDeviceConfigList);
		logger.info("------------------end savePacuDeviceConfig------------------------");
		return resp.getJsonStr();
	}

	@ResponseBody
	@RequestMapping("/deletePacuDeviceConfig")
	@ApiOperation(value="删除设备以及采集参数，对b_pacu_device_config增加or修改记录",httpMethod="POST",notes="删除设备以及采集参数，对b_pacu_device_config增加or修改记录")
	public String deletePacuDeviceConfig(@ApiParam(name="json", value ="删除参数") @RequestBody JSONObject json){
		logger.info("----------------start savePacuDeviceConfig------------------------");
		ResponseValue resp = new ResponseValue();
		String bedId = json.getString("bedId");
		String deviceId = json.getString("deviceId");
		String beid = (String) json.get("beid");
		if (StringUtils.isBlank(beid)) {
			beid = getBeid();
		}
		docAnaesPacuRecService.deletePacuDeviceConfig(bedId,deviceId);
		// 发送命令的socket客户端
		CmdMsg msg = new CmdMsg();
		msg.setMsgType(MyConstants.UPDATE_PACU_CONFIG);
		msg.setBedId(bedId);
		resp = MsgProcess.process(msg);
		
		List<PacuDeviceConfigFormBean> pacuDeviceConfigList = docAnaesPacuRecService.getPacuDeviceConfigList(bedId, beid);
		resp.put("resultList", pacuDeviceConfigList);
		logger.info("------------------end savePacuDeviceConfig------------------------");
		return resp.getJsonStr();
	}
}
