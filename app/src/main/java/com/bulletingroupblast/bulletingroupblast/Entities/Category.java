/**
 * Copyright © 2015 Ruben Piatnitsky
 * This program is released under the "GNU license".
 * Please see the file LICENSE in this distribution for
 * license terms.
 */

package com.bulletingroupblast.bulletingroupblast.Entities;

import com.bulletingroupblast.bulletingroupblast.DatabaseEntity;


public class Category extends DatabaseEntity{

    protected String type;
    protected String name;
    protected String description;
    protected int orgId = 0;
    protected boolean isActive = true;

    /** Default constructor
     * @param id record id
     * @param type the category type
     * @param name of the category
     * @param desc description of the category
     * @param orgId organization id
     */
    public Category(int id, String type, String name, String desc, int orgId) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.description = desc;
        this.orgId = orgId;
        this.isActive = true;
    }

    /** Load from DB constructor
     * @param orgId
     */
    public Category(int orgId) {
        /*TODO: load from DB*/
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getOrgId() {
        return orgId;
    }

    public void setOrgId(int orgId) {
        this.orgId = orgId;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }
}
