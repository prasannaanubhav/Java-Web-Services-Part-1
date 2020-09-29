package com.springsecurity.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Product")
public class Product {

	private long id;
	private String description;

	public Product() {

	}

	public Product(long id, String description) {
		this.id = id;
		this.description = description;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
