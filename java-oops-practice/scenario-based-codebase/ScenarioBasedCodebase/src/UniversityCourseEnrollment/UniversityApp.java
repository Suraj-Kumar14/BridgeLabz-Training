package UniversityCourseEnrollment;

public class UniversityApp {
	
	public static void main(String[] args) {

		 Student s1 = new Undergraduate(101, "Ananya");
	     Student s2 = new Postgraduate(201, "Karan", 3.0);

	     Course oop = new Course("CS101", "Object Oriented Programming");

	     Faculty faculty = new Faculty("Dr. Mehta");

	     faculty.assignGrade((Graded) s1, 82);
	     faculty.assignGrade((Graded) s2, 45);

	      Enrollment e1 = new Enrollment(s1, oop);
	      Enrollment e2 = new Enrollment(s2, oop);

	      e1.showDetails();
	      e2.showDetails();
    }
}
