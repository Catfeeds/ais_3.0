/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.digihealth.anesthesia.common.service;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.digihealth.anesthesia.basedata.dao.BasAnaesKndgbaseDao;
import com.digihealth.anesthesia.basedata.dao.BasAnaesMedicineInRecordDao;
import com.digihealth.anesthesia.basedata.dao.BasAnaesMedicineLoseRecordDao;
import com.digihealth.anesthesia.basedata.dao.BasAnaesMedicineOutRecordDao;
import com.digihealth.anesthesia.basedata.dao.BasAnaesMedicineRetreatRecordDao;
import com.digihealth.anesthesia.basedata.dao.BasAnaesMedicineStorageDao;
import com.digihealth.anesthesia.basedata.dao.BasAnaesMedicineStorageHisDao;
import com.digihealth.anesthesia.basedata.dao.BasAnaesMethodDao;
import com.digihealth.anesthesia.basedata.dao.BasAnnouncementDao;
import com.digihealth.anesthesia.basedata.dao.BasBusEntityDao;
import com.digihealth.anesthesia.basedata.dao.BasChargeItemDao;
import com.digihealth.anesthesia.basedata.dao.BasChargeItemPackagesRelDao;
import com.digihealth.anesthesia.basedata.dao.BasChargePackagesDao;
import com.digihealth.anesthesia.basedata.dao.BasCheckItemDao;
import com.digihealth.anesthesia.basedata.dao.BasCollectPacuDataDao;
import com.digihealth.anesthesia.basedata.dao.BasCollectPacuDataHisDao;
import com.digihealth.anesthesia.basedata.dao.BasColumnStyleDao;
import com.digihealth.anesthesia.basedata.dao.BasConsultationDao;
import com.digihealth.anesthesia.basedata.dao.BasDefaultOperatorDao;
import com.digihealth.anesthesia.basedata.dao.BasDeptDao;
import com.digihealth.anesthesia.basedata.dao.BasDeviceConfigDao;
import com.digihealth.anesthesia.basedata.dao.BasDeviceMonitorConfigDao;
import com.digihealth.anesthesia.basedata.dao.BasDeviceSpecificationDao;
import com.digihealth.anesthesia.basedata.dao.BasDiagnosedefDao;
import com.digihealth.anesthesia.basedata.dao.BasDispatchDao;
import com.digihealth.anesthesia.basedata.dao.BasDocumentDao;
import com.digihealth.anesthesia.basedata.dao.BasHealthNurseDao;
import com.digihealth.anesthesia.basedata.dao.BasIconSvgDao;
import com.digihealth.anesthesia.basedata.dao.BasInOutInfoDao;
import com.digihealth.anesthesia.basedata.dao.BasInspectItemDao;
import com.digihealth.anesthesia.basedata.dao.BasInspectRecordDao;
import com.digihealth.anesthesia.basedata.dao.BasInstrSuitRelDao;
import com.digihealth.anesthesia.basedata.dao.BasInstrsuitDao;
import com.digihealth.anesthesia.basedata.dao.BasInstrumentDao;
import com.digihealth.anesthesia.basedata.dao.BasInventoryDao;
import com.digihealth.anesthesia.basedata.dao.BasInventoryMonthDao;
import com.digihealth.anesthesia.basedata.dao.BasIoDefinationDao;
import com.digihealth.anesthesia.basedata.dao.BasMedicalTakeReasonDao;
import com.digihealth.anesthesia.basedata.dao.BasMedicalTakeWayDao;
import com.digihealth.anesthesia.basedata.dao.BasMedicineDao;
import com.digihealth.anesthesia.basedata.dao.BasMonitorConfigFreqDao;
import com.digihealth.anesthesia.basedata.dao.BasOperateLogDao;
import com.digihealth.anesthesia.basedata.dao.BasOperationPeopleDao;
import com.digihealth.anesthesia.basedata.dao.BasOperdefDao;
import com.digihealth.anesthesia.basedata.dao.BasOperroomDao;
import com.digihealth.anesthesia.basedata.dao.BasPacuBedEventConfigDao;
import com.digihealth.anesthesia.basedata.dao.BasPacuDeviceConfigDao;
import com.digihealth.anesthesia.basedata.dao.BasPacuDeviceMonitorConfigDao;
import com.digihealth.anesthesia.basedata.dao.BasPacuDeviceSpecificationDao;
import com.digihealth.anesthesia.basedata.dao.BasPacuMonitorConfigDao;
import com.digihealth.anesthesia.basedata.dao.BasPriceDao;
import com.digihealth.anesthesia.basedata.dao.BasRegOptDao;
import com.digihealth.anesthesia.basedata.dao.BasRegionBedDao;
import com.digihealth.anesthesia.basedata.dao.BasRegionDao;
import com.digihealth.anesthesia.basedata.dao.BasRequiredItemDao;
import com.digihealth.anesthesia.basedata.dao.BasRowStyleDao;
import com.digihealth.anesthesia.basedata.dao.BasSysCodeDao;
import com.digihealth.anesthesia.basedata.dao.BasTitleStyleDao;
import com.digihealth.anesthesia.basedata.dao.ControllerDao;
import com.digihealth.anesthesia.basedata.formbean.SystemSearchFormBean;
import com.digihealth.anesthesia.common.config.Global;
import com.digihealth.anesthesia.doc.dao.DocAccedeDao;
import com.digihealth.anesthesia.doc.dao.DocAccedeInformedDao;
import com.digihealth.anesthesia.doc.dao.DocAnaesBeforeSafeCheckDao;
import com.digihealth.anesthesia.doc.dao.DocAnaesPacuObserveRecDao;
import com.digihealth.anesthesia.doc.dao.DocAnaesPacuRecDao;
import com.digihealth.anesthesia.doc.dao.DocAnaesPlanDao;
import com.digihealth.anesthesia.doc.dao.DocAnaesPostopDao;
import com.digihealth.anesthesia.doc.dao.DocAnaesRecordDao;
import com.digihealth.anesthesia.doc.dao.DocAnaesSummaryAllergicReactionDao;
import com.digihealth.anesthesia.doc.dao.DocAnaesSummaryAppendixCanalDao;
import com.digihealth.anesthesia.doc.dao.DocAnaesSummaryAppendixGenDao;
import com.digihealth.anesthesia.doc.dao.DocAnaesSummaryAppendixVisitDao;
import com.digihealth.anesthesia.doc.dao.DocAnaesSummaryDao;
import com.digihealth.anesthesia.doc.dao.DocAnaesSummaryVenipunctureDao;
import com.digihealth.anesthesia.doc.dao.DocAnalgesicMedicalInfoDao;
import com.digihealth.anesthesia.doc.dao.DocAnalgesicRecipeDao;
import com.digihealth.anesthesia.doc.dao.DocAnalgesicRecordDao;
import com.digihealth.anesthesia.doc.dao.DocAnalgesicVisitInfoDao;
import com.digihealth.anesthesia.doc.dao.DocBadEventDao;
import com.digihealth.anesthesia.doc.dao.DocEventBillingDao;
import com.digihealth.anesthesia.doc.dao.DocExitOperSafeCheckDao;
import com.digihealth.anesthesia.doc.dao.DocGeneralAnaesDao;
import com.digihealth.anesthesia.doc.dao.DocInstrubillItemDao;
import com.digihealth.anesthesia.doc.dao.DocInsuredChargeInformDao;
import com.digihealth.anesthesia.doc.dao.DocInsuredChargeItemDao;
import com.digihealth.anesthesia.doc.dao.DocInsuredItemDao;
import com.digihealth.anesthesia.doc.dao.DocInsuredPatAgreeDao;
import com.digihealth.anesthesia.doc.dao.DocNerveBlockDao;
import com.digihealth.anesthesia.doc.dao.DocOperBeforeSafeCheckDao;
import com.digihealth.anesthesia.doc.dao.DocOptCareRecordDao;
import com.digihealth.anesthesia.doc.dao.DocOptNurseDao;
import com.digihealth.anesthesia.doc.dao.DocOptNurseRecordDao;
import com.digihealth.anesthesia.doc.dao.DocOptRiskEvaluationDao;
import com.digihealth.anesthesia.doc.dao.DocPackagesItemDao;
import com.digihealth.anesthesia.doc.dao.DocPatOutRangeAgreeDao;
import com.digihealth.anesthesia.doc.dao.DocPatOutRangeItemDao;
import com.digihealth.anesthesia.doc.dao.DocPatShuttleTransferContentDao;
import com.digihealth.anesthesia.doc.dao.DocPatShuttleTransferDao;
import com.digihealth.anesthesia.doc.dao.DocPlacentaHandleAgreeDao;
import com.digihealth.anesthesia.doc.dao.DocPostFollowAnalgesicDao;
import com.digihealth.anesthesia.doc.dao.DocPostFollowGeneralDao;
import com.digihealth.anesthesia.doc.dao.DocPostFollowRecordDao;
import com.digihealth.anesthesia.doc.dao.DocPostFollowSpinalDao;
import com.digihealth.anesthesia.doc.dao.DocPreOperVisitDao;
import com.digihealth.anesthesia.doc.dao.DocPrePostVisitDao;
import com.digihealth.anesthesia.doc.dao.DocPrePostVisitItemDao;
import com.digihealth.anesthesia.doc.dao.DocPreVisitDao;
import com.digihealth.anesthesia.doc.dao.DocPrevisitAccessexamDao;
import com.digihealth.anesthesia.doc.dao.DocPrevisitAnaesplanDao;
import com.digihealth.anesthesia.doc.dao.DocPrevisitPhyexamDao;
import com.digihealth.anesthesia.doc.dao.DocSafeCheckDao;
import com.digihealth.anesthesia.doc.dao.DocSelfPayAccedeDao;
import com.digihealth.anesthesia.doc.dao.DocSpinalCanalPunctureDao;
import com.digihealth.anesthesia.doc.dao.DocTransferConnectRecordDao;
import com.digihealth.anesthesia.doc.dao.DocTransferConnectTypeDao;
import com.digihealth.anesthesia.evt.dao.EvtAnaesEventDao;
import com.digihealth.anesthesia.evt.dao.EvtCheckEventDao;
import com.digihealth.anesthesia.evt.dao.EvtCheckEventItemRelationDao;
import com.digihealth.anesthesia.evt.dao.EvtCtlBreathDao;
import com.digihealth.anesthesia.evt.dao.EvtEgressDao;
import com.digihealth.anesthesia.evt.dao.EvtInEventDao;
import com.digihealth.anesthesia.evt.dao.EvtMaterialDao;
import com.digihealth.anesthesia.evt.dao.EvtMedicalEventDao;
import com.digihealth.anesthesia.evt.dao.EvtMedicalEventDetailDao;
import com.digihealth.anesthesia.evt.dao.EvtOperBodyEventDao;
import com.digihealth.anesthesia.evt.dao.EvtOptLatterDiagDao;
import com.digihealth.anesthesia.evt.dao.EvtOptRealOperDao;
import com.digihealth.anesthesia.evt.dao.EvtOtherEventDao;
import com.digihealth.anesthesia.evt.dao.EvtParticipantDao;
import com.digihealth.anesthesia.evt.dao.EvtRealAnaesMethodDao;
import com.digihealth.anesthesia.evt.dao.EvtRescueeventDao;
import com.digihealth.anesthesia.evt.dao.EvtShiftChangeDao;
import com.digihealth.anesthesia.inspect.dao.PatInspectItemDao;
import com.digihealth.anesthesia.inspect.dao.PatInspectRecordDao;
import com.digihealth.anesthesia.operProceed.dao.BasAnaesMonitorConfigDao;
import com.digihealth.anesthesia.operProceed.dao.BasMonitorConfigDao;
import com.digihealth.anesthesia.operProceed.dao.BasMonitorConfigDefaultDao;
import com.digihealth.anesthesia.operProceed.dao.BasMonitorDisplayChangeHisDao;
import com.digihealth.anesthesia.operProceed.dao.BasMonitorDisplayDao;
import com.digihealth.anesthesia.operProceed.dao.BasMonitorFreqChangeDao;
import com.digihealth.anesthesia.operProceed.dao.BasMonitorPupilDao;
import com.digihealth.anesthesia.operProceed.dao.BasObserveDataDao;
import com.digihealth.anesthesia.operProceed.dao.BasObserveDataHisDao;
import com.digihealth.anesthesia.operProceed.dao.ObserveDataChangeHisDao;
import com.digihealth.anesthesia.research.dao.StatisticsDao;
import com.digihealth.anesthesia.sysMng.dao.BasMenuDao;
import com.digihealth.anesthesia.sysMng.dao.BasRoleDao;
import com.digihealth.anesthesia.sysMng.dao.BasRoleMenuDao;
import com.digihealth.anesthesia.sysMng.dao.BasUserDao;
import com.digihealth.anesthesia.sysMng.dao.BasUserRoleDao;
import com.digihealth.anesthesia.tmp.dao.TmpAnaesDoctempDao;
import com.digihealth.anesthesia.tmp.dao.TmpIoEventDao;
import com.digihealth.anesthesia.tmp.dao.TmpMedicineDao;
import com.digihealth.anesthesia.tmp.dao.TmpMedicineEventDao;
import com.digihealth.anesthesia.tmp.dao.TmpSciResearchFieldDao;
import com.digihealth.anesthesia.tmp.dao.TmpSciTempDao;

