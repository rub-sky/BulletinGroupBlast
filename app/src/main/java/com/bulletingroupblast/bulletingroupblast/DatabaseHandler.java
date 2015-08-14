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
    private static final String[] TABLE_NAMES = {"tblUser","tblGroup","tblOrganization","tblChat","tblAnnouncement","tblNotification","tblNotification"};
    private static final String USER_TABLE_NAME = "tblUser";

    protected final String[] TABLE_COL_NAMES = {
            "id",
            "email",
            "password",
            "salt",
            "firstName",
            "lastName",
            "isActive",
            "autoLogin",
            "dateCreated",
            "avatarFileName"
    };
    protected final String[] TABLE_COL_TYPES = {
            "INT PRIMARY KEY",
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


    public DatabaseHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    /** Creating the Database Tables
     * @param db database
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        for (int i = 0; i <TABLE_NAMES.length; i++) {
            String CREATE_TABLE = "";
            db.execSQL(CREATE_TABLE);
        }
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
        String createTblUser = "CREATE TABLE COMPANY(\n" +
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
        return createTblUser;
    }

    /** Remove a user with a given id
     * @param id of the user
     * @return string
     */
    public int removeUser(int id) {
        String delUserStr = "DELETE FROM tblUser WHERE id = " + id + ";";
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
        return selUser;
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


}

