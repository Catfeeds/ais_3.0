/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.digihealth.anesthesia.common.web;

import java.beans.PropertyEditorSupport;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import javax.validation.Validator;

import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.BindException;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.digihealth.anesthesia.basedata.service.AnaesPacuSocketService;
import com.digihealth.anesthesia.basedata.service.BasAnaesKndgbaseService;
import com.digihealth.anesthesia.basedata.service.BasAnaesMedicineInRecordService;
import com.digihealth.anesthesia.basedata.service.BasAnaesMedicineLoseRecordService;
import com.digihealth.anesthesia.basedata.service.BasAnaesMedicineOutRecordService;
import com.digihealth.anesthesia.basedata.service.BasAnaesMedicineRetreatRecordService;
import com.digihealth.anesthesia.basedata.service.BasAnaesMedicineStorageService;
import com.digihealth.anesthesia.basedata.service.BasAnaesMethodService;
import com.digihealth.anesthesia.basedata.service.BasAnnouncementService;
import com.digihealth.anesthesia.basedata.service.BasBusEntityService;
import com.digihealth.anesthesia.basedata.service.BasChargeItemService;
import com.digihealth.anesthesia.basedata.service.BasChargePackagesService;
import com.digihealth.anesthesia.basedata.service.BasCheckItemService;
import com.digihealth.anesthesia.basedata.service.BasCollectPacuDataHisService;
import com.digihealth.anesthesia.basedata.service.BasCollectPacuDataService;
import com.digihealth.anesthesia.basedata.service.BasColumnStyleService;
import com.digihealth.anesthesia.basedata.service.BasConsultationService;
import com.digihealth.anesthesia.basedata.service.BasDefaultOperatorService;
import com.digihealth.anesthesia.basedata.service.BasDeptService;
import com.digihealth.anesthesia.basedata.service.BasDeviceConfigService;
import com.digihealth.anesthesia.basedata.service.BasDeviceMonitorConfigService;
import com.digihealth.anesthesia.basedata.service.BasDeviceService;
import com.digihealth.anesthesia.basedata.service.BasDeviceSpecificationService;
import com.digihealth.anesthesia.basedata.service.BasDiagnosedefService;
import com.digihealth.anesthesia.basedata.service.BasDispatchService;
import com.digihealth.anesthesia.basedata.service.BasHealthNurseService;
import com.digihealth.anesthesia.basedata.service.BasIconSvgService;
import com.digihealth.anesthesia.basedata.service.BasInOutInfoService;
import com.digihealth.anesthesia.basedata.service.BasInstrSuitRelService;
import com.digihealth.anesthesia.basedata.service.BasInstrsuitService;
import com.digihealth.anesthesia.basedata.service.BasInstrumentService;
import com.digihealth.anesthesia.basedata.service.BasInventoryService;
import com.digihealth.anesthesia.basedata.service.BasIoDefinationService;
import com.digihealth.anesthesia.basedata.service.BasMedicalTakeReasonService;
import com.digihealth.anesthesia.basedata.service.BasMedicalTakeWayService;
import com.digihealth.anesthesia.basedata.service.BasMedicineService;
import com.digihealth.anesthesia.basedata.service.BasMonitorConfigFreqService;
import com.digihealth.anesthesia.basedata.service.BasOperateLogService;
import com.digihealth.anesthesia.basedata.service.BasOperationPeopleService;
import com.digihealth.anesthesia.basedata.service.BasOperdefService;
import com.digihealth.anesthesia.basedata.service.BasOperroomService;
import com.digihealth.anesthesia.basedata.service.BasPriceService;
import com.digihealth.anesthesia.basedata.service.BasRegOptService;
import com.digihealth.anesthesia.basedata.service.BasRegionBedService;
import com.digihealth.anesthesia.basedata.service.BasRegionService;
import com.digihealth.anesthesia.basedata.service.BasRequiredItemService;
import com.digihealth.anesthesia.basedata.service.BasRowStyleService;
import com.digihealth.anesthesia.basedata.service.BasSysCodeService;
import com.digihealth.anesthesia.basedata.service.BasTitleStyleService;
import com.digihealth.anesthesia.basedata.service.ControllerService;
import com.digihealth.anesthesia.common.beanvalidator.BeanValidators;
import com.digihealth.anesthesia.common.beanvalidator.ValidatorBean;
import com.digihealth.anesthesia.common.entity.ResponseValue;
import com.digihealth.anesthesia.common.mapper.JsonMapper;
import com.digihealth.anesthesia.common.utils.DateUtils;
import com.digihealth.anesthesia.doc.service.DocAccedeService;
import com.digihealth.anesthesia.doc.service.DocAnaesBeforeSafeCheckService;
import com.digihealth.anesthesia.doc.service.DocAnaesPacuObserveRecService;
import com.digihealth.anesthesia.doc.service.DocAnaesPacuRecService;
import com.digihealth.anesthesia.doc.service.DocAnaesPlanService;
import com.digihealth.anesthesia.doc.service.DocAnaesPostopService;
import com.digihealth.anesthesia.doc.service.DocAnaesRecordService;
import com.digihealth.anesthesia.doc.service.DocAnaesSummaryService;
import com.digihealth.anesthesia.doc.service.DocAnalgesicRecordService;
import com.digihealth.anesthesia.doc.service.DocBadEventService;
import com.digihealth.anesthesia.doc.service.DocCollectPacuDataService;
import com.digihealth.anesthesia.doc.service.DocEventBillingService;
import com.digihealth.anesthesia.doc.service.DocExitOperSafeCheckService;
import com.digihealth.anesthesia.doc.service.DocGeneralAnaesService;
import com.digihealth.anesthesia.doc.service.DocInstrubillItemService;
import com.digihealth.anesthesia.doc.service.DocInsuredChargeInformService;
import com.digihealth.anesthesia.doc.service.DocInsuredPatAgreeService;
import com.digihealth.anesthesia.doc.service.DocNerveBlockService;
import com.digihealth.anesthesia.doc.service.DocOperBeforeSafeCheckService;
import com.digihealth.anesthesia.doc.service.DocOptCareRecordService;
import com.digihealth.anesthesia.doc.service.DocOptNurseRecordService;
import com.digihealth.anesthesia.doc.service.DocOptNurseService;
import com.digihealth.anesthesia.doc.service.DocOptRiskEvaluationService;
import com.digihealth.anesthesia.doc.service.DocPackagesItemService;
import com.digihealth.anesthesia.doc.service.DocPatOutRangeAgreeService;
import com.digihealth.anesthesia.doc.service.DocPatShuttleTransferService;
import com.digihealth.anesthesia.doc.service.DocPlacentaHandleAgreeService;
import com.digihealth.anesthesia.doc.service.DocPostFollowRecordService;
import com.digihealth.anesthesia.doc.service.DocPreOperVisitService;
import com.digihealth.anesthesia.doc.service.DocPrePostVisitService;
import com.digihealth.anesthesia.doc.service.DocPreVisitService;
import com.digihealth.anesthesia.doc.service.DocSafeCheckService;
import com.digihealth.anesthesia.doc.service.DocSelfPayAccedeService;
import com.digihealth.anesthesia.doc.service.DocSpinalCanalPunctureService;
import com.digihealth.anesthesia.doc.service.DocTransferConnectRecordService;
import com.digihealth.anesthesia.evt.service.EvtAnaesEventService;
import com.digihealth.anesthesia.evt.service.EvtCheckEventService;
import com.digihealth.anesthesia.evt.service.EvtCtlBreathService;
import com.digihealth.anesthesia.evt.service.EvtEgressService;
import com.digihealth.anesthesia.evt.service.EvtInEventService;
import com.digihealth.anesthesia.evt.service.EvtMaterialService;
import com.digihealth.anesthesia.evt.service.EvtMedicalEventService;
import com.digihealth.anesthesia.evt.service.EvtOperBodyEventService;
import com.digihealth.anesthesia.evt.service.EvtOptLatterDiagService;
import com.digihealth.anesthesia.evt.service.EvtOptRealOperService;
import com.digihealth.anesthesia.evt.service.EvtOtherEventService;
import com.digihealth.anesthesia.evt.service.EvtParticipantService;
import com.digihealth.anesthesia.evt.service.EvtRealAnaesMethodService;
import com.digihealth.anesthesia.evt.service.EvtRescueeventService;
import com.digihealth.anesthesia.evt.service.EvtShiftChangeService;
import com.digihealth.anesthesia.inspect.service.PatInspectItemService;
import com.digihealth.anesthesia.inspect.service.PatInspectRecordService;
import com.digihealth.anesthesia.interfacedata.service.OperListService;
import com.digihealth.anesthesia.operProceed.service.BasAnaesMonitorConfigService;
import com.digihealth.anesthesia.operProceed.service.BasMonitorConfigDefaultService;
import com.digihealth.anesthesia.operProceed.service.BasMonitorConfigService;
import com.digihealth.anesthesia.operProceed.service.BasMonitorDisplayService;
import com.digihealth.anesthesia.operProceed.service.BasMonitorFreqChangeService;
import com.digihealth.anesthesia.operProceed.service.BasMonitorPupilService;
import com.digihealth.anesthesia.operProceed.service.BasObserveDataService;
import com.digihealth.anesthesia.research.service.QCManagerService;
import com.digihealth.anesthesia.research.service.StatisticsService;
import com.digihealth.anesthesia.sysMng.service.BasMenuService;
import com.digihealth.anesthesia.sysMng.service.BasRoleMenuService;
import com.digihealth.anesthesia.sysMng.service.BasRoleService;
import com.digihealth.anesthesia.sysMng.service.BasUserRoleService;
import com.digihealth.anesthesia.sysMng.service.BasUserService;
import com.digihealth.anesthesia.tmp.service.TmpAnaesDoctempService;
import com.digihealth.anesthesia.tmp.service.TmpIoEventService;
import com.digihealth.anesthesia.tmp.service.TmpMedicineEventService;
import com.digihealth.anesthesia.tmp.service.TmpMedicineService;
import com.digihealth.anesthesia.tmp.service.TmpSciResearchFieldService;
import com.digihealth.anesthesia.tmp.service.TmpSciTempService;

