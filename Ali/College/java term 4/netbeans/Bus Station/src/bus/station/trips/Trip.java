package bus.station.trips;

import bus.station.users.Driver;
import bus.station.vehicles.Vehicle;

import java.util.ArrayList;
import java.util.HashMap;

public class Trip {

    public static HashMap<String, Trip> tripsDictionary;

    private String ID;
    private String start;
    private String destination;
    private String time;

    private boolean internal;
    private boolean nonStop;

    private ArrayList<String> stops = new ArrayList<>();
    private int distance;
    private double price;

    private Vehicle vehicle;
    private Driver driver;

    public Trip(String ID, String start, String destination, boolean internal, int distance, Vehicle vehicle) {
        this.ID = ID;
        this.start = start;
        this.destination = destination;
        this.internal = internal;
        this.distance = distance;
        this.vehicle = vehicle;
        this.nonStop = true;

        calculatePrice();
    }

    public Trip(){}   //for reading from files only

    public Trip(String ID,String start, String destination, boolean internal, ArrayList<String> stops, int distance, Vehicle vehicle) {
        this.ID = ID;
        this.start = start;
        this.destination = destination;
        this.internal = internal;
        this.stops = stops;
        this.distance = distance;
        this.vehicle = vehicle;
        this.nonStop = false;

        calculatePrice();
    }

    public void calculatePrice() {
        double factor = 0.5;
        this.price = (this.distance * factor + stops.size() * 20) * (internal ? 1 : 1.5);
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public void addStop(String stop) {
        stops.add(stop);
    }


    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public boolean isInternal() {
        return internal;
    }

    public void setInternal(boolean internal) {
        this.internal = internal;
    }

    public boolean isNonStop() {
        return nonStop;
    }

    public void setNonStop(boolean nonStop) {
        this.nonStop = nonStop;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
