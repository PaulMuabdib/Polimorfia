/**
 * @author: Paul Muabdib
 * @version: 1.0
 * 
 * Define y gestiona los objetos Items.
 * 
 */

package entity;

public class ItemEntity {
    protected int idItem;
    protected String nombreItem;
    protected int tipoItem;
    protected int subTipoItem;
    
    public ItemEntity(){
        
    }

    /**
     * Constructor con 4 argumentos
     * @param idItem (ID de la API de Blizzard del Item)
     * @param nombreItem (Nombre de la API de Blizzard del Item)
     * @param tipoItem (ID del Tipo de Item al que pertenece)
     * @param subTipoItem (ID del SubTipo de Item al que pertenece)
     */
    public ItemEntity(int idItem, String nombreItem, int tipoItem, int subTipoItem) {
        this.idItem = idItem;
        this.nombreItem = nombreItem;
        this.tipoItem = tipoItem;
        this.subTipoItem = subTipoItem;
    }
    
    public int getIdItem() {
        return idItem;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    public String getNombreItem() {
        return nombreItem;
    }

    public void setNombreItem(String nombreItem) {
        this.nombreItem = nombreItem;
    }

    public int getTipoItem() {
        return tipoItem;
    }

    public void setTipoItem(int tipoItem) {
        this.tipoItem = tipoItem;
    }

    public int getSubTipoItem() {
        return subTipoItem;
    }

    public void setSubTipoItem(int subTipoItem) {
        this.subTipoItem = subTipoItem;
    }

    @Override
    public String toString() {
        return "Item{" + "idItem=" + idItem + ", nombreItem=" + nombreItem + ", tipoItem=" + tipoItem + ", subTipoItem=" + subTipoItem + '}';
    }

    
    
    
    
}
