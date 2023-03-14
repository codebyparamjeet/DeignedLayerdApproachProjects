package in.main.jdbcUtilPack;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.print.DocFlavor.URL;

public class jdbcUtilPack {
	
	private jdbcUtilPack() {}
	
	static {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection getJDBCConnection() throws SQLException, IOException {
		FileInputStream fis = new FileInputStream("src\\in\\main\\properties\\application.properties");
		Properties properties = new Properties();
		properties.load(fis);
		Connection connection = DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("username"),properties.getProperty("password"));
		return connection;
	}
	
	public void closeUp(Connection con, ResultSet res, Statement stmt)
	{
		try {
			con.close();
			res.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	

}
