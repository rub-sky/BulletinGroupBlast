package com.bulletingroupblast.bulletingroupblast;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class OrganizationActivity extends FragmentActivity {

    Organization currentOrg;
    User testUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_organization); // Need to remove because you are receiving an intent

        //Temp Data
        testUser = new User("test.test@gmail.com", "password", "Test", "User");
        Organization currentOrg = new Organization("Portland State University", "A description", testUser);
        currentOrg.setId(10);


        Intent intent = getIntent();
        String message = intent.getStringExtra(UserLandingActivity.EXTRA_MESSAGE);   // Get the string that was passed through the intent

        TextView txtOrgName = (TextView) findViewById(R.id.lblOrgName); // Get the reference to the textview
        txtOrgName.setText(message);     // Set the message

        // Creating a list view object that refers to the list view on the page
        ArrayList<String> listItems = new ArrayList<String>();
        listItems.add("Groups");
        listItems.add("Announcements");
        listItems.add("Events");

        ListView lvOverView = (ListView) findViewById(R.id.lvOrgOverViewItems); // ListView reference
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listItems);  // Adapter for the list view which is given the string array
        lvOverView.setAdapter(adapter);        // Attach the adapter to the listView

        // Attach an on click event to the list
        lvOverView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adView, View view, int position, long id) {
                // Show a message
                Toast.makeText(getBaseContext(), adView.getItemAtPosition(position) + " is selected", Toast.LENGTH_LONG).show();
            }
        });

        // load the current organization
    }

    //============================

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_organization, menu);
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
     * When the activity resumes from another activity
     */
    @Override
    public void onResume() {
        super.onResume();  // Call the superclass method

        /*TODO: Refresh the lists*/
    }

    /**
     * Go to the new Group activity
     */
    public void onClick_New_Group(View v) {
        Intent intent = new Intent(this, com.bulletingroupblast.bulletingroupblast.CreateGroupActivity.class);     // Intent is for switching to a different activity
        intent.putExtra("org_id", currentOrg.getId());
        intent.putExtra("org_name", currentOrg.getName());
        startActivity(intent);
    }

}
