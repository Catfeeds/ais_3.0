package com.digihealth.anesthesia.basedata.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.digihealth.anesthesia.basedata.formbean.BaseInfoQuery;
import com.digihealth.anesthesia.basedata.formbean.MedicineFormBean;
import com.digihealth.anesthesia.basedata.formbean.SystemSearchFormBean;
import com.digihealth.anesthesia.basedata.po.BasMedicine;
import com.digihealth.anesthesia.basedata.po.BasPrice;
import com.digihealth.anesthesia.common.entity.ResponseValue;
import com.digihealth.anesthesia.common.web.BaseController;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

/**
 * 
 * Title: MedicineController.java Description: 药品表MedicineController
 * 
 * @author liukui
 * @created 2015-9-15 下午1:56:40
 */
@Controller
@RequestMapping(value = "/basedata")
@Api(value = "BasMedicineController", description = "药品信息处理类")
public class BasMedicineController extends BaseController
{
    
    @RequestMapping(value = "/getMedicineList")
    @ResponseBody
    @ApiOperation(value = "查询药品列表", httpMethod = "POST", notes = "查询药品列表")
    public String getMedicineList(@ApiParam(name = "baseQuery", value = "系统查询对象") @RequestBody BaseInfoQuery baseQuery)
    {
        logger.info("begin getMedicineList");
        ResponseValue resp = new ResponseValue();
        List<MedicineFormBean> resultList = basMedicineService.findList(baseQuery);
        resp.put("resultList", resultList);
        logger.info("end getMedicineList");
        return resp.getJsonStr();
    }
    
    /**
     * 
     * @discription 根据条件查询药品信息
     * @author liukui
     * @created 2015年12月3日 下午3:01:40
     * @param systemSearchFormBean
     * @return
     */
    @RequestMapping(value = "/queryMedicineList")
    @ResponseBody
    @ApiOperation(value = "根据条件查询药品信息", httpMethod = "POST", notes = "根据条件查询药品信息")
    public String queryMedicineList(
        @ApiParam(name = "systemSearchFormBean", value = "系统查询对象") @RequestBody SystemSearchFormBean systemSearchFormBean)
    {
        logger.info("begin queryMedicineList");
        ResponseValue resp = new ResponseValue();
        List<BasMedicine> resultList = basMedicineService.queryMedicineList(systemSearchFormBean);
        int total = basMedicineService.queryMedicineListTotal(systemSearchFormBean);
        resp.put("resultList", resultList);
        resp.put("total", total);
        logger.info("end queryMedicineList");
        return resp.getJsonStr();
    }
    
    /**
     * 
     * @discription 查询单个药品信息
     * @author liukui
     * @created 2015年12月3日 下午3:01:54
     * @param dept
     * @return
     */
    @RequestMapping(value = "/queryMedicineById")
    @ResponseBody
    @ApiOperation(value = "查询单个药品信息", httpMethod = "POST", notes = "查询单个药品信息")
    public String queryMedicineById(@ApiParam(name = "medicine", value = "药品信息对象") @RequestBody BasMedicine medicine)
    {
        logger.info("begin queryMedicineById");
        ResponseValue resp = new ResponseValue();
        BasMedicine resultDept = basMedicineService.queryMedicineById(medicine.getMedicineId());
        resp.put("medicine", resultDept);
        logger.info("end queryMedicineById");
        return resp.getJsonStr();
    }
    
    /**
     * 
     * @discription 修改或者添加药品信息
     * @author liukui
     * @created 2015年12月3日 下午3:02:15
     * @param Operdef
     * @return
     */
    @RequestMapping(value = "/saveMedicine")
    @ResponseBody
    @ApiOperation(value = "修改或者添加药品信息", httpMethod = "POST", notes = "修改或者添加药品信息")
    public String saveMedicine(@ApiParam(name = "medicine", value = "药品信息对象") @RequestBody BasMedicine medicine)
    {
        logger.info("begin saveMedicine");
        ResponseValue resp = new ResponseValue();
        basMedicineService.saveMedicine(medicine);
        logger.info("end saveMedicine");
        return resp.getJsonStr();
    }
    
    /**
     * 
     * @discription 删除药品信息
     * @author liukui
     * @created 2015年12月3日 下午3:02:15
     * @param Operdef
     * @return
     */
    @RequestMapping(value = "/deleteMedicine")
    @ResponseBody
    @ApiOperation(value = "删除药品信息", httpMethod = "POST", notes = "删除药品信息")
    public String deleteMedicine(@ApiParam(name = "medicineIdList", value = "药品信息对象") @RequestBody List<String> medicineIdList)
    {
        logger.info("begin deleteMedicine");
        ResponseValue resp = new ResponseValue();
        basMedicineService.deleteMedicine(medicineIdList);
        logger.info("end deleteMedicine");
        return resp.getJsonStr();
    }
    
    /**
     * 
     * @discription 根据药品信息显示价格明细
     * @author liukui
     * @created 2015年12月3日 下午3:01:54
     * @param dept
     * @return
     */
    @RequestMapping(value = "/editMedicineAandPrice")
    @ResponseBody
    @ApiOperation(value = "根据药品信息显示价格明细", httpMethod = "POST", notes = "根据药品信息显示价格明细")
    public String editMedicineAandPrice(@ApiParam(name = "medicine", value = "药品信息对象") @RequestBody BasMedicine medicine)
    {
        logger.info("begin editMedicineAandPrice");
        ResponseValue resp = new ResponseValue();
        BasMedicine resultPo = basMedicineService.queryMedicineById(medicine.getMedicineId());
        BaseInfoQuery baseQuery = new BaseInfoQuery();
        baseQuery.setCode(resultPo.getCode());
        List<BasPrice> priceList = basPriceService.searchPriceList(baseQuery);
        resp.put("medicine", resultPo);
        resp.put("resultList", priceList);
        logger.info("end editMedicineAandPrice");
        return resp.getJsonStr();
    }
    
}
