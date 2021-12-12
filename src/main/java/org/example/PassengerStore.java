package org.example;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PassengerStore {

    private final ArrayList<Passenger> passengerList;

    public PassengerStore(String fileName) {
        this.passengerList = new ArrayList<>();
        loadPassengerDataFromFile(fileName);
    }

    public List<Passenger> getAllPassengers() {
        return this.passengerList;
    }

    public void displayAllPassengers() {
        for (Passenger p : this.passengerList) {
            System.out.println(p.toString());
        }
    }

public Passenger FindPassengerByName(String PassengerName){
        for (Passenger pa: passengerList){
            if(pa.getName().equalsIgnoreCase(PassengerName)){
                return pa;
            }
        }
        return null;
}
public Passenger findPassengerByID(int passengerId){
    for (Passenger ps: passengerList){
        if(ps.getId() == (passengerId)){
            return ps;
        }
    }
    return null;

}




    /**
     * Read Passenger records from a text file and create and add Passenger
     * objects to the PassengerStore.
     */


    private void loadPassengerDataFromFile(String filename) {

        try {
            Scanner sc = new Scanner(new File(filename));

            sc.useDelimiter("[,\r\n]+");

            while (sc.hasNext()) {
                int id = sc.nextInt();
                String name = sc.next();
                String email = sc.next();
                String phone = sc.next();
                double latitude = sc.nextDouble();
                double longitude = sc.nextDouble();


                passengerList.add(new Passenger(id, name, email, phone, latitude, longitude));
            }
            sc.close();

        } catch (IOException e) {
            System.out.println("Exception thrown. " + e);
        }
    }

    // TODO - see functional spec for details of code to add
    public void addPassenger(String name, String email, String phone, double latitude, double longitude){
        Passenger passenger1 = new Passenger(name, email,phone, latitude, longitude);
        boolean found = false;
        for(Passenger p:passengerList){
            if(p.equals(passenger1)){
                found = true;
                break;
            }
        }
        if(found == false){
            passengerList.add(passenger1);
        }
    }





}
