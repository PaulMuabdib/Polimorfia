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
import entity.TipoItemEntity;
import negocio.registro.Registro;
import negocio.registro.TipoLog;
import puertosSecundarios.baseDeDatos.ConexionDB;
import puertosSecundarios.baseDeDatos.TiposJDBC;

/**
 * Implementacion de TiposJDBC
 * @see TiposJDBC
 */
public class TiposJDBCImpl implements TiposJDBC{
    private static final String SQL_INSERT = "INSERT INTO tipos_de_objetos (nombre_tipo_de_objeto, blizzard_id) VALUES (?,?)";
    private static final String SQL_DELETE_ALL = "DELETE FROM tipos_de_objetos";
    private static final String SQL_SELECT = "SELECT id_tipo_de_objeto, nombre_tipo_de_objeto, blizzard_id FROM tipos_de_objetos";
    private final ConexionDB conexion = new ConexionDBImpl();
    private Connection conn = null;
    private PreparedStatement stmt = null;
    
    
    @Override
    public int guardarNuevoTipo(TipoItemEntity tipo) {              
        
        int rows = 0;
        try {
            conn = conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, tipo.getNombreTipo());
            stmt.setInt(2, tipo.getIdBlizzard());
            System.out.println("Ejecutando sentencia INSERT para: " + tipo.getNombreTipo());
            Registro.registroInfo(TiposJDBCImpl.class, TipoLog.INFO, "Ejecutando sentencia INSERT para: " + tipo.getNombreTipo());
            rows = stmt.executeUpdate();            
        } catch (SQLException ex){
            System.out.println("Surgió un problema al intentar grabar en la Base de Datos, acceda a registro.log para mas información.");
            Registro.registroInfo(TiposJDBCImpl.class, TipoLog.ERROR, ex.getMessage());
        } finally {
            conexion.close(stmt);
            conexion.close(conn);
        }
        return rows;
    }

    
    @Override
    public int borrarTipos() {
        int rows = 0;
        try {
            conn = conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE_ALL);
            System.out.println("Borrando el contenido de Tipos de Items en la Base de Datos.");
            Registro.registroInfo(TiposJDBCImpl.class, TipoLog.INFO, "Borrando el contenido de Tipos de Items en la Base de Datos.");
            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Surgió un problema al intentar borrar en la Base de Datos, acceda a registro.log para mas información.");
            Registro.registroInfo(TiposJDBCImpl.class, TipoLog.ERROR, ex.getMessage());
        } finally {
            conexion.close(stmt);
            conexion.close(conn);
        }
        return rows;
    }

    
    @Override
    public List<TipoItemEntity> listarTipos() {        
        ResultSet rs = null;
        TipoItemEntity tipoItem = null;
        List<TipoItemEntity> tiposItems = new ArrayList();
        try {
            conn = conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()){
                tipoItem = new TipoItemEntity(rs.getInt(1), rs.getString(2), rs.getInt(3));
                tiposItems.add(tipoItem);
            }
                    
        } catch (SQLException ex) {
            System.out.println("Surgió un problema al intentar listar de la Base de Datos, acceda a registro.log para mas información.");
            Registro.registroInfo(TiposJDBCImpl.class, TipoLog.ERROR, ex.getMessage());
        } finally {
            conexion.close(rs, stmt, conn);
        }
        return tiposItems;
    }
    
}
