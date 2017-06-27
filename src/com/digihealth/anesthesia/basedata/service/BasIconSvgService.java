package com.digihealth.anesthesia.basedata.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.digihealth.anesthesia.common.service.BaseService;

/**
 * 通过icon图标获取svg path路径
 * 
 * @author HK
 */
@Service
public class BasIconSvgService extends BaseService {

	public String getPathByIcon(String icon, String beid) {
		if (StringUtils.isBlank(beid)) {
			beid = getBeid();
		}

		return basIconSvgDao.getSvgByIcon(icon, beid);
	}

}
