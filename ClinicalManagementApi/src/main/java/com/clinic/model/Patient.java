package com.clinic.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicInsert(true)
@DynamicUpdate(true)
@Table(name = "Patient")
public class Patient implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pid;

	@Column(name = "firstname", length = 10)
	private String firstname;

	@Column(name = "lastname", length = 10)
	private String lastname;

	@Column(name = "age", length = 10)
	private int age;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "patient")
	private List<ClinicalData> clinicalDataList;

	public Patient() {

	}

	public Patient(int pid, String firstname, String lastname, int age, List<ClinicalData> clinicalDataList) {
		this.pid = pid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.age = age;
		this.clinicalDataList = clinicalDataList;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public List<ClinicalData> getClinicalDataList() {
		return clinicalDataList;
	}

	public void setClinicalDataList(List<ClinicalData> clinicalDataList) {
		this.clinicalDataList = clinicalDataList;
	}

}
