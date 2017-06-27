/*
 * BasRegOptDao.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-03-24 Created
 */
package com.digihealth.anesthesia.basedata.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.digihealth.anesthesia.basedata.formbean.BaseInfoQuery;
import com.digihealth.anesthesia.basedata.formbean.DocumentStateFormbean;
import com.digihealth.anesthesia.basedata.po.BasRegOpt;
import com.digihealth.anesthesia.common.persistence.CrudDao;
import com.digihealth.anesthesia.common.persistence.annotation.MyBatisDao;
import com.digihealth.anesthesia.doc.formbean.AnaesPacuRecFormBean;
import com.digihealth.anesthesia.evt.formbean.CancleRegOptFormBean;
import com.digihealth.anesthesia.evt.formbean.SearchConditionFormBean;
import com.digihealth.anesthesia.evt.formbean.SearchMyOperationFormBean;
import com.digihealth.anesthesia.evt.formbean.SearchOperaPatrolRecordFormBean;
import com.digihealth.anesthesia.evt.formbean.SearchRegOptByIdFormBean;
import com.digihealth.anesthesia.evt.formbean.SearchRegOptByLoginNameAndStateFormBean;
import com.digihealth.anesthesia.evt.formbean.SearchRegOptByRoomIdAndOperDateAndStateFormBean;
import com.digihealth.anesthesia.evt.formbean.SearchSafeCheckRegOptFormBean;
import com.digihealth.anesthesia.operProceed.formbean.RegOptFormBean;

@MyBatisDao
public interface BasRegOptDao extends CrudDao<BasRegOpt>{
	public List<SearchMyOperationFormBean> searchMyOperation(@Param("filter") String filter,
			@Param("loginName") String loginName,
			@Param("roleType") String roleType, @Param("searchConditionFormBean") SearchConditionFormBean searchConditionFormBean);

	/**
	 * 
	 * @discription 根据登录账号和用户类别和手术状态获取人员列表信息描述类
	 * @author chengwang
	 * @created 2015-10-9 上午10:26:40
	 * @param loginName
	 * @param statu
	 * @return 
	 */
	public List<SearchRegOptByLoginNameAndStateFormBean> searchRegOptByAnaesDoctorAndState(@Param("filter") String filter,
			@Param("loginName") String loginName,
			@Param("roleType") String roleType, @Param("searchConditionFormBean") SearchConditionFormBean searchConditionFormBean, @Param("beid") String beid);

	public int searchRegoptTotalByAnaesDoctorAndState(@Param("filter") String filter,
			@Param("loginName") String loginName,
			@Param("roleType") String roleType, @Param("searchConditionFormBean") SearchConditionFormBean searchConditionFormBean, @Param("beid") String beid);

	/**
	 * 
	 * @discription 获取单个手术室即将进行手术的病人列表
	 * @author chengwang
	 * @created 2015-10-10 上午9:43:03
	 * @param roomId
	 * @param operDate
	 * @param state
	 * @return
	 */
	public List<SearchRegOptByRoomIdAndOperDateAndStateFormBean> searchRegOptByRoomIdAndOperDateAndState(
			@Param("roomId") String roomId, @Param("operDate") String operDate,
			@Param("state") List<String> state, @Param("beid") String beid);
	
	/**
	 * 获取当日手术和正在术中的手术
	 * @param roomId
	 * @param operDate
	 * @return
	 */
	public List<SearchRegOptByRoomIdAndOperDateAndStateFormBean> searchDayRegOpt(@Param("roomId")String roomId,@Param("operDate")String operDate, @Param("beid") String beid);
	
	/**
	 * 获取当前麻醉医生或巡回护士1的下面的手术
	 * @param roomId
	 * @param operDate
	 * @param loginName
	 * @return
	 */
	public List<SearchRegOptByRoomIdAndOperDateAndStateFormBean> searchCurUserRegOpt(@Param("roomId")String roomId,@Param("operDate")String operDate,@Param("userId")String userId, @Param("beid") String beid);
	
	
	public List<SearchRegOptByRoomIdAndOperDateAndStateFormBean> queryAllRegOpt(@Param("regOptFormBean")RegOptFormBean entity,@Param("beid") String beid);

	/**
	 * 
	 * @discription 根据ID获取regOpt
	 * @author chengwang
	 * @created 2015-10-10 下午5:47:31
	 * @param id
	 * @return
	 */
	public BasRegOpt searchRegOptById(@Param("regOptId") String id);

