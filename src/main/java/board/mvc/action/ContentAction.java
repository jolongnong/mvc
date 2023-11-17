package board.mvc.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.mvc.action.SuperAction;

public class ContentAction implements SuperAction {

	@Override
	public String action(HttpServletRequest request, HttpServletResponse response) {
		
		return "board/content.jsp";
	}

}
