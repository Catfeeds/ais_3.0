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
import com.digihealth.anesthesia.evt.formbean.OperBodyFormBean;
import com.digihealth.anesthesia.evt.formbean.SearchFormBean;
import com.digihealth.anesthesia.evt.po.EvtOperBodyEvent;

@Service
public class EvtOperBodyEventService extends BaseService {

	public List<OperBodyFormBean> queryOperBodyEventList(SearchFormBean searchBean) {
		if (StringUtils.isBlank(searchBean.getBeid())) {
			searchBean.setBeid(getBeid());
		}
		return evtOperBodyEventDao.queryOperBodyEventList(searchBean);
	}

	/**
	 * 手术体位变更
	 * 
	 * @param OptLatterDiag
	 */
	@Transactional
	public void saveOperBody(EvtOperBodyEvent operBodyEvent) {
		// 获取麻醉记录单
		DocAnaesRecord anaesRecord = docAnaesRecordDao.searchAnaesRecordById(operBodyEvent.getDocId());
		// operBodyEvent.setState(anaesRecord.getState());
		operBodyEvent.setOptBodyEventId(GenerateSequenceUtil.generateSequenceNo());
		evtOperBodyEventDao.insert(operBodyEvent);

		LogUtils.saveOperateLog(anaesRecord.getRegOptId(), LogUtils.OPT_TYPE_INFO_SAVE, LogUtils.OPT_MODULE_OPER_RECORD, "术中手术体位变更保存", JsonType.jsonType(operBodyEvent), UserUtils.getUserCache(), getBeid());
	}

	public String queryOperBodyList(SearchFormBean searchBean) {
		DocAnaesRecord anaesRecord = docAnaesRecordDao.searchAnaesRecordById(searchBean.getDocId());
		String anaeString = null;
		if (null != anaesRecord) {
			anaeString = anaesRecord.getOptBody();
		}
		return anaeString;
	}
}
