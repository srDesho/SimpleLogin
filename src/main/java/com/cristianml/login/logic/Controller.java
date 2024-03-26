package com.cristianml.login.logic;

import com.cristianml.login.persistence.PersistenceController;
import java.util.List;

public class Controller {
    PersistenceController persisControl;
    
    // Creating constructor to instance
    public Controller() {
        persisControl = new PersistenceController();
    }
    
    public User validateUser(String username, String pass) {
        // String message = "";
        User usr = null;
        // Create user list from database
        List<User> userList = persisControl.bringUserList();
        
        // Validate the datas
         for (User user : userList) {
            if (user.getUsername().equals(username)) {
                if (user.getPass().equals(pass)) {
                    // message = "Validated correctly, Welcome " + user.getUsername();
                    usr = user;
                    return usr;
                } else {
                    // message = "Password incorrect.";
                    usr = null;
                    return usr;
                }
            } else {
                // message = "Username unregistered.";
                usr = null;
            }
        }
        return usr;
    }

    public List<User> bringUserList() {
        return persisControl.bringUserList();
    }
    
}
