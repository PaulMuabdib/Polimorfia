/**
 * @author: Paul Muabdib
 * @version: 1.0
 */

package puertosSecundarios.baseDeDatos;

import java.util.List;
import entity.SubTipoItemEntity;

/**
 * Realiza operaciones necesarias para con la Base de Datos de los Subtipos de 
 * Items
 * 
 */
public interface SubTiposJDBC {

    /**
     * Guarda un nuevo Subtipo de Item en la Base de Datos
     * 
     * @param subTipo (Subtipo a guardar)
     * @return int rows (La cantidad de registros afectados)
     */
    int guardarNuevoSubTipo (SubTipoItemEntity subTipo);
    
    /**
     * Borra los Subtipos de la Base de Datos
     * 
     * @return int rows (La cantidad de registros afectados)
     */
    int borrarSubTipos ();
    
    /**
     * Crea un listado de los Subtipo de Items
     * 
     * @return List de Subtipos de Items 
     */
    List<SubTipoItemEntity> listarSubTipos ();
}
