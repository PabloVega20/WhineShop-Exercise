package com.sinestesia.whineshop.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Wine {

	@Id
	private Integer id;

	private String name;
	private Integer year;
	private float rating;
	private Integer numReviews;
	private float price;
	private Integer body;
	private Integer acidity;
	private Integer wineryId;
	private Integer typeId;
	private Integer regionId;

	public Wine() {
		super();
	}

	public Wine(Integer id, String name, Integer year, float rating, Integer numReviews, float price, Integer body,
			Integer acidity, Integer wineryId, Integer typeId, Integer regionId) {
		super();
		this.id = id;
		this.name = name;
		this.year = year;
		this.rating = rating;
		this.numReviews = numReviews;
		this.price = price;
		this.body = body;
		this.acidity = acidity;
		this.wineryId = wineryId;
		this.typeId = typeId;
		this.regionId = regionId;
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

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public Integer getNumReviews() {
		return numReviews;
	}

	public void setNumReviews(Integer numReviews) {
		this.numReviews = numReviews;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Integer getBody() {
		return body;
	}

	public void setBody(Integer body) {
		this.body = body;
	}

	public Integer getAcidity() {
		return acidity;
	}

	public void setAcidity(Integer acidity) {
		this.acidity = acidity;
	}

	public Integer getWineryId() {
		return wineryId;
	}

	public void setWineryId(Integer wineryId) {
		this.wineryId = wineryId;
	}

	public Integer getTypeId() {
		return typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	public Integer getRegionId() {
		return regionId;
	}

	public void setRegionId(Integer regionId) {
		this.regionId = regionId;
	}

}
