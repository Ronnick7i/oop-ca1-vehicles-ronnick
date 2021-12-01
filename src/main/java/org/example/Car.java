package org.example;

public class Car extends Vehicle
{

    private int NumOfSeats;

    public Car(String type, String make, String model, double milesPerKwH,
               String registration, double costPerMile,
               int year, int month, int day,
               int mileage, double latitude, double longitude,
               int NumOfSeats)
    {

        super(type,make,model,milesPerKwH,
                registration,costPerMile,
                year,month,day,
                mileage,latitude,longitude);

        this.NumOfSeats = NumOfSeats;
    }

    public Car(int id, String type, String make, String model, double milesPerKwH,
               String registration, double costPerMile,
               int year, int month, int day,
               int mileage, double latitude, double longitude,
               int NumOfSeats)
    {
        // call superclass constructor to initialize the fields defined in Vehicle
        super(id,type,make,model,milesPerKwH,
                registration,costPerMile,
                year,month,day,
                mileage,latitude,longitude);

        this.NumOfSeats = NumOfSeats;
    }

    public double getLNumOfSeats() {
        return NumOfSeats;
    }
    public void setNumOfSeats(int NumOfSeats) {
        this.NumOfSeats = NumOfSeats;
    }

    @Override
    public String toString() {
        return "Car{" +
                "NumOfSeats=" + NumOfSeats +
                "} " + super.toString();
    }
}







