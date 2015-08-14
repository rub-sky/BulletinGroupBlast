/**
 * Copyright © 2015 Ruben Piatnitsky
 * This program is released under the "MIT license".
 * Please see the file LICENSE in this distribution for
 * license terms.
 */

package com.bulletingroupblast.bulletingroupblast.Entities;

import com.bulletingroupblast.bulletingroupblast.DatabaseEntity;


public class Notification extends DatabaseEntity {

    private final String TABLE_NAME = "tblNotification";

    /** Default Constructor
     */
    public Notification() {
        super();

        this.mTableName = TABLE_NAME;
    }
}
