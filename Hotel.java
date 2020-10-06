package myPackage.Vinay.HotelReservationSystem;

public class Hotel {
	public String hotelName;
	public int regularWeekdayRate;
	public int regularWeekendRate;
	public Hotel(String hotelName, int regularWeekdayRate, int regularWeekendRate) {
		super();
		this.hotelName = hotelName;
		this.regularWeekdayRate = regularWeekdayRate;
		this.regularWeekendRate = regularWeekendRate;
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
	public int getRegularWeekendRate() {
		return regularWeekendRate;
	}
	public void setRegularWeekendRate(int regularWeekendRate) {
		this.regularWeekendRate = regularWeekendRate;
	}		
}
