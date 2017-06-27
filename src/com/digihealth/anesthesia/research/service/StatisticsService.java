/**
 * 
 */
package com.digihealth.anesthesia.research.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.digihealth.anesthesia.basedata.formbean.BaseInfoQuery;
import com.digihealth.anesthesia.basedata.formbean.DocumentStateFormbean;
import com.digihealth.anesthesia.basedata.formbean.SystemSearchFormBean;
import com.digihealth.anesthesia.basedata.po.BasAnaesMethod;
import com.digihealth.anesthesia.basedata.po.BasDocument;
import com.digihealth.anesthesia.common.service.BaseService;
import com.digihealth.anesthesia.doc.po.DocEventBilling;
import com.digihealth.anesthesia.doc.po.DocPackagesItem;
import com.digihealth.anesthesia.evt.formbean.Filter;
import com.digihealth.anesthesia.evt.formbean.SearchConditionFormBean;
import com.digihealth.anesthesia.evt.formbean.SearchFormBean;
import com.digihealth.anesthesia.evt.po.EvtParticipant;
import com.digihealth.anesthesia.evt.po.EvtRealAnaesMethod;
import com.digihealth.anesthesia.evt.service.EvtParticipantService;
import com.digihealth.anesthesia.research.formbean.AnaesCntByAnaesMethod;
import com.digihealth.anesthesia.research.formbean.AnaesDocObserveTimeCount;
import com.digihealth.anesthesia.research.formbean.AnaesDocumentStateCountFormbean;
import com.digihealth.anesthesia.research.formbean.DocStateListFormbean;
import com.digihealth.anesthesia.research.formbean.HomeAnaesDoctorWorkingTimeFormBean;
import com.digihealth.anesthesia.research.formbean.MedIoChargeFormBean;
import com.digihealth.anesthesia.research.formbean.ResearchAnalysisList;
import com.digihealth.anesthesia.research.formbean.SearchAnaesRegInfo;
import com.digihealth.anesthesia.research.formbean.SearchAnesTypeFormBean;
import com.digihealth.anesthesia.research.formbean.SearchBadEventInfo;
import com.digihealth.anesthesia.research.formbean.SearchDeptOperatCountBySteward;
import com.digihealth.anesthesia.research.formbean.SearchMedicineType;
import com.digihealth.anesthesia.research.formbean.SearchOperByASALevel;
import com.digihealth.anesthesia.research.formbean.SearchOperByDept;
import com.digihealth.anesthesia.research.formbean.SearchOperByNurse;
import com.digihealth.anesthesia.research.formbean.SearchOperByOperator;
import com.digihealth.anesthesia.research.formbean.SearchOperFormBean;
import com.digihealth.anesthesia.research.formbean.SearchRegionOperatCompdiag;
import com.digihealth.anesthesia.research.formbean.SearchRegionOperatCountByAsalev;
import com.digihealth.anesthesia.research.formbean.SearchRegionOperatCountByOptlev;
import com.digihealth.anesthesia.research.formbean.SearchStewardScoFormBean;
import com.digihealth.anesthesia.research.formbean.StaticAnaesDocCountByAnalgesic;
import com.digihealth.anesthesia.research.formbean.StaticDeptCountByAnalgesic;
import com.digihealth.anesthesia.research.formbean.WorkingTimeFormBean;
import com.digihealth.anesthesia.sysMng.po.BasUser;

/**
 * @author ChengW
 *
 */
@Service
@Transactional
public class StatisticsService extends BaseService{
	
	String json = "{";
	
	
	public List statisAnaesOptNum(String startTime,String endTime,String state){
		return statisticsDao.statisAnaesOptNum(startTime,endTime,state, getBeid());
	}
	
	public List<WorkingTimeFormBean> searchWorkingTime(String startTime,String endTime,int loginName){
		
		return statisticsDao.searchWorkingTime(startTime, endTime, loginName, getBeid());
	}
	
	public List<WorkingTimeFormBean> searchAnaesDoctorWorkingTime(String startTime,String endTime,String loginName, String beid){
			
			return statisticsDao.searchAnaesDoctorWorkingTime(startTime, endTime, loginName, beid);
		}
	
	public List<WorkingTimeFormBean> searchNurseQmWorkingTime(String startTime,String endTime,String loginName, String beid){
		
		return statisticsDao.searchNurseQmWorkingTime(startTime, endTime, loginName, beid);
	}
	
	public List<WorkingTimeFormBean> searchNurseJmWorkingTime(String startTime,String endTime,String loginName, String beid){
		
		return statisticsDao.searchNurseJmWorkingTime(startTime, endTime, loginName, beid);
	}
	
	public List<WorkingTimeFormBean> searchConsultationTime(String startTime,String endTime,String loginName, String beid){
		
		return statisticsDao.searchConsultationTime(startTime, endTime, loginName, beid);
	}
	
	public List<SearchMedicineType> searchMedicineGroupMedicineId( String startTime,
			String endTime){
		return statisticsDao.searchMedicineGroupMedicineId(startTime, endTime);
		
	}
	
	public List<SearchMedicineType> searchMedicineByUser(String startTime,
			String endTime,String loginName){
		return statisticsDao.searchMedicineByUser(startTime, endTime, loginName);
	}
	
