package com.soap.ws.implementation;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.cxf.feature.Features;

import com.bharath.ws.trainings.CreateOrderRequest;
import com.bharath.ws.trainings.CreateOrderResponse;
import com.bharath.ws.trainings.CustomerOrdersPortType;
import com.bharath.ws.trainings.DeleteOrderRequest;
import com.bharath.ws.trainings.DeleteOrderResponse;
import com.bharath.ws.trainings.GetOrderInformation;
import com.bharath.ws.trainings.GetOrderRequest;
import com.bharath.ws.trainings.Order;
import com.bharath.ws.trainings.Product;

//@Features(features = "org.apache.cxf.feature.LoggingFeature")
public class CustomerOrderService implements CustomerOrdersPortType {

	Map<BigInteger, List<Order>> customerMap = new HashMap<>();
	long primaryKey = 0;

	public CustomerOrderService() {
		init();
	}

	private void init() {

		List<Order> orders = new ArrayList<>();
		Order order = new Order();
		order.setId(BigInteger.valueOf(1));

		Product product = new Product();
		product.setId("1");
		product.setDescription("Nokia");
		product.setQuantity(BigInteger.valueOf(4));

		order.getProduct().add(product);
		orders.add(order);
		customerMap.put(BigInteger.valueOf(++primaryKey), orders);
	}

	@Override
	public GetOrderInformation getOrders(GetOrderRequest request) {
		GetOrderInformation response = new GetOrderInformation();
		List<Order> orders = customerMap.get(request.getCustomerId());
		if (orders != null) {

			response.getOrder().addAll(orders);
			return response;
		}
		response.getOrder().set(0, new Order());
		return response;
	}

	@Override
	public CreateOrderResponse createOrders(CreateOrderRequest request) {

		CreateOrderResponse response = new CreateOrderResponse();
		Order order = request.getOrder();
		List<Order> listOrders = customerMap.get(request.getCustomerId());
		if (listOrders == null) {
			List<Order> orderList = new ArrayList<>();
			orderList.add(order);
			customerMap.put(request.getCustomerId(), orderList);
			for (Map.Entry<BigInteger, List<Order>> entry : customerMap.entrySet()) {
				int i = 0;
				System.out.println(entry.getKey() + " " + entry.getValue().get(i).getProduct().get(i).getDescription());
				i++;
			}
			response.setResult(true);
			return response;
		}
		listOrders.add(order);
		customerMap.put(request.getCustomerId(), listOrders);
		response.setResult(true);
		return response;

	}

	@Override
	public DeleteOrderResponse deleteOrders(DeleteOrderRequest request) {
		DeleteOrderResponse deleteOrderResponse = new DeleteOrderResponse();
		if (customerMap.get(request.getCustomerId()) != null) {
			customerMap.remove(request.getCustomerId());
			deleteOrderResponse.setResult("Successfully deleted");
			return deleteOrderResponse;
		}
		deleteOrderResponse.setResult("No Orders Found with respective given customer ID");
		return deleteOrderResponse;
	}

}
