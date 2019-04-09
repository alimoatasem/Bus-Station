package bus.station;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
public class MainMenu {
    Stage stage;
    Scene scene;
    Passenger passenger;
    Employee employee;
    
    public MainMenu(Stage stage){
        this.stage=stage;
}
    
    public void prepareScene(){
        
        
        Label welcome=new Label("Welcome to Bus Station");
        Button passenger1=new Button("Passenger");
        Button employee1=new Button("Employee");
        
        GridPane grid=new GridPane();
        
        grid.add(welcome,0,0);
        grid.add(passenger1,0,1);
        grid.add(employee1,0,2);
        
        //functions of buttons
        passenger1.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){
                stage.setScene(passenger.getScene());
            }
        });
        
        employee1.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){
                stage.setScene(employee.getScene());
            }
        });
        
        scene=new Scene(grid,600,400);
        
        
    }
    
    public Scene getScene(){
        return this.scene;
}
    
    public void setPassenger(Passenger passenger){
        this.passenger=passenger;
    }
    
    public void setEmployee(Employee employee){
        this.employee=employee;
    }
}
