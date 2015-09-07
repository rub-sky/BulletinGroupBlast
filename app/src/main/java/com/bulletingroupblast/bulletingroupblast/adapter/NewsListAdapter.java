/**
 * Copyright © 2015 Ruben Piatnitsky
 * This program is released under the "MIT license".
 * Please see the file LICENSE in this distribution for
 * license terms.
 */

package com.bulletingroupblast.bulletingroupblast.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.bulletingroupblast.bulletingroupblast.R;
import com.bulletingroupblast.bulletingroupblast.customListItems.NewsListItem;

import java.util.ArrayList;

/** This class is for the new list view
 */
public class NewsListAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<NewsListItem> listItems;

    public NewsListAdapter() {}

    /** Constructor with context and ArrayList of navListItems
     *
     * @param context context of the current activity
     * @param navItems Are the {@link:ArrayList} of {@link:navListItem}
     */
    public NewsListAdapter(Context context, ArrayList<NewsListItem> navItems) {
        this.context = context;
        this.listItems = navItems;
    }

    /** Gets the context of the the adapter
     *
     * @return context
     */
    public Context getContext() {
        return context;
    }

    /** set the context
     *
     * @param context context to set to
     */
    public void setContext(Context context) {
        this.context = context;
    }

    /** Gets the size of the list of nav items
     *
     * @return int of size of the {@link:ArrayList}
     */
    @Override
    public int getCount() {
        return this.listItems.size();
    }

    /** Get the whole news item list
     *
     * @return ArrayList of news items
     */
    public ArrayList<NewsListItem> getNewsListItems() {
        return listItems;
    }

    /** Sets the navlistItems ArrayList
     *
     * @param newsListItems {@link:ArrayList} of {@link:navLinkItem}
     */
    public void setNavListItems(ArrayList<NewsListItem> newsListItems) {
        this.listItems = newsListItems;
    }

    /** Gets the list items position
     *
     * @param position the position of the given item in the list
     * @return long of position
     */
    @Override
    public long getItemId(int position) {
        return position;
    }

    /** Gets the item at specified position
     *
     * @param position position of list item in ArrayList
     * @return object navListItem
     */
    @Override
    public Object getItem(int position) {
        return this.listItems.get(position);
    }

    /** Gets the view of the navigation list
     *
     * @param position the position of the list item
     * @param view the view of the list item
     * @param parent the parent of the list item
     * @return A view of the list item
     */
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        if (view == null) {
            LayoutInflater mInflater = (LayoutInflater)
                    context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            view = mInflater.inflate(R.layout.news_list_item, null);
        }

        // Link to actual objects in layout
        ImageView image = (ImageView) view.findViewById(R.id.news_item_image);
        TextView txtTitle = (TextView) view.findViewById(R.id.news_item_title);
        TextView txtDesc = (TextView) view.findViewById(R.id.news_item_description);

        // Get the current list item
        NewsListItem listItem = listItems.get(position);

        // Set the values for image, title and description
        image.setImageResource(listItem.getImage());    // Set the image
        txtTitle.setText(listItem.getTitle());        // Set the title
        txtDesc.setText(listItem.getDescription());      // Set the Description

        // Check if the item is light or dark and set the color
        if (listItem.isTextLight()) {

            // Check if values are empty
            if (listItem.getDarkTextColor() != 0) {
                txtTitle.setTextColor(listItem.getDarkTextColor());
            }
            if (listItem.getLightTextColor() != 0) {
                txtDesc.setTextColor(listItem.getLightTextColor());
            }
        }

        return view;
    }
}
