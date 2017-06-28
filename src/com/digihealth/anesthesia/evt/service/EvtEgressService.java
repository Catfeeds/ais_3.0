package com.digihealth.anesthesia.evt.service;

import java.util.ArrayList;
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
import com.digihealth.anesthesia.evt.formbean.RegOptOperEgressFormBean;
import com.digihealth.anesthesia.evt.formbean.SearchFormBean;
import com.digihealth.anesthesia.evt.formbean.SearchOptOperEgress;
import com.digihealth.anesthesia.evt.po.EvtEgress;

@Service
public class EvtEgressService extends BaseService {

	public List<SearchOptOperEgress> searchEgressList(SearchFormBean searchBean) {
	    if (StringUtils.isBlank(searchBean.getBeid()))
	    {
	        searchBean.setBeid(getBeid());
	    }
		return evtEgressDao.searchEgressList(searchBean);
	}

	public List<RegOptOperEgressFormBean> searchEgressGroupByDefIdList(SearchFormBean searchBean) {
	    if (StringUtils.isBlank(searchBean.getBeid()))
        {
            searchBean.setBeid(getBeid());
        }
	    
		// 将相同药品的数据重新封装
		List<RegOptOperEgressFormBean> resultList = evtEgressDao.searchEgressGroupByDefIdList(searchBean);
		RegOptOperEgressFormBean bean = null;
		if (null != resultList && resultList.size() > 0) {
			for (int i = 0; i < resultList.size(); i++) {
				RegOptOperEgressFormBean regOptOperEgressFormBean = resultList.get(i);
				// 出量事件
				String name = regOptOperEgressFormBean.getName();
				if (name.equals("其他")) {
					bean = regOptOperEgressFormBean;
					// resultList.remove(regOptOperEgressFormBean); //移除为其他的数据
					continue;
				}
				searchBean.setCode(regOptOperEgressFormBean.getIoDefId().toString());
				regOptOperEgressFormBean.setEgressList(evtEgressDao.searchEgressList(searchBean));
			}
		}
		resultList.remove(bean);
		
		/*for (RegOptOperEgressFormBean regOptOperEgressFormBean : resultList) { // 出量事件
			String name = regOptOperEgressFormBean.getName();
		
			if (name.equals("其他")) {
				bean = regOptOperEgressFormBean;
				resultList.remove(regOptOperEgressFormBean); // 移除为其他的数据 continue; }
				searchBean.setCode(regOptOperEgressFormBean.getIoDefId().toString());
				regOptOperEgressFormBean.setEgressList(evtEgressDao.searchEgressList(searchBean));
			}
		}*/
		 
		if (null != bean) {
			SearchFormBean sb = new SearchFormBean();
			String docId = searchBean.getDocId();
			String ioDefId = bean.getIoDefId().toString();
			sb.setDocId(docId);
			sb.setCode(ioDefId);
			List<SearchOptOperEgress> searchEgressList = evtEgressDao.searchEgressList(sb);
			List<SearchOptOperEgress> egressList = null;
			RegOptOperEgressFormBean b = null;
			if (null != searchEgressList && searchEgressList.size() > 0) {
				for (SearchOptOperEgress searchOptOperEgress : searchEgressList) {
					b = new RegOptOperEgressFormBean();
					b.setName(searchOptOperEgress.getEgressName());
					b.setIoDefId(bean.getIoDefId());
					b.setUnit(bean.getUnit());
					egressList = new ArrayList<SearchOptOperEgress>();
					egressList.add(searchOptOperEgress);
					b.setEgressList(egressList);
					resultList.add(b);
				}
			}
		}
		return resultList;
	}

	public List<EvtEgress> queryEgressListById(SearchFormBean searchBean) {
		return evtEgressDao.queryEgressListById(searchBean);
	}

	public Integer getEgressCountValueByIoDef(String ioDefId, String docId) {
		return evtEgressDao.getEgressCountValueByIoDef(ioDefId, docId);
	}

	@Transactional
	public void saveEgress(EvtEgress egress) {
		DocAnaesRecord anaesRecord = docAnaesRecordDao.searchAnaesRecordById(egress.getDocId());
		if (StringUtils.isNotBlank(egress.getEgressId())) {
			evtEgressDao.updateByPrimaryKeySelective(egress);
		} else {
			egress.setEgressId(GenerateSequenceUtil.generateSequenceNo());
			evtEgressDao.insert(egress);
		}
		LogUtils.saveOperateLog(anaesRecord.getRegOptId(), LogUtils.OPT_TYPE_INFO_SAVE, LogUtils.OPT_MODULE_INTERFACE, "术中人员出量事件保存", JsonType.jsonType(egress), UserUtils.getUserCache(), getBeid());
	}

	/**
	 * 新增出量事件
	 * 
	 * @param Anaesevent
	 */
	@Transactional
	public void insertEgress(EvtEgress egress) {
		egress.setEgressId(GenerateSequenceUtil.generateSequenceNo());
		evtEgressDao.insert(egress);
	}

	/**
	 * 修改出量事件
	 * 
	 * @param Anaesevent
	 */
	@Transactional
	public void updateEgress(EvtEgress egress) {
		evtEgressDao.updateByPrimaryKeySelective(egress);
	}

	/**
	 * 删除出入量事件
	 * 
	 * @param Egress
	 */
	@Transactional
	public void deleteEgress(EvtEgress egress) {
		evtEgressDao.deleteByPrimaryKey(egress.getEgressId());
	}

	
}