	public List<BasAnaesMethod> searchRealMed(String startTime,
			String endTime){
		return statisticsDao.searchRealMed(startTime, endTime, getBeid());
	}
	
	
	@Transactional
	public String updateMedIoCharge(MedIoChargeFormBean medIoChargeFormBean){
		
		List<DocEventBilling> medList = medIoChargeFormBean.getMedList();
		List<DocEventBilling> ioList = medIoChargeFormBean.getIoList();
		List<DocPackagesItem> packagesCharge = medIoChargeFormBean.getPackagesCharge();
		List<DocPackagesItem> charge = medIoChargeFormBean.getCharge();
		
		if(medList!=null && medList.size()>0){
			for(int i = 0 ; i < medList.size();i++){
				if(StringUtils.isNotBlank(medList.get(i).getEbId())){
					DocEventBilling eventBilling = docEventBillingDao.searchEventBillingById(medList.get(i).getEbId(), getBeid());
					eventBilling.setDiscount(medList.get(i).getDiscount());
					eventBilling.setIsCharged(medList.get(i).getIsCharged());
					docEventBillingDao.update(eventBilling);
				}
			}
			
		}
		
		if(ioList!=null && ioList.size()>0){
			for(int i = 0 ; i < ioList.size();i++){
				if(StringUtils.isNotBlank(ioList.get(i).getEbId())){
					DocEventBilling eventBilling = docEventBillingDao.searchEventBillingById(ioList.get(i).getEbId(), getBeid());
					eventBilling.setDiscount(ioList.get(i).getDiscount());
					eventBilling.setIsCharged(ioList.get(i).getIsCharged());
					docEventBillingDao.update(eventBilling);
				}
			}
			
		}
		
		if(packagesCharge!=null && packagesCharge.size()>0){
			for(int i = 0 ; i < packagesCharge.size();i++){
				if(StringUtils.isNotBlank(packagesCharge.get(i).getPkItId())){
					DocPackagesItem packagesItem = docPackagesItemDao.searchPackagesItemById(packagesCharge.get(i).getPkItId());
					packagesItem.setDiscount(packagesCharge.get(i).getDiscount());
					packagesItem.setIsCharge(packagesCharge.get(i).getIsCharge());
					packagesItem.setChargeAmount(packagesCharge.get(i).getChargeAmount());
					docPackagesItemDao.update(packagesItem);
				}
			}
			
		}
		
		if(charge!=null && charge.size()>0){
			for(int i = 0 ; i < charge.size();i++){
				if(StringUtils.isNotBlank(charge.get(i).getPkItId())){
					DocPackagesItem packagesItem = docPackagesItemDao.searchPackagesItemById(charge.get(i).getPkItId());
					packagesItem.setDiscount(charge.get(i).getDiscount());
					packagesItem.setIsCharge(charge.get(i).getIsCharge());
					packagesItem.setChargeAmount(charge.get(i).getChargeAmount());
					docPackagesItemDao.update(packagesItem);
				}
			}
			
		}
		
		return "更新成功!";
	}

	public List<SearchRegionOperatCountByOptlev>  searchRegionOperatCountByOptlev(SearchFormBean searchFormBean){
		return statisticsDao.searchRegionOperatCountByOptlev(searchFormBean);
	}
	
	public List<SearchRegionOperatCountByAsalev>  searchRegionOperatCountByAsalev(SearchFormBean searchFormBean){
		return statisticsDao.searchRegionOperatCountByAsalev(searchFormBean);
	}
	
	public List<SearchRegionOperatCompdiag> searchRegionOperatCompdiag(SearchFormBean searchFormBean){
		if (StringUtils.isBlank(searchFormBean.getBeid())) {
			searchFormBean.setBeid(getBeid());
		}
		return statisticsDao.searchRegionOperatCompdiag(searchFormBean);
	}
	
