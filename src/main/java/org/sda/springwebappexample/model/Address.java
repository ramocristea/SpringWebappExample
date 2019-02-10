package org.sda.springwebappexample.model;

public class Address {
	private int id;
	private String city;
	private String country;
	private String street;

	public Address(int id, String city, String country, String street) {
		super();
		this.city = city;
		this.country = country;
		this.street = street;
		this.setId(id);
	}

	public Address() {

	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
