import java.util.List;
import java.util.Scanner;

public class Main {
    static Student student;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create dormitory
        Dormitory dormitory = new Dormitory();

        // Display main menu
        System.out.println("Welcome to the Dormitory Management System!");

        while (true) {
            System.out.println("\nWhat would you like to do?");
            System.out.println("1. View all apartments");
            System.out.println("2. View all students");
            System.out.println("3. View students in a faculty");
            System.out.println("4. Add a student to an apartment");
            System.out.println("5. Remove a student from an apartment");
            System.out.println("6. Exit");

            // Get user input
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // View all apartments
                    List<Apartment> apartments = dormitory.getApartments();
                    for (Apartment apartment : apartments) {
                        System.out.println(apartment);
                    }
                    break;
                case 2:
                    // View all students
                    List<Student> students = dormitory.getAllStudents();
                    for (Student student : students) {
                        System.out.println(student);
                    }
                    break;
                case 3:
                    // View students in a faculty
                    System.out.println("Enter faculty (A, B, C, or D):");
                    char faculty = scanner.next().charAt(0);
                    List<Student> studentsInFaculty = dormitory.getStudentsInFaculty(faculty);
                    for (Student student : studentsInFaculty) {
                        System.out.println(student);
                    }
                    break;
                case 4:
                    // Add a student to an apartment
                    System.out.println("Enter faculty (A, B, C, or D):");
                    char addFaculty = scanner.next().charAt(0);
                    System.out.println("Enter apartment number (1, 2, or 3):");
                    int addNumber = scanner.nextInt();
                    System.out.println("Enter student name:");
                    String addName = scanner.next();
                    System.out.println("Enter student ID:");
                    int addID = scanner.nextInt();

                    // Create new student
                    Student newStudent = new Student(addName, addID);

                    // Add student to apartment
                    boolean added = dormitory.addStudentToApartment(newStudent, addFaculty, addNumber);
                    if (added) {
                        System.out.println("Student added successfully!");
                    } else {
                        System.out.println("Failed to add student. Apartment may be full or not exist.");
                    }
                    break;
                case 5:
                    // Remove a student from an apartment
                    System.out.println("Enter faculty (A, B, C, or D):");
                    char removeFaculty = scanner.next().charAt(0);
                    System.out.println("Enter apartment number (1, 2, or 3):");
                    int removeNumber = scanner.nextInt();
                    System.out.println("Enter student ID:");
                    int removeID = scanner.nextInt();

                    // Remove student from apartment
                    boolean removed = dormitory.removeStudentFromApartment(removeID, removeFaculty, removeNumber);
                    if (dormitory.removeStudentFromApartment(student)) {
                        System.out.println("Student removed from apartment");
                    } else {
                        System.out.println("Student not found in any apartment");
                    }

                    break;
                case 6:
                    // Exit program
                    System.out.println("Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

    }
}