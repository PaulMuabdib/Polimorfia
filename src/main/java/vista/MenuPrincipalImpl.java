/**
 * @author: Paul Muabdib
 * @version: 1.0
 */
 
package vista;

import adaptadoresPrimarios.OpcionSeleccionadaImpl;
import java.util.Scanner;
import negocio.registro.Registro;
import negocio.registro.TipoLog;
import puertosPrimarios.OpcionSeleccionada;

/**  
 * Implementación de MenuPrincipal
 * @see MenuPrincipal
 */ 
public class MenuPrincipalImpl implements MenuPrincipal{

    
    @Override
    public void verMenuPrincipal() {
        int opcion = 100;
        boolean correcto = false;
        var consola = new Scanner(System.in);
        OpcionSeleccionada seleccion = new OpcionSeleccionadaImpl();
        do{
            System.out.println("************************************");
            System.out.println("********** MENU PRINCIPAL **********");
            System.out.println("************************************");
            System.out.println();
            System.out.println("1.- Actualizar Tipos de Items.");
            System.out.println("2.- Actualizar SubTipos de Items.");
            System.out.println("3.- Actualizar Items (*)");            
            System.out.println("0.- Salir del programa.");
            System.out.println("************************************");
            System.out.println();
            System.out.println("(*) Se recomienda la desactivacion del sitema de suspension del PC, ");
            System.out.println("devido a que este es un proceso muy largo que puede provacar fallos ");
            System.out.println("en la conexion con la API de Blizzard.");
            System.out.println("El proceso generará un archivo items.log con el registro de acciones.");
            
            opcion = Integer.parseInt(consola.nextLine()); 
            
            switch (opcion){
                case 1:
                    correcto = seleccion.actualizarTipos();                
                    if (correcto){                    
                        System.out.println("Se han actualizado correctamente los Tipos de Items");
                        Registro.registroInfo(MenuPrincipalImpl.class, TipoLog.INFO, "Se han actualizado correctamente los Tipos de Items");
                    } else {
                        System.out.println("Hubo un problema al acctualizar los Tipos de Items");
                        Registro.registroInfo(MenuPrincipalImpl.class, TipoLog.ERROR, "Hubo un problema al acctualizar los Tipos de Items");
                    }
                    break;
                case 2:
                    correcto = seleccion.actualizarSubTipos();
                    if (correcto){                    
                        System.out.println("Se han actualizado correctamente los Sub-Tipos de Items");
                        Registro.registroInfo(MenuPrincipalImpl.class, TipoLog.INFO, "Se han actualizado correctamente los Sub-Tipos de Items");
                    } else {
                        System.out.println("Hubo un problema al acctualizar los Sub-Tipos de Items");
                        Registro.registroInfo(MenuPrincipalImpl.class, TipoLog.ERROR, "Hubo un problema al acctualizar los Sub-Tipos de Items");
                    }
                    break;
                case 3:
                    correcto = seleccion.actualizarItems();
                    if (correcto){
                        System.out.println("Se han actualizado correctamente los Items");
                        Registro.registroInfo(MenuPrincipalImpl.class, TipoLog.INFO, "Se han actualizado correctamente los Items");
                    } else {
                        System.out.println("Hubo un problema al acctualizar los Items");
                        Registro.registroInfo(MenuPrincipalImpl.class, TipoLog.ERROR, "Hubo un problema al acctualizar los Items");
                    }                    
                    break;
            }                                
        } while (opcion != 0); 
        System.out.println("Gracias por utilizar Polimorfia 1.0");
        
    }
    
}
