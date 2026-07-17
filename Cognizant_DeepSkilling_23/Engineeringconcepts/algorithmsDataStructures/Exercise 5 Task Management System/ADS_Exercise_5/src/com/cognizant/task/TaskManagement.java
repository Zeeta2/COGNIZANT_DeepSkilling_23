package com.cognizant.task;

public class TaskManagement {

    Task head = null;

    // Add Task
    public void addTask(int id, String name, String status) {

        Task newTask = new Task(id, name, status);

        if (head == null) {
            head = newTask;
        } else {

            Task temp = head;

            while (temp.next != null) {
                temp = temp.next;
            }

            temp.next = newTask;
        }

        System.out.println("Task Added Successfully.");
    }

    // Search Task
    public void searchTask(int id) {

        Task temp = head;

        while (temp != null) {

            if (temp.taskId == id) {
                System.out.println("Task Found:");
                System.out.println(temp);
                return;
            }

            temp = temp.next;
        }

        System.out.println("Task Not Found.");
    }

    // Traverse Tasks
    public void traverseTasks() {

        if (head == null) {
            System.out.println("No Tasks Available.");
            return;
        }

        Task temp = head;

        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }
    }

    // Delete Task
    public void deleteTask(int id) {

        if (head == null) {
            System.out.println("Task Not Found.");
            return;
        }

        if (head.taskId == id) {
            head = head.next;
            System.out.println("Task Deleted Successfully.");
            return;
        }

        Task current = head;

        while (current.next != null && current.next.taskId != id) {
            current = current.next;
        }

        if (current.next == null) {
            System.out.println("Task Not Found.");
        } else {
            current.next = current.next.next;
            System.out.println("Task Deleted Successfully.");
        }
    }

    public static void main(String[] args) {

        TaskManagement obj = new TaskManagement();

        obj.addTask(101, "Design UI", "Pending");
        obj.addTask(102, "Develop Backend", "In Progress");
        obj.addTask(103, "Testing", "Pending");

        System.out.println("\nTask List:");
        obj.traverseTasks();

        System.out.println("\nSearching Task:");
        obj.searchTask(102);

        System.out.println("\nDeleting Task:");
        obj.deleteTask(101);

        System.out.println("\nTask List After Deletion:");
        obj.traverseTasks();
    }
}