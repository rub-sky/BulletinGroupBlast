/**
 * Copyright © 2015 Ruben Piatnitsky
 * This program is released under the "GNU license".
 * Please see the file COPYING in this distribution for
 * license terms.
 *
 * @Author Ruben Piatnitsky
 *
 */

package com.bulletingroupblast.bulletingroupblast;

import android.media.Image;

import com.bulletingroupblast.bulletingroupblast.Organization;
import java.sql.Array;
import java.util.Date;
import java.util.ArrayList;

public class User {
    protected String email;
    protected int userId;
    protected String password;
    protected String firstName;
    protected String lastName;
    protected boolean isActive;
    protected boolean isAdmin;
    protected boolean autoLogin;
    protected Date dateCreated;
    protected Image avatar;
    private final int PASSWORD_MIN_LENGTH = 8;
    private final int PASSWORD_MAX_LENGTH = 64;
    private ArrayList<Organization> organizationList = new ArrayList<Organization>();  // List of organizations this user belongs to
    private ArrayList<Group> groupList = new ArrayList<Group>(); // List of Groups that this user belongs to

    /**@apiNote Default Constructor
     * @param user_email - String
     * @param user_password - String
     * @param fName - String
     * @param lName - String
     */
    public User(String user_email, String user_password, String fName, String lName) {
        email = user_email;

        if (checkStringValue(fName)) {
            this.firstName = fName;
        }

        if (checkStringValue(lName)) {
            this.lastName = lName;
        }

        this.isActive = true;
        this.isAdmin = true;
        /*TODO: populate avatar image*/
        this.dateCreated = new Date();

        if (!setPassword(user_password)) {
            /*TODO: Cast an exception if the password setting fails*/
        }

    }

    /**@apiNote Creates a user object from an existing user id.
     * @param uId
     */
    public User(int uId) {
        if (uId > 0 ) {
            /*TODO: Search database for this record and load it into an array*/

        }
    }

    /**@apiNote Sets the password by hashing it
     * @param newPassword - String
     * @return boolean - true if success, false otherwise
     */
    public boolean setPassword(String newPassword) {
        boolean success = false;

        if (checkStringValue(newPassword)) {
            if (newPassword.length() >= PASSWORD_MIN_LENGTH || newPassword.length() <= PASSWORD_MAX_LENGTH) {
                /*TODO: Hash the password string*/
                this.password = newPassword;
                success = true;
            }
        }

        return success;
    }


    /**@apiNote Adds an organization to the user's organization list
     * @param newOrganization - Organization Class Object
     * @return boolean - true if item added, false otherwise
     */
    public boolean addOrganization(Organization newOrganization) {
        boolean success = false;

        if (newOrganization != null) {
            this.organizationList.add(newOrganization);
            success = true;
        }

        return success;
    }

    /**@apiNote Adds a group to the user's group list
     * @param newGroup - Group Class Object
     * @return boolean - true if item added, false otherwise
     */
    public boolean addGroup(Group newGroup) {
        boolean success = false;

        if (newGroup != null) {
            this.groupList.add(newGroup);
            success = true;
        }

        return success;
    }

    /**@apiNote Gets User Id field
     * @return User Id - Int
     */
    public int getUserId() {
        return userId;
    }

    /**@apiNote Gets First Name field
     * @return First Name - String
     */
    public String getFirstName() {
        return this.firstName;
    }

    /**@apiNote Sets First Name field
     * @param firstName - String
     * @return null
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**@apiNote Gets email field
     * @return email - String
     */
    public String getLastName() {
        return this.lastName;
    }

    /**@apiNote Sets Last Name field
     * @param lastName - String
     * @return null
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**@apiNote Gets the autologin field
     * @return boolean
     */
    public boolean getAutoLogin() {
        return autoLogin;
    }

    /**@apiNote Sets the autologin field
     * @param autoLogin - boolean
     */
    public void setAutoLogin(boolean autoLogin) {
        this.autoLogin = autoLogin;
    }

    /**@apiNote Gets email field
     * @return email - String
     */
    public String getEmail() {
        return this.email;
    }

    /**@apiNote Sets email field
     * @param email - String
     * @return null
     */
    public void setEmail(String email) {
        /*TODO: Send user an email to verify that the email was changed*/
        this.email = email;
    }

    /** @apiNote Checks the value of the given string to make sure its not null or empty
     * @param strVal
     * @return boolean - true if string not empty or null, false otherwise
     */
    private boolean checkStringValue(String strVal) {
        boolean success = false;

        if (strVal != null || !strVal.isEmpty()) {
            success = true;
        }

        return success;
    }

    /**@apiNote  Updates the current user info in the database
     * @return SQL String for Update
     */
    public String UpdateString() {
        String result = "Update";
        /*TODO: Generate an UPDATE statement*/

        return result;
    }

    /**@apiNote Inserts the current user into the database
     * @return SQL String for insert
     */
    public String InsertString() {
        String result = "Insert";
        /*TODO: Generate an INSERT statement*/
        String qry = "INSERT into users values() where id=" + this.userId;

        return result;
    }

    /**@apiNote Deletes the current user from the database and initializes the variables
     * @return SQL String for Delete
     */
    public String DeleteString() {
        return "Delete from tblUser where id="+this.userId;
    }

    /**@apiNote  Populates the user from the database
     * @return boolean - true if successful, false otherwise
     */
    public String getDataFromDB() {
        return "select * from tblUsers where id="+this.userId;
    }

    /**@apiNote Sends the user a confirmation email
     * @return boolean - true if message sent and false otherwise
     */
    public boolean SendConfirmation() {
        boolean result = false;

        try {
            /*TODO: Generate an Email to be sent*/

        } catch (Exception e) {
            /*TODO: Log the error*/
            /*TODO: Redirect*/
        }

        return result;
    }
}
