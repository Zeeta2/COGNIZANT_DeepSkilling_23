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

        testGetAllPermanentEmployees();

    }

    private static void testGetAllPermanentEmployees() {

        System.out.println("START");

        List<Employee> employees =
                employeeService.getAllPermanentEmployees();

        for(Employee e : employees) {

            System.out.println("---------------------------");

            System.out.println("Employee : " + e);

            System.out.println("Department : " + e.getDepartment());

            System.out.println("Skills : " + e.getSkillList());

        }

        System.out.println("END");
    }

}