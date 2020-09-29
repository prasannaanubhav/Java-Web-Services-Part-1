package com.asyncclient.client;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import javax.ws.rs.client.AsyncInvoker;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import com.asyncclient.model.CheckList;

public class AsynchClient {

	public static void main(String[] args) {

		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080/asynccheck/checkservice/processcheck");
		AsyncInvoker asyncInvoker = target.request().async();
		Future<Boolean> response = asyncInvoker.post(Entity.entity(new CheckList(), MediaType.APPLICATION_XML),
				Boolean.class);
		try {
			System.out.println(response.get());
		} catch (InterruptedException | ExecutionException e) {

			e.printStackTrace();
		}

	}

}
