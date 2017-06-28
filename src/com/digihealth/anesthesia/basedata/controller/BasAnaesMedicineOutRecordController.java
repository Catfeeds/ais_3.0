package com.digihealth.anesthesia.basedata.controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.digihealth.anesthesia.basedata.formbean.BasMedicineRegOptFormBean;
import com.digihealth.anesthesia.basedata.formbean.SystemSearchFormBean;
import com.digihealth.anesthesia.basedata.po.BasAnaesMedicineLoseRecord;
import com.digihealth.anesthesia.basedata.po.BasAnaesMedicineOutRecord;
import com.digihealth.anesthesia.basedata.po.BasAnaesMedicineRetreatRecord;
import com.digihealth.anesthesia.common.entity.ResponseValue;
import com.digihealth.anesthesia.common.web.BaseController;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

@Controller
@RequestMapping(value = "/basedata")
@Api(value = "BasAnaesMedicineOutRecordController", description = "毒麻药取药处理类")
public class BasAnaesMedicineOutRecordController extends BaseController
{
	/**
     * 
     * @discription 添加毒麻药取药记录
     * @author pengqing
     * @created 2017年6月13日 下午3:01:40
     * @param basAnaesMedicineInRecord
     * @return
     */
    @RequestMapping(value = "/addMedicineOutRecord")
    @ResponseBody
    @ApiOperation(value = "添加毒麻药取药记录", httpMethod = "POST", notes = "添加毒麻药取药记录")
    public String addMedicineOutRecord(
        @ApiParam(name = "basAnaesMedicineInRecord", value = "毒麻药入库对象") @RequestBody BasAnaesMedicineOutRecord basAnaesMedicineOutRecord)
    {
    	logger.info("begin addMedicineOutRecord");
        ResponseValue resp = new ResponseValue();
        if(null == basAnaesMedicineOutRecord)
        {
        	resp.setResultCode("10000001");
            resp.setResultMessage("要保存的记录不能为空。");
        }else
        {
        	basAnaesMedicineOutRecordService.addAnaesMedicineOutRecord(basAnaesMedicineOutRecord,resp);
        }
        logger.info("end addMedicineOutRecord");
        return resp.getJsonStr();
    }
    
	/**
     * 
     * @discription 根据条件查询毒麻药取药记录
     * @author pengqing
     * @created 2017年6月13日 下午3:01:40
     * @param systemSearchFormBean
     * @return
     */
    @RequestMapping(value = "/queryMedicineOutRecordList")
    @ResponseBody
    @ApiOperation(value = "根据条件查询毒麻药取药记录", httpMethod = "POST", notes = "根据条件查询毒麻药取药记录")
    public String queryMedicineOutRecordList(
        @ApiParam(name = "systemSearchFormBean", value = "系统查询参数") @RequestBody SystemSearchFormBean systemSearchFormBean)
    {
        logger.info("begin queryMedicineOutRecordList");
        ResponseValue resp = new ResponseValue();
        List<BasAnaesMedicineOutRecord> resultList = basAnaesMedicineOutRecordService.queryMedicineOutRecordList(systemSearchFormBean);
        int total = basAnaesMedicineOutRecordService.queryMedicineOutRecordListTotal(systemSearchFormBean);
        resp.put("resultList", resultList);
        resp.put("total", total);
        logger.info("end queryMedicineOutRecordList");
        return resp.getJsonStr();
    }
    
    
	/**
     * 
     * @discription 添加毒麻药退药记录
     * @author pengqing
     * @created 2017年6月13日 下午3:01:40
     * @param basAnaesMedicineRetreatRecord
     * @return
     */
    @RequestMapping(value = "/addMedicineRetreatRecord")
    @ResponseBody
    @ApiOperation(value = "添加毒麻药退药记录", httpMethod = "POST", notes = "添加毒麻药退药记录")
    public String addMedicineRetreatRecord(
        @ApiParam(name = "basAnaesMedicineRetreatRecord", value = "毒麻药退药记录") @RequestBody BasAnaesMedicineRetreatRecord basAnaesMedicineRetreatRecord)
    {
    	logger.info("begin addMedicineRetreatRecord");
        ResponseValue resp = new ResponseValue();
        if(null == basAnaesMedicineRetreatRecord)
        {
        	resp.setResultCode("10000001");
            resp.setResultMessage("要保存的记录不能为空。");
        }else
        {
        	basAnaesMedicineOutRecordService.addMedicineRetreatRecord(basAnaesMedicineRetreatRecord, resp);
        }
        logger.info("end addMedicineRetreatRecord");
        return resp.getJsonStr();
    }
    
