package MVP.Hotel.Booking.Hotel.Booking.Entities;

import javax.persistence.*;
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

    @Column(name = "checkInDate")
    private LocalDate checkInDate;

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

    @Column(name = "checkOutDate")
    private LocalDate checkOutDate;

}
