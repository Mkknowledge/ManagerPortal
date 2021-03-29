package com.mkknowledge.managerportal.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.persistence.JoinColumn;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table( name = "employee",
uniqueConstraints = {@UniqueConstraint(columnNames = "email")})
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String empId;
	
	@NotBlank
	@Size(max = 20)
	private String firstname;
	
	@NotBlank
	@Size(max = 20)
	private String lastname;
	
	@NotBlank
	@Size(max = 50)
	@Email
	private String email;
	
	@NotBlank
	@Size(max = 120)
	private String address;
	
	@JsonFormat(pattern="yyy-mm-dd")
	private Date dob;
	 
	@NotBlank
	@Size(max = 10)
	private String mobile;
	
	@NotBlank
	@Size(max = 20)
	private String city;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(	name = "user_roles", 
		joinColumns = @JoinColumn(name = "user_id"), 
		inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();
	
	public Employee() {
		
	}
	
	public String getEmpId() {
		return empId;
	}



	public void setEmpId(String empId) {
		this.empId = empId;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public Set<Role> getRoles() {
		return roles;
	}



	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	
	
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((dob == null) ? 0 : dob.hashCode());
		result = prime * result + ((empId == null) ? 0 : empId.hashCode());
		result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
		result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
		result = prime * result + ((mobile == null) ? 0 : mobile.hashCode());
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
		Employee other = (Employee) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (dob == null) {
			if (other.dob != null)
				return false;
		} else if (!dob.equals(other.dob))
			return false;
		if (empId == null) {
			if (other.empId != null)
				return false;
		} else if (!empId.equals(other.empId))
			return false;
		if (firstname == null) {
			if (other.firstname != null)
				return false;
		} else if (!firstname.equals(other.firstname))
			return false;
		if (lastname == null) {
			if (other.lastname != null)
				return false;
		} else if (!lastname.equals(other.lastname))
			return false;
		if (mobile == null) {
			if (other.mobile != null)
				return false;
		} else if (!mobile.equals(other.mobile))
			return false;
		return true;
	}
	
	
}
