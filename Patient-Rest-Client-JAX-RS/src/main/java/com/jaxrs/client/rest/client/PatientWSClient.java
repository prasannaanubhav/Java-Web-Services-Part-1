package com.jaxrs.client.rest.client;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.jaxrs.client.model.Patient;

public class PatientWSClient {

	public static void main(String[] args) {

		// get List of patients

		Client client = ClientBuilder.newClient();
//		WebTarget target = client.target("http://localhost:8080/patient/patientservice/getpatients");
//		Builder request = target.request();
//		Response response = request.get();
//		List<Patient> list = response.readEntity(new GenericType<List<Patient>>() {});
//		System.out.println(response.getStatus());
//		for (Patient patient : list) {
//			System.out.println(patient.getId() + " " + patient.getName());
//		}

		// get patient by id

//		Client client = ClientBuilder.newClient();
//		WebTarget target = client.target("http://localhost:8080/patient/patientservice/getpatientbyid/1");
//		Builder request = target.request();
//		Response response = request.get();
//		Patient patient = response.readEntity(Patient.class);
//		System.out.println(patient.getId()+" "+patient.getName());

		// createPatient

		WebTarget target = client.target("http://localhost:8080/patient/patientservice/createpatient");
		Builder request = target.request();
		Patient patient = new Patient();
		patient.setName("Bharath");
//        request.header("Content-Type", MediaType.APPLICATION_JSON);
//	     request.header("Content-Type", "application/json");
		Response response = request.post(Entity.entity(patient, MediaType.APPLICATION_XML), Response.class);
		System.out.println(response.getStatus());

		// updatePatient


//		WebTarget target = client.target("http://localhost:8080/patient/patientservice/update");
//		Builder request = target.request();
//		Patient patient = new Patient();
//		patient.setId(3);
//		patient.setName("Bharath");
//		Response response = request.put(Entity.entity(patient, MediaType.APPLICATION_XML), Response.class);
//		System.out.println(response.getStatus());

		// deletePatient


//		WebTarget target = client.target("http://localhost:8080/patient/patientservice/delete/3");
//		Builder request = target.request();
//		Response response = request.delete();
//		System.out.println(response.getStatus());

		client.close();
	}

}
