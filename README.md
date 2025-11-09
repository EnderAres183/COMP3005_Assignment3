# Student Database Application

## Overview
This is a console-based Java application that interacts with a PostgreSQL database to manage student records.  
It allows you to perform CRUD operations (Create, Read, Update, Delete) on a `students` table.

---

## Files
- 'StudentApp.java' – Java source code for the console application. its in the folder 'src'
- 'school_db.sql' – SQL file to create the `students` table and populate it with initial data. 
- 'README.md' – This documentation.

---

## Database Setup

1. **Install PostgreSQL**  
   Download and install from [https://www.postgresql.org/download/](https://www.postgresql.org/download/).

2. **Create the Database**  
   Open pgAdmin 4 and use the file provided "student_db.sql"

## Java setup
1. download PostgreSQL JDBC Driver

2. in StudentApp.java, set these variables to your specification
private static final String URL = "jdbc:postgresql://localhost:5432/school_db"; //database URL
private static final String USER = "postgres"; //your username
private static final String PASSWORD = "COMP3005"; //your passwprd

compile using your IDE of choice

## usage
when the ap runs you will be presented with a menu
--- Student Database Menu ---
1. View All Students
2. Add Student
3. Update Student Email
4. Delete Student
5. Exit

explanation:
1. View All Students – Displays all records.
2. Add Student – Prompts for first name, last name, email, and enrollment date.
3. Update Student Email – Update email for a specific student ID.
4. Delete Student – Delete student by ID.

5. Exit – Closes the application.1. View All Students – Displays all records.
2. Add Student – Prompts for first name, last name, email, and enrollment date.
3. Update Student Email – Update email for a specific student ID.
4. Delete Student – Delete student by ID.
5. Exit – Closes the application.

# notes
make sure your database is running before using the app
make sure the JDBC drievr is working correctly and is in the classpath

Video link to onedrive: 
https://1drv.ms/f/c/99cc8ad3e4b5e954/EmgFw2lX85lLpPgpiFp_7FgBv6kozqDGYeSFhD9Q6MajLQ?e=c1quKx
