/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bus.station;

import bus.station.filesManager.FilesManager;
import javafx.application.Application;
import javafx.stage.Stage;

import java.util.Formatter;
import java.util.HashMap;

/**
 *
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
        primaryStage.setTitle("Bus Station");

        //reading files
        HashMap vehicles = FilesManager.readVehicles();


        MainMenu mainMenu=new MainMenu(primaryStage);
        Passenger passenger=new Passenger(primaryStage);
        Employee employee=new Employee(primaryStage);
        PassengerProfile profile=new PassengerProfile(primaryStage);
        ManagerSystem system=new ManagerSystem(primaryStage);
        
        mainMenu.prepareScene();
        passenger.prepareScene();
        employee.prepareScene();
        profile.prepareScene();
        system.prepareScene();
        
        mainMenu.setPassenger(passenger);
        passenger.setmainMenu(mainMenu);
        
        mainMenu.setEmployee(employee);
        employee.setmainMenu(mainMenu);
        
        passenger.setPassengerProfile(profile);
        profile.setPassenger(passenger);
        
        employee.setManagerSystem(system);
        system.setEmployee(employee);
        
        primaryStage.setScene(mainMenu.getScene());
        
        primaryStage.show();
    }
    
}
