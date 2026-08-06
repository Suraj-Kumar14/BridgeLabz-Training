package com.jdbc.model;

public class Doctor {

	private int doctorId;
	private String name;
	private String specialty;
	private int departmentId;
	
	public Doctor() {
	}
		
	public Doctor(String name, String specialty, int departmentId) {
		this.name = name;
		this.specialty = specialty;
		this.departmentId = departmentId;
	}


	public int getDoctorId() {
		return doctorId;
	}


	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getSpecialty() {
		return specialty;
	}


	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}


	public int getDepartmentId() {
		return departmentId;
	}


	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	
    @Override
    public String toString() {
        return "Doctor [doctorId=" + doctorId + ", name=" + name
                + ", specialty=" + specialty
                + ", departmentId=" + departmentId + "]";
    }
	
}