	public List<SearchBadEventInfo> searchBadEventInfoList(SearchFormBean searchBean){
		List<SearchBadEventInfo>  list =  statisticsDao.searchBadEventInfoList(searchBean, getBeid());
		for (SearchBadEventInfo searchBadEventInfo : list) {
			searchBean.setDocId(searchBadEventInfo.getDocId());
			//麻醉方法
			String anaesMethod = this.getAnaesMethodName(searchBean);
			searchBadEventInfo.setAnaesMethod(anaesMethod);
			//麻醉医生列表
			searchBean.setRole(EvtParticipantService.ROLE_ANESTH);
			String anaesDoc = this.getNameStrByDocId(searchBean);
			searchBadEventInfo.setAnaesDoc(anaesDoc);
			//手术医生列表
			searchBean.setRole(EvtParticipantService.ROLE_OPERAT);
			String operatDoc = this.getNameStrByDocId(searchBean);
			searchBadEventInfo.setOperateDoc(operatDoc);
			String badEventReson = "";
			if("true".equals(searchBadEventInfo.getLapseReason())){
				badEventReson += basSysCodeDao.searchSysCodeByGroupIdAndCodeValue("lapse_reason", "1", getBeid()).get(0).getCodeName()+",";
			}
			if("true".equals(searchBadEventInfo.getSurgeryReason())){
				badEventReson += basSysCodeDao.searchSysCodeByGroupIdAndCodeValue("surgery_reason", "1", getBeid()).get(0).getCodeName()+",";
			}
			if("true".equals(searchBadEventInfo.getTechnologyReason())){
				badEventReson += basSysCodeDao.searchSysCodeByGroupIdAndCodeValue("technology_reason", "1", getBeid()).get(0).getCodeName()+",";
			}
			badEventReson = badEventReson.substring(0, badEventReson.length()-1);
			searchBadEventInfo.setBadEventReson(badEventReson);
		}
		return list;
	}
	
	
	public String getAnaesMethodName(SearchFormBean searchBean){
		List<EvtRealAnaesMethod>  list = evtRealAnaesMethodDao.searchRealAnaesMethodList(searchBean);
		String realStr = "";
		for (EvtRealAnaesMethod realAnaesMethod : list) {
			realStr += realAnaesMethod.getName();
		}
		if(realStr.length()>0)
			realStr = realStr.substring(0, realStr.length()-1);
		return realStr;
	}
	
	
	public String getNameStrByDocId(SearchFormBean searchBean){
		String anaesDoc = "";
		List<EvtParticipant> anesDocList = evtParticipantDao.searchParticipantList(searchBean, getBeid());
		for (EvtParticipant participant : anesDocList) {
			anaesDoc += participant.getName()+",";
		}
		if(anaesDoc.length()>0)
			anaesDoc = anaesDoc.substring(0, anaesDoc.length()-1);
		return anaesDoc;
	}
	
	
	public List<AnaesDocObserveTimeCount> countAnaesDocUpdateObserveTime(SearchFormBean searchFormBean){
		if (StringUtils.isBlank(searchFormBean.getBeid())) {
			searchFormBean.setBeid(getBeid());
		}
		return statisticsDao.countAnaesDocUpdateObserveTime(searchFormBean);
	}
	   
	public String selectSql(String sql,List<ResearchAnalysisList> filters,String abbreviation){
		for(int i = 0;i<filters.size();i++){
			ResearchAnalysisList selectBean = filters.get(i);
			if("equal".equals(selectBean.getType())){
				if(!StringUtils.isEmpty(selectBean.getValue())){
					
					if("emergency".equals(selectBean.getName())){
						if("1".equals(selectBean.getValue())){
							json = json + "\""+selectBean.getName()+"\":"+"\"急诊\",";
						}else{
							json = json + "\""+selectBean.getName()+"\":"+"\"择期\",";
						}
					}else{
						json = json + "\""+selectBean.getName()+"\":"+"\""+selectBean.getValue()+selectBean.getUnit()+"\",";
					}
					
						sql = sql + " AND "+abbreviation+"."+com.digihealth.anesthesia.common.utils.StringUtils.zhuanData(selectBean.getName())+"='"+selectBean.getValue()+"' ";
						
					
					
				}
			}
			if("between".equals(selectBean.getType())){
				if((!StringUtils.isEmpty(selectBean.getBt1()))||(!StringUtils.isEmpty(selectBean.getBt2()))){
					if(selectBean.getName().equals("age")){
						sql = sql +(StringUtils.isEmpty(selectBean.getBt1())?"":" AND (IFNULL("+abbreviation+"."+"age,0)*365+IFNULL("+abbreviation+"."+"age_mon,0)*31+IFNULL("+abbreviation+"."+"age_day,0))>='"+(Integer.parseInt(selectBean.getBt1())*365)+"' ")+(StringUtils.isEmpty(selectBean.getBt2())?"":" and (IFNULL("+abbreviation+"."+"age,0)*365+IFNULL("+abbreviation+"."+"age_mon,0)*31+IFNULL("+abbreviation+"."+"age_day,0))<='"+(Integer.parseInt(selectBean.getBt2())*365)+"' ");
					}else{
						sql = sql +(StringUtils.isEmpty(selectBean.getBt1())?"":" AND "+abbreviation+"."+com.digihealth.anesthesia.common.utils.StringUtils.zhuanData(selectBean.getName())+">='"+selectBean.getBt1()+"' ")+(StringUtils.isEmpty(selectBean.getBt2())?"":" and "+abbreviation+"."+com.digihealth.anesthesia.common.utils.StringUtils.zhuanData(selectBean.getName())+"<='"+selectBean.getBt2()+"' ");
					}
					json = json + "\""+selectBean.getName()+"\":"+"\""+selectBean.getBt1()+selectBean.getUnit()+"~"+selectBean.getBt2()+selectBean.getUnit()+"\",";
				}
			}
			if("array".equals(selectBean.getType())){
				List list = selectBean.getArray();
				if(list !=null && list.size()>0){
					json = json + "\""+selectBean.getName()+"\":"+"\"";
					sql = sql + " AND (";
					for(int j = 0;j<list.size();j++){
						Map<String,Object> b = (Map) list.get(j);
						for(Map.Entry<String,Object> m:b.entrySet()){
							if(m.getValue() instanceof Integer){ 
								if(j == 0){
									sql = sql + "("+abbreviation+"." + com.digihealth.anesthesia.common.utils.StringUtils.zhuanData(selectBean.getName()) + " like '%,"+m.getValue()+"%' or "+abbreviation+"."+com.digihealth.anesthesia.common.utils.StringUtils.zhuanData(selectBean.getName())+" like '%"+m.getValue()+",%' or "+abbreviation+"."+com.digihealth.anesthesia.common.utils.StringUtils.zhuanData(selectBean.getName())+"='"+m.getValue()+"' or "+abbreviation+"."+com.digihealth.anesthesia.common.utils.StringUtils.zhuanData(selectBean.getName()) +" like '%,"+m.getValue()+",%' ) ";
										
								}else{
									sql = sql + " or (" +abbreviation+"."+ com.digihealth.anesthesia.common.utils.StringUtils.zhuanData(selectBean.getName()) + " like '%,"+m.getValue()+"%' or "+abbreviation+"."+com.digihealth.anesthesia.common.utils.StringUtils.zhuanData(selectBean.getName())+" like '%"+m.getValue()+",%' or "+abbreviation+"."+com.digihealth.anesthesia.common.utils.StringUtils.zhuanData(selectBean.getName())+"='"+m.getValue()+"' or "+abbreviation+"."+com.digihealth.anesthesia.common.utils.StringUtils.zhuanData(selectBean.getName()) +" like '%,"+m.getValue()+",%' ) ";
									
								}
							}
							if(m.getKey().equals("name")){
								json = json + m.getValue()+",";
							}
						}
					}
					sql = sql + " ) ";
					json = json +"\",";
				}
			}
		}
		return sql+";";
	}
	
