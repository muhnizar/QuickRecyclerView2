package com.example.moohn.quickrecyclerview2;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ViewHolder>{

    public void addMoreContacts (Contact contact){
        mContacts.add(0, contact);
        notifyItemInserted(0);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    Context ctx = parent.getContext();

        LayoutInflater inflater = LayoutInflater.from(ctx);

        //inflate the layout
        View contactLayout = inflater.inflate(R.layout.item_contact,parent,false);

        return new ViewHolder(contactLayout);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

//  get the data based on position
    Contact contact =  mContacts.get(position);

//  set item based on data model
    TextView textView =  holder.name;
    textView.setText(contact.getName());
    Button msgButton = holder.msgButton;

        if (contact.isOnline()){
            msgButton.setText("message");
            msgButton.setEnabled(true);
        }else {
            msgButton.setText("offline");
            msgButton.setEnabled(false);
        }
    }

    @Override
    public int getItemCount() {
        return mContacts.size();
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

    private List<Contact> mContacts;

    public ContactAdapter(List<Contact> contacts) {
        mContacts = contacts;
    }
}