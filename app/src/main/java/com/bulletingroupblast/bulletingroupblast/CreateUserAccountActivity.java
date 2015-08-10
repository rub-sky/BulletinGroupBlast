/**
 * Copyright © 2015 Ruben Piatnitsky
 * This program is released under the "GNU license".
 * Please see the file LICENSE in this distribution for
 * license terms.
 *
 * Created by Ruben Piatnitsky on 7/6/15.
 */

package com.bulletingroupblast.bulletingroupblast;

import com.bulletingroupblast.bulletingroupblast.Entities.User;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;
import android.view.View;

import java.lang.String;


public class CreateUserAccountActivity extends ActionBarActivity {

    private User newUser;   // THe new user that is being created
    public final static String USERID_MESSAGE = "com.BulletinGroupBlast.BulletinGroupBlast.UserLandingActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user_account);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_create_user_account, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /** The click event for the create New User button
     *
     * @param v - View
     */
    public void onClickCreateNewUser(View v) {
        String message = "ERROR - While Creating User";

        if (v.getId() == R.id.btnCreateUserAccount) {
            if (createNewUser()) {
                // If the user is created, then move to the landing page
                jumpToUserLanding();
            }

            // Display an Error Message
            Toast.makeText(getBaseContext(), message, Toast.LENGTH_LONG).show();
        }

    }

    /**Creates a new User account locally and then it saves it to the database
     *
     * @return boolean - true if successful, false otherwise
     */
    private boolean createNewUser() {
        boolean result = false;
        boolean txtValuesNotValid = false;

        String FName;
        String LName;
        String Email;
        String Password;

        try {
            // Get all the form field values
            EditText txtFName = (EditText) findViewById(R.id.txtFirstName);
            EditText txtLName = (EditText) findViewById(R.id.txtLastName);
            EditText txtEmail = (EditText) findViewById(R.id.txtEmail);
            EditText txtPassword = (EditText) findViewById(R.id.txtPassword);

            // Put them into string variables
            FName = txtFName.getText().toString();
            LName = txtLName.getText().toString();
            Email = txtEmail.getText().toString();

            /*TODO: Hash password to MD5*/
            Password = txtPassword.getText().toString();

            // Check the string values to see if they are not empty
            if(FName.isEmpty() || FName.contains(null)) {
                txtValuesNotValid = true;
            }
            if(LName.isEmpty() || LName.contains(null)) {
                txtValuesNotValid = true;
            }
            if(Email.isEmpty() || Email.contains(null)) {
                txtValuesNotValid = true;
            }
            if(Password.isEmpty() || Password.contains(null)) {
                txtValuesNotValid = true;
            }

            if (!txtValuesNotValid) {
                // Create a new User object
                newUser = new User(FName, LName, Email, Password);
                String qryUpdateUser = newUser.UpdateString();

                newUser.SendConfirmation();

                result = true;      // success
            }

        } catch (Exception e) {
            /*TODO: Log the error*/
            return result;
        }

        return result;
    }

    /**
     *  Redirects to the User landing Activity
     */
    public void jumpToUserLanding() {
        Intent intentUserLanding = new Intent(this, com.bulletingroupblast.bulletingroupblast.UserLandingActivity.class);     // Intent is for switching to a different activity
        intentUserLanding.putExtra(USERID_MESSAGE, newUser.getId());        // Adds the text value to the intent
        startActivity(intentUserLanding);
    }
}
