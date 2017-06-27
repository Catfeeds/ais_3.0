/**     
 * @discription 在此输入一句话描述此文件的作用
 * @author chengwang       
 * @created 2015-10-10 下午5:32:33    
 * tags     
 * see_to_target     
 */

package com.digihealth.anesthesia.doc.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.digihealth.anesthesia.basedata.po.Controller;
import com.digihealth.anesthesia.basedata.utils.LogUtils;
import com.digihealth.anesthesia.basedata.utils.UserUtils;
import com.digihealth.anesthesia.common.entity.ResponseValue;
import com.digihealth.anesthesia.common.service.BaseService;
import com.digihealth.anesthesia.common.utils.BeanHelper;
import com.digihealth.anesthesia.common.utils.GenerateSequenceUtil;
import com.digihealth.anesthesia.common.utils.JsonType;
import com.digihealth.anesthesia.common.utils.StringUtils;
import com.digihealth.anesthesia.doc.formbean.PreVisitFormBean;
import com.digihealth.anesthesia.doc.po.DocPreVisit;
import com.digihealth.anesthesia.doc.po.DocPrevisitAccessexam;
import com.digihealth.anesthesia.doc.po.DocPrevisitAnaesplan;
import com.digihealth.anesthesia.doc.po.DocPrevisitPhyexam;
import com.digihealth.anesthesia.evt.formbean.SearchConditionFormBean;
import com.digihealth.anesthesia.evt.formbean.SearchMyOperationFormBean;
import com.digihealth.anesthesia.sysMng.po.BasUser;

/**
 * Title: PreVisitService.java Description: 描述
 * 
 * @author chengwang
 * @created 2015-10-10 下午5:32:33
 */
@Service
public class DocPreVisitService extends BaseService {
	/**
	 * 
	 * @discription 根据手术ID获取术前访视单信息
	 * @author chengwang
	 * @created 2015-10-10 下午5:13:48
	 * @param regOptId
	 * @return
	 */
	public DocPreVisit searchPreVisitByRegOptId(String regOptId) {
		return docPreVisitDao.searchPreVisitByRegOptId(regOptId);
	}

	/**
	 * 
	 * @discription 通过ID查询术前访视单
	 * @author chengwang
	 * @created 2015-10-20 下午1:44:32
	 * @param id
	 * @return
	 */
	public DocPreVisit searchPreVisitById(String id) {
		return docPreVisitDao.searchPreVisitById(id);
	}

	/**
	 * 
	 * @discription 保存术前访视单
	 * @author chengwang
	 * @created 2015-10-20 下午1:44:18
	 * @param preVisit
	 * @return
	 */
	@Transactional
	public ResponseValue updatePreVisitByDocId(DocPreVisit preVisit) {
	    setSelectValue(preVisit);
	    ResponseValue resp = new ResponseValue();
		if(preVisit==null){
			resp.setResultCode("30000001");
			resp.setResultMessage("术前访视单不存在!");
			return resp;
		}
		Controller controller = controllerDao.getControllerById(preVisit.getRegOptId()!=null?preVisit.getRegOptId():"");
		if(controller == null){
			resp.setResultCode("70000001");
			resp.setResultMessage("手术控制信息不存在!");
			return resp;
		}
		DocPreVisit oldPreVisit = searchPreVisitById(preVisit.getPreVisitId()!=null?preVisit.getPreVisitId():"");
		if(oldPreVisit==null){
			resp.setResultCode("30000001");
			resp.setResultMessage("术前访视单不存在!");
			return resp;
		}
		//if (controller.getState().equals(oldPreVisit.getState())) {
			docPreVisitDao.updatePreVisit(preVisit);
		/*} else {
			oldPreVisit.setFlag("0");
			docPreVisitDao.updatePreVisit(oldPreVisit);
			DocPreVisit newPreVisit = new DocPreVisit();
			BeanHelper.copyProperties(preVisit, newPreVisit);
			newPreVisit.setState(controller.getState());
			newPreVisit.setFlag("1");
			docPreVisitDao.insert(newPreVisit);
		}*/
		BasUser user = UserUtils.getUserCache();
		LogUtils.saveOperateLog(preVisit.getRegOptId(), "4",
            "2", "术前访视单修改", JsonType.jsonType(preVisit),user, getBeid());
		resp.setResultCode("1");
		resp.setResultMessage("术前访视单修改成功!");
		return resp;
	}

