package unilak.services;

import unilak.models.course;
import java.util.ArrayList;

public class coursemanager {
    public ArrayList<course> courses = new ArrayList<>();

    public void add(course c) { 
        courses.add(c); 
    }

    public course find(String code) {
        for (course c : courses) {
            if (c.courseCode.equalsIgnoreCase(code)) return c;
        }
        return null;
    }

    // This is the missing method causing your error
    public void showAll() {
        if (courses.isEmpty()) {
            System.out.println("No courses available.");
            return;
        }
        System.out.println("\n--- Available Courses ---");
        for (course c : courses) {
            System.out.println("Code: " + c.courseCode + 
                               " | Title: " + c.title + 
                               " | Instructor: " + c.instructor + 
                               " | Capacity: " + c.enrolledStudents.size() + "/" + c.capacity);
        }
    }

    public void showByInstructor(String instructorName) {
        for (course c : courses) {
            if (c.instructor.equalsIgnoreCase(instructorName)) {
                System.out.println("- " + c.courseCode + ": " + c.title);
            }
        }
    }
}