<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import = "board.mvc.dao.BoardDAO" %>
<%@ page import = "java.sql.Timestamp" %>

<% request.setCharacterEncoding("UTF-8");%>

<jsp:useBean id="article" scope="page" class="board.mvc.dto.BoardDTO">
   <jsp:setProperty name="article" property="*"/>
</jsp:useBean>
 
<%
    article.setReg_date(new Timestamp(System.currentTimeMillis()) );
	article.setIp(request.getRemoteAddr());

	BoardDAO dbPro = BoardDAO.getInstance();
    dbPro.insertArticle(article);

    response.sendRedirect("/mvc/board/list.bo");
%>




