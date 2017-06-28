package com.digihealth.anesthesia.basedata.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.digihealth.anesthesia.basedata.formbean.BasAnaesMedicineOutRecordFormBean;
import com.digihealth.anesthesia.basedata.formbean.BasAnaesMedicineStorageFormbean;
import com.digihealth.anesthesia.basedata.formbean.SystemSearchFormBean;
import com.digihealth.anesthesia.basedata.po.BasAnaesMedicineStorage;
import com.digihealth.anesthesia.common.entity.ResponseValue;
import com.digihealth.anesthesia.common.web.BaseController;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

@Controller
@RequestMapping(value = "/basedata") 
@Api(value = "BasAnaesMedicineStorageController", description = "毒麻药库存处理类")
public class BasAnaesMedicineStorageController extends BaseController
{
	
	/**
     * 
     * @discription 按药品名字，厂家，规格 查询毒麻药库存记录
     * @author pengqing
     * @created 2017年6月13日 下午3:01:40
     * @param systemSearchFormBean
     * @return
     */
    @RequestMapping(value = "/queryAnaesMedicineListGroupByNFS")
    @ResponseBody
    @ApiOperation(value = "按药品名字，厂家，规格 查询毒麻药库存记录", httpMethod = "POST", notes = "按药品名字，厂家，规格 查询毒麻药库存记录")
    public String queryAnaesMedicineListGroupByNFS(
        @ApiParam(name = "systemSearchFormBean", value = "系统查询参数") @RequestBody SystemSearchFormBean systemSearchFormBean)
    {
        logger.info("begin queryAnaesMedicineListGroupByNFS");
        ResponseValue resp = new ResponseValue();
        List<BasAnaesMedicineStorage> resultList = basAnaesMedicineStorageService.queryAnaesMedicineListGroupByNFS(systemSearchFormBean);
        int total = basAnaesMedicineStorageService.queryAnaesMedicineListGroupByNFSTotal(systemSearchFormBean);
        resp.put("resultList", resultList);
        resp.put("total", total);
        logger.info("end queryAnaesMedicineListGroupByNFS");
        return resp.getJsonStr();
    }
    
	/**
     * @discription 根据条件查询毒麻药库存记录
     * @author pengqing
     * @created 2017年6月13日 下午3:01:40
     * @param systemSearchFormBean
     * @return
     */
    @RequestMapping(value = "/queryAnaesMedicineList")
    @ResponseBody
    @ApiOperation(value = "根据条件查询毒麻药库存记录", httpMethod = "POST", notes = "根据条件查询毒麻药库存记录")
    public String queryAnaesMedicineList(
        @ApiParam(name = "systemSearchFormBean", value = "系统查询参数") @RequestBody SystemSearchFormBean systemSearchFormBean)
    {
        logger.info("begin queryMedicineList");
        ResponseValue resp = new ResponseValue();
        List<BasAnaesMedicineStorage> resultList = basAnaesMedicineStorageService.queryMedicineList(systemSearchFormBean);
        int total = basAnaesMedicineStorageService.queryMedicineListTotal(systemSearchFormBean);
        resp.put("resultList", resultList);
        resp.put("total", total);
        logger.info("end queryMedicineList");
        return resp.getJsonStr();
    }
    
	/**
     * 
     * @discription 按月统计库存情况
     * @author pengqing
     * @created 2017年6月13日 下午3:01:40
     * @param map
     * @return
     */
    @RequestMapping(value = "/queryAnaesMedicineByMonth")
    @ResponseBody
    @ApiOperation(value = "按月统计库存情况", httpMethod = "POST", notes = "按月统计库存情况")
    public String queryAnaesMedicineByMonth(
        @ApiParam(name = "map", value = "库存查询参数")@RequestBody SystemSearchFormBean systemSearchFormBean)
    {
        logger.info("begin queryMedicineList");
        ResponseValue resp = new ResponseValue();
        List<BasAnaesMedicineStorageFormbean> resultList = basAnaesMedicineStorageService.queryAnaesMedicineByMonth(systemSearchFormBean,resp);
        int total = basAnaesMedicineStorageService.queryAnaesMedicineByMonthTotal(systemSearchFormBean);
        resp.put("resultList", resultList);
        resp.put("total", total);
        logger.info("end queryMedicineList");
        return resp.getJsonStr();
    }
    
    
	/**
     * 
     * @discription 统计个人用药情况
     * @author pengqing
     * @created 2017年6月13日 下午3:01:40
     * @param map
     * @return
     */
    @RequestMapping(value = "/queryAnaesMedicineByPersonal")
    @ResponseBody
    @ApiOperation(value = "统计个人用药情况", httpMethod = "POST", notes = "统计个人用药情况")
    public String queryAnaesMedicineByPersonal(
        @ApiParam(name = "map", value = "库存查询参数")@RequestBody SystemSearchFormBean systemSearchFormBean)
    {
        logger.info("begin queryMedicineList");
        ResponseValue resp = new ResponseValue();
        List<BasAnaesMedicineOutRecordFormBean> resultList = basAnaesMedicineStorageService.queryAnaesMedicineByPersonal(systemSearchFormBean);
        int total = basAnaesMedicineStorageService.queryAnaesMedicineByPersonalTotal(systemSearchFormBean);
        resp.put("resultList", resultList);
        resp.put("total", total);
        logger.info("end queryMedicineList");
        return resp.getJsonStr();
    }
}