	/**
	 * 
	 * @discription 手术申请界面查看单个病人信息
	 * @author chengwang
	 * @created 2015-10-19 下午3:38:20
	 * @param id
	 * @return
	 */
	public List<SearchRegOptByIdFormBean> searchApplicationById(@Param("id") String id,@Param("beid") String beid);

	/**
	 * 
	 * @discription 手术核查需要的基本信息i
	 * @author chengwang
	 * @created 2015年10月28日 上午10:59:23
	 * @param regOptId
	 * @return
	 */
	public SearchSafeCheckRegOptFormBean searchSafeCheckRegOptById(@Param("regOptId") String regOptId,@Param("beid") String beid);
	
	/**
	 * 
	     * @discription 取消手术
	     * @author chengwang       
	     * @created 2015年10月30日 上午9:17:13     
	     * @param cancleRegOptFormBean
	 */
	public void cancleRegOpt(@Param("cancleRegOptFormBean") CancleRegOptFormBean cancleRegOptFormBean);
	
	@Override
	public int update(@Param("regOpt")BasRegOpt basRegOpt);
	
	/**
	 * 
	 * @param baseQuery 
	 * @return
	 */
	public List<SearchOperaPatrolRecordFormBean> getOperaPatrolRecordList(@Param("baseQuery") BaseInfoQuery baseQuery);
	
	public List<SearchOperaPatrolRecordFormBean> getOperaPatrolRecordListByRoomId(@Param("baseQuery") BaseInfoQuery baseQuery);
	
	
	public List<SearchMyOperationFormBean> searchNoArchiveRegOpt(@Param("time")String time);
	
	public List<DocumentStateFormbean> queryDocState(@Param("sql")String sql);
	
	public String searchDocumentState(@Param("sql")String sql);
	
	public List<String> researchAnalysis(@Param("sql")String sql);
	
	public List<SearchMyOperationFormBean> searchRegOpt(@Param("loginName") String loginName,
			@Param("roleType") String roleType, @Param("searchConditionFormBean") SearchConditionFormBean searchConditionFormBean);
	
	public int updateMsid(@Param("regOptId")String regOptId,@Param("msid")String msid);
	
	public int updateOperTime(@Param("operTime")String operTime,@Param("regOptId")String regOptId);
	
	public int updateIntermitcause(@Param("cause")String cause,@Param("regOptId")String regOptId);
	
	public AnaesPacuRecFormBean getPostopOptInfo(@Param("regOptId")String regOptId, @Param("beid") String beid);
	
	public int updateState(@Param("regOptId")String regOptId,@Param("state")String state);
	

	/**
	 * 
	 * @discription 根据登录账号和用户类别和手术状态获取已归档手术信息描述类
	 * @author chengwang
	 * @created 2015-10-9 上午10:26:40
	 * @param loginName
	 * @param statu
	 * @return 
	 */
	public List<SearchRegOptByLoginNameAndStateFormBean> searchRegOptByArchstate(@Param("filter") String filter,
			@Param("loginName") String loginName,
			@Param("roleType") String roleType, @Param("searchConditionFormBean") SearchConditionFormBean searchConditionFormBean, @Param("beid") String beid);
	
	public int searchRegoptTotalByArchstate(@Param("filter") String filter,
			@Param("loginName") String loginName,
			@Param("roleType") String roleType, @Param("searchConditionFormBean") SearchConditionFormBean searchConditionFormBean, @Param("beid") String beid);
	
	
	public int updateArchstate(@Param("regOptIdList")List<String> regOptIdList,@Param("archstate")String archstate);
	
	public int updateNurseArchstate(@Param("regOptIdList")List<String> regOptIdList,@Param("nurseArchstate")String nurseArchstate);
	
	public int updateFrontOperForbidTake(BasRegOpt basRegOpt);
	
	public int updateFrontOperSpecialCase(BasRegOpt basRegOpt);

	public BasRegOpt selectByState(@Param("roomId")String roomId,@Param("state")String state,@Param("beid")String beid);

	public int selectHisToRegOpt(@Param("preengagementnumber")String preengagementnumber,@Param("operaDate")String operaDate);

    int updateByPrimaryKey(BasRegOpt record);
    
    int updateByPrimaryKeySelective(BasRegOpt record);
    
    int insertSelective(BasRegOpt record);

    int insert(BasRegOpt record);
    
    int deleteByPrimaryKey(String regOptId);

}