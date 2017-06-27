/*
 * DocSelfPayAccedeDao.java
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
import com.digihealth.anesthesia.doc.po.DocSelfPayAccede;
@MyBatisDao
public interface DocSelfPayAccedeDao extends CrudDao<DocSelfPayAccede>{
	public List<DocSelfPayAccede> searchSelfPayAccedeByRegOptId(@Param("regOptId") String regOptId,@Param("type") String type);
	
	public DocSelfPayAccede searchSelfPayAccedeById(@Param("id") String id);
	
    int deleteByPrimaryKey(String id);

    int insert(DocSelfPayAccede record);

    int insertSelective(DocSelfPayAccede record);

    DocSelfPayAccede selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DocSelfPayAccede record);

    int updateByPrimaryKey(DocSelfPayAccede record);
}