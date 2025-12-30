package StudentRegistration;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentDAO dao = new StudentDAO();

        while (true) {
            System.out.println("1 Add");
            System.out.println("2 View");
            System.out.println("3 Update");
            System.out.println("4 Delete");
            System.out.println("5 Exit");

            int choice = sc.nextInt();
            sc.nextLine();

            try {
                if (choice == 1) {
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Email: ");
                    String email = sc.nextLine();
                    System.out.print("Course: ");
                    String course = sc.nextLine();
                    dao.addStudent(new Student(name, email, course));
                    System.out.println("Student added successfully!");
                }

                if (choice == 2) {
                    List<Student> students = dao.getAllStudents();

                    System.out.printf("%-5s %-20s %-25s %-10s%n", "ID", "Name", "Email", "Course");
                    System.out.println("--------------------------------------------------------------");
                    for (Student s : students) {
                        System.out.printf("%-5d %-20s %-25s %-10s%n",
                                s.getId(),
                                s.getName(),
                                s.getEmail(),
                                s.getCourse());
                    }
                }

                if (choice == 3) {
                    System.out.print("ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Email: ");
                    String email = sc.nextLine();
                    System.out.print("Course: ");
                    String course = sc.nextLine();
                    dao.updateStudent(new Student(id, name, email, course));
                    System.out.println("Student updated successfully!");
                }

                if (choice == 4) {
                    System.out.print("ID: ");
                    int id = sc.nextInt();
                    dao.deleteStudent(id);
                    System.out.println("Student deleted successfully!");
                }

                if (choice == 5) {
                    break;
                }
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
    }
}
