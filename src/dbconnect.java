/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.*;
/**
 *
 * @author BSCIT
 */
public class dbconnect {
    private Connection conn;
    private Statement st;
    private ResultSet rs;
    
    public dbconnect(){
        
    try{
        
        Class.forName("com.mysql.jdbc.Driver");
        
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dictionary?zeroDateTimeBehavior=convertToNull","root","");
        st = conn.createStatement();
    
    }catch(Exception ex){
            
                System.out.println("error: "+ ex);
                
                }
    };
    
    public void getdata(){
    
        try{
            String query = "select form * mydic";
            rs = st.executeQuery(query);
            System.out.println("Record from Database");
             while(rs.next()){
                 
                 String Word = rs.getString("Word");
                  int Count = rs.getByte ("Count");
                  System.out.println("Word : "+Word+" "+"Count : "+Count);
             }
        
        }catch(Exception ex){
            System.out.println(ex);
        
        }
    
    }
    
    };


