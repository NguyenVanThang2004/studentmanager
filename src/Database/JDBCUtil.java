package Database;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.DriverPropertyInfo;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Properties;
import java.util.logging.Logger;

public class JDBCUtil {

	public static Connection getConnection() {
		Connection connect = null;
		try {
			// sign up drive manager
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());

			// setting
			String url = "jdbc:mysql://localhost:3306/studentmanager";
			String username = "root";
			String password = "";

			// connect
			connect = DriverManager.getConnection(url, username, password);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return connect;
	}

	public static void closeConnection(Connection connect) {
		try {
			if (connect != null) {
				connect.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
