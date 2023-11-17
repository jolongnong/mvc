<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <!-- 라이브러리이름 -->
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> <!-- 라이브러리이름 -->


money : <fmt:formatNumber value="${money}" /> <br />
money : <fmt:formatNumber value="${money}" type="currency" currencySymbol="\\"/><br />
money : <fmt:formatNumber value="${money}" type="percent" /><br />

<br />
여기서 띄우기<br />
<br />

pi : <fmt:formatNumber value="${pi}" type="percent" /><br />
pi : <fmt:formatNumber value="${pi}" pattern=".0000000" /><br />
pi : <fmt:formatNumber value="${pi}" pattern=".0" /><br /> 
<!-- 패턴은 소수점어디까지 보여줄건지 -->
<br />
여기서 띄우기<br />
<br />

day: <fmt:formatDate value="${day}"/> <br />
day: <fmt:formatDate value="${day}" type="date"/><br />
day: <fmt:formatDate value="${day}" type="time"/><br />
day: <fmt:formatDate value="${day}" type="both"/><br />
<br />
여기서 띄우기<br />
<br />
day: <fmt:formatDate value="${day}" type="date" dateStyle="full"/><br />
day: <fmt:formatDate value="${day}" type="date" dateStyle="long"/><br />
day: <fmt:formatDate value="${day}" type="date" dateStyle="medium"/><br />
day: <fmt:formatDate value="${day}" type="date" dateStyle="short"/><br />
day: <fmt:formatDate value="${day}" type="date" dateStyle="default"/><br />