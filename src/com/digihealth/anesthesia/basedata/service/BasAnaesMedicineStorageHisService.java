package com.digihealth.anesthesia.basedata.service;

import org.springframework.transaction.annotation.Transactional;

import com.digihealth.anesthesia.basedata.po.BasAnaesMedicineStorageHis;
import com.digihealth.anesthesia.common.service.BaseService;

public class BasAnaesMedicineStorageHisService extends BaseService
{
   //把月末库存剩余记录写到表里
   @Transactional
   public void saveBasAnaesMedicineStorageHis(BasAnaesMedicineStorageHis basAnaesMedicineStorageHis)
   {
	   basAnaesMedicineStorageHisDao.insertSelective(basAnaesMedicineStorageHis);
   }
}
