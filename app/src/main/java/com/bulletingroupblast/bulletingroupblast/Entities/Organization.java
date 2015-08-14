/**
 * Copyright © 2015 Ruben Piatnitsky
 * This program is released under the "MIT license".
 * Please see the file LICENSE in this distribution for
 * license terms.
 */
package com.bulletingroupblast.bulletingroupblast.Entities;


import android.content.ContentValues;
import android.media.Image;
import android.util.Log;

import com.bulletingroupblast.bulletingroupblast.DatabaseEntity;

import java.sql.Timestamp;
import java.util.ArrayList;

public class Organization extends DatabaseEntity {
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
    protected String logoFileName;
    protected boolean isActive = true;

    protected ArrayList<Group> groupList = new ArrayList<Group>();
    protected ArrayList<Announcement> newsList = new ArrayList<Announcement>();
    protected ArrayList<CalendarEvent> eventList = new ArrayList<CalendarEvent>();

    protected ArrayList<User> userList = new ArrayList<User>();
    protected ArrayList<User> adminList = new ArrayList<User>();

    private final String TABLE_NAME = "tblOrganization";
    protected final String[] TABLE_COL_NAMES = {
            "id",
            "name",
            "description",
            "createDate",
            "address1",
            "address2",
            "city",
            "state",
            "zipCode",
            "websiteLink",
            "logoFileName",
            "isActive"
    };
    protected final String[] TABLE_COL_TYPES = {
            "INTEGER PRIMARY KEY",
            "VARCHAR(150)",
            "VARCHAR(300)",
            "DATETIME",
            "VARCHAR(100)",
            "VARCHAR(100)",
            "VARCHAR(50)",
            "VARCHAR(2)",
            "VARCHAR(9)",
            "VARCHAR(150)",
            "VARCHAR(75)",
            "BOOLEAN DEFAULT 1"
    };

    /** Gets the organization with a specified id
     * @param id of the organization
     */
    public Organization(int id) {
        /*TODO: Load data from Database*/

    }

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

    /** Gets the organization by the index number
     * @param index of the organization in the list
     * @return Organization object
     */
    public Group getGroupByIndex(int index) {

        // Check if any organizations exist
        if (groupList.size() > 0) {
            // If the index is in range then return it
            if (index >= 0 && index < groupList.size()) {
                return groupList.get(index);
            }
        }
        return null;
    }

    /** Get the organization by id
     * @param id of the organization
     * @return organization if exists or null otherwise
     */
    public Group getGroupById(int id) {

        // Check if any organizations exist
        if (groupList.size() > 0) {
            //Loop through all organizations
            for (int i = 0; i < groupList.size(); i++) {
                Group grp = groupList.get(i);
                // Check if the id matches
                if (grp.getId() == id) {
                    return grp;     // match
                }
            }
        }
        return null;
    }

    /** Gets the organization group list
     * @return Arraylist of groups
     */
    public ArrayList<Group> getGroupList() {
        return groupList;
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

    /** Gets the logo filename
     * @return
     */
    public String getLogoFileName() {
        return logoFileName;
    }

    /** Sets the logo filename
     * @param logoFileName string
     */
    public void setLogoFileName(String logoFileName) {
        this.logoFileName = logoFileName;
    }

    /** Get the news list for organization
     * @return ArrayList of Announcements
     */
    public ArrayList<Announcement> getNewsList() {
        return newsList;
    }

    /** Sets the News list to array list
     * @param newsList array list of Announcements
     */
    public void setNewsList(ArrayList<Announcement> newsList) {
        this.newsList = newsList;
    }

    /** Add a news item to organization
     * @param announce and announcement object
     */
    public void addNews(Announcement announce) {
        announce.setOrganizationId(this.id);
        /*TODO: Save the announcement to database first */
        this.newsList.add(announce);
    }

    /** Removes the event from the event list
     * @param event CalendarEvent to remove
     * @return int -1 if DB remove fail, 0 if list remove fail, and 1 otherwise
     */
    public int removeNews(Announcement event) {
        int result = -1; // Fail by default

        /*TODO: Delete news from the database*/

        // Remove the event from the list
        if (this.newsList.remove(event)) {
            result = 0;
        }

        return result;
    }

    /** Gets the event list
     * @return array list of calendar events
     */
    public ArrayList<CalendarEvent> getEventList() {
        return eventList;
    }

    /** Sets the array list of calendar events
     * @param eventList asrray list of Calendar events
     */
    public void setEventList(ArrayList<CalendarEvent> eventList) {
        this.eventList = eventList;
    }

    /** Add an item to the event list
     * @param event CalendarEvent item
     */
    public void addEvent(CalendarEvent event) {
        event.setOrganizationId(this.id);
        /*TODO: Save event to database*/
        this.eventList.add(event);
    }

    /** Removes the event from the event list
     * @param event CalendarEvent to remove
     * @return int -1 if DB remove fail, 0 if list remove fail, and 1 otherwise
     */
    public int removeEvent(CalendarEvent event) {
        int result = -1; // Fail by default

        /*TODO: Delete event from the database*/

        // Remove the event from the list
        if (this.eventList.remove(event)) {
            result = 0;
        }

        return result;
    }

    /** Generate a value list to save into the database
     * @return ContentValues of fields in TABLE_COL_NAMES
     */
    public ContentValues getInsertFieldValues() {
        /* TABLE COLUMN NAMES
            "id",  <----- DOES NOT GET INCLUDED
            "name",
            "description",
            "createDate",
            "address1",
            "address2",
            "city",
            "state",
            "zipCode",
            "websiteLink",
            "logoFileName",
            "isActive"
        */
        ContentValues values = new ContentValues();

        // Set the values
        values.put(TABLE_COL_NAMES[1], this.name);
        values.put(TABLE_COL_NAMES[2], this.description);
        values.put(TABLE_COL_NAMES[3], this.createdDate.toString());
        values.put(TABLE_COL_NAMES[4], this.address1);
        values.put(TABLE_COL_NAMES[5], this.address2);
        values.put(TABLE_COL_NAMES[6], this.city);
        values.put(TABLE_COL_NAMES[7], this.state);
        values.put(TABLE_COL_NAMES[8], this.zipCode);
        values.put(TABLE_COL_NAMES[9], this.websiteLink);
        values.put(TABLE_COL_NAMES[10], this.logoFileName);
        values.put(TABLE_COL_NAMES[11], this.isActive);

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
