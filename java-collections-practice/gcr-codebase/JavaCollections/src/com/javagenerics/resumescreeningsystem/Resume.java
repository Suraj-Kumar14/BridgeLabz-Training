package com.javagenerics.resumescreeningsystem;

public class Resume <T extends JobRole> {
	private T candidate;
	
	public Resume(T candidate) {
		this.candidate=candidate;
	}

	//screening
	public void processScreening() {
		System.out.println("Processing resume for -> "+candidate.getRole());
		System.out.println("Candidate Name: "+candidate.getCandidateName());
		
		if(candidate.screenResume()) {
			System.out.println("Resume Shortlisted.");
		}else {
			System.out.println("Resume Not Shortlisted!");
		}
	}
	
	//public void get candidate
	public T getCandiate() {
		return candidate;
	}

}
