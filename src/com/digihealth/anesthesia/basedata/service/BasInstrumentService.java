package com.digihealth.anesthesia.basedata.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.digihealth.anesthesia.basedata.formbean.BaseInfoQuery;
import com.digihealth.anesthesia.basedata.formbean.SystemSearchFormBean;
import com.digihealth.anesthesia.basedata.po.BasInstrument;
import com.digihealth.anesthesia.common.service.BaseService;
import com.digihealth.anesthesia.common.utils.GenerateSequenceUtil;
import com.digihealth.anesthesia.common.utils.PingYinUtil;
import com.digihealth.anesthesia.evt.formbean.Filter;
/**
 * 
     * Title: InstrsuitService.java    
     * Description: 手术包Service
     * @author liukui       
     * @created 2015-10-7 下午6:00:54
 */
@Service
public class BasInstrumentService extends BaseService {
	
	
	public List<BasInstrument> searchInstrument(BaseInfoQuery baseQuery){
	    if (StringUtils.isBlank(baseQuery.getBeid()))
        {
	        baseQuery.setBeid(getBeid());
        }
		return basInstrumentDao.searchInstrument(baseQuery);
	}
	
	public List<BasInstrument> queryInstrumentList(SystemSearchFormBean systemSearchFormBean){
	    if (StringUtils.isBlank(systemSearchFormBean.getBeid()))
        {
            systemSearchFormBean.setBeid(getBeid());
        }
		if(StringUtils.isEmpty(systemSearchFormBean.getSort())){
			systemSearchFormBean.setSort("instrumentId");
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
		return basInstrumentDao.queryInstrumentList(filter, systemSearchFormBean);
	}
	
	public int queryInstrumentListTotal(SystemSearchFormBean systemSearchFormBean){
	    if (StringUtils.isBlank(systemSearchFormBean.getBeid()))
        {
            systemSearchFormBean.setBeid(getBeid());
        }
		if(StringUtils.isEmpty(systemSearchFormBean.getSort())){
			systemSearchFormBean.setSort("instrumentId");
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
		return basInstrumentDao.queryInstrumentListTotal(filter, systemSearchFormBean);
	}
	
	
	public BasInstrument searchInstrumentById(String instrumentId){
		return basInstrumentDao.searchInstrumentById(instrumentId);
	}
	
	@Transactional
	public String updateInstrument(BasInstrument instrument){
	    if (StringUtils.isBlank(instrument.getBeid()))
	    {
	        instrument.setBeid(getBeid());
	    }
	    
		instrument.setPinYin(PingYinUtil.getFirstSpell(instrument.getName()));
		if (instrument.getInstrumentId()!= null) {
			basInstrumentDao.update(instrument);
			return "修改器械成功";
		} else {
		    instrument.setInstrumentId(GenerateSequenceUtil.generateSequenceNo());
			basInstrumentDao.insert(instrument);
			return "创建器械成功";
		}
	}
	
	public List<BasInstrument> queryInstrumentByInstrsuitId(String instrsuitId){
		return basInstrumentDao.queryInstrumentByInstrsuitId(instrsuitId);
	}
	
}
