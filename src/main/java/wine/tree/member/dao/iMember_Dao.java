package wine.tree.member.dao;

import wine.tree.member.dto.Member_Dto;

public interface iMember_Dao {
	
	boolean register(Member_Dto dto);
	boolean idCheck(Member_Dto dto);
	
	boolean pwCheck(Member_Dto dto);
	
	boolean login(Member_Dto dto);
	Member_Dto getUserInfo(Member_Dto dto);
	boolean updateMember(Member_Dto dto);


}
