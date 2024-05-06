package MVP.Hotel.Booking.Hotel.Booking.service;

import MVP.Hotel.Booking.Hotel.Booking.Entities.HotelBooking;
import MVP.Hotel.Booking.Hotel.Booking.Exception.HotelNotFoundException;
import MVP.Hotel.Booking.Hotel.Booking.Repository.HotelBookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class HotelBookingServiceImpl {

    @Autowired
    private HotelBookingRepository hotelBookingRepository;


    public HotelBooking saveBooking(HotelBooking booking) {
        booking.setBookingTimestamp(LocalDateTime.now());
        return hotelBookingRepository.save(booking);
    }

    public List<HotelBooking> getAllBookings() {
        return hotelBookingRepository.findAll();
    }

    public void CancelBooking(Long bookingId) {
        hotelBookingRepository.deleteBooking(bookingId);
    }


    public HotelBooking getBookingDetailsById(Long id) {
        return hotelBookingRepository.findById(id)
                .orElseThrow(() -> new HotelNotFoundException("Hotel not found with ID: " + id));
    }

    public HotelBooking updateBooking(Long bookingId, HotelBooking updatedBooking) {
        HotelBooking existingBooking = hotelBookingRepository.findById(bookingId)
                .orElseThrow(() -> new HotelNotFoundException("Booking not found with ID: " + bookingId));
        existingBooking.setHotelId(updatedBooking.getHotelId());
        existingBooking.setRoomType(updatedBooking.getRoomType());
        existingBooking.setNumberOfGuests(updatedBooking.getNumberOfGuests());
        existingBooking.setCheckInDate(updatedBooking.getCheckInDate());
        existingBooking.setCheckOutDate(updatedBooking.getCheckOutDate());

        return hotelBookingRepository.save(existingBooking);
    }
}

