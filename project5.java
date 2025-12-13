import java.util.ArrayList;
import java.util.Scanner;

class Student {
    int id;
    String name;
    int age;
    String course;

    Student(int id, String name, int age, String course) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.course = course;
    }
}

public class project5 {
    static ArrayList<Student> students = new ArrayList<>();

    static void addStudent(Scanner sc) {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Age: ");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Course: ");
        String course = sc.nextLine();

        students.add(new Student(id, name, age, course));
        System.out.println("Student Added");
    }

    static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No Records Found");
            return;
        }

        System.out.println("\nID\tName\tAge\tCourse");
        System.out.println("--------------------------------");
        for (Student s : students) {
            System.out.println(s.id + "\t" + s.name + "\t" + s.age + "\t" + s.course);
        }
    }

    static void updateStudent(Scanner sc) {
        System.out.print("Enter ID to Update: ");
        int id = sc.nextInt();
        sc.nextLine();

        for (Student s : students) {
            if (s.id == id) {
                System.out.print("Enter New Name: ");
                s.name = sc.nextLine();

                System.out.print("Enter New Age: ");
                s.age = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter New Course: ");
                s.course = sc.nextLine();

                System.out.println("Student Updated");
                return;
            }
        }
        System.out.println("Student Not Found");
    }

    static void deleteStudent(Scanner sc) {
        System.out.print("Enter ID to Delete: ");
        int id = sc.nextInt();

        for (Student s : students) {
            if (s.id == id) {
                students.remove(s);
                System.out.println("Student Deleted");
                return;
            }
        }
        System.out.println("Student Not Found");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");

            System.out.print("Choose option: ");
            int choice = sc.nextInt();

            if (choice == 1) {
                addStudent(sc);
            } 
            else if (choice == 2) {
                viewStudents();
            } 
            else if (choice == 3) {
                updateStudent(sc);
            } 
            else if (choice == 4) {
                deleteStudent(sc);
            } 
            else if (choice == 5) {
                System.out.println("Program Ended");
                break;
            } 
            else {
                System.out.println("Invalid Choice");
            }
        }
    }
}
