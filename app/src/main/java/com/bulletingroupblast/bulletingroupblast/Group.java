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
    protected int orgId;    // The organization id that this group belongs to

    /*TODO: Add Chat, Announcement to variables*/
    /*TODO: avatar*/

    /** This is the default constructor for group class
     * @param name string
     * @param description string
     */
    public Group(String name, String description) {
        this.id = 0;
        this.name = name;
        this.description = description;

        /*TODO: Initialize members, admins, chat and announcement*/
        this.admins = new ArrayList<User>();
        this.members = new ArrayList<User>();
    }

    /** This is the default constructor for group class
     * @param grpId group id
     * @param orgId organization id string
     * @param name string
     * @param description string
     * @param cat category string
     */
    public Group(int grpId, int orgId, String name, String description, String cat, User admin) {
        this.id = grpId;
        this.orgId = orgId;
        this.name = name;
        this.description = description;
        this.category = cat;

        /*TODO: Initialize members, admins, chat and announcement*/
        this.admins = new ArrayList<User>();
        this.admins.add(admin);

        this.members = new ArrayList<User>();
    }

    /** Gets the group Id
     * @return group Id
     */
    public int getId() {
        return id;
    }

    /** Gets the name of the group
     * @return group name
     */
    public String getName() {
        return name;
    }

    /** Sets the group name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /** Gets the description of the group
     * @return group description
     */
    public String getDescription() {
        return description;
    }

    /** Sets the group description
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /** Gets the category of the group
     * Returns group category
     */
    public String getCategory() {
        return category;
    }

    /** Sets the category of the group
     * @param category
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /** Gets the created date of the group
     * @return group created date
     */
    public Date getCreated() {
        return created;
    }

    /** Gets the Members of the group
     * @return group members, which are a list of User objects
     */
    public ArrayList getMembers() {
        return members;
    }

    /** Adds a new user to the group
     * @param newUser
     */
    public void addMember(User newUser) {
        /*TODO: Check if the user is added to the organization*/
        members.add(newUser);
    }

    /** Gets the Admins of the group
     * @return group admins list, which are a list of User objects
     */
    public ArrayList getAdmins() {
        return admins;
    }

    /** Adds a new Admin to the group
     * @param newAdmin a new user to add
     */
    public void addAdmin(User newAdmin) {
        /*TODO: Check if the User belongs to the Organization that this group belongs to*/
        admins.add(newAdmin);
    }

    /** Get the organization id that this group belongs to
     * @return organization id int
     */
    public int getOrgId() {
        return orgId;
    }

    /**
     * Set the organization id that this group belongs to
     * @param orgId organization id int
     */
    public void setOrgId(int orgId) {
        this.orgId = orgId;
    }
}
