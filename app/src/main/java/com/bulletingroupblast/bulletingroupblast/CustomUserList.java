/**
 * Copyright © 2015 Ruben Piatnitsky
 * This program is released under the "GNU license".
 * Please see the file COPYING in this distribution for
 * license terms.
 *
 * Created by Ruben Piatnitsky on 7/29/15.
 */

package com.bulletingroupblast.bulletingroupblast;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bulletingroupblast.bulletingroupblast.Entities.User;

import java.util.ArrayList;


public class CustomUserList extends ArrayAdapter<User>{
    private final Activity context;
    private String[] namesList;
    private String[] emailList;
    private Integer[] imageList;
    private ArrayList<User> userList;

    /** Default Constructor
     * @param context Current activity
     * @param newUserList Array list of {@link User} objects
     */
    public CustomUserList(Activity context, ArrayList<User> newUserList) {
        super(context, R.layout.user_custom_listview, newUserList);

        this.context = context;
        this.userList = newUserList;
        int userListSize = this.userList.size();

        // Check the user list passed in
        if (this.userList != null && userListSize > 0) {

            // Initialize the image list size and name list size
            this.imageList = new Integer[userListSize];
            this.namesList = new String[userListSize];
            this.emailList = new String[userListSize];

            // Get the data
            for (int i = 0; i < userListSize; i++) {
                this.imageList[i] = this.userList.get(i).getAvatar();
                this.namesList[i] = this.userList.get(i).getFullName();
                this.emailList[i] = this.userList.get(i).getEmail();
            }
        }
    }

    /** Gets the view rendering
     *
     * @param position
     * @param view
     * @param parent
     * @return
     */
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView= inflater.inflate(R.layout.user_custom_listview, null, true);

        // Populate the image and text view objects
        TextView lblName = (TextView) rowView.findViewById(R.id.userListLblName);
        lblName.setText(namesList[position]);

        // Populate the email
        TextView lblEmail = (TextView) rowView.findViewById(R.id.userListLblEmail);
        lblEmail.setText(emailList[position]);

        // Populate the image
        ImageView imageView = (ImageView) rowView.findViewById(R.id.userListImageItem);
        imageView.setImageResource(imageList[position]);

        return rowView;
    }

}
