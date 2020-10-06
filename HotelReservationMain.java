package myPackage.Vinay.HotelReservationSystem;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import com.sun.jdi.IntegerValue;

public class HotelReservationMain {
	List<Hotel> hotelList = new ArrayList<Hotel>();
	public void chepestBestRatedHotelInRange() {
		List<Hotel> sortedList = hotelList.stream().sorted(Comparator.comparingInt(Hotel::getTotalCostIncurred)).collect(Collectors.toList());
		int cheapestRate = sortedList.stream().findFirst().get().getTotalCostIncurred();
		List<Hotel> requiredHotelList = sortedList.stream().filter(list -> list.totalCostIncurred==cheapestRate).collect(Collectors.toList());
		if(requiredHotelList.size()==1)
			System.out.println(requiredHotelList);
		else {
			Optional<Hotel> bestRatingHotelWhenTie = requiredHotelList.stream().sorted(Comparator.comparingInt(Hotel::getHotelRating).reversed()).findFirst();
			System.out.println(bestRatingHotelWhenTie.get());
		}
	}
	public void bestRatedHotelInRange() {
		List<Hotel> sortedList = hotelList.stream().sorted(Comparator.comparingInt(Hotel::getHotelRating).reversed()).collect(Collectors.toList());
		Optional<Hotel> bestRatedHotelInRange = sortedList.stream().findFirst();
		System.out.println(bestRatedHotelInRange.get());
	}
	
	public static void main(String[] args) {		
		HotelReservationMain hotelReservationMain = new HotelReservationMain();
		System.out.println("Welcome to Hotel Reservation System");
		Hotel lakeWoodHotel = new Hotel("LakeWood",110,90,3,80,80);
		Hotel bridgeWoodHotel = new Hotel("Bridgewood", 150,50,4,110,50);
		Hotel ridgeWoodHotel = new Hotel("Ridgewood", 220,150,5,100,40);
		lakeWoodHotel.loyaltyFlag=true;
		bridgeWoodHotel.loyaltyFlag=true;
		ridgeWoodHotel.loyaltyFlag=true;
		hotelReservationMain.hotelList.add(ridgeWoodHotel);
		hotelReservationMain.hotelList.add(bridgeWoodHotel);
		hotelReservationMain.hotelList.add(lakeWoodHotel);
		for(Hotel hotel : hotelReservationMain.hotelList) {
			hotel.costOfStay("10oct2020","11oct2020");
		}
		hotelReservationMain.chepestBestRatedHotelInRange();		
	}
}
