/**
 * Copyright © 2015 Ruben Piatnitsky
 * This program is released under the "GNU license".
 * Please see the file COPYING in this distribution for
 * license terms.
 *
 * Created by Ruben Piatnitsky on 7/29/15.
 */

package com.bulletingroupblast.bulletingroupblast;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
//import android.app.Fragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bulletingroupblast.bulletingroupblast.dummy.DummyContent;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OrganizationOverviewFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link OrganizationOverviewFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class OrganizationOverviewFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    protected ArrayAdapter mAdapter;
    protected ListView mListView;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment OrganizationOverviewFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static OrganizationOverviewFragment newInstance(String param1, String param2) {
        OrganizationOverviewFragment fragment = new OrganizationOverviewFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
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
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }


    }

    /** THe on Create View Event for fragment
     *
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_organization_overview, container, false);

        mAdapter = new ArrayAdapter<DummyContent.DummyItem>(getActivity(),
                android.R.layout.simple_list_item_1, android.R.id.text1, DummyContent.ITEMS);

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
            lblOrgName.setText(mParam1);
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

}
