/**
 * Copyright © 2015 Ruben Piatnitsky
 * This program is released under the "GNU license".
 * Please see the file COPYING in this distribution for
 * license terms.
 *
 * Created by Ruben Piatnitsky on 7/6/15.
 */

package com.bulletingroupblast.bulletingroupblast;

import java.sql.Timestamp;


public class Announcement extends DatabaseEntity{

    protected String title;
    protected String content;
    protected Timestamp created;
    protected User postedBy;

    private final String TABLE_NAME = "tblAnnouncement";

    /** Default Constructor
     */
    public Announcement() {
        super();

        this.m_tableName = TABLE_NAME;
    }

    /** Constructor with title, content, and  user posting
     * @param title
     * @param content
     * @param postedBy
     */
    public Announcement(String title, String content, User postedBy) {
        super();

        this.title = title;
        this.content = content;
        this.postedBy = postedBy;
    }

    /** Gets the title
     * @return String
     */
    public String getTitle() {
        return title;
    }

    /** Sets the title
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /** Gets the Content
     * @return String
     */
    public String getContent() {
        return content;
    }

    /** Sets the Content
     * @param content
     */
    public void setContent(String content) {
        this.content = content;
    }

    /** Gets the created date
     *
     * @return Timestamp
     */
    public Timestamp getCreated() {
        return created;
    }

    /** Sets the Timestamp
     * @param created
     */
    public void setCreated(Timestamp created) {
        this.created = created;
    }

    /** Gets the User who posted the announcement
     * @return
     */
    public User getPostedBy() {
        return postedBy;
    }

    /** Sets the Posted By User
     * @param postedBy
     */
    public void setPostedBy(User postedBy) {
        this.postedBy = postedBy;
    }
}
