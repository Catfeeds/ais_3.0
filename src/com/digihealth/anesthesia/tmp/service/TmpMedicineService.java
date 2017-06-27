/**
 * Copyright &copy; 2012-2013 <a href="httparamMap://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.digihealth.anesthesia.tmp.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.druid.util.StringUtils;
import com.digihealth.anesthesia.basedata.formbean.MedTempFormBean;
import com.digihealth.anesthesia.basedata.formbean.SystemSearchFormBean;
import com.digihealth.anesthesia.common.service.BaseService;
import com.digihealth.anesthesia.common.utils.DateUtils;
import com.digihealth.anesthesia.common.utils.GenerateSequenceUtil;
import com.digihealth.anesthesia.common.utils.PingYinUtil;
import com.digihealth.anesthesia.evt.formbean.Filter;
import com.digihealth.anesthesia.tmp.po.TmpIoEvent;
import com.digihealth.anesthesia.tmp.po.TmpMedicine;
import com.digihealth.anesthesia.tmp.po.TmpMedicineEvent;

/**
 * 
     * Title: MedTempService.java    
     * Description: 日志Service
     * @author chengwang       
     * @created 2015-10-7 下午6:00:54
 */
@Service
public class TmpMedicineService extends BaseService {
	
	
	
	public List<TmpMedicine> queryMedTempList(SystemSearchFormBean systemSearchFormBean){
		if(StringUtils.isEmpty(systemSearchFormBean.getSort())){
			systemSearchFormBean.setSort("createTime");
		}
		if(StringUtils.isEmpty(systemSearchFormBean.getOrderBy())){
			systemSearchFormBean.setOrderBy("DESC");
		}
		String filter = "";
		List<Filter> filters = systemSearchFormBean.getFilters();
		if(filters!=null&&filters.size()>0){
			for(int i = 0;i<filters.size();i++){
				if(!StringUtils.isEmpty(filters.get(i).getValue().toString())){
					filter = filter + " AND "+filters.get(i).getField() +" like '%"+filters.get(i).getValue()+"%' ";
				}
			}
		}
		return tmpMedicineDao.queryMedTempList(filter, systemSearchFormBean);
	}
	
	public int queryMedTempListTotal(SystemSearchFormBean systemSearchFormBean){
		if(StringUtils.isEmpty(systemSearchFormBean.getSort())){
			systemSearchFormBean.setSort("createTime");
		}
		if(StringUtils.isEmpty(systemSearchFormBean.getOrderBy())){
			systemSearchFormBean.setOrderBy("DESC");
		}
		String filter = "";
		List<Filter> filters = systemSearchFormBean.getFilters();
		if(filters!=null&&filters.size()>0){
			for(int i = 0;i<filters.size();i++){
				if(!StringUtils.isEmpty(filters.get(i).getValue().toString())){
					filter = filter + " AND "+filters.get(i).getField() +" like '%"+filters.get(i).getValue()+"%' ";
				}
			}
		}
		return tmpMedicineDao.queryMedTempListTotal(filter, systemSearchFormBean);
	}
	
	
	public TmpMedicine searchMedTempById(String medTempId){
		return tmpMedicineDao.searchMedTempById(medTempId);
	}
	
