/**
 * @author: Paul Muabdib
 * @version: 1.0
 * 
 * Define y gestiona los objetos Subtipos de Items.
 * 
 */

package entity;

public class SubTipoItemEntity extends TipoItemEntity {
    protected int idDB;
    protected int idSubTipo;
    protected String nombreSubtipo;
    
    public SubTipoItemEntity (){
        
    }
    
    /**
     * Constructor con 3 argumentos
     * @param idTipo (ID del tipo al que pertence el SubTipo)
     * @param idSubTipo (ID del SubTipo de Item de la API de Blizzard)
     * @param nombreSubTipo (Nombre del SubTipo de la API de Blizzard)
     */
    public SubTipoItemEntity (int idTipo, int idSubTipo, String nombreSubTipo){
        this.idBlizzard = idTipo;        
        this.idSubTipo = idSubTipo;
        this.nombreSubtipo = nombreSubTipo;        
    }

    public int getIdDB() {
        return idDB;
    }

    public void setIdDB(int idDB) {
        this.idDB = idDB;
    }

    public int getIdSubTipo() {
        return idSubTipo;
    }

    public void setIdSubTipo(int idSubTipo) {
        this.idSubTipo = idSubTipo;
    }

    public String getNombreSubtipo() {
        return nombreSubtipo;
    }

    public void setNombreSubtipo(String nombreSubtipo) {
        this.nombreSubtipo = nombreSubtipo;
    }

    @Override
    public String toString() {
        if (this.idDB != 0){
            return "SubTipo de Item{" + "idDB= " + idDB + ", idSubTipo= " + idSubTipo + ", nombreSubtipo= " + nombreSubtipo + '}';
        }else{
            return "SubTipo de Item{" + "idSubTipo= " + idSubTipo + ", nombreSubtipo= " + nombreSubtipo + '}';
        }
        
    }
    
}
