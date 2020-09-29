package com.passenger.service;

import java.util.ArrayList;

import java.util.List;
import java.util.Set;

import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MultivaluedMap;

import org.springframework.stereotype.Service;

import com.passenger.model.Passenger;

@Service
public class PassengerServiceImpl implements IPassengerService {

	List<Passenger> passengerList = new ArrayList<>();
	int currentId = 0;

	@Override
	public List<Passenger> getPassengers(int start, int size) {
	System.out.println(start);
		System.out.println(size);
		return null;
	}

	@Override
	public Passenger addPassenger(Passenger passenger) {
		passenger.setId(++currentId);
		passengerList.add(passenger);
		return passenger;
	}

	@Override
	public void formParam(String firstname, String lastname, String agent, HttpHeaders httpHeaders) {
		System.out.println(firstname);
		System.out.println(lastname);
		System.out.println(agent);

		MultivaluedMap<String, String> requestHeaders = httpHeaders.getRequestHeaders();
		Set<String> keySet = requestHeaders.keySet();
		for (String key : keySet) {
			System.out.println(key);
			System.out.println(httpHeaders.getHeaderString(key));
		}

	}

}
