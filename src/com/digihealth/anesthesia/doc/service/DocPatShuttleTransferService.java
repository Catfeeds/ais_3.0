package com.digihealth.anesthesia.doc.service;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.digihealth.anesthesia.common.entity.ResponseValue;
import com.digihealth.anesthesia.common.service.BaseService;
import com.digihealth.anesthesia.common.utils.GenerateSequenceUtil;
import com.digihealth.anesthesia.common.utils.JsonType;
import com.digihealth.anesthesia.doc.formbean.PatShuttleFormbean;
import com.digihealth.anesthesia.doc.formbean.PatShuttleTransferContentFormbean;
import com.digihealth.anesthesia.doc.formbean.PatShuttleTransferFormbean;
import com.digihealth.anesthesia.doc.po.DocPatShuttleTransfer;
import com.digihealth.anesthesia.doc.po.DocPatShuttleTransferContent;


@Service
public class DocPatShuttleTransferService extends BaseService {
	/**
	 * 查询手术患者接送交接单 <功能详细描述>
	 * 
	 * @param map
	 * @return
	 * @see [类、类#方法、类#成员]
	 */
	public void searchPatShuttleTransfer(String regOptId, ResponseValue resp) {
		DocPatShuttleTransfer transfer = docPatShuttleTransferDao.getPatShuttleTransferByRegOptId(regOptId);
		resp.put("patShuttleTransfer", transfer);
		if (transfer != null) {
			resp.put("content1", docPatShuttleTransferContentDao.getContentBycheckPoint(transfer.getId(), "1"));
			resp.put("content2", docPatShuttleTransferContentDao.getContentBycheckPoint(transfer.getId(), "2"));
		}else {
			resp.put("content1", new DocPatShuttleTransferContent());
			resp.put("content2", new DocPatShuttleTransferContent());
		}
	}

	/**
	 * 保存手术患者接送交接单 <功能详细描述>
	 * 
	 * @param anaesPlan
	 * @return
	 * @see [类、类#方法、类#成员]
	 */
	@Transactional
	public ResponseValue savePatShuttleTransfer(PatShuttleTransferFormbean record, ResponseValue resp) {

		PatShuttleFormbean patShuttleTransfer = record.getPatShuttleTransfer();

		DocPatShuttleTransfer transfer = new DocPatShuttleTransfer();
		BeanUtils.copyProperties(patShuttleTransfer, transfer, new String[] {
				"worn", "goodsRemove", "preAdviceExec", "veinBody" });// 除json串的不需要传递之外，其他都传递

		if (null != patShuttleTransfer.getWorn()) {
			transfer.setWorn(JsonType.jsonType(patShuttleTransfer.getWorn()));
		}
		if (null != patShuttleTransfer.getGoodsRemove()) {
			transfer.setGoodsRemove(JsonType.jsonType(patShuttleTransfer
					.getGoodsRemove()));
		}
		if (null != patShuttleTransfer.getPreAdviceExec()) {
			transfer.setPreAdviceExec(JsonType.jsonType(patShuttleTransfer
					.getPreAdviceExec()));
		}
		if (null != patShuttleTransfer.getVeinBody()) {
			transfer.setVeinBody(JsonType.jsonType(patShuttleTransfer
					.getVeinBody()));
		}

		docPatShuttleTransferDao.updateByPrimaryKeyWithBLOBs(transfer);

		docPatShuttleTransferContentDao.deleteByPatShuttleId(transfer.getId());

		PatShuttleTransferContentFormbean content1 = record.getContent1();
		PatShuttleTransferContentFormbean content2 = record.getContent2();

		if (content1 != null) {

			DocPatShuttleTransferContent patShuttleTransferContent1 = new DocPatShuttleTransferContent();

			BeanUtils.copyProperties(content1, patShuttleTransferContent1,
					new String[] { "unuseDrug", "surplus", "skinFull",
							"operroomTake", "veinBody", "other" });// 除json串的不需要传递之外，其他都传递

			if (null != content1.getUnuseDrug()) {
				patShuttleTransferContent1.setUnuseDrug(JsonType
						.jsonType(content1.getUnuseDrug()));
			}
			if (null != content1.getSurplus()) {
				patShuttleTransferContent1.setSurplus(JsonType
						.jsonType(content1.getSurplus()));
			}
			if (null != content1.getSkinFull()) {
				patShuttleTransferContent1.setSkinFull(JsonType
						.jsonType(content1.getSkinFull()));
			}
			if (null != content1.getOperroomTake()) {
				patShuttleTransferContent1.setOperroomTake(JsonType
						.jsonType(content1.getOperroomTake()));
			}
			if (null != content1.getVeinBody()) {
				patShuttleTransferContent1.setVeinBody(JsonType
						.jsonType(content1.getVeinBody()));
			}
			if (null != content1.getOther()) {
				patShuttleTransferContent1.setOther(JsonType.jsonType(content1
						.getOther()));
			}

			patShuttleTransferContent1.setPatShuttleId(transfer.getId());
			patShuttleTransferContent1.setCheckPoint("1");
			patShuttleTransferContent1.setId(GenerateSequenceUtil
					.generateSequenceNo());
			docPatShuttleTransferContentDao.insertSelective(patShuttleTransferContent1);
		}

		if (content2 != null) {

			DocPatShuttleTransferContent patShuttleTransferContent2 = new DocPatShuttleTransferContent();

			BeanUtils.copyProperties(content2, patShuttleTransferContent2,
					new String[] { "unuseDrug", "surplus", "skinFull",
							"operroomTake", "veinBody", "other" });// 除json串的不需要传递之外，其他都传递

			if (null != content2.getUnuseDrug()) {
				patShuttleTransferContent2.setUnuseDrug(JsonType
						.jsonType(content2.getUnuseDrug()));
			}
			if (null != content2.getSurplus()) {
				patShuttleTransferContent2.setSurplus(JsonType
						.jsonType(content2.getSurplus()));
			}
			if (null != content2.getSkinFull()) {
				patShuttleTransferContent2.setSkinFull(JsonType
						.jsonType(content2.getSkinFull()));
			}
			if (null != content2.getOperroomTake()) {
				patShuttleTransferContent2.setOperroomTake(JsonType
						.jsonType(content2.getOperroomTake()));
			}
			if (null != content2.getVeinBody()) {
				patShuttleTransferContent2.setVeinBody(JsonType
						.jsonType(content2.getVeinBody()));
			}
			if (null != content2.getOther()) {
				patShuttleTransferContent2.setOther(JsonType.jsonType(content2
						.getOther()));
			}

			patShuttleTransferContent2.setPatShuttleId(transfer.getId());
			patShuttleTransferContent2.setCheckPoint("2");
			patShuttleTransferContent2.setId(GenerateSequenceUtil.generateSequenceNo());
			docPatShuttleTransferContentDao.insertSelective(patShuttleTransferContent2);
		}
		return resp;

	}
}
