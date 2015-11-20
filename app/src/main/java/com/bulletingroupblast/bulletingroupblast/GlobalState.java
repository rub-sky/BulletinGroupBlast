/**
 * Copyright © 2015 Ruben Piatnitsky
 * This program is released under the "MIT license".
 * Please see the file LICENSE in this distribution for
 * license terms.
 *
 */


package com.bulletingroupblast.bulletingroupblast;

import android.app.Application;

import com.bulletingroupblast.bulletingroupblast.Entities.Category;
import com.bulletingroupblast.bulletingroupblast.Entities.Group;
import com.bulletingroupblast.bulletingroupblast.Entities.Organization;
import com.bulletingroupblast.bulletingroupblast.Entities.User;

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
    protected ArrayList<Category> testCategory;
    protected Integer[] userImageList;
    protected String[] userNameList;

    /** Default Constructor
     *
     */
    public GlobalState() {

        createTestData();

    }

//    pictureData [] pictureA = null;

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
        return picture;
    }

    /** Set the picture data
     * @param picData - new picture data
     */
    /*
    public void setPictureData(pictureData [] picData){
        pictureA = picData;
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

    public Integer[] getUserImageList() { return userImageList; }

    public void setUserImageList(Integer[] imageList) { this.userImageList = imageList; }

    public String[] getUserNameList() { return userNameList; }

    public void setUserNameList(String[] userNameList) { this.userNameList = userNameList; }

    public ArrayList<Category> getTestCategory() {
        return testCategory;
    }

    public void setTestCategory(ArrayList<Category> testCategory) {
        this.testCategory = testCategory;
    }

    public void createTestData() {

        testUsers = new ArrayList<User>();
        testOrgs = new ArrayList<Organization>();
        testGroups = new ArrayList<Group>();
        testCategory = new ArrayList<Category>();
        User primeUser = new User(testUsers.size()+1, "John.Doe@test.gmail.com","password","John", "Doe", R.drawable.ic_face_dark);
        primeUser.setId(125);

        testUsers.add(primeUser);
        testUsers.add(new User(testUsers.size()+1, "Amanda4Lang@test.gmail.com","password","Amanda", "Langley", R.drawable.ic_face_dark));
        testUsers.add(new User(testUsers.size()+1, "FrankHops@test.gmail.com","password","Frank", "Hops", R.drawable.ic_face_dark));
        testUsers.add(new User(testUsers.size()+1, "jane.b.Gerald@test.gmail.com","password","Jane", "Gerald", R.drawable.ic_face_dark));
        testUsers.add(new User(testUsers.size()+1, "joeshmoe@test.hotmail.com","password","Joe", "Hajk", R.drawable.ic_face_dark));
        testUsers.add(new User(testUsers.size()+1, "suzie@test.outlook.com","password","Sue", "Drake", R.drawable.ic_face_dark));

        userNameList = new String[testUsers.size()];
        userImageList = new Integer[testUsers.size()];

        for (int i = 0; i < testUsers.size(); i++) {
            userNameList[i] = testUsers.get(i).getFirstName() + " " + testUsers.get(i).getLastName();
            userImageList[i] = testUsers.get(i).getAvatar();
        }

        Organization psuOrg = new Organization(345,"Portland State University", "Come learn something new at Portland State University!", primeUser);
        Organization foodcart = new Organization(238,"Portland Food Cart Organization","Food cart owners coming together.",primeUser);



        testOrgs.add(psuOrg);
        testOrgs.add(foodcart);
        testOrgs.add(new Organization(testOrgs.size()+1,"Vancouver Lego Guild", "A description", testUsers.get(0)));
        testOrgs.add(new Organization(testOrgs.size()+1,"Smashing Car Show", "Come smash some cars with us", testUsers.get(1)));
        testOrgs.add(new Organization(testOrgs.size()+1,"Cooks on Wheels", "A club for food car owners.", testUsers.get(1)));
        testOrgs.add(new Organization(testOrgs.size()+1,"Cooking Club Portland", "Cooks coming together to share new techniques and recipes.", testUsers.get(2)));
        testOrgs.add(new Organization(testOrgs.size()+1,"Gardening Club", "A Non-Profit organization that gives people a chance to sow some seeds", testUsers.get(3)));
        testOrgs.add(new Organization(testOrgs.size()+1,"Gun Club Van", "Gun lovers of Vancouver coming together to learn more on gun safety and use", testUsers.get(3)));
        testOrgs.add(new Organization(testOrgs.size()+1, "Portland International Raceway", "Come race with us on our track!", testUsers.get(2)));

        // Some temporary categories
        Category lang = new Category(45,"Lang","Language","Language practice for freshman",psuOrg.getId());
        Category engr = new Category(46,"Engr","Engineering","Engineering projects.",psuOrg.getId());
        Category oss = new Category(47,"OSS","Open Source","Open source software development", psuOrg.getId());

        Category chin = new Category(48,"Chn","Chinese Food","Chinese food carts", foodcart.getId());
        Category jap = new Category(49,"Jap","Japanese Food","Japanese food carts", foodcart.getId());
        Category mex = new Category(50,"Mex","Mexican Food","Mexican food carts", foodcart.getId());
        Category gen = new Category(51,"Gen","Test Category","Test General Category",testOrgs.get(3).getId());

        // Add groups to choose from
        testGroups.add(new Group(89,psuOrg.getId(),"Alumni","Portland State Alumni",lang, primeUser));
        testGroups.add(new Group(90,psuOrg.getId(),"Rocket Club","PSU Engineering Rocket Club",engr, primeUser));
        testGroups.add(new Group(91,psuOrg.getId(),"Spanish Language","PSU Spanish language practice group",lang, primeUser));
        testGroups.add(new Group(92,psuOrg.getId(),"Open Source Dev","PSU Open Source Development Club",oss, primeUser));

        // Add groups to the food cart
        testGroups.add(new Group(93,foodcart.getId(),"5th Avenue Food Cart Lot","Food cart owners located on 5th avenue",chin,primeUser));
        testGroups.add(new Group(94,foodcart.getId(),"10th Street Food Cart Lot","Food cart owners located on 10th street",jap,primeUser));
        testGroups.add(new Group(95,foodcart.getId(),"Alder Street Food Cart Lot","Food cart owners located on Alder street",mex,primeUser));

        testGroups.add(new Group(testGroups.size()+1,testOrgs.get(1).getId(),"Teenager Lego Builders","Lego builders that are teenagers",gen, testUsers.get(0)));
        testGroups.add(new Group(testGroups.size()+1,testOrgs.get(1).getId(),"Adult Lego Builders","Older Lego Builders",gen, testUsers.get(0)));
        testGroups.add(new Group(testGroups.size()+1, testOrgs.get(2).getId(), "Baseball Bat Smashers", "People who love to smash with a baseball bat", gen, testUsers.get(1)));
        testGroups.add(new Group(testGroups.size()+1, testOrgs.get(2).getId(), "Crow Bar Smashers", "Love to smash things with a crow bar.", gen, testUsers.get(1)));


        // Add groups to the PSU organization
        psuOrg.addGroup(testGroups.get(0));
        psuOrg.addGroup(testGroups.get(1));
        psuOrg.addGroup(testGroups.get(2));
        psuOrg.addGroup(testGroups.get(3));

        // Add groups to the food cart organization
        foodcart.addGroup(testGroups.get(4));
        foodcart.addGroup(testGroups.get(5));
        foodcart.addGroup(testGroups.get(6));

        // Add organization to user
        primeUser.addOrganization(psuOrg);
        primeUser.addOrganization(foodcart);

        currentUser = primeUser; // Set the primary user

    }

}
