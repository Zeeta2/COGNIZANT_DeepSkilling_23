package com.cognizant.ormlearn.repository;

import java.util.List;

import com.cognizant.ormlearn.model.Employee;

public interface EmployeeRepositoryCustom {

    List<Employee> searchEmployees(double salary, boolean permanent);

}