package MVP.Hotel.Booking.Hotel.Booking.Repository;

import MVP.Hotel.Booking.Hotel.Booking.Entities.HotelBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface HotelBookingRepository extends JpaRepository<HotelBooking, Long> {
    @Transactional
    @Modifying
    @Query(value = "DELETE FROM hotel_booking WHERE booking_id = :bookingId", nativeQuery = true)
    void deleteBooking(@Param("bookingId") Long bookingId);
}
