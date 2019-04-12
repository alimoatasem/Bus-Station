package bus.station.filesManager;

import bus.station.trips.Trip;
import bus.station.users.Driver;
import bus.station.users.Passenger;
import bus.station.vehicles.Vehicle;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import java.io.FileReader;
import java.util.HashMap;


public class FilesManager {

    public static HashMap<Integer, Vehicle> readVehicles() {

        HashMap<Integer, Vehicle> hashMap = new HashMap<>();

        try {

            FileReader filereader = new FileReader("vehicles.CSV");
            //skip header
            CSVReader csvReader = new CSVReaderBuilder(filereader).withSkipLines(1).build();
            String[] nextRecord;
            //read line by line till null
            while ((nextRecord = csvReader.readNext()) != null) {

                Vehicle vehicle = Vehicle.createType(nextRecord[1]);
                vehicle.setNumber(Integer.parseInt(nextRecord[0]));
                vehicle.reserve(Integer.parseInt(nextRecord[2]));

                hashMap.put(Integer.parseInt(nextRecord[0]), vehicle);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hashMap;
    }

    public static HashMap<String, Passenger> readPassengers() {

        HashMap<String, Passenger> hashMap = new HashMap<>();

        try {

            FileReader filereader = new FileReader("passengers.CSV");

            //skip header
            CSVReader csvReader = new CSVReaderBuilder(filereader).withSkipLines(1).build();
            String[] nextRecord;

            Passenger passenger = new Passenger();

            //read line by line till null
            while ((nextRecord = csvReader.readNext()) != null) {

                passenger.setId(nextRecord[0]);
                passenger.setUserName(nextRecord[1]);
                passenger.setPassword(nextRecord[2]);
                passenger.setCredit(Integer.parseInt(nextRecord[3]));
                passenger.setBookedTrips(Integer.parseInt(nextRecord[4]));
                int bookedTrips = Integer.parseInt(nextRecord[4]);
                if (bookedTrips != 0) {
                    for (int i = 5; i < nextRecord.length; i++) {
                        passenger.bookTrip(nextRecord[i]);
                    }
                }
                hashMap.put(passenger.getUserName(), passenger);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hashMap;
    }

    public static HashMap<String, Trip> readTrips() {
        HashMap<String, Trip> hashMap = new HashMap<>();

        try {

            FileReader filereader = new FileReader("trips.CSV");

            //skip header
            CSVReader csvReader = new CSVReaderBuilder(filereader).withSkipLines(1).build();
            String[] nextRecord;

            Trip trip = new Trip();

            //read line by line till null
            while ((nextRecord = csvReader.readNext()) != null) {

                trip.setID(nextRecord[0]);
                trip.setStart(nextRecord[4]);
                trip.setDestination(nextRecord[5]);
                trip.setTime(nextRecord[6]);
                trip.setDistance(Integer.parseInt(nextRecord[7]));
                trip.setVehicle(Vehicle.vehiclesDictionary.get(Integer.parseInt(nextRecord[8])));
                if (Integer.parseInt(nextRecord[3]) != 0) {
                    for (int i = 10; i < nextRecord.length; i++) {
                        trip.addStop(nextRecord[i]);
                    }
                }
                trip.calculatePrice();
                trip.setDriver(Driver.DriversDictionary.get(nextRecord[9]));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hashMap;
    }


}
