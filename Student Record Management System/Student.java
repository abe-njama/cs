import java.util.HashMap;

/**
 * Compilation: javac Student.java
 *
 * 
 * Represents a student with a name, ID, and enrolled courses.
 */
public class Student {
    private String studentName;
    private String studentID;
    private HashMap<Course, String> courseGrades;

    /**
     * Constructs a Student object.
     *
     * studentName is the name of the student.
     * studentID is the ID of the student.
     */
    public Student(String studentName, String studentID) {
        this.studentName = studentName;
        this.studentID = studentID;
        this.courseGrades = new HashMap<>();
    }

    /*
     * Gets the name of the student.
     * 
     * Returns the name of the student
     */

    public String getStudentName() {
        return studentName;
    }
    
    /*
     * Sets the name of the student.
     * 
     * studentName is the new name of the student.
     */
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    /*
     * Gets the student ID.
     * 
     * Returns the student ID.
     */
    public String getStudentID() {
        return studentID;
    }

    /*
     * Sets the student ID.
     * 
     * studentID is the new student ID.
     */
    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    /*
     * Gets the course grades.
     * 
     * Returns the course grades.
     */
    public HashMap<Course, String> getCourseGrades() {
        return courseGrades;
    }

    /**
     * Enrolls the student in a course.
     *
     * course is the course to enroll in.
     */
    public void enrollInCourse(Course course) {
        if (!courseGrades.containsKey(course)) {
            courseGrades.put(course, null);
        }
    }

    /**
     * Assigns a grade to the student for a course.
     *
     * course is the enrolled course.
     * grade is the grade of the enrolled course.
     */
    public void assignGrade(Course course, String grade) {
        if (courseGrades.containsKey(course)) {
            courseGrades.put(course, grade);
        }
    }
}
