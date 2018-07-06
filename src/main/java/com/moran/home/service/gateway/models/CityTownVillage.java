package com.moran.home.service.gateway.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class CityTownVillage {

	@Id
	@GeneratedValue
	private int code;
	private int name;

	@ManyToOne
	@JoinColumn(name = "district_id", nullable = false, insertable = true, updatable = true)
	private District district;

	CityTownVillage() {
	}

	public CityTownVillage(int code, int name, District district) {
		super();
		this.code = code;
		this.name = name;
		this.district = district;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public int getName() {
		return name;
	}

	public void setName(int name) {
		this.name = name;
	}

	public District getDistrict() {
		return district;
	}

	public void setDistrict(District district) {
		this.district = district;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + code;
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
		CityTownVillage other = (CityTownVillage) obj;
		if (code != other.code)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "City/Town/Village [name=" + name + "]";
	}

}
