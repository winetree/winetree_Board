package wine.tree.member.service;

import wine.tree.member.dto.Member_Dto;

public interface iMember_Service {
	
	boolean register(Member_Dto dto);
	boolean idCheck(String id);
	boolean login(Member_Dto dto);
	Member_Dto getUserInfo(String id);
	boolean updateMember(Member_Dto dto);
	boolean pwCheck(Member_Dto dto);
}
