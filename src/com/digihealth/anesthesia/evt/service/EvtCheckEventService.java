package com.digihealth.anesthesia.evt.service;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.digihealth.anesthesia.common.service.BaseService;
import com.digihealth.anesthesia.common.utils.DateUtils;
import com.digihealth.anesthesia.common.utils.GenerateSequenceUtil;
import com.digihealth.anesthesia.evt.formbean.CheckeventItemFormBean;
import com.digihealth.anesthesia.evt.formbean.SearchFormBean;
import com.digihealth.anesthesia.evt.po.EvtCheckEvent;
import com.digihealth.anesthesia.evt.po.EvtCheckEventItemRelation;

@Service
public class EvtCheckEventService extends BaseService {

	public EvtCheckEvent searchEvtCheckEventById(String id) {
		return evtCheckEventDao.selectByPrimaryKey(id);
	}
	
	public List<EvtCheckEvent> serarchCheckevent(SearchFormBean searchBean) {
		List<EvtCheckEventItemRelation> checkeventItems = evtCheckEventItemRelationDao.serarchCheckevent(searchBean);
		List<EvtCheckEvent> list = evtCheckEventDao.searchCheckeventList(searchBean);
//		if (null != checkeventItems && checkeventItems.size() > 0) {
//			for (EvtCheckEventItemRelation checkeventItem : checkeventItems) {
//				List<EvtCheckEventItemRelation> vaildCheckItems = evtCheckEventItemRelationDao.serarchAllValidCheckeventItem(checkeventItem.getDocId());
//				if (null != vaildCheckItems) {
//					checkeventItem.setVaildCheckItems(vaildCheckItems);
//				}
//			}
//		}
		return list;
	}
	
	public List<EvtCheckEventItemRelation> serarchCheckeventItemRelationList(SearchFormBean searchBean) {
		if (StringUtils.isBlank(searchBean.getBeid())) {
			searchBean.setBeid(getBeid());
		}
		return evtCheckEventItemRelationDao.serarchCheckeventItemRelationList(searchBean);
	}
	
	/**
	 * 检验事件
	 * @param CheckeventItemRelation
	 */
	@Transactional
	public void inserCheckeventItemRelation(EvtCheckEventItemRelation checkeventItemRelation){
		checkeventItemRelation.setItemId(GenerateSequenceUtil.generateSequenceNo());
		evtCheckEventItemRelationDao.insert(checkeventItemRelation);
	}
	
	/**
	 * 
	 * @param checkeventItemRelation
	 */
	@Transactional
	public void inserCheckeventItemRelationHis(EvtCheckEventItemRelation checkeventItemRelation){
		checkeventItemRelation.setItemId(GenerateSequenceUtil.generateSequenceNo());
		evtCheckEventItemRelationDao.inserCheckeventItemRelationHis(checkeventItemRelation);
	}
	
	@Transactional
	public String updateCheckeventItemRelation(CheckeventItemFormBean checkeventItemFormBean){
		String date = DateUtils.getDateTime();
		List<EvtCheckEventItemRelation> list = checkeventItemFormBean.getCheckeventItemRelationList();
		if(list!=null&&list.size()>0){
			String evtCheckEventId = GenerateSequenceUtil.generateSequenceNo();
			EvtCheckEvent evtCheckEvent = checkeventItemFormBean.getEvtCheckEvent();
			if (StringUtils.isBlank(evtCheckEvent.getCheEventId())) {
				evtCheckEvent.setCheEventId(evtCheckEventId);
				evtCheckEventDao.insert(evtCheckEvent);
			}else {
				evtCheckEventDao.updateByPrimaryKey(evtCheckEvent);
			}
			if(StringUtils.isNotBlank(evtCheckEvent.getCheEventId())){
				evtCheckEventItemRelationDao.deleteCheckeventItemRelation(evtCheckEvent.getCheEventId());
			}
			for(EvtCheckEventItemRelation checkeventItemRelation : list){
				if (StringUtils.isBlank(checkeventItemRelation.getCheEventId())) {
					checkeventItemRelation.setCheEventId(evtCheckEvent.getCheEventId());
				}
				inserCheckeventItemRelation(checkeventItemRelation);
			}
		}
		return date;
	}
	
	@Transactional
	public int deleteCheckItem(SearchFormBean searchBean){
		evtCheckEventItemRelationDao.deleteCheckeventItemRelation(searchBean.getCheEventId());
		int total = evtCheckEventDao.deleteByPrimaryKey(searchBean.getCheEventId());
		return total;
	}
}
