package com.example.demo;

import com.example.demo.model.Contact;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import java.util.ArrayList;
import java.util.List;

public class Controller {

    private List<Contact> contacts;
    @FXML
    public ListView<Contact> contactList;

    public void initialize(){
        var contact1 = new Contact("john", "doe1", 123456789);
        var contact2 = new Contact("john", "doe2", 123904012);
        var contact3 = new Contact("john", "doe3", 123093473);
        var contact4 = new Contact("john", "doe4", 981341344);
        var contact5 = new Contact("john", "doe5", 983476913);
        contacts = new ArrayList<>();
        contacts.add(contact1);
        contacts.add(contact2);
        contacts.add(contact3);
        contacts.add(contact4);
        contacts.add(contact5);

        contactList.getItems().setAll(contacts);
    }

}