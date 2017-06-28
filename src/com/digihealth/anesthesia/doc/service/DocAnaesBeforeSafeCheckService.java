/**     
 * @discription 在此输入一句话描述此文件的作用
 * @author chengwang       
 * @created 2015-10-10 下午5:32:33    
 * tags     
 * see_to_target     
 */

package com.digihealth.anesthesia.doc.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.digihealth.anesthesia.basedata.po.Controller;
import com.digihealth.anesthesia.common.entity.ResponseValue;
import com.digihealth.anesthesia.common.service.BaseService;
import com.digihealth.anesthesia.doc.po.DocAnaesBeforeSafeCheck;
import com.digihealth.anesthesia.doc.po.DocExitOperSafeCheck;
import com.digihealth.anesthesia.doc.po.DocOperBeforeSafeCheck;
import com.digihealth.anesthesia.doc.po.DocSafeCheck;

/**
 * Title: AnaesBeforeSafeCheckService.java Description: 描述
 * 
 * @author chengwang
 * @created 2015-10-10 下午5:32:33
 */
@Service
public class DocAnaesBeforeSafeCheckService extends BaseService {
	/**
	 * 
	 * @discription 根据手术ID获取麻醉前核查
	 * @author chengwang
	 * @created 2015-10-10 下午5:13:48
	 * @param regOptId
	 * @return
	 */
	public DocAnaesBeforeSafeCheck searchAnaBeCheckByRegOptId(String regOptId) {
		return docAnaesBeforeSafeCheckDao.searchAnaBeCheckByRegOptId(regOptId);
	}

	/**
	 * 
	 * @discription 通过ID查询麻醉前核查
	 * @author chengwang
	 * @created 2015-10-20 下午1:44:32
	 * @param id
	 * @return
	 */
	public DocAnaesBeforeSafeCheck searchAnaBeCheckById(String id) {
		return docAnaesBeforeSafeCheckDao.searchAnaBeCheckById(id);
	}

	/**
	 * 
	 * @discription 保存麻醉前核查
	 * @author chengwang
	 * @created 2015-10-20 下午1:44:18
	 * @param preVisit
	 * @return
	 */
	@Transactional
	public ResponseValue updateAnaesBeforeSafeCheck(DocAnaesBeforeSafeCheck anaesBeforeSafeCheck) {
		ResponseValue resp = new ResponseValue();
		if (anaesBeforeSafeCheck == null) {
			resp.setResultCode("40000004");
			resp.setResultMessage("麻醉前核查单不存在!");
			return resp;
		}
		String regOptId = anaesBeforeSafeCheck.getRegOptId() != null ? anaesBeforeSafeCheck.getRegOptId() : "";
		Controller controller = controllerDao
				.getControllerById(regOptId);
		if (controller == null) {
			resp.setResultCode("70000001");
			resp.setResultMessage("手术控制信息不存在!");
			return resp;
		}
		DocAnaesBeforeSafeCheck oldAnaesBeforeSafeCheck = searchAnaBeCheckById(anaesBeforeSafeCheck
				.getAnesBeforeId() != null ? anaesBeforeSafeCheck.getAnesBeforeId()
				: "");
		if (oldAnaesBeforeSafeCheck == null) {
			resp.setResultCode("40000004");
			resp.setResultMessage("麻醉前核查单不存在!");
			return resp;
		}
		docAnaesBeforeSafeCheckDao.updateByPrimaryKey(anaesBeforeSafeCheck);
//		DocOperBeforeSafeCheck ob = docOperBeforeSafeCheckDao.searchOperBeCheckByRegOptId(regOptId);
//		DocExitOperSafeCheck eo = docExitOperSafeCheckDao.searchExitOperCheckByRegOptId(regOptId, getBeid());
//		if(ob!=null&&eo!=null){
//			if("END".equals(ob.getProcessState())&&"END".equals(eo.getProcessState())){
//				DocSafeCheck safeCheck = docSafeCheckDao.searchSafeCheckByRegOptId(regOptId, getBeid());
//				if(safeCheck!=null){
//					safeCheck.setProcessState("END");
//					docSafeCheckDao.updateSafeCheck(safeCheck);
//				}
//			}
//		}
		resp.setResultCode("1");
		resp.setResultMessage("手术安全核查单修改成功!");
		return resp;

	}

}