/**
 * 
 * Title: BaseController.java Description: 控制器支持类
 * 
 * @author chengwang
 * @created 2015-10-7 上午10:29:56
 */
public abstract class BaseController {
	@Autowired
	protected HttpServletRequest request;
	@Autowired
	protected DocAnaesPacuRecService docAnaesPacuRecService;
	@Autowired
	protected BasAnnouncementService basAnnouncementService;
	@Autowired
	protected DocInstrubillItemService docInstrubillItemService;
	@Autowired
	protected DocPreVisitService docPreVisitService;
	@Autowired
	protected DocAccedeService docAccedeService;
	@Autowired
	protected DocPrePostVisitService docPrePostVisitService;
	@Autowired
	protected BasHealthNurseService basHealthNurseService;
	@Autowired
	protected ControllerService controllerService;
	@Autowired
	protected DocAnaesPostopService docAnaesPostopService;
	@Autowired
	protected DocOptNurseService docOptNurseService;
	@Autowired
	protected BasIoDefinationService basIoDefinationService;
	@Autowired
	protected EvtOptLatterDiagService evtOptLatterDiagService;
	@Autowired
	protected EvtOptRealOperService evtOptRealOperService;

	@Autowired
	protected EvtAnaesEventService evtAnaesEventService;

	@Autowired
	protected EvtMedicalEventService evtMedicaleventService;

