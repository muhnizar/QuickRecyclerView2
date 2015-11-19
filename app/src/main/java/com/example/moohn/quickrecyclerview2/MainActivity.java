package com.example.moohn.quickrecyclerview2;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

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
        rvContacts.setLayoutManager(new LinearLayoutManager(this) {
        });

//        add more contact listener
        Button addMoreButton = (Button) findViewById(R.id.add_more_contacts);
        addMoreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.addMoreContacts(new Contact("New Person ", true));
                adapter.notifyItemInserted(0);
                rvContacts.scrollToPosition(0);
            }
        });
    }
}
