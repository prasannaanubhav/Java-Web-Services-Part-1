package com.soap.client;

import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import com.bharath.ws.trainings.CustomerOrdersPortType;
import com.bharath.ws.trainings.GetOrderInformation;
import com.bharath.ws.trainings.GetOrderRequest;
import com.bharath.ws.trainings.Order;
import com.soap.ws.implementation.CustomerOrderServiceService;

public class SoapClient {

	public static void main(String[] args) throws MalformedURLException {

		CustomerOrderServiceService service = new CustomerOrderServiceService(
				new URL("http://localhost:8080/wsdl/customerorderservice?wsdl"));
		CustomerOrdersPortType customerOrderServicePort = service.getCustomerOrderServicePort();
		GetOrderRequest request = new GetOrderRequest();
		request.setCustomerId(BigInteger.valueOf(1));
		GetOrderInformation response = customerOrderServicePort.getOrders(request);
		List<Order> orders = response.getOrder();
		for (Order order : orders) {
			System.out.println(order.getProduct().get(0).getDescription());
			System.out.println(order.getProduct().get(0).getId());
			System.out.println(order.getProduct().get(0).getQuantity());
		}
	}

}
