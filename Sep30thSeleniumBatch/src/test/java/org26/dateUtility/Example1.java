package org26.dateUtility;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.testng.annotations.Test;

public class Example1 {
	@Test(priority=1)
	public void testDate() {
		Date d1=new Date();
		System.out.println("Default current date without formatting: "+d1);
		//format date based on need
		SimpleDateFormat s1=new SimpleDateFormat("dd-MMM-yyyy");
		String date=s1.format(d1);
		System.out.println("Format Date :"+date);
	}
	@Test(priority=2)
	public void dateInPastAndFutureDays() {
		Calendar cal=Calendar.getInstance();
		cal.add(Calendar.DATE, 5);//positive number for future and -ve number for past
		SimpleDateFormat s=new SimpleDateFormat("E, yyyy-MM-dd");
		String date=s.format(new Date(cal.getTimeInMillis()));
		System.out.println("Date After 5 Days: "+date);
	}
	@Test(priority=3)
	public void dateInPastAndFutureMonths() {
		Calendar cal=Calendar.getInstance();
		cal.add(Calendar.MONTH, 7);//positive number for future and -ve number for past
		SimpleDateFormat s=new SimpleDateFormat("E, dd/MM/yyyy");
		String date=s.format(new Date(cal.getTimeInMillis()));
		System.out.println("Date After 7 Months: "+date);
	}
	@Test(priority=4)
	public void dateInPastAndFutureYear() {
		Calendar cal=Calendar.getInstance();
		cal.add(Calendar.YEAR, 8);//positive number for future and -ve number for past
		SimpleDateFormat s=new SimpleDateFormat("E, MMM dd yyyy");
		String date=s.format(new Date(cal.getTimeInMillis()));
		System.out.println("Date After 8 Year: "+date);
	}
}
/*
 * Date format
yyyy-MM-dd	    "1988-09-29"	
dd/MM/yyyy  	"29/09/1988"	
dd-MMM-yyyy 	"29-Sep-1988"	
E, MMM dd yyyy	"Thu, Sep 29 1988"
*/