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

import com.sun.jdi.IntegerValue;

public class HotelReservationMain {
	
	public static void main(String[] args) {
		List<Hotel> hotelList = new ArrayList<Hotel>();
		System.out.println("Welcome to Hotel Reservation System");
		Hotel lakeWoodHotel = new Hotel("LakeWood",110,90,3);
		Hotel bridgeWoodHotel = new Hotel("Bridgewood", 150,50,4);
		Hotel ridgeWoodHotel = new Hotel("Ridgewood", 220,150,5);
		hotelList.add(ridgeWoodHotel);
		hotelList.add(bridgeWoodHotel);
		hotelList.add(lakeWoodHotel);
		for(Hotel hotel : hotelList) {
			hotel.costOfStay("11sep2020","12sep2020");
		}
		HashMap<String, Integer> costIncurredMap = (HashMap<String, Integer>) hotelList.stream().sorted(Comparator.comparing(Hotel :: getTotalCostIncurred)).collect(Collectors.toMap(Hotel :: getHotelName, Hotel :: getTotalCostIncurred ));
		String cheapestHotelName = costIncurredMap.entrySet().stream().findFirst().get().getKey();
		Integer cheapestRate = costIncurredMap.entrySet().stream().findFirst().get().getValue();
		costIncurredMap.entrySet().stream().filter(map -> map.getValue().intValue()==cheapestRate).forEach(System.out::println);
	}
}
