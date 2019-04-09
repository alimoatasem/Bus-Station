package bus.station;

import javafx.scene.Scene;
import javafx.scene.control.Button;
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
public class ManagerSystem {
    Stage stage;
    Scene scene;
    Employee employee;
    
    
    public ManagerSystem(Stage stage){
        this.stage=stage;
    }
    
    public void prepareScene(){
        Button boi=new Button("boi");
        
        GridPane grid=new GridPane();
        grid.add(boi,0,0);
        
        scene=new Scene(grid,600,400);
    }
    
    public Scene getScene(){
        return scene;
    }
    
    public void setEmployee(Employee employee){
        this.employee=employee;
    }
}
