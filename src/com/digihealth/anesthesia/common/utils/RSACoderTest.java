package com.digihealth.anesthesia.common.utils;

import static org.junit.Assert.*;  

import org.junit.Before;  
import org.junit.Test;  
  











import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Map;  
  
/** 
 *  
 * @author 梁栋 
 * @version 1.0 
 * @since 1.0 
 */  
public class RSACoderTest {  
    private String publicKey;  
    private String privateKey;  
    
    public static void main(String[] args) {
    	RSACoderTest t = new RSACoderTest();
    	
    	
    	try {
			t.setUp1();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    
    public static String byte2String(byte[] buff) {
		StringBuffer sbuf = new StringBuffer();
		for (int i = 0; i < buff.length; i++) {
			int tmp = buff[i] & 0XFF;
			String str = Integer.toHexString(tmp);
			if (str.length() == 1) {
				sbuf.append("0" + str);
			} else {
				sbuf.append(str);
			}

		}
		return sbuf.toString();
	}

	public static byte[] String2byte(String str) {
		byte[] result = new byte[str.length() / 2];
		int index = 0;
		for (int i = 0; i < str.length(); i += 2) {
			result[index++] = (byte) Integer.parseInt(str.substring(i, i + 2),
					16);
		}
		return result;
	}
    
    public void setUp1() throws Exception {  
        //Map<String, Object> keyMap = RSACoder.initKey(); 
    	publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC7PaDPTmXejOw4eZn6gZMcxbVqAozK3AoTkoxGa+ayEnNW3eA/XMPxWFuHoGhwwk2xGg/JoHVyTI7N/d2twxnsglKe0YrEVXbvnMjr1a6Z7I0m8KWersC3/HvtqSBQ5WAHZj/ZT0f99LnP0bNEexTmAbgajp+hYduW9j1nLcBiPwIDAQAB";
    	privateKey = "MIICdQIBADANBgkqhkiG9w0BAQEFAASCAl8wggJbAgEAAoGBALs9oM9OZd6M7Dh5mfqBkxzFtWoCjMrcChOSjEZr5rISc1bd4D9cw/FYW4egaHDCTbEaD8mgdXJMjs393a3DGeyCUp7RisRVdu+cyOvVrpnsjSbwpZ6uwLf8e+2pIFDlYAdmP9lPR/30uc/Rs0R7FOYBuBqOn6Fh25b2PWctwGI/AgMBAAECgYB2bS1H0VM3JrTFp4vPWKMegKIUkdZQ/ElXRcp5RAfeuzK+T4llKhw4iuUhbECCiTKwgEZaBaYjC+8KtLXAEHVU/uMlpq5KhJro1dPRDaH2rpKxClGSrEzXWOLykzMuCw4NusDjcFQ+fAD1iL2cOsjNUl7gT9jEaipc5nV2+vLM4QJBAO1IAlh+jkSv3QhNIVek+e0+6x3on8e6R5WGKKeyLIVI5BJDGpR8ZqfzZUWOZLtWteMlCrwCuLLuPglgEo+jiG8CQQDKAwetJHAzV4UA93DVQrtyNpztiDD1naQqJk9PLMFw61bhS7dHtUWwa+qbo35uja/8TxjlnBX9mRUCXfX7EYsxAkAawYnyLKMiP6pu6zOdTG8aP4QHpVmPDgRQagZfkonOpb+CB6sRn018FsgOpdXaAhcUe/LP7IajNpYsPHcbV1dlAkAxROvqXqi+3OmjgrYSTWRKRuefR0gpn3kajp1pQhEr6ToXWNAqvRtyG9/sdcOwUv5JG0GHPrpeT6fAHAqSYYUBAkA0ZjQDooO0EIZLIkQhNx7YxfRjtsiCfXyYznnaso5eygHSRdGJAls2P5dBpNZbMc0fvdd9A/5YrnSp3izpUx0p";
    	String inputStr = "his_ccszyy_chuangxin";  
        byte[] data = inputStr.getBytes();  
  
        byte[] encodedData = RSACoder.encryptByPublicKey(data, publicKey); 
        System.err.println("加密后: " + byte2String(encodedData));
        byte[] decodedData = RSACoder.decryptByPrivateKey(String2byte(byte2String(encodedData)),  
                privateKey);  
  
        String outputStr = new String(decodedData);  
        System.err.println("加密后: " + byte2String(encodedData) + "\n\r" + "解密后: " + outputStr);  
    	//System.out.println("public:"+publicKey);
        //privateKey = RSACoder.getPrivateKey(keyMap);
        //System.out.println("private:"+privateKey);
        //RSACoder.getFile(publicKey.getBytes(), "D:\\", "DIGI_AIS_publicKey");
       /* String pStr = "his_ccszyy_chuangxin";  
       
			String inputStr = pStr;
	        byte[] data = inputStr.getBytes();  
	  
	        byte[] encodedData = RSACoder.encryptByPrivateKey(data, privateKey);  
	        System.err.println(new String("加密后:"+encodedData));
	        
	        
	        
	        String sign = RSACoder.sign(encodedData, privateKey); 
	        System.out.println("sign:"+sign);
	        RSACoder.getFile(sign.getBytes(), "D:\\", "sign");*/
		
        /*byte[] decodedData = RSACoder  
                .decryptByPublicKey(encodedData, publicKey);  
        String outputStr = new String(decodedData);  
        System.err.println("加密前: " + inputStr + "\n\r" + "解密后: " + outputStr);  
        
       
        
        boolean status = RSACoder.verify(encodedData, publicKey, sign);  */
        
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
    
    
  
   /* @Before  
    public void setUp() throws Exception {  
        Map<String, Object> keyMap = RSACoder.initKey();  
  
        publicKey = RSACoder.getPublicKey(keyMap);  
        privateKey = RSACoder.getPrivateKey(keyMap);  
        System.err.println("公钥: \n\r" + publicKey);  
        System.err.println("私钥： \n\r" + privateKey);  
    }  
  
    @Test  
    public void test() throws Exception {  
        System.err.println("公钥加密——私钥解密");  
        String inputStr = "abc";  
        byte[] data = inputStr.getBytes();  
  
        byte[] encodedData = RSACoder.encryptByPublicKey(data, publicKey);  
  
        byte[] decodedData = RSACoder.decryptByPrivateKey(encodedData,  
                privateKey);  
  
        String outputStr = new String(decodedData);  
        System.err.println("加密前: " + inputStr + "\n\r" + "解密后: " + outputStr);  
        assertEquals(inputStr, outputStr);  
  
    }  
  
    @Test  
    public void testSign() throws Exception {  
        System.err.println("私钥加密——公钥解密");  
        String inputStr = "sign";  
        byte[] data = inputStr.getBytes();  
  
        byte[] encodedData = RSACoder.encryptByPrivateKey(data, privateKey);  
  
        byte[] decodedData = RSACoder  
                .decryptByPublicKey(encodedData, publicKey);  
  
        String outputStr = new String(decodedData);  
        System.err.println("加密前: " + inputStr + "\n\r" + "解密后: " + outputStr);  
        assertEquals(inputStr, outputStr);  
  
        System.err.println("私钥签名——公钥验证签名");  
        // 产生签名  
        String sign = RSACoder.sign(encodedData, privateKey);  
        System.err.println("签名:\r" + sign);  
  
        // 验证签名  
        boolean status = RSACoder.verify(encodedData, publicKey, sign);  
        System.err.println("状态:\r" + status);  
        assertTrue(status);  
  
    }  */
  
}  