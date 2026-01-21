package unilak.models;

public abstract class user {
    public String username;
    public String password;
    public String fullName;
    public String email;

    public user(String username, String password, String fullName, String email) {
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.email = email;
    }

    public abstract void displayInfo();
    public abstract String getRole();
}