/**     
 * @discription 在此输入一句话描述此文件的作用
 * @author chengwang       
 * @created 2015-10-19 下午4:42:09    
 * tags     
 * see_to_target     
 */

package com.digihealth.anesthesia.basedata.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.digihealth.anesthesia.basedata.config.OperationState;
import com.digihealth.anesthesia.basedata.po.BasDispatch;
import com.digihealth.anesthesia.basedata.po.BasRegOpt;
import com.digihealth.anesthesia.basedata.po.Controller;
import com.digihealth.anesthesia.common.entity.ResponseValue;
import com.digihealth.anesthesia.common.service.BaseService;
import com.digihealth.anesthesia.common.utils.GenerateSequenceUtil;
import com.digihealth.anesthesia.doc.po.DocAccede;
import com.digihealth.anesthesia.doc.po.DocAnaesBeforeSafeCheck;
import com.digihealth.anesthesia.doc.po.DocAnaesPlan;
import com.digihealth.anesthesia.doc.po.DocAnaesRecord;
import com.digihealth.anesthesia.doc.po.DocAnaesSummary;
import com.digihealth.anesthesia.doc.po.DocAnaesSummaryAllergicReaction;
import com.digihealth.anesthesia.doc.po.DocAnaesSummaryAppendixCanal;
import com.digihealth.anesthesia.doc.po.DocAnaesSummaryAppendixGen;
import com.digihealth.anesthesia.doc.po.DocAnaesSummaryAppendixVisit;
import com.digihealth.anesthesia.doc.po.DocAnaesSummaryVenipuncture;
import com.digihealth.anesthesia.doc.po.DocExitOperSafeCheck;
import com.digihealth.anesthesia.doc.po.DocInsuredPatAgree;
import com.digihealth.anesthesia.doc.po.DocOperBeforeSafeCheck;
import com.digihealth.anesthesia.doc.po.DocOptCareRecord;
import com.digihealth.anesthesia.doc.po.DocOptNurse;
import com.digihealth.anesthesia.doc.po.DocOptRiskEvaluation;
import com.digihealth.anesthesia.doc.po.DocPatOutRangeAgree;
import com.digihealth.anesthesia.doc.po.DocPatShuttleTransfer;
import com.digihealth.anesthesia.doc.po.DocPlacentaHandleAgree;
import com.digihealth.anesthesia.doc.po.DocPostFollowRecord;
import com.digihealth.anesthesia.doc.po.DocPreOperVisit;
import com.digihealth.anesthesia.doc.po.DocPrePostVisit;
import com.digihealth.anesthesia.doc.po.DocPreVisit;
import com.digihealth.anesthesia.doc.po.DocSafeCheck;
import com.digihealth.anesthesia.doc.po.DocTransferConnectRecord;

/**
 * Title: ControllerService.java Description: 描述
 * 
 * @author chengwang
 * @created 2015-10-19 下午4:42:09
 */
@Service
public class ControllerService extends BaseService {

