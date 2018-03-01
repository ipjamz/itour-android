package com.peterjamesbabiera.itour_android.views.fragments.event;

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

import java.util.ArrayList;
import java.util.List;

/**
 * Created by peter on 2/28/18.
 */

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.ViewHolder> {
    private AttractionLogic logic = AttractionLogic.getInstance();
    private List<Attraction> events = new ArrayList<>();
    private Attraction event;

    private CustomViewListener mListener;

    public EventAdapter(CustomViewListener listener) {
        this.events = logic.getEvent();
        this.mListener = listener;
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
            mListener.onClick(view, events.get(getAdapterPosition()));
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_attraction_row, parent, false);
        return new ViewHolder(view, mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        event = events.get(position);
        holder.mImage.setImageBitmap(BitmapFactory.decodeResource(ITourApplication.getContext().getResources(), event.getImageId()));
        holder.mName.setText(event.getName());
    }

    @Override
    public int getItemCount() {
        return events.size();
    }

}
