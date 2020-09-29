package com.clinic.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.apache.cxf.rs.security.cors.CrossOriginResourceSharing;
import org.springframework.beans.factory.annotation.Autowired;

import com.clinic.model.ClinicalData;
import com.clinic.model.ClinicalDataRequest;
import com.clinic.model.Patient;
import com.clinic.repository.ClinicalDataRepository;
import com.clinic.repository.PatientRepository;

@Consumes("application/json")
@Produces("application/json")
@Path("/clinicalservice")
@CrossOriginResourceSharing(allowAllOrigins = true)
public class ClinicalDataService {

	@Autowired
	private PatientRepository patientRepository;

	@Autowired
	private ClinicalDataRepository clinicalDataRepository;

	@Path("/saveclinicaldata")
	@POST
	public ClinicalData saveClinicalDetails(ClinicalDataRequest request) {

		Patient patient = patientRepository.findById(request.getPatient_Id()).get();
		if(patient!=null) {
			
			ClinicalData clinicalData = request.getClinicalData();
			clinicalData.setPatient(patient);
			ClinicalData savedClinicalData = clinicalDataRepository.save(clinicalData);
			return savedClinicalData;
		}
		return null;
	}

}
