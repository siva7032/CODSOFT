import java.io.*;
import java.util.*;

class Student implements Serializable {
    private String name;
    private int rollNumber;
    private String grade;
    // Add other relevant details as needed

    public Student(String name, int rollNumber, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
    }

    // Getters and setters for attributes
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}

class StudentManagementSystem {
    private List<Student> students;

    public StudentManagementSystem() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(Student student) {
        students.remove(student);
    }

    public Student searchStudent(int rollNumber) {
        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                return student;
            }
        }
        return null; // Student not found
    }

    public void displayAllStudents() {
        for (Student student : students) {
            System.out.println("Name: " + student.getName() + ", Roll Number: " + student.getRollNumber() + ", Grade: " + student.getGrade());
        }
    }

    // Implement methods to read and write student data to a file
    public void saveToFile(String filename) {
        try {
            FileOutputStream fos = new FileOutputStream(filename);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(students);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadFromFile(String filename) {
        try {
            FileInputStream fis = new FileInputStream(filename);
            ObjectInputStream ois = new ObjectInputStream(fis);
            students = (List<Student>) ois.readObject();
            ois.close();
            fis.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

public class student {
    public static void main(String[] args) {
        StudentManagementSystem sms = new StudentManagementSystem();
        // Load students from file if needed

        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("1. Add a student");
            System.out.println("2. Remove a student");
            System.out.println("3. Search for a student");
            System.out.println("4. Display all students");
            System.out.println("5. Save students to file");
            System.out.println("6. Load students from file");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter roll number: ");
                    int rollNumber = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter grade: ");
                    String grade = scanner.nextLine();
                    Student newStudent = new Student(name, rollNumber, grade);
                    sms.addStudent(newStudent);
                    break;
                case 2:
                    System.out.print("Enter roll number of student to remove: ");
                    int rollToRemove = scanner.nextInt();
                    Student studentToRemove = sms.searchStudent(rollToRemove);
                    if (studentToRemove != null) {
                        sms.removeStudent(studentToRemove);
                        System.out.println("Student removed successfully.");
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter roll number of student to search: ");
                    int rollToSearch = scanner.nextInt();
                    Student foundStudent = sms.searchStudent(rollToSearch);
                    if (foundStudent != null) {
                        System.out.println("Student found:");
                        System.out.println("Name: " + foundStudent.getName() + ", Roll Number: " + foundStudent.getRollNumber() + ", Grade: " + foundStudent.getGrade());
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case 4:
                    System.out.println("All students:");
                    sms.displayAllStudents();
                    break;
                case 5:
                    sms.saveToFile("students.ser");
                    System.out.println("Students saved to file.");
                    break;
                case 6:
                    sms.loadFromFile("students.ser");
                    System.out.println("Students loaded from file.");
                    break;
                case 7:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 7.");
            }
        } while (choice != 7);

        scanner.close();
    }
}