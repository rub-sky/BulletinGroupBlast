package com.bulletingroupblast.bulletingroupblast;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Copyright © 2015 Ruben Piatnitsky
 * This program is released under the "GNU license".
 * Please see the file COPYING in this distribution for
 * license terms.
 * <p>
 * Created by Ruben Piatnitsky on 7/6/15.
 */


public class CalendarEvent extends DatabaseEntity{

    protected Date date;
    protected Time time;
    protected String Title;
    protected String Description;


    private final String TABLE_NAME = "tblCalendarEvent";

    /** default constructor
     */
    public CalendarEvent() {
        super();

        this.m_tableName = TABLE_NAME;
    }
}
