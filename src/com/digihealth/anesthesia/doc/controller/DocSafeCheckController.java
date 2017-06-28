/**     
 * @discription 在此输入一句话描述此文件的作用
 * @author chengwang       
 * @created 2015-10-10 下午5:34:19    
 * tags     
 * see_to_target     
 */

package com.digihealth.anesthesia.doc.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.digihealth.anesthesia.basedata.po.BasDispatch;
import com.digihealth.anesthesia.basedata.po.BasOperationPeople;
import com.digihealth.anesthesia.basedata.po.BasRegOpt;
import com.digihealth.anesthesia.common.beanvalidator.ValidatorBean;
import com.digihealth.anesthesia.common.entity.ResponseValue;
import com.digihealth.anesthesia.common.utils.StringUtils;
import com.digihealth.anesthesia.common.web.BaseController;
import com.digihealth.anesthesia.doc.formbean.SafeCheckFormBean;
import com.digihealth.anesthesia.doc.formbean.UpdateSafeCheckFormbean;
import com.digihealth.anesthesia.doc.po.DocAnaesBeforeSafeCheck;
import com.digihealth.anesthesia.doc.po.DocAnaesRecord;
import com.digihealth.anesthesia.doc.po.DocExitOperSafeCheck;
import com.digihealth.anesthesia.doc.po.DocOperBeforeSafeCheck;
import com.digihealth.anesthesia.doc.po.DocSafeCheck;
import com.digihealth.anesthesia.evt.formbean.SearchFormBean;
import com.digihealth.anesthesia.evt.formbean.SearchSafeCheckRegOptFormBean;
import com.digihealth.anesthesia.evt.po.EvtOptLatterDiag;
import com.digihealth.anesthesia.evt.po.EvtOptRealOper;
import com.digihealth.anesthesia.evt.po.EvtParticipant;
import com.digihealth.anesthesia.evt.po.EvtRealAnaesMethod;
import com.digihealth.anesthesia.sysMng.po.BasUser;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

/**
 * Title: PreVisitController.java Description: 描述
 * 
 * @author chengwang
 * @created 2015-10-10 下午5:34:19
 */
@Controller
@RequestMapping(value = "/document")
@Api(value="DocSafeCheckController",description="安全核查处理类")
public class DocSafeCheckController extends BaseController {

