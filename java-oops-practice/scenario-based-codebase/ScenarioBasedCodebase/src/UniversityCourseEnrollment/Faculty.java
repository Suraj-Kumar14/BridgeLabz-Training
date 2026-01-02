package UniversityCourseEnrollment;

public class Faculty {

    private String facultyName;

    public Faculty(String name) {
        this.facultyName = name;
    }

    public void assignGrade(Graded student, double marks) {
        student.assignGrade(marks);
    }
}
