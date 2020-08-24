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
import entity.ItemEntity;
import negocio.configuracion.Configuracion;
import negocio.registro.Registro;
import negocio.registro.TipoLog;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;
import puertosSecundarios.apiBlizzard.ItemsAPI;
import puertosSecundarios.apiBlizzard.TokenAPI;

/**
 * Implementacion de ItemsAPI
 * @see ItemsAPI
 */
public class ItemsApiImpl implements ItemsAPI{

    
    @Override
    public List<ItemEntity> listarItem(String token) {
        TokenAPI apiToken = new TokenApiImpl();
        List<ItemEntity> listaItems = new ArrayList();
        HttpURLConnection conexion = null;
        int ultimoIdEncontrado = 0;
        
        for (int i = 0; i <= 179999;i++){
            String urlBusqueda = Configuracion.getURL_ITEM_1()+i+Configuracion.getURL_ITEM_2()+token;
            try {
                URL url = new URL(urlBusqueda);
                conexion = (HttpURLConnection) url.openConnection();
                conexion.setRequestMethod("GET");
                int codigoRespuesta = conexion.getResponseCode();
                System.out.println("codigoRespuesta = " + codigoRespuesta + ", para id: " + i);                
                if (codigoRespuesta == 200){
                    ultimoIdEncontrado=i;
                    String respuesta = IOUtils.toString(conexion.getInputStream(),"UTF-8");
                    JSONObject objetoJSON = new JSONObject(respuesta);
                    JSONObject claseItem = objetoJSON.getJSONObject("item_class");
                    JSONObject subClaseItem = objetoJSON.getJSONObject("item_subclass");
                    JSONObject previewJSON = objetoJSON.getJSONObject("preview_item");
                    JSONObject itemJSON = previewJSON.getJSONObject("item");                    
                    int idClaseItem = claseItem.getInt("id");
                    int idSubClaseItem = subClaseItem.getInt("id");
                    int idItem = itemJSON.getInt("id");
                    String nombreItem = previewJSON.getString("name");
                    ItemEntity item = new ItemEntity(idItem,nombreItem,idClaseItem,idSubClaseItem);
                    System.out.println("Item encontrado: " + item);
                    Registro.registroInfo(ItemsApiImpl.class, TipoLog.INFO, "Item encontrado: " + item);        
                    listaItems.add(item);
                    if (i%10000 == 0){                        
                        token = apiToken.getToken();
                    }
                }
            } catch (MalformedURLException ex) {
                Registro.registroInfo(ItemsApiImpl.class, TipoLog.ERROR, ex.getMessage());
            } catch (IOException ex) {
                Registro.registroInfo(ItemsApiImpl.class, TipoLog.ERROR, ex.getMessage());
            }
        }
        if (ultimoIdEncontrado != 0) {
            System.out.println("Ultimo Id Encontrado = " + ultimoIdEncontrado);
            Registro.registroInfo(ItemsApiImpl.class, TipoLog.INFO, "Ultimo Id Encontrado = " + ultimoIdEncontrado);            
        } else {
            System.out.println("No se ha encontrado ningún registro en la API de BLIZZARD.");
            Registro.registroInfo(ItemsApiImpl.class, TipoLog.WARNING, "No se ha encontrado ningún registro en la API de BLIZZARD.");    
        }
        return listaItems;
    }

    
}