	public String selectMedicineSql(String sql,List<ResearchAnalysisList> filters,String abbreviation,int medicineType){
		for(int i = 0;i<filters.size();i++){
			ResearchAnalysisList selectBean = filters.get(i);
			if("equal".equals(selectBean.getType())){
				if(!StringUtils.isEmpty(selectBean.getValue())){
					json = json + "\""+selectBean.getName()+"\":"+"\""+selectBean.getValue()+selectBean.getUnit()+"\",";
					sql = sql + " AND "+abbreviation+"."+com.digihealth.anesthesia.common.utils.StringUtils.zhuanData(selectBean.getName())+"='"+selectBean.getValue()+"' ";
					
				}
			}
			if("between".equals(selectBean.getType())){
				if((!StringUtils.isEmpty(selectBean.getBt1()))||(!StringUtils.isEmpty(selectBean.getBt2()))){
					sql = sql +(StringUtils.isEmpty(selectBean.getBt1())?"":" AND "+abbreviation+"."+com.digihealth.anesthesia.common.utils.StringUtils.zhuanData(selectBean.getName())+">='"+selectBean.getBt1()+"' ")+(StringUtils.isEmpty(selectBean.getBt2())?"":" and "+abbreviation+"."+com.digihealth.anesthesia.common.utils.StringUtils.zhuanData(selectBean.getName())+"<='"+selectBean.getBt2()+"' ");
					json = json + "\""+selectBean.getName()+"\":"+"\""+selectBean.getBt1()+selectBean.getUnit()+"~"+selectBean.getBt2()+selectBean.getUnit()+"\",";
				}
			}
			if("array".equals(selectBean.getType())){
				List list = selectBean.getArray();
				if(list !=null && list.size()>0){
					if(medicineType == 1){
						json = json + "\"mazuiMedicine\":"+"\"";
					}else if(medicineType == 2){
						json = json + "\"zhiliaoMedicine\":"+"\"";
					}
					
					sql = sql + " AND (";
					for(int j = 0;j<list.size();j++){
						Map<String,Object> b = (Map) list.get(j);
						for(Map.Entry<String,Object> m:b.entrySet()){
							if(m.getKey().equals("medicineId")){ 
								if(j == 0){
									sql = sql + "("+abbreviation+"." + com.digihealth.anesthesia.common.utils.StringUtils.zhuanData(selectBean.getName()) + " like '%,"+m.getValue()+"%' or "+abbreviation+"."+com.digihealth.anesthesia.common.utils.StringUtils.zhuanData(selectBean.getName())+" like '%"+m.getValue()+",%' or "+abbreviation+"."+com.digihealth.anesthesia.common.utils.StringUtils.zhuanData(selectBean.getName())+"='"+m.getValue()+"' or "+abbreviation+"."+com.digihealth.anesthesia.common.utils.StringUtils.zhuanData(selectBean.getName()) +" like '%,"+m.getValue()+",%' ) ";
										
								}else{
									sql = sql + " or (" +abbreviation+"."+ com.digihealth.anesthesia.common.utils.StringUtils.zhuanData(selectBean.getName()) + " like '%,"+m.getValue()+"%' or "+abbreviation+"."+com.digihealth.anesthesia.common.utils.StringUtils.zhuanData(selectBean.getName())+" like '%"+m.getValue()+",%' or "+abbreviation+"."+com.digihealth.anesthesia.common.utils.StringUtils.zhuanData(selectBean.getName())+"='"+m.getValue()+"' or "+abbreviation+"."+com.digihealth.anesthesia.common.utils.StringUtils.zhuanData(selectBean.getName()) +" like '%,"+m.getValue()+",%' ) ";
									
								}
							}
							if(m.getKey().equals("name")){
								json = json + m.getValue()+",";
							}
						}
					}
					sql = sql + " ) ";
					json = json +"\",";
				}
			}
		}
		return sql+";";
	}
	
	
	
	
	
	

