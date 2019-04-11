/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bus.station;

import bus.station.filesManager.FilesManager;
import bus.station.users.Passenger;
import bus.station.vehicles.Vehicle;
import javafx.application.Application;
import javafx.stage.Stage;

import java.util.Formatter;

/**
 * @author hitman
 */
public class BusStation extends Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        //reading files
        Vehicle.vehiclesDictionary = FilesManager.readVehicles();
        Passenger.passengersDictionary = FilesManager.readPassengers();



        primaryStage.setTitle("Bus Station");

        MainMenu mainMenu = new MainMenu(primaryStage);
        PassengerLogin passengerLogin = new PassengerLogin(primaryStage);
        EmployeeSelect employeeSelect = new EmployeeSelect(primaryStage);
        PassengerProfile profile = new PassengerProfile(primaryStage);
        ManagerSystem system = new ManagerSystem(primaryStage);

        mainMenu.prepareScene();
        passengerLogin.prepareScene();
        employeeSelect.prepareScene();
        profile.prepareScene();
        system.prepareScene();

        mainMenu.setPassengerLogin(passengerLogin);
        passengerLogin.setmainMenu(mainMenu);

        mainMenu.setEmployeeSelect(employeeSelect);
        employeeSelect.setMainMenu(mainMenu);

        passengerLogin.setPassengerProfile(profile);
        profile.setPassengerLogin(passengerLogin);

        employeeSelect.setManagerSystem(system);
        system.setEmployeeSelect(employeeSelect);

        primaryStage.setScene(mainMenu.getScene());

        primaryStage.show();
    }

}
