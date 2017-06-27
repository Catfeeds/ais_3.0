/*
 * DocAnalgesicRecipeDao.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-03-30 Created
 */
package com.digihealth.anesthesia.doc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.digihealth.anesthesia.common.persistence.annotation.MyBatisDao;
import com.digihealth.anesthesia.doc.po.DocAnalgesicRecipe;
@MyBatisDao
public interface DocAnalgesicRecipeDao {
    int deleteByPrimaryKey(String id);

    int insert(DocAnalgesicRecipe record);

    int insertSelective(DocAnalgesicRecipe record);

    DocAnalgesicRecipe selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DocAnalgesicRecipe record);

    int updateByPrimaryKey(DocAnalgesicRecipe record);

    int deleteByanalgesicId(@Param("analgesicId") String analgesicId);
    
    List<DocAnalgesicRecipe> getByanalgesicId(@Param("analgesicId") String analgesicId);
}