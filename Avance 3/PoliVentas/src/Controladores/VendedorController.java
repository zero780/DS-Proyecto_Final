/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Modelos.Usuario;
import Observer.Vendedor;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author usuario
 */
public class VendedorController {
    
    
    public static float obtenerCalificacion(Usuario usuario) throws SQLException{
        
        float calificacion =0;
        //promedioCalificacion
        ResultSet calificaciones = Singleton.Conexion.callProcedure("db_poliventas.calificacionVendedor('"+usuario.getCedula()+"');");
        try {
        while(calificaciones.next()){
            calificacion = Integer.valueOf(calificaciones.getString("promedioCalificacion"));
         
        } 
        }catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return calificacion;
                
        }
    
    public static Vendedor convertirVendedor(Usuario usuario){
        Vendedor vendedor = new Vendedor();
        vendedor.setApellidos(usuario.getApellidos());
        vendedor.setCedula(usuario.getCedula());
        vendedor.setDireccion(usuario.getDireccion());
        vendedor.setEmail(usuario.getEmail());
        vendedor.setNombres(usuario.getNombres());
        vendedor.setRol(usuario.getRol());
        vendedor.setTelefono(usuario.getTelefono());
        vendedor.setTieneWhatsapp(usuario.isTieneWhatsapp());
        return vendedor;
    }
     public static Vendedor crearVendedor(ResultSet info) throws SQLException{
        Vendedor vendedor = null;
        vendedor = new Vendedor();
        vendedor.setNombres(info.getString("nombres"));
        vendedor.setApellidos(info.getString("apellidos"));
        vendedor.setTelefono(info.getString("telefono"));
        vendedor.setCedula(info.getString("cedula"));
        vendedor.setDireccion(info.getString("direccion"));
        vendedor.setEmail(info.getString("email"));
        vendedor.setRol(info.getString("rol"));
        if (info.getString("tieneWhatsapp").equals("1"))                   
            vendedor.setTieneWhatsapp(true);
        else vendedor.setTieneWhatsapp(false);
        vendedor.setCalificacion(obtenerCalificacion(vendedor));

        return vendedor;
     }
    
    
}
