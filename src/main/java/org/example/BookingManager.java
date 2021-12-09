package org.example;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class BookingManager {
    private final ArrayList<Booking> bookingList;
    private PassengerStore passengerStore;
    private VehicleManager vehicleManager;
    private IdGenerator idGenerator;


    // Constructor
    public BookingManager(VehicleManager vehicleManager, PassengerStore passengerStore) {
        this.vehicleManager = vehicleManager;
        this.passengerStore = passengerStore;
        this.bookingList = new ArrayList<>();

    }


public Booking MakeBooking(int passengerId, int vehicleId, int year, int month, int day, int hours,
      int minutes, double startLatitude, double startLongtitude, double endLatitude, double endLongtitude){


    return null;
}

    //TODO implement functionality as per specification
    //load booking from file bookings.txt
    public void loadBookingFromFile(String fileName) {
        try {
            Scanner sc = new Scanner(new File(fileName));
            sc.useDelimiter("[,\r\n]+");
            while (sc.hasNext()) {
                int bookID = sc.nextInt();
                int passengerID = sc.nextInt();
                int vehicleID = sc.nextInt();
                int year = sc.nextInt();   // last service date
                int month = sc.nextInt();
                int day = sc.nextInt();
                int hours = sc.nextInt();
                int min = sc.nextInt();
                double startLatitude = sc.nextDouble();
                double startLongtitude = sc.nextDouble();
                double endLatitude = sc.nextDouble();
                double endLongtitude = sc.nextDouble();
            }
            sc.close();
        } catch (IOException e) {
            System.out.println("Exception thrown. " + e);
        }
    }




    public void displayAllBookings() {
        for (Booking b : bookingList)
            System.out.println(b.toString());
    }


    public Booking addBooking(int passengerId, int vehicleId, LocalDateTime bookingDateTime,
                           LocationGPS startLocation, LocationGPS endLocation, double cost) {
        if (passengerStore.findPassengerByID(passengerId) != null) {
            if (vehicleManager.findVehicleByID(vehicleId) != null) {


                Booking booking = new Booking(passengerId, vehicleId, bookingDateTime, startLocation, endLocation, cost);
                bookingList.add(booking);
               return booking;

            }

        } else {
            System.out.println("There is no such passenger in the file");
        }
         return null;
    }

    //find booking
    public Booking findBooking(int id) {
        for (Booking b : bookingList) {
            if (b.getBookingId() == id) {
                return b;
            }
        }
        return null;

    }

    public void editBooking(int id) {


    }

    public void deleteBooking(int id) {
        for (Booking b : bookingList) {
            if (b.getBookingId() == id) {

                bookingList.remove(b);
                System.out.println("The booking with id " + id + " is deleted.");
                break;
            } else {
                System.out.println("There is no booking with id " + id + " in the list!");
            }

        }
    }

}
