/**     
 * @discription 在此输入一句话描述此文件的作用
 * @author liukui       
 * @created 2015-10-10 下午5:32:33    
 * tags     
 * see_to_target     
 */

package com.digihealth.anesthesia.doc.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.digihealth.anesthesia.basedata.utils.LogUtils;
import com.digihealth.anesthesia.basedata.utils.UserUtils;
import com.digihealth.anesthesia.common.service.BaseService;
import com.digihealth.anesthesia.common.utils.GenerateSequenceUtil;
import com.digihealth.anesthesia.common.utils.JsonType;
import com.digihealth.anesthesia.doc.po.DocOptRiskEvaluation;
import com.digihealth.anesthesia.sysMng.po.BasUser;

/**
 * Title: OptRiskEvaluationService.java Description: 描述
 * 
 * @author liukui
 * @created 2015-10-10 下午5:32:33
 */
@Service
public class DocOptRiskEvaluationService extends BaseService {
	
	/**
	 * 
	 * @discription 根据手术ID获取手术风险评估表信息
	 * @author liukui
	 * @created 2015-10-10 下午5:13:48
	 * @param regOptId
	 * @return
	 */
	public DocOptRiskEvaluation searchOptRiskEvaluationByRegOptId(DocOptRiskEvaluation optRiskEvaluation) {
		return docOptRiskEvaluationDao.searchOptRiskEvaluationByRegOptId(optRiskEvaluation);
	}
	
	/**
	 * 保存提交手术风险评估表信息
	 * @param optRiskEvaluation
	 */
	@Transactional
	public void saveOptRiskEvaluation(DocOptRiskEvaluation optRiskEvaluation){
//		optRiskEvaluation.setProcessState("END");
//		optRiskEvaluation.setFlag("1");
		if (StringUtils.isNotBlank(optRiskEvaluation.getOptRiskEvaluationId())) {
			docOptRiskEvaluationDao.updateByPrimaryKey(optRiskEvaluation);
		}else{
			optRiskEvaluation.setOptRiskEvaluationId(GenerateSequenceUtil.generateSequenceNo());
			docOptRiskEvaluationDao.insert(optRiskEvaluation);
		}
		BasUser user = UserUtils.getUserCache();
		LogUtils.saveOperateLog(optRiskEvaluation.getRegOptId(), "4",
            "2", "手术风险评估单修改", JsonType.jsonType(optRiskEvaluation),user, getBeid());
	}

}
