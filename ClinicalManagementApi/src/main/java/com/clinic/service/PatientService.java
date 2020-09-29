package com.clinic.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.apache.cxf.rs.security.cors.CrossOriginResourceSharing;

import com.clinic.model.Patient;

@Consumes("application/json")
@Produces("application/json")
@Path(value ="/patientservice")
@CrossOriginResourceSharing(allowAllOrigins = true)
public interface PatientService {
	
	@Path(value = "/getpatients")
	@GET
	public List<Patient> getListofPatients();
	
	@Path(value = "/getpatients/{id}")
	@GET
	public Patient getPatientById(@PathParam("id") int id);
	
	@Path(value="/addpatients")
	@POST
	public Patient addPatient(Patient patient);
	
	@Path(value="/updatepatient")
	@PUT
	public Patient updatePatient(Patient patient);
	
	@Path(value = "/getbmi/{id}")
	@GET
	public Patient analyzeBmi(@PathParam("id") int id);

}
