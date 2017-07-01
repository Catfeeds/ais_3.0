package com.digihealth.anesthesia.basedata.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.digihealth.anesthesia.basedata.formbean.SystemSearchFormBean;
import com.digihealth.anesthesia.basedata.po.BasAnaesMedicineInRecord;
import com.digihealth.anesthesia.common.service.BaseService;
import com.digihealth.anesthesia.common.utils.PingYinUtil;
import com.digihealth.anesthesia.common.utils.StringUtils;
import com.digihealth.anesthesia.evt.formbean.Filter;

@Service
public class BasAnaesMedicineInRecordService extends BaseService
{

	//查询毒麻药入库信息列表
	public List<BasAnaesMedicineInRecord> queryMedicineInRecordList(SystemSearchFormBean systemSearchFormBean)
	{
		if(StringUtils.isEmpty(systemSearchFormBean.getSort())){
			systemSearchFormBean.setSort("id");
		}
		if(StringUtils.isEmpty(systemSearchFormBean.getOrderBy())){
			systemSearchFormBean.setOrderBy("DESC");
		}
		
		List<Filter> filters = systemSearchFormBean.getFilters();
		if(null == filters)
		{
			filters = new ArrayList<Filter>();
		}
		Filter filter = new Filter();
		filter.setField("beid");
		filter.setValue(getBeid());
		filters.add(filter);
		
		return basAnaesMedicineInRecordDao.queryMedicineInRecordList(filters, systemSearchFormBean);
	}
	
	//查询毒麻药入库信息数量
	public int queryMedicineInRecordListTotal(SystemSearchFormBean systemSearchFormBean)
	{
		List<Filter> filters = systemSearchFormBean.getFilters();
		return basAnaesMedicineInRecordDao.queryMedicineInRecordListTotal(filters);
	}
	
	//存储毒麻药
	@Transactional
	public void saveMedicineInRecord(BasAnaesMedicineInRecord basAnaesMedicineInRecord)
	{
		Integer id = basAnaesMedicineInRecord.getId();
		if(null == id)
		{
			basAnaesMedicineInRecord.setPinYin(PingYinUtil.getFirstSpell(basAnaesMedicineInRecord.getMedicineName()));
			basAnaesMedicineInRecord.setOperateTime(new Date());
			basAnaesMedicineInRecordDao.insertSelective(basAnaesMedicineInRecord);
		}else
		{
			basAnaesMedicineInRecord.setPinYin(PingYinUtil.getFirstSpell(basAnaesMedicineInRecord.getMedicineName()));
			basAnaesMedicineInRecordDao.updateByPrimaryKeySelective(basAnaesMedicineInRecord);
		}
	}
	
	//删除毒麻药记录
	@Transactional
	public void delMedicineInRecord(Integer id)
	{
		basAnaesMedicineInRecordDao.deleteByPrimaryKey(id);
	}
	
	//审核毒麻药
	@Transactional
	public void checkMedicineInRecord(BasAnaesMedicineInRecord basAnaesMedicineInRecord)
	{
		if(null != basAnaesMedicineInRecord)
		{
			basAnaesMedicineInRecord.setCheckTime(new Date());
			basAnaesMedicineInRecord.setStatus(1);
			basAnaesMedicineInRecordDao.updateByPrimaryKeySelective(basAnaesMedicineInRecord);
		}
		
	}
	
	//通过ID查询入库记录
	public BasAnaesMedicineInRecord selectById(Integer id)
	{
		return basAnaesMedicineInRecordDao.selectByPrimaryKey(id);
	}
	
}
