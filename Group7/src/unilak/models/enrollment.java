package unilak.models;

public class enrollment {
    public String studentUsername;
    public String courseCode;
    public String status; // ACTIVE, DROPPED, COMPLETED

    public enrollment(String studentUsername, String courseCode) {
        this.studentUsername = studentUsername;
        this.courseCode = courseCode;
        this.status = "ACTIVE";
    }
}