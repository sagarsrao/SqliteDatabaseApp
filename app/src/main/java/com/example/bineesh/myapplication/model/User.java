package com.example.bineesh.myapplication.model;

/**
 * Created by bineesh on 30/10/17.
 */

/*The below is the model class which helps in getting and setting the data to the recycler View*/
public class User {


    String _id;

    String name;

    String phoneNumber;


    public User() {

    }

    public User(String id, String name, String phoneNumber) {
        this._id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }


    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
