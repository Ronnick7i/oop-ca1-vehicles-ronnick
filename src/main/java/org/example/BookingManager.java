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

    // Constructor
    public BookingManager(String fileName, VehicleManager vehicleManager,
                          PassengerStore passengerStore) {
        this.bookingList = new ArrayList<>();
        this.vehicleManager = vehicleManager;
        this.passengerStore = passengerStore;
        loadBookingFromFile(fileName);
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
                double cost = sc.nextDouble();
                LocalDateTime dateBooking = LocalDateTime.of(year, month, day,
                        hours, min);
                LocationGPS startLocation = new LocationGPS(startLatitude,startLongtitude);
                LocationGPS endLocation = new LocationGPS(endLatitude,endLongtitude);

                bookingList.add(new Booking(bookID,passengerID,vehicleID,dateBooking,startLocation,endLocation,cost));
            }
            sc.close();
        } catch (IOException e) {
            System.out.println("Exception thrown. " + e);
        }
    }

    public Booking addNewBooking(Booking b1) throws IOException {

        boolean found = false;
        for (Booking b : bookingList) {
            if (b.equals(b1)) {
                found = true;
                System.out.println("Booking has already been made");
                break;
            }

        }
        if (found == false) {
            bookingList.add(b1);
            System.out.println("*-----------------------------*");
            System.out.println("*   New booking is added      *");
            System.out.println("*-----------------------------*\n");
        }
        return null;
    }





    public void editBooking(int id) {

        Booking b = findBooking(id);

        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter passenger ID: ");
        int passengerId = Integer.parseInt(keyboard.nextLine()) ;
        System.out.println("Please enter vehicle ID: ");
        int vehicleId = Integer.parseInt(keyboard.nextLine()) ;
        System.out.println("Please enter year of the booking: ");
        int yearOfbooking = Integer.parseInt(keyboard.nextLine()) ;
        System.out.println("Please enter month of the booking: ");
        int monthOfbooking = Integer.parseInt(keyboard.nextLine()) ;
        System.out.println("Please enter day of the booking: ");
        int dayOfbooking = Integer.parseInt(keyboard.nextLine()) ;
        System.out.println("Please enter hour of the booking: ");
        int hourOfbooking = Integer.parseInt(keyboard.nextLine()) ;
        System.out.println("Please enter minute of the booking: ");
        int minuteOfbooking = Integer.parseInt(keyboard.nextLine()) ;


        LocalDateTime dateBooking = LocalDateTime.of(yearOfbooking, monthOfbooking, dayOfbooking,
                hourOfbooking, minuteOfbooking);
        System.out.println("Please enter start latitude of the booking: ");
        double startLatitude = Double.parseDouble(keyboard.nextLine());
        System.out.println("Please enter start longtitude of the booking: ");
        double startLongtitude = Double.parseDouble(keyboard.nextLine());

        LocationGPS startLocation = new LocationGPS(startLatitude,startLongtitude);
        System.out.println("Please enter end latitude of the booking: ");
        double endLatitude = Double.parseDouble(keyboard.nextLine());
        System.out.println("Please enter end longtitude of the booking: ");
        double endLongtitude = Double.parseDouble(keyboard.nextLine());

        LocationGPS endLocation = new LocationGPS(endLatitude,endLongtitude);
        System.out.println("Please enter end cost of the booking: ");
        double cost = Double.parseDouble(keyboard.nextLine());

        b.setPassengerId(passengerId);
        b.setVehicleId(vehicleId);
        b.setBookingDateTime(dateBooking);
        b.setStartLocation(startLocation);
        b.setEndLocation(endLocation);
        b.setCost(cost);

        System.out.println("*--------------------------------------------------*");
        System.out.println("*      Your Booking with ID " + id + " has now been editied.   *");
        System.out.println("*--------------------------------------------------*");

    }

    public void costBooking(double startLatitude, double startLongitude,
                            double endLatitude, double endLongitude,
                            LocationGPS vehDepotLocation, double costPerMile) {
        double cost = 0;

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


    public Booking findBooking(int findId) {
        for (Booking bo : bookingList) {
            if (bo.getBookingId() == findId) {
                return bo;

            }
        }
        return null;
    }



    public void displayAllBookings() {
        if (!bookingList.isEmpty()) {

            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.printf("%-5s %-6s %-10s %-10s %-10s %-10s %-10s %-10s %-17s %-17s %-15s %-15s %-17s \n","Booking ID" ," Passenger ID"," Vehicle ID"," Year" ,"Month","Day","Hour","Minute","Start Latitude","Start Longitude ","End Latitude"," End Longitude","Cost");
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            for (Booking b : bookingList) {
                System.out.printf("%-12d %-12s %-11s %-10s %-10s %-10s %-10s %-13s %-18s %-12s %-17s %-13s  %-13s \n",b.getBookingId() , b.getPassengerId(), b.getVehicleId(), b.getBookingDateTime().getYear() , b.getBookingDateTime().getMonthValue() , b.getBookingDateTime().getDayOfMonth(),
                        b.getBookingDateTime().getHour(),b.getBookingDateTime().getMinute(), b.getStartLocation().getLatitude() , b.getStartLocation().getLongitude() , b.getEndLocation().getLatitude() , b.getEndLocation().getLongitude(),b.getCost());

            }
        }else{
            System.out.println("  There is no bookings in the list");

        }

    }
    @Override
    public String toString() {


        return "BookingManager{" +
                "bookingList=" + bookingList +
                ", passengerStore=" + passengerStore +
                ", vehicleManager=" + vehicleManager +
                '}';
    }

}

