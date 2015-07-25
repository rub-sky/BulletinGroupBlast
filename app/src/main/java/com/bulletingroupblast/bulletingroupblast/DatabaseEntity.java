/**
 * Copyright © 2015 Ruben Piatnitsky
 * This program is released under the "GNU license".
 * Please see the file COPYING in this distribution for
 * license terms.
 *
 * Created by Ruben Piatnitsky on 7/24/15.
 */

package com.bulletingroupblast.bulletingroupblast;

import android.util.Log;

public abstract class DatabaseEntity {
    protected int id;
    protected String m_tableName;

    /** Default constructor
     */
    protected DatabaseEntity() {
        m_tableName = null;
    }


    /** Getst the object ID
     * @return int
     */
    public int getId() {
        return id;
    }

    /** Getst the table name of the object
     * @return String
     */
    public String getTableName() {
        return m_tableName;
    }

    /** Save the organization to the database
     *
     */
    public void save() {
        try {
            /*TODO: Save the organization to the database*/
        } catch (Exception ex) {
            Log.e(ex.getCause().toString(),ex.getMessage());
        }
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
        String qry = "INSERT into " + this.m_tableName + " values() where id=" + this.id;

        return result;
    }

    /** Deletes the current user from the database and initializes the variables
     * @return SQL String for Delete
     */
    public String DeleteString() {
        return "Delete from " + this.m_tableName + " where id="+this.id;
    }

    /** Populates the user from the database
     * @return boolean - true if successful, false otherwise
     */
    public String getDataFromDB() {
        return "select * from " + this.m_tableName+ " where id="+this.id;
    }
}
