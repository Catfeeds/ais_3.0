package com.digihealth.anesthesia.tmp.service;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.digihealth.anesthesia.common.entity.ResponseValue;
import com.digihealth.anesthesia.common.service.BaseService;
import com.digihealth.anesthesia.common.utils.GenerateSequenceUtil;
import com.digihealth.anesthesia.common.utils.JsonType;
import com.digihealth.anesthesia.research.formbean.ResearchFormbean;
import com.digihealth.anesthesia.research.formbean.SciTempFormBean;
import com.digihealth.anesthesia.tmp.po.TmpSciTemp;

@Service
public class TmpSciTempService extends BaseService {

	public TmpSciTemp getSciResearch(String sciId) {
		return tmpSciTempDao.selectByPrimaryKey(sciId);
	}
	
	public List<SciTempFormBean> getSciTempList(){
		return tmpSciTempDao.getSciTempList(getBeid());
	}
	
	@Transactional
	public ResponseValue delSciResearch(String sciId, String userId) {
		ResponseValue res = new ResponseValue();
		TmpSciTemp sciTemp = tmpSciTempDao.selectByPrimaryKey(sciId);
		if (null != sciTemp) {
			String createUser = sciTemp.getCreateUser();
			if (null != createUser) {
				if (createUser.equals(userId)) {
					tmpSciTempDao.deleteByPrimaryKey(sciId);// 删除操作
					res.setResultCode("1");
					res.setResultMessage("删除模板成功！");
				} else {
					res.setResultCode("70000000");
					res.setResultMessage("当前用户和创建用户不一致，不能删除！");
				}
			} else {
				res.setResultCode("10000000");
				res.setResultMessage("当前对象没有createUser值，系统错误！");
			}
		} else {
			res.setResultCode("10000000");
			res.setResultMessage("没有找到当前模板，系统错误！");
		}
		return res;
	}

	/**
	 * 新增or修改模板
	 * 
	 * @param researchBean
	 */
	@Transactional
	public String HandleSciTemp(ResearchFormbean researchBean) {
		String id = "";
		TmpSciTemp sciTemp = new TmpSciTemp();
		if(null == researchBean.getCreateTime()){
			researchBean.setCreateTime(new Date());
		}
		if(null == researchBean.getType()){
			researchBean.setType(1); // 默认使用级别为 个人
		}
		
		BeanUtils.copyProperties(researchBean, sciTemp);
		sciTemp.setTmpJson(JsonType.jsonType(researchBean));
		if (null == sciTemp.getId() || StringUtils.isBlank(sciTemp.getId())) {
			sciTemp.setId(GenerateSequenceUtil.generateSequenceNo());// 生成id
			researchBean.setId(sciTemp.getId()); //将id设值到json对象中
			sciTemp.setTmpJson(JsonType.jsonType(researchBean));
			tmpSciTempDao.insertSelective(sciTemp);
			id = sciTemp.getId();
			return id;
		} else {
			sciTemp.setCreateUser(null); //修改的时候，不需要传递createUser的值，不修改创建人id
			tmpSciTempDao.updateByPrimaryKeySelective(sciTemp);
			id = sciTemp.getId();
			return id;
		}
	}

	public TmpSciTemp selectBySciId(String sciId) {
		return tmpSciTempDao.selectByPrimaryKey(sciId);
	}

}
