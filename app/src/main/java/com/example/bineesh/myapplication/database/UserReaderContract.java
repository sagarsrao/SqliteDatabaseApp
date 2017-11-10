package com.example.bineesh.myapplication.database;

import android.provider.BaseColumns;

/**
 * Created by bineesh on 30/10/17.
 */

/*This is the contract class which will be helpful in having the table name and table columns*/
public final class UserReaderContract {

    private UserReaderContract() {}

    /* Inner class that defines the table contents */
    public static class UserEntry implements BaseColumns {
        public static final String TABLE_NAME = "user";
        public static final String COLUMN_USER_NAME = "name";
        public static final String COLUMN_USER_PHONE_NUMBER = "phone";
    }
}
