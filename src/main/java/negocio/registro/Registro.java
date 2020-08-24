/**
 * @author: Paul Muabdib
 * @version: 1.0
 */

package negocio.registro;

import adaptadoresSecundarios.apiBlizzard.ItemsApiImpl;
import adaptadoresSecundarios.baseDeDatos.ItemsJDBCImpl;
import org.apache.log4j.Logger;

/** 
 * Se engarga de generar y gestionar los archivos de registro mediante log4j
 */
public class Registro {
    private static final Logger regLog = Logger.getLogger("REGISTROMAIN");
    private static final Logger itemsLog = Logger.getLogger("REGISTROITEMS");
    
    /**
     * Gestión de los registros
     * @param clase (Clase de la que proviene el registro a guardar)
     * @param tipo (Nivel del Log de la ENUM TipoLog)
     * @param mensaje (Mensaje a guardar en el registro)
     * 
     * @see TipoLog
     */
    public static void registroInfo (Class clase, TipoLog tipo, String mensaje){ 
        if (clase == ItemsApiImpl.class || clase == ItemsJDBCImpl.class){
            switch (tipo){
                case DEBUG:
                    itemsLog.debug(mensaje);
                    break;
                case ERROR:
                    itemsLog.error("ERROR EN: "+ clase.getName()+ " => " + mensaje);
                    break;
                case FATAL:
                    itemsLog.fatal(mensaje);
                    break;
                case INFO:
                    itemsLog.info(mensaje);
                    break;
                case WARNING:
                    itemsLog.warn(mensaje);
                    break;
            }
        } else {
            switch (tipo){
                case DEBUG:
                    regLog.debug(mensaje);
                    break;
                case ERROR:
                    regLog.error("ERROR EN: "+ clase.getName()+ " => " + mensaje);
                    break;
                case FATAL:
                    regLog.fatal(mensaje);
                    break;
                case INFO:
                    regLog.info(mensaje);
                    break;
                case WARNING:
                    regLog.warn(mensaje);
                    break;
            }
        }
    }
    
}