/**
 * 
 * Title: BaseService.java Description: Service基类
 * 
 * @author chengwang
 * @created 2015-10-8 下午1:57:36
 */
@Transactional
public abstract class BaseService {

	/**
	 * 日志对象
	 */
	protected Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	protected HttpServletRequest request;
	
	@Autowired
	protected BasAnnouncementDao basAnnouncementDao;
	@Autowired
	protected BasPriceDao basPriceDao;
	@Autowired
	protected BasMedicineDao basMedicineDao;
	@Autowired
	protected DocPreVisitDao docPreVisitDao;
	@Autowired
	protected DocAccedeDao docAccedeDao;
	@Autowired
	protected BasAnaesMethodDao basAnaesMethodDao;
	@Autowired
	protected StatisticsDao statisticsDao;
	@Autowired
	protected ControllerDao controllerDao;
	@Autowired
	protected DocAnaesPostopDao docAnaesPostopDao;
	@Autowired
	protected DocOptNurseDao docOptNurseDao;
	@Autowired
	protected DocAnaesPlanDao docAnaesPlanDao;
	@Autowired
	protected BasIoDefinationDao basIoDefinationDao;
	@Autowired
	protected BasInstrumentDao basInstrumentDao;
	@Autowired
	protected BasInstrSuitRelDao basInstrSuitRelDao;
	@Autowired
	protected DocAnaesRecordDao docAnaesRecordDao;
	
