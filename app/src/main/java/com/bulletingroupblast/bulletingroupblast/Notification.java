package com.bulletingroupblast.bulletingroupblast;

/**
 * Copyright © 2015 Ruben Piatnitsky
 * This program is released under the "GNU license".
 * Please see the file COPYING in this distribution for
 * license terms.
 * <p>
 * Created by Ruben Piatnitsky on 7/6/15.
 */


public class Notification extends DatabaseEntity {

    private final String TABLE_NAME = "tblNotification";

    /** Default Constructor
     */
    public Notification() {
        super();

        this.m_tableName = TABLE_NAME;
    }
}