	@Autowired
	protected BasMonitorDisplayService basMonitorDisplayService;
	@Autowired
	protected EvtParticipantService evtParticipantService;
	@Autowired
	protected EvtInEventService evtInEventService;
	@Autowired
	protected DocPatOutRangeAgreeService docPatOutRangeAgreeService;
	@Autowired
	protected EvtCtlBreathService evtCtlBreathService;
	@Autowired
	protected DocAnaesRecordService docAnaesRecordService;
	@Autowired
	protected DocSafeCheckService docSafeCheckService;
	@Autowired
	protected DocAnaesBeforeSafeCheckService docAnaesBeforeSafeCheckService;
	@Autowired
	protected DocOperBeforeSafeCheckService docOperBeforeSafeCheckService;
	@Autowired
	protected DocAnaesPlanService docAnaesPlanService;
	@Autowired
	protected DocExitOperSafeCheckService docExitOperSafeCheckService;
	@Autowired
	protected DocAnaesSummaryService docAnaesSummaryService;
	@Autowired
	protected DocGeneralAnaesService docGeneralAnaesService;
	@Autowired
	protected DocNerveBlockService docNerveBlockService;
	@Autowired
	protected DocSpinalCanalPunctureService docSpinalCanalPunctureService;
	@Autowired
	protected BasDeptService basDeptService;
	@Autowired
	protected DocBadEventService docBadEventService;
	@Autowired
	protected BasDispatchService basDispatchService;
	@Autowired
	protected BasDefaultOperatorService basDefaultOperatorService;
	@Autowired
	protected EvtOtherEventService evtOtherEventService;
	@Autowired
	protected EvtEgressService evtEgressService;
	@Autowired
	protected OperListService operListService;
	@Autowired
	protected BasInstrumentService basInstrumentService;
	@Autowired
	protected BasCheckItemService basCheckItemService;
	@Autowired
	protected BasAnaesMonitorConfigService basAnaesMonitorConfigService;

