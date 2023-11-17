package test.mvc.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainAction implements SuperAction{
	public String action(HttpServletRequest request,
                          HttpServletResponse response) {
		//DAO , DTO  여기다 불러서 작업한다.
		//System.out.println("wow main");
		return "1113/main.jsp";
	}
	
}
