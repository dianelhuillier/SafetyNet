//package com.project.safetynet.service;
//
//public class ImportJson {
//	
//	DECLARE @json NVARCHAR(MAX);
//	SET @json = "persons"'[  	
//	        { "firstName":"John", "lastName":"Boyd", "address":"1509 Culver St", "city":"Culver", "zip":"97451", "phone":"841-874-6512", "email":"jaboyd@email.com" },
//	        { "firstName":"Jacob", "lastName":"Boyd", "address":"1509 Culver St", "city":"Culver", "zip":"97451", "phone":"841-874-6513", "email":"drk@email.com" },
//	        { "firstName":"Tenley", "lastName":"Boyd", "address":"1509 Culver St", "city":"Culver", "zip":"97451", "phone":"841-874-6512", "email":"tenz@email.com" },
//	        { "firstName":"Roger", "lastName":"Boyd", "address":"1509 Culver St", "city":"Culver", "zip":"97451", "phone":"841-874-6512", "email":"jaboyd@email.com" },
//	        { "firstName":"Felicia", "lastName":"Boyd", "address":"1509 Culver St", "city":"Culver", "zip":"97451", "phone":"841-874-6544", "email":"jaboyd@email.com" },
//	        { "firstName":"Jonanathan", "lastName":"Marrack", "address":"29 15th St", "city":"Culver", "zip":"97451", "phone":"841-874-6513", "email":"drk@email.com" },
//	        { "firstName":"Tessa", "lastName":"Carman", "address":"834 Binoc Ave", "city":"Culver", "zip":"97451", "phone":"841-874-6512", "email":"tenz@email.com" },
//	        { "firstName":"Peter", "lastName":"Duncan", "address":"644 Gershwin Cir", "city":"Culver", "zip":"97451", "phone":"841-874-6512", "email":"jaboyd@email.com" },
//	        { "firstName":"Foster", "lastName":"Shepard", "address":"748 Townings Dr", "city":"Culver", "zip":"97451", "phone":"841-874-6544", "email":"jaboyd@email.com" },
//	        { "firstName":"Tony", "lastName":"Cooper", "address":"112 Steppes Pl", "city":"Culver", "zip":"97451", "phone":"841-874-6874", "email":"tcoop@ymail.com" },
//	        { "firstName":"Lily", "lastName":"Cooper", "address":"489 Manchester St", "city":"Culver", "zip":"97451", "phone":"841-874-9845", "email":"lily@email.com" },
//	        { "firstName":"Sophia", "lastName":"Zemicks", "address":"892 Downing Ct", "city":"Culver", "zip":"97451", "phone":"841-874-7878", "email":"soph@email.com" },
//	        { "firstName":"Warren", "lastName":"Zemicks", "address":"892 Downing Ct", "city":"Culver", "zip":"97451", "phone":"841-874-7512", "email":"ward@email.com" },
//	        { "firstName":"Zach", "lastName":"Zemicks", "address":"892 Downing Ct", "city":"Culver", "zip":"97451", "phone":"841-874-7512", "email":"zarc@email.com" },
//	        { "firstName":"Reginold", "lastName":"Walker", "address":"908 73rd St", "city":"Culver", "zip":"97451", "phone":"841-874-8547", "email":"reg@email.com" },
//	        { "firstName":"Jamie", "lastName":"Peters", "address":"908 73rd St", "city":"Culver", "zip":"97451", "phone":"841-874-7462", "email":"jpeter@email.com" },
//	        { "firstName":"Ron", "lastName":"Peters", "address":"112 Steppes Pl", "city":"Culver", "zip":"97451", "phone":"841-874-8888", "email":"jpeter@email.com" },
//	        { "firstName":"Allison", "lastName":"Boyd", "address":"112 Steppes Pl", "city":"Culver", "zip":"97451", "phone":"841-874-9888", "email":"aly@imail.com" },
//	        { "firstName":"Brian", "lastName":"Stelzer", "address":"947 E. Rose Dr", "city":"Culver", "zip":"97451", "phone":"841-874-7784", "email":"bstel@email.com" },
//	        { "firstName":"Shawna", "lastName":"Stelzer", "address":"947 E. Rose Dr", "city":"Culver", "zip":"97451", "phone":"841-874-7784", "email":"ssanw@email.com" },
//	        { "firstName":"Kendrik", "lastName":"Stelzer", "address":"947 E. Rose Dr", "city":"Culver", "zip":"97451", "phone":"841-874-7784", "email":"bstel@email.com" },
//	        { "firstName":"Clive", "lastName":"Ferguson", "address":"748 Townings Dr", "city":"Culver", "zip":"97451", "phone":"841-874-6741", "email":"clivfd@ymail.com" },
//	        { "firstName":"Eric", "lastName":"Cadigan", "address":"951 LoneTree Rd", "city":"Culver", "zip":"97451", "phone":"841-874-7458", "email":"gramps@email.com" }
//		]', 
//				
//	 SET @json "firestations": '[
//		{ "address":"1509 Culver St", "station":"3" },
//	        { "address":"29 15th St", "station":"2" },
//	        { "address":"834 Binoc Ave", "station":"3" },
//	        { "address":"644 Gershwin Cir", "station":"1" },
//	        { "address":"748 Townings Dr", "station":"3" },
//	        { "address":"112 Steppes Pl", "station":"3" },
//	        { "address":"489 Manchester St", "station":"4" },
//	        { "address":"892 Downing Ct", "station":"2" },
//	        { "address":"908 73rd St", "station":"1" },
//	        { "address":"112 Steppes Pl", "station":"4" },
//	        { "address":"947 E. Rose Dr", "station":"1" },
//	        { "address":"748 Townings Dr", "station":"3" },
//	        { "address":"951 LoneTree Rd", "station":"2" }
//		]',
//	  SET @json  "medicalrecords": '[
//	        { "firstName":"John", "lastName":"Boyd", "birthdate":"03/06/1984", "medications":["aznol:350mg", "hydrapermazol:100mg"], "allergies":["nillacilan"] },
//	        { "firstName":"Jacob", "lastName":"Boyd", "birthdate":"03/06/1989", "medications":["pharmacol:5000mg", "terazine:10mg", "noznazol:250mg"], "allergies":[] },
//	        { "firstName":"Tenley", "lastName":"Boyd", "birthdate":"02/18/2012", "medications":[], "allergies":["peanut"] },
//	        { "firstName":"Roger", "lastName":"Boyd", "birthdate":"09/06/2017", "medications":[], "allergies":[] },
//	        { "firstName":"Felicia", "lastName":"Boyd","birthdate":"01/08/1986", "medications":["tetracyclaz:650mg"], "allergies":["xilliathal"] },
//	        { "firstName":"Jonanathan", "lastName":"Marrack", "birthdate":"01/03/1989", "medications":[], "allergies":[] },
//	        { "firstName":"Tessa", "lastName":"Carman", "birthdate":"02/18/2012", "medications":[], "allergies":[] },
//	        { "firstName":"Peter", "lastName":"Duncan", "birthdate":"09/06/2000", "medications":[], "allergies":["shellfish"] },
//	        { "firstName":"Foster", "lastName":"Shepard", "birthdate":"01/08/1980", "medications":[], "allergies":[] },
//	        { "firstName":"Tony", "lastName":"Cooper", "birthdate":"03/06/1994", "medications":["hydrapermazol:300mg", "dodoxadin:30mg"], "allergies":["shellfish"] },
//	        { "firstName":"Lily", "lastName":"Cooper", "birthdate":"03/06/1994", "medications":[], "allergies":[] },
//	        { "firstName":"Sophia", "lastName":"Zemicks", "birthdate":"03/06/1988", "medications":["aznol:60mg", "hydrapermazol:900mg", "pharmacol:5000mg", "terazine:500mg"], "allergies":["peanut", "shellfish", "aznol"] },
//	        { "firstName":"Warren", "lastName":"Zemicks", "birthdate":"03/06/1985", "medications":[], "allergies":[] },
//	        { "firstName":"Zach", "lastName":"Zemicks", "birthdate":"03/06/2017", "medications":[], "allergies":[] },
//	        { "firstName":"Reginold", "lastName":"Walker", "birthdate":"08/30/1979", "medications":["thradox:700mg"], "allergies":["illisoxian"] },
//	        { "firstName":"Jamie", "lastName":"Peters", "birthdate":"03/06/1982", "medications":[], "allergies":[] },
//	        { "firstName":"Ron", "lastName":"Peters", "birthdate":"04/06/1965", "medications":[], "allergies":[] },
//	        { "firstName":"Allison", "lastName":"Boyd", "birthdate":"03/15/1965", "medications":["aznol:200mg"], "allergies":["nillacilan"] },
//	        { "firstName":"Brian", "lastName":"Stelzer", "birthdate":"12/06/1975", "medications":["ibupurin:200mg", "hydrapermazol:400mg"], "allergies":["nillacilan"] },
//	        { "firstName":"Shawna", "lastName":"Stelzer", "birthdate":"07/08/1980", "medications":[], "allergies":[] },
//	        { "firstName":"Kendrik", "lastName":"Stelzer", "birthdate":"03/06/2014", "medications":["noxidian:100mg", "pharmacol:2500mg"], "allergies":[] },
//	        { "firstName":"Clive", "lastName":"Ferguson", "birthdate":"03/06/1994", "medications":[], "allergies":[] },
//	        { "firstName":"Eric", "lastName":"Cadigan", "birthdate":"08/06/1945", "medications":["tradoxidine:400mg"], "allergies":[] }
//	        
//	
//			]';
//}SELECT*
//
//	FROM OPENJSON(@json)  WITH (
//	    id INT 'strict $.id',
//
//	firstName NVARCHAR(50) '$.info.firstName',
//
//	lastName NVARCHAR(50) '$.info.lastName',  
//	    
//	    birthdate DATETIME2 '$.dob',
//
//	medications NVARCHAR(MAX) '$.info.medications' AS JSON
//	allergies NVARCHAR(MAX) '$.info.allergies' AS JSON
//
//	  )
//	OUTER APPLY OPENJSON(skills)
//	  WITH (skill NVARCHAR(8) '$');
//}
//}