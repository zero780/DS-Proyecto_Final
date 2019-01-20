/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Busqueda_Strategy;

/**
 *
 * @author Usuario
 */
public class AvanzadaStrategy implements BusquedaStrategy{

    private String filtros;
    
    
    @Override
    public void busqueda(){
    
    }
    
    public String getFiltros() {
        return filtros;
    }

    public void setFiltros(String filtros) {
        this.filtros = filtros;
    }
}
