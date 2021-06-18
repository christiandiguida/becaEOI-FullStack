package utilidades;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtils {
    public static ResultSet StatementGenerico(String sql, Connection con, String url, String usuario, String password) {
        ResultSet rs = null;
        try {
            con = DriverManager.getConnection(url, usuario, password);
            Statement st = con.createStatement();
            rs = st.executeQuery(sql);
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
