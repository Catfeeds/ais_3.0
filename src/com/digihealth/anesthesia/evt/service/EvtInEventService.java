package com.digihealth.anesthesia.evt.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.digihealth.anesthesia.basedata.po.BasIoDefination;
import com.digihealth.anesthesia.basedata.utils.LogUtils;
import com.digihealth.anesthesia.basedata.utils.UserUtils;
import com.digihealth.anesthesia.common.entity.ResponseValue;
import com.digihealth.anesthesia.common.service.BaseService;
import com.digihealth.anesthesia.common.utils.DateUtils;
import com.digihealth.anesthesia.common.utils.GenerateSequenceUtil;
import com.digihealth.anesthesia.common.utils.JsonType;
import com.digihealth.anesthesia.evt.formbean.RegOptOperIoeventFormBean;
import com.digihealth.anesthesia.evt.formbean.SearchFormBean;
import com.digihealth.anesthesia.evt.formbean.SearchOptOperIoevent;
import com.digihealth.anesthesia.evt.po.EvtInEvent;

@Service
public class EvtInEventService extends BaseService {

	public List<SearchOptOperIoevent> searchIoeventList(SearchFormBean searchBean) {
		return evtInEventDao.searchIoeventList(searchBean);
	}

	public List<RegOptOperIoeventFormBean> searchIoeventGroupByDefIdList(SearchFormBean searchBean) {
		// 将相同药品的数据重新封装
		List<RegOptOperIoeventFormBean> resultList = evtInEventDao.searchIoeventGroupByDefIdList(searchBean);
		for (RegOptOperIoeventFormBean regOptOperIoeventFormBean : resultList) {
			// 入量事件
			searchBean.setCode(regOptOperIoeventFormBean.getIoDefId().toString());
			SearchOptOperIoevent soi = evtInEventDao.queryIoeventTotalByDefId(searchBean);
			regOptOperIoeventFormBean.setTotalAmout(soi.getTotalAmout());
			regOptOperIoeventFormBean.setIoeventList(evtInEventDao.searchIoeventList(searchBean));
		}
		return resultList;
	}

	public Integer getIoeventCountValueByIoDef(String docId, String ioDefId) {
		return evtInEventDao.getIoeventCountValueByIoDef(docId, ioDefId);
	}

	@Transactional
	public void saveIoevent(EvtInEvent ioevent, ResponseValue value) {

		SearchFormBean searchFormBean = new SearchFormBean();
		searchFormBean.setDocId(ioevent.getDocId());
		searchFormBean.setId(ioevent.getInEventId());
		List<EvtInEvent> List = evtInEventDao.checkIoeventCanInsert(searchFormBean, ioevent.getIoDefId() + "");
		if (null != List && List.size() > 0) {
			for (EvtInEvent event : List) {
				Date ioStartTime = ioevent.getStartTime();
				Date startTime = event.getStartTime();
				Date ioEndTime = ioevent.getEndTime();
				Date endTime = event.getEndTime();
				if ((ioStartTime.getTime() < startTime.getTime() && ioEndTime.getTime() < endTime.getTime()) || ioStartTime.getTime() > endTime.getTime()) {
					continue;
				} else {
					value.setResultCode("10000001");
					value.setResultMessage("该输液在开始时间：" + ioevent.getStartTime() + "至结束时间：" + ioevent.getEndTime() + ", 已经存在持续输液情况,请勿重复添加!");
					return;
				}
			}
		}

		if (StringUtils.isNotBlank(ioevent.getInEventId())) {
			evtInEventDao.updateByPrimaryKeySelective(ioevent);
		} else {
			ioevent.setInEventId(GenerateSequenceUtil.generateSequenceNo());
			evtInEventDao.insert(ioevent);
		}
		LogUtils.saveOperateLog(ioevent.getDocId(), LogUtils.OPT_TYPE_INFO_SAVE, LogUtils.OPT_MODULE_INTERFACE, "术中入量事件保存", JsonType.jsonType(ioevent), UserUtils.getUserCache(), getBeid());

	}

	@Transactional
	public void batchSaveIoevent(List<EvtInEvent> ioeventList, ResponseValue value) {
		if (null != ioeventList && ioeventList.size() > 0) {
			List<String> successList = new ArrayList<String>();
			List<String> failList = new ArrayList<String>();
			for (EvtInEvent ioevent : ioeventList) {
				SearchFormBean searchFormBean = new SearchFormBean();
				searchFormBean.setDocId(ioevent.getDocId());
				searchFormBean.setId(ioevent.getInEventId());
				List<EvtInEvent> List = evtInEventDao.checkIoeventCanInsert(searchFormBean, ioevent.getIoDefId() + "");

				boolean flag = false;

				for (EvtInEvent event : List) {
					if ((DateUtils.parseDate(ioevent.getStartTime()).compareTo(DateUtils.parseDate(event.getStartTime())) < 0 && DateUtils.parseDate(ioevent.getEndTime()).compareTo(DateUtils.parseDate(event.getStartTime())) < 0) || DateUtils.parseDate(ioevent.getStartTime()).compareTo(DateUtils.parseDate(event.getEndTime())) > 0) {
						continue;
					} else {
						// value.setResultCode("10000001");
						// value.setResultMessage("该输液在开始时间：" +
						// ioevent.getStarttime() + "至结束时间：" +
						// ioevent.getEndtime()
						// + ", 已经存在持续输液情况,请勿重复添加!");
						// return;
						flag = true;
					}
				}

				BasIoDefination ioDefination = basIoDefinationDao.selectByPrimaryKey(ioevent.getIoDefId() + "");

				if (flag) {
					failList.add(ioDefination.getName());
					continue;
				}

				if (StringUtils.isBlank(ioevent.getInEventId())) {
					ioevent.setInEventId(GenerateSequenceUtil.generateSequenceNo());
					evtInEventDao.insert(ioevent);
					successList.add(ioDefination.getName());
				}
			}
			value.put("success", successList);
			value.put("fail", failList);
		}
	}

	/**
	 * 新增出入量事件
	 * 
	 * @param Anaesevent
	 */
	@Transactional
	public void insertIoevent(EvtInEvent ioevent) {
		ioevent.setInEventId(GenerateSequenceUtil.generateSequenceNo());
		evtInEventDao.insert(ioevent);
	}

	/**
	 * 修改出入量事件
	 * 
	 * @param Anaesevent
	 */
	@Transactional
	public void updateIoevent(EvtInEvent ioevent) {
		evtInEventDao.updateByPrimaryKeySelective(ioevent);
	}

	/**
	 * 删除出入量事件
	 * 
	 * @param ioevent
	 */
	@Transactional
	public void deleteIoevent(EvtInEvent ioevent) {
		evtInEventDao.deleteByPrimaryKey(ioevent.getInEventId());
	}

	public String seleteIoeventSumByDocId(String docId) {
		return evtInEventDao.seleteIoeventSumByDocId(docId);
	}

	public String seleteEgressSumByDocId(String docId) {
		return evtInEventDao.seleteEgressSumByDocId(docId);
	}

	public String seleteEmictionSumByDocId(String docId) {
		return evtInEventDao.seleteEmictionSumByDocId(docId);
	}

	public String seleteBloodSumByDocId(String docId) {
		return evtInEventDao.seleteBloodSumByDocId(docId);
	}

	public String seleteOtherSumByDocId(String docId) {
		return evtInEventDao.seleteOtherSumByDocId(docId);
	}

	public String getBloodByDocId(@Param("docId") String docId) {
		return evtInEventDao.getBloodByDocId(docId);
	}
}
