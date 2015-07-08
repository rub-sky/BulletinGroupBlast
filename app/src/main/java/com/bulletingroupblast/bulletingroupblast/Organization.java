package com.bulletingroupblast.bulletingroupblast;

/**
 * Copyright © 2015 Ruben Piatnitsky
 * This program is released under the "GNU license".
 * Please see the file COPYING in this distribution for
 * license terms.
 * <p>
 * Created by Ruben Piatnitsky on 7/6/15.
 */

import com.bulletingroupblast.bulletingroupblast.Group;
import com.bulletingroupblast.bulletingroupblast.User;
import java.util.ArrayList;
import java.util.Date;

public class Organization {
    protected String name;
    protected String description;
    protected User admin;
    protected Date createdDate;


    ArrayList<Group> groupList = new ArrayList<Group>();
    ArrayList<User> userList = new ArrayList<User>();
    ArrayList<User> adminList = new ArrayList<User>();


//    Group someGroup = new Group();
//
//    groupList.add(Group.class someGroup);

    // This is the default constructor for the organization class
    // It takes in the name, description, and user object for administrator
    // Returns nothing
    public Organization(String orgName, String orgDesc, User orgAdmin) {
        if (orgName != null || !orgName.isEmpty()) {
            name = orgName;
        }
//        else {
            // Throw exception
//        }

        description = orgDesc;

        if (orgAdmin != null) {
            admin = orgAdmin;
        }
//        else {
            //Throw exception
//        }

        createdDate = new Date();
    }

    // This function allows you to add a new group to the organization
    // It takes in a group object
    // Returns: a true if the group is added or false otherwise
    public boolean addGroup(Group newGroup) {
        boolean success = false;

        if (newGroup != null) {
            groupList.add(newGroup);
            success = true;
        }

        return success;
    }

    // This function allows you to add a new group to the organization
    // It takes in a group object
    // Returns: a true if the group is added or false otherwise
    public boolean removeGroup(Group someGroup) {
        boolean success = false;

        if (groupList.contains(someGroup)) {
            groupList.add(someGroup);
            success = true;
        }

        return success;
    }

    // Gets the admin user
    // Takes in Nothing
    // Returns a User object
    public User getAdmin() {
        return admin;
    }

    // Sets the organization admin
    // Takes in a User object
    // Returns nothing
    public void setAdmin(User admin) {
        // Send notification to current admin
        this.admin = admin;
    }

    // Gets the organization name
    // Takes in Nothing
    // Returns a string
    public String getName() {
        return name;
    }

    // Sets the organization name
    // Takes in a name string
    // Returns nothing
    public void setName(String name) {
        this.name = name;
    }
}
