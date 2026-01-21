package unilak.services;

public interface enrollmentservice {
    boolean enroll(String studentUsername, String courseCode);
    boolean drop(String studentUsername, String courseCode);
    boolean assignGrade(String instructorUser, String studentUser, String code, String rawGrade);
    double calculateGpa(String studentUser);
}