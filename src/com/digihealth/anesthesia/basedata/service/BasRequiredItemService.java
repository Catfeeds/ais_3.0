package com.digihealth.anesthesia.basedata.service;

import java.util.List;
import java.util.Map;

import org.apache.commons.collections.MapUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.druid.util.StringUtils;
import com.digihealth.anesthesia.basedata.po.BasRequiredItem;
import com.digihealth.anesthesia.common.service.BaseService;

@Service
public class BasRequiredItemService extends BaseService {
	
	public List<BasRequiredItem> searchRequiredItem(Map<String, Object> map) {
		if (StringUtils.isEmpty((String) map.get("beid"))) {
			map.put("beid", getBeid());
		}
		Integer type = 0;
		if (map.get("type") != null) {
			type = MapUtils.getInteger(map, "type");
		}
		return basRequiredItemDao.selectByType(type, (String) map.get("beid"));
	}

	@Transactional
	public void updateRequiredItem(List<BasRequiredItem> requiredItemList) {
		if (null != requiredItemList && requiredItemList.size() > 0) {
			for (int i = 0; i < requiredItemList.size(); i++) {
				basRequiredItemDao.updateByPrimaryKeySelective(requiredItemList.get(i));
			}
		}
	}
}
