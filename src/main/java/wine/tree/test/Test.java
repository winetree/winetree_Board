package wine.tree.test;

import com.ibatis.sqlmap.client.SqlMapClient;
import wine.tree.board.dao.Board_Dao;
import wine.tree.board.dto.Board_Dto;
import wine.tree.comm.Database;
import wine.tree.comm.SQLSupport;
import wine.tree.member.dao.Member_Dao;
import wine.tree.member.dto.Member_Dto;
import wine.tree.member.service.Member_Service;
import wine.tree.member.service.iMember_Service;
import wine.tree.board.service.*;

import java.util.List;

public class Test {
	
	public static void main(String[] args) {
		
		Board_Dao dao = new Board_Dao();
		
		Board_Dto dto = new Board_Dto();
		
		dto.setId("winetree");
		dto.setWriter("winetree");
		dto.setTitle("title");
		dto.setContent("content");
		
		dao.insertBoard(dto);

	}
}
