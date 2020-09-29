package com.restattachmentsclient.client;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.ws.rs.core.Response;

import org.apache.cxf.jaxrs.client.WebClient;
import org.apache.cxf.jaxrs.ext.multipart.Attachment;
import org.apache.cxf.jaxrs.ext.multipart.ContentDisposition;

public class RestAttachmentClient {
	
	public static void main(String[] args) throws FileNotFoundException {
		
		WebClient client = WebClient.create("http://localhost:8080/restattachments/services/fileservice/upload");
		client.type("multipart/form-data");
		
		ContentDisposition contentDisposition = new ContentDisposition("attachment;filename=newImage.jpg");
		Attachment attachment = new Attachment("root", new FileInputStream(new File("C:/Users/Anubhav/Desktop/newImage.jpg")), contentDisposition);
		
		Response response = client.post(attachment);
		System.out.println(response.getStatus());
	}

	

}
