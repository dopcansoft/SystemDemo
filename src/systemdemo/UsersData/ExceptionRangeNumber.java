/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package systemdemo.UsersData;

/**
 *
 * @author i7
 */
public class ExceptionRangeNumber  extends Exception{
    
    public ExceptionRangeNumber(){
        super("Ocurrio un Error");
    }
    
     public ExceptionRangeNumber(String Message){
        super(Message);
    }
    
}
