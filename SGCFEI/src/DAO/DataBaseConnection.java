/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author midgu
 */
public class DataBaseConnection {
    private Connection connection = null;    

    public void startConnection(){ 
        
        try{
            connection = DriverManager.getConnection("jdbc:mysql://192.168.1.120:3306/sgcfeii?useUnicode=yes&characterEncoding=UTF-8", "seth", "Sndd1026");
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    public Connection getConnection(){
        startConnection();
        return connection;
    }
    
    public void closeConnection(){ 
        if (connection != null) {
            try{
                if(!connection.isClosed()){
                    connection.close();
                }
            }
            catch(SQLException ex){
                System.out.println(ex.getMessage());
            }
        }
    }  
}
