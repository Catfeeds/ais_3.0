/**     
 * @discription 在此输入一句话描述此文件的作用
 * @author chengwang       
 * @created 2015-10-10 下午5:34:19    
 * tags     
 * see_to_target     
 */

package com.digihealth.anesthesia.doc.controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.digihealth.anesthesia.basedata.formbean.DispatchPeopleNameFormBean;
import com.digihealth.anesthesia.sysMng.po.BasUser;
import com.digihealth.anesthesia.basedata.po.BasRegOpt;
import com.digihealth.anesthesia.basedata.utils.UserUtils;
import com.digihealth.anesthesia.common.beanvalidator.ValidatorBean;
import com.digihealth.anesthesia.common.entity.ResponseValue;
import com.digihealth.anesthesia.common.utils.Exceptions;
import com.digihealth.anesthesia.common.utils.StringUtils;
import com.digihealth.anesthesia.common.web.BaseController;
import com.digihealth.anesthesia.doc.formbean.BadEventFormBean;
import com.digihealth.anesthesia.doc.po.DocAnaesRecord;
import com.digihealth.anesthesia.doc.po.DocBadEvent;
import com.digihealth.anesthesia.evt.formbean.SearchFormBean;
import com.digihealth.anesthesia.evt.po.EvtOptLatterDiag;
import com.digihealth.anesthesia.evt.po.EvtOptRealOper;
import com.digihealth.anesthesia.evt.po.EvtRealAnaesMethod;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

/**
 * Title: BadEventController.java Description: 描述
 * 
 * @author chengwang
 * @created 2015-10-10 下午5:34:19
 */
@Controller
@RequestMapping(value = "/document")
@Api(value="DocBadEventController",description="不良事件处理类")
public class DocBadEventController extends BaseController {

