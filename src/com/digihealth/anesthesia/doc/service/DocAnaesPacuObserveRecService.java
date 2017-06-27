/**
 * Copyright &copy; 2012-2013 <a href="httparamMap://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.digihealth.anesthesia.doc.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.digihealth.anesthesia.basedata.formbean.PacuObsFormbean;
import com.digihealth.anesthesia.basedata.formbean.SystemSearchFormBean;
import com.digihealth.anesthesia.basedata.po.BasRegOpt;
import com.digihealth.anesthesia.basedata.utils.LogUtils;
import com.digihealth.anesthesia.basedata.utils.UserUtils;
import com.digihealth.anesthesia.common.entity.ResponseValue;
import com.digihealth.anesthesia.common.service.BaseService;
import com.digihealth.anesthesia.common.utils.DateUtils;
import com.digihealth.anesthesia.common.utils.GenerateSequenceUtil;
import com.digihealth.anesthesia.common.utils.JsonType;
import com.digihealth.anesthesia.common.utils.StringUtils;
import com.digihealth.anesthesia.doc.po.DocAnaesPacuObserveRec;
import com.digihealth.anesthesia.doc.po.DocAnaesPacuRec;
import com.digihealth.anesthesia.evt.formbean.Filter;
import com.digihealth.anesthesia.evt.formbean.SearchFormBean;
import com.digihealth.anesthesia.evt.po.EvtMedicalEvent;

/**
 * 
     * Title: AnaesPacuObserveRecService.java    
     * Description: 复苏室观察记录表Service
     * @author liukui       
     * @created 2016-7-27 下午6:00:54
 */
@Service
public class DocAnaesPacuObserveRecService extends BaseService {
	
	public List<DocAnaesPacuObserveRec> selectByPacuRecId(SystemSearchFormBean searchFormBean){
		if(StringUtils.isBlank(searchFormBean.getSort())){
			searchFormBean.setSort("id");
		}
		if(StringUtils.isBlank(searchFormBean.getOrderBy())){
			searchFormBean.setOrderBy("DESC");
		}
		List<Filter> filters = searchFormBean.getFilters();
		if(filters.size()==0){
			filters = new ArrayList<Filter>();
		}
		return docAnaesPacuObserveRecDao.selectByPacuRecId(searchFormBean,filters);
	}
	
	public List<DocAnaesPacuObserveRec> selectPacuObByPacuRecId(SystemSearchFormBean searchFormBean,String pacuRecId){
		if(StringUtils.isBlank(searchFormBean.getSort())){
			searchFormBean.setSort("recordTime");
		}
		if(StringUtils.isBlank(searchFormBean.getOrderBy())){
			searchFormBean.setOrderBy("ASC");
		}
		return docAnaesPacuObserveRecDao.selectPacuObByPacuRecId(searchFormBean, pacuRecId);
	}

