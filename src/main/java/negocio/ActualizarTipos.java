/**
 * @author: Paul Muabdib
 * @version: 1.0
 */

package negocio;

import entity.TipoItemEntity;
import adaptadoresSecundarios.apiBlizzard.TiposApiImpl;
import adaptadoresSecundarios.apiBlizzard.TokenApiImpl;
import adaptadoresSecundarios.baseDeDatos.TiposJDBCImpl;
import java.util.List;
import puertosSecundarios.baseDeDatos.TiposJDBC;
import puertosSecundarios.apiBlizzard.TiposAPI;
import puertosSecundarios.apiBlizzard.TokenAPI;

/** 
 * Actualizador de los TiposAPI de Items, retornará el boolean con true si se ha 
 efectuado correctamente o de lo contrario con false.
 */
public class ActualizarTipos {
    
    /**
     * Actualiza los tipos de Items, llamando a las clases que: 
          1.- Genera el TOKEN de la API de Blizzard
          2.- Lista los TiposAPI de Items de la API
          3.- Guardan los tipos en la Base de Datos
     * @return boolean (true = actualizacion correcta, false = hubieron fallos)
     */
    public  boolean actualizar (){
        
        TokenAPI apiToken = new TokenApiImpl();
        TiposAPI apiTipos = new TiposApiImpl();
        TiposJDBC tiposJDBC = new TiposJDBCImpl();
        
        boolean correcto = false;
        
        String token = apiToken.getToken();
        
        List<TipoItemEntity>tiposItems = apiTipos.listarTipos(token);       
        List <TipoItemEntity> listaDB = tiposJDBC.listarTipos();
        if (!listaDB.isEmpty()){
            int rows_borrado = tiposJDBC.borrarTipos();
        }   
        for (TipoItemEntity tipo : tiposItems){
            int rows = tiposJDBC.guardarNuevoTipo(tipo);
            System.out.println("Se han creado: "+ rows +" nuevos registros");
            if (rows > 0){
                correcto = true;
            }
        }
    return correcto;
    }
}
