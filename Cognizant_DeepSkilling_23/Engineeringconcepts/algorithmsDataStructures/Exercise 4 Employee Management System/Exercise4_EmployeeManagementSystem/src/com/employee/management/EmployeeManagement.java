package com.employee.management;

public class EmployeeManagement {

    Employee[] employees = new Employee[5];
    int count = 0;

    // Add Employee
    public void addEmployee(Employee employee) {

        if (count < employees.length) {
            employees[count] = employee;
            count++;
            System.out.println("Employee added successfully.");
        } else {
            System.out.println("Employee array is full.");
        }
    }

    // Search Employee
    public void searchEmployee(int employeeId) {

        boolean found = false;

        for (int i = 0; i < count; i++) {

            if (employees[i].employeeId == employeeId) {
                System.out.println("Employee Found:");
                employees[i].display();
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Employee not found.");
        }
    }

    // Display All Employees
    public void displayEmployees() {

        if (count == 0) {
            System.out.println("No employees available.");
            return;
        }

        System.out.println("\nEmployee Records:");

        for (int i = 0; i < count; i++) {
            employees[i].display();
        }
    }

    // Delete Employee
    public void deleteEmployee(int employeeId) {

        boolean found = false;

        for (int i = 0; i < count; i++) {

            if (employees[i].employeeId == employeeId) {

                for (int j = i; j < count - 1; j++) {
                    employees[j] = employees[j + 1];
                }

                employees[count - 1] = null;
                count--;

                System.out.println("Employee deleted successfully.");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Employee not found.");
        }
    }
}