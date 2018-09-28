package wine.tree.comm;

import java.sql.*;
import java.util.Date;

public class Database {
	
	public Database() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			printMsg("Database : 드라이버 로딩 성공");
		} catch (ClassNotFoundException e) {
			printMsg("Database : 드라이버 로딩 실패", e);
		}
	}
	
	public Connection getConnection() {
		Connection conn = null;
		
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String username = "winetreeboard";
		String password = "winetreeboard";
		
		try {
			conn = DriverManager.getConnection(url, username, password);
			printMsg("Database : 연결 성공");
		} catch (SQLException e) {
			printMsg("Database : 연결 실패", e);
		}
		
		return conn;
	}
	
	public void closed(ResultSet rs, Statement pstmt, Connection conn) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (conn != null) {
				conn.close();
			}
			printMsg("Database : 연결 해제 성공");
		} catch (SQLException e) {
			printMsg("Database : 연결 해제 실패", e);
		}
	}
	
	
	public void printMsg(String str) {
		System.out.println(new Date().toLocaleString() + " : " + str);
	}
	
	public void printMsg(String str, Exception e) {
		System.out.println(new Date().toLocaleString() + " : " + str);
		e.printStackTrace();
	}
}
