package MVP.Hotel.Booking.Hotel.Booking;


import MVP.Hotel.Booking.Hotel.Booking.Entities.HotelBooking;
import MVP.Hotel.Booking.Hotel.Booking.Exception.HotelNotFoundException;
import MVP.Hotel.Booking.Hotel.Booking.Repository.HotelBookingRepository;
import MVP.Hotel.Booking.Hotel.Booking.service.HotelBookingServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class HotelBookingServiceTest {

    @Mock
    private HotelBookingRepository hotelBookingRepository;

    @InjectMocks
    private HotelBookingServiceImpl hotelBookingService;

    @Test
    public void testSaveBooking() {

        HotelBooking booking = createBooking(1L, "priya", "7380846751", "priya@example.com",
                1L, "Single", 2, LocalDateTime.now(), LocalDate.now(), LocalDate.now().plusDays(2));
        when(hotelBookingRepository.save(any())).thenReturn(booking);


        HotelBooking savedBooking = hotelBookingService.saveBooking(booking);


        assertNotNull(savedBooking);
        assertEquals(booking.getBookingId(), savedBooking.getBookingId());
    }

    @Test
    public void testGetAllBookings() {

        List<HotelBooking> expectedBookings = new ArrayList<>();
        HotelBooking booking = createBooking(1L, "John", "1234567890", "john@example.com",
                1L, "Single", 2, LocalDateTime.now(), LocalDate.now(), LocalDate.now().plusDays(2));
        expectedBookings.add(booking);
        when(hotelBookingRepository.findAll()).thenReturn(expectedBookings);


        List<HotelBooking> actualBookings = hotelBookingService.getAllBookings();


        assertEquals(expectedBookings.size(), actualBookings.size());
        assertEquals(expectedBookings.get(0).getBookingId(), actualBookings.get(0).getBookingId());
    }

    @Test
    public void testGetBookingDetailsById() {

        HotelBooking expectedBooking = createBooking(1L, "John", "1234567890", "john@example.com",
                1L, "Single", 2, LocalDateTime.now(), LocalDate.now(), LocalDate.now().plusDays(2));
        when(hotelBookingRepository.findById(1L)).thenReturn(Optional.of(expectedBooking));


        HotelBooking actualBooking = hotelBookingService.getBookingDetailsById(1L);


        assertNotNull(actualBooking);
        assertEquals(expectedBooking.getBookingId(), actualBooking.getBookingId());
    }

    @Test
    public void testGetBookingDetailsById_NotFound() {

        when(hotelBookingRepository.findById(1L)).thenReturn(Optional.empty());


        assertThrows(HotelNotFoundException.class, () -> hotelBookingService.getBookingDetailsById(1L));
    }

    @Test
    public void testCancelBooking() {

        Long bookingId = 1L;


        hotelBookingService.CancelBooking(bookingId);


        verify(hotelBookingRepository, times(1)).deleteBooking(bookingId);
    }

    @Test
    public void testUpdateBooking() {

        Long bookingId = 1L;
        HotelBooking updatedBooking = createBooking(bookingId, "John", "1234567890", "john@example.com",
                1L, "Double", 3, LocalDateTime.now(), LocalDate.now(), LocalDate.now().plusDays(3));
        HotelBooking existingBooking = createBooking(bookingId, "John", "1234567890", "john@example.com",
                1L, "Single", 2, LocalDateTime.now(), LocalDate.now(), LocalDate.now().plusDays(2));
        when(hotelBookingRepository.findById(bookingId)).thenReturn(Optional.of(existingBooking));
        when(hotelBookingRepository.save(any())).thenReturn(updatedBooking);


        HotelBooking savedBooking = hotelBookingService.updateBooking(bookingId, updatedBooking);


        assertNotNull(savedBooking);
        assertEquals(updatedBooking.getBookingId(), savedBooking.getBookingId());
        assertEquals(updatedBooking.getRoomType(), savedBooking.getRoomType());
        assertEquals(updatedBooking.getNumberOfGuests(), savedBooking.getNumberOfGuests());
        assertEquals(updatedBooking.getCheckInDate(), savedBooking.getCheckInDate());
        assertEquals(updatedBooking.getCheckOutDate(), savedBooking.getCheckOutDate());
    }

    private HotelBooking createBooking(Long id, String username, String phoneNumber, String emailId,
                                       Long hotelId, String roomType, int numberOfGuests,
                                       LocalDateTime bookingTimestamp, LocalDate checkInDate, LocalDate checkOutDate) {
        HotelBooking booking = new HotelBooking();
        booking.setBookingId(id);
        booking.setUsername(username);
        booking.setPhoneNumber(phoneNumber);
        booking.setEmailId(emailId);
        booking.setHotelId(hotelId);
        booking.setRoomType(roomType);
        booking.setNumberOfGuests(numberOfGuests);
        booking.setBookingTimestamp(bookingTimestamp);
        booking.setCheckInDate(checkInDate);
        booking.setCheckOutDate(checkOutDate);
        return booking;
    }
}
