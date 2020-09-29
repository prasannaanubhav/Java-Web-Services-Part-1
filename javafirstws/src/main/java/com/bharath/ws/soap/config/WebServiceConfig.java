package com.bharath.ws.soap.config;

import java.util.HashMap;



import java.util.Map;

import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.ws.security.wss4j.WSS4JInInterceptor;
import org.apache.wss4j.dom.WSConstants;
import org.apache.wss4j.dom.handler.WSHandlerConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bharath.ws.soap.PaymentProcessorImpl;

@Configuration
public class WebServiceConfig {

	@Autowired
	private Bus bus;

	@Bean
	public Endpoint endpoint() {

		EndpointImpl endpoint = new EndpointImpl(bus, new PaymentProcessorImpl());
		endpoint.publish("/payment");

		Map<String, Object> map = new HashMap<>();
		map.put(WSHandlerConstants.ACTION, WSHandlerConstants.USERNAME_TOKEN);
		map.put(WSHandlerConstants.PASSWORD_TYPE, WSConstants.PW_DIGEST);
		map.put(WSHandlerConstants.PW_CALLBACK_CLASS, new UTPasswordCallback());

		WSS4JInInterceptor wss4jInInterceptor = new WSS4JInInterceptor(map);
		endpoint.getInFaultInterceptors().add(wss4jInInterceptor);

		return endpoint;

	}

}
