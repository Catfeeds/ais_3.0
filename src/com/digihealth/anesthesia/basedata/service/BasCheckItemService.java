package com.digihealth.anesthesia.basedata.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.digihealth.anesthesia.basedata.formbean.BaseInfoQuery;
import com.digihealth.anesthesia.basedata.formbean.SystemSearchFormBean;
import com.digihealth.anesthesia.basedata.po.BasCheckItem;
import com.digihealth.anesthesia.common.service.BaseService;
import com.digihealth.anesthesia.common.utils.GenerateSequenceUtil;
import com.digihealth.anesthesia.evt.formbean.Filter;

@Service
public class BasCheckItemService extends BaseService {
	
	public List<BasCheckItem> searchAllCheckItem(BaseInfoQuery baseQuery){
	    String beid = baseQuery.getBeid();
        if (StringUtils.isEmpty(beid)) {
            beid = getBeid();
        }
        baseQuery.setBeid(beid);
		return basCheckItemDao.searchAllCheckItem(baseQuery);
	}

	
	/**
	 * 根据id查询检查项目信息
	 * @param defId
	 * @return
	 */
	public BasCheckItem queryCheckItemById(String cheItemId) {
		return basCheckItemDao.queryCheckItemById(cheItemId);
	}
	
	/**
	 * 根据页面条件筛选检查项目并排序
	 * @param systemSearchFormBean
	 * @return
	 */
	public List<BasCheckItem> queryCheckItemList(SystemSearchFormBean systemSearchFormBean){
	    if (StringUtils.isEmpty(systemSearchFormBean.getBeid()))
        {
            systemSearchFormBean.setBeid(getBeid());
        }

		if(StringUtils.isEmpty(systemSearchFormBean.getSort())){
			systemSearchFormBean.setSort("chkItemId");
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
		return basCheckItemDao.queryCheckItemList(filter, systemSearchFormBean);
	}
	/**
	 * 获取查询检查项目条数
	 * @param systemSearchFormBean
	 * @return
	 */
	public int queryCheckItemListTotal(SystemSearchFormBean systemSearchFormBean){
	    if (StringUtils.isEmpty(systemSearchFormBean.getBeid()))
        {
            systemSearchFormBean.setBeid(getBeid());
        }

		if(StringUtils.isEmpty(systemSearchFormBean.getSort())){
			systemSearchFormBean.setSort("chkItemId");
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
		return basCheckItemDao.queryCheckItemListTotal(filter, systemSearchFormBean);
	}
	
	/**
	 * 保存检查项目
	 * @param BasCheckItem
	 */
	@Transactional
	public String saveCheckItem(BasCheckItem basCheckItem){
	    if (StringUtils.isBlank(basCheckItem.getBeid()))
	    {
	        basCheckItem.setBeid(getBeid());
	    }
	    
		if(null != basCheckItem.getChkItemId()){
			basCheckItemDao.update(basCheckItem);
		}else{
		    basCheckItem.setChkItemId(GenerateSequenceUtil.generateSequenceNo());
			basCheckItemDao.insert(basCheckItem);
		}
		return "保存成功";
	}
	/**
	 * 删除检查项目信息
	 * @param HisCheckItem
	 */
	@Transactional
	public String deleteCheckItem(List<String> cheItemIdList){
		for (String cheItemId : cheItemIdList) {
			basCheckItemDao.deleteCheckItem(cheItemId);
		}
		return "删除成功";
	}
	
}
