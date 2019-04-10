package bus.station.vehicles;

public class PrivateCar extends Vehicles {


    private int seats;

    public PrivateCar() {
        seats = 4;
    }

    public int getSeats() {
        return seats;
    }

    @Override
    Boolean checkAvailable(int seats) {
        return seats <= this.seats - getReserved();
    }
}
