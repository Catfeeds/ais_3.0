/*
 * DocEventBillingDao.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-03-30 Created
 */
package com.digihealth.anesthesia.doc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.digihealth.anesthesia.basedata.formbean.BaseInfoQuery;
import com.digihealth.anesthesia.basedata.formbean.SystemSearchFormBean;
import com.digihealth.anesthesia.common.persistence.CrudDao;
import com.digihealth.anesthesia.common.persistence.annotation.MyBatisDao;
import com.digihealth.anesthesia.doc.formbean.EventBillingFormBean;
import com.digihealth.anesthesia.doc.po.DocEventBilling;

@MyBatisDao
public interface DocEventBillingDao extends CrudDao<DocEventBilling>{
    int deleteByPrimaryKey(String ebId);

    int insert(DocEventBilling record);

    int insertSelective(DocEventBilling record);

    DocEventBilling selectByPrimaryKey(String ebId);

    int updateByPrimaryKeySelective(DocEventBilling record);

    int updateByPrimaryKey(DocEventBilling record);

	/**
	 * 统计手术所用药品总量及总价
	 * @param filter
	 * @param systemSearchFormBean
	 * @return
	 */
	public List<EventBillingFormBean> searchBillGroupByMedicode(@Param("filter") String filter,@Param("systemSearchFormBean") SystemSearchFormBean systemSearchFormBean, @Param("beid") String beid);
	/**
	 * 
	 * @discription 根据手术ID获取结账单信息
	 * @author liukui
	 * @created 2015-10-10 下午5:13:48
	 * @param BaseInfoQuery
	 * @return
	 */
	public List<DocEventBilling> searchEventBillingList(@Param("filter") String filter,@Param("systemSearchFormBean") SystemSearchFormBean systemSearchFormBean, @Param("beid") String beid);
	
	public Integer searchEventBillingListTotal(@Param("filter") String filter,@Param("systemSearchFormBean") SystemSearchFormBean systemSearchFormBean, @Param("beid") String beid);
	
	
	public DocEventBilling searchEventBillingById(@Param("ebId") String ebId, @Param("beid") String beid);
	
	public void deleteBilling(@Param("ebId") String ebId);
	
	public void deleteBillingByRegOptId(@Param("baseQuery") BaseInfoQuery baseQuery);
	
	public List<DocEventBilling> queryMedicaleventInBill(@Param("baseQuery") BaseInfoQuery baseQuery, @Param("beid") String beid);
	
	public List<DocEventBilling> queryIoeventInBill(@Param("baseQuery") BaseInfoQuery baseQuery, @Param("beid") String beid);
	
	public List<DocEventBilling> selectEventBillingBySource(@Param("source")String source, @Param("beid") String beid);
}