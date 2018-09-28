package wine.tree.member.dao;

import wine.tree.comm.Database;
import wine.tree.member.dto.Member_Dto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Member_Dao extends Database {
	
	public boolean register(Member_Dto dto) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = " INSERT INTO MEMBER(ID, PW, EMAIL, WRITER, REGDATE) VALUES(?, ?, ?, ?, SYSDATE) ";
		
		int result = 0;
		
		try {
			
			conn = getConnection();
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPw());
			pstmt.setString(3, dto.getEmail());
			pstmt.setString(4, dto.getWriter());
			printMsg("Register : 쿼리문 준비 완료.");
			
			result = pstmt.executeUpdate();
			printMsg("Register : 쿼리문 전송 완료.");
		
			printMsg("Register : 회원가입 성공.");
		} catch (SQLException e) {
			printMsg("Register : 회원가입 실패.", e);
		} finally {
			closed(rs, pstmt, conn);
		}
		
		return result>0?true:false;
	}
}
