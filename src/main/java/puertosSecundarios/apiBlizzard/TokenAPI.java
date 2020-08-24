/**
 * @author: Paul Muabdib
 * @version: 1.0
 */

package puertosSecundarios.apiBlizzard;

/** 
 * Generará el Token necesario para la conexión con la API de Blizzard
 */
public interface TokenAPI {
    
    /**
     * Genera el TokenAPI con los credenciales guardados en la clase Configuracion
     * 
     * @return String token (Es el TokenAPI para la conexión con la API) 
     */
    public String getToken ();    
    
}
