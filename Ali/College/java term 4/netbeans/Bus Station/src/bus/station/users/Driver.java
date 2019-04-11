package bus.station.users;

public class Driver extends Employee {



    @Override
    public boolean validate(String ID, String password) {
        boolean validationResult;
        Employee fetchedEmployee = Employee.DriversDictionary.get(ID);
        if (fetchedEmployee != null) {
            validationResult = fetchedEmployee.getPassword().equals(password);
        } else {
            validationResult = false;
        }
        return validationResult;
    }
}
