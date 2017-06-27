package com.digihealth.anesthesia.basedata.service;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.digihealth.anesthesia.basedata.po.BasOperateLog;
import com.digihealth.anesthesia.common.service.BaseService;
import com.digihealth.anesthesia.common.utils.GenerateSequenceUtil;
import com.digihealth.anesthesia.sysMng.po.BasUser;

@Service
public class BasOperateLogService extends BaseService {
	/**
	 * 日志类型
	 */
	public static final String OPT_TYPE_USRE_LOGIN = "1";   //用户登录
	public static final String OPT_TYPE_USRE_OUT = "2";		//用户退出
	public static final String OPT_TYPE_INFO_QUERY = "3";	//数据查询
	public static final String OPT_TYPE_INFO_SAVE = "4";	//数据保存
	public static final String OPT_TYPE_INFO_DEL = "5";		//数据删除
	
	/**
	 * 所属模块
	 */
	public static final String OPT_MODULE_LOGIN = "1";   //用户登录模块
	public static final String OPT_MODULE_OPER_DOC = "2";//文书模块
	public static final String OPT_MODULE_OPER_RECORD = "3";//术中记录模块
	public static final String OPT_MODULE_BASE_INFO = "4";//基础信息
	public static final String OPT_MODULE_INTERFACE = "5";//接口模块
	
	/**
     *根据登录名查询一天（自然日）内的错误登录记录 
     */
	public List<BasOperateLog> selectLogionRecordByUserName(String userName,String beid) {
	    if (StringUtils.isEmpty(beid))
        {
	        beid = getBeid();
        }
		return basOperateLogDao.selectLogionRecordByUserName(userName,beid);
	}
	
	/**
	 *插入登录记录
	 */
	@Transactional
	public void addSysLogionLog(BasOperateLog basOperateLog) {
	    if (StringUtils.isBlank(basOperateLog.getBeid()))
        {
	        basOperateLog.setBeid(getBeid());
        }
	    basOperateLog.setId(GenerateSequenceUtil.generateSequenceNo());
		basOperateLogDao.insertSelective(basOperateLog);
	}
	

	/**
	 * 保存操作日志信息
	 * @param regOptId  病人Id
	 * @param operType  日志类型
	 * @param operModule  所属模块
	 * @param desc		描述
	 * @param contents	详细信息
	 */
	@Transactional
	public void saveBasOperateLog(String regOptId,String operType,String operModule,String desc,String contents){
		this.saveBasOperateLog(regOptId, operType, operModule, desc, contents, null);
	}
	
	/**
	 * 保存操作日志信息
	 * @param regOptId  病人Id
	 * @param operType  日志类型
	 * @param operModule  所属模块
	 * @param desc		描述
	 * @param contents	详细信息
	 * @param operid	操作员ID
	 * @param opername	操作员姓名
	 */
	@Transactional
	public void saveBasOperateLog(String regOptId,String operType,String operModule,String desc,String contents,BasUser user){
		BasOperateLog log = new BasOperateLog();
		log.setId(GenerateSequenceUtil.generateSequenceNo());
		log.setBusiId(regOptId);
		log.setOperTime(new Date());
		log.setOperType(operType);
		log.setOperContents(contents);
		log.setDescription(desc);
		if(user != null){
			log.setOperId(user.getUserName());
			log.setOperName(user.getName());
		}
		log.setOperModule(operModule);
		log.setBeid(getBeid());
		basOperateLogDao.insertSelective(log);
	}
}
