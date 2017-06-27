/**     
 * @discription 在此输入一句话描述此文件的作用
 * @author chengwang       
 * @created 2015-10-10 下午5:32:33    
 * tags     
 * see_to_target     
 */

package com.digihealth.anesthesia.doc.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.digihealth.anesthesia.basedata.formbean.BaseInfoQuery;
import com.digihealth.anesthesia.basedata.formbean.SystemSearchFormBean;
import com.digihealth.anesthesia.common.entity.ResponseValue;
import com.digihealth.anesthesia.common.service.BaseService;
import com.digihealth.anesthesia.common.utils.DateUtils;
import com.digihealth.anesthesia.common.utils.GenerateSequenceUtil;
import com.digihealth.anesthesia.doc.formbean.EventBillingFormBean;
import com.digihealth.anesthesia.doc.po.DocAnaesRecord;
import com.digihealth.anesthesia.doc.po.DocEventBilling;
import com.digihealth.anesthesia.evt.formbean.Filter;

/**
 * Title: EventBillingService.java Description: 描述
 * 
 * @author liukui
 * @created 2015-10-10 下午5:32:33
 */
@Service
public class DocEventBillingService extends BaseService {
	
	/**
	 * 统计病人药品数据及总价
	 * @param systemSearchFormBean
	 * @return
	 */
	public List<EventBillingFormBean> searchBillGroupByMedicode(SystemSearchFormBean systemSearchFormBean){	
		return docEventBillingDao.searchBillGroupByMedicode(this.getFilterStr(systemSearchFormBean,"code"),systemSearchFormBean, getBeid());
	}
	
	/**
	 * 查询药品结账单明细
	 * @param baseInfo
	 * @return
	 */
	public List<DocEventBilling> searchEventBillingList(SystemSearchFormBean systemSearchFormBean){
		return docEventBillingDao.searchEventBillingList(this.getFilterStr(systemSearchFormBean,"code"),systemSearchFormBean, getBeid());
	}
	
	/**
	 * 查询药品结账单明细总数
	 * @param baseInfo
	 * @return
	 */
	public int searchEventBillingListTotal(SystemSearchFormBean systemSearchFormBean){
		return docEventBillingDao.searchEventBillingListTotal(this.getFilterStr(systemSearchFormBean,"code"), systemSearchFormBean, getBeid());
	}
	
	public String getFilterStr(SystemSearchFormBean systemSearchFormBean,String sort){
		
		if(StringUtils.isEmpty(systemSearchFormBean.getSort())){
			systemSearchFormBean.setSort(sort);
		}
		if(StringUtils.isEmpty(systemSearchFormBean.getOrderBy())){
			systemSearchFormBean.setOrderBy("ASC");
		}
		
		String filter = "";
		List<Filter> filters = systemSearchFormBean.getFilters();
		if(filters!=null&&filters.size()>0){
			for(int i = 0;i<filters.size();i++){
				if(!StringUtils.isEmpty(filters.get(i).getValue().toString())){
					filter = filter + " AND "+filters.get(i).getField() +" like '%"+filters.get(i).getValue()+"%' ";
				}
			}
		}
		return filter;
	}
	
