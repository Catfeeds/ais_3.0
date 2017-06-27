/**     
 * @discription 在此输入一句话描述此文件的作用
 * @author liukui       
 * @created 2015-10-10 下午5:32:33    
 * tags     
 * see_to_target     
 */

package com.digihealth.anesthesia.doc.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.digihealth.anesthesia.basedata.utils.LogUtils;
import com.digihealth.anesthesia.basedata.utils.UserUtils;
import com.digihealth.anesthesia.common.service.BaseService;
import com.digihealth.anesthesia.common.utils.GenerateSequenceUtil;
import com.digihealth.anesthesia.common.utils.JsonType;
import com.digihealth.anesthesia.doc.po.DocSpinalCanalPuncture;
import com.digihealth.anesthesia.evt.formbean.SearchFormBean;

/**
 * Title: SpinalCanalPunctureService.java Description: 椎管内穿刺记录
 * 
 * @author liukui
 * @created 2015-10-10 下午5:32:33
 */
@Service
public class DocSpinalCanalPunctureService extends BaseService {
	/**
	 * 
	 * @discription 查询麻醉总结表中椎管内穿刺记录
	 * @author liukui
	 * @created 2015-10-10 下午5:13:48
	 * @param SearchFormBean
	 * @return
	 */
	public List<DocSpinalCanalPuncture> searchSpinalCanalPunctureList(SearchFormBean searchBean) {
		return docSpinalCanalPunctureDao.searchSpinalCanalPunctureList(searchBean);
	}
	/**
	 * 新增麻醉总结
	 * @param SpinalCanalPuncture
	 * @return
	 */
	@Transactional
	public String insertSpinalCanalPuncture(DocSpinalCanalPuncture spinalCanalPuncture){
		spinalCanalPuncture.setSpinalCanalId(GenerateSequenceUtil.generateSequenceNo());
		docSpinalCanalPunctureDao.insert(spinalCanalPuncture);
		return "true";
	}
	/**
	 * 
	 * @discription 保存麻醉总结
	 * @author liukui
	 * @created 2015-10-20 下午1:44:18
	 * @param preVisit
	 * @return
	 */
	@Transactional
	public String updateSpinalCanalPuncture(DocSpinalCanalPuncture spinalCanalPuncture) {
		docSpinalCanalPunctureDao.update(spinalCanalPuncture);
		LogUtils.saveOperateLog("", "4",
            "2", "椎管内穿刺修改", JsonType.jsonType(spinalCanalPuncture),UserUtils.getUserCache(), getBeid());
		return "true";
	}

}
