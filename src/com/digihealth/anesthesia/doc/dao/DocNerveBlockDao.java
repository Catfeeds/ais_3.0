/*
 * DocNerveBlockDao.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-03-30 Created
 */
package com.digihealth.anesthesia.doc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.digihealth.anesthesia.common.persistence.CrudDao;
import com.digihealth.anesthesia.common.persistence.annotation.MyBatisDao;
import com.digihealth.anesthesia.doc.po.DocNerveBlock;
import com.digihealth.anesthesia.evt.formbean.SearchFormBean;

@MyBatisDao
public interface DocNerveBlockDao extends CrudDao<DocNerveBlock>{
    int deleteByPrimaryKey(String nerveBlockId);

    int insert(DocNerveBlock record);

    int insertSelective(DocNerveBlock record);

    DocNerveBlock selectByPrimaryKey(String nerveBlockId);

    int updateByPrimaryKeySelective(DocNerveBlock record);

    int updateByPrimaryKey(DocNerveBlock record);

	public List<DocNerveBlock> searchNerveBlockList(@Param("searchBean")SearchFormBean searchBean);
}