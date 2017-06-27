/**     
 * @discription 在此输入一句话描述此文件的作用
 */

package com.digihealth.anesthesia.doc.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.digihealth.anesthesia.basedata.formbean.PacuStartFormbean;
import com.digihealth.anesthesia.common.beanvalidator.ValidatorBean;
import com.digihealth.anesthesia.common.entity.ResponseValue;
import com.digihealth.anesthesia.common.utils.Exceptions;
import com.digihealth.anesthesia.common.web.BaseController;
import com.digihealth.anesthesia.doc.po.DocCollectPacuData;
import com.digihealth.anesthesia.operProceed.formbean.CmdMsg;
import com.digihealth.anesthesia.pacu.core.MyConstants;
import com.digihealth.anesthesia.pacu.datasync.MsgProcess;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

/**
 * Title: CollectPacuDataController.java Description: 描述
 */
@Controller
@RequestMapping(value = "/document")
@Api(value="DocCollectPacuDataController",description="生命体征处理类")
public class DocCollectPacuDataController extends BaseController {

	/**
	 * 开始复苏监测
	 * @param 
	 *  
	 */
	@RequestMapping(value = "/startAnalepsia")
	@ResponseBody
	@ApiOperation(value="开始复苏监测",httpMethod="POST",notes="开始复苏监测")
	public String startAnalepsia(@ApiParam(name="pacuStartFormbean", value ="查询参数") @RequestBody PacuStartFormbean pacuStartFormbean)
	{
		logger.info("---------------------begin startAnalepsia---------------------");
		ResponseValue resp = new ResponseValue();
		try {
			ValidatorBean validatorBean = beanValidator(pacuStartFormbean);
			if(!(validatorBean.isValidator()) || StringUtils.isBlank(pacuStartFormbean.getBedId()))
			{
				resp.setResultCode("10000001");
				resp.setResultMessage(validatorBean.getMessage());
				return resp.getJsonStr();
			}
			
			CmdMsg msg = new CmdMsg();
			msg.setMsgType(MyConstants.STATUS_START);
			msg.setBedId(pacuStartFormbean.getBedId());
			msg.setRegOptId(pacuStartFormbean.getRegOptId());
			MsgProcess.process(msg);
		} catch (Exception e) {
			if(logger.isErrorEnabled()){
				logger.error(Exceptions.getStackTraceAsString(e));
			}
			resp.setResultCode("10000000");
			resp.setResultMessage("系统错误，请与系统管理员联系!");
		}
		logger.info("---------------------end startAnalepsia---------------------");
		return resp.getJsonStr();
	}
	
	/**
	 * 结束复苏监测
	 * @param 
	 *  
	 */
	@RequestMapping(value = "/endAnalepsia")
	@ResponseBody
	@ApiOperation(value="开始复苏监测",httpMethod="POST",notes="开始复苏监测")
	public String endAnalepsia(@ApiParam(name="pacuStartFormbean", value ="查询参数") @RequestBody PacuStartFormbean pacuStartFormbean)
	{
		logger.info("---------------------begin startAnalepsia---------------------");
		ResponseValue resp = new ResponseValue();
		try {
			ValidatorBean validatorBean = beanValidator(pacuStartFormbean);
			if(!(validatorBean.isValidator()) || StringUtils.isBlank(pacuStartFormbean.getBedId()))
			{
				resp.setResultCode("10000001");
				resp.setResultMessage(validatorBean.getMessage());
				return resp.getJsonStr();
			}
			
			CmdMsg msg = new CmdMsg();
			msg.setMsgType(MyConstants.STATUS_END);
			msg.setBedId(pacuStartFormbean.getBedId());
			msg.setRegOptId(pacuStartFormbean.getRegOptId());
			MsgProcess.process(msg);
		} catch (Exception e) {
			if(logger.isErrorEnabled()){
				logger.error(Exceptions.getStackTraceAsString(e));
			}
			resp.setResultCode("10000000");
			resp.setResultMessage("系统错误，请与系统管理员联系!");
		}
		logger.info("---------------------end startAnalepsia---------------------");
		return resp.getJsonStr();
	}
	
	
	/**
	 * 根据患者id查询生命体征
	 * @param docId
	 * @return
	 */
	@RequestMapping(value = "/searchPacuObserveDataList")
	@ResponseBody
	@ApiOperation(value="根据患者id查询生命体征",httpMethod="POST",notes="根据患者id查询生命体征")
	public String searchPacuObserveDataList(@ApiParam(name="record", value ="查询参数") @RequestBody DocCollectPacuData record) {
		logger.info("---------------------begin searchPacuObserveDataList---------------------");
		ResponseValue resp = new ResponseValue();
		try {
			List<DocCollectPacuData> dateList = docCollectPacuDataService.searchPacuObserveDataList(record.getDocId(), record.getTime());
			resp.put("dateList", dateList);
		} catch (Exception e) {
			resp.setResultCode("10000000");
			resp.setResultMessage("系统错误，请与系统管理员联系!");
		}
		logger.info("---------------------end searchPacuObserveDataList---------------------");
		return resp.getJsonStr();
	}
	
}
