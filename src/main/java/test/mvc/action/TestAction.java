package test.mvc.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.net.ApplicationBufferHandler;

public class TestAction implements SuperAction{
	public String action(HttpServletRequest request,
		                   HttpServletResponse response) {
		//request.setCharacterEncoding("UTF-8");
		
		String msg = request.getParameter("msg");
		msg += "_MVC";
		
		//필요시 dao, dto 호출
		//DAO , DTO  여기다 불러서 작업한다.
		//application.setAttribute  -- 어디서든 사용가능 (자주안씀)
		//session.setAttribute - 해당브라우저에서만
		request.setAttribute("result", msg);  // 전달받은 페이지에서만  
		request.setAttribute("result2", "hello world"); 
		
		
	return "test/test.jsp";
	}
}
