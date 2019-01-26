/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Observer.Comprador;
import Modelos.*;

/**
 *
 * @author usuario
 */
public class CompradorController {
    
    public static Comprador convertirComprador(Usuario usuario){
        Comprador comprador = new Comprador();
        comprador.setApellidos(usuario.getApellidos());
        comprador.setCedula(usuario.getCedula());
        comprador.setDireccion(usuario.getDireccion());
        comprador.setEmail(usuario.getEmail());
        comprador.setNombres(usuario.getNombres());
        comprador.setRol(usuario.getRol());
        comprador.setTelefono(usuario.getTelefono());
        comprador.setTieneWhatsapp(usuario.isTieneWhatsapp());
        return comprador;
    }
    
}
