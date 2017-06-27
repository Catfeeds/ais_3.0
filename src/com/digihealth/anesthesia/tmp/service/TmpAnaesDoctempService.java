package com.digihealth.anesthesia.tmp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.druid.util.StringUtils;
import com.digihealth.anesthesia.basedata.formbean.SearchDoctempFormBean;
import com.digihealth.anesthesia.common.service.BaseService;
import com.digihealth.anesthesia.common.utils.GenerateSequenceUtil;
import com.digihealth.anesthesia.common.utils.PingYinUtil;
import com.digihealth.anesthesia.evt.formbean.Filter;
import com.digihealth.anesthesia.tmp.po.TmpAnaesDoctemp;

@Service
public class TmpAnaesDoctempService  extends BaseService {
     /**
      * 根据条件查询模板信息
      */
	public List<TmpAnaesDoctemp>  selectAnaesDoctempByForbean(SearchDoctempFormBean searchDoctempFormBean) {
		List<TmpAnaesDoctemp> anaesDoctempList = new ArrayList<TmpAnaesDoctemp>();
		if(StringUtils.isEmpty(searchDoctempFormBean.getSort())){
		    searchDoctempFormBean.setSort("id");
		}
		if(StringUtils.isEmpty(searchDoctempFormBean.getOrderBy())){
		    searchDoctempFormBean.setOrderBy("ASC");
		}
		List<Filter> filters = searchDoctempFormBean.getFilters();
		anaesDoctempList = tmpAnaesDoctempDao.selectAnaesDoctempByForbean(filters,searchDoctempFormBean);
		return anaesDoctempList;
	}
	
	public int selectAnaesDoctempTotalByForbean(SearchDoctempFormBean searchDoctempFormBean) {
	    List<Filter> filters = searchDoctempFormBean.getFilters();
		return tmpAnaesDoctempDao.selectAnaesDoctempTotalByForbean(filters,searchDoctempFormBean);
	}
	
	@Transactional
	public void addAnaesDoctemp(TmpAnaesDoctemp anaesDoctemp) {
		String medTempName = anaesDoctemp.getMedTempName();
		String pinyin = PingYinUtil.getFirstSpell(medTempName);
		anaesDoctemp.setPinYin(pinyin);
		if(org.apache.commons.lang.StringUtils.isNotBlank(anaesDoctemp.getId())) { 
			tmpAnaesDoctempDao.updateByPrimaryKeySelective(anaesDoctemp);
		}else {
			anaesDoctemp.setId(GenerateSequenceUtil.generateSequenceNo());
			tmpAnaesDoctempDao.insertSelective(anaesDoctemp);
		}
	}
	
	@Transactional
	public void delAnaesDoctemp(String id) {
		tmpAnaesDoctempDao.deleteByPrimaryKey(id);
	}
}
