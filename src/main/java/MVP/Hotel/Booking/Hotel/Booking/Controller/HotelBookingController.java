package MVP.Hotel.Booking.Hotel.Booking.Controller;

import MVP.Hotel.Booking.Hotel.Booking.Entities.HotelBooking;
import MVP.Hotel.Booking.Hotel.Booking.Exception.HotelNotFoundException;
import MVP.Hotel.Booking.Hotel.Booking.service.HotelBookingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RestControllerAdvice
@Validated
@RequestMapping("/bookings")
public class HotelBookingController {
    @Autowired
    private HotelBookingServiceImpl bookingService;

    @ExceptionHandler(HotelNotFoundException.class)
    public ResponseEntity<String> handleHotelNotFoundException(HotelNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @PostMapping
    public ResponseEntity<HotelBooking> createBooking(@Valid @RequestBody HotelBooking booking) {
        HotelBooking createdBooking = bookingService.saveBooking(booking);
        return ResponseEntity.ok(createdBooking);
    }

    @GetMapping
    public ResponseEntity<List<HotelBooking>> getAllBookings() {
        List<HotelBooking> bookings = bookingService.getAllBookings();
        return ResponseEntity.ok(bookings);
    }

    @GetMapping("/{BookingId}")
    public ResponseEntity<HotelBooking> getBookingDetailsById(@PathVariable Long BookingId) {

        HotelBooking hotel = bookingService.getBookingDetailsById(BookingId);
        if (hotel != null) {
            return ResponseEntity.ok(hotel);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{BookingId}")
    public ResponseEntity<String> CancelBooking(@PathVariable Long BookingId) {
        bookingService.CancelBooking(BookingId);
        return ResponseEntity.ok("Booking with ID " + BookingId + " has been deleted.");
    }

    @PutMapping("/{Bookingid}")
    public ResponseEntity<HotelBooking> updateBooking(@PathVariable Long Bookingid, @Valid @RequestBody HotelBooking updatedBooking) {
        HotelBooking booking = bookingService.updateBooking(Bookingid, updatedBooking);
        return ResponseEntity.ok(booking);
    }
}

