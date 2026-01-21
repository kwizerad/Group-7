package unilak.models;

public class admin extends user {
    public String permissions;

    public admin(String username, String password, String fullName, String email, String permissions) {
        super(username, password, fullName, email);
        this.permissions = permissions;
    }

    @Override
    public void displayInfo() {
        System.out.println("Admin: " + fullName + " | Permissions: " + permissions);
    }

    @Override
    public String getRole() { return "ADMIN"; }
}