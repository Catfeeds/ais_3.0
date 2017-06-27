package com.digihealth.anesthesia.doc.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.digihealth.anesthesia.common.service.BaseService;
import com.digihealth.anesthesia.common.utils.GenerateSequenceUtil;
import com.digihealth.anesthesia.doc.formbean.InsuredChargeInformFormbean;
import com.digihealth.anesthesia.doc.po.DocInsuredChargeInform;
import com.digihealth.anesthesia.doc.po.DocInsuredChargeItem;


@Service
public class DocInsuredChargeInformService extends BaseService {

	public InsuredChargeInformFormbean selectByRegOptId(String regOptId) {
		InsuredChargeInformFormbean insuredChargeInformFormbean = new InsuredChargeInformFormbean();
		DocInsuredChargeInform insuredChargeInform = docInsuredChargeInformDao
				.selectByRegOptId(regOptId);
		insuredChargeInformFormbean.setInsuredChargeInform(insuredChargeInform);
		if (null != insuredChargeInform) {
			List<DocInsuredChargeItem> insuredChargeItemList = docInsuredChargeItemDao.selectByInsuredId(insuredChargeInform.getId());
			insuredChargeInformFormbean.setInsuredChargeItemList(insuredChargeItemList);
		}
		return insuredChargeInformFormbean;
	}

	public DocInsuredChargeItem selectByItemId(DocInsuredChargeItem insuredChargeItem) {
		return docInsuredChargeItemDao.selectByPrimaryKey(insuredChargeItem.getId());
	}

	@Transactional
	public void updateInsuredChargeItem(DocInsuredChargeItem insuredChargeItem) {
		if (null == insuredChargeItem.getId()) {
			DocInsuredChargeItem ici = docInsuredChargeItemDao.selectByNameAndPrice(
					insuredChargeItem.getInsuredId(),
					insuredChargeItem.getName(), insuredChargeItem.getPrice());
			if (null == ici) {
				insuredChargeItem.setId(GenerateSequenceUtil
						.generateSequenceNo());
				docInsuredChargeItemDao.insert(insuredChargeItem);
			} else {
				ici.setCount(insuredChargeItem.getCount()
						+ (null == ici.getCount() ? 0 : ici.getCount()));
				ici.setTotalPrice(insuredChargeItem.getTotalPrice()
						+ (null == ici.getTotalPrice() ? 0 : ici
								.getTotalPrice()));
				docInsuredChargeItemDao.updateByPrimaryKey(ici);
			}

		} else {
			docInsuredChargeItemDao.updateByPrimaryKeySelective(insuredChargeItem);
		}
	}

	@Transactional
	public void deleteInsuredChargeItem(DocInsuredChargeItem insuredChargeItem) {
		docInsuredChargeItemDao.deleteByPrimaryKey(insuredChargeItem.getId());
	}

	@Transactional
	public void updateInsuredChargeInform(DocInsuredChargeInform insuredChargeInform) {
		docInsuredChargeInformDao.updateByPrimaryKeySelective(insuredChargeInform);
	}
}
