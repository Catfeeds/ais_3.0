/**     
 * @discription 在此输入一句话描述此文件的作用
 * @author chengwang       
 * @created 2015-10-10 下午5:34:19    
 * tags     
 * see_to_target     
 */

package com.digihealth.anesthesia.interfacedata.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.digihealth.anesthesia.common.entity.ResponseValue;
import com.digihealth.anesthesia.common.web.BaseController;

/**
 * Title: OperListController.java Description: 描述
 * 
 * @author chengwang
 * @created 2015-10-10 下午5:34:19
 */
@Controller
@RequestMapping(value = "/interfacedata")
public class OperListController extends BaseController {

	@Autowired  
	private  HttpServletRequest request;  
	
	/*@RequestMapping(value = "/hisToRegOpt")
	@ResponseBody
	public String hisToRegOpt(@RequestBody HisToRegOptFormBean bean){
		ResponseValue req = new ResponseValue();
		ValidatorBean validatorBean = beanValidator(bean);
		if(!(validatorBean.isValidator())){
			req.setResultCode("10000001");
			req.setResultMessage(validatorBean.getMessage());
		}
		ValidatorBean validatorBeanOperList = beanValidator(bean.getOperList());
		if(!(validatorBeanOperList.isValidator())){
			req.setResultCode("10000001");
			req.setResultMessage(validatorBeanOperList.getMessage());
		}
		InterfaceOauth iOauth = interfaceOauthService.findByKey(bean.getAppkey());
		if(iOauth==null){
			req.setResultCode("90000001");
		}else {
			try {
				String appkey = new String(RSACoder.decryptByPrivateKey(RSACoder.String2byte(bean.getToken()),iOauth.getPrivateKey()));
				if(bean.getAppkey().equals(appkey)){
					String requestUrl = request.getRequestURI();
					if(requestUrl.indexOf("ais")!=-1) {
						int index = requestUrl.indexOf("ais");
						requestUrl = requestUrl.substring(index+3, requestUrl.length()).trim();
					}
					if(iOauth.getMethod().indexOf(requestUrl)==-1){
						req.setResultCode("90000003");
					}else{
						int result = operListService.hisToRegOpt(bean.getOperList());
						if(result == 0){
							req.setResultCode("90000004");
						}else if(result == 1){
							req.setResultCode("90000000");
						}
					}
				}else{
					req.setResultCode("90000002");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				if(logger.isErrorEnabled()){
					logger.error(Exceptions.getStackTraceAsString(e));
				}
				req.setResultCode("10000000");
			}
		}
		
		
		return req.getJsonStr();
	}*/
	
	/**
	 * 深圳市龙岗区第二人民医院
	 * @return
	 */
	@RequestMapping(value = "/hisToRegOpt")
	@ResponseBody
	public String hisToRegOpt(){
		logger.info("begin hisToRegOpt");
		ResponseValue req = new ResponseValue();
		
		operListService.synHisOperList();
		
		logger.info("end hisToRegOpt");
		return req.getJsonStr();
	}
}
