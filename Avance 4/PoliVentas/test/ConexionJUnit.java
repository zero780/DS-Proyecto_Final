
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
public class ConexionJUnit extends TestCase{
    public void primerTest() throws SQLException{
        ResultSet busqueda = Singleton.Conexion.callProcedure("obtenerArticulo(2);");
        System.out.println(busqueda); 
        assertNull(busqueda);
    }
}
