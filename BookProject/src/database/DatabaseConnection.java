package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

	static Connection connection;
	
	public static Connection connecttoDb()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String username="root";
			String password="root";
			String datainfo="jdbc:mysql://localhost:3306/books_db";
			
			connection=DriverManager.getConnection(datainfo,username,password);
		} 
		catch (ClassNotFoundException e) { e.printStackTrace();}
		catch ( SQLException e) { e.printStackTrace();}
		return connection;
	}
}
