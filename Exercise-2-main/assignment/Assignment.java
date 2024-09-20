package assignment;

public class Assignment {
    private String assignmentName;
    private String classroomName;

    public Assignment(String assignmentName, String classroomName) {
        this.assignmentName = assignmentName;
        this.classroomName = classroomName;
    }

    public String getAssignmentName() {
        return assignmentName;
    }

    public String getClassroomName() {
        return classroomName;
    }
}
