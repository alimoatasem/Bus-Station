
import javafx.application.Application;
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
public class ATM extends Application{

    public static void main(String[] args){
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        
        primaryStage.setTitle("ATM");
        
        MainMenu mainMenu= new MainMenu(primaryStage);
        
        HomeScreen homeScreen=new HomeScreen(primaryStage);
        
        mainMenu.prepareScene();
        homeScreen.prepareScene();
        
        mainMenu.setHomeScreen(homeScreen);
        homeScreen.setMainMenu(mainMenu);
        
        primaryStage.setScene(mainMenu.getScene());
        
        primaryStage.show();
    }
    
}
