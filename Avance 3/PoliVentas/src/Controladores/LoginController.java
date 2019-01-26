/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Singleton.Conexion;
import poliventas.comprador.MenuComprador;
import poliventas.vendedor.MenuVendedor;
import poliventas.administrador.MenuAdministrador;
import Observer.Comprador;
import Modelos.Usuario;
import Observer.Vendedor;
import java.sql.*;
import javax.swing.JOptionPane;


/**
 *
 * @author usuario
 */
public class LoginController {
    
    public static void comprobarUsuario(String usuarioIngreso, char[] contrasena) throws SQLException{
        
        String contra="";
            for (char o : contrasena){
                contra= contra+ o;
            }
        ResultSet consulta= Conexion.callProcedure("db_poliventas.comprobarUsuario('"+usuarioIngreso+"','"+contra+"');");
        
        Usuario usuario = Controladores.UsuarioController.crearUsuario(consulta);
        Conexion.cerrarConexion();
        
        
        
        if (usuario != null){
            switch (usuario.getRol()) {
                case "admin":
                    MenuAdministrador menuAdmin = new MenuAdministrador(usuario);
                    menuAdmin.setVisible(true);
                    System.out.println("Entraste");
                    break;
                case "vendedor":
                    Vendedor vendedor = Controladores.VendedorController.convertirVendedor(usuario);
                    vendedor.setCalificacion(Controladores.VendedorController.obtenerCalificacion(usuario));
                    MenuVendedor menuVendedor = new MenuVendedor(vendedor);
                    menuVendedor.setVisible(true);
                    System.out.println("Entraste");
                    break;
                case "comprador":
                    Comprador comprador = Controladores.CompradorController.convertirComprador(usuario);
                    MenuComprador menuComprador = new MenuComprador(comprador);
                    menuComprador.setVisible(true);
                    System.out.println("Entraste");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Usuario invalido", "Mensaje del sistema",JOptionPane.ERROR_MESSAGE);
                    break;
            }
        }
        else JOptionPane.showMessageDialog(null, "Usuario invalido", "Mensaje del sistema",JOptionPane.ERROR_MESSAGE);

    }
    
    
}
