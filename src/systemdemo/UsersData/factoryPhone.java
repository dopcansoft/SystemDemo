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
public class factoryPhone implements IPhone {
    
    @Override
    public Phone crearTelefono(String tipo, long numero) {
       Phone p=null;
           p = new Phone(numero, tipo);
       return p;
    }

    
    
}
