package com.cognizant.ormlearn;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.ormlearn.model.Employee;
import com.cognizant.ormlearn.service.DepartmentService;
import com.cognizant.ormlearn.service.EmployeeService;
import com.cognizant.ormlearn.service.SkillService;

@SpringBootApplication
public class OrmLearnApplication {

    private static EmployeeService employeeService;
    private static DepartmentService departmentService;
    private static SkillService skillService;

    public static void main(String[] args) {

        ApplicationContext context =
                SpringApplication.run(
                        OrmLearnApplication.class,
                        args);

        employeeService =
                context.getBean(EmployeeService.class);

        departmentService =
                context.getBean(DepartmentService.class);

        skillService =
                context.getBean(SkillService.class);

        testGetAllEmployeesNative();
    }

    private static void testGetAllEmployeesNative() {

        System.out.println("==================================");
        System.out.println("Hands-on 5 : Native Query");
        System.out.println("==================================");

        List<Employee> employees = employeeService.getAllEmployeesNative();

        employees.forEach(System.out::println);

        System.out.println("==================================");
    }
}