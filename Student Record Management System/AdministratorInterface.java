import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/**
 * Compilation: javac AdministratorInterface.java
 * Execution: java AdministratorInterface
 * 
 * Provides an interactive command-line interface for administrators.
 */
public class AdministratorInterface {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        /*
         * Administrator can add a new course, enrol new students, assign a course to a student, assign grades
         * and calculate overall grades.
         */
        while (true) {
            System.out.println("\nWelcome to the Course Enrollment and Grade Management System\n");
            System.out.print("1. Add new course\n2. Enrol new student\n3. Add course to a student\n4. Assign grade\n5. Calculate overall grade\n6. Exit\nSelect an option: ");
            int option = Integer.parseInt(reader.readLine());

            switch (option) {
                case 1:
                    System.out.print("Enter course name: ");
                    String courseName = reader.readLine();
                    System.out.print("Enter course code: ");
                    String courseCode = reader.readLine();
                    System.out.print("Enter course max capacity: ");
                    int maxCapacity = Integer.parseInt(reader.readLine());
                    CourseManagement.addCourse(courseCode, courseName, maxCapacity);
                    System.out.println("Course added successfully");
                    break;
                case 2:
                    System.out.print("Enter student name: ");
                    String studentName = reader.readLine();
                    System.out.print("Enter student id: ");
                    String studentId = reader.readLine();
                    Student student = new Student(studentName, studentId);
                    System.out.print("Enter course code: ");
                    String enrollCourseCode = reader.readLine();
                    Course enrollCourse = CourseManagement.getCourseByCode(enrollCourseCode);
                    if (enrollCourse != null && CourseManagement.enrollStudent(student, enrollCourse)) {
                        System.out.println("Student enrolled successfully");
                    } else {
                        System.out.println("Student could not be enrolled, course is full or does not exist");
                    }
                    break;
                case 3:
                    System.out.print("Enter student id: ");
                    String studentId1 = reader.readLine();
                    Student student1 = CourseManagement.getStudentById(studentId1);
                    if (student1 == null) {
                        System.out.println("Student does not exist");
                        break;
                    }
                    System.out.print("Enter course code: ");
                    String courseCode1 = reader.readLine();
                    Course course1 = CourseManagement.getCourseByCode(courseCode1);
                    if (course1 != null && CourseManagement.enrollStudent(student1, course1)) {
                        System.out.println("Course added to a student successfully");
                    } else {
                        System.out.println("Course could not be added, course is full or does not exist");
                    }
                    break;
                case 4:
                    System.out.print("Enter student id: ");
                    String studentId2 = reader.readLine();
                    Student student2 = CourseManagement.getStudentById(studentId2);
                    if (student2 == null) {
                        System.out.println("Student does not exist");
                        break;
                    }
                    System.out.print("Enter course code: ");
                    String courseCode2 = reader.readLine();
                    Course course2 = CourseManagement.getCourseByCode(courseCode2);
                    if (course2 == null) {
                        System.out.println("Course does not exist");
                        break;
                    }
                    System.out.print("Enter grade: ");
                    String grade = reader.readLine();
                    CourseManagement.assignGrade(student2, course2, grade);
                    System.out.println("Grade assigned successfully");
                    break;
                case 5:
                    System.out.print("Enter student id: ");
                    String studentId3 = reader.readLine();
                    Student student3 = CourseManagement.getStudentById(studentId3);
                    if (student3 == null) {
                        System.out.println("Student does not exist");
                        break;
                    }
                    System.out.println("Overall grade: " + CourseManagement.calculateOverallGrade(student3));
                    break;
                case 6:
                    System.out.println("Thank you for using the Course Enrollment and Grade Management System");
                    return;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }
    }
}
