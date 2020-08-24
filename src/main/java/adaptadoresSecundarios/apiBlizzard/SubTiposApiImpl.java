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
import entity.SubTipoItemEntity;
import entity.TipoItemEntity;
import negocio.configuracion.Configuracion;
import negocio.registro.Registro;
import negocio.registro.TipoLog;
import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import puertosSecundarios.apiBlizzard.SubTiposAPI;
import puertosSecundarios.apiBlizzard.TiposAPI;

/**
 * Implementacion de SubTiposAPI
 * @see SubTiposAPI
 */
public class SubTiposApiImpl implements SubTiposAPI{
    
    @Override
    public List<SubTipoItemEntity> listarSubTipo(String token) {
        List<SubTipoItemEntity> listaSubTipos = new ArrayList ();
        HttpURLConnection conexion = null;
        
        TiposAPI apiTipos = new TiposApiImpl ();
        
        List<TipoItemEntity> listaTipos = apiTipos.listarTipos(token);
        
        for (TipoItemEntity tipo : listaTipos){
            
            System.out.println("Buscando subtipos de: " + tipo);
            
            try {
                URL url = new URL (Configuracion.getURL_SUBTIPO_1()+tipo.getIdBlizzard()+Configuracion.getURL_SUBTIPO_2()+token);
                conexion = (HttpURLConnection) url.openConnection();
                    conexion.setRequestMethod("GET");
                int codigoRespuesta = conexion.getResponseCode();
                if (codigoRespuesta == 200){
                    String respuesta = IOUtils.toString(conexion.getInputStream(),"UTF-8");
                    JSONObject objetoJSON = new JSONObject(respuesta);
                    JSONArray arrayJSON = objetoJSON.getJSONArray("item_subclasses");
                    int i = 0;
                    boolean bandera = false;
                    do{
                        try{
                            if (arrayJSON.get(i) instanceof JSONObject || arrayJSON.get(i) instanceof JSONArray){
                                JSONObject subTipoJSON = (JSONObject) arrayJSON.get(i);
                                SubTipoItemEntity subTipo = new SubTipoItemEntity ((Integer)tipo.getIdBlizzard(),(Integer)subTipoJSON.get("id"),subTipoJSON.get("name").toString());
                                listaSubTipos.add(subTipo);
                                System.out.println("Se ha encontrado el Subtipo: "+subTipo);
                                Registro.registroInfo(TiposApiImpl.class, TipoLog.INFO, "Se ha encontrado el subtipo: "+subTipo);
                                i++;
                            }
                        }catch (JSONException e){                            
                            bandera = true;
                        }
                    }while (bandera == false);
                } else {
                    System.out.println("La API de BLIZZARD no devolvió un codigo de respuesta válido.");
                    Registro.registroInfo(TiposApiImpl.class, TipoLog.ERROR, "La API de BLIZZARD no devolvió un codigo de respuesta válido.");
                }
            } catch (MalformedURLException ex) {
                System.out.println("Surgió un problema al intentar acceder a los datos de Subtipos de Items en la API de BLIZZARD, acceda a registro.log para mas información.");
                Registro.registroInfo(TiposApiImpl.class, TipoLog.ERROR, ex.getMessage());
            } catch (IOException ex) {
                System.out.println("Surgió un problema al intentar acceder a los datos de Subtipos de Items en la API de BLIZZARD, acceda a registro.log para mas información.");
                Registro.registroInfo(TiposApiImpl.class, TipoLog.ERROR, ex.getMessage());
            }
        }        
        return listaSubTipos;
    }    
}