	/**
	 * 麻醉科麻醉例数统计
	 * 
	 * @param searchFormBean
	 * @return
	 */
	public List<SearchAnesTypeFormBean> searchAnaesMethodByDept(
			SearchFormBean searchFormBean) {
		List<SearchAnesTypeFormBean> resultList = new ArrayList<SearchAnesTypeFormBean>();
		SearchAnesTypeFormBean sum = new SearchAnesTypeFormBean();
		sum.setTotalNum(0);
		sum.setAvgTime(0.0f);

		searchFormBean.setType("0");
		SearchAnesTypeFormBean spinalVo = statisticsDao.countAnesNumByAnesType(searchFormBean); // 椎管内全麻
		spinalVo.setAnesType("椎管内全麻");
		resultList.add(spinalVo);
		sum.setTotalNum(sum.getTotalNum() + spinalVo.getTotalNum());
		sum.setAvgTime(sum.getAvgTime() + spinalVo.getAvgTime());

		searchFormBean.setType("1");
		SearchAnesTypeFormBean intubatVo = statisticsDao.countAnesNumByAnesType(searchFormBean); // 插管全麻
		intubatVo.setAnesType("插管全麻");
		resultList.add(intubatVo);
		sum.setTotalNum(sum.getTotalNum() + intubatVo.getTotalNum());
		sum.setAvgTime(sum.getAvgTime() + intubatVo.getAvgTime());

		searchFormBean.setType("2");
		SearchAnesTypeFormBean nonIntubatVo = statisticsDao.countAnesNumByAnesType(searchFormBean); // 非插管全麻
		nonIntubatVo.setAnesType("非插管全麻");
		resultList.add(nonIntubatVo);
		sum.setTotalNum(sum.getTotalNum() + nonIntubatVo.getTotalNum());
		sum.setAvgTime(sum.getAvgTime() + nonIntubatVo.getAvgTime());

		SearchAnesTypeFormBean compositeVo = statisticsDao.countAnesNumByWihtAnesType(searchFormBean); // 复合全麻
		compositeVo.setAnesType("复合麻醉");
		resultList.add(compositeVo);
		sum.setTotalNum(sum.getTotalNum() + compositeVo.getTotalNum());
		sum.setAvgTime(sum.getAvgTime() + compositeVo.getAvgTime());

		searchFormBean.setType("3");
		SearchAnesTypeFormBean otherVo = statisticsDao.countAnesNumByOtherAnesType(searchFormBean);
		; // 其他麻醉方式
		otherVo.setAnesType("其他麻醉方式");
		resultList.add(otherVo);

		sum.setTotalNum(sum.getTotalNum() + otherVo.getTotalNum());
		sum.setAvgTime(sum.getAvgTime() + otherVo.getAvgTime());
		sum.setAnesType("总计");
		resultList.add(sum);
		return resultList;
	}
	
	public List<SearchAnaesRegInfo> searchAnaesRegInfoList(SystemSearchFormBean searchFormBean) {
		if (StringUtils.isBlank(searchFormBean.getBeid())) {
			searchFormBean.setBeid(getBeid());
		}
		if(StringUtils.isBlank(searchFormBean.getSort())){
			searchFormBean.setSort("operaDate");
		}
		if(StringUtils.isBlank(searchFormBean.getOrderBy())){
			searchFormBean.setOrderBy("DESC");
		}
		List<Filter> filters = searchFormBean.getFilters();
		if(filters.size()==0){
			filters = new ArrayList<Filter>();
		}
		return statisticsDao.searchAnaesRegInfoList(searchFormBean,filters);
	}
	
	public Integer searchTotalByAnaesRegInfoList(SystemSearchFormBean searchFormBean) {
		List<Filter> filters = searchFormBean.getFilters();
		if(filters.size()==0){
			filters = new ArrayList<Filter>();
		}
		return statisticsDao.searchTotalByAnaesRegInfoList(filters, getBeid());
	}
	
	
	public List<AnaesDocObserveTimeCount> searchPatGroupByDept(SystemSearchFormBean searchFormBean){
		if(StringUtils.isBlank(searchFormBean.getBeid())) {
			searchFormBean.setBeid(getBeid());
		}
		List<Filter> filters = searchFormBean.getFilters();
		if(filters.size()==0){
			filters = new ArrayList<Filter>();
		}
		return statisticsDao.searchPatGroupByDept(filters, searchFormBean.getBeid());
	}
	
	public List<AnaesDocObserveTimeCount> searchPatGroupByAnaesDoc(SystemSearchFormBean searchFormBean){
		List<Filter> filters = searchFormBean.getFilters();
		if(filters.size()==0){
			filters = new ArrayList<Filter>();
		}
		return statisticsDao.searchPatGroupByAnaesDoc(filters, getBeid());
	}
	
	public List<SearchDeptOperatCountBySteward> searchDeptOperatCountBySteward(SearchFormBean searchBean){
		return statisticsDao.searchDeptOperatCountBySteward(searchBean);
	}
	
	public List<StaticDeptCountByAnalgesic> searchDeptCountByAnalgesic(SearchFormBean searchBean){
		return statisticsDao.searchDeptCountByAnalgesic(searchBean);
	}
	
	public List<StaticAnaesDocCountByAnalgesic> searchAnaecDocCountByAnalgesic(SearchFormBean searchBean){
		return statisticsDao.searchAnaecDocCountByAnalgesic(searchBean);
	}
	
	public List<AnaesCntByAnaesMethod> getDeptAnaesCntGroupByAnaesMethod(SearchFormBean searchFormBean){
		return statisticsDao.getDeptAnaesCntGroupByAnaesMethod(searchFormBean);
	}
	
