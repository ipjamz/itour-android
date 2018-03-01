package com.peterjamesbabiera.itour_android.views.fragments.site;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.peterjamesbabiera.itour_android.ITourApplication;
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

public class SiteAdapter extends RecyclerView.Adapter<SiteAdapter.ViewHolder> implements View.OnClickListener {

    private AttractionLogic logic = AttractionLogic.getInstance();
    private List<Attraction> sites = new ArrayList<>();
    private Attraction site;

    private ViewGroup mViewGroup;

    private CustomViewListener mListener;

    public SiteAdapter(CustomViewListener listener) {
        this.sites = logic.getSites();
        this.mListener = listener;
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(mViewGroup.getContext(), DetailedSiteActivity.class);
        mViewGroup.getContext().startActivity(intent);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public ImageView mImage;
        public TextView mName;

        private CustomViewListener mListener;

        public ViewHolder(View itemView, CustomViewListener listener) {
            super(itemView);
            mImage = itemView.findViewById(R.id.viewImage);
            mName = itemView.findViewById(R.id.tv_name);
            mListener = listener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            mListener.onClick(view, sites.get(getAdapterPosition()));
        }
    }

    @NonNull
    @Override
    public SiteAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_attraction_row, parent, false);
        return new SiteAdapter.ViewHolder(view, mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull SiteAdapter.ViewHolder holder, int position) {
        site = sites.get(position);
        holder.mImage.setImageBitmap(BitmapFactory.decodeResource(ITourApplication.getContext().getResources(), site.getImageId()));
        holder.mName.setText(site.getName());
    }

    @Override
    public int getItemCount() {
        return sites.size();
    }

}
