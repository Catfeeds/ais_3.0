/**
 * Copyright &copy; 2012-2013 <a href="httparamMap://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.digihealth.anesthesia.basedata.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.digihealth.anesthesia.basedata.formbean.SystemSearchFormBean;
import com.digihealth.anesthesia.basedata.po.BasMonitorConfigFreq;
import com.digihealth.anesthesia.common.service.BaseService;
import com.digihealth.anesthesia.common.utils.GenerateSequenceUtil;
import com.digihealth.anesthesia.evt.formbean.Filter;

/**
 * 
     * Title: DeptService.java    
     * Description: 科室Service
     * @author liukui       
     * @created 2015-10-7 下午6:00:54
 */
@Service
public class BasMonitorConfigFreqService extends BaseService {
	
	public BasMonitorConfigFreq queryMonitorConfigFreqById(String id){
		return basMonitorConfigFreqDao.queryMonitorConfigFreqById(id);
	}
	
	public List<BasMonitorConfigFreq> queryMonitorConfigFreqList(SystemSearchFormBean systemSearchFormBean){
	    if (StringUtils.isEmpty(systemSearchFormBean.getBeid()))
        {
            systemSearchFormBean.setBeid(getBeid());
        }
		if(StringUtils.isEmpty(systemSearchFormBean.getSort())){
			systemSearchFormBean.setSort("id");
		}
		if(StringUtils.isEmpty(systemSearchFormBean.getOrderBy())){
			systemSearchFormBean.setOrderBy("ASC");
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
		return basMonitorConfigFreqDao.queryMonitorConfigFreqList(filter, systemSearchFormBean);
	}
	
	@Transactional
	public String updateMonitorConfigFreq(BasMonitorConfigFreq monitorConfigFreq){
	    if (StringUtils.isEmpty(monitorConfigFreq.getBeid()))
        {
	        monitorConfigFreq.setBeid(getBeid());
        }
		if (StringUtils.isNotBlank(monitorConfigFreq.getId())) {
			basMonitorConfigFreqDao.update(monitorConfigFreq);
			return "修改科室成功";
		} else {
		    monitorConfigFreq.setId(GenerateSequenceUtil.generateSequenceNo());
			basMonitorConfigFreqDao.insert(monitorConfigFreq);
			return "创建科室成功";
		}
	}
	
	@Transactional
	public void updateFreq(List<BasMonitorConfigFreq> freqList){
		if(null != freqList && freqList.size()>0){
			for (BasMonitorConfigFreq monitorConfigFreq : freqList) {
				basMonitorConfigFreqDao.update(monitorConfigFreq);
			}
		}
	}
	
	public BasMonitorConfigFreq searchMonitorFreqByType(String type) {
	    BasMonitorConfigFreq monitorFreq = basMonitorConfigFreqDao.searchMonitorFreqByType(type, getBeid());
        return monitorFreq;
    }
    
    public List<BasMonitorConfigFreq> searchMonitorFreqList() {
        return basMonitorConfigFreqDao.searchMonitorFreqList(getBeid());
    }
}
