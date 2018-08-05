package com.example.irfanirfi.facebookapi;

//import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import android.support.v4.app.Fragment;

/**
 * Created by Irfan Irfi on 9/21/2017.
 */

public class HomeFragement extends Fragment {
    private static final String ARG_SECTION_NUMBER = "section_number";

    public HomeFragement() {
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static HomeFragement newInstance(int sectionNumber) {
        HomeFragement fragment = new HomeFragement();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.homefragment, container, false);

        return rootView;
    }
}
