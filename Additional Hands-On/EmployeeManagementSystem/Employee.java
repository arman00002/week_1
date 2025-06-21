package EmployeeManagementSystem;

public class Employee {
    private int employeeId;
    private String name;
    private String position;
    private double salary;

    private static final int MAX = 100;
    private static Employee[] employees = new Employee[MAX];
    private static int count = 0;

    public Employee(int id, String name, String position, double salary) {
        this.employeeId = id;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    public static void addEmployee(int id, String name, String position, double salary) {
        if (count < MAX) {
            employees[count++] = new Employee(id, name, position, salary);
            System.out.println("Employee added: " + name);
        } else {
            System.out.println("Cannot add more employees, array is full.");
        }
    }

    public static void searchEmployee(int id) {
        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId == id) {
                System.out.println("Employee Found:");
                employees[i].display();
                return;
            }
        }
        System.out.println("Employee ID " + id + " not found.");
    }

    public static void deleteEmployee(int id) {
        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId == id) {
                for (int j = i; j < count - 1; j++) {
                    employees[j] = employees[j + 1];
                }
                employees[--count] = null;
                System.out.println("Employee ID " + id + " deleted.");
                return;
            }
        }
        System.out.println("Employee ID " + id + " not found.");
    }

    public static void listAll() {
        if (count == 0) {
            System.out.println("No employees in the system.");
            return;
        }
        System.out.println("Employee List:");
        for (int i = 0; i < count; i++) {
            employees[i].display();
        }
    }

    public void display() {
        System.out.println("ID: " + employeeId + ", Name: " + name +
                ", Position: " + position + ", Salary: Rs." + salary);
    }

    public static void main(String[] args) {
        addEmployee(101, "Arjun", "Developer", 55000);
        addEmployee(102, "Sneha", "Manager", 72000);
        addEmployee(103, "Raj", "Tester", 48000);

        System.out.println();
        listAll();

        System.out.println("\nSearching for Employee ID 102:");
        searchEmployee(102);

        System.out.println("\nDeleting Employee ID 103:");
        deleteEmployee(103);

        System.out.println();
        listAll();
    }
}

