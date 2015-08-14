/**
 * Copyright © 2015 Ruben Piatnitsky
 * This program is released under the "MIT license".
 * Please see the file LICENSE in this distribution for
 * license terms.
 *
 * Created by Ruben Piatnitsky on 7/20/15.
 */

package com.bulletingroupblast.bulletingroupblast;

import android.app.Activity;
import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentManager;
//import android.support.v4.app.Fragment;
//import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.widget.DrawerLayout;

import com.bulletingroupblast.bulletingroupblast.Entities.Group;
import com.bulletingroupblast.bulletingroupblast.Entities.Organization;
import com.bulletingroupblast.bulletingroupblast.Entities.User;


public class GroupActivity extends ActionBarActivity
        implements NavigationGroupDrawerFragment.NavigationDrawerCallbacks {

    private static final String GRP_ID = "grpId";
    private static final String GRP_NAME = "grpName";

    private int orgId = 0;      // The passed organization id
    private int groupId = 0;    // The passed group id
    private Group newGroup;     // The new group being created
    private Group mGroup;       // Current selected group

    private GlobalState gs; // For test data

    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */
    private NavigationGroupDrawerFragment mNavigationGroupDrawerFragment;
    private CharSequence mTitle;    // Used to store the last screen title

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group);

        mNavigationGroupDrawerFragment = (NavigationGroupDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);

        mTitle = getTitle();

        // Set up the drawer.
        mNavigationGroupDrawerFragment.setUp(
                R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));

        Intent prevIntent = getIntent();
        orgId = prevIntent.getIntExtra(OrganizationActivity.ORG_ID,0);       // Get the org. id
        groupId = prevIntent.getIntExtra(OrganizationActivity.GROUP_ID,0);   // Get the group id

        // Test data
        gs = new GlobalState();
        gs.createTestData();
        User curUser = gs.getCurrentUser();
        Organization curOrg = curUser.getOrganizationById(orgId);

        // Load group data
        if (groupId > 0 && curOrg != null) {
            mGroup = curOrg.getGroupById(groupId);
            if (mGroup != null) {
                mTitle = mGroup.getName(); // Set the title
            }
        }

        Log.i("GA Org ID:", String.valueOf(orgId));
        Log.i("GA Group ID:", String.valueOf(groupId));

    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        // update the main content by replacing fragments
        Fragment fragment = null;
        Bundle args = new Bundle();     // For passing arguments

        // This is the click event switch for each menu item
        switch (position) {
            case 0:
                // Overview Fragment
                fragment = new GroupOverviewFragment();
                break;
            case 1:
                // News list fragment
                fragment = new NewsItemFragment();
                break;
            case 2:
                // Events list fragment
                fragment = new EventItemFragment();
                break;
            case 3:
                // Chat fragment
                fragment = new ChatFragment();
                break;
            case 4:
                // Users fragment
                fragment = new UserItemFragment();
                break;
            default:
                // open the overview for default
                fragment = new GroupOverviewFragment();
                break;
        }

        // Check if fragment is valid
        if (fragment == null) {
            Log.e("GroupActivity", "Error in creating fragment");
        }

        // Pass organization id and name
        args.putInt(GRP_ID, groupId);
        if (mGroup != null) {
            args.putString(GRP_NAME, mGroup.getName());
        }

        // update the main content by replacing fragments
        FragmentManager fragmentManager = this.getFragmentManager();

        // Replace the fragment with selected fragment
        fragmentManager.beginTransaction().replace(R.id.container, fragment).commit();
    }

    /** Side menu selected item which changes the title
     * @param number the selected menu item index from navigation menu
     */
    public void onSectionAttached(int number) {
        switch (number) {
            case 0:
                mTitle = getString(R.string.title_overview);
                break;
            case 1:
                mTitle = getString(R.string.title_news);
                break;
            case 2:
                mTitle = getString(R.string.title_events);
                break;
            case 3:
                mTitle = getString(R.string.title_chat);
                break;
            case 4:
                mTitle = getString(R.string.title_users);
                break;
            default:
                mTitle = getString(R.string.title_overview);
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
        if (!mNavigationGroupDrawerFragment.isDrawerOpen()) {
            // Only show items in the action bar relevant to this screen
            // if the drawer is not showing. Otherwise, let the drawer
            // decide what to show in the action bar.
            getMenuInflater().inflate(R.menu.group, menu);
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
//            View rootView = inflater.inflate(R.layout.fragment_group, container, false);
            return null;//rootView;
        }

        @Override
        public void onAttach(Activity activity) {
            super.onAttach(activity);
            ((GroupActivity) activity).onSectionAttached(
                    getArguments().getInt(ARG_SECTION_NUMBER));
        }
    }



}
