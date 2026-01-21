package unilak.services;

import unilak.models.course;
import unilak.models.enrollment;

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

    // IMPORTANT: This signature must match enrollmentservice
    @Override
    public boolean assignGrade(String studentUser, String courseCode, String rawGrade, String ignored) {
        for (enrollment e : enrollments) {
            if (e.studentUsername.equals(studentUser)
                    && e.courseCode.equalsIgnoreCase(courseCode)
                    && "ACTIVE".equals(e.status)) {

                course c = cm.find(courseCode);
                if (c == null) return false;

                GradeScheme scheme = GradeSchemeFactory.get(c.gradingScheme);

                if (!scheme.isValid(rawGrade)) {
                    System.out.println("Invalid grade for scheme: " + scheme.getType());
                    return false;
                }

                e.grade = scheme.normalize(rawGrade);
                e.status = "COMPLETED";
                return true;
            }
        }
        return false;
    }

    @Override
    public double calculateGpa(String studentUser) {
        double totalPoints = 0.0;
        int totalCredits = 0;

        for (enrollment e : enrollments) {
            if (!e.studentUsername.equals(studentUser)) continue;
            if (!"COMPLETED".equals(e.status)) continue;
            if (e.grade == null) continue;

            course c = cm.find(e.courseCode);
            if (c == null) continue;

            GradeScheme scheme = GradeSchemeFactory.get(c.gradingScheme);
            if (!scheme.countsInGpa()) continue;

            totalPoints += scheme.gradePoints(e.grade) * c.credits;
            totalCredits += c.credits;
        }

        if (totalCredits == 0) return 0.0;
        return totalPoints / totalCredits;
    }
}