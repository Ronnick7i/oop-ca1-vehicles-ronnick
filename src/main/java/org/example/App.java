package org.example;

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
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        System.out.println("\nWelcome to the VEHICLE BOOKINGS MANAGEMENT SYSTEM - CA1 for OOP\n");
        System.out.println("-----------------------------------------------------");
        System.out.println("Main Menu");
        System.out.println("-----------------------------------------------------");
        int choice = 0;
        while (choice != 6) {
            System.out.println("1. Display all Vechicles");
            System.out.println("2. Find Vechicle by Reg Numbers");
            System.out.println("3. Display all passengers");
            System.out.println("4. Add Passenger");
            System.out.println("5. Find passenger by Name");
            System.out.println("6. Exit");
            System.out.println("-----------------------------------------------------");
            choice = kb.nextInt();
            kb.nextLine();

            switch (choice) {
                case 1:
                    VehicleManager vehicleManager = new VehicleManager("vehicles.txt");
                    System.out.println("List of all vehicles");
                    vehicleManager.allVehicles();
                    break;
                case 2:
                    break;
                case 3:
                    PassengerStore pasStore = new PassengerStore("passengers.txt");
                    System.out.println("List of all ");

            }
            // create PassengerStore and load it with passenger records from text file
            PassengerStore passengerStore = new PassengerStore("passengers.txt");
            System.out.println("List of all passengers:");

            passengerStore.addPassenger("Iggy Pop", "iggy@gmail.com", "0838691644", 34.3623, -23.2345);
            passengerStore.addPassenger("Randy Door", "Randy@gmail.com", "0899674223", 34.2345, -15.2345);

            String PassengerName = "Iggy Pop";

            Passenger pa = passengerStore.FindPassengerByName(PassengerName);
            if (pa != null) {
                System.out.println(pa + "This name is Found");
            } else {
                System.out.println("Name not found");
            }

            VehicleManager vehicleManager = new VehicleManager("vehicles.txt");
            System.out.println("List of all Vehicles:");

            String Reg = "151D987105";
            Vehicle v = vehicleManager.FindValueByRegNumber(Reg);
            if (v != null) {
                System.out.println(v);
            } else {
                System.out.println("Vehicle not found");
            }
            System.out.println("Program exiting... Goodbye");
        }



    }
}

