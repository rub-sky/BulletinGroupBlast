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
import java.util.ArrayList;

/**
 * This class is the chat class that stores the chat data
 */
public class Chat extends DatabaseEntity{
    protected String topic;
    protected ArrayList<ChatMessage> messages;
    protected Timestamp CreatedDate;
    protected ArrayList<User> members;
    protected int group_id;
    protected int initiator_id;

    private final String TABLE_NAME = "tblChat";

    /** This is the default constructor
     * @param id
     * @param topic
     * @param members
     * @param group_id
     * @param initiator
     */
    public Chat(int id, String topic, ArrayList<User> members, int group_id, int initiator) {
        super();

        this.id = id;
        this.topic = topic;
        this.group_id = group_id;
        this.initiator_id = initiator;

        this.m_tableName = TABLE_NAME;
    }

    /** Gets the chat Topic
     * @return topic string
     */
    public String getTopic() {
        return topic;
    }

    /** Sets the chat topic
     * @param topic
     */
    public void setTopic(String topic) {
        this.topic = topic;
    }

    /** Gets the chat Messages
     * @return ChatMessage Array list
     */
    public ArrayList<ChatMessage> getMessages() {
        return messages;
    }

    /** Adds a message to the chat
     * @param message
     */
    public void addMessage(ChatMessage message) {
        message.save();
        this.messages.add(message);
    }

    /** Gets the chat created date
     * @return Timestamp
     */
    public Timestamp getCreatedDate() {
        return CreatedDate;
    }

    /** Gets the group id
     * @return int
     */
    public int getGroup_id() {
        return group_id;
    }

    /** Saves the message to the database
     */
    public void save() {
        try {

            /*TODO: Save message to the database*/
        } catch (Exception ex) {
            Log.e(ex.getCause().toString(), ex.getMessage());
        }
    }

    /** Delete the current chat from the database
     */
    public void delete() {
       try {
           /*TODO: Delete message from database*/
       } catch (Exception ex) {
           Log.e(ex.getCause().toString(), ex.getMessage());
       }
    }

    /** Creates a SQL string for the save function
     * @return save sql string
     */
    private String getSaveSqlString() {
        /*TODO: Create SQL string for save*/
        return "";
    }

    /** Creates a SQL string for the delete function
     * @return delete sql string
     */
    private String getDeleteSqlString() {
        /*TODO: Create SQL string for delete*/
        return "";
    }
}
