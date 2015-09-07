/**
 * Copyright © 2015 Ruben Piatnitsky
 * This program is released under the "MIT license".
 * Please see the file LICENSE in this distribution for
 * license terms.
 *
 */

package com.bulletingroupblast.bulletingroupblast.customListItems;

/** This class is for the news list item fragment
 *
 */
public class NewsListItem {
    private int image;
    private String title;
    private String description;

    // Values for setting the text color to light or dark
    protected int darkTextColor = 0;
    protected int lightTextColor = 0;
    protected boolean isTextLight = true;

    /** Default Constructor
     *
     */
    public NewsListItem() { }

    /** Constructor with icon and title
     *
     * @param image the icon to use for the list item
     * @param title the title to set for list item
     */
    public NewsListItem(int image, String title) {
        this.image = image;
        this.title = title;
    }

    /** Constructor for navListItem class with all values
     * sets default values to show image and text
     *
     * @param image The icon from the project in int
     * @param title the string to appear in the list item
     * @param desc The description of the item
     */
    public NewsListItem(int image, String title, String desc) {
        this.image = image;
        this.title = title;
        this.description = desc;
    }

    /** Constructor for navListItem class with all values
     *
     * @param title the string to appear in the list item
     * @param desc The description of the item
     */
    public NewsListItem(String title, String desc) {
        this.title = title;
        this.description = desc;
    }

    /** Get the image for list item
     *
     * @return image int value
     */
    public int getImage() {
        return image;
    }

    /** Set the list item image
     *
     * @param image project drawable int
     */
    public void setImage(int image) {
        this.image = image;
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

    /** Get the Description
     *
     * @return string
     */
    public String getDescription() {
        return description;
    }

    /** Set the Description
     *
     * @param description of the news item
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /** Get current Dark Text Color
     *
     * @return string of dark text color
     */
    public int getDarkTextColor() {
        return darkTextColor;
    }

    /** Set the dark text color
     *
     * @param darkTextColor Must be a hexadecimal number (ie. #C3C5C9)
     */
    public void setDarkTextColor(int darkTextColor) {
        this.darkTextColor = darkTextColor;
    }

    /** Gets the light text color
     * @return string of light text color
     */
    public int getLightTextColor() {
        return lightTextColor;
    }

    /** Sets the light text color
     * @param lightTextColor Must be a hexadecimal number (ie. #C3C5C9)
     */
    public void setLightTextColor(int lightTextColor) {
        this.lightTextColor = lightTextColor;
    }

    /** Gets the value of if the text color is light
     * @return boolean true if light color, false otherwise
     */
    public boolean isTextLight() {
        return isTextLight;
    }

    /** Sets the text to be dark colored
     *
     * @param isTextLight boolean true if light color, false for dark
     */
    public void setIsTextLight(boolean isTextLight) {
        this.isTextLight = isTextLight;
    }
}
