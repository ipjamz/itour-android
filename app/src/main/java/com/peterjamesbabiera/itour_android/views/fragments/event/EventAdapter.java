package com.peterjamesbabiera.itour_android.views.fragments.event;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
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

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.ViewHolder> {

    private AttractionLogic logic = AttractionLogic.getInstance();
    private List<Attraction> event = new ArrayList<>();

    public EventAdapter() {
        event = logic.getEvent();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView mImage;
        public TextView mName;

        public ViewHolder(View itemView) {
            super(itemView);

            mImage = itemView.findViewById(R.id.viewImage);
            mName = itemView.findViewById(R.id.tv_name);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_image_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.mImage.setImageBitmap(event.get(position).getImage());
        holder.mName.setText(event.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return event.size();
    }
}
