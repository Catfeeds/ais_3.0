package com.digihealth.anesthesia.basedata.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.digihealth.anesthesia.basedata.formbean.BasMedicineRegOptFormBean;
import com.digihealth.anesthesia.basedata.formbean.SystemSearchFormBean;
import com.digihealth.anesthesia.basedata.po.BasAnaesMedicineLoseRecord;
import com.digihealth.anesthesia.basedata.po.BasAnaesMedicineOutRecord;
import com.digihealth.anesthesia.basedata.po.BasAnaesMedicineRetreatRecord;
import com.digihealth.anesthesia.basedata.po.BasAnaesMedicineStorage;
import com.digihealth.anesthesia.basedata.po.BasRegOpt;
import com.digihealth.anesthesia.common.entity.ResponseValue;
import com.digihealth.anesthesia.common.service.BaseService;
import com.digihealth.anesthesia.common.utils.PingYinUtil;
import com.digihealth.anesthesia.common.utils.StringUtils;
import com.digihealth.anesthesia.evt.formbean.Filter;

@Service
public class BasAnaesMedicineOutRecordService extends BaseService
{
    //新增取药记录
	@Transactional
	public void addAnaesMedicineOutRecord(BasAnaesMedicineOutRecord basAnaesMedicineOutRecord,ResponseValue resp)
	{
		Integer storageId = basAnaesMedicineOutRecord.getStorageId();
		int outNumber = basAnaesMedicineOutRecord.getOutNumber();
		BasAnaesMedicineStorage basAnaesMedicineStorage = basAnaesMedicineStorageDao.selectByPrimaryKey(storageId);
		if(null != basAnaesMedicineStorage)
		{
			int number = basAnaesMedicineStorage.getNumber();
			if(outNumber>number)
			{
				resp.setResultCode("10000002");
	            resp.setResultMessage("取药的数量不能大于库存的数量");
			}else
			{
				String outType = basAnaesMedicineOutRecord.getOutType();
				String regOptId = basAnaesMedicineOutRecord.getRegOptId();
				basAnaesMedicineOutRecord.setActualNumber(outNumber);
				basAnaesMedicineOutRecord.setOutTime(new Date());
				basAnaesMedicineOutRecord.setPinYin(PingYinUtil.getFirstSpell(basAnaesMedicineOutRecord.getMedicineName()));
				basAnaesMedicineOutRecordDao.insertSelective(basAnaesMedicineOutRecord);
				//如果是手术取药，更新手术信息表outMedicine字段
				if("2".equals(outType))
				{
					BasRegOpt basRegOpt = basRegOptDao.searchRegOptById(regOptId);
					basRegOpt.setOutMedicine(1);
					basRegOptDao.updateByPrimaryKeySelective(basRegOpt);
				}
				
				//更新取药记录表
				basAnaesMedicineStorage.setNumber(number-outNumber);
				basAnaesMedicineStorageDao.updateByPrimaryKeySelective(basAnaesMedicineStorage);
			}
		}else
		{
			resp.setResultCode("10000003");
            resp.setResultMessage("传输的库存记录不存在！");
		}
	}
	
	//查询毒麻药取药记录列表
	public List<BasAnaesMedicineOutRecord>  queryMedicineOutRecordList(SystemSearchFormBean systemSearchFormBean)
	{
		if (StringUtils.isEmpty(systemSearchFormBean.getSort()))
		{
			systemSearchFormBean.setSort("id");
		}
		if (StringUtils.isEmpty(systemSearchFormBean.getOrderBy()))
		{
			systemSearchFormBean.setOrderBy("DESC");
		}

		List<Filter> filters = systemSearchFormBean.getFilters();
		if (null == filters)
		{
			filters = new ArrayList<Filter>();
		}
		Filter filter = new Filter();
		filter.setField("beid");
		filter.setValue(getBeid());
		filters.add(filter);

		return basAnaesMedicineOutRecordDao.queryMedicineOutRecordList(filters, systemSearchFormBean);
	}

