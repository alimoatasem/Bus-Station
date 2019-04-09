package bus.station;
        
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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
public class Passenger {
    Stage stage;
    Scene scene;
    MainMenu mainMenu;
    PassengerProfile profile;
    PassengerAuthentication authentication;
    
    public Passenger(Stage stage){
        this.stage=stage;
    }
    
   
    
    public void prepareScene(){
        authentication=new PassengerAuthentication();
        
        Label name=new Label("Name:");
        Label password=new Label("Password:");
        TextField name1=new TextField();
        TextField pass1=new TextField();
        Button enter=new Button("Enter");
        Label validationLabel=new Label();
        
        GridPane grid=new GridPane();
        grid.add(name,0,0);
        grid.add(name1,1,0);
        grid.add(password,0,1);
        grid.add(pass1,1,1);
        grid.add(enter,0,2);
        grid.add(validationLabel,2,0);
        
        enter.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){
               String name=name1.getText(); 
               String number=pass1.getText();
               
            boolean valid=authentication.validate(name,number);
            if(valid){
                 stage.setScene(profile.getScene());
            } else{
             validationLabel.setText("Wrong Name or Pass");   
            }
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

    void setmainMenu(MainMenu mainMenu) {
    }
    
    public void setPassengerProfile(PassengerProfile profile){
        this.profile=profile;
    }

}
