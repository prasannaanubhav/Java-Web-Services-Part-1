package com.soap.ws.endpoint;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class SoapControllerEndPoint {

	@WebMethod
	public String HelloSoap() {
		
		return "Hello Soap";
	}
	
}
