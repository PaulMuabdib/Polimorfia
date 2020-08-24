/**
 * @author: Paul Muabdib
 * @version: 1.0
 */

package negocio;

import entity.SubTipoItemEntity;
import adaptadoresSecundarios.apiBlizzard.SubTiposApiImpl;
import adaptadoresSecundarios.apiBlizzard.TokenApiImpl;
import adaptadoresSecundarios.baseDeDatos.SubTiposJDBCImpl;
import java.util.List;
import puertosSecundarios.baseDeDatos.SubTiposJDBC;
import puertosSecundarios.apiBlizzard.SubTiposAPI;
import puertosSecundarios.apiBlizzard.TokenAPI;

/** 
 * Actualizador de los Subtipos de Items, retornará el boolean con true si se ha 
 * efectuado correctamente o de lo contrario con false.
 */
public class ActualizarSubTipos {
    
    /**
     * Actualiza los Subtipos de Items, llamando a las clases que:
     *          1.- Genera el TOKEN de la API de Blizzard
     *          2.- Lista los Subtipos de Items de la API
     *          3.- Guardan los tipos en la Base de Datos
     * @return boolean (true = actualizacion correcta, false = hubieron fallos)
     */
    public boolean actualizar (){
        TokenAPI apiToken = new TokenApiImpl();
        SubTiposAPI apiSubTipos = new SubTiposApiImpl();
        SubTiposJDBC subTiposJDBC = new SubTiposJDBCImpl();
        
        boolean correcto = false;
        
        String token = apiToken.getToken();
        List<SubTipoItemEntity>subTiposItems = apiSubTipos.listarSubTipo(token);
        List<SubTipoItemEntity> listaDB = subTiposJDBC.listarSubTipos();
        
        if (!listaDB.isEmpty()){
            int rows_borrados = subTiposJDBC.borrarSubTipos();            
        }        
        for (SubTipoItemEntity subTipo : subTiposItems){
            int rows = subTiposJDBC.guardarNuevoSubTipo(subTipo);
            System.out.println("Se han creado: "+ rows +" nuevos registros");
            if (rows > 0){
                correcto = true;
            }
        }
        return correcto;
    }
    
}
