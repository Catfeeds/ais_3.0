package com.digihealth.anesthesia.interfacedata.server;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;

import com.digihealth.anesthesia.sysMng.dao.BasUserDao;
import com.digihealth.anesthesia.sysMng.po.BasUser;

@WebService(endpointInterface = "com.digihealth.anesthesia.interfacedata.server.HelloService")
public class HelloServiceImpl implements HelloService {

	@Autowired
	private BasUserDao basUserDao;

	public String hello(String name) {
		BasUser user = basUserDao.get("11");
		return "hello," + user.getName();
	}
	
	public String sayHi(String name){
		return "hi,hi";
	}
	
	public String hisToDigi(BasUser user){
		return "hisToDigi,"+user.getName();
	}

}
