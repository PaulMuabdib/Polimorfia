/**
 * @author: Paul Muabdib
 * @version: 1.0
 */
package puertosSecundarios.apiBlizzard;

import java.util.List;
import entity.SubTipoItemEntity;
/** 
 * Se encarga de importar los Subtipos de Items de la API de Blizzard mediante:
 *          1.- Llama a la API que devuelve un JSON con los Subtipos de Items
 *          2.- Genera una List de Subtipos de Items del JSON
 *          3.- Retorna la List 
 */
public interface SubTiposAPI {
    
    /**
     * Se encarga de importar los Subtipos de Items de la API de Blizzard mediante:
     *          1.- Llama a la API que devuelve un JSON con los Subtipos de Items
     *          2.- Genera una List de Subtipos de Items del JSON
     *          3.- Retorna la List 
     * 
     * @param token (Token para la conexión con la API)
     * @return List listaSubTipos (Lista con los Subtipos de Items) 
     */
    public List<SubTipoItemEntity> listarSubTipo (String token);
    
}
