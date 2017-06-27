/**
 * Copyright &copy; 2012-2013 <a href="httparamMap://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.digihealth.anesthesia.evt.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.digihealth.anesthesia.basedata.utils.LogUtils;
import com.digihealth.anesthesia.basedata.utils.UserUtils;
import com.digihealth.anesthesia.common.service.BaseService;
import com.digihealth.anesthesia.common.utils.GenerateSequenceUtil;
import com.digihealth.anesthesia.common.utils.JsonType;
import com.digihealth.anesthesia.doc.po.DocAnaesRecord;
import com.digihealth.anesthesia.evt.formbean.SearchFormBean;
import com.digihealth.anesthesia.evt.po.EvtRescueevent;

/**
     * Title: RescueeventService.java    
     * Description:呼吸事件service
     * @author liukui       
     * @created 2015-10-7 下午6:00:54
 */
@Service
public class EvtRescueeventService extends BaseService {

	public List<EvtRescueevent> searchRescueeventList(SearchFormBean searchBean) 
	{
		return evtRescueeventDao.searchRescueeventList(searchBean);
	}
	
	@Transactional
	public void saveRescueevent(EvtRescueevent rescueevent)
	{
		
		DocAnaesRecord anaesRecord = docAnaesRecordDao.searchAnaesRecordById(rescueevent.getDocId());
		
		LogUtils.saveOperateLog(anaesRecord.getRegOptId(), LogUtils.OPT_TYPE_INFO_SAVE,
            LogUtils.OPT_MODULE_OPER_RECORD,"术中呼吸事件保存", JsonType.jsonType(rescueevent), UserUtils.getUserCache(), getBeid());
		
		evtRescueeventDao.updateCurrentState(rescueevent.getDocId(), "0");
		rescueevent.setCurrentState(1);
		rescueevent.setRescueEventId(GenerateSequenceUtil.generateSequenceNo());
		rescueevent.setStartTime(new Date());
		evtRescueeventDao.insertSelective(rescueevent);
	}
}
