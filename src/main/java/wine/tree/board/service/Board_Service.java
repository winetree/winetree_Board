package wine.tree.board.service;

import wine.tree.board.dao.Board_Dao;
import wine.tree.board.dao.iBoard_Dao;
import wine.tree.board.dto.Board_Dto;

import java.util.List;


public class Board_Service implements iBoard_Service {
	
	iBoard_Dao dao;
	
	public Board_Service() {
		dao = new Board_Dao();
	}
	
	@Override
	public List<Board_Dto> getAllBoard() {
		return dao.getAllBoard();
	}



}
