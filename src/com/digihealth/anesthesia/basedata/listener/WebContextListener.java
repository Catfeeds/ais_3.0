package com.digihealth.anesthesia.basedata.listener;

import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Scanner;

import javax.servlet.ServletContext;

import org.springframework.web.context.WebApplicationContext;

import com.digihealth.anesthesia.sysMng.service.BasUserService;

public class WebContextListener extends org.springframework.web.context.ContextLoaderListener {
	@Override
	public WebApplicationContext initWebApplicationContext(ServletContext servletContext) {
		if (!BasUserService.printKeyLoadMessage()){
			return null;
		}

		return super.initWebApplicationContext(servletContext);
		/*InetAddress ia;

		try {
			URL urlLicense = this.getClass().getClassLoader().getResource("license");
			URL urlPublicKey = this.getClass().getClassLoader().getResource("publickey");
			String publicKey = new String(RSACoder.getBytes(urlPublicKey));
			URL urlSign = this.getClass().getClassLoader().getResource("sign");
			String sign = new String(RSACoder.getBytes(urlSign));
			ia = InetAddress.getLocalHost();
			boolean status = RSACoder.verify(RSACoder.getBytes(urlLicense),publicKey,sign);
			if(status){
				byte[] decodedData = RSACoder  
		                .decryptByPublicKey(RSACoder.getBytes(urlLicense), publicKey);  
		        String outputStr = new String(decodedData);
		        String[] outs = outputStr.split(",");
		        if(outs[2].equals(getLocalMac(ia))&&outs[3].equals(getCPU())&&outs[4].equals(ia.getHostAddress())){
		        	return super.initWebApplicationContext(servletContext);
		        }
			}else{
				return null;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;*/
	}
	
	public static String getCPU() throws IOException{
    	Process process = Runtime.getRuntime().exec(new String[] {"wmic","cpu","get","ProcessorId"});
		process.getOutputStream().close();
		Scanner sc = new Scanner(process.getInputStream());
		String property = sc.next();
		String serial = sc.next();
		return serial;
    }
	
	public static String getLocalMac(InetAddress ia) throws SocketException{
    	byte[] mac = NetworkInterface.getByInetAddress(ia).getHardwareAddress();
    	StringBuffer sb = new StringBuffer("");
    	for(int i = 0;i<mac.length;i++){
    		if(i!=0){
    			sb.append("-");
    		}
    		int temp = mac[i]&0xff;
			String str = Integer.toHexString(temp);
			if(str.length() == 1){
				sb.append("0"+str);
			}else{
				sb.append(str);
			}
    	}
    	return sb.toString().toUpperCase();
    }
}