	/**
	 * 
	 * @discription 根据手术ID获取手术核查单
	 * @author chengwang
	 * @created 2015年10月28日 上午9:51:41
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/searchSafeCheckByRegOptId")
	@ResponseBody
	@ApiOperation(value="根据手术ID获取手术核查单",httpMethod="POST",notes="根据手术ID获取手术核查单")
	public String searchSafeCheckByRegOptId(@ApiParam(name="map", value ="查询参数") @RequestBody Map<String, Object> map) {
		logger.info("begin searchSafeCheckByRegOptId");
		ResponseValue resp = new ResponseValue();
		String regOptId = map.get("regOptId") != null ? map.get("regOptId").toString() : "";
		String beid = map.get("beid") != null ? map.get("beid").toString() : "";
		DocSafeCheck safeCheck = docSafeCheckService.searchSafeCheckByRegOptId(regOptId);
		if (safeCheck == null) {
			resp.setResultCode("30000002");
			resp.setResultMessage("手术核查单不存在");
			return resp.getJsonStr();
		}
		BasUser safeCheckUser = basUserService.get(safeCheck.getCircunurseId() != null ? safeCheck.getCircunurseId() : "", beid);
		if (safeCheckUser != null) {
			safeCheck.setCircunurseName(safeCheckUser.getName());
		}

		SearchSafeCheckRegOptFormBean searchRegOptByIdFormBean = basRegOptService
				.searchSafeCheckRegOptById(regOptId);
		SafeCheckFormBean bean = new SafeCheckFormBean();
		//bean.setAge(UserUtils.getAge(searchRegOptByIdFormBean.getAge()==null?"":searchRegOptByIdFormBean.getAge()+"", searchRegOptByIdFormBean.getAgeMon()==null?"":searchRegOptByIdFormBean.getAgeMon()+"", searchRegOptByIdFormBean.getAgeDay()));
		bean.setAge(searchRegOptByIdFormBean.getAge());
		/*bean.setAgeDay(searchRegOptByIdFormBean.getAgeDay());
		bean.setAgeMon(searchRegOptByIdFormBean.getAgeMon());*/
		/*bean.setAnesthetistName((searchRegOptByIdFormBean.getAnesthetistName() != null ? searchRegOptByIdFormBean
				.getAnesthetistName() + ","
				: "")
				+ (searchRegOptByIdFormBean.getCircuanesthetistName() != null ? searchRegOptByIdFormBean
						.getCircuanesthetistName() + ","
						: "")
				+ (searchRegOptByIdFormBean.getPerfusiondoctorName() != null ? searchRegOptByIdFormBean
				.getPerfusiondoctorName() : ""));*/
		bean.setBed(searchRegOptByIdFormBean.getBed());
		bean.setDeptName(searchRegOptByIdFormBean.getDeptName());
		bean.setDesignedAnaesMethodName(searchRegOptByIdFormBean
				.getDesignedAnaesMethodName());
		bean.setDesignedOptName(searchRegOptByIdFormBean.getDesignedOptName());
		bean.setDiagnosisName(searchRegOptByIdFormBean.getDiagnosisName());
		bean.setHid(searchRegOptByIdFormBean.getHid());
		bean.setName(searchRegOptByIdFormBean.getName());
		/*bean.setNurseName((searchRegOptByIdFormBean.getInstrnurseName1() != null ? searchRegOptByIdFormBean
				.getInstrnurseName1() + ","
				: "")
				+ (searchRegOptByIdFormBean.getInstrnurseName2() != null ? searchRegOptByIdFormBean
						.getInstrnurseName2() + ","
						: "")
				+ (searchRegOptByIdFormBean.getCircunurseName1() != null ? searchRegOptByIdFormBean
						.getCircunurseName1() + ","
						: "") + (searchRegOptByIdFormBean.getCircunurseName2() != null ? searchRegOptByIdFormBean
				.getCircunurseName2() : ""));*/
		bean.setOperaDate(searchRegOptByIdFormBean.getOperaDate());
		//bean.setOperatorName(searchRegOptByIdFormBean.getOperatorName());
		bean.setRegionName(searchRegOptByIdFormBean.getRegionName());
		bean.setRegOptId(searchRegOptByIdFormBean.getRegOptId());
		bean.setSex(searchRegOptByIdFormBean.getSex());
		DocAnaesRecord anaesRecord = docAnaesRecordService
				.searchAnaesRecordByRegOptId(regOptId);
		SearchFormBean searchBean = new SearchFormBean();
		searchBean.setDocId(anaesRecord.getAnaRecordId());
		List<EvtRealAnaesMethod> realAnaMdList = evtRealAnaesMethodService
				.searchRealAnaesMethodList(searchBean);
		searchBean.setRole("A");
		List<EvtParticipant> anaesDocList = evtParticipantService.searchParticipantList(searchBean);
		bean.setAnesthetistName("");
		if(anaesDocList!=null&&anaesDocList.size()>0){
			for(int i = 0 ; i <anaesDocList.size();i++){
				BasUser user = basUserService.searchUserById(anaesDocList.get(i).getUserLoginName(), getBeid());
				bean.setAnesthetistName(bean.getAnesthetistName()+user.getName()+",");
			}
		}
		
		if(!org.apache.commons.lang3.StringUtils.isEmpty(bean.getAnesthetistName())){
			bean.setAnesthetistName(bean.getAnesthetistName().substring(0,bean.getAnesthetistName().length()-1));
		}
		
		searchBean.setRole("N");
		List<EvtParticipant> nurseDocList = evtParticipantService.searchParticipantList(searchBean);
		bean.setNurseName("");
		if(nurseDocList!=null&&nurseDocList.size()>0){
			for(int i = 0 ; i <nurseDocList.size();i++){
				BasUser user = basUserService.searchUserById(nurseDocList.get(i).getUserLoginName(), getBeid());
				bean.setNurseName(bean.getNurseName()+user.getName()+",");
			}
		}
		
