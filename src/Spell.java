
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.sql.*;
import java.util.ArrayList;


/**
 *
 * @author BSCIT
 */
public class Spell {
    
 public static Connection getConnection() throws Exception{
  try{
   String driver = "com.mysql.jdbc.Driver";
   String url = "jdbc:mysql://localhost:3306/dictionary?zeroDateTimeBehavior=convertToNull";
   String username = "root";
   String password = "";
   Class.forName(driver);
   
   Connection conn = DriverManager.getConnection(url,username,password);
   System.out.println("Connected");
   return conn;
  } catch(Exception e){System.out.println(e);}
  
  
  return null;
 }


    public static void main(String[] args)throws Exception {
        
      getConnection();
      get();
}
    
    public static ArrayList<String> get() throws Exception{
        try{
            Connection con = getConnection();
            PreparedStatement statement = con.prepareStatement("SELECT * FROM mydic");
           
            ResultSet result = statement.executeQuery();
           
            ArrayList<String> array = new ArrayList<String>();
            while(result.next()){
                System.out.print(result.getString("Word"));
                System.out.print(" ");
                System.out.println(result.getString("Count"));
             
            }
            System.out.println("All records have been selected!");
            return array;
           
        }catch(Exception e){System.out.println(e);}
        return null;
       
    }
    };
    
