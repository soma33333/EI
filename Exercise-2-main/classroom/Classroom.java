package classroom;

import java.util.ArrayList;
import java.util.List;
import student.Student;
import assignment.Assignment;

public class Classroom {
    private String className;
    private List<Student> students;
    private List<Assignment> assignments;

    public Classroom(String className) {
        this.className = className;
        this.students = new ArrayList<>();
        this.assignments = new ArrayList<>();
    }

    public String getClassName() {
        return className;
    }

    public List<Student> getStudents() {
        return students;
    }

    public List<Assignment> getAssignments() {
        return assignments;
    }

    public void addStudent(Student stud) {
        students.add(stud);
        System.out.println("Student " + stud.getName() + " has been added to classroom " + className);
    }

    public void scheduleAssignment(Assignment assignment) {
        assignments.add(assignment);
        System.out.println("Assignment " + assignment.getAssignmentName() + " scheduled for classroom " + className);
    }

    public void listStudents() {
        if (students.isEmpty()) {
            System.out.println("No students enrolled in classroom " + className);
        } else {
            System.out.println("Students in classroom " + className + ":");
            for (Student student : students) {
                System.out.println("- " + student.getName());
            }
        }
    }
}