	// 查询毒麻药取药记录数量
	public int queryMedicineOutRecordListTotal(
			SystemSearchFormBean systemSearchFormBean)
	{
		List<Filter> filters = systemSearchFormBean.getFilters();
		return basAnaesMedicineOutRecordDao.queryMedicineOutRecordListTotal(filters);
	}
	
	//增加毒麻药退药记录
	public void addMedicineRetreatRecord(BasAnaesMedicineRetreatRecord basAnaesMedicineRetreatRecord,ResponseValue resp)
	{
		//取得取药记录id
		int outRecordId = basAnaesMedicineRetreatRecord.getOutRecordId();
		int retreatNumber = basAnaesMedicineRetreatRecord.getRetreatNumber();
		//通过取药记录id获得取药记录信息
		BasAnaesMedicineOutRecord basAnaesMedicineOutRecord = basAnaesMedicineOutRecordDao.selectByPrimaryKey(outRecordId);
		if(null != basAnaesMedicineOutRecord)
		{
			int actualNumber = basAnaesMedicineOutRecord.getActualNumber();
			if(retreatNumber>actualNumber)
			{
				resp.setResultCode("10000002");
	            resp.setResultMessage("退药的数量不能大于取药的实际数量");
			}else
			{
				//退药记录存入数据库
				basAnaesMedicineRetreatRecord.setRetreatTime(new Date());
				basAnaesMedicineRetreatRecordDao.insertSelective(basAnaesMedicineRetreatRecord);
				//将取药记录进行更新。更新退药数量和实际数量
				int outReteatNum = basAnaesMedicineOutRecord.getRetreatNumber();
				basAnaesMedicineOutRecord.setRetreatNumber(outReteatNum + retreatNumber);
				basAnaesMedicineOutRecord.setActualNumber(actualNumber - retreatNumber);
				basAnaesMedicineOutRecordDao.updateByPrimaryKeySelective(basAnaesMedicineOutRecord);
				
				int storageId = basAnaesMedicineOutRecord.getStorageId();
				BasAnaesMedicineStorage basAnaesMedicineStorage = basAnaesMedicineStorageDao.selectByPrimaryKey(storageId);
				if(null != basAnaesMedicineStorage)
				{
					int number = basAnaesMedicineStorage.getNumber();
					basAnaesMedicineStorage.setNumber(number + retreatNumber);
					basAnaesMedicineStorageDao.updateByPrimaryKeySelective(basAnaesMedicineStorage);
				}
			}
		}else
		{
			resp.setResultCode("10000003");
            resp.setResultMessage("传输的取药记录不存在！");
		}
	}
	
