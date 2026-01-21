package unilak.models;

import java.util.ArrayList;

public class instructor extends user {
    public String department;
    public String officeHours;
    public ArrayList<String> coursesTaught;

    public instructor(String username, String password, String fullName, String email, String dept, String hours) {
        super(username, password, fullName, email);
        this.department = dept;
        this.officeHours = hours;
        this.coursesTaught = new ArrayList<>();
    }

    @Override
    public void displayInfo() {
        System.out.println("Instructor: " + fullName + " | Dept: " + department + " | Office Hours: " + officeHours);
    }

    @Override
    public String getRole() {
        return "INSTRUCTOR";
    }
}