package bus.station;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hitman
 */
public class PassengerProfile {
    Stage stage;
    Scene scene;
    Passenger passenger;
    
    public PassengerProfile(Stage stage){
        this.stage=stage;
    }
    public void prepareScene(){
        
        Label source=new Label("Source:");
        Label destination=new Label("Destination:");
        TextField source1=new TextField();
        TextField destination1=new TextField();
        
        ListView<String> list=new ListView<String>();
        ObservableList<String> vehicles=FXCollections.observableArrayList(
        "Bus","Mini Bus","Private Car");
        list.setItems(vehicles);
        
        ListView<String> list1=new ListView<String>();
        ObservableList<String> trip=FXCollections.observableArrayList(
        "Single","Round");
        list1.setItems(trip); 
        
        GridPane grid=new GridPane();
        grid.add(source,0,0);
        grid.add(destination,1,0);
        grid.add(source1,0,1);
        grid.add(destination1,1,1);
        grid.add(list,0,2);
        grid.add(list1,1,2);
        
        list.setPrefSize(100,70);
        list1.setPrefSize(100,70);
        
        
        list.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {
                System.out.println("clicked on:"+list.getSelectionModel().getSelectedItem());
            }
            
        });
        
        scene=new Scene(grid,600,400);
    }
    public Scene getScene(){
        return scene;
    }
    public void setPassenger(Passenger passenger){
        this.passenger=passenger;
    }
    
}