	/**
	 * 将药品事件表、入量事件表记录同步至billing表中
	 * @param regOptId
	 * @param userType
	 */
	@Transactional
	public void synMedicTakeInfoList(String regOptId,String userType,ResponseValue resp){
		//为了确保不重复同步数据，先删除原来同步的事件表数据,这里要区分麻醉医生、护士
		BaseInfoQuery baseInfo = new BaseInfoQuery();
		baseInfo.setRegOptId(regOptId);
		baseInfo.setUserType(userType);
		docEventBillingDao.deleteBillingByRegOptId(baseInfo);
		
		List<DocEventBilling> list = new ArrayList<DocEventBilling>();
		
		DocAnaesRecord anaesRecord = docAnaesRecordDao.searchAnaesRecordByRegOptId(regOptId);
		baseInfo.setDocId(anaesRecord.getAnaRecordId());
		
		List<DocEventBilling> medicList = docEventBillingDao.queryMedicaleventInBill(baseInfo, getBeid());
		for (DocEventBilling eventBilling : medicList) {
			eventBilling.setEbId(GenerateSequenceUtil.generateSequenceNo());
			eventBilling.setRegOptId(regOptId);
			eventBilling.setUserType(userType);
			Float newDosageTotalAmount = eventBilling.getDosageTotalAmount();
			Float newPackageTotalAmount = new Float(Math.ceil(newDosageTotalAmount.floatValue()/eventBilling.getPackageDosageAmount()));
			eventBilling.setShouldCost(eventBilling.getPriceMinPackage()*newPackageTotalAmount);
			eventBilling.setRealCost((eventBilling.getPriceMinPackage()*newPackageTotalAmount*eventBilling.getDiscount()));
			eventBilling.setPackageTotalAmount(newPackageTotalAmount);
			docEventBillingDao.insert(eventBilling);
			list.add(eventBilling);
		}
		
		List<DocEventBilling> ioevnetList = docEventBillingDao.queryIoeventInBill(baseInfo, getBeid());
		for (DocEventBilling eventBilling : ioevnetList) {
			eventBilling.setEbId(GenerateSequenceUtil.generateSequenceNo());
			eventBilling.setRegOptId(regOptId);
			eventBilling.setUserType(userType);
			Float newDosageTotalAmount = eventBilling.getDosageTotalAmount();
			Float newPackageTotalAmount = new Float(Math.ceil(newDosageTotalAmount.floatValue()/eventBilling.getPackageDosageAmount()));
			eventBilling.setShouldCost(eventBilling.getPriceMinPackage()*newPackageTotalAmount);
			eventBilling.setRealCost((eventBilling.getPriceMinPackage()*newPackageTotalAmount*eventBilling.getDiscount()));
			eventBilling.setPackageTotalAmount(newPackageTotalAmount);
			docEventBillingDao.insert(eventBilling);
			list.add(eventBilling);
		}
		//source为2表示是手工添加的
		List<DocEventBilling> sourceList = docEventBillingDao.selectEventBillingBySource("2", getBeid());
		list.addAll(sourceList);
		
		if(medicList.size()<1 && ioevnetList.size()<1){
			resp.setResultCode("1");
			resp.setResultMessage("无可同步的药品及入量信息!");
			resp.put("eventBillingList", list);
		}else{
			resp.setResultCode("1");
			resp.setResultMessage("同步术中药品及入量信息至账单数据成功!");
			resp.put("eventBillingList", list);
		}
		
	}
	
	/**
	 * 根据id、type=M选择查询药品事件明细
	 * 根据id、type=I选择查询入量事件明细
	 * @param baseInfo
	 * @return
	 */
	public List<DocEventBilling> queryMedievnetOrIoeventListById(BaseInfoQuery baseInfo){
		if("M".equals(baseInfo.getType())){
			return docEventBillingDao.queryMedicaleventInBill(baseInfo, getBeid());
		}else{
			return docEventBillingDao.queryIoeventInBill(baseInfo, getBeid());
		}
	}
	
	/**
	 * 根据id查询单挑账单信息
	 * @param baseInfo
	 * @return
	 */
	public DocEventBilling searchEventBillingList(String ebId){
		return docEventBillingDao.searchEventBillingById(ebId, getBeid());
	}
	
	/**
	 * 保存单条入账信息
	 * @param ebId
	 */
	@Transactional
	public void saveEventBilling(List<DocEventBilling> eventBillingList){
		for (DocEventBilling eventBilling : eventBillingList) {
			if(StringUtils.isNotBlank(eventBilling.getEbId())){
				docEventBillingDao.update(eventBilling);
			}else{
				eventBilling.setEbId(GenerateSequenceUtil.generateSequenceNo());
				eventBilling.setSource(2); //表示手工录入
				eventBilling.setCreateTime(new Date());
				docEventBillingDao.insert(eventBilling);
			}
		}
	}
	
	public List<DocEventBilling> selectEventBillingBySource(String source){
		return docEventBillingDao.selectEventBillingBySource(source, getBeid());
	}
	
	
	/**
	 * 删除单条入账信息
	 * @param ebId
	 */
	@Transactional
	public void deleteBilling(String ebId){
		docEventBillingDao.deleteBilling(ebId);;
	}

}
