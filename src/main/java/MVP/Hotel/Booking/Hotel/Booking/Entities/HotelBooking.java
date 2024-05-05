package MVP.Hotel.Booking.Hotel.Booking.Entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
@Getter
@Setter
@ToString
@Entity
@Table(name = "Hotel_Reservations")
public class HotelBooking {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingId;
    @Column(name = "Name")
    private String username;
    @Column(name = "PhoneNumber")
    private String phoneNumber;
    @Column(name = "emailId")
    private String emailId;
    @Column(name = "HotelId")
    private Long hotelId;
    @Column(name = "RoomType")
    private String roomType;
    @Column(name = "bookingTimeStamp")
    private LocalDateTime bookingTimestamp;
    @Column(name = "NumberOfGuest")
    private int numberOfGuests;
    @Column(name = "checkInDate")
    private LocalDate checkInDate;
    @Column(name = "checkOutDate")
    private LocalDate checkOutDate;

}
