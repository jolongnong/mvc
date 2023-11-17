package test.mvc.action;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Jstl2Action implements SuperAction {

	@Override
	public String action(HttpServletRequest request, HttpServletResponse response) {
		
		request.setAttribute("money", 100000000);
		request.setAttribute("pi", Math.PI);
		
		Date day = new Date();
		request.setAttribute("day", day);
		
		return "1114/jstl02.jsp";
	}

}
