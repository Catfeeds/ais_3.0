/**     
 * @discription 在此输入一句话描述此文件的作用
 * @author chengwang       
 * @created 2015-10-10 下午5:32:33    
 * tags     
 * see_to_target     
 */

package com.digihealth.anesthesia.doc.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.digihealth.anesthesia.basedata.config.OperationState;
import com.digihealth.anesthesia.basedata.po.BasRegOpt;
import com.digihealth.anesthesia.basedata.po.Controller;
import com.digihealth.anesthesia.basedata.po.BasInstrSuitRel;
import com.digihealth.anesthesia.basedata.po.BasInstrument;
import com.digihealth.anesthesia.basedata.utils.LogUtils;
import com.digihealth.anesthesia.basedata.utils.UserUtils;
import com.digihealth.anesthesia.common.entity.ResponseValue;
import com.digihealth.anesthesia.common.service.BaseService;
import com.digihealth.anesthesia.common.utils.JsonType;
import com.digihealth.anesthesia.doc.formbean.OptNurseInstrubillItemFormbean;
import com.digihealth.anesthesia.doc.po.DocAnaesRecord;
import com.digihealth.anesthesia.doc.po.DocInstrubillItem;
import com.digihealth.anesthesia.doc.po.DocOptNurse;
import com.digihealth.anesthesia.sysMng.po.BasUser;

/**
 * Title: OptNurseService.java Description: 描述
 * 
 * @author chengwang
 * @created 2015-10-10 下午5:32:33
 */
@Service
public class DocOptNurseService extends BaseService {
	@Autowired
	private DocInstrubillItemService instrubillItemService;

	/**
	 * 
	 * @discription 根据手术ID获取手术护理
	 * @author chengwang
	 * @created 2015-10-10 下午5:13:48
	 * @param regOptId
	 * @return
	 */
	public DocOptNurse searchOptNurseByRegOptId(String regOptId) {
		DocOptNurse opt = null;
		DocAnaesRecord anaesRecord = docAnaesRecordDao.searchAnaesRecordByRegOptId(regOptId);
		if (anaesRecord != null) {
			opt = docOptNurseDao.searchOptNurseByRegOptId(regOptId);
			if (opt != null) {
				Integer bleeding = evtEgressDao.getEgressCountValueByIoDef("25", anaesRecord.getAnaRecordId())==null?0:evtEgressDao.getEgressCountValueByIoDef("25", anaesRecord.getAnaRecordId());
				opt.setBleeding(bleeding); //失血量
				Integer urine = evtEgressDao.getEgressCountValueByIoDef("26", anaesRecord.getAnaRecordId()) == null ?0:evtEgressDao.getEgressCountValueByIoDef("26", anaesRecord.getAnaRecordId());
				opt.setUrine(urine);	//尿量
				Integer infusion = evtInEventDao.getIoeventCountValueByIoDef(anaesRecord.getAnaRecordId(),null) == null?0:evtInEventDao.getIoeventCountValueByIoDef(anaesRecord.getAnaRecordId(),null);
				opt.setInfusion(infusion);		//输液
			}
		}
		return opt;
	}

	/**
	 * 
	 * @discription 通过ID查询麻醉同意书
	 * @author chengwang
	 * @created 2015-10-20 下午1:44:32
	 * @param id
	 * @return
	 */
	public DocOptNurse searchOptNurseById(String id) {
		return docOptNurseDao.searchOptNurseById(id);
	}

