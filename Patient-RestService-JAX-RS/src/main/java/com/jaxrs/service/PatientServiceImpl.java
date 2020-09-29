package com.jaxrs.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.Response;

import org.springframework.stereotype.Service;

import com.jaxrs.exception.PatientBusinessException;
import com.jaxrs.model.Patient;

@Service
public class PatientServiceImpl implements IPatient {

	Map<Long, Patient> patientMap = new HashMap<>();
	long currentId = 1;

	public PatientServiceImpl() {
		init();
	}

	public void init() {

		Patient patient = new Patient(currentId, "Anubhav");
		patientMap.put(patient.getId(), patient);
	}

	@Override
	public List<Patient> getPatients() {
		Collection<Patient> values = patientMap.values();
		List<Patient> list = new ArrayList<>(values);
		return list;
	}

	@Override
	public Patient getPatientById(long id) {
		Patient patient = patientMap.get(id);
		return patient;
	}

	@Override
	public Response createPatient(Patient patient) {
		patient.setId(++currentId);
		patientMap.put(patient.getId(), patient);
		return Response.ok(patient).build();
	}

	@Override
	public Response updatePatient(Patient patient) {

		Patient currentPatient = patientMap.get(patient.getId());
		if (currentPatient != null) {
			patientMap.put(patient.getId(), patient);
			return Response.ok(patient).build();
		} else {
			throw new PatientBusinessException();
		}
	}

	@Override
	public Response deletePatient(long id) {

		Patient patient = patientMap.get(id);
		if (patient != null) {
			patientMap.remove(id);
			return Response.ok().build();
		}
		return Response.notModified().build();
	}

}
