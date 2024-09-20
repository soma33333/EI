package management;

import classroom.Classroom;
import student.Student;
import assignment.Assignment;

import java.util.HashMap;
import java.util.Map;

public class ClassManagement {
    private Map<String, Classroom> classrooms;

    public ClassManagement() {
        this.classrooms = new HashMap<>();
    }

    public void addClassroom(String className) {
        if (classrooms.containsKey(className)) {
            System.out.println("Classroom " + className + " exists.");
        } else {
            classrooms.put(className, new Classroom(className));
            System.out.println("Classroom " + className + " has been added.");
        }
    }

    public void listClassrooms() {
        if (classrooms.isEmpty()) {
            System.out.println("No classrooms available.");
        } else {
            System.out.println("List of classrooms:");
            for (String className : classrooms.keySet()) {
                System.out.println("- " + className);
            }
        }
    }

    public void removeClassroom(String className) {
        if (classrooms.containsKey(className)) {
            classrooms.remove(className);
            System.out.println("Classroom " + className + " has been removed.");
        } else {
            System.out.println("Classroom " + className + " does not exist.");
        }
    }

    public void addStudent(String id, String name, String className) {
        Classroom classroom = classrooms.get(className);
        if (classroom != null) {
            Student student = new Student(id, name);
            classroom.addStudent(student);
        } else {
            System.out.println("Classroom " + className + " does not exist.");
        }
    }

    public void listStudents(String className) {
        Classroom classroom = classrooms.get(className);
        if (classroom != null) {
            classroom.listStudents();
        } else {
            System.out.println("Classroom " + className + " does not exist.");
        }
    }

    public void scheduleAssignment(String assignmentName, String className) {
        Classroom classroom = classrooms.get(className);
        if (classroom != null) {
            Assignment assignment = new Assignment(assignmentName, className);
            classroom.scheduleAssignment(assignment);
        } else {
            System.out.println("Classroom " + className + " does not exist.");
        }
    }

    public void submitAssignment(String studID, String className, String assignName) {
        Classroom classroom = classrooms.get(className);
        if (classroom != null) {
            boolean studentFound = false;
            for (Student student : classroom.getStudents()) {
                if (student.getId().equals(studID)) {
                    Assignment assignment = new Assignment(assignName, className);
                    student.submitAssignment(assignment);
                    studentFound = true;
                    break;
                }
            }
            if (!studentFound) {
                System.out.println("Student " + studID + " not found in classroom " + className);
            }
        } else {
            System.out.println("Classroom " + className + " not found.");
        }
    }
}