	public List<AnaesCntByAnaesMethod> getAnaesDocAnaesCntGroupByAnaesMethod(SearchFormBean searchFormBean){
		return statisticsDao.getAnaesDocAnaesCntGroupByAnaesMethod(searchFormBean);
	}
	
	public List<SearchAnaesRegInfo> searchAnalgesicRegInfoList(SystemSearchFormBean searchFormBean) {
		if(StringUtils.isBlank(searchFormBean.getBeid())){
			searchFormBean.setBeid(getBeid());
		}
		if(StringUtils.isBlank(searchFormBean.getSort())){
			searchFormBean.setSort("operaDate");
		}
		if(StringUtils.isBlank(searchFormBean.getOrderBy())){
			searchFormBean.setOrderBy("DESC");
		}
		List<Filter> filters = searchFormBean.getFilters();
		if(filters.size()==0){
			filters = new ArrayList<Filter>();
		}
		return statisticsDao.searchAnalgesicRegInfoList(searchFormBean,filters);
	}
	
	public Integer searchTotalAnalgesicRegInfoList(SystemSearchFormBean searchFormBean) {
		List<Filter> filters = searchFormBean.getFilters();
		if(filters.size()==0){
			filters = new ArrayList<Filter>();
		}
		if(StringUtils.isBlank(searchFormBean.getBeid())){
			searchFormBean.setBeid(getBeid());
		}
		return statisticsDao.searchTotalAnalgesicRegInfoList(searchFormBean, filters);
	}
	
	public List<AnaesDocumentStateCountFormbean> countAnaesDocDocumentCondition(SearchConditionFormBean searchConditionFormBean){
		
		BaseInfoQuery baseQuery = new BaseInfoQuery();
		baseQuery.setUserType("ANAES_DOCTOR");
		List<BasUser> anaesDocList = basUserDao.getUserList(baseQuery);
		
		List<AnaesDocumentStateCountFormbean> resultList = new ArrayList<AnaesDocumentStateCountFormbean>();
		String beid = null;
		if(StringUtils.isBlank(searchConditionFormBean.getBeid())){
			beid = getBeid();
			searchConditionFormBean.setBeid(beid);
		}else{
			beid = searchConditionFormBean.getBeid();
		}
		if(anaesDocList.size()>0){
			//List<BasMenu> menuList = basMenuDao.searchDocumentMenu(anaesDocList.get(0).getRoleId(), searchConditionFormBean.getOptType());
			List<BasDocument> documentList = basDocumentDao.searchDocument(anaesDocList.get(0).getRoleId(), "06", beid);
			for (BasUser user : anaesDocList) {
				List<DocStateListFormbean> docStatList = new ArrayList<DocStateListFormbean>();
				for(int j = 0;j<documentList.size();j++){
					BasDocument document = documentList.get(j);
					String sql = "select processState as state,COUNT(1) total from "+document.getTable()+" x where "
							+ "	regOptId in (select b.regOptId from bas_dispatch b,bas_reg_opt t where b.regOptId=t.regOptId and t.beid = '" +beid +"' and b.anesthetistId ='"+user.getUserName()+"'"
									+ " AND t.operaDate >= '"+searchConditionFormBean.getStartTime()+"'"
									+ " and t.operaDate <= '"+searchConditionFormBean.getEndTime()+"'"
									+ " ) group by processState";
					 
					List<DocumentStateFormbean> stateList = basRegOptDao.queryDocState(sql);
					DocStateListFormbean doc = new DocStateListFormbean();
					doc.setDocName(document.getName());
					doc.setDocId(document.getDocId());
					doc.setUserId(user.getUserName());
					if(stateList.size()>0){
						for (DocumentStateFormbean documentStateFormbean : stateList) {
							if (documentStateFormbean.getState().equals("NO_END")) {
								doc.setUnfinishedTotal(documentStateFormbean.getTotal());
							}
							if (documentStateFormbean.getState().equals("END")) {
								doc.setEndTotal(documentStateFormbean.getTotal());
							}
						}
					}
					if(doc.getEndTotal()==null){
						doc.setEndTotal(0);
					}
					if(doc.getUnfinishedTotal()==null){
						doc.setUnfinishedTotal(0);
					}
					docStatList.add(doc);
				}
				AnaesDocumentStateCountFormbean formbean = new AnaesDocumentStateCountFormbean();
				formbean.setId(user.getUserName());
				formbean.setName(user.getName());
				formbean.setDocStateList(docStatList);
				
				resultList.add(formbean);
			}
		}
		return resultList;
	}
	
	public List<SearchStewardScoFormBean> searchStewardScoByPacu(SearchFormBean searchFormBean){
		if(StringUtils.isBlank(searchFormBean.getBeid())) {
			searchFormBean.setBeid(getBeid());
		}
		List<String> timeList = this.getTimeList(searchFormBean);
		List<SearchStewardScoFormBean> list = new ArrayList<SearchStewardScoFormBean>();
		Integer pacuTotal = 0;
		Integer stewardTotal = 0;
		for (String dt : timeList) {
			SearchStewardScoFormBean formbean = new SearchStewardScoFormBean();
			formbean.setEnterTime(dt);
			formbean.setPacuTotal(statisticsDao.searchEntryPacuPatCount(dt, searchFormBean.getBeid()));
			pacuTotal += formbean.getPacuTotal();
			formbean.setStewardTotal(statisticsDao.searchStewardScoCount(dt, searchFormBean.getBeid()));
			stewardTotal += formbean.getStewardTotal();
			list.add(formbean);
		}
		SearchStewardScoFormBean formbean = new SearchStewardScoFormBean();
		formbean.setEnterTime("总计");
		formbean.setPacuTotal(pacuTotal);
		formbean.setStewardTotal(stewardTotal);
		list.add(formbean);
		return list;
	}

