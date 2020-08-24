/**
 * @author: Paul Muabdib
 * @version: 1.0 
 */
package puertosSecundarios.baseDeDatos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

/** 
 * Realiza las gestiones para la conexión con la Base de Datos
 * 
 */
public interface ConexionDB {
    
    /**
     * Realiza la conexion con la Base de Datos
     * @return Connection (Conexión con la Base de Datos)
     * @throws SQLException (Error al conectarse)
     */
    public Connection getConnection() throws SQLException;
    
    /**
     * Cierra el ResultSet
     * @param re (ResultSet a cerrar)
     */
    void close (ResultSet re);
    
    /**
     * Cierra el PreparedStatement
     * @param stmt (PreparedStatement a cerrar)
     */
    void close (PreparedStatement stmt);
    
    /**
     * Cierra la conexión.
     * @param con (Conexión a cerrar)
     */
    void close (Connection con);
    
    /**
     * Cierra el ResultSet, el PreparedStatement y la Conexión
     * @param rs (ResultSet a cerrar)
     * @param stmt (PreparedStatement a cerrar)
     * @param conn (Conexión a cerrar)
     */
    void close (ResultSet rs, PreparedStatement stmt, Connection conn);
    
}
