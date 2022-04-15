import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Sec31_247_jdbcConnection {

	public static void main(String[] args) throws SQLException {

		String host = "localhost";
		String port = "3306";

		// Connecting java to mySQL Server
		Connection con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/Qadbt", "root", "admin");

		Statement s = con.createStatement();

		ResultSet rs = s.executeQuery("SELECT * FROM qadbt.employeeinfo where name=\"sam\"");
		while (rs.next()) {
			System.out.println(rs.getString("name"));
			System.out.println(rs.getInt("id"));

		}
	}
}
