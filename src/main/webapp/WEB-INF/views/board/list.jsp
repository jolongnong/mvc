<%@ page contentType = "text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import = "board.mvc.dao.BoardDAO" %>
<%@ page import = "board.mvc.dto.BoardDTO" %>
<%@ page import = "java.util.List" %>
<%@ page import = "java.text.SimpleDateFormat" %>
<%@ include file="/resources/etc/color.jsp"%>





<%
    int pageSize = 10;  
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    String pageNum = request.getParameter("pageNum");
    if (pageNum == null) {
        pageNum = "1";
    }

    int currentPage = Integer.parseInt(pageNum);
    int startRow = (currentPage - 1) * pageSize + 1;
    int endRow = currentPage * pageSize;
    int count = 0;
    int number=0;

    List articleList = null;
    BoardDAO dbPro = BoardDAO.getInstance();
    count = dbPro.getArticleCount();
    if (count > 0) {
        articleList = dbPro.getArticles(startRow, endRow);
    }

	number=count-(currentPage-1)*pageSize;
%>
<html>
<head>
<title>게시판</title>
<link href="/mvc/resources/etc/style.css" rel="stylesheet" type="text/css"> 
</head>

<body bgcolor="${bodyback_c}">

<center><b>글목록(전체 글:${count})</b>
<table width="700">
<tr>
    <td align="right" bgcolor="${value_c}">
    	<a href="/mvc/board/writeForm.bo">글쓰기</a>
    </td>
</table>

<%
    if (count == 0) {
%>

<c:if test="${count==0 }">

<table width="700" border="1" cellpadding="0" cellspacing="0">
<tr>
    <td align="center">
    게시판에 저장된 글이 없습니다.
    </td>
</table>
</c:if>

<%  } else {    %>
<table border="1" width="700" cellpadding="0" cellspacing="0" align="center"> 
    <tr height="30" bgcolor="${value_c}"> 
       <td align="center"  width="50"  >번 호</td> 
      <td align="center"  width="250" >제   목</td> 
      <td align="center"  width="100" >작성자</td>
      <td align="center"  width="150" >작성일</td> 
      <td align="center"  width="50" >조 회</td> 
      <td align="center"  width="100" >IP</td>   
    </tr>
<%  
        for (int i = 0 ; i < articleList.size() ; i++) {
          BoardDTO article = (BoardDTO)articleList.get(i);
%>
   <tr height="30">
    <td align="center"  width="50" > <%=number--%></td>
    <td  width="250" >
	<%
	      int wid=0; 
	      if(article.getRe_level() > 0){
	        wid=20*(article.getRe_level());
	%>
	  <img src="images/level.gif" width="<%=wid%>" height="16">
	  <img src="images/re.gif">
	<%}else{%>
	  <img src="images/level.gif" width="<%=wid%>" height="16">
	<%}%>
           
      <a href="/mvc/board/content.bo?num=<%=article.getNum()%>&pageNum=<%=currentPage%>">
           <%=article.getSubject()%></a> 
          <% if(article.getReadcount() >= 20){%>
         <img src="images/hot.gif" border="0"  height="16"><%}%> </td>
    <td align="center"  width="100"> 
       <a href="mailto:<%=article.getEmail()%>"><%=article.getWriter()%></a></td>
    <td align="center"  width="150"><%= sdf.format(article.getReg_date())%></td>
    <td align="center"  width="50"><%=article.getReadcount()%></td>
    <td align="center" width="100" ><%=article.getIp()%></td>
  </tr>
     <%}%>
</table>
<%}%>


    
 <c:if test="${startPage>10}">      		 
		 <a href="/mvc/board/list.bo?pageNum=${startPage-10}">[이전]</a>
<c:forEach var="i" begin="${startPage}" end="${endPage}" step="1">
		<a href="/mvc/board/list.bo?pageNum=${startPage}">[${startPage}]</a>
</c:forEach>
</c:if> 

 <c:if test="${startPage>10}">  	
        <a href="/mvc/board/list.bo?pageNum=${startPage+10}">[다음]</a>
     </c:if>  



</center>
</body>
</html>