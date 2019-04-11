package bus.station.users;
import java.util.HashMap;


public class Passenger implements User {

    //key is username
    public static HashMap<String,Passenger> passengersDictionary;

    private String userName;
    private String password;

    private String id;
    private int credit = 0;

    private int bookedTrips;


    @Override
    public boolean validate(String name, String password) {
        boolean validationResult;
        Passenger fetchedPassenger = passengersDictionary.get(name);
        if (fetchedPassenger != null) {
            validationResult = fetchedPassenger.getPassword().equals(password);
        } else {
            validationResult = false;
        }
        return validationResult;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    private String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public int getBookedTrips() {
        return bookedTrips;
    }

    public void setBookedTrips(int bookedTrips) {
        this.bookedTrips = bookedTrips;
    }
}
