package bus.station.filesManager;

import bus.station.users.Passenger;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import bus.station.vehicles.Vehicles;

import java.io.FileReader;
import java.util.HashMap;


public class FilesManager {

    public static HashMap<Integer, Vehicles> readVehicles() {

        HashMap<Integer, Vehicles> hashMap = new HashMap<>();

        try {

            FileReader filereader = new FileReader("vehicles.CSV");
            //skip header
            CSVReader csvReader = new CSVReaderBuilder(filereader).withSkipLines(1).build();
            String[] nextRecord;
            //read line by line till null
            while ((nextRecord = csvReader.readNext()) != null) {

                System.out.println(nextRecord[0] + nextRecord[1]);
                Vehicles vehicles = Vehicles.createType(nextRecord[1]);
                vehicles.setNumber(Integer.parseInt(nextRecord[0]));
                vehicles.reserve(Integer.parseInt(nextRecord[2]));

                hashMap.put(Integer.parseInt(nextRecord[0]), vehicles);

            }
        }
        catch (Exception e) {
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

                System.out.println(nextRecord[0] + nextRecord[1] + nextRecord[2]);

                passenger.setId(nextRecord[0]);
                passenger.setUserName(nextRecord[1]);
                passenger.setPassword(nextRecord[2]);
                passenger.setCredit(Integer.parseInt(nextRecord[3]));
                passenger.setBookedTrips(Integer.parseInt(nextRecord[4]));
                // TODO: 4/10/2019 loop on booked trips and save IDs
                hashMap.put(passenger.getUserName(), passenger);

            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return hashMap;
    }



}
