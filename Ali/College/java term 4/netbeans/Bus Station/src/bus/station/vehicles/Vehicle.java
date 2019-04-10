package bus.station.vehicles;

public abstract class Vehicle {

    private int number;
    private int reserved = 0;

    static String getType(Vehicle vehicle) {

        if (vehicle instanceof Bus) {
            return "bus";
        }
        if (vehicle instanceof MiniBus) {
            return "minibus";
        }

        if (vehicle instanceof PrivateCar) {
            return "private car";
        }

        return "unknown";
    }

    public static Vehicle createType(String type) {
        switch (type) {
            case "bus":
                return new Bus();
            case "minibus":
                return new MiniBus();
            case "private car":
                return new PrivateCar();
            default:
                System.out.println("unknown vehicle type detected, creating bus.station.vehicles.Bus as default");
                return new Bus();
        }
    }

        int getReserved () {
            return reserved;
        }

        public void reserve(int seats){   //don't use before checking if seats are available
            this.reserved += seats;
        }

        public int getNumber () {
            return number;
        }

        public void setNumber(int number){
            this.number = number;
        }

        abstract Boolean checkAvailable ( int seats);
        public abstract int getSeats ();
    }