	@Transactional
	public void updateMedTemp(MedTempFormBean medTempFromBean){
		
		TmpMedicine medTemp = medTempFromBean.getMedTemp();
		medTemp.setPinYin(PingYinUtil.getFirstSpell(medTemp.getMedTempName()));
		if(medTemp !=null){
			if(medTemp.getMedTempId()!=null){
				List<TmpMedicineEvent> medTempEventList = medTempFromBean.getMedTempEventList();
				tmpMedicineEventDao.deleteByMedTempId(medTemp.getMedTempId());
				if(medTempEventList!=null&&medTempEventList.size()>0){
					for(int i = 0 ; i < medTempEventList.size();i++){
						medTempEventList.get(i).setMedEventId(GenerateSequenceUtil.generateSequenceNo());
						medTempEventList.get(i).setMedTempId(medTemp.getMedTempId());
						medTempEventList.get(i).setType("02");
						tmpMedicineEventDao.insert(medTempEventList.get(i));
					}
				}
				List<TmpMedicineEvent> zlTempEventList = medTempFromBean.getZhlTempEventList();
				if(zlTempEventList!=null&&zlTempEventList.size()>0){
					for(int i = 0 ; i < zlTempEventList.size();i++){
						zlTempEventList.get(i).setMedTempId(medTemp.getMedTempId());
						zlTempEventList.get(i).setType("01");
						zlTempEventList.get(i).setMedEventId(GenerateSequenceUtil.generateSequenceNo());
						tmpMedicineEventDao.insert(zlTempEventList.get(i));
					}
				}
				List<TmpIoEvent> ioTempEventList = medTempFromBean.getIoTempEventList();
				tmpIoEventDao.deleteByMedTempId(medTemp.getMedTempId());
				if(ioTempEventList!=null&&ioTempEventList.size()>0){
					for(int i = 0 ; i < ioTempEventList.size();i++){
						ioTempEventList.get(i).setIoeventId(GenerateSequenceUtil.generateSequenceNo());
						ioTempEventList.get(i).setMedTempId(medTemp.getMedTempId());
						tmpIoEventDao.insert(ioTempEventList.get(i));
					}
				}
				medTemp.setCreateTime(DateUtils.getDateTime());
				tmpMedicineDao.update(medTemp);
			}else{
				List<TmpMedicine> medTempList = tmpMedicineDao.selectMedTempOrderById();
				int medTempId = 1;
				if(medTempList !=null && medTempList.size()>0){
					medTempId = Integer.parseInt(medTempList.get(0).getMedTempId()) + 1;
				}
				List<TmpMedicineEvent> medTempEventList = medTempFromBean.getMedTempEventList();
				if(medTempEventList!=null&&medTempEventList.size()>0){
					for(int i = 0 ; i < medTempEventList.size();i++){
						medTempEventList.get(i).setMedEventId(GenerateSequenceUtil.generateSequenceNo());
						medTempEventList.get(i).setMedTempId(medTempId+"");
						medTempEventList.get(i).setType("02");
						tmpMedicineEventDao.insert(medTempEventList.get(i));
					}
				}
				List<TmpMedicineEvent> zlTempEventList = medTempFromBean.getZhlTempEventList();
				if(zlTempEventList!=null&&zlTempEventList.size()>0){
					for(int i = 0 ; i < zlTempEventList.size();i++){
						zlTempEventList.get(i).setMedTempId(medTempId+"");
						zlTempEventList.get(i).setMedEventId(GenerateSequenceUtil.generateSequenceNo());
						zlTempEventList.get(i).setType("01");
						tmpMedicineEventDao.insert(zlTempEventList.get(i));
					}
				}
				List<TmpIoEvent> ioTempEventList = medTempFromBean.getIoTempEventList();
				if(ioTempEventList!=null&&ioTempEventList.size()>0){
					for(int i = 0 ; i < ioTempEventList.size();i++){
						ioTempEventList.get(i).setMedTempId(medTempId+"");
						ioTempEventList.get(i).setIoeventId(GenerateSequenceUtil.generateSequenceNo());
						tmpIoEventDao.insert(ioTempEventList.get(i));
					}
				}
				medTemp.setMedTempId(medTempId+"");
				medTemp.setCreateTime(DateUtils.getDateTime());
				tmpMedicineDao.insert(medTemp);
			}
		}
	}
	
	@Transactional
	public void deleteMedTempById(TmpMedicine medTemp){
		if(medTemp!=null){
			if(medTemp.getMedTempId()!=null){
				tmpMedicineDao.delete(medTemp.getMedTempId());
				tmpMedicineEventDao.deleteByMedTempId(medTemp.getMedTempId());
				tmpIoEventDao.deleteByMedTempId(medTemp.getMedTempId());
			}
		}
	}
	
}
