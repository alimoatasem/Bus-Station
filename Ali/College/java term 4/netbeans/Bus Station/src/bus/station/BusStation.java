/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bus.station;

import bus.station.filesManager.FilesManager;
import bus.station.trips.Trip;
import bus.station.users.Driver;
import bus.station.users.Passenger;
import bus.station.vehicles.Vehicle;
import javafx.application.Application;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.print.Book;
import java.security.cert.TrustAnchor;
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
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        //reading files
        Vehicle.vehiclesDictionary = FilesManager.readVehicles();
        Trip.tripsDictionary = FilesManager.readTrips();  // must be after vehicles and drivers
        Passenger.passengersDictionary = FilesManager.readPassengers();

        SwingUtilities.invokeLater(() -> {
            ViewTrips viewTrips = new ViewTrips();
            BookOrView bookOrView = new BookOrView(viewTrips);
            Login login = new Login(bookOrView);
            login.setVisible(true);
        });
    }

}
