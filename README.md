# BulletinGroupBlast
#####Copyright © 2015 Ruben Piatnitsky
<p>The BulletinGroupBlast Android app provides an interface that allows organizations to communicate with their members. The systems main purpose is to be a portal for all announcements on multiple levels - from the individual, to the group, and up to the organization level, and to provide an effective tool for small organizations to be able to centralize their communication.</p>

#####How it works
<p>A user downloads the app. Then the user creates an account. Once in the account, the user can then add organizations that host the BGB database. Once the organization is added, it will appear in the organization list. The organization can create groups for different categories of people. Once a group is created by the administrator of the organization, the user may join any group to be able to communicate between those group members through announcements, chat, calendar events, posts. Some of the features are:</p>

<ul>
  <li>Join a group to receive announcements and bulletins from this group through news lists and notifications.</li> 
  <li>Chat within the confinements of the group by creating a topic chat room and discussing the topic.</li>
  <li>See the overall event calendar for the organization and group to synchronize the events.</li>
  <li>Create reminders or lists for each event or group.</li>
  <li>Share links, documents, and photos</li>
</ul>

####Working Features
<ul>
  <li>A datastructure backend that allows storage and interfacing of the different entities</li>
  <li>Users</li>
  <li>Organization</li>
  <li>Groups</li>
  <li>Categories</li>
  <li>Currently have a basic interface that loads a test user in and displays test data stored in the data structures.</li>
</ul>

####Currently In-Progress
  <ul>
    <li>Database integration of entity objects so that the data may be stored</li>
    <li>User interface</li>
    <li>BGB Database for MySQL</li>
    <li>Fragment Communication and Global Variables</li>
  </ul>
<br>

###License information
BulletinGroupBlast is licensed under the MIT license.
See the [LICENSE](LICENSE) for detail licensing information.

###Contact Information
You may contact me at ruben.piatnitsky@pdx.edu if you have any questions.


###Building the Project
The project can be built by pressing the "play" button found in the main toolbar, or through the build menu option up top of Android Studio. Official Android instructions can be found [here](https://developer.android.com/intl/ko/tools/building/building-studio.html).

#####Prerequisites
<ul>
  <li>Pulling the files from the repository onto your local system</li>
  <li>Android Studio</li>
    <ul>
      <li>Follow the instructions on their website.</li>
      <li>Android Emulator, which may be downloaded with Android Studio</li>
      <li>Note, this project uses Android Studio 1.3.1</li>
    </ul>
</ul>
>Android studio can be downloaded [here](https://developer.android.com/intl/ko/sdk/index.html#Other).

#####Hosting the Database
For the app to work correctly, a MySQL database must be hosted on a server. The administrator may then connect to the server and send out invitations with the connection string. Once the database is complete, the details of setup will be posted.

#####Getting an APK File
<ol>
  <li>Click on the drop down menu with the name of your project on the toolbar at the top, next to the "Run" ("play button")</li>
  <li>Select "Edit Configurations"</li>
  <li>Click on your project in the left pane</li>
  <li>Click the plus (+) sign at top left corner or press "Alt+Insert"</li>
  <li>Select "Gradle"</li>
  <li>Fill out the form:
    <ul>
      <li>Choose your module as Gradle project</li>
      <li>For Tasks field: enter "assemble"</li>
    </ul>
  </li>
  <li>Click "OK"</li>
  <li>Click the "Play" button to build the project</li>
  <li>The APK file will be located in "BulletinGroupBlast\build\outputs\apk"</li>
</ol>
  
#####Installing the APK on an Android Device
<ol>
  <li>Copy the file onto the SD card or directly onto your device</li>
  <li>Go to "Settings" on the device</li>
  <li>Click "Security"</li>
  <li>Check the "Unkown Sources" check box</li>
  <li>Open a file explorer app.</li>
  <li>Go to the directory that the file was downloaded to and click on it</li>
  <li>The installation should begin</li>
</ol>
    
#####Running the App Reference
See the official documentation for running your app in detail [here](http://developer.android.com/intl/ko/training/basics/firstapp/running-app.html).
