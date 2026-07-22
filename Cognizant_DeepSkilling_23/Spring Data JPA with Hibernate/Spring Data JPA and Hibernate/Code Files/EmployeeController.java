package com.example.employeemanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import com.example.employeemanagementsystem.entity.Employee;
import com.example.employeemanagementsystem.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // Save
    @PostMapping
    public Employee saveEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    // Get All
    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    // Get By Id
    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }

    // Update
    @PutMapping
    public Employee updateEmployee(@RequestBody Employee employee) {
        return employeeService.updateEmployee(employee);
    }

    // Delete
    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return "Employee Deleted Successfully";
    }

    // Pagination
    @GetMapping("/page")
    public Page<Employee> getEmployeesByPage(
            @RequestParam int page,
            @RequestParam int size) {

        return employeeService.getEmployeesByPage(page, size);
    }

    // Sorting
    @GetMapping("/sort")
    public List<Employee> sortEmployees() {
        return employeeService.getEmployeesSortedByName();
    }

    // Pagination + Sorting
    @GetMapping("/pagesort")
    public Page<Employee> pageAndSort(
            @RequestParam int page,
            @RequestParam int size) {

        return employeeService.getEmployeesByPageAndSort(page, size);
    }
}