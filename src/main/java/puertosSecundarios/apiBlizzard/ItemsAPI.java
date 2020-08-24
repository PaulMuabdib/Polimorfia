/**
 * @author: Paul Muabdib
 * @version: 1.0
 */
package puertosSecundarios.apiBlizzard;

import java.util.List;
import entity.ItemEntity;

/** 
 * Se encarga de importar los Items de la API de Blizzard mediante:
 *          1.- Busqueda de todas las respuestas con codigo 200 hasta el ID 179999
 *          2.- Obtención de los datos del ITEM (ID,NOMBRE,ID TIPO, ID SUBTIPO)
 *          3.- Creacion de una LIST con los ITEMS
 *          4.- Debido al lo largo del proceso regenerar el Token cuando sea necesario
 */
public interface ItemsAPI {
    
    /**
     * Método que busca los ItemsAPI en la API de Blizzard
     * 
     * @param token (TokenAPI inicial con el que empezaremos las búsquedas)
     * @return listaItems (Lista de ItemsAPI encontrados)
     */
    public List<ItemEntity> listarItem (String token);
    
}
