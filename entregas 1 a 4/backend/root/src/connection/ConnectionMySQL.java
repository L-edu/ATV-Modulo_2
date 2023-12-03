package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionMySQL {
	private static final String USERNAME = "root";
	private static final String PASSWORD = "root";
	
	private static final String DATABASE_URL = 
			"jdbc:mysql://localhost:3306/bahiatour";
	public static Connection createConnectionMySQL()throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
		return connection;
	}
	public static void main(String[] args) throws Exception{
		Connection con = createConnectionMySQL();
		if(con!=null) {
			System.out.println("Conexão OK" + con);
			con.close();
		}
	}
}
