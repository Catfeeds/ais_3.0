package com.digihealth.anesthesia.evt.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import com.digihealth.anesthesia.basedata.utils.LogUtils;
import com.digihealth.anesthesia.basedata.utils.UserUtils;
import com.digihealth.anesthesia.common.service.BaseService;
import com.digihealth.anesthesia.common.utils.GenerateSequenceUtil;
import com.digihealth.anesthesia.common.utils.JsonType;
import com.digihealth.anesthesia.doc.po.DocAnaesRecord;
import com.digihealth.anesthesia.evt.formbean.SearchFormBean;
import com.digihealth.anesthesia.evt.po.EvtOtherEvent;

@Service
public class EvtOtherEventService extends BaseService {
	
	public List<EvtOtherEvent> searchOthereventList(SearchFormBean searchBean) {
		return evtOtherEventDao.searchOthereventList(searchBean);
	}
	@Transactional
	public void saveOtherevent(@RequestBody EvtOtherEvent otherevent) {
		DocAnaesRecord anaesRecord = docAnaesRecordDao.searchAnaesRecordById(otherevent.getDocId());
		if(StringUtils.isNotBlank(otherevent.getOtherEventId())){
			this.updateOtherevent(otherevent);
		}else{
			otherevent.setOtherEventId(GenerateSequenceUtil.generateSequenceNo());
			evtOtherEventDao.insertSelective(otherevent);
		}
		LogUtils.saveOperateLog(anaesRecord.getRegOptId(), LogUtils.OPT_TYPE_INFO_SAVE,
            LogUtils.OPT_MODULE_OPER_RECORD,"术中其他事件保存", JsonType.jsonType(otherevent), UserUtils.getUserCache(), getBeid());
	}
	
	/**
	 * 检验事件
	 * @param Otherevent
	 */
	@Transactional
	public void insertOtherevent(EvtOtherEvent otherevent){
		otherevent.setOtherEventId(GenerateSequenceUtil.generateSequenceNo());
		evtOtherEventDao.insertSelective(otherevent);
	}
	/**
	 * 检验事件
	 * @param Otherevent
	 */
	@Transactional
	public void updateOtherevent(EvtOtherEvent otherevent){
		evtOtherEventDao.updateByPrimaryKeySelective(otherevent);
	}
	
	
	@Transactional
	public void deleteOtherevent(EvtOtherEvent otherevent){
		evtOtherEventDao.deleteByPrimaryKey(otherevent.getOtherEventId());
	}
}
