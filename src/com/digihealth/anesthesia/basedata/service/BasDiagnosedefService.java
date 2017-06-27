package com.digihealth.anesthesia.basedata.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.digihealth.anesthesia.basedata.formbean.BaseInfoQuery;
import com.digihealth.anesthesia.basedata.formbean.DiagnosedefFormBean;
import com.digihealth.anesthesia.basedata.formbean.SystemSearchFormBean;
import com.digihealth.anesthesia.basedata.po.BasDiagnosedef;
import com.digihealth.anesthesia.common.service.BaseService;
import com.digihealth.anesthesia.common.utils.GenerateSequenceUtil;
import com.digihealth.anesthesia.common.utils.PingYinUtil;
import com.digihealth.anesthesia.evt.formbean.Filter;

/**
 * 
     * Title: DiagnosedefService.java    
     * Description: 用户 Service
     * @author liukui       
     * @created 2015-10-7 下午6:00:54
 */
@Service
public class BasDiagnosedefService extends BaseService {
	
	
	public List<DiagnosedefFormBean> findList(BaseInfoQuery baseQuery) {
		String beid = baseQuery.getBeid();
		if (StringUtils.isBlank(beid)) {
			beid = getBeid();
		}
		baseQuery.setBeid(beid);
		return basDiagnosedefDao.findList(baseQuery);
	}
	
	public BasDiagnosedef searchDiagnosedefById(String diagnosedefId){
		return basDiagnosedefDao.searchDiagnosedefById(diagnosedefId);
	}
	
	public List<BasDiagnosedef> queryDiagnosedefList(SystemSearchFormBean systemSearchFormBean){
	    if (StringUtils.isBlank(systemSearchFormBean.getBeid()))
        {
            systemSearchFormBean.setBeid(getBeid());
        }
		if(StringUtils.isEmpty(systemSearchFormBean.getSort())){
			systemSearchFormBean.setSort("diagDefId");
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
		return basDiagnosedefDao.queryDiagnosedefList(filter, systemSearchFormBean);
	}
	
	public int queryDiagnosedefListTotal(SystemSearchFormBean systemSearchFormBean){
	    if (StringUtils.isBlank(systemSearchFormBean.getBeid()))
        {
            systemSearchFormBean.setBeid(getBeid());
        }
		if(StringUtils.isEmpty(systemSearchFormBean.getSort())){
			systemSearchFormBean.setSort("diagDefId");
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
		return basDiagnosedefDao.queryDiagnosedefListTotal(filter, systemSearchFormBean);
	}
	
	
	@Transactional
	public String updateDiagnosedef(BasDiagnosedef diagnosedef){
	    if (StringUtils.isBlank(diagnosedef.getBeid()))
        {
	        diagnosedef.setBeid(getBeid());
        }
	    
		if (StringUtils.isNotBlank(diagnosedef.getDiagDefId())) {
			basDiagnosedefDao.update(diagnosedef);
			return "修改诊断成功";
		} else {
			diagnosedef.setPinYin(PingYinUtil.getFirstSpell(diagnosedef.getName()));
			diagnosedef.setDiagDefId(GenerateSequenceUtil.generateSequenceNo());
			basDiagnosedefDao.insert(diagnosedef);
			return "创建诊断成功";
		}
	}
	
	public List<BasDiagnosedef> selectByName(String name){
		return basDiagnosedefDao.selectByName(name, getBeid());
	}
}
