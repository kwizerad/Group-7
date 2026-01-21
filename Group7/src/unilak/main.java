package unilak;

import unilak.models.*;
import unilak.services.*;
import java.util.Scanner;

public class Main {
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

        // Make sure your course constructor matches these parameters in your project
        cm.add(new course("BIT211", "Java Programming", 3, "Dr. Robert", 40));

        while (true) {
            System.out.println("\nLOGIN FORM");
            System.out.print("Username: ");
            String u = sc.nextLine();
            if (u.equalsIgnoreCase("exit")) break;

            System.out.print("Password: ");
            String p = sc.nextLine();

            user found = um.checkLogin(u, p);

            if (found != null) {
                fh.logActivity("Login: " + found.username);
                boolean active = true;

                while (active) {
                    System.out.println("\nMenu for " + found.getRole());

                    // STUDENT MENU
                    if (found.getRole().equals("STUDENT")) {
                        System.out.println("1. Courses\n2. Enroll\n3. Status\n4. GPA\n5. Logout");
                        System.out.print("Choose: ");
                        String opt = sc.nextLine();

                        if (opt.equals("1")) {
                            cm.showAll();
                        } else if (opt.equals("2")) {
                            System.out.print("Course Code: ");
                            String code = sc.nextLine();
                            boolean ok = em.enroll(found.username, code);
                            System.out.println(ok ? "Enrolled successfully." : "Enroll failed.");
                        } else if (opt.equals("3")) {
                            rm.printStatus((student) found);
                        } else if (opt.equals("4")) {
                            double gpa = em.calculateGpa(found.username);
                            System.out.println("GPA: " + String.format("%.2f", gpa));
                        } else if (opt.equals("5")) {
                            active = false;
                        } else {
                            System.out.println("Invalid option.");
                        }
                    }

                    // INSTRUCTOR MENU
                    else if (found.getRole().equals("INSTRUCTOR")) {
                        System.out.println("1. My Courses\n2. Assign Grade\n3. Logout");
                        System.out.print("Choose: ");
                        String opt = sc.nextLine();

                        if (opt.equals("1")) {
                            cm.showByInstructor(found.fullName);
                        } else if (opt.equals("2")) {
                            System.out.print("Course Code: ");
                            String courseCode = sc.nextLine();

                            System.out.print("Student Username: ");
                            String studentUser = sc.nextLine();

                            System.out.print("Grade: ");
                            String rawGrade = sc.nextLine();

                            boolean ok = em.assignGrade(studentUser, courseCode, rawGrade, "");
                            System.out.println(ok ? "Grade assigned." : "Assign grade failed.");
                        } else if (opt.equals("3")) {
                            active = false;
                        } else {
                            System.out.println("Invalid option.");
                        }
                    }

                    // ADMIN MENU
                    else if (found.getRole().equals("ADMIN")) {
                        System.out.println("1. View All\n2. Logout");
                        System.out.print("Choose: ");
                        String opt = sc.nextLine();

                        if (opt.equals("1")) {
                            cm.showAll();
                        } else if (opt.equals("2")) {
                            active = false;
                        } else {
                            System.out.println("Invalid option.");
                        }
                    }

                    else {
                        System.out.println("Unknown role.");
                        active = false;
                    }
                }
            } else {
                System.out.println("Invalid login");
            }
        }

        sc.close();
    }
}