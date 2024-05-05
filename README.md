Hotel Booking System
**********************

Overview
This project implements a simple hotel booking system using Spring Boot and JPA. It provides endpoints to create, read, update, and delete hotel bookings.

Endpoints
POST /bookings: Create a new hotel booking.
GET /bookings: Retrieve all hotel bookings.
GET /bookings/{id}: Retrieve a specific booking by ID.
DELETE /bookings/{id}: Cancel a booking by ID.
PUT /bookings/{id}: Update a booking by ID.

Entities
The HotelBooking entity represents a hotel booking with the following attributes:

bookingId: Unique identifier for the booking.
username: Username of the person making the booking.
phoneNumber: Contact phone number.
emailId: Contact email address.
hotelId: ID of the hotel.
roomType: Type of room booked(example single,double,standard).
bookingTimestamp: Timestamp when the booking was made.
numberOfGuests: Number of guests.
checkInDate: Date of check-in.
checkOutDate: Date of check-out.

Exceptions
The project includes custom exception handling for HotelNotFoundException. This exception is thrown when a hotel booking is not found by its ID.

Repository
The HotelBookingRepository interface extends JpaRepository and provides methods for CRUD operations on hotel bookings. It includes a custom method deleteBooking to delete a booking by ID.

Services
The HotelBookingService interface defines methods for managing hotel bookings, including saving, retrieving, canceling, updating, and getting details of a booking by ID.

The HotelBookingServiceImpl class implements the HotelBookingService interface. It provides implementations for the defined methods using the HotelBookingRepository. 
