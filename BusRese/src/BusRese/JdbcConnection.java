package BusRese;
import java.sql.*;

public class JdbcConnection {
	private static final  String url = "jdbc:mysql://localhost:3306/busreserv";
	private static final  String username = "root";
	private static final  String password = "Gokul@123/1854";
	public static Connection getConnection() throws SQLException{
		return DriverManager.getConnection(url,username,password);
	}
}