	/**
	 * 
	 * @discription 插入器械
	 * @author chengwang
	 * @created 2015-10-22 下午2:43:18
	 * @param regOptId
	 * @param optNurseId
	 * @param instrumentCode
	 * @param instrsuitCode
	 * @return
	 */
	@Transactional
	public List<DocInstrubillItem> insertInstubillItem(String regOptId,
			String optNurseId, String instrumentId, String instrsuitId) {
		List<DocInstrubillItem> list = new ArrayList<DocInstrubillItem>();
		BasInstrument instrument = null;
		if (StringUtils.isNotBlank(instrumentId)) {
			DocInstrubillItem instrubillItemSql = docInstrubillItemDao
					.searchInstrubillItemByCodeAndRegOptId(regOptId,
							instrumentId);
			if (instrubillItemSql == null) {
				instrument = basInstrumentDao.searchInstrumentByInstrumentId(instrumentId+"");
				if (instrument != null) {
					// List<InstrubillItem> instrubillItemList =
					// instrubillItemDao.searchInstrubillItemByInstrumentId(instrument.getInstrumentId());
					// if(instrubillItemList==null||instrubillItemList.size()<=0){
					DocInstrubillItem instrubillItem = instrubillItemService.insertInstrubillItemByOptNurseIdAndRegOptId(regOptId, optNurseId, instrument, null);
					list.add(instrubillItem);
					// }
				}
			} else {
				return list;
			}
		} else if (StringUtils.isNotBlank(instrsuitId)) {
			List<BasInstrSuitRel> instrSuitRelList = basInstrSuitRelDao
					.searchInstrumentCodeByInstrsuitCode(instrsuitId+"");
			if (instrSuitRelList.size() > 0 && instrSuitRelList != null) {
				for (int i = 0; i < instrSuitRelList.size(); i++) {

					instrument = basInstrumentDao
							.searchInstrumentByInstrumentId(instrSuitRelList
									.get(i).getInstrumentId());
					if (instrument != null) {
						DocInstrubillItem instrubillItemSql = docInstrubillItemDao
								.searchInstrubillItemByCodeAndRegOptId(regOptId, instrument.getInstrumentId());
						if (instrubillItemSql == null) {
							
							DocInstrubillItem instrubillItem = instrubillItemService.insertInstrubillItemByOptNurseIdAndRegOptId(
											regOptId, optNurseId, instrument,
											instrSuitRelList.get(i));
							list.add(instrubillItem);
						}
						// List<InstrubillItem> instrubillItemList =
						// instrubillItemDao.searchInstrubillItemByInstrumentId(instrument.getInstrumentId());
						// if(instrubillItemList==null||instrubillItemList.size()<=0){

						// }

					}

				}
			}
		}

		return list;
	}

