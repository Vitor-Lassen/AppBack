
package appback;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


import java.util.logging.Logger;


public class AppBack {

    
    static Connection con; 
    static String drive = "com.microsoft.sqlserver.jdbc.SQLServerDriver"; 
    static String url = "jdbc:sqlserver://localhost\\SQLEXPRESS:1433;databaseName = DB_BACK"; 
    static String usuario = "cliente"; 
    static String senha = "1234567";


public static void main(String[] args) throws ClassNotFoundException,SQLException,InstantiationException,IllegalAccessException {
   
        Class.forName(drive).newInstance(); 
        con = DriverManager.getConnection(url, usuario, senha); 
        System.out.println("Conexão Realizada com Sucesso"); 
    }
}


    

