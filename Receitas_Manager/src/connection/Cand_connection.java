package connection;
/**
 *
 * @author GILBERTO
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Cand_connection {
    private final String servidor = "jdbc:mysql://localhost:3306/CandyCream?useTimezone=true&serverTimezone=UTC";
    private final String usuario = "root";
    private final String senha = "password";
    private final String driver = "com.mysql.cj.jdbc.Driver";
    
    public Connection getConnection(){
        try {
            Class.forName(driver);
            return (Connection)DriverManager.getConnection(servidor, usuario, senha);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Erro de conexao : "+e.getMessage());
        }
        return null;
    }
    
    public static void closeConnection(Connection con){
        if(con!=null){
            try {
                con.close();
            } catch (SQLException ex) {
                System.err.println("erro ao fechar conection:"+ex);
            }
        }
    }
    
    public static void closeConnection(Connection con,PreparedStatement stmt){
        if(con!=null){
            try {
                stmt.close();
            } catch (SQLException ex) {
                System.err.println("erro ao fechar statement:"+ex);
            }
        }
        closeConnection(con);
    }
    
    public static void closeConnection(Connection con,PreparedStatement stmt,ResultSet rs){
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException ex) {
                System.err.println("erro ao fechar result:"+ex);
            }
        }
        closeConnection(con,stmt);
    }
    
}
