/**
 * @author: Paul Muabdib
 * @version: 1.0
 */
package adaptadoresSecundarios.apiBlizzard;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import entity.TipoItemEntity;
import negocio.configuracion.Configuracion;
import negocio.registro.Registro;
import negocio.registro.TipoLog;
import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import puertosSecundarios.apiBlizzard.TiposAPI;

/**
 * Implementacion de TiposAPI
 * @see TiposAPI
 */
public class TiposApiImpl implements TiposAPI{
    
    @Override
    public List<TipoItemEntity> listarTipos(String token) {
        List<TipoItemEntity> listaTipos = new ArrayList();
        HttpURLConnection conexion = null;        
        try {
            URL url = new URL(Configuracion.getURL_TIPO()+token);
            conexion = (HttpURLConnection) url.openConnection();
            conexion.setRequestMethod("GET");
            int codigoRespuesta = conexion.getResponseCode();
            if (codigoRespuesta == 200){
                String respuesta = IOUtils.toString(conexion.getInputStream(),"UTF-8");
                JSONObject objetoJSON = new JSONObject(respuesta);
                JSONArray arrayJSON = objetoJSON.getJSONArray("item_classes");
                int i = 0;
                boolean bandera = false;
                do{
                    try {
                        if (arrayJSON.get(i) instanceof JSONObject || arrayJSON.get(i) instanceof JSONArray){
                            JSONObject tipoJSON = (JSONObject) arrayJSON.get(i);
                            TipoItemEntity tipo = new TipoItemEntity((Integer) tipoJSON.get("id"), tipoJSON.get("name").toString()); 
                            listaTipos.add (tipo);
                            System.out.println("Se ha encontrado el tipo: "+tipo);
                            Registro.registroInfo(TiposApiImpl.class, TipoLog.INFO, "Se ha encontrado el tipo: "+tipo);
                            i++;
                        }
                    } catch (JSONException e){
                        bandera = true;
                    }
                } while (bandera == false);
            } else {
                System.out.println("La API de BLIZZARD no devolvió un codigo de respuesta válido.");
                Registro.registroInfo(TiposApiImpl.class, TipoLog.ERROR, "La API de BLIZZARD no devolvió un codigo de respuesta válido.");
            }
        } catch (MalformedURLException ex) {
            System.out.println("Surgió un problema al intentar acceder a los datos de Tipos de Items en la API de BLIZZARD, acceda a registro.log para mas información.");
            Registro.registroInfo(TiposApiImpl.class, TipoLog.ERROR, ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Surgió un problema al intentar acceder a los datos de Tipos de Items en la API de BLIZZARD, acceda a registro.log para mas información.");
            Registro.registroInfo(TiposApiImpl.class, TipoLog.ERROR, ex.getMessage());
        }        
        return listaTipos;
    }    
}
