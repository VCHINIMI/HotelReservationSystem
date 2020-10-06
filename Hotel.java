package myPackage.Vinay.HotelReservationSystem;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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
	    int weekdayRate =0; int weekendRate =0; 
	    if(loyaltyFlag==false) {
	    	weekdayRate=regularWeekdayRate;
	    	weekendRate=regularWeekendRate;
	    }
	    else {
	    	weekdayRate=loyaltyWeekdayRate;
	    	weekendRate=loyaltyWeekendRate;
	    }
	    LocalDate entryDate = convertDateToRequiredDate(entry);
		LocalDate exitDate = convertDateToRequiredDate(exit);
	    for(LocalDate date = entryDate; date.isBefore(exitDate);date=date.plusDays(1)) {
	    	int dayNumber = date.getDayOfWeek().getValue(); 
	    	if(dayNumber==0||dayNumber==6)
	        	totalCost = totalCost + weekendRate; 
	        else
	        	totalCost = totalCost + weekdayRate;
	    }
	    if(exitDate.getDayOfWeek().getValue()==0||exitDate.getDayOfWeek().getValue()==6)
	    	totalCost=totalCost+weekendRate;
	    else
	    	totalCost = totalCost + weekdayRate;
	    
	    this.totalCostIncurred = totalCost;	    
	}
	
	public LocalDate convertDateToRequiredDate(String dateString) {
        LocalDate localDate = null;
        DateTimeFormatter formatter = new DateTimeFormatterBuilder().parseCaseInsensitive().appendPattern("ddMMMyyyy").toFormatter(Locale.ENGLISH);
        try {     
        	localDate = LocalDate.parse(dateString, formatter);
        }
        catch(Exception e) {System.out.println(e.getMessage());}
        return localDate; 
	}
	
	@Override
	public String toString() {
		return (hotelName+", Total Cost: "+totalCostIncurred+", Rating: "+hotelRating+" ");
	}
}
