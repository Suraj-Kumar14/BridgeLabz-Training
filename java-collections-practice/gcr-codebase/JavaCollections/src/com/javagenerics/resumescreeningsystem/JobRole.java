package com.javagenerics.resumescreeningsystem;

public abstract class JobRole {
	private String candidateName;
	private String role;
	
	public JobRole(String candidateName) {
		this.candidateName = candidateName;
	}
	
	public String getCandidateName() {
		return candidateName;
	}
	
	public abstract String getRole() ;
	abstract boolean screenResume();
	
	@Override
	public String toString() {
		return "JobRole [name=" + candidateName + ", role=" + role + "]";
	}
	
	
}
