package test.mvc.action.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import test.mvc.action.SuperAction;

public class LoginProAction implements SuperAction {

	@Override
	public String action(HttpServletRequest request, HttpServletResponse response) {
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		//session 사용
		HttpSession session = request.getSession();
		session.setAttribute("sid", id);
		session.setAttribute("spw", pw);
		
		return "member/loginPro.jsp";
	}

}
