/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.atm;

import java.util.ArrayList;
import java.util.List;
import com.mycompany.atm.User;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author AMSY
 */

//    Admin Sectiond
class Admin {
    private Map<String, User> users;

    
    //    Admin Constractor
    public Admin() {
        users = new HashMap<>();
    }
//    createUser Method
    public void createUser(String uniqueId, String pin, String name, String contactNumber, String gender, String address) {
        User newUser = new User(uniqueId, pin, name, contactNumber, gender, address);
        users.put(uniqueId, newUser);
        System.out.println("User account created successfully");
    }
//    getUser Method
    public User getUser(String uniqueId) {
        return users.get(uniqueId);
    }
}