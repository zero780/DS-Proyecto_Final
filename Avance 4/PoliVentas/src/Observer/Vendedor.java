/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Observer;

import Modelos.Usuario;

/**
 *
 * @author usuario
 */
public class Vendedor extends Usuario {
    
    private float calificacion ; 

    public Vendedor(String nombres, String apellidos, String telefono, boolean tieneWhatsapp, String email, String direccion, String cedula, String matricula, String rol) {
        super(nombres, apellidos, telefono, tieneWhatsapp, email, direccion, cedula, matricula, rol);
    }

    public Vendedor() {
    }

    public float getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(float calificacion) {
        this.calificacion = calificacion;
    }
    
    
    
}