	@Autowired
	protected BasDeviceConfigService basDeviceConfigService;
	
	@Autowired
	protected BasDeviceService basDeviceService;
	
	@Autowired
	protected BasDeviceMonitorConfigService basDeviceMonitorConfigService;
	@Autowired
	protected EvtOperBodyEventService evtOperBodyEventService;
	@Autowired
	protected BasDeviceSpecificationService basDeviceSpecificationService;
	@Autowired
	protected BasMonitorConfigFreqService basMonitorConfigFreqService;
	@Autowired
	protected BasConsultationService basConsultationService;
	@Autowired
	protected DocOptRiskEvaluationService docOptRiskEvaluationService;
	@Autowired
	protected BasChargeItemService basChargeItemService;
	@Autowired
	protected BasInOutInfoService basInOutInfoService;
	@Autowired
	protected BasPriceService basPriceService;
	@Autowired
	protected DocEventBillingService docEventBillingService;
	@Autowired
	protected BasInventoryService basInventoryService;
	@Autowired
	protected BasChargePackagesService basChargePackagesService;
	@Autowired
	protected StatisticsService statisticsService;
	@Autowired
	protected DocPackagesItemService docPackagesItemService;
	@Autowired
	protected BasObserveDataService observeDataService;
	@Autowired
	protected TmpMedicineEventService tmpMedicineEventService;
	@Autowired
	protected TmpMedicineService tmpMedicineService;
	@Autowired
	protected TmpIoEventService tmpIoEventService;
	@Autowired
	protected EvtMaterialService evtMaterialService;
	@Autowired
	protected DocSelfPayAccedeService docSelfPayAccedeService;
	@Autowired
	protected DocOptCareRecordService docOptCareRecordService;
	@Autowired
	protected BasMonitorFreqChangeService basMonitorFreqChangeService;

	@Autowired
	protected PatInspectItemService patInspectItemService;

	@Autowired
	protected PatInspectRecordService patInspectRecordService;

	@Autowired
	protected DocAnaesPacuObserveRecService docAnaesPacuObserveRecService;
	@Autowired
	protected DocAnalgesicRecordService docAnalgesicRecordService;

	@Autowired
	protected BasAnaesKndgbaseService basAnaesKndgbaseService;
	@Autowired
	protected BasCollectPacuDataService basCollectPacuDataService;
	@Autowired
	protected DocCollectPacuDataService docCollectPacuDataService;
	@Autowired
	protected BasMonitorConfigService basMonitorConfigService;
	@Autowired
	protected AnaesPacuSocketService anaesPacuSocketService;
	@Autowired
	protected BasCollectPacuDataHisService basCollectPacuDataHisService;
	@Autowired
	protected DocOptNurseRecordService docOptNurseRecordService;
	@Autowired
	protected BasColumnStyleService basColumnStyleService;
	@Autowired
	protected BasRowStyleService basRowStyleService;
	@Autowired
	protected BasTitleStyleService basTitleStyleService;

	@Autowired
	protected TmpSciResearchFieldService tmpSciResearchFieldService;

	@Autowired
	protected TmpSciTempService tmpSciTempService;

	@Autowired
	protected QCManagerService qcManagerService;

	@Autowired
	protected BasIconSvgService basIconSvgService;
	@Autowired
	protected DocInsuredChargeInformService docInsuredChargeInformService;

	@Autowired
	protected BasMonitorConfigDefaultService monitorConfigDefaultService;

	@Autowired
	protected BasBusEntityService basBusEntityService;

	@Autowired
	protected BasUserService basUserService;

	@Autowired
	protected BasRoleService basRoleService;

	@Autowired
	protected BasMenuService basMenuService;

	@Autowired
	protected BasUserRoleService basUserRoleService;

	@Autowired
	protected BasRoleMenuService basRoleMenuService;

	@Autowired
	protected BasOperateLogService basOperateLogService;

	@Autowired
	protected BasRegOptService basRegOptService;

	@Autowired
	protected BasRegionService basRegionService;

	@Autowired
	protected BasAnaesMethodService basAnaesMethodService;

	@Autowired
	protected BasDiagnosedefService basDiagnosedefService;