	@Autowired
	protected EvtAnaesEventDao evtAnaesEventDao;
	
	@Autowired
	protected EvtMedicalEventDao evtMedicaleventDao;

	@Autowired
	protected EvtOptRealOperDao evtOptRealOperDao;
	@Autowired
	protected EvtInEventDao evtInEventDao;
	
	@Autowired
	protected EvtCtlBreathDao evtCtlBreathDao;
	@Autowired
	protected DocSafeCheckDao docSafeCheckDao;
	@Autowired
	protected BasHealthNurseDao basHealthNurseDao;
	@Autowired
	protected BasOperationPeopleDao basOperationPeopleDao;
	@Autowired
	protected BasOperdefDao basOperdefDao;
	@Autowired
	protected DocAnaesBeforeSafeCheckDao docAnaesBeforeSafeCheckDao;
	@Autowired
	protected DocOperBeforeSafeCheckDao docOperBeforeSafeCheckDao;
	@Autowired
	protected DocExitOperSafeCheckDao docExitOperSafeCheckDao;
	@Autowired
	protected DocAnaesSummaryDao docAnaesSummaryDao;
	@Autowired
	protected DocGeneralAnaesDao docGeneralAnaesDao;
	@Autowired
	protected DocNerveBlockDao docNerveBlockDao;
	@Autowired
	protected BasRegionDao basRegionDao;
	@Autowired
	protected DocBadEventDao docBadEventDao;
	@Autowired
	protected EvtOtherEventDao evtOtherEventDao;
	@Autowired
	protected EvtOptLatterDiagDao evtOptLatterDiagDao;
	
