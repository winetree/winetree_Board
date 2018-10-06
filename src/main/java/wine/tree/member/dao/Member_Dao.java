package wine.tree.member.dao;

import com.ibatis.sqlmap.client.SqlMapClient;
import org.apache.log4j.Logger;
import wine.tree.comm.Database;
import wine.tree.comm.SQLSupport;
import wine.tree.member.dto.Member_Dto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Member_Dao extends Database implements iMember_Dao {
	
	SqlMapClient manager = SQLSupport.SQLMapClient;
	Logger logger = Logger.getLogger("Member_Dao");
	
	/**
	 * Register Method
	 *
	 * @param dto
	 * @return true : Registed / false : Register Failed
	 */
	@Override
	public boolean register(Member_Dto dto) {
		Member_Dto result;
		result = new Member_Dto();
		try {
			manager.insert("wine.tree.register", dto);
			result = (Member_Dto)manager.queryForObject("wine.tree.getUserInfo", dto);
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return result.getId()!=null?true:false;
	}
	
	/**
	 * idCheck method
	 *
	 * @param dto
	 * @return true : usable / false : unusable
	 */
	
	@Override
	public boolean idCheck(Member_Dto dto) {
		Member_Dto result = new Member_Dto();
		try {
			result = (Member_Dto)manager.queryForObject("wine.tree.getUserInfo", dto);
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return result!=null?false:true;
	}
	
	@Override
	public boolean pwCheck(Member_Dto dto) {
		Member_Dto result = new Member_Dto();
	
		try {
			result = (Member_Dto)manager.queryForObject("wine.tree.pwCheck", dto);
		} catch(SQLException e) {
			e.printStackTrace();
		}
	
		return result!=null?true:false;
	}
	
	@Override
	public boolean login(Member_Dto dto) {
		Member_Dto result = new Member_Dto();
		try {
			 result = (Member_Dto)manager.queryForObject("wine.tree.login", dto);
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return result!=null?true:false;
	}
	
	@Override
	public Member_Dto getUserInfo(Member_Dto dto) {
		Member_Dto result = new Member_Dto();
		
		try {
			result = (Member_Dto)manager.queryForObject("wine.tree.getUserInfo", dto);
		
		} catch (SQLException e) {
			printMsg("iBatis : 실패", e);
		}
		
		return result;
	}
	
	@Override
	public boolean updateMember(Member_Dto dto) {
		int result = 0;
		
		try {
			result = manager.update("wine.tree.updateUser", dto);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result>0?true:false;
	}
	
}
