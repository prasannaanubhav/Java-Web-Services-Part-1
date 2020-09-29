package com.soap.ws.config;

import java.util.ArrayList;

import javax.xml.ws.Binding;
import javax.xml.ws.Endpoint;
import javax.xml.ws.handler.Handler;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.soap.ws.handler.SiteHandler;
import com.soap.ws.implementation.CustomerOrderService;

@Configuration
public class WebServiceConfig {

	@Autowired
	private Bus bus;

	@Bean
	public Endpoint endpoint() {

		Endpoint endpoint = new EndpointImpl(bus, new CustomerOrderService());
		endpoint.publish("/customerorderservice");
		
		Binding binding = endpoint.getBinding();
		
		ArrayList<Handler> chain = new ArrayList<>();
		chain.add(new SiteHandler());
		binding.setHandlerChain(chain);
		return endpoint;

	}

}
