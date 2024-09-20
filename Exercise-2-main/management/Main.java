package management;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ClassManagement manage = new ClassManagement();
        Scanner input = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("Enter command (add_classroom, list_classrooms, remove_classroom, add_student, list_students, schedule_assignment, submit_assignment, exit):");
                String str = input.nextLine();

                switch (str) {
                    case "add_classroom":
                        System.out.println("Enter classroom name:");
                        String className = input.nextLine();
                        manage.addClassroom(className);
                        break;

                    case "list_classrooms":
                        manage.listClassrooms();
                        break;

                    case "remove_classroom":
                        System.out.println("Enter classroom name to remove:");
                        className = input.nextLine();
                        manage.removeClassroom(className);
                        break;

                    case "add_student":
                        System.out.println("Enter student ID, name, and classroom name (comma separated):");
                        String[] studentData = input.nextLine().split(",");
                        manage.addStudent(studentData[0].trim(), studentData[1].trim(), studentData[2].trim());
                        break;

                    case "list_students":
                        System.out.println("Enter classroom name:");
                        className = input.nextLine();
                        manage.listStudents(className);
                        break;

                    case "schedule_assignment":
                        System.out.println("Enter assignment name and classroom name (comma separated):");
                        String[] assignmentData = input.nextLine().split(",");
                        manage.scheduleAssignment(assignmentData[0].trim(), assignmentData[1].trim());
                        break;

                    case "submit_assignment":
                        System.out.println("Enter student ID, classroom name, and assignment name (comma separated):");
                        String[] submissionData = input.nextLine().split(",");
                        manage.submitAssignment(submissionData[0].trim(), submissionData[1].trim(), submissionData[2].trim());
                        break;

                    case "exit":
                        System.out.println("Exiting program.");
                        return;

                    default:
                        System.out.println("Invalid command.");
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Invalid input format. Please check your entries.");
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        }
    }
}
