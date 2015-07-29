/**
 * Copyright © 2015 Ruben Piatnitsky
 * This program is released under the "GNU license".
 * Please see the file COPYING in this distribution for
 * license terms.
 * <p>
 * Created by Ruben Piatnitsky on 7/6/15.
 */
package com.bulletingroupblast.bulletingroupblast;


import android.media.Image;
import android.util.Log;

import com.bulletingroupblast.bulletingroupblast.Group;
import com.bulletingroupblast.bulletingroupblast.User;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.StringTokenizer;

public class Organization extends DatabaseEntity{
    protected String name;
    protected String description;
    protected Timestamp createdDate;
    protected String address1;
    protected String address2;
    protected String city;
    protected String state;
    protected String zipCode;
    protected String websiteLink;
    protected Image logo;

    protected ArrayList<Group> groupList = new ArrayList<Group>();
    protected ArrayList<User> userList = new ArrayList<User>();
    protected ArrayList<User> adminList = new ArrayList<User>();

    private final String TABLE_NAME = "tblOrganization";


    /** This is the default constructor for the organization class
     * @param orgName Organization name
     * @param orgDesc Description of the organization
     * @param orgAdmin Organization administrator
    */
    public Organization(String orgName, String orgDesc, User orgAdmin) {
        super();

        this.groupList = new ArrayList<>();
        this.adminList = new ArrayList<>();
        this.userList = new ArrayList<>();

        // Make sure the strings are not empty
        if (orgName != null || !orgName.isEmpty()) {
            this.name = orgName;
        }
            // Throw exception if otherwise

        if (orgAdmin != null) {
            this.adminList.add(orgAdmin);
        }

        this.description = orgDesc;
        this.id = 0;
        this.address1 = new String();
        this.address2 = new String();
        this.city = new String();
        this.state = new String();
        this.zipCode = new String();

        long time = System.currentTimeMillis(); // get the current time
        this.createdDate = new Timestamp(time);
    }

    /** This is the secondary constructor for the organization class
     * @param orgId Organization Id
     * @param orgName Organization name
     * @param orgDesc Description of the organization
     * @param orgAdmin Organization administrator
     */
    public Organization(int orgId, String orgName, String orgDesc, User orgAdmin) {
        super();

        if (orgName != null || !orgName.isEmpty()) {
            this.name = orgName;
        }
//        else {
        // Throw exception
//        }

        this.description = orgDesc;
        this.id = orgId;
        this.address1 = new String();
        this.address2 = new String();
        this.city = new String();
        this.state = new String();
        this.zipCode = new String();

        long time = System.currentTimeMillis(); // Get the current time
        this.createdDate = new Timestamp(time);
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

    /** Gets the organization name
      * @return A string of the name
     */
    public String getName() {
        return name;
    }

    /** Sets the organization name
     * @param name Takes in a name string
     */
    public void setName(String name) {
        this.name = name;
    }

    /** Adds a new user to the organization
     * @param toAddUser User object to add to the organization users list
     */
    public void addUser(User toAddUser) {
        try {
            /*TODO: Add the user to the organization*/

        } catch (Exception ex) {
            Log.e(ex.getCause().toString(),ex.getMessage());
        }
    }

    /** Adds a new user to the organization
     * @param userId The user id (int) to remove
     */
    public void removeUser(int userId) {
        try {
            /*Check if the user exists in the organization and database*/
            /*TODO: Remove the given user from the organization*/

        } catch (Exception ex) {
            Log.e(ex.getCause().toString(),ex.getMessage());
        }
    }

    /** Gets the website link
     * @return string of address
     */
    public String getWebsiteLink() {
        return websiteLink;
    }

    /** Sets the website link
     * @param websiteLink A link to the given website
     */
    public void setWebsiteLink(String websiteLink) {
        this.websiteLink = websiteLink;
    }

    /** Gets the logo of the organization
     * @return Image of the logo
     */
    public Image getLogo() {
        return logo;
    }

    /** Sets the logo of the organization
     * @param logo Image file of the logo
     */
    public void setLogo(Image logo) {
        /*TODO: Resize the image*/
        /*TODO: Save the image to local folder*/
        this.logo = logo;
    }
}