	private void setSelectValue(DocPreVisit preVisit) {
	    preVisit.setBriefHis(String.valueOf(preVisit.getBriefHisMap()));
	    preVisit.setHeartBoolCond(String.valueOf(preVisit.getHeartBoolCondMap()));
	    preVisit.setLungbreathCond(String.valueOf(preVisit.getLungbreathCondMap()));
	    preVisit.setBrainNerve(String.valueOf(preVisit.getBrainNerveMap()));
	    preVisit.setSpineLimb(String.valueOf(preVisit.getSpineLimbMap()));
	    preVisit.setBlood(String.valueOf(preVisit.getBloodMap()));
	    preVisit.setDigestion(String.valueOf(preVisit.getDigestionMap()));
	    preVisit.setEndocrine(String.valueOf(preVisit.getEndocrineMap()));
	    preVisit.setInfectious(String.valueOf(preVisit.getInfectiousMap()));
	    preVisit.setAirwayManage(String.valueOf(preVisit.getAirwayManageMap()));
	    preVisit.setSpecialHandle(String.valueOf(preVisit.getSpecialHandleMap()));
	    preVisit.setAnalgesicCond(String.valueOf(preVisit.getAnalgesicMap()));
	    preVisit.setMonitor(String.valueOf(preVisit.getMonitorMap()));
        preVisit.setToothAbnormalCond(String.valueOf(preVisit.getToothAbnormalMap()));
        preVisit.setAssayAbnormalCond(String.valueOf(preVisit.getAssayAbnormalMap()));
    }

    /**
	 * 查询未完成的术前访视单
	 * @param searchConditionFormBean
	 * @return
	 */
	public List<SearchMyOperationFormBean> searchNoEndPreVisit(SearchConditionFormBean searchConditionFormBean){
		searchConditionFormBean.setState("03,04,05,06");
		if(StringUtils.isEmpty(searchConditionFormBean.getSort())){
			searchConditionFormBean.setSort("operaDate");
		}
		if(StringUtils.isEmpty(searchConditionFormBean.getOrderBy())){
			searchConditionFormBean.setOrderBy("DESC");
		}
		
		BasUser user = basUserDao.get(searchConditionFormBean.getLoginName()!=null?searchConditionFormBean.getLoginName():"");
		
		return docPreVisitDao.searchNoEndPreVisit(user == null?"":user.getUserName(), searchConditionFormBean, getBeid());
	}
	
	/**
	 * 
	 * @discription 保存术前访视单
	 * @author chengwang
	 * @created 2015-10-20 下午1:44:18
	 * @param preVisit
	 * @return
	 */
	@Transactional
	public void savePreVisitByDocId(PreVisitFormBean preVisitFormBean,ResponseValue resp) {
		DocPreVisit preVisit = preVisitFormBean.getPreVisit();
		DocPrevisitAccessexam previsitAccessexam = preVisitFormBean.getPrevisitAccessexam();
		DocPrevisitAnaesplan previsitAnaesplan = preVisitFormBean.getPrevisitAnaesplan();
		DocPrevisitPhyexam previsitPhyexam = preVisitFormBean.getPrevisitPhyexam();
		
		if(preVisit==null){
			resp.setResultCode("30000001");
			resp.setResultMessage("术前访视单不存在!");
			return;
		}
		preVisit.setProcessState("END");
		Controller controller = controllerDao.getControllerById(preVisit.getRegOptId()!=null?preVisit.getRegOptId():"");
		if(controller == null){
			resp.setResultCode("70000001");
			resp.setResultMessage("手术控制信息不存在!");
			return;
		}
		String preVisitId = preVisit.getPreVisitId()!=null?preVisit.getPreVisitId():"";
		DocPreVisit oldPreVisit = searchPreVisitById(preVisitId);
		if(oldPreVisit==null){
			resp.setResultCode("30000001");
			resp.setResultMessage("术前访视单不存在!");
			return;
		}
		docPreVisitDao.updatePreVisit(preVisit);
		
		if(docPrevisitAccessexamDao.selectByPreVisitId(preVisitId)!=null){
			docPrevisitAccessexamDao.updateByPrimaryKeySelective(previsitAccessexam);
		}else{
			previsitAccessexam.setId(GenerateSequenceUtil.generateSequenceNo());
			docPrevisitAccessexamDao.insertSelective(previsitAccessexam);
		}
		if(docPrevisitAnaesplanDao.selectByPreVisitId(preVisitId)!=null){
			docPrevisitAnaesplanDao.updateByPrimaryKeySelective(previsitAnaesplan);
		}else{
			previsitAnaesplan.setId(GenerateSequenceUtil.generateSequenceNo());
			docPrevisitAnaesplanDao.insertSelective(previsitAnaesplan);
		}
		if(docPrevisitPhyexamDao.selectByPreVisitId(preVisitId)!=null){
			docPrevisitPhyexamDao.updateByPrimaryKeySelective(previsitPhyexam);
		}else{
			previsitPhyexam.setId(GenerateSequenceUtil.generateSequenceNo());
			docPrevisitPhyexamDao.insertSelective(previsitPhyexam);
		}
		
		BasUser user = UserUtils.getUserCache();
		LogUtils.saveOperateLog(preVisit.getRegOptId(), "4",
            "2", "术前访视单修改", JsonType.jsonType(preVisit),user, getBeid());
	}
}
