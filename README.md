DEPENDENCIES

Make sure to have:
1. mysql-connector-java-5.1.40-bin.jar 
2. projectdatabase.sql

DESCRIPTION:
University App is a software that enables students to perform certain activities about courses and friends.  
They can also choose to edit their profile in the app.

![ImgName](https://github.com/uendihoxha/UniApplication-in-Java/blob/master/screenshots/mainPage.PNG)

FEATURES

1. User can login to the system.
2. User can check/search all available courses in the system & view details about them.
3. User can add or drop a course.
4. User cannot enroll a course that doesn't belong to his/her major.
5. User can check his courses list.
6. User can check/search all students in the system.
7. User can add friends to his friend list.
8. User can check his friend list.
9. User can check student's courses.
10. User can add comments about a course. 
11. User can edit and save his profile information.
12. User can "Check on recent" to see who has recently joined a course. 

INSTRUCTIONS

1. Download the zip file & extract.
2. Open Java Project in NetBeans: File -> Open Project -> UendiHoxhaProject.
3. Importing Database:phpMyAdmin -> Import -> Choose file -> projectdatabase.sql
4. Connect the JDBC driver(JConnector) by including the it's JAR File in the Project
   - Libraries->(Right Click)ADD JAR File->include file: mysql-connector-java-5.1.40-bin.jar 
   - or at Resolve when opening the project
   
-Some small changes are needed to make to completely fit the three tier architecture in this project-

NOTE: Screenshots of the software functioning are provided in the folder "screenshots" in the zipfile. 

![ImgName](https://github.com/uendihoxha/UniApplication-in-Java/blob/master/screenshots/login.PNG)

![ImgName](https://github.com/uendihoxha/UniApplication-in-Java/blob/master/screenshots/myProfile.PNG)