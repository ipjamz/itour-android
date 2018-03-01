package com.peterjamesbabiera.itour_android.views.fragments.contact;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.peterjamesbabiera.itour_android.R;
import com.peterjamesbabiera.itour_android.data.Contact;
import com.peterjamesbabiera.itour_android.logic.ContactLogic;
import com.peterjamesbabiera.itour_android.views.CustomViewListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by peter on 3/2/18.
 */

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ViewHolder> {
    private ContactLogic logic = ContactLogic.getInstance();
    private List<Contact> contacts = new ArrayList<>();
    private Contact contact;

    private CustomViewListener mListener;

    public ContactAdapter(CustomViewListener listener) {
        this.contacts = logic.getContacts();
        this.mListener = listener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView mName;
        public TextView mNumber;

        private CustomViewListener mListener;

        public ViewHolder(View itemView, CustomViewListener listener) {
            super(itemView);
            mName = itemView.findViewById(R.id.tv_contact_person);
            mNumber = itemView.findViewById(R.id.tv_number);
            mListener = listener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            mListener.onClick(view, contacts.get(getAdapterPosition()));
        }
    }

    @NonNull
    @Override
    public ContactAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_contact_row, parent, false);
        return new ContactAdapter.ViewHolder(view, mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactAdapter.ViewHolder holder, int position) {
        contact = contacts.get(position);
        holder.mName.setText(contact.getName());
        holder.mNumber.setText(contact.getNumber());
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

}
