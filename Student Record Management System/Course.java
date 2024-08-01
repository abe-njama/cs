/**
 * Compilation: javac Course.java
 * 
 * Represents a course with a course code, name, and maximum capacity.
 */
public class Course {
    private String courseCode;
    private String courseName;
    private int maxCapacity;
    private int enrolledStudents;

    /**
     * Constructs a Course object.
     *
     * courseCode is the unique code of the course.
     * courseName is the name of the course.
     * maxCapacity is the maximum number of students that can enrol in the course.
     */
    public Course(String courseCode, String courseName, int maxCapacity) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.maxCapacity = maxCapacity;
        this.enrolledStudents = 0;
    }

    /*
     * Gets the course code.
     * 
     * Returns the course code.
     */
    public String getCourseCode() {
        return courseCode;
    }

    /*
     * Gets the course name.
     * 
     * Returns the course name.
     */
    public String getCourseName() {
        return courseName;
    }

    /*
     * Gets the maximum capacity of a course.
     * 
     * Returns the maximum capacity of a course.
     */
    public int getMaxCapacity() {
        return maxCapacity;
    }

    /*
     * Gets the number of students enrolled in a course.
     * 
     * Returns the number of students enrolled in a course.
     */
    public int getEnrolledStudents() {
        return enrolledStudents;
    }

    /**
     * Enrolls a student in the course if the maximu capacity has not been reached.
     */
    public void enrollStudent() {
        if (enrolledStudents < maxCapacity) {
            enrolledStudents++;
        }
    }
}
