package bus.station;
        
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
public class Employee {
    Stage stage;
    Scene scene;
    MainMenu mainMenu;
    ManagerSystem system;
    
    public Employee(Stage stage){
        this.stage=stage;
    }
    
   
    
    public void prepareScene(){
        Button driver=new Button("Driver");
        Button manager=new Button("Manager");
        
        GridPane grid=new GridPane();
        grid.add(driver,0,0);
        grid.add(manager,0,1);
        
        manager.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){
                stage.setScene(system.getScene());
            }
        });
        
        scene=new Scene(grid,600,400);
    }
    
    public Scene getScene(){
        return scene;
    }
    
    public void setMainMenu(MainMenu mainMenu){
        this.mainMenu=mainMenu;
    }
    
    public void setManagerSystem(ManagerSystem system){
        this.system=system;
    }

    void setmainMenu(MainMenu mainMenu) {
    }

   

}
