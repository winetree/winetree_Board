package wine.tree.member.dao;

import wine.tree.member.dto.Member_Dto;

public interface iMember_Dao {
	
	public boolean register(Member_Dto dto);
	public boolean idCheck(Member_Dto dto);
	


}
