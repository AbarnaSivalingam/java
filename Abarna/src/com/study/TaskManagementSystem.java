package com.study;
class Task {
    int taskId;
    String taskName;
    String status;

    public Task(int taskId, String taskName, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Task ID: " + taskId +
               ", Name: " + taskName +
               ", Status: " + status;
    }
}

// Node class for the singly linked list
class TaskNode {
    Task task;
    TaskNode next;

    public TaskNode(Task task) {
        this.task = task;
        this.next = null;
    }
}

// Task management system using singly linked list
public class TaskManagementSystem {
    private TaskNode head;

    // Add a new task at the end
    public void addTask(Task task) {
        TaskNode newNode = new TaskNode(task);
        if (head == null) {
            head = newNode;
        } else {
            TaskNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        System.out.println("Task added: " + task);
    }

    // Search for a task by ID
    public Task searchTask(int taskId) {
        TaskNode current = head;
        while (current != null) {
            if (current.task.taskId == taskId) {
                return current.task;
            }
            current = current.next;
        }
        return null;
    }

    // Traverse and print all tasks
    public void traverseTasks() {
        if (head == null) {
            System.out.println("No tasks to display.");
            return;
        }

        System.out.println("Task List:");
        TaskNode current = head;
        while (current != null) {
            System.out.println(current.task);
            current = current.next;
        }
    }

    // Delete a task by ID
    public void deleteTask(int taskId) {
        if (head == null) {
            System.out.println("Task list is empty.");
            return;
        }

        if (head.task.taskId == taskId) {
            head = head.next;
            System.out.println("Task deleted. ID: " + taskId);
            return;
        }

        TaskNode current = head;
        while (current.next != null && current.next.task.taskId != taskId) {
            current = current.next;
        }

        if (current.next == null) {
            System.out.println("Task not found. ID: " + taskId);
        } else {
            current.next = current.next.next;
            System.out.println("Task deleted. ID: " + taskId);
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        TaskManagementSystem tms = new TaskManagementSystem();

        // Add tasks
        tms.addTask(new Task(1, "Design UI", "Pending"));
        tms.addTask(new Task(2, "Develop Backend", "In Progress"));
        tms.addTask(new Task(3, "Write Tests", "Pending"));

        // Traverse tasks
        tms.traverseTasks();

        // Search for a task
        Task found = tms.searchTask(2);
        System.out.println(found != null ? "Task Found: " + found : "Task not found.");

        // Delete a task
        tms.deleteTask(2);

        // Traverse again
        tms.traverseTasks();

        // Try deleting a non-existent task
        tms.deleteTask(99);
    }
}



