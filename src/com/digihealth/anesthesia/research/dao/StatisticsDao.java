/**
 * 
 */
package com.digihealth.anesthesia.research.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.digihealth.anesthesia.basedata.formbean.SystemSearchFormBean;
import com.digihealth.anesthesia.basedata.po.BasAnaesMethod;
import com.digihealth.anesthesia.common.persistence.BaseDao;
import com.digihealth.anesthesia.common.persistence.annotation.MyBatisDao;
import com.digihealth.anesthesia.doc.po.DocPostFollowGeneral;
import com.digihealth.anesthesia.doc.po.DocPostFollowSpinal;
import com.digihealth.anesthesia.evt.formbean.Filter;
import com.digihealth.anesthesia.evt.formbean.SearchConditionFormBean;
import com.digihealth.anesthesia.evt.formbean.SearchFormBean;
import com.digihealth.anesthesia.research.formbean.AnaesCntByAnaesMethod;
import com.digihealth.anesthesia.research.formbean.AnaesDocObserveTimeCount;
import com.digihealth.anesthesia.research.formbean.HomeAnaesDoctorWorkingTimeFormBean;
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
import com.digihealth.anesthesia.research.formbean.StaticAnaesDocCountByAnalgesic;
import com.digihealth.anesthesia.research.formbean.StaticDeptCountByAnalgesic;
import com.digihealth.anesthesia.research.formbean.StatisAnaesOptFormBean;
import com.digihealth.anesthesia.research.formbean.WorkingTimeFormBean;

/**
 * 
 * Title: StatisticsDao.java Description: 统计DAO
 * 
 * @author chengwang
 * @created 2015-10-17 上午9:34:33
 */
@SuppressWarnings("rawtypes")
@MyBatisDao
public interface StatisticsDao extends BaseDao {

	public List<StatisAnaesOptFormBean> statisAnaesOptNum(@Param("startTime") String startTime,
			@Param("endTime") String endTime,@Param("state") String state, @Param("beid") String beid);
	
	public List<WorkingTimeFormBean> searchWorkingTime(@Param("startTime") String startTime, @Param("endTime") String endTime,@Param("loginName")int loginName, @Param("beid") String beid);
	
	public List<WorkingTimeFormBean> searchAnaesDoctorWorkingTime(@Param("startTime") String startTime,
			@Param("endTime") String endTime,@Param("loginName")String loginName, @Param("beid") String beid);
	
	public List<WorkingTimeFormBean> searchNurseQmWorkingTime(@Param("startTime") String startTime,
			@Param("endTime") String endTime,@Param("loginName")String loginName, @Param("beid") String beid);
	
	public List<WorkingTimeFormBean> searchNurseJmWorkingTime(@Param("startTime") String startTime,
			@Param("endTime") String endTime,@Param("loginName")String loginName, @Param("beid") String beid);
	
	public List<WorkingTimeFormBean> searchConsultationTime(@Param("startTime") String startTime,
			@Param("endTime") String endTime,@Param("loginName")String loginName, @Param("beid") String beid);
	
	public List<SearchMedicineType> searchMedicineGroupMedicineId(@Param("startTime") String startTime,
			@Param("endTime") String endTime);
	
	public List<SearchMedicineType> searchMedicineByUser(@Param("startTime") String startTime,
			@Param("endTime") String endTime,@Param("loginName") String loginName);
	
	public List<SearchRegionOperatCountByOptlev>  searchRegionOperatCountByOptlev(@Param("searchFormBean") SearchFormBean searchFormBean);
	
	public List<SearchRegionOperatCountByAsalev>  searchRegionOperatCountByAsalev(@Param("searchFormBean") SearchFormBean searchFormBean);
	
	public List<SearchRegionOperatCompdiag> searchRegionOperatCompdiag(@Param("searchFormBean") SearchFormBean searchFormBean);
	
	public List<SearchBadEventInfo>  searchBadEventInfoList(@Param("searchFormBean") SearchFormBean searchFormBean, @Param("beid") String beid);
	
	public List<AnaesDocObserveTimeCount>  countAnaesDocUpdateObserveTime(@Param("searchFormBean") SearchFormBean searchFormBean);
	
	public List<BasAnaesMethod> searchRealMed(@Param("startTime") String startTime,
			@Param("endTime") String endTime, @Param("beid") String beid);
	
	
	public List<SearchAnaesRegInfo> searchAnaesRegInfoList(@Param("searchFormBean") SystemSearchFormBean searchFormBean,@Param("filters") List<Filter> filters);
	
	public Integer searchTotalByAnaesRegInfoList(@Param("filters") List<Filter> filters, @Param("beid") String beid);
	
	
	public List<AnaesDocObserveTimeCount> searchPatGroupByDept(@Param("filters") List<Filter> filters, @Param("beid") String beid);
	
