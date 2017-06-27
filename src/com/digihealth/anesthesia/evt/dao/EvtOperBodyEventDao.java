/*
 * EvtOperBodyEventDao.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-04-06 Created
 */
package com.digihealth.anesthesia.evt.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.digihealth.anesthesia.common.persistence.annotation.MyBatisDao;
import com.digihealth.anesthesia.evt.formbean.OperBodyFormBean;
import com.digihealth.anesthesia.evt.formbean.SearchFormBean;
import com.digihealth.anesthesia.evt.po.EvtOperBodyEvent;

@MyBatisDao
public interface EvtOperBodyEventDao {
    int deleteByPrimaryKey(String optBodyEventId);

    int insert(EvtOperBodyEvent record);

    int insertSelective(EvtOperBodyEvent record);

    EvtOperBodyEvent selectByPrimaryKey(String optBodyEventId);

    int updateByPrimaryKeySelective(EvtOperBodyEvent record);

    int updateByPrimaryKey(EvtOperBodyEvent record);
    
    public List<OperBodyFormBean> queryOperBodyEventList(@Param("searchBean")SearchFormBean searchBean);
}