	@Transactional
	public void savePacuAnaesObserve(DocAnaesPacuObserveRec record,ResponseValue resp){
		//根据病人id、时间获取当前观察项数据
		DocAnaesPacuObserveRec obs = docAnaesPacuObserveRecDao.getObserveRecordByTime(record.getPacuRecId(),record.getRecordTime());
		if(obs!=null){
			record.setId(obs.getId());
		}
		if(StringUtils.isNotBlank(record.getId())){
			docAnaesPacuObserveRecDao.updateByPrimaryKeySelective(record);
		}else{
			record.setId(GenerateSequenceUtil.generateSequenceNo());
			docAnaesPacuObserveRecDao.insertSelective(record);
		}
		resp.put("pacuObsId", record.getId());
	}
	
	
	/**
	 * 复苏单药品添加事件
	 * @param medicalevent
	 * @param value
	 */
	@Transactional
	public void savePacuMediclevent(PacuObsFormbean records,ResponseValue value) {
		
		//根据病人id、时间获取当前观察项数据
		DocAnaesPacuObserveRec pacuObs = docAnaesPacuObserveRecDao.selectByPrimaryKey(records.getPacuObsId());
		String pacuRecId  = pacuObs.getPacuRecId();
		DocAnaesPacuRec anaesPacuRec = docAnaesPacuRecDao.selectByPrimaryKey(pacuRecId);
		
		//如果复苏记录单对应状态不为复苏中时，则不允许编辑数据
		if(!anaesPacuRec.getProcessState().equals("1")){
			value.setResultCode("10000001");
			value.setResultMessage("对应复苏记录单数据状态不为复苏中，不允许编辑数据");
			return;
		}
		
		BasRegOpt regOpt = basRegOptDao.searchRegOptById(anaesPacuRec.getRegOptId());
		
		EvtMedicalEvent medicalevent = records.getMedicalevent();
		
		//medicalevent.setState(regOpt.getState());
		SearchFormBean searchFormBean = new SearchFormBean();
		searchFormBean.setDocId(pacuRecId);
		List<EvtMedicalEvent> List = evtMedicaleventDao.checkMedicaleventCanInsert(searchFormBean, medicalevent.getMedicineId()+"");
		medicalevent.setDocId(pacuRecId);
		//持续用药
		if("1".equals(medicalevent.getDurable())){
			for (EvtMedicalEvent event : List) {
				if((DateUtils.parseDate(medicalevent.getStartTime()).compareTo(DateUtils.parseDate(event.getStartTime()))<0
						&& DateUtils.parseDate(medicalevent.getEndTime()).compareTo(DateUtils.parseDate(event.getStartTime()))<0)
						|| DateUtils.parseDate(medicalevent.getStartTime()).compareTo(DateUtils.parseDate(event.getEndTime()))>0){
					continue;
				}else{
					value.setResultCode("10000001");
					value.setResultMessage("该药品在开始时间："+medicalevent.getStartTime()+"至结束时间："+medicalevent.getEndTime()+", 已经存在持续用药情况,请勿重复添加!");
					return;
				}
			}
		}else{//普通用药
			for (EvtMedicalEvent event : List) {
				if(!(DateUtils.parseDate(medicalevent.getStartTime()).compareTo(DateUtils.parseDate(event.getStartTime()))>0
						&& DateUtils.parseDate(medicalevent.getStartTime()).compareTo(DateUtils.parseDate(event.getEndTime()))<0)){
					continue;
				}else{
					value.setResultCode("10000001");
					value.setResultMessage("该药品在开始时间："+medicalevent.getStartTime()+", 已经存在持续用药情况,请勿重复添加!");
					return;
				}
			}
		}
		String meds = pacuObs.getMedId();
		if(StringUtils.isNotBlank(medicalevent.getMedEventId())){
			evtMedicaleventDao.updateByPrimaryKey(medicalevent);
		}else{
			medicalevent.setMedEventId(GenerateSequenceUtil.generateSequenceNo());
			evtMedicaleventDao.insert(medicalevent);
			if(StringUtils.isNotBlank(meds)){
				meds+=","+medicalevent.getMedEventId();
			}else{
				meds+=medicalevent.getMedEventId();
			}
		}
        pacuObs.setMedId(meds);
        docAnaesPacuObserveRecDao.updateByPrimaryKeySelective(pacuObs);
        LogUtils.saveOperateLog(regOpt.getRegOptId(),
            LogUtils.OPT_TYPE_INFO_SAVE,
            LogUtils.OPT_MODULE_OPER_RECORD,
            "复苏观察记录表",
            JsonType.jsonType(records),
            UserUtils.getUserCache(),
            getBeid());
    }
	
	/**
	 * 复苏单药品添加事件
	 * @param medicalevent
	 * @param value
	 */
	@Transactional
	public void deletePacuMediclevent(PacuObsFormbean records) {
		//根据病人id、时间获取当前观察项数据
		DocAnaesPacuObserveRec pacuObs = docAnaesPacuObserveRecDao.selectByPrimaryKey(records.getPacuObsId());
		String pacuRecId  = pacuObs.getPacuRecId();
		DocAnaesPacuRec anaesPacuRec = docAnaesPacuRecDao.selectByPrimaryKey(pacuRecId);
		EvtMedicalEvent medicalevent = records.getMedicalevent();
		evtMedicaleventDao.deleteByPrimaryKey(medicalevent.getMedEventId());
		String[] medIds = pacuObs.getMedId().split(",");
		String medId="";
		for (int i = 0; i < medIds.length; i++) {
			if(!medIds[i].equals(medicalevent.getMedEventId())){
				medId += medIds[i]+",";
			}
		}
		pacuObs.setMedId(medId.substring(0, medId.length()-1));
		docAnaesPacuObserveRecDao.updateByPrimaryKeySelective(pacuObs);
		
		LogUtils.saveOperateLog(anaesPacuRec.getRegOptId(),
            LogUtils.OPT_TYPE_INFO_SAVE,
            LogUtils.OPT_MODULE_OPER_RECORD,
            "复苏观察记录表",
            JsonType.jsonType(records),
            UserUtils.getUserCache(),
            getBeid());
	}
	
	
	public DocAnaesPacuObserveRec getAnaesPacuObserveRec(String id){
		return docAnaesPacuObserveRecDao.selectByPrimaryKey(id);
	}
	
	@Transactional
	public void deletePacuAnaesObserve(String id) {
		docAnaesPacuObserveRecDao.deleteByPrimaryKey(id);
	}
}
