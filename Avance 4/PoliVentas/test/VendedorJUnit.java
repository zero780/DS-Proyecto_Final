
import Controladores.ArticuloController;
import Modelos.Articulo;
import Observer.Vendedor;
import java.sql.ResultSet;
import java.sql.SQLException;
import junit.framework.TestCase;
import static junit.framework.TestCase.assertEquals;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author usuario
 */
public class VendedorJUnit extends TestCase{
    public void primerTest() throws SQLException{
        ResultSet busqueda = Singleton.Conexion.callProcedure("obtenerArticulo(2);");
        if(busqueda.next()){
            Vendedor vendedorProducto = Controladores.VendedorController.crearVendedor(busqueda);
            assertEquals("0999999999", vendedorProducto.getCedula());
        }
        
    }
    
}
