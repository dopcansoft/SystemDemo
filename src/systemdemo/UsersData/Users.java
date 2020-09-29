/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package systemdemo.UsersData;

import java.util.List;

/**
 *
 * @author i7
 */
public class Users {
    
    String Name; 
    int Age;
    Boolean relocation; 
    List<Phone> Phones; 
    String Email; 

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int Age) {
        this.Age = Age;
    }

    public Boolean getRelocation() {
        return relocation;
    }

    public void setRelocation(Boolean relocation) {
        this.relocation = relocation;
    }

    public List<Phone> getPhones() {
        return Phones;
    }

    public void setPhones(List<Phone> Phone) {
        this.Phones = Phone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }
    
    
}
