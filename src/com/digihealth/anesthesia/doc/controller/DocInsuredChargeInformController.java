package com.digihealth.anesthesia.doc.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.digihealth.anesthesia.common.entity.ResponseValue;
import com.digihealth.anesthesia.common.web.BaseController;
import com.digihealth.anesthesia.doc.formbean.InsuredChargeInformFormbean;
import com.digihealth.anesthesia.doc.po.DocInsuredChargeInform;
import com.digihealth.anesthesia.doc.po.DocInsuredChargeItem;
import com.digihealth.anesthesia.evt.formbean.SearchRegOptByIdFormBean;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

@Controller
@RequestMapping(value = "/document")
@Api(value="DocInsuredChargeInformController",description="参保患者使用自费药品、医用材料和服务设施告知书处理类")
public class DocInsuredChargeInformController extends BaseController
{
    /** 
     * 查询参保患者使用自费药品、医用材料和服务设施告知书
     * <功能详细描述>
     * @param map
     * @return
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping(value = "/searchInsuredChargeInform")
    @ResponseBody
	@ApiOperation(value="查询参保患者使用自费药品、医用材料和服务设施告知书",httpMethod="POST",notes="查询参保患者使用自费药品、医用材料和服务设施告知书")
    public String searchInsuredChargeInformByRegOptId(@ApiParam(name="map", value ="查询参数") @RequestBody Map<String, Object> map) {
        logger.info("------------begin searchInsuredChargeInform--------------");
        ResponseValue resp = new ResponseValue();
        String regOptId = map.get("regOptId")!=null?map.get("regOptId").toString():"";
        
        InsuredChargeInformFormbean insuredChargeInformFormbean = docInsuredChargeInformService.selectByRegOptId(regOptId);
        DocInsuredChargeInform insuredChargeInform = insuredChargeInformFormbean.getInsuredChargeInform();
        if (null == insuredChargeInform) {
        	resp.setResultCode("40000002");
        	resp.setResultMessage("参保患者使用自费药品、医用材料和服务设施告知书不存在");
            return resp.getJsonStr();
        }
        
        List<SearchRegOptByIdFormBean> searchRegOptByIdFormBeanList = basRegOptService.searchApplicationById(regOptId);
        SearchRegOptByIdFormBean searchRegOptByIdFormBean =  searchRegOptByIdFormBeanList!=null?searchRegOptByIdFormBeanList.get(0):null;
        
        //首次进入文书添加五个默认值
        if (null == insuredChargeInform.getFlag()) {
            List<DocInsuredChargeItem> insuredChargeItems = new ArrayList<DocInsuredChargeItem>();
            DocInsuredChargeItem insuredChargeItem = new DocInsuredChargeItem();
            insuredChargeItem.setInsuredId(insuredChargeInform.getId());
            insuredChargeItem.setName("阿扎司琼氯化钠注射液");
            insuredChargeItem.setTime(new Date());
            insuredChargeItem.setPrice(48.74f);
            insuredChargeItems.add(insuredChargeItem);
            docInsuredChargeInformService.updateInsuredChargeItem(insuredChargeItem);
            insuredChargeItem = new DocInsuredChargeItem();
            insuredChargeItem.setInsuredId(insuredChargeInform.getId());
            insuredChargeItem.setName("地佐辛注射液");
            insuredChargeItem.setTime(new Date());
            insuredChargeItem.setPrice(120.00f);
            insuredChargeItems.add(insuredChargeItem);
            docInsuredChargeInformService.updateInsuredChargeItem(insuredChargeItem);
            insuredChargeItem = new DocInsuredChargeItem();
            insuredChargeItem.setInsuredId(insuredChargeInform.getId());
            insuredChargeItem.setName("盐酸纳布啡注射液");
            insuredChargeItem.setTime(new Date());
            insuredChargeItem.setPrice(86.63f);
            insuredChargeItems.add(insuredChargeItem);
            docInsuredChargeInformService.updateInsuredChargeItem(insuredChargeItem);
            insuredChargeItem = new DocInsuredChargeItem();
            insuredChargeItem.setInsuredId(insuredChargeInform.getId());
            insuredChargeItem.setName("盐酸戊乙奎醚注射液");
            insuredChargeItem.setTime(new Date()); 
            insuredChargeItem.setPrice(44.57f);
            insuredChargeItems.add(insuredChargeItem);
            docInsuredChargeInformService.updateInsuredChargeItem(insuredChargeItem);
            insuredChargeItem = new DocInsuredChargeItem();
            insuredChargeItem.setInsuredId(insuredChargeInform.getId());
            insuredChargeItem.setName("羟乙基淀粉 130/0.4 注射液");
            insuredChargeItem.setTime(new Date());
            insuredChargeItem.setPrice(60.00f);
            insuredChargeItems.add(insuredChargeItem);
            docInsuredChargeInformService.updateInsuredChargeItem(insuredChargeItem);
            insuredChargeInformFormbean.setInsuredChargeItemList(insuredChargeItems);
            
            //将文书改为非首次进入
            insuredChargeInform.setFlag(0);
            docInsuredChargeInformService.updateInsuredChargeInform(insuredChargeInform);
        }
        resp.setResultCode("1");
        resp.setResultMessage("查询成功!");
        resp.put("insuredChargeInform", insuredChargeInform);
        resp.put("insuredChargeItemList", insuredChargeInformFormbean.getInsuredChargeItemList());
        resp.put("searchRegOptByIdFormBean", searchRegOptByIdFormBean);
        logger.info("------------end searchInsuredChargeInform-----------");
        return resp.getJsonStr();
    }
    
    /** 
     * 修改参保患者使用自费药品、医用材料和服务设施告知书
     * <功能详细描述>
     * @param insuredChargeItem
     * @return
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping(value = "/updateInsuredChargeInform")
    @ResponseBody
	@ApiOperation(value="修改参保患者使用自费药品、医用材料和服务设施告知书",httpMethod="POST",notes="修改参保患者使用自费药品、医用材料和服务设施告知书")
    public String updateInsuredChargeInform(@ApiParam(name="insuredChargeInform", value ="修改参数") @RequestBody DocInsuredChargeInform insuredChargeInform) {
        logger.info("------------begin updateInsuredChargeInform------------");
        ResponseValue resp = new ResponseValue();
        if (null == insuredChargeInform) {
        	resp.setResultCode("40000002");
        	resp.setResultMessage("参保患者使用自费药品、医用材料和服务设施项目不存在");
            return resp.getJsonStr();
        }
        docInsuredChargeInformService.updateInsuredChargeInform(insuredChargeInform);

    	resp.setResultCode("1");
    	resp.setResultMessage("更新成功!");
        logger.info("------------end updateInsuredChargeInform-------------");
        return resp.getJsonStr();
    }
    
    /** 
     * 增加或修改参保患者使用自费药品、医用材料和服务设施告知书项目
     * <功能详细描述>
     * @param insuredChargeItem
     * @return
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping(value = "/updateInsuredChargeItem")
    @ResponseBody
	@ApiOperation(value="增加或修改参保患者使用自费药品、医用材料和服务设施告知书项目",httpMethod="POST",notes="增加或修改参保患者使用自费药品、医用材料和服务设施告知书项目")
    public String updateInsuredChargeItem(@ApiParam(name="insuredChargeItem", value ="修改参数") @RequestBody DocInsuredChargeItem insuredChargeItem) {
        logger.info("------------begin updateInsuredChargeItem------------");
        ResponseValue resp = new ResponseValue();
        if (null == insuredChargeItem) {
        	resp.setResultCode("40000002");
        	resp.setResultMessage("参保患者使用自费药品、医用材料和服务设施项目不存在");
            return resp.getJsonStr();
        }
        docInsuredChargeInformService.updateInsuredChargeItem(insuredChargeItem);

    	resp.setResultCode("1");
    	resp.setResultMessage("更新成功!");
        logger.info("------------end updateInsuredChargeItem-------------");
        return resp.getJsonStr();
    }
    
    /** 
     * 查询参保患者使用自费药品、医用材料和服务设施告知书项目
     * <功能详细描述>
     * @param insuredChargeItem
     * @return
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping(value = "/searchInsuredChargeItemById")
    @ResponseBody
	@ApiOperation(value="查询参保患者使用自费药品、医用材料和服务设施告知书项目",httpMethod="POST",notes="查询参保患者使用自费药品、医用材料和服务设施告知书项目")
    public String searchInsuredChargeItemById(@ApiParam(name="insuredChargeItem", value ="查询参数") @RequestBody DocInsuredChargeItem insuredChargeItem) {
        logger.info("------------begin searchInsuredChargeItemById--------------");
        ResponseValue resp = new ResponseValue();
        if (null == insuredChargeItem) {
        	resp.setResultCode("40000002");
        	resp.setResultMessage("参保患者使用自费药品、医用材料和服务设施项目不存在");
            return resp.getJsonStr();
        }
        
        insuredChargeItem =  docInsuredChargeInformService.selectByItemId(insuredChargeItem);
    	resp.setResultCode("1");
    	resp.setResultMessage("更新成功!");
    	resp.put("insuredChargeItem", insuredChargeItem);
        logger.info("------------end searchInsuredChargeItemById-----------");
        return resp.getJsonStr();
    }
    
    /** 
     * 删除参保患者使用自费药品、医用材料和服务设施告知书项目
     * <功能详细描述>
     * @param insuredChargeItem
     * @return
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping(value = "/deleteInsuredChargeItem")
    @ResponseBody
	@ApiOperation(value="删除参保患者使用自费药品、医用材料和服务设施告知书项目",httpMethod="POST",notes="删除参保患者使用自费药品、医用材料和服务设施告知书项目")
    public String deleteInsuredChargeItem(@ApiParam(name="insuredChargeItem", value ="查询参数") @RequestBody DocInsuredChargeItem insuredChargeItem) {
        logger.info("------------begin deleteInsuredChargeItem--------------");
        ResponseValue resp = new ResponseValue();
        if (null == insuredChargeItem) {
        	resp.setResultCode("40000002");
        	resp.setResultMessage("参保患者使用自费药品、医用材料和服务设施项目不存在");
            return resp.getJsonStr();
        }
        docInsuredChargeInformService.deleteInsuredChargeItem(insuredChargeItem);
    	resp.setResultCode("1");
    	resp.setResultMessage("删除成功!");
        logger.info("------------end deleteInsuredChargeItem-------------");
        return resp.getJsonStr();
    }
    
}
