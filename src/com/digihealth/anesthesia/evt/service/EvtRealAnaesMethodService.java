/**
 * Copyright &copy; 2012-2013 <a href="httparamMap://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.digihealth.anesthesia.evt.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.digihealth.anesthesia.basedata.utils.LogUtils;
import com.digihealth.anesthesia.basedata.utils.UserUtils;
import com.digihealth.anesthesia.common.service.BaseService;
import com.digihealth.anesthesia.common.utils.GenerateSequenceUtil;
import com.digihealth.anesthesia.common.utils.JsonType;
import com.digihealth.anesthesia.doc.po.DocAnaesRecord;
import com.digihealth.anesthesia.evt.formbean.EvtAnaesMethodFormBean;
import com.digihealth.anesthesia.evt.formbean.SearchFormBean;
import com.digihealth.anesthesia.evt.po.EvtRealAnaesMethod;

/**
 * 
 * Title: RealAnaesMethodService.java Description:实际麻醉方法service
 * 
 * @author liukui
 * @created 2015-10-7 下午6:00:54
 */
@Service
public class EvtRealAnaesMethodService extends BaseService {

	public List<EvtAnaesMethodFormBean> getSelectRealAnaesMethodList(SearchFormBean searchBean) {
		return evtRealAnaesMethodDao.getSelectRealAnaesMethodList(searchBean);
	}

	public List<EvtRealAnaesMethod> searchRealAnaesMethodList(SearchFormBean searchBean) {
		return evtRealAnaesMethodDao.searchRealAnaesMethodList(searchBean);
	}

	/**
	 * 保存麻醉方法
	 * 
	 * @param RealAnaesMethod
	 */
	@Transactional
	public void saveRealAnaesMethod(List<EvtRealAnaesMethod> realAnaesMethodList) {
		String regOptId = "";
		if (realAnaesMethodList.size() > 0) {
			DocAnaesRecord anaesRecord = docAnaesRecordDao.searchAnaesRecordById(realAnaesMethodList.get(0).getDocId());
			regOptId = anaesRecord.getRegOptId();
		}

		if (realAnaesMethodList.size() > 0) {
			EvtRealAnaesMethod realAnaesMethod = realAnaesMethodList.get(0);
			evtRealAnaesMethodDao.deleteByDocId(realAnaesMethod.getDocId());
		}

		for (EvtRealAnaesMethod realAnaesMethod : realAnaesMethodList) {
			if (StringUtils.isNotBlank(realAnaesMethod.getAnaMedId())){
				realAnaesMethod.setRealAnaMedId(GenerateSequenceUtil.generateSequenceNo());
				evtRealAnaesMethodDao.insert(realAnaesMethod);
			}
		}
		LogUtils.saveOperateLog(regOptId, LogUtils.OPT_TYPE_INFO_SAVE, LogUtils.OPT_MODULE_OPER_RECORD, "术中麻醉方法保存", JsonType.jsonType(realAnaesMethodList), UserUtils.getUserCache(), getBeid());
	}

	/**
	 * 检验事件
	 * 
	 * @param RealAnaesMethod
	 */
	@Transactional
	public void insertRealAnaesMethod(EvtRealAnaesMethod realAnaesMethod) {
		realAnaesMethod.setRealAnaMedId(GenerateSequenceUtil.generateSequenceNo());
		evtRealAnaesMethodDao.insert(realAnaesMethod);
	}

	/**
	 * 
	 * @param realAnaesMethod
	 */
	@Transactional
	public void deleteRealAnaesMethod(EvtRealAnaesMethod realAnaesMethod) {
		evtRealAnaesMethodDao.deleteByPrimaryKey(realAnaesMethod.getRealAnaMedId());
	}
}
