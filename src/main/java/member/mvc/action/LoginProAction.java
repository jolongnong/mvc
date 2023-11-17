package member.mvc.action;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.mvc.dao.MemberDAO;
import test.mvc.action.SuperAction;

public class LoginProAction implements SuperAction{
	@Override
	public String action(HttpServletRequest request, HttpServletResponse response) {
		try { // 미리 작성해두어야함
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {			
			e.printStackTrace();
		}
		
		String id = request.getParameter("id");
		String passwd  = request.getParameter("passwd");
		
		MemberDAO manager = MemberDAO.getInstance();		
		try {
			int check= manager.userCheck(id,passwd);
			/*
			 * if(check ==1) { HttpSession session = request.getSession();
			 * session.setAttribute("id", id); }
			 */
			request.setAttribute("check", check);
			request.setAttribute("id", id);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return "member/loginPro.jsp";
	}
}
