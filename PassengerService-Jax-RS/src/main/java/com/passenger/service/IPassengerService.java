package com.passenger.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;

import com.passenger.model.Passenger;

@Produces("application/json,application/xml")
@Consumes("application/json,application/xml,application/x-www-form-urlencoded")
@Path(value = "/passengerservice")
public interface IPassengerService {

	@Path(value = "/getpassengers")
	@GET
	public List<Passenger> getPassengers(@QueryParam("start") int start, @QueryParam("size") int size);

	@Path(value = "/addpassengers")
	@POST
	public Passenger addPassenger(Passenger passenger);

	@Path(value = "/formparam")
	@POST
	public void formParam(@FormParam("firstname") String firstname, @FormParam("lastname") String lastname,
			@HeaderParam("agent") String agent, @Context HttpHeaders httpHeaders);


}
