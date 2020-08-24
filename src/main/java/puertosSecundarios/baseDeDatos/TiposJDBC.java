/**
 * @author: Paul Muabdib
 * @version: 1.0
 */

package puertosSecundarios.baseDeDatos;

import java.util.List;
import entity.TipoItemEntity;

/** 
 * Realiza operaciones necesarias para con la Base de Datos de los Tipos de Items
 */
public interface TiposJDBC {
    
    /**
     * Guarda un nuevo Tipo de Item 
     *
     * @param tipo (el tipo de Item a guardar)
     * @return int rows (La cantidad de registros afectados)
     */
    int guardarNuevoTipo (TipoItemEntity tipo);
    
    /**
     * Borra todos los Tipos de Items de la Base de Datos
     * 
     * @return int rows (La cantidad de registros afectados)
     */
    int borrarTipos ();
    
    /**
     * Crea un listado de los Tipo de Items
     * 
     * @return List de Tipos de Items
     */
    List<TipoItemEntity> listarTipos ();
    
}
