/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.util.LinkedList;

/**
 *
 * @author usuario
 */
public class Comprador extends Usuario {
    
    LinkedList<Articulo> carrito = new LinkedList<>();

    public Comprador(String nombres, String apellidos, String telefono, boolean tieneWhatsapp, String email, String direccion, String cedula, String matricula, String rol) {
        super(nombres, apellidos, telefono, tieneWhatsapp, email, direccion, cedula, matricula, rol);
    }

    public Comprador() {
    }
    
    public void agregarCarrito(Articulo articulo){
        carrito.add(articulo);
    }
    
    
    
}
