/**
 * Copyright &copy; 2012-2013 <a href="httparamMap://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.digihealth.anesthesia.basedata.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.druid.util.StringUtils;
import com.digihealth.anesthesia.basedata.formbean.BasChargePackagesFromBean;
import com.digihealth.anesthesia.basedata.formbean.SystemSearchFormBean;
import com.digihealth.anesthesia.basedata.po.BasChargeItemPackagesRel;
import com.digihealth.anesthesia.basedata.po.BasChargePackages;
import com.digihealth.anesthesia.common.service.BaseService;
import com.digihealth.anesthesia.common.utils.GenerateSequenceUtil;
import com.digihealth.anesthesia.common.utils.PingYinUtil;
import com.digihealth.anesthesia.evt.formbean.Filter;

/**
 * 
     * Title: ChargePackagesService.java    
     * Description: 收费项目套餐包service
     * @author chengwang       
     * @created 2015年12月16日 上午10:02:08
 */
@Service
public class BasChargePackagesService extends BaseService {
	
	
	public List<BasChargePackages> queryChargePackagesList(SystemSearchFormBean systemSearchFormBean){
	    if (StringUtils.isEmpty(systemSearchFormBean.getBeid()))
        {
            systemSearchFormBean.setBeid(getBeid());
        }

		if(StringUtils.isEmpty(systemSearchFormBean.getSort())){
			systemSearchFormBean.setSort("chargePkgId");
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
		return basChargePackagesDao.queryChargePackagesList(filter, systemSearchFormBean);
	}
	
	public int queryChargePackagesTotal(SystemSearchFormBean systemSearchFormBean){
	    if (StringUtils.isEmpty(systemSearchFormBean.getBeid()))
        {
            systemSearchFormBean.setBeid(getBeid());
        }

		if(StringUtils.isEmpty(systemSearchFormBean.getSort())){
			systemSearchFormBean.setSort("chargePkgId");
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
		return basChargePackagesDao.queryChargePackagesListTotal(filter, systemSearchFormBean);
	}
	
	public BasChargePackages searchChargePackagesById(String chargePkgId){
		return basChargePackagesDao.searchChargePackagesById(chargePkgId);
	}
	
	@Transactional
	public String updateChargePackages(BasChargePackagesFromBean chargePackagesFromBean){
		BasChargePackages chargePackages = chargePackagesFromBean.getChargePackages();
		chargePackages.setPinYin(PingYinUtil.getFirstSpell(chargePackages.getChargePackagesName()));
		if (StringUtils.isEmpty(chargePackages.getBeid()))
		{
		    chargePackages.setBeid(getBeid());
		}
		if(chargePackages!=null){
			if(!StringUtils.isEmpty(chargePackages.getChargePkgId())){
				List<BasChargeItemPackagesRel> chargeItemPackagesRelList = chargePackagesFromBean.getChargeItemPackagesRelList();
				if(chargeItemPackagesRelList!=null&&chargeItemPackagesRelList.size()>0){
					basChargeItemPackagesRelDao.deleteByChargePkgId(chargePackages.getChargePkgId());
					for(int i = 0;i<chargeItemPackagesRelList.size();i++){
						chargeItemPackagesRelList.get(i).setChgItmPkgId(GenerateSequenceUtil.generateSequenceNo());
						chargeItemPackagesRelList.get(i).setChargePkgId(chargePackages.getChargePkgId());
						basChargeItemPackagesRelDao.insert(chargeItemPackagesRelList.get(i));
					}
				}
				chargePackages.setPinYin(PingYinUtil.getFirstSpell(chargePackages.getChargePackagesName()));
				basChargePackagesDao.update(chargePackages);
				return "修改收费项目套餐包成功";
			}else{
				List<BasChargePackages> list = basChargePackagesDao.searchChargePackagesOrderId(chargePackages.getBeid());
				int id = 1;
				if(list!=null && list.size()>0){
					id = Integer.parseInt(list.get(0).getChargePkgId())+1;
				}
				chargePackages.setChargePkgId(id + "");
				chargePackages.setChargePackagesCode("ais"+id);
				
				List<BasChargeItemPackagesRel> chargeItemPackagesRelList = chargePackagesFromBean.getChargeItemPackagesRelList();
				if(chargeItemPackagesRelList!=null&&chargeItemPackagesRelList.size()>0){
					for(int i = 0;i<chargeItemPackagesRelList.size();i++){
						chargeItemPackagesRelList.get(i).setChargePkgId(id+"");
						chargeItemPackagesRelList.get(i).setChargeItemId(chargePackagesFromBean.getChargeItemPackagesRelList().get(i).getChargeItemId());
						chargeItemPackagesRelList.get(i).setChgItmPkgId(GenerateSequenceUtil.generateSequenceNo());
						basChargeItemPackagesRelDao.insert(chargeItemPackagesRelList.get(i));
					}
				}
				chargePackages.setPinYin(PingYinUtil.getFirstSpell(chargePackages.getChargePackagesName()));
				basChargePackagesDao.insert(chargePackages);
				return "新增收费项目套餐包成功";
			}
			
		}
		return "";
	}
}
