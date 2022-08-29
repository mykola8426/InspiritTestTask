
# TRIP APP

### 📒 Project description:
      A simple web application that supports authentication, registration and other CRUD operations.
###  🔗 Features:
___
* registration like a user;
* authentication like a user;
* authentication like a admin;
* create/find by email a user;
* create/update/delete/get/get list by price a ticket;
* create/update/delete/get a tour;
* create/update/delete/get tour operator;
* create/update/delete/get/find by country locations;
* find all locations, tours, tickets or operators 


#####  Access rights to individual endpoints according to roles:
```
GET: /tickets (USER)
GET: /locations (USER)
GET: /tours (USER)
GET: /tour-operators (USER)
GET: /locations/by-country (USER)
GET: /tickets/by-price (USER)
POST: /tickets (ADMIN)
POST: /locations (ADMIN)
POST: / (ADMIN)
POST: / (ADMIN)
PUT: /tickets/{id} (ADMIN)
PUT: /locations/{id} (ADMIN)
PUT: /tours/{id} (ADMIN)
PUT: /tour-operators/{id} (ADMIN)
DELETE: /tickets (ADMIN)
DELETE: /locations (ADMIN)
DELETE: /tours (ADMIN)
DELETE: /tour-operators (ADMIN)
```
### 🖥 Technologies used:
___
* JDK 11
* Maven 3.8.6
* Hibernate
* MySql 8.0.22
* SpringBoot

### 🚀  Run Locally:
___
To correctly use this service you have to install MySQL, Apache Tomcat version 9 and PostMan.
1. Clone this project to your environment:
2. Create schema manually;
3. Write url to schema into property with name:"db.url" in /src/main/resources/db.properties file
4. Write login and password to your db into properties with name: "spring.datasource.username" and "spring.datasource.password" in /src/main/resources/application.properties file
6. Click run button
7. Go ahead and use it(default users created in DataIntializer.class)!
8.There are two predefined users: 
 1.Login: bohdanRomaniv@gmail.com
      Password:12345
      Role:ADMIN
 2.Login: mykoolayakymiv@gmail.com
      Password:12345
      Role:USER

