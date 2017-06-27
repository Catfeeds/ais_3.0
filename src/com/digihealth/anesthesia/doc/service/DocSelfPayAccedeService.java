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
import com.digihealth.anesthesia.common.entity.ResponseValue;
import com.digihealth.anesthesia.common.service.BaseService;
import com.digihealth.anesthesia.common.utils.GenerateSequenceUtil;
import com.digihealth.anesthesia.common.utils.JsonType;
import com.digihealth.anesthesia.doc.po.DocSelfPayAccede;
import com.digihealth.anesthesia.sysMng.po.BasUser;


@Service
public class DocSelfPayAccedeService extends BaseService {

	public List<DocSelfPayAccede> searchSelfPayAccedeByRegOptId(String regOptId,String type) {
		return docSelfPayAccedeDao.searchSelfPayAccedeByRegOptId(regOptId,type);
	}
	
	public DocSelfPayAccede searchSelfPayAccedeById(String id) {
		return docSelfPayAccedeDao.searchSelfPayAccedeById(id);
	}
	
	@Transactional
	public ResponseValue updateSelfPayAccede(DocSelfPayAccede selfPayAccede) {
		ResponseValue resp = new ResponseValue();
		Controller controller = controllerDao.getControllerById(selfPayAccede.getRegOptId()!=null?selfPayAccede.getRegOptId():"");
		if(controller == null){
			resp.setResultCode("70000001");
			resp.setResultMessage("手术控制信息不存在!");
			return resp;
		}
		selfPayAccede.setState(controller.getState());
		if(selfPayAccede!=null&&(!org.apache.commons.lang3.StringUtils.isEmpty(selfPayAccede.getId()))){
			docSelfPayAccedeDao.updateByPrimaryKeySelective(selfPayAccede);
		}else{
			selfPayAccede.setId(GenerateSequenceUtil.generateSequenceNo());
			docSelfPayAccedeDao.insert(selfPayAccede);
		}
		BasUser user = UserUtils.getUserCache();
		LogUtils.saveOperateLog(selfPayAccede.getRegOptId(), "4",
            "2", "医保病人麻醉科自费项目同意书修改", JsonType.jsonType(selfPayAccede),user, getBeid());
		resp.setResultCode("1");
		resp.setResultMessage("更新药品和其他项目成功!");
		return resp;
	}
	
	@Transactional
	public int deleteByPrimaryKey(String id){
		return docSelfPayAccedeDao.deleteByPrimaryKey(id);
	}

}
