/*
 * DocOptRiskEvaluationDao.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-03-30 Created
 */
package com.digihealth.anesthesia.doc.dao;

import org.apache.ibatis.annotations.Param;

import com.digihealth.anesthesia.common.persistence.CrudDao;
import com.digihealth.anesthesia.common.persistence.annotation.MyBatisDao;
import com.digihealth.anesthesia.doc.po.DocOptRiskEvaluation;

@MyBatisDao
public interface DocOptRiskEvaluationDao extends CrudDao<DocOptRiskEvaluation>{
    int deleteByPrimaryKey(String optRiskEvaluationId);

    int insert(DocOptRiskEvaluation record);

    int insertSelective(DocOptRiskEvaluation record);

    DocOptRiskEvaluation selectByPrimaryKey(String optRiskEvaluationId);

    int updateByPrimaryKeySelective(DocOptRiskEvaluation record);

    int updateByPrimaryKey(DocOptRiskEvaluation record);

	/**
	 * 
	 * @discription 根据手术ID获取手术风险评估
	 * @author liukui
	 * @created 2015-10-10 下午5:13:48
	 * @param regOptId
	 * @return
	 */
	public DocOptRiskEvaluation searchOptRiskEvaluationByRegOptId(@Param("optRiskEvaluation") DocOptRiskEvaluation optRiskEvaluation);
}