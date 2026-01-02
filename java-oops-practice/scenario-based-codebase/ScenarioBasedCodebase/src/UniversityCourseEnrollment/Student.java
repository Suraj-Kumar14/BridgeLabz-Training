package UniversityCourseEnrollment;

public abstract class Student {
	public  String name;
	public  int studentId;
	private double gpa;
	
	//without elective preference
	public Student(int studentId, String name) {
        this.studentId = studentId;
        this.name = name;
        this.gpa = 0.0;
    }
	
	//with elective preference
	 public Student(int studentId, String name, double gpa) {
        this.studentId = studentId;
	    this.name = name;
	    this.gpa = gpa;
    }
		
	protected void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public double getGpa() {
        return gpa;
    }

    public String getTranscript() {
        return "ID: " + studentId + ", Name: " + name + ", GPA: " + gpa;
    }

    public abstract void displayInfo();
	
}
