package com.bulletingroupblast.bulletingroupblast;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


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
        return inflater.inflate(R.layout.fragment_home_main, container, false);
    }
}
