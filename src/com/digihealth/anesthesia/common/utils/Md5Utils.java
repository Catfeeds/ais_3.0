package com.digihealth.anesthesia.common.utils;

import org.apache.shiro.crypto.hash.Md5Hash;

public class Md5Utils {
	public static String md5ToHex(String password,String salt,int count){
		return new Md5Hash(password, salt, count).toHex();
	}
}
