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
import com.digihealth.anesthesia.doc.po.DocGeneralAnaes;
import com.digihealth.anesthesia.evt.formbean.SearchFormBean;

/**
 * Title: GeneralAnaesService.java Description:  全身麻醉表
 * 
 * @author liukui
 * @created 2015-10-10 下午5:32:33
 */
@Service
public class DocGeneralAnaesService extends BaseService {
	/**
	 * 
	 * @discription 根据手术ID获取麻醉总结单
	 * @author liukui
	 * @created 2015-10-10 下午5:13:48
	 * @param SearchFormBean
	 * @return
	 */
	public List<DocGeneralAnaes> searchGeneralAnaesList(SearchFormBean searchBean) {
		return docGeneralAnaesDao.searchGeneralAnaesList(searchBean);
	}
	/**
	 * 新增麻醉总结
	 * @param GeneralAnaes
	 * @return
	 */
	@Transactional
	public String insertGeneralAnaes(DocGeneralAnaes generalAnaes){
		generalAnaes.setGeneralAnaesId(GenerateSequenceUtil.generateSequenceNo());
		docGeneralAnaesDao.insert(generalAnaes);
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
	public String updateGeneralAnaes(DocGeneralAnaes generalAnaes) {
		docGeneralAnaesDao.updateByPrimaryKey(generalAnaes);
		LogUtils.saveOperateLog("", "4",
            "2", "麻醉记录单二中全身麻醉修改", JsonType.jsonType(generalAnaes),UserUtils.getUserCache(), getBeid());
		return "true";
	}

}
