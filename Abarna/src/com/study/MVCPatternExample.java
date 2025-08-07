package com.study;
class Student {
    private String id;
    private String name;
    private String grade;

    // Constructor
    public Student(String id, String name, String grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGrade() {
        return grade;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}

// Step 3: View Class
class StudentView {
    public void displayStudentDetails(String id, String name, String grade) {
        System.out.println("Student Details:");
        System.out.println("ID   : " + id);
        System.out.println("Name : " + name);
        System.out.println("Grade: " + grade);
        System.out.println();
    }
}

// Step 4: Controller Class
class StudentController {
    private Student model;
    private StudentView view;

    public StudentController(Student model, StudentView view) {
        this.model = model;
        this.view = view;
    }

    public void setStudentName(String name) {
        model.setName(name);
    }

    public void setStudentGrade(String grade) {
        model.setGrade(grade);
    }

    public String getStudentName() {
        return model.getName();
    }

    public String getStudentGrade() {
        return model.getGrade();
    }

    public void updateView() {
        view.displayStudentDetails(model.getId(), model.getName(), model.getGrade());
    }
}

// Step 5: Main/Test Class
public class MVCPatternExample {
    public static void main(String[] args) {
        // Create Model
        Student student = new Student("S101", "Alice Smith", "A");

        // Create View
        StudentView view = new StudentView();

        // Create Controller
        StudentController controller = new StudentController(student, view);

        // Display initial data
        controller.updateView();

        // Update data using controller
        controller.setStudentName("Alice Johnson");
        controller.setStudentGrade("A+");

        // Display updated data
        controller.updateView();
    }
}