	@Autowired
	protected EvtCheckEventItemRelationDao evtCheckEventItemRelationDao;

	@Autowired
	protected EvtCheckEventDao evtCheckEventDao;
	
	@Autowired
	protected EvtEgressDao evtEgressDao;
	@Autowired
	protected DocAccedeInformedDao docAccedeInformedDao;
	@Autowired
	protected BasCheckItemDao basCheckItemDao;
	@Autowired
	protected BasAnaesMonitorConfigDao basAnaesMonitorConfigDao;
	@Autowired
	protected BasDeviceMonitorConfigDao basDeviceMonitorConfigDao;
	@Autowired
	protected EvtOperBodyEventDao evtOperBodyEventDao;
	@Autowired
	protected BasDeviceSpecificationDao basDeviceSpecificationDao;
	@Autowired
	protected BasDeviceConfigDao basDeviceConfigDao;
	@Autowired
	protected BasMonitorConfigFreqDao basMonitorConfigFreqDao;
	@Autowired
	protected BasConsultationDao basConsultationDao;
	@Autowired
	protected BasDiagnosedefDao basDiagnosedefDao;
	@Autowired
	protected DocOptRiskEvaluationDao docOptRiskEvaluationDao;
	@Autowired
	protected BasChargeItemDao basChargeItemDao;
	@Autowired
	protected BasInOutInfoDao basInOutInfoDao;
	@Autowired
	protected BasInventoryDao basInventoryDao;
	@Autowired
	protected BasInventoryMonthDao basInventoryMonthDao;
	@Autowired
	protected DocEventBillingDao docEventBillingDao;
	@Autowired
	protected BasChargePackagesDao basChargePackagesDao;
	@Autowired
	protected BasChargeItemPackagesRelDao basChargeItemPackagesRelDao;
	@Autowired
    protected BasObserveDataHisDao basObserveDataHisDao;
	@Autowired
	protected BasObserveDataDao basObserveDataDao;
	@Autowired
	protected EvtParticipantDao evtParticipantDao;
	@Autowired
	protected BasDeptDao basDeptDao;
	@Autowired
	protected DocPackagesItemDao docPackagesItemDao;
	@Autowired
	protected ObserveDataChangeHisDao observeDataChangeDao;
	
