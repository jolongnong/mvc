package member.mvc.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import test.mvc.action.SuperAction;

public class LogoutAction implements SuperAction{

	@Override
	public String action(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session=request.getSession();
		session.invalidate();
		return "member/logout.jsp";
	}

}
