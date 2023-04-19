# COURSE MANAGER APPLICATION
Video demo: [CourseApp https://youtu.be/hvRBzQ1H84U](https://youtu.be/hvRBzQ1H84U)
<hr/>

## POINT TO PROJECT SOURCE
`execute file database` <br/>
Create database: [base_create.sql](./database/base_create.sql)<br/>
Insert database: [insert_data.sql](./database/insert_data.sql)<br/>
## CONFIGURATION CONNECT SQL-SERVER AND SEND-MAIL
[./source/src/main/java/com/course/model/JdbcHelper.java](./source/src/main/java/com/course/model/JdbcHelper.java)<br/>
17:&ensp;`static String user = "sa";`<br/>
18:&ensp;`static String password = "songlong";`<hr/>

[./source/src/main/java/com/course/model/SendMail.java](./source/src/main/java/com/course/model/SendMail.java)<br/>
config google email: https://myaccount.google.com/security<br/>
&ensp;S1: turn on: 2-Step verification<br/>
&ensp;S2: forward to https://myaccount.google.com/apppasswords<br/>
&ensp;&ensp;- mail & your device > generate<br/>
&ensp;&ensp;- copy app password generated example: "gicawozhnwuakhys"<br/>
&ensp;S3: add your mail and app-password generated<br/>
32:&ensp;`public SendMail() {`<br/>
33:&ensp;&ensp;`this.user = "[your mail]";`<br/>
34:&ensp;&ensp;`this.pass = "[app - password]";`<br/>
35:&ensp;`}`<hr/>

## POINT TO PROJECT SOURCE
```
cd ..[project location]/CourseApp/source
```
## DOWNLOAD DEPENDENCIES (LIBRARIES)
```
mvn dependency:copy-dependencies
```
## START PROJECT WITH MAVEN
```
mvn -X clean exec:java
```
`Open main and run with java`
[MainJFrame.java](./source/src/main/java/com/course/views/MainJFrame.java)

another version: [SOF2041_Ps18107_NgoDuyHoa_ASM.zip](https://drive.google.com/file/d/10C78WYRB8Ez_CW1M9lJpGZRokmyEvN6g/view?usp=sharing)
