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
public class Phone {
    
    long numberPhone;
    String tipo;
    
    Phone(long phone, String tipo){
       this.numberPhone = phone;
       this.tipo = tipo;
    }

    public long getNumberPhone() {
        return numberPhone;
    }

    public String getTipo() {
        return tipo;
    }
    
    
    
}
