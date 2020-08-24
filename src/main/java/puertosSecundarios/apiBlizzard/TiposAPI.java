/**
 * @author: Paul Muabdib
 * @version: 1.0 
 */
package puertosSecundarios.apiBlizzard;

import java.util.List;
import entity.TipoItemEntity;

/** 
 * Se encarga de importar los Tipos de Items de la API de Blizzard mediante:
 *          1.- Llama a la API que devuelve un JSON con los Tipos de Items
 *          2.- Genera una List de Tipos de Items del JSON
 *          3.- Retorna la List 
 */
public interface TiposAPI {
    
    /**
     * Se encarga de importar los TiposAPI de Items de la API de Blizzard mediante:
          1.- Llama a la API que devuelve un JSON con los TiposAPI de Items
          2.- Genera una List de TiposAPI de Items del JSON
          3.- Retorna la List 
     * 
     * @param token (Token para la conexión con la API)
     * @return List listaTipos (Lista con los TiposAPI de Items) 
     * 
     */
    public List<TipoItemEntity> listarTipos (String token);
    
}
