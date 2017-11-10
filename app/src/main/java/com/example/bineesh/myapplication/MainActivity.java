package com.example.bineesh.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.bineesh.myapplication.adapter.UserAdapter;
import com.example.bineesh.myapplication.database.UserReaderDBHelper;
import com.example.bineesh.myapplication.model.User;

import java.util.List;

/*This is the home page which contains an menu icon and clicking on it we will goto second activity
 * and going forward it will save the data and display in a recyclerView */
public class MainActivity extends AppCompatActivity {


    UserReaderDBHelper dbHelper;

    RecyclerView myRecyclerView;
    private UserAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        myRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        dbHelper = new UserReaderDBHelper(MainActivity.this);

        List<User> userList = dbHelper.getAllContacts();

        for (User user : userList) {
            String log = "Id: " + user.get_id() + " ,Name: " + user.getName() + " ,Phone: " + user.getPhoneNumber();

            //mName.setText("My UserName is:" + user.getName());
            // mPhone.setText("My UserContact is:" + user.getPhoneNumber());
            myRecyclerView.setHasFixedSize(true);

            // use a linear layout manager
            mLayoutManager = new LinearLayoutManager(this);
            myRecyclerView.setLayoutManager(mLayoutManager);
            mAdapter = new UserAdapter(MainActivity.this, userList);
            myRecyclerView.setAdapter(mAdapter);


        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        switch (item.getItemId()) {
            case R.id.menu_add:
                startActivity(new Intent(MainActivity.this, SecondActivity.class));
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
