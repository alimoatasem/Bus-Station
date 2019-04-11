package bus.station.users;

import java.util.HashMap;

public abstract class Employee implements User {

    public static HashMap<String, Employee> DriversDictionary;
    public static HashMap<String, Employee> ManagersDictionary;

    private String userName;
    private String password;

    private String ID;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
}
