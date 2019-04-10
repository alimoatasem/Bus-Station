package bus.station.vehicles;

public class MiniBus extends Vehicle {

    private int seats;

    MiniBus() {
        seats = 12;
    }

    public int getSeats() {
        return seats;
    }

    @Override
    Boolean checkAvailable(int seats) {
        return seats <= this.seats - getReserved();
    }
}
