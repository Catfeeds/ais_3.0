package com.digihealth.anesthesia.interfacedata.server;

import javax.jws.WebParam;
import javax.jws.WebService;

import com.digihealth.anesthesia.sysMng.po.BasUser;

@WebService
public interface HelloService {
	public String hello(@WebParam(name = "name")String name);
	
	public String sayHi(@WebParam(name="name") String name);
	
	public String hisToDigi(BasUser user);
}
