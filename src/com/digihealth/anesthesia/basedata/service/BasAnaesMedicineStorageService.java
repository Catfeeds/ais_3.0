package com.digihealth.anesthesia.basedata.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.digihealth.anesthesia.basedata.formbean.BasAnaesMedicineOutRecordFormBean;
import com.digihealth.anesthesia.basedata.formbean.BasAnaesMedicineStorageFormbean;
import com.digihealth.anesthesia.basedata.formbean.SystemSearchFormBean;
import com.digihealth.anesthesia.basedata.po.BasAnaesMedicineInRecord;
import com.digihealth.anesthesia.basedata.po.BasAnaesMedicineStorage;
import com.digihealth.anesthesia.common.entity.ResponseValue;
import com.digihealth.anesthesia.common.service.BaseService;
import com.digihealth.anesthesia.common.utils.DateUtils;
import com.digihealth.anesthesia.common.utils.PingYinUtil;
import com.digihealth.anesthesia.common.utils.StringUtils;
import com.digihealth.anesthesia.evt.formbean.Filter;

@Service
public class BasAnaesMedicineStorageService extends BaseService
{
    //将审核后的药物入库
	@Transactional
	public void saveToMedicineStorage(BasAnaesMedicineInRecord basAnaesMedicineInRecord)
	{
		//药品名字
		String medicineName = basAnaesMedicineInRecord.getMedicineName();
		//厂家
		String firm = basAnaesMedicineInRecord.getFirm();
		//规格
		String spec = basAnaesMedicineInRecord.getSpec();
		//批次
		String batch = basAnaesMedicineInRecord.getBatch();
		
		BasAnaesMedicineStorage oldBasAnaesMedicineStorage = basAnaesMedicineStorageDao.selectMedicineByMFSB(medicineName, firm, spec, batch);
		if(null == oldBasAnaesMedicineStorage)
		{
			BasAnaesMedicineStorage basAnaesMedicineStorage = new BasAnaesMedicineStorage();
			basAnaesMedicineStorage.setBatch(batch);
			basAnaesMedicineStorage.setBeid(getBeid());
			basAnaesMedicineStorage.setEffectiveTime(basAnaesMedicineInRecord.getEffectiveTime());
			basAnaesMedicineStorage.setFirm(firm);
			basAnaesMedicineStorage.setMedicineCode(basAnaesMedicineInRecord.getMedicineCode());
			basAnaesMedicineStorage.setMedicineName(medicineName);
			basAnaesMedicineStorage.setMinPackageUnit(basAnaesMedicineInRecord.getMinPackageUnit());
			basAnaesMedicineStorage.setNumber(basAnaesMedicineInRecord.getNumber());
			basAnaesMedicineStorage.setSpec(spec);
			basAnaesMedicineStorage.setPinYin(PingYinUtil.getFirstSpell(medicineName));
			basAnaesMedicineStorageDao.insertSelective(basAnaesMedicineStorage);
		}else{
			int oldNumber = oldBasAnaesMedicineStorage.getNumber();
			oldNumber += basAnaesMedicineInRecord.getNumber();
			oldBasAnaesMedicineStorage.setNumber(oldNumber);
			basAnaesMedicineStorageDao.updateByPrimaryKeySelective(oldBasAnaesMedicineStorage);
		}
		
	}
	
	
	//查询毒麻药入库信息列表,按名字，厂家，规格分组
	public List<BasAnaesMedicineStorage> queryAnaesMedicineListGroupByNFS(SystemSearchFormBean systemSearchFormBean)
	{
		if(StringUtils.isEmpty(systemSearchFormBean.getSort())){
			systemSearchFormBean.setSort("id");
		}
		if(StringUtils.isEmpty(systemSearchFormBean.getOrderBy())){
			systemSearchFormBean.setOrderBy("ASC");
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
		
		return basAnaesMedicineStorageDao.queryAnaesMedicineListGroupByNFS(filters, systemSearchFormBean);
	}
	
	//查询毒麻药入库信息数量,按名字，厂家，规格分组
	public int queryAnaesMedicineListGroupByNFSTotal(SystemSearchFormBean systemSearchFormBean)
	{
		List<Filter> filters = systemSearchFormBean.getFilters();
		return basAnaesMedicineStorageDao.queryAnaesMedicineListGroupByNFSTotal(filters);
	}
	

	//查询毒麻药入库信息列表
	public List<BasAnaesMedicineStorage> queryMedicineList(SystemSearchFormBean systemSearchFormBean)
	{
		if(StringUtils.isEmpty(systemSearchFormBean.getSort())){
			systemSearchFormBean.setSort("id");
		}
		if(StringUtils.isEmpty(systemSearchFormBean.getOrderBy())){
			systemSearchFormBean.setOrderBy("ASC");
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
		
		return basAnaesMedicineStorageDao.queryMedicineList(filters, systemSearchFormBean);
	}
	
	//查询毒麻药入库信息数量
	public int queryMedicineListTotal(SystemSearchFormBean systemSearchFormBean)
	{
		List<Filter> filters = systemSearchFormBean.getFilters();
		return basAnaesMedicineStorageDao.queryMedicineListTotal(filters);
	}
	
	//按月统计库存记录
	public List<BasAnaesMedicineStorageFormbean> queryAnaesMedicineByMonth(SystemSearchFormBean systemSearchFormBean,ResponseValue resp)
	{
		if(StringUtils.isEmpty(systemSearchFormBean.getSort())){
			systemSearchFormBean.setSort("id");
		}
		if(StringUtils.isEmpty(systemSearchFormBean.getOrderBy())){
			systemSearchFormBean.setOrderBy("ASC");
		}
		
		List<Filter> filters = systemSearchFormBean.getFilters();
		if(null == filters)
		{
			filters = new ArrayList<Filter>();
		}
		//指定的查询月份
		String queryMonth = "";
		for (Filter filter : filters)
		{
			if (filter.getField().equals("queryMonth"))
			{
				queryMonth = filter.getValue();
			}
		}
		//检查时间
		int month = Integer.parseInt(DateUtils.getMonth());
		int year = Integer.parseInt(queryMonth.substring(0, 4));
		int subMonth = Integer.parseInt(queryMonth.substring(5,7));
		if(year==Integer.parseInt(DateUtils.getYear()) && subMonth >= month)
        {
            resp.setResultCode("30000001");
         	resp.setResultMessage("查询月份没有过完，统计数据还有变动，不能进行统计！");
         	return null;
        }
		
		Filter filter = new Filter();
		filter.setField("beid");
		filter.setValue(getBeid());
		filters.add(filter);
		
		
		
		return basAnaesMedicineStorageDao.queryAnaesMedicineByMonth(filters, systemSearchFormBean,queryMonth);
	}
	
	//按月统计库存记录数量
	public int queryAnaesMedicineByMonthTotal(SystemSearchFormBean systemSearchFormBean)
	{
		List<Filter> filters = systemSearchFormBean.getFilters();
		return basAnaesMedicineStorageDao.queryAnaesMedicineByMonthTotal(filters);
	}
	
	
	//按月统计个人用药情况
	public List<BasAnaesMedicineOutRecordFormBean> queryAnaesMedicineByPersonal(SystemSearchFormBean systemSearchFormBean)
	{
		if(StringUtils.isEmpty(systemSearchFormBean.getSort())){
			systemSearchFormBean.setSort("id");
		}
		if(StringUtils.isEmpty(systemSearchFormBean.getOrderBy())){
			systemSearchFormBean.setOrderBy("ASC");
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
		
		
		return basAnaesMedicineStorageDao.queryAnaesMedicineByPersonal(filters, systemSearchFormBean);
	}
	
	//按月统计个人用药情况
	public int queryAnaesMedicineByPersonalTotal(SystemSearchFormBean systemSearchFormBean)
	{
		List<Filter> filters = systemSearchFormBean.getFilters();
		return basAnaesMedicineStorageDao.queryAnaesMedicineByPersonalTotal(filters);
	}
	
	//查询当前局点下的库存记录
	public List<BasAnaesMedicineStorage> queryAnaesMedicineStorageByBeid()
	{
		return basAnaesMedicineStorageDao.queryAnaesMedicineStorageByBeid(getBeid());
	}
}
