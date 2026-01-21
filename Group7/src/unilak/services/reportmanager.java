package unilak.services;

import unilak.models.*;

public class reportmanager {
    private coursemanager cm;

    public reportmanager(coursemanager cm) {
        this.cm = cm;
    }

    public void printStatus(student s) {
        System.out.println("\n--- STUDENT ENROLLMENT STATUS ---");
        System.out.println("Name: " + s.fullName);
        System.out.println("Program: " + s.program);
        System.out.println("Enrolled Courses:");
        
        boolean found = false;
        for (course c : cm.courses) {
            if (c.enrolledStudents.contains(s.username)) {
                System.out.println("- " + c.courseCode + ": " + c.title);
                found = true;
            }
        }
        if (!found) System.out.println("No active enrollments.");
        System.out.println("---------------------------------");
    }
}