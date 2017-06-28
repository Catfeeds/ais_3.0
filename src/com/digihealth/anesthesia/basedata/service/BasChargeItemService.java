package com.digihealth.anesthesia.basedata.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.druid.util.StringUtils;
import com.digihealth.anesthesia.basedata.formbean.BasChargeItemFormBean;
import com.digihealth.anesthesia.basedata.formbean.SystemSearchFormBean;
import com.digihealth.anesthesia.basedata.po.BasChargeItem;
import com.digihealth.anesthesia.common.service.BaseService;
import com.digihealth.anesthesia.common.utils.GenerateSequenceUtil;
import com.digihealth.anesthesia.common.utils.PingYinUtil;
import com.digihealth.anesthesia.evt.formbean.Filter;

/**
 * 
     * Title: ChargeItemService.java    
     * Description: 收费项目service
     * @author chengwang       
     * @created 2015年12月15日 上午10:14:41
 */
@Service
public class BasChargeItemService extends BaseService {
	
	/**
	 * 
	     * @discription 查询收费项目
	     * @author chengwang       
	     * @created 2015年12月15日 上午10:18:24     
	     * @param systemSearchFormBean
	     * @return
	 */
	public List<BasChargeItemFormBean> findList(String pinyin, String beid) {
		if (StringUtils.isEmpty(beid)) {
			beid = getBeid();
		}
		return basChargeItemDao.findList(pinyin, beid);
	}

	/**
	 * 
	 * @discription 查询收费项目
	 * @author chengwang
	 * @created 2015年12月15日 上午10:18:24
	 * @param systemSearchFormBean
	 * @return
	 */
	public List<BasChargeItem> queryChargeItemList(SystemSearchFormBean systemSearchFormBean) {
		if (StringUtils.isEmpty(systemSearchFormBean.getBeid())) {
			systemSearchFormBean.setBeid(getBeid());
		}
		if (StringUtils.isEmpty(systemSearchFormBean.getSort())) {
			systemSearchFormBean.setSort("chargeItemId");
		}
		if (StringUtils.isEmpty(systemSearchFormBean.getOrderBy())) {
			systemSearchFormBean.setOrderBy("ASC");
		}
		String filter = "";
		List<Filter> filters = systemSearchFormBean.getFilters();
		if (filters != null && filters.size() > 0) {
			for (int i = 0; i < filters.size(); i++) {
				if (!StringUtils.isEmpty(filters.get(i).getValue().toString())) {
					filter = filter + " AND " + filters.get(i).getField() + " like '%" + filters.get(i).getValue() + "%' ";
				}
			}
		}
		filter += " AND enable = 1";
		return basChargeItemDao.queryChargeItemList(filter, systemSearchFormBean);
	}

	/**
	 * 
	 * @discription 查询收费项目总数
	 * @author chengwang
	 * @created 2015年12月15日 上午10:18:24
	 * @param systemSearchFormBean
	 * @return
	 */
	public int findListTotal(SystemSearchFormBean systemSearchFormBean) {
		if (StringUtils.isEmpty(systemSearchFormBean.getBeid())) {
			systemSearchFormBean.setBeid(getBeid());
		}
		if (StringUtils.isEmpty(systemSearchFormBean.getSort())) {
			systemSearchFormBean.setSort("chargeItemId");
		}
		if (StringUtils.isEmpty(systemSearchFormBean.getOrderBy())) {
			systemSearchFormBean.setOrderBy("ASC");
		}
		String filter = "";
		List<Filter> filters = systemSearchFormBean.getFilters();
		if (filters != null && filters.size() > 0) {
			for (int i = 0; i < filters.size(); i++) {
				if (!StringUtils.isEmpty(filters.get(i).getValue().toString())) {
					filter = filter + " AND " + filters.get(i).getField()
							+ " like '%" + filters.get(i).getValue() + "%' ";
				}
			}
		}
		filter += " AND enable = 1";
		return basChargeItemDao.findListTotal(filter, systemSearchFormBean.getBeid());
	}

	public BasChargeItem searchChargeItemById(String chargeItemId, String beid) {
		if (StringUtils.isEmpty(beid)) {
			beid = getBeid();
		}
		return basChargeItemDao.searchChargeItemById(chargeItemId, beid);
	}

	@Transactional
	public String updateChargeItem(BasChargeItem chargeItem) {
		if (StringUtils.isEmpty(chargeItem.getBeid())) {
			chargeItem.setBeid(getBeid());
		}
		if (!StringUtils.isEmpty(chargeItem.getChargeItemId())) {
			basChargeItemDao.updateByPrimaryKey(chargeItem);
			return "修改收费项目成功";
		} else {
			chargeItem.setPinYin(PingYinUtil.getFirstSpell(chargeItem.getChargeItemName()));
			chargeItem.setChargeItemId(GenerateSequenceUtil.generateSequenceNo());
			basChargeItemDao.insert(chargeItem);
			return "创建收费项目成功";
		}
	}

	public List<BasChargeItem> queryChargeItemByChargePackagesId(SystemSearchFormBean systemSearchFormBean, String chargePkgId, String beid) {
		if (StringUtils.isEmpty(beid)) {
			beid = getBeid();
		}
		String filter = "";
		List<Filter> filters = systemSearchFormBean.getFilters();
		if (filters != null && filters.size() > 0) {
			for (int i = 0; i < filters.size(); i++) {
				if (!StringUtils.isEmpty(filters.get(i).getValue().toString()) && !"chargePkgId".equals(filters.get(i).getField().toString())) {
					filter += " AND " + filters.get(i).getField() + " like '%" + filters.get(i).getValue() + "%' ";
				}
			}
		}
		return basChargeItemDao.queryChargeItemByChargePackagesId(filter, chargePkgId, beid);
	}
	
}
