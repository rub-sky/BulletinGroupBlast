/**
 * Copyright © 2015 Ruben Piatnitsky
 * This program is released under the "MIT license".
 * Please see the file LICENSE in this distribution for
 * license terms.
 *
 * @Author Ruben Piatnitsky
 */

package com.bulletingroupblast.bulletingroupblast;


import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;
import android.app.Fragment;
//import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.bulletingroupblast.bulletingroupblast.adapter.NavListAdapter;
import com.bulletingroupblast.bulletingroupblast.customListItems.NavListItemWithCounter;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link GroupOverviewFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GroupOverviewFragment extends Fragment {
    private static final String GRP_ID = "grpId";
    private static final String GRP_NAME = "grpName";
    private ArrayList<NavListItemWithCounter> mOverviewItemsList;
    private String[] mTitleList;
    protected NavListAdapter mAdapter;
    protected ListView mListView;

    // Parameters
    private int mGrpId = 0;
    private String mGrpName;


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param grpId Parameter 1.
     * @param grpName Parameter 2.
     * @return A new instance of fragment GroupOverviewFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static GroupOverviewFragment newInstance(int grpId, String grpName) {
        GroupOverviewFragment fragment = new GroupOverviewFragment();
        Bundle args = new Bundle();
        args.putInt(GRP_ID, grpId);
        args.putString(GRP_NAME, grpName);
        fragment.setArguments(args);
        return fragment;
    }

    public GroupOverviewFragment() {
        // Required empty public constructor
    }

    /** Create event of Fragment
     *
     * @param savedInstanceState
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mGrpId = getArguments().getInt(GRP_ID);
            mGrpName = getArguments().getString(GRP_NAME);

            Log.i("Group OV Id:", String.valueOf(mGrpId));
            Log.i("Group OV Name:", mGrpName);
        }

        // Set the title list
        mTitleList = new String[] {
                getString(R.string.title_news),
                getString(R.string.title_events),
                getString(R.string.title_chat),
                getString(R.string.title_users)
        };

        // Set the listview
        SetOverViewListItems();
    }

    /** Create view event of the Fragment
     *
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_group_overview, container, false);

        mAdapter = new NavListAdapter(getActivity(), mOverviewItemsList);

        if (view != null) {             // Check if the view is valid

            // Set the adapter
            mListView = (ListView) view.findViewById(R.id.lstOverviewItems);
            mListView.setAdapter(mAdapter);

            // Attach an on click event to the list
            mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adView, View view, int position, long id) {
                    onOrgItemClick(adView, view, position, id);  // Click event for the list
                }
            });

            // Change the Organization Name label
            TextView lblGroupName = (TextView) view.findViewById(R.id.lblGroupName);
            lblGroupName.setText(mGrpName);
        }

        return view;
    }

    /** The click event for the ListView lstGroups, opens a specific group activity
     *
     * @param adView
     * @param v
     * @param position
     * @param id
     */
    private void onOrgItemClick(AdapterView<?> adView, View v, int position, long id) {
        // Move to another activity
        try {
            // Open the group activity that was selected

            // Intent is for switching to a different activity
            /*Intent intent = new Intent(this,
                com.bulletingroupblast.bulletingroupblast.OrganizationActivity.class);

            String message = adView.getItemAtPosition(position).toString();
            intent.putExtra(EXTRA_MESSAGE, message);        // Adds the text value to the intent
            startActivity(intent);*/
            Activity myActivity = getActivity();
            FragmentManager myFragMan = myActivity.getFragmentManager();
            Fragment navFrag = myFragMan.findFragmentById(R.id.lstGroupMenu);

//            myActivity.onNa

        }
        catch (Exception e) {
//            Toast.makeText(v.g(), e.getMessage().toString(), Toast.LENGTH_LONG).show(); // Show a message in toast
        }
    }

    /** Sets the overview item list
     * The order is taken from the list of mTitleList items
     */
    private void SetOverViewListItems() {
        mOverviewItemsList = new ArrayList<>();

        // News Item
        mOverviewItemsList.add(new NavListItemWithCounter(
                R.drawable.ic_view_list_dark, mTitleList[0],"2"));

        // Events Item
        mOverviewItemsList.add(new NavListItemWithCounter(
                R.drawable.ic_event_dark, mTitleList[1], "10"));

        // Chat Item
        mOverviewItemsList.add(new NavListItemWithCounter(
                R.drawable.ic_question_answer_white, mTitleList[2]));

        // Users item
        mOverviewItemsList.add(new NavListItemWithCounter(
                R.drawable.ic_account_circle_black, mTitleList[3], "1"));

        // Set the colors for each item
        for (int i = 0; i < mOverviewItemsList.size(); i++) {
            // Set the colors
            NavListItemWithCounter item = mOverviewItemsList.get(i);

            // Set the light and dark colors
            item.setDarkTextColor(R.color.primary_text_default_material_dark);
            item.setLightTextColor(R.color.primary_text_default_material_dark);
            item.setIsTextLight(false);
        }
    }

}
