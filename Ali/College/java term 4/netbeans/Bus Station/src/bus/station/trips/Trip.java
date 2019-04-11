package bus.station.trips;

import bus.station.users.Driver;
import bus.station.vehicles.Vehicle;

public class Trip {

    private int ID;
    private String start;
    private String destination;
    private String time;

    private boolean internal;
    private boolean nonStop;

    private String[] stops;
    private int distance;
    private double price;

    private Vehicle vehicle;
    private Driver driver;

    public Trip(int ID, String start, String destination, boolean internal, int distance, Vehicle vehicle) {
        this.ID = ID;
        this.start = start;
        this.destination = destination;
        this.internal = internal;
        this.distance = distance;
        this.vehicle = vehicle;
        this.nonStop = true;

        calculatePrice();
    }

    public Trip(int ID,String start, String destination, boolean internal, String[] stops, int distance, Vehicle vehicle) {
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

    private void calculatePrice() {
        double factor = 0.5;
        this.price = (this.distance * factor + stops.length * 20) * (internal ? 1 : 1.5);
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

}
