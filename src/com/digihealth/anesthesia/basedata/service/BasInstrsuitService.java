/**
 * Copyright &copy; 2012-2013 <a href="httparamMap://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.digihealth.anesthesia.basedata.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.druid.util.StringUtils;
import com.digihealth.anesthesia.basedata.formbean.BaseInfoQuery;
import com.digihealth.anesthesia.basedata.formbean.InstrsuitFromBean;
import com.digihealth.anesthesia.basedata.formbean.SystemSearchFormBean;
import com.digihealth.anesthesia.basedata.po.BasInstrSuitRel;
import com.digihealth.anesthesia.basedata.po.BasInstrsuit;
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
public class BasInstrsuitService extends BaseService {
	
	
	public List<BasInstrsuit> findList(BaseInfoQuery baseQuery) {
	    if (StringUtils.isEmpty(baseQuery.getBeid()))
        {
	        baseQuery.setBeid(getBeid());
        }
		return basInstrsuitDao.findList(baseQuery);
	}
	/**
	 * 新增手术包器械耗材关联表
	 * @param BasInstrsuit
	 */
	@Transactional
	public void insertInstrsuit(BasInstrsuit instrsuit){
	    if (StringUtils.isEmpty(instrsuit.getBeid()))
        {
	        instrsuit.setBeid(getBeid());
        }
	    instrsuit.setInstrsuitId(GenerateSequenceUtil.generateSequenceNo());
		basInstrsuitDao.insert(instrsuit);
	}
	/**
	 * 修改手术包器械耗材关联表
	 * @param BasInstrsuit
	 */
	@Transactional
	public void updateInstrSuitRel(BasInstrsuit instrsuit){
	    if (StringUtils.isEmpty(instrsuit.getBeid()))
        {
            instrsuit.setBeid(getBeid());
        }
		basInstrsuitDao.updateInstrsuit(instrsuit);
	}
	
	public List<BasInstrsuit> queryInstrsuitList(SystemSearchFormBean systemSearchFormBean){
	    if (StringUtils.isEmpty(systemSearchFormBean.getBeid()))
        {
	        systemSearchFormBean.setBeid(getBeid());
        }
		if(StringUtils.isEmpty(systemSearchFormBean.getSort())){
			systemSearchFormBean.setSort("instrsuitId");
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
		return basInstrsuitDao.queryInstrsuitList(filter, systemSearchFormBean);
	}
	
	public int queryInstrsuitListTotal(SystemSearchFormBean systemSearchFormBean){
	    if (StringUtils.isEmpty(systemSearchFormBean.getBeid()))
        {
            systemSearchFormBean.setBeid(getBeid());
        }
		if(StringUtils.isEmpty(systemSearchFormBean.getSort())){
			systemSearchFormBean.setSort("instrsuitId");
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
		return basInstrsuitDao.queryInstrsuitListTotal(filter, systemSearchFormBean);
	}
	
	public BasInstrsuit searchInstrsuitById(String instrsuitId){
		return basInstrsuitDao.searchInstrsuitById(instrsuitId);
	}
	
	@Transactional
	public void updateInstrsuit(InstrsuitFromBean instrsuitFromBean){
		BasInstrsuit instrsuit = instrsuitFromBean.getInstrsuit();
		instrsuit.setPinYin(PingYinUtil.getFirstSpell(instrsuit.getName()));
		if (StringUtils.isEmpty(instrsuit.getBeid()))
        {
		    instrsuit.setBeid(getBeid());
        }
		if(instrsuit!=null){
			if(instrsuit.getInstrsuitId()!=null){
				int amount = 0;
				List<BasInstrSuitRel> instrSuitRelList = instrsuitFromBean.getInstrSuitRelList();
				if(instrSuitRelList!=null&&instrSuitRelList.size()>0){
					basInstrSuitRelDao.deleteByInstrsuitId(instrsuit.getInstrsuitId());
					for(int i = 0;i<instrSuitRelList.size();i++){
						instrSuitRelList.get(i).setInstrsuitId(instrsuit.getInstrsuitId());
						instrSuitRelList.get(i).setInstrSuitRelId(GenerateSequenceUtil.generateSequenceNo());
						basInstrSuitRelDao.insert(instrSuitRelList.get(i));
						amount = amount + instrSuitRelList.get(i).getAmount();
					}
				}
				instrsuit.setTotalAmount(amount);
				basInstrsuitDao.update(instrsuit);
				
			}else{
				List<BasInstrsuit> list = basInstrsuitDao.searchInstrsuitOrderId();
				int id = 1;
				if(list!=null && list.size()>0){
					id = Integer.parseInt(list.get(0).getInstrsuitId())+1;
				}
				instrsuit.setInstrsuitId(id+"");
				instrsuit.setCode(id+"");
				
				int amount = 0;
				List<BasInstrSuitRel> instrSuitRelList = instrsuitFromBean.getInstrSuitRelList();
				if(instrSuitRelList!=null&&instrSuitRelList.size()>0){
					for(int i = 0;i<instrSuitRelList.size();i++){
						instrSuitRelList.get(i).setInstrsuitId(id+"");
						instrSuitRelList.get(i).setInstrSuitRelId(GenerateSequenceUtil.generateSequenceNo());
						basInstrSuitRelDao.insert(instrSuitRelList.get(i));
						amount = amount + instrSuitRelList.get(i).getAmount();
					}
				}
				instrsuit.setTotalAmount(amount);
				basInstrsuitDao.insert(instrsuit);
			}
			
		}
	}
}
