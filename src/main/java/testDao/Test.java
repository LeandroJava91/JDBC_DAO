
package testDao;

import Entity.Productos;
import datos.ProductosDao;
import java.util.List;


public class Test {
 
    public static void main(String[] args) {
        
          ProductosDao productosDao= new ProductosDao();
       /* 
        Productos produ= new Productos("celular",18000);
        productosDao.insertar(produ);
        productosDao.insertar(new Productos("tele",300));
        
        Productos prodmod= new Productos(9,"celualar",28000);
        productosDao.actualizar(prodmod);
        */
       Productos eliminarprod= new Productos(10);
       productosDao.eliminar(eliminarprod);
      
        
        
        
        
        List<Productos>productos= productosDao.seleccionar();
        
        for(Productos producto: productos){
            System.out.println(producto);
        }
    }
       
 
}
