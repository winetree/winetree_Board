package wine.tree.member.service;

import wine.tree.member.dto.Member_Dto;

public interface iMember_Service {
	
	public boolean register(Member_Dto dto);
	public boolean idCheck(Member_Dto dto);
	public boolean login(Member_Dto dto);
	public Member_Dto getUserInfo(String id);
	public boolean updateMember(Member_Dto dto);

}
