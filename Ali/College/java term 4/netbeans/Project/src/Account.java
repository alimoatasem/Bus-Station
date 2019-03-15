
import javafx.scene.control.Label;
import javafx.embed.swing.JFXPanel;
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
public class Account {
    private double balance=5.0;
    public double amount;
    
    public double history[] = new double[5];
    int j=-1;
    public Account(double initialBalance){
        if(initialBalance>0.0){
            balance=initialBalance;
    }
    }

    public Account(float balance) {
		super();
		this.balance = balance;
	}
    

    Account() {
    }
        public void deposit(double amount){
        
            balance=balance+amount;
        
            for(int i=4;i>0;i--){
            history[i]=history[i-1];    
            }
            history[0]=amount;
        }
        public void withdraw(double amount){
            if(amount>balance){
                JOptionPane.showMessageDialog(null,"insufficient");
            }else{
            
            balance=balance-amount;
            
            for(int i=4;i>0;i--){
                history[i]=history[i-1];
            }
        history[0]=amount;
        }
        }
        
        public double getBalance(){
            return balance;
        }
        public double prev(){
        
        
            return history[++j];
        }
        public double next(){
       
            return history[--j];
        }
             
}
