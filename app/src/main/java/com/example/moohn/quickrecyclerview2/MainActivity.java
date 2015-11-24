package com.example.moohn.quickrecyclerview2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.android.supportv7.widget.decorator.DividerItemDecoration;

import jp.wasabeef.recyclerview.animators.SlideInUpAnimator;

public class MainActivity extends AppCompatActivity {
    ContactAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupViews();
    }

    private void setupViews(){

        final RecyclerView rvContacts = (RecyclerView) findViewById(R.id.rvContacts);
        adapter = new ContactAdapter(Contact.createContactList(20));

        rvContacts.setAdapter(adapter);

//      display divider between each items.
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST);
        rvContacts.addItemDecoration(itemDecoration);

        // Setup layout manager for items
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
//      Control orientation of the items
//      also supports LinearLayoutManager.HORIZONTAL
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
//      Optionally customize the position you want to default scroll to
        layoutManager.scrollToPosition(0);
//      Attach layout manager to the RecyclerView
        rvContacts.setLayoutManager(layoutManager);


        rvContacts.setItemAnimator(new SlideInUpAnimator());

//        add more contact listener
        Button addMoreButton = (Button) findViewById(R.id.add_more_contacts);
        addMoreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.addMoreContacts(new Contact("New Person ", true));
                rvContacts.scrollToPosition(0);
            }
        });
    }
}
