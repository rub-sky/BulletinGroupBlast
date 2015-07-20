/**
 * Copyright © 2015 Ruben Piatnitsky
 * This program is released under the "GNU license".
 * Please see the file COPYING in this distribution for
 * license terms.
 *
 * Created by Ruben Piatnitsky on 7/20/15.
 */

/*Add to given class example:
*
* public class ExampleActivity extends Activity {

        GlobalState gs;

	public void onCreate(Bundle savedInstanceState) {
              gs = (GlobalState) getApplication();
        }

        public void examples(){
            File temp = gs.getFilePath();
            if(gs.refresh()){
                gs.setRefresh(false);
             }
        }
}
* */

package com.bulletingroupblast.bulletingroupblast;

import android.app.Application;
import java.io.File;

public class GlobalState extends Application {
    public File file = null;
    boolean refresh = true;
    protected User currentUser;
    protected Organization currentOrg;
    protected Group currentGroup;

//    pictureData [] picturemarkers = null;

    /** Get the data file path
     * @return file
     */
    public File getDataFilePath(){
        return file;
    }

    /** Set a new data file path
     * @param newFilePath
     */
    public void setDataFilePath(File newFilePath){
        this.file = newFilePath;
    }

    /** Gets the picture data from the file
     * @return picture;
     */
    /*public pictureData[] getPictureData(){
        return picturemarkers;
    }

    /** Set the picture data
     * @param picData - new picture data
     */
    /*
    public void setPictureData(pictureData [] picData){
        picturemarkers = picData;
    }*/

    /** Set the refresh for the data
     * @param refresh
     */
    public void setRefresh(boolean refresh){
        this.refresh = refresh;
    }

    /** Get the refresh status
     * @return boolean
     */
    public boolean getRefresh(){
        return refresh;
    }

    /** Gets the current User
     * @return current user
     */
    public User getCurrentUser() {
        return currentUser;
    }

    /** Sets the current User
     * @param currentUser
     */
    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    /** Get the current organization
     * @return
     */
    public Organization getCurrentOrg() {
        return currentOrg;
    }

    /** Set the current organization
     * @param currentOrg
     */
    public void setCurrentOrg(Organization currentOrg) {
        this.currentOrg = currentOrg;
    }

    /** Get the current group
     * @return
     */
    public Group getCurrentGroup() {
        return currentGroup;
    }

    /** Set the current group
     * @param currentGroup
     */
    public void setCurrentGroup(Group currentGroup) {
        this.currentGroup = currentGroup;
    }
}