	@Autowired
	protected BasMonitorDisplayChangeHisDao basMonitorDisplayChangeHisDao;
	@Autowired
	protected DocPatOutRangeItemDao docPatOutRangeItemDao;
	@Autowired
	protected DocOptCareRecordDao docOptCareRecordDao;
	@Autowired
	protected BasOperroomDao basOperroomDao;
	@Autowired
	protected EvtMaterialDao evtMaterialDao;
	
	@Autowired
	protected DocAnalgesicRecipeDao docAnalgesicRecipeDao;
	@Autowired
	protected DocAnalgesicMedicalInfoDao docAnalgesicMedicalInfoDao;
	@Autowired
	protected DocAnalgesicVisitInfoDao docAnalgesicVisitInfoDao;
	@Autowired
	protected BasMonitorDisplayDao basMonitorDisplayDao;
	@Autowired
	protected DocInstrubillItemDao docInstrubillItemDao;
	@Autowired
	protected BasMonitorFreqChangeDao basMonitorFreqChangeDao;
	@Autowired
	protected BasMonitorConfigDao basMonitorConfigDao;
	@Autowired
	protected PatInspectItemDao patInspectItemDao;
	@Autowired
	protected PatInspectRecordDao patInspectRecordDao;
	@Autowired
	protected BasInspectItemDao basInspectItemDao;
	@Autowired
	protected BasInspectRecordDao basInspectRecordDao;
	@Autowired
	protected DocAnaesPacuRecDao docAnaesPacuRecDao;
	@Autowired
    protected DocAnaesPacuObserveRecDao docAnaesPacuObserveRecDao;
	@Autowired
	protected DocAnalgesicRecordDao docAnalgesicRecordDao;
	@Autowired
	protected TmpAnaesDoctempDao tmpAnaesDoctempDao;
	@Autowired
	protected TmpIoEventDao tmpIoEventDao;
	@Autowired
    protected TmpMedicineEventDao tmpMedicineEventDao;
	@Autowired
    protected TmpMedicineDao tmpMedicineDao;
	@Autowired
    protected TmpSciResearchFieldDao tmpSciResearchFieldDao;
	@Autowired
    protected TmpSciTempDao tmpSciTempDao;
	@Autowired
	protected BasCollectPacuDataDao basCollectPacuDataDao;
	@Autowired
	protected BasCollectPacuDataHisDao basCollectPacuDataHisDao;
	@Autowired
	protected DocAnaesSummaryAppendixCanalDao docAnaesSummaryAppendixCanalDao;
	@Autowired
	protected DocAnaesSummaryAppendixGenDao docAnaesSummaryAppendixGenDao;
	@Autowired
	protected DocAnaesSummaryAppendixVisitDao docAnaesSummaryAppendixVisitDao;
	@Autowired
	protected DocOptNurseRecordDao docOptNurseRecordDao;
	@Autowired
	protected BasColumnStyleDao basColumnStyleDao;
	@Autowired
	protected BasRowStyleDao basRowStyleDao;
	@Autowired
	protected BasTitleStyleDao basTitleStyleDao;
	@Autowired
	protected DocPrePostVisitItemDao docPrePostVisitItemDao;
	
