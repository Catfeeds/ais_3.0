/**
 * Copyright &copy; 2012-2013 <a href="httparamMap://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.digihealth.anesthesia.basedata.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.digihealth.anesthesia.basedata.formbean.BaseInfoQuery;
import com.digihealth.anesthesia.basedata.formbean.MedicineFormBean;
import com.digihealth.anesthesia.basedata.formbean.SystemSearchFormBean;
import com.digihealth.anesthesia.basedata.po.BasMedicine;
import com.digihealth.anesthesia.common.service.BaseService;
import com.digihealth.anesthesia.common.utils.GenerateSequenceUtil;
import com.digihealth.anesthesia.common.utils.PingYinUtil;
import com.digihealth.anesthesia.evt.formbean.Filter;

/**
 * 
     * Title: MedicineService.java    
     * Description: 日志Service
     * @author liukui       
     * @created 2015-10-7 下午6:00:54
 */
@Service
public class BasMedicineService extends BaseService {
	
	
	/**
	 * 查询药品表数据
	 * @param baseQuery
	 * @return
	 */
	public List<MedicineFormBean> findList(BaseInfoQuery baseQuery) {
	    if (StringUtils.isEmpty(baseQuery.getBeid()))
        {
	        baseQuery.setBeid(getBeid());
        }
		return basMedicineDao.findList(baseQuery == null?new BaseInfoQuery():baseQuery);
	}
	
	/**
	 * 根据药品id查询药品信息
	 * @param defId
	 * @return
	 */
	public BasMedicine queryMedicineById(String medicineId) {
		return basMedicineDao.queryMedicineById(medicineId);
	}
	
	/**
	 * 根据页面条件筛选药品信息并排序
	 * @param systemSearchFormBean
	 * @return
	 */
	public List<BasMedicine> queryMedicineList(SystemSearchFormBean systemSearchFormBean){
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
		return basMedicineDao.queryMedicineList(filter, systemSearchFormBean);
	}
	/**
	 * 获取查询药品条数
	 * @param systemSearchFormBean
	 * @return
	 */
	public int queryMedicineListTotal(SystemSearchFormBean systemSearchFormBean){
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
		return basMedicineDao.queryMedicineListTotal(filter, systemSearchFormBean);
	}
	
	/**
	 * 保存药品信息
	 * @param HisMedicine
	 */
	@Transactional
	public String saveMedicine(BasMedicine medicine){
	    if(StringUtils.isNotBlank(medicine.getName())){
	        medicine.setPinYin(PingYinUtil.getFirstSpell(medicine.getName()));
	    }
	    if (StringUtils.isEmpty(medicine.getBeid()))
        {
	        medicine.setBeid(getBeid());
        }
		
		if(null != medicine.getMedicineId()){
			basMedicineDao.update(medicine);
		}else{
		    medicine.setMedicineId(GenerateSequenceUtil.generateSequenceNo());
			basMedicineDao.insert(medicine);
		}
		return "保存成功";
	}
	/**
	 * 删除药品信息
	 * @param HisMedicine
	 */
	@Transactional
	public String deleteMedicine(List<String> medicineIdList){
		for (String medicineId : medicineIdList) {
			basMedicineDao.deleteMedicine(medicineId);
		}
		return "删除成功";
	}
	
	
}
