package unilak.models;

public class student extends user {
    public String program;
    public int year;

    public student(String username, String password, String fullName, String email, String program, int year) {
        super(username, password, fullName, email);
        this.program = program;
        this.year = year;
    }

    @Override
    public void displayInfo() {
        System.out.println("Student: " + fullName + " | Program: " + program + " | Year: " + year);
    }

    @Override
    public String getRole() { return "STUDENT"; }
}