		if(!org.apache.commons.lang3.StringUtils.isEmpty(bean.getNurseName())){
			bean.setNurseName(bean.getNurseName().substring(0,bean.getNurseName().length()-1));
		}
		
		searchBean.setRole("O");
		List<EvtParticipant> operList = evtParticipantService.searchParticipantList(searchBean);
		bean.setOperatorName("");
		if(operList!=null&&operList.size()>0){
			for(int i = 0 ; i <operList.size();i++){
				//User user = basUserService.searchUserById(Integer.parseInt(operList.get(i).getUserLoginName()));
			    BasOperationPeople resultDept = basOperationPeopleService.queryOperationPeopleById(operList.get(i).getUserLoginName());
				bean.setOperatorName(bean.getOperatorName()+resultDept.getName()+",");
			}
		}
		
		if(!org.apache.commons.lang3.StringUtils.isEmpty(bean.getOperatorName())){
			bean.setOperatorName(bean.getOperatorName().substring(0,bean.getOperatorName().length()-1));
		}
		bean.setRealDesignedAnaesMethodName("");
		if (realAnaMdList.size() > 0 && realAnaMdList != null) {
			for (int i = 0; i < realAnaMdList.size(); i++) {
				bean.setRealDesignedAnaesMethodName(bean
						.getRealDesignedAnaesMethodName()==null?realAnaMdList.get(i).getName() + ",":bean
						.getRealDesignedAnaesMethodName()
						+ realAnaMdList.get(i).getName() + ",");
			}
		}
		
		if(!org.apache.commons.lang3.StringUtils.isEmpty(bean.getRealDesignedAnaesMethodName())){
			bean.setRealDesignedAnaesMethodName(bean.getRealDesignedAnaesMethodName().substring(0,bean.getRealDesignedAnaesMethodName().length()-1));
		}

		List<EvtOptLatterDiag> optLDList = evtOptLatterDiagService.searchOptLatterDiagList(searchBean);
		bean.setRealDiagnosisName("");
		if (optLDList.size() > 0 && optLDList != null) {
			for (int i = 0; i < optLDList.size(); i++) {
				bean.setRealDiagnosisName(bean.getRealDiagnosisName()==null?optLDList.get(i).getName() + ",":bean.getRealDiagnosisName()
						+ optLDList.get(i).getName() + ",");
			}
		}
		
		if(!org.apache.commons.lang3.StringUtils.isEmpty(bean.getRealDiagnosisName())){
			bean.setRealDiagnosisName(bean.getRealDiagnosisName().substring(0,bean.getRealDiagnosisName().length()-1));
		}

		List<EvtOptRealOper> optROList = evtOptRealOperService.searchOptRealOperList(searchBean);
		bean.setRealDesignedOptName("");
		if (optROList.size() > 0 && optROList != null) {
			for (int i = 0; i < optROList.size(); i++) {
				bean.setRealDesignedOptName(bean.getRealDesignedOptName()==null?optROList.get(i).getName() + ",":bean.getRealDesignedOptName()
						+ optROList.get(i).getName() + ",");
			}
		}
		if(!org.apache.commons.lang3.StringUtils.isEmpty(bean.getRealDesignedOptName())){
			bean.setRealDesignedOptName(bean.getRealDesignedOptName().substring(0,bean.getRealDesignedOptName().length()-1));
		}
		
