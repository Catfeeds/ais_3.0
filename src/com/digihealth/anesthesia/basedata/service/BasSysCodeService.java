package com.digihealth.anesthesia.basedata.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.digihealth.anesthesia.basedata.formbean.AnaesEventFormBean;
import com.digihealth.anesthesia.basedata.formbean.SysCodeFormbean;
import com.digihealth.anesthesia.basedata.formbean.SystemSearchFormBean;
import com.digihealth.anesthesia.common.entity.ResponseValue;
import com.digihealth.anesthesia.common.service.BaseService;
import com.digihealth.anesthesia.common.utils.CacheUtils;
import com.digihealth.anesthesia.common.utils.GenerateSequenceUtil;
import com.digihealth.anesthesia.common.utils.StringUtils;
import com.digihealth.anesthesia.evt.formbean.Filter;
import com.digihealth.anesthesia.evt.formbean.SearchFormBean;
import com.digihealth.anesthesia.evt.po.EvtAnaesEvent;


@Service
public class BasSysCodeService extends BaseService {
	public static final String SYS_CODE_CACHE = "sysCodeCache";
	public static final String SYS_CODE_CACHE_ID = "id_";
	
	@SuppressWarnings("unchecked")
	public List<SysCodeFormbean> searchSysCodeByGroupId(String groupId,String beid){
		if(StringUtils.isBlank(beid)){
			beid = getBeid();
		}
		List<SysCodeFormbean> list = (List<SysCodeFormbean>) CacheUtils.get(SYS_CODE_CACHE, SYS_CODE_CACHE_ID+groupId+beid);
		if(list == null || list.size()<=0){
			list = basSysCodeDao.searchSysCodeByGroupId(StringUtils.zhuanData(groupId),beid);
			CacheUtils.put(SYS_CODE_CACHE, SYS_CODE_CACHE_ID +groupId+beid, list);
		}
		return list;
	}
	
	public List<SysCodeFormbean> searchSysCodeByGroupIdAndCodeValue(String groupId,String codeValue,String beid){
		if(StringUtils.isBlank(beid)){
			beid = getBeid();
		}
		groupId = StringUtils.zhuanData(groupId);
		return basSysCodeDao.searchSysCodeByGroupIdAndCodeValue(groupId, codeValue,beid);
	}
	
	public List<SysCodeFormbean> searchSysCodeByGroupIdAndCodeName(String groupId,String codeName,String beid){
		if(StringUtils.isBlank(beid)){
			beid = getBeid();
		}
		groupId = StringUtils.zhuanData(groupId);
		return basSysCodeDao.searchSysCodeByGroupIdAndCodeName(groupId, codeName,beid);
	}

	/** 
	 * 查询所有麻醉事件
	 * <功能详细描述>
	 * @return
	 * @see [类、类#方法、类#成员]
	 */
	public List<AnaesEventFormBean> searchAnaesEvent(SystemSearchFormBean systemSearchFormBean) {
	    if (StringUtils.isEmpty(systemSearchFormBean.getBeid())) {
	        systemSearchFormBean.setBeid(getBeid());
        }
		if(StringUtils.isEmpty(systemSearchFormBean.getSort())){
			systemSearchFormBean.setSort("`order`");
		}
		if(StringUtils.isEmpty(systemSearchFormBean.getOrderBy())){
			systemSearchFormBean.setOrderBy("ASC");
		}
		String filter = getSysFilter(systemSearchFormBean);
		return basSysCodeDao.searchAnaesEvent(filter, systemSearchFormBean);
	}

	public Integer searchAnaesEventTotal(SystemSearchFormBean systemSearchFormBean) {
	    if (StringUtils.isEmpty(systemSearchFormBean.getBeid())) {
	        systemSearchFormBean.setBeid(getBeid());
        }
		if(StringUtils.isEmpty(systemSearchFormBean.getSort())){
			systemSearchFormBean.setSort("`order`");
		}
		if(StringUtils.isEmpty(systemSearchFormBean.getOrderBy())){
			systemSearchFormBean.setOrderBy("ASC");
		}
		String filter = getSysFilter(systemSearchFormBean);
		return basSysCodeDao.searchAnaesEventTotal(filter, systemSearchFormBean);
	}
	
	public String getSysFilter(SystemSearchFormBean systemSearchFormBean) {
		String filter = "";
		List<Filter> filters = systemSearchFormBean.getFilters();
		if(filters!=null&&filters.size()>0){
			for(int i = 0;i<filters.size();i++){
				if(!StringUtils.isEmpty(filters.get(i).getValue().toString())){
					filter += " AND "+filters.get(i).getField() +" like '%"+filters.get(i).getValue()+"%' ";
				}
			}
		}
		return filter;
	}
	
	/** 
	 * 添加或者修改麻醉事件类型
	 * <功能详细描述>
	 * @param anaesEventFormBean
	 * @return
	 * @see [类、类#方法、类#成员]
	 */
	@Transactional
	public String updateAnaesEvent(AnaesEventFormBean anaesEventFormBean) {
		ResponseValue resp = new ResponseValue();
		String beid = getBeid();
		if (StringUtils.isNotBlank(anaesEventFormBean.getBeid())) {
			beid = anaesEventFormBean.getBeid();
		}
		if (StringUtils.isBlank(anaesEventFormBean.getSysCodeId())) {
			Integer maxCodeValue = basSysCodeDao.getMaxCodeValue(beid);
			anaesEventFormBean.setSysCodeId(GenerateSequenceUtil.generateSequenceNo());
			anaesEventFormBean.setCodeValue(String.valueOf(maxCodeValue + 1));
			Integer maxOrder = basSysCodeDao.getMaxOrder(beid);
			anaesEventFormBean.setOrder(maxOrder + 1);
			anaesEventFormBean.setGroupId("anaes_event_type");
			anaesEventFormBean.setGroupName("麻醉事件类型");
			anaesEventFormBean.setBeid(beid);
			basSysCodeDao.insertAnaesEvent(anaesEventFormBean);
			resp.setResultMessage("添加麻醉事件类型成功!");
		} else {
			basSysCodeDao.updateAnaesEvent(anaesEventFormBean);
			resp.setResultMessage("修改麻醉事件类型成功!");
		}
		return resp.getJsonStr();
	}

	/**
	 * 删除麻醉事件类型 <功能详细描述>
	 * 
	 * @param sysCodeId
	 * @return
	 * @see [类、类#方法、类#成员]
	 */
	@Transactional
	public String deleteAnaesEvent(AnaesEventFormBean anaesEventFormBean) {
		ResponseValue resp = new ResponseValue();
		SearchFormBean searchFormBean = new SearchFormBean();
		searchFormBean.setCode(anaesEventFormBean.getCodeValue());
		List<EvtAnaesEvent> anaesEventList = evtAnaesEventDao.searchAnaeseventList(searchFormBean);
		List<EvtAnaesEvent> anaesEventPacuList = evtAnaesEventDao.searchAnaeseventList(searchFormBean);

		if ((null != anaesEventList && anaesEventList.size() > 0) || (null != anaesEventPacuList && anaesEventPacuList.size() > 0)) {
			resp.setResultCode("10000000");
			resp.setResultMessage("删除麻醉事件失败，该麻醉事件已在系统中使用!");
			return resp.getJsonStr();
		}

		String sysCodeId = anaesEventFormBean.getSysCodeId();
		basSysCodeDao.deleteAnaesEvent(sysCodeId);
		resp.setResultMessage("删除麻醉事件成功!");
		return resp.getJsonStr();
	}
}
