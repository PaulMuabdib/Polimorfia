/**
 * @author: Paul Muabdib
 * @version: 1.0
 */

package negocio;

import entity.ItemEntity;
import adaptadoresSecundarios.apiBlizzard.ItemsApiImpl;
import adaptadoresSecundarios.apiBlizzard.TokenApiImpl;
import adaptadoresSecundarios.baseDeDatos.ItemsJDBCImpl;
import java.util.List;
import puertosSecundarios.baseDeDatos.ItemsJDBC;
import puertosSecundarios.apiBlizzard.ItemsAPI;
import puertosSecundarios.apiBlizzard.TokenAPI;

/** 
 * Actualizador de los ItemsAPI, retornará el boolean con true si se ha 
 efectuado correctamente o de lo contrario con false.
 */
public class ActualizarItems {

    /**
     * Actualiza ItemsAPI, llamando a las clases que:
          1.- Genera el TOKEN de la API de Blizzard
          2.- Lista los ItemsAPI de la API
          3.- Guardan los tipos en la Base de Datos
     * @return boolean (true = actualizacion correcta, false = hubieron fallos)
     */
    public boolean actualizar() {
        TokenAPI apiToken = new TokenApiImpl();
        ItemsAPI apiItems = new ItemsApiImpl();
        ItemsJDBC itemsJDBC = new ItemsJDBCImpl();
        
        
        boolean correcto = false;
        
        String token = apiToken.getToken();     
        List<ItemEntity> listaItems = apiItems.listarItem(token);
        List<ItemEntity> listaDB = itemsJDBC.listarItems();
        if (!listaDB.isEmpty()){
            int rows_borrado = itemsJDBC.borrarItems();
        }
        for (ItemEntity item : listaItems){
            int rows = itemsJDBC.guardarNuevoItem(item);
            System.out.println("Se han creado: "+ rows +" nuevos registros");
            if (rows > 0){
                correcto = true;
            }
        }
        System.out.println("Proceso de grabacion de datos terminado.");
        return correcto;
    }
    
}
