package wine.tree.test;

import wine.tree.comm.Database;
import wine.tree.member.dao.Member_Dao;
import wine.tree.member.dto.Member_Dto;

public class Test {
	
	public static void main(String[] args) {
		
		Member_Dto dto = new Member_Dto();
		
		dto.setId("winetree");
		dto.setPw("password");
		dto.setEmail("hanarinn.naver.com");
		dto.setWriter("hansol");
		
		Member_Dao dao = new Member_Dao();
		
		dao.register(dto);
		
	}
}
