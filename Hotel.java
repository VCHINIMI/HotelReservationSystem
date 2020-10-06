package myPackage.Vinay.HotelReservationSystem;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Hotel {
	public String hotelName;
	public int regularWeekdayRate;
	public int regularWeekendRate;
	public int loyaltyWeekdayRate;
	public int loyaltyWeekendRate;
	public int totalCostIncurred;
	public int hotelRating;
	public boolean loyaltyFlag;
	public Hotel(String hotelName, int regularWeekdayRate, int regularWeekendRate, int hotelRating, int loyaltyWeekdayRate, int loyaltyWeekendRate) {
		super();
		this.hotelName = hotelName;
		this.regularWeekdayRate = regularWeekdayRate;
		this.regularWeekendRate = regularWeekendRate; 
		this.hotelRating = hotelRating;
		this.loyaltyWeekdayRate = loyaltyWeekdayRate;
		this.loyaltyWeekendRate = loyaltyWeekendRate;
	}	
	public int getRegularWeekendRate() {
		return regularWeekendRate;
	}

	public int getHotelRating() {
		return hotelRating;
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
	    int weekdayRate =0; int weekendRate =0; 
	    if(loyaltyFlag==false) {
	    	weekdayRate=regularWeekdayRate;
	    	weekendRate=regularWeekendRate;
	    }
	    else {
	    	weekdayRate=loyaltyWeekdayRate;
	    	weekendRate=loyaltyWeekendRate;
	    }
	    for (Date date = entryDateCalendar.getTime(); entryDateCalendar.before(exitDateCalendar); entryDateCalendar.add(Calendar.DATE, 1), date = entryDateCalendar.getTime()) {
	    	int dayNumber = date.getDay();
	        if(dayNumber==0||dayNumber==6)
	        	totalCost = totalCost + weekendRate;
	        else
	        	totalCost = totalCost + weekdayRate;
	    }
	    if(exitDate.getDay()==0||exitDate.getDay()==6)
	    	totalCost=totalCost+weekendRate;
	    else
	    	totalCost = totalCost + weekdayRate;
	    
	    
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
		return (hotelName+", Total Cost: "+totalCostIncurred+", Rating: "+hotelRating+" ");
	}
}
