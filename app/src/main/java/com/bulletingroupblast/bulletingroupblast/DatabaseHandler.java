/**
 * Copyright © 2015 Ruben Piatnitsky
 * This program is released under the "MIT license".
 * Please see the file LICENSE in this distribution for
 * license terms.
 */

package com.bulletingroupblast.bulletingroupblast;

import android.content.ContentValues;
import android.content.Context;
import android.database.*;
import android.database.sqlite.*;
import android.util.Log;

import com.bulletingroupblast.bulletingroupblast.Entities.Group;
import com.bulletingroupblast.bulletingroupblast.Entities.Organization;
import com.bulletingroupblast.bulletingroupblast.Entities.User;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Objects;

public class DatabaseHandler extends SQLiteOpenHelper{

    SQLiteDatabase db;

    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "BulletinGroupBlast";

    // Entity tables
    private static final String ANNOUNCEMENT_TABLE_NAME = "tblAnnouncement";
    private static final String CALENDAR_EVENT_TABLE_NAME = "tblCalendarEvent";
    private static final String CATEGORY_TABLE_NAME = "tblCategory";
    private static final String CHAT_TABLE_NAME = "tblChat";
    private static final String CHAT_MESSAGE_TABLE_NAME = "tblChatMessage";
    private static final String GROUP_TABLE_NAME = "tblGroup";
    private static final String ORGANIZATION_TABLE_NAME = "tblOrganization";
    private static final String USER_TABLE_NAME = "tblUser";

    // Tables that define the relationship between entities
    private static final String USER_ORG_TABLE_NAME = "tblUserOrgs";    // User's organizations list
    private static final String USER_ORG_GROUP_TABLE_NAME = "tblUserOrgsGroup"; // Users Group list for organizations
    private static final String GROUP_CAT_TABLE_NAME = "tblGroupCategory";
    private static final String GROUP_CHAT_TABLE_NAME = "tblGroupChat";

    private static final String[] ENTITY_TABLE_NAMES = {
            ANNOUNCEMENT_TABLE_NAME,
            CALENDAR_EVENT_TABLE_NAME,
            CATEGORY_TABLE_NAME,
            CHAT_TABLE_NAME,
            CHAT_MESSAGE_TABLE_NAME,
            GROUP_TABLE_NAME,
            ORGANIZATION_TABLE_NAME,
            USER_TABLE_NAME
    };

    private static final String[] REL_TABLE_NAMES = {
            USER_ORG_TABLE_NAME,
            USER_ORG_GROUP_TABLE_NAME,
            GROUP_CAT_TABLE_NAME,
            GROUP_CHAT_TABLE_NAME
    };

    private static String[] CREATE_TABLE_STRINGS;


