package com.digihealth.anesthesia.basedata.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.digihealth.anesthesia.basedata.formbean.BaseInfoQuery;
import com.digihealth.anesthesia.basedata.formbean.SystemSearchFormBean;
import com.digihealth.anesthesia.basedata.po.BasCheckItem;
import com.digihealth.anesthesia.common.entity.ResponseValue;
import com.digihealth.anesthesia.common.web.BaseController;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

/**
 * 
     * Title: CheckItemController.java    
     * Description: 检验事件
     * @author chengwang       
     * @created 2015年12月15日 上午10:05:27
 */
@Controller
@RequestMapping(value = "/basedata")
@Api(value = "BasCheckItemController", description = "检验项目处理类")
public class BasCheckItemController extends BaseController {

	@RequestMapping(value = "/searchAllCheckItem")
	@ResponseBody
	@ApiOperation(value = "查询检验项目", httpMethod = "POST", notes = "查询检验项目")
	public String searchAllCheckItem(@ApiParam(name = "baseQuery", value = "系统查询对象") @RequestBody BaseInfoQuery baseQuery) {
        logger.info("begin searchAllCheckItem");
        ResponseValue resp = new ResponseValue();
        List<BasCheckItem> resultList = basCheckItemService.searchAllCheckItem(baseQuery);
        resp.put("resultList", resultList);
        logger.info("end searchAllCheckItem");
        return resp.getJsonStr();
	}
	
	
	/**
	 * 
	     * @discription 根据条件查询检查项目
	     * @author liukui       
	     * @created 2015年12月3日 下午3:01:40     
	     * @param systemSearchFormBean
	     * @return
	 */
	@RequestMapping(value = "/queryCheckItemList")
	@ResponseBody
	@ApiOperation(value = "根据条件查询检查项目", httpMethod = "POST", notes = "根据条件查询检查项目")
	public String queryCheckItemList(@ApiParam(name = "systemSearchFormBean", value = "系统查询对象") @RequestBody SystemSearchFormBean systemSearchFormBean) {
		logger.info("begin queryCheckItemList");
		ResponseValue resp = new ResponseValue();
		List<BasCheckItem> resultList = basCheckItemService.queryCheckItemList(systemSearchFormBean);
		int total = basCheckItemService.queryCheckItemListTotal(systemSearchFormBean);
		resp.put("resultList", resultList);
		resp.put("total", total);
		logger.info("end queryCheckItemList");
		return resp.getJsonStr();
	}
	
	/**
	 * 
	     * @discription 查询单个检查项目
	     * @author liukui       
	     * @created 2015年12月3日 下午3:01:54     
	     * @param dept
	     * @return
	 */
	@RequestMapping(value = "/queryCheckItemById")
	@ResponseBody
	@ApiOperation(value = "查询单个检查项目", httpMethod = "POST", notes = "查询单个检查项目")
	public String queryCheckItemById(@ApiParam(name = "checkItem", value = "检查项目对象") @RequestBody BasCheckItem checkItem){
		logger.info("begin queryCheckItemById");
		ResponseValue resp = new ResponseValue();
		BasCheckItem resultObj = basCheckItemService.queryCheckItemById(checkItem.getChkItemId());
		resp.put("checkItem", resultObj);
		logger.info("end queryCheckItemById");
		return resp.getJsonStr();
	}
	
	/**
	 * 
	     * @discription 修改或者添加检查项目
	     * @author liukui      
	     * @created 2015年12月3日 下午3:02:15     
	     * @param Operdef
	     * @return
	 */
	@RequestMapping(value = "/saveCheckItem")
	@ResponseBody
	@ApiOperation(value = "修改或者添加检查项目", httpMethod = "POST", notes = "修改或者添加检查项目")
	public String saveCheckItem(@ApiParam(name = "checkItem", value = "检查项目对象") @RequestBody BasCheckItem checkItem){
		logger.info("begin saveCheckItem");
		ResponseValue resp = new ResponseValue();
        basCheckItemService.saveCheckItem(checkItem);
		logger.info("end saveCheckItem");
		return resp.getJsonStr();
	}
	/**
	 * 
	     * @discription 删除检查项目
	     * @author liukui      
	     * @created 2015年12月3日 下午3:02:15     
	     * @param Operdef
	     * @return
	 */
	@RequestMapping(value = "/deleteCheckItem")
	@ResponseBody
	@ApiOperation(value = "删除检查项目", httpMethod = "POST", notes = "删除检查项目")
	public String deleteCheckItem(@ApiParam(name = "cheItemIdList", value = "检查项目Id列表") @RequestBody List<String> cheItemIdList){
		logger.info("begin deleteCheckItem");
		ResponseValue resp = new ResponseValue();
        basCheckItemService.deleteCheckItem(cheItemIdList);
		logger.info("end deleteCheckItem");
		return resp.getJsonStr();
	}
}
