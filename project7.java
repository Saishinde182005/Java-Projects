import java.util.*;

class Employee {
    int id;
    String name;
    String department;
    double salary;

    Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }
}

public class project7 {
    static Map<Integer, Employee> employeeMap = new HashMap<>();

    static void addEmployee(Scanner sc) {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        if (employeeMap.containsKey(id)) {
            System.out.println("Employee Already Exists");
            return;
        }

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Department: ");
        String department = sc.nextLine();

        System.out.print("Enter Salary: ");
        double salary = sc.nextDouble();

        employeeMap.put(id, new Employee(id, name, department, salary));
        System.out.println("Employee Added");
    }

    static void viewEmployees() {
        if (employeeMap.isEmpty()) {
            System.out.println("No Records Found");
            return;
        }

        System.out.println("\nID\tName\tDepartment\tSalary");
        System.out.println("-------------------------------------------");

        for (Employee e : employeeMap.values()) {
            System.out.println(e.id + "\t" + e.name + "\t" + e.department + "\t\t" + e.salary);
        }
    }

    static void updateEmployee(Scanner sc) {
        System.out.print("Enter ID to Update: ");
        int id = sc.nextInt();
        sc.nextLine();

        Employee e = employeeMap.get(id);
        if (e == null) {
            System.out.println("Employee Not Found");
            return;
        }

        System.out.print("Enter New Name: ");
        e.name = sc.nextLine();

        System.out.print("Enter New Department: ");
        e.department = sc.nextLine();

        System.out.print("Enter New Salary: ");
        e.salary = sc.nextDouble();

        System.out.println("Employee Updated");
    }

    static void deleteEmployee(Scanner sc) {
        System.out.print("Enter ID to Delete: ");
        int id = sc.nextInt();

        if (employeeMap.remove(id) != null) {
            System.out.println("Employee Deleted");
        } else {
            System.out.println("Employee Not Found");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");

            System.out.print("Choose option: ");
            int choice = sc.nextInt();

            if (choice == 1) {
                addEmployee(sc);
            } 
            else if (choice == 2) {
                viewEmployees();
            } 
            else if (choice == 3) {
                updateEmployee(sc);
            } 
            else if (choice == 4) {
                deleteEmployee(sc);
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