    /**
     * 
     * @discription 添加毒麻药报损记录
     * @author pengqing
     * @created 2017年6月13日 下午3:01:40
     * @param basAnaesMedicineLoseRecord
     * @return
     */
    @RequestMapping(value = "/addMedicineLoseRecord")
    @ResponseBody
    @ApiOperation(value = "添加毒麻药报损记录", httpMethod = "POST", notes = "添加毒麻药报损记录")
    public String addMedicineLoseRecord(
        @ApiParam(name = "basAnaesMedicineLoseRecord", value = "毒麻药退药记录") @RequestBody BasAnaesMedicineLoseRecord basAnaesMedicineLoseRecord)
    {
    	logger.info("begin addMedicineLoseRecord");
        ResponseValue resp = new ResponseValue();
        if(null == basAnaesMedicineLoseRecord)
        {
        	resp.setResultCode("10000001");
            resp.setResultMessage("要保存的记录不能为空。");
        }else
        {
        	basAnaesMedicineOutRecordService.addMedicineLoseRecord(basAnaesMedicineLoseRecord, resp);
        }
        logger.info("end addMedicineLoseRecord");
        return resp.getJsonStr();
    }
    
	/**
     * 
     * @discription 查询手术是否取药信息列表
     * @author pengqing
     * @created 2017年6月13日 下午3:01:40
     * @param systemSearchFormBean
     * @return
     */
    @RequestMapping(value = "/selectRegOptInfoForOutRecord")
    @ResponseBody
    @ApiOperation(value = "查询手术是否取药信息列表", httpMethod = "POST", notes = "查询手术是否取药信息列表")
  	public String selectRegOptInfoForOutRecord(@ApiParam(name = "systemSearchFormBean", value = "系统查询参数") @RequestBody SystemSearchFormBean systemSearchFormBean)
    {
        logger.info("begin selectRegOptInfoForOutRecord");
        ResponseValue resp = new ResponseValue();
        List<BasMedicineRegOptFormBean> resultList = basAnaesMedicineOutRecordService.selectRegOptInfoForOutRecordList(systemSearchFormBean);
        int total = basAnaesMedicineOutRecordService.selectRegOptInfoForOutRecordListTotal(systemSearchFormBean);
        resp.put("resultList", resultList);
        resp.put("total", total);
        logger.info("end selectRegOptInfoForOutRecord");
        return resp.getJsonStr();
    }
    
    /**
     * 
     * @discription 删除毒麻药退药记录
     * @author pengqing
     * @created 2017年6月13日 下午3:01:40
     * @param map
     * @return
     */
    @RequestMapping(value = "/delMedicineRetreatRecord")
    @ResponseBody
    @ApiOperation(value = "删除毒麻药退药记录", httpMethod = "POST", notes = "添加毒麻药退药记录")
    public String delMedicineRetreatRecord(
        @ApiParam(name = "map", value = "毒麻药退药记录id和取药id必传") @RequestBody Map<String,Object> map)
    {
    	logger.info("begin delMedicineRetreatRecord");
        ResponseValue resp = new ResponseValue();
        if(null == map || null == map.get("id"))
        {
        	resp.setResultCode("10000001");
            resp.setResultMessage("退药记录id不能为空！");
        }else
        {
        	Integer id = Integer.parseInt(map.get("id").toString());
        	basAnaesMedicineOutRecordService.delMedicineRetreatRecord(id,resp);
        }
        logger.info("end delMedicineRetreatRecord");
        return resp.getJsonStr();
    }
    
    /**
     * 
     * @discription 删除毒麻药报损记录
     * @author pengqing
     * @created 2017年6月13日 下午3:01:40
     * @param map
     * @return
     */
    @RequestMapping(value = "/delMedicineLoseRecord")
    @ResponseBody
    @ApiOperation(value = "删除毒麻药报损记录", httpMethod = "POST", notes = "添加毒麻药报损记录")
    public String delMedicineLoseRecord(
        @ApiParam(name = "map", value = "毒麻药报损记录id") @RequestBody Map<String,Object> map)
    {
    	logger.info("begin delMedicineLoseRecord");
        ResponseValue resp = new ResponseValue();
        if(null == map || null == map.get("id"))
        {
        	resp.setResultCode("10000001");
            resp.setResultMessage("报损记录id不能为空！");
        }else
        {
        	Integer id = Integer.parseInt(map.get("id").toString());
        	basAnaesMedicineOutRecordService.delMedicineLoseRecord(id,resp);
        }
        logger.info("end delMedicineLoseRecord");
        return resp.getJsonStr();
    }
    
    
    /**
     * 
     * @discription 逻辑删除毒麻药取药记录
     * @author pengqing
     * @created 2017年6月13日 下午3:01:40
     * @param map
     * @return
     */
    @RequestMapping(value = "/delMedicineOutRecord")
    @ResponseBody
    @ApiOperation(value = "逻辑删除毒麻药取药记录", httpMethod = "POST", notes = "逻辑删除毒麻药取药记录")
    public String delMedicineOutRecord(
        @ApiParam(name = "map", value = "毒麻药取药id必传") @RequestBody Map<String,Object> map)
    {
    	logger.info("begin delMedicineOutRecord");
        ResponseValue resp = new ResponseValue();
        if(null == map || null == map.get("id"))
        {
        	resp.setResultCode("10000001");
            resp.setResultMessage("取药记录id不能为空！");
        }else
        {
        	Integer id = Integer.parseInt(map.get("id").toString());
        	basAnaesMedicineOutRecordService.delMedicineOutRecord(id,resp);
        }
        logger.info("end delMedicineOutRecord");
        return resp.getJsonStr();
    }
}
