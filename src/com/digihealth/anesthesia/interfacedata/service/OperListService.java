/**     
 * @discription 在此输入一句话描述此文件的作用
 * @author chengwang       
 * @created 2015-10-10 下午5:32:33    
 * tags     
 * see_to_target     
 */

package com.digihealth.anesthesia.interfacedata.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.digihealth.anesthesia.basedata.config.OperationState;
import com.digihealth.anesthesia.basedata.formbean.DispatchFormbean;
import com.digihealth.anesthesia.basedata.po.BasAnaesMethod;
import com.digihealth.anesthesia.basedata.po.BasMedicine;
import com.digihealth.anesthesia.basedata.po.BasOperationPeople;
import com.digihealth.anesthesia.basedata.po.BasOperdef;
import com.digihealth.anesthesia.basedata.po.BasPrice;
import com.digihealth.anesthesia.basedata.po.BasRegOpt;
import com.digihealth.anesthesia.basedata.po.BasDiagnosedef;
import com.digihealth.anesthesia.basedata.po.BasInstrument;
import com.digihealth.anesthesia.basedata.service.BasDispatchService;
import com.digihealth.anesthesia.basedata.service.BasMedicineService;
import com.digihealth.anesthesia.basedata.service.BasOperationPeopleService;
import com.digihealth.anesthesia.basedata.service.BasOperdefService;
import com.digihealth.anesthesia.basedata.service.BasPriceService;
import com.digihealth.anesthesia.basedata.service.BasInstrumentService;
import com.digihealth.anesthesia.basedata.utils.LogUtils;
import com.digihealth.anesthesia.basedata.utils.UserUtils;
import com.digihealth.anesthesia.common.service.BaseService;
import com.digihealth.anesthesia.common.utils.ConnectionManager;
import com.digihealth.anesthesia.common.utils.DateUtils;
import com.digihealth.anesthesia.common.utils.GenerateSequenceUtil;
import com.digihealth.anesthesia.common.utils.JsonType;
import com.digihealth.anesthesia.common.utils.PingYinUtil;
import com.digihealth.anesthesia.common.utils.StringUtils;
import com.digihealth.anesthesia.interfacedata.po.OperList;

/**
 * Title: OperListService.java Description: 描述
 * 
 * @author chengwang
 * @created 2015-10-10 下午5:32:33
 */
@Service
@Transactional(readOnly = true)
public class OperListService extends BaseService {

	@Autowired
	private BasOperationPeopleService operationPeopleService;
	@Autowired
	private BasOperdefService operdefService;
	@Autowired
	private BasInstrumentService instrumentService;
	@Autowired
	private BasMedicineService medicineService;
	@Autowired
	private BasPriceService priceService;
	@Autowired
	private BasDispatchService dispatchService;
	
	
	
