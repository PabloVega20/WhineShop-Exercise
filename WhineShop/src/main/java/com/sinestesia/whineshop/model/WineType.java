package com.sinestesia.whineshop.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "type")
public class WineType {

	@Id
	private Integer id;
	
	private String name;

	public WineType(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public WineType() {
		super();
	}

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
	
	
}
