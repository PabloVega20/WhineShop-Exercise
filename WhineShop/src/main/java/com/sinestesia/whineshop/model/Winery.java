package com.sinestesia.whineshop.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Winery {

	@Id
	private Integer id;
	
	private String name;

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

	public Winery(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Winery() {
		super();
	}
	
}
