package com.digihealth.anesthesia.basedata.controller;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.digihealth.anesthesia.basedata.formbean.SystemSearchFormBean;
import com.digihealth.anesthesia.basedata.po.BasAnaesMedicineInRecord;
import com.digihealth.anesthesia.common.entity.ResponseValue;
import com.digihealth.anesthesia.common.web.BaseController;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

@Controller
@RequestMapping(value = "/basedata")
@Api(value = "BasAnaesMedicineInRecordController", description = "毒麻药入库处理类")
public class BasAnaesMedicineInRecordController extends BaseController
{

	/**
     * 
     * @discription 根据条件查询毒麻药入库记录
     * @author pengqing
     * @created 2017年6月13日 下午3:01:40
     * @param systemSearchFormBean
     * @return
     */
    @RequestMapping(value = "/queryMedicineInRecordList")
    @ResponseBody
    @ApiOperation(value = "根据条件查询毒麻药入库记录", httpMethod = "POST", notes = "根据条件查询毒麻药入库记录")
    public String queryMedicineInRecordList(
        @ApiParam(name = "systemSearchFormBean", value = "系统查询参数") @RequestBody SystemSearchFormBean systemSearchFormBean)
    {
        logger.info("begin queryMedicineInRecordList");
        ResponseValue resp = new ResponseValue();
        List<BasAnaesMedicineInRecord> resultList = basAnaesMedicineInRecordService.queryMedicineInRecordList(systemSearchFormBean);
        int total = basAnaesMedicineInRecordService.queryMedicineInRecordListTotal(systemSearchFormBean);
        resp.put("resultList", resultList);
        resp.put("total", total);
        logger.info("end queryMedicineInRecordList");
        return resp.getJsonStr();
    }
    
	/**
     * 
     * @discription 存储毒麻药入库记录
     * @author pengqing
     * @created 2017年6月13日 下午3:01:40
     * @param basAnaesMedicineInRecord
     * @return
     */
    @RequestMapping(value = "/saveMedicineInRecord")
    @ResponseBody
    @ApiOperation(value = "存储毒麻药入库记录", httpMethod = "POST", notes = "没有传了id是新增，传了是修改")
    public String saveMedicineInRecord(
        @ApiParam(name = "basAnaesMedicineInRecord", value = "毒麻药入库对象") @RequestBody BasAnaesMedicineInRecord basAnaesMedicineInRecord)
    {
    	logger.info("begin saveMedicineInRecord");
        ResponseValue resp = new ResponseValue();
        basAnaesMedicineInRecordService.saveMedicineInRecord(basAnaesMedicineInRecord);
        logger.info("end saveMedicineInRecord");
        return resp.getJsonStr();
    }
    
	/**
     * 
     * @discription 审核毒麻药入库记录
     * @author pengqing
     * @created 2017年6月13日 下午3:01:40
     * @param basAnaesMedicineInRecord
     * @return
     */
    @RequestMapping(value = "/checkMedicineInRecord")
    @ResponseBody
    @ApiOperation(value = "审核毒麻药入库记录", httpMethod = "POST", notes = "没有传了id是新增，传了是修改")
    public String checkMedicineInRecord(
        @ApiParam(name = "basAnaesMedicineInRecord", value = "毒麻药入库对象") @RequestBody BasAnaesMedicineInRecord basAnaesMedicineInRecord)
    {
    	logger.info("begin checkMedicineInRecord");
        ResponseValue resp = new ResponseValue();
        if(null == basAnaesMedicineInRecord || null == basAnaesMedicineInRecord.getId()
        		|| StringUtils.isBlank(basAnaesMedicineInRecord.getCheckName()))
        {
        	resp.setResultCode("10000001");
            resp.setResultMessage("核对记录和核对者不能为空");
        }else
        {
        	Integer id = basAnaesMedicineInRecord.getId();
        	BasAnaesMedicineInRecord selectBasAnaesMedicineInRecord = basAnaesMedicineInRecordService.selectById(id);
        	//状态必须是未审核的才可以，不然会导致重复审核
        	if(selectBasAnaesMedicineInRecord.getStatus() == 0)
        	{
        		//改变状态
            	basAnaesMedicineInRecordService.checkMedicineInRecord(basAnaesMedicineInRecord);
            	//存入毒麻药库
            	basAnaesMedicineStorageService.saveToMedicineStorage(selectBasAnaesMedicineInRecord);
        	}else
        	{
        		resp.setResultCode("10000002");
                resp.setResultMessage("这条记录已经核对入库了，不能重复操作");
        	}
        }
        logger.info("end checkMedicineInRecord");
        return resp.getJsonStr();
    }
    
    /**
     * 
     * @discription 删除毒麻药入库记录
     * @author pengqing
     * @created 2017年6月13日 下午3:01:40
     * @param systemSearchFormBean
     * @return
     */
    @RequestMapping(value = "/delMedicineInRecord")
    @ResponseBody
    @ApiOperation(value = "删除毒麻药入库记录", httpMethod = "POST", notes = "没有传了id是新增，传了是修改")
    public String delMedicineInRecord(
        @ApiParam(name = "map", value = "要删除的毒麻药入库记录id必传") @RequestBody Map<String,Object> map)
    {
    	logger.info("begin delMedicineInRecord");
        ResponseValue resp = new ResponseValue();
        if(null == map || null == map.get("id"))
        {
        	resp.setResultCode("10000001");
            resp.setResultMessage("要删除的毒麻药入库记录id必传");
        }else
        {
        	Integer id = Integer.parseInt(map.get("id").toString());
        	basAnaesMedicineInRecordService.delMedicineInRecord(id);
        }
        
        logger.info("end delMedicineInRecord");
        return resp.getJsonStr();
    }
    
}
