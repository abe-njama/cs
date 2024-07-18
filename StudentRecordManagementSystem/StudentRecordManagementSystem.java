/*
 * Compilation: javac StudentRecordManagementSystem.java
 * Execution: java StudentRecordManagementSystem
 * 
 * The Student Record Management System allows admins to add, update and view student records
 * 
 * 
 */

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Represents a Student with name, ID, age, and grade.
 */
class Student {
    private String name;
    private String id;
    private int age;
    private char grade;

    /**
     * Constructs a new Student.
     *
     * @param name  the student's name
     * @param id    the student's ID
     * @param age   the student's age
     * @param grade the student's grade
     */
    public Student(String name, String id, int age, char grade) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.grade = grade;
    }

    /*
     * Gets the name of the student
     */
    public String getName() { return name; }

    /*
     * Sets the name of the student
     */
    public void setName(String name) { this.name = name; }

    /*
     * Gets the ID of the student
     */
    public String getId() { return id; }

    /*
     * Sets the ID of the student
     */
    public void setId(String id) { this.id = id; }

    /*
     * Gets the age of the student
     */
    public int getAge() { return age; }

    /*
     * Sets the age of the student
     */
    public void setAge(int age) { this.age = age; }

    /*
     * Gets the grade of the student
     */
    public char getGrade() { return grade; }

    /*
     * Sets the grade of the student
     */
    public void setGrade(char grade) { this.grade = grade; }

    /*
     * Returns a string representation of the student.
     * The string contains the student's ID, name, age and grade
     */
    @Override
    public String toString() {
        return "Student [ID=" + id + ", Name=" + name + ", Age=" + age + ", Grade=" + grade + "]";
    }
}

/**
 * Manages the list of students and provides methods to add, update, and view student details.
 */
class StudentManagement {
    private static ArrayList<Student> studentList = new ArrayList<>();
    private static int totalStudents = 0;

    /**
     * Adds a new student to the list.
     *
     * @param name  the student's name
     * @param id    the student's ID
     * @param age   the student's age
     * @param grade the student's grade
     */
    public static void addStudent(String name, String id, int age, char grade) {
        Student newStudent = new Student(name, id, age, grade);
        studentList.add(newStudent);
        totalStudents++;
    }

    /**
     * Updates the details of an existing student.
     *
     * @param id    the student's ID
     * @param name  the new name
     * @param age   the new age
     * @param grade the new grade
     * @return true if the student was updated, false if not found
     */
    public static boolean updateStudent(String id, String name, int age, char grade) {
        for (Student student : studentList) {
            if (student.getId().equals(id)) {
                student.setName(name);
                student.setAge(age);
                student.setGrade(grade);
                return true;
            }
        }
        return false;
    }

    /**
     * Retrieves a student's details by ID.
     *
     * @param id the student's ID
     * @return the student if found, null if not found
     */
    public static Student viewStudent(String id) {
        for (Student student : studentList) {
            if (student.getId().equals(id)) {
                return student;
            }
        }
        return null;
    }

    /**
     * Retrieves the list of all students.
     *
     * @return the list of students
     */
    public static ArrayList<Student> viewAllStudents() {
        return studentList;
    }

    /**
     * Gets the total number of students.
     *
     * @return the total number of students
     */
    public static int getTotalStudents() {
        return totalStudents;
    }
}

/**
 * Main class to run the Student Record Management System.
 */
public class StudentRecordManagementSystem {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("\nWelcome to the Student Record Management System!\n");
        System.out.println("Select one option by typing in the number that is next to your preferred task\n");

        while (true) {
            System.out.println("1. Add a new Student"); //Admin will be compelled to enter the student's name, ID, age, and grade when prompted.
            System.out.println("2. Update Student Information"); //Admin will enter the student's ID, followed by the new name, age, and grade
            System.out.println("3. View Student Details"); //Admin will enter the student's ID to view their details
            System.out.println("4. View All Students"); //Admin can view the list of all registered students
            System.out.println("5. Exit\n"); //Exits the program
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    addNewStudent();
                    break;
                case 2:
                    updateStudentInfo();
                    break;
                case 3:
                    viewStudentDetails();
                    break;
                case 4:
                    viewAllStudents();
                    break;
                case 5:
                    System.out.println("Thank you for using the Student Record Management System");
                    return;
                default:
                    System.out.println("\nInvalid input!");
                    System.out.println("Select either option 1 to 5\n");
            }
        }
    }

    /**
     * Prompts the administrator to add a new student and adds the student.
     */
    private static void addNewStudent() {
        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Student ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Student Age: ");
        int age = scanner.nextInt();
        System.out.print("Enter Student Grade: ");
        char grade = scanner.next().charAt(0);
        scanner.nextLine();  // Consume newline

        StudentManagement.addStudent(name, id, age, grade);
        System.out.println("Student added successfully!");
    }

    /**
     * Prompts the administrator to update an existing student's information.
     */
    private static void updateStudentInfo() {
        System.out.print("Enter Student ID to update: ");
        String id = scanner.nextLine();
        System.out.print("Enter New Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter New Age: ");
        int age = scanner.nextInt();
        System.out.print("Enter New Grade: ");
        char grade = scanner.next().charAt(0);
        scanner.nextLine();  // Consume newline

        boolean success = StudentManagement.updateStudent(id, name, age, grade);
        if (success) {
            System.out.println("Student updated successfully!");
        } else {
            System.out.println("Student ID not found!");
        }
    }

    /**
     * Prompts the administrator to view a student's details.
     */
    private static void viewStudentDetails() {
        System.out.print("Enter Student ID to view: ");
        String id = scanner.nextLine();
        Student student = StudentManagement.viewStudent(id);
        if (student != null) {
            System.out.println(student);
        } else {
            System.out.println("Student ID not found!");
        }
    }

    /**
     * Displays the list of all registered students.
     */
    private static void viewAllStudents() {
        ArrayList<Student> students = StudentManagement.viewAllStudents();
        if (students.isEmpty()) {
            System.out.println("No students have currently been registered\n");
        } else {
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }
}
