package com.clinic.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinic.model.ClinicalData;
import com.clinic.model.Patient;
import com.clinic.repository.PatientRepository;

@Service
public class PatientServiceImpl implements PatientService {

	@Autowired
	private PatientRepository patientRepository;

	@Override
	public List<Patient> getListofPatients() {

		return patientRepository.findAll();
	}

	@Override
	public Patient getPatientById(int id) {
		Patient patient = patientRepository.findById(id).get();
		if (patient != null) {
			return patient;
		}
		return null;
	}

	@Override
	public Patient addPatient(Patient patient) {

		Patient resultpatient = patientRepository.findByFirstname(patient.getFirstname());
		if (resultpatient != null) {
			return resultpatient;
		}
		for (int i = 0; i < patient.getClinicalDataList().size(); i++) {

			ClinicalData clinicalData = patient.getClinicalDataList().get(i);
			clinicalData.setPatient(patient);
			patient.getClinicalDataList().set(i, clinicalData);
		}

		Patient savedPatient = patientRepository.save(patient);
		return savedPatient;
	}

	@Override
	public Patient updatePatient(Patient patient) {
		Patient result = patientRepository.findById(patient.getPid()).get();
		if (result != null) {
			for (int i = 0; i < patient.getClinicalDataList().size(); i++) {
				ClinicalData clinicalData = result.getClinicalDataList().get(i);
				clinicalData.setComponent_name(patient.getClinicalDataList().get(i).getComponent_name());
				clinicalData.setComponent_value(patient.getClinicalDataList().get(i).getComponent_value());
				clinicalData.setMeasured_date_time(patient.getClinicalDataList().get(i).getMeasured_date_time());
				clinicalData.setPatient(patient);
				result.setAge(patient.getAge());
				result.setFirstname(patient.getFirstname());
				result.setLastname(patient.getLastname());
				result.getClinicalDataList().set(i, clinicalData);
			}
			Patient updatedPatient = patientRepository.save(result);
			return updatedPatient;
		}
		return null;
	}

	@Override
	public Patient analyzeBmi(int id) {
		Patient patient = patientRepository.findById(id).get();
		List<ClinicalData> clinicalDataList = new ArrayList<>(patient.getClinicalDataList());
		for (ClinicalData clinicalData : clinicalDataList) {
			if (clinicalData.getComponent_name().equals("hw")) {
				String[] split = clinicalData.getComponent_value().split("/");
				String height = split[0];
				String weight = split[1];
				float bmi = Float.parseFloat(weight) / (Float.parseFloat(height) * Float.parseFloat(height));
				ClinicalData clinData = new ClinicalData();
				clinData.setComponent_name("bmi");
				clinData.setComponent_value(String.valueOf(bmi));
				clinData.setPatient(patient);
				patient.getClinicalDataList().add(clinData);
			}
		}
		return patient;
	}

}
