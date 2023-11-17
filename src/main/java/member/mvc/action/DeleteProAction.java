package member.mvc.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.mvc.dao.MemberDAO;
import test.mvc.action.SuperAction;

public class DeleteProAction implements SuperAction{

	@Override
	public String action(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();	   
	    String id = (String)session.getAttribute("memId");
		String passwd  = request.getParameter("passwd");
		
		MemberDAO manager = MemberDAO.getInstance();
		int check = 0;
		try {
			check = manager.deleteMember(id,passwd);
		} catch (Exception e) {
			e.printStackTrace();
		}
  
		if(check==1){
			session.invalidate();
		}
		request.setAttribute("check", check);
		return "member/deletePro.jsp";
	}
	
}
