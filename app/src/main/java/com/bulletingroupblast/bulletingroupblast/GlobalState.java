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
import java.util.ArrayList;

public class GlobalState extends Application {
    public File file = null;
    boolean refresh = true;
    protected User currentUser;
    protected Organization currentOrg;
    protected Group currentGroup;
    protected ArrayList<User> testUsers;
    protected ArrayList<Organization> testOrgs;
    protected ArrayList<Group> testGroups;

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

    public ArrayList<User> getTestUsers() {
        return testUsers;
    }

    public void setTestUsers(ArrayList<User> testUsers) {
        this.testUsers = testUsers;
    }

    public ArrayList<Organization> getTestOrgs() {
        return testOrgs;
    }

    public void setTestOrgs(ArrayList<Organization> testOrgs) {
        this.testOrgs = testOrgs;
    }

    public ArrayList<Group> getTestGroups() {
        return testGroups;
    }

    public void setTestGroups(ArrayList<Group> testGroups) {
        this.testGroups = testGroups;
    }

    public void createTestData() {

        testUsers = new ArrayList<User>();
        testOrgs = new ArrayList<Organization>();
        testGroups = new ArrayList<>();

        testUsers.add(new User(testUsers.size(), "John.Doe@test.gmail.com","password","John", "Doe"));
        testUsers.add(new User(testUsers.size(), "Amanda4Lang@test.gmail.com","password","Amanda", "Langley"));
        testUsers.add(new User(testUsers.size(), "FrankHops@test.gmail.com","password","Frank", "Hops"));
        testUsers.add(new User(testUsers.size(), "jane.b.Gerald@test.gmail.com","password","Jane", "Gerald"));
        testUsers.add(new User(testUsers.size(), "joeshmoe@test.hotmail.com","password","Joe", "Hajk"));
        testUsers.add(new User(testUsers.size(), "suzie@test.outlook.com","password","Sue", "Drake"));

        testOrgs.add(new Organization(testOrgs.size(),"Portland State University", "Come learn something new at Portland State University!", testUsers.get(0)));
        testOrgs.add(new Organization(testOrgs.size(),"Vancouver Lego Guild", "A description", testUsers.get(0)));
        testOrgs.add(new Organization(testOrgs.size(),"Smashing Car Show", "Come smash some cars with us", testUsers.get(1)));
        testOrgs.add(new Organization(testOrgs.size(),"Cooks on Wheels", "A club for food car owners.", testUsers.get(1)));
        testOrgs.add(new Organization(testOrgs.size(),"Cooking Club Portland", "Cooks coming together to share new techniques and recipes.", testUsers.get(2)));
        testOrgs.add(new Organization(testOrgs.size(),"Gardening Club", "A Non-Profit organization that gives people a chance to sow some seeds", testUsers.get(3)));
        testOrgs.add(new Organization(testOrgs.size(),"Gun Club Van", "Gun lovers of Vancouver coming together to learn more on gun safety and use", testUsers.get(3)));
        testOrgs.add(new Organization(testOrgs.size(),"Portland International Raceway", "Come race with us on our track!", testUsers.get(2)));

        testGroups.add(new Group(testGroups.size(),testOrgs.get(0).getId(),"Alumni","Portland State Alumni","Group Category PSU 1", testUsers.get(0)));
        testGroups.add(new Group(testGroups.size(),testOrgs.get(0).getId(),"Rocket Club","PSU Engineering Rocket Club","Engineering", testUsers.get(0)));
        testGroups.add(new Group(testGroups.size(),testOrgs.get(1).getId(),"Teenager Lego Builders","Lego builders that are teenagers","Teenager Builders", testUsers.get(0)));
        testGroups.add(new Group(testGroups.size(),testOrgs.get(1).getId(),"Adult Lego Builders","Older Lego Builders","Adult", testUsers.get(0)));
        testGroups.add(new Group(testGroups.size(),testOrgs.get(2).getId(),"Baseball Bat Smashers","People who love to smash with a baseball bat","Baseball Bat", testUsers.get(1)));
        testGroups.add(new Group(testGroups.size(),testOrgs.get(2).getId(),"Crow Bar Smashers","Love to smash things with a crow bar.","Crow Bar", testUsers.get(1)));




    }
}
