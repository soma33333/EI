package student;

import java.util.ArrayList;
import java.util.List;
import assignment.Assignment;

public class Student {
    private String id;
    private String name;
    private List<Assignment> submittedAssignments;

    public Student(String id, String name) {
        this.id = id;
        this.name = name;
        this.submittedAssignments = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void submitAssignment(Assignment assignment) {
        submittedAssignments.add(assignment);
        System.out.println("Student " + name + " submitted assignment " + assignment.getAssignmentName() + " in the classroom " + assignment.getClassroomName());
    }
}
