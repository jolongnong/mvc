<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import = "member.mvc.dto.MemberDTO" %>
<%@ page import = "member.mvc.dao.MemberDAO" %>
<%@ page import = "java.sql.Timestamp" %>

<% request.setCharacterEncoding("UTF-8");%>

<jsp:useBean id="member" class="member.mvc.dto.MemberDTO">
    <jsp:setProperty name="member" property="*" />
</jsp:useBean>

<%
    member.setReg_date(new Timestamp(System.currentTimeMillis()) );
	MemberDAO manager = MemberDAO.getInstance();
    manager.insertMember(member);

    response.sendRedirect("/mvc/user/loginForm.me");
%>