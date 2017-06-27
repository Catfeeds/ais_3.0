/*
 * BasHisInterfaceTransferRegOptDao.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-04-06 Created
 */
package com.digihealth.anesthesia.basedata.dao;

import com.digihealth.anesthesia.basedata.po.BasHisInterfaceTransferRegOpt;

public interface BasHisInterfaceTransferRegOptDao {
    int deleteByPrimaryKey(String regOptId);

    int insert(BasHisInterfaceTransferRegOpt record);

    int insertSelective(BasHisInterfaceTransferRegOpt record);

    BasHisInterfaceTransferRegOpt selectByPrimaryKey(String regOptId);

    int updateByPrimaryKeySelective(BasHisInterfaceTransferRegOpt record);

    int updateByPrimaryKey(BasHisInterfaceTransferRegOpt record);
}