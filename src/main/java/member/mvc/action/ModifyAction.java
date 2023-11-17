package member.mvc.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.mvc.action.SuperAction;

public class ModifyAction implements SuperAction{

	@Override
	public String action(HttpServletRequest request, HttpServletResponse response) {

		return "member/modify.jsp";
	}

}
