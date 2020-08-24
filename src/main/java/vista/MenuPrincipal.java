/**
 * @author: Paul Muabdib
 * @version: 1.0
 
 * @see MenuPrincipalImpl
 * 
 */

package vista;

 /**  
 * El menú principal que nos da la opción de actualizar os Tipos de Items, 
 * los Subtipos y los Items en nustra base de datos. 
 */ 
public interface MenuPrincipal {
    
    /**
     * El método verMenuPrincipal se encarga de: 
     *          1.- Mostrar el menú. 
     *          2.- Recibir la opción.
     *          3.- Chequear la opcion para ejecutar las distintas clases y 
     *              comprobar el resultado de las mismas.     
     */
    void verMenuPrincipal ();
    
}
