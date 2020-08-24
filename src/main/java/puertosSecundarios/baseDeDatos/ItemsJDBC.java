/**
 * @author: Paul Muabdib
 * @version: 1.0
 */

package puertosSecundarios.baseDeDatos;

import java.util.List;
import entity.ItemEntity;

/** 
 * Realiza operaciones necesarias para con la Base de Datos de los Items
 */
public interface ItemsJDBC {
    
    /**
     * Guarda un nuevo ItemEntity en la Base de Datos
     * 
     * @param item (Nuevo ItemEntity que guardar)
     * @return int rows (La cantidad de registros afectados)
     */
    int guardarNuevoItem (ItemEntity item);
    
    /**
     * Borra los Items de la Base de Datos
     * 
     * @return int rows (La cantidad de registros afectados)
     */
    int borrarItems ();
    
    /**
     * Crea un listado de los Items
     * 
     * @return List de Items
     */
    List <ItemEntity> listarItems ();
    
    
}
