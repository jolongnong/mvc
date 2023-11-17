<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>

    <h2>/WEB-INF/view/test/test.jsp</h2>
    
<h3><%=request.getAttribute("result")%></h3>
<h3><%=request.getAttribute("result2")%></h3>
<h3>표현언어(EL) => ${result}</h3>
<h3>${result2}</h3>
<hr>
