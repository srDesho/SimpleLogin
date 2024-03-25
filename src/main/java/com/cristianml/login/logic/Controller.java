package com.cristianml.login.logic;

import com.cristianml.login.persistence.PersistenceController;
import java.util.List;

public class Controller {
    PersistenceController persisControl;
    
    // Creating constructor to instance
    public Controller() {
        persisControl = new PersistenceController();
    }
    
    public String validateUser(String username, String pass) {
        String message = "";
        // Create user list from database
        List<User> userList = persisControl.bringUserList();
        
        // Validate the datas
         for (User user : userList) {
            if (user.getUsername().equals(username)) {
                if (user.getPass().equals(pass)) {
                    message = "Validated correctly, Welcome " + user.getUsername();
                    return message;
                } else {
                    message = "Password incorrect.";
                    return message;
                }
            } else {
                message = "Username unregistered.";
            }
        }
        return message;
    }
    
}