	/**
	 * 
	 * @discription 保存手术护理
	 * @author chengwang
	 * @created 2015-10-20 下午1:44:18
	 * @param preVisit
	 * @return
	 */
	@Transactional
	public ResponseValue updateOptNurse(OptNurseInstrubillItemFormbean optNurseItem) {
		ResponseValue resp = new ResponseValue();
		DocOptNurse optNurse = optNurseItem.getOptNurse();
		if(optNurse.getShuHouState() == 1){
			Controller controller = controllerDao.getControllerById(optNurse.getRegOptId());
			if(null != controller){
				if(controller.getIsLocalAnaes().equals("1")){
					controller.setState(OperationState.POSTOPERATIVE);
					controllerDao.update(controller);
				}
				
			}
		}
		//optNurse.setProcessState("END");
		Controller controller = controllerDao.getControllerById(optNurse
				.getRegOptId() != null ? optNurse.getRegOptId() : "");
		
		BasRegOpt regOpt = basRegOptDao.searchRegOptById(optNurse
				.getRegOptId() != null ? optNurse.getRegOptId() : "");
		
		if (controller == null) {
			resp.setResultCode("70000001");
			resp.setResultMessage("手术控制信息不存在!");
			return resp;
		}
		DocOptNurse oldOptNurse = searchOptNurseById(optNurse.getOptNurseId() != null ? optNurse
				.getOptNurseId() : "");
		if (oldOptNurse == null) {
			resp.setResultCode("40000002");
			resp.setResultMessage("护理记录单不存在");
			return resp;
		}
		// 如果状态没发生改变，直接修改数据
		//if (controller.getState().equals(oldOptNurse.getState())) {
			List<String> preCircunurseList = optNurse.getPreCircunurseList();
			List<String> midCircunurseList = optNurse.getMidCircunurseList();
			List<String> postCircunurseList = optNurse.getPostCircunurseList();
			String preCircunurseId = "";
			String midCircunurseId = "";
			String postCircunurseId = "";
			if (preCircunurseList != null) {
				for (String id : preCircunurseList) {
					if (StringUtils.isBlank(preCircunurseId)) {
						preCircunurseId = id;
					}else {
						preCircunurseId += "," + id;
					}
				}
			}
			if (midCircunurseList != null) {
				for (String id : midCircunurseList) {
					if (StringUtils.isBlank(midCircunurseId)) {
						midCircunurseId = id;
					}else {
						midCircunurseId += "," + id;
					}
				}
			}
			if (postCircunurseList != null) {
				for (String id : postCircunurseList) {
					if (StringUtils.isBlank(postCircunurseId)) {
						postCircunurseId = id;
					}else {
						postCircunurseId += "," + id;
					}
				}
			}
			optNurse.setPreCircunurseId(preCircunurseId);
			optNurse.setMidCircunurseId(midCircunurseId);
			optNurse.setPostCircunurseId(postCircunurseId);
			docOptNurseDao.updateByPrimaryKey(optNurse);
			if (optNurseItem.getInstrubillItems().size() > 0
					&& optNurseItem.getInstrubillItems() != null) {
				for (int i = 0; i < optNurseItem.getInstrubillItems().size(); i++) {
					docInstrubillItemDao.updateInstrubillItem(optNurseItem
							.getInstrubillItems().get(i));
				}
			}
		/*} else {
			// 如果状态发生改变，手术护理表新增一条数据为新的有用的数据，上个数据flag=0作为历史数据
			oldOptNurse.setFlag("0");
			optNurseDao.updateOptNurse(oldOptNurse);
			OptNurse newOptNurse = new OptNurse();
			BeanHelper.copyProperties(optNurse, newOptNurse);
			newOptNurse.setState(controller.getState());
			newOptNurse.setFlag("1");
			optNurseDao.insert(newOptNurse);
			// 器械先读出原先的数据 写入历史表，并把原先的数据在主表删除，然后把新的数据插入主表
			List<InstrubillItem> oldInstrubillItemList = instrubillItemDao
					.searchInstrubillItemByRegOptId(optNurseItem.getOptNurse()
							.getRegOptId());
			if (oldInstrubillItemList != null
					&& oldInstrubillItemList.size() > 0) {
				for (int i = 0; i < oldInstrubillItemList.size(); i++) {
					instrubillItemDao
							.insertInstrubillItemHis(oldInstrubillItemList
									.get(i));
					instrubillItemDao
							.deleteInstrubillItem(oldInstrubillItemList.get(i)
									.getInstruItemId());
				}
			}
			if (optNurseItem.getInstrubillItems().size() > 0
					&& optNurseItem.getInstrubillItems() != null) {
				for (int i = 0; i < optNurseItem.getInstrubillItems().size(); i++) {
					InstrubillItem newInstrubillItem = new InstrubillItem();
					BeanHelper.copyProperties(optNurseItem.getInstrubillItems()
							.get(i), newInstrubillItem);
					newInstrubillItem.setState(controller.getState());
					instrubillItemDao.insert(newInstrubillItem);
				}
			}
		}*/
//		if("1".equals(regOpt.getIsLocalAnaes())){
//			controllerDao.checkOperation(optNurse
//				.getRegOptId() != null ? optNurse.getRegOptId() : "", OperationState.POSTOPERATIVE, controller.getState());
//		}
		BasUser user = UserUtils.getUserCache();
		LogUtils.saveOperateLog(regOpt.getRegOptId(), "4",
            "2", "手术护理单修改", JsonType.jsonType(optNurseItem),user, getBeid());
		resp.setResultCode("1");
		resp.setResultMessage("护理器械单修改成功!");
		return resp;
	}

}
