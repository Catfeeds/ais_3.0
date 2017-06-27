package com.digihealth.anesthesia.doc.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.digihealth.anesthesia.basedata.po.Controller;
import com.digihealth.anesthesia.basedata.utils.UserUtils;
import com.digihealth.anesthesia.common.entity.ResponseValue;
import com.digihealth.anesthesia.common.service.BaseService;
import com.digihealth.anesthesia.common.utils.GenerateSequenceUtil;
import com.digihealth.anesthesia.common.utils.JsonType;
import com.digihealth.anesthesia.doc.formbean.AccedeFormBean;
import com.digihealth.anesthesia.doc.po.DocAccede;
import com.digihealth.anesthesia.doc.po.DocAccedeInformed;
import com.digihealth.anesthesia.sysMng.po.BasUser;

@Service
public class DocAccedeService extends BaseService {

	/**
	 * 
	 * @discription 根据手术ID获取麻醉同意书信息
	 * @author chengwang
	 * @created 2015-10-10 下午5:13:48
	 * @param regOptId
	 * @return
	 */
	public DocAccede searchAccedeByRegOptId(String regOptId) {
		return docAccedeDao.searchAccedeByRegOptId(regOptId);
	}

	/**
	 * 
	 * @discription 通过ID查询麻醉同意书
	 * @author chengwang
	 * @created 2015-10-20 下午1:44:32
	 * @param id
	 * @return
	 */
	public DocAccede searchAccedeById(String id) {
		return docAccedeDao.searchAccedeById(id);
	}

	public List<DocAccedeInformed> searchAccedeInformedListById(String accedeId) {
		return docAccedeInformedDao.queryAccedeInformList(accedeId);
	}
	
	/**
	 * 
	 * @discription 保存麻醉同意书
	 * @author chengwang
	 * @created 2015-10-20 下午1:44:18
	 * @param preVisit
	 * @return
	 */
	@Transactional
	public ResponseValue updateAccede(AccedeFormBean accedeFormBean) {
		ResponseValue resp = new ResponseValue();
		Map map = new HashMap();
		if(accedeFormBean==null){
			resp.setResultCode("30000002");
			resp.setResultMessage("麻醉同意书不存在!");
			return resp;
		}
		Controller controller = controllerDao.getControllerById(accedeFormBean.getAccede()
				.getRegOptId()!=null?accedeFormBean.getAccede()
						.getRegOptId():"");
		if(controller == null){
			resp.setResultCode("70000001");
			resp.setResultMessage("手术控制信息不存在!");
			return resp;
		}
		DocAccede oldAccede = searchAccedeById(accedeFormBean.getAccede().getAccedeId()!=null?accedeFormBean.getAccede()
						.getAccedeId():"");
		if(oldAccede == null){
			resp.setResultCode("30000002");
			resp.setResultMessage("麻醉同意书不存在!");
			return resp;
		}
		DocAccede accede = new DocAccede();
		BeanUtils.copyProperties(accedeFormBean.getAccede(), accede, new String[]{"cureContent"});
		if(null != accedeFormBean.getAccede().getCureContent()){
			accede.setCureContent(JsonType.jsonType(accedeFormBean.getAccede().getCureContent()));
		}
		docAccedeDao.updateAccede(accede);
		docAccedeInformedDao.deleteByAccedeId(accede.getAccedeId());
		List<DocAccedeInformed> rs = accedeFormBean.getAccedeInformedList();
		for (DocAccedeInformed accedeInformed : rs) {
			accedeInformed.setAccedeId(accede.getAccedeId());
			accedeInformed.setAnasInformedId(GenerateSequenceUtil.generateSequenceNo());
			docAccedeInformedDao.insert(accedeInformed);
		}
		resp.setResultCode("1");
		resp.setResultMessage("麻醉同意书修改成功!");
		return resp;
	}
}
