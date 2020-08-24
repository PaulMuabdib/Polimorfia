/**
 * @author: Paul Muabdib
 * @version: 1.0
 */
package puertosPrimarios;

/**
 * Lanza los actualizadores de Tipos, Subtipos e Items que devolverán un 
 * boolean con el que sabremos si se han realizado correctamente o no las 
 * actualizaciones.
 */ 
public interface OpcionSeleccionada {

    /**
     * Lanza el actualizador de Tipos de Items.
     *
     * @return boolean (true: se realizó correctamente, false: hubo algun error)
     */
    public boolean actualizarTipos();
    
    /**
     * Lanza el actualizador de Subtipos de Items.
     * 
     * @return boolean (true: se realizó correctamente, false: hubo algun error)
     */
    public boolean actualizarSubTipos();
    
    /**
     * Lanza el actualizador de Items.
     * 
     * @return boolean (true: se realizó correctamente, false: hubo algun error)
     */
    public boolean actualizarItems ();
    
   
    
}
