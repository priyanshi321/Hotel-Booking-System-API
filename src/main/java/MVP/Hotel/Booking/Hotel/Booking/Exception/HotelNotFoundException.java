package MVP.Hotel.Booking.Hotel.Booking.Exception;



public class HotelNotFoundException extends RuntimeException {
    public HotelNotFoundException(String message) {
        super(message);
    }
}

