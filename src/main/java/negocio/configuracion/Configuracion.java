/**
 * @author: Paul Muabdib
 * @version: 1.0
 */

package negocio.configuracion;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

/**
 * Garda las constantes necesarias para la conexión con la API de Blizard
 */
public class Configuracion {
    // URLs para las llamadas a la API de BLIZZARD
    private static final String URL_TOKEN = "https://eu.battle.net/oauth/token";
    private static final String URL_TIPO = "https://eu.api.blizzard.com/data/wow/item-class/index?namespace=static-eu&locale=es_ES&access_token=";
    private static final String URL_SUBTIPO_1 = "https://eu.api.blizzard.com/data/wow/item-class/";
    private static final String URL_SUBTIPO_2 = "?namespace=static-eu&locale=es_ES&access_token=";
    private static final String URL_ITEM_1 = "https://eu.api.blizzard.com/data/wow/item/";
    private static final String URL_ITEM_2 = "?namespace=static-eu&locale=es_ES&access_token=";
    
    // Client ID y Secret de Blizzard Api
    private static final String BLIZZAR_CLIENT_ID = "Poner aqui Client ID"; // Colocar aqui el ClientID de Blizzard
    private static final String BLIZZARD_SECRET = "Poner aqui Secret";   // Colocar aqui el Secret de Blizzard

    public static String getURL_ITEM_1() {
        return URL_ITEM_1;
    }

    public static String getURL_ITEM_2() {
        return URL_ITEM_2;
    }

    public static String getURL_SUBTIPO_1() {
        return URL_SUBTIPO_1;
    }

    public static String getURL_SUBTIPO_2() {
        return URL_SUBTIPO_2;
    }

    public static String getURL_TOKEN() {
        return URL_TOKEN;
    }

    public static String getURL_TIPO() {
        return URL_TIPO;
    }
    
    /**
     * Codificación de los credenciales para la obtención del token de la API 
     * de Blizzard
     * @return String credencialesCodificadas (Credenciales para el Token)
     */
    public static String credencialesCodificadas (){
        String CREDENCIALES = BLIZZAR_CLIENT_ID+':'+BLIZZARD_SECRET;
        String credencialCodificada = null;
        try {
            credencialCodificada = Base64.getEncoder().encodeToString(CREDENCIALES.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException ex) {
            ex.printStackTrace(System.out);
        }        
        return credencialCodificada;
    }
}
