package com.soap.mtom;

import javax.activation.DataHandler;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService(name="FileWs")
public interface FileWs {

	@WebMethod
	public @WebResult(name="upload") void upload(@WebParam(name="file") DataHandler attachments);
	
	@WebMethod
	public @WebResult(name="download") DataHandler download();
}