    /** DEfault Constructor
     *
     * @param context context of current activity
     */
    public DatabaseHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);

        // Create Strings
        CREATE_TABLE_STRINGS = new String[] {
//                createAnnouncementTable(),
//                createCalendarEventTable(),
//                createCategoryTable(),
//                createChatTable,
//                createChatMessageTable(),
//                createGroupTable(),
                createOrganizationTable(),
                createUserTable()
        };

    }

    /** Creating the Database Tables
     * @param db database
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        for (int i = 0; i < ENTITY_TABLE_NAMES.length; i++) {
            String CREATE_TABLE = "";
            db.execSQL(CREATE_TABLE);
        }

        createUserTable();
        /*TODO: createUserOrgTable();*/
        createOrganizationTable();
        /*TODO: createGroupTable();*/
        /*TODO: createOrgGroupTable();*/
        /*TODO: createChatTable();*/
    }

    /** Updating the Database
     * @param db database
     * @param oldVersion older version value
     * @param newVersion new version value
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + "table name");

        // Create tables again
            onCreate(db);
    }


    /*TODO: Write the database class that will handle the database requests*/

    /** This function inserts values into the database
     * @param values are a list of table column names and their new values
     * @param table is the table name
     * @return an int
     */
    public boolean Insert(String table, ContentValues values) {
        boolean result;

        try {
            db = this.getWritableDatabase();
            db.insert(table, null, values);     // Insert the values
            db.close();                         // Closing database connection
            result = true;                      // Success
        } catch (Exception e) {
            Log.e(e.getCause().toString(), e.getMessage());
            result = false;
        }

        return result;
    }

    /** This function deletes a record from the database
     * takes in a delete query string
     * @return an int
     */
    public int Delete(String qry) {

        return 0;
    }

    /** This Function updates the given record
     * takes in an update string
     * @return an int value
     */
    public int Update(String qry) {

        return 0;
    }

    /** Gets one item from the database and returns it populated
     * @param obj DatabaseEntity object
     * @param id the id of the object
     * @return object
     */
    public Object getObject(DatabaseEntity obj, int id) {
        db = this.getReadableDatabase();
        String table = obj.getTableName();
        String[] cols = obj.getTableColNames();

        Cursor cursor = db.query(table, cols, cols[0] + "=" + id,
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        /* TODO: Constructor for each entity type with */
        Object newObj = new Object(); /*Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2));*/
        // return contact
        return newObj;
    }

    /** Gets a list of records from the database
     *
     * @param obj Any DatabaseEntity object
     * @param columns Array of columns to query
     * @param filter Is the WHERE part of a query (Include the WHERE)
     * @param params Array of Search parameters (column, value) to search for
     * @return ArrayList of mapped objects
     */
    public List<Object> getList(DatabaseEntity obj, String[] columns, String filter, Map<String, String> params) {

        List<Object> result = new ArrayList<>();
        Class<?> objClass = obj.getClass();
        String tableName = "";

        /*TODO: SQL select query to the database*/
        // If the object class is a Database entity, then open up the database and query it
        if ((obj.getClass().getSuperclass() == DatabaseEntity.class)) {

            // Initialize the variables
            tableName = obj.getTableName();
            db = this.getReadableDatabase();
            Cursor cursor = db.query(tableName, columns, filter, null, null, null, null, null);

            if (cursor != null) {
                cursor.moveToFirst();
            }
            //Object<cls> contact = new Object<cls>();
        }


        for (int i = 0; i < 10; i++) {
            Map<String, Object> Row = new HashMap<String, Object>();
            result.add(Row);
        }


        return result;
    }

    /** Gets a list of objects from one table in the database
     * @param tableName The table in which to do the select query
     * @param qry SQL Select query with "?" for the values in the WHERE clause.
     *            For example - "select * from tblUser WHERE name=?"
     * @param args The values for the qry WHERE "?"
     * @return {@link List} of {@link Map} <Key,Value>
     */
    /*public List<Map<String, Object>> getList(String tableName, String qry, String[] args) {
        List<Map<String,Object>> results = new List<Map<String,Object>>();

        try {
            db = this.getReadableDatabase();
            Cursor cursor = db.rawQuery(qry, args); // Run the query

            // Check the cursor first
            if (cursor != null) {
                cursor.moveToFirst();

                do { // Loop through each row returned
                    Map<String, Object> row = new HashMap<>();      // Init the row Hashmap

                    for (int i = 0; i < cursor.getColumnCount(); i++) { // Loop through each column
                        String colName = cursor.getColumnName(i);       // Get the column name
                        String colValue = cursor.getString(i);          // Get the column value
                        row.put(colName, colValue);                     // Add the values into map
                    }

                    results.add(row);       // Add the row into the list

                } while (cursor.moveToNext());
            }

        } catch(Exception ex) {
            Log.e(ex.getCause().toString(), ex.getMessage()); // Log the error
            return null;        // Return nothing if there is an error
        }

        return results;
    }*/

    /** ======================= User SQL ================== */

//    protected final String[] TABLE_COL_NAMES = {
//            "id",
//            "email",
//            "password",
//            "salt",
//            "firstName",
//            "lastName",
//            "isActive",
//            "autoLogin",
//            "dateCreated",
//            "avatarFileName"
//    };
//    protected final String[] TABLE_COL_TYPES = {
//            "INT PRIMARY KEY",
//            "VARCHAR(100)",
//            "VARCHAR(300)",
//            "VARCHAR(300)",
//            "VARCHAR(50)",
//            "VARCHAR(50)",
//            "BOOLEAN DEFAULT 1",
//            "BOOLEAN DEFAULT 1",
//            "DATETIME",
//            "TEXT"
//    };

    /** Create table string for User
     * @return string
     */
    public String createUserTable() {
        return "CREATE TABLE " + USER_TABLE_NAME + "(\n" +
                "id             INT PRIMARY KEY     NOT NULL,\n" +
                "email          VARCHAR(100)    NOT NULL,\n" +
                "password       VARCHAR(300)    NOT NULL,\n" +
                "salt           CHAR(50)        NOT NULL,\n" +
                "firstName      VARCHAR(100)    NOT NULL,\n" +
                "lastName       VARCHAR(100)    NOT NULL,\n" +
                "isActive       BOOLEAN DEFAULT 1,\n" +
                "autoLogin      BOOLEAN DEFAULT 1,\n" +
                "dateCreated    DATETIME        NOT NULL,\n" +
                "avatarFileName TEXT\n" +
                ");";
    }

    /** Remove a user with a given id
     * @param id of the user
     * @return string
     */
    public int deleteUser(int id) {
        db = this.getWritableDatabase();

        int cnt = db.delete(USER_TABLE_NAME, "id = " + id, null);
        db.close();

        return cnt;
    }

    /** Gets a user from the database and populates it
     *
     * @param id of user to get
     * @return User object
     */
    public User selectUser(int id) {
        User selUser = new User();
        String selUserQry = "SELECT * from tblUSer WHERE id = " + id + ";";

        // Set up the database query
        db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selUserQry, null);
        c.moveToFirst();

        User tempUser = new User(
                c.getInt(c.getColumnIndex("id")),
                c.getString(c.getColumnIndex("email")),
                c.getString(c.getColumnIndex("password")),
                c.getString(c.getColumnIndex("firstName")),
                c.getString(c.getColumnIndex("lastName"))
        );

        tempUser.setIsActive(Boolean.parseBoolean(c.getString(c.getColumnIndex("isActive"))));
        tempUser.setAutoLogin(Boolean.parseBoolean(c.getString(c.getColumnIndex("autoLogin"))));
        tempUser.setAvatarFileName(c.getString(c.getColumnIndex("avatarFileName")));

        db.close();
        return tempUser;
    }

    /** Get a list of Users from the database
     *
     * @param filter is a string with SQL WHERE conditions
     * @return Arraylist of Users
     */
    public ArrayList<User> selectUserArray(String filter) {
        ArrayList<User> userList = new ArrayList<>();
        String selUserQry = "SELECT * from tblUSer WHERE " + filter + ";";

        // Set up the database query
        db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selUserQry, null);
        c.moveToFirst();

        // Move through the results
        while (!c.equals(null)) {
            User tempUser = new User(
                    c.getInt(c.getColumnIndex("id")),
                    c.getString(c.getColumnIndex("email")),
                    c.getString(c.getColumnIndex("password")),
                    c.getString(c.getColumnIndex("firstName")),
                    c.getString(c.getColumnIndex("lastName"))
            );

            tempUser.setIsActive(Boolean.parseBoolean(c.getString(c.getColumnIndex("isActive"))));
            tempUser.setAutoLogin(Boolean.parseBoolean(c.getString(c.getColumnIndex("autoLogin"))));
            tempUser.setAvatarFileName(c.getString(c.getColumnIndex("avatarFileName")));
            userList.add(tempUser);
        }

        db.close();
        return userList;
    }


    /*protected final String[] TABLE_COL_NAMES = {
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
    };*/
    /** Create table string for Organization
     * @return string
     */
    public String createOrganizationTable() {
        return "CREATE TABLE " + ORGANIZATION_TABLE_NAME + "(\n" +
                "id             INT PRIMARY KEY     NOT NULL,\n" +
                "name           VARCHAR(150)    NOT NULL,\n" +
                "description    VARCHAR(300)    NOT NULL,\n" +
                "createDate     DATETIME      NOT NULL,\n" +
                "address1       VARCHAR(100),\n" +
                "address2       VARCHAR(100),\n" +
                "city           VARCHAR(50),\n" +
                "state          VARCHAR(2),\n" +
                "zipCode        VARCHAR(9)          NOT NULL,\n" +
                "websiteLink    VARCHAR(150)\n" +
                "logoFileName   VARCHAR(75)         NOT NULL,\n" +
                "isActive       BOOLEAN DEFAULT 1\n" +
                ");";

        /*CREATE TABLE [IF NOT EXISTS] "main"."/tblOrganization"
(
	"id"             INT PRIMARY KEY    AUTOINCREMENT NOT NULL,
	"name"           VARCHAR(150)    NOT NULL,
	"description"    VARCHAR(300)    NOT NULL,
	"createDate"     DATETIME      NOT NULL,
	"address1"       VARCHAR(100),
	"address2"       VARCHAR(100),
	"city"           VARCHAR(50),
	"state"          VARCHAR(2),
	"zipCode"        VARCHAR(9)          NOT NULL,
	"websiteLink"    VARCHAR(150),
	"logoFileName"   VARCHAR(75)         NOT NULL,
	"isActive"       BOOLEAN DEFAULT 1
)*/
    }

    /** Remove a user with a given id
     * @param id of the user
     * @return string
     */
    public int deleteOrganization(int id) {
        db = this.getWritableDatabase();
        int cnt = db.delete(ORGANIZATION_TABLE_NAME, "id = " + id, null);
        db.close();

        return cnt;
    }

    /** Gets a user from the database and populates it
     *
     * @param id of Organization to get
     * @return Organization object
     */
    public Organization selectOrganization(int id) {
        Organization tempOrg;
        String selOrgQry = "SELECT * from " + ORGANIZATION_TABLE_NAME + " WHERE id = " + id + ";";

        // Set up the database query
        db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selOrgQry, null);
        c.moveToFirst();

        tempOrg = new Organization(
                c.getInt(c.getColumnIndex("id")),
                c.getString(c.getColumnIndex("name")),
                c.getString(c.getColumnIndex("description"))
        );

        tempOrg.setIsActive(Boolean.parseBoolean(c.getString(c.getColumnIndex("isActive"))));
        tempOrg.setName(c.getString(c.getColumnIndex("name")));
        tempOrg.setDescription(c.getString(c.getColumnIndex("description")));
        tempOrg.setAddress1(c.getString(c.getColumnIndex("address1")));
        tempOrg.setAddress2(c.getString(c.getColumnIndex("address2")));
        tempOrg.setCity(c.getString(c.getColumnIndex("city")));
        tempOrg.setState(c.getString(c.getColumnIndex("state")));
        tempOrg.setZipCode(c.getString(c.getColumnIndex("zipCode")));
        tempOrg.setWebsiteLink(c.getString(c.getColumnIndex("websitelink")));
        tempOrg.setLogoFileName(c.getString(c.getColumnIndex("logoFileName")));

        db.close();
        return tempOrg;
    }

    /** Get a list of Organizations from the database
     *
     * @param filter is a string with SQL WHERE conditions
     * @return Arraylist of Organizations
     */
    public ArrayList<Organization> selectOrganizationArray(String filter) {
        ArrayList<Organization> orgList = new ArrayList<>();
         String selUserQry = "SELECT * from " + ORGANIZATION_TABLE_NAME + " WHERE " + filter + ";";

        // Set up the database query
        db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selUserQry, null);
        c.moveToFirst();

        // Move through the results
        while (!c.equals(null)) {
            Organization tempOrg = new Organization(
                    c.getInt(c.getColumnIndex("id")),
                    c.getString(c.getColumnIndex("name")),
                    c.getString(c.getColumnIndex("description"))
            );

            tempOrg.setIsActive(Boolean.parseBoolean(c.getString(c.getColumnIndex("isActive"))));
            tempOrg.setName(c.getString(c.getColumnIndex("name")));
            tempOrg.setDescription(c.getString(c.getColumnIndex("description")));
            tempOrg.setAddress1(c.getString(c.getColumnIndex("address1")));
            tempOrg.setAddress2(c.getString(c.getColumnIndex("address2")));
            tempOrg.setCity(c.getString(c.getColumnIndex("city")));
            tempOrg.setState(c.getString(c.getColumnIndex("state")));
            tempOrg.setZipCode(c.getString(c.getColumnIndex("zipCode")));
            tempOrg.setWebsiteLink(c.getString(c.getColumnIndex("websiteLink")));
            tempOrg.setLogoFileName(c.getString(c.getColumnIndex("logoFileName")));

            orgList.add(tempOrg);
        }

        db.close();
        return orgList;
    }

    /*protected final String[] TABLE_COL_NAMES = {
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
    };*/

    /** Create table string for Organization
     * @return string
     */
    public String createGroupTable() {
        return "CREATE TABLE " + GROUP_TABLE_NAME + "(\n" +
                "id             INT PRIMARY KEY     NOT NULL,\n" +
                "name           VARCHAR(150)        NOT NULL,\n" +
                "description    VARCHAR(300)        NOT NULL,\n" +
                "categoryId     INT                 NOT NULL\n" +
                "createDate     DATETIME            NOT NULL,\n" +
                "orgId          INT                 NOT NULL,\n" +
                "logoFileName   VARCHAR(75)         NOT NULL,\n" +
                "isActive       BOOLEAN DEFAULT 1\n" +
                ");";
    }

    /** Remove a user with a given id
     * @param id of the user
     * @return string
     */
    public int deleteGroup(int id) {
        db = this.getWritableDatabase();
        int cnt = db.delete(ORGANIZATION_TABLE_NAME, "id = " + id, null);
        db.close();

        return cnt;
    }

    /** Gets a user from the database and populates it
     *
     * @param id of Organization to get
     * @return Organization object
     */
    public Group selectGroup(int id) {
        Group tempGrp;
        String selOrgQry = "SELECT * from " + ORGANIZATION_TABLE_NAME + " WHERE id = " + id + ";";

        // Set up the database query
        db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selOrgQry, null);
        c.moveToFirst();
        //public Group(int grpId, int orgId, String name, String description, Category cat) {
        tempGrp = new Group(
                c.getInt(c.getColumnIndex("id")),
                c.getInt(c.getColumnIndex("orgId")),
                c.getString(c.getColumnIndex("name")),
                c.getString(c.getColumnIndex("description")),
                c.getInt(c.getColumnIndex("categoryId"))
        );

