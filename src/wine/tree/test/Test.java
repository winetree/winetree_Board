package wine.tree.test;

import wine.tree.comm.Database;
import wine.tree.member.dao.Member_Dao;
import wine.tree.member.dto.Member_Dto;
import wine.tree.member.service.Member_Service;
import wine.tree.member.service.iMember_Service;

public class Test {
	
	public static void main(String[] args) {
		
		iMember_Service service = new Member_Service();
		
		Member_Dto dto = service.getUserInfo("winetree");
		
		System.out.println(dto);
		
		boolean isc = service.updateMember(dto);
		
		System.out.println(isc);
		
	}
}
