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
import java.util.StringTokenizer;

public class Organization {
    protected int id;
    protected String name;
    protected String description;
    protected User admin;
    protected Date createdDate;
    protected String address1;
    protected String address2;
    protected String city;
    protected String state;
    protected String zipCode;
    protected String websiteLink;


    ArrayList<Group> groupList = new ArrayList<Group>();
    ArrayList<User> userList = new ArrayList<User>();
    ArrayList<User> adminList = new ArrayList<User>();


//    Group someGroup = new Group();
//
//    groupList.add(Group.class someGroup);

    /** This is the default constructor for the organization class
     * @param  orgName Organization name
     * @param orgDesc Description of the organization
     * @param orgAdmin Organization administrator
    */
    public Organization(String orgName, String orgDesc, User orgAdmin) {
        if (orgName != null || !orgName.isEmpty()) {
            this.name = orgName;
        }
//        else {
            // Throw exception
//        }

        this.description = orgDesc;

        if (orgAdmin != null) {
            this.admin = orgAdmin;
        }
//        else {
            //Throw exception
//        }

        this.id = 0;
        this.address1 = new String();
        this.address2 = new String();
        this.city = new String();
        this.state = new String();
        this.zipCode = new String();

        this.createdDate = new Date();
    }

    /** This function allows you to add a new group to the organization
     * @param  newGroup - It takes in a group object
     * @return true if the group is added and false otherwise
     */
    public boolean addGroup(Group newGroup) {
        boolean success = false;

        if (newGroup != null) {
            groupList.add(newGroup);
            success = true;
        }

        return success;
    }

    /** This function allows you to add a new group to the organization
     * @param someGroup It takes in a group object
     * @return true if the group is added and false otherwise
     */
    public boolean removeGroup(Group someGroup) {
        boolean success = false;

        if (groupList.contains(someGroup)) {
            groupList.add(someGroup);
            success = true;
        }

        return success;
    }

    /** Gets the admin user
     * Returns a User object
     */
    public User getAdmin() {
        return admin;
    }

    /** Sets the organization admin
     * Takes in a User object
     */
    public void setAdmin(User admin) {
        // Send notification to current admin
        this.admin = admin;
    }

    /** Gets the organization name
      * Returns a string
     */
    public String getName() {
        return name;
    }

    /** Sets the organization name
     * Takes in a name string
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the organization id
     * @return int
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the organization id
     * This function is only available within its class
     * @param orgId
     */
    public void setId(int orgId) {
        this.id = orgId;
    }
}
