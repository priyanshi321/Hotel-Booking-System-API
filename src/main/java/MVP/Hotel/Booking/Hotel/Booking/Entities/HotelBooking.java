package MVP.Hotel.Booking.Hotel.Booking.Entities;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Entity
@Table(name = "Hotel_Reservations")
public class HotelBooking {
    @Id
    @Column(name = "ID")
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingId;
    @Column(name = "Name")
    @NotBlank(message = "Username is required")
    private String username;
    @Column(name = "PhoneNumber")
    @NotBlank(message = "Phone number is required")
    @Pattern(regexp="^\\+(?:[0-9] ?){6,14}[0-9]$", message="Please provide a valid phone number")
    private String phoneNumber;
    @NotBlank(message = "Email is required")
    @Email(message = "Please provide a valid email address")
    @Column(name = "emailId")
    private String emailId;
    @Column(name = "HotelId")
    private Long hotelId;
    @Column(name = "RoomType")
    private String roomType;
    @Column(name = "booking_timestamp", updatable = false)
    @CreationTimestamp
    private LocalDateTime bookingTimestamp;
    @Column(name = "NumberOfGuest")
    @Min(value = 1, message = "Number of guests must be at least 1")
    private int numberOfGuests;
    @NotNull(message = "Check-in date is required")
    @FutureOrPresent(message = "Check-in date must be in the present or future")
    @Column(name = "checkInDate")
    private LocalDate checkInDate;
    @NotNull(message = "Check-out date is required")
    @Future(message = "Check-out date must be in the future")
    @Column(name = "checkOutDate")
    private LocalDate checkOutDate;

    @Override
    public String toString() {
        return "HotelBooking{" +
                "bookingId=" + bookingId +
                ", username='" + username + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", emailId='" + emailId + '\'' +
                ", hotelId=" + hotelId +
                ", roomType='" + roomType + '\'' +
                ", bookingTimestamp=" + bookingTimestamp +
                ", numberOfGuests=" + numberOfGuests +
                ", checkInDate=" + checkInDate +
                ", checkOutDate=" + checkOutDate +
                '}';
    }

    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public LocalDateTime getBookingTimestamp() {
        return bookingTimestamp;
    }

    public void setBookingTimestamp(LocalDateTime bookingTimestamp) {
        this.bookingTimestamp = bookingTimestamp;
    }

    public int getNumberOfGuests() {
        return numberOfGuests;
    }

    public void setNumberOfGuests(int numberOfGuests) {
        this.numberOfGuests = numberOfGuests;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(LocalDate checkInDate) {
        this.checkInDate = checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(LocalDate checkOutDate) {
        this.checkOutDate = checkOutDate;
    }


}
