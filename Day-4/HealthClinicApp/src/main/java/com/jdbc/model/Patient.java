package com.jdbc.model;

public class Patient {

    private int patientId;
    private String name;
    private String gender;
    private int age;
    private String phone;
    private String city;

    public Patient() {}

    public Patient(String name,String gender,int age,String phone,String city) {
        this.name=name;
        this.gender = gender;
        this.age = age;
        this.phone = phone;
        this.city = city;
    }

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}    
	
    @Override
    public String toString() {
        return "Patient [patientId=" + patientId + ", name=" + name + ", age=" + age
                + ", gender=" + gender + ", phone=" + phone + ", city=" + city + "]";
    }
}