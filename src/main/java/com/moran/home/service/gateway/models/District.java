package com.moran.home.service.gateway.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class District {

	@Id
	private int code;
	private int name;

	@ManyToOne
	@JoinColumn(name = "state_id", nullable = false, insertable = true, updatable = true)
	private StateProvince stateProvince;

	District() {
	}

	public District(int code, int name, StateProvince stateProvince) {
		super();
		this.code = code;
		this.name = name;
		this.stateProvince = stateProvince;
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

	public StateProvince getStateProvince() {
		return stateProvince;
	}

	public void setStateProvince(StateProvince stateProvince) {
		this.stateProvince = stateProvince;
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
		District other = (District) obj;
		if (code != other.code)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "District [name=" + name + "]";
	}

}
