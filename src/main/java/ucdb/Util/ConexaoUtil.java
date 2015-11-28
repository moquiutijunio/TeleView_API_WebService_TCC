package ucdb.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ConexaoUtil {
	public static Connection getConnection() {

		try {
			Class.forName("org.postgresql.Driver");
			String url = "jdbc:postgresql://localhost:5432/TeleView";
			String usuario = "postgres";
			String senha = "postgres";
			try {
				Connection connection = DriverManager.getConnection(url,
						usuario, senha);
				return connection;
			} catch (SQLException ex) {
				Logger.getLogger(ConexaoUtil.class.getName()).log(Level.SEVERE,
						null, ex);
			}

			return null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
			
		}

	}
}
