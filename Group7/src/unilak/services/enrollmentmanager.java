package unilak.services;

import unilak.models.enrollment;
import unilak.models.course;
import java.util.ArrayList;

public class enrollmentmanager implements enrollmentservice {
    public ArrayList<enrollment> enrollments = new ArrayList<>();
    private coursemanager cm;

    public enrollmentmanager(coursemanager cm) {
        this.cm = cm;
    }

    @Override
    public boolean enroll(String studentUser, String code) {
        course c = cm.find(code);
        
        // Validation: Must exist, not be full, and avoid duplicate enrollment
        if (c != null && !c.isFull()) {
            for (enrollment e : enrollments) {
                if (e.studentUsername.equals(studentUser) && e.courseCode.equalsIgnoreCase(code)) {
                    System.out.println("Error: Already enrolled in " + code);
                    return false;
                }
            }
            enrollments.add(new enrollment(studentUser, code));
            c.enrolledStudents.add(studentUser);
            return true;
        }
        return false;
    }

    @Override
    public boolean drop(String studentUser, String code) {
        for (int i = 0; i < enrollments.size(); i++) {
            enrollment e = enrollments.get(i);
            if (e.studentUsername.equals(studentUser) && e.courseCode.equalsIgnoreCase(code)) {
                enrollments.remove(i);
                course c = cm.find(code);
                if (c != null) c.enrolledStudents.remove(studentUser);
                return true;
            }
        }
        return false;
    }
}