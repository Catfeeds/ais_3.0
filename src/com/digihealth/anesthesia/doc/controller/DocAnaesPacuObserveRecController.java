package com.digihealth.anesthesia.doc.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.digihealth.anesthesia.basedata.formbean.SystemSearchFormBean;
import com.digihealth.anesthesia.basedata.po.BasCollectPacuData;
import com.digihealth.anesthesia.basedata.po.BasRegOpt;
import com.digihealth.anesthesia.common.beanvalidator.ValidatorBean;
import com.digihealth.anesthesia.common.config.Global;
import com.digihealth.anesthesia.common.entity.ResponseValue;
import com.digihealth.anesthesia.common.utils.StringUtils;
import com.digihealth.anesthesia.common.web.BaseController;
import com.digihealth.anesthesia.doc.po.DocAnaesPacuObserveRec;
import com.digihealth.anesthesia.doc.po.DocAnaesPacuRec;
import com.digihealth.anesthesia.evt.formbean.Filter;
import com.digihealth.anesthesia.evt.formbean.SearchFormBean;
import com.digihealth.anesthesia.evt.formbean.SearchOptOperIoevent;
import com.digihealth.anesthesia.evt.formbean.SearchOptOperMedicalevent;
import com.digihealth.anesthesia.operProceed.formbean.CmdMsg;
import com.digihealth.anesthesia.pacu.core.MyConstants;
import com.digihealth.anesthesia.pacu.datasync.MsgProcess;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;


/**
 * 
     * Title: AnaesPacuObserveRecController.java    
     * Description: 复苏处理
     * @author        
     * @created 2015-9-15 下午1:56:40
 */
@Controller
@RequestMapping(value = "/document")
@Api(value="DocAnaesPacuObserveRecController",description="复苏记录单处理类")
public class DocAnaesPacuObserveRecController extends BaseController{
	
	@RequestMapping(value = "/selectByPacuRecId")
	@ResponseBody
	@ApiOperation(value="根据id查询复苏记录单",httpMethod="POST",notes="根据id查询复苏记录单")
	public String selectByPacuRecId(@ApiParam(name="searchFormBean", value ="查询参数") @RequestBody SystemSearchFormBean searchFormBean) {
		logger.info("begin selectByPacuRecId");
		ResponseValue resp = new ResponseValue();
		
		//复苏记录单数据
		DocAnaesPacuRec anaesPacuRec = new DocAnaesPacuRec(); 
//		String pacurecid = "";
//		if(searchFormBean!=null){
//			List<Filter> fs = searchFormBean.getFilters();
//			for (Filter filter : fs) {
//				if(filter.getField().equals("pacurecid")){
//					pacurecid = filter.getValue();
//				}
//			}
//		}
//		if(StringUtils.isNotBlank(pacurecid)){
//			anaesPacuRec = docAnaesPacuRecService.getAnaesPacuRecById(pacurecid);
//		}
		
		String regOptId = "";
		if (searchFormBean != null) {
			List<Filter> fs = searchFormBean.getFilters();
			for (Filter filter : fs) {
				if ("regOptId".equals(filter.getField())) {
					regOptId = filter.getValue();
				}
			}
		}
        if(org.apache.commons.lang3.StringUtils.isNotBlank(regOptId)){
          anaesPacuRec = docAnaesPacuRecService.getAnaesPacuRecByRegOptId(regOptId);
        }
		
		BasRegOpt regOpt = basRegOptService.searchRegOptById(anaesPacuRec.getRegOptId());
		String state = regOpt.getState();
		
		String pacurecid = anaesPacuRec.getId();
		
		//状态为05表示患者进入了复苏室，此时需要采集数据
		if ("05".equals(state)) {
			if (null == anaesPacuRec.getEnterTime()) {
				Date date = new Date();
				docAnaesPacuRecService.updatePacuRecEnterRoomTime(date, pacurecid); // 首次进入pacu存入时间
				anaesPacuRec.setEnterTime(date);
			}

			CmdMsg msg = new CmdMsg();
			msg.setMsgType(MyConstants.STATUS_START);
			msg.setBedId(anaesPacuRec.getBedId());
			msg.setRegOptId(anaesPacuRec.getRegOptId());
			MsgProcess.process(msg);
		}
				
		resp.put("anaesPacuRec", anaesPacuRec);
		//人员基础信息
		resp.put("regOpt", basRegOptService.getPostopOptInfo(anaesPacuRec.getRegOptId()) );
		//复苏记录观察项
		//List<DocAnaesPacuObserveRec> resultList = docAnaesPacuObserveRecService.selectByPacuRecId(searchFormBean);
		List<DocAnaesPacuObserveRec> resultList = docAnaesPacuObserveRecService.selectPacuObByPacuRecId(searchFormBean, pacurecid);
		
		for (DocAnaesPacuObserveRec anaesPacuObserveRec : resultList) {
			//if(StringUtils.isNotBlank(anaesPacuObserveRec.getMedId())){
				/*String[] meds = anaesPacuObserveRec.getMedId().split(",");
				List<String> ls = new ArrayList<String>();
				for (int i = 0; i < meds.length; i++) {
					ls.add(meds[i]);
				}*/
				SearchFormBean searchBean = new SearchFormBean();
				searchBean.setDocId(anaesPacuObserveRec.getId());
				List<SearchOptOperMedicalevent> medList = evtMedicaleventService.searchMedicaleventList(searchBean);
				anaesPacuObserveRec.setMedList(medList);
				
				List<SearchOptOperIoevent> ioList = evtInEventService.searchIoeventList(searchBean);
				anaesPacuObserveRec.setIoList(ioList);
				//anaesPacuObserveRec.setObsMedList(medicaleventService.getPacuMedicaleventList(anaesPacuRec.getId(),anaesPacuObserveRec.getMedId(),ls));
			//}
		}
		resp.put("resultList", resultList);
		logger.info("end selectByPacuRecId");
		return resp.getJsonStr();
	}
	
	
	@RequestMapping(value = "/getPacuAnaesMedicalList")
	@ResponseBody
	@ApiOperation(value="查询复苏室记录单列表",httpMethod="POST",notes="查询复苏室记录单列表")
	public String getPacuAnaesMedicalList(@ApiParam(name="record", value ="复苏记录单对象") @RequestBody DocAnaesPacuObserveRec record) {
		logger.info("begin getPacuAnaesMedicalList");
		ResponseValue resp = new ResponseValue();
		
		DocAnaesPacuObserveRec anaesPacuObserveRec = docAnaesPacuObserveRecService.getAnaesPacuObserveRec(record.getId());
		List<SearchOptOperMedicalevent> obsMedList = new ArrayList<SearchOptOperMedicalevent>();
		if(org.apache.commons.lang3.StringUtils.isNotBlank(anaesPacuObserveRec.getMedId())){
			String[] meds = anaesPacuObserveRec.getMedId().split(",");
			List<String> ls = new ArrayList<String>();
			for (int i = 0; i < meds.length; i++) {
				ls.add(meds[i]);
			}
			obsMedList = evtMedicaleventService.getPacuMedicaleventList(anaesPacuObserveRec.getPacuRecId(),anaesPacuObserveRec.getMedId(),ls);
		}
		resp.put("resultList", obsMedList);
		logger.info("end getPacuAnaesMedicalList");
		return resp.getJsonStr();
	}
	