	//增加报损记录
	public void addMedicineLoseRecord(BasAnaesMedicineLoseRecord basAnaesMedicineLoseRecord,ResponseValue resp)
	{
		//报损类型
		String loseType = basAnaesMedicineLoseRecord.getLoseType();
		int loseNumber = basAnaesMedicineLoseRecord.getLoseNumber();
		//类型为普通报损和手术报损
		if("1".equals(loseType) || "2".equals(loseType))
		{
			// 取得取药记录id
			int outRecordId = basAnaesMedicineLoseRecord.getOutRecordId();
			// 通过取药记录id获得取药记录信息
			BasAnaesMedicineOutRecord basAnaesMedicineOutRecord = basAnaesMedicineOutRecordDao.selectByPrimaryKey(outRecordId);
			if (null != basAnaesMedicineOutRecord)
			{
				int actualNumber = basAnaesMedicineOutRecord.getActualNumber();
				if (loseNumber > actualNumber)
				{
					resp.setResultCode("10000002");
					resp.setResultMessage("报损的数量不能大于取药的实际数量");
				} else
				{
					// 报损记录存入数据库
					basAnaesMedicineLoseRecord.setLoseTime(new Date());
					basAnaesMedicineLoseRecordDao.insertSelective(basAnaesMedicineLoseRecord);
					// 将取药记录进行更新。更新退药数量和实际数量
					int outLoseNum = basAnaesMedicineOutRecord.getLoseNumber();
					basAnaesMedicineOutRecord.setLoseNumber(outLoseNum + loseNumber);
					basAnaesMedicineOutRecord.setActualNumber(actualNumber - loseNumber);
					basAnaesMedicineOutRecordDao.updateByPrimaryKeySelective(basAnaesMedicineOutRecord);
				}
			} else
			{
				resp.setResultCode("10000003");
				resp.setResultMessage("传输的取药记录不存在！");
			}
		}else if("3".equals(loseType))//清单报损
		{
			int storageId = basAnaesMedicineLoseRecord.getStorageId();
			BasAnaesMedicineStorage basAnaesMedicineStorage = basAnaesMedicineStorageDao.selectByPrimaryKey(storageId);
			if(null != basAnaesMedicineStorage)
			{
				//库存剩余数量
				int storageNum = basAnaesMedicineStorage.getNumber();
				if(loseNumber > storageNum)
				{
					resp.setResultCode("10000006");
					resp.setResultMessage("清单报损，报损数量不能大于存在剩余数量！");
				}else
				{
					// 报损记录存入数据库
					basAnaesMedicineLoseRecord.setLoseTime(new Date());
					basAnaesMedicineLoseRecordDao.insertSelective(basAnaesMedicineLoseRecord);
					//更新库存记录
					basAnaesMedicineStorage.setNumber(storageNum - loseNumber );
					basAnaesMedicineStorageDao.updateByPrimaryKeySelective(basAnaesMedicineStorage);
				}
				
			}else
			{
				resp.setResultCode("10000005");
				resp.setResultMessage("清单报损，库存ID传输错误，没有这个库存记录！");
			}
		}else
		{
			resp.setResultCode("10000004");
			resp.setResultMessage("报损类型错误！");
		}
		
	}
	
	//查询手术信息
	public List<BasMedicineRegOptFormBean> selectRegOptInfoForOutRecordList(SystemSearchFormBean systemSearchFormBean)
	{
		if (StringUtils.isEmpty(systemSearchFormBean.getSort()))
		{
			systemSearchFormBean.setSort("regOptId");
		}
		if (StringUtils.isEmpty(systemSearchFormBean.getOrderBy()))
		{
			systemSearchFormBean.setOrderBy("ASC");
		}

		List<Filter> filters = systemSearchFormBean.getFilters();
		if (null == filters)
		{
			filters = new ArrayList<Filter>();
		}
		Filter filter = new Filter();
		filter.setField("beid");
		filter.setValue(getBeid());
		filters.add(filter);
		
		return basAnaesMedicineOutRecordDao.selectRegOptInfoForOutRecordList(filters, systemSearchFormBean);
	}
	//查询查询手术信息数量
	public int selectRegOptInfoForOutRecordListTotal(SystemSearchFormBean systemSearchFormBean)
	{
		List<Filter> filters = systemSearchFormBean.getFilters();
		return basAnaesMedicineOutRecordDao.selectRegOptInfoForOutRecordListTotal(filters);
	}
	
	//删除退药记录
	public void delMedicineRetreatRecord(Integer id,ResponseValue resp)
	{
		BasAnaesMedicineRetreatRecord basAnaesMedicineRetreatRecord = basAnaesMedicineRetreatRecordDao.selectByPrimaryKey(id);
		if(null != basAnaesMedicineRetreatRecord)
		{
			int retreatNumber = basAnaesMedicineRetreatRecord.getRetreatNumber();
			basAnaesMedicineRetreatRecordDao.deleteByPrimaryKey(id);
			
			int outRecordId = basAnaesMedicineRetreatRecord.getOutRecordId();
			BasAnaesMedicineOutRecord basAnaesMedicineOutRecord = basAnaesMedicineOutRecordDao.selectByPrimaryKey(outRecordId);
			if(null != basAnaesMedicineOutRecord)
			{
				int oldRetreatNum = basAnaesMedicineOutRecord.getRetreatNumber();
				int oldActualNum = basAnaesMedicineOutRecord.getActualNumber();
				basAnaesMedicineOutRecord.setRetreatNumber(oldRetreatNum - retreatNumber);
				basAnaesMedicineOutRecord.setActualNumber(oldActualNum + retreatNumber);
				basAnaesMedicineOutRecordDao.updateByPrimaryKeySelective(basAnaesMedicineOutRecord);
				
				int storageId = basAnaesMedicineOutRecord.getStorageId();
				BasAnaesMedicineStorage basAnaesMedicineStorage = basAnaesMedicineStorageDao.selectByPrimaryKey(storageId);
				if(null != basAnaesMedicineStorage)
				{
					int number = basAnaesMedicineStorage.getNumber();
					basAnaesMedicineStorage.setNumber(number - retreatNumber);
					basAnaesMedicineStorageDao.updateByPrimaryKeySelective(basAnaesMedicineStorage);
				}
			}
		}else
		{
			resp.setResultCode("10000002");
			resp.setResultMessage("退药记录不存在！");
		}
	}
	
