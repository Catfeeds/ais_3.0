package com.digihealth.anesthesia.inspect.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.digihealth.anesthesia.basedata.formbean.SystemSearchFormBean;
import com.digihealth.anesthesia.basedata.po.BasPatInspectRecord;
import com.digihealth.anesthesia.common.service.BaseService;
import com.digihealth.anesthesia.evt.formbean.Filter;
import com.digihealth.anesthesia.inspect.formbean.PatInspectRecordFormbean;

@Service
public class PatInspectRecordService extends BaseService{
	
	public List<BasPatInspectRecord> getPatInspectRecordList(SystemSearchFormBean searchFormBean){
		setBeid(searchFormBean);
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
		return basInspectRecordDao.getPatInspectRecordList(searchFormBean,filters);
	}
	
	public int getTotalPatInspectRecordList(SystemSearchFormBean searchFormBean){
		List<Filter> filters = searchFormBean.getFilters();
		if(filters.size()==0){
			filters = new ArrayList<Filter>();
		}
		setBeid(searchFormBean);
		return basInspectRecordDao.getTotalPatInspectRecordList(searchFormBean, filters);
	}
	
	
	public List<PatInspectRecordFormbean> getRegInfoListByPatInspect(SystemSearchFormBean searchFormBean){
		setBeid(searchFormBean);
		if(StringUtils.isBlank(searchFormBean.getSort())){
			searchFormBean.setSort("regOptId");
		}
		if(StringUtils.isBlank(searchFormBean.getOrderBy())){
			searchFormBean.setOrderBy("DESC");
		}
		List<Filter> filters = searchFormBean.getFilters();
		if(filters.size()==0){
			filters = new ArrayList<Filter>();
		}
		return basInspectRecordDao.getRegInfoListByPatInspect(searchFormBean,filters);
	}
	    
	public int getTotalRegInfoListByPatInspect(SystemSearchFormBean searchFormBean){
		List<Filter> filters = searchFormBean.getFilters();
		if(filters.size()==0){
			filters = new ArrayList<Filter>();
		}
		setBeid(searchFormBean);
		return basInspectRecordDao.getTotalRegInfoListByPatInspect(searchFormBean, filters);
	}
}
