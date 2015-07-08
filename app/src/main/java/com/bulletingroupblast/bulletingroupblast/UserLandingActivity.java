/**
 * Copyright © 2015 Ruben Piatnitsky
 * This program is released under the "GNU license".
 * Please see the file COPYING in this distribution for
 * license terms.
 * <p>
 * Created by Ruben Piatnitsky on 7/6/15.
 */

package com.bulletingroupblast.bulletingroupblast;

import com.bulletingroupblast.bulletingroupblast.Organization;
import com.bulletingroupblast.bulletingroupblast.User;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView;

import java.util.ArrayList;


public class UserLandingActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_landing);

        // Test Data created for interface dev
        User testUser = new User("ruben@gmail.com", "password", "Ruben", "Piatnitsky");
        Organization testOrg1 = new Organization("Portland State University", "A description", testUser);
        Organization testOrg2 = new Organization("Vancouver Lego Guild", "A description", testUser);
        Organization testOrg3 = new Organization("Smashing Car Show", "A description", testUser);
        Organization testOrg4 = new Organization("Biker Gang", "A description", testUser);


        // Creating a list view object that refers to the list view on the page
        ArrayList<String> listItems = new ArrayList<String>();
        listItems.add(testOrg1.getName());
        listItems.add(testOrg2.getName());
        listItems.add(testOrg3.getName());
        listItems.add(testOrg4.getName());

        ListView orgListView = (ListView) findViewById(R.id.lstOrganizations);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listItems);

        orgListView.setAdapter(adapter);
        orgListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(), parent.getItemAtPosition(position) + " is selected", Toast.LENGTH_LONG).show();
            }
        });

        final TextView textViewToChange = (TextView) findViewById(R.id.lblUserEmail);
        textViewToChange.setText(testUser.getEmail());
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
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
