/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Modelos.Usuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author usuario
 */
public class UsuarioController {
    
    
    public static Usuario crearUsuario(ResultSet info){
        Usuario usuario = null;
        try {
            while(info.next()){
                usuario = new Usuario();
                usuario.setNombres(info.getString("nombres"));
                usuario.setApellidos(info.getString("apellidos"));
                usuario.setTelefono(info.getString("telefono"));
                usuario.setCedula(info.getString("cedula"));
                usuario.setDireccion(info.getString("direccion"));
                usuario.setEmail(info.getString("email"));
                usuario.setRol(info.getString("tipo"));
                if (info.getString("tieneWhatsapp").equals("1"))                   
                    usuario.setTieneWhatsapp(true);
                else usuario.setTieneWhatsapp(false);


               
            }
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuario;
    }
    
}