	public List<AnaesDocObserveTimeCount> searchPatGroupByAnaesDoc(@Param("filters") List<Filter> filters, @Param("beid") String beid);
	
	public List<SearchDeptOperatCountBySteward> searchDeptOperatCountBySteward(@Param("searchFormBean") SearchFormBean searchFormBean);
	
	public List<StaticDeptCountByAnalgesic> searchDeptCountByAnalgesic(@Param("searchFormBean") SearchFormBean searchFormBean);
	
	public List<StaticAnaesDocCountByAnalgesic> searchAnaecDocCountByAnalgesic(@Param("searchFormBean") SearchFormBean searchFormBean);
	
	/**
	 * 根据科室、麻醉方法统计数据
	 * @param searchFormBean
	 * @return
	 */
	public List<AnaesCntByAnaesMethod> getDeptAnaesCntGroupByAnaesMethod(@Param("searchFormBean") SearchFormBean searchFormBean);
	
	/**
	 * 根据麻醉医生、麻醉方法统计数据
	 * @param searchFormBean
	 * @return
	 */
	public List<AnaesCntByAnaesMethod> getAnaesDocAnaesCntGroupByAnaesMethod(@Param("searchFormBean") SearchFormBean searchFormBean);
	
	public List<SearchAnaesRegInfo> searchAnalgesicRegInfoList(@Param("searchFormBean") SystemSearchFormBean searchFormBean,@Param("filters") List<Filter> filters);
	
	public Integer searchTotalAnalgesicRegInfoList(@Param("searchFormBean") SystemSearchFormBean searchFormBean, @Param("filters") List<Filter> filters);
	
	public List<SearchOperByDept> searchOperByDept(@Param("searchFormBean") SearchFormBean searchFormBean);
	
	public List<SearchOperByOperator> searchOperByOperator(@Param("searchFormBean") SearchFormBean searchFormBean);
	
	public List<SearchOperByOperator> searchOperatorJMWorkingTime(@Param("searchFormBean") SearchFormBean searchFormBean);
	
	public List<SearchOperByOperator> searchOperatorQMWorkingTime(@Param("searchFormBean") SearchFormBean searchFormBean);
	
	public SearchOperByNurse searchOperByNurse(@Param("searchFormBean") SearchFormBean searchFormBean); 
	
	public SearchOperByNurse searchNurseJMWorkingTime(@Param("searchFormBean") SearchFormBean searchFormBean);
	
	public SearchOperByNurse searchNurseQMWorkingTime(@Param("searchFormBean") SearchFormBean searchFormBean);
	
	public List<SearchOperByASALevel> searchOperByASALevel(@Param("searchFormBean") SearchFormBean searchFormBean);
	
	public Integer searchOperByAnalgesic(@Param("searchFormBean") SearchFormBean searchFormBean);
	
	public Integer searchOperByOperSource(@Param("searchFormBean") SearchFormBean searchFormBean);
	
	public List<SearchOperFormBean> searchOperByCondition(@Param("searchFormBean") SearchFormBean searchFormBean);
	
	public List<SearchOperFormBean> searchToICUOper(@Param("searchFormBean") SearchFormBean searchFormBean, @Param("beid") String beid);
	
	public List<SearchOperFormBean> searchCancleOperAfterAnaes(@Param("searchFormBean") SearchFormBean searchFormBean);
	
	public List<SearchOperFormBean> searchVenipunctyreList(@Param("searchFormBean") SearchFormBean searchFormBean);
	
	public List<SearchOperFormBean> searchASALevelOper(@Param("searchFormBean") SearchFormBean searchFormBean);
	
	public List<SearchOperFormBean> searchAutograftBloodTrans400mlInfo(@Param("searchFormBean") SearchFormBean searchFormBean);
	
	public List<SearchOperFormBean> searchBloodTrans400mlInfo(@Param("searchFormBean") SearchFormBean searchFormBean);
	
	public List<HomeAnaesDoctorWorkingTimeFormBean> searchAllHomeAnaesDoctorWorkingTime(@Param("startTime") String startTime,
			@Param("endTime") String endTime,@Param("loginName")String loginName, @Param("beid") String beid);
			
	public List<HomeAnaesDoctorWorkingTimeFormBean> searchHomeAnaesDoctorShiftWorkingTime(@Param("startTime") String startTime,
			@Param("endTime") String endTime, @Param("beid") String beid);
	
	public List<HomeAnaesDoctorWorkingTimeFormBean> searchHomeAnaesDoctorWorkingTime(@Param("startTime") String startTime,
			@Param("endTime") String endTime,@Param("loginName")String loginName, @Param("beid") String beid);
	
