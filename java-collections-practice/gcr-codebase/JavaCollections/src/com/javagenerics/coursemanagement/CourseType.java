package com.javagenerics.coursemanagement;

public abstract class CourseType {
	private String evaluationMethod;
	
	public CourseType(String evaluationMethod) {
		this.evaluationMethod=evaluationMethod;
	}

	 public String getEvaluationMethod() {
	        return evaluationMethod;
	    }

	    public abstract String getType();

		@Override
		public String toString() {
			return "CourseType [evaluationMethod=" + evaluationMethod + "]";
		}
	    
}
