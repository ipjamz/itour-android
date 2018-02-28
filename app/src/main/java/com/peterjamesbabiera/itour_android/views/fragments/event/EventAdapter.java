package com.peterjamesbabiera.itour_android.views.fragments.event;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.peterjamesbabiera.itour_android.R;
import com.peterjamesbabiera.itour_android.data.Attraction;
import com.peterjamesbabiera.itour_android.logic.AttractionLogic;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by peter on 2/28/18.
 */

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.ViewHolder> implements View.OnClickListener {

    private AttractionLogic logic = AttractionLogic.getInstance();
    private List<Attraction> events = new ArrayList<>();
    private Attraction attraction;

    public EventAdapter() {
        events = logic.getEvent();
    }

    @Override
    public void onClick(View view) {
        Log.w("~~~~~~~~~Name", "");
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
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_attraction_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        attraction = events.get(position);
        holder.mImage.setImageBitmap(attraction.getImage());
        holder.mName.setText(attraction.getName());
    }

    @Override
    public int getItemCount() {
        return events.size();
    }

}