	/**
	 * 深圳市龙岗区第二人民医院
	 * 同步手术医生
	 */
	@Transactional(readOnly =false)
	public void synchronousOperPeople(){
		logger.info("----------------begin synchronousOperPeople--------------------------");
		Connection conn = ConnectionManager.getConnection();
		 String sql = "select * from ycyl.v_surgerydoctor";
		    PreparedStatement pstmt = null;
		    ResultSet rs = null;
		    try {
		        pstmt = (PreparedStatement)conn.prepareStatement(sql);
		        rs = pstmt.executeQuery();
		        int col = rs.getMetaData().getColumnCount();
		        logger.info("synchronousOperPeople================col"+col+"============");
		        /*if(rs != null){
					basOperationPeopleDao.updateEnable();
		        }*/
		        while (rs.next()) {
		            if(!StringUtils.isEmpty(rs.getString(1))){
		            	List<BasOperationPeople> opers = basOperationPeopleDao.selectByCode(rs.getString(1).trim(), getBeid());
						if(opers!=null&&opers.size()>0){
							for(int j = 0;j<opers.size();j++){
								BasOperationPeople opd = new BasOperationPeople();
								opd.setOperatorId(opers.get(j).getOperatorId());
								opd.setCode(rs.getString(1).trim());
								opd.setName(rs.getString(2));
								opd.setPinYin(PingYinUtil.getFirstSpell(rs.getString(2)));
								opd.setEnable(rs.getInt(3));
								if((!opers.get(j).getCode().equals(rs.getString(1).trim()))||
										(!opers.get(j).getName().equals(rs.getString(2).trim()))||
										(!opers.get(j).getEnable().equals(rs.getString(3)))){
									operationPeopleService.saveOperationPeople(opd);
								}
								
							}
						}else{
							BasOperationPeople opd = new BasOperationPeople();
							opd.setCode(rs.getString(1).trim());
							opd.setName(rs.getString(2));
							opd.setPinYin(PingYinUtil.getFirstSpell(rs.getString(2)));
							opd.setEnable(rs.getInt(3));
							operationPeopleService.saveOperationPeople(opd);
						}
		            }
		        	
		        }
		        logger.info("synchronousOperPeople================while end============");
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		    finally
	        {
	            try
                {
                    closeConnection(pstmt, rs);
                }
                catch (SQLException e)
                {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
	        }
		logger.info("-------------end synchronousOperPeople---------------");
	}
	
	/**
	 * 深圳市龙岗区第二人民医院
	 * 同步器械
	 */
	@Transactional(readOnly =false)
	public void synchronousIns(){
		logger.info("------------begin synchronousInsService---------------");
		Connection conn = ConnectionManager.getConnection();
		 String sql = "select * from ycyl.v_surgerycl";
		    PreparedStatement pstmt = null;
		    ResultSet rs = null;
		    try {
		        pstmt = (PreparedStatement)conn.prepareStatement(sql);
		        rs = pstmt.executeQuery();
		        int col = rs.getMetaData().getColumnCount();
		        System.out.println("============================");
		        if(rs != null){
		        	basInstrumentDao.updateEnable(getBeid());
		        }
		        while (rs.next()) {
		            if(!StringUtils.isEmpty(rs.getString(1))){
		            	List<BasInstrument> insList = basInstrumentDao.selectByCode(rs.getString(1), getBeid());
						if(insList!=null&&insList.size()>0){
							for(int j = 0;j<insList.size();j++){
								BasInstrument opd = new BasInstrument();
								opd.setInstrumentId(insList.get(j).getInstrumentId());
								opd.setCode(rs.getString(1));
								opd.setName(rs.getString(2));
								opd.setPinYin(StringUtils.isNoneBlank(rs.getString(4)) ? rs.getString(4) : PingYinUtil.getFirstSpell(rs.getString(2)));
								opd.setType(rs.getString(3));
								opd.setEnable(rs.getInt(5));
								instrumentService.updateInstrument(opd);
							}
						}else{
							BasInstrument opd = new BasInstrument();
							opd.setCode(rs.getString(1));
							opd.setName(rs.getString(2));
							opd.setPinYin(StringUtils.isNoneBlank(rs.getString(4)) ? rs.getString(4) : PingYinUtil.getFirstSpell(rs.getString(2)));
							opd.setType(rs.getString(3));
							opd.setEnable(rs.getInt(5));
							instrumentService.updateInstrument(opd);
						}
		            }
		        	
		        }
		        System.out.println("============================");
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		    finally
	        {
	            try
                {
                    closeConnection(pstmt, rs);
                }
                catch (SQLException e)
                {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
	        }
		logger.info("-----------------end synchronousIns---------------");
	}
	
	/**
	 * 深圳市龙岗区第二人民医院
	 * 同步手术名称
	 */
	@Transactional(readOnly =false)
	public void synchronousOperDef(){
		logger.info("--------------begin synchronousOperDef--------------------------");
		Connection conn = ConnectionManager.getConnection();
		 String sql = "select * from ycyl.v_surgeryname";
		    PreparedStatement pstmt = null;
		    ResultSet rs = null;
		    try {
		        pstmt = (PreparedStatement)conn.prepareStatement(sql);
		        rs = pstmt.executeQuery();
		        int col = rs.getMetaData().getColumnCount();
		        logger.info("synchronousOperDef=============col"+col+"===============");
		        /*if(rs != null){
		        	basOperdefDao.updateEnable();
		        }*/
		        while (rs.next()) {
		            if(!StringUtils.isEmpty(rs.getString(1))){
		            	List<BasOperdef> opers = basOperdefDao.selectByCode(rs.getString(1), getBeid());
						if(opers!=null&&opers.size()>0){
							for(int j = 0;j<opers.size();j++){
								BasOperdef opd = new BasOperdef();
								opd.setOperdefId(opers.get(j).getOperdefId());
								opd.setCode(rs.getString(1));
								opd.setName(rs.getString(2));
								opd.setPinYin(StringUtils.isNoneBlank(rs.getString(3)) ? rs.getString(3) : PingYinUtil.getFirstSpell(rs.getString(2)));
								opd.setEnable(rs.getInt(4));
								if((!opers.get(j).getPinYin().equals(rs.getString(3)))||(!opers.get(j).getCode().equals(rs.getString(1)))||(!opers.get(j).getName().equals(rs.getString(2)))||(!opers.get(j).getEnable().equals(rs.getString(4)))){
									operdefService.saveOperdef(opd);
								}
							}
						}else{
							BasOperdef opd = new BasOperdef();
							opd.setCode(rs.getString(1));
							opd.setName(rs.getString(2));
							opd.setPinYin(StringUtils.isNoneBlank(rs.getString(3)) ? rs.getString(3) : PingYinUtil.getFirstSpell(rs.getString(2)));
							opd.setEnable(rs.getInt(4));
							operdefService.saveOperdef(opd);
						}
		            }
		        	
		        }
		        logger.info("synchronousOperDef=============while end===============");
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		    finally
	        {
	            try
                {
                    closeConnection(pstmt, rs);
                }
                catch (SQLException e)
                {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
	        }
		logger.info("------------end synchronousOperDef-------------------------");
	}
	
	/**
	 * 深圳市龙岗区第二人民医院
	 * 同步药品
	 */
	@Transactional(readOnly =false)
	public void synchronousMedicine(){
		logger.info("----------------begin synchronousMedicine----------------------");
		Connection conn = ConnectionManager.getConnection();
		 String sql = "select * from hisbase.v_surgeryyp ";
		    PreparedStatement pstmt = null;
		    ResultSet rs = null;
		    try {
		        pstmt = (PreparedStatement)conn.prepareStatement(sql);
		        rs = pstmt.executeQuery();
		        int col = rs.getMetaData().getColumnCount();
		        logger.info("synchronousMedicine=============col"+col+"===============");
		        /*if(rs != null){
		        	basMedicineDao.updateEnable();
		        	basPriceDao.updateEnable();
		        }*/
		        while (rs.next()) {
		            if(!StringUtils.isEmpty(rs.getString(1))){
		            	List<BasMedicine> medList = basMedicineDao.selectByCode(rs.getString(1), getBeid());
						if(medList!=null&&medList.size()>0){
							for(int j = 0;j<medList.size();j++){
								BasMedicine opd = new BasMedicine();
								opd.setMedicineId(medList.get(j).getMedicineId());
								opd.setCode(rs.getString(1));
								opd.setName(rs.getString(5));
								opd.setBriefName(rs.getString(6));
								opd.setDosageUnit(rs.getString(8));
								//opd.setPackageDosageAmount(rs.getString(7));
								opd.setPinYin(StringUtils.isNoneBlank(rs.getString(4)) ? rs.getString(4) : PingYinUtil.getFirstSpell(rs.getString(5)));
								opd.setSpec(rs.getString(9));
								opd.setRoughType(rs.getString(2));
								opd.setType(rs.getString(2));
								opd.setEnable(rs.getInt(3));
								if((!medList.get(j).getCode().equals(rs.getString(1)))||
										(!medList.get(j).getName().equals(rs.getString(5)))||
										(!medList.get(j).getDosageUnit().equals(rs.getString(8)))||
										((!medList.get(j).getPinYin().equals(rs.getString(4))) && !(!medList.get(j).getPinYin().equals(PingYinUtil.getFirstSpell(rs.getString(5)))))||
										(!medList.get(j).getSpec().equals(rs.getString(9)))||
										(!medList.get(j).getEnable().equals(rs.getString(3)))){
									basMedicineDao.update(opd);
								}
							}
						}else{
							BasMedicine opd = new BasMedicine();
							opd.setCode(rs.getString(1));
							opd.setName(rs.getString(5));
							opd.setBriefName(rs.getString(6));
							opd.setDosageUnit(rs.getString(8));
							//opd.setPackageDosageAmount(rs.getString(7));
							opd.setPinYin(StringUtils.isNoneBlank(rs.getString(4)) ? rs.getString(4) : PingYinUtil.getFirstSpell(rs.getString(5)));
							opd.setSpec(rs.getString(9));
							opd.setRoughType(rs.getString(2));
							opd.setType(rs.getString(2));
							opd.setEnable(rs.getInt(3));
							basMedicineDao.insert(opd);
						}
						List<BasPrice> priList = basPriceDao.selectByCode(rs.getString(1), getBeid());
						if(priList!=null&&priList.size()>0){
							for(int j = 0;j<priList.size();j++){
								BasPrice opd = new BasPrice();
								opd.setPriceId(priList.get(j).getPriceId());
								opd.setCode(rs.getString(1));
								opd.setSpec(rs.getString(9));
								opd.setEnable(rs.getInt(3));
								if((!priList.get(j).getCode().equals(rs.getString(1)))||
										(!priList.get(j).getSpec().equals(rs.getString(9)))||
										(!priList.get(j).getEnable().equals(rs.getString(3)))){
									priceService.savePrice(opd);
								}
								
							}
						}else{
							BasPrice opd = new BasPrice();
							opd.setCode(rs.getString(1));
							opd.setSpec(rs.getString(9));
							opd.setEnable(rs.getInt(3));
							priceService.savePrice(opd);
						}
		            }
		        	
		        }
		        logger.info("synchronousMedicine=============while end===============");
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		    finally
	        {
	            try
                {
                    closeConnection(pstmt, rs);
                }
                catch (SQLException e)
                {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
	        }
		logger.info("----------------end synchronousMedicine------------------------");
	}
	
	
	
	/**
	 * 深圳市龙岗区第二人民医院
	 * 同步HIS手术通知数据
	 */
	@Transactional(readOnly =false)
	public void synHisOperList(){
		logger.info("---------------------begin synHisOperList------------------------");
		Connection conn = ConnectionManager.getConnection();
	    String sql = "select * from ycyl.v_surgerysqd where operDate >=to_date('"+DateUtils.DateToString(new Date())+" 00:00:00'"+",'yyyy-mm-dd hh24:mi:ss')";
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    try {
	        pstmt = (PreparedStatement)conn.prepareStatement(sql);
	        rs = pstmt.executeQuery();
	        int col = rs.getMetaData().getColumnCount();
	        logger.info("synHisOperList=============col"+col+"===============");
	        while (rs.next()) {
	        	int result = basRegOptDao.selectHisToRegOpt(rs.getString(1), DateUtils.getParseNYRTime(rs.getString(31)));
	            if(result<1){
	            	for (int i = 1; i <= col; i++) {
	            		logger.info("rs.getString(i) " + "\t");
		            }
	            	String regOptId = GenerateSequenceUtil.generateSequenceNo();
	            	BasRegOpt regOpt = new BasRegOpt();
	            	regOpt.setRegOptId(regOptId);
            		regOpt.setPreengagementnumber(rs.getString(1));
            		regOpt.setName(rs.getString(2));
            		if(rs.getString(3).indexOf("岁")!=-1){
            			regOpt.setAge(Integer.parseInt(rs.getString(3).substring(0, rs.getString(3).trim().indexOf("岁"))));
            		}else if(rs.getString(3).indexOf("月")!=-1){
            			regOpt.setAgeMon(Integer.parseInt(rs.getString(3).substring(0, rs.getString(3).trim().indexOf("月"))));
            		}else if(rs.getString(3).indexOf("天")!=-1){
            			regOpt.setAgeMon(Integer.parseInt(rs.getString(3).substring(0, rs.getString(3).trim().indexOf("天"))));
            		}
            		regOpt.setBirthday(rs.getString(6));
            		regOpt.setSex(rs.getString(7));
            		regOpt.setMedicalType(rs.getString(8));
            		regOpt.setIdentityNo(rs.getString(9));
            		regOpt.setHid(rs.getString(10));
            		regOpt.setCid(rs.getString(11));
            		if(!StringUtils.isEmpty(rs.getString(12))){
            			regOpt.setRegionId(rs.getString(12));
            		}
            		
            		regOpt.setRegionName(rs.getString(13));
            		if(!StringUtils.isEmpty(rs.getString(14))){
            			regOpt.setDeptId(rs.getString(14));
            		}
            		regOpt.setDeptName(rs.getString(15));
            		regOpt.setBed(rs.getString(16));
            		List<BasDiagnosedef> diaList = basDiagnosedefDao.selectByName(rs.getString(18), getBeid());
            		int defId = 1;
            		if(diaList==null||diaList.size()<1){
            			if(!StringUtils.isEmpty(rs.getString(18))){
            				List<BasDiagnosedef> orderList =  basDiagnosedefDao.selectOrderByIdDesc();
                			if(orderList != null && orderList.size()>0){
                				defId = Integer.parseInt(orderList.get(0).getDiagDefId()) + 1;
                			}
                			BasDiagnosedef def = new BasDiagnosedef();
                			def.setDiagDefId(defId+"");
                			def.setCode(defId+"");
                			def.setEnable(1);
                			def.setName(rs.getString(18));
                			def.setPinYin(PingYinUtil.getFirstSpell(rs.getString(18)));
                			basDiagnosedefDao.insert(def);
            			}
            			
            		}
            		regOpt.setDiagnosisCode(defId+"");
            		regOpt.setDiagnosisName(rs.getString(18));
            		int operId = 1;
            		List<BasOperdef> operList = basOperdefDao.selectByName(rs.getString(20), getBeid());
            		if(operList == null || operList.size()<1){
            			if(!StringUtils.isEmpty(rs.getString(20))){
            				List<BasOperdef> orderList =  basOperdefDao.selectOrderByIdDesc();
            				if(orderList != null && orderList.size()>0){
            					operId = Integer.parseInt(orderList.get(0).getOperdefId()) + 1;
                			}
            				BasOperdef operdef = new BasOperdef();
            				operdef.setOperdefId(operId+"");
            				operdef.setCode(operId+"");
            				operdef.setEnable(1);
            				operdef.setName(rs.getString(20));
            				operdef.setPinYin(PingYinUtil.getFirstSpell(rs.getString(20)));
            				basOperdefDao.insert(operdef);
            			}
            		}
            		regOpt.setDesignedOptCode(operId+"");
            		regOpt.setDesignedOptName(rs.getString(20));
            		
            		String operationPeopleCode = rs.getString("surgeryDoctorId"); //获取主刀医生code
            		String operationPeopleName = rs.getString("surgeryDoctorName"); //获取主刀医生name
            		logger.info("synHisOperList========"+operationPeopleCode+"====" + operationPeopleName);
            		List<BasOperationPeople> ope = basOperationPeopleDao.selectByCode(operationPeopleCode, getBeid());
            		regOpt.setOperatorId((ope!=null&&ope.size()>0)?ope.get(0).getOperatorId()+"":null);
            		regOpt.setOperatorName((ope!=null&&ope.size()>0)?ope.get(0).getName()+"":null);
            		
            		if(null == regOpt.getOperatorName() || StringUtils.isBlank(regOpt.getOperatorName())){ //如果取出来的数据为null，则取页面传过来的数据 
            			regOpt.setOperatorName(operationPeopleName);
            		}
            		
            		//助手医生处理
            		regOpt.setAssistantId("");
            		regOpt.setAssistantName("");
            		//助手医生id是逗号分割的
            		String assistants = rs.getString("assistantId");
            		if(null != assistants && StringUtils.isNotBlank(assistants)){
            			String[] assistantsList = assistants.split(",");
            			if(null != assistantsList && assistantsList.length>0){
            				for (String id : assistantsList) {
            					List<BasOperationPeople> operPerList = basOperationPeopleDao.selectByCode(id, getBeid());
            					regOpt.setAssistantId( regOpt.getAssistantId()+((operPerList != null && operPerList.size()>0)?operPerList.get(0).getCode()+",":""));
            					regOpt.setAssistantName(regOpt.getAssistantName()+((operPerList != null && operPerList.size()>0)?operPerList.get(0).getName()+",":""));
							}
            			}
            		}
            		
            		//助手医生code和name去掉最后一个逗号
            		String assistantId = regOpt.getAssistantId();
            		if(null != assistantId && StringUtils.isNotBlank(assistantId)){
            			assistantId = assistantId.substring(0, assistantId.length()-1);
            			regOpt.setAssistantId(assistantId);
            		}
            		String assistantName = regOpt.getAssistantName();
            		if(null != assistantName && StringUtils.isNotBlank(assistantName)){
            			assistantName = assistantName.substring(0, assistantName.length()-1);
            			regOpt.setAssistantName(assistantName);
            		}
            		
            		
            		if(!StringUtils.isEmpty(rs.getString(25))){
            			regOpt.setWeight(Float.parseFloat(rs.getString(25).trim()));
            		}
            		if(!StringUtils.isEmpty(rs.getString(26))){
            			regOpt.setHeight(Float.parseFloat(rs.getString(26).trim()));
            		}
            		regOpt.setHbsag(rs.getString(27));
            		regOpt.setHcv(rs.getString(28));
            		regOpt.setHiv(rs.getString(29));
            		regOpt.setHp(rs.getString(30));
            		regOpt.setOperaDate(DateUtils.getParseNYRTime(rs.getString(31)));
            		regOpt.setStartTime(rs.getString(31));
            		regOpt.setHyperSusceptiBility(rs.getString(34));
            		regOpt.setOptLevel(rs.getString(35));
            		regOpt.setEmergency(0);
            		//regOpt.setIsLocalAnaes("0");
            		
            		//麻醉方法
            		String designedAnaesMethodName = rs.getString(41);
            		regOpt.setDesignedAnaesMethodCode("");//初始设置为""
            		if(null != designedAnaesMethodName && StringUtils.isNotBlank(designedAnaesMethodName)){
            			String[] designedAnaesMethodNameList = designedAnaesMethodName.split(",");
            			if(null != designedAnaesMethodNameList && designedAnaesMethodNameList.length>0){
            				for (String name : designedAnaesMethodNameList) {
            					List<BasAnaesMethod> anaesMethodList = basAnaesMethodDao.selectByName(name, getBeid());
            					regOpt.setDesignedAnaesMethodCode(regOpt.getDesignedAnaesMethodCode()+((anaesMethodList != null && anaesMethodList.size()>0)?anaesMethodList.get(0).getCode()+",":""));
							}
            			}
            		}
            		
            		// 麻醉方法code去掉最后一个逗号，
            		String designedAnaesMethodCode = regOpt.getDesignedAnaesMethodCode();
            		if(null != designedAnaesMethodCode && StringUtils.isNotBlank(designedAnaesMethodCode)){
            			designedAnaesMethodCode = designedAnaesMethodCode.substring(0, designedAnaesMethodCode.length()-1);
            			regOpt.setDesignedAnaesMethodCode(designedAnaesMethodCode);
            		}
            		
            		// 全麻局麻控制
            		if(null != designedAnaesMethodCode && designedAnaesMethodCode.equals("6")){
            			regOpt.setIsLocalAnaes(1); //1是局麻，0是全麻
            		}else{
            			regOpt.setIsLocalAnaes(0);
            		}
            		
            		//regOpt.setDesignedAnaesMethodCode(rs.getString(40));
            		regOpt.setDesignedAnaesMethodName(designedAnaesMethodName);
            		
            		regOpt.setCreateTime(DateUtils.formatDateTime(new Date()));
            		regOpt.setCreateUser(rs.getString(42));
            		// 增加备注
            		regOpt.setRemark(rs.getString("remark"));//从his中获取
            		regOpt.setState(OperationState.NOT_REVIEWED);
            		int resultInsert = basRegOptDao.insert(regOpt);
        			LogUtils.saveOperateLog(regOptId, LogUtils.OPT_TYPE_INFO_SAVE,
        			    LogUtils.OPT_MODULE_INTERFACE, "HIS手术通知单", JsonType.jsonType(regOpt), UserUtils.getUserCache(), getBeid());
	            	
	            }
	        }
	        
	        logger.info("synHisOperList=============while end===============");
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    finally
	    {
	        try
            {
                closeConnection(pstmt, rs);
            }
            catch (SQLException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
	    }
	    logger.info("------------------end synHisOperList-------------------------");
	}

    public void closeConnection(PreparedStatement pstmt, ResultSet rs) throws SQLException
    {
        if (null != pstmt)
        {
            pstmt.close();
        }
        
        if (null != rs)
        {
            rs.close();
        }
        //关闭conn
        ConnectionManager.closeConnection();
    }
	
	@Transactional(readOnly =false)
	public int hisToRegOpt(OperList oper){
		String regOptId = GenerateSequenceUtil.generateSequenceNo();
		BasRegOpt regOpt = new BasRegOpt();
		regOpt.setRegOptId(regOptId);
		regOpt.setPreengagementnumber(oper.getReservenumber());
		regOpt.setName(oper.getName());
		regOpt.setAge(oper.getAge());
		regOpt.setAgeDay(oper.getAgeDay());
		regOpt.setAgeMon(oper.getAgeMon());
		regOpt.setBirthday(oper.getBirthday());
		regOpt.setSex(oper.getSex());
		regOpt.setMedicalType(oper.getMedicalType());
		regOpt.setIdentityNo(oper.getCredNumber());
		regOpt.setHid(oper.getHid());
		regOpt.setCid(oper.getCid());
		regOpt.setRegionId(oper.getRegionId());
		regOpt.setRegionName(oper.getRegionName());
		regOpt.setDeptId(oper.getDeptId());
		regOpt.setDeptName(oper.getDeptName());
		regOpt.setBed(oper.getBed());
		regOpt.setDiagnosisCode(oper.getDiagCode());
		regOpt.setDiagnosisName(oper.getDiagName());
		regOpt.setDesignedOptCode(oper.getOperCode());
		regOpt.setDesignedOptName(oper.getOperName());
		
		List<BasOperationPeople> ope = basOperationPeopleDao.selectByCode(oper.getSurgeryDoctorId(), getBeid());
		regOpt.setOperatorId((ope!=null&&ope.size()>0)?ope.get(0).getOperatorId()+"":null);
		regOpt.setOperatorName((ope!=null&&ope.size()>0)?ope.get(0).getName()+"":null);
		String assistants = oper.getOperAssistantId();
		regOpt.setAssistantId("");
		regOpt.setAssistantName("");
		if(StringUtils.isEmpty(assistants)){
			regOpt.setAssistantId(null);
			regOpt.setAssistantName(null);
		}else{
			String[] assistantArray = oper.getOperAssistantId().split(",");
			if(assistantArray.length>0){
				for(int i = 0 ; i <assistantArray.length;i++){
					List<BasOperationPeople> ope1 = basOperationPeopleDao.selectByCode(assistantArray[i], getBeid());
					regOpt.setAssistantId(regOpt.getAssistantId()+((ope1!=null&&ope1.size()>0)?ope1.get(0).getOperatorId()+",":null));
					regOpt.setAssistantName(regOpt.getAssistantName()+((ope1!=null&&ope1.size()>0)?ope1.get(0).getName()+",":null));
				}
			}
		}
		
		
		regOpt.setWeight(oper.getWeight());
		regOpt.setHeight(oper.getHeight());
		regOpt.setHbsag(oper.getHbsag());
		regOpt.setHcv(oper.getHcv());
		regOpt.setHiv(oper.getHiv());
		regOpt.setHp(oper.getHp());
		regOpt.setOperaDate(oper.getOperDate());
		regOpt.setHyperSusceptiBility(oper.getDragAllergy());
		regOpt.setOptLevel(oper.getOperLevel());
		regOpt.setEmergency(Integer.parseInt(oper.getOperType()));
		//regOpt.setIsLocalAnaes(oper.getAnaesType());
		regOpt.setDesignedAnaesMethodCode(oper.getAnaesId());
		regOpt.setDesignedAnaesMethodName(oper.getAnaesName());
		if("6".equals(oper.getAnaesId())||"20".equals(oper.getAnaesId())||("局麻").equals(StringUtils.isEmpty(oper.getAnaesName())?"":oper.getAnaesName().trim())){
			regOpt.setIsLocalAnaes(1);//局麻
		}else{
			regOpt.setIsLocalAnaes(0);//全麻
		}
		regOpt.setCreateTime(DateUtils.formatDateTime(new Date()));
		regOpt.setCreateUser(oper.getCreateUser());
		regOpt.setStartTime(oper.getOperStartTime());
		regOpt.setEndTime(oper.getOperEndTime());
		regOpt.setState(OperationState.NOT_REVIEWED);
		if(!(oper.getRegionName().indexOf("(本部)")== -1) ||!(oper.getRegionName().indexOf("(本)")== -1) || !(oper.getRegionName().indexOf("（本）")== -1)||!(oper.getDeptName().indexOf("(本部)")== -1) ||!(oper.getDeptName().indexOf("(本)")== -1) || !(oper.getDeptName().indexOf("（本）")== -1)){
			int result = basRegOptDao.insert(regOpt);
			
			LogUtils.saveOperateLog(regOptId, LogUtils.OPT_TYPE_INFO_SAVE,
                LogUtils.OPT_MODULE_INTERFACE, "HIS手术通知单", JsonType.jsonType(regOpt), UserUtils.getUserCache(), getBeid());
			return result;
		}
		return 0;
		
	}
	
	/**
	 * 深圳龙岗第二人民医院
	 * 回写手术ID给中天，让他们通过手术ID调用我们的网页，查看文书数据
	 */
	@Transactional(readOnly =false)
	public int tsurgeryhisid(BasRegOpt regOpt){
		logger.info("begin tsurgeryhisid");
		Connection conn = ConnectionManager.getConnection();
		int i = 0;
		 String insertSql = "insert into ycyl.tsurgeryhisid (fzyh,ftyzyh,surgeryid,fname) values(?,?,?,?)";
		 PreparedStatement insertPstmt = null;
		 PreparedStatement selectPstmt = null;
		 ResultSet rs = null;
		 String selectSql = "select * from ycyl.tsurgeryhisid where surgeryid = '"+regOpt.getRegOptId()+"'";
		 try{
			 selectPstmt = (PreparedStatement)conn.prepareStatement(selectSql);
		     rs = selectPstmt.executeQuery();
		     if(!rs.next()){
		    	 insertPstmt = (PreparedStatement)conn.prepareStatement(insertSql);
			     insertPstmt.setString(1, regOpt.getHid());//住院号
			     insertPstmt.setString(2, "");//统一住院号
			     insertPstmt.setString(3, regOpt.getRegOptId());//手术ID
			     insertPstmt.setString(4, regOpt.getName());//病人姓名
			     insertPstmt.executeUpdate();
			     insertPstmt.close();
		     }
		     //selectPstmt.close();
			 //conn.close();
		 }catch(Exception e){
			 e.printStackTrace();
		 }finally{
            try
            {
                closeConnection(selectPstmt, rs);
                closeConnection(insertPstmt, rs);
            }
            catch (SQLException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
		 }
		 
		 return i;
	}
	
	/**
	 * 深圳市龙岗区第二人民医院
	 * 手术安排后回写给中天
	 * @param regOpt
	 * @return
	 */
	@Transactional(readOnly =false)
	public int tsssqhz(BasRegOpt regOpt){
		logger.info("begin tsssqhz");
		
		DispatchFormbean dispatchBean = dispatchService.getDispatchOperByRegOptId(regOpt.getRegOptId());
		String insertSql = "insert into ycyl.tsssqhz (frecid,fzyh,fname,fsex,fnl,fbcdm,fbcmc,fsqkh,"
		 		+ "fsqks,fmzmc,fzd,fsurmc,fapsj,fsurroom,fsurgrde,fsurtype,fsurpart,fjj,doctor,assitant1,"
		 		+ "assitant2,anesthetist1,anesthetist2,anesthetist3,qxnurse,xhnurse,qxnurse2,xhnurse2,qxnurse3,"
		 		+ "xhnurse3,frecremark) values(?,?,?,?,?,?,?,?,"
		 		+ "?,?,?,?,?,?,?,?,?,?,?,?,"
		 		+ "?,?,?,?,?,?,?,?,?,"
		 		+ "?,?)";
		
		String operRoomName = null != dispatchBean ? dispatchBean.getOperRoomName() : "";
		String optBodyName = null != dispatchBean ? dispatchBean.getOptBodyName() : "";
        String anesthetistName = null != dispatchBean ? dispatchBean.getAnesthetistName() : "";
        String instrnurseName1 = null != dispatchBean ? dispatchBean.getInstrnurseName1() : "";
        String circunurseName1 = null != dispatchBean ? dispatchBean.getCircunurseName1() : "";
        String instrnurseName2 = null != dispatchBean ? dispatchBean.getInstrnurseName2() : "";
        String circunurseName2 = null != dispatchBean ? dispatchBean.getCircunurseName2() : "";
        String updateSql ="update ycyl.tsssqhz set fzyh='"+regOpt.getHid()+"',fname='"+regOpt.getName()+"',fsex="+( regOpt.getSex().equals("男")?1:2)+","
				+ "fnl='"+UserUtils.getAge(regOpt.getAge()+"",regOpt.getAgeMon() +"", regOpt.getAgeDay())+"',"
						+ "fmzmc='"+regOpt.getDesignedAnaesMethodName()+"',fzd='"+regOpt.getDiagnosisName()+"',fsurmc='"+regOpt.getDesignedOptName()+"',"
								+ "fapsj='"+regOpt.getOperaDate()+"',fsurroom='"+operRoomName+"',fsurgrde='"+regOpt.getOptLevel()+"',"
										+ "doctor='"+regOpt.getOperatorName()+"',assitant1='"+regOpt.getAssistantName()+"',anesthetist1='"+anesthetistName+"',"
												+ "qxnurse='"+instrnurseName1+"',xhnurse='"+circunurseName1+"',qxnurse2='"+instrnurseName2+"',"
														+ "xhnurse2='"+circunurseName2+"',frecremark='"+regOpt.getRemark()+"' where frecid='"+regOpt.getRegOptId()+"'";
		
		int i = 0;
		
		Connection conn = ConnectionManager.getConnection();
		PreparedStatement insertPstmt = null;
		PreparedStatement selectPstmt = null;
		PreparedStatement updatePstmt = null;
		ResultSet rs = null;
		String selectSql = "select * from ycyl.tsssqhz where frecid = '"+regOpt.getRegOptId()+"'";
		try{
			selectPstmt = (PreparedStatement)conn.prepareStatement(selectSql);
		    rs = selectPstmt.executeQuery();
		    if(!rs.next()){
		    	insertPstmt = (PreparedStatement)conn.prepareStatement(insertSql);
			    insertPstmt.setString(1, regOpt.getRegOptId());//手术ID
			    insertPstmt.setString(2, regOpt.getHid());//住院号
			    insertPstmt.setString(3, regOpt.getName());//病人姓名
			    insertPstmt.setInt(4, regOpt.getSex().equals("男")?1:2);//病人性别
			    insertPstmt.setString(5, UserUtils.getAge(regOpt.getAge()+"",regOpt.getAgeMon() +"", regOpt.getAgeDay()));//病人年龄
			    insertPstmt.setString(6,"");//病床代码
			    insertPstmt.setString(7, regOpt.getBed());//病床名称
			    insertPstmt.setString(8, regOpt.getDeptId()+"");//申请科号
			    insertPstmt.setString(9, regOpt.getDeptName());//申请科室
			    insertPstmt.setString(10, regOpt.getDesignedAnaesMethodName());//麻醉方法
			    insertPstmt.setString(11, regOpt.getDiagnosisName());//诊断
			    insertPstmt.setString(12, regOpt.getDesignedOptName());//手术名称
			    insertPstmt.setDate(13, DateUtils.stringToDate(regOpt.getOperaDate()));//安排时间
			    insertPstmt.setString(15, regOpt.getOptLevel());//手术等级
			    insertPstmt.setString(16, "");//手术方式
			    insertPstmt.setInt(18,regOpt.getEmergency());//紧急程度
			    insertPstmt.setString(19,regOpt.getOperatorName());//主刀医生
			    insertPstmt.setString(20,regOpt.getAssistantName());//助手医生1
			    insertPstmt.setString(21,"");//助手医生2
			    insertPstmt.setString(23,"");//麻醉医生2
			    insertPstmt.setString(24,"");//麻醉医生3
                insertPstmt.setString(14, operRoomName);// 手术间
                insertPstmt.setString(17, optBodyName);// 手术体位
                insertPstmt.setString(22, anesthetistName);// 麻醉医生1
                insertPstmt.setString(25, instrnurseName1);// 器械护士
                insertPstmt.setString(26, circunurseName1);// 巡回护士
                insertPstmt.setString(27, instrnurseName2);// 器械护士2
                insertPstmt.setString(28, circunurseName2);// 巡回护士2
			    insertPstmt.setString(29,"");//巡回护士3
			    insertPstmt.setString(30,"");//器械护士3
			    insertPstmt.setString(31,regOpt.getRemark());//手术备注
			    
			    int result = insertPstmt.executeUpdate();
			    if(result > 0){
			    	logger.info("tsssqhz 插入成功!");
			    }else{
			    	logger.info("tsssqhz 插入失败!");
			    }
			    //insertPstmt.close();
		    }else{
		    	updatePstmt = (PreparedStatement)conn.prepareStatement(updateSql);
		    	int result = updatePstmt.executeUpdate();
		    	//updatePstmt.close();
		    	if(result > 0){
			    	logger.info("tsssqhz 更新成功!");
			    }else{
			    	logger.info("tsssqhz 更新失败!");
			    }
		    }
		    //selectPstmt.close();
		 }catch(Exception e){
			 e.printStackTrace();
		 }
		finally{
		    try
            {
                closeConnection(insertPstmt, rs);
                closeConnection(updatePstmt, rs);
                closeConnection(selectPstmt, rs);
            }
            catch (SQLException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
		    
	    }
		logger.info("end tsssqhz");
		return i;
		 
	}

}
