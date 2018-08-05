package com.example.irfanirfi.facebookapi;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Irfan Irfi on 9/21/2017.
 */

public class TrendingFragment extends Fragment {
    private static final String ARG_SECTION_NUMBER = "section_number";

    public TrendingFragment() {
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static TrendingFragment newInstance(int sectionNumber) {
        TrendingFragment fragment = new TrendingFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.trending, container, false);

        return rootView;
    }
}
