/**
 * Copyright &copy; 2012-2013 <a href="httparamMap://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.digihealth.anesthesia.tmp.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.digihealth.anesthesia.common.service.BaseService;
import com.digihealth.anesthesia.evt.formbean.RegOptOperMedicaleventFormBean;
import com.digihealth.anesthesia.evt.formbean.SearchFormBean;
import com.digihealth.anesthesia.evt.formbean.SearchOptOperMedicalevent;
import com.digihealth.anesthesia.tmp.po.TmpMedicineEvent;

/**
 * 
     * Title: MedicaleventService.java    
     * Description: 用药事件Service
     * @author liukui       
     * @created 2015-10-7 下午6:00:54
 */
@Service
public class TmpMedicineEventService extends BaseService {
	
	private static final String MEDICAL_EVENT_TYPE_ANAES="02";//麻醉用药
	private static final String MEDICAL_EVENT_TYPE_TREAT="01";//治疗用药
	
	/**
	 * 根据用药事件信息关联查询药品表数据
	 * @param docId
	 * @return
	 */
	public List<SearchOptOperMedicalevent> searchMedicaleventList(SearchFormBean searchBean) {
	    if (StringUtils.isBlank(searchBean.getBeid()))
        {
            searchBean.setBeid(getBeid());
        }
		return tmpMedicineEventDao.searchMedicaleventList(searchBean);
	}
	
	/**
	 * 按药品名称分组显示药品信息
	 * @param searchBean
	 * @return
	 */
	public List<RegOptOperMedicaleventFormBean> searchMedicaleventGroupByCodeList(SearchFormBean searchBean) {
	    if (StringUtils.isBlank(searchBean.getBeid()))
        {
            searchBean.setBeid(getBeid());
        }
		//将相同药品的数据重新封装
		List<RegOptOperMedicaleventFormBean> resultList = tmpMedicineEventDao.getMedicalGroupByNameList(searchBean);
		for (RegOptOperMedicaleventFormBean regOptOperMedicaleventFormBean : resultList) {
			//麻醉用药事件列表
			searchBean.setCode(regOptOperMedicaleventFormBean.getCode());
			regOptOperMedicaleventFormBean.setMedicalEventList(tmpMedicineEventDao.searchMedicaleventList(searchBean));
		}
		return resultList;
	}
	
	/**
	 * 查询用药事件表数据
	 * @param searchBean
	 * @return
	 */
	public List<TmpMedicineEvent> queryMedicaleventListById(SearchFormBean searchBean){
		return tmpMedicineEventDao.queryMedicaleventListById(searchBean);
	}
	
	/**
	 * 删除用药事件
	 * @param medicalevent
	 */
	@Transactional
	public void deleteMedicalevent(TmpMedicineEvent medicalevent){
		tmpMedicineEventDao.delete(medicalevent.getMedEventId());
	}
	
	
	public List<TmpMedicineEvent> selectMedTempEventByMedTempId(String medTempId,String type){
		return tmpMedicineEventDao.selectMedTempEventByMedTempId(medTempId,type);
	}
	
	@Transactional
	public int deleteByMedTempId(String medTempId){
		return tmpMedicineEventDao.deleteByMedTempId(medTempId);
	}
	
	public TmpMedicineEvent queryMedTempEvemtById(String medEventId){
		return tmpMedicineEventDao.queryMedTempEvemtById(medEventId);
	}
}
