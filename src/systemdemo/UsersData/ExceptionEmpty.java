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
public class ExceptionEmpty extends Exception{
    
    public ExceptionEmpty(){
        super("Ocurrio un Error");
    }
    public ExceptionEmpty(String Message){
        super(Message);
    }
    
}
