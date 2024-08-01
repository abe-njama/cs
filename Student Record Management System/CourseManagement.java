import java.util.ArrayList;
import java.util.HashMap;

/**
 * Compilation: javac CourseManagement.java
 * 
 * Manages courses and student enrollments.
 */
public class CourseManagement {
    private static ArrayList<Course> courses = new ArrayList<>();
    private static ArrayList<Student> students = new ArrayList<>();
    private static HashMap<Student, HashMap<Course, String>> studentGrades = new HashMap<>();

    /**
     * Adds a new course.
     *
     * courseCode is the code of the course.
     * courseName is the name of the course.
     * maxCapacity is the maximum capacity of the course.
     */
    public static void addCourse(String courseCode, String courseName, int maxCapacity) {
        courses.add(new Course(courseCode, courseName, maxCapacity));
    }

    /**
     * Enrolls a student in a course.
     *
     * student is the student to enroll.
     * course is the course to enroll in.
     * Returns true if the student was successfully enrolled, else false.
     */
    public static boolean enrollStudent(Student student, Course course) {
        if (course.getEnrolledStudents() < course.getMaxCapacity()) {
            student.enrollInCourse(course);
            course.enrollStudent();
            if (!students.contains(student)) {
                students.add(student);
            }
            studentGrades.putIfAbsent(student, new HashMap<>());
            studentGrades.get(student).putIfAbsent(course, null);
            return true;
        }
        return false;
    }

    /**
     * Assigns a grade to a student for a course.
     *
     * student is the student to be assigned a grade.
     * course is the course to be assigned a grade.
     * grade is the grade to be assigned to a course.
     */
    public static void assignGrade(Student student, Course course, String grade) {
        student.assignGrade(course, grade);
        studentGrades.get(student).put(course, grade);
    }

    /**
     * Calculates the overall grade for a student.
     *
     * student is the student to calculate total assigned grades.
     * Returns the overall grade as a double.
     */
    public static double calculateOverallGrade(Student student) {
        HashMap<Course, String> grades = student.getCourseGrades();
        double total = 0;
        int count = 0;

        for (String grade : grades.values()) {
            if (grade != null) {
                total += Double.parseDouble(grade);
                count++;
            }
        }

        return count > 0 ? total / count : 0;
    }

    /**
     * Gets the list of courses.
     *
     * Returns the list of courses.
     */
    public static ArrayList<Course> getCourses() {
        return courses;
    }

    /**
     * Gets the list of students.
     *
     * Returns the list of students.
     */
    public static ArrayList<Student> getStudents() {
        return students;
    }

    /**
     * Retrieves a course by its code.
     *
     * courseCode is the code of the course.
     * Returns the course, or null if not found.
     */
    public static Course getCourseByCode(String courseCode) {
        for (Course course : courses) {
            if (course.getCourseCode().equals(courseCode)) {
                return course;
            }
        }
        return null;
    }

    /**
     * Retrieves a student by their ID.
     *
     * studentId is the student ID
     * Returns the student, or null if not found
     */
    public static Student getStudentById(String studentId) {
        for (Student student : students) {
            if (student.getStudentID().equals(studentId)) {
                return student;
            }
        }
        return null;
    }
}