	/**
	 * 首页中 龙岗第二人民医院 护士全麻工作量
	 * @param startTime
	 * @param endTime
	 * @param loginName
	 * @return
	 */
	public List<WorkingTimeFormBean> searchLgNurseQmWorkingTime(@Param("startTime") String startTime,
			@Param("endTime") String endTime,@Param("loginName")String loginName);
	/**
	 * 首页中 龙岗第二人民医院 护士局麻工作量
	 * @param startTime
	 * @param endTime
	 * @param loginName
	 * @return
	 */
	public List<WorkingTimeFormBean> searchLgNurseJmWorkingTime(@Param("startTime") String startTime,
			@Param("endTime") String endTime,@Param("loginName")String loginName);
	
	public Integer searchHomeQMTimes(@Param("startTime") String startTime,@Param("endTime") String endTime,@Param("loginName")String loginName);
	
	public Integer searchHomeNurseJMTimes(@Param("startTime") String startTime,@Param("endTime") String endTime,@Param("loginName")String loginName);

	public int searchEntryPacuPatCount(@Param("startTime") String startTime, @Param("beid") String beid);
	
	public int searchStewardScoCount(@Param("startTime") String startTime, @Param("beid") String beid);

	public SearchAnesTypeFormBean countAnesNumByWihtAnesType(@Param("searchFormBean") SearchFormBean searchFormBean);
	
	public SearchAnesTypeFormBean countAnesNumByAnesType(@Param("searchFormBean") SearchFormBean searchFormBean);
	
	public SearchAnesTypeFormBean countAnesNumByOtherAnesType(@Param("searchFormBean") SearchFormBean searchFormBean);
	
	public int searchOperByCPRNum(@Param("searchFormBean") SearchFormBean searchFormBean);

	public List<SearchOperFormBean> searchAnaesPacuDelayRate(@Param("searchFormBean") SearchFormBean searchFormBean);

	public List<SearchOperFormBean> searchEnterPacuNum(@Param("searchFormBean") SearchFormBean searchFormBean);

	public List<SearchOperFormBean> searchAnaesPacuLowTemp(@Param("searchFormBean") SearchFormBean searchFormBean);

	public List<SearchOperFormBean> searchAnesSecondIntubatList(@Param("searchFormBean") SearchFormBean searchFormBean);

	public List<SearchOperFormBean> searchAnesExtubatList(@Param("searchFormBean") SearchFormBean searchFormBean);

	public List<SearchOperFormBean> searchOptAllergicReactionList(@Param("searchFormBean") SearchFormBean searchFormBean);

	public List<SearchOperFormBean> searchOtherAnesList(@Param("searchFormBean") SearchFormBean searchFormBean);

	public List<DocPostFollowSpinal> searchSpinalAneshrListInHours(@Param("searchFormBean") SearchFormBean searchFormBean,@Param("hours") Integer hours);

	public List<DocPostFollowGeneral> searchExtubat72hrHoarseList(@Param("searchFormBean") SearchFormBean searchFormBean);

	public List<SearchOperFormBean> searchOutpatientOperateList(@Param("searchBean")SearchFormBean searchBean);

	public int queryTotalAnaesRegDetailList(@Param("filters") List<Filter> filters, @Param("beid") String beid);

	public List<SearchAnaesRegInfo> queryAnaesRegDetailList(@Param("searchFormBean") SearchConditionFormBean searchFormBean,@Param("filters") List<Filter> filters);

	public List<SearchAnaesRegInfo> queryOperateDetailByDept(@Param("searchFormBean") SearchConditionFormBean searchFormBean,@Param("filters") List<Filter> filters);
	
	public int queryOperateDetailByDeptTotal(@Param("searchFormBean") SearchConditionFormBean searchFormBean,@Param("filters") List<Filter> filters);

	public int searchHospitalKeyOperationNum(@Param("searchFormBean")SearchFormBean searchFormBean);

	public int searchDeathNum(@Param("searchFormBean")SearchFormBean searchFormBean);

	public List<SearchOperFormBean> searchAnes24hrCardiacArrest(@Param("searchFormBean") SearchFormBean searchFormBean);

	public List<SearchOperFormBean> search24HourDeathRate(@Param("searchFormBean") SearchFormBean searchFormBean);

	public List<SearchOperFormBean> searchQmFjgIcuNum(@Param("searchFormBean") SearchFormBean searchFormBean);
	
	public List<SearchOperFormBean> searchQmIcuNum(@Param("searchFormBean") SearchFormBean searchFormBean);
	
	public List<SearchOperFormBean> searchJmIcuNum(@Param("searchFormBean") SearchFormBean searchFormBean);

	public List<SearchOperFormBean> searchReunitWihtAnesList(@Param("searchFormBean") SearchFormBean searchFormBean);
	
}