	@Autowired
	protected EvtMedicalEventDetailDao evtMedicalEventDetailDao;
	
	@Autowired
	protected DocInsuredChargeInformDao docInsuredChargeInformDao;
	@Autowired
	protected DocInsuredChargeItemDao docInsuredChargeItemDao;
	@Autowired
    protected BasMonitorConfigDefaultDao basMonitorConfigDefaultDao;
	
	@Autowired
	protected BasBusEntityDao basBusEntityDao;
	
	@Autowired
	protected BasUserRoleDao basUserRoleDao;

	@Autowired
	protected BasRoleMenuDao basRoleMenuDao;
	
	@Autowired
	protected BasRoleDao basRoleDao;
	
	@Autowired
	protected BasUserDao basUserDao;

	@Autowired
	protected BasMenuDao basMenuDao;
	
	@Autowired
	protected BasSysCodeDao basSysCodeDao;
	
	@Autowired
	protected BasOperateLogDao basOperateLogDao;
	
	@Autowired
	protected BasRegOptDao basRegOptDao;

	@Autowired
	protected BasDispatchDao basDispatchDao;
	
	@Autowired
	protected BasAnaesKndgbaseDao basAnaesKndgbaseDao;
	@Autowired
    protected BasDefaultOperatorDao basDefaultOperatorDao;
	@Autowired
	protected BasRegionBedDao basRegionBedDao;
	@Autowired
	protected BasRequiredItemDao basRequiredItemDao;
	
	@Autowired
	protected BasMedicalTakeReasonDao basMedicalTakeReasonDao;
	
	@Autowired
	protected BasMedicalTakeWayDao basMedicalTakeWayDao;
	
	@Autowired
    protected BasInstrsuitDao basInstrsuitDao;
	
	@Autowired
	protected BasMonitorPupilDao basMonitorPupilDao;
	
	@Autowired
	protected BasIconSvgDao basIconSvgDao;
	@Autowired
	protected DocPatOutRangeAgreeDao docPatOutRangeAgreeDao;
	
	@Autowired
	protected DocPrePostVisitDao docPrePostVisitDao;
	
	@Autowired
	protected DocPatShuttleTransferDao docPatShuttleTransferDao;
	
	@Autowired
	protected DocAnaesSummaryAllergicReactionDao docAnaesSummaryAllergicReactionDao;
	
	@Autowired
	protected DocAnaesSummaryVenipunctureDao docAnaesSummaryVenipunctureDao;

