package member.mvc.action;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import test.mvc.action.SuperAction;

public class MainAction implements SuperAction{
	
	@Override
	public String action(HttpServletRequest request, HttpServletResponse response) {
		
		return "member/main.jsp";
	}
}
