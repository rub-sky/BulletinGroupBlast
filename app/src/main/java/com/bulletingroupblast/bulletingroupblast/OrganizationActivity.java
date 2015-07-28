package com.bulletingroupblast.bulletingroupblast;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.widget.DrawerLayout;
import android.widget.Toast;


public class OrganizationActivity extends ActionBarActivity
        implements NavigationOrganizationDrawerFragment.NavigationDrawerCallbacks {

    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */
    private NavigationOrganizationDrawerFragment mNavigationOrganizationDrawerFragment;

    /**
     * Used to store the last screen title. For use in {@link #restoreActionBar()}.
     */
    private CharSequence mTitle;
    private String mOrganization;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_organization);

        mNavigationOrganizationDrawerFragment = (NavigationOrganizationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.organization_navigation_drawer);
        mTitle = getTitle();

        // Set up the drawer.
        mNavigationOrganizationDrawerFragment.setUp(
                R.id.organization_navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));

//        // Get the organization information
//        Intent intent = getIntent();
//        // Get the string that was passed through the intent
//        String message = intent.getStringExtra(UserLandingActivity.EXTRA_MESSAGE);
//        mTitle = message;   // Set the tile

    }

    /** The click event for the navagation drawer list items
     * open a fragment based on selection
     * @param position
     */
    @Override
    public void onNavigationDrawerItemSelected(int position) {
        // update the main content by replacing fragments
        Fragment fragment = null;

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
//                fragment = new NewsListFragment();
                break;
            case 3:
                // Events list fragment
//                fragment = new EventsListFragment();
                break;
            case 4:
                // Calendar fragment
//                fragment = new CalendarFragment();
                break;
            case 5:
                // Users fragment
//                fragment = new UserListFragment();
                break;
            default:
                // open the overview for default
//                fragment = new GroupOverViewFragment();
                break;
        }

        // Check if fragment is valid
        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();

            // Replace the fragment with selected fragment
            fragmentManager.beginTransaction().replace(R.id.container, fragment).commit();
        } else {
            Log.e("OrganizationActivity", "Error in creating fragment");
        }
    }

    /** Side menu selected item click
     * @param number
     */
    public void onSectionAttached(int number) {
        switch (number) {
            case 1:
                mTitle = getString(R.string.title_overview);
                break;
            case 2:
                mTitle = getString(R.string.title_groups);
                break;
            case 3:
                mTitle = getString(R.string.title_news);
                break;
            case 4:
                mTitle = getString(R.string.title_events);
                break;
            case 5:
                mTitle = getString(R.string.title_calendar);
                break;
            case 6:
                mTitle = getString(R.string.title_users);
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


//        public void onNavigationDrawerItemSelected(int position) {
//            switch (position) {
//                case 0:
//                    // Overview
//                    Log.i("Nav. Drawer position", String.valueOf(position));
//                    break;
//                case 1:
//                    Log.i("Nav. Drawer position", String.valueOf(position));
//                    // Create a new fragment and specify the list to show based on position
//                    Fragment groupListFragment = new GroupItemFragment();
//                    Bundle args = new Bundle();
//                    //args.putInt(GroupItemFragment, position); // Args that needed to be passed
//                    /*TODO: Pass the organization to fragment*/
//                    groupListFragment.setArguments(args);
//
//                    // Insert the fragment by replacing any existing fragment
//                    FragmentManager fragmentManager = getFragmentManager();
//                    fragmentManager.beginTransaction()
//                            .replace(R.id.contentPanel, groupListFragment)
//                            .commit();
//
//                    // Highlight the selected item, update the title, and close the drawer
//                    mDrawerListView.setItemChecked(position, true);
//                    getActionBar().setTitle(mTitleList[position]);
//                    mDrawerLayout.closeDrawer(mDrawerListView);
//
//                    break;
//                case 2:
//                    // Something
//                    Log.i("Nav. Drawer position", String.valueOf(position));
//                    break;
//                case 3:
//                    // Something
//                    Log.i("Nav. Drawer position", String.valueOf(position));
//                    break;
//                case 4:
//                    // Something
//                    Log.i("Nav. Drawer position", String.valueOf(position));
//                    break;
//                case 5:
//                    // Something
//                    Log.i("Nav. Drawer position", String.valueOf(position));
//                    break;
//                default:
//                    // Overview
//                    break;
//            }
//        }


//        public void onFragmentInteraction(int position) {
//
//            Log.i("Nav. Drawer position", String.valueOf(position));
//            switch (position) {
//                case 0:
//                    // Overview
//
//                    break;
//                case 1:
//                    Log.i("Nav. Drawer position", String.valueOf(position));
//                    /* Create a new fragment and specify the list to show based on position
//                    Fragment groupListFragment = new GroupItemFragment();
//                    Bundle args = new Bundle();
//                    //args.putInt(GroupItemFragment, position); // Args that needed to be passed
//                *//**//*TODO: Pass the organization to fragment*//**//*
//                    groupListFragment.setArguments(args);
//
//                    // Insert the fragment by replacing any existing fragment
//                    FragmentManager fragmentManager = getFragmentManager();
//                    fragmentManager.beginTransaction()
//                            .replace(R.id.contentPanel, groupListFragment)
//                            .commit();
//
//                    // Highlight the selected item, update the title, and close the drawer
//                    mDrawerListView.setItemChecked(position, true);
//                    getActionBar().setTitle(mTitleList[position]);
//                    mDrawerLayout.closeDrawer(mDrawerListView);
//                    break;
//                case 2:
//                    // Something
//                    Log.i("Nav. Drawer position", String.valueOf(position));
//                    break;
//                case 3:
//                    // Something
//                    Log.i("Nav. Drawer position", String.valueOf(position));
//                    break;
//                case 4:
//                    // Something
//                    Log.i("Nav. Drawer position", String.valueOf(position));
//                    break;
//                case 5:
//                    // Something
//                    Log.i("Nav. Drawer position", String.valueOf(position));
//                    break;
//                default:
//                    // Overview
//                    Log.i("Nav. Drawer position", String.valueOf(position));
//                    break;
//            }
//        }
    }

}
