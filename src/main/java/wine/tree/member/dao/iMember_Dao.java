package wine.tree.member.dao;

import wine.tree.member.dto.Member_Dto;

public interface iMember_Dao {
	
	boolean register(Member_Dto dto);
	boolean idCheck(String id);
	
	boolean pwCheck(Member_Dto dto);
	
	boolean login(Member_Dto dto);
	Member_Dto getUserInfo(String id);
	boolean updateMember(Member_Dto dto);


}
