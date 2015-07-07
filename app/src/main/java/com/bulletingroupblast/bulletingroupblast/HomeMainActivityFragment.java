package com.bulletingroupblast.bulletingroupblast;

import com.bulletingroupblast.bulletingroupblast.Organization;
import com.bulletingroupblast.bulletingroupblast.User;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import android.widget.TextView;


/**
 * A placeholder fragment containing a simple view.
 */
public class HomeMainActivityFragment extends Fragment {

    public HomeMainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //lstOrganizations.list.add()

        User testUser = new User("ruben@gmail.com", "password", "Ruben", "Piatnitsky");
        Organization testOrg = new Organization("Test Organization", "A description", testUser);

        View rootView = inflater.inflate(R.layout.fragment_home_main, container, false);

        final TextView textViewToChange = (TextView) rootView.findViewById(R.id.lblUserEmail);
        textViewToChange.setText(testUser.getEmail());

        return rootView;
    }
}
