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
import com.digihealth.anesthesia.common.utils.StringUtils;
import com.digihealth.anesthesia.doc.po.DocAnaesBeforeSafeCheck;
import com.digihealth.anesthesia.doc.po.DocExitOperSafeCheck;
import com.digihealth.anesthesia.doc.po.DocOperBeforeSafeCheck;
import com.digihealth.anesthesia.doc.po.DocSafeCheck;
import com.digihealth.anesthesia.sysMng.po.BasUser;

/**
 * Title: OperBeforeSafeCheckService.java Description: 描述
 * 
 * @author chengwang
 * @created 2015-10-10 下午5:32:33
 */
@Service
public class DocOperBeforeSafeCheckService extends BaseService {
	/**
	 * 
	 * @discription 根据手术ID获取手术前核查
	 * @author chengwang
	 * @created 2015-10-10 下午5:13:48
	 * @param regOptId
	 * @return
	 */
	public DocOperBeforeSafeCheck searchOperBeCheckByRegOptId(String regOptId) {
		return docOperBeforeSafeCheckDao.searchOperBeCheckByRegOptId(regOptId);
	}

	/**
	 * 
	 * @discription 通过ID查询手术前核查
	 * @author chengwang
	 * @created 2015-10-20 下午1:44:32
	 * @param id3
	 * @return
	 */
	public DocOperBeforeSafeCheck searchOperBeCheckById(String id) {
		return docOperBeforeSafeCheckDao.searchOperBeCheckById(id);
	}

	/**
	 * 
	 * @discription 保存手术前核查
	 * @author chengwang
	 * @created 2015-10-20 下午1:44:18
	 * @param preVisit
	 * @return
	 */
	@Transactional
	public ResponseValue updateOperBeforeSafeCheck(DocOperBeforeSafeCheck operBeforeSafeCheck) {
		ResponseValue resp = new ResponseValue();
		if (operBeforeSafeCheck == null) {
			resp.setResultCode("40000005");
			resp.setResultMessage("手术前核查单不存在!");
			return resp;
		}
		String regOptId = operBeforeSafeCheck.getRegOptId() != null ? operBeforeSafeCheck.getRegOptId() : "";
		Controller controller = controllerDao.getControllerById(regOptId);
		if (controller == null) {
			resp.setResultCode("70000001");
			resp.setResultMessage("手术控制信息不存在!");
			return resp;
		}
		DocOperBeforeSafeCheck oldOperBeforeSafeCheck = searchOperBeCheckById(operBeforeSafeCheck.getOperBeforeId() != null ? operBeforeSafeCheck.getOperBeforeId() : "");
		if (oldOperBeforeSafeCheck == null) {
            resp.setResultCode("40000005");
            resp.setResultMessage("手术前核查单不存在!");
            return resp;
        }
		
		operBeforeSafeCheck.setAnesthetistId(StringUtils.getStringByList(operBeforeSafeCheck.getAnesthetistList()));
        operBeforeSafeCheck.setOperatorId(StringUtils.getStringByList(operBeforeSafeCheck.getOperatorList()));
        operBeforeSafeCheck.setCircuNurseId(StringUtils.getStringByList(operBeforeSafeCheck.getCircunurseList()));
		
		
		//if (controller.getState().equals(oldOperBeforeSafeCheck.getState())) {
		docOperBeforeSafeCheckDao.updateByPrimaryKey(operBeforeSafeCheck);
		/*} else {
			oldOperBeforeSafeCheck.setFlag("0");
			operBeforeSafeCheckDao.updateOperBeCheck(oldOperBeforeSafeCheck);
			OperBeforeSafeCheck newOperBeforeSafeCheck = new OperBeforeSafeCheck();
			BeanHelper.copyProperties(operBeforeSafeCheck,
					newOperBeforeSafeCheck);
			newOperBeforeSafeCheck.setState(controller.getState());
			newOperBeforeSafeCheck.setFlag("1");
			operBeforeSafeCheckDao.insert(newOperBeforeSafeCheck);
		}
		DocAnaesBeforeSafeCheck ab = docAnaesBeforeSafeCheckDao.searchAnaBeCheckByRegOptId(regOptId);
		DocExitOperSafeCheck eo = docExitOperSafeCheckDao.searchExitOperCheckByRegOptId(regOptId, getBeid());
		if(ab!=null&&eo!=null){
			if("END".equals(ab.getProcessState())&&"END".equals(eo.getProcessState())){
				DocSafeCheck safeCheck = docSafeCheckDao.searchSafeCheckByRegOptId(regOptId, getBeid());
				if(safeCheck!=null){
					safeCheck.setProcessState("END");
					docSafeCheckDao.updateSafeCheck(safeCheck);
				}
			}
		}*/
		BasUser user = UserUtils.getUserCache();
		LogUtils.saveOperateLog(regOptId, "4",
            "2", "手术前核查单修改", JsonType.jsonType(operBeforeSafeCheck),user, getBeid());
		resp.setResultCode("1");
		resp.setResultMessage("手术安全核查单修改成功!");
		return resp;
	}

}
