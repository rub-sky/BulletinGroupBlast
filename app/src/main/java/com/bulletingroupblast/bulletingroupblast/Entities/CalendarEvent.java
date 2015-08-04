/**
 * Copyright © 2015 Ruben Piatnitsky
 * This program is released under the "GNU license".
 * Please see the file COPYING in this distribution for
 * license terms.
 *
 * Created by Ruben Piatnitsky on 7/6/15.
 */

package com.bulletingroupblast.bulletingroupblast.Entities;

import com.bulletingroupblast.bulletingroupblast.DatabaseEntity;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;


public class CalendarEvent extends DatabaseEntity {

    protected Date date;
    protected Time time;
    protected String Title;
    protected String Description;

    protected int organizationId = 0;
    protected int groupId = 0;


    private final String TABLE_NAME = "tblCalendarEvent";

    /** default constructor
     */
    public CalendarEvent() {
        super();

        this.mTableName = TABLE_NAME;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    /** Get the organization Id
     * @return int of organization id
     */
    public int getOrganizationId() { return organizationId; }

    /** Set the organization Id
     * @param organizationId int
     */
    public void setOrganizationId(int organizationId) {
        this.organizationId = organizationId;
    }

    /** Get the Group id
     * @return int
     */
    public int getGroupId() { return groupId; }

    /** Set the group Id
     * @param groupId int
     */
    public void setGroupId(int groupId) { this.groupId = groupId; }
}
