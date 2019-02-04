/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

/**
 *
 * @author usuario
 */
public class Usuario {
    
    protected String nombres;
    protected String apellidos;
    protected String telefono;
    protected boolean tieneWhatsapp;
    protected String email;
    protected String direccion;
    protected String cedula;
    protected String matricula;
    protected String rol;

    public Usuario(String nombres, String apellidos, String telefono, boolean tieneWhatsapp, String email, String direccion, String cedula, String matricula, String rol) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.tieneWhatsapp = tieneWhatsapp;
        this.email = email;
        this.direccion = direccion;
        this.cedula = cedula;
        this.rol = rol;
    }

    public Usuario() {
    }
    
    
    
    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public boolean isTieneWhatsapp() {
        return tieneWhatsapp;
    }

    public void setTieneWhatsapp(boolean tieneWhatsapp) {
        this.tieneWhatsapp = tieneWhatsapp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

   

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
    
    
    
}
