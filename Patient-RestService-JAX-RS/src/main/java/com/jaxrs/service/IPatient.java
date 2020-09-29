package com.jaxrs.service;

import java.util.List;


import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.jaxrs.model.Patient;

@Produces("application/xml,application/json")
@Consumes("application/xml,application/json")
@Path(value = "/patientservice")
public interface IPatient {

	@Path(value = "/getpatients")
	@GET
	public List<Patient> getPatients();

	@Path(value="/getpatientbyid/{id}")
	@GET
	public Patient getPatientById(@PathParam(value = "id") long id);
	
	@Path(value = "/createpatient")
	@POST
	public Response createPatient(Patient patient);
	
	@Path(value = "/update")
	@PUT
	public Response updatePatient(Patient patient);
	
	@Path(value = "/delete/{id}")
	@DELETE
	public Response deletePatient(@PathParam(value = "id") long id);
}
