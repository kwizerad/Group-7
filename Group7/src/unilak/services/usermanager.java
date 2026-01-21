package unilak.services;

import unilak.models.user;
import java.util.ArrayList;

public class usermanager {
    public ArrayList<user> list = new ArrayList<>();

    public void add(user u) { list.add(u); }

    public user checkLogin(String u, String p) {
        for (user current : list) {
            if (current.username.equals(u) && current.password.equals(p)) return current;
        }
        return null;
    }
}