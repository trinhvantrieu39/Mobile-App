package ConnectDatabase;
import java.sql.*;

public class getMySQLConnection {
	final String url = "jdbc:mysql://localhost:3306/cuahangdongho";
	final String user = "root";
	final String pass = "";
	Connection conn = null;
	Statement stmt = null;
	
	public static Connection getMySQLConnection(String host, String dbName, String user, String pass) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.jdbc.Driver");
		String connectionURL = "jdbc:mysql://" + host+ ":3306/" + dbName;
		Connection conn =DriverManager.getConnection(connectionURL, user, pass);
		
		return conn;
	}
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Connection c = getMySQLConnection("localhost","banhang","root","");
		if(c==null) {
			System.out.println("ook");
		}
		else
			System.out.println("nooooooooo");
	}
}
