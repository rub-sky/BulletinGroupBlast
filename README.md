# BulletinGroupBlast
#####Copyright © 2015 Ruben Piatnitsky

The BulletinGroupBlast Android app provides an interface that allows organizations to communicate with their members. The systems main purpose is to be a portal for all announcements on multiple levels - from the individual, to the group, and up to the organization level, and to provide an effective tool for small organizations to be able to centralize their communication.

###Outline
* [How it Works](#how-it-works)
* [License](#license-information)
* [Contact Information](#contact-information)
* [Building the Project](#building-the-project)


###How it works
A user downloads the app. Then the user creates an account. Once in the account, the user can then add organizations that host the BGB database. Once the organization is added, it will appear in the organization list. The organization can create groups for different categories of people. Once a group is created by the administrator of the organization, the user may join any group to be able to communicate between those group members through announcements, chat, calendar events, posts. Some of the features are:

* Join a group to receive announcements and bulletins from this group through news lists and notifications.
* Chat within the confinements of the group by creating a topic chat room and discussing the topic.
* See the overall event calendar for the organization and group to synchronize the events.
* Create reminders or lists for each event or group.
* Share links, documents, and photos

#####Working Features
* A datastructure backend that allows storage and interfacing of the different entities
* Users
* Organization
* Groups
* Categories
* Currently have a basic interface that loads a test user in and displays test data stored in the data structures.

#####Currently In-Progress
* Database integration of entity objects so that the data may be stored
* User interface
* BGB Database for MySQL
* Fragment Communication and Global Variables

###License information
BulletinGroupBlast is licensed under the MIT license. See the [LICENSE](LICENSE) for detail licensing information.

###Contact Information
You may contact me at ruben.piatnitsky@pdx.edu if you have any questions.

###Building the Project
The project can be built by pressing the "play" button found in the main toolbar, or through the build menu option up top of Android Studio. Official Android instructions can be found [here](https://developer.android.com/intl/ko/tools/building/building-studio.html).

#####Prerequisites
* Pulling the files from the repository onto your local system
* Android Studio
  * Follow the instructions on their website.
  * Android Emulator, which may be downloaded with Android Studio
  * Note, this project uses Android Studio 1.3.1
  * Android studio can be downloaded [here](https://developer.android.com/intl/ko/sdk/index.html#Other).

#####Hosting the Database
For the app to work correctly, a MySQL database must be hosted on a server. The administrator may then connect to the server and send out invitations with the connection string. Once the database is complete, the details of setup will be posted.

#####Getting an APK File

1. Click on the drop down menu with the name of your project on the toolbar at the top, next to the "Run" ("play button")
2. Select "Edit Configurations"
3. Click on your project in the left pane
4. Click the plus (+) sign at top left corner or press "Alt+Insert"
5. Select "Gradle"
6. Fill out the form:
  * Choose your module as Gradle project
  * For Tasks field: enter "assemble"
7. Click "OK"
8. Click the "Play" button to build the project
9. The APK file will be located in "BulletinGroupBlast\build\outputs\apk"
  
#####Installing the APK on an Android Device
1. Copy the file onto the SD card or directly onto your device
2. Go to "Settings" on the device
3. Click "Security"
4. Check the "Unkown Sources" check box
5. Open a file explorer app.
6. Go to the directory that the file was downloaded to and click on it.
7. The installation should begin
    
#####Running the App Reference
See the official documentation for running your app in detail [here](http://developer.android.com/intl/ko/training/basics/firstapp/running-app.html).
