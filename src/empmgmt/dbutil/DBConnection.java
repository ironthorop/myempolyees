/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empmgmt.dbutil;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author sharm
 */
public class DBConnection {
    private static Connection conn;
    static{
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
         conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/thor", "root", "Yash@12345"); 
        }
        catch(ClassNotFoundException ex){
            JOptionPane.showMessageDialog(null, "Cannot load driver:"+ex.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
            
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "DB Error:"+ex.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }
    public static Connection getConnection(){
        return conn;
    }
    public static void closeConnection(){
        try{
            conn.close();
            JOptionPane.showMessageDialog(null, "Disconnected successfully!","Success!",JOptionPane.INFORMATION_MESSAGE);
            
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "DB Error:"+ex.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }
    
    
}
