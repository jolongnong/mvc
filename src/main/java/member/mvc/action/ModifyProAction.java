package member.mvc.action;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.mvc.dao.MemberDAO;
import member.mvc.dto.MemberDTO;
import test.mvc.action.SuperAction;

public class ModifyProAction implements SuperAction{

	@Override
	public String action(HttpServletRequest request, HttpServletResponse response) {
		
		try { // 미리 작성해두어야함
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {			
			e.printStackTrace();
		}
		
		
		HttpSession session = request.getSession();
	      String id = (String) session.getAttribute("memId");
		
	      MemberDTO dto = new MemberDTO();
	      dto.setId(id);;
	      dto.setPasswd(request.getParameter("passwd"));
	      dto.setName(request.getParameter("name"));
	      dto.setEmail(request.getParameter("email"));
	      dto.setBlog(request.getParameter("blog"));
	      
	      MemberDAO manager = MemberDAO.getInstance();
	      try {    	  
			manager.updateMember(dto);
		} catch (Exception e) {
			e.printStackTrace();
		}
	      
		return "member/modifyPro.jsp";
	}
	
}
