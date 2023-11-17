<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <!-- 라이브러리이름 -->
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> <!-- 라이브러리이름 -->
<h2>JSTL</h2>
<!-- http://localhost:8080/mvc/jstl.do -->

<!-- String id = test 라는 의미 -->
<c:set var="id" value="test" />  
<h3>set변수 => ${id}</h3>

<c:remove var="id" />  <!-- 삭제라는 의미 -->
<h3>set변수 => ${id}</h3>

<c:set var="country" value="korea" />
<c:if test="${country != null}">   <!-- if문을 쓴것 -->
	<h3>국가명 : ${country} </h3>
</c:if>

<!-- 단순비교시 -->
<c:if test="${name == 'hong'}">   <!-- 액션에서 세션을 받앗을때, 겹따옴표 안 홑따옴표 -->
	<h3>이름! : ${name} ${10+'10'}</h3>  <!-- 파신트인트로 변경할필요없이 숫자로 자동바뀜 -->
</c:if>

<!-- else if 가 필요하면 choose문을 쓴다 -->
<c:set var="count" value="55" />
<c:choose>
	<c:when test="${count >= 100}">100이상</c:when>
	<c:when test="${count >= 50}">100이하 50이상</c:when>
	<c:when test="${count >= 0}">50이하 0이상</c:when>
	<c:otherwise>0이하</c:otherwise>
</c:choose>

<br />

<!-- 반복문 for(int i=1; i<=10; i++) -->  
<c:forEach var="i" begin="1" end="10" step="1">
${i}  <!-- foreach 안에서 if를 또 쓸수 있다-->
</c:forEach>

<br />

<!-- 배열, 사이즈 만큼 반복할때는 items를 쓴다 -->
<c:forEach var="a" items="${arr}">
${a}
</c:forEach>

<br />
<!-- dto 호출시 get을 쓸필요가 없다 -->
${d1.num} = ${d1.name}

<br />
${d2.num} = ${d2.name}

<br />
여기서 띄우기 
<br />
<c:forEach var="dto" items="${al}">
${dto.num} = ${dto.name} <br />
</c:forEach>

<br />
<!-- 인쿠르드랑 비슷함 -->
<%-- <c:import url="http://localhost:8080/mvc/main.do" var="aa" />
${aa} --%>

<!-- 문자를 자르는 것, 이때 delims는 어떻게 짜를거냐 -->
<c:forTokens var="i" items="aa,bb,cc,dd,ee" delims=",">
${i}
</c:forTokens>


