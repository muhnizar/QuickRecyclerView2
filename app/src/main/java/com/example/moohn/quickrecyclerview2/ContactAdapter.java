package com.example.moohn.quickrecyclerview2;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ViewHolder>{
    private List<Contact> mContacts;

    public ContactAdapter(List<Contact> contacts) {
        mContacts = contacts;
    }

    public void addMoreContacts (Contact contact){
        mContacts.add(0, contact);
        notifyItemInserted(0);
    }

    public void remove(Contact contact ) {
        int position = mContacts.indexOf(contact);

        mContacts.remove(position);
        notifyItemRemoved(position);
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
    public void onBindViewHolder(ViewHolder holder, final int position) {

//  get the data based on position
    final Contact contact =  mContacts.get(position);

//  set item based on data model
    TextView textViewName =  holder.name;
    textViewName.setText(contact.getName());

    /*textViewName.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            remove(contact);
        }
    });*/

    /*textViewName.setOnLongClickListener(new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {
            remove(contact);
            return true;
        }
    });*/

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

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnLongClickListener
    {

        public TextView name;
        public Button msgButton;


        public ViewHolder(View itemView) {
            super(itemView);

            name = (TextView) itemView.findViewById(R.id.contact_name);
            msgButton = (Button) itemView.findViewById(R.id.message_button);

            itemView.setOnLongClickListener(this);
        }

        @Override
        public boolean onLongClick(View v) {
            int position = getLayoutPosition();
            Contact contact = mContacts.get(position);
            remove(contact);
            return true;
        }
    }

}