//package com.project.safetynet.util;
//
//public class ImportJson<SQLException> {
//
//   // JDBC driver name and database URL
//   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
//   static final String DB_URL = "jdbc:mysql://localhost/SAFETYNET";
//
//   //  Database credentials
//   static final String USER = "username";
//   static final String PASS = "rootroot";
//   
//   public static void main(String[] args) {
//   Connection conn = null;
//   Statement stmt = null;
//   try{
//      //STEP 2: Register JDBC driver
//      Class.forName("com.mysql.jdbc.Driver");
//
//      //STEP 3: Open a connection
//      conn = DriverManager.getConnection(DB_URL, USER, PASS);
//
//        
//        //STEP 4: Execute a query
//        stmt = conn.createStatement();
//
//        String sql = "CREATE TABLE PERSONS"+
//                "(id INTEGER not NULL, " +
//   "firstName VARCHAR(25) NOT NULL," +
//  "lastName  VARCHAR(25) NOT NULL," +
//  "address   VARCHAR(25) NOT NULL,"+
//  "city      VARCHAR(15) NOT NULL,"+
//  "zip       INTEGER  NOT NULL,"+
//  "phone     VARCHAR(12) NOT NULL,"+
//  "email     VARCHAR(25) NOT NULL,"+
//  " PRIMARY KEY ( id ))"; 
//
//
//        stmt.executeUpdate(sql);
//
//INSERT INTO PERSONS(firstName,lastName,address,city,zip,phone,email) VALUES ('John','Boyd','1509 Culver St','Culver',97451,'841-874-6512','jaboyd@email.com');
//INSERT INTO PERSONS(firstName,lastName,address,city,zip,phone,email) VALUES ('Jacob','Boyd','1509 Culver St','Culver',97451,'841-874-6513','drk@email.com');
//INSERT INTO PERSONS(firstName,lastName,address,city,zip,phone,email) VALUES ('Tenley','Boyd','1509 Culver St','Culver',97451,'841-874-6512','tenz@email.com');
//INSERT INTO PERSONS(firstName,lastName,address,city,zip,phone,email) VALUES ('Roger','Boyd','1509 Culver St','Culver',97451,'841-874-6512','jaboyd@email.com');
//INSERT INTO PERSONS(firstName,lastName,address,city,zip,phone,email) VALUES ('Felicia','Boyd','1509 Culver St','Culver',97451,'841-874-6544','jaboyd@email.com');
//INSERT INTO PERSONS(firstName,lastName,address,city,zip,phone,email) VALUES ('Jonanathan','Marrack','29 15th St','Culver',97451,'841-874-6513','drk@email.com');
//INSERT INTO PERSONS(firstName,lastName,address,city,zip,phone,email) VALUES ('Tessa','Carman','834 Binoc Ave','Culver',97451,'841-874-6512','tenz@email.com');
//INSERT INTO PERSONS(firstName,lastName,address,city,zip,phone,email) VALUES ('Peter','Duncan','644 Gershwin Cir','Culver',97451,'841-874-6512','jaboyd@email.com');
//INSERT INTO PERSONS(firstName,lastName,address,city,zip,phone,email) VALUES ('Foster','Shepard','748 Townings Dr','Culver',97451,'841-874-6544','jaboyd@email.com');
//INSERT INTO PERSONS(firstName,lastName,address,city,zip,phone,email) VALUES ('Tony','Cooper','112 Steppes Pl','Culver',97451,'841-874-6874','tcoop@ymail.com');
//INSERT INTO PERSONS(firstName,lastName,address,city,zip,phone,email) VALUES ('Lily','Cooper','489 Manchester St','Culver',97451,'841-874-9845','lily@email.com');
//INSERT INTO PERSONS(firstName,lastName,address,city,zip,phone,email) VALUES ('Sophia','Zemicks','892 Downing Ct','Culver',97451,'841-874-7878','soph@email.com');
//INSERT INTO PERSONS(firstName,lastName,address,city,zip,phone,email) VALUES ('Warren','Zemicks','892 Downing Ct','Culver',97451,'841-874-7512','ward@email.com');
//INSERT INTO PERSONS(firstName,lastName,address,city,zip,phone,email) VALUES ('Zach','Zemicks','892 Downing Ct','Culver',97451,'841-874-7512','zarc@email.com');
//INSERT INTO PERSONS(firstName,lastName,address,city,zip,phone,email) VALUES ('Reginold','Walker','908 73rd St','Culver',97451,'841-874-8547','reg@email.com');
//INSERT INTO PERSONS(firstName,lastName,address,city,zip,phone,email) VALUES ('Jamie','Peters','908 73rd St','Culver',97451,'841-874-7462','jpeter@email.com');
//INSERT INTO PERSONS(firstName,lastName,address,city,zip,phone,email) VALUES ('Ron','Peters','112 Steppes Pl','Culver',97451,'841-874-8888','jpeter@email.com');
//INSERT INTO PERSONS(firstName,lastName,address,city,zip,phone,email) VALUES ('Allison','Boyd','112 Steppes Pl','Culver',97451,'841-874-9888','aly@imail.com');
//INSERT INTO PERSONS(firstName,lastName,address,city,zip,phone,email) VALUES ('Brian','Stelzer','947 E. Rose Dr','Culver',97451,'841-874-7784','bstel@email.com');
//INSERT INTO PERSONS(firstName,lastName,address,city,zip,phone,email) VALUES ('Shawna','Stelzer','947 E. Rose Dr','Culver',97451,'841-874-7784','ssanw@email.com');
//INSERT INTO PERSONS(firstName,lastName,address,city,zip,phone,email) VALUES ('Kendrik','Stelzer','947 E. Rose Dr','Culver',97451,'841-874-7784','bstel@email.com');
//INSERT INTO PERSONS(firstName,lastName,address,city,zip,phone,email) VALUES ('Clive','Ferguson','748 Townings Dr','Culver',97451,'841-874-6741','clivfd@ymail.com');
//INSERT INTO PERSONS(firstName,lastName,address,city,zip,phone,email) VALUES ('Eric','Cadigan','951 LoneTree Rd','Culver',97451,'841-874-7458','gramps@email.com');
//
//
//
//
//
//
//CREATE TABLE STATIONS(
//		   address VARCHAR(17) NOT NULL PRIMARY KEY
//		  ,station INTEGER  NOT NULL
//		);
//		INSERT INTO STATIONS(address,station) VALUES ('1509 Culver St',3);
//		INSERT INTO STATIONS(address,station) VALUES ('29 15th St',2);
//		INSERT INTO STATIONS(address,station) VALUES ('834 Binoc Ave',3);
//		INSERT INTO STATIONS(address,station) VALUES ('644 Gershwin Cir',1);
//		INSERT INTO STATIONS(address,station) VALUES ('748 Townings Dr',3);
//		INSERT INTO STATIONS(address,station) VALUES ('112 Steppes Pl',3);
//		INSERT INTO STATIONS(address,station) VALUES ('489 Manchester St',4);
//		INSERT INTO STATIONS(address,station) VALUES ('892 Downing Ct',2);
//		INSERT INTO STATIONS(address,station) VALUES ('908 73rd St',1);
//		INSERT INTO STATIONS(address,station) VALUES ('112 Steppes Pl',4);
//		INSERT INTO STATIONS(address,station) VALUES ('947 E. Rose Dr',1);
//		INSERT INTO STATIONS(address,station) VALUES ('748 Townings Dr',3);
//		INSERT INTO STATIONS(address,station) VALUES ('951 LoneTree Rd',2);
//
//		
//		
//		
//		
//		CREATE TABLE MEDICAL_RECORDS(
//				   firstName     VARCHAR(25) NOT NULL PRIMARY KEY
//				  ,lastName      VARCHAR(25) NOT NULL
//				  ,birthdate     DATE  NOT NULL
//				  ,medications0  VARCHAR(100)
//				  ,medications1  VARCHAR(100)
//				  ,allergies0    VARCHAR(100)
//				  ,medications2  VARCHAR(100)
//				  ,medications3  VARCHAR(100)
//				  ,allergies1    VARCHAR(100)
//				  ,allergies2    VARCHAR(100)
//				);
//				INSERT INTO MEDICAL_RECORDS(firstName,lastName,birthdate,medications0,medications1,allergies0,medications2,medications3,allergies1,allergies2) VALUES ('John','Boyd','03/06/1984','aznol:350mg','hydrapermazol:100mg','nillacilan',NULL,NULL,NULL,NULL);
//				INSERT INTO MEDICAL_RECORDS(firstName,lastName,birthdate,medications0,medications1,allergies0,medications2,medications3,allergies1,allergies2) VALUES ('Jacob','Boyd','03/06/1989','pharmacol:5000mg','terazine:10mg',NULL,'noznazol:250mg',NULL,NULL,NULL);
//				INSERT INTO MEDICAL_RECORDS(firstName,lastName,birthdate,medications0,medications1,allergies0,medications2,medications3,allergies1,allergies2) VALUES ('Tenley','Boyd','02/18/2012',NULL,NULL,'peanut',NULL,NULL,NULL,NULL);
//				INSERT INTO MEDICAL_RECORDS(firstName,lastName,birthdate,medications0,medications1,allergies0,medications2,medications3,allergies1,allergies2) VALUES ('Roger','Boyd','09/06/2017',NULL,NULL,NULL,NULL,NULL,NULL,NULL);
//				INSERT INTO MEDICAL_RECORDS(firstName,lastName,birthdate,medications0,medications1,allergies0,medications2,medications3,allergies1,allergies2) VALUES ('Felicia','Boyd','01/08/1986','tetracyclaz:650mg',NULL,'xilliathal',NULL,NULL,NULL,NULL);
//				INSERT INTO MEDICAL_RECORDS(firstName,lastName,birthdate,medications0,medications1,allergies0,medications2,medications3,allergies1,allergies2) VALUES ('Jonanathan','Marrack','01/03/1989',NULL,NULL,NULL,NULL,NULL,NULL,NULL);
//				INSERT INTO MEDICAL_RECORDS(firstName,lastName,birthdate,medications0,medications1,allergies0,medications2,medications3,allergies1,allergies2) VALUES ('Tessa','Carman','02/18/2012',NULL,NULL,NULL,NULL,NULL,NULL,NULL);
//				INSERT INTO MEDICAL_RECORDS(firstName,lastName,birthdate,medications0,medications1,allergies0,medications2,medications3,allergies1,allergies2) VALUES ('Peter','Duncan','09/06/2000',NULL,NULL,'shellfish',NULL,NULL,NULL,NULL);
//				INSERT INTO MEDICAL_RECORDS(firstName,lastName,birthdate,medications0,medications1,allergies0,medications2,medications3,allergies1,allergies2) VALUES ('Foster','Shepard','01/08/1980',NULL,NULL,NULL,NULL,NULL,NULL,NULL);
//				INSERT INTO MEDICAL_RECORDS(firstName,lastName,birthdate,medications0,medications1,allergies0,medications2,medications3,allergies1,allergies2) VALUES ('Tony','Cooper','03/06/1994','hydrapermazol:300mg','dodoxadin:30mg','shellfish',NULL,NULL,NULL,NULL);
//				INSERT INTO MEDICAL_RECORDS(firstName,lastName,birthdate,medications0,medications1,allergies0,medications2,medications3,allergies1,allergies2) VALUES ('Lily','Cooper','03/06/1994',NULL,NULL,NULL,NULL,NULL,NULL,NULL);
//				INSERT INTO MEDICAL_RECORDS(firstName,lastName,birthdate,medications0,medications1,allergies0,medications2,medications3,allergies1,allergies2) VALUES ('Sophia','Zemicks','03/06/1988','aznol:60mg','hydrapermazol:900mg','peanut','pharmacol:5000mg','terazine:500mg','shellfish','aznol');
//				INSERT INTO MEDICAL_RECORDS(firstName,lastName,birthdate,medications0,medications1,allergies0,medications2,medications3,allergies1,allergies2) VALUES ('Warren','Zemicks','03/06/1985',NULL,NULL,NULL,NULL,NULL,NULL,NULL);
//				INSERT INTO MEDICAL_RECORDS(firstName,lastName,birthdate,medications0,medications1,allergies0,medications2,medications3,allergies1,allergies2) VALUES ('Zach','Zemicks','03/06/2017',NULL,NULL,NULL,NULL,NULL,NULL,NULL);
//				INSERT INTO MEDICAL_RECORDS(firstName,lastName,birthdate,medications0,medications1,allergies0,medications2,medications3,allergies1,allergies2) VALUES ('Reginold','Walker','08/30/1979','thradox:700mg',NULL,'illisoxian',NULL,NULL,NULL,NULL);
//				INSERT INTO MEDICAL_RECORDS(firstName,lastName,birthdate,medications0,medications1,allergies0,medications2,medications3,allergies1,allergies2) VALUES ('Jamie','Peters','03/06/1982',NULL,NULL,NULL,NULL,NULL,NULL,NULL);
//				INSERT INTO MEDICAL_RECORDS(firstName,lastName,birthdate,medications0,medications1,allergies0,medications2,medications3,allergies1,allergies2) VALUES ('Ron','Peters','04/06/1965',NULL,NULL,NULL,NULL,NULL,NULL,NULL);
//				INSERT INTO MEDICAL_RECORDS(firstName,lastName,birthdate,medications0,medications1,allergies0,medications2,medications3,allergies1,allergies2) VALUES ('Allison','Boyd','03/15/1965','aznol:200mg',NULL,'nillacilan',NULL,NULL,NULL,NULL);
//				INSERT INTO MEDICAL_RECORDS(firstName,lastName,birthdate,medications0,medications1,allergies0,medications2,medications3,allergies1,allergies2) VALUES ('Brian','Stelzer','12/06/1975','ibupurin:200mg','hydrapermazol:400mg','nillacilan',NULL,NULL,NULL,NULL);
//				INSERT INTO MEDICAL_RECORDS(firstName,lastName,birthdate,medications0,medications1,allergies0,medications2,medications3,allergies1,allergies2) VALUES ('Shawna','Stelzer','07/08/1980',NULL,NULL,NULL,NULL,NULL,NULL,NULL);
//				INSERT INTO MEDICAL_RECORDS(firstName,lastName,birthdate,medications0,medications1,allergies0,medications2,medications3,allergies1,allergies2) VALUES ('Kendrik','Stelzer','03/06/2014','noxidian:100mg','pharmacol:2500mg',NULL,NULL,NULL,NULL,NULL);
//				INSERT INTO MEDICAL_RECORDS(firstName,lastName,birthdate,medications0,medications1,allergies0,medications2,medications3,allergies1,allergies2) VALUES ('Clive','Ferguson','03/06/1994',NULL,NULL,NULL,NULL,NULL,NULL,NULL);
//				INSERT INTO MEDICAL_RECORDS(firstName,lastName,birthdate,medications0,medications1,allergies0,medications2,medications3,allergies1,allergies2) VALUES ('Eric','Cadigan','08/06/1945','tradoxidine:400mg',NULL,NULL,NULL,NULL,NULL,NULL);
//
//}
//   }catch(SQLException se){
//	      //Handle errors for JDBC
//	      ((Throwable) se).printStackTrace();
//	   }catch(Exception e){
//	      //Handle errors for Class.forName
//	      e.printStackTrace();
//	   }finally{
//	      //finally block used to close resources
//	      try{
//	         if(stmt!=null)
//	            conn.close();
//	      }catch(SQLException se){
//	      }// do nothing
//	      try{
//	         if(conn!=null)
//	            conn.close();
//	      }catch(SQLException se){
//	         se.printStackTrace();
//	      }//end finally try
//	   }//end try
//	   System.out.println("Goodbye!");
//	}//end main
//	}//end JDBCExample
//}