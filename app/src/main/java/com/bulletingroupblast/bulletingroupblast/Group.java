/**
 * Copyright © 2015 Ruben Piatnitsky
 * This program is released under the "GNU license".
 * Please see the file COPYING in this distribution for
 * license terms.
 * <p>
 * Created by Ruben Piatnitsky on 7/6/15.
 */

package com.bulletingroupblast.bulletingroupblast;

import java.util.ArrayList;
import java.util.Date;
import com.bulletingroupblast.bulletingroupblast.User;


public class Group {
    private int id;
    protected String name;
    protected String description;
    protected String category;
    /*TODO: Create ENUM for category*/
    protected Date created;
    protected ArrayList members;
    protected ArrayList admins;

    /*TODO: Add Chat, Announcement to variables*/
    /*TODO: avatar*/

    // This is the default constructor for group class
    // Takes in a name string and description string
    // Returns nothing
    public Group(String name, String description) {
        this.id = 0;
        this.name = name;
        this.description = description;

        /*TODO: Initialize members, admins, chat and announcement*/
    }

    // Gets the group Id
    // Takes in nothing
    // Returns group Id
    public int getId() {
        return id;
    }

    // Gets the name of the group
    // Takes in nothing
    // Returns group name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Gets the description of the group
    // Takes in nothing
    // Returns group description
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // Gets the category of the group
    // Takes in nothing
    // Returns group category
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    // Gets the created date of the group
    // Takes in nothing
    // Returns group created date
    public Date getCreated() {
        return created;
    }

    // Gets the Members of the group
    // Takes in nothing
    // Returns group members, which are a list of User objects
    public ArrayList getMembers() {
        return members;
    }

    public void setMembers(ArrayList members) {
        this.members = members;
    }

    // Gets the Admins of the group
    // Takes in nothing
    // Returns group admins, which are a list of User objects
    public ArrayList getAdmins() {
        return admins;
    }

    public void setAdmins(ArrayList admins) {
        this.admins = admins;
    }
}
