/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package systemdemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.io.*;
import java.util.InputMismatchException;

import systemdemo.DAO.usersDAO;
import systemdemo.UsersData.Phone;
import systemdemo.UsersData.Users;
import systemdemo.UsersData.factoryPhone;
import systemdemo.UsersData.ExceptionEmpty;
import systemdemo.UsersData.ExceptionRangeNumber;

/**
 *
 * @author i7
 */
public class SystemDemo {
    
     static List<String> names = Arrays.asList(new String[]{"Carlos", "Manuel", "Edgar", "Juan", 
         "Mario", "Gilberto", "Antonio", "Sinue", "Adolfo", "Oswaldo", });
     static List<String>  lastname = Arrays.asList(new String[]{"Martinez", "Guzman", "Perez",
     "Aguilar","Sandoval","Garcia","Lopez","Bustos","Palomino","Cardenas"});
     
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        usersDAO usrDAO = new usersDAO();
        int opc = 0;
        
        Scanner reader = new Scanner(System.in);
        
        InputStreamReader isread = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(isread);
        
        while (opc != 7){
            System.out.println("-OPCIONES-");
            System.out.println("[1] List all users");
            System.out.println("[2] Show");
            System.out.println("[3] Create user");
            System.out.println("[4] Delete user");
            System.out.println("[5] Create random users");
            System.out.println("[6] Delete all users");
            System.out.println("[7] Salir");
            
            System.out.println("Selecciona una opcion [1 a 7]: ");
            opc = reader.nextInt();
            
            switch(opc){
                case (1):
                    System.out.println("List All Users");
                    List<Users> lstUsr = usrDAO.listAllUsers();
                    int cont = 0; 
                    for (Users u: lstUsr){
                       
                       System.out.println ("id: "+cont);
                       System.out.println("Name: "+u.getName());
                       System.out.println("Age: "+u.getAge());
                       System.out.println("e-mail: "+u.getEmail());
                       System.out.println("Location: "+u.getRelocation());
                       List<Phone> lPhones = u.getPhones();
                       System.out.println ("List Phone");
                       for (Phone p : lPhones){
                           String strNum = String.valueOf(p.getNumberPhone());
                           String strFormato ="+"+strNum.substring(0,1)+"("+strNum.substring(1, 4)
                                   +") "+strNum.substring(4, 6)
                                   +" "+strNum.substring(6, 8)
                                   +" "+strNum.substring(8);
                        System.out.println ("Tipo: "+p.getTipo()+" Numero: "+strFormato);
                       }
                       cont++;
                    }
                    break;
                case (2):
                    System.out.println("Opcion [2] Show");
                    System.out.println ("id: ");
                    int id = reader.nextInt();
                    Users oneUser = usrDAO.getUser(id);
                    System.out.println("Name: "+ oneUser.getName());
                    System.out.println("Age: "+ oneUser.getAge());
                    
                    List<Phone> lPhones = oneUser.getPhones();
                    System.out.println ("List Phone");
                    for (Phone p : lPhones){
                        System.out.println ("Tipo: "+p.getTipo()+" Numero: "+p.getNumberPhone());
                    }
                    
                    System.out.println("e-mail: "+ oneUser.getEmail());
                    System.out.println("Relocation: "+ (oneUser.getRelocation()==true?"Yes":"Not"));
                    break;
                case (3):
                    try {
                        System.out.println("Opcion [3]");
                         List<Phone> lstPhone= new ArrayList<>();
                        System.out.println("Name : ");
                        String strName =teclado.readLine();
                        String[] parts = strName.split(" ");
                        if (parts.length < 4 ) throw new ExceptionEmpty("Deben de ser 4 palabras");
                        else if (
                                (parts[0].length()<3 || parts[0].length()>7)||
                                (parts[1].length()<3 || parts[1].length()>7)||
                                (parts[2].length()<3 || parts[2].length()>7)||
                                (parts[3].length()<3 || parts[3].length()>7)) throw new ExceptionEmpty("las palabras deben ser entre 3 y 7 caracteres");
                        
                        if (strName.isEmpty()) throw new ExceptionEmpty("Ningun dato vacio es permitido");
                        int age=0;
                        try {
                            System.out.println("Age : ");
                            age = reader.nextInt();
                            if ((age < 18)||(age>45)) throw new ExceptionRangeNumber("Solo Edad entre 18 y 45 ");
                            
                        } catch (InputMismatchException e){
                            System.out.println(e.getMessage());
                            System.exit(0);
                        }
                        
                        System.out.println("List Phones ");
                        String continuar = "S";
                        while (continuar.compareTo("S")==0){
                            System.out.println("Phone Type: ");
                            String phoneType = reader.next();
                            if (phoneType.isEmpty()) throw new ExceptionEmpty("Ningun dato vacio es permitido");
                            System.out.println("Phone number : ");
                            int phoneNumber = reader.nextInt();
                            factoryPhone fp = new factoryPhone();
                            lstPhone.add(fp.crearTelefono(phoneType, phoneNumber));
                            System.out.println("Otro [S/N] : ");
                            continuar = reader.next();
                        }
                        System.out.println("e-mail : ");
                        String strEmail = reader.next();
                        if (strEmail.contains("@")==true){
                            String[] strEmailpart= strEmail.split("@");
                            if ((strEmailpart[0].length()>=4)&&(strEmailpart[0].length()<=20)){
                                if (strEmailpart[1].contains(".")==true){
                                    System.out.println(strEmailpart[0]);
                                    System.out.println(strEmailpart[1]);
                                    //System.out.println(strEmailpart[1].);
                                    String t = strEmailpart[1];
                                    int posPunto=0;
                                    for (int i = 0; i < t.length();i++ ){
                                        if (t.charAt(i)=='.'){
                                          posPunto=i;
                                        }
                                    }
                                    String strAntesPunto = t.substring(0, posPunto);
                                    System.out.println(strAntesPunto);
                                    String strDespuesPunto = t.substring(posPunto+1);
                                    System.out.println(strDespuesPunto);
                                    
                                    //String[] strEmailname = strEmailpart[1].split("."); No sirve
                                    //System.out.println(strEmailname[0]);
                                    if ((strAntesPunto.length()>=5)&&(strAntesPunto.length()<=10)) {
                                     if ((strDespuesPunto.length()<2)||(strDespuesPunto.length()>4)){
                                         throw new ExceptionEmpty("El prefijo final debe de ser entre 2 y 4 caracteres");
                                     }
                                    }
                                    else throw new ExceptionEmpty("el nombre del correo despues del @ debe de ser entre 5 y 10 caracteres");
                                }else throw new ExceptionEmpty("El correo no es un formato valido, debe de tener . como separador");
                            } else throw new ExceptionEmpty("el nombre del correo debe de ser entre 4 y 20 caracteres");
                        }else throw new ExceptionEmpty("No es un formato Valido de correo le falta el caracter @");
                        //if (parts.length < 4 ) throw new ExceptionEmpty("Deben de ser 4 palabras");
                        Boolean blRelocation = true;
                        Users usr  = new Users();
                        usr.setName(strName);
                        usr.setAge(age);
                        usr.setEmail(strEmail);
                        usr.setPhones(lstPhone);
                        usr.setRelocation(blRelocation);
                        usrDAO.insertUser(usr);
                    }
                    catch(IOException | ExceptionEmpty | ExceptionRangeNumber e){
                        System.out.println(e.getMessage());
                    }
                    
                    break;
                case (4):
                    System.out.println("[4] Delete user");
                    System.out.println ("id: ");
                    int idDel = reader.nextInt();
                    Users userDeleted =usrDAO.deleteUser(idDel);
                    System.out.println ("Usuario Eliminado: "+ userDeleted.getName());
                    break;
                case (5):
                    System.out.println("Opcion [5]");
                    Users usRdn = new Users();
                    
                    String nameUser = (names.get((int)Math.round(Math.random()*9)))+" "
                            +(names.get((int)Math.round(Math.random()*9)))+" "
                            +(lastname.get((int)Math.round(Math.random()*9)))+" "
                            +(lastname.get((int)Math.round(Math.random()*9)));
                    
                    usRdn.setName(nameUser);
                    int agetmp = (int)Math.round(Math.random()*45);
                    agetmp = agetmp<18?agetmp+18:agetmp;
                    usRdn.setAge(agetmp);
                    usRdn.setEmail(nameUser.substring(0, 5)+"@gmail.com");
                    String strPhone1 = String.valueOf((Math.round(Math.random()*9))*9 );
                    strPhone1 =strPhone1.length()==1?strPhone1=strPhone1+"0":strPhone1;
                    String strPhone2 = String.valueOf((Math.round(Math.random()*9))*9 );
                    strPhone2 =strPhone2.length()==1?strPhone2=strPhone2+"0":strPhone2;
                    String strPhone3 = String.valueOf((Math.round(Math.random()*9))*9 );
                    strPhone3 =strPhone3.length()==1?strPhone3=strPhone3+"0":strPhone3;
                    String strPhone4 = String.valueOf((Math.round(Math.random()*9))*9 );
                    strPhone4 =strPhone4.length()==1?strPhone4=strPhone4+"0":strPhone4;
                    String strPhone5 = String.valueOf((Math.round(Math.random()*9))*9 );
                    strPhone5 =strPhone5.length()==1?strPhone5=strPhone5+"0":strPhone5;
                    //int i = 7254902790;
                    List<Phone> lstPhCasa =new  ArrayList<>();
                    String strTipo = "Casa";
                    long NumPhone = Long.parseLong(strPhone1+strPhone2+strPhone3+strPhone4+strPhone5);
                      factoryPhone fp = new factoryPhone();
                            lstPhCasa.add(fp.crearTelefono(strTipo, NumPhone));
                    usRdn.setPhones(lstPhCasa);
                    usRdn.setRelocation(true);
                    if (usrDAO.insertUser(usRdn)==1){
                        System.out.println("Un Usuario Generado Aleatoriamente ");
                    }
                    break;
                case (6):
                    System.out.println("[5] Delete All user");
                    System.out.println (usrDAO.deleteAllUser());
                    break;
                case (7):
                    System.out.println("[7] Saludos!!");
                    break;
                default :
                    System.out.println("just by option between 1 and 7");
                    break;
            }
                
        } 
    }
    
}
