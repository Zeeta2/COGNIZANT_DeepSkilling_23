package com.employee.management;

public class Main {

    public static void main(String[] args) {

        EmployeeManagement management = new EmployeeManagement();

        // Add Employees
        management.addEmployee(new Employee(101, "Arun", "Manager", 60000));
        management.addEmployee(new Employee(102, "Kavin", "Developer", 45000));
        management.addEmployee(new Employee(103, "Ravi", "Tester", 35000));

        // Display Employees
        System.out.println("\nAll Employees");
        management.displayEmployees();

        // Search Employee
        System.out.println("\nSearching Employee with ID 102");
        management.searchEmployee(102);

        // Delete Employee
        System.out.println("\nDeleting Employee with ID 102");
        management.deleteEmployee(102);

        // Display After Deletion
        System.out.println("\nEmployees After Deletion");
        management.displayEmployees();
    }
}