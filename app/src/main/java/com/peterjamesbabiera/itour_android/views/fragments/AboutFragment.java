package com.peterjamesbabiera.itour_android.views.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.peterjamesbabiera.itour_android.R;

/**
 * Created by peter on 3/2/18.
 */

public class AboutFragment extends Fragment {
    private View mMainView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        mMainView = inflater.inflate(R.layout.fragment_about, container, false);
        return mMainView;
    }

}
