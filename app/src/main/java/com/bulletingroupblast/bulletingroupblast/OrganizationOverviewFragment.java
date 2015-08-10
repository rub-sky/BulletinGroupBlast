/**
 * Copyright © 2015 Ruben Piatnitsky
 * This program is released under the "GNU license".
 * Please see the file LICENSE in this distribution for
 * license terms.
 *
 * Created by Ruben Piatnitsky on 7/29/15.
 */

package com.bulletingroupblast.bulletingroupblast;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bulletingroupblast.bulletingroupblast.Entities.Organization;
import com.bulletingroupblast.bulletingroupblast.adapter.NavListWithCounterAdapter;
import com.bulletingroupblast.bulletingroupblast.customnavlistitem.NavListItemWithCounter;
import com.bulletingroupblast.bulletingroupblast.dummy.DummyContent;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OrganizationOverviewFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link OrganizationOverviewFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class OrganizationOverviewFragment extends Fragment {
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ORG_ID = "orgId";
    private static final String ORG_NAME = "orgName";
    private ArrayList<NavListItemWithCounter> mOverviewItemsList;
    private String[] mTitleList;
//    protected ArrayAdapter mAdapter;
    protected NavListWithCounterAdapter mAdapter;
    protected ListView mListView;

    // Parameters
    private int mOrgId = 0;
    private String mOrgName;

    private OnFragmentInteractionListener mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param orgId Parameter 1.
     * @param orgName Parameter 2.
     * @return A new instance of fragment OrganizationOverviewFragment.
     */
    public static OrganizationOverviewFragment newInstance(int orgId, String orgName) {
        OrganizationOverviewFragment fragment = new OrganizationOverviewFragment();
        Bundle args = new Bundle();
        args.putInt(ORG_ID, orgId);
        args.putString(ORG_NAME, orgName);
        fragment.setArguments(args);
        return fragment;
    }

    public OrganizationOverviewFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mOrgId = getArguments().getInt(ORG_ID);
            mOrgName = getArguments().getString(ORG_NAME);
        }

        // Set the title list
        mTitleList = new String[] {
                getString(R.string.title_groups),
                getString(R.string.title_news),
                getString(R.string.title_events),
                getString(R.string.title_calendar),
                getString(R.string.title_users)
        };

        // Set the listview
        SetOverViewListItems();

    }

    /** The on Create View Event for fragment
     *
     * @param inflater {@link:LayoutInflater}
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_organization_overview, container, false);

//        mAdapter = new ArrayAdapter<DummyContent.DummyItem>(getActivity(),
//                android.R.layout.simple_list_item_1, android.R.id.text1, DummyContent.ITEMS);
        mAdapter = new NavListWithCounterAdapter(getActivity(), mOverviewItemsList);

        if (view != null) { // Check if the view is valid
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
            TextView lblOrgName = (TextView) view.findViewById(R.id.lblOrganizationName);
            lblOrgName.setText(mOrgName);
        }


        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

/*    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }*/

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
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

            /*Intent intent = new Intent(this, com.bulletingroupblast.bulletingroupblast.OrganizationActivity.class);     // Intent is for switching to a different activity
            String message = adView.getItemAtPosition(position).toString();
            intent.putExtra(EXTRA_MESSAGE, message);        // Adds the text value to the intent
            startActivity(intent);*/
        }
        catch (Exception e) {
//            Toast.makeText(v.g(), e.getMessage().toString(), Toast.LENGTH_LONG).show(); // Show a message in toast
        }
    }

    /** Sets the overview item list
     *
     */
    private void SetOverViewListItems() {
        /*getString(R.string.title_overview),
                getString(R.string.title_groups),
                getString(R.string.title_news),
                getString(R.string.title_events),
                getString(R.string.title_calendar),
                getString(R.string.title_users)*/
        mOverviewItemsList = new ArrayList<NavListItemWithCounter>();

        mOverviewItemsList.add(new NavListItemWithCounter(
                R.drawable.ic_group_work_dark, mTitleList[0],"5"));

        mOverviewItemsList.add(new NavListItemWithCounter(
                R.drawable.ic_view_list_dark, mTitleList[1],"18"));

        mOverviewItemsList.add(new NavListItemWithCounter(
                R.drawable.ic_event_dark, mTitleList[2], "10"));

        mOverviewItemsList.add(new NavListItemWithCounter(
                R.drawable.ic_perm_contact_calendar_dark, mTitleList[3]));

        mOverviewItemsList.add(new NavListItemWithCounter(
                R.drawable.ic_account_circle_black, mTitleList[4], "15"));
    }

}
