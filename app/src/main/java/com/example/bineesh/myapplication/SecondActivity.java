package com.example.bineesh.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bineesh.myapplication.database.UserReaderContract;
import com.example.bineesh.myapplication.database.UserReaderDBHelper;
import com.example.bineesh.myapplication.model.User;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity {


    private EditText mName;

    private EditText mPhone;

    private Button mSubmit;


    UserReaderDBHelper dbHelper;

    List<User> userList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        mName = (EditText) findViewById(R.id.editText_Name);
        mPhone = (EditText) findViewById(R.id.editText_Phone);
        mSubmit = (Button) findViewById(R.id.bt_Submit);
        dbHelper = new UserReaderDBHelper(SecondActivity.this);
        userList = new ArrayList<>();


        mSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (TextUtils.isEmpty(mName.getText().toString())) {

                    Toast.makeText(SecondActivity.this, "Name should not be empty", Toast.LENGTH_SHORT).show();
                }

                if (TextUtils.isEmpty(mPhone.getText().toString())) {
                    Toast.makeText(SecondActivity.this, "Phone Number should not be empty", Toast.LENGTH_SHORT).show();
                }

                String name = mName.getText().toString();

                String phoneNumber = mPhone.getText().toString();


                long result = dbHelper.addUserData(new User(UserReaderContract.UserEntry._ID, name, phoneNumber));
                if (result > 0) {

                    Toast.makeText(SecondActivity.this, "DataSuccessFullySaved", Toast.LENGTH_SHORT).show();
                    mName.setText("");
                    mPhone.setText("");
                    startActivity(new Intent(SecondActivity.this,MainActivity.class));

                } else {

                    Toast.makeText(SecondActivity.this, "Unsuccessfull operation", Toast.LENGTH_SHORT).show();
                }

            }
        });









    }


}
