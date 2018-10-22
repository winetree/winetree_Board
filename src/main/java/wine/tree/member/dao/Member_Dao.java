package wine.tree.member.dao;

import com.ibatis.sqlmap.client.SqlMapClient;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import wine.tree.comm.Database;
import wine.tree.comm.SQLSupport;
import wine.tree.member.dto.Member_Dto;

import javax.servlet.jsp.PageContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Member_Dao extends SQLSupport implements iMember_Dao {
	
	SqlSessionFactory manager = getSqlSessionFactory();
	Logger logger = Logger.getLogger(Member_Dao.class);
	
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
			SqlSession session = manager.openSession(true);
		try {
			session.insert("wine.tree.register", dto);
			result = session.selectOne("wine.tree.getUserInfo", dto);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return result.getId() != null ? true : false;
	}
	
	/**
	 * idCheck method
	 *
	 * @param dto
	 * @return true : usable / false : unusable
	 */
	
	@Override
	public boolean idCheck(String id) {
		Member_Dto result = null;
		
		SqlSession session = getSqlSessionFactory().openSession(true);
		
		try {
			result = session.selectOne("wine.tree.getUserInfo", id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return result != null ? false : true;
	}
	
	@Override
	public boolean pwCheck(Member_Dto dto) {
		Member_Dto result = new Member_Dto();
		SqlSession session = getSqlSessionFactory().openSession(true);
		try {
			result = session.selectOne("wine.tree.pwCheck", dto);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return result != null ? true : false;
	}
	
	@Override
	public boolean login(Member_Dto dto) {
		Member_Dto result = new Member_Dto();
		SqlSession session = getSqlSessionFactory().openSession(true);
		try {
			result = session.selectOne("wine.tree.login", dto);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return result != null ? true : false;
	}
	
	@Override
	public Member_Dto getUserInfo(String id) {
		Member_Dto result = null;
		SqlSession session = getSqlSessionFactory().openSession(true);
		try {
			result = session.selectOne("wine.tree.getUserInfo", id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return result;
	}
	
	@Override
	public boolean updateMember(Member_Dto dto) {
		int result = 0;
		
		SqlSession session = getSqlSessionFactory().openSession(true);
		try {
			result = session.update("wine.tree.updateUser", dto);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return result > 0 ? true : false;
	}
	
}
