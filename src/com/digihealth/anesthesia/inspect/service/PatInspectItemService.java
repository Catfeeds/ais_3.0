package com.digihealth.anesthesia.inspect.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.digihealth.anesthesia.basedata.formbean.SystemSearchFormBean;
import com.digihealth.anesthesia.basedata.po.BasPatInspectItem;
import com.digihealth.anesthesia.common.service.BaseService;
import com.digihealth.anesthesia.evt.formbean.Filter;

@Service
public class PatInspectItemService extends BaseService{
	
	public List<BasPatInspectItem> getPatInspectItemList(SystemSearchFormBean searchFormBean){
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
		return basInspectItemDao.getPatInspectItemList(searchFormBean,filters);
	}
}
