package unilak;

import unilak.models.*;
import unilak.services.*;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        usermanager um = new usermanager();
        coursemanager cm = new coursemanager();
        enrollmentmanager em = new enrollmentmanager(cm);
        reportmanager rm = new reportmanager(cm);
        filehandler fh = new filehandler();
        Scanner sc = new Scanner(System.in);

        // System Data
        um.add(new admin("admin", "admin123", "System Admin", "admin@unilak.rw", "Full"));
        um.add(new student("student1", "student123", "Kwizera Dieume", "kd@unilak.rw", "BIT", 2));
        um.add(new instructor("prof1", "prof123", "Dr. Robert", "robert@unilak.rw", "IT", "10AM-12PM"));
        cm.add(new course("BIT211", "Java Programming", 3, "Dr. Robert", 40));

        while (true) {
            System.out.println("\nLOGIN FORM");
            System.out.print("Username: ");
            String u = sc.nextLine();
            
            if (u.equals("exit")) break;
            
            System.out.print("Password: ");
            String p = sc.nextLine();

            user found = um.checkLogin(u, p);

            if (found != null) {
                fh.logActivity("Login: " + found.username);
                boolean active = true;
                
                while (active) {
                    System.out.println("\nMenu for " + found.getRole());
                    
                    if (found.getRole().equals("STUDENT")) {
                        System.out.println("1. Courses\n2. Enroll\n3. Status\n4. Logout");
                        String opt = sc.nextLine();
                        if (opt.equals("1")) cm.showAll();
                        else if (opt.equals("2")) {
                            System.out.print("Course Code: ");
                            em.enroll(found.username, sc.nextLine());
                        }
                        else if (opt.equals("3")) rm.printStatus((student) found);
                        else if (opt.equals("4")) active = false;
                    } 
                    else if (found.getRole().equals("INSTRUCTOR")) {
                        System.out.println("1. My Courses\n2. Logout");
                        String opt = sc.nextLine();
                        if (opt.equals("1")) cm.showByInstructor(found.fullName);
                        else if (opt.equals("2")) active = false;
                    }
                    else if (found.getRole().equals("ADMIN")) {
                        System.out.println("1. View All\n2. Logout");
                        String opt = sc.nextLine();
                        if (opt.equals("1")) cm.showAll();
                        else if (opt.equals("2")) active = false;
                    }
                }
            } else {
                System.out.println("Invalid Login");
            }
        }
        sc.close();
    }
}