/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

/**
 *
 * @author Vitor
 */

import  java.sql.Connection;
import java.sql.DriverManager;

import java.sql.SQLException;


public class SQLConnection {
    public static Connection con; 
    static String drive = "com.microsoft.sqlserver.jdbc.SQLServerDriver"; 
    static String url = "jdbc:sqlserver://localhost\\SQLEXPRESS:1433;databaseName = DB_BACK"; 
    static String usuario = "user"; 
    static String senha = "1234567";
    
    public void connect() throws ClassNotFoundException,InstantiationException,IllegalAccessException,SQLException {
        Class.forName(drive).newInstance(); 
        con = DriverManager.getConnection(url, usuario, senha); 
    }
    public void disconnect()throws SQLException{
        con.close();
    }

}