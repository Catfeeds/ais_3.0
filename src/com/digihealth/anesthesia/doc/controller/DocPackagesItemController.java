/**     
 * @discription 在此输入一句话描述此文件的作用
 * @author chengwang       
 * @created 2015-10-10 下午5:34:19    
 * tags     
 * see_to_target     
 */

package com.digihealth.anesthesia.doc.controller;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.digihealth.anesthesia.common.entity.ResponseValue;
import com.digihealth.anesthesia.common.web.BaseController;
import com.digihealth.anesthesia.doc.po.DocPackagesItem;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

/**
 * 
     * Title: PackagesItemController.java    
     * Description: 费用统计中收费项目
     * @author chengwang       
     * @created 2015年12月16日 下午2:35:49
 */
@Controller
@RequestMapping(value = "/document")
@Api(value="DocPackagesItemController",description="收费项目处理类")
public class DocPackagesItemController extends BaseController {
	
	@RequestMapping(value = "/insertPackagesItem")
	@ResponseBody
	@ApiOperation(value="保存收费项目",httpMethod="POST",notes="保存收费项目")
	public String insertPackagesItem(@ApiParam(name="packagesItem", value ="保存参数") @RequestBody DocPackagesItem packagesItem) {
		logger.info("----------------begin insertPackagesItem----------------");
		ResponseValue resp = new ResponseValue();
		List<DocPackagesItem> packagesItemList = docPackagesItemService.insertPackagesItem(packagesItem);
		resp.put("packagesItemList",packagesItemList);
		logger.info("----------------end insertPackagesItem----------------");
		return resp.getJsonStr();
	}
	
	@RequestMapping(value = "/changePackagesItem")
	@ResponseBody
	@ApiOperation(value="修改收费项目",httpMethod="POST",notes="修改收费项目")
	public String changePackagesItem(@RequestBody DocPackagesItem packagesItem){
		logger.info("----------------begin changePackagesItem----------------");
		ResponseValue resp = new ResponseValue();
		int flag = docPackagesItemService.updateIsCharge(packagesItem);
		if(flag > 0){
			resp.setResultCode("1");
			resp.setResultMessage("修改成功！");
		}
		
		logger.info("----------------end changePackagesItem----------------");
		return resp.getJsonStr();
	}

}
