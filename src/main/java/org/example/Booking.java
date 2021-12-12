package org.example;

import java.time.LocalDateTime;
import java.util.Objects;

class Booking
{
    private int bookingId;
    private int passengerId;
    private int vehicleId;
    private LocalDateTime bookingDateTime;
    private LocationGPS startLocation;
    private LocationGPS endLocation;

    private double cost;  //Calculated at booking time
    private IdGenerator idGenerator = IdGenerator.getInstance("bookings.txt");

    //TODO - see specification

    public Booking(int passengerId, int vehicleId, LocalDateTime bookingDateTime,
                   LocationGPS startLocation, LocationGPS endLocation, double cost)
    {
        this.bookingId = idGenerator.getNextId();
        this.passengerId = passengerId;
        this.vehicleId = vehicleId;
        this.bookingDateTime = bookingDateTime;
        this.startLocation = startLocation;
        this.endLocation = endLocation;
        this.cost = cost;
    }


    //constructor, when the ID is available from reading the file
    public Booking(int bookingId, int passengerId, int vehicleId, LocalDateTime bookingDateTime,
                   LocationGPS startLocation, LocationGPS endLocation, double cost)
    {
        this.bookingId = bookingId;
        this.passengerId = passengerId;
        this.vehicleId = vehicleId;
        this.bookingDateTime = bookingDateTime;
        this.startLocation = startLocation;
        this.endLocation = endLocation;
        this.cost = cost;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public int getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(int passengerId) {
        this.passengerId = passengerId;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public LocalDateTime getBookingDateTime() {
        return bookingDateTime;
    }

    public void setBookingDateTime(LocalDateTime bookingDateTime) {
        this.bookingDateTime = bookingDateTime;
    }

    public LocationGPS getStartLocation() {
        return startLocation;
    }

    public void setStartLocation(LocationGPS startLocation) {
        this.startLocation = startLocation;
    }

    public LocationGPS getEndLocation() {
        return endLocation;
    }

    public void setEndLocation(LocationGPS endLocation) {
        this.endLocation = endLocation;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return bookingId == booking.bookingId && passengerId == booking.passengerId && vehicleId == booking.vehicleId && Double.compare(booking.cost, cost) == 0 && bookingDateTime.equals(booking.bookingDateTime) && startLocation.equals(booking.startLocation) && endLocation.equals(booking.endLocation) && idGenerator.equals(booking.idGenerator);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookingId, passengerId, vehicleId, bookingDateTime, startLocation, endLocation, cost, idGenerator);
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingId=" + bookingId +
                ", passengerId=" + passengerId +
                ", vehicleId=" + vehicleId +
                ", bookingDateTime=" + bookingDateTime +
                ", startLocation=" + startLocation +
                ", endLocation=" + endLocation +
                ", cost=" + cost +
                '}';
    }
}
