/**
 * Copyright © 2015 Ruben Piatnitsky
 * This program is released under the "GNU license".
 * Please see the file COPYING in this distribution for
 * license terms.
 *
 * Created by Ruben Piatnitsky on 7/6/15.
 */

package com.bulletingroupblast.bulletingroupblast;

import com.bulletingroupblast.bulletingroupblast.Entities.Organization;
import com.bulletingroupblast.bulletingroupblast.Entities.User;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView;
import android.content.Intent;

import java.util.ArrayList;


public class UserLandingActivity extends ActionBarActivity {
    public final static String ORG_ID = "com.BulletinGroupBlast.BulletinGroupBlast.OrganizationId";
    protected GlobalState gs;
    private ArrayList<Organization> mOrgList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_landing);

        // Global Session Variables
        gs = (GlobalState) getApplication();
        gs.createTestData();

        // Test data
        User testUser;

        // Get the passed variables from previous intent
        Intent intentPrev = getIntent();
        int passedUserId = intentPrev.getIntExtra(MainActivity.USERID_MESSAGE, 0);

        // Test Data created for interface dev
        if (passedUserId == 0) {
            testUser = new User(1, "test.test@gmail.com", "password", "Test", "User", R.drawable.image1);
        } else {
            testUser = new User(1, "John.Doe@gmail.com", "password", "John", "Doe", R.drawable.image2);
        }

        // Creating a list view object that refers to the list view on the page
        ArrayList<String> listItems = new ArrayList<String>();

        // Load the test data organizations
        mOrgList = gs.getTestOrgs();
        for (int i = 0; i < mOrgList.size(); i++) {
            listItems.add(mOrgList.get(i).getName());
        }

        ListView orgListView = (ListView) findViewById(R.id.lstOrganizations); // ListView reference
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listItems);  // Adapter for the list view which is given the string array

        orgListView.setAdapter(adapter);        // Attach the adapter to the listView
        // Attach an on click event to the list
        orgListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adView, View view, int position, long id) {
                // Show a message
//                Toast.makeText(getBaseContext(), adView.getItemAtPosition(position) + " is selected", Toast.LENGTH_LONG).show();
                onOrgListItemClick(adView, view, position, id);
            }
        });

        TextView textViewToChange = (TextView) findViewById(R.id.lblUserEmail);   // This is a reference to the email text box
        textViewToChange.setText(testUser.getEmail());  // Change the email to what I want

        // Set the image for the user
        ImageView userAvatar = (ImageView) findViewById(R.id.imgViewUserAvatar);
        userAvatar.setImageResource(testUser.getAvatar());

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_user_landing, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int itemId = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (itemId == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * Organization ListView item click event
     * @param adView adapter for the view
     * @param v the view
     * @param position the index of clicked list item
     * @param id
     */
    private void onOrgListItemClick(AdapterView<?> adView, View v, int position, long id) {
        // Move to another activity
        try {
            Intent intent = new Intent(this, com.bulletingroupblast.bulletingroupblast.OrganizationActivity.class);     // Intent is for switching to a different activity
            String message = adView.getItemAtPosition(position).toString();
            intent.putExtra(ORG_ID, mOrgList.get(position).getId());        // Adds the text value to the intent
            startActivity(intent);
        }
        catch (Exception e) {
            Toast.makeText(getBaseContext(), e.getMessage().toString(), Toast.LENGTH_LONG).show(); // Show a message in toast
        }
    }

    /**
     * Add a new organization to the user list
     * @param v
     */
    public void onNewOrgBtnClick(View v) {
        Intent intent = new Intent(this, com.bulletingroupblast.bulletingroupblast.CreateOrganizationActivity.class);     // Intent is for switching to a different activity
        startActivity(intent);
    }

    /**
     * When the activity resumes from another activity
     */
    @Override
    public void onResume() {
        super.onResume();  // Call the superclass method

        /*TODO: Refresh the organization list*/
    }

}
