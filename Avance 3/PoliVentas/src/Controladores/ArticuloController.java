/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Modelos.Articulo;
import Observer.Vendedor;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author usuario
 */
public class ArticuloController {
    
    
    public static Articulo crearArticulo(ResultSet info,Vendedor vendedor) throws SQLException{
        
        Articulo articulo = new Articulo();
        articulo.setCategoria(info.getString("categoria"));
        articulo.setDescripcion(info.getString("descripcion"));
        articulo.setFechaPublicacion(info.getString("fechaPublicacion"));
        articulo.setNombre(info.getString("nombre"));
        articulo.setPrecio(Integer.parseInt(info.getString("precio")));
        articulo.setTiempoEntrega(info.getString("tiempoEntrega"));
        articulo.setVendedor(vendedor);


        return articulo;
    }
}
