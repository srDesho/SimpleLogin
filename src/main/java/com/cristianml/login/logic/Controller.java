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

    public List<Role> bringRoleList() {
        return persisControl.bringRoleList();
    }

    public void createUser(String username, String pass, String strRole) {
        
        User usr = new User();
        usr.setUsername(username);
        usr.setPass(pass);
        // Get the last user id to the table user and set new id
        int idUser = bringLastIdUser()+1;
        usr.setId(idUser);
        // get the rol
        Role role = bringRole(strRole);
        if(role != null){
            usr.setUnRole(role);
        }  
        
        persisControl.createUser(usr);
    }
    
    public Role bringRole(String strRole) {
        List<Role> roleList = bringRoleList();
        for (Role role : roleList) {
            if (role.getRoleName().equals(strRole)) {   
                return role;
            }  
        }
        return null;
    }

    public User bringUser(int idUser) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private int bringLastIdUser() {
        List<User> userList = bringUserList();
        User lastUser = userList.get((userList.size()-1));
        return lastUser.getId();
    }
}
