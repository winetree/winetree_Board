package wine.tree.member.dao;

import wine.tree.comm.Database;
import wine.tree.member.dto.Member_Dto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Member_Dao_JDBC extends Database implements iMember_Dao {
	
	/**
	 * Register Method
	 *
	 * @param dto
	 * @return true : Registed / false : Register Failed
	 */
	@Override
	public boolean register(Member_Dto dto) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = " INSERT INTO MEMBER(ID, PW, EMAIL, WRITER, REGDATE, \"LEVEL\") VALUES(?, ?, ?, ?, SYSDATE, 1) ";
		
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
		
		return result > 0 ? true : false;
	}
	
	/**
	 * idCheck method
	 *
	 * @param
	 * @return true : usable / false : unusable
	 */
	@Override
	public boolean idCheck(String id) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = " SELECT ID FROM MEMBER WHERE ID = ? ";
		boolean isc = true;
		
		try {
			
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			printMsg("idCheck : SQL ready.");
			
			rs = pstmt.executeQuery();
			printMsg("idCheck : SQL Executed.");
			
			while (rs.next()) {
				if (rs.getString(1).equalsIgnoreCase(id)) {
					isc = false;
				}
			}
			
			printMsg(isc ? "idCheck : Usable ID" : "idCheck : Unusable ID");
			
		} catch (SQLException e) {
			printMsg("idCheck : idCheck Failed", e);
		} finally {
			closed(rs, pstmt, conn);
		}
		return isc;
	}
	
	@Override
	public boolean pwCheck(Member_Dto dto) {
		return false;
	}
	
	/**
	 * @param dto
	 * @return true : login / false : denied
	 */
	@Override
	public boolean login(Member_Dto dto) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = " SELECT ID FROM MEMBER WHERE ID = ? AND PW = ? ";
		
		int result = 0;
		
		try {
			
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPw());
			printMsg("login : SQL ready");
			
			result += pstmt.executeUpdate();
			printMsg("login : SQL Executed");
			
			printMsg(result > 0 ? "login : ID/PW Found" : "login : ID/PW Not matched");
			
		} catch (SQLException e) {
			printMsg("login : Failed", e);
		} finally {
			closed(rs, pstmt, conn);
		}
		
		return result > 0 ? true : false;
	}
	
	@Override
	public Member_Dto getUserInfo(String id) {
		Member_Dto dto = new Member_Dto();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = " SELECT ID, EMAIL, WRITER, REGDATE, PW, \"LEVEL\" FROM MEMBER WHERE ID = ? ";
		
		try {
			
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				dto.setId(rs.getString(1));
				dto.setEmail(rs.getString(2));
				dto.setWriter(rs.getString(3));
				dto.setRegdate(rs.getString(4));
				dto.setPw(rs.getString(5));
				dto.setLevel(rs.getString(6));
			}
			
		} catch (SQLException e) {
			printMsg("getUserInfo : Failed", e);
		} finally {
			closed(rs, pstmt, conn);
		}
		
		return dto;
	}
	
	
	@Override
	public boolean updateMember(Member_Dto dto) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int result = 0;
		
		String sql = " UPDATE MEMBER SET PW = ?, EMAIL = ?, WRITER = ? WHERE ID = ? ";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getPw());
			pstmt.setString(2, dto.getEmail());
			pstmt.setString(3, dto.getWriter());
			pstmt.setString(4, dto.getId());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			printMsg("updateMember : ", e);
		} finally {
			closed(rs, pstmt, conn);
		}
		
		return result>0?true:false;
	}
	
}
