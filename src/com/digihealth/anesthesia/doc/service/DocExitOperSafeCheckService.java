/**     
 * @discription 在此输入一句话描述此文件的作用
 * @author chengwang       
 * @created 2015-10-10 下午5:32:33    
 * tags     
 * see_to_target     
 */

package com.digihealth.anesthesia.doc.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.digihealth.anesthesia.basedata.po.Controller;
import com.digihealth.anesthesia.basedata.utils.LogUtils;
import com.digihealth.anesthesia.basedata.utils.UserUtils;
import com.digihealth.anesthesia.common.entity.ResponseValue;
import com.digihealth.anesthesia.common.service.BaseService;
import com.digihealth.anesthesia.common.utils.JsonType;
import com.digihealth.anesthesia.doc.po.DocAnaesBeforeSafeCheck;
import com.digihealth.anesthesia.doc.po.DocExitOperSafeCheck;
import com.digihealth.anesthesia.doc.po.DocOperBeforeSafeCheck;
import com.digihealth.anesthesia.doc.po.DocSafeCheck;
import com.digihealth.anesthesia.sysMng.po.BasUser;

/**
 * Title: ExitOperforeSafeCheckService.java Description: 描述
 * 
 * @author chengwang
 * @created 2015-10-10 下午5:32:33
 */
@Service
public class DocExitOperSafeCheckService extends BaseService {
	/**
	 * 
	 * @discription 根据手术ID获取出手术室核查
	 * @author chengwang
	 * @created 2015-10-10 下午5:13:48
	 * @param regOptId
	 * @return
	 */
	public DocExitOperSafeCheck searchExitOperCheckByRegOptId(String regOptId) {
		return docExitOperSafeCheckDao.searchExitOperCheckByRegOptId(regOptId, getBeid());
	}

	/**
	 * 
	 * @discription 通过ID查询出手术室核查
	 * @author chengwang
	 * @created 2015-10-20 下午1:44:32
	 * @param id3
	 * @return
	 */
	public DocExitOperSafeCheck searchExitOperCheckById(String id) {
		return docExitOperSafeCheckDao.searchExitOperCheckById(id, getBeid());
	}

	/**
	 * 
	 * @discription 保存出入手术室核查
	 * @author chengwang
	 * @created 2015-10-20 下午1:44:18
	 * @param preVisit
	 * @return
	 */
	@Transactional
	public ResponseValue updateExitOperSafeCheck(DocExitOperSafeCheck exitOperSafeCheck,String processState) {
		ResponseValue resp = new ResponseValue();
		if (exitOperSafeCheck == null) {
			resp.setResultCode("40000006");
			resp.setResultMessage("出手术室前核查单不存在!");
			return resp;
		}
		String regOptId = exitOperSafeCheck.getRegOptId() != null ? exitOperSafeCheck.getRegOptId() : "";
		Controller controller = controllerDao
				.getControllerById(regOptId);
		if (controller == null) {
			resp.setResultCode("70000001");
			resp.setResultMessage("手术控制信息不存在!");
			return resp;
		}
		DocExitOperSafeCheck oldExitOperSafeCheck = searchExitOperCheckById(exitOperSafeCheck
				.getExitOperId() != null ? exitOperSafeCheck.getExitOperId()
				: "");
		if (oldExitOperSafeCheck == null) {
			resp.setResultCode("40000006");
			resp.setResultMessage("出手术室前核查单不存在!");
			return resp;
		}
		//if (controller.getState().equals(oldExitOperSafeCheck.getState())) {
			docExitOperSafeCheckDao.updateExitOperCheck(exitOperSafeCheck);
		/*} else {
			oldExitOperSafeCheck.setFlag("0");
			docExitOperSafeCheckDao.updateExitOperCheck(oldExitOperSafeCheck);
			ExitOperSafeCheck newExitOperSafeCheck = new ExitOperSafeCheck();
			BeanHelper.copyProperties(exitOperSafeCheck, newExitOperSafeCheck);
			newExitOperSafeCheck.setState(controller.getState());
			newExitOperSafeCheck.setFlag("1");
			docExitOperSafeCheckDao.insert(newExitOperSafeCheck);
		}*/
		if("END".equals(processState)){
			DocSafeCheck safeCheck = docSafeCheckDao.searchSafeCheckByRegOptId(regOptId, getBeid());
			if(safeCheck!=null){
				safeCheck.setProcessState("END");
				docSafeCheckDao.updateSafeCheck(safeCheck);
			}
		}
		/*DocAnaesBeforeSafeCheck ab = docAnaesBeforeSafeCheckDao.searchAnaBeCheckByRegOptId(regOptId);
		DocOperBeforeSafeCheck ob = docOperBeforeSafeCheckDao.searchOperBeCheckByRegOptId(regOptId);
		if(ob!=null&&ab!=null){
			if("END".equals(ob.getProcessState())&&"END".equals(ab.getProcessState())){
				DocSafeCheck safeCheck = docSafeCheckDao.searchSafeCheckByRegOptId(regOptId, getBeid());
				if(safeCheck!=null){
					safeCheck.setProcessState("END");
					docSafeCheckDao.updateSafeCheck(safeCheck);
				}
			}
		}*/
		BasUser user = UserUtils.getUserCache();
		LogUtils.saveOperateLog(regOptId, "4", "2", "离开手术室核查单修改", JsonType.jsonType(exitOperSafeCheck),user, getBeid());
		resp.setResultCode("1");
		resp.setResultMessage("手术安全核查单修改成功!");
		return resp;
	}

}
