package MVP.Hotel.Booking.Hotel.Booking.service;

import MVP.Hotel.Booking.Hotel.Booking.Entities.HotelBooking;

import java.util.List;

public interface HotelBookingService {

    HotelBooking saveBooking(HotelBooking booking);

    List<HotelBooking> getAllBookings();

    void CancelBooking(Long bookingId);

    HotelBooking getBookingDetailsById(Long id);

    HotelBooking updateBooking(Long bookingId, HotelBooking updatedBooking);
}
