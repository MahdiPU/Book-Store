import javax.daoTemplate.utils.TemplateDataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class MyDataSource implements TemplateDataSource {
	public Connection getConnection() throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore","root", "123");

	}

	public void closeConnection(Connection con) {
		if(con !=null)
			try { con.close();
			} catch (SQLException e) {e.printStackTrace();}
	}
}
