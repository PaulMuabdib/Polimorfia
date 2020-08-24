/**
 * @author: Paul Muabdib
 * @version: 1.0
 * 
 * Define y gestiona los objetos Tipos de Items.
 * 
 */

package entity;

public class TipoItemEntity {
    protected int idDB;
    protected String nombreTipo;
    protected int idBlizzard;    
    
    public TipoItemEntity (){
        
    }
    
    /**
     * Constructor con 2 argumentos
     * @param idBlizzard (es el Id que utiliza la API de Blizzard)
     * @param nombreTipo (es el nombre que le da la API de Blizzard)
     */
    
    public TipoItemEntity (int idBlizzard, String nombreTipo){
        this.idBlizzard = idBlizzard;
        this.nombreTipo = nombreTipo;
    }    
    
    /**
     * Constructor con 3 argumentos
     * @param idDB (es el id que le asigna la base de datos automaticamente)
     * @param nombreTipo (es el nombre que le da la API de Blizzard)
     * @param idBlizzard (es el Id que utiliza la API de Blizzard)
     */
    public TipoItemEntity (int idDB, String nombreTipo, int idBlizzard){
        this.idDB = idDB;
        this.nombreTipo = nombreTipo;
        this.idBlizzard = idBlizzard;
    }
   
    public int getIdDB() {
        return idDB;
    }

    public void setIdDB(int idDB) {
        this.idDB = idDB;
    }

    public String getNombreTipo() {
        return nombreTipo;
    }

    public void setNombreTipo(String nombreTipo) {
        this.nombreTipo = nombreTipo;
    }

    public int getIdBlizzard() {
        return idBlizzard;
    }

    public void setIdBlizzard(int idBlizzard) {
        this.idBlizzard = idBlizzard;
    }
    
    @Override
    public String toString() {
        if (this.idDB != 0){
            return "Tipo de Item{" + "idDB=" + idDB + ", nombreTipo=" + nombreTipo + ", idBlizzard=" + idBlizzard + '}';
        } else {
            return "Tipo de Item{" + "nombreTipo=" + nombreTipo + ", idBlizzard=" + idBlizzard + '}';
        }        
    }
    
    
}
