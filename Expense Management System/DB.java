import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB {
	public static Connection getConnection(){
		Connection con=null;
		Statement statement = null;
		ResultSet resultSet = null;

		// Step 1: Loading or registering Oracle JDBC driver class
		try {

			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
                        String msAccessDBName = "E://Database//Expense.accdb";
			String dbURL = "jdbc:ucanaccess://" + msAccessDBName; 

			// Step 2.A: Create and get connection using DriverManager class
			con = DriverManager.getConnection(dbURL); 
		
		}catch(Exception e){System.out.println(e);}
		return con;
	}

}
