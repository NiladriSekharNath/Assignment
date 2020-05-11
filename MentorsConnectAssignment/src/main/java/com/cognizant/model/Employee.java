package com.cognizant.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class Employee implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="em_id")
	private int id;
	
	@Column(name="em_name")
	private String name;
	
	@Column(name="em_comp_name")
	private String companyName;
	
	@Column(name="em_contactNo")
	private long contactNo;
	
	@Column(name="em_sex")
	private String gender;
	
	
	@ManyToOne
	@JoinColumn(name="id",nullable=false)
	private Address address;

	public Employee() {
		super();
	}

	public Employee(String name, String companyName, long contactNo, String gender, Address address) {
		super();
		this.name = name;
		this.companyName = companyName;
		this.contactNo = contactNo;
		this.gender = gender;
		//this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public long getContactNo() {
		return contactNo;
	}

	public void setContactNo(long contactNo) {
		this.contactNo = contactNo;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", companyName=" + companyName + ", contactNo=" + contactNo + ", gender="
				+ gender + ", address= ]";
	}
	
	
	

}
