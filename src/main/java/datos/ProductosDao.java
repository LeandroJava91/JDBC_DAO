
package datos;

import Entity.Productos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ProductosDao {
    
    private static final String SQL_SELECT = "SELECT id, nombre, precio FROM productos";
    private static final String SQL_INSERT= "INSERT INTO productos (nombre, precio) VALUES (?,?)";    
    private static final String SQL_UPDATE= "UPDATE productos SET  nombre=?, precio=? WHERE id=?";
    private static final String SQL_DELETE= "DELETE FROM productos WHERE id=?";
    
    
    
    ///////////////////MOSTRAR////////////////////////
    
    public List<Productos> seleccionar(){
        
        Connection conn= null;
        PreparedStatement stmt=null;
        ResultSet rs=null;
        Productos productos=null;
        List<Productos>product= new ArrayList<>();
        
        try {
            conn=conexion.getConnection();
            stmt=conn.prepareStatement(SQL_SELECT);
            rs=stmt.executeQuery();
            while( rs.next()){
                int id= rs.getInt("id");
                String nombre= rs.getString("nombre");
                int precio= rs.getInt("precio");
                
                productos= new Productos(id,nombre,precio);
                product.add(productos);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        
        finally{
            
            try {
                conexion.close(rs);
                conexion.close(stmt);
                conexion.close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);                
            }
            
    }
                
        
        return product;
    }
    
    //////////////////INSERTAR/////////////////////
    
    public int insertar(Productos pro){
        Connection conn=null;
        PreparedStatement stmt=null;
        int registros=0;
        Productos prod= null;
        
        try {
            conn=conexion.getConnection();
            stmt=conn.prepareStatement(SQL_INSERT);
            
            stmt.setString(1,pro.getNombre());
            stmt.setInt(2, pro.getPrecio());
            registros= stmt.executeUpdate();
            
        } catch (SQLException ex) {
            
        }
        
        finally{            
            try {
                conexion.close(conn);
                conexion.close(stmt);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);    
            }
        }
        
        return registros;
        
    }
    
    ////////////////////ACTUALIZAR///////////////////////////
    
    public int actualizar(Productos prod){
        Connection conn=null;
        PreparedStatement stmt=null;
        int registros=0;
        
        try {
            conn=conexion.getConnection();
            stmt=conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1,prod.getNombre());
            stmt.setInt(2,prod.getPrecio());
            stmt.setInt(3,prod.getId());
            
            registros=stmt.executeUpdate();
           
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        
        finally{
            try {
                conexion.close(stmt);
                conexion.close(conn);
            } catch (SQLException ex) {
                
            }
        }
        
        return registros;
    }
    
    ////////////////////ELIMINAR///////////////////////////
    
    public int eliminar(Productos productos){
        
        Connection conn=null;
        PreparedStatement stmt= null;
        int registros=0;
        
        try {
            conn=conexion.getConnection();
            stmt=conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, productos.getId());
            registros=stmt.executeUpdate();
        } catch (SQLException ex) {
          ex.printStackTrace(System.out);  
        }
        
        finally{
            try {
                conexion.close(stmt);
                conexion.close(conn);
                
            } catch (SQLException ex) {
             ex.printStackTrace(System.out);   
            }
        }
        
        return registros;
    }
    
}
