/**
 * Copyright &copy; 2012-2013 <a href="httparamMap://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.digihealth.anesthesia.basedata.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.digihealth.anesthesia.basedata.formbean.SystemSearchFormBean;
import com.digihealth.anesthesia.basedata.po.BasRegionBed;
import com.digihealth.anesthesia.common.service.BaseService;
import com.digihealth.anesthesia.common.utils.GenerateSequenceUtil;
import com.digihealth.anesthesia.evt.formbean.Filter;

/**
 * 
 * Title: RegionBedService.java Description: 操作日志保存接口
 * 
 * @author liukui
 * @created 2016-5-17 下午6:00:54
 */
@Service
public class BasRegionBedService extends BaseService {

	public List<BasRegionBed> getregionbed(SystemSearchFormBean regionBedFormbean) {
		if (StringUtils.isEmpty(regionBedFormbean.getBeid())) {
			regionBedFormbean.setBeid(getBeid());
		}
		StringBuffer filter = new StringBuffer();
		List<Filter> filters = regionBedFormbean.getFilters();
		if (filters != null && filters.size() > 0) {
			for (int i = 0; i < filters.size(); i++) {
				if (!StringUtils.isEmpty(filters.get(i).getValue().toString())) {
					Filter f = filters.get(i);
					filter.append(" AND " + f.getField() + " like '%" + f.getValue() + "%' ");
				}
			}
		}
		return basRegionBedDao.getregionbedList(filter.toString(), regionBedFormbean.getBeid());
	}

	public void updateByPatId(BasRegionBed regionBed) {
		if (StringUtils.isEmpty(regionBed.getBeid())) {
			regionBed.setBeid(getBeid());
		}
		basRegionBedDao.updateByPatId(regionBed);
	}

	public List<BasRegionBed> queryRegionBedList(SystemSearchFormBean systemSearchFormBean) {
		if (StringUtils.isEmpty(systemSearchFormBean.getBeid())) {
			systemSearchFormBean.setBeid(getBeid());
		}
		if (StringUtils.isEmpty(systemSearchFormBean.getSort())) {
			systemSearchFormBean.setSort("id");
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
		return basRegionBedDao.queryRegionBedList(filter, systemSearchFormBean);
	}

	public int queryRegionBedListTotal(SystemSearchFormBean systemSearchFormBean) {
		if (StringUtils.isEmpty(systemSearchFormBean.getBeid())) {
			systemSearchFormBean.setBeid(getBeid());
		}
		if (StringUtils.isEmpty(systemSearchFormBean.getSort())) {
			systemSearchFormBean.setSort("id");
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
		return basRegionBedDao.queryRegionBedListTotal(filter, systemSearchFormBean);
	}

	public BasRegionBed queryRegionBedById(String id) {
		return basRegionBedDao.searchRegionBedById(id);
	}

	@Transactional
	public int updateRegionBed(BasRegionBed regionBed) {
		if (StringUtils.isEmpty(regionBed.getBeid())) {
			regionBed.setBeid(getBeid());
		}
		if (null != regionBed.getId()) {
			return basRegionBedDao.updateByPrimaryKeySelective(regionBed);
		} else {
			regionBed.setStatus(0);
			regionBed.setId(GenerateSequenceUtil.generateSequenceNo());
			return basRegionBedDao.insert(regionBed);
		}
	}

	@Transactional
	public String deleteRegionBed(List<String> idList) {
		for (String id : idList) {
			basRegionBedDao.deleteByPrimaryKey(id);
		}
		return "删除成功";
	}

	public String getregpatIdByIpAndPort(String ip, int port) {
		return basRegionBedDao.getregpatIdByIpAndPort(ip, port, getBeid());
	}

	public BasRegionBed selectByIpAddrPort(String ip, Integer port,String beid) {
		if(StringUtils.isBlank(beid)){
			beid = getBeid();
		}
		return basRegionBedDao.selectByIpAddrPort(ip, port,beid);
	}
}
