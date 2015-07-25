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
import java.util.Map;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class User extends DatabaseEntity{
    protected String email;
    protected String password;
    protected String salt;
    protected String firstName;
    protected String lastName;
    protected boolean isActive;
    protected boolean autoLogin;
    protected Date dateCreated;
    protected String avatarFileName;
    protected Image avatar;

    private final String TABLE_NAME = "tblUser";
    private final String[] TABLE_COL_NAMES = {
            "id",
            "email",
            "password",
            "salt",
            "firstName",
            "lastName",
            "isActive",
            "autoLogon",
            "dateCreated",
            "avatarFileName"
    };
    private final String[] TABLE_COL_TYPES = {
            "INTEGER PRIMARY KEY",
            "VARCHAR(100)",
            "VARCHAR(300)",
            "VARCHAR(300)",
            "VARCHAR(50)",
            "VARCHAR(50)",
            "BOOLEAN DEFAULT 1",
            "BOOLEAN DEFAULT 1",
            "DATETIME",
            "TEXT"
    };
    private final int PASSWORD_MIN_LENGTH = 8;
    private final int PASSWORD_MAX_LENGTH = 64;

    // List of organizations this user belongs to
    private ArrayList<Organization> organizationList = new ArrayList<Organization>();
    // List of Groups that this user belongs to
    private ArrayList<Group> groupList = new ArrayList<Group>();

    // The mapping of columns to their types
    // Used to create the table in the database
    protected Map<String, String> tableMap;

    /**@apiNote Default Constructor
     * @param user_email - String
     * @param user_password - String
     * @param fName - String
     * @param lName - String
     */
    public User(String user_email, String user_password, String fName, String lName) {
        super();

        email = user_email;

        if (checkStringValue(fName)) {
            this.firstName = fName;
        }

        if (checkStringValue(lName)) {
            this.lastName = lName;
        }

        this.isActive = true;

        /*TODO: populate avatar image*/

        this.dateCreated = new Date();
        this.m_tableName = TABLE_NAME; // Set the table name

        if (!setPassword(user_password)) {
            /*TODO: Cast an exception if the password setting fails*/
        }

    }
    /**@apiNote Default Constructor
     * @param userId - int
     * @param user_email - String
     * @param user_password - String
     * @param fName - String
     * @param lName - String
     */
    public User(int userId, String user_email, String user_password, String fName, String lName) {
        super();

        email = user_email;

        if (checkStringValue(fName)) {
            this.firstName = fName;
        }

        if (checkStringValue(lName)) {
            this.lastName = lName;
        }

        this.id = userId;
        this.isActive = true;
        /*TODO: populate avatar image*/
        this.dateCreated = new Date();
        this.m_tableName = TABLE_NAME; // Set the table name

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

        if (super.checkStringValue(newPassword)) {
            if (newPassword.length() >= PASSWORD_MIN_LENGTH || newPassword.length() <= PASSWORD_MAX_LENGTH) {
                /*TODO: Hash the password string*/
                this.password = newPassword;
                success = true;
            }
        }

        return success;
    }

    protected String salt(String MD5Password, Date dateCreated) {
        String Salt = dateCreated.toString() + SecurityUtil.RandomString(16);
        return (MD5Password + salt) + salt;
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

    /** Gets First Name field
     * @return First Name - String
     */
    public String getFirstName() {
        return this.firstName;
    }

    /** Sets First Name field
     * @param firstName - String
     * @return null
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /** Gets email field
     * @return email - String
     */
    public String getLastName() {
        return this.lastName;
    }

    /** Sets Last Name field
     * @param lastName - String
     * @return null
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /** Gets the autologin field
     * @return boolean
     */
    public boolean getAutoLogin() {
        return autoLogin;
    }

    /** Sets the autologin field
     * @param autoLogin - boolean
     */
    public void setAutoLogin(boolean autoLogin) {
        this.autoLogin = autoLogin;
    }

    /** Gets email field
     * @return email - String
     */
    public String getEmail() {
        return this.email;
    }

    /** Sets email field
     * @param email - String
     * @return null
     */
    public void setEmail(String email) {
        /*TODO: Send user an email to verify that the email was changed*/
        this.email = email;
    }

    /** Sends the user a confirmation email
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
