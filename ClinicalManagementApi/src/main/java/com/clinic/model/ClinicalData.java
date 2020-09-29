package com.clinic.model;

import java.io.Serializable;


import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@DynamicInsert(true)
@DynamicUpdate(true)
@Table(name = "clinicaldata")
@JsonIgnoreProperties({"patient"})
public class ClinicalData implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cid;

	@Column(name = "component_name", length = 20)
	private String component_name;

	@Column(name = "component_value", length = 20)
	private String component_value;

	@Column(name = "measured_date_time", length = 50)
	private Timestamp measured_date_time;

	@ManyToOne
	@JoinColumn(name = "patient_id", referencedColumnName = "pid")
	private Patient patient;

	public ClinicalData() {

	}

	public ClinicalData(int cid, String component_name, String component_value, Timestamp measured_date_time,
			Patient patient) {
		this.cid = cid;
		this.component_name = component_name;
		this.component_value = component_value;
		this.measured_date_time = measured_date_time;
		this.patient = patient;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getComponent_name() {
		return component_name;
	}

	public void setComponent_name(String component_name) {
		this.component_name = component_name;
	}

	public String getComponent_value() {
		return component_value;
	}

	public void setComponent_value(String component_value) {
		this.component_value = component_value;
	}

	public Timestamp getMeasured_date_time() {
		return measured_date_time;
	}

	public void setMeasured_date_time(Timestamp measured_date_time) {
		this.measured_date_time = measured_date_time;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

}
