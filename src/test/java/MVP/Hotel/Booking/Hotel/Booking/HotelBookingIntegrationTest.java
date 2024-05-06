package MVP.Hotel.Booking.Hotel.Booking;

import MVP.Hotel.Booking.Hotel.Booking.Entities.HotelBooking;
import MVP.Hotel.Booking.Hotel.Booking.Repository.HotelBookingRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HotelBookingIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;

    @Autowired
    private HotelBookingRepository hotelBookingRepository;


    @Test
    public void testCreateBooking() {
        HotelBooking booking = new HotelBooking();
        booking.setBookingId(1L);
        booking.setUsername("priya");
        booking.setPhoneNumber("7380846751");
        booking.setEmailId("priya@example.com");
        booking.setHotelId(1L);
        booking.setRoomType("Single");
        booking.setNumberOfGuests(2);
        booking.setBookingTimestamp(LocalDateTime.now());
        booking.setCheckInDate(LocalDate.now());
        booking.setCheckOutDate(LocalDate.now().plusDays(2));

        ResponseEntity<HotelBooking> responseEntity = restTemplate.postForEntity("/bookings", booking, HotelBooking.class);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

    }

    @Test
    public void testGetAllBookings() {
        ResponseEntity<List> responseEntity = restTemplate.getForEntity("/bookings", List.class);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

}
