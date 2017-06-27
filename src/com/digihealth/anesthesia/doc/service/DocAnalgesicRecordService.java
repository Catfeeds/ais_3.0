/**     
 * @discription 在此输入一句话描述此文件的作用
 * @author chengwang       
 * @created 2015-10-10 下午5:32:33    
 * tags     
 * see_to_target     
 */

package com.digihealth.anesthesia.doc.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.digihealth.anesthesia.basedata.po.Controller;
import com.digihealth.anesthesia.basedata.utils.LogUtils;
import com.digihealth.anesthesia.basedata.utils.UserUtils;
import com.digihealth.anesthesia.common.service.BaseService;
import com.digihealth.anesthesia.common.utils.GenerateSequenceUtil;
import com.digihealth.anesthesia.common.utils.JsonType;
import com.digihealth.anesthesia.doc.formbean.AnalgesicRecordFormBean;
import com.digihealth.anesthesia.doc.po.DocAnalgesicMedicalInfo;
import com.digihealth.anesthesia.doc.po.DocAnalgesicRecipe;
import com.digihealth.anesthesia.doc.po.DocAnalgesicRecord;
import com.digihealth.anesthesia.doc.po.DocAnalgesicVisitInfo;
import com.digihealth.anesthesia.sysMng.po.BasUser;

/**
 * Title: AnalgesicRecordService.java Description: 描述
 * 
 * @author liukui
 * 
 * @created 2016-7-10 下午5:32:33
 */
@Service
public class DocAnalgesicRecordService extends BaseService {
	
	/**
	 * 根据患者id获取麻醉镇痛单数据
	 * @param patId
	 * @return
	 */
	public AnalgesicRecordFormBean getAnalgesicRecord(String regOptId){
		AnalgesicRecordFormBean record = new AnalgesicRecordFormBean();
		DocAnalgesicRecord analgesic = docAnalgesicRecordDao.searchAnalgesicRecordByPatId(regOptId);
		if(analgesic!=null){
			record.setAnalgesicRecord(analgesic);
			record.setAnalgesicRecipe(docAnalgesicRecipeDao.getByanalgesicId(analgesic.getId()));
			record.setAnalgesicMedicalInfo(docAnalgesicMedicalInfoDao.getByanalgesicId(analgesic.getId()));
			record.setAnalgesicVisitInfo(docAnalgesicVisitInfoDao.getByanalgesicId(analgesic.getId()));
		}
		return record;
	}

	/**
	 * 
	 * @discription 麻醉科术后镇痛单
	 * @author liukui
	 * @created 2015-10-20 下午1:44:18
	 * @param DocAnalgesicRecord
	 * @return
	 */
	@Transactional
	public void saveAnalgesicRecord(AnalgesicRecordFormBean record) {
		DocAnalgesicRecord analgesicRecord = record.getAnalgesicRecord();
		List<DocAnalgesicMedicalInfo> analgesicMedicalInfoLs = record.getAnalgesicMedicalInfo();
		List<DocAnalgesicRecipe> analgesicRecipeLs = record.getAnalgesicRecipe();
		List<DocAnalgesicVisitInfo> analgesicVisitLs = record.getAnalgesicVisitInfo();
		
		Controller controller = controllerDao.getControllerById(analgesicRecord.getRegOptId());
		
		analgesicRecord.setState(controller.getState());
		
		DocAnalgesicRecord analgesic = docAnalgesicRecordDao.searchAnalgesicRecordByPatId(analgesicRecord.getRegOptId());
		
		if(analgesic!=null){
			analgesicRecord.setId(analgesic.getId());
			docAnalgesicRecordDao.updateByPrimaryKeySelective(analgesicRecord);
		}else{
			analgesicRecord.setId(GenerateSequenceUtil.generateSequenceNo());
			docAnalgesicRecordDao.insert(analgesicRecord);
		}
		String analgesicId = analgesicRecord.getId();
		if(analgesicMedicalInfoLs.size()>0){
			docAnalgesicMedicalInfoDao.deleteByanalgesicId(analgesicId);
			for (DocAnalgesicMedicalInfo analgesicMedicalInfo : analgesicMedicalInfoLs) {
//				analgesicMedicalInfo.setPatId(analgesicRecord.getRegOptId());
				analgesicMedicalInfo.setAnalgesicId(analgesicId);
				analgesicMedicalInfo.setId(GenerateSequenceUtil.generateSequenceNo());
				docAnalgesicMedicalInfoDao.insertSelective(analgesicMedicalInfo);
			}
		}
		if(analgesicVisitLs.size()>0){
			docAnalgesicVisitInfoDao.deleteByanalgesicId(analgesicId);
			for (DocAnalgesicVisitInfo analgesicVisitInfo : analgesicVisitLs) {
//				analgesicVisitInfo.setPatId(analgesicRecord.getRegOptId());
				analgesicVisitInfo.setAnalgesicId(analgesicId);
				analgesicVisitInfo.setId(GenerateSequenceUtil.generateSequenceNo());
				docAnalgesicVisitInfoDao.insertSelective(analgesicVisitInfo);
			}
		}
		
		if(analgesicRecipeLs.size()>0){
			docAnalgesicRecipeDao.deleteByanalgesicId(analgesicId);
			for (DocAnalgesicRecipe analgesicRecipe : analgesicRecipeLs) {
//				analgesicRecipe.setPatId(analgesicRecord.getRegOptId());
				analgesicRecipe.setAnalgesicId(analgesicId);
				analgesicRecipe.setId(GenerateSequenceUtil.generateSequenceNo());
				docAnalgesicRecipeDao.insertSelective(analgesicRecipe);
			}
		}
		BasUser user = UserUtils.getUserCache();
		LogUtils.saveOperateLog(analgesicRecord.getRegOptId(), "4",
            "2", "麻醉记录单二修改", JsonType.jsonType(record),user, getBeid());
	}
}
