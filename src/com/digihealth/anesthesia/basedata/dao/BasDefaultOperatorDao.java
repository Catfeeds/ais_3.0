package com.digihealth.anesthesia.basedata.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.digihealth.anesthesia.basedata.formbean.BaseInfoQuery;
import com.digihealth.anesthesia.basedata.formbean.SearchDefaultOperatorFormBean;
import com.digihealth.anesthesia.basedata.po.BasDefaultOperator;
import com.digihealth.anesthesia.common.persistence.annotation.MyBatisDao;

@MyBatisDao
public interface BasDefaultOperatorDao {
    int deleteByPrimaryKey(String id);

    int insert(BasDefaultOperator record);

    int insertSelective(BasDefaultOperator record);

    BasDefaultOperator selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(BasDefaultOperator record);

    int update(BasDefaultOperator record);
    
    public List<SearchDefaultOperatorFormBean> findList(@Param("baseQuery") BaseInfoQuery baseQuery);
    
    public List<BasDefaultOperator> getDefaultOperatorById(@Param("baseQuery") BaseInfoQuery baseQuery);
    
    public void deleteDefaultOperator(@Param("operRoomId") String operRoomId, @Param("beid") String beid);
}