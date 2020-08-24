/**
 * @author: Paul Muabdib
 * @version: 1.0
 * 
 * Esta clase generará el Token necesario para la conexión con la API de 
 * Blizzard
 * 
 */
 package adaptadoresSecundarios.apiBlizzard;

import negocio.configuracion.Configuracion;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import negocio.registro.Registro;
import negocio.registro.TipoLog;
import org.apache.commons.io.IOUtils;
import puertosSecundarios.apiBlizzard.TokenAPI;

/**
 * Implementacion de TokenAPI
 * @see TokenAPI
 */
public class TokenApiImpl implements TokenAPI{
    
    @Override
    public String getToken() {
        String token = null;
        HttpURLConnection conexion = null;        
        try {
            URL url = new URL(Configuracion.getURL_TOKEN());
            conexion = (HttpURLConnection) url.openConnection();
                conexion.setRequestMethod("POST");
                conexion.setRequestProperty("Authorization", String.format("Basic %s", Configuracion.credencialesCodificadas()));
                conexion.setDoOutput(true);
                conexion.getOutputStream().write("grant_type=client_credentials".getBytes("UTF-8"));
            int codigoRespuesta = conexion.getResponseCode();
            if (codigoRespuesta == 200){
                String respuesta = IOUtils.toString(conexion.getInputStream(), "UTF-8");
                token = respuesta.substring(17,51);
                Registro.registroInfo(TokenApiImpl.class, TipoLog.INFO, "Conexion con API BLIZZARD establecida con exito, nuevo token asignado.");
            }else{
                System.out.println("Se produjo un error al conectar con la API de Blizzard");
                Registro.registroInfo(TokenApiImpl.class, TipoLog.ERROR, "Error al conectar con la API BLIZZARD, no se puede asignar un token válido.");
            } 
        } catch (MalformedURLException ex) {
            Registro.registroInfo(TokenApiImpl.class, TipoLog.ERROR, ex.getMessage());
        } catch (IOException ex) {
            Registro.registroInfo(TokenApiImpl.class, TipoLog.ERROR, ex.getMessage());
        }
        return token;
    }
}
