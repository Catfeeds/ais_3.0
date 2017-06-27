package com.digihealth.anesthesia.tmp.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.digihealth.anesthesia.basedata.formbean.BaseInfoQuery;
import com.digihealth.anesthesia.basedata.po.BasRegOpt;
import com.digihealth.anesthesia.basedata.utils.UserUtils;
import com.digihealth.anesthesia.common.service.BaseService;
import com.digihealth.anesthesia.common.utils.JsonType;
import com.digihealth.anesthesia.common.utils.StringUtils;
import com.digihealth.anesthesia.doc.po.DocAnaesRecord;
import com.digihealth.anesthesia.doc.po.DocAnaesSummary;
import com.digihealth.anesthesia.doc.po.DocAnalgesicRecord;
import com.digihealth.anesthesia.doc.po.DocOptNurseRecord;
import com.digihealth.anesthesia.evt.formbean.AmountFormbean;
import com.digihealth.anesthesia.evt.formbean.EvtAnaesMethodFormBean;
import com.digihealth.anesthesia.evt.formbean.RegOptOperMedicaleventFormBean;
import com.digihealth.anesthesia.evt.formbean.SearchFormBean;
import com.digihealth.anesthesia.evt.po.EvtAnaesEvent;
import com.digihealth.anesthesia.evt.po.EvtOptRealOper;
import com.digihealth.anesthesia.operProceed.formbean.BasAnaesMonitorConfigFormBean;
import com.digihealth.anesthesia.operProceed.formbean.LegendData;
import com.digihealth.anesthesia.operProceed.po.BasMonitorDisplay;
import com.digihealth.anesthesia.research.formbean.LifeSignFormBean;
import com.digihealth.anesthesia.research.formbean.LifeSignObserveFormBean;
import com.digihealth.anesthesia.research.formbean.LifeSignSeriesData;
import com.digihealth.anesthesia.research.formbean.LifeSignXAxis1Data;
import com.digihealth.anesthesia.research.formbean.LifeSignYAxisData;
import com.digihealth.anesthesia.research.formbean.SciArray;
import com.digihealth.anesthesia.research.formbean.SciCompareFormbean;
import com.digihealth.anesthesia.research.formbean.SciResearchFilter;
import com.digihealth.anesthesia.research.formbean.SciResearchFormBean;
import com.digihealth.anesthesia.research.formbean.SearchAnaesRegInfo;
import com.digihealth.anesthesia.tmp.po.TmpSciResearchField;

@Service
public class TmpSciResearchFieldService extends BaseService{
	
	/**
	 * 获取所有的查询条件
	 * @return
	 */
	public List<TmpSciResearchField> getAllField(){
		return tmpSciResearchFieldDao.getAllField();
	}
	
	public String getBetweenSql(String column,SciArray sciArray){
		String btSql = " group by docId  HAVING 1 = 1 ";
		if(sciArray.getMin()!=null){
			btSql +=	" and sum("+column+") >= " + sciArray.getMin();
		}
		if(sciArray.getMax()!=null){
			btSql +=	" and sum("+column+") <= " + sciArray.getMax();
		}
		return btSql;
	}
	
	/**
	 * 普通的between拼接
	 * @param column
	 * @param sciArray
	 * @return
	 */
	public String getNormalBetweenSql(String column,SciResearchFilter filter){
		String btSql = "";
		String andQuotes = "operaDate";
		if(andQuotes.contains(column)){
			if(StringUtils.isNotBlank(filter.getBt1())){
				btSql += column+" >= '" + filter.getBt1()+"'";
			}
			if(StringUtils.isNotBlank(filter.getBt2())){
				if(StringUtils.isNotBlank(filter.getBt1())){
					btSql += " and "+column+" <= '" + filter.getBt2()+"'";
				}else{
					btSql += column+" <= '" + filter.getBt2()+"'";
				}
			}
		}else{
			if(StringUtils.isNotBlank(filter.getBt1())){
				btSql += column+" >= " + filter.getBt1();
			}
			if(StringUtils.isNotBlank(filter.getBt2())){
				if(StringUtils.isNotBlank(filter.getBt1())){
					btSql += " and "+column+" <= " + filter.getBt2();
				}else{
					btSql += column+" <= " + filter.getBt2();
				}
			}
		}
		return btSql;
	}
	
