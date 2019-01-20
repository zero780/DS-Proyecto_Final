/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Observer;

import java.sql.Date;

/**
 *
 * @author Usuario
 */
public class Venta {

    private Comprador cliente;
    private Vendedor vendedor;
    private Date fecha;
    private String estado;
    private String lugarEntrega;
    
    public void notificarVendedor(){
        
    }
    
    public Comprador getCliente() {
        return cliente;
    }

    public void setCliente(Comprador cliente) {
        this.cliente = cliente;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getLugarEntrega() {
        return lugarEntrega;
    }

    public void setLugarEntrega(String lugarEntrega) {
        this.lugarEntrega = lugarEntrega;
    }
}
