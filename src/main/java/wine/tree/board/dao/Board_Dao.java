package wine.tree.board.dao;

import com.ibatis.sqlmap.client.SqlMapClient;
import org.apache.log4j.Logger;
import wine.tree.board.dto.Board_Dto;
import wine.tree.comm.SQLSupport;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Board_Dao implements iBoard_Dao {

	SqlMapClient manager = SQLSupport.SQLMapClient;
	Logger logger = Logger.getLogger("Board_Dao");
	
	@Override
	public List<Board_Dto> getAllBoard() {
		List<Board_Dto> lists = new ArrayList<Board_Dto>();

		try {
			lists = (List<Board_Dto>)manager.queryForList("wine.tree.board.getAllBoard");
		} catch(SQLException e ) {
			e.printStackTrace();
		}
		return lists;
	}
	
	@Override
	public int insertBoard(Board_Dto dto) {
		int result = 0;
		try {
			manager.insert("wine.tree.board.insertBoard", dto);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

}
