package com.digihealth.anesthesia.evt.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.digihealth.anesthesia.basedata.utils.LogUtils;
import com.digihealth.anesthesia.basedata.utils.UserUtils;
import com.digihealth.anesthesia.common.entity.ResponseValue;
import com.digihealth.anesthesia.common.service.BaseService;
import com.digihealth.anesthesia.common.utils.GenerateSequenceUtil;
import com.digihealth.anesthesia.common.utils.JsonType;
import com.digihealth.anesthesia.doc.po.DocAnaesRecord;
import com.digihealth.anesthesia.evt.formbean.SearchFormBean;
import com.digihealth.anesthesia.evt.po.EvtCtlBreath;

@Service
public class EvtCtlBreathService extends BaseService {
	
	public List<EvtCtlBreath> searchCtlBreathList(SearchFormBean searchBean) {
		return evtCtlBreathDao.searchCtlBreathList(searchBean);
	}

	@Transactional
	public void saveCtlBreath(EvtCtlBreath ctlBreath,ResponseValue resp) {
		DocAnaesRecord anaesRecord = docAnaesRecordDao.searchAnaesRecordById(ctlBreath.getDocId());
		//ctlBreath.setState(anaesRecord.getState());
		// 判断当前的呼吸模式是否和页面传递过来的模式相同，如果相同，则不做任何操作，如果不相同，则置为0，再新增一条1
		EvtCtlBreath cb = evtCtlBreathDao.queryCurCtlBreath(ctlBreath.getDocId());
		if (null != cb) {
			logger.info("saveCtlBreath---cb.type===" + cb.getType() + ",ctlBreath.type=" + ctlBreath.getType());
			if (cb.getType().equals(ctlBreath.getType())) {
				logger.info("saveCtlBreath----呼吸事件的type一致，无需修改----");
				resp.setResultCode("200000000");
				resp.setResultMessage("saveCtlBreath----呼吸事件的type一致，无需修改!");
				return;
			} else { // 修改状态、新增记录
				evtCtlBreathDao.updateCurrentState(ctlBreath.getDocId(), "0");
				ctlBreath.setCtlBreId(GenerateSequenceUtil.generateSequenceNo());
				ctlBreath.setCurrentState(1);
				evtCtlBreathDao.insertSelective(ctlBreath);
			}
		} else {
			evtCtlBreathDao.updateCurrentState(ctlBreath.getDocId(), "0");
			ctlBreath.setCtlBreId(GenerateSequenceUtil.generateSequenceNo());
			ctlBreath.setCurrentState(1);
			evtCtlBreathDao.insert(ctlBreath);
		}
		LogUtils.saveOperateLog(anaesRecord.getRegOptId(), LogUtils.OPT_TYPE_INFO_SAVE, LogUtils.OPT_MODULE_INTERFACE, "术中人员呼吸事件保存", JsonType.jsonType(ctlBreath), UserUtils.getUserCache(), getBeid());
	}

	public EvtCtlBreath selCtlBreathCur(String regOptId) {
		return evtCtlBreathDao.selCtlBreathCur(regOptId);
	}

	public List<EvtCtlBreath> searchBreathListOrder(String regOptId) {
		return evtCtlBreathDao.searchBreathListOrder(regOptId);
	}
}
