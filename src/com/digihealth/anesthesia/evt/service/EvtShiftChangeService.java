/**
 * Copyright &copy; 2012-2013 <a href="httparamMap://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.digihealth.anesthesia.evt.service;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.digihealth.anesthesia.basedata.utils.LogUtils;
import com.digihealth.anesthesia.basedata.utils.UserUtils;
import com.digihealth.anesthesia.common.entity.ResponseValue;
import com.digihealth.anesthesia.common.service.BaseService;
import com.digihealth.anesthesia.common.utils.GenerateSequenceUtil;
import com.digihealth.anesthesia.common.utils.JsonType;
import com.digihealth.anesthesia.common.utils.SysUtil;
import com.digihealth.anesthesia.doc.po.DocAnaesRecord;
import com.digihealth.anesthesia.evt.formbean.SearchFormBean;
import com.digihealth.anesthesia.evt.po.EvtParticipant;
import com.digihealth.anesthesia.evt.po.EvtShiftChange;

/**
 * Title: ShiftChangeService.java Description:交接班事件service
 * 
 * @author liukui
 * @created 2015-10-7 下午6:00:54
 */
@Service
public class EvtShiftChangeService extends BaseService {

	/**
	 * 查询当前交接班情况
	 * 
	 * @param searchBean
	 * @return
	 */
	public List<EvtShiftChange> searchShiftChangeList(SearchFormBean searchBean) {
		return evtShiftChangeDao.searchShiftChangeList(searchBean);
	}

	/**
	 * 保存交班信息
	 * 
	 * @param id
	 */
	@Transactional
	public void saveShiftChange(EvtShiftChange shiftChange, ResponseValue respValue) {

		LogUtils.saveOperateLog(shiftChange.getDocId(), LogUtils.OPT_TYPE_INFO_SAVE, LogUtils.OPT_MODULE_OPER_RECORD, "术中人员交接班信息保存", JsonType.jsonType(shiftChange), UserUtils.getUserCache(), getBeid());

		// 当正常交接班时，判断交接班人员是否为同一人
		if (StringUtils.isNotBlank(shiftChange.getShiftChangedPeopleId()) && StringUtils.isNotBlank(shiftChange.getShiftChangePeopleId())) {
			if (shiftChange.getShiftChangedPeopleId().equals(shiftChange.getShiftChangePeopleId())) {
				respValue.setResultCode("10000001");
				respValue.setResultMessage("交接班人员不能为同一人员，请核查数据");
				return;
			}
		}
		String userLoginName = shiftChange.getShiftChangePeopleId();
		String name = shiftChange.getShiftChangePeople();

		// 如果交班信息发生改变则先删除接班人员在术中人员列表的信息，再将接班人员信息插入至术中人员表
		EvtParticipant participant = new EvtParticipant();
		participant.setPartpId(GenerateSequenceUtil.generateSequenceNo());
		participant.setDocId(shiftChange.getDocId());

		participant.setRole(EvtParticipantService.ROLE_ANESTH);
		participant.setOperatorType("01");// 只有主麻才能交接班
		if (shiftChange.getId() != null) {
			EvtShiftChange parObj = evtShiftChangeDao.selectByPrimaryKey(shiftChange.getId());
			evtParticipantDao.deleteByUserId(parObj.getDocId(), parObj.getShiftChangePeopleId());
			evtShiftChangeDao.updateByPrimaryKeySelective(shiftChange);
		} else {

			// 如果接班人员为空时，则为手术完成
			if (StringUtils.isBlank(shiftChange.getShiftChangePeopleId())) {
				// 获取交班人员信息，将麻醉记录单描点数据变更表的userId对应到交班人员
				SearchFormBean searchBean = new SearchFormBean();
				searchBean.setDocId(shiftChange.getDocId());
				List<EvtShiftChange> shiftList = evtShiftChangeDao.getAllShiftChangeList(searchBean);
				for (EvtShiftChange shift : shiftList) {
					DocAnaesRecord docAnaesRecord = docAnaesRecordDao.selectByPrimaryKey(shift.getDocId());
					String time = SysUtil.getTimeFormat(shift.getShiftChangeTime());
					if (null != docAnaesRecord) {
						String regOptId = docAnaesRecord.getRegOptId();
						if (StringUtils.isNotEmpty(regOptId)) {
							observeDataChangeDao.updateObserveUserByRegOptId(shift.getShiftChangedPeopleId(),time, regOptId);
						}
					}
				}
				// 在手术完成时，避免在participant表出现重复的人员数据，先删除再插入
				evtParticipantDao.deleteByUserId(shiftChange.getDocId(), shiftChange.getShiftChangedPeopleId());

				userLoginName = shiftChange.getShiftChangedPeopleId();
				name = shiftChange.getShiftChangedPeople();
			} else {
				shiftChange.setShiftChangeTime(new Date());
				evtShiftChangeDao.insertSelective(shiftChange);
			}
		}
		participant.setUserLoginName(userLoginName);
		participant.setName(name);
		participant.setIsShiftChange(1); // 交接班人员
		evtParticipantDao.insertSelective(participant);
	}

	/**
	 * 删除交班信息
	 * 
	 * @param id
	 */
	@Transactional
	public void deleteShiftChange(Integer id) {
		EvtShiftChange shiftChange = evtShiftChangeDao.selectByPrimaryKey(id);
		// 在手术人员表中删除接班人员信息
		if (shiftChange != null) {
			evtParticipantDao.deleteByUserId(shiftChange.getDocId(), shiftChange.getShiftChangePeopleId());
			// 删除交接班信息
			evtShiftChangeDao.deleteByPrimaryKey(shiftChange.getId());
		}
	}
}
