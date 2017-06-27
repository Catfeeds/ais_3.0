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
import com.digihealth.anesthesia.evt.formbean.SearchFormBean;
import com.digihealth.anesthesia.evt.po.EvtParticipant;
import com.digihealth.anesthesia.sysMng.formbean.UserInfoFormBean;

@Service
public class EvtParticipantService extends BaseService {
	public static final String ROLE_ANESTH = "A";
	public static final String ROLE_NURSE = "N";
	public static final String ROLE_OPERAT = "O";
	public static final String OPER_TYPE_INSTRUMENT = "04";
	public static final String OPER_TYPE_TOUR = "05";

	public List<UserInfoFormBean> getSelectParticipantList(SearchFormBean searchBean) {
		return evtParticipantDao.getSelectParticipantList(searchBean, getBeid());
	}

	/**
	 * 根据麻醉文书id获取手术人员信息
	 * 
	 * @param docId
	 * @return
	 */
	public List<EvtParticipant> searchParticipantList(SearchFormBean searchBean) {
		return evtParticipantDao.searchParticipantList(searchBean, getBeid());
	}

	/**
	 * 根据docId获取当次手术的麻醉医生及护士信息
	 * 
	 * @param searchBean
	 * @return
	 */
	public List<EvtParticipant> queryOperPersonListByDocId(SearchFormBean searchBean) {
		return evtParticipantDao.queryOperPersonListByDocId(searchBean);
	}

	/**
	 * 手术人员
	 * 
	 * @param Participant
	 */
	@Transactional
	public void saveParticipant(List<EvtParticipant> participantList) {

		String regOptId = "";
		if (participantList.size() > 0) {
			DocAnaesRecord anaesRecord = docAnaesRecordDao.searchAnaesRecordById(participantList.get(0).getDocId());
			regOptId = anaesRecord.getRegOptId();
		}
		LogUtils.saveOperateLog(regOptId, LogUtils.OPT_TYPE_INFO_SAVE, LogUtils.OPT_MODULE_OPER_RECORD, "手术人员保存", JsonType.jsonType(participantList), UserUtils.getUserCache(), getBeid());

		if (participantList.size() > 0) {
			EvtParticipant part = participantList.get(0);

			evtParticipantDao.deleteByOperatorType(part);
			// 如果保存为麻醉医生这里需要特殊处理下
			if (part.getRole().equals("A")) {
				List<EvtParticipant> mainAnesDocList = evtParticipantDao.getMainDocList(part.getDocId(), part.getRole(), "01");
				for (EvtParticipant participant1 : participantList) {
					boolean flag = true;
					for (EvtParticipant participant : mainAnesDocList) {
						// 如果界面传入过来的麻醉医生列表的数据已经存在则不新增
						if (participant1.getUserLoginName().equals(participant.getUserLoginName())) {
							flag = false;
							break;
						}
					}
					if (flag) {
						if (StringUtils.isNotBlank(participant1.getUserLoginName())) {
							participant1.setPartpId(GenerateSequenceUtil.generateSequenceNo());
							evtParticipantDao.insertSelective(participant1);
						}
					}
				}
			} else if (part.getRole().equals("O")) {
				List<EvtParticipant> mainOperateDocList = evtParticipantDao.getMainDocList(part.getDocId(), part.getRole(), "06");
				for (EvtParticipant participant1 : participantList) {
					boolean flag = true;
					for (EvtParticipant participant : mainOperateDocList) {
						// 如果界面传入过来的手术医生列表的数据已经存在则不新增
						if (participant1.getUserLoginName().equals(participant.getUserLoginName())) {
							flag = false;
							break;
						}
					}
					if (flag) {
						if (StringUtils.isNotBlank(participant1.getUserLoginName())) {
							participant1.setPartpId(GenerateSequenceUtil.generateSequenceNo());
							evtParticipantDao.insertSelective(participant1);
						}
					}
				}
			} else {
				for (EvtParticipant participant : participantList) {
					if (StringUtils.isNotBlank(participant.getUserLoginName())) {
						participant.setPartpId(GenerateSequenceUtil.generateSequenceNo());
						evtParticipantDao.insertSelective(participant);
					}
				}
			}
		}
	}

	/**
	 * 检验事件
	 * 
	 * @param Participant
	 */
	@Transactional
	public void insertParticipant(EvtParticipant participant) {
		participant.setPartpId(GenerateSequenceUtil.generateSequenceNo());
		evtParticipantDao.insertSelective(participant);
	}

	/**
	 * 
	 * @param participant
	 */
	@Transactional
	public void deleteParticipant(EvtParticipant participant) {
		evtParticipantDao.deleteByPrimaryKey(participant.getPartpId());
	}
}
