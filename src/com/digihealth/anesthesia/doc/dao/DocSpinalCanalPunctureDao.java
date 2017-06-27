/*
 * DocSpinalCanalPunctureDao.java
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
import com.digihealth.anesthesia.doc.po.DocSpinalCanalPuncture;
import com.digihealth.anesthesia.evt.formbean.SearchFormBean;
@MyBatisDao
public interface DocSpinalCanalPunctureDao extends CrudDao<DocSpinalCanalPuncture>{
    int deleteByPrimaryKey(String spinalCanalId);

    int insert(DocSpinalCanalPuncture record);

    int insertSelective(DocSpinalCanalPuncture record);

    DocSpinalCanalPuncture selectByPrimaryKey(String spinalCanalId);

    int updateByPrimaryKeySelective(DocSpinalCanalPuncture record);

    int updateByPrimaryKey(DocSpinalCanalPuncture record);

	public List<DocSpinalCanalPuncture> searchSpinalCanalPunctureList(@Param("searchBean")SearchFormBean searchBean);
}