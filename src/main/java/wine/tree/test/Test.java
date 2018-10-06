package wine.tree.test;

import com.ibatis.sqlmap.client.SqlMapClient;
import wine.tree.comm.Database;
import wine.tree.comm.SQLSupport;
import wine.tree.member.dao.Member_Dao;
import wine.tree.member.dto.Member_Dto;
import wine.tree.member.service.Member_Service;
import wine.tree.member.service.iMember_Service;

public class Test {
	
	public static void main(String[] args) {

		Member_Dao dao = new Member_Dao();
		Member_Dto dto = new Member_Dto();
		
		dto.setId("winet3fd3e");
		dto.setPw("winetree");
		dto.setWriter("writer");
		dto.setEmail("email@email.com");
		
		boolean isc = dao.register(dto);
		
		System.out.println(isc);
		
		
	}
}
