/**     
 * @discription 在此输入一句话描述此文件的作用
 * @author chengwang       
 * @created 2015-10-10 下午5:32:33    
 * tags     
 * see_to_target     
 */

package com.digihealth.anesthesia.doc.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.digihealth.anesthesia.sysMng.po.BasUser;
import com.digihealth.anesthesia.basedata.po.BasInstrSuitRel;
import com.digihealth.anesthesia.basedata.po.BasInstrument;
import com.digihealth.anesthesia.basedata.utils.UserUtils;
import com.digihealth.anesthesia.common.service.BaseService;
import com.digihealth.anesthesia.common.utils.DateUtils;
import com.digihealth.anesthesia.common.utils.GenerateSequenceUtil;
import com.digihealth.anesthesia.doc.po.DocInstrubillItem;
import com.digihealth.anesthesia.doc.po.DocOptNurse;


/**
 * Title: OptNurseService.java Description: 描述
 * 
 * @author chengwang
 * @created 2015-10-10 下午5:32:33
 */
@Service
public class DocInstrubillItemService extends BaseService {

	/**
	 * 
	 * @discription 根据手术ID获取手术器械
	 * @author chengwang
	 * @created 2015-10-10 下午5:13:48
	 * @param regOptId
	 * @return
	 */
	public List<DocInstrubillItem> searchInstrubillItemByRegOptId(String regOptId) {
		return docInstrubillItemDao.searchInstrubillItemByRegOptId(regOptId);
	}

	/**
	 * 
	 * @discription 通过ID查询手术器械
	 * @author chengwang
	 * @created 2015-10-20 下午1:44:32
	 * @param id
	 * @return
	 */
	public DocInstrubillItem searchInstrubillItemById(String id) {
		return docInstrubillItemDao.searchInstrubillItemById(id);
	}
	
	/**
	 * 
	     * @discription 插入一条新的器械
	     * @author chengwang       
	     * @created 2015-10-22 下午1:59:04     
	     * @param map
	     * @return
	 */
	@Transactional
	public DocInstrubillItem insertInstrubillItemByOptNurseIdAndRegOptId(String regOptId,String optNurseId,BasInstrument instrument,BasInstrSuitRel instrSuitRel){
		DocOptNurse optNurse = docOptNurseDao.searchOptNurseById(optNurseId);
		BasUser user = UserUtils.getUserCache();
		DocInstrubillItem instrubillItem = new DocInstrubillItem();
		instrubillItem.setInstruItemId(GenerateSequenceUtil.generateSequenceNo());
		instrubillItem.setInstrumentId(instrument.getInstrumentId());
		instrubillItem.setCloAfBody(0);
		instrubillItem.setCloBeBody(0);
		instrubillItem.setCreateTime(new Date());
		if(user !=null){
			instrubillItem.setCreateUser(user.getUserName());
		}
		instrubillItem.setInstruItemName(instrument.getName());
		instrubillItem.setInadd(0);
		if(instrSuitRel == null){
			instrubillItem.setOrigamount(0);
		}else{
			instrubillItem.setOrigamount(instrSuitRel.getAmount());
		}
		
		instrubillItem.setRegOptId(regOptId);
		docInstrubillItemDao.insert(instrubillItem);
		return instrubillItem;
	}

	/**
	 * 
	     * @discription 删除器械
	     * @author chengwang       
	     * @created 2015-10-22 下午4:41:48     
	     * @param id
	 */
	@Transactional
	public int deleteInstrubillItem(String id){
		return docInstrubillItemDao.deleteByPrimaryKey(id);
	}

}
