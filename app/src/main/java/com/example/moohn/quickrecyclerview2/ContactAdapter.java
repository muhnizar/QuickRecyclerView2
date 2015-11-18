package com.example.moohn.quickrecyclerview2;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

/**
 * Created by moohn on 11/17/2015.
 */
public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ViewHolder>{

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView name;
        public Button msgButton;


        public ViewHolder(View itemView) {
            super(itemView);

            name = (TextView) itemView.findViewById(R.id.contact_name);
            msgButton = (Button) itemView.findViewById(R.id.message_button);

        }
    }

    private List<Contact> mContact;

    public ContactAdapter(List<Contact> contacts) {
        mContact = contacts;
    }


}