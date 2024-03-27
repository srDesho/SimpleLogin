package com.cristianml.login.persistence;

import com.cristianml.login.logic.Role;
import com.cristianml.login.logic.User;
import java.util.List;

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
    
}