	public String getNormalBetweenSql(String column,SciArray sciArray){
		String btSql = "";
		
		if(sciArray.getMin()!=null){
			btSql += column+" >= " + sciArray.getMin();
		}
		if(sciArray.getMax()!=null){
			if(sciArray.getMin()!=null){
				btSql += " and "+column+" <= " + sciArray.getMax();
			}else{
				btSql += column+" <= " + sciArray.getMax();
			}
		}
		return btSql;
	}
	
	
	@Transactional
	public List<SearchAnaesRegInfo> changeResearchAnalysisTemp(SciResearchFormBean bean){
		
		StringBuffer sqlBuff = new StringBuffer();
		sqlBuff.append("select DISTINCT a.regOptId,a.isLocalAnaes,operaDate,name,sex,age,ageMon,ageDay,hid,regionName,deptName,bed,designedOptName,designedAnaesMethodName "
				+ "From bas_reg_opt a,doc_anaes_record b ");
		
		StringBuffer sqlWhere = new StringBuffer();
		
		sqlWhere.append(" where  a.regOptId = b.regOptId and a.state in ('06','07')");
		
		String sql = "";
		if(bean.getRegOptFilters()!=null && bean.getRegOptFilters().size()>0){
			List<SciResearchFilter> ls  = bean.getRegOptFilters();
			
			for (SciResearchFilter filter : ls) {
				
				if(filter.getArray().size()>0){
					sql += " and ";
					List<SciArray> array = filter.getArray();
					if(array.size()>1){
						sql += "( ";
					}
					int k = 0;
					for (SciArray sciArray : array) {
						if(array.size()>1 && k!=array.size()-1){
							sql +=" FIND_IN_SET("+sciArray.getValue()+",a."+sciArray.getField()+")"+" "+ filter.getAndor();
						}else{
							sql +=" FIND_IN_SET("+sciArray.getValue()+",a."+sciArray.getField()+")";
						}
						k++;
					}
					if(array.size()>1){
						sql += ") ";
					}	
					
				}else{
					sql += " and ( ";
					
					if(filter.getName().equals("age")){
						filter.setName("(IFNULL(a.`age`,0)*365+IFNULL(a.`ageMon`,0)*30+IFNULL(a.`ageDay`,0))");
					}
					if(filter.getType().equals("equal")){
						sql += filter.getName()  +" = '" + filter.getValue()+"'" ;
					}
					if(filter.getType().equals("between")){
						sql += getNormalBetweenSql(filter.getName(), filter) ;
					}
					sql+=" ) ";
				}
			}
			
		}
		
		if(bean.getAnaesRecordFilters()!=null && bean.getAnaesRecordFilters().size()>0){
			List<SciResearchFilter> ls  = bean.getAnaesRecordFilters();
			
			for (SciResearchFilter filter : ls) {
				
				if(filter.getArray().size()>0){
					sql += " and ";
					List<SciArray> array = filter.getArray();
					if(array.size()>1){
						sql += "( ";
					}
					int k = 0;
					for (SciArray sciArray : array) {
						if(filter.getName().equals("optBody")){
							if(array.size()>1 && k!=array.size()-1){
								sql +=" FIND_IN_SET("+sciArray.getValue()+",b."+sciArray.getField()+")"+" "+ filter.getAndor();
							}else{
								sql +=" FIND_IN_SET("+sciArray.getValue()+",b."+sciArray.getField()+")";
							}
						}
						k++;
					}
					if(array.size()>1){
						sql += ") ";
					}
				}else{
					sql += " and ( ";
					if(filter.getName().equals("operTimeLength")){
						sql += getNormalBetweenSql("ROUND((TO_SECONDS(b.operEndTime) - TO_SECONDS(b.operStartTime))/60)", filter);
					}else if(filter.getName().equals("anaesTimeLength")){
						sql += getNormalBetweenSql(" ROUND((TO_SECONDS(b.anaesEndTime) - TO_SECONDS(b.anaesStartTime))/60)",filter) ;
					}else{
						if(filter.getType().equals("between")){
							sql += " b."+getNormalBetweenSql(filter.getName(), filter) ;
						}else{
							sql += " b."+filter.getName() +" = "+filter.getValue();
						}
					}
					sql+=" ) ";
				}
			}
		}
		
		
		if(bean.getAnaesEventFilter()!=null && bean.getAnaesEventFilter().getArray().size()>0){
			List<SciArray> array = bean.getAnaesEventFilter().getArray();
			
			String joinMethod = " inner ";
			if(!bean.getAnaesEventFilter().getAndor().equals("and")){
				joinMethod = " left ";
			}
			int arrSize = array.size();
			int start = 0;
			if(arrSize>0){	
				sql += " and EXISTS (select DISTINCT a0.docId from  ";
				sql += " (select docId from evt_anaesevent where  "+array.get(start).getField()+" = "+array.get(start).getValue() +") a"+ start ;

				for (int j = 0; j < arrSize; j++) {
					start++;
					if(arrSize>1 && start!=arrSize){
						sql += joinMethod+" JOIN (select docId from evt_anaesevent where  "+array.get(start).getField()+" = "+array.get(start).getValue() +") a"+(start);
						sql += " on a"+(start)+".docId = a"+(start-1)+".docId ";
					}
				}
				sql += " where b.anaRecordId=a0.docId ) ";
			}
		}
		/**
		 *镇痛方式
		 */
		if(bean.getAnalgesicFilter()!=null){
			sqlBuff.append(",doc_analgesic_record d ");
			sqlWhere.append(" and b.regOptId = d.regOptId ");
			
			sql += " and d.channel = "+bean.getAnalgesicFilter().getValue();
		}
		/**
		 *入量数据拼接
		 */
		if (bean.getIoEventFilter() != null	&& bean.getIoEventFilter().getArray().size() > 0) {

			List<SciArray> array = bean.getIoEventFilter().getArray();
			String joinMethod = " inner ";
			if(!bean.getIoEventFilter().getAndor().equals("and")){
				joinMethod = " left ";
			}
			int arrSize = array.size();
			int start = 0;
			if(arrSize>0){	
				sql += " and EXISTS (select  a0.docId from  ";
				sql += " (select docId from evt_inevent where  "+array.get(start).getField()+" = "+array.get(start).getValue()+this.getBetweenSql("dosageAmount", array.get(start))+" ) a"+ start;
				for (int j = 0; j < arrSize; j++) {
					start++;
					if(arrSize>1 && start!=arrSize){
						sql += joinMethod + " JOIN (select docId from evt_inevent where  "+array.get(start).getField()+" = "+array.get(start).getValue() +this.getBetweenSql("dosageAmount", array.get(start))+" ) a"+(start);
						sql += " on a"+(start)+".docId = a"+(start-1)+".docId ";
					}
				}
				sql += " where b.anaRecordId=a0.docId ) ";
			}			
		}
		
		/**
		 *出量数据拼接
		 */
		if(bean.getEgressEventFilter()!=null && bean.getEgressEventFilter().getArray().size()>0){
			
			List<SciArray> array = bean.getEgressEventFilter().getArray();
			String joinMethod = " inner ";
			if(!bean.getEgressEventFilter().getAndor().equals("and")){
				joinMethod = " left ";
			}
			
			int arrSize = array.size();
			int start = 0;
			if(arrSize>0){	
				sql += " and EXISTS (select a0.docId from  ";
				sql += " (select docId from evt_egress where  "+array.get(start).getField()+" = "+array.get(start).getValue()+this.getBetweenSql("value", array.get(start))+" ) a"+ start;
				for (int j = 0; j < arrSize; j++) {
					start++;
					if(arrSize>1 && start!=arrSize){
						sql += joinMethod + "JOIN (select docId from evt_egress where  "+array.get(start).getField()+" = "+array.get(start).getValue() +this.getBetweenSql("value", array.get(start))+" ) a"+(start);
						sql += " on a"+(start)+".docId = a"+(start-1)+".docId ";
					}
				}
				sql += " where b.anaRecordId=a0.docId ) ";
			}
			
			
//			if(bean.getEgressEventFilter().getAndor().equals("and") && array.size()>1){
//				int arrSize = array.size();
//				int start = 0;
//				if(arrSize>0){	
//					sql += " and EXISTS (select a0.doc_id from  ";
//					sql += " (select doc_id from s_egress where  "+array.get(start).getField()+" = "+array.get(start).getValue()+this.getBetweenSql("value", array.get(start))+" ) a"+ start;
//					for (int j = 0; j < arrSize; j++) {
//						start++;
//						if(arrSize>1 && start!=arrSize){
//							sql += " inner JOIN (select * from s_egress where  "+array.get(start).getField()+" = "+array.get(start).getValue() +this.getBetweenSql("value", array.get(start))+" ) a"+(start);
//							sql += " on a"+(start)+".doc_id = a"+(start-1)+".doc_id ";
//						}
//					}
//					sql += " where b.ana_record_id=a0.doc_id ) ";
//				}
//				
//			}else{
//				sqlBuff.append(",s_egress g ");
//				sqlWhere.append(" and b.ana_record_id = g.doc_id ");
//				
//				sql += " and ";
//				if(array.size()>1){
//					sql += "( ";
//				}
//				int i = 0;
//				for (SciArray sciArray : array) {
//					if(array.size()>1 && i!=array.size()-1){
//						sql += " (g."+sciArray.getField()+" = "+ sciArray.getValue() + this.getBetweenSql("value",sciArray)+" ) "+ bean.getEgressEventFilter().getAndor();
//					}else{
//						sql += " (g."+sciArray.getField()+" = "+ sciArray.getValue() + this.getBetweenSql("value",sciArray)+" ) ";
//					}
//					i++;
//				}
//				if(array.size()>1){
//					sql+=" ) "; 
//				}
//			}

		}
		
		/**
		 *实施麻醉方法
		 */
		if(bean.getImplAnaesMethodFilter()!=null && bean.getImplAnaesMethodFilter().getArray().size()>0){
			sqlBuff.append(" ,( ");
			
			sqlBuff.append(" select DISTINCT x1.regOptId from bas_reg_opt x1"
					+ " INNER JOIN doc_anaes_record x2 on x1.regOptId = x2.regOptId"
					+ " left JOIN evt_real_anaes_method x3 on x2.anaRecordId = x3.docId"
					+ " INNER join doc_opt_nurse_record x4 on x4.regOptId=x1.regOptId where ");
			
			String whereSql = "";
			List<SciArray> array = bean.getImplAnaesMethodFilter().getArray();
			int i = 0;
			for (SciArray sciArray : array) {
				if(array.size()>1 && i!=array.size()-1){
					whereSql +=" IF(x1.isLocalAnaes > 0,FIND_IN_SET('"+sciArray.getValue()+"',x4.designedAnaesMethodCode),x3."+sciArray.getField()+"='"+sciArray.getValue()+"')"+" "+ bean.getImplAnaesMethodFilter().getAndor();
				}else{
					whereSql +=" IF(x1.isLocalAnaes > 0,FIND_IN_SET('"+sciArray.getValue()+"',x4.designedAnaesMethodCode),x3."+sciArray.getField()+"='"+sciArray.getValue()+"')";
				}
				i++;
			}
			sqlBuff.append(whereSql);
			sqlBuff.append(" ) m ");
			sqlWhere.append(" and a.regOptId = m.regOptId ");
		}
		
		/**
		 *实施诊断
		 */
		if(bean.getImplDiagFilter()!=null && bean.getImplDiagFilter().getArray().size()>0){			
			sqlBuff.append(" ,( ");
			sqlBuff.append(" select DISTINCT x1.regOptId from bas_reg_opt x1 "
					+ " INNER JOIN doc_anaes_record x2 on x1.regOptId = x2.regOptId "
					+ " left JOIN evt_opt_latter_diag x3 on x2.anaRecordId = x3.docId where ");
			
			String whereSql = "";
			List<SciArray> array = bean.getImplDiagFilter().getArray();
			int i = 0;
			for (SciArray sciArray : array) {
				if(array.size()>1 && i!=array.size()-1){
					whereSql +=" IF(x1.isLocalAnaes > 0,FIND_IN_SET('"+sciArray.getValue()+"',x1.diagnosisCode),x3."+sciArray.getField()+"='"+sciArray.getValue()+"')"+" "+ bean.getImplDiagFilter().getAndor();
				}else{
					whereSql +=" IF(x1.isLocalAnaes > 0,FIND_IN_SET('"+sciArray.getValue()+"',x1.diagnosisCode),x3."+sciArray.getField()+"='"+sciArray.getValue()+"')";
				}
				i++;
			}
			sqlBuff.append(whereSql);
			sqlBuff.append(" ) n ");
			sqlWhere.append(" and a.regOptId = n.regOptId ");
		}
		/**
		 *实施手术
		 */
		if(bean.getImplOperFilter()!=null && bean.getImplOperFilter().getArray().size()>0){
			
			sqlBuff.append(" ,( ");
			sqlBuff.append(" select DISTINCT x1.regOptId from bas_reg_opt x1 INNER JOIN doc_anaes_record x2 on x1.regOptId = x2.regOptId"
					+ " left JOIN evt_opt_real_oper x3 on x2.anaRecordId = x3.docId "
					+ "INNER join doc_opt_nurse_record x4 on x4.regOptId=x1.regOptId where ");
			
			String whereSql = "";
			List<SciArray> array = bean.getImplOperFilter().getArray();
			int i = 0;
			for (SciArray sciArray : array) {
				if(array.size()>1 && i!=array.size()-1){
					whereSql +=" IF(x1.isLocalAnaes > 0,FIND_IN_SET('"+sciArray.getValue()+"',x4.operationCode),x3."+sciArray.getField()+"='"+sciArray.getValue()+"')"+" "+ bean.getImplOperFilter().getAndor();
				}else{
					whereSql +=" IF(x1.isLocalAnaes > 0,FIND_IN_SET('"+sciArray.getValue()+"',x4.operationCode),x3."+sciArray.getField()+"='"+sciArray.getValue()+"')";
				}
				i++;
			}
			sqlBuff.append(whereSql);
			sqlBuff.append(" ) k ");
			sqlWhere.append(" and a.regOptId = k.regOptId ");
		}
		/**
		 *手术器械
		 */
		if(bean.getInstrumentFilter()!=null && bean.getInstrumentFilter().getArray().size()>0){
			
			List<SciArray> array = bean.getInstrumentFilter().getArray();
			String joinMethod = " inner ";
			if(!bean.getInstrumentFilter().getAndor().equals("and")){
				joinMethod = " left ";
			}
			int arrSize = array.size();
			int start = 0;
			if(arrSize>0){	
				sql += " and EXISTS (select DISTINCT a0.regOptId from  ";
				sql += " (select regOptId from doc_instrubill_item where  "+array.get(start).getField()+" = "+array.get(start).getValue() +") a"+ start ;

				for (int j = 0; j < arrSize; j++) {
					start++;
					if(arrSize>1 && start!=arrSize){
						sql += joinMethod+" JOIN (select regOptId from doc_instrubill_item where  "+array.get(start).getField()+" = "+array.get(start).getValue() +") a"+(start);
						sql += " on a"+(start)+".regOptId = a"+(start-1)+".regOptId ";
					}
				}
				sql += " where a.regOptId=a0.regOptId ) ";
			}
		}

		/**
		 *用药事件
		 */
		if(bean.getUseMedEventFilter()!=null && bean.getUseMedEventFilter().getArray().size()>0){
			
			List<SciArray> array = bean.getUseMedEventFilter().getArray();
			String joinMethod = " inner ";
			if(!bean.getUseMedEventFilter().getAndor().equals("and")){
				joinMethod = " left ";
			}
			int arrSize = array.size();
			int start = 0;
			if(arrSize>0){	
				sql += " and EXISTS (select DISTINCT a0.docId from  ";
				sql += " (select docId from evt_medicalevent where  "+array.get(start).getField()+" = "+array.get(start).getValue()+this.getBetweenSql("dosage", array.get(start))+" ) a"+ start;
				for (int j = 0; j < arrSize; j++) {
					start++;
					if(arrSize>1 && start!=arrSize){
						sql += joinMethod+" JOIN (select docId from evt_medicalevent where  "+array.get(start).getField()+" = "+array.get(start).getValue() +this.getBetweenSql("dosage", array.get(start))+" ) a"+(start);
						sql += " on a"+(start)+".docId = a"+(start-1)+".docId ";
					}
				}
				sql += " where b.anaRecordId=a0.docId ) ";
			}
		}
		sqlBuff.append(sqlWhere);
		sqlBuff.append(sql);
		sqlBuff.append(" and a.beid = '" + getBeid() + "'");
		
		List<SearchAnaesRegInfo> regInfoList = tmpSciResearchFieldDao.searchRegInfoBySciRes(sqlBuff.toString());
		List<String> regOptRs = new ArrayList<String>();
		List<SearchAnaesRegInfo> resultList = new ArrayList<SearchAnaesRegInfo>();
		
		StringBuffer monitorSql = new StringBuffer();
		monitorSql.append("SELECT DISTINCT regOptId  FROM bas_monitor_display WHERE regOptId IN ");		
		
		if(bean.getLifeSignFilter()!=null && bean.getLifeSignFilter().getArray().size()>0){
			String lsSql = "and (";
			List<SciArray> array = bean.getLifeSignFilter().getArray();
			int i = 0;
			for (SciArray sciArray : array) {
				if(array.size()>1 && i!=array.size()-1){
					lsSql += " ("+sciArray.getField()+" = "+ sciArray.getValue() +" and " + getNormalBetweenSql("value", sciArray) +" )"+" "+ bean.getLifeSignFilter().getAndor();
				}else{
					lsSql += " ("+sciArray.getField()+" = "+ sciArray.getValue()+" and " + getNormalBetweenSql("value", sciArray) +" ) ";
				}
				i++;
			}
			
			lsSql+=" ) ";
			
			String regStr = "";
			int count = 1;
			for (SearchAnaesRegInfo searchAnaesRegInfo : regInfoList) {
				regStr += searchAnaesRegInfo.getRegOptId()+",";
				if(count%200==0 || regInfoList.size()==count){
					regStr = regStr.substring(0,regStr.length()-1);
					regOptRs.addAll(tmpSciResearchFieldDao.searchMonitListByRegOpt(monitorSql.toString()+"("+regStr+")"+lsSql));
					regStr="";
				}
				count++;
			}
			
			for (String regOptId : regOptRs) {
				for (SearchAnaesRegInfo searchAnaesRegInfo : regInfoList) {
					if(searchAnaesRegInfo.getRegOptId().equals(regOptId)){
						resultList.add(searchAnaesRegInfo);
					}
				}
			}
			return resultList;
		}else{
			return regInfoList;
		}
	}
	
	
	public SciCompareFormbean getSciCompareRegInfo(String regOptId){
		BasRegOpt regOpt = basRegOptDao.searchRegOptById(regOptId);

		DocAnaesRecord anesRecord = docAnaesRecordDao.searchAnaesRecordByRegOptId(regOptId);
		DocAnalgesicRecord analgesicRecord = docAnalgesicRecordDao.searchAnalgesicRecordByPatId(regOptId);
		DocAnaesSummary anaesSummary = docAnaesSummaryDao.getAnaesSummaryByRegOptId(regOptId);
		
		SearchFormBean searchBean = new SearchFormBean();
		searchBean.setDocId(anesRecord.getAnaRecordId());
		
		SciCompareFormbean record = new SciCompareFormbean();
		record.setIsLocalAnaes(regOpt.getIsLocalAnaes());
		record.setSex(regOpt.getSex());
		record.setAge(UserUtils.getAge(regOpt.getAge()+"", regOpt.getAgeMon()+"", regOpt.getAgeDay()));
		record.setHeight(regOpt.getHeight());
		record.setWeight(regOpt.getWeight());
		record.setEmergency(basSysCodeDao.searchSysCodeByGroupIdAndCodeValue("operat_category", regOpt.getEmergency()+"", getBeid()).size()>0?basSysCodeDao.searchSysCodeByGroupIdAndCodeValue("operat_category", regOpt.getEmergency()+"", getBeid()).get(0).getCodeName():regOpt.getEmergency()+"");
		record.setName(regOpt.getName());
		String optBody = "";
		if(StringUtils.isNotBlank(anesRecord.getOptBody())){
			String[] optBodyArr = anesRecord.getOptBody().split(",");
			for (int i = 0; i < optBodyArr.length; i++) {
				optBody += basSysCodeDao.searchSysCodeByGroupIdAndCodeValue("opt_body",optBodyArr[i], getBeid()).get(0).getCodeName()+",";
			}
		}
		record.setOptBody(optBody.length()>0?optBody.substring(0, optBody.length()-1):optBody);
		record.setOperateTime(anesRecord.getOperStartTime());
		record.setAsa(StringUtils.isNotBlank(anesRecord.getAsaLevel())?basSysCodeDao.searchSysCodeByGroupIdAndCodeValue("asa_level",anesRecord.getAsaLevel(), getBeid()).get(0).getCodeName():"");
		if(analgesicRecord!=null)
			record.setAnalgesicMethod(analgesicRecord.getAnalgesicMethod());
		record.setHyperSusceptiBility(regOpt.getHyperSusceptiBility());
		record.setAnaesMethod(regOpt.getDesignedAnaesMethodName());
		record.setDiagnosisName(record.getDiagnosisName());
		record.setOperationName(regOpt.getDesignedOptName());
		record.setAnaesSummary(anaesSummary.getAnestSummary());
		
		record.setOperateTime(docAnaesRecordDao.getOperdateByRegOpt(regOptId)+"小时");
		record.setAnaesTime(docAnaesRecordDao.getAnesdateByRegOpt(regOptId)+"小时");
		
		if(regOpt.getIsLocalAnaes().equals("0")){  //全麻
			List<EvtAnaesMethodFormBean> realAnesLs = evtRealAnaesMethodDao.getSelectRealAnaesMethodList(searchBean);
			
			String anesMethod = "";
			for (EvtAnaesMethodFormBean anaesMethodFormBean : realAnesLs) {
				anesMethod += anaesMethodFormBean.getName()+",";
			}
			anesMethod = anesMethod.length()>0?anesMethod.substring(0, anesMethod.length()-1):anesMethod;
			record.setAnaesMethod(anesMethod);
			
			List<EvtOptRealOper> optLs = evtOptRealOperDao.searchOptRealOperList(searchBean);
			String optNameStr = "";
			for (EvtOptRealOper optRealOper : optLs) {
				optNameStr += optRealOper.getName()+",";
			}
			optNameStr = optNameStr.length()>0?optNameStr.substring(0, optNameStr.length()-1):optNameStr;
			record.setOperationName(optNameStr);
			
			List<EvtAnaesEvent> anaeseventLs = evtAnaesEventDao.searchAnaeseventList(searchBean);
			String eventStr = "";
			for (EvtAnaesEvent anaesevent : anaeseventLs) {
				eventStr+=anaesevent.getCodeName()+",";
			}
			eventStr = eventStr.length()>0?eventStr.substring(0, eventStr.length()-1):eventStr;
			record.setAnaesEvent(eventStr);
			
			List<RegOptOperMedicaleventFormBean> medLs = evtMedicaleventDao.getUseMedicalGroupByNameList(searchBean);
			String medicineStr = "";
			for (RegOptOperMedicaleventFormBean regOptOperMedicaleventFormBean : medLs) {
				medicineStr += regOptOperMedicaleventFormBean.getName()+" "+regOptOperMedicaleventFormBean.getDosage()+regOptOperMedicaleventFormBean.getDosageUnit()+",";
			}
			medicineStr = medicineStr.length()>0?medicineStr.substring(0, medicineStr.length()-1):medicineStr;
			record.setMedicLs(medicineStr);
		}else{
			DocOptNurseRecord optNurseRecord = docOptNurseRecordDao.selectByRegOptId(regOptId);
			if (optNurseRecord != null) {
				record.setOptBody(optNurseRecord.getOptBody());
			}
		}
		
		List<AmountFormbean> ioLs = evtInEventDao.getIoAmountCountByDocId(searchBean.getDocId());
		String ioStr = "";
		for (AmountFormbean amountFormbean : ioLs) {
			ioStr += amountFormbean.getName()+" "+amountFormbean.getAmount()+amountFormbean.getDosageUnit()+",";
		}
		ioStr = ioStr.length()>0?ioStr.substring(0, ioStr.length()-1):ioStr;
		record.setIoevent(ioStr);
		
		List<AmountFormbean> egLs = evtEgressDao.getEgressAmountCountByDocId(searchBean.getDocId());
		String egressStr = "";
		for (AmountFormbean amountFormbean : egLs) {
			egressStr += amountFormbean.getName()+" "+amountFormbean.getAmount()+amountFormbean.getDosageUnit()+",";
		}
		egressStr = egressStr.length()>0?egressStr.substring(0, egressStr.length()-1):egressStr;
		record.setEgressevent(egressStr);
		
		LifeSignFormBean splitObservesData = this.getSplitObservesData(regOptId, 61);
		record.setSeries(splitObservesData.getSeries());
		record.setxAxis(splitObservesData.getxAxis());
		record.setyAxis(splitObservesData.getyAxis());
		record.setLegend(splitObservesData.getLegend());
		
		return record;
	}
	
	
	public LifeSignFormBean getSplitObservesData(String regOptId,Integer pageSize){
		LifeSignFormBean bean = new LifeSignFormBean();
		
		if(null == pageSize){
			pageSize = 10;
		}
		
		List<LifeSignYAxisData> yAxis = new ArrayList<LifeSignYAxisData>();
		LifeSignYAxisData yd = null;
		yd = new LifeSignYAxisData();
		// yd.setName(ObserveDataController.PR_NAME);
		yd.setType("value");
		yd.setMax(180);
		yd.setMin(0);
		yd.setOrder(1);
		yAxis.add(yd);
		yd = new LifeSignYAxisData();
		// yd.setName(ObserveDataController.TEMP_NAME);
		yd.setType("value");
		yd.setMax(60);
		yd.setMin(30);
		yd.setOrder(2);
		yAxis.add(yd);
		Collections.sort(yAxis);
		LegendData legend = new LegendData();
		List<String> legendData = new ArrayList<String>();
		List<LifeSignXAxis1Data> xAxis = new ArrayList<LifeSignXAxis1Data>();
		List<Integer> xAxisData = new ArrayList<Integer>();
		List<LifeSignSeriesData> series = new ArrayList<LifeSignSeriesData>();
		
		BaseInfoQuery baseQuery = new BaseInfoQuery();
		baseQuery.setRegOptId(regOptId);
		baseQuery.setPosition(0+"");
		baseQuery.setEnable("1");
		List<BasAnaesMonitorConfigFormBean> anaesLists = basAnaesMonitorConfigDao.findAnaesMonitorRecordListByRegOptId(baseQuery);
		List<String> observeIds = new ArrayList<String>();
		Map<String,LifeSignSeriesData> seriesMap = new TreeMap<String, LifeSignSeriesData>();
		
		if (null != anaesLists && anaesLists.size() > 0) {
			for (BasAnaesMonitorConfigFormBean fBean : anaesLists) {
				String observeId = fBean.getEventId();
				// 获取显示项需要的observeIds
				observeIds.add(observeId);
				String observeName = fBean.getEventName();
				//String color = fBean.getColor();// 对应图标
				//String icon = fBean.getIconId();// 对应颜色
				//String units = fBean.getUnits(); // 默认单位
				//Float max = fBean.getMax();  //max
				//Float min = fBean.getMin();  //min
				legendData.add(observeName);
				if (observeId.equals("31008") || observeId.equals("31010")) { // 如果是温度，则y轴为1
					seriesMap.put(observeId, new LifeSignSeriesData(observeName,observeId, "line", 1,new ArrayList<Float>()));
				} else {
					seriesMap.put(observeId, new LifeSignSeriesData(observeName,observeId,"line", 0,new ArrayList<Float>()));
				}
			}
		}
		
		List<BasMonitorDisplay> observeTimes = basMonitorDisplayDao.searchObserveTimeById(regOptId,observeIds);
		int total = observeTimes.size();
		if (observeTimes != null & total > 0) {
			BaseInfoQuery infoQry = new BaseInfoQuery();
			infoQry.setRegOptId(regOptId);
			infoQry.setPosition("0");  //取描点的数据
			List<BasMonitorDisplay> resultList = basMonitorDisplayDao.searchObserveDataList(infoQry,observeIds);
			Map<Date, List<BasMonitorDisplay>> map = new TreeMap<Date, List<BasMonitorDisplay>>();
			List<BasMonitorDisplay> datList = null;
			Date t = new Date(1L);
			if (observeTimes.size() <= pageSize) {
				for (int i = 0; i < resultList.size(); i++) {
					BasMonitorDisplay d = resultList.get(i);
					if (t != d.getTime()) {
						t = d.getTime();
					}
					if (d.getTime().equals(t)) {
						if (!map.containsKey(t)) {
							datList = new ArrayList<BasMonitorDisplay>();
							datList.add(d);
							map.put(t, datList);
						} else {
							List<BasMonitorDisplay> list = map.get(t);
							list.add(d);
							map.put(t, list);
						}
					}
				}

				/*if (!map.isEmpty()) {
					for (Date key : map.keySet()) {
						//List<MonitorDisplay> series = map.get(key);
						String curTime = SysUtil.getTimeFormat(key);
						
					}
				}*/
			} else {
				float sp = (float) total / (pageSize - 1);
				List<Date> times = new ArrayList<Date>();
				for (int cnt = 0; cnt < pageSize - 1; cnt++) {
					times.add(observeTimes.get((int) (cnt * sp)).getTime());
				}
				times.add(observeTimes.get(observeTimes.size() - 1).getTime());
				logger.info("times--------------"+JsonType.jsonType(times));
				for (int i = 0; i < resultList.size(); i++) {
					BasMonitorDisplay d = resultList.get(i);
					if (times.contains(d.getTime())) {
						if (t != d.getTime()) {
							t = d.getTime();
						}
						if (d.getTime().equals(t)) {
							if (!map.containsKey(t)) {
								datList = new ArrayList<BasMonitorDisplay>();
								datList.add(d);
								map.put(t, datList);
							} else {
								List<BasMonitorDisplay> list = map.get(t);
								list.add(d);
								map.put(t, list);
							}
						}
					}
				}
			}
			
			if (!map.isEmpty()) {
				int count = 1;
				for (Date key : map.keySet()) {
					List<BasMonitorDisplay> list = map.get(key);
					xAxisData.add(count++);
					if(null != list && list.size()>0){
						for (int i = 0; i < list.size(); i++) {
							BasMonitorDisplay md = list.get(i);
							String observeId = md.getObserveId();
							if(!seriesMap.containsKey(observeId)){
								logger.info("-----------默认显示项无当前监测项："+key);
							}else{
								LifeSignSeriesData lifeSignSeriesData = seriesMap.get(observeId);
								List<Float> data = lifeSignSeriesData.getData();
								data.add(md.getValue());
								lifeSignSeriesData.setData(data);
								seriesMap.put(observeId, lifeSignSeriesData);
							}
						}
					}
				}
			}
			
			
		}
		
		// 循环seriesMap中的数据
		for (String key : seriesMap.keySet()) {
			LifeSignSeriesData lifeSignSeriesData = seriesMap.get(key);
			series.add(lifeSignSeriesData);
		}
		
		LifeSignXAxis1Data lsxAxis1Data = new LifeSignXAxis1Data();
		lsxAxis1Data.setData(xAxisData);
		xAxis.add(lsxAxis1Data);
		
		legend.setData(legendData);
		
		bean.setxAxis(xAxis);
		bean.setyAxis(yAxis);
		bean.setSeries(series);
		bean.setLegend(legend);

		return bean;
	}

	public List<LifeSignObserveFormBean> getLifeSignList() {
		return basMonitorConfigDao.getLifeSignList(getBeid());
	}
	
	
}