		// BeanHelper.copyProperties(searchRegOptByIdFormBean, bean);
		DocAnaesBeforeSafeCheck anaesBeforeSafeCheck = docAnaesBeforeSafeCheckService.searchAnaBeCheckByRegOptId(regOptId);
		BasUser anaesBeforeSafeCheckA = basUserService.get(anaesBeforeSafeCheck.getAnesthetistId() != null ? anaesBeforeSafeCheck.getAnesthetistId() : "", null);
		if (anaesBeforeSafeCheckA != null) {
			anaesBeforeSafeCheck.setAnesthetistName(anaesBeforeSafeCheckA.getName());
		}
		BasUser anaesBeforeSafeCheckO = basUserService.get(anaesBeforeSafeCheck
				.getOperatorId() != null ? anaesBeforeSafeCheck.getOperatorId()
				: "", null);
		if (anaesBeforeSafeCheckO != null) {
			anaesBeforeSafeCheck.setOperatorName(anaesBeforeSafeCheckO
					.getName());
		}
		BasUser anaesBeforeSafeCheckC = basUserService.get(anaesBeforeSafeCheck
				.getCircuNurseId() != null ? anaesBeforeSafeCheck
				.getOperatorId() : "", null);
		if (anaesBeforeSafeCheckC != null) {
			anaesBeforeSafeCheck.setCircunurseName(anaesBeforeSafeCheckC
					.getName());
		}
		DocOperBeforeSafeCheck operBeforeSafeCheck = docOperBeforeSafeCheckService
				.searchOperBeCheckByRegOptId(regOptId);
		BasUser operBeforeSafeCheckA = basUserService.get(operBeforeSafeCheck
				.getAnesthetistId() != null ? operBeforeSafeCheck
				.getAnesthetistId() : "", null);
		if (operBeforeSafeCheckA != null) {
			operBeforeSafeCheck.setAnesthetistName(operBeforeSafeCheckA
					.getName());
		}
		BasUser operBeforeSafeCheckO = basUserService.get(operBeforeSafeCheck.getOperatorId() != null ? operBeforeSafeCheck.getOperatorId() : "", null);
		if (operBeforeSafeCheckO != null) {
			operBeforeSafeCheck.setOperatorName(operBeforeSafeCheckO.getName());
		}
		BasUser operBeforeSafeCheckC = basUserService.get(operBeforeSafeCheck
				.getCircuNurseId() != null ? operBeforeSafeCheck
				.getCircuNurseId() : "", null);
		if (operBeforeSafeCheckC != null) {
			operBeforeSafeCheck.setCircunurseName(operBeforeSafeCheckC
					.getName());
		}
		
		
		/**
         * 进入安全核查页面时，如果手术医生、麻醉医生、护士为空则获取手术排班的数据
         */
        BasDispatch dispatch = basDispatchService.getDispatchOper(regOptId);
        BasRegOpt regOpt = basRegOptService.searchRegOptById(regOptId);
//        if(StringUtils.isBlank(operBeforeSafeCheck.getCircuNurseId())){
//            operBeforeSafeCheck.setCircuNurseId(dispatch.getCircunurseId1());
//        }
//        if(StringUtils.isBlank(operBeforeSafeCheck.getOperatorId())){
//            operBeforeSafeCheck.setOperatorId(regOpt.getOperatorId());
//        }
//        if(StringUtils.isBlank(operBeforeSafeCheck.getAnesthetistId())){
//            operBeforeSafeCheck.setAnesthetistId(dispatch.getAnesthetistId());
//        }
        // 安全核查单护士
        List<String> circunurseList = new ArrayList<String>();
        if (null == operBeforeSafeCheck.getCircuNurseId())
        {
            if (nurseDocList != null && nurseDocList.size() > 0)
            {
                for (EvtParticipant pt : nurseDocList)
                {
                    circunurseList.add(pt.getUserLoginName());
                }
            }
            operBeforeSafeCheck.setCircuNurseId(StringUtils.getStringByList(circunurseList));
        }
        else
        {
            circunurseList = StringUtils.getListByString(operBeforeSafeCheck.getCircuNurseId());
        }
        operBeforeSafeCheck.setCircunurseList(circunurseList);
        
        // 安全核查单麻醉医生
        List<String> anesthetistList = new ArrayList<String>();
        if (null == operBeforeSafeCheck.getAnesthetistId())
        {
            if (anaesDocList != null && anaesDocList.size() > 0)
            {
                for (EvtParticipant pt : anaesDocList)
                {
                    anesthetistList.add(pt.getUserLoginName());
                }
            }
            operBeforeSafeCheck.setAnesthetistId(StringUtils.getStringByList(anesthetistList));
        }
        else if (StringUtils.isNotBlank(operBeforeSafeCheck.getAnesthetistId()))
        {
            anesthetistList = StringUtils.getListByString(operBeforeSafeCheck.getAnesthetistId());
        }
        operBeforeSafeCheck.setAnesthetistList(anesthetistList);
        
