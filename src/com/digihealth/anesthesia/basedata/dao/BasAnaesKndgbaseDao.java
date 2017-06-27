package com.digihealth.anesthesia.basedata.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.digihealth.anesthesia.basedata.po.BasAnaesKndgbase;
import com.digihealth.anesthesia.common.persistence.annotation.MyBatisDao;

@MyBatisDao
public interface BasAnaesKndgbaseDao {
    int deleteByPrimaryKey(String id);

    int insert(BasAnaesKndgbase record);

    int insertSelective(BasAnaesKndgbase record);

    BasAnaesKndgbase selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(BasAnaesKndgbase record);

    int updateByPrimaryKeyWithBLOBs(BasAnaesKndgbase record);

    int updateByPrimaryKey(BasAnaesKndgbase record);
    
    public List<BasAnaesKndgbase> queryAnaesKndgbaseList(@Param("basAnaesKndgbase")BasAnaesKndgbase basAnaesKndgbase);
    
    public int selectByPid(@Param("pId")String pId, @Param("beid")String beid);
    
    public List<BasAnaesKndgbase> selectOrderById();
}