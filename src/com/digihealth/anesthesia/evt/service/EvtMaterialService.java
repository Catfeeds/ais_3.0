package com.digihealth.anesthesia.evt.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.digihealth.anesthesia.common.service.BaseService;
import com.digihealth.anesthesia.common.utils.GenerateSequenceUtil;
import com.digihealth.anesthesia.common.utils.StringUtils;
import com.digihealth.anesthesia.evt.po.EvtMaterial;

@Service
public class EvtMaterialService extends BaseService {
	public List<EvtMaterial> selectMaterialByDocId(String docId) {
		return evtMaterialDao.selectByDocId(docId);
	}

	@Transactional
	public void updateMaterial(EvtMaterial record) {
		if (record != null && (!StringUtils.isEmpty(record.getId()))) {
			evtMaterialDao.updateByPrimaryKeySelective(record);
		} else {
			record.setId(GenerateSequenceUtil.generateSequenceNo());
			evtMaterialDao.insertSelective(record);
		}

	}

	@Transactional
	public void deleteMaterialById(String id) {
		evtMaterialDao.deleteByPrimaryKey(id);
	}
}
