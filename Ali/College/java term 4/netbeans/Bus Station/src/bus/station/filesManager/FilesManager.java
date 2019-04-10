package bus.station.filesManager;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import bus.station.vehicles.Vehicle;

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
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return hashMap;
    }

}
