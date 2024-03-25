package com.cristianml.login.persistence;

import com.cristianml.login.logic.User;
import java.util.List;

public class PersistenceController {
    UserJpaController userJpa = new UserJpaController();

    public List<User> bringUserList() {
        List<User> userList = userJpa.findUserEntities();
        return userList;
    }
    
}
