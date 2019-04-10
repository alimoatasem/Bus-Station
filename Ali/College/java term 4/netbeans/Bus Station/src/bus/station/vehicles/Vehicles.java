package bus.station.vehicles;

import java.util.HashMap;

public abstract class Vehicles {

    public static HashMap<Integer, Vehicles> vehiclesDictionary;

    private int number;
    private int reserved = 0;

    static String getType(Vehicles vehicles) {

        if (vehicles instanceof Bus) {
            return "bus";
        }
        if (vehicles instanceof MiniBus) {
            return "minibus";
        }
        if (vehicles instanceof PrivateCar) {
            return "private car";
        }

        return "unknown";
    }

    public static Vehicles createType(String type) {
        switch (type) {
            case "bus":
                return new Bus();
            case "minibus":
                return new MiniBus();
            case "private car":
                return new PrivateCar();
            default:
                System.out.println("unknown vehicle type detected, creating Bus as default");
                return new Bus();
        }
    }

    int getReserved() {
        return reserved;
    }

    public void reserve(int seats) {   //don't use before checking if seats are available
        this.reserved += seats;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    abstract Boolean checkAvailable(int seats);

    public abstract int getSeats();
}
