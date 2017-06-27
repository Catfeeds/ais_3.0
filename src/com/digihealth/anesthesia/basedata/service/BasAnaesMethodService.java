/**
 * Copyright &copy; 2012-2013 <a href="httparamMap://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.digihealth.anesthesia.basedata.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.digihealth.anesthesia.basedata.formbean.AnaesMethodFormBean;
import com.digihealth.anesthesia.basedata.formbean.BaseInfoQuery;
import com.digihealth.anesthesia.basedata.formbean.SystemSearchFormBean;
import com.digihealth.anesthesia.basedata.po.BasAnaesMethod;
import com.digihealth.anesthesia.common.service.BaseService;
import com.digihealth.anesthesia.common.utils.PingYinUtil;
import com.digihealth.anesthesia.evt.formbean.Filter;
/**
 * 
     * Title: AnaesMethodService.java    
     * Description: 日志Service
     * @author chengwang       
     * @created 2015-10-7 下午6:00:54
 */
@Service
public class BasAnaesMethodService extends BaseService {
	
	/**
	 * 当传入的查询条件为空时，需要构建一个查询对象
	 * @param baseQuery
	 * @return
	 */
	public List<AnaesMethodFormBean> findList(BaseInfoQuery baseQuery) {
		String beid = baseQuery.getBeid();
		if (StringUtils.isEmpty(beid)) {
			beid = getBeid();
		}
		baseQuery.setBeid(beid);
		return basAnaesMethodDao.findList(baseQuery);
	}
	
	public List<BasAnaesMethod> findAllList(BaseInfoQuery baseQuery) {
	    String beid = baseQuery.getBeid();
        if (StringUtils.isEmpty(beid)) {
            beid = getBeid();
        }
        baseQuery.setBeid(beid);
		return basAnaesMethodDao.findAllList(baseQuery);
	}

	public List<BasAnaesMethod> selectEntityList(BasAnaesMethod basAnaesMethod) {
        return basAnaesMethodDao.selectEntityList(basAnaesMethod);
    }
	
	@Transactional
	public void insertAnaesMethod(BasAnaesMethod anaesMethod){
		anaesMethod.setPinYin(PingYinUtil.getFirstSpell(anaesMethod.getName()));
		anaesMethod.setBeid(StringUtils.isEmpty(anaesMethod.getBeid()) ? getBeid() : anaesMethod.getBeid());
		if(logger.isDebugEnabled()){
			logger.debug("url:insertAnaesMethod data:"+anaesMethod.toString());
		}
		basAnaesMethodDao.insert(anaesMethod);
	}
	
	/*@Transactional(readOnly = false)
	public void updateAnaesMethod(BasAnaesMethod anaesMethod)throws Exception{
		if(logger.isDebugEnabled()){
			logger.debug("url:updateAnaesMethod data:"+anaesMethod.toString());
		}
		anaesMethod.setPinyin(PinyinConv.cn2py(anaesMethod.getName()));
		basAnaesMethodDao.update(anaesMethod);
	}*/
	
	public List<BasAnaesMethod> queryAnaesMethodList(SystemSearchFormBean systemSearchFormBean){
	    if (StringUtils.isEmpty(systemSearchFormBean.getBeid()))
        {
            systemSearchFormBean.setBeid(getBeid());
        }
		if(StringUtils.isEmpty(systemSearchFormBean.getSort())){
			systemSearchFormBean.setSort("anaMedId");
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
		return basAnaesMethodDao.queryAnaesMethodList(filter, systemSearchFormBean);
	}
	
	public int queryAnaesMethodListTotal(SystemSearchFormBean systemSearchFormBean){
	    if (StringUtils.isEmpty(systemSearchFormBean.getBeid()))
        {
            systemSearchFormBean.setBeid(getBeid());
        }
		if(StringUtils.isEmpty(systemSearchFormBean.getSort())){
			systemSearchFormBean.setSort("anaMedId");
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
		return basAnaesMethodDao.queryAnaesMethodListTotal(filter, systemSearchFormBean);
	}
	
	public BasAnaesMethod selectBycode(String code,String beid){
		BasAnaesMethod anaesMethod = null;
		if(StringUtils.isBlank(beid)){
			beid = getBeid();
		}
		List<BasAnaesMethod> anaesMethodList = basAnaesMethodDao.selectByCode(code, beid);
		if(null != anaesMethodList && anaesMethodList.size()>0){
			anaesMethod = anaesMethodList.get(0);
		}
		return anaesMethod;
	}
	
	
	public BasAnaesMethod searchAnaesMethodById(String anaMedId){
		return basAnaesMethodDao.searchAnaesMethodById(anaMedId);
	}
	
	@Transactional
	public String updateAnaesMethod(BasAnaesMethod anaesMethod){
		anaesMethod.setPinYin(PingYinUtil.getFirstSpell(anaesMethod.getName()));
		anaesMethod.setBeid(StringUtils.isEmpty(anaesMethod.getBeid()) ? getBeid() : anaesMethod.getBeid());
		if (anaesMethod.getAnaMedId()!= null) {
			basAnaesMethodDao.update(anaesMethod);
			return "修改麻醉方法成功";
		} else {
			int id = 1; 
			List<BasAnaesMethod> list = basAnaesMethodDao.searchAnaesMethodOrberById();
			if(list != null&&list.size()>0 ){
				anaesMethod.setAnaMedId(list.get(0).getAnaMedId()+1);
				anaesMethod.setCode((list.get(0).getAnaMedId()+1)+"");
			}else{
				anaesMethod.setCode(id+"");
			}
			basAnaesMethodDao.insert(anaesMethod);
			return "创建麻醉方法成功";
		}
	}
	
	
	
}
