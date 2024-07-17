package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBC {

	public static Connection getConnect() {
		
		Connection conn = null;
		
		 String url = "jdbc:sqlserver://localhost:1433;databaseName=QLSV;encrypt=true;trustServerCertificate=true";	
		 String user = "sa";
		 String pass = "123";
	
		try {
			conn = DriverManager.getConnection(url, user, pass);
			
			System.out.println("Kết nối thành công !");
			
		} catch (SQLException e) {
			System.out.println("Kết nối thất bại !");
			e.printStackTrace();
		}
		 return conn;
	}

	
	public static void closeConnect(Connection conn) {
		if(conn != null) { 
			
			try {
				conn.close();
				System.out.println("Đóng kết nối thành công !");
			} catch (SQLException e) {
				System.out.println("Đóng kết nối thất bại !");
				e.printStackTrace();
			}
		}	
	}		
}
