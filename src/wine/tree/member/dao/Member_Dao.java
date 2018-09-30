package wine.tree.member.dao;

import wine.tree.comm.Database;
import wine.tree.member.dto.Member_Dto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Member_Dao extends Database implements iMember_Dao{
	
	
	/**
	 * Register Method
	 * @param dto
	 * @return true : Registed / false : Register Failed
	 */
	@Override
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
			printMsg("Register : SQL Ready.");
			
			result = pstmt.executeUpdate();
			printMsg("Register : SQL Executed.");
		
			printMsg("Register : Registered.");
		} catch (SQLException e) {
			printMsg("Register : Register Failed.", e);
		} finally {
			closed(rs, pstmt, conn);
		}
		
		return result>0?true:false;
	}
	
	/**
	 * idCheck method
	 * @param dto
	 * @return true : usable / false : unusable
	 */
	@Override
	public boolean idCheck(Member_Dto dto) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String id = dto.getId();
		String sql = " SELECT ID FROM MEMBER WHERE ID = ? ";
		boolean isc = true;
		
		try {
			
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			printMsg("idCheck : SQL ready.");
			
			rs = pstmt.executeQuery();
			printMsg("idCheck : SQL Executed.");
			
			while(rs.next()) {
				if (rs.getString(1).equalsIgnoreCase(id)) {
					isc = false;
				}
			}
			
			printMsg(isc?"idCheck : Usable ID":"idCheck : Unusable ID");
		
		} catch (SQLException e) {
			printMsg("idCheck : idCheck Failed", e);
		} finally {
			closed(rs, pstmt, conn);
		}
		return isc;
	}
}
