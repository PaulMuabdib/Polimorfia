/**
 * @author: Paul Muabdib
 * @version: 1.0
 * 
 * Este programa pretende convertir los datos que proporciona la API de 
 * BLIZZARD para Items del juego de World of Warcraft en una Base de Datos
 * MYSQL para que pueda utilizarse desde otras aplicaciones ya que la API 
 * de BLIZZARD sólo permite busquedas por ID de ITEM.
 * 
 * Este programa está realizado con una arquitectura "puertos/adaptadores" o 
 * también llamada "hexagonal".
 */

package main;

import vista.MenuPrincipalImpl;
import vista.MenuPrincipal;

public class Main {
    public static void main(String[] args) {
        MenuPrincipal menu = new MenuPrincipalImpl();
        menu.verMenuPrincipal();
    }
}
