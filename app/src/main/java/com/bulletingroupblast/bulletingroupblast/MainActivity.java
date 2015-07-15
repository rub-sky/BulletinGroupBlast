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
    public final static String USERID_MESSAGE = "com.BulletinGroupBlast.BulletinGroupBlast.UserLandingActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int dataAvailable = LoadLocalData();  //Check for local Data

        try {
            switch (dataAvailable) {
                case -1:
                    goToCreateNewUserAccount(); // Data Error
                    break;
                case 1:
                    goToUserLanding();          // Log user in automatically
                    break;
                default:
                    goToUserLogin();            // Go to Login page
                    break;
            }

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
            /*TODO: Load User if one exists locally*/
            userAccount = new User("John.Doe@gmail.com","password","John", "Doe");
            //result = 0;
            result = 1;
        } catch (Exception e) {
            /*TODO: Write to Error Log*/
            result = -1;
        }

        return result;
    }

    /**
     * @apiNote Opens the User Landing activity for the user
     */
    private void goToUserLanding() {
        Intent intentUserLanding = new Intent(this, com.bulletingroupblast.bulletingroupblast.UserLandingActivity.class);     // Intent is for switching to a different activity
        intentUserLanding.putExtra(USERID_MESSAGE, userAccount.getUserId());        // Adds the text value to the intent
        startActivity(intentUserLanding);
        //message = "SUCCESS - User " + newUser.getEmail() + " Created and Saved!";
    }

    /**
     * @apiNote Checks if the user needs to enter credentials or not nd redirects them to login or landing page
     */
    private void goToUserLogin() {
        if (userAccount.getAutoLogin()) {
            goToUserLanding();  // Send the user to the landing page
        } else {
            // Send the user to the login page
            Intent intentSignIn = new Intent(this, com.bulletingroupblast.bulletingroupblast.LoginActivity.class);
            startActivity(intentSignIn);
        }
    }

    /**
     * @apitNote Redirecting to create a new user account activity
     */
    private void goToCreateNewUserAccount() {
        // Send the user to create a new user account
        Intent intentNewUser = new Intent(this, com.bulletingroupblast.bulletingroupblast.CreateUserAccountActivity.class);
        startActivity(intentNewUser);
    }
}
