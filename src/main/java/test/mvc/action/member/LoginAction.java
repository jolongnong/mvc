package test.mvc.action.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.mvc.action.SuperAction;

public class LoginAction implements SuperAction{
	public String action(HttpServletRequest request,
            HttpServletResponse response) {
		
		return "member/login.jsp";
	}
	
}
