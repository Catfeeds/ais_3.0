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
import com.digihealth.anesthesia.doc.po.DocNerveBlock;
import com.digihealth.anesthesia.evt.formbean.SearchFormBean;

/**
 * Title: NerveBlockService.java Description: 神经阻滞
 * 
 * @author liukui
 * @created 2015-10-10 下午5:32:33
 */
@Service
public class DocNerveBlockService extends BaseService {
	/**
	 * 
	 * @discription 根据ID神经阻滞
	 * @author liukui
	 * @created 2015-10-10 下午5:13:48
	 * @param SearchFormBean
	 * @return
	 */
	public List<DocNerveBlock> searchNerveBlockList(SearchFormBean searchBean) {
		return docNerveBlockDao.searchNerveBlockList(searchBean);
	}
	/**
	 * 新增神经阻滞
	 * @param NerveBlock
	 * @return
	 */
	@Transactional
	public String insertNerveBlock(DocNerveBlock nerveBlock){
		nerveBlock.setNerveBlockId(GenerateSequenceUtil.generateSequenceNo());
		docNerveBlockDao.insert(nerveBlock);
		return "true";
	}
	/**
	 * 
	 * @discription 保存神经阻滞
	 * @author liukui
	 * @created 2015-10-20 下午1:44:18
	 * @param preVisit
	 * @return
	 */
	@Transactional
	public String updateNerveBlock(DocNerveBlock nerveBlock) {
		docNerveBlockDao.updateByPrimaryKey(nerveBlock);
		LogUtils.saveOperateLog("", "4",
            "2", "麻醉记录单二中神经阻滞修改", JsonType.jsonType(nerveBlock),UserUtils.getUserCache(), getBeid());
		return "true";
	}

}
