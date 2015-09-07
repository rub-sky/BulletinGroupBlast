/**
 * Copyright © 2015 Ruben Piatnitsky
 * This program is released under the "MIT license".
 * Please see the file LICENSE in this distribution for
 * license terms.
 *
 */

package com.bulletingroupblast.bulletingroupblast;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.bulletingroupblast.bulletingroupblast.Entities.Group;


public class CreateGroupActivity extends ActionBarActivity {
    protected Group newGroup; // This is the new group that will be created
    protected int org_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_group);

        try {
            Intent prevIntent = getIntent();
            int org_id = prevIntent.getIntExtra("org_id", 0); // Get the organization id

//            if (org_id == 0) {
            /*TODO: Throw an exception*/
                Log.i("Organization activity", String.valueOf(org_id));
//            } else {

//            }


        } catch (Exception ex) {
            Log.e(ex.getCause().toString(), ex.getMessage());
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_create_group, menu);
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

    /**
     * The click event for the Create Group Button
     * Creates a new group and then reroutes the app to user group list
     * @param v
     */
    public void onCreateGroupBtnClick(View v) {

        try {
            // Get the reference to the text views
            TextView txtOrgName = (TextView) findViewById(R.id.txtOrgName);
            TextView txtDesc = (TextView) findViewById(R.id.txtGrpDescription);
            TextView txtCategory = (TextView) findViewById(R.id.txtGrpCategory);

            // Get string values from text boxes
            String orgName = txtOrgName.getText().toString();
            String orgDesc = txtDesc.getText().toString();
            String orgCat = txtCategory.getText().toString();

            // Create a group object
            //newGroup = new Group(10, orgName, orgDesc, orgCat);

            /*TODO: Save group to database*/
            // End this activity

        } catch (Exception ex) {

        }
    }


    /**
     * The click event for adding another user to the group
     * @param v
     */
    public void onAddNewUserToGroup(View v) {
        /*TODO: open a fragment with all users for the organization*/
    }
}
