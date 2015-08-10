/**
 * Copyright © 2015 Ruben Piatnitsky
 * This program is released under the "GNU license".
 * Please see the file LICENSE in this distribution for
 * license terms.
 *
 * Created by Ruben Piatnitsky on 7/24/15.
 */

package com.bulletingroupblast.bulletingroupblast;

import android.util.Log;

public abstract class DatabaseEntity {
    protected int id;
    protected String mTableName;
    protected String[] mTableColNames;
    protected String[] mTableColTypes;

    /** Default constructor
     */
    protected DatabaseEntity() {
        mTableName = null;
    }


    /** Getst the object ID
     * @return int
     */
    public int getId() {
        return id;
    }

    /** Sets the object id
     * @param id of the object
     */
    protected void setId(int id) { this.id = id; }

    /** Getst the table name of the object
     * @return String
     */
    public String getTableName() {
        return mTableName;
    }

    /** Get the table column names
     * @return string array
     */
    public String[] getTableColNames() {
        return mTableColNames;
    }

    /** Get table column types
     * @return string array
     */
    public String[] getTableColTypes() {
        return mTableColTypes;
    }

    /** Save the organization to the database
     */
    public boolean save() {
        boolean result;
        try {
            /*TODO: Save the organization to the database*/
            result = true;
        } catch (Exception ex) {
            Log.e(ex.getCause().toString(),ex.getMessage());
            result = false;
        }

        return result;
    }

    /** Delete the Organization from the database
     *
     */
    public void delete() {
        try {
            /*TODO: Delete the object from the database*/
            /*TODO: Delete all related records to the database*/
        } catch (Exception ex) {
            Log.e(ex.getCause().toString(),ex.getMessage());
        }
    }

    /** Checks the value of the given string to make sure its not null or empty
     * @param strVal String
     * @return boolean - true if string not empty or null, false otherwise
     */
    protected boolean checkStringValue(String strVal) {
        boolean success = false;

        if (strVal != null || !strVal.isEmpty()) {
            success = true;
        }

        return success;
    }

    /** Updates the current user info in the database
     * @return SQL String for Update
     */
    public String UpdateString() {
        String result = "Update";
        /*TODO: Generate an UPDATE statement*/

        return result;
    }

    /** Inserts the current user into the database
     * @return SQL String for insert
     */
    public String InsertString() {
        String result = "Insert";
        /*TODO: Generate an INSERT statement*/
        String qry = "INSERT into " + this.mTableName + " values() where id=" + this.id;

        return result;
    }

    /** Deletes the current user from the database and initializes the variables
     * @return SQL String for Delete
     */
    public String DeleteString() {
        return "Delete from " + this.mTableName + " where id="+this.id;
    }

    /** Populates the data from the database
     * @return boolean - true if successful, false otherwise
     */
    public String getData() {
        return "select * from " + this.mTableName+ " where id="+this.id;
    }
}
