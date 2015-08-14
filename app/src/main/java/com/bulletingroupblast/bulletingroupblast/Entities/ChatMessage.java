/**
 * Copyright © 2015 Ruben Piatnitsky
 * This program is released under the "MIT license".
 * Please see the file LICENSE in this distribution for
 * license terms.
 *
 * Created by Ruben Piatnitsky on 7/21/15.
 */

package com.bulletingroupblast.bulletingroupblast.Entities;

import android.util.Log;

import com.bulletingroupblast.bulletingroupblast.DatabaseEntity;

import java.sql.Timestamp;

public class ChatMessage extends DatabaseEntity {
    protected int chat_id;
    protected Timestamp posted_date;
    protected String message;
    protected int userId;

    private final String TABLE_NAME = "tblChatMessage";

    /**
     * Default constructor for the message
     * @param id int
     * @param chatId int
     * @param message string
     * @param userId int
     */
    public ChatMessage(int id, int chatId, Timestamp posted_date, String message, int userId) {
        super();

        this.id = id;
        this.chat_id = chatId;
        this.posted_date = posted_date;
        this.message = message;
        this.userId = userId;

        this.mTableName = TABLE_NAME;
    }

    /** Get the message posted date
     * @return posted_date
     */
    public Timestamp getPosted_date() {
        return posted_date;
    }

    /** Get the message text
     * @return message string
     */
    public String getMessage() {
        return message;
    }

    /** Set the message text
     * @param message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /** Get the message user that posted the message
     * @return user
     */
    public int getUserId() {
        return userId;
    }

    
}
