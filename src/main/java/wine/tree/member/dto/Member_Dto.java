package wine.tree.member.dto;

import java.io.Serializable;

public class Member_Dto implements Serializable {
	
	
	private static final long serialVersionUID = -4672395975905508513L;
	
	private String id;
	private String pw;
	private String email;
	private String writer;
	private String regdate;
	private String level;
	
	public Member_Dto() {
	}
	
	public Member_Dto(String id, String pw, String email, String writer, String regdate, String level) {
		this.id = id;
		this.pw = pw;
		this.email = email;
		this.writer = writer;
		this.regdate = regdate;
		this.level = level;
	}
	
	@Override
	public String toString() {
		return "Member_Dto{" +
			"id='" + id + '\'' +
			", pw='" + pw + '\'' +
			", email='" + email + '\'' +
			", writer='" + writer + '\'' +
			", regdate='" + regdate + '\'' +
			", level='" + level + '\'' +
			'}';
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getPw() {
		return pw;
	}
	
	public void setPw(String pw) {
		this.pw = pw;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getWriter() {
		return writer;
	}
	
	public void setWriter(String writer) {
		this.writer = writer;
	}
	
	public String getRegdate() {
		return regdate;
	}
	
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	
	public String getLevel() {
		return level;
	}
	
	public void setLevel(String level) {
		this.level = level;
	}
}
