/**
 * 
 */
package com.moran.home.service.gateway.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 * @author rahmohan
 *
 */

@Entity
public class ServiceProvider {

	@Id
	private String email;
	private int mobile;
	private int countryCode; // Mobile number country code
	private int landLinePhone;
	private int landLineAreaCode;
	private String firstName;
	private String middleName;
	private String lastName;

	@OneToOne
	@JoinColumn(name = "address_id", nullable = false, insertable = true, updatable = true)
	private Address address;

	ServiceProvider() {
	}

	public ServiceProvider(String email, int mobile, int countryCode, int landLinePhone, int landLineAreaCode,
			String firstName, String middleName, String lastName, Address address) {
		super();
		this.email = email;
		this.mobile = mobile;
		this.countryCode = countryCode;
		this.landLinePhone = landLinePhone;
		this.landLineAreaCode = landLineAreaCode;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getMobile() {
		return mobile;
	}

	public void setMobile(int mobile) {
		this.mobile = mobile;
	}

	public int getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(int countryCode) {
		this.countryCode = countryCode;
	}

	public int getLandLinePhone() {
		return landLinePhone;
	}

	public void setLandLinePhone(int landLinePhone) {
		this.landLinePhone = landLinePhone;
	}

	public int getLandLineAreaCode() {
		return landLineAreaCode;
	}

	public void setLandLineAreaCode(int landLineAreaCode) {
		this.landLineAreaCode = landLineAreaCode;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + mobile;
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
		ServiceProvider other = (ServiceProvider) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (mobile != other.mobile)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ServiceProvider [email=" + email + ", mobile=" + mobile + ", firstName=" + firstName + ", middleName="
				+ middleName + ", lastName=" + lastName + ", address=" + address + "]";
	}

}
