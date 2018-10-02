package wine.tree.test;

import wine.tree.comm.Database;
import wine.tree.member.dao.Member_Dao;
import wine.tree.member.dto.Member_Dto;
import wine.tree.member.service.Member_Service;
import wine.tree.member.service.iMember_Service;

public class Test {
	
	public static void main(String[] args) {
		
		Member_Dto dto = new Member_Dto();
		
		dto.setId("winetree");
		dto.setPw("winetree");
		
		iMember_Service service = new Member_Service();
		
		service.login(dto);
		
	}
}
