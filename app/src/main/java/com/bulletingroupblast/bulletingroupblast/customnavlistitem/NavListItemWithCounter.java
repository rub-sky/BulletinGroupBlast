/**
 * Copyright © 2015 Ruben Piatnitsky
 * This program is released under the "GNU license".
 * Please see the file COPYING in this distribution for
 * license terms.
 *
 * Created by Ruben Piatnitsky on 8/2/15.
 */

package com.bulletingroupblast.bulletingroupblast.customnavlistitem;


public class NavListItemWithCounter {
    private int icon;
    private String title;
    private String count = "0";
    private boolean iconVisible = true; // Toggles the visibility of the icon
    private boolean counterVisible = false; // Toggles the visibility of the counter

    /** Default Constructor
     *
     */
    public NavListItemWithCounter() { }

    /** Constructor with icon and title
     *
     * @param icon the icon to use for the list item
     * @param title the title to set for list item
     */
    public NavListItemWithCounter(int icon, String title) {
        this.icon = icon;
        this.title = title;
        this.count = "0";
        this.counterVisible = false;
    }

    /** Constructor for navListItem class with all values
     * sets default values to show icon and counter
     *
     * @param icon The icon from the project in int
     * @param title the string to appear in the list item
     * @param count the count string to place into the list item
     */
    public NavListItemWithCounter(int icon, String title, String count) {
        this.icon = icon;
        this.title = title;
        this.count = count;
        this.iconVisible = true;
        this.counterVisible = true;
    }

    /** Constructor for navListItem class with all values
     *
     * @param icon The icon from the project in int
     * @param title the string to appear in the list item
     * @param count the count string to place into the list item
     * @param isIconVisible Set the icon visible by setting to true, false otherwise
     * @param isCounterVisible Set the counter visibility - true for visibile, hidden otherwise
     */
    public NavListItemWithCounter(int icon, String title, String count, boolean isIconVisible, boolean isCounterVisible) {
        this.icon = icon;
        this.title = title;
        this.count = count;
        this.iconVisible = isIconVisible;
        this.counterVisible = isCounterVisible;
    }

    /** Get the icon for list item
     *
     * @return icon int value
     */
    public int getIcon() {
        return icon;
    }

    /** Set the list item icon
     *
     * @param icon project drawable int
     */
    public void setIcon(int icon) {
        this.icon = icon;
    }

    /** Get the title of list item
     *
     * @return string of title
     */
    public String getTitle() {
        return title;
    }

    /** Set the list item title
     *
     * @param title a string to appear in the list item
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /** Get the count for list item
     *
     * @return count for list item - returns string
     */
    public String getCount() {
        return count;
    }

    /** Set the list item counter
     *
     * @param count a string representing the count of list item
     */
    public void setCount(String count) {
        this.count = count;
    }

    /** Gets the icon visibility
     *
     * @return boolean - true if visible and false otherwise
     */
    public boolean isIconVisible() {
        return iconVisible;
    }

    /** Sets the icon visibility
     *
     * @param iconVisible - True to make icon visible, and false otherwise
     */
    public void setIconVisible(boolean iconVisible) {
        this.iconVisible = iconVisible;
    }

    /** Gets the counter visibility
     *
     * @return true if the counter is visible and false otherwise
     */
    public boolean isCounterVisible() {
        return counterVisible;
    }

    /** Sets the counter visiblily
     *
     * @param counterVisible true to set the counter visible and false otherwise
     */
    public void setCounterVisible(boolean counterVisible) {
        this.counterVisible = counterVisible;
    }
}
