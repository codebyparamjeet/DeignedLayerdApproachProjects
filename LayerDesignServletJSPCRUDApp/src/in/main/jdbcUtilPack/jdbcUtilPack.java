package in.main.jdbcUtilPack;

import java.io.FileInputStream;  
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;



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
	
	public static Connection getJDBCConnection() throws SQLException, IOException{
		
//		String fileLoc = "F:\\Design Layer Approach Projects\\ServletLayerCRUDApp\\JDBCCrudApp\\src\\in\\main\\properties\\application.properties";
//		HikariConfig config = new HikariConfig(fileLoc);
//		HikariDataSource dataSource = new HikariDataSource(config);

//		return dataSource.getConnection();
		return physicalConnection();
	}

	private static Connection physicalConnection() throws FileNotFoundException, IOException, SQLException {
		String fileLoc = "F:\\Design Layer Approach Projects\\ServletLayerCRUDApp\\MVCJSPCrudApp\\src\\in\\main\\properties\\application.properties";
		FileInputStream fis = new FileInputStream(fileLoc);
		Properties properties = new Properties();
		properties.load(fis);
		String url= properties.getProperty("url");
		String username = properties.getProperty("username");
		String password = properties.getProperty("password");
		return DriverManager.getConnection(url, username, password);
	}

}
