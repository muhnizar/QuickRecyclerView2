package com.example.moohn.quickrecyclerview2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by moohn on 11/12/2015.
 */
public class Contact {
    private String name;
    private boolean isOnline;

    public Contact(String name, boolean isOnline) {
        this.name = name;
        this.isOnline = isOnline;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIsOnline(boolean isOnline) {
        this.isOnline = isOnline;
    }

    public boolean isOnline() {
        return isOnline;

    }

    /*Create dummy list of data*/
    public List<Contact> createContactList(int  num){
    List<Contact> contacts = new ArrayList<Contact>();
        for (int i = 0; i < num ; i++) {
            contacts.add(new Contact("person" + i , (i%2==0? true : false)) );
        }
        return contacts;
    }
}
