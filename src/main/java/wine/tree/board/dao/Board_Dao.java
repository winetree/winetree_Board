package wine.tree.board.dao;

import com.ibatis.sqlmap.client.SqlMapClient;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import wine.tree.board.dto.Board_Dto;
import wine.tree.comm.SQLSupport;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Board_Dao extends SQLSupport implements iBoard_Dao {
	
	SqlSessionFactory manager = getSqlSessionFactory();
	Logger logger = Logger.getLogger("Board_Dao");
	
	@Override
	public List<Board_Dto> getAllBoard() {
		List<Board_Dto> lists = null;
			SqlSession session = manager.openSession(true);
		try {
			session.selectList("wine.tree.board.getAllBoard");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return lists;
	}
	
	@Override
	public int insertBoard(Board_Dto dto) {
		int result = 0;
			SqlSession session = manager.openSession(true);
		try {
			result = session.insert("wine.tree.board.insertBoard", dto);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return result;
	}
	
}
