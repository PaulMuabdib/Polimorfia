/**
 * @author: Paul Muabdib
 * @version: 1.0 
 */
package adaptadoresPrimarios;

import negocio.ActualizarItems;
import negocio.ActualizarSubTipos;
import negocio.ActualizarTipos;
import puertosPrimarios.OpcionSeleccionada;
/**
 * Implementacion de OpcionSeleccionada
 * @see OpcionSeleccionada
 */
public class OpcionSeleccionadaImpl implements OpcionSeleccionada {
    
    @Override
    public boolean actualizarTipos() {        
        ActualizarTipos actualizador = new ActualizarTipos();       
        return actualizador.actualizar();        
    }    
    
    @Override
    public boolean actualizarSubTipos() {
        
        ActualizarSubTipos actualizador = new ActualizarSubTipos();
        return actualizador.actualizar();
    }
    
    @Override
    public boolean actualizarItems() {
        ActualizarItems actualizador = new ActualizarItems();
        return actualizador.actualizar();
    }

}
