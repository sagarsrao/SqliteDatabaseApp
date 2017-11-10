package com.example.bineesh.myapplication.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.bineesh.myapplication.R;
import com.example.bineesh.myapplication.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bineesh on 30/10/17.
 */

/*A simple adapter which uses the recycler View for binding the data*/
public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {


    Context mContext;

    List<User> userList = new ArrayList<>();

    /*Constructor which is used for initializing the list components*/
    public UserAdapter(Context mContext, List<User> userList) {
        this.mContext = mContext;
        this.userList = userList;
    }

    /*This method will be used for referring the layout*/
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_user, parent, false);

        return new ViewHolder(view);
    }

    /*This method will be used for binding the layout*/
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.mName.setText("My Name is:" + userList.get(position).getName());
        holder.mPhone.setText("My Phone Number is" + userList.get(position).getPhoneNumber());

    }

    /*The below method will help you in getting the total list of items that are stored in the database*/
    @Override
    public int getItemCount() {
        return userList.size();
    }


    /*The below is a inner class which holds the View and it is used for referring and binding XML
    * components required for recyclerView*/
    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView mName;

        TextView mPhone;

        public ViewHolder(View itemView) {
            super(itemView);
            mName = (TextView) itemView.findViewById(R.id.tv_name);
            mPhone = (TextView) itemView.findViewById(R.id.tv_phoneNumber);
        }
    }
}