//        tempGrp.setIsActive(Boolean.parseBoolean(c.getString(c.getColumnIndex("isActive"))));
//        tempGrp.setName(c.getString(c.getColumnIndex("name")));
//        tempGrp.setDescription(c.getString(c.getColumnIndex("description")));
//        tempGrp.setAddress1(c.getString(c.getColumnIndex("address1")));
//        tempGrp.setAddress2(c.getString(c.getColumnIndex("address2")));
//        tempGrp.setCity(c.getString(c.getColumnIndex("city")));
//        tempGrp.setState(c.getString(c.getColumnIndex("state")));
//        tempGrp.setZipCode(c.getString(c.getColumnIndex("zipCode")));
//        tempGrp.setWebsiteLink(c.getString(c.getColumnIndex("websitelink")));
//        tempGrp.setLogoFileName(c.getString(c.getColumnIndex("logoFileName")));

        db.close();
        return tempGrp;
    }

    /** Get a list of Organizations from the database
     *
     * @param filter is a string with SQL WHERE conditions
     * @return Arraylist of Organizations
     */
    public ArrayList<Organization> selectGroupArray(String filter) {
        ArrayList<Organization> orgList = new ArrayList<>();
        String selUserQry = "SELECT * from " + ORGANIZATION_TABLE_NAME + " WHERE " + filter + ";";

        // Set up the database query
        db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selUserQry, null);
        c.moveToFirst();

        // Move through the results
        while (!c.equals(null)) {
            Organization tempOrg = new Organization(
                    c.getInt(c.getColumnIndex("id")),
                    c.getString(c.getColumnIndex("name")),
                    c.getString(c.getColumnIndex("description"))
            );

            tempOrg.setIsActive(Boolean.parseBoolean(c.getString(c.getColumnIndex("isActive"))));
            tempOrg.setName(c.getString(c.getColumnIndex("name")));
            tempOrg.setDescription(c.getString(c.getColumnIndex("description")));
            tempOrg.setAddress1(c.getString(c.getColumnIndex("address1")));
            tempOrg.setAddress2(c.getString(c.getColumnIndex("address2")));
            tempOrg.setCity(c.getString(c.getColumnIndex("city")));
            tempOrg.setState(c.getString(c.getColumnIndex("state")));
            tempOrg.setZipCode(c.getString(c.getColumnIndex("zipCode")));
            tempOrg.setWebsiteLink(c.getString(c.getColumnIndex("websiteLink")));
            tempOrg.setLogoFileName(c.getString(c.getColumnIndex("logoFileName")));

            orgList.add(tempOrg);
        }

        db.close();
        return orgList;
    }

    /*
CREATE TABLE tbl_user (
    "id" INT NOT NULL,
    "email" VARCHAR(100) NOT NULL,
    "password" VARCHAR(300) NOT NULL,
    "salt" CHAR(50) NOT NULL,
    "firstName" VARCHAR(100) NOT NULL,
    "lastName" VARCHAR(100) NOT NULL,
    "isActive" BOOLEAN DEFAULT (1),
    "autoLogin" BOOLEAN DEFAULT (1),
    "dateCreated" DATETIME NOT NULL,
    "avatarFileName" TEXT
);
CREATE TABLE sqlite_sequence(name,seq);
CREATE TABLE tbl_group (
    "id" INTEGER NOT NULL,
    "name" VARCHAR(150) NOT NULL,
    "description" VARCHAR(300) NOT NULL,
    "categoryId" INT NOT NULL,
    "createDate" DATETIME NOT NULL,
    "orgId" INT NOT NULL,
    "logoFileName" VARCHAR(75) NOT NULL,
    "isActive" BOOLEAN DEFAULT (1)
, "adminId" INTEGER  NOT NULL  DEFAULT (0));
CREATE TABLE tbl_organization (
    "id" INT NOT NULL,
    "name" VARCHAR(150) NOT NULL,
    "description" VARCHAR(300) NOT NULL,
    "createDate" DATETIME NOT NULL,
    "address1" VARCHAR(100),
    "address2" VARCHAR(100),
    "city" VARCHAR(50),
    "state" VARCHAR(2),
    "zipCode" VARCHAR(9) NOT NULL,
    "websiteLink" VARCHAR(150),
    "logoFileName" VARCHAR(75) NOT NULL,
    "isActive" BOOLEAN DEFAULT (1)
, "adminId" INTEGER  NOT NULL  DEFAULT (0));
CREATE TABLE "tbl_group_admins" (
    "id" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    "groupId" INTEGER NOT NULL,
    "userId" INTEGER NOT NULL
);
CREATE TABLE "tbl_user_organizations" (
    "id" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    "user_Id" INTEGER NOT NULL,
    "org_Id" INTEGER NOT NULL
);
CREATE TABLE "tbl_user_groups" (
    "Id" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    "user_Id" INTEGER NOT NULL,
    "group_Id" INTEGER NOT NULL
);
CREATE TABLE "tbl_organization_groups" (
    "id" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    "org_Id" INTEGER NOT NULL,
    "group_Id" INTEGER NOT NULL
);
CREATE TABLE tbl_organization_admins (
    "id" INTEGER NOT NULL,
    "org_Id" INTEGER NOT NULL,
    "user_Id" INTEGER NOT NULL
);
CREATE TABLE "tbl_category" (
    "id" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    "org_Id" INTEGER NOT NULL,
    "type" TEXT NOT NULL,
    "name" TEXT NOT NULL,
    "description" TEXT,
    "isActive" BOOLEAN true
);
CREATE TABLE "tbl_chat_messages" (
    "id" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    "chat_Id" INTEGER NOT NULL DEFAULT (0),
    "user_Id" INTEGER NOT NULL DEFAULT (0),
    "posted_date" DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    "message" TEXT NOT NULL
);
CREATE TABLE tbl_chat (
    "id" INTEGER NOT NULL,
    "group_Id" INTEGER NOT NULL DEFAULT (0),
    "initiator_Id" INTEGER NOT NULL DEFAULT (0),
    "topic" TEXT NOT NULL,
    "createdDate" DATETIME NOT NULL DEFAULT ('CURRENT_TIMESTAMP'),
    "deleted" BOOLEAN NOT NULL DEFAULT ('FALSE')
);
    */
}