	@Autowired
	protected BasOperationPeopleService basOperationPeopleService;

	@Autowired
	protected BasOperroomService basOperroomService;

	@Autowired
	protected BasSysCodeService basSysCodeService;

	@Autowired
	protected BasOperdefService basOperdefService;

	@Autowired
	protected BasRegionBedService basRegionBedService;

	@Autowired
	protected BasRequiredItemService basRequiredItemService;
	@Autowired
	protected BasMedicineService basMedicineService;
	@Autowired
	protected BasMedicalTakeReasonService basMedicalTakeReasonService;
	@Autowired
	protected BasMedicalTakeWayService basMedicalTakeWayService;
	@Autowired
	protected BasInstrsuitService basInstrsuitService;
	@Autowired
	protected BasInstrSuitRelService basInstrSuitRelService;
	@Autowired
	protected EvtRescueeventService evtRescueeventService;
	@Autowired
	protected EvtRealAnaesMethodService evtRealAnaesMethodService;
	@Autowired
	protected EvtShiftChangeService evtShiftChangeService;
	@Autowired
	protected DocPatShuttleTransferService docPatShuttleTransferService;
	@Autowired
	protected DocPreOperVisitService docPreOperVisitService;
	@Autowired
	protected DocPostFollowRecordService docPostFollowRecordService;
	@Autowired
	protected BasMonitorPupilService basMonitorPupilService;
	@Autowired
	protected TmpAnaesDoctempService tmpAnaesDoctempService;
	@Autowired
	protected EvtCheckEventService evtCheckEventService;
	@Autowired
	protected BasAnaesMedicineInRecordService basAnaesMedicineInRecordService;
	@Autowired
	protected BasAnaesMedicineStorageService basAnaesMedicineStorageService;
	@Autowired
	protected BasAnaesMedicineOutRecordService basAnaesMedicineOutRecordService;
	@Autowired
	protected BasAnaesMedicineRetreatRecordService basAnaesMedicineRetreatRecordService;
	@Autowired
    protected DocInsuredPatAgreeService docInsuredPatAgreeService;
	@Autowired
    protected DocTransferConnectRecordService docTransferConnectRecordService;
	@Autowired
    protected DocPlacentaHandleAgreeService docPlacentaHandleAgreeService;
	@Autowired
	protected BasAnaesMedicineLoseRecordService basAnaesMedicineLoseRecordService;

	/**
	 * 日志对象
	 */
	protected Logger logger = LoggerFactory.getLogger(getClass());

	/**
	 * 管理基础路径
	 */
	@Value("${adminPath}")
	protected String adminPath;

	/**
	 * 前端基础路径
	 */
	@Value("${frontPath}")
	protected String frontPath;

	/**
	 * 前端URL后缀
	 */
	@Value("${urlSuffix}")
	protected String urlSuffix;

	/**
	 * 验证Bean实例对象
	 */
	@Autowired
	protected Validator validator;

	private ValidatorBean validatorBean = new ValidatorBean();

	/**
	 * 服务端参数有效性验证
	 * 
	 * @param object
	 *            验证的实体对象
	 * @param groups
	 *            验证组
	 * @return 验证成功：返回true；严重失败：将错误信息添加到 message 中
	 */
	protected ValidatorBean beanValidator(Object object, Class<?>... groups) {
		try {
			BeanValidators.validateWithException(validator, object, groups);
		} catch (ConstraintViolationException ex) {
			List<String> list = BeanValidators.extractPropertyAndMessageAsList(ex, ": ");
			// list.add(0, "数据验证失败：");
			String result = addMessage(list.toArray(new String[] {}));
			validatorBean.setValidator(false);
			validatorBean.setMessage(result);
			return validatorBean;
		}
		validatorBean.setValidator(true);
		return validatorBean;
	}

	/**
	 * 服务端参数有效性验证
	 * 
	 * @param object
	 *            验证的实体对象
	 * @param groups
	 *            验证组
	 * @return 验证成功：返回true；严重失败：将错误信息添加到 flash message 中
	 */
	protected boolean beanValidator(RedirectAttributes redirectAttributes, Object object, Class<?>... groups) {
		try {
			BeanValidators.validateWithException(validator, object, groups);
		} catch (ConstraintViolationException ex) {
			List<String> list = BeanValidators.extractPropertyAndMessageAsList(ex, ": ");
			list.add(0, "数据验证失败：");
			addMessage(list.toArray(new String[] {}));
			return false;
		}
		return true;
	}

