package com.cg.hms.model;

import java.util.Date;

public class Patient {
	private Integer id;
	private String name;
	private String gender;
	private Long phoneNumber;
	private String disease;
	private Date appointmentDate;
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getDisease() {
		return disease;
	}
	public void setDisease(String disease) {
		this.disease = disease;
	}
	public Date getAppointmentDate() {
		return appointmentDate;
	}
	public void setAppointmentDate(Date appointmentDate) {
		this.appointmentDate = appointmentDate;
	}
	public Patient(Integer id, String name, String gender, Long phoneNumber,
			String disease, Date appointmentDate) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.phoneNumber = phoneNumber;
		this.disease = disease;
		this.appointmentDate = appointmentDate;
	}
	public Patient() {
		// TODO Auto-generated constructor stub
	}
	
}
