package com.peterjamesbabiera.itour_android.views.fragments.site;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.peterjamesbabiera.itour_android.R;
import com.peterjamesbabiera.itour_android.data.Attraction;
import com.peterjamesbabiera.itour_android.views.CustomViewListener;
import com.peterjamesbabiera.itour_android.views.activities.DetailedSiteActivity;

/**
 * Created by peter on 2/28/18.
 */

public class SiteFragment extends Fragment implements CustomViewListener<Attraction> {
    public static final String SITE = "com.peterjamesbabiera.itour_android.site";

    private View mMainView;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        mMainView = inflater.inflate(R.layout.fragment_site, container, false);
        return mMainView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mRecyclerView = mMainView.findViewById(R.id.recycler_view);

        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new SiteAdapter(this);
        mRecyclerView.setAdapter(mAdapter);

    }

    @Override
    public void onClick(View view, Attraction object) {
        Intent intent = new Intent(getActivity(), DetailedSiteActivity.class);
        intent.putExtra(SITE, object);
        startActivity(intent);
    }
}
