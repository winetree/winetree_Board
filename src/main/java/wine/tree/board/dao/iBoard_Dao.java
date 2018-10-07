package wine.tree.board.dao;

import wine.tree.board.dto.Board_Dto;

import java.util.List;

public interface iBoard_Dao {
	List<Board_Dto> getAllBoard();
	
	int insertBoard(Board_Dto dto);
}
