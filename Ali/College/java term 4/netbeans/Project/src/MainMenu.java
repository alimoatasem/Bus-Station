
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

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
    CardAuthentication authentication;
    HomeScreen homeScreen;
    
    public MainMenu(Stage stage){
        this.stage=stage;
    }
    
    
    public void prepareScene() {
    authentication=new CardAuthentication();
        
    Label nameLabel=new Label("Name");
    TextField  nameField=new TextField(); 
    Label numberLabel=new Label("Card Number");
    TextField  numberField=new TextField(); 
    Label balance=new Label();
    Button withdrawal=new Button("Withdrawal");
    Button deposit=new Button("Deposit");
    Button balanceinquiry=new Button("Balance Inquiry");
    Button previous=new Button("Previous");
    Button next=new Button("Next");
    Label validationLabel=new Label();
    
        GridPane grid=new GridPane();
        
        grid.add(nameLabel,0,0);
        grid.add(nameField,1,0);
        grid.add(numberLabel,0,1);
        grid.add(numberField,1,1);
        grid.add(withdrawal,0,2);
        grid.add(deposit,0,3);
        grid.add(balanceinquiry,0,4);
        grid.add(balance,1,4);
        grid.add(previous,0,5);
        grid.add(next,0,6);
        grid.add(validationLabel,1,2);
        
        withdrawal.setOnAction(new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent event) {
            String name=nameField.getText();
            String number=numberField.getText();
            
            boolean valid=authentication.validate(name,number);
            if(valid){
                stage.setScene(homeScreen.getScene());
            } else{
             validationLabel.setText("Wrong Name or Card Number");   
            }
            
        }  
        });
        
        deposit.setOnAction(new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent event) {
            stage.setScene(homeScreen.getScene());
        }  
        });
        
        balanceinquiry.setOnAction(new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent event) {
            Account account=new Account();
            String boi=Double.toString(account.getBalance());
                balance.setText(boi);
        }  
        });
        previous.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Account account=new Account();
                if(account.j>4){
                    JOptionPane.showMessageDialog(null,"no prev done");
                }else{
                   JOptionPane.showMessageDialog(null,account.prev());
                }
                
                }
        });
        next.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Account account=new Account();
                if(account.j<1){
                    JOptionPane.showMessageDialog(null,"no more next");
                }else{
                   JOptionPane.showMessageDialog(null,account.next());
                }
                }
        });
        
        scene=new Scene(grid,600,400);
        
    }
   
    public Scene getScene(){
        return this.scene;
    }
    
    public void setHomeScreen(HomeScreen homeScreen){
        this.homeScreen=homeScreen;
    }
}
