package com.study;
class Employee {
    int employeeId;
    String name;
    String position;
    double salary;

    public Employee(int employeeId, String name, String position, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "ID: " + employeeId + ", Name: " + name +
               ", Position: " + position + ", Salary: $" + salary;
    }
}

public class EmployeeManagementSystem {
    private Employee[] employees;
    private int count;

    public EmployeeManagementSystem(int capacity) {
        employees = new Employee[capacity];
        count = 0;
    }

    public void addEmployee(Employee emp) {
        if (count < employees.length) {
            employees[count++] = emp;
            System.out.println("Employee added: " + emp);
        } else {
            System.out.println("Employee list is full. Cannot add more employees.");
        }
    }

    public Employee searchEmployee(int employeeId) {
        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId == employeeId) {
                return employees[i];
            }
        }
        return null;
    }

    public void listEmployees() {
        if (count == 0) {
            System.out.println("No employees to display.");
        } else {
            System.out.println("Employee List:");
            for (int i = 0; i < count; i++) {
                System.out.println(employees[i]);
            }
        }
    }

    public void deleteEmployee(int employeeId) {
        boolean found = false;
        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId == employeeId) {
                for (int j = i; j < count - 1; j++) {
                    employees[j] = employees[j + 1];
                }
                employees[--count] = null;
                System.out.println("Employee deleted. ID: " + employeeId);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Employee not found. ID: " + employeeId);
        }
    }

    public static void main(String[] args) {
        EmployeeManagementSystem ems = new EmployeeManagementSystem(5);

        ems.addEmployee(new Employee(1, "Alice", "Manager", 75000));
        ems.addEmployee(new Employee(2, "Bob", "Developer", 60000));
        ems.addEmployee(new Employee(3, "Charlie", "Designer", 55000));

        ems.listEmployees();

        Employee found = ems.searchEmployee(2);
        System.out.println(found != null ? "Found: " + found : "Employee not found.");

        ems.deleteEmployee(2);
        ems.listEmployees();

        ems.deleteEmployee(10);
    }
}



