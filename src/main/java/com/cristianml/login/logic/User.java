package com.cristianml.login.logic;

import java.io.Serializable;
import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class User implements Serializable {
    @Id
    //@GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String username;
    private String pass;
    
    @ManyToOne
    @JoinColumn(name = "fk_role")
    private Role unRole;
    
    public User(){}

    public User(int id, String username, String pass, Role unRole) {
        this.id = id;
        this.username = username;
        this.pass = pass;
        this.unRole = unRole;
    }

    public Role getUnRole() {
        return unRole;
    }

    public void setUnRole(Role unRole) {
        this.unRole = unRole;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    
    
}
