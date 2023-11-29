package com.cfg.demoRest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="address")
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long add_id;
	
	@Column(name="city")
	private String city;
	
	@Column(name="street_no")
	private String street_no;
	
	@Column(name="country")
	private String country;

	public Long getAdd_id() {
		return add_id;
	}

	public Address(Long add_id, String city, String street_no, String country) {
		super();
		this.add_id = add_id;
		this.city = city;
		this.street_no = street_no;
		this.country = country;
	}

	

	public Address() {
		// TODO Auto-generated constructor stub
	}

	public void setAdd_id(Long add_id) {
		this.add_id = add_id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet_no() {
		return street_no;
	}

	public void setStreet_no(String street_no) {
		this.street_no = street_no;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}
