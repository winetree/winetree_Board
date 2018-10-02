package wine.tree.member.service;

import wine.tree.member.dao.Member_Dao;
import wine.tree.member.dao.iMember_Dao;
import wine.tree.member.dto.Member_Dto;

public class Member_Service implements iMember_Service {

	private iMember_Dao dao;
	
	public Member_Service(){
		dao = new Member_Dao();
	}
	
	
	@Override
	public boolean register(Member_Dto dto) {
		return dao.register(dto);
	}
	
	@Override
	public boolean idCheck(Member_Dto dto) {
		return dao.idCheck(dto);
	}
	
	@Override
	public boolean login(Member_Dto dto) {
		return dao.login(dto);
	}
}
