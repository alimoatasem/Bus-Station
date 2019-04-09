package bus.station;
import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hitman
 */
public class PassengerAuthentication {
    HashMap usersDictionary;
    
    public PassengerAuthentication(){
        usersDictionary=new HashMap();
        usersDictionary.put("ali", "0000");
    }
    public boolean validate(String name,String number){
        boolean validationResult;
        String fetchedNumber=(String) usersDictionary.get(name);
        if(fetchedNumber!=null){
            validationResult=fetchedNumber.equals(number);
        } else{
            validationResult=false;
        }
        return validationResult;
    }
}