	public List<String> getTimeList(SearchFormBean searchFormBean) {
		// 搜索条件，开始时间和结束时间
		String startTime = searchFormBean.getStartTime();
		String endTime = searchFormBean.getEndTime();
		String sYear = startTime.substring(0, 4);
		String eYear = endTime.substring(0, 4);
		String sMonth = startTime.substring(5, 7);
		String eMonth = endTime.substring(5, 7);

		String[] time = new String[(Integer.parseInt(eYear) - Integer
				.parseInt(sYear))
				* 12
				- Integer.parseInt(sMonth)
				+ Integer.parseInt(eMonth) + 1];
		int smonth = 0;
		int syear = 0;

		List<String> sdata = new ArrayList<String>();

		for (int i = 0; i < time.length; i++) {
			if (i == 0) {
				smonth = Integer.parseInt(sMonth);
				syear = Integer.parseInt(sYear);
			}
			String month = smonth > 9 ? smonth + "" : "0" + smonth;
			if (smonth == 13) {
				syear = syear + 1;
				smonth = 1;
				time[i] = (syear + "-" + month).replace("-13", "-01");
			} else {
				time[i] = syear + "-" + month;
			}
			sdata.add(time[i]);
			smonth++;
		}
		return sdata;
	}
	
    public List<SearchOperByDept> searchOperByDept(SearchFormBean searchBean) {
    	if (StringUtils.isBlank(searchBean.getBeid())) {
    		searchBean.setBeid(getBeid());
		}
        return statisticsDao.searchOperByDept(searchBean);
    }
    
    public List<SearchOperByOperator> searchOperByOperator(SearchFormBean searchBean) {
        return statisticsDao.searchOperByOperator(searchBean);
    }
	
    public List<SearchOperByOperator> searchOperatorJMWorkingTime(SearchFormBean searchBean) {
        return statisticsDao.searchOperatorJMWorkingTime(searchBean);
    }
    
    public List<SearchOperByOperator> searchOperatorQMWorkingTime(SearchFormBean searchBean) {
        return statisticsDao.searchOperatorQMWorkingTime(searchBean);
    }
    
    public SearchOperByNurse searchOperByNurse(SearchFormBean searchBean) {
        return statisticsDao.searchOperByNurse(searchBean);
    }
    
    public SearchOperByNurse searchNurseJMWorkingTime(SearchFormBean searchBean) {
        return statisticsDao.searchNurseJMWorkingTime(searchBean);
    }
    
    public SearchOperByNurse searchNurseQMWorkingTime(SearchFormBean searchBean) {
        return statisticsDao.searchNurseQMWorkingTime(searchBean);
    }
    
    public List<SearchOperByASALevel> searchOperByASALevel(SearchFormBean searchBean) {
    	if (StringUtils.isBlank(searchBean.getBeid())) {
    		searchBean.setBeid(getBeid());
		}
        return statisticsDao.searchOperByASALevel(searchBean);
    }
    
    public Integer searchOperByAnalgesic(SearchFormBean searchBean) {
    	if (StringUtils.isBlank(searchBean.getBeid())) {
    		searchBean.setBeid(getBeid());
		}
        return statisticsDao.searchOperByAnalgesic(searchBean);
    }
    
    public Integer searchOperByOperSource(SearchFormBean searchBean) {
    	if (StringUtils.isBlank(searchBean.getBeid())) {
    		searchBean.setBeid(getBeid());
		}
        return statisticsDao.searchOperByOperSource(searchBean);
    }
    
    /**
     * 
         * @discription 主麻醉医生和巡台麻醉医生工作时长
         * @author chengwang       
         * @created 2016年11月17日 下午3:12:54     
         * @param startTime
         * @param endTime
         * @return
     */
    public List<HomeAnaesDoctorWorkingTimeFormBean> searchHomeAnaesDoctorWorkingTime(String startTime,
			String endTime,String loginName){
    	return statisticsDao.searchHomeAnaesDoctorWorkingTime(startTime, endTime,loginName, getBeid());
    }
    
    /**
     * 一段时间内所有的手术的工作时长。
     * @param startTime
     * @param endTime
     * @param loginName
     * @return
     */
    public List<HomeAnaesDoctorWorkingTimeFormBean> searchAllHomeAnaesDoctorWorkingTime(String startTime,
			String endTime,String loginName){
    	return statisticsDao.searchAllHomeAnaesDoctorWorkingTime(startTime, endTime,loginName, getBeid());
    }
    
    /**
     * 
         * @discription 麻醉医生交接班工作时长
         * @author chengwang       
         * @created 2016年11月17日 下午3:12:54     
         * @param startTime
         * @param endTime
         * @return
     */
    public List<HomeAnaesDoctorWorkingTimeFormBean> searchHomeAnaesDoctorShiftWorkingTime(String startTime,
			String endTime){
    	return statisticsDao.searchHomeAnaesDoctorShiftWorkingTime(startTime, endTime, getBeid());
    }
    
