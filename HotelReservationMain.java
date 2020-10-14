package myPackage.Vinay.HotelReservationSystem;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class HotelReservationMain {

	public static Scanner userInputScanner = new Scanner(System.in);
	public static List<Hotel> hotelList = new ArrayList<Hotel>();

//Add Hotel to HotelList
	public boolean addHotel(Hotel hotel) {
		if (hotelList.add(hotel))
			return true;
		return false;
	}

//Cheapest first, when Tie, best rated hotel in given Date Range	
	public static void chepestBestRatedHotelInRange() {
		List<Hotel> sortedList = hotelList.stream().sorted(Comparator.comparingInt(Hotel::getTotalCostIncurred))
				.collect(Collectors.toList());
		int cheapestRate = sortedList.stream().findFirst().get().getTotalCostIncurred();
		List<Hotel> requiredHotelList = sortedList.stream().filter(list -> list.totalCostIncurred == cheapestRate)
				.collect(Collectors.toList());
		if (requiredHotelList.size() == 1) {
			System.out.println(requiredHotelList);
		} else {
			Optional<Hotel> bestRatingHotelWhenTie = requiredHotelList.stream()
					.sorted(Comparator.comparingInt(Hotel::getHotelRating).reversed()).findFirst();
			System.out.println(bestRatingHotelWhenTie.get());
		}
	}

//Best rated Hotel in given Date range	
	public static void bestRatedHotelInRange() {
		List<Hotel> sortedList = hotelList.stream().sorted(Comparator.comparingInt(Hotel::getHotelRating).reversed())
				.collect(Collectors.toList());
		Optional<Hotel> bestRatedHotelInRange = sortedList.stream().findFirst();
		System.out.println(bestRatedHotelInRange.get());
	}

//Cost of stay method	
	public static void totalCostOfStay(String entryDate, String exitDate) {
		for (Hotel hotel : hotelList) {
			hotel.costOfStay(entryDate, exitDate);
		}
	}

//Set Loyalty Status
	public static void setLoyaltyStatus(boolean flag) {
		for (Hotel hotel : hotelList)
			hotel.setLoyaltyFlag(flag);
	}

//Convert date to LocalDate
	public static LocalDate convertStringToLocalDate(String date) {
		LocalDate localDate = null;
		DateTimeFormatter formatter = new DateTimeFormatterBuilder().parseCaseInsensitive().appendPattern("ddMMMyyyy")
				.toFormatter(Locale.ENGLISH);
		try {
			localDate = LocalDate.parse(date, formatter);
		} catch (Exception e) {
			System.out.println("Invalid Date");
		}
		return localDate;
	}

//Input hotel details method
	public static void takeHotelDetails() {
		Hotel inputHotel = new Hotel();
		try {
			System.out.println("Enter Hotel Name : ");
			String hotelName = userInputScanner.nextLine();
			inputHotel.setHotelName(hotelName);
			System.out.println("Enter Weekday rate for Regular customers");
			int regularWeekday = userInputScanner.nextInt();
			userInputScanner.nextLine();
			inputHotel.setRegularWeekdayRate(regularWeekday);
			System.out.println("Enter Weekend rate for Regular customers");
			int regularWeekend = userInputScanner.nextInt();
			userInputScanner.nextLine();
			inputHotel.setRegularWeekendRate(regularWeekend);
			System.out.println("Enter Weekday rate for Loyalty customers");
			int loyaltyWeekday = userInputScanner.nextInt();
			userInputScanner.nextLine();
			inputHotel.setLoyaltyWeekdayRate(loyaltyWeekday);
			System.out.println("Enter Weekend rate for Loyalty customers");
			int LoyaltyWeekend = userInputScanner.nextInt();
			userInputScanner.nextLine();
			inputHotel.setLoyaltyWeekendRate(LoyaltyWeekend);
			System.out.println("Enter Hotel Rating");
			int hotelRating = userInputScanner.nextInt();
			userInputScanner.nextLine();
			inputHotel.setHotelRating(hotelRating);
			hotelList.add(inputHotel);
		} catch (NullPointerException e) {
			System.out.println("Input is null");
		} catch (HotelException e) {
			System.out.println(e.getMessage());
		} catch (InputMismatchException e) {
			System.out.println("Input not of correct type");
		}
	}

// 	Main method
	public static void main(String[] args) {
		int flag = 0;
		while (flag == 0) {
			System.out.println("1. Input Hotel details to system");
			System.out.println("2. Input Date Range and Calculate fare");
			System.out.println("3. Exit");
			int option = userInputScanner.nextInt();
			userInputScanner.nextLine();
			switch (option) {
			case 1:
				takeHotelDetails();
				break;
			case 2:
				System.out.println("Customer part of Loyalty Program (true/false)");
				String loyaltyString = userInputScanner.nextLine();
				if (loyaltyString.equals("true"))
					setLoyaltyStatus(true);
				else
					setLoyaltyStatus(false);
				System.out.println("Enter Date Range");
				String entryDate = userInputScanner.nextLine();
				String exitDate = userInputScanner.nextLine();
				totalCostOfStay(entryDate, exitDate);
				chepestBestRatedHotelInRange();
				break;
			case 3:
				flag = 1;
				break;
			default:
				break;
			}
		}
		userInputScanner.close();
	}
}
