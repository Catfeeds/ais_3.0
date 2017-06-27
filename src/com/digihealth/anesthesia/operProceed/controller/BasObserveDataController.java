package com.digihealth.anesthesia.operProceed.controller;

//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import com.digihealth.anesthesia.basedata.formbean.BaseInfoQuery;
//import com.digihealth.anesthesia.common.entity.ResponseValue;
import com.digihealth.anesthesia.common.web.BaseController;
//import com.digihealth.anesthesia.operProceed.po.BasObserveData;

//@Controller
//@RequestMapping(value = "/observedata")
public class BasObserveDataController extends BaseController {
//    @RequestMapping(value = "/getObserveDataList")
//    @ResponseBody
//    public String getObserveDataList(@RequestBody BaseInfoQuery baseQuery) {
//       logger.info("begin getObserveDataList");
//       Integer total = observeDataService.searchObserveDataListTotal(baseQuery);
//       ResponseValue resp = new ResponseValue();
//       resp.put("total", total);
//       resp.put("no", baseQuery.getId());
//       resp.put("msgBody", observeDataService.searchObserveDataList(baseQuery));
//
//       logger.info("end getObserveDataList");
//       return resp.getJsonStr();
//    }
//    
//    @RequestMapping(value = "/updateObserveData")
//    @ResponseBody
//    public void updateObserveData(@RequestBody BasObserveData observeData) {
//        logger.info("begin updateObserveData");
//        observeDataService.updateObserveData(observeData);
//        logger.info("end updateObserveData");
//    }
//    
//    @RequestMapping(value = "/getPrintObserveData")
//    @ResponseBody
//    public String getPrintObserveData(@RequestBody BaseInfoQuery baseQuery) {
//       logger.info("begin getPrintObserveData");
//       ResponseValue resp = new ResponseValue();
//	   resp.put("msgBody", observeDataService.searchPrintObserveData(baseQuery));
//       logger.info("end getPrintObserveData");
//       return resp.getJsonStr();
//    }
}
