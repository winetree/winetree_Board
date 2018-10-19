package wine.tree.test;

import com.ibatis.sqlmap.client.SqlMapClient;
import wine.tree.board.dao.Board_Dao;
import wine.tree.board.dto.Board_Dto;
import wine.tree.comm.Database;
import wine.tree.comm.SQLSupport;
import wine.tree.comm.SQLSupport_MyBatis;
import wine.tree.member.dao.Member_Dao;
import wine.tree.member.dto.Member_Dto;
import wine.tree.member.service.Member_Service;
import wine.tree.member.service.iMember_Service;
import wine.tree.board.service.*;

import java.util.List;

public class Test {
	
	public static void main(String[] args) {
		
		
		
		Member_Dao dao = new Member_Dao();
		Member_Dto dto = new Member_Dto();
		
		dto.setId("winetree");

		Member_Dto dto2 = dao.getUserInfo(dto.getId());
		
		System.out.println(dto2);
	}
}