	/**
	 * 复苏室观察记录表
	 * @param DocAnaesPacuObserveRec
	 * @return
	 */
	@RequestMapping(value = "/savePacuAnaesObserve")
	@ResponseBody
	@ApiOperation(value="保存复苏室记录",httpMethod="POST",notes="保存复苏室记录")
	public String savePacuAnaesObserve(@ApiParam(name="record", value ="复苏记录单对象") @RequestBody DocAnaesPacuObserveRec record){
		logger.info("begin savePacuAnaesObserve");
		ResponseValue resp = new ResponseValue();
		ValidatorBean validatorBean = beanValidator(record);
		if (!(validatorBean.isValidator())) {
			resp.setResultCode("10000001");
			resp.setResultMessage(validatorBean.getMessage());
			return resp.getJsonStr();
		}

		DocAnaesPacuRec pacuRec = docAnaesPacuRecService.getAnaesPacuRecById(record.getPacuRecId());
		if (pacuRec.getAnabioticState() != 1) {
			if (pacuRec.getExitTime().compareTo(record.getRecordTime()) < 0) {
				resp.setResultCode("10000001");
				resp.setResultMessage("患者补录数据时间应在出室时间之前，请确认！");
				return resp.getJsonStr();
			}
		} else {
			if (pacuRec.getEnterTime().compareTo(record.getRecordTime()) > 0) {
				resp.setResultCode("10000001");
				resp.setResultMessage("患者补录数据时间应在入室时间之后，请确认！");
				return resp.getJsonStr();
			}
		}
		docAnaesPacuObserveRecService.savePacuAnaesObserve(record, resp);
		logger.info("end savePacuAnaesObserve");
		return resp.getJsonStr();
	}
	
