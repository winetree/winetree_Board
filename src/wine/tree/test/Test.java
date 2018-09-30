package wine.tree.test;

import wine.tree.comm.Database;
import wine.tree.member.dao.Member_Dao;
import wine.tree.member.dto.Member_Dto;

public class Test {
	
	public static void main(String[] args) {
		
		Member_Dto dto = new Member_Dto();
		
		dto.setId("winetree");
		
		Member_Dao dao = new Member_Dao();
		
		boolean isc = dao.idCheck(dto);
		
		System.out.println(isc);
		
	}
}
