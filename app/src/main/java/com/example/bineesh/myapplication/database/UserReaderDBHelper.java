package com.example.bineesh.myapplication.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.bineesh.myapplication.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bineesh on 30/10/17.
 */

/*This is the database class which is used for creating and upgrading the tables*/
public class UserReaderDBHelper extends SQLiteOpenHelper {
    /*Database Version*/
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "user.db";/*Table Name*/

    /*Create table schema*/
    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + UserReaderContract.UserEntry.TABLE_NAME + " (" +
                    UserReaderContract.UserEntry._ID + " INTEGER PRIMARY KEY," +
                    UserReaderContract.UserEntry.COLUMN_USER_NAME + " TEXT," +
                    UserReaderContract.UserEntry.COLUMN_USER_PHONE_NUMBER + " TEXT)";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + UserReaderContract.UserEntry.TABLE_NAME;


    public UserReaderDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /*Creating the table for the first time*/
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL(SQL_CREATE_ENTRIES);

    }

    /*This below method can be used when there is a change in the database schema*/
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldversion, int newversion) {

        sqLiteDatabase.execSQL(SQL_DELETE_ENTRIES);
        onCreate(sqLiteDatabase);


    }


    public long addUserData(User user) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(UserReaderContract.UserEntry.COLUMN_USER_NAME, user.getName()); // Contact Name
        values.put(UserReaderContract.UserEntry.COLUMN_USER_PHONE_NUMBER, user.getPhoneNumber()); // Contact Phone Number

        // Inserting Row
        long savingId = db.insert(UserReaderContract.UserEntry.TABLE_NAME, null, values);
        db.close(); // Closing database connection
        return savingId;
    }


    public List<User> getAllContacts() {
        List<User> contactList = new ArrayList<User>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + UserReaderContract.UserEntry.TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                User user = new User();
                //contact.setID(Integer.parseInt(cursor.getString(0)));
                user.set_id(String.valueOf((int) cursor.getLong(
                        cursor.getColumnIndexOrThrow(UserReaderContract.UserEntry._ID))));
                user.setName(cursor.getString(1));
                user.setPhoneNumber(cursor.getString(2));
                // Adding contact to list
                contactList.add(user);
            } while (cursor.moveToNext());
        }

        // return contact list
        return contactList;
    }
}