	/**
	 * 复苏室观察记录表
	 * @param DocAnaesPacuObserveRec
	 * @return
	 */
	@RequestMapping(value = "/addPacuAnaesObserve")
	@ResponseBody
	@ApiOperation(value="添加复苏室记录",httpMethod="POST",notes="添加复苏室记录")
	public String addPacuAnaesObserve(@RequestBody DocAnaesPacuObserveRec record){
        logger.info("begin addPacuAnaesObserve");
        ResponseValue resp = new ResponseValue();
        ValidatorBean validatorBean = beanValidator(record);
        if (!(validatorBean.isValidator()))
        {
            resp.setResultCode("10000001");
            resp.setResultMessage(validatorBean.getMessage());
            return resp.getJsonStr();
        }
        // 如果复苏记录单对应状态不为复苏中时，则不允许编辑数据
        DocAnaesPacuRec rec = docAnaesPacuRecService.getAnaesPacuRecById(record.getPacuRecId());
        if (rec.getAnabioticState() != 1)
        {
            resp.setResultCode("10000001");
            resp.setResultMessage("对应复苏记录单数据状态不为复苏中，不允许编辑数据");
            return resp.getJsonStr();
        }
        
        List<BasCollectPacuData> dataList =
            basCollectPacuDataService.searchPacuObserveDataList(rec.getRegOptId(), record.getRecordTime());
		for (BasCollectPacuData collectPacuData : dataList) {
			if (collectPacuData.getObserveId().equals("31002")) {
				record.setHr(collectPacuData.getValue());
			}
			if (collectPacuData.getObserveId().equals("31003")) {
				record.setR(collectPacuData.getValue());
			}
			if (collectPacuData.getObserveId().equals("32001")) {
				record.setSpo2(collectPacuData.getValue());
			}
			if (collectPacuData.getObserveId().equals("31004")) {
				record.setHypertension(collectPacuData.getValue());
			}
			if (collectPacuData.getObserveId().equals("31005")) {
				record.setHypopiesia(collectPacuData.getValue());
			}
			/*
			 * if(collectPacuData.getObserveId().equals("31002")){
			 * record.setHr(collectPacuData.getValue()); }
			 */
		}
        docAnaesPacuObserveRecService.savePacuAnaesObserve(record, resp);
        resp.put("pacuObsData", record);
        logger.info("end addPacuAnaesObserve");
        return resp.getJsonStr();
	}

	@RequestMapping("/deletePacuAnaesObserve")
	@ResponseBody
	@ApiOperation(value="删除复苏室记录",httpMethod="POST",notes="删除复苏室记录")
	public String deletePacuAnaesObserve(@ApiParam(name="json", value ="复苏记录单对象") @RequestBody DocAnaesPacuObserveRec rec){
		logger.info("----begin deletePacuAnaesObserve-----");
		ResponseValue resp = new ResponseValue();
		String id = rec.getId();
		if(null != id && StringUtils.isNotBlank(id)){
			docAnaesPacuObserveRecService.deletePacuAnaesObserve(id);
		}else{
			resp.setResultCode("70000000");
			resp.setResultMessage(Global.getRetMsg(resp.getResultCode()));
			logger.info("----end deletePacuAnaesObserve----");
			return resp.getJsonStr();
		}
		logger.info("----end deletePacuAnaesObserve----");
		return resp.getJsonStr();
	}
	/**
	 * 复苏室观察记录表
	 * @param DocAnaesPacuObserveRec
	 * @return
	 */
//	@RequestMapping(value = "/savePacuMediclevent")
//	@ResponseBody
//	public String savePacuMediclevent(@RequestBody PacuObsFormbean records){
//		logger.info("begin savePacuMediclevent");
//		ResponseValue resp = new ResponseValue();
//		try {
//			ValidatorBean validatorBean = beanValidator(records.getMedicalevent());
//			if(!(validatorBean.isValidator())){
//				resp.setResultCode("10000001");
//				resp.setResultMessage(validatorBean.getMessage());
//				return resp.getJsonStr();
//			}
//			docAnaesPacuObserveRecService.savePacuMediclevent(records,resp);
//		} catch (Exception e) {
//			resp.setResultCode("1000000000");
//			resp.setResultMessage("系统错误请联系管理员!");
//		}
//		logger.info("end savePacuMediclevent");
//		return resp.getJsonStr();
//	}
	/**
	 * 删除复苏记录观察记录药品记录
	 * @param records
	 * @return
	 */
//	@RequestMapping(value = "/deletePacuMediclevent")
//	@ResponseBody
//	public String deletePacuMediclevent(@RequestBody PacuObsFormbean records) {
//		logger.info("begin deletePacuMediclevent");
//		ResponseValue value = new ResponseValue();
//		try {
//			docAnaesPacuObserveRecService.deletePacuMediclevent(records);
//		} catch (Exception e) {
//			if(logger.isErrorEnabled()){
//				logger.error(Exceptions.getStackTraceAsString(e));
//			}
//			value.setResultCode("10000000");
//			value.setResultMessage("系统错误，请与系统管理员联系!");
//		}
//		logger.info("end deletePacuMediclevent");
//		return value.getJsonStr();
//	}
}
