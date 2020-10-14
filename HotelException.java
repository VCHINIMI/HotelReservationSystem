package myPackage.Vinay.HotelReservationSystem;

public class HotelException extends Exception {
	private static final long serialVersionUID = 1L;

	enum ExceptionType {
		ENTERED_EMPTY, ENTERED_INVALID
	}

	ExceptionType exceptionType;

	public HotelException(ExceptionType exceptionType, String message) {
		super(message);
		this.exceptionType = exceptionType;
	}
}
