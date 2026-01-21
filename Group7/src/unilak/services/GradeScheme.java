package unilak.services;

public interface GradeScheme {
    String getType();
    boolean isValid(String raw);
    String normalize(String raw);
    double gradePoints(String normalized);
    boolean countsInGpa();
}