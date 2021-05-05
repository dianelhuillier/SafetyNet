package com.project.safetynet.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class Util {

	public static long calculAgeByBirthdate(String birthdate) {
		SimpleDateFormat formatBirthdate = new SimpleDateFormat("MM/dd/yyyy");
		Date dateBirthday = null;
		try {
			dateBirthday = formatBirthdate.parse(birthdate);
		} catch (ParseException e) {

			e.printStackTrace();
		}
		LocalDate date = dateBirthday.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		LocalDate localDate = LocalDate.now(); // creating LocalDate instance
		long age = ChronoUnit.YEARS.between(date, localDate); // age calcul
		return age;
	}

}