        // 安全核查单手术医生
        List<String> operatorList = new ArrayList<String>();
        if (null == operBeforeSafeCheck.getOperatorId())
        {
            if (operList != null && operList.size() > 0)
            {
                for (EvtParticipant pt : operList)
                {
                    operatorList.add(pt.getUserLoginName());
                }
            }
            operBeforeSafeCheck.setOperatorId(StringUtils.getStringByList(operatorList));
        }
        else
        {
            operatorList = StringUtils.getListByString(operBeforeSafeCheck.getOperatorId());
        }
        operBeforeSafeCheck.setOperatorList(operatorList);

        DocExitOperSafeCheck exitOperSafeCheck = docExitOperSafeCheckService
				.searchExitOperCheckByRegOptId(regOptId);
		BasUser exitOperSafeCheckA = basUserService.get(exitOperSafeCheck
				.getAnesthetistId() != null ? exitOperSafeCheck
				.getAnesthetistId() : "", null);
		if (exitOperSafeCheckA != null) {
			exitOperSafeCheck.setAnesthetistName(exitOperSafeCheckA.getName());
		}
		BasUser exitOperSafeCheckO = basUserService.get(exitOperSafeCheck
				.getOperatorId() != null ? exitOperSafeCheck.getOperatorId()
				: "", null);
		if (exitOperSafeCheckO != null) {
			exitOperSafeCheck.setOperatorName(exitOperSafeCheckO.getName());
		}
		BasUser exitOperSafeCheckC = basUserService.get(exitOperSafeCheck
				.getCircuNurseId() != null ? exitOperSafeCheck
				.getCircuNurseId() : "", null);
		if (exitOperSafeCheckC != null) {
			exitOperSafeCheck.setCircunurseName(exitOperSafeCheckC.getName());
		}
		resp.put("safeCheck", safeCheck);
		resp.put("safeCheckFormBean", bean);
		resp.put("anaesBeforeSafeCheck", anaesBeforeSafeCheck);
		resp.put("operBeforeSafeCheck", operBeforeSafeCheck);
		resp.put("exitOperSafeCheck", exitOperSafeCheck);
		logger.info("end searchSafeCheckByRegOptId");
		return resp.getJsonStr();
	}

	@RequestMapping(value = "/updateSafeCheck")
	@ResponseBody
	@ApiOperation(value="修改手术核查单",httpMethod="POST",notes="修改手术核查单")
	public String updateSafeCheck(@ApiParam(name="safeCheckFormbean", value ="修改参数") @RequestBody UpdateSafeCheckFormbean safeCheckFormbean){
		logger.info("begin updateOperBeforeSafeCheck");
		ResponseValue resp = new ResponseValue();
		ValidatorBean validatorBean = beanValidator(safeCheckFormbean.getOperBeforeSafeCheck());
		if(!(validatorBean.isValidator())){
			resp.setResultCode("10000001");
			resp.setResultMessage(validatorBean.getMessage());
			return resp.getJsonStr();
		}
		ValidatorBean validatorBean1 = beanValidator(safeCheckFormbean.getAnaesBeforeSafeCheck());
		if(!(validatorBean1.isValidator())){
			resp.setResultCode("10000001");
			resp.setResultMessage(validatorBean.getMessage());
			return resp.getJsonStr();
		}
		ValidatorBean validatorBean2 = beanValidator(safeCheckFormbean.getExitOperSafeCheck());
		if(!(validatorBean2.isValidator())){
			resp.setResultCode("10000001");
			resp.setResultMessage(validatorBean.getMessage());
			return resp.getJsonStr();
		}
		
		resp = docOperBeforeSafeCheckService.updateOperBeforeSafeCheck(safeCheckFormbean.getOperBeforeSafeCheck());
		resp = docAnaesBeforeSafeCheckService.updateAnaesBeforeSafeCheck(safeCheckFormbean.getAnaesBeforeSafeCheck());
		resp = docExitOperSafeCheckService.updateExitOperSafeCheck(safeCheckFormbean.getExitOperSafeCheck(),safeCheckFormbean.getProcessState());
		
		logger.info("end updateOperBeforeSafeCheck");
		return resp.getJsonStr();
	}

}
