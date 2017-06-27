package com.digihealth.anesthesia.common.utils;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
/**
 * 
     * Title: EncryptUtil.java    
     * Description: spring security加密机制
     * @author chengwang       
     * @created 2015-10-7 上午10:28:36
 */
public class EncryptUtil {
	//从配置文件中获得  
    private static final String SITE_WIDE_SECRET = "DIGIHEALTH-AIS";  
    private static final PasswordEncoder encoder = new StandardPasswordEncoder(  
       SITE_WIDE_SECRET);  
   
    /**
     * 
         * @discription 需要加密的数据
         * @author chengwang       
         * @created 2015-10-7 上午10:29:01     
         * @param rawPassword
         * @return
     */
    public static String encrypt(String rawPassword) {  
         return encoder.encode(rawPassword);  
    }  
   
    /**
     * 
         * @discription 密码匹配
         * @author chengwang       
         * @created 2015-10-7 上午10:29:16     
         * @param rawPassword
         * @param password
         * @return
     */
    public static boolean match(String rawPassword, String password) {  
         return encoder.matches(rawPassword, password);  
    }
    
    public static void main(String[] args) {
    	System.out.println(EncryptUtil.encrypt("1234"));
		System.out.println(EncryptUtil.match("1234", "ef050e6c6e7e02d1f88b4badb3b075812f5ccca68800cecb9d3cd2cb4b01c30e7125f027dca780e7"));
	}
    
       
}
