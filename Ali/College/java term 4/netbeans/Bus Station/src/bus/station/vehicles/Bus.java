package bus.station.vehicles;

public class Bus extends Vehicles {

    private int seats;

    Bus() {
        seats = 32;
    }

    public int getSeats() {
        return seats;
    }

    @Override
    Boolean checkAvailable(int seats) {
        return seats <= this.seats - getReserved();
    }
}
