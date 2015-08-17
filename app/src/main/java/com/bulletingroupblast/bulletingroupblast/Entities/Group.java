/**
 * Copyright © 2015 Ruben Piatnitsky
 * This program is released under the "MIT license".
 * Please see the file LICENSE in this distribution for
 * license terms.
 */

package com.bulletingroupblast.bulletingroupblast.Entities;

import android.content.ContentValues;

import java.util.ArrayList;
import java.util.Date;

import com.bulletingroupblast.bulletingroupblast.DatabaseEntity;


public class Group extends DatabaseEntity {
    protected String name;
    protected String description;
    protected int categoryId;
    protected Date created;
    protected int orgId;    // The organization id that this group belongs to
    protected boolean isActive = true;
    /*TODO: Add a keyword string*/

    protected ArrayList members;
    protected ArrayList admins;

    private final String TABLE_NAME = "tblOrganization";
    protected final String[] TABLE_COL_NAMES = {
            "id",
            "name",
            "description",
            "categoryId",
            "created",
            "orgId",
            "isActive"
    };
    protected final String[] TABLE_COL_TYPES = {
            "INTEGER PRIMARY KEY",
            "VARCHAR(150)",
            "VARCHAR(300)",
            "INTEGER",
            "DATETIME",
            "INTEGER",
            "BOOLEAN DEFAULT 1"
    };

    /*TODO: Add Chat, Announcement to variables*/
    /*TODO: avatar*/

    /** This is the default constructor for group class
     * @param name string
     * @param description string
     */
    public Group(String name, String description) {
        super();

        this.id = 0;
        this.name = name;
        this.description = description;
        this.mTableName = TABLE_NAME;

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
    public Group(int grpId, int orgId, String name, String description, Category cat, User admin) {
        super();

        this.id = grpId;
        this.orgId = orgId;
        this.name = name;
        this.description = description;
        this.categoryId = cat.getId();

        /*TODO: Initialize members, admins, chat and announcement*/
        this.admins = new ArrayList<User>();
        this.admins.add(admin);

        this.members = new ArrayList<User>();
    }


    /** Gets the name of the group
     * @return group name
     */
    public String getName() {
        return name;
    }

    /** Sets the group name
     * @param name string
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
     * @param description string
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /** Gets the category of the group
     * @return int group category
     */
    public int getCategory() {
        return categoryId;
    }

    /** Sets the category of the group
     * @param category int
     */
    public void setCategory(Category category) {
        this.categoryId = category.getId();
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

    /** Generate a value list to save into the database
     * @return ContentValues of fields in TABLE_COL_NAMES
     */
    public ContentValues getInsertFieldValues() {
        /* TABLE COLUMN NAMES
            "id",  <----- DOES NOT GET INCLUDED
            "name",
            "description",
            "categoryId",
            "created",
            "orgId",
            "isActive"
        */
        ContentValues values = new ContentValues();

        // Set the values
        values.put(TABLE_COL_NAMES[1], this.name);
        values.put(TABLE_COL_NAMES[2], this.description);
        values.put(TABLE_COL_NAMES[4], this.categoryId);
        values.put(TABLE_COL_NAMES[5], this.created.toString());
        values.put(TABLE_COL_NAMES[6], this.orgId);
        values.put(TABLE_COL_NAMES[7], this.isActive);

        return values;
    }

    /** Get the table name
     * @return string table name
     */
    public String getTableName() {
        return TABLE_NAME;
    }

    /** Get the table column names
     * @return string array
     */
    public String[] getTableColumnNames() {
        return TABLE_COL_NAMES;
    }

    /** Get the table column types
     * @return string array
     */
    public String[] getTableColumnTypes() {
        return TABLE_COL_TYPES;
    }
}
