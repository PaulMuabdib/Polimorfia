/**
 * @author: Paul Muabdib
 * @version: 1.0
 * 
 * Realiza operaciones necesarias para con la Base de Datos de los Subtipos de 
 * Items
 * 
 */
package adaptadoresSecundarios.baseDeDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import entity.SubTipoItemEntity;
import negocio.registro.Registro;
import negocio.registro.TipoLog;
import puertosSecundarios.baseDeDatos.ConexionDB;
import puertosSecundarios.baseDeDatos.SubTiposJDBC;

/**
 * Implementacion de SubTiposJDBC
 * @see SubTiposJDBC
 */
public class SubTiposJDBCImpl implements SubTiposJDBC {
    private static final String SQL_INSERT = "INSERT INTO subtipos_de_objetos (nombre_subtipos_de_objetos, blizzard_id, tipo_de_objeto) VALUES (?,?,?)";
    private static final String SQL_DELETE_ALL = "DELETE FROM subtipos_de_objetos";
    private static final String SQL_SELECT = "SELECT id_subtipo_de_objetos, nombre_subtipos_de_objetos, blizzard_id, tipo_de_objeto FROM subtipos_de_objetos";
    private final ConexionDB conexion = new ConexionDBImpl();
    private Connection conn = null;
    private PreparedStatement stmt = null;
    
    
    @Override
    public int guardarNuevoSubTipo(SubTipoItemEntity subTipo) {
        int rows = 0;
        try{
            conn = conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, subTipo.getNombreSubtipo());
            stmt.setInt(2, subTipo.getIdSubTipo());
            stmt.setInt(3, subTipo.getIdBlizzard());
            System.out.println("Ejecutando sentencia INSERT para: "+ subTipo.getNombreSubtipo());
            Registro.registroInfo(SubTiposJDBCImpl.class, TipoLog.INFO, "Ejecutando sentencia INSERT para: " + subTipo.getNombreTipo());
            rows = stmt.executeUpdate();
        } catch (SQLException ex){
            System.out.println("Surgió un problema al intentar grabar en la Base de Datos, acceda a registro.log para mas información.");
            Registro.registroInfo(SubTiposJDBCImpl.class, TipoLog.ERROR, ex.getMessage());
        }finally{
            conexion.close(stmt);
            conexion.close(conn);
        }
        return rows;    }

    
    @Override
    public int borrarSubTipos() {
        int rows = 0;
        try {
            conn = conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE_ALL);
            System.out.println("Borrando el contenido de SubTipos de Items de la Base de Datos.");
            Registro.registroInfo(SubTiposJDBCImpl.class, TipoLog.INFO, "Borrando el contenido de SubTipos de Items de la Base de Datos.");
            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Surgió un problema al intentar borrar en la Base de Datos, acceda a registro.log para mas información.");
            Registro.registroInfo(SubTiposJDBCImpl.class, TipoLog.ERROR, ex.getMessage());
        } finally {
            conexion.close(stmt);
            conexion.close(conn);
        }
        return rows;
    }

    
    @Override
    public List<SubTipoItemEntity> listarSubTipos() {
        List<SubTipoItemEntity> listaSubTipos = new ArrayList();
        ResultSet rs = null;
        SubTipoItemEntity subTipoItem = null;
        
        try {
            conn = conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()){
                subTipoItem = new SubTipoItemEntity(rs.getInt(1),rs.getInt(3),rs.getString(2));
                listaSubTipos.add(subTipoItem);
            }
        } catch (SQLException ex) {
            System.out.println("Surgió un problema al intentar listar de la Base de Datos, acceda a registro.log para mas información.");
            Registro.registroInfo(SubTiposJDBCImpl.class, TipoLog.ERROR, ex.getMessage());
        }finally{
            conexion.close(rs, stmt, conn);
        }
        return listaSubTipos;
        
    }
    
}
