package com.cristianml.login.persistence;

import com.cristianml.login.logic.Role;
import com.cristianml.login.logic.User;
import com.cristianml.login.persistence.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PersistenceController {
    UserJpaController userJpa = new UserJpaController();
    RoleJpaController rolJpa = new RoleJpaController();

    public List<User> bringUserList() {
        List<User> userList = userJpa.findUserEntities();
        return userList;
    }

    public List<Role> bringRoleList() {
        return rolJpa.findRoleEntities();
    }

    public void createUser(User usr) {
        userJpa.create(usr);
    }

    public User bringUser(int idUser) {
        return userJpa.findUser(idUser);
    }

    public void editUser(User usr) {
        try {
            userJpa.edit(usr);
        } catch (Exception ex) {
            Logger.getLogger(PersistenceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteUser(int idUser) {
        try {
            userJpa.destroy(idUser);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(PersistenceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
}
