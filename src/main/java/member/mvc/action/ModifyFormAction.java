package member.mvc.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;

import member.mvc.dao.MemberDAO;
import member.mvc.dto.MemberDTO;
import test.mvc.action.SuperAction;

public class ModifyFormAction implements SuperAction{

   @Override
   public String action(HttpServletRequest request, HttpServletResponse response) {
      try {
         request.setCharacterEncoding("UTF-8");
      } catch (Exception e) {
         e.printStackTrace();
      }
      HttpSession session = request.getSession();
      String id = (String) session.getAttribute("memId");
      request.setAttribute("id", id);
      
      
      MemberDAO manager = MemberDAO.getInstance();
      try {
         MemberDTO c = manager.getMember(id);
         request.setAttribute("dto", c);
         
      } catch (Exception e) {
         e.printStackTrace();
      }
      return "member/modifyForm.jsp";
   }

}