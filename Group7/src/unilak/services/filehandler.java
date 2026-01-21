package unilak.services;

import java.io.*;
import java.util.Date;

public class filehandler {
    // This method must match the name used in main.java
    public void logActivity(String msg) {
        try {
            // "activity.log" is the file name, true means append mode
            FileWriter fw = new FileWriter("activity.log", true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(new Date() + " : " + msg);
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            System.out.println("Error writing to log file: " + e.getMessage());
        }
    }
}