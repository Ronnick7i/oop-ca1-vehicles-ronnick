package org.example;

import java.time.LocalDateTime;

class Booking
{

    private IdGenerator idGenerator = IdGenerator.getInstance("next-id-store.txt");
    private int bookingId;
    private int passengerId;
    private int vehicleId;
    private LocalDateTime bookingDateTime;
    private LocationGPS startLocation;
    private LocationGPS endLocation;

    private double cost;  //Calculated at booking time

    public Booking(int passengerId, int vehicleId,int year, int month, int day, int hour, int minute, double startLatitude, double startLongitude, double endLatitude, double endLongitude, double cost) {
        this.passengerId = passengerId;
        this.vehicleId = vehicleId;
        this.bookingDateTime = LocalDateTime.of(year, month,day,hour,minute);
        this.startLocation = new LocationGPS(startLongitude, startLatitude);
        this.endLocation = new LocationGPS(endLatitude, endLongitude);
    }
    public Booking(int bookingId, int passengerId, int vehicleId, int year, int month, int day, int hour, int minute, double startLatitude, double startLongitude, double endLatitude, double endLongitude, double cost) {
        this.bookingId = bookingId;
        this.passengerId = passengerId;
        this.vehicleId = vehicleId;
        this.bookingDateTime = LocalDateTime.of(year, month,day,hour,minute);
        this.startLocation = new LocationGPS(startLongitude, startLatitude);
        this.endLocation = new LocationGPS(endLatitude, endLongitude);
    }


    public int getBookingId() {

        return  bookingId;
    }
    public void setBookingId(int bookingId){
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

    public LocationGPS getEndLocation() {
        return endLocation;
    }

    public void setEndLocation(LocationGPS endLocation) {
        this.endLocation = endLocation;
    }

    //TODO - see specification
    
    

}