	//删除报损记录
	public void delMedicineLoseRecord(Integer id,ResponseValue resp)
	{
		BasAnaesMedicineLoseRecord basAnaesMedicineLoseRecord = basAnaesMedicineLoseRecordDao.selectByPrimaryKey(id);
		if(null != basAnaesMedicineLoseRecord)
		{
			int loseNumber = basAnaesMedicineLoseRecord.getLoseNumber();
			basAnaesMedicineLoseRecordDao.deleteByPrimaryKey(id);
				
			int outRecordId = basAnaesMedicineLoseRecord.getOutRecordId();
			BasAnaesMedicineOutRecord basAnaesMedicineOutRecord = basAnaesMedicineOutRecordDao.selectByPrimaryKey(outRecordId);
			if(null != basAnaesMedicineOutRecord)
			{
				int oldloseNum = basAnaesMedicineOutRecord.getLoseNumber();
				int oldActualNum =basAnaesMedicineOutRecord.getActualNumber();
				basAnaesMedicineOutRecord.setLoseNumber(oldloseNum - loseNumber);
				basAnaesMedicineOutRecord.setActualNumber(oldActualNum + loseNumber);
				basAnaesMedicineOutRecordDao.updateByPrimaryKeySelective(basAnaesMedicineOutRecord);
			}
		}
		else
		{
			resp.setResultCode("10000002");
			resp.setResultMessage("报损记录不存在！");
		}
	}
	
	//逻辑删除取药记录
	public void delMedicineOutRecord(Integer id,ResponseValue resp)
	{
		BasAnaesMedicineOutRecord basAnaesMedicineOutRecord = basAnaesMedicineOutRecordDao.selectByPrimaryKey(id);
		if(null != basAnaesMedicineOutRecord)
		{
			
			int actualNumber = basAnaesMedicineOutRecord.getActualNumber();
			int loseNumber = basAnaesMedicineOutRecord.getLoseNumber();
			basAnaesMedicineOutRecord.setEnable(0);
			basAnaesMedicineOutRecordDao.updateByPrimaryKeySelective(basAnaesMedicineOutRecord);
			
			//存储记录恢复
			Integer storageId = basAnaesMedicineOutRecord.getStorageId();
			BasAnaesMedicineStorage basAnaesMedicineStorage = basAnaesMedicineStorageDao.selectByPrimaryKey(storageId);
			if(null != basAnaesMedicineStorage)
			{
				int number = basAnaesMedicineStorage.getNumber();
				basAnaesMedicineStorage.setNumber(number + actualNumber + loseNumber);
				basAnaesMedicineStorageDao.updateByPrimaryKeySelective(basAnaesMedicineStorage);
			}
			
			//退药记录逻辑删除
			basAnaesMedicineRetreatRecordDao.updateEnableByOutRecordId(id);
			//报损记录逻辑删除
			basAnaesMedicineLoseRecordDao.updateEnableByOutRecordId(id);
			
		}else
		{
			resp.setResultCode("10000002");
			resp.setResultMessage("取药记录不存在！");
		}
	}
	
}
