/**
 * Copyright &copy; 2012-2013 <a href="httparamMap://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.digihealth.anesthesia.basedata.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.digihealth.anesthesia.basedata.formbean.BaseInfoQuery;
import com.digihealth.anesthesia.basedata.formbean.SystemSearchFormBean;
import com.digihealth.anesthesia.basedata.po.BasPrice;
import com.digihealth.anesthesia.common.service.BaseService;
import com.digihealth.anesthesia.common.utils.GenerateSequenceUtil;
import com.digihealth.anesthesia.evt.formbean.Filter;

/**
 * 
     * Title: PriceService.java    
     * Description: 日志Service
     * @author liukui       
     * @created 2015-10-7 下午6:00:54
 */
@Service
public class BasPriceService extends BaseService {
	
	
	public List<BasPrice> searchPriceList(BaseInfoQuery baseQuery){
	    if (StringUtils.isEmpty(baseQuery.getBeid()))
        {
	        baseQuery.setBeid(getBeid());
        }
		return basPriceDao.searchPriceList(baseQuery);
	}
	
	/**
	 * 根据id查询药品价格信息
	 * @param defId
	 * @return
	 */
	public BasPrice queryPriceByPriceId(String priceId) {
		return basPriceDao.queryPriceByPriceId(priceId);
	}
	
	/**
	 * 根据页面条件筛选药品价格信息并排序
	 * @param systemSearchFormBean
	 * @return
	 */
	public List<BasPrice> queryPriceList(SystemSearchFormBean systemSearchFormBean){
	    if (StringUtils.isEmpty(systemSearchFormBean.getBeid()))
        {
	        systemSearchFormBean.setBeid(getBeid());
        }
		if(StringUtils.isEmpty(systemSearchFormBean.getSort())){
			systemSearchFormBean.setSort("code");
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
		return basPriceDao.queryPriceList(filter, systemSearchFormBean);
	}
	/**
	 * 获取查询药品价格条数
	 * @param systemSearchFormBean
	 * @return
	 */
	public int queryPriceListTotal(SystemSearchFormBean systemSearchFormBean){
	    if (StringUtils.isEmpty(systemSearchFormBean.getBeid()))
        {
            systemSearchFormBean.setBeid(getBeid());
        }
		if(StringUtils.isEmpty(systemSearchFormBean.getSort())){
			systemSearchFormBean.setSort("medicineId");
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
		return basPriceDao.queryPriceListTotal(filter, systemSearchFormBean);
	}
	/**
	 * 保存药品价格信息
	 * @param HisPrice
	 */
	@Transactional
	public String savePrice(BasPrice price){
	    if (StringUtils.isEmpty(price.getBeid()))
        {
	        price.setBeid(getBeid());
        }
		if(null != price.getPriceId()){
			basPriceDao.update(price);
		}else{
		    price.setPriceId(GenerateSequenceUtil.generateSequenceNo());
			basPriceDao.insert(price);
		}
		return "保存成功";
	}
	
}