	/**
	 * 
	 * @discription 根据手术ID获取不良事件
	 * @author chengwang
	 * @created 2015-10-10 下午5:13:48
	 * @param regOptId
	 * @return
	 */
	@RequestMapping(value = "/searchBadEventByRegOptId")
	@ResponseBody
	@ApiOperation(value="根据手术ID获取不良事件",httpMethod="POST",notes="根据手术ID获取不良事件")
	public String searchBadEventByRegOptId(@ApiParam(name="map", value ="查询参数") @RequestBody Map map) {
		logger.info("-----------------------start searchBadEventByRegOptId-----------------------");
		ResponseValue resp = new ResponseValue();
		try {
			String regOptId = map.get("regOptId")!=null?map.get("regOptId").toString():"";
			
			BadEventFormBean bean = new BadEventFormBean();
			BasRegOpt regOpt = basRegOptService.searchRegOptById(regOptId);
			if(regOpt == null){
				resp.setResultCode("20000002");
				resp.setResultMessage("手术申请信息不存在!");
				return resp.getJsonStr();
			}
			bean.setAge(UserUtils.getAge(regOpt.getAge()==null?"":regOpt.getAge()+"", regOpt.getAgeMon()==null?"":regOpt.getAgeMon()+"", regOpt.getAgeDay()));
			bean.setAgeDay(regOpt.getAgeDay()==null?0:regOpt.getAgeDay());
			bean.setAgeMon(regOpt.getAgeMon()==null?0:regOpt.getAgeMon());
			bean.setSex(regOpt.getSex());
			
			//不良事件信息
			DocBadEvent badEvent = docBadEventService.searchBadEventByRegOptId(regOptId);
			if(badEvent == null){
				resp.setResultCode("40000008");
				resp.setResultMessage("不良事件单不存在!");
				return resp.getJsonStr();
			}
			BasUser user = basUserService.get(badEvent.getCircuanesthetistId()==null?"":badEvent.getCircuanesthetistId(), getBeid());
			if(user !=null){
				badEvent.setCircuanesthetistName(user.getName());
			}
			
			//得到排班人员的名字
			DispatchPeopleNameFormBean dispatchPeopleName = basDispatchService.searchPeopleNameByRegOptId(regOptId);
			//获取麻醉记录单主表信息
			DocAnaesRecord anaesRecord = docAnaesRecordService.searchAnaesRecordByRegOptId(regOptId);
			bean.setAnaesStartTime(anaesRecord.getAnaesStartTime());
			if(dispatchPeopleName!=null){
				bean.setAnesthetistName(dispatchPeopleName.getAnesthetistName());
			}
			bean.setBed(regOpt.getBed());
			bean.setDeptName(regOpt.getDeptName());
			bean.setEmergency(regOpt.getEmergency());
			bean.setHid(regOpt.getHid());
			bean.setName(regOpt.getName());
			bean.setOperStartTime(anaesRecord.getOperStartTime());
			SearchFormBean searchBean = new SearchFormBean();
			searchBean.setDocId(anaesRecord.getAnaRecordId());
			List<EvtRealAnaesMethod> realAnaMdList = evtRealAnaesMethodService.searchRealAnaesMethodList(searchBean);
			bean.setRealDesignedAnaesMethodName("");
			if(realAnaMdList.size()>0&&realAnaMdList!=null){
				for(int i = 0 ;i<realAnaMdList.size();i++){
					bean.setRealDesignedAnaesMethodName(bean.getRealDesignedAnaesMethodName()==null?realAnaMdList.get(i).getName()+",":bean.getRealDesignedAnaesMethodName()+realAnaMdList.get(i).getName()+",");
				}
			}
			
			if(!StringUtils.isEmpty(bean.getRealDesignedAnaesMethodName())){
				bean.setRealDesignedAnaesMethodName(bean.getRealDesignedAnaesMethodName().substring(0,bean.getRealDesignedAnaesMethodName().length()-1));
			}
			
			List<EvtOptLatterDiag> optLDList = evtOptLatterDiagService.searchOptLatterDiagList(searchBean);
			bean.setRealDiagnosisName("");
			if(optLDList.size()>0&&optLDList!=null){
				for(int i = 0 ;i<optLDList.size();i++){
					bean.setRealDiagnosisName(bean.getRealDiagnosisName()==null?optLDList.get(i).getName()+",":bean.getRealDiagnosisName()+optLDList.get(i).getName()+",");
				}
			}
			if(!StringUtils.isEmpty(bean.getRealDiagnosisName())){
				bean.setRealDiagnosisName(bean.getRealDiagnosisName().substring(0,bean.getRealDiagnosisName().length()-1));
			}
			 
			List<EvtOptRealOper> optROList = evtOptRealOperService.searchOptRealOperList(searchBean);
			bean.setRealDesignedOptName("");
			if(optROList.size()>0&&optROList!=null){
				for(int i = 0 ;i<optROList.size();i++){
					bean.setRealDesignedOptName(bean.getRealDesignedOptName()==null?optROList.get(i).getName()+",":bean.getRealDesignedOptName()+optROList.get(i).getName()+",");
				}
			}
			if(!StringUtils.isEmpty(bean.getRealDesignedOptName())){
				bean.setRealDesignedOptName(bean.getRealDesignedOptName().substring(0,bean.getRealDesignedOptName().length()-1));
			}
			resp.setResultCode("1");
			resp.setResultMessage("不良事件单查询成功!");
			resp.put("result", "true");
			resp.put("badEventItem", badEvent);
			resp.put("badEventFormBean", bean);
		} catch (Exception e) {
			if(logger.isErrorEnabled()){
				logger.error(Exceptions.getStackTraceAsString(e));
			}
			resp.setResultCode("10000000");
			resp.setResultMessage("系统错误，请与系统管理员联系!");
		}
		logger.info("-----------------------end searchBadEventByRegOptId-----------------------");
		return resp.getJsonStr();
	}

	/**
	 * 
	 * @discription 修改不良事件
	 * @author chengwang
	 * @created 2015-10-20 上午9:33:40
	 * @param docId
	 * @return
	 */
	@RequestMapping(value = "/updateBadEvent")
	@ResponseBody
	@ApiOperation(value="修改不良事件",httpMethod="POST",notes="修改不良事件")
	public String updateBadEvent(@ApiParam(name="badEvent", value ="修改参数") @RequestBody DocBadEvent badEvent) {
		logger.info("-----------------------begin updateBadEvent-----------------------");
		ResponseValue resp = new ResponseValue();
		try {
			ValidatorBean validatorBean = beanValidator(badEvent);
			if(!(validatorBean.isValidator())){
				resp.setResultCode("10000001");
				resp.setResultMessage(validatorBean.getMessage());
				return resp.getJsonStr();
			}
			resp = docBadEventService.updateBadEvent(badEvent);
		} catch (Exception e) {
			if(logger.isErrorEnabled()){
				logger.error(Exceptions.getStackTraceAsString(e));
			}
			resp.put("resultCode", "10000000");
			resp.put("resultMessage", "系统错误，请与系统管理员联系!");
		}
		logger.info("-----------------------end updateBadEvent-----------------------");
		return resp.getJsonStr();
	}

}
