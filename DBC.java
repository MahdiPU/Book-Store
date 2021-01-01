import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBC {
	private static Connection con ;
	
	public DBC() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore?" + "user=root&password=123");
			System.out.println("DB connection successful.");
		} catch (ClassNotFoundException e) {
			System.out.println("Failed to find driver class.");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("DB connection failed.");
			e.printStackTrace();
		}
	}
	public static void disConnect() {
		if (con != null) {
		    try {
			con.close();
			System.out.println("DB connection closed.");
		    }
		    catch (SQLException e) {
			System.out.println("DB connection failed to close.");
			e.printStackTrace();
		    }
		}
	    }
	public static Connection getConnection() {
		try {
		    if (con == null || con.isClosed())
			new DBC();
		}
		catch (SQLException ex) {
		    System.out.println(ex.getMessage());
		    ex.printStackTrace();
		}
		return con;
	    }

}
