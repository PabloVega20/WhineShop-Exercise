package com.sinestesia.whineshop.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Region {
	
	@Id
	private Integer id;

	private String name;
	private String country;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Region(Integer id, String name, String country) {
		super();
		this.id = id;
		this.name = name;
		this.country = country;
	}
	public Region() {
		super();
	}
	
	
}
