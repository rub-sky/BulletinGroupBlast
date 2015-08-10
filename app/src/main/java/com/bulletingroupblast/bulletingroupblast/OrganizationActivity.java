/**
 * Copyright © 2015 Ruben Piatnitsky
 * This program is released under the "GNU license".
 * Please see the file LICENSE in this distribution for
 * license terms.
 *
 * Created by Ruben Piatnitsky on 7/21/15.
 */

package com.bulletingroupblast.bulletingroupblast;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.widget.DrawerLayout;

import com.bulletingroupblast.bulletingroupblast.Entities.Organization;


public class OrganizationActivity extends ActionBarActivity
        implements NavigationOrganizationDrawerFragment.NavigationDrawerCallbacks {

    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */
    private NavigationOrganizationDrawerFragment mNavigationOrganizationDrawerFragment;
    private CharSequence mTitle;            // Used to store the last screen title
    private String[] mTitleList;            // The lsit of titles
    protected int mOrgId = 0;               // Organization id that is passed from User Landing
    protected Organization mOrganization;   // Organization that is selected

    public static final String GROUP_ID = "com.BulletinGroupBlast.BulletinGroupBlast.groupId";
    public static final String ORG_ID = "com.BulletinGroupBlast.BulletinGroupBlast.orgId";
    private static final String ORG_ID2 = "orgId";
    private static final String ORG_NAME = "orgName";


    /** The activty create event
     *
     * @param savedInstanceState bundle
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_organization);

        GlobalState gs = new GlobalState();
        gs.createTestData();

        mNavigationOrganizationDrawerFragment = (NavigationOrganizationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.organization_navigation_drawer);
        mTitle = getTitle();

        // Set up the drawer.
        mNavigationOrganizationDrawerFragment.setUp(R.id.organization_navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));

        // Get the organization information
        Intent intent = getIntent();

        // Get the values that were passed through the intent
        mOrgId = intent.getIntExtra(UserLandingActivity.ORG_ID, 0);
        mOrganization = gs.getCurrentUser().getOrganizationById(mOrgId);    // Get the organization
        mTitle = String.valueOf(mOrganization.getName());                   // Set the tile

        // Load the title array
        mTitleList = new String[] {
                getString(R.string.title_overview),
                getString(R.string.title_groups),
                getString(R.string.title_news),
                getString(R.string.title_events),
                getString(R.string.title_calendar),
                getString(R.string.title_users)
        };

        // Load the organization data

    }

    /** The click event for the navigation drawer list items
     * open a fragment based on selection
     * @param position navigation menu item selected index
     */
    @Override
    public void onNavigationDrawerItemSelected(int position) {
        // update the main content by replacing fragments
        android.app.Fragment fragment = null;
        Bundle args = new Bundle();     // For passing arguments


        // This is the click event switch for each menu item
        switch (position) {
            case 0:
                // Overview Fragment
                fragment = new OrganizationOverviewFragment();
                break;
            case 1:
                // Group list fragment
                fragment = new GroupItemFragment();
                break;
            case 2:
                // News list fragment
                fragment = new NewsItemFragment();
                break;
            case 3:
                // Events list fragment
                fragment = new EventItemFragment();
                break;
            case 4:
                // Calendar fragment
                fragment = new CalendarFragment();
                break;
            case 5:
                // Users fragment
                fragment = new UserItemFragment();
                break;
            default:
                // open the overview for default
                fragment = new OrganizationOverviewFragment();
                break;
        }

        // Check if fragment is valid
        if (fragment == null) {
            Log.e("OrganizationActivity", "Error in creating fragment");
        }

        // Pass organization id and name
        args.putInt(ORG_ID2, mOrgId);
        if (mOrganization != null) {
            args.putString(ORG_NAME, mOrganization.getName());
        }

        fragment.setArguments(args);
        FragmentManager fragmentManager = getFragmentManager();

        // Replace the fragment with selected fragment
        fragmentManager.beginTransaction().replace(R.id.container, fragment).commit();
    }

    /** Side menu selected item which changes the title
     * @param number the selected menu item index from navigation menu
     */
    public void onSectionAttached(int number) {
        switch (number) {
            case 1:
                mTitle = mTitleList[0];
                break;
            case 2:
                mTitle = mTitleList[1];
                break;
            case 3:
                mTitle = mTitleList[2];
                break;
            case 4:
                mTitle = mTitleList[3];
                break;
            case 5:
                mTitle = mTitleList[4];
                break;
            case 6:
                mTitle = mTitleList[5];
                break;
        }
    }

    public void restoreActionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(mTitle);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!mNavigationOrganizationDrawerFragment.isDrawerOpen()) {
            // Only show items in the action bar relevant to this screen
            // if the drawer is not showing. Otherwise, let the drawer
            // decide what to show in the action bar.
            getMenuInflater().inflate(R.menu.organization, menu);
            restoreActionBar();
            return true;
        }
        return super.onCreateOptionsMenu(menu);
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

        onNavigationDrawerItemSelected(id);

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_organization, container, false);
            return rootView;
        }

        @Override
        public void onAttach(Activity activity) {
            super.onAttach(activity);
            ((OrganizationActivity) activity).onSectionAttached(
                    getArguments().getInt(ARG_SECTION_NUMBER));
        }

        /** Set the organization session variable to the one selected
         *
         */
        private void setOrganizationSessionVariable() {
//            SharedPreferences settings = getSharedPreferences(MainActivity.SESSION_DATA, 0); // Shared Pref File
//            SharedPreferences.Editor editor = settings.edit();  // Edit the file
//            editor.putInt("selOrgId", mOrgId);          // Set the organization Id
//            editor.commit();                                    // Commit the edits!
        }


    }

}
