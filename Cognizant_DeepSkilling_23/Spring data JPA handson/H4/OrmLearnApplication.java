package com.cognizant.ormlearn;

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

        testAddEmployee();
    }

    private static void testAddEmployee() {

        Employee employee = new Employee();

        employee.setName("Zeeta");
        employee.setSalary(50000);
        employee.setPermanent(true);

        employee.setDepartment(
                departmentService.get(1));

        employeeService.save(employee);

        System.out.println(employee);
        System.out.println(employee.getDepartment());
    }
}