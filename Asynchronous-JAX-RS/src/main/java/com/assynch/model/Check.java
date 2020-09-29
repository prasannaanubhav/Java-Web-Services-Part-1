package com.assynch.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Check {

	private String checkNumber;
	private String accountNumber;
	private String name;

	public String getCheckNumber() {
		return checkNumber;
	}

	public void setCheckNumber(String checkNumber) {
		this.checkNumber = checkNumber;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
