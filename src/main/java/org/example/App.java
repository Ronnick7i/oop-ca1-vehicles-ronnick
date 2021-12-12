package org.example;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

/**Ronnick Achums sd2
 * This Vehicle Bookings Management Systems manages the booking of Vehicles
 * by Passengers.
 *
 * This program reads from 3 text files:
 * "vehicles.txt", "passengers.txt", and "next-id-store.txt"
 * You should be able to see them in the project pane.
 * You will create "bookings.txt" at a later stage, to store booking records.
 *
 * "next-id-store.txt" contains one number ("201"), which will be the
 * next auto-generated id to be used to when new vehicles, passengers, or
 * bookings are created.  The value in the file will be updated when new objects
 * are created - but not when objects are recreated from records in
 * the files - as they already have IDs.  Dont change it - it will be updated by
 * the IdGenerator class.
 */

public class App {
    private static VehicleManager vehicleManager;
    private static PassengerStore passengerStore;
    private static BookingManager bookingManager;
    private static LocalDateTime bookingDateTime;


    public static void main(String[] args) throws IOException {
        Scanner kb = new Scanner(System.in);
        System.out.println("\nWelcome to the VEHICLE BOOKINGS MANAGEMENT SYSTEM - CA1 for OOP\n");
        System.out.println("-----------------------------------------------------");
        System.out.println("Main Menu");
        System.out.println("-----------------------------------------------------");
        PassengerStore passengerStore = new PassengerStore("passengers.txt");
        VehicleManager vehicleManager = new VehicleManager("vehicles.txt");
        BookingManager bookingManager = new BookingManager("bookings.txt",vehicleManager,passengerStore);

        int choice = 0;
        while (choice != 10) {
            System.out.println("1. Display all Vechicles");
            System.out.println("2. Find Vechicle by Reg Numbers");
            System.out.println("3. Display all passengers");
            System.out.println("4. Add Passenger");
            System.out.println("5. Find passenger by Name");
            System.out.println("6. Display all Bookings");
            System.out.println("7. Find Booking by ID");
            System.out.println("8. Add Booking");
            System.out.println("9. Edit Booking");
            System.out.println("10. Delete Booking");
            System.out.println("11. Exit");
            System.out.println("-----------------------------------------------------");
            choice = kb.nextInt();
            kb.nextLine();

            switch (choice) {
                case 1:
                  vehicleManager = new VehicleManager("vehicles.txt");
                    System.out.println("List of all vehicles");
                    vehicleManager.allVehicles();
                    break;
                case 2:
                    vehicleManager = new VehicleManager("vehicles.txt");

                    System.out.println("What reg number do you want to find");
                    String Reg = kb.nextLine();
                    Vehicle v = vehicleManager.FindValueByRegNumber(Reg);
                    if (v != null) {
                        System.out.println(v);
                    } else {
                        System.out.println("Vehicle not found");
                    }


                    break;
                case 3:
                    passengerStore = new PassengerStore("passengers.txt");
                    System.out.println("List of all Passengers ");
                    passengerStore.displayAllPassengers();
                    break;

                case 4:
                    passengerStore = new PassengerStore("passengers.txt");
                    passengerStore.addPassenger("Danny Whale", "Danny@gmail.com", "0832387446", 34.1625, -23.7574);
                    passengerStore.addPassenger("Pope Dawn", "Pope@gmail.com", "0899236778", 34.5643, -15.6758);
                    passengerStore.displayAllPassengers();
                    System.out.println("List of added passengers");
                    break;

                case 5:
                    passengerStore = new PassengerStore("passengers.txt");

                    System.out.println("What name do you want to find?");
                    String PassengerName = kb.nextLine();
                    Passenger pa = passengerStore.FindPassengerByName(PassengerName);
                    if (pa != null) {
                        System.out.println(pa + "This name is Found");
                    } else {
                        System.out.println("Name not found");

            }
                    break;
                case 6:
                    bookingManager = new BookingManager("bookings.txt",vehicleManager,passengerStore);
                    System.out.println("List of all bookings");
                    bookingManager.displayAllBookings();
                    break;

                case 7:
                    bookingManager = new BookingManager("bookings.txt",vehicleManager,passengerStore);
                    System.out.println("What ID do you want to find");
                    int findId = kb.nextInt();
                    Booking bo = bookingManager.findBooking(findId);
                    if (bo == null)
                        System.out.println("No Booking matching this ID " + findId );
                    else
                        System.out.println("Found Booking: " + bo.toString());
                    break;

                case 8:
                    bookingManager = new BookingManager("bookings.txt",vehicleManager,passengerStore);
                    bookingManager.displayAllBookings();
                    passengerStore.displayAllPassengers();
                    vehicleManager.allVehicles();

                    System.out.println("Please choose passenger ID: ");
                    int passengerId = Integer.parseInt(kb.nextLine()) ;
                    System.out.println("Please choose vehicle ID: ");
                    int vehicleId = Integer.parseInt(kb.nextLine()) ;
                    System.out.println("Please enter year of the booking: ");
                    int yearOfbooking = Integer.parseInt(kb.nextLine()) ;
                    System.out.println("Please enter month of the booking: ");
                    int monthOfbooking = Integer.parseInt(kb.nextLine()) ;
                    System.out.println("Please enter day of the booking: ");
                    int dayOfbooking = Integer.parseInt(kb.nextLine()) ;
                    System.out.println("Please enter hour of the booking: ");
                    int hourOfbooking = Integer.parseInt(kb.nextLine()) ;
                    System.out.println("Please enter minute of the booking: ");
                    int minuteOfbooking = Integer.parseInt(kb.nextLine()) ;

                    LocalDateTime dateBooking = LocalDateTime.of(yearOfbooking, monthOfbooking, dayOfbooking,
                            hourOfbooking, minuteOfbooking);
                    System.out.println("Please enter start latitude of the booking: ");
                    double startLatitude = Double.parseDouble(kb.nextLine());
                    System.out.println("Please enter start longttude of the booking: ");
                    double startLongtitude = Double.parseDouble(kb.nextLine());

                    LocationGPS startLocation = new LocationGPS(startLatitude,startLongtitude);
                    System.out.println("Please enter end latitude of the booking: ");
                    double endLatitude = Double.parseDouble(kb.nextLine());
                    System.out.println("Please enter end longitude of the booking: ");
                    double endLongtitude = Double.parseDouble(kb.nextLine());

                    LocationGPS endLocation = new LocationGPS(endLatitude,endLongtitude);
                    System.out.println("Please enter end cost of the booking: ");

                    double costPerMile;


                   double cost = 0;


                   
                    Booking b1 = new Booking(passengerId,vehicleId, bookingDateTime,
                            startLocation,endLocation,cost);

                    if (passengerStore.findPassengerByID(passengerId) != null) {

                        if (vehicleManager.findVehicleByID(vehicleId) != null) {
                            bookingManager.addNewBooking(b1);
                        }else {

                            System.out.println("There is no such passenger in the file");
                        }
                    }
                    break;
                case 9:
                    bookingManager = new BookingManager("bookings.txt",vehicleManager,passengerStore);
                    bookingManager.displayAllBookings();
                    System.out.println("Please enter booking ID : ");
                    int edit = Integer.parseInt(kb.nextLine());
                    bookingManager.editBooking(edit);
                    bookingManager.displayAllBookings();
                    break;

                case 10:
                    bookingManager = new BookingManager("bookings.txt",vehicleManager,passengerStore);
                    bookingManager.displayAllBookings();
                    System.out.println("Please enter booking ID : ");
                    int delete = Integer.parseInt(kb.nextLine());
                    bookingManager.deleteBooking(delete);
                    bookingManager.displayAllBookings();

                case 11:
                    System.out.println("exit ");
                    break;



            }


        }




    }
}

