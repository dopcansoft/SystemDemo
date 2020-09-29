/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package systemdemo.DAO;

import java.util.ArrayList;
import systemdemo.UsersData.Users;
import java.util.List;

/**
 *
 * @author i7
 */
public class usersDAO {
    
    List<Users> lstUsers= new ArrayList<>();
    
    public int insertUser(Users newUSer){
       int result = -1;
        if (lstUsers.add(newUSer)){
          result = 1;
        }
       return result;
    }
    
    public List<Users> listAllUsers(){
        return lstUsers;
    } 
    
    public Users getUser(int id){
       return lstUsers.get(id);
    }
    
    public Users deleteUser(int id){
      Users usrDeleted = lstUsers.get(id);
      lstUsers.remove(id);
      return usrDeleted;
    }
    public String  deleteAllUser(){
      lstUsers.clear();
      return "All Records deleted";
    }
    
}
