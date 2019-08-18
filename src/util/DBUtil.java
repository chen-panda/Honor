package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	public static String url = "jdbc:mysql://127.0.0.1:3306/wzry?characterEncoding=UTF-8";
	public static String user = "root";
	public static String pwd = "root";
	public static String driver = "com.mysql.jdbc.Driver";
	
	public static Connection getCon(){
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, pwd);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
		
	}
	
	public static void closeCon(Connection con){
		if(con!=null){
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		System.out.println(getCon());
	}
}
