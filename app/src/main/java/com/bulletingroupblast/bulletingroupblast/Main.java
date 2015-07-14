/**
 * Copyright © 2015 Ruben Piatnitsky
 * This program is released under the "GNU license".
 * Please see the file COPYING in this distribution for
 * license terms.
 * <p>
 * Created by Ruben Piatnitsky on 7/14/15.
 */

package com.bulletingroupblast.bulletingroupblast;

import com.bulletingroupblast.bulletingroupblast.*;

public class Main {

    User userAccount;
    AppData bgb_DB;

    public Main() {
        //Check for local Data
        /*TODO: Load User if one exists locally*/

        /*TODO: Log in user automatically if user has logged in before*/

        /*TODO: Redirect new User to Create a New User Activity if no user exists*/
    }

    // Checks if a User exists and is set to autologin
    // Takes in a user
    //
    private boolean checkUserAutoLogin() {
        boolean result = false;



        return result;
    }

    // This function checks to see if any local data was saved to the device
    // Takes in nothing
    // Returns an AppData class object
    private int LoadLocalData() {
        int result = 0;     // -1 - Fail, 0 - No Local Data, 1 - Data Available and loaded,

        try {
        /*TODO: Check the local data stored on device*/
            result = 0;
            result = 1;
        } catch (Exception e) {
            /*TODO: Write to Error Log*/
            result = -1;
        }

        return result;
    }
}
