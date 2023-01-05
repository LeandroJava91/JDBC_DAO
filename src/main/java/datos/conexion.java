
package datos;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class conexion {
    
    private static final String JDBC_URL= "jdbc:mysql://127.0.0.1:5050/curso?serverTimezone=UTC";
    private static final String JDBC_USER= "root";
    private static final String JDBC_PASS= "sasa";
    
    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(JDBC_URL,JDBC_USER,JDBC_PASS);
    }
    
    public static void close(ResultSet rs) throws SQLException{
        rs.close();
    }  
    
    public static void close(Statement smtm) throws SQLException{
        smtm.close();
    }
    
    public static void close(PreparedStatement smtm) throws SQLException{
        smtm.close();
    }
    
    public static void close(Connection conn) throws SQLException{
        conn.close();
    }
    
    
}
