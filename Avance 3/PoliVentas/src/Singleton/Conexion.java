/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labsystems;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author usuario
 */
public class Conexion {
    
    private static Connection connection ;
//    private static final String url = "jdbc:mysql://10.0.2.15:3306/db_labsistems";
//    private static final String user = "root"; //tu usuario
//    private static final String pass = ""; //tu contraseña
    static String dbName = "db_poliVentas";
    static String dbUserName = "ebsn1996";
    static String dbPassword = "1234";
    static String connectionString = "jdbc:mysql://localhost:3306/" + dbName + "?user=" + dbUserName + "&password=" + dbPassword + "&useUnicode=true&characterEncoding=UTF-8";
    
    
    public static void connect(){
        System.out.println("Conectando...");
        try{
            System.out.println("conectando...");
            Conexion.connection = DriverManager.getConnection(connectionString);
            System.out.println("Conectado!!");
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    	
    public static void cerrarConexion(){
	try {
            System.out.println("Cerrando conexión...");
            connection.close();
            System.out.println("Conexión cerrada");
	} catch (SQLException e) {
            System.out.println(e.getMessage());
	}
    }
    

    public static ResultSet consultar(String nombreTabla){
        connect();
        
        ResultSet resultado= null;
        try {
            Statement in = connection.createStatement();
            resultado = in.executeQuery("SELECT * FROM "+nombreTabla);
            System.out.println("si");
            
        } catch (SQLException ex) {
            System.out.println("EXCEPCION: " + ex.getMessage());
        }
        return resultado;        
    }
    
    public static Boolean modificar(String nombreTabla, String cadena){
        connect();
        Boolean resultado= null;
        try {
            Statement in = connection.createStatement();
            resultado = in.execute("UPDATE "+nombreTabla+" set " +cadena);
            System.out.println("si");
            
        } catch (SQLException ex) {
            System.out.println("EXCEPCION: " + ex.getMessage());
        }
        return resultado;        
    }
    
    
    public static ResultSet callProcedure(String nombreTabla){
        connect();
        ResultSet resultado= null;
        try {
            Statement in = connection.createStatement();
            resultado = in.executeQuery("CALL "+nombreTabla);
            System.out.println("si");
            
        } catch (SQLException ex) {
            System.out.println("EXCEPCION: " + ex.getMessage());
            
        }
        return resultado;        
    }
    
    
    public static Boolean ingresar(String nombreTabla, String atributos, String valores){
        connect();
        Boolean resultado= false;
        
        try {
            Statement in = connection.createStatement();
            resultado = in.execute("Insert into db_labsistems."+nombreTabla+" ("+atributos+") values ("+valores+");");
            
        } catch (SQLException ex) {
            System.out.println("EXCEPCION: " + ex.getMessage());
        }
        return resultado; 
    }
    
    
    
    

    
}
