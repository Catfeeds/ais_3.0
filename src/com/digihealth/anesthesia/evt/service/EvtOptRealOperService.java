package com.digihealth.anesthesia.evt.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.digihealth.anesthesia.basedata.formbean.OperDefFormBean;
import com.digihealth.anesthesia.basedata.utils.LogUtils;
import com.digihealth.anesthesia.basedata.utils.UserUtils;
import com.digihealth.anesthesia.common.service.BaseService;
import com.digihealth.anesthesia.common.utils.GenerateSequenceUtil;
import com.digihealth.anesthesia.common.utils.JsonType;
import com.digihealth.anesthesia.doc.po.DocAnaesRecord;
import com.digihealth.anesthesia.evt.formbean.SearchFormBean;
import com.digihealth.anesthesia.evt.po.EvtOptRealOper;

@Service
public class EvtOptRealOperService extends BaseService {

	public List<OperDefFormBean> getSelectOptRealOperList(SearchFormBean searchBean) {
		if (StringUtils.isBlank(searchBean.getBeid())) {
			searchBean.setBeid(getBeid());
		}
		return evtOptRealOperDao.getSelectOptRealOperList(searchBean);
	}

	public List<EvtOptRealOper> searchOptRealOperList(SearchFormBean searchBean) {
		if (StringUtils.isBlank(searchBean.getBeid())) {
			searchBean.setBeid(getBeid());
		}
		return evtOptRealOperDao.searchOptRealOperList(searchBean);
	}

	/**
	 * 实施手术
	 * 
	 * @param OptRealOper
	 */
	@Transactional
	public void saveOptRealOper(List<EvtOptRealOper> optRealOperList) {
		if (optRealOperList.size() > 0) {
			EvtOptRealOper optRealOper = optRealOperList.get(0);
			String docId = optRealOper.getDocId();
			evtOptRealOperDao.deleteByDocId(docId);
		}
		for (EvtOptRealOper optRealOper : optRealOperList) {
			if (StringUtils.isNotBlank(optRealOper.getOperDefId())) {
				optRealOper.setOptRealOperId(GenerateSequenceUtil.generateSequenceNo());
				evtOptRealOperDao.insert(optRealOper);
			}
		}

		String regOptId = "";
		if (optRealOperList.size() > 0) {
			DocAnaesRecord anaesRecord = docAnaesRecordDao.searchAnaesRecordById(optRealOperList.get(0).getDocId());
			regOptId = anaesRecord.getRegOptId();
		}

		LogUtils.saveOperateLog(regOptId, LogUtils.OPT_TYPE_INFO_SAVE, LogUtils.OPT_MODULE_OPER_RECORD, "实施手术保存",
				JsonType.jsonType(optRealOperList), UserUtils.getUserCache(), getBeid());
	}

	/**
	 * 检验事件
	 * 
	 * @param OptRealOper
	 */
	@Transactional
	public void insertOptRealOper(EvtOptRealOper optRealOper) {
		optRealOper.setOptRealOperId(GenerateSequenceUtil.generateSequenceNo());
		evtOptRealOperDao.insert(optRealOper);
	}

	/**
	 * 检验事件
	 * 
	 * @param OptRealOper
	 */
	@Transactional
	public void updateOptRealOper(EvtOptRealOper optRealOper) {
		evtOptRealOperDao.updateByPrimaryKeySelective(optRealOper);
	}

	/**
	 * 删除
	 * 
	 * @param optRealOper
	 */
	@Transactional
	public void deleteOptRealOper(EvtOptRealOper optRealOper) {
		evtOptRealOperDao.deleteByPrimaryKey(optRealOper.getOptRealOperId());
	}
}
