/**
 * Copyright © 2015 Ruben Piatnitsky
 * This program is released under the "GNU license".
 * Please see the file COPYING in this distribution for
 * license terms.
 *
 * @Author Ruben Piatnitsky
 */

package com.bulletingroupblast.bulletingroupblast;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.app.Activity;


public class MainActivity extends Activity {

    private User userAccount;
    private AppData bgb_DB;
    private Intent intentNewUser;
    private Intent intentSignIn;
    private Intent intentUserLanding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            Intent intentUserLanding = new Intent(this, com.bulletingroupblast.bulletingroupblast.UserLandingActivity.class);     // Intent is for switching to a different activity
            intentUserLanding.putExtra("com.BulletinGroupBlast.BulletinGroupBlast.UserLandingActivity", userAccount.getUserId());        // Adds the text value to the intent
            startActivity(intentUserLanding);
            //message = "SUCCESS - User " + newUser.getEmail() + " Created and Saved!";

            //Check for local Data
        /*TODO: Load User if one exists locally*/

        /*TODO: Log in user automatically if user has logged in before*/
            Intent intent = new Intent(this, com.bulletingroupblast.bulletingroupblast.CreateUserAccountActivity.class);     // Intent is for switching to a different activity
            startActivity(intentNewUser);

        /*TODO: Redirect new User to Create a New User Activity if no user exists*/
            Intent intentNewUser = new Intent(this, com.bulletingroupblast.bulletingroupblast.CreateUserAccountActivity.class);     // Intent is for switching to a different activity
            startActivity(intentNewUser);
        } catch (Exception e) {
            /*TODO: Error Log entry*/
        }
    }

    /**@apiNote Check if a User exists and is set to AutoLogin
     * @return boolean - true if success, false otherwise
     */
    private boolean checkUserAutoLogin() {
        boolean result = false;



        return result;
    }

    /**@apiNote Checks to see if any local data on the device
    * @return int -1 is Fail, 0 is No Local Data, 1 is Data Available and loaded
    */
    private int LoadLocalData() {
        int result = 0;

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
