package in.fssa.missnature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import io.github.cdimascio.dotenv.Dotenv;

public class ConnectionUtil {
	/**
	 * 
	 * @return
	 */
	public static Connection getConnection() {
		
	String url;
	String userName;
	String password;
	

	// cloud database
	
//         url = System.getenv("DATABASE_HOSTNAME");
//         userName = System.getenv("DATABASE_USERNAME");
//         password = System.getenv("DATABASE_PASSWORD");
    
    	// local 
    	url = "jdbc:mysql://164.52.216.41:3306/saranya_ramesh__corejava_project";
    	userName = "13WSR0mXUsnO";
    	password = "7231823c-1c64-446b-9f0b-aa0a287ef8f5";
    		
    
		Connection connection = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 connection = DriverManager.getConnection(url,userName,password);
		}
		catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return connection;
	}
/**
 * 
 * @param connection
 * @param ps
 */
	public static void close(Connection connection , PreparedStatement  ps) {
		try {
			if(ps !=null) {
				ps.close();
			}
			if(connection!= null) {
				connection.close();
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 
	 * @param connection
	 * @param ps
	 * @param rs
	 */
	public static void close(Connection connection , PreparedStatement  ps , ResultSet  rs) {
		try {
			if(rs != null) {
				rs.close();
			}
			if(ps != null) {
				ps.close();
			}
			if(connection != null) {
				connection.close();
			}			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
