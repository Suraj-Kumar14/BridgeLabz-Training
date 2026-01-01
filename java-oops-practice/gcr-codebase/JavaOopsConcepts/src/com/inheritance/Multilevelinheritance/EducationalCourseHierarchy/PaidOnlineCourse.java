package com.inheritance.Multilevelinheritance.EducationalCourseHierarchy;

public class PaidOnlineCourse extends OnlineCourse {
	private double fee;
	private double discount;
	
	//constructor
	public PaidOnlineCourse(String courseName,int duration,String platform,boolean isRecorded,double fee,double discount) {
		super(courseName,duration,platform,isRecorded);
		this.fee=fee;
		this.discount=discount;
	}
	
	double calculateFinalFee(double fee,double discount) {
		return fee-(fee*discount/100);
	}
	
	@Override
	public void getCourseInfo() {
		super.getCourseInfo();
		System.out.println("Total fee: "+fee);
		System.out.println("Discount: "+discount+"%");
		System.out.println("Final fee: "+calculateFinalFee(fee,discount));		
	}
}
