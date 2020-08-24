/**
 * @author: Paul Muabdib
 * @version: 1.0 
 */
package adaptadoresSecundarios.baseDeDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import entity.ItemEntity;
import negocio.registro.Registro;
import negocio.registro.TipoLog;
import puertosSecundarios.baseDeDatos.ConexionDB;
import puertosSecundarios.baseDeDatos.ItemsJDBC;

/**
 * Implementacion de ItemsJDBC
 * @see ItemsJDBC
 */
public class ItemsJDBCImpl implements ItemsJDBC {
    
    private static final String SQL_INSERT = "INSERT INTO items (id_item_blizzard, nombre_item, clase_item, subclase_item) VALUES (?,?,?,?)";
    private static final String SQL_DELETE_ALL = "DELETE FROM items";
    private static final String SQL_SELECT = "SELECT id_item_blizzard, nombre_item, clase_item, subclase_item FROM items";
    
    private final ConexionDB conexion = new ConexionDBImpl();
    private Connection conn = null;
    private PreparedStatement stmt = null;

    
    @Override
    public int guardarNuevoItem(ItemEntity item) {
        int rows = 0;
        try {
            conn = conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, item.getIdItem());
            stmt.setString(2, item.getNombreItem());
            stmt.setInt(3, item.getTipoItem());
            stmt.setInt(4, item.getSubTipoItem());
            System.out.println("Ejecutando sentencia INSERT para: " + item.getNombreItem());
            Registro.registroInfo(ItemsJDBCImpl.class, TipoLog.INFO, "Ejecutando sentencia INSERT para: " + item.getNombreItem());
            rows = stmt.executeUpdate();            
        } catch (SQLException ex){
            ex.printStackTrace(System.out);
            Registro.registroInfo(ItemsJDBCImpl.class, TipoLog.ERROR, "ERROR al intentar grabar datos en la DB.");
            Registro.registroInfo(ItemsJDBCImpl.class, TipoLog.ERROR, ex.getMessage());
        } finally {
            conexion.close(stmt);
            conexion.close(conn);
        }
        return rows;    
    }

    
    @Override
    public int borrarItems() {
        int rows = 0;
        try {
            conn = conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE_ALL);
            System.out.println("Borrando el contenido de Tipos de Items en la Base de Datos.");
            Registro.registroInfo(ItemsJDBCImpl.class, TipoLog.INFO, "Borrado el contenido de Tipos de Items en la Base de Datos.");
            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            Registro.registroInfo(ItemsJDBCImpl.class, TipoLog.ERROR, "ERROR al intentar borrar datos en la DB.");
            Registro.registroInfo(ItemsJDBCImpl.class, TipoLog.ERROR, ex.getMessage());
        } finally {
            conexion.close(stmt);
            conexion.close(conn);
        }
        return rows;
    }

    
    @Override
    public List<ItemEntity> listarItems() {
        ResultSet rs = null;
        ItemEntity item = null;
        List<ItemEntity> items = new ArrayList();
        try {
            conn = conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()){
                item = new ItemEntity(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4));
                items.add(item);
            }
                    
        } catch (SQLException ex) {
            System.out.println("Surgió un problema al intentar listar de la Base de Datos, acceda a registro.log para mas información.");
            Registro.registroInfo(ItemsJDBCImpl.class, TipoLog.ERROR, ex.getMessage());
        } finally {
            conexion.close(rs, stmt, conn);
        }
        return items;
    }
    
}
