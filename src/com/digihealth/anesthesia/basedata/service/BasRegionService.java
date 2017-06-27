package com.digihealth.anesthesia.basedata.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.digihealth.anesthesia.basedata.formbean.BaseInfoQuery;
import com.digihealth.anesthesia.basedata.formbean.SystemSearchFormBean;
import com.digihealth.anesthesia.basedata.po.BasRegion;
import com.digihealth.anesthesia.common.service.BaseService;
import com.digihealth.anesthesia.common.utils.GenerateSequenceUtil;
import com.digihealth.anesthesia.common.utils.PingYinUtil;
import com.digihealth.anesthesia.evt.formbean.Filter;

/**
 * 
     * Title: RegionService.java    
     * Description: 病区Service
     * @author liukui       
     * @created 2015-10-7 下午6:00:54
 */
@Service
public class BasRegionService extends BaseService {
	
	/**
	 * 当传入的查询条件为空时，需要构建一个查询对象
	 * @param baseQuery
	 * @return
	 */
	public List<BasRegion> findList(BaseInfoQuery baseQuery) {
		
	    if (null == baseQuery)
	    {
	        baseQuery = new BaseInfoQuery();
	    }
	    baseQuery.setBeid(getBeid());
		return basRegionDao.findList(baseQuery);
	}
	
	public BasRegion searchRegionById(String regionId){
		return basRegionDao.searchRegionById(regionId);
	}
	
	
	public List<BasRegion> queryRegionList(SystemSearchFormBean systemSearchFormBean){
	    
	    if (StringUtils.isBlank(systemSearchFormBean.getBeid()))
        {
            systemSearchFormBean.setBeid(getBeid());
        }
		if(StringUtils.isEmpty(systemSearchFormBean.getSort())){
			systemSearchFormBean.setSort("regionId");
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
		return basRegionDao.queryRegionList(filter, systemSearchFormBean);
	}
	
	public int queryRegionListTotal(SystemSearchFormBean systemSearchFormBean){
	    if (StringUtils.isBlank(systemSearchFormBean.getBeid()))
        {
            systemSearchFormBean.setBeid(getBeid());
        }
	    
		if(StringUtils.isEmpty(systemSearchFormBean.getSort())){
			systemSearchFormBean.setSort("regionId");
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
		return basRegionDao.queryRegionListTotal(filter, systemSearchFormBean);
	}
	
	
	@Transactional
	public String updateRegion(BasRegion region){
	    if (StringUtils.isBlank(region.getBeid()))
	    {
	        region.setBeid(getBeid());
	    }
	    
		if (region.getRegionId()!=null) {
			region.setPinYin(PingYinUtil.getFirstSpell(region.getName()));
			basRegionDao.update(region);
			return "修改病区成功";
		} else {
			region.setPinYin(PingYinUtil.getFirstSpell(region.getName()));
		    region.setRegionId(GenerateSequenceUtil.generateSequenceNo());
			basRegionDao.insert(region);
			return "创建病区成功";
		}
	}
	
}
