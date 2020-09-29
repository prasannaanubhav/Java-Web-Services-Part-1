package com.clinic.model;

public class ClinicalDataRequest {

	private int patient_Id;
	private ClinicalData clinicalData;

	public ClinicalDataRequest() {

	}

	public ClinicalDataRequest(int patient_Id, ClinicalData clinicalData) {
		this.patient_Id = patient_Id;
		this.clinicalData = clinicalData;
	}

	public int getPatient_Id() {
		return patient_Id;
	}

	public void setPatient_Id(int patient_Id) {
		this.patient_Id = patient_Id;
	}

	public ClinicalData getClinicalData() {
		return clinicalData;
	}

	public void setClinicalData(ClinicalData clinicalData) {
		this.clinicalData = clinicalData;
	}

}
