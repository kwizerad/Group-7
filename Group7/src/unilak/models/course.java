package unilak.models;

import java.util.ArrayList;

public class course {
    public String courseCode;
    public String title;
    public int credits;
    public String instructor;
    public int capacity;
    public ArrayList<String> enrolledStudents;
    public String gradingScheme; // LETTER, PASS_FAIL, NUMERICAL

    public course(String courseCode, String title, int credits, String instructor, int capacity) {
        this.courseCode = courseCode;
        this.title = title;
        // Validation: credits must be greater than 0
        this.credits = (credits > 0) ? credits : 1;
        this.instructor = instructor;
        this.capacity = capacity;
        this.enrolledStudents = new ArrayList<>();
        this.gradingScheme = "LETTER"; // default
    }

    public boolean isFull() {
        return enrolledStudents.size() >= capacity;
    }
}