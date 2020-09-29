package com.passenger.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Passenger")
public class Passenger {

	private int id;
	private String name;

	public Passenger() {

	}

	public Passenger(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
