package com.peterjamesbabiera.itour_android.views.fragments.site;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.peterjamesbabiera.itour_android.R;
import com.peterjamesbabiera.itour_android.data.Attraction;
import com.peterjamesbabiera.itour_android.logic.AttractionLogic;
import com.peterjamesbabiera.itour_android.views.CustomViewListener;
import com.peterjamesbabiera.itour_android.views.activities.DetailedSiteActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by peter on 2/28/18.
 */

public class SiteFragment extends Fragment implements CustomViewListener<Attraction> {
    public static final String SITE = "com.peterjamesbabiera.itour_android.site";

    private View mMainView;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private List<Attraction> sites = new ArrayList<>();
    private List<Attraction> filteredSites = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        mMainView = inflater.inflate(R.layout.fragment_site, container, false);
        setHasOptionsMenu(true);
        return mMainView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mRecyclerView = mMainView.findViewById(R.id.recycler_view);

        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        sites = AttractionLogic.getInstance().getSites();

        mAdapter = new SiteAdapter(this, sites);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onClick(View view, Attraction object) {
        Intent intent = new Intent(getActivity(), DetailedSiteActivity.class);
        intent.putExtra(SITE, object);
        startActivity(intent);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_category, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_menu_all_sites:
                return true;
            case R.id.action_menu_churches:
                filterSites("church");
                return true;
            case R.id.action_menu_real_estate:
                filterSites("real estate");
                return true;
            case R.id.action_menu_historic:
                filterSites("historic");
                return true;
            case R.id.action_menu_night_life:
                filterSites("night life");
                return true;
            case R.id.action_menu_promenade:
                filterSites("promenade");
                return true;
            case R.id.actionmenu_delicacies:
                filterSites("delicacies");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void filterSites(String category) {
        filteredSites.clear();
        for (Attraction site : sites) {
            if (site.getCategory().equals(category))
                filteredSites.add(site);
        }
        mRecyclerView.setAdapter(new SiteAdapter(this, filteredSites));
    }
}