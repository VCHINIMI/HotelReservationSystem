package myPackage.Vinay.HotelReservationSystem;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Hotel {
	public String hotelName;
	public int regularWeekdayRate;
	public int regularWeekendRate;
	public int totalCostIncurred;
	public Hotel(String hotelName, int regularWeekdayRate, int regularWeekendRate) {
		super();
		this.hotelName = hotelName;
		this.regularWeekdayRate = regularWeekdayRate;
		this.regularWeekendRate = regularWeekendRate; 
	}
	public int getTotalCostIncurred() {
		return totalCostIncurred;
	}
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public int getRegularWeekdayRate() {
		return regularWeekdayRate;
	}
	public void setRegularWeekdayRate(int regularWeekdayRate) {
		this.regularWeekdayRate = regularWeekdayRate;
	}
	public void costOfStay(String entry, String exit) {
		int totalCost =0;
		Date entryDate = convertGivenDateToRequiredDate(entry);
		Date exitDate = convertGivenDateToRequiredDate(exit);
		Calendar entryDateCalendar = Calendar.getInstance();
	    entryDateCalendar.setTime(entryDate);
	    Calendar exitDateCalendar = Calendar.getInstance();
	    exitDateCalendar.setTime(exitDate);
	    for (Date date = entryDateCalendar.getTime(); entryDateCalendar.before(exitDateCalendar); entryDateCalendar.add(Calendar.DATE, 1), date = entryDateCalendar.getTime()) {
	        int dayNumber = date.getDay();
	        if(dayNumber==0||dayNumber==6)
	        	totalCost = totalCost + regularWeekendRate;
	        else
	        	totalCost = totalCost + regularWeekdayRate;
	    }
	    if(exitDate.getDay()==0||exitDate.getDay()==6)
	    	totalCost=totalCost+regularWeekendRate;
	    else
	    	totalCost = totalCost + regularWeekdayRate;
	    this.totalCostIncurred = totalCost;
	}	
		
	
	public Date convertGivenDateToRequiredDate(String date) {
		DateFormat df4 = new SimpleDateFormat("ddMMMyyyy");
	    Date date1=null;		
	    try {
			date1 = df4.parse(date);
			
		} catch (Exception e) {
			System.out.println("Invalid Date");
		} 
	    return date1;
	}
	@Override
	public String toString() {
		return hotelName;
	}
}
