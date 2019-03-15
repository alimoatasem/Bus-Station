
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
public class HomeScreen {
    Stage stage;
    Scene scene;
    MainMenu mainMenu;
    
    public HomeScreen(Stage stage){
        this.stage=stage;
    }

    HomeScreen() {
    }
    
    public void prepareScene(){
        Button one=new Button("   1   ");
        Button two=new Button("   2   ");
        Button three=new Button("   3   ");
        Button four=new Button("   4   ");
        Button five=new Button("   5   ");
        Button six=new Button("   6   ");
        Button seven=new Button("   7   ");
        Button eight=new Button("   8   ");
        Button nine=new Button("   9   ");
        Button zero=new Button("   0   ");
        Button deposit=new Button("Deposit");
        Button withdraw=new Button("Withdraw");
        Button back=new Button("Back");
        Button clear=new Button("Clear");
        Label number=new Label();
        Label dep=new Label();
        Label with=new Label();
        GridPane grid=new GridPane();
        grid.add(one,0,0);
        grid.add(two,1,0);
        grid.add(three,2,0);
        grid.add(four,0,1);
        grid.add(five,1,1);
        grid.add(six,2,1);
        grid.add(seven,0,2);
        grid.add(eight,1,2);
        grid.add(nine,2,2);
        grid.add(clear,0,3);
        grid.add(zero,1,3);
        grid.add(number,3,0);
        grid.add(deposit,3,1);
        grid.add(withdraw,3,2);
        grid.add(back,3,3);
        grid.add(dep,5,1);
        grid.add(with,5,2);
        
        
        one.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String Enternumber=number.getText() +"1";
                number.setText(Enternumber);
            }
        });
        two.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String Enternumber=number.getText() +"2";
                number.setText(Enternumber);
            }
        });
        three.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String Enternumber=number.getText() +"3";
                number.setText(Enternumber);
            }
        });
        four.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String Enternumber=number.getText() +"4";
                number.setText(Enternumber);
            }
        });
        five.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String Enternumber=number.getText() +"5";
                number.setText(Enternumber);
            }
        });
        six.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String Enternumber=number.getText() +"6";
                number.setText(Enternumber);
            }
        });
        seven.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String Enternumber=number.getText() +"7";
                number.setText(Enternumber);
            }
        });
        eight.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String Enternumber=number.getText() +"8";
                number.setText(Enternumber);
            }
        });
        nine.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String Enternumber=number.getText() +"9";
                number.setText(Enternumber);
            }
        });
        zero.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String Enternumber=number.getText() +"0";
                number.setText(Enternumber);
            }
        });
        deposit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               
                Account account=new Account();
                String Enternumber=number.getText();
                double boi = Double.parseDouble(Enternumber);
                account.deposit(boi);
                dep.setText("The val is: "+ account.getBalance()); 
            }

        });
        withdraw.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                
                Account account=new Account();
                String Enternumber=number.getText();
                double boi = Double.parseDouble(Enternumber);
                account.withdraw(boi);
                with.setText("The Val is: "+ account.getBalance()); 
            }
        });
        back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stage.setScene(mainMenu.getScene());
            }
        });
        clear.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                
                number.setText("");
                }
        });
        
        
        scene=new Scene(grid,600,400);
    }


   public Scene getScene() {
   return scene; 
   }
   
   public void setMainMenu(MainMenu mainMenu){
       this.mainMenu=mainMenu;
   }
}