    /**
     * 
     * @discription 改变状态
     * @author chengwang
     * @created 2015-10-19 下午4:44:04
     * @param id
     * @param state
     * @return
     */
    @Transactional
    public void checkOperation(String ids, String state,String previousState,ResponseValue respValue) {
        List<String> idsList = new ArrayList<String>();
        String[] idsString = ids.split(",");
        for (int i = 0; i < idsString.length; i++) {
            idsList.add(idsString[i]);
        }
        int succCnt = 0;
        //List<DocumentType> documentType = documentTypeDao.searchDocumentTypeByEnable("");
        if (idsList.size() > 0 && idsList != null) {
            for (int i = 0; i < idsList.size(); i++) {
                BasRegOpt regOpt = basRegOptDao.searchRegOptById(idsList.get(i));
                if(regOpt!=null){
                    if(StringUtils.isEmpty(regOpt.getDesignedAnaesMethodName())||StringUtils.isEmpty(regOpt.getDesignedAnaesMethodCode())){
                        continue;
                    }
                }
                Controller c = controllerDao.getControllerById(idsList.get(i));
                if(c!=null){
                    if(c.getState().equals(OperationState.NOT_REVIEWED)){
                        controllerDao.checkOperation(idsList.get(i), state,previousState);
                        
                        // 创建术前访视单
                        DocPreVisit preVisit = new DocPreVisit();
                        preVisit.setPreVisitId(GenerateSequenceUtil.generateSequenceNo());
                        preVisit.setRegOptId(idsList.get(i));
                        preVisit.setProcessState("NO_END");
                        docPreVisitDao.insert(preVisit);

                        // 创建术前访视单
                        DocPreOperVisit docPreOperVisit = new DocPreOperVisit();
                        docPreOperVisit.setId(GenerateSequenceUtil.generateSequenceNo());
                        docPreOperVisit.setRegOptId(idsList.get(i));
                        docPreOperVisit.setProcessState("NO_END");
                        docPreOperVisitDao.insert(docPreOperVisit);
                        
                        // 创建麻醉同意书
                        DocAccede accede = new DocAccede();
                        accede.setAccedeId(GenerateSequenceUtil.generateSequenceNo());
                        accede.setRegOptId(idsList.get(i));
                        accede.setFlag("1");
                        accede.setProcessState("NO_END");
                        docAccedeDao.insert(accede);

                        //麻醉计划单
                        DocAnaesPlan anaesPlan = new DocAnaesPlan();
                        anaesPlan.setRegOptId(idsList.get(i));
                        anaesPlan.setProcessState("NO_END");
                        anaesPlan.setId(GenerateSequenceUtil.generateSequenceNo());
                        docAnaesPlanDao.insert(anaesPlan);
                        
                        //医疗保险病人超范围用药同意书
                        DocPatOutRangeAgree patOutRangeAgree = new DocPatOutRangeAgree();
                        patOutRangeAgree.setRegOptId(idsList.get(i));
                        patOutRangeAgree.setProcessState("NO_END");
                        patOutRangeAgree.setId(GenerateSequenceUtil.generateSequenceNo());
                        docPatOutRangeAgreeDao.insert(patOutRangeAgree);
                        
                        //手术病人术前术后访问记录单
                        DocPrePostVisit prePostVisit = new DocPrePostVisit();
                        prePostVisit.setRegOptId(idsList.get(i));
                        prePostVisit.setProcessState("NO_END");
                        //急诊时不需要此单子，直接设置状态为完成
                        if ("1".equals(regOpt.getEmergency()))
                        {
                            prePostVisit.setProcessState("END");
                        }
                        prePostVisit.setId(GenerateSequenceUtil.generateSequenceNo());
                        docPrePostVisitDao.insert(prePostVisit);
                        
                        //手术患者接送交接单
                        DocPatShuttleTransfer patShuttleTransfer = new DocPatShuttleTransfer();
                        patShuttleTransfer.setRegOptId(idsList.get(i));
                        patShuttleTransfer.setProcessState("NO_END");
                        patShuttleTransfer.setId(GenerateSequenceUtil.generateSequenceNo());
                        docPatShuttleTransferDao.insert(patShuttleTransfer);
                        
                        //创建手术风险评估单 
                        DocOptRiskEvaluation optRiskEvaluatio = new DocOptRiskEvaluation();
                        optRiskEvaluatio.setRegOptId(idsList.get(i));
                        optRiskEvaluatio.setOptRiskEvaluationId(GenerateSequenceUtil.generateSequenceNo());
                        optRiskEvaluatio.setProcessState("NO_END");
                        //局麻时直接设置状态为完成
                        if ("1".equals(regOpt.getIsLocalAnaes()))
                        {
                            optRiskEvaluatio.setProcessState("END");
                        }
                        optRiskEvaluatio.setFlag("1");
                        docOptRiskEvaluationDao.insert(optRiskEvaluatio);
                        
                        //创建麻醉记录单
                        DocAnaesRecord anaesRecord = new DocAnaesRecord();
                        anaesRecord.setAnaRecordId(GenerateSequenceUtil.generateSequenceNo());
                        anaesRecord.setOther("O2L/min");
                        anaesRecord.setProcessState("NO_END");
                        anaesRecord.setRegOptId(idsList.get(i));
                        docAnaesRecordDao.insert(anaesRecord);
                        
                        //麻醉总结单
                        DocAnaesSummary anaesSummary = new DocAnaesSummary();
                        anaesSummary.setRegOptId(idsList.get(i));
                        anaesSummary.setProcessState("NO_END");
                        anaesSummary.setAnaSumId(GenerateSequenceUtil.generateSequenceNo());
                        docAnaesSummaryDao.insert(anaesSummary);
                        //椎管内麻醉
                        DocAnaesSummaryAppendixCanal anaesSummaryAppendixCanal = new DocAnaesSummaryAppendixCanal();
                        anaesSummaryAppendixCanal.setAnaSumId(anaesSummary.getAnaSumId());
                        anaesSummaryAppendixCanal.setAnaSumAppCanId(GenerateSequenceUtil.generateSequenceNo());
                        docAnaesSummaryAppendixCanalDao.insert(anaesSummaryAppendixCanal);
                        //全麻
                        DocAnaesSummaryAppendixGen anaesSummaryAppendixGen = new DocAnaesSummaryAppendixGen();
                        anaesSummaryAppendixGen.setAnaSumId(anaesSummary.getAnaSumId());
                        anaesSummaryAppendixGen.setAnaSumAppGenId(GenerateSequenceUtil.generateSequenceNo());
                        docAnaesSummaryAppendixGenDao.insert(anaesSummaryAppendixGen);
                        //术后访视
                        DocAnaesSummaryAppendixVisit anaesSummaryAppendixVisit = new DocAnaesSummaryAppendixVisit();
                        anaesSummaryAppendixVisit.setAnaSumId(anaesSummary.getAnaSumId());
                        anaesSummaryAppendixVisit.setAnesSumVisId(GenerateSequenceUtil.generateSequenceNo());
                        docAnaesSummaryAppendixVisitDao.insert(anaesSummaryAppendixVisit);
                        //并发症
                        DocAnaesSummaryAllergicReaction anaesSummaryAllergicReaction = new DocAnaesSummaryAllergicReaction();
                        anaesSummaryAllergicReaction.setAnaSumId(anaesSummary.getAnaSumId());
                        anaesSummaryAllergicReaction.setAnaSumAllReaId(GenerateSequenceUtil.generateSequenceNo());
                        docAnaesSummaryAllergicReactionDao.insert(anaesSummaryAllergicReaction);
                        //中心静脉穿刺
                        DocAnaesSummaryVenipuncture  anaesSummaryVenipuncture = new DocAnaesSummaryVenipuncture();
                        anaesSummaryVenipuncture.setAnaSumId(anaesSummary.getAnaSumId());
                        anaesSummaryVenipuncture.setAnesSumVenId(GenerateSequenceUtil.generateSequenceNo());
                        docAnaesSummaryVenipunctureDao.insert(anaesSummaryVenipuncture);
                        
                        //创建手术护理记录文书
                        DocOptCareRecord optCareRecord = new DocOptCareRecord();
                        optCareRecord.setRegOptId(idsList.get(i));
                        optCareRecord.setId(GenerateSequenceUtil.generateSequenceNo());
                        optCareRecord.setProcessState("NO_END");
                        docOptCareRecordDao.insert(optCareRecord);
                        
                        //创建手术清点记录
                        DocOptNurse optNurse = new DocOptNurse();
                        optNurse.setRegOptId(idsList.get(i));
                        optNurse.setOptNurseId(GenerateSequenceUtil.generateSequenceNo());
                        optNurse.setProcessState("NO_END");
                        docOptNurseDao.insert(optNurse);
                        
                        //创建手术核查单
                        DocSafeCheck safeCheck = new DocSafeCheck();
                        safeCheck.setRegOptId(idsList.get(i));
                        safeCheck.setProcessState("NO_END");
                        safeCheck.setSafCheckId(GenerateSequenceUtil.generateSequenceNo());
                        docSafeCheckDao.insert(safeCheck);
                        DocAnaesBeforeSafeCheck anaesBeforeSafeCheck = new DocAnaesBeforeSafeCheck();
                        anaesBeforeSafeCheck.setRegOptId(idsList.get(i));
                        anaesBeforeSafeCheck.setAnesBeforeId(GenerateSequenceUtil.generateSequenceNo());
                        anaesBeforeSafeCheck.setProcessState("NO_END");
                        docAnaesBeforeSafeCheckDao.insert(anaesBeforeSafeCheck);
                        DocOperBeforeSafeCheck operBeforeSafeCheck = new DocOperBeforeSafeCheck();
                        operBeforeSafeCheck.setRegOptId(idsList.get(i));
                        operBeforeSafeCheck.setOperBeforeId(GenerateSequenceUtil.generateSequenceNo());
                        operBeforeSafeCheck.setProcessState("NO_END");
                        docOperBeforeSafeCheckDao.insert(operBeforeSafeCheck);
                        DocExitOperSafeCheck exitOperSafeCheck = new DocExitOperSafeCheck();
                        exitOperSafeCheck.setRegOptId(idsList.get(i));
                        exitOperSafeCheck.setProcessState("NO_END");
                        exitOperSafeCheck.setExitOperId(GenerateSequenceUtil.generateSequenceNo());
                        docExitOperSafeCheckDao.insert(exitOperSafeCheck);
                        
                        //术后随访记录单
                        DocPostFollowRecord postFollowRecord = new DocPostFollowRecord();
                        postFollowRecord.setRegOptId(idsList.get(i));
                        postFollowRecord.setProcessState("NO_END");
                        postFollowRecord.setPostFollowId(GenerateSequenceUtil.generateSequenceNo());
                        docPostFollowRecordDao.insert(postFollowRecord);
                        
                        //参保患者特殊用药、卫材知情单
                        DocInsuredPatAgree insuredPatAgree = new DocInsuredPatAgree();
                        insuredPatAgree.setRegOptId(idsList.get(i));
                        insuredPatAgree.setProcessState("NO_END");
                        insuredPatAgree.setId(GenerateSequenceUtil.generateSequenceNo());
                        docInsuredPatAgreeDao.insert(insuredPatAgree);
                        
                        //手术病人转运交接记录单
                        DocTransferConnectRecord transferConnectRecord = new DocTransferConnectRecord();
                        transferConnectRecord.setRegOptId(idsList.get(i));
                        transferConnectRecord.setProcessState("NO_END");
                        transferConnectRecord.setId(GenerateSequenceUtil.generateSequenceNo());
                        docTransferConnectRecordDao.insert(transferConnectRecord);
                        
                        //胎盘处置知情同意书
                        DocPlacentaHandleAgree placentaHandleAgree = new DocPlacentaHandleAgree();
                        placentaHandleAgree.setRegOptId(idsList.get(i));
                        placentaHandleAgree.setProcessState("NO_END");
                        placentaHandleAgree.setId(GenerateSequenceUtil.generateSequenceNo());
                        docPlacentaHandleAgreeDao.insert(placentaHandleAgree);
                        
                        //在审核的时候  生成排程信息记录 
                        int dispatchCount = basDispatchDao.searchDistchByRegOptId(idsList.get(i));
                        if(dispatchCount<1){
                            BasDispatch dispatch = new BasDispatch();
                            dispatch.setRegOptId(idsList.get(i));
                            dispatch.setBeid(getBeid());
                            basDispatchDao.insert(dispatch);
                        }
                        
                        succCnt ++;
                    }
                }
            }
        }
        
        if(idsList.size() - succCnt > 0){
            int failCnt = idsList.size() - succCnt; 
            respValue.setResultMessage("批量审核完成!其中成功"+succCnt+"条数据,"+"失败"+failCnt+"条数据");
        }
    }
    
    /**
     * 
         * @discription 改变手术状态
         * @author chengwang       
         * @created 2015年10月30日 上午9:51:16
     */
    @Transactional
    public void changeControllerState(String regOptId,String state){
        Controller controller = getControllerById(regOptId);
        controllerDao.checkOperation(regOptId, state, controller.getState());
    }

    /**
     * 
     * @discription 根据手术ID获取控制表信息
     * @author chengwang
     * @created 2015-10-20 上午9:37:13
     * @param id
     * @return
     */
    public Controller getControllerById(String id) {
        return controllerDao.getControllerById(id);
    }

}
