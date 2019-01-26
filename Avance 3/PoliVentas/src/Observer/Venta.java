/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Observer;

/**
 *
 * @author usuario
 */
public class Venta {
    protected boolean estadoVenta;
    protected String fecha;
    protected float total;
    protected Vendedor vendedor ;
    protected Comprador comprador;
    protected Vendedor vendedorComprador;
    protected String tipoPago;

    
    public Venta() {
    }

    
    public String getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
    }

    
    public boolean isEstadoVenta() {
        return estadoVenta;
    }

    public void setEstadoVenta(boolean estadoVenta) {
        this.estadoVenta = estadoVenta;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public Comprador getComprador() {
        return comprador;
    }

    public void setComprador(Comprador comprador) {
        this.comprador = comprador;
    }

    public Vendedor getVendedorComprador() {
        return vendedorComprador;
    }

    public void setVendedorComprador(Vendedor vendedorComprador) {
        this.vendedorComprador = vendedorComprador;
    }
    
    
    
}