	@Autowired
	protected DocPostFollowRecordDao docPostFollowRecordDao;
	@Autowired
	protected DocPrevisitAccessexamDao docPrevisitAccessexamDao;
	@Autowired
	protected DocPrevisitAnaesplanDao docPrevisitAnaesplanDao;
	@Autowired
	protected DocPrevisitPhyexamDao docPrevisitPhyexamDao;
	@Autowired
	protected DocSelfPayAccedeDao docSelfPayAccedeDao;
	@Autowired
	protected DocSpinalCanalPunctureDao docSpinalCanalPunctureDao;
    @Autowired
    protected BasDocumentDao basDocumentDao;
    @Autowired
    protected EvtRescueeventDao evtRescueeventDao;
    @Autowired
    protected EvtRealAnaesMethodDao evtRealAnaesMethodDao;
    @Autowired
    protected EvtShiftChangeDao evtShiftChangeDao;
	@Autowired
	protected DocPatShuttleTransferContentDao docPatShuttleTransferContentDao;
    @Autowired
    protected DocPreOperVisitDao docPreOperVisitDao;
    @Autowired
    protected DocPostFollowAnalgesicDao docPostFollowAnalgesicDao;
    @Autowired
    protected DocPostFollowGeneralDao docPostFollowGeneralDao;
    @Autowired
    protected DocPostFollowSpinalDao docPostFollowSpinalDao;
    @Autowired
    protected BasPacuDeviceConfigDao basPacuDeviceConfigDao;
    @Autowired
    protected BasPacuBedEventConfigDao basPacuBedEventConfigDao;
    @Autowired
    protected BasPacuDeviceSpecificationDao basPacuDeviceSpecificationDao;
    @Autowired
    protected BasPacuMonitorConfigDao basPacuMonitorConfigDao;
    @Autowired
    protected BasAnaesMedicineInRecordDao basAnaesMedicineInRecordDao;
    @Autowired
    protected BasAnaesMedicineStorageDao basAnaesMedicineStorageDao;
    @Autowired
    protected BasAnaesMedicineOutRecordDao basAnaesMedicineOutRecordDao;
    @Autowired
    protected BasAnaesMedicineRetreatRecordDao basAnaesMedicineRetreatRecordDao;
    @Autowired
    protected BasAnaesMedicineLoseRecordDao basAnaesMedicineLoseRecordDao;
    @Autowired
    protected BasAnaesMedicineStorageHisDao basAnaesMedicineStorageHisDao;
    @Autowired
    protected DocInsuredPatAgreeDao docInsuredPatAgreeDao;
    @Autowired
    protected DocInsuredItemDao docInsuredItemDao;
    @Autowired
    protected DocTransferConnectRecordDao docTransferConnectRecordDao;
    @Autowired
    protected DocTransferConnectTypeDao docTransferConnectTypeDao;
    @Autowired
    protected DocPlacentaHandleAgreeDao docPlacentaHandleAgreeDao;
    @Autowired
    protected BasPacuDeviceMonitorConfigDao basPacuDeviceMonitorConfigDao;
    
	public String getBeid() {
		String beid = null;
		try {
			if (null != request && null != request.getHeader("beid")) {
				beid = request.getHeader("beid");
			}
		} catch (IllegalStateException e) {
			//logger.error("特殊处理(取不到request的异常,不处理)：DataCollMgr--checkMonitorData--"+Exceptions.getStackTraceAsString(e));
			logger.warn("特殊处理(取不到request的异常,不处理)：getBeid--DataCollMgr--checkMonitorData");
		}
		//logger.info("beid==start=="+beid+"bool=="+StringUtils.isBlank(beid));
		if (StringUtils.isBlank(beid)) {
			beid = basBusEntityDao.getBeid();
			//logger.info("beid==isBlank=="+beid);
			if(StringUtils.isBlank(beid)){
				beid = Global.getConfig("operatorBeid").toString();
				//logger.info("beid==else=="+beid);
			}
		}
		//logger.info("beid===final==="+beid);
		return beid;
	}
	
	public static void main(String[] args) {
		String beid = null;
		boolean bool = StringUtils.isBlank(beid);
		System.out.println(bool);
	}
	/**
	 * 设置查询参数的beid
	 * @param systemSearchFormBean
	 * @return
	 */
	public SystemSearchFormBean setBeid(SystemSearchFormBean searchFormBean) {
		if (StringUtils.isBlank(searchFormBean.getBeid())) {
			searchFormBean.setBeid(getBeid());
		}
		return searchFormBean;
	}
	
	public String getUserName(){
		return request.getHeader("username");
	}
	
	/**
	 * 获取module
	 * @return
	 */
	public String getModule(){
		String module = request.getHeader("module");//从header中获取module
		if(StringUtils.isBlank(module)){
			module = Global.getConfig("defModule").toString(); //取配置文件中的module
		}
		return module;
	}
}
