package wine.tree.board.servlet;

import wine.tree.member.dto.Member_Dto;
import wine.tree.member.service.Member_Service;
import wine.tree.member.service.iMember_Service;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterCtrl extends ServletComm {
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		
		iMember_Service service = new Member_Service();
		
		String command = req.getParameter("command");
		
		if (command.equalsIgnoreCase("form")) {
			res.sendRedirect("/register/registerForm.jsp");
		} else if (command.equalsIgnoreCase("register")) {
			
			String id = req.getParameter("id");
			String pw = req.getParameter("pw");
			String writer = req.getParameter("writer");
			String email = req.getParameter("email");
			
			Member_Dto dto = new Member_Dto();
			
			dto.setId(id);
			dto.setPw(pw);
			dto.setWriter(writer);
			dto.setEmail(email);
			
			boolean isc = service.register(dto);
			
			
			if(isc) {
				req.setAttribute("dto", dto);
				dispatcher("/register/registered.jsp", req, res);
			} else {
				req.setAttribute("errMsg", "뭔가 실패");
				dispatcher("/comm/error.jsp", req, res);
			}
		}
	
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}
}
