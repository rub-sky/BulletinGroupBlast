package com.bulletingroupblast.bulletingroupblast;

/**
 * Copyright © 2015 Ruben Piatnitsky
 * This program is released under the "GNU license".
 * Please see the file COPYING in this distribution for
 * license terms.
 * <p>
 * Created by Ruben Piatnitsky on 7/6/15.
 */

//import com.google.common.base.Strings;
import com.bulletingroupblast.bulletingroupblast.Organization;
import java.util.Date;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class User {
    public String email;
    protected String password;
    protected String firstName;
    protected String lastName;
    protected boolean isActive;
    protected boolean isAdmin;
    protected Date dateCreated;
    private final int PASSWORD_MIN_LENGTH = 8;
    private final int PASSWORD_MAX_LENGTH = 64;


    ArrayList<Organization> organizationList = new ArrayList<Organization>();  // List of organizations this user belongs to


    // This is the default constructor for the User class
    // It takes in an email, password and a boolean value for admin
    // It returns nothing
    public User(String user_email, String user_password, String fName, String lName) {
        email = user_email;

        if (checkStringValue(fName)) {
            firstName = fName;
        }

        if (checkStringValue(lName)) {
            lastName = lName;
        }

        isActive = true;
        isAdmin = true;

        dateCreated = new Date();

        setPassword(user_password);     // Set the user password

    }

    // This function sets the password
    // It takes in a password value and sets it
    // Returns: True if successful and false otherwise
    public boolean setPassword(String newPassword) {
        boolean success = false;

        if (checkStringValue(newPassword)) {
            if (newPassword.length() >= PASSWORD_MIN_LENGTH || newPassword.length() <= PASSWORD_MAX_LENGTH) {
                password = newPassword;
                success = true;
            }
        }

        return success;
    }

    // This function adds an organization to the user's organization list
    // It takes in an organization object
    // Returns: true if added and false otherwise
    public boolean addOrganization(Organization newOrganization) {
        boolean success = false;

        if (newOrganization != null) {
            organizationList.add(newOrganization);
            success = true;
        }

        return success;
    }

    // Get function for first name field
    // Takes in nothing
    // Returns firstName as string
    public String getFirstName() {
        return firstName;
    }

    // Set function for first name field
    // Takes in a string
    // Returns nothing
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    // Get function for lst name field
    // Takes in nothing
    // Returns lastName
    public String getLastName() {
        return lastName;
    }

    // Set function for first name field
    // Takes in lastName string
    // Returns nothing
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // Get function for email field
    // Takes in email string
    // Returns nothing
    public String getEmail() {
        return email;
    }

    // Set function for  field
    // Takes in lastName string
    // Returns nothing
    public void setEmail(String email) {
        /*TODO: Send user an email to verify that the email was changed*/
        this.email = email;
    }

    // This function checks the value of the given string to make sure its not null or empty
    private boolean checkStringValue(String strVal) {
        boolean success = false;

        if (strVal != null || !strVal.isEmpty()) {
            success = true;
        }

        return success;
    }
}
