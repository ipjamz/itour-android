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
import com.peterjamesbabiera.itour_android.views.activities.DetailedSiteActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by peter on 2/28/18.
 */

public class SiteAdapter extends RecyclerView.Adapter<SiteAdapter.ViewHolder> implements View.OnClickListener {

    private AttractionLogic logic = AttractionLogic.getInstance();
    private List<Attraction> sites = new ArrayList<>();
    private Attraction attraction;

    private ViewGroup mViewGroup;

    public SiteAdapter() {
        sites = logic.getSites();
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(mViewGroup.getContext(), DetailedSiteActivity.class);
        mViewGroup.getContext().startActivity(intent);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView mImage;
        public TextView mName;
        public View mView;

        public ViewHolder(View itemView) {
            super(itemView);
            mView = itemView.findViewById(R.id.rv_attaction);
            mImage = itemView.findViewById(R.id.viewImage);
            mName = itemView.findViewById(R.id.tv_name);
        }
    }

    @NonNull
    @Override
    public SiteAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_attraction_row, parent, false);
        mViewGroup = parent;
        return new SiteAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SiteAdapter.ViewHolder holder, int position) {
        attraction = sites.get(position);
        holder.mImage.setImageBitmap(BitmapFactory.decodeResource(ITourApplication.getContext().getResources(), attraction.getImageId()));
        holder.mName.setText(attraction.getName());
        holder.mView.setOnClickListener(this);
    }

    @Override
    public int getItemCount() {
        return sites.size();
    }

}
