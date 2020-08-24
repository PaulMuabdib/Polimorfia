/**
 * @author: Paul Muabdib
 * @version: 1.0
 */

package adaptadoresSecundarios.baseDeDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import negocio.registro.Registro;
import negocio.registro.TipoLog;
import puertosSecundarios.baseDeDatos.ConexionDB;

/**
 * Implementacion de ConexionDB
 * @see ConexionDB
 */
public class ConexionDBImpl implements ConexionDB{
    private static final String JDBC_URL = "jdbc:mysql://localhost:3333/wowdb?useSSL=false&serverTimezone=UTC";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASS = "admin";
    
    
    @Override
    public Connection getConnection() throws SQLException {
        Registro.registroInfo(ConexionDBImpl.class, TipoLog.INFO, "Creando conexion con la Base de Datos");
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS);
    }

    
    @Override
    public void close(ResultSet re) {
        try{
            re.close();
            Registro.registroInfo(ConexionDBImpl.class, TipoLog.INFO, "Cerrando ResultSet");
        } catch (SQLException ex){
            ex.printStackTrace(System.out);
            System.out.println("Surgió un problema al intentar cerrar la conexión con la Base de Datos, acceda a registro.log para mas información.");
            Registro.registroInfo(ConexionDBImpl.class, TipoLog.ERROR, ex.getMessage());
        }
    }

    
    @Override
    public void close(PreparedStatement stmt) {
        try {
            stmt.close();
            Registro.registroInfo(ConexionDBImpl.class, TipoLog.INFO, "Cerrando PreparedStatement");
        } catch (SQLException ex){
            System.out.println("Surgió un problema al intentar cerrar la conexión con la Base de Datos, acceda a registro.log para mas información.");
            Registro.registroInfo(ConexionDBImpl.class, TipoLog.ERROR, ex.getMessage());
        }
    }

    
    @Override
    public void close(Connection con) {
        try {
            con.close();
            Registro.registroInfo(ConexionDBImpl.class, TipoLog.INFO, "Cerrando conexión con la Base de Datos");
        } catch (SQLException ex){
            System.out.println("Surgió un problema al intentar cerrar la conexión con la Base de Datos, acceda a registro.log para mas información.");
            Registro.registroInfo(ConexionDBImpl.class, TipoLog.ERROR, ex.getMessage());
        }
    }

    
    @Override
    public void close(ResultSet rs, PreparedStatement stmt, Connection con) {
        try {
            rs.close();
            Registro.registroInfo(ConexionDBImpl.class, TipoLog.INFO, "Cerrando ResultSet");
            stmt.close();
            Registro.registroInfo(ConexionDBImpl.class, TipoLog.INFO, "Cerrando PreparedStatement");
            con.close();
            Registro.registroInfo(ConexionDBImpl.class, TipoLog.INFO, "Cerrando conexión con la Base de Datos");
        } catch (SQLException ex) {
            System.out.println("Surgió un problema al intentar cerrar la conexión con la Base de Datos, acceda a registro.log para mas información.");
            Registro.registroInfo(ConexionDBImpl.class, TipoLog.ERROR, ex.getMessage());
        }
    }    
}