	/**
	 * 服务端参数有效性验证
	 * 
	 * @param object
	 *            验证的实体对象
	 * @param groups
	 *            验证组，不传入此参数时，同@Valid注解验证
	 * @return 验证成功：继续执行；验证失败：抛出异常跳转400页面。
	 */
	/*
	 * protected void beanValidator(Object object, Class<?>... groups) {
	 * BeanValidators.validateWithException(validator, object, groups); }
	 */

	/**
	 * 添加Model消息
	 * 
	 * @param message
	 */
	protected String addMessage(String... messages) {
		StringBuilder sb = new StringBuilder();
		for (String message : messages) {
			sb.append(message);
			return sb.toString();
		}
		return "";
		// model.addAttribute("message", sb.toString());
	}

	/**
	 * 客户端返回JSON字符串
	 * 
	 * @param response
	 * @param object
	 * @return
	 */
	protected String renderString(HttpServletResponse response, Object object) {
		return renderString(response, JsonMapper.toJsonString(object), "application/json");
	}

	/**
	 * 客户端返回字符串
	 * 
	 * @param response
	 * @param string
	 * @return
	 */
	protected String renderString(HttpServletResponse response, String string, String type) {
		try {
			response.reset();
			response.setContentType(type);
			response.setCharacterEncoding("utf-8");
			response.getWriter().print(string);
			return null;
		} catch (IOException e) {
			return null;
		}
	}

	/**
	 * 参数绑定异常
	 */
	@ExceptionHandler({ BindException.class, ConstraintViolationException.class, ValidationException.class })
	public String bindException() {
		return "error/400";
	}

	/**
	 * 增加统一异常处理，如有错误，请查看对应日志
	 * 
	 * @param request
	 * @param ex
	 * @return
	 */
	@ExceptionHandler
	@ResponseBody
	public String exp(HttpServletRequest request, Exception ex) {

		logger.error("exp：uri=" + request.getRequestURI() + ",exception=" + getStackTrace(ex));
		ResponseValue resp = new ResponseValue();
		resp.setResultCode("10000000");
		resp.setResultMessage("系统异常请联系管理员!");
		resp.put("exception", getStackTrace(ex).replace("$", "\\$"));
		resp.put("url", request.getRequestURI());
		// operatelogService.saveOperatelog("", "exception",
		// request.getRequestURI(),getStackTrace(ex).replace("$", "\\$"), "");
		basOperateLogService.saveBasOperateLog("", "exception", request.getRequestURI(), getStackTrace(ex).replace("$", "\\$"), "");
		return resp.getJsonStr();
	}

	/*
	 * protected static String getStackTraceAsString(Throwable e) { if (e ==
	 * null){ return ""; } StringWriter stringWriter = new StringWriter();
	 * e.printStackTrace(new PrintWriter(stringWriter));
	 * 
	 * return stringWriter.toString(); }
	 */

	protected static String getStackTrace(Throwable throwable) {
		return ExceptionUtils.getStackTrace(throwable);
	}

	/**
	 * 从header中获取beid
	 * 
	 * @return
	 */
	public String getBeid() {
		String beid = request.getHeader("beid");
		if (beid == null) {
			beid = basBusEntityService.getBeid();
		}
		return beid;
	}

	/**
	 * 从header中获取module
	 * 
	 * @return
	 */
	public String getModule() {
		return request.getHeader("Module");
	}

	/**
	 * 初始化数据绑定 1. 将所有传递进来的String进行HTML编码，防止XSS攻击 2. 将字段中Date类型转换为String类型
	 */
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		// String类型转换，将所有传递进来的String进行HTML编码，防止XSS攻击
		binder.registerCustomEditor(String.class, new PropertyEditorSupport() {
			@Override
			public void setAsText(String text) {
				setValue(text == null ? null : StringEscapeUtils.escapeHtml4(text.trim()));
			}

			@Override
			public String getAsText() {
				Object value = getValue();
				return value != null ? value.toString() : "";
			}
		});
		// Date 类型转换
		binder.registerCustomEditor(Date.class, new PropertyEditorSupport() {
			@Override
			public void setAsText(String text) {
				setValue(DateUtils.parseDate(text));
			}
			// @Override
			// public String getAsText() {
			// Object value = getValue();
			// return value != null ? DateUtils.formatDateTime((Date)value) :
			// "";
			// }
		});
	}

}
