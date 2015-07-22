/**
 * Copyright © 2015 Ruben Piatnitsky
 * This program is released under the "GNU license".
 * Please see the file COPYING in this distribution for
 * license terms.
 *
 * Created by Ruben Piatnitsky on 7/21/15.
 */

package com.bulletingroupblast.bulletingroupblast;

import android.util.Log;

import java.sql.Timestamp;

public class ChatMessage {
    protected int id;
    protected int chat_id;
    protected Timestamp posted_date;
    protected String message;
    protected User user;

    /**
     * Default constructor for the message
     * @param id
     * @param chatId
     * @param message
     * @param user
     */
    public ChatMessage(int id, int chatId, Timestamp posted_date, String message, User user) {
        this.id = id;
        this.chat_id = chatId;
        this.posted_date = posted_date;
        this.message = message;
        this.user = user;
    }

    /** Get the message id
     * @return int id
     */
    public int getId() {
        return id;
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
    public User getUser() {
        return user;
    }

    /** Saves the message to the database
     *
     */
    public void save() {
        try {
        /*TODO: Save this message to the database*/
        } catch (Exception ex) {
            Log.e(ex.getCause().toString(), ex.getMessage());
        }
    }
}
