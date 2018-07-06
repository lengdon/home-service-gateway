package com.moran.home.service.gateway.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Address {

	@Id
	@GeneratedValue
	private int id;
	private String addressLine1;
	private String addressLine2;
	private String addressLine3;
	
	@ManyToOne
    @JoinColumn(name="city_id", nullable=false, insertable=true, updatable=true)
	private CityTownVillage cityTownVillage;
	
	private int zipCode;

	Address() {
	}

	public Address(int id, String addressLine1, String addressLine2, String addressLine3,
			CityTownVillage cityTownVillage, int zipCode) {
		super();
		this.id = id;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.addressLine3 = addressLine3;
		this.cityTownVillage = cityTownVillage;
		this.zipCode = zipCode;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getAddressLine3() {
		return addressLine3;
	}

	public void setAddressLine3(String addressLine3) {
		this.addressLine3 = addressLine3;
	}

	public CityTownVillage getCityTownVillage() {
		return cityTownVillage;
	}

	public void setCityTownVillage(CityTownVillage cityTownVillage) {
		this.cityTownVillage = cityTownVillage;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Address [addressLine1=" + addressLine1 + ", addressLine2=" + addressLine2 + ", addressLine3="
				+ addressLine3 + ", cityTownVillage=" + cityTownVillage + ", zipCode=" + zipCode + "]";
	}

}