    /**
     * 首页护士工作量 全麻
     * @param startTime
     * @param endTime
     * @param loginName
     * @return
     */
    public List<WorkingTimeFormBean> searchNhNurseQmWorkingTime(String startTime,
			 String endTime,String loginName){
    	return statisticsDao.searchLgNurseQmWorkingTime(startTime, endTime, loginName);
    }
    
    /**
     * 首页护士工作量 局麻
     * @param startTime
     * @param endTime
     * @param loginName
     * @return
     */
    public List<WorkingTimeFormBean> searchNhNurseJmWorkingTime(String startTime,
			 String endTime,String loginName){
    	return statisticsDao.searchLgNurseJmWorkingTime(startTime, endTime, loginName);
    }
    
    public Integer searchHomeQMTimes(String startTime,String endTime,String loginName) {
	    return statisticsDao.searchHomeQMTimes(startTime, endTime, loginName);
	}
    
    public Integer searchHomeNurseJMTimes(String startTime,String endTime,String loginName) {
	    return statisticsDao.searchHomeNurseJMTimes(startTime, endTime, loginName);
	}
    
    public int searchOperByCPRNum(SearchFormBean searchFormBean){
		return statisticsDao.searchOperByCPRNum(searchFormBean);
	}

	public List<SearchOperFormBean> searchOutpatientOperateList(SearchFormBean searchBean){
		if (StringUtils.isBlank(searchBean.getBeid())) {
			searchBean.setBeid(getBeid());
		}
		return statisticsDao.searchOutpatientOperateList(searchBean);
	}

	public int queryTotalAnaesRegDetailList(SearchConditionFormBean searchFormBean){
		return statisticsDao.queryTotalAnaesRegDetailList(this.getFilters(searchFormBean), getBeid());
	}

	public List<SearchAnaesRegInfo> queryAnaesRegDetailList(
			SearchConditionFormBean searchFormBean) {
		if (StringUtils.isBlank(searchFormBean.getBeid())) {
			searchFormBean.setBeid(getBeid());
		}
		if (StringUtils.isBlank(searchFormBean.getSort())) {
			searchFormBean.setSort("operaDate");
		}
		if (StringUtils.isBlank(searchFormBean.getOrderBy())) {
			searchFormBean.setOrderBy("DESC");
		}
		return statisticsDao.queryAnaesRegDetailList(searchFormBean, this.getFilters(searchFormBean));
	}

	public List<SearchAnaesRegInfo> queryOperateDetailByDept(SearchConditionFormBean searchFormBean) {
		if (StringUtils.isBlank(searchFormBean.getBeid())) {
			searchFormBean.setBeid(getBeid());
		}
		if (StringUtils.isBlank(searchFormBean.getSort())) {
			searchFormBean.setSort("operaDate");
		}
		if (StringUtils.isBlank(searchFormBean.getOrderBy())) {
			searchFormBean.setOrderBy("DESC");
		}
		return statisticsDao.queryOperateDetailByDept(searchFormBean, this.getFilters(searchFormBean));
	}
	
	public int queryOperateDetailByDeptTotal(SearchConditionFormBean searchFormBean){
		if (StringUtils.isBlank(searchFormBean.getBeid())) {
			searchFormBean.setBeid(getBeid());
		}
		return statisticsDao.queryOperateDetailByDeptTotal(searchFormBean, this.getFilters(searchFormBean));
	}

	public List<SearchOperFormBean> queryComplicationPatient(SearchFormBean searchFormBean) {
	    return statisticsDao.searchOperByCondition(searchFormBean);
	}

	public int searchHospitalKeyOperationNum(SearchFormBean searchFormBean) {
		if (StringUtils.isBlank(searchFormBean.getBeid())) {
			searchFormBean.setBeid(getBeid());
		}
		return statisticsDao.searchHospitalKeyOperationNum(searchFormBean);
	}

	public int searchDeathNum(SearchFormBean searchFormBean) {
		if (StringUtils.isBlank(searchFormBean.getBeid())) {
			searchFormBean.setBeid(getBeid());
		}
		return statisticsDao.searchDeathNum(searchFormBean);
	}
	
	public List<Filter> getFilters(SearchConditionFormBean searchFormBean){
		List<Filter> filters = new ArrayList<Filter>();
		Filter f1 = new Filter();
		f1.setField("startTime");
		f1.setValue(searchFormBean.getStartTime());
		filters.add(f1);
		Filter f2 = new Filter();
		f2.setField("endTime");
		f2.setValue(searchFormBean.getEndTime());
		filters.add(f2);
		
		Filter ff = null;
		if(com.digihealth.anesthesia.common.utils.StringUtils.isNotBlank(searchFormBean.getDeptId())){
			ff= new Filter();
			ff.setField("deptId");
			ff.setValue(searchFormBean.getDeptId());
			filters.add(ff);
		}
		if(com.digihealth.anesthesia.common.utils.StringUtils.isNotBlank(searchFormBean.getOperatorId())){
			ff= new Filter();
			ff.setField("operatorId");
			ff.setValue(searchFormBean.getOperatorId());
			filters.add(ff);
		}
		return filters;
	}
}
