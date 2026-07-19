package com.cognizant.mvc;

public class MVCTest {

    public static void main(String[] args) {

        Student student = new Student("John", 101, "A");

        StudentView view = new StudentView();

        StudentController controller =
                new StudentController(student, view);

        System.out.println("Initial Student Details:");
        controller.updateView();

        System.out.println();

        controller.setStudentName("Alice");
        controller.setStudentId(102);
        controller.setStudentGrade("A+");

        System.out.println("Updated Student Details:");
        controller.updateView();
    }
}