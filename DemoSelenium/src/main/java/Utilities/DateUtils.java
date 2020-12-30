package Utilities;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {
	
	private static Date date;
	private static SimpleDateFormat formatter;
	
	public static String getCurrentDate()
	{
		
		date=new Date();
		formatter=new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Current Date is: "+formatter.format(date));
		return formatter.format(date);
	}
	
	public static String getCurrentTimeInHHMMSS()
	{
		date=new Date();
		formatter=new SimpleDateFormat("HH:mm:ss");
		
		return formatter.format(date);
	}
	
	
	public static String getTomorrowDate()
	{
	    
		
		LocalDate todate=LocalDate.now();
		
		String tomorrow=new SimpleDateFormat("dd/MM/yyyy").format(todate.plusDays(1));
		
		return tomorrow;
		
			
		
	}

	
	public static String getYesterdayDate()
	{
		
		LocalDate todate=LocalDate.now();
		
		String yesterday=new SimpleDateFormat("dd/MM/yyyy").format(todate.minusDays(1));	
		
		return yesterday;
		
	}
	
	public static String addYearsToCurrentDate(int years)
	{
		
		LocalDate todate=LocalDate.now();
		
		String toYear=new SimpleDateFormat("yyyy").format(todate.plusYears(years));
		
		return toYear;
		
	}
	
	public static boolean isLeapYearOrNot(int year)
	{
		boolean status=false;
		if(((year%4==0) && (year%100!=0)) || (year%400==0))
		{
			status=true;
		}
		else
		{
			status=false;
		}
		return status;
	}
	
	
	
	public static String addHoursToCurrentTime(long hours)
	{
		
		LocalTime ltime=LocalTime.now();
		
		return new SimpleDateFormat("HH:mm").format(ltime.plusHours(hours));
		
	}
	
	public static String addHoursOnGivenTime(String timeData, long hours) throws Exception
	{
		
		LocalTime ltime=LocalTime.parse(timeData);
		
		return new SimpleDateFormat("HH:mm:ss").format(ltime.plusHours(hours));		
		
	}
	
	public static String addDaysToADate(String Date1,int days)
	{
		
	LocalDate lDate1=LocalDate.parse(Date1);
	
	return new SimpleDateFormat("dd/MM/yyyy").format(lDate1.plusDays(days));
		
	}
	
	public static String addMonthsToADate(String date, long months)
	{
		
		LocalDate date1=LocalDate.parse(date);
		
		return new SimpleDateFormat("dd/MM/yyyy").format(date1.plusMonths(months));
		
	}
	
	public static String addYearsToADate(String date, long years) throws Exception
	{
		
		LocalDate date1=LocalDate.parse(date);
		
		return new SimpleDateFormat("dd/MM/yyyy").format(date1.plusYears(years));
		
	}
	
	
	
	
